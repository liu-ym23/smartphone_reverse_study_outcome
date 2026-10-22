package ik0;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bpea.basics.BPEAException;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements FlowableOnSubscribe {
    public final /* synthetic */ SensorManager a;

    /* JADX INFO: renamed from: ik0.a$a, reason: collision with other inner class name */
    public static final class C0221a implements ttc.c {
        public final /* synthetic */ a a;
        public final /* synthetic */ b b;
        public final /* synthetic */ HandlerThread c;

        public C0221a(a r1, b r2, PthreadHandlerThreadV2 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void cancel() {
            SensorManager r0 = this.a.a;
            b r1 = this.b;
            if (fna.g.d() == true) goto L5;
            r0.unregisterListener(r1);
        L10:
            this.c.quitSafely();
            return;
        L5:
            r0.unregisterListener(r1);
            if (r1 == null) goto L8;
            int r2 = r1.hashCode();
        L9:
            ona.b.c(new ona.a(r2, null));
            goto L10
        L8:
            r2 = 0;
            goto L9
        }
    }

    public static final class b implements SensorEventListener {
        public final /* synthetic */ FlowableEmitter a;

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "sensor");
        }

        public b(FlowableEmitter r1) {
            this.a = r1;
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            if (this.a.isCancelled() == true) goto L6;
            this.a.onNext(r2);
            return;
        }
    }

    public a(SensorManager r1) {
        this.a = r1;
    }

    public final void subscribe(FlowableEmitter<SensorEvent> r9) {
        Intrinsics.checkNotNullParameter(r9, "emitter");
        Sensor r0 = g80.f.b(this.a, ik0.b.a);     // Catch: BPEAException -> L14
        PthreadHandlerThreadV2 r1 = new PthreadHandlerThreadV2("SensorThread");
        ThreadMethodProxy.start(r1);
        Handler r2 = new Handler(r1.getLooper());
        b r3 = new b(r9);
        SensorManager r4 = this.a;
        if (fna.g.d() == true) goto L7;
        Boolean r5 = Boolean.valueOf(r4.registerListener(r3, r0, 2, r2));
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Boolean");
        r5.booleanValue();
    L12:
        r9.setCancellable(new C0221a(this, r3, r1));
        return;
    L7:
        Boolean r6 = Boolean.valueOf(r4.registerListener(r3, r0, 2, r2));
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Boolean");
        r6.booleanValue();
        int r7 = r3.hashCode();
        if (r0 == null) goto L10;
        int r8 = r0.hashCode();
    L11:
        ona.b.a(new ona.a(r7, Integer.valueOf(r8)));
        goto L12
    L10:
        r8 = 0;
    L14:
        e = move-exception;
        ALogger.e("SensorRx", "Error getting sensor", e);
        r9.onError(e);
    }
}
