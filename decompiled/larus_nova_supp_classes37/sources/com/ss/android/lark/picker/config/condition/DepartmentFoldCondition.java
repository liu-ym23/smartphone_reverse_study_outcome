package com.ss.android.lark.picker.config.condition;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0001\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/DepartmentFoldCondition;", "Lcom/ss/android/lark/picker/config/condition/DepartmentCondition;", "Lcom/ss/android/lark/picker/config/condition/FoldCondition;", "<init>", "()V", "key", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "getKey", "()Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "inter", "other", "Key", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DepartmentFoldCondition extends FoldCondition<DepartmentCondition<?>, DepartmentFoldCondition> implements DepartmentCondition<DepartmentFoldCondition> {
    public static final Key Key = null;
    private final Condition.Key<DepartmentFoldCondition> key;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/DepartmentFoldCondition$Key;", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "Lcom/ss/android/lark/picker/config/condition/DepartmentFoldCondition;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Key implements Condition.Key<DepartmentFoldCondition> {
        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Key = new Key(null);
    }

    public DepartmentFoldCondition() {
        this.key = Key;
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public Condition.Key<DepartmentFoldCondition> getKey() {
        return this.key;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DepartmentFoldCondition inter(DepartmentFoldCondition r7) {
        Intrinsics.checkNotNullParameter(r7, "other");
        DepartmentFoldCondition r0 = new DepartmentFoldCondition();
        Pair r8 = TuplesKt.to(this, r7);
        FoldCondition r1 = (FoldCondition) r8.component1();
        Condition.Element r9 = (Condition.Element) r8.component2();
        Iterator<C> r2 = r1.iterator();
    L3:
        Condition.Element r3 = null;
        if (r2.hasNext() == false) goto L14;
        Condition.Element r4 = (Condition.Element) r2.next();
        Condition.Element r5 = r9.get(r4.getKey());
        if ((r5 instanceof Condition.Element) == false) goto L8;
        r3 = r5;
    L8:
        if (r3 == null) goto L11;
        r4 = FoldCondition.access$interInternal(r0, r4, r3);
    L11:
        if (r4 == null) goto L3;
        r0.getSet().put(r4.getKey(), r4);
        goto L3
    L14:
        if ((r9 instanceof DepartmentFoldCondition) == false) goto L17;
        MapsKt.putAll(r0.getSet(), SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence((Iterable) r9), new FoldCondition$inter$2(r0)), FoldCondition$inter$3.INSTANCE));
    L22:
        return r0;
    L17:
        if ((!r0.getSet().containsKey(r9.getKey())) == true) goto L20;
        r9 = null;
    L20:
        if (r9 == null) goto L22;
        r0.getSet().put(r9.getKey(), r9);
        goto L22
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element inter(Condition.Element r1) {
        return inter((DepartmentFoldCondition) r1);
    }
}
