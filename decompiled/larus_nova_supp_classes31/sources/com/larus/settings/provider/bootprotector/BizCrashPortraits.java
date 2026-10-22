package com.larus.settings.provider.bootprotector;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J:\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/larus/settings/provider/bootprotector/BizCrashPortraits;", "", "bizTag", "", "minCrashCount", "", "crashPortraits", "", "Lcom/larus/settings/provider/bootprotector/CrashPortrait;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "getBizTag", "()Ljava/lang/String;", "getMinCrashCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCrashPortraits", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lcom/larus/settings/provider/bootprotector/BizCrashPortraits;", "equals", "", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class BizCrashPortraits {

    @SerializedName("biz_tag")
    private final String bizTag;

    @SerializedName("crash_portraits")
    private final List<CrashPortrait> crashPortraits;

    @SerializedName("min_crash_count")
    private final Integer minCrashCount;

    public BizCrashPortraits() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BizCrashPortraits copy$default(BizCrashPortraits r0, String r1, Integer r2, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.bizTag;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.minCrashCount;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.crashPortraits;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.bizTag;
    }

    public final Integer component2() {
        return this.minCrashCount;
    }

    public final List<CrashPortrait> component3() {
        return this.crashPortraits;
    }

    public final BizCrashPortraits copy(String r2, Integer r3, List<CrashPortrait> r4) {
        return new BizCrashPortraits(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BizCrashPortraits) == true) goto L8;
        return false;
    L8:
        BizCrashPortraits r6 = (BizCrashPortraits) r5;
        if (Intrinsics.areEqual(this.bizTag, r6.bizTag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.minCrashCount, r6.minCrashCount) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.crashPortraits, r6.crashPortraits) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.bizTag;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.minCrashCount;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<CrashPortrait> r7 = this.crashPortraits;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "BizCrashPortraits(bizTag=" + this.bizTag + ", minCrashCount=" + this.minCrashCount + ", crashPortraits=" + this.crashPortraits + ')';
    }

    public final String getBizTag() {
        return this.bizTag;
    }

    public final List<CrashPortrait> getCrashPortraits() {
        return this.crashPortraits;
    }

    public final Integer getMinCrashCount() {
        return this.minCrashCount;
    }

    public BizCrashPortraits(String r1, Integer r2, List<CrashPortrait> r3) {
        this.bizTag = r1;
        this.minCrashCount = r2;
        this.crashPortraits = r3;
    }

    public /* synthetic */ BizCrashPortraits(String r1, Integer r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = 1;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = CollectionsKt.emptyList();
    L11:
        this(r1, r2, r3);
    }
}
