package com.ss.android.lark.picker.config.condition;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0016J\u0010\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rj\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/ManageStatus;", "Lcom/ss/android/lark/picker/config/condition/GroupCondition;", "Lcom/ss/android/lark/picker/config/condition/DepartmentCondition;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "MY_MANAGE", "NOT_MY_MANAGE", "ALL", "key", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "getKey", "()Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "isNone", "", "inter", "other", "union", "Key", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum ManageStatus extends Enum<ManageStatus> implements GroupCondition<ManageStatus>, DepartmentCondition<ManageStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ManageStatus[] $VALUES = null;
    public static final ManageStatus ALL = null;
    public static final ManageStatus MY_MANAGE = null;
    public static final ManageStatus NONE = null;
    public static final ManageStatus NOT_MY_MANAGE = null;
    private final Condition.Key<ManageStatus> key;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/ManageStatus$Key;", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "Lcom/ss/android/lark/picker/config/condition/ManageStatus;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Key implements Condition.Key<ManageStatus> {
        public static final Key INSTANCE = null;

        static {
            INSTANCE = new Key();
        }

        private Key() {
        }
    }

    private static final /* synthetic */ ManageStatus[] $values() {
        return new ManageStatus[]{NONE, MY_MANAGE, NOT_MY_MANAGE, ALL};
    }

    public static EnumEntries<ManageStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        NONE = new ManageStatus("NONE", 0);
        MY_MANAGE = new ManageStatus("MY_MANAGE", 1);
        NOT_MY_MANAGE = new ManageStatus("NOT_MY_MANAGE", 2);
        ALL = new ManageStatus("ALL", 3);
        ManageStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static ManageStatus[] values() {
        return (ManageStatus[]) $VALUES.clone();
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public boolean isNone() {
        if (this != NONE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public Condition.Key<ManageStatus> getKey() {
        return this.key;
    }

    public static ManageStatus valueOf(String r1) {
        return (ManageStatus) a.a(ManageStatus.class, r1);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public <E extends Condition.Element<E>> E get(Condition.Key<E> r1) {
        return (E) GroupCondition.DefaultImpls.get(this, r1);
    }

    public ManageStatus inter(ManageStatus r3) {
        Intrinsics.checkNotNullParameter(r3, "other");
        ManageStatus[] r0 = values();
        int r1 = ordinal();
        return r0[r3.ordinal() & r1];
    }

    public ManageStatus union(ManageStatus r3) {
        Intrinsics.checkNotNullParameter(r3, "other");
        ManageStatus[] r0 = values();
        int r1 = ordinal();
        return r0[r3.ordinal() | r1];
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element inter(Condition.Element r1) {
        return inter((ManageStatus) r1);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element union(Condition.Element r1) {
        return union((ManageStatus) r1);
    }

    private ManageStatus(String r1, int r2) {
        super(r1, r2);
        this.key = Key.INSTANCE;
    }
}
