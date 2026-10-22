package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/q1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enableAnnieX", "Z", "enableSurfaceCanvas", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "surfaceCanvasWhiteGiftIdList", "Ljava/util/List;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q1 {

    @SerializedName("enable_annie_x")
    public boolean enableAnnieX;

    @SerializedName("enable_surface_canvas")
    public boolean enableSurfaceCanvas;

    @SerializedName("surface_canvas_white_gift_id_list")
    public List<String> surfaceCanvasWhiteGiftIdList;

    public q1() {
        this.surfaceCanvasWhiteGiftIdList = new ArrayList();
    }
}
