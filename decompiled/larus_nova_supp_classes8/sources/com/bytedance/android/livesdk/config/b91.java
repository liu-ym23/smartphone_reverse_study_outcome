package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/config/b91;", "", "", "canPaidShow", "Z", "getCanPaidShow", "()Z", "", "", "showLiveLayoutList", "Ljava/util/List;", "getShowLiveLayoutList", "()Ljava/util/List;", "canUseVisibility", "getCanUseVisibility", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b91 {

    @SerializedName("can_paid_live_show")
    private final boolean canPaidShow;

    @SerializedName("can_use_visibility")
    private final boolean canUseVisibility;

    @SerializedName("show_live_layout_list")
    private final List<Long> showLiveLayoutList;

    public b91() {
        this.canPaidShow = true;
        this.showLiveLayoutList = CollectionsKt.listOf(0L);
        this.canUseVisibility = true;
    }
}
