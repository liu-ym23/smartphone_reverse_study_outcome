package a2;

import a3.i;
import a3.j;
import a3.k;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import b3.o;
import com.bytedance.ai.bridge.method.info.GetAppInfoMethod;
import com.bytedance.ai.bridge.method.system.permission.RequestPermissionMethod;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.settings.AISDKSettingConfigManager;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.ivy.ivykit.api.plugin.h;
import com.lynx.tasm.behavior.ui.utils.n;
import com.obric.widget.host.runtime.SharedPreferencesWidgetRenderStateStore;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f47a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f48b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f49c;

    public /* synthetic */ a(int r5, Object r10, Object r11) {
        this.f47a = r5;
        this.f49c = r10;
        this.f48b = r11;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Object r5 = this.f49c;
        Object r10 = this.f48b;
        switch(this.f47a) {
            case 0: goto L106;
            case 1: goto L19;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            default: goto L5;
        };
    L12:
        com.ivy.ivykit.api.plugin.c r15 = IIvyAIPackageResourceService.Companion;
        Context r11 = ((Application) r5).getApplicationContext();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.app.Application");
        Application r12 = (Application) r11;
        u0.a r13 = s0.a.f21800c;
        if (r13 == null) goto L16;
        String r14 = r13.f22202m;
        if (r14 == null) goto L16;
    L17:
        h r16 = new h();
        r16.f9495a = true;
        Unit r17 = Unit.INSTANCE;
        com.ivy.ivykit.api.plugin.d r18 = new com.ivy.ivykit.api.plugin.d();
        r18.f9484a = AISDKSettingConfigManager.INSTANCE.getREQUEST_WHITE_LIST().getValue();
        r15.initContainer(r12, r14, (String) r10, r16, r18);
        return r17;
    L16:
        r14 = "";
        goto L17
    L19:
        String r19 = (String) r5;
        j r110 = cl.a.b(r19, i.f84b);
        Function1 r20 = (Function1) r10;
        if (r110.d == false) goto L22;
        r20.invoke(Boolean.FALSE);
        return Unit.INSTANCE;
    L22:
        int r21 = r110.f.ordinal();
        int r22 = 0;
        if (r21 == 0) goto L37;
        if (r21 == 1) goto L34;
        if (r21 == 2) goto L31;
        if (r21 != 3) goto L29;
    L39:
        boolean r23 = false;
    L40:
        if (r23 == false) goto L42;
    L45:
        int r24 = r110.f.ordinal();
        k r25 = i.d;
        o r111 = r110.f86a;
        b3.k r112 = r110.f87b;
        if (r24 == 0) goto L56;
        if (r24 == 1) goto L53;
        if (r24 != 2) goto L62;
        i.g.getClass();
        Intrinsics.checkNotNullParameter(r110, "traceEvent");
        Long r26 = com.bytedance.android.anniex.base.service.f.b(r111, "native_process_event", "fe_receive_event");
        if (r26 == null) goto L62;
        r112.a("total_duration", Long.valueOf(r26.longValue()));
    L62:
        if (r23 == true) goto L64;
    L66:
        JSONObject r27 = new JSONObject();
        int r28 = r110.f.ordinal();
        if (r28 == 0) goto L76;
        if (r28 == 1) goto L75;
        if (r28 == 2) goto L74;
        if (r28 != 3) goto L73;
        Unit r29 = Unit.INSTANCE;
    L77:
        JSONObject r30 = new JSONObject();
        r30.put("trace_id", r19);
        r30.put("is_trace_complete", r22);
        LinkedHashMap r31 = r110.e;
        LinkedHashMap r32 = new LinkedHashMap();
        Iterator r33 = r31.entrySet().iterator();
    L79:
        if (r33.hasNext() == false) goto L83;
        Map.Entry r34 = (Map.Entry) r33.next();
        if (r34.getValue() == null) goto L79;
        r32.put(r34.getKey(), r34.getValue());
        goto L79
    L83:
        Iterator r35 = r32.entrySet().iterator();
    L85:
        if (r35.hasNext() == false) goto L87;
        Map.Entry r36 = (Map.Entry) r35.next();
        r30.put((String) r36.getKey(), r36.getValue());
        goto L85
    L87:
        r27.put("category", r30);
        JSONObject r37 = new JSONObject();
        cl.a.z(r37, r111.f852b);
        cl.a.z(r37, r112.f852b);
        r27.put(LynxMonitorService.KEY_METRIC, r37);
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L90
        Object r39 = Result.m124constructorimpl(r27.getString("eventName"));     // Catch: Throwable -> L90
    L93:
        if (Result.m130isFailureimpl(r39) == false) goto L95;
        r39 = null;
    L95:
        String r40 = (String) r39;
        if (r40 != null) goto L99;
    L102:
        r20.invoke(Boolean.TRUE);
        r110.d = true;
    L104:
        return Unit.INSTANCE;
    L99:
        if (Random.Default.nextInt(10) != 0) goto L102;
        z2.d.d(r40, new n(r27));
    L90:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r39 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L93
    L73:
        throw new NoWhenBranchMatchedException();
    L74:
        r27.put("eventName", "applet_event_to_fe_timeline_full");
        goto L77
    L75:
        r27.put("eventName", "applet_fe_call_native_timeline_full");
        goto L77
    L76:
        r27.put("eventName", "applet_fe_call_fe_timeline_full");
        goto L77
    L64:
        if (r110.g == true) goto L66;
        r22 = 1;
        goto L66
    L53:
        r25.getClass();
        k.a(r110);
        i.f.getClass();
        Intrinsics.checkNotNullParameter(r110, "traceEvent");
        Long r42 = com.bytedance.android.anniex.base.service.f.b(r111, "start_handle_call", "native_process_callback");
        if (r42 == null) goto L62;
        r112.a("native_handle_call_duration", Long.valueOf(r42.longValue()));
        goto L62
    L56:
        r25.getClass();
        k.a(r110);
        i.e.getClass();
        Intrinsics.checkNotNullParameter(r110, "traceEvent");
        Long r43 = com.bytedance.android.anniex.base.service.f.b(r111, "fe_send_callback", "native_receive_callback");
        if (r43 == null) goto L59;
        r112.a("callback_fe_to_native_duration", Long.valueOf(r43.longValue()));
    L59:
        Long r44 = com.bytedance.android.anniex.base.service.f.b(r111, "native_receive_callback", "native_process_callback");
        if (r44 == null) goto L62;
        r112.a("preprocess_callback_duration", Long.valueOf(r44.longValue()));
        goto L62
    L42:
        if (r110.g == true) goto L45;
        r20.invoke(Boolean.FALSE);
        goto L104
    L29:
        throw new NoWhenBranchMatchedException();
    L31:
        if (r110.f88c < 1) goto L39;
    L38:
        r23 = true;
        goto L40
    L34:
        if (r110.f88c < 2) goto L39;
    L37:
        if (r110.f88c < 4) goto L39;
    L5:
        return ym.a.b((String) r5, ((Widget) r10).F);
    L7:
        return ym.a.b((String) r5, ((Applet) r10).F);
    L9:
        return RequestPermissionMethod.b((RequestPermissionMethod) r5, (Activity) r10);
    L11:
        return SharedPreferencesWidgetRenderStateStore.a((SharedPreferencesWidgetRenderStateStore) r5, (String) r10);
    L106:
        return GetAppInfoMethod.e((View) r5, (Function1) r10);
    }
}
