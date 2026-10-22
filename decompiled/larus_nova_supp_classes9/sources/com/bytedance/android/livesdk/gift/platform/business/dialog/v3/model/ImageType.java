package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/model/ImageType;", BuildConfig.FLAVOR, "BitMap", "ImageModel", "DynamicImage", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ImageType extends Enum<ImageType> {
    public static final ImageType BitMap = null;
    public static final ImageType DynamicImage = null;
    public static final ImageType ImageModel = null;
    public static final /* synthetic */ ImageType[] a = null;

    static {
        ImageType r1 = new ImageType("BitMap", 0);
        BitMap = r1;
        ImageType r2 = new ImageType("ImageModel", 1);
        ImageModel = r2;
        ImageType r3 = new ImageType("DynamicImage", 2);
        DynamicImage = r3;
        a = new ImageType[]{r1, r2, r3};
    }

    public static ImageType valueOf(String r1) {
        return (ImageType) a.a(ImageType.class, r1);
    }

    public static ImageType[] values() {
        return (ImageType[]) a.clone();
    }

    public ImageType(String r1, int r2) {
        super(r1, r2);
    }
}
