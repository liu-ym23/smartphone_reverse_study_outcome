package t3;

import android.hardware.SensorEvent;
import com.google.gson.JsonObject;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class b extends c {
    @Override // t3.c
    public final JsonObject c(SensorEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        float[] r0 = r10.values;
        JsonObject r1 = new JsonObject();
        Intrinsics.checkNotNull(r0);
        Float r11 = ArraysKt.getOrNull(r0, 0);
        double r12 = 0.0d;
        if (r11 == null) goto L5;
        double r13 = r11.floatValue();
    L6:
        r1.addProperty("x", Double.valueOf(r13));
        Float r14 = ArraysKt.getOrNull(r0, 1);
        if (r14 == null) goto L9;
        double r15 = r14.floatValue();
    L10:
        r1.addProperty("y", Double.valueOf(r15));
        Float r16 = ArraysKt.getOrNull(r0, 2);
        if (r16 == null) goto L13;
        r12 = r16.floatValue();
    L13:
        r1.addProperty("z", Double.valueOf(r12));
        r1.addProperty("timestamp", Long.valueOf(r10.timestamp));
        return r1;
    L9:
        r15 = 0.0d;
        goto L10
    L5:
        r13 = 0.0d;
        goto L6
    }

    public b(e3.d r10, int r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, "changeEventName");
        Intrinsics.checkNotNullParameter(r13, "unavailableMessage");
        super(r10, r11, r12, r13);
    }
}
