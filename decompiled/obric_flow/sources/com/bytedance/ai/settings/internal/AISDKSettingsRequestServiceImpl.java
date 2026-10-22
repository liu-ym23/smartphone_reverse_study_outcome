package com.bytedance.ai.settings.internal;

import android.content.Context;
import android.os.Process;
import com.bytedance.ai.model.p;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.f;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.keva.Keva;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.json.JSONObject;
import qg.a;
import qg.b;
import s0.c;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/settings/internal/AISDKSettingsRequestServiceImpl;", "Lqg/a;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAISDKSettingsRequestServiceImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AISDKSettingsRequestServiceImpl.kt\ncom/bytedance/ai/settings/internal/AISDKSettingsRequestServiceImpl\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,145:1\n216#2,2:146\n*S KotlinDebug\n*F\n+ 1 AISDKSettingsRequestServiceImpl.kt\ncom/bytedance/ai/settings/internal/AISDKSettingsRequestServiceImpl\n*L\n69#1:146,2\n*E\n"})
public final class AISDKSettingsRequestServiceImpl implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Keva f2773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2774c;

    public AISDKSettingsRequestServiceImpl() {
        this.f2772a = c.a();
        this.f2773b = Keva.getRepo(AISDKSettingsRequestServiceImpl.class.getName());
    }

    public static final void d() {
        Intrinsics.checkNotNullParameter("SettingsRequestServiceImpl", "tag");
        d r5 = com.bytedance.ai.utils.c.f2846a;
        if (r5 == null) goto L5;
        r5.w("SettingsRequestServiceImpl", "retry fetching settings");
    L5:
        pg.a.b("flow_ai_sdk").d();
    }

    @Override // qg.a
    public final b a() {
        b r10 = new b();
    L7:
        th = move-exception;
        c();
        Intrinsics.checkNotNullParameter("SettingsRequestServiceImpl", "tag");
        d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L75;
        r12.w("SettingsRequestServiceImpl", "fetch settings failed", th);
    L75:
        return r10;
    L4:
        if (f.c(this.f2772a) == true) goto L9;
        c();     // Catch: Throwable -> L7
        return r10;
    L9:
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L7
        r11.append("https://is.snssdk.com/service/settings/v3/");     // Catch: Throwable -> L7
        r11.append("?caller_name=flow_ai_sdk");     // Catch: Throwable -> L7
        r11.append("&ai_sdk_version_name=0.90.0-rc.37-miniapp");     // Catch: Throwable -> L7
        r11.append("&ai_sdk_version_code=900087");     // Catch: Throwable -> L7
        r11.append("&is_32bit=" + (!Process.is64Bit() ? 1 : 0));     // Catch: Throwable -> L7
        u0.a r5 = s0.a.f21800c;     // Catch: Throwable -> L7
        String r13 = null;
        if (r5 != null) goto L12;
    L23:
        t0.b r14 = p.f2294c;     // Catch: Throwable -> L7
        if (r14 == null) goto L31;
        Map r15 = r14.getCommonParameters();     // Catch: Throwable -> L7
        if (r15 == null) goto L31;
        Iterator r16 = r15.entrySet().iterator();     // Catch: Throwable -> L7
    L29:
        if (r16.hasNext() == false) goto L31;
        Map.Entry r17 = (Map.Entry) r16.next();     // Catch: Throwable -> L7
        r11.append(Typography.amp + ((String) r17.getKey()) + '=' + r17.getValue());     // Catch: Throwable -> L7
    L31:
        String r18 = r11.toString();     // Catch: Throwable -> L7
        if (r18.length() > 0) goto L34;
    L38:
        String r19 = a(r18);     // Catch: Throwable -> L7
        if (r19 != null) goto L41;
    L68:
        c();     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter("SettingsRequestServiceImpl", "tag");     // Catch: Throwable -> L7
        d r20 = com.bytedance.ai.utils.c.f2846a;     // Catch: Throwable -> L7
        if (r20 == null) goto L75;
        r20.w("SettingsRequestServiceImpl", "settings response is null");     // Catch: Throwable -> L7
        return r10;
    L41:
        if (r19.length() == 0) goto L68;
        JSONObject r21 = new JSONObject(r19);     // Catch: Throwable -> L7
        if (Intrinsics.areEqual("success", r21.optString("message")) == true) goto L49;
        c();     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter("SettingsRequestServiceImpl", "tag");     // Catch: Throwable -> L7
        d r22 = com.bytedance.ai.utils.c.f2846a;     // Catch: Throwable -> L7
        if (r22 == null) goto L75;
        r22.w("SettingsRequestServiceImpl", "settings response is not success");     // Catch: Throwable -> L7
        return r10;
    L49:
        JSONObject r23 = r21.optJSONObject("data");     // Catch: Throwable -> L7
        if (r23 == null) goto L52;
        JSONObject r24 = r23.optJSONObject("settings");     // Catch: Throwable -> L7
    L53:
        if (r24 == null) goto L55;
        JSONObject r25 = r24.optJSONObject("sdk_key_flow_ai_sdk");     // Catch: Throwable -> L7
    L56:
        if (r25 == null) goto L58;
        qg.c r26 = new qg.c(UUID.randomUUID().toString(), r25, null);     // Catch: Throwable -> L7
    L59:
        b r27 = new b();     // Catch: Throwable -> L7
        r27.f21509b = r26;     // Catch: Throwable -> L7
        if (r23 == null) goto L62;
        r23.optJSONObject("vid_info");     // Catch: Throwable -> L7
    L62:
        if (r23 == null) goto L64;
        r13 = r23.optString("ctx_infos");     // Catch: Throwable -> L7
    L64:
        r27.f21510c = r13;     // Catch: Throwable -> L7
        r27.f21508a = true;     // Catch: Throwable -> L7
        String r28 = "settings response: " + r23;     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter("SettingsRequestServiceImpl", "tag");     // Catch: Throwable -> L7
        d r29 = com.bytedance.ai.utils.c.f2846a;     // Catch: Throwable -> L7
        if (r29 == null) goto L67;
        r29.i("SettingsRequestServiceImpl", r28);     // Catch: Throwable -> L7
    L67:
        return r27;
    L58:
        r26 = new qg.c(UUID.randomUUID().toString(), r24, null);     // Catch: Throwable -> L7
        goto L59
    L55:
        r25 = null;
        goto L56
    L52:
        r24 = null;
        goto L53
    L34:
        if (StringsKt.P(r18, IIvyAIPackageResourceService.SCHEMA) == true) goto L38;
        if (StringsKt.P(r18, "http") == false) goto L38;
        r18 = new Regex("http").replaceFirst(r18, IIvyAIPackageResourceService.SCHEMA);     // Catch: Throwable -> L7
        goto L38
    L12:
        if (r5.f22205p != true) goto L23;
        r11.append("&use_ppe=1");     // Catch: Throwable -> L7
        u0.a r30 = s0.a.f21800c;     // Catch: Throwable -> L7
        if (r30 == null) goto L16;
        String r31 = r30.f22206q;     // Catch: Throwable -> L7
    L17:
        if (r31 == null) goto L23;
        StringBuilder r32 = new StringBuilder("&http_env=");     // Catch: Throwable -> L7
        u0.a r33 = s0.a.f21800c;     // Catch: Throwable -> L7
        if (r33 == null) goto L21;
        String r34 = r33.f22206q;     // Catch: Throwable -> L7
    L22:
        r32.append(r34);     // Catch: Throwable -> L7
        r11.append(r32.toString());     // Catch: Throwable -> L7
        goto L23
    L21:
        r34 = null;
        goto L22
    L16:
        r31 = null;
        goto L17
    }

    public final boolean b() {
        boolean r5 = this.f2773b.getBoolean("first_request", true);
        if (r5 == false) goto L5;
        this.f2773b.storeBoolean("first_request", false);
    L5:
        return r5;
    }

    public final void c() {
        int r5 = this.f2774c + 1;
        this.f2774c = r5;
        if (r5 > 3) goto L6;
        f3.a r10 = new f3.a(0);
        SoftReference r11 = c1.b.f1102a;
        Intrinsics.checkNotNullParameter(r10, "runnable");
        c1.b.c().postDelayed(r10, WsConstants.EXIT_DELAY_TIME);
        return;
    }

    public final String a(String r5) {
        boolean r10 = b();     // Catch: Throwable -> L5
        MapsKt.mapOf(new Pair[]{TuplesKt.to("Content-Type", "application/json"), TuplesKt.to("X-Tt-Request-Tag", "t=0;n=" + (r10 ? 1 : 0))});     // Catch: Throwable -> L5
        throw new CommonHttpException(0, "not implemented");     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }
}
