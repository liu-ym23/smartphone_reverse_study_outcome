package com.ss.android.lark.image.compose.common;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.entity.LoadParams;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/image/compose/common/ImageFormat;", "", "value", "", "suffix", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getValue", "()I", "getSuffix", "()Ljava/lang/String;", "WEBP", "JPEG", "PNG", "HEIC", "Companion", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum ImageFormat extends Enum<ImageFormat> {
    public static final a Companion = null;
    public static final ImageFormat HEIC = null;
    public static final ImageFormat JPEG = null;
    public static final ImageFormat PNG = null;
    public static final ImageFormat WEBP = null;
    public static final /* synthetic */ ImageFormat[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String suffix;
    private final int value;

    public static EnumEntries<ImageFormat> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.image.compose.common.ImageFormat$a] */
    static {
        ImageFormat r0 = new ImageFormat("WEBP", 0, 1, LoadParams.ImageFormat.WEBP);
        WEBP = r0;
        ImageFormat r1 = new ImageFormat("JPEG", 1, 2, LoadParams.ImageFormat.JPEG);
        JPEG = r1;
        ImageFormat r4 = new ImageFormat("PNG", 2, 3, LoadParams.ImageFormat.PNG);
        PNG = r4;
        ImageFormat r6 = new ImageFormat("HEIC", 3, 4, "heic");
        HEIC = r6;
        ImageFormat[] r8 = {r0, r1, r4, r6};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
        Companion = new a();
    }

    public static ImageFormat[] values() {
        return (ImageFormat[]) a.clone();
    }

    public final String getSuffix() {
        return this.suffix;
    }

    public final int getValue() {
        return this.value;
    }

    public static ImageFormat valueOf(String r1) {
        return (ImageFormat) r27.a.a(ImageFormat.class, r1);
    }

    public ImageFormat(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.value = r3;
        this.suffix = r4;
    }
}
