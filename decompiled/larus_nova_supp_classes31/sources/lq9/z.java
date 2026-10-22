package lq9;

import com.google.gson.annotations.SerializedName;
import com.larus.common.apphost.AppHost;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J^\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u0006&"}, d2 = {"Lcom/larus/platform/model/audio/RealtimeClientRetryConfig;", "", "enableRetry", "", "maxRetryTimesInSingleCall", "", "retryCodeList", "", "unlimitedRetrySubErrorCodeList", "enableServerErrorRetry", "enableServerErrorUI", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;ZZ)V", "getEnableRetry", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMaxRetryTimesInSingleCall", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRetryCodeList", "()Ljava/util/List;", "getUnlimitedRetrySubErrorCodeList", "getEnableServerErrorRetry", "()Z", "getEnableServerErrorUI", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;ZZ)Lcom/larus/platform/model/audio/RealtimeClientRetryConfig;", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class z {

    @SerializedName("enable_client_retry")
    private final Boolean enableRetry;

    @SerializedName("enable_server_error_retry")
    private final boolean enableServerErrorRetry;

    @SerializedName("enable_server_error_ui")
    private final boolean enableServerErrorUI;

    @SerializedName("max_retry_times_in_single_call")
    private final Integer maxRetryTimesInSingleCall;

    @SerializedName("retry_error_code_list")
    private final List<Integer> retryCodeList;

    @SerializedName("unlimited_retry_sub_error_code_list")
    private final List<Integer> unlimitedRetrySubErrorCodeList;

    public z() {
        this(null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof z) == true) goto L8;
        return false;
    L8:
        z r6 = (z) r5;
        if (Intrinsics.areEqual(this.enableRetry, r6.enableRetry) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxRetryTimesInSingleCall, r6.maxRetryTimesInSingleCall) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.retryCodeList, r6.retryCodeList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.unlimitedRetrySubErrorCodeList, r6.unlimitedRetrySubErrorCodeList) == true) goto L21;
        return false;
    L21:
        if (this.enableServerErrorRetry == r6.enableServerErrorRetry) goto L24;
        return false;
    L24:
        if (this.enableServerErrorUI == r6.enableServerErrorUI) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.enableRetry;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.maxRetryTimesInSingleCall;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<Integer> r7 = this.retryCodeList;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<Integer> r10 = this.unlimitedRetrySubErrorCodeList;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        int r11 = (r9 + r1) * 31;
        int r12 = 1231;
        if (this.enableServerErrorRetry == false) goto L21;
        int r13 = 1231;
    L22:
        int r14 = (r11 + r13) * 31;
        if (this.enableServerErrorUI == true) goto L27;
        r12 = 1237;
    L27:
        return r14 + r12;
    L21:
        r13 = 1237;
        goto L22
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "RealtimeClientRetryConfig(enableRetry=" + this.enableRetry + ", maxRetryTimesInSingleCall=" + this.maxRetryTimesInSingleCall + ", retryCodeList=" + this.retryCodeList + ", unlimitedRetrySubErrorCodeList=" + this.unlimitedRetrySubErrorCodeList + ", enableServerErrorRetry=" + this.enableServerErrorRetry + ", enableServerErrorUI=" + this.enableServerErrorUI + ')';
    }

    public final Boolean a() {
        return this.enableRetry;
    }

    public final boolean b() {
        return this.enableServerErrorRetry;
    }

    public final boolean c() {
        return this.enableServerErrorUI;
    }

    public final Integer d() {
        return this.maxRetryTimesInSingleCall;
    }

    public final List<Integer> e() {
        return this.retryCodeList;
    }

    public final List<Integer> f() {
        return this.unlimitedRetrySubErrorCodeList;
    }

    public z(Object r7) {
        Boolean r8 = Boolean.valueOf(!AppHost.a.isOversea());
        List<Integer> r2 = CollectionsKt.listOf(new Integer[]{10005, 10002, 10006});
        List<Integer> r3 = CollectionsKt.listOf(622);
        this.enableRetry = r8;
        this.maxRetryTimesInSingleCall = 1;
        this.retryCodeList = r2;
        this.unlimitedRetrySubErrorCodeList = r3;
        this.enableServerErrorRetry = true;
        this.enableServerErrorUI = false;
    }
}
