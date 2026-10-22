package com.bytedance.android.anniex.detect;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/anniex/detect/FailureStage;", "", "PixelCopy", "PureColorDetection", "PartialBlankDetection", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum FailureStage extends Enum<FailureStage> {
    public static final FailureStage PartialBlankDetection = null;
    public static final FailureStage PixelCopy = null;
    public static final FailureStage PureColorDetection = null;
    public static final /* synthetic */ FailureStage[] a = null;

    public static FailureStage valueOf(String r1) {
        return (FailureStage) r27.a.a(FailureStage.class, r1);
    }

    public static FailureStage[] values() {
        return (FailureStage[]) a.clone();
    }

    static {
        FailureStage r0 = new FailureStage("PixelCopy", 0);
        PixelCopy = r0;
        FailureStage r1 = new FailureStage("PureColorDetection", 1);
        PureColorDetection = r1;
        FailureStage r10 = new FailureStage("PartialBlankDetection", 2);
        PartialBlankDetection = r10;
        a = new FailureStage[]{r0, r1, r10};
    }

    public FailureStage(String r1, int r10) {
        super(r1, r10);
    }
}
