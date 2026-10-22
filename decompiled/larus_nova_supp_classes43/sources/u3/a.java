package u3;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.google.gson.JsonObject;
import e3.d;
import kotlin.jvm.internal.Intrinsics;
import t3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends c {

    /* JADX INFO: renamed from: u3.a$a, reason: collision with other inner class name */
    public static final class C0201a {
    }

    static {
    }

    public a(d r10) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        super(r10, 11, "doubao.onCompassChange", "compass is not available");
    }

    @Override // t3.c
    public final JsonObject c(SensorEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        float[] r0 = new float[9];
        float[] r11 = new float[3];
        SensorManager.getRotationMatrixFromVector(r0, r10.values);
        SensorManager.getOrientation(r0, r11);
        JsonObject r1 = new JsonObject();
        double r12 = Math.toDegrees(r11[0]) % 360.0d;
        if (r12 >= 0.0d) goto L5;
        r12 = r12 + 360.0d;
    L5:
        r1.addProperty("direction", Double.valueOf(r12));
        int r13 = r10.accuracy;
        if (r13 == (-1)) goto L18;
        if (r13 != 0) goto L9;
        String r14 = "unreliable";
    L19:
        r1.addProperty("accuracy", r14);
        return r1;
    L9:
        if (r13 != 1) goto L11;
        r14 = "low";
        goto L19
    L11:
        if (r13 == 2) goto L15;
        if (r13 == 3) goto L14;
        r14 = "unknow " + r13;
        goto L19
    L14:
        r14 = "high";
        goto L19
    L15:
        r14 = "medium";
        goto L19
    L18:
        r14 = "no-contact";
        goto L19
    }
}
