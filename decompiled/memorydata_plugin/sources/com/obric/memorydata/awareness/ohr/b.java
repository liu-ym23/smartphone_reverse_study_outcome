package com.obric.memorydata.awareness.ohr;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.InputEvent;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.memorydata.ability.data.h;
import com.obric.memorydata.ability.data.p;
import com.obric.memorydata.ability.f;
import com.obric.memorydata.ability.k;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.screencapture.monitor.d;
import com.obric.memorydata.utils.j;
import com.ss.ugc.clientai.aiservice.ohr.c;
import com.ss.ugc.clientai.aiservice.ohr.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0007H\u0016J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006)"}, d2 = {"Lcom/obric/memorydata/awareness/ohr/OHRPredict;", "Lcom/obric/memorydata/screencapture/monitor/InputMonitorManager$InputEventListener;", "Lcom/ss/ugc/clientai/aiservice/ohr/OHRPredictObserver;", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "<init>", "()V", "MSG_ENABLE_PREDICT", "", "MSG_CHECK_FREE", "INTERVAL_PREDICT", "", "FREE_TIMEOUT", "abilityParams", "Lcom/obric/memorydata/ability/AbilityParams;", "isScreenOff", "", "ohrService", "Lcom/ss/ugc/clientai/aiservice/ohr/OHRService;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "enable", "disable", "disableTemp", "dispatchTouchEvent", "e", "Landroid/view/MotionEvent;", "onInputEvent", "event", "Landroid/view/InputEvent;", "onOHRPredictChanged", "result", "Lcom/ss/ugc/clientai/aiservice/ohr/OHRPredictResult;", "onOHRPredictStatus", "status", "onDataReceive", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b implements k, d.a, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8759a = null;
    private static final f c = null;
    private static boolean d;
    private static final e e = null;
    private static final Handler f = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/awareness/ohr/OHRPredict$handler$1", "Landroid/os/Handler;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends Handler {
        a(Looper r1) {
            super(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            Intrinsics.checkNotNullParameter(r8, NotificationCompat.CATEGORY_MESSAGE);
            int r7 = r8.what;
            if (r7 != 1001) goto L5;
            b.a(b.f8759a);
            return;
        L5:
            if (r7 != 1002) goto L11;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OHREngine", "hand became free", false, 4, null);
            com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "ohr_hand", 3, null, 4, null);
            return;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.awareness.ohr.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/awareness/ohr/OHRPredict$init$config$1", "Lcom/ss/ugc/clientai/aiservice/AIEngineFactory;", "createEngine", "Lcom/ss/ugc/clientai/aiservice/AIEngine;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0449b implements com.ss.ugc.clientai.aiservice.b {
        C0449b() {
        }

        @Override // com.ss.ugc.clientai.aiservice.b
        public com.ss.ugc.clientai.aiservice.a a() {
            return (com.ss.ugc.clientai.aiservice.a) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.awareness.ohr.a(), com.ss.ugc.clientai.aiservice.a.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f8759a = new b();
        c = new f(100000005, MapsKt.mapOf(TuplesKt.to("mode", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL)));
        e = new e();
        f = (Handler) ZeusTransformUtils.preCheckCast(new a(Looper.getMainLooper()), Handler.class, "com.obric.memorydata.plugin");
    }

    private b() {
    }

    public static final /* synthetic */ void a(b r0) {
        r0.c();
    }

    public static final /* synthetic */ void b(b r0) {
        r0.d();
    }

    private final void c() {
        RunLog.INSTANCE.debug("OHREngine", "enable");
        e r0 = e;
        r0.b();
        r0.a((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"));
        d.f12805a.a((d.a) ZeusTransformUtils.preCheckCast(this, d.a.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.ability.d r1 = new com.obric.memorydata.ability.d();
        f r2 = c;
        r1.a(r2, (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin"));
        new com.obric.memorydata.ability.d().query(r2, (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin"));
    }

    private final void d() {
        RunLog.INSTANCE.debug("OHREngine", "disable");
        e r0 = e;
        r0.b((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"));
        r0.c();
        d.f12805a.b((d.a) ZeusTransformUtils.preCheckCast(this, d.a.class, "com.obric.memorydata.plugin"));
        f.removeMessages(1002);
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "ohr_hand", 3, null, 4, null);
        new com.obric.memorydata.ability.d().b(c, (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.ugc.clientai.aiservice.ohr.c
    public void a(int r3) {
        RunLog.INSTANCE.debug("OHREngine", "onOHRPredictStatus " + r3);
    }

    @Override // com.obric.memorydata.screencapture.monitor.d.a
    public void a(InputEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        a((MotionEvent) ZeusTransformUtils.preCheckCast(r3, MotionEvent.class, "com.obric.memorydata.plugin"));
    }

    public final void a(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        e.a(r3);
        Handler r2 = f;
        r2.removeMessages(1002);
        r2.sendEmptyMessageDelayed(1002, 60000);
    }

    @Override // com.obric.memorydata.ability.k
    public void a(h r8) {
        h r7 = (h) ZeusTransformUtils.wrapperContextForParams(r8, h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "data");
        RunLog.INSTANCE.debug("OHREngine", "onDataReceive: " + r7);
        if (ZeusTransformUtils.instanceOf(r7, p.class) == true) goto L5;
    L7:
        d = false;
        return;
    L5:
        if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r7, p.class, "com.obric.memorydata.plugin")).a(), com.tom_roush.pdfbox.pdmodel.a.d.f.g) == false) goto L7;
        d = true;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OHREngine", "screen off, hand became free", false, 4, null);
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "ohr_hand", 3, null, 4, null);
    }

    @Override // com.ss.ugc.clientai.aiservice.ohr.c
    public void a(com.ss.ugc.clientai.aiservice.ohr.d r9) {
        Intrinsics.checkNotNullParameter(r9, "result");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OHREngine", "onOHRPredictChanged " + r9, false, 4, null);
        if (d == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OHREngine", "ignore predict result because screen is off", false, 4, null);
        return;
    L6:
        int r8 = r9.a();
        int r10 = 1;
        if (r8 == 1) goto L9;
        r10 = 2;
    L9:
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "ohr_hand", Integer.valueOf(r10), null, 4, null);
    }

    public final void b() {
        com.ss.ugc.clientai.aiservice.ohr.b r4 = new com.ss.ugc.clientai.aiservice.ohr.b((com.ss.ugc.clientai.aiservice.b) ZeusTransformUtils.preCheckCast(new C0449b(), com.ss.ugc.clientai.aiservice.b.class, "com.obric.memorydata.plugin"));
        e.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
        kotlinx.coroutines.flow.k.b(kotlinx.coroutines.flow.k.f((i) ZeusTransformUtils.preCheckCast(AwarenessManager.INSTANCE.observeAnyListener("ohr_hand"), i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new OHRPredict$init$1(null), Function2.class, "com.obric.memorydata.plugin")), j.a());
    }

    @Override // com.obric.memorydata.ability.k
    public String g_() {
        return k.a.a(this);
    }
}
