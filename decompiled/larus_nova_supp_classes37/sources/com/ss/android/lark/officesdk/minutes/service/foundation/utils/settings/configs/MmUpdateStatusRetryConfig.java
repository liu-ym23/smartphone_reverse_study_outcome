package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "vc_minutes_update_status_retry_config")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmUpdateStatusRetryConfig;", "Ljava/io/Serializable;", "intervalInSecs", "", "maxRetryCount", "<init>", "(II)V", "getIntervalInSecs", "()I", "getMaxRetryCount", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmUpdateStatusRetryConfig implements Serializable {
    public static final a Companion = null;
    public static final long MAX_RANDOM_MS = 2000;

    @SerializedName("intervalInSecs")
    private final int intervalInSecs;

    @SerializedName("maxRetryCount")
    private final int maxRetryCount;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public MmUpdateStatusRetryConfig() {
        int r2 = 0;
        this(r2, r2, 3, null);
    }

    public MmUpdateStatusRetryConfig(int r4) {
        int r2 = 0;
        this(r4, r2, 2, null);
    }

    public static /* synthetic */ MmUpdateStatusRetryConfig copy$default(MmUpdateStatusRetryConfig r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.intervalInSecs;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.maxRetryCount;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.intervalInSecs;
    }

    public final int component2() {
        return this.maxRetryCount;
    }

    public final MmUpdateStatusRetryConfig copy(int r2, int r3) {
        return new MmUpdateStatusRetryConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmUpdateStatusRetryConfig) == true) goto L8;
        return false;
    L8:
        MmUpdateStatusRetryConfig r6 = (MmUpdateStatusRetryConfig) r5;
        if (this.intervalInSecs == r6.intervalInSecs) goto L12;
        return false;
    L12:
        if (this.maxRetryCount == r6.maxRetryCount) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.intervalInSecs * 31) + this.maxRetryCount;
    }

    public String toString() {
        return "MmUpdateStatusRetryConfig(intervalInSecs=" + this.intervalInSecs + ", maxRetryCount=" + this.maxRetryCount + ')';
    }

    public final int getIntervalInSecs() {
        return this.intervalInSecs;
    }

    public final int getMaxRetryCount() {
        return this.maxRetryCount;
    }

    public MmUpdateStatusRetryConfig(int r1, int r2) {
        this.intervalInSecs = r1;
        this.maxRetryCount = r2;
    }

    public /* synthetic */ MmUpdateStatusRetryConfig(int r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 5;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 10;
    L8:
        this(r1, r2);
    }
}
