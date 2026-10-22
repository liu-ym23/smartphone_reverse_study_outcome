package com.ss.android.lark.picker.config.condition;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u001dB\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0016J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/TimeRange;", "Lcom/ss/android/lark/picker/config/condition/DocCondition;", "Lcom/ss/android/lark/picker/config/condition/WikiCondition;", "startTime", "", "endTime", "<init>", "(JJ)V", "getStartTime", "()J", "getEndTime", "key", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "getKey", "()Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "inter", "other", "isNone", "", "union", "component1", "component2", "copy", "equals", "", "hashCode", "", "toString", "", "Key", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class TimeRange implements DocCondition<TimeRange>, WikiCondition<TimeRange> {
    public static final Key Key = null;
    private final long endTime;
    private final Condition.Key<TimeRange> key;
    private final long startTime;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/TimeRange$Key;", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "Lcom/ss/android/lark/picker/config/condition/TimeRange;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Key implements Condition.Key<TimeRange> {
        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Key = new Key(null);
    }

    public TimeRange() {
        this(0, 0, 3, null);
    }

    public static /* synthetic */ TimeRange copy$default(TimeRange r0, long r1, long r3, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.startTime;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r0.endTime;
    L9:
        return r0.copy(r1, r3);
    }

    public final long component1() {
        return this.startTime;
    }

    public final long component2() {
        return this.endTime;
    }

    public final TimeRange copy(long r2, long r4) {
        return new TimeRange(r2, r4);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof TimeRange) == true) goto L8;
        return false;
    L8:
        TimeRange r9 = (TimeRange) r8;
        if (this.startTime == r9.startTime) goto L12;
        return false;
    L12:
        if (this.endTime == r9.endTime) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r0 = this.startTime;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.endTime;
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public String toString() {
        return "TimeRange(startTime=" + this.startTime + ", endTime=" + this.endTime + ')';
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public boolean isNone() {
        if (this.startTime <= this.endTime) goto L5;
        return true;
    L5:
        return false;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public Condition.Key<TimeRange> getKey() {
        return this.key;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public <E extends Condition.Element<E>> E get(Condition.Key<E> r1) {
        return (E) DocCondition.DefaultImpls.get(this, r1);
    }

    public TimeRange inter(TimeRange r8) {
        Intrinsics.checkNotNullParameter(r8, "other");
        return new TimeRange(Math.max(this.startTime, r8.startTime), Math.min(this.endTime, r8.endTime));
    }

    public TimeRange union(TimeRange r8) {
        Intrinsics.checkNotNullParameter(r8, "other");
        return new TimeRange(Math.min(this.startTime, r8.startTime), Math.max(this.endTime, r8.endTime));
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element inter(Condition.Element r1) {
        return inter((TimeRange) r1);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element union(Condition.Element r1) {
        return union((TimeRange) r1);
    }

    public TimeRange(long r1, long r3) {
        this.startTime = r1;
        this.endTime = r3;
        this.key = Key;
    }

    public /* synthetic */ TimeRange(long r1, long r3, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r3 = Long.MAX_VALUE;
    L8:
        this(r1, r3);
    }
}
