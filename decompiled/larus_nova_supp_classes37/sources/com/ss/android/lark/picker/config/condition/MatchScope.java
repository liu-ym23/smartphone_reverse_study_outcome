package com.ss.android.lark.picker.config.condition;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0016J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/MatchScope;", "Lcom/ss/android/lark/picker/config/condition/DocCondition;", "Lcom/ss/android/lark/picker/config/condition/WikiCondition;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "ONLY_TITLE", "ONLY_COMMENT", "ALL", "isNone", "", "inter", "other", "union", "key", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "getKey", "()Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "Key", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MatchScope extends Enum<MatchScope> implements DocCondition<MatchScope>, WikiCondition<MatchScope> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MatchScope[] $VALUES = null;
    public static final MatchScope ALL = null;
    public static final MatchScope NONE = null;
    public static final MatchScope ONLY_COMMENT = null;
    public static final MatchScope ONLY_TITLE = null;
    private final Condition.Key<MatchScope> key;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/MatchScope$Key;", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "Lcom/ss/android/lark/picker/config/condition/MatchScope;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Key implements Condition.Key<MatchScope> {
        public static final Key INSTANCE = null;

        static {
            INSTANCE = new Key();
        }

        private Key() {
        }
    }

    private static final /* synthetic */ MatchScope[] $values() {
        return new MatchScope[]{NONE, ONLY_TITLE, ONLY_COMMENT, ALL};
    }

    public static EnumEntries<MatchScope> getEntries() {
        return $ENTRIES;
    }

    static {
        NONE = new MatchScope("NONE", 0);
        ONLY_TITLE = new MatchScope("ONLY_TITLE", 1);
        ONLY_COMMENT = new MatchScope("ONLY_COMMENT", 2);
        ALL = new MatchScope("ALL", 3);
        MatchScope[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static MatchScope[] values() {
        return (MatchScope[]) $VALUES.clone();
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public boolean isNone() {
        if (this != NONE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public Condition.Key<MatchScope> getKey() {
        return this.key;
    }

    public static MatchScope valueOf(String r1) {
        return (MatchScope) a.a(MatchScope.class, r1);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public <E extends Condition.Element<E>> E get(Condition.Key<E> r1) {
        return (E) DocCondition.DefaultImpls.get(this, r1);
    }

    public MatchScope inter(MatchScope r3) {
        Intrinsics.checkNotNullParameter(r3, "other");
        MatchScope[] r0 = values();
        int r1 = ordinal();
        return r0[r3.ordinal() & r1];
    }

    public MatchScope union(MatchScope r3) {
        Intrinsics.checkNotNullParameter(r3, "other");
        MatchScope[] r0 = values();
        int r1 = ordinal();
        return r0[r3.ordinal() | r1];
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element inter(Condition.Element r1) {
        return inter((MatchScope) r1);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element union(Condition.Element r1) {
        return union((MatchScope) r1);
    }

    private MatchScope(String r1, int r2) {
        super(r1, r2);
        this.key = Key.INSTANCE;
    }
}
