package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/y0;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "syncEnable", "Z", "b", "()Z", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "supportPageType", "Ljava/util/List;", "a", "()Ljava/util/List;", "setSupportPageType", "(Ljava/util/List;)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y0 {

    @SerializedName("support_gift_list_page_type")
    private List<Integer> supportPageType;

    @SerializedName("sync_enable")
    private final boolean syncEnable;

    public y0() {
        this.syncEnable = true;
        this.supportPageType = CollectionsKt.mutableListOf(new Integer[]{1, 15});
    }

    public final List<Integer> a() {
        return this.supportPageType;
    }

    public final boolean b() {
        return this.syncEnable;
    }
}
