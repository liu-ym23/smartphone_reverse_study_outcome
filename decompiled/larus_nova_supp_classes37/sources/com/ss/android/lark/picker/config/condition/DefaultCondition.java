package com.ss.android.lark.picker.config.condition;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\b\u0012\u0004\u0012\u00020\u00000\u00042\b\u0012\u0004\u0012\u00020\u00000\u0005:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0016J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011j\u0002\b\b¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/DefaultCondition;", "Lcom/ss/android/lark/picker/config/condition/ThreadCondition;", "Lcom/ss/android/lark/picker/config/condition/ShieldP2PCondition;", "Lcom/ss/android/lark/picker/config/condition/MailUserCondition;", "Lcom/ss/android/lark/picker/config/condition/MailContactCondition;", "", "<init>", "(Ljava/lang/String;I)V", "ALL", "isNone", "", "inter", "other", "union", "key", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "getKey", "()Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "Key", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum DefaultCondition extends Enum<DefaultCondition> implements ThreadCondition<DefaultCondition>, ShieldP2PCondition<DefaultCondition>, MailUserCondition<DefaultCondition>, MailContactCondition<DefaultCondition> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DefaultCondition[] $VALUES = null;
    public static final DefaultCondition ALL = null;
    private final Condition.Key<DefaultCondition> key;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/DefaultCondition$Key;", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "Lcom/ss/android/lark/picker/config/condition/DefaultCondition;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Key implements Condition.Key<DefaultCondition> {
        public static final Key INSTANCE = null;

        static {
            INSTANCE = new Key();
        }

        private Key() {
        }
    }

    private static final /* synthetic */ DefaultCondition[] $values() {
        return new DefaultCondition[]{ALL};
    }

    public static EnumEntries<DefaultCondition> getEntries() {
        return $ENTRIES;
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public boolean isNone() {
        return false;
    }

    static {
        ALL = new DefaultCondition("ALL", 0);
        DefaultCondition[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static DefaultCondition[] values() {
        return (DefaultCondition[]) $VALUES.clone();
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public Condition.Key<DefaultCondition> getKey() {
        return this.key;
    }

    public static DefaultCondition valueOf(String r1) {
        return (DefaultCondition) a.a(DefaultCondition.class, r1);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public <E extends Condition.Element<E>> E get(Condition.Key<E> r1) {
        return (E) ThreadCondition.DefaultImpls.get(this, r1);
    }

    public DefaultCondition inter(DefaultCondition r3) {
        Intrinsics.checkNotNullParameter(r3, "other");
        DefaultCondition[] r0 = values();
        int r1 = ordinal();
        return r0[r3.ordinal() & r1];
    }

    public DefaultCondition union(DefaultCondition r3) {
        Intrinsics.checkNotNullParameter(r3, "other");
        DefaultCondition[] r0 = values();
        int r1 = ordinal();
        return r0[r3.ordinal() | r1];
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element inter(Condition.Element r1) {
        return inter((DefaultCondition) r1);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element union(Condition.Element r1) {
        return union((DefaultCondition) r1);
    }

    private DefaultCondition(String r1, int r2) {
        super(r1, r2);
        this.key = Key.INSTANCE;
    }
}
