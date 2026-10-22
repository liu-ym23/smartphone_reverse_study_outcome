package xx8;

import com.larus.camera.impl.utils.capture.ZoomRatio;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i {
    public ZoomRatio a;
    public final String b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ZoomRatio.values().length];
            r0[ZoomRatio.RATIO_1X.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ZoomRatio.RATIO_2X.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ZoomRatio.RATIO_3X.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public i() {
        this.a = ZoomRatio.RATIO_1X;
        this.b = "ZoomRatioStep";
    }

    public final void a(float r5) {
        FLogger.a.i(this.b, "switchRatioStep: " + r5 + ", wideMinRatio:null");
        ZoomRatio r0 = ZoomRatio.RATIO_4X;
        if (r5 < r0.getRatio()) goto L5;
        this.a = r0;
        return;
    L5:
        ZoomRatio r1 = ZoomRatio.RATIO_3X;
        if (r5 < r1.getRatio()) goto L8;
        this.a = r1;
        return;
    L8:
        ZoomRatio r2 = ZoomRatio.RATIO_2X;
        if (r5 < r2.getRatio()) goto L11;
        this.a = r2;
        return;
    L11:
        ZoomRatio r3 = ZoomRatio.RATIO_1X;
        if (r5 < r3.getRatio()) goto L18;
        this.a = r3;
        return;
    }
}
