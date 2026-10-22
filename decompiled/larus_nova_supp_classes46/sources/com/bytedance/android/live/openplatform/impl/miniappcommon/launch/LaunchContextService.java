package com.bytedance.android.live.openplatform.impl.miniappcommon.launch;

import am2.n;
import am2.x;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.openplatform.impl.base.context.ContextServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.utils.m;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdk.config.wc1;
import com.bytedance.android.livesdk.log.l0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.r2;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import ko0.b;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ContextServiceImpl(audienceService = "com.bytedance.android.live.openplatform.impl.miniappaudience.launch.AudienceLaunchContextService", liveAnchorService = "com.bytedance.android.live.openplatform.impl.miniappanchor.launch.LiveAnchorLaunchContextService", previewAnchorService = "com.bytedance.android.live.openplatform.impl.miniappanchor.launch.PreviewAnchorLaunchContextService")
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J*\u0010\f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0004¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/launch/LaunchContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "", "", "origin", "getMergedAdParams", "schema", "Lko0/b;", "launchParams", "Lkotlin/Function0;", "", "onSuccess", "openMiniApp", "getLaunchSchema", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "Companion", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class LaunchContextService extends OpenPlatformContextService {
    public static final a Companion = null;
    public static final String TAG = "LaunchContextService";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public LaunchContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    private final Map<String, String> getMergedAdParams(Map<String, String> r9) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(r9);
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put("aid", n.f().a());
        r10.put("cid", n.f().c());
        String r1 = n.f().d();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(new JSONObject(r1));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r5) == false) goto L10;
        r5 = null;
    L10:
        JSONObject r6 = (JSONObject) r5;
        Object r7 = "";
        if (r6 == null) goto L14;
        String r8 = r6.optString("clickid");
        if (r8 == null) goto L14;
    L15:
        r10.put("clickid", r8);
        r10.put("log_extra", r1);
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator r11 = r10.entrySet().iterator();
    L17:
        if (r11.hasNext() == false) goto L21;
        Map.Entry r12 = (Map.Entry) r11.next();
        if (r2.a((String) r12.getValue()) == false) goto L17;
        r2.put(r12.getKey(), r12.getValue());
        goto L17
    L21:
        r0.putAll(r2);
        if (r0.isEmpty() == true) goto L24;
        LinkedHashMap r13 = new LinkedHashMap();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L28
        Object r14 = Result.constructor-impl(m.g(r0).toString());     // Catch: Throwable -> L28
    L31:
        if (Result.isFailure-impl(r14) == true) goto L34;
        r7 = r14;
    L34:
        r13.put("ad_params", r7);
        Iterator r15 = r0.entrySet().iterator();
    L36:
        if (r15.hasNext() == false) goto L53;
        Map.Entry r16 = (Map.Entry) r15.next();
        String r17 = (String) r16.getKey();
        int r18 = r17.hashCode();
        if (r18 != 96572) goto L40;
        if (r17.equals("aid") == false) goto L36;
        r13.put("aid", r16.getValue());
        r13.put("adid", r16.getValue());
        goto L36
    L40:
        if (r18 != 98494) goto L42;
        if (r17.equals("cid") == false) goto L36;
        r13.put("cid", r16.getValue());
        r13.put("creativeid", r16.getValue());
        goto L36
    L42:
        if (r18 != 860524707) goto L36;
        if (r17.equals("clickid") == false) goto L36;
        r13.put("clickid", r16.getValue());
        goto L36
    L53:
        return r13;
    L28:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L24:
        return MapsKt.emptyMap();
    L14:
        r8 = "";
    L5:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final String getLaunchSchema(String r9, b r10) {
        Intrinsics.checkNotNullParameter(r9, "schema");
        Intrinsics.checkNotNullParameter(r10, "launchParams");
        SchemaInfo.s.getClass();
        SchemaInfo r0 = SchemaInfo.b.b(r9);
        SchemaInfo.a r1 = new SchemaInfo.a(r9);
        r1.f(SchemaInfo.LaunchMode.HOST_STACK);
        String r11 = r10.a;
        Intrinsics.checkNotNullParameter(r11, "scene");
        r1.a.put("scene", r11);
        String r12 = r10.b;
        Intrinsics.checkNotNullParameter(r12, "launchFrom");
        r1.b("launch_from", r12);
        String r13 = r10.c;
        Intrinsics.checkNotNullParameter(r13, "location");
        r1.b("location", r13);
        r1.b("entrance_form", r10.d);
        r1.b("enter_from_merge", r10.e);
        r1.b("enter_position", r10.f);
        r1.b("room_id", String.valueOf(getOpenPlatformContext().getRoomId()));
        String r14 = com.bytedance.android.live.openplatform.impl.base.utils.n.a();
        boolean r3 = false;
        if (r14.length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        Object r5 = null;
        if (r2 == true) goto L10;
        r14 = null;
    L10:
        if (r14 != null) goto L12;
        r14 = "natural";
    L12:
        r1.b("is_ad_channel", r14);
        r1.b("live_enter_method", l0.a("enter_method", u.l().c(x.class)));
        r1.b("live_action_type", l0.a("action_type", u.l().c(x.class)));
        Iterator<Map.Entry<String, String>> r15 = r10.g.entrySet().iterator();
    L14:
        if (r15.hasNext() == false) goto L16;
        Map.Entry<String, String> r4 = r15.next();
        r1.b(r4.getKey(), r4.getValue());
        goto L14
    L16:
        int r16 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
        if (r16 != 0) goto L19;
        r1.b("live_category", "single");
    L27:
        if (((IInteractService) k.n(IInteractService.class)).isLinkCasting() == false) goto L29;
        r1.b("if_mp_live_projection", "1");
    L29:
        String r17 = r10.h;
        if (StringsKt.isBlank(r17) == false) goto L34;
        if (r0 == null) goto L33;
        r17 = r0.f();
        goto L34
    L33:
        r17 = null;
    L34:
        if (r17 == null) goto L64;
        if (r17.length() <= 0) goto L38;
        r3 = true;
    L38:
        if (r3 == true) goto L41;
        r17 = null;
    L41:
        if (r17 == null) goto L64;
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("live_room_id", String.valueOf(getOpenPlatformContext().getRoomId()));
        r6.putAll(r10.i);
        if (((wc1) de0.a.getValue()).o() == true) goto L76;
    L58:
        if (r0 == null) goto L62;
        Map r7 = (Map) r0.j.getValue();
        if (r7 == null) goto L62;
        r6.putAll(r7);
    L62:
        r1.h(r17, r6);
        goto L64
    L76:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L52
        Object r18 = r6.get("ad_params");     // Catch: Throwable -> L52
        if (r2.a((String) r18) == false) goto L47;
        r5 = r18;
    L47:
        String r19 = (String) r5;     // Catch: Throwable -> L52
        if (r19 != null) goto L50;
        r19 = "{}";
    L50:
        Object r20 = Result.constructor-impl(m.h(new JSONObject(r19)));     // Catch: Throwable -> L52
    L54:
        LinkedHashMap r21 = new LinkedHashMap();
        if (Result.isFailure-impl(r20) == false) goto L57;
        r20 = r21;
    L57:
        r6.putAll(getMergedAdParams((Map) r20));
    L52:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
    L64:
        if (r10.l == false) goto L66;
        r1.e("forceColdBoot", "1");
    L66:
        Iterator<Map.Entry<String, String>> r23 = r10.j.entrySet().iterator();
    L68:
        if (r23.hasNext() == false) goto L70;
        Map.Entry<String, String> r110 = r23.next();
        r1.e(r110.getKey(), r110.getValue());
        goto L68
    L70:
        SchemaInfo r24 = r1.c();
        if (r24 == null) goto L74;
        String r25 = r24.h();
        if (r25 == null) goto L74;
        return r25;
    L74:
        return "";
    L19:
        if (r16 != 8) goto L21;
        r1.b("live_category", "1v6");
        goto L27
    L21:
        if (r16 != 12) goto L27;
        r1.b("live_category", "party");
        goto L27
    L5:
        r2 = false;
        goto L6
    }

    public void openMiniApp(String r3, b r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "schema");
        Intrinsics.checkNotNullParameter(r4, "launchParams");
        ((CommonLaunchContextService) getOpenPlatformContext().getService(CommonLaunchContextService.class)).openMicroApp(getLaunchSchema(r3, r4), null, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void openMiniApp$default(LaunchContextService r0, String r1, b r2, Function0 r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        r0.openMiniApp(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openMiniApp");
    }
}
