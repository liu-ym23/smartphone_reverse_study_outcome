package com.ss.android.lark.image.uploader.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.entity.LoadParams;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R.\u0010\b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tj\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/image/uploader/config/TranscodeConfig;", "", "<init>", "()V", "enable", "", "getEnable", "()Z", "imageTypeWhiteList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getImageTypeWhiteList", "()Ljava/util/ArrayList;", "targetTranscodeType", "getTargetTranscodeType", "()Ljava/lang/String;", "Companion", "image-uploader_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class g {
    public static final List<String> a = null;

    @SerializedName("enable_client_transcode")
    private final boolean enable;

    @SerializedName("skip_transcode_image_type_list")
    private final ArrayList<String> imageTypeWhiteList;

    @SerializedName("target_transcode_type")
    private final String targetTranscodeType;

    public static final class a {
    }

    static {
        a = CollectionsKt.listOf(new String[]{LoadParams.ImageFormat.PNG, LoadParams.ImageFormat.WEBP, LoadParams.ImageFormat.JPEG, "jpg", "gif"});
    }

    public g() {
        this.enable = true;
        this.imageTypeWhiteList = new ArrayList(a);
        this.targetTranscodeType = LoadParams.ImageFormat.JPEG;
    }

    public final boolean a() {
        return this.enable;
    }

    public final ArrayList<String> b() {
        return this.imageTypeWhiteList;
    }
}
