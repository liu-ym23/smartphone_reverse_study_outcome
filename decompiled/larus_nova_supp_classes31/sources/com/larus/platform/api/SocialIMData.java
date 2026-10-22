package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J>\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013¨\u0006\""}, d2 = {"Lcom/larus/platform/api/SocialIMData;", "Ljava/io/Serializable;", "updateTime", "", "desc", "", "redBadge", "", "redBadgeWithoutDoubao", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getUpdateTime", "()Ljava/lang/Long;", "setUpdateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDesc", "()Ljava/lang/String;", "getRedBadge", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRedBadgeWithoutDoubao", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/platform/api/SocialIMData;", "equals", "", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SocialIMData implements Serializable {
    private final String desc;
    private final Integer redBadge;
    private final Integer redBadgeWithoutDoubao;
    private Long updateTime;

    public SocialIMData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SocialIMData copy$default(SocialIMData r0, Long r1, String r2, Integer r3, Integer r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.updateTime;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.desc;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.redBadge;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.redBadgeWithoutDoubao;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Long component1() {
        return this.updateTime;
    }

    public final String component2() {
        return this.desc;
    }

    public final Integer component3() {
        return this.redBadge;
    }

    public final Integer component4() {
        return this.redBadgeWithoutDoubao;
    }

    public final SocialIMData copy(Long r2, String r3, Integer r4, Integer r5) {
        return new SocialIMData(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SocialIMData) == true) goto L8;
        return false;
    L8:
        SocialIMData r6 = (SocialIMData) r5;
        if (Intrinsics.areEqual(this.updateTime, r6.updateTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.desc, r6.desc) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.redBadge, r6.redBadge) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.redBadgeWithoutDoubao, r6.redBadgeWithoutDoubao) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Long r0 = this.updateTime;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.desc;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.redBadge;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.redBadgeWithoutDoubao;
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
        return "SocialIMData(updateTime=" + this.updateTime + ", desc=" + this.desc + ", redBadge=" + this.redBadge + ", redBadgeWithoutDoubao=" + this.redBadgeWithoutDoubao + ')';
    }

    public final String getDesc() {
        return this.desc;
    }

    public final Integer getRedBadge() {
        return this.redBadge;
    }

    public final Integer getRedBadgeWithoutDoubao() {
        return this.redBadgeWithoutDoubao;
    }

    public final Long getUpdateTime() {
        return this.updateTime;
    }

    public final void setUpdateTime(Long r1) {
        this.updateTime = r1;
    }

    public SocialIMData(Long r1, String r2, Integer r3, Integer r4) {
        this.updateTime = r1;
        this.desc = r2;
        this.redBadge = r3;
        this.redBadgeWithoutDoubao = r4;
    }

    public /* synthetic */ SocialIMData(Long r2, String r3, Integer r4, Integer r5, int r6, DefaultConstructorMarker r7) {
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
