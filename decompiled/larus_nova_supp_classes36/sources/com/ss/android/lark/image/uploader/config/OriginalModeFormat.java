package com.ss.android.lark.image.uploader.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.entity.LoadParams;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/image/uploader/config/OriginalModeFormat;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "FILE", "image-uploader_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum OriginalModeFormat extends Enum<OriginalModeFormat> {

    @SerializedName("file")
    public static final OriginalModeFormat FILE = null;

    @SerializedName(LoadParams.ImageFormat.IMAGE)
    public static final OriginalModeFormat IMAGE = null;
    public static final /* synthetic */ OriginalModeFormat[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OriginalModeFormat> getEntries() {
        return b;
    }

    static {
        OriginalModeFormat r0 = new OriginalModeFormat("IMAGE", 0);
        IMAGE = r0;
        OriginalModeFormat r1 = new OriginalModeFormat("FILE", 1);
        FILE = r1;
        OriginalModeFormat[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static OriginalModeFormat[] values() {
        return (OriginalModeFormat[]) a.clone();
    }

    public static OriginalModeFormat valueOf(String r1) {
        return (OriginalModeFormat) r27.a.a(OriginalModeFormat.class, r1);
    }

    public OriginalModeFormat(String r1, int r2) {
        super(r1, r2);
    }
}
