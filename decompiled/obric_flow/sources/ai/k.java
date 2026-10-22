package ai;

import android.os.Build;
import com.bytedance.android.monitorV2.settings.ISettingsApi;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements qg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f239a;

    @Override // qg.a
    public qg.b a() {
        StringBuilder r5 = new StringBuilder("https://is.snssdk.com/service/settings/v3/");
        r5.append("?aid=" + com.bytedance.android.monitorV2.h.e().a().getInitConfig().f98a);
        com.bytedance.android.monitorV2.h.e().a().getInitConfig().getClass();
        r5.append("&iid=null");
        r5.append("&device_id=" + com.bytedance.android.monitorV2.h.e().a().getInitConfig().e);
        r5.append("&device_brand=" + Build.BRAND);
        r5.append("&device_type=" + Build.MODEL);
        r5.append("&channel=" + com.bytedance.android.monitorV2.h.e().a().getInitConfig().f);
        r5.append("&device_platform=android");
        r5.append("&version_code=" + com.bytedance.android.monitorV2.h.e().a().getInitConfig().g);
        r5.append("&update_version_code=" + com.bytedance.android.monitorV2.h.e().a().getInitConfig().f101h);
        r5.append("&caller_name=hybrid_monitor");
        r5.append("&ctx_infos=" + this.f239a);
        r5.append("&os_api=" + Build.VERSION.SDK_INT);
        r5.append("&os_version=" + Build.VERSION.RELEASE);
        r5.append("&settings_time=" + com.bytedance.android.monitorV2.constant.a.a("monitor_app_settings_time"));
        ISettingsApi r10 = (ISettingsApi) com.bytedance.ttnet.utils.d.c(ISettingsApi.class, "https://is.snssdk.com/service/settings/v3/");
        d5.b.f("MonitorRequestServiceImpl", "MonitorRequestServiceImpl:startRequest:url = " + r5);
        c r11 = r10.doPost(r5.toString(), CollectionsKt.listOf(new bi.c[]{new bi.c("Content-Type", "application/json"), new bi.c("mimeType", "application/json")}), new LinkedHashMap());
        qg.b r12 = new qg.b();
        r12.f21508a = false;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L17
        q0 r14 = r11.execute();     // Catch: Throwable -> L17
        bi.e r15 = r14.f290a;     // Catch: Throwable -> L17
        Object r16 = r14.f291b;
        if (r15.w() == false) goto L43;
        CharSequence r17 = (CharSequence) r16;     // Catch: Throwable -> L17
        if (r17 == null) goto L43;
        if (r17.length() == 0) goto L43;
        com.bytedance.android.monitorV2.settings.g r18 = (com.bytedance.android.monitorV2.settings.g) new Gson().fromJson((String) r16, com.bytedance.android.monitorV2.settings.g.class);     // Catch: Throwable -> L17
        d5.b.f("MonitorRequestServiceImpl", "MonitorRequestServiceImpl:response:message = " + r18.b());     // Catch: Throwable -> L17
        if (Intrinsics.areEqual(r18.b(), "success") == false) goto L15;
    L19:
        com.bytedance.android.monitorV2.settings.a r19 = r18.a();     // Catch: Throwable -> L17
        if (r19 == null) goto L25;
        String r20 = r19.b();     // Catch: Throwable -> L17
        if (r20 == null) goto L25;
        JSONObject r21 = new JSONObject(r20);     // Catch: Throwable -> L17
    L26:
        String r22 = null;
        r12.f21509b = new qg.c(UUID.randomUUID().toString(), r21, null);     // Catch: Throwable -> L17
        com.bytedance.android.monitorV2.settings.a r23 = r18.a();     // Catch: Throwable -> L17
        if (r23 == null) goto L31;
        String r24 = r23.d();     // Catch: Throwable -> L17
        if (r24 == null) goto L31;
        new JSONObject(r24);     // Catch: Throwable -> L17
    L31:
        com.bytedance.android.monitorV2.settings.a r25 = r18.a();     // Catch: Throwable -> L17
        if (r25 == null) goto L34;
        r22 = r25.a();     // Catch: Throwable -> L17
    L34:
        r12.f21510c = r22;     // Catch: Throwable -> L17
        r12.f21508a = true;     // Catch: Throwable -> L17
        com.bytedance.android.monitorV2.settings.a r26 = r18.a();     // Catch: Throwable -> L17
        if (r26 == null) goto L42;
        Long r27 = r26.c();     // Catch: Throwable -> L17
        if (r27 == null) goto L39;
        com.bytedance.android.monitorV2.constant.a.c("monitor_app_settings_time", r27.longValue());     // Catch: Throwable -> L17
    L39:
        String r28 = r26.b();     // Catch: Throwable -> L17
        if (r28 == null) goto L42;
        com.bytedance.android.monitorV2.constant.a.d("monitor_app_settings_response", r28);     // Catch: Throwable -> L17
    L42:
        this.f239a = r12.f21510c;     // Catch: Throwable -> L17
    L25:
        r21 = new JSONObject(com.bytedance.android.monitorV2.constant.a.b("monitor_app_settings_response", "{}"));     // Catch: Throwable -> L17
        goto L26
    L15:
        if (Intrinsics.areEqual(r18.b(), "demotion") == true) goto L19;
    L43:
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
        return r12;
    L17:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        return r12;
    }
}
