package com.xiphias.browser.scanner.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0003!\"#B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0007J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\b\u0010 \u001a\u00020\u0007H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/xiphias/browser/scanner/util/MotionDetector;", "Landroid/hardware/SensorEventListener;", "context", "Landroid/content/Context;", "onStateChanged", "Lkotlin/Function1;", "Lcom/xiphias/browser/scanner/util/MotionDetector$State;", "", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "sensorManager", "Landroid/hardware/SensorManager;", "accelerometer", "Landroid/hardware/Sensor;", CommonConsts.TIMER_TYPE, "Ljava/util/Timer;", "state", "lastPosition", "Lcom/xiphias/browser/scanner/util/MotionDetector$Position;", "lastActiveTime", "", CommonConsts.APM_INNER_EVENT_COST_START, "stop", "resetLastActiveTime", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "onAccuracyChanged", "sensor", LocationMonitorConst.ACCURACY, "", "onScreenStationary", "onScreenMoving", "State", "Position", "Companion", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MotionDetector implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16352a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<State, Unit> f16353b;
    private SensorManager c;
    private Sensor d;
    private Timer e;
    private State f;
    private b g;
    private volatile long h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/xiphias/browser/scanner/util/MotionDetector$State;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVE", "INACTIVE", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State ACTIVE = null;
        public static final State INACTIVE = null;

        private static final /* synthetic */ State[] $values() {
            return new State[]{ACTIVE, INACTIVE};
        }

        static {
            ACTIVE = new State("ACTIVE", 0);
            INACTIVE = new State("INACTIVE", 1);
            State[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String r2) {
            return (State) ZeusTransformUtils.preCheckCast(Enum.valueOf(State.class, r2), State.class, "com.obric.memorydata.plugin");
        }

        public static State[] values() {
            return (State[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), State[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/xiphias/browser/scanner/util/MotionDetector$Companion;", "", "<init>", "()V", "THRESHOLD", "", "INACTIVE_TIME_THRESHOLD", "", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/xiphias/browser/scanner/util/MotionDetector$Position;", "", "x", "", "y", "z", "<init>", "(FFF)V", "getX", "()F", "getY", "getZ", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f16355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f16356b;
        private final float c;

        public b(float r1, float r2, float r3) {
            this.f16355a = r1;
            this.f16356b = r2;
            this.c = r3;
        }

        public final float a() {
            return this.f16355a;
        }

        public final float b() {
            return this.f16356b;
        }

        public final float c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Float.compare(this.f16355a, r6.f16355a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f16356b, r6.f16356b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.c, r6.c) == 0) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Float.hashCode(this.f16355a) * 31) + Float.hashCode(this.f16356b)) * 31) + Float.hashCode(this.c);
        }

        public String toString() {
            return "Position(x=" + this.f16355a + ", y=" + this.f16356b + ", z=" + this.c + ')';
        }
    }

    static {
        f16352a = new a(null);
    }

    public MotionDetector(Context r9, Function1<? super State, Unit> r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Function1<State, Unit> r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "onStateChanged");
        this.f16353b = r12;
        Object r13 = r11.getSystemService("sensor");
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.hardware.SensorManager");
        this.c = (SensorManager) ZeusTransformUtils.preCheckCast(r13, SensorManager.class, "com.obric.memorydata.plugin");
        this.f = State.ACTIVE;
        this.h = System.currentTimeMillis();
        this.e = new Timer();
        SensorManager r14 = this.c;
        if (r14 == null) goto L5;
        Intrinsics.checkNotNull(r14);
        this.d = r14.getDefaultSensor(1);
    L5:
        Timer r2 = this.e;
        if (r2 == null) goto L9;
        r2.schedule((TimerTask) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), TimerTask.class, "com.obric.memorydata.plugin"), 0, 1000);
        return;
    }

    public static final /* synthetic */ long a(MotionDetector r2) {
        return r2.h;
    }

    public static final /* synthetic */ void a(MotionDetector r0, State r1) {
        r0.f = r1;
    }

    public static final /* synthetic */ State b(MotionDetector r0) {
        return r0.f;
    }

    public static final /* synthetic */ Function1 c(MotionDetector r0) {
        return r0.f16353b;
    }

    private final void d() {
    }

    private final void e() {
        if (this.f != State.INACTIVE) goto L5;
        this.f16353b.invoke(State.ACTIVE);
    L5:
        this.f = State.ACTIVE;
        this.h = System.currentTimeMillis();
    }

    public final void a() {
        if (this.d == null) goto L8;
        SensorManager r0 = this.c;
        if (r0 == null) goto L9;
        r0.registerListener((SensorEventListener) ZeusTransformUtils.preCheckCast(this, SensorEventListener.class, "com.obric.memorydata.plugin"), this.d, 3);
        return;
    L9:
        return;
    }

    public final void b() {
        Timer r0 = this.e;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.e = null;
        SensorManager r1 = this.c;
        if (r1 == null) goto L9;
        r1.unregisterListener((SensorEventListener) ZeusTransformUtils.preCheckCast(this, SensorEventListener.class, "com.obric.memorydata.plugin"));
        return;
    }

    public final void c() {
        this.f = State.ACTIVE;
        this.h = System.currentTimeMillis();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor r1, int r2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        float r0 = r7.values[0];
        float r1 = r7.values[1];
        float r8 = r7.values[2];
        b r2 = this.g;
        if (r2 != null) goto L6;
        this.g = new b(r0, r1, r8);
        return;
    L6:
        Intrinsics.checkNotNull(r2);
        float r3 = Math.abs(r0 - r2.a());
        b r4 = this.g;
        Intrinsics.checkNotNull(r4);
        float r5 = Math.abs(r1 - r4.b());
        b r6 = this.g;
        Intrinsics.checkNotNull(r6);
        float r9 = Math.abs(r8 - r6.c());
        this.g = new b(r0, r1, r8);
        if (Math.sqrt(((r3 * r3) + (r5 * r5)) + (r9 * r9)) >= 0.5d) goto L9;
        d();
        return;
    L9:
        e();
    }
}
