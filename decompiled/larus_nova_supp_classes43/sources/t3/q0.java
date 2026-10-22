package t3;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q0 extends c {
    public q0(e3.d r10) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        super(r10, 11, "doubao.onDeviceMotionChange", "device motion is not available");
    }

    @Override // t3.c
    public final JsonObject c(SensorEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        float[] r0 = new float[9];
        float[] r1 = new float[3];
        SensorManager.getRotationMatrixFromVector(r0, r10.values);
        SensorManager.getOrientation(r0, r1);
        JsonObject r11 = new JsonObject();
        double r12 = ((double) r1[0]) % 6.283185307179586d;
        if (r12 >= 0.0d) goto L5;
        r12 = r12 + 6.283185307179586d;
    L5:
        r11.addProperty("alpha", Double.valueOf(r12));
        r11.addProperty("beta", Double.valueOf(r1[1]));
        r11.addProperty("gamma", Double.valueOf(r1[2]));
        return r11;
    }
}
