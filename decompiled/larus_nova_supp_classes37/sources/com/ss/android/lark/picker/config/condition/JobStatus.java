package com.ss.android.lark.picker.config.condition;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0016J\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00000\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/JobStatus;", "Lcom/ss/android/lark/picker/config/condition/ChatterCondition;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "ON_JOB", "RESIGNED", "ALL", "key", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "getKey", "()Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "isNone", "", "inter", "other", "union", "Key", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum JobStatus extends Enum<JobStatus> implements ChatterCondition<JobStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ JobStatus[] $VALUES = null;
    public static final JobStatus ALL = null;
    public static final JobStatus NONE = null;
    public static final JobStatus ON_JOB = null;
    public static final JobStatus RESIGNED = null;
    private final Condition.Key<JobStatus> key;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/JobStatus$Key;", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "Lcom/ss/android/lark/picker/config/condition/JobStatus;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Key implements Condition.Key<JobStatus> {
        public static final Key INSTANCE = null;

        static {
            INSTANCE = new Key();
        }

        private Key() {
        }
    }

    private static final /* synthetic */ JobStatus[] $values() {
        return new JobStatus[]{NONE, ON_JOB, RESIGNED, ALL};
    }

    public static EnumEntries<JobStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        NONE = new JobStatus("NONE", 0);
        ON_JOB = new JobStatus("ON_JOB", 1);
        RESIGNED = new JobStatus("RESIGNED", 2);
        ALL = new JobStatus("ALL", 3);
        JobStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static JobStatus[] values() {
        return (JobStatus[]) $VALUES.clone();
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public boolean isNone() {
        if (this != NONE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public Condition.Key<JobStatus> getKey() {
        return this.key;
    }

    public static JobStatus valueOf(String r1) {
        return (JobStatus) a.a(JobStatus.class, r1);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public <E extends Condition.Element<E>> E get(Condition.Key<E> r1) {
        return (E) ChatterCondition.DefaultImpls.get(this, r1);
    }

    public JobStatus inter(JobStatus r3) {
        Intrinsics.checkNotNullParameter(r3, "other");
        JobStatus[] r0 = values();
        int r1 = ordinal();
        return r0[r3.ordinal() & r1];
    }

    public JobStatus union(JobStatus r3) {
        Intrinsics.checkNotNullParameter(r3, "other");
        JobStatus[] r0 = values();
        int r1 = ordinal();
        return r0[r3.ordinal() | r1];
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element inter(Condition.Element r1) {
        return inter((JobStatus) r1);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element union(Condition.Element r1) {
        return union((JobStatus) r1);
    }

    private JobStatus(String r1, int r2) {
        super(r1, r2);
        this.key = Key.INSTANCE;
    }
}
