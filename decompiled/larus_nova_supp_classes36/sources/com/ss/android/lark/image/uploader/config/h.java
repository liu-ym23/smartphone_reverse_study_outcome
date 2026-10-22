package com.ss.android.lark.image.uploader.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/image/uploader/config/UploadAvatarConfig;", "", "<init>", "()V", "avatarShortSideMaxSize", "", "getAvatarShortSideMaxSize", "()I", "quality", "getQuality", "image-uploader_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class h {

    @SerializedName("limit_image_size")
    private final int avatarShortSideMaxSize;

    @SerializedName("quality")
    private final int quality;

    public h() {
        this.avatarShortSideMaxSize = 1080;
        this.quality = 75;
    }

    public final int a() {
        return this.avatarShortSideMaxSize;
    }

    public final int b() {
        return this.quality;
    }
}
