package com.ss.android.lark.picker.config.condition;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0016J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/Tenant;", "Lcom/ss/android/lark/picker/config/condition/ChatterCondition;", "Lcom/ss/android/lark/picker/config/condition/GroupCondition;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "IN", "OUT", "ALL", "isNone", "", "inter", "other", "union", "key", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "getKey", "()Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "Key", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum Tenant extends Enum<Tenant> implements ChatterCondition<Tenant>, GroupCondition<Tenant> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ Tenant[] $VALUES = null;
    public static final Tenant ALL = null;
    public static final Tenant IN = null;
    public static final Tenant NONE = null;
    public static final Tenant OUT = null;
    private final Condition.Key<Tenant> key;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/Tenant$Key;", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "Lcom/ss/android/lark/picker/config/condition/Tenant;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Key implements Condition.Key<Tenant> {
        public static final Key INSTANCE = null;

        static {
            INSTANCE = new Key();
        }

        private Key() {
        }
    }

    private static final /* synthetic */ Tenant[] $values() {
        return new Tenant[]{NONE, IN, OUT, ALL};
    }

    public static EnumEntries<Tenant> getEntries() {
        return $ENTRIES;
    }

    static {
        NONE = new Tenant("NONE", 0);
        IN = new Tenant("IN", 1);
        OUT = new Tenant("OUT", 2);
        ALL = new Tenant("ALL", 3);
        Tenant[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static Tenant[] values() {
        return (Tenant[]) $VALUES.clone();
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public boolean isNone() {
        if (this != NONE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public Condition.Key<Tenant> getKey() {
        return this.key;
    }

    public static Tenant valueOf(String r1) {
        return (Tenant) a.a(Tenant.class, r1);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public <E extends Condition.Element<E>> E get(Condition.Key<E> r1) {
        return (E) ChatterCondition.DefaultImpls.get(this, r1);
    }

    public Tenant inter(Tenant r3) {
        Intrinsics.checkNotNullParameter(r3, "other");
        Tenant[] r0 = values();
        int r1 = ordinal();
        return r0[r3.ordinal() & r1];
    }

    public Tenant union(Tenant r3) {
        Intrinsics.checkNotNullParameter(r3, "other");
        Tenant[] r0 = values();
        int r1 = ordinal();
        return r0[r3.ordinal() | r1];
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element inter(Condition.Element r1) {
        return inter((Tenant) r1);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element union(Condition.Element r1) {
        return union((Tenant) r1);
    }

    private Tenant(String r1, int r2) {
        super(r1, r2);
        this.key = Key.INSTANCE;
    }
}
