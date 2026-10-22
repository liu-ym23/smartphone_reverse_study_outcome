package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0005R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmUploadTaskRetryConfig;", "Ljava/io/Serializable;", "<init>", "()V", "interval", "", "getInterval", "()I", "setInterval", "(I)V", "maxCount", "getMaxCount", "setMaxCount", "", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmUploadTaskRetryConfig implements Serializable {
    public static final a Companion = null;

    @SerializedName("interval")
    private int interval;

    @SerializedName("max_count")
    private int maxCount;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public MmUploadTaskRetryConfig() {
    }

    public final int getMaxCount() {
        int r0 = this.maxCount;
        if (r0 != (-1)) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return r0;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final void setInterval(int r1) {
        this.interval = r1;
    }

    public final void setMaxCount(int r1) {
        this.maxCount = r1;
    }

    public static final /* synthetic */ void access$setMaxCount$p(MmUploadTaskRetryConfig r0, int r1) {
        r0.maxCount = r1;
    }
}
