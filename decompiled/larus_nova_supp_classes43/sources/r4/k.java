package r4;

import android.content.ClipData;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface k {
    boolean a(Context r1, e3.d r10, String r11);

    void b(Context r1, e3.d r10, String r11, ClipData r12);

    ClipData c(Context r1, e3.d r10, String r11);

    void d(Context r1, Integer r10, Long r11, String r12, Long r13, c r14, Boolean r15, String r16);

    Sensor e(SensorManager r1, e3.d r10, String r11, int r12);
}
