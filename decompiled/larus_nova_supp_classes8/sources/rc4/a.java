package rc4;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.bytedance.bpea.basics.BPEAException;
import fna.g;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import ona.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {

    /* JADX INFO: renamed from: rc4.a$a, reason: collision with other inner class name */
    public static final class C0413a {
    }

    static {
    }

    @JvmStatic
    public static final void b(SensorManager r1, SensorEventListener r2, Sensor r3) throws BPEAException {
        if (g.d() == true) goto L5;
        r1.unregisterListener(r2, r3);
        return;
    L5:
        r1.unregisterListener(r2, r3);
        int r0 = 0;
        if (r2 == null) goto L8;
        int r4 = r2.hashCode();
    L9:
        if (r3 == null) goto L11;
        r0 = r3.hashCode();
    L11:
        b.c(new ona.a(r4, Integer.valueOf(r0)));
        return;
    L8:
        r4 = 0;
        goto L9
    }

    @JvmStatic
    public static final void a(SensorManager r3, SensorEventListener r4, Sensor r5, Handler r6) throws BPEAException {
        if (g.d() == true) goto L5;
        Boolean r7 = Boolean.valueOf(r3.registerListener(r4, r5, 3, r6));
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.Boolean");
        r7.booleanValue();
        return;
    L5:
        Boolean r8 = Boolean.valueOf(r3.registerListener(r4, r5, 3, r6));
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.Boolean");
        r8.booleanValue();
        int r9 = 0;
        if (r4 == null) goto L8;
        int r10 = r4.hashCode();
    L9:
        if (r5 == null) goto L11;
        r9 = r5.hashCode();
    L11:
        b.a(new ona.a(r10, Integer.valueOf(r9)));
        return;
    L8:
        r10 = 0;
        goto L9
    }
}
