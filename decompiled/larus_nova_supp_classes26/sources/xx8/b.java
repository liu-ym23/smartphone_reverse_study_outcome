package xx8;

import com.larus.camera.impl.utils.capture.CameraZoomRatioType;
import com.larus.camera.impl.utils.k;
import com.larus.utils.logger.FLogger;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements c {
    public boolean a;
    public float b;

    public static final class a {
    }

    static {
    }

    @Override // xx8.c
    public final float f(float r1) {
        return r1;
    }

    public b() {
        this.a = true;
        this.b = 1.0f;
    }

    @Override // xx8.c
    public final boolean b() {
        return c.a.a(this);
    }

    @Override // xx8.c
    public final boolean d() {
        return c.a.c(this);
    }

    @Override // xx8.c
    public final boolean h() {
        return c.a.b(this);
    }

    @Override // xx8.c
    public final boolean g() {
        return this.a;
    }

    @Override // xx8.c
    public final Pair<Float, Boolean> a(float r6) {
        Lazy r0 = k.a;
        boolean r3 = true;
        if (((oq9.d) r0.getValue()).a() != CameraZoomRatioType.SINGLE_ZOOM_RATIO.getType()) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        this.a = false;
        float r2 = r6;
    L16:
        this.b = r2;
        FLogger.a.i("Camera2ZoomManager", "checkMaxZoomSupport srcMaxZoomValue=" + r6 + " resMaxZoomValue=" + r2 + " settings:" + r1);
        return new Pair(Float.valueOf(r2), Boolean.valueOf(this.a));
    L11:
        if (r6 >= 3.0f) goto L14;
        r3 = false;
    L14:
        this.a = r3;
        r2 = (float) Math.floor(r6);
        goto L16
    L5:
        if (((oq9.d) r0.getValue()).a() == CameraZoomRatioType.MULTI_ZOOM_RATIO.getType()) goto L8;
        r1 = false;
        goto L9
    }

    @Override // xx8.c
    public final float c(float r5) {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        Float r1 = StringsKt.toFloatOrNull(String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(r5)}, 1)));
        FLogger.a.i("Camera2ZoomManager", "calculateZoomRatio zoomValue: " + r5 + ", after:" + r1);
        if (r1 != null) goto L5;
        return r5;
    L5:
        return r1.floatValue();
    }

    @Override // xx8.c
    public final double e(float r13, double r14) {
        FLogger.a.i("Camera2ZoomManager", "adjustMoveTotalLength ratio:" + r13 + ", max:" + r14);
        if (r13 > 1.0f) goto L7;
        return 0.0d;
    L7:
        return RangesKt.coerceIn((((double) r13) - 1.0d) / (((double) this.b) - 1.0d), 0.0d, 1.0d) * r14;
    }
}
