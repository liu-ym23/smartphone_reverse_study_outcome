package com.larus.dora.impl.device.ailab.keywords;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0013\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0003JF\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/larus/dora/impl/device/ailab/keywords/DoraWakeupKeywords;", "", "errCode", "", "sn", "", "ability", "Lcom/larus/dora/impl/device/ailab/keywords/DoraWakeupKeywordsAbility;", "wakeupKeywords", "", "Lcom/larus/dora/impl/device/ailab/keywords/DoraWakeupKeyword;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/dora/impl/device/ailab/keywords/DoraWakeupKeywordsAbility;Ljava/util/List;)V", "getErrCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSn", "()Ljava/lang/String;", "getAbility", "()Lcom/larus/dora/impl/device/ailab/keywords/DoraWakeupKeywordsAbility;", "getWakeupKeywords", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/dora/impl/device/ailab/keywords/DoraWakeupKeywordsAbility;Ljava/util/List;)Lcom/larus/dora/impl/device/ailab/keywords/DoraWakeupKeywords;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraWakeupKeywords {

    @SerializedName("abilities")
    private final DoraWakeupKeywordsAbility ability;

    @SerializedName("err_code")
    private final Integer errCode;

    @SerializedName("device_sn")
    private final String sn;

    @SerializedName("wakeup_keywords")
    private final List<DoraWakeupKeyword> wakeupKeywords;

    public DoraWakeupKeywords() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DoraWakeupKeywords copy$default(DoraWakeupKeywords r0, Integer r1, String r2, DoraWakeupKeywordsAbility r3, List r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.errCode;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.sn;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.ability;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.wakeupKeywords;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Integer component1() {
        return this.errCode;
    }

    public final String component2() {
        return this.sn;
    }

    public final DoraWakeupKeywordsAbility component3() {
        return this.ability;
    }

    public final List<DoraWakeupKeyword> component4() {
        return this.wakeupKeywords;
    }

    public final DoraWakeupKeywords copy(Integer r2, String r3, DoraWakeupKeywordsAbility r4, List<DoraWakeupKeyword> r5) {
        return new DoraWakeupKeywords(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoraWakeupKeywords) == true) goto L8;
        return false;
    L8:
        DoraWakeupKeywords r6 = (DoraWakeupKeywords) r5;
        if (Intrinsics.areEqual(this.errCode, r6.errCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sn, r6.sn) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ability, r6.ability) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.wakeupKeywords, r6.wakeupKeywords) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.errCode;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.sn;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        DoraWakeupKeywordsAbility r7 = this.ability;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<DoraWakeupKeyword> r10 = this.wakeupKeywords;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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

    public String toString() {
        return "DoraWakeupKeywords(errCode=" + this.errCode + ", sn=" + this.sn + ", ability=" + this.ability + ", wakeupKeywords=" + this.wakeupKeywords + ')';
    }

    public final DoraWakeupKeywordsAbility getAbility() {
        return this.ability;
    }

    public final Integer getErrCode() {
        return this.errCode;
    }

    public final String getSn() {
        return this.sn;
    }

    public final List<DoraWakeupKeyword> getWakeupKeywords() {
        return this.wakeupKeywords;
    }

    public DoraWakeupKeywords(Integer r1, String r2, DoraWakeupKeywordsAbility r3, List<DoraWakeupKeyword> r4) {
        this.errCode = r1;
        this.sn = r2;
        this.ability = r3;
        this.wakeupKeywords = r4;
    }

    public /* synthetic */ DoraWakeupKeywords(Integer r2, String r3, DoraWakeupKeywordsAbility r4, List r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
