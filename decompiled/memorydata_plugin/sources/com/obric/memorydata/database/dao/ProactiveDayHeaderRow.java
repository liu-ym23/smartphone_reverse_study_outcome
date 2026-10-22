package com.obric.memorydata.database.dao;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/database/dao/ProactiveDayHeaderRow;", "", "dayKey", "", "dayStartMillis", "", CommonConsts.COUNT_TYPE, "", "<init>", "(Ljava/lang/String;JI)V", "getDayKey", "()Ljava/lang/String;", "getDayStartMillis", "()J", "getCount", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveDayHeaderRow {
    private final int count;
    private final String dayKey;
    private final long dayStartMillis;

    public ProactiveDayHeaderRow(String r2, long r3, int r5) {
        Intrinsics.checkNotNullParameter(r2, "dayKey");
        this.dayKey = r2;
        this.dayStartMillis = r3;
        this.count = r5;
    }

    public static /* synthetic */ ProactiveDayHeaderRow copy$default(ProactiveDayHeaderRow r0, String r1, long r2, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.dayKey;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.dayStartMillis;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r0.count;
    L12:
        return r0.copy(r1, r2, r4);
    }

    public final String component1() {
        return this.dayKey;
    }

    public final long component2() {
        return this.dayStartMillis;
    }

    public final int component3() {
        return this.count;
    }

    public final ProactiveDayHeaderRow copy(String r1, long r2, int r4) {
        Intrinsics.checkNotNullParameter(r1, "dayKey");
        return new ProactiveDayHeaderRow(r1, r2, r4);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ProactiveDayHeaderRow.class) == true) goto L8;
        return false;
    L8:
        ProactiveDayHeaderRow r10 = (ProactiveDayHeaderRow) ZeusTransformUtils.preCheckCast(r9, ProactiveDayHeaderRow.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.dayKey, r10.dayKey) == true) goto L12;
        return false;
    L12:
        if (this.dayStartMillis == r10.dayStartMillis) goto L15;
        return false;
    L15:
        if (this.count == r10.count) goto L17;
        return false;
    L17:
        return true;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getDayKey() {
        return this.dayKey;
    }

    public final long getDayStartMillis() {
        return this.dayStartMillis;
    }

    public int hashCode() {
        return (((this.dayKey.hashCode() * 31) + Long.hashCode(this.dayStartMillis)) * 31) + Integer.hashCode(this.count);
    }

    public String toString() {
        return "ProactiveDayHeaderRow(dayKey=" + this.dayKey + ", dayStartMillis=" + this.dayStartMillis + ", count=" + this.count + ')';
    }
}
