package com.larus.camera.impl.utils.capture;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/camera/impl/utils/capture/ZoomRatio;", "", "ratio", "", "ratioStr", "", "<init>", "(Ljava/lang/String;IFLjava/lang/String;)V", "getRatio", "()F", "getRatioStr", "()Ljava/lang/String;", "RATIO_1X", "RATIO_2X", "RATIO_3X", "RATIO_4X", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ZoomRatio extends Enum<ZoomRatio> {
    public static final ZoomRatio RATIO_1X = null;
    public static final ZoomRatio RATIO_2X = null;
    public static final ZoomRatio RATIO_3X = null;
    public static final ZoomRatio RATIO_4X = null;
    public static final /* synthetic */ ZoomRatio[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final float ratio;
    private final String ratioStr;

    public static EnumEntries<ZoomRatio> getEntries() {
        return b;
    }

    static {
        ZoomRatio r0 = new ZoomRatio("RATIO_1X", 0, 1.0f, "1x");
        RATIO_1X = r0;
        ZoomRatio r1 = new ZoomRatio("RATIO_2X", 1, 2.0f, "2x");
        RATIO_2X = r1;
        ZoomRatio r2 = new ZoomRatio("RATIO_3X", 2, 3.0f, "3x");
        RATIO_3X = r2;
        ZoomRatio r3 = new ZoomRatio("RATIO_4X", 3, 4.0f, "4x");
        RATIO_4X = r3;
        ZoomRatio[] r5 = {r0, r1, r2, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ZoomRatio[] values() {
        return (ZoomRatio[]) a.clone();
    }

    public final float getRatio() {
        return this.ratio;
    }

    public final String getRatioStr() {
        return this.ratioStr;
    }

    public static ZoomRatio valueOf(String r1) {
        return (ZoomRatio) a.a(ZoomRatio.class, r1);
    }

    public ZoomRatio(String r1, int r2, float r3, String r4) {
        super(r1, r2);
        this.ratio = r3;
        this.ratioStr = r4;
    }
}
