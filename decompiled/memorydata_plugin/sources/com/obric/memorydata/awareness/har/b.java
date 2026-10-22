package com.obric.memorydata.awareness.har;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.userAware.SensorCollectManager;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.al;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J1\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u001bJ5\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\r2\u0014\u0010\u001f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00100 H\u0002¢\u0006\u0002\u0010!J\u000f\u0010\"\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010#J\u0017\u0010$\u001a\u00020\u00102\b\u0010%\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010&J\u0017\u0010'\u001a\u00020\u00102\b\u0010%\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010&J\u0017\u0010(\u001a\u00020\u00102\b\u0010%\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010&J\u0017\u0010)\u001a\u00020\u00102\b\u0010%\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010&J\u0006\u0010*\u001a\u00020\u0010J\u0006\u0010+\u001a\u00020\u001dJ\u0006\u0010,\u001a\u00020\u001dR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/memorydata/awareness/har/HarSensorHandler;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "sensorManager", "Landroid/hardware/SensorManager;", "oemHar", "Landroid/hardware/Sensor;", "elevatorSensor", "escalatorAndStairSensor", "stateBeforeElevator", "", "Ljava/lang/Integer;", "hasSavedStateBeforeElevator", "", "stateBeforeStairOrEscalator", "hasSavedStateBeforeStairOrEscalator", "sensorListener", "Landroid/hardware/SensorEventListener;", "saveStateBeforeTransitIfNeeded", MemoryInfoSectionEditActivity.KIND_SCENE, "", "hasSavedState", "currentSavedState", "transitState", "(Ljava/lang/String;ZLjava/lang/Integer;I)Ljava/lang/Integer;", "restoreStateBeforeTransitIfCurrentMatches", "", "stateBeforeTransit", "currentStateMatcher", "Lkotlin/Function1;", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "getCurrentHarActivityState", "()Ljava/lang/Integer;", "isElevatorHarState", "state", "(Ljava/lang/Integer;)Z", "isStairHarState", "isEscalatorHarState", "isStairOrEscalatorHarState", "isSupport", CommonConsts.APM_INNER_EVENT_COST_START, "stop", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8614a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SensorManager f8615b;
    private final Sensor c;
    private final Sensor d;
    private final Sensor e;
    private Integer f;
    private boolean g;
    private Integer h;
    private boolean i;
    private SensorEventListener j;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/memorydata/awareness/har/HarSensorHandler$Companion;", "", "<init>", "()V", "TAG", "", "OEM_HAR_SENSOR_TYPE", "", "SENSOR_TYPE_ELEVATOR", "SENSOR_TYPE_ESCALATOR_STAIR", "ELEVATOR_IN", "ELEVATOR_OUT", "STAIR_UP", "STAIR_DOWN", "ESCALATOR_UP", "ESCALATOR_DOWN", "STAIR_ESCALATOR_OUT", "SNS_OEM_HAR_STATUS_TYPE_STATIONARY", "SNS_OEM_HAR_STATUS_TYPE_RUNNING", "SNS_OEM_HAR_STATUS_TYPE_WALKING", "SNS_OEM_HAR_STATUS_TYPE_ACCELERATE", "SNS_OEM_HAR_STATUS_TYPE_OTHER", "SNS_OEM_HAR_STATUS_WAKEUP_LEVEL2_MODEL", "SNS_OEM_HAR_STATUS_TYPE_AIR_PRESSURE", "SNS_OEM_HAR_STATUS_TYPE_UNKNOWN", "SNS_OEM_HAR_LEVEL2_STATE_STATIONARY", "SNS_OEM_HAR_LEVEL2_STATE_RUNNING", "SNS_OEM_HAR_LEVEL2_STATE_WALKING", "SNS_OEM_HAR_LEVEL2_STATE_OTHER", "SNS_OEM_HAR_LEVEL2_STATE_SUBWAY", "SNS_OEM_HAR_LEVEL2_STATE_CYCLING", "SNS_OEM_HAR_LEVEL2_STATE_ELECTRIC_BIKE", "SNS_OEM_HAR_LEVEL2_STATE_CAR", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.awareness.har.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000Q\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0004R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"com/obric/memorydata/awareness/har/HarSensorHandler$sensorListener$1", "Landroid/hardware/SensorEventListener;", "baseDeltaMs", "", "Ljava/lang/Long;", "lastUnknownTsMs", "cacheBuffer", "", "Lcom/obric/memorydata/awareness/har/HarEvent;", "airPressureBuffer", "", "cacheFlushHandler", "Landroid/os/Handler;", "cacheFlushScheduled", "", "cacheFlushWindowMs", "cacheFlushRunnable", "Ljava/lang/Runnable;", "onSensorChanged", "", "event", "Landroid/hardware/SensorEvent;", "onAccuracyChanged", "sensor", "Landroid/hardware/Sensor;", LocationMonitorConst.ACCURACY, "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0434b implements SensorEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f8616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Long f8617b;
        private Long c;
        private final List<HarEvent> d;
        private final List<Float> e;
        private final Handler f;
        private boolean g;
        private final long h;
        private final Runnable i;

        C0434b(b r3) {
            this.f8616a = r3;
            this.d = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            this.e = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            this.f = new Handler(Looper.getMainLooper());
            this.h = 100;
            this.i = new $$Lambda$b$b$U_Ps6GQce_FqBN83JYTFxmbnds(this);
        }

        private static final void a(C0434b r9) {
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r9.d, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L5;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarSensorHandler", "flush cacheBuffer size: " + r9.d.size(), false, 4, null);
            HarPredict.a(HarPredict.f8604a.a(), CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r9.d, Iterable.class, "com.obric.memorydata.plugin")), null, true, 2, null);
            r9.d.clear();
        L5:
            r9.g = false;
        }

        /* JADX INFO: renamed from: lambda$U_Ps6GQ-ce_FqBN83JYTFxmbnds, reason: not valid java name */
        public static /* synthetic */ void m503lambda$U_Ps6GQce_FqBN83JYTFxmbnds(C0434b r0) {
            a(r0);
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor r1, int r2) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent r21) {
            Intrinsics.checkNotNullParameter(r21, "event");
            int r2 = r21.sensor.getType();
            if (r2 != 33171014) goto L12;
            int r1 = (int) r21.values[0];
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarSensorHandler", "onElevatorSensorChanged, state: " + r1, false, 4, null);
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L58;
            i.a(j.a(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new HarSensorHandler$sensorListener$1$onSensorChanged$2(this.f8616a, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            return;
        L58:
            return;
        L9:
            i.a(j.a(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new HarSensorHandler$sensorListener$1$onSensorChanged$1(this.f8616a, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            return;
        L12:
            if (r2 != 33171019) goto L28;
            int r3 = (int) r21.values[0];
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarSensorHandler", "onEscalatorAndStairSensorChanged, state: " + r3, false, 4, null);
            if (r3 == 0) goto L24;
            if (r3 == 1) goto L23;
            if (r3 == 2) goto L23;
            if (r3 != 3) goto L20;
        L22:
            al r8 = j.a();
            CoroutineContext r9 = null;
            CoroutineStart r10 = null;
            Object r0 = ZeusTransformUtils.preCheckCast(new HarSensorHandler$sensorListener$1$onSensorChanged$4(r3, this.f8616a, null), Function2.class, "com.obric.memorydata.plugin");
        L25:
            i.a(r8, r9, r10, (Function2) r0, 3, null);
            return;
        L20:
            if (r3 == 4) goto L22;
            return;
        L23:
            i.a(j.a(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new HarSensorHandler$sensorListener$1$onSensorChanged$3(r3, this.f8616a, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            return;
        L24:
            r8 = j.a();
            r9 = null;
            r10 = null;
            r0 = ZeusTransformUtils.preCheckCast(new HarSensorHandler$sensorListener$1$onSensorChanged$5(this.f8616a, null), Function2.class, "com.obric.memorydata.plugin");
            goto L25
        L28:
            if (r2 == 33171015) goto L30;
            return;
        L30:
            int r4 = (int) r21.values[0];
            long r11 = (long) r21.values[1];
            RunLog.INSTANCE.debug("HarSensorHandler", "onSensorChanged, state: " + r4 + ", sensorTimestampMs: " + r11);
            long r12 = System.currentTimeMillis();
            if (r4 != 98) goto L37;
            if (r21.values.length <= 2) goto L61;
            this.e.add(Float.valueOf(r21.values[2]));
            return;
        L61:
            return;
        L37:
            if (r4 != 99) goto L40;
            this.f8617b = Long.valueOf(r12 - r11);
            this.c = Long.valueOf(r11);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarSensorHandler", "onSensorChanged: 99 event, baseDeltaMs=" + this.f8617b, false, 4, null);
            return;
        L40:
            Long r5 = this.f8617b;
            if (r5 == null) goto L43;
            long r6 = r5.longValue();
        L44:
            HarEvent r7 = new HarEvent(r4, r6 + r11);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarSensorHandler", "onSensorChanged: " + r7, false, 4, null);
            Long r13 = this.c;
            if (r13 == null) goto L53;
            Intrinsics.checkNotNull(r13);
            if (r11 >= r13.longValue()) goto L53;
            this.d.add(r7);
            if (this.g == true) goto L62;
            this.g = true;
            this.f.postDelayed(this.i, this.h);
            return;
        L62:
            return;
        L53:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(this.d, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L55;
            this.f.removeCallbacks(this.i);
            this.g = false;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarSensorHandler", "flush current cacheBuffer size: " + this.d.size(), false, 4, null);
            HarPredict.a(HarPredict.f8604a.a(), CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.d, Iterable.class, "com.obric.memorydata.plugin")), null, true, 2, null);
            this.d.clear();
        L55:
            HarPredict.f8604a.a().a(CollectionsKt.listOf(r7), CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin")), false);
            this.e.clear();
            return;
        L43:
            r6 = r12 - r11;
            this.f8617b = Long.valueOf(r6);
            goto L44
        }
    }

    static {
        f8614a = new a(null);
    }

    public b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Object r6 = r5.getSystemService("sensor");
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.hardware.SensorManager");
        SensorManager r7 = (SensorManager) ZeusTransformUtils.preCheckCast(r6, SensorManager.class, "com.obric.memorydata.plugin");
        this.f8615b = r7;
        this.c = r7.getDefaultSensor(33171015, true);
        this.d = r7.getDefaultSensor(SensorCollectManager.SENSOR_TYPE_ELEVATOR, true);
        this.e = r7.getDefaultSensor(SensorCollectManager.SENSOR_TYPE_UP_DOWN, true);
        this.j = (SensorEventListener) ZeusTransformUtils.preCheckCast(new C0434b(this), SensorEventListener.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ Integer a(b r0, String r1, boolean r2, Integer r3, int r4) {
        return r0.a(r1, r2, r3, r4);
    }

    private final Integer a(String r9, boolean r10, Integer r11, int r12) {
        if (r10 == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarSensorHandler", "keep state before " + r9 + ": " + com.obric.memorydata.sdk.awareness.b.f12819a.a(r11) + ", set state: " + com.obric.memorydata.sdk.awareness.b.f12819a.a(Integer.valueOf(r12)), false, 4, null);
        return r11;
    L6:
        Integer r8 = d();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarSensorHandler", "save state before " + r9 + ": " + com.obric.memorydata.sdk.awareness.b.f12819a.a(r8) + ", set state: " + com.obric.memorydata.sdk.awareness.b.f12819a.a(Integer.valueOf(r12)), false, 4, null);
        return r8;
    }

    public static final /* synthetic */ void a(b r0, Integer r1) {
        r0.f = r1;
    }

    public static final /* synthetic */ void a(b r2, String r3, Integer r4, Function1 r5) {
        r2.a(r3, r4, (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(b r0, boolean r1) {
        r0.g = r1;
    }

    private final void a(String r7, Integer r8, Function1<? super Integer, Boolean> r9) {
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Integer r6 = d();
        if (((Boolean) ZeusTransformUtils.preCheckCast(r10.invoke(r6), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarSensorHandler", "revert from " + r7 + " to state: " + com.obric.memorydata.sdk.awareness.b.f12819a.a(r8), false, 4, null);
        FeatureManager.INSTANCE.setFeature("har_activity_state", r8, null);
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarSensorHandler", "skip revert from " + r7 + ", current state: " + com.obric.memorydata.sdk.awareness.b.f12819a.a(r6) + ", state before " + r7 + ": " + com.obric.memorydata.sdk.awareness.b.f12819a.a(r8), false, 4, null);
    }

    public static final /* synthetic */ boolean a(b r0) {
        return r0.g;
    }

    private final boolean a(Integer r1) {
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.intValue() != 201) goto L7;
        return true;
    }

    public static final /* synthetic */ Integer b(b r0) {
        return r0.f;
    }

    public static final /* synthetic */ void b(b r0, boolean r1) {
        r0.i = r1;
    }

    public static final /* synthetic */ boolean b(b r0, Integer r1) {
        return r0.a(r1);
    }

    private final boolean b(Integer r2) {
        if (r2 == null) goto L7;
        if (r2.intValue() != 211) goto L7;
    L13:
        return true;
    L7:
        if (r2 != null) goto L10;
    L12:
        return false;
    L10:
        if (r2.intValue() != 212) goto L12;
        goto L12
    }

    public static final /* synthetic */ void c(b r0, Integer r1) {
        r0.h = r1;
    }

    public static final /* synthetic */ boolean c(b r0) {
        return r0.i;
    }

    private final boolean c(Integer r2) {
        if (r2 == null) goto L7;
        if (r2.intValue() != 213) goto L7;
    L13:
        return true;
    L7:
        if (r2 != null) goto L10;
    L12:
        return false;
    L10:
        if (r2.intValue() != 214) goto L12;
        goto L12
    }

    private final Integer d() {
        Object r2 = FeatureManager.INSTANCE.getFeature("har_activity_state");
        if (ZeusTransformUtils.instanceOf(r2, Integer.class) == true) goto L7;
        return null;
    L7:
        return (Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ Integer d(b r0) {
        return r0.h;
    }

    public static final /* synthetic */ boolean d(b r0, Integer r1) {
        return r0.d(r1);
    }

    private final boolean d(Integer r2) {
        if (b(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (c(r2) == true) goto L8;
        return false;
    }

    public final boolean a() {
        if (this.c == null) goto L6;
        return true;
    L6:
        if (DeviceInfoState.INSTANCE.isObricOsDevice() == true) goto L8;
        return false;
    L8:
        if (this.d == null) goto L10;
    L11:
        return true;
    L10:
        if (this.e != null) goto L11;
        return false;
    }

    public final void b() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarSensorHandler", CommonConsts.APM_INNER_EVENT_COST_START, false, 4, null);
        Sensor r0 = this.c;
        if (r0 == null) goto L6;
        this.f8615b.registerListener(this.j, r0, 3);
    L6:
        if (DeviceInfoState.INSTANCE.isObricOsDevice() == false) goto L14;
        Sensor r1 = this.d;
        if (r1 == null) goto L10;
        this.f8615b.registerListener(this.j, r1, 1);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarSensorHandler", "register elevatorSensor listener", false, 4, null);
    L10:
        Sensor r2 = this.e;
        if (r2 == null) goto L15;
        this.f8615b.registerListener(this.j, r2, 1);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarSensorHandler", "register escalatorAndStairSensor listener", false, 4, null);
        return;
    L15:
        return;
    }

    public final void c() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarSensorHandler", "stop", false, 4, null);
        this.f8615b.unregisterListener(this.j);
    }
}
