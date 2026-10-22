package com.ss.android.lark.chat.base.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@AppConfig(key = "send_image_msg_config")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chat/base/model/ImageSendConfig;", BuildConfig.FLAVOR, "baseConfig", "Lcom/ss/android/lark/chat/base/model/FormatConfig;", "pngConfig", "jpegConfig", "gifConfig", "<init>", "(Lcom/ss/android/lark/chat/base/model/FormatConfig;Lcom/ss/android/lark/chat/base/model/FormatConfig;Lcom/ss/android/lark/chat/base/model/FormatConfig;Lcom/ss/android/lark/chat/base/model/FormatConfig;)V", "getBaseConfig", "()Lcom/ss/android/lark/chat/base/model/FormatConfig;", "getPngConfig", "getJpegConfig", "getGifConfig", "getConfigByType", "mimeType", BuildConfig.FLAVOR, "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageSendConfig {

    @SerializedName("base_config")
    private final FormatConfig baseConfig;

    @SerializedName("gif_config")
    private final FormatConfig gifConfig;

    @SerializedName("jpg_config")
    private final FormatConfig jpegConfig;

    @SerializedName("png_config")
    private final FormatConfig pngConfig;

    public ImageSendConfig() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ImageSendConfig copy$default(ImageSendConfig r0, FormatConfig r1, FormatConfig r2, FormatConfig r3, FormatConfig r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.baseConfig;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.pngConfig;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.jpegConfig;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.gifConfig;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final FormatConfig component1() {
        return this.baseConfig;
    }

    public final FormatConfig component2() {
        return this.pngConfig;
    }

    public final FormatConfig component3() {
        return this.jpegConfig;
    }

    public final FormatConfig component4() {
        return this.gifConfig;
    }

    public final ImageSendConfig copy(FormatConfig r2, FormatConfig r3, FormatConfig r4, FormatConfig r5) {
        Intrinsics.checkNotNullParameter(r2, "baseConfig");
        Intrinsics.checkNotNullParameter(r3, "pngConfig");
        Intrinsics.checkNotNullParameter(r4, "jpegConfig");
        Intrinsics.checkNotNullParameter(r5, "gifConfig");
        return new ImageSendConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ImageSendConfig) == true) goto L8;
        return false;
    L8:
        ImageSendConfig r6 = (ImageSendConfig) r5;
        if (Intrinsics.areEqual(this.baseConfig, r6.baseConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pngConfig, r6.pngConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.jpegConfig, r6.jpegConfig) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.gifConfig, r6.gifConfig) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.baseConfig.hashCode() * 31) + this.pngConfig.hashCode()) * 31) + this.jpegConfig.hashCode()) * 31) + this.gifConfig.hashCode();
    }

    public String toString() {
        return "ImageSendConfig(baseConfig=" + this.baseConfig + ", pngConfig=" + this.pngConfig + ", jpegConfig=" + this.jpegConfig + ", gifConfig=" + this.gifConfig + ')';
    }

    public final FormatConfig getBaseConfig() {
        return this.baseConfig;
    }

    public final FormatConfig getGifConfig() {
        return this.gifConfig;
    }

    public final FormatConfig getJpegConfig() {
        return this.jpegConfig;
    }

    public final FormatConfig getPngConfig() {
        return this.pngConfig;
    }

    public final FormatConfig getConfigByType(String r3) {
        if (r3 == null) goto L23;
        int r0 = r3.hashCode();
        if (r0 == (-879267568)) goto L19;
        if (r0 == (-879264467)) goto L15;
        if (r0 != (-879258763)) goto L23;
        if (r3.equals("image/png") == false) goto L23;
        return this.pngConfig;
    L15:
        if (r3.equals("image/jpg") == false) goto L23;
        return this.jpegConfig;
    L19:
        if (r3.equals("image/gif") == false) goto L23;
        return this.gifConfig;
    L23:
        return this.baseConfig;
    }

    public ImageSendConfig(FormatConfig r2, FormatConfig r3, FormatConfig r4, FormatConfig r5) {
        Intrinsics.checkNotNullParameter(r2, "baseConfig");
        Intrinsics.checkNotNullParameter(r3, "pngConfig");
        Intrinsics.checkNotNullParameter(r4, "jpegConfig");
        Intrinsics.checkNotNullParameter(r5, "gifConfig");
        this.baseConfig = r2;
        this.pngConfig = r3;
        this.jpegConfig = r4;
        this.gifConfig = r5;
    }

    public /* synthetic */ ImageSendConfig(FormatConfig r7, FormatConfig r8, FormatConfig r9, FormatConfig r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r7 = new FormatConfig(0, null, 3, null);
    L6:
        if ((r11 & 2) == 0) goto L9;
        r8 = new FormatConfig(0, new ResolutionSize(8000, 8000), 1, null);
    L9:
        if ((r11 & 4) == 0) goto L12;
        r9 = new FormatConfig(0, new ResolutionSize(12000, 12000), 1, null);
    L12:
        if ((r11 & 8) == 0) goto L14;
        r10 = new FormatConfig(0, new ResolutionSize(7000, 7000), 1, null);
    L14:
        this(r7, r8, r9, r10);
    }
}
