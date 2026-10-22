package com.ss.android.lark.imageocr_export;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/imageocr_export/OCRScene;", "", "<init>", "(Ljava/lang/String;I)V", "OCR", "SCRATCH", "imageocr_export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum OCRScene extends Enum<OCRScene> {
    public static final OCRScene OCR = null;
    public static final OCRScene SCRATCH = null;
    public static final /* synthetic */ OCRScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OCRScene> getEntries() {
        return b;
    }

    static {
        OCRScene r0 = new OCRScene("OCR", 0);
        OCR = r0;
        OCRScene r1 = new OCRScene("SCRATCH", 1);
        SCRATCH = r1;
        OCRScene[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static OCRScene[] values() {
        return (OCRScene[]) a.clone();
    }

    public static OCRScene valueOf(String r1) {
        return (OCRScene) a.a(OCRScene.class, r1);
    }

    public OCRScene(String r1, int r2) {
        super(r1, r2);
    }
}
