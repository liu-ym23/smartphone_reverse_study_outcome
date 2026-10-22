package com.ss.android.lark.picker.config.condition;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0004\u0014\u0015\u0016\u0017B%\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0016J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\u0003\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/ContainMemberIds;", "Lcom/ss/android/lark/picker/config/condition/GroupCondition;", "includes", "", "", "excludes", "<init>", "(Ljava/util/Set;Ljava/util/Set;)V", "getIncludes", "()Ljava/util/Set;", "getExcludes", "isNone", "", "inter", "other", "union", "key", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "getKey", "()Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "NONE", "NEW", "ALL", "Key", "Lcom/ss/android/lark/picker/config/condition/ContainMemberIds$ALL;", "Lcom/ss/android/lark/picker/config/condition/ContainMemberIds$NEW;", "Lcom/ss/android/lark/picker/config/condition/ContainMemberIds$NONE;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class ContainMemberIds implements GroupCondition<ContainMemberIds> {
    private final Set<String> excludes;
    private final Set<String> includes;
    private final Condition.Key<ContainMemberIds> key;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/ContainMemberIds$ALL;", "Lcom/ss/android/lark/picker/config/condition/ContainMemberIds;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class ALL extends ContainMemberIds {
        public static final ALL INSTANCE = null;

        static {
            INSTANCE = new ALL();
        }

        private ALL() {
            super(SetsKt.emptySet(), SetsKt.emptySet(), null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/ContainMemberIds$Key;", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "Lcom/ss/android/lark/picker/config/condition/ContainMemberIds;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Key implements Condition.Key<ContainMemberIds> {
        public static final Key INSTANCE = null;

        static {
            INSTANCE = new Key();
        }

        private Key() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/ContainMemberIds$NEW;", "Lcom/ss/android/lark/picker/config/condition/ContainMemberIds;", "includes", "", "", "excludes", "<init>", "(Ljava/util/Set;Ljava/util/Set;)V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class NEW extends ContainMemberIds {
        public NEW(Set<String> r4, Set<String> r5) {
            Intrinsics.checkNotNullParameter(r4, "includes");
            Intrinsics.checkNotNullParameter(r5, "excludes");
            ArrayList r0 = new ArrayList();
            Iterator<T> r6 = r4.iterator();
        L4:
            if (r6.hasNext() == false) goto L8;
            Object r1 = r6.next();
            if ((!r5.contains((String) r1)) == false) goto L4;
            r0.add(r1);
            goto L4
        L8:
            super(CollectionsKt.toSet(r0), r5, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/ContainMemberIds$NONE;", "Lcom/ss/android/lark/picker/config/condition/ContainMemberIds;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class NONE extends ContainMemberIds {
        public static final NONE INSTANCE = null;

        static {
            INSTANCE = new NONE();
        }

        private NONE() {
            super(SetsKt.emptySet(), SetsKt.emptySet(), null);
        }
    }

    public /* synthetic */ ContainMemberIds(Set r1, Set r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public boolean isNone() {
        return Intrinsics.areEqual(this, NONE.INSTANCE);
    }

    public final Set<String> getExcludes() {
        return this.excludes;
    }

    public final Set<String> getIncludes() {
        return this.includes;
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public Condition.Key<ContainMemberIds> getKey() {
        return this.key;
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public <E extends Condition.Element<E>> E get(Condition.Key<E> r1) {
        return (E) GroupCondition.DefaultImpls.get(this, r1);
    }

    public ContainMemberIds inter(ContainMemberIds r7) {
        Intrinsics.checkNotNullParameter(r7, "other");
        if ((this instanceof NONE) == true) goto L28;
        if ((r7 instanceof NONE) == true) goto L28;
        if ((this instanceof ALL) == false) goto L11;
        return r7;
    L11:
        if ((r7 instanceof ALL) == false) goto L13;
        return this;
    L13:
        Set<String> r0 = this.includes;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L15:
        if (r2.hasNext() == false) goto L19;
        Object r3 = r2.next();
        Set<String> r4 = r7.includes;
        if (r4.contains((String) r3) == false) goto L15;
        r1.add(r3);
        goto L15
    L19:
        Set r5 = CollectionsKt.toSet(r1);
        Set<String> r6 = this.excludes;
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r6.iterator();
    L21:
        if (r9.hasNext() == false) goto L26;
        Object r10 = r9.next();
        Set<String> r11 = r7.excludes;
        if (r11.contains((String) r10) == false) goto L21;
        r8.add(r10);
        goto L21
    L26:
        return new NEW(r5, CollectionsKt.toSet(r8));
    L28:
        return NONE.INSTANCE;
    }

    public ContainMemberIds union(ContainMemberIds r3) {
        Intrinsics.checkNotNullParameter(r3, "other");
        NONE r0 = NONE.INSTANCE;
        if (Intrinsics.areEqual(this, r0) == false) goto L6;
        return r3;
    L6:
        if (Intrinsics.areEqual(r3, r0) == false) goto L8;
        return this;
    L8:
        ALL r1 = ALL.INSTANCE;
        if (Intrinsics.areEqual(this, r1) == false) goto L11;
    L15:
        return r1;
    L11:
        if (Intrinsics.areEqual(r3, r1) == true) goto L15;
        Set r2 = CollectionsKt.toMutableSet(this.includes);
        r2.addAll(r3.includes);
        Set r4 = CollectionsKt.toMutableSet(this.excludes);
        r4.addAll(r3.excludes);
        return new NEW(r2, r4);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element inter(Condition.Element r1) {
        return inter((ContainMemberIds) r1);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element union(Condition.Element r1) {
        return union((ContainMemberIds) r1);
    }

    private ContainMemberIds(Set<String> r1, Set<String> r2) {
        this.includes = r1;
        this.excludes = r2;
        this.key = Key.INSTANCE;
    }
}
