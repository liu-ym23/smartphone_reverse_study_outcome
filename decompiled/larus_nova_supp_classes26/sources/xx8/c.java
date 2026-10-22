package xx8;

import com.larus.camera.impl.utils.capture.CameraZoomRatioType;
import com.larus.camera.impl.utils.k;
import com.larus.utils.logger.FLogger;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface c {

    public static final class a {
        public static boolean a(c r1) {
            if (r1.d() == false) goto L5;
        L8:
            return true;
        L5:
            if (r1.h() == true) goto L8;
            return false;
        }

        public static boolean b(c r7) {
            if (((oq9.d) k.a.getValue()).a() != CameraZoomRatioType.MULTI_ZOOM_RATIO.getType()) goto L5;
            boolean r0 = true;
        L6:
            FLogger.a.i(r7.getClass().getName(), "isMultiZoomRatioEnable res=" + r0 + " isCheckMaxZoomSupport=" + r7.g());
            if (r0 == true) goto L9;
            return false;
        L9:
            if (r7.g() == false) goto L13;
            return true;
        L13:
            return false;
        L5:
            r0 = false;
            goto L6
        }

        public static boolean c(c r7) {
            if (((oq9.d) k.a.getValue()).a() != CameraZoomRatioType.SINGLE_ZOOM_RATIO.getType()) goto L5;
            boolean r0 = true;
        L6:
            FLogger.a.i(r7.getClass().getName(), "isSingleZoomRatioEnable res=" + r0 + " isCheckMaxZoomSupport=" + r7.g());
            if (r0 == true) goto L9;
            return false;
        L9:
            if (r7.g() == false) goto L13;
            return true;
        L13:
            return false;
        L5:
            r0 = false;
            goto L6
        }
    }

    Pair<Float, Boolean> a(float r1);

    boolean b();

    float c(float r1);

    boolean d();

    double e(float r1, double r2);

    float f(float r1);

    boolean g();

    boolean h();
}
