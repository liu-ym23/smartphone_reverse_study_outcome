package com.bytedance.android.live.broadcast.api.model;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.util.Range;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r {
    public static final z1 a = null;

    static {
        a = new z1(0);
    }

    @JvmStatic
    public static final boolean c() {
        Integer r0 = (Integer) com.bytedance.android.livesdk.sharedpref.b.a.a();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 1) goto L8;
        return true;
    }

    public static void a(int r7) {
        int r0 = Build.VERSION.SDK_INT;
        Object r1 = jc1.a.b().getApplicationContext().getSystemService(NewBroadcastMonitor.STAGE.CAMERA);
        if (r1 == null) goto L38;
        CameraCharacteristics r8 = ((CameraManager) r1).getCameraCharacteristics(String.valueOf(r7));     // Catch: Exception -> L34
        Integer r2 = (Integer) r8.get(CameraCharacteristics.LENS_FACING);     // Catch: Exception -> L34
        z1 r3 = a;
        if (r0 < 30) goto L18;
        Range r9 = (Range) r8.get(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);     // Catch: Exception -> L34
        if (r9 != null) goto L11;
        return;
    L11:
        ALogger.i("CameraZoomManager", "isFront:" + r2 + ",range:" + ((Float) r9.getLower()) + "---" + ((Float) r9.getUpper()));     // Catch: Exception -> L34
        if (r2 != null) goto L15;
    L17:
        r3.b = new a2(((Number) r9.getUpper()).floatValue(), ((Number) r9.getLower()).floatValue());     // Catch: Exception -> L34
        return;
    L15:
        if (r2.intValue() != 0) goto L17;
        r3.a = new a2(((Number) r9.getUpper()).floatValue(), ((Number) r9.getLower()).floatValue());     // Catch: Exception -> L34
        return;
    L18:
        Float r11 = (Float) r8.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);     // Catch: Exception -> L34
        ALogger.i("CameraZoomManager", "isFront:" + r2 + ",range:" + r11);     // Catch: Exception -> L34
        if (r2 != null) goto L22;
    L29:
        if (r11 == null) goto L31;
        float r12 = r11.floatValue();     // Catch: Exception -> L34
    L32:
        r3.b = new a2(r12, 1.0f);     // Catch: Exception -> L34
        return;
    L31:
        r12 = 1.0f;
        goto L32
    L22:
        if (r2.intValue() != 0) goto L29;
        if (r11 == null) goto L26;
        float r13 = r11.floatValue();     // Catch: Exception -> L34
    L27:
        r3.a = new a2(r13, 1.0f);     // Catch: Exception -> L34
        return;
    L26:
        r13 = 1.0f;
    L34:
        e = move-exception;
        e.printStackTrace();
        return;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
    }

    public static a2 b(int r3) {
        z1 r0 = a;
        if (r0.a == null) goto L5;
    L7:
        if (r3 == 1) goto L13;
        if (r3 == 0) goto L14;
        return null;
    L14:
        return r0.b;
    L13:
        return r0.a;
    L5:
        if (r0.b != null) goto L7;
        a(0);
        a(1);
        goto L7
    }

    @JvmStatic
    public static final void d(y1 r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "currentRatioEntry");
        boolean r0 = c();
        ALogger.i("CameraZoomManager", "set ratio:" + r4);
        if (r0 == false) goto L5;
        r3.a = r4;
    L6:
        r3.c = r4;
        return;
    L5:
        r3.b = r4;
        goto L6
    }
}
