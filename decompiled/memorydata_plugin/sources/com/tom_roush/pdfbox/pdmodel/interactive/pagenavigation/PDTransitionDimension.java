package com.tom_roush.pdfbox.pdmodel.interactive.pagenavigation;

import androidx.exifinterface.media.ExifInterface;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum PDTransitionDimension extends Enum<PDTransitionDimension> {
    private static final /* synthetic */ PDTransitionDimension[] $VALUES = null;
    public static final PDTransitionDimension H = null;
    public static final PDTransitionDimension V = null;

    static {
        PDTransitionDimension r0 = new PDTransitionDimension(i.n, 0);
        H = r0;
        PDTransitionDimension r1 = new PDTransitionDimension(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, 1);
        V = r1;
        $VALUES = new PDTransitionDimension[]{r0, r1};
    }

    private PDTransitionDimension(String r1, int r2) {
        super(r1, r2);
    }

    public static PDTransitionDimension valueOf(String r2) {
        return (PDTransitionDimension) ZeusTransformUtils.preCheckCast(Enum.valueOf(PDTransitionDimension.class, r2), PDTransitionDimension.class, "com.obric.memorydata.plugin");
    }

    public static PDTransitionDimension[] values() {
        return (PDTransitionDimension[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PDTransitionDimension[].class, "com.obric.memorydata.plugin");
    }
}
