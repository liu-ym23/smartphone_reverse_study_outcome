package com.ss.android.lark.picker.config.condition;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0005\u0014\u0015\u0016\u0017\u0018B\u0017\b\u0004\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0016J\u0006\u0010\u000e\u001a\u00020\u0000J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\u0004\u0019\u001a\u001b\u001c¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/SharerIds;", "Lcom/ss/android/lark/picker/config/condition/DocCondition;", "Lcom/ss/android/lark/picker/config/condition/WikiCondition;", "ids", "", "", "<init>", "(Ljava/util/Set;)V", "getIds", "()Ljava/util/Set;", "isNone", "", "inter", "other", "negate", "union", "key", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "getKey", "()Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "NONE", "IN", "OUT", "ALL", "Key", "Lcom/ss/android/lark/picker/config/condition/SharerIds$ALL;", "Lcom/ss/android/lark/picker/config/condition/SharerIds$IN;", "Lcom/ss/android/lark/picker/config/condition/SharerIds$NONE;", "Lcom/ss/android/lark/picker/config/condition/SharerIds$OUT;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class SharerIds implements DocCondition<SharerIds>, WikiCondition<SharerIds> {
    public static final Key Key = null;
    private final Set<String> ids;
    private final Condition.Key<SharerIds> key;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/SharerIds$ALL;", "Lcom/ss/android/lark/picker/config/condition/SharerIds;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class ALL extends SharerIds {
        public static final ALL INSTANCE = null;

        static {
            INSTANCE = new ALL();
        }

        private ALL() {
            super(SetsKt.emptySet(), null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/SharerIds$IN;", "Lcom/ss/android/lark/picker/config/condition/SharerIds;", "ids", "", "", "<init>", "(Ljava/util/Set;)V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class IN extends SharerIds {
        public IN(Set<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "ids");
            super(r2, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/SharerIds$Key;", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "Lcom/ss/android/lark/picker/config/condition/SharerIds;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Key implements Condition.Key<SharerIds> {
        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/SharerIds$NONE;", "Lcom/ss/android/lark/picker/config/condition/SharerIds;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class NONE extends SharerIds {
        public static final NONE INSTANCE = null;

        static {
            INSTANCE = new NONE();
        }

        private NONE() {
            super(SetsKt.emptySet(), null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/SharerIds$OUT;", "Lcom/ss/android/lark/picker/config/condition/SharerIds;", "ids", "", "", "<init>", "(Ljava/util/Set;)V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class OUT extends SharerIds {
        public OUT(Set<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "ids");
            super(r2, null);
        }
    }

    static {
        Key = new Key(null);
    }

    public /* synthetic */ SharerIds(Set r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public boolean isNone() {
        return Intrinsics.areEqual(this, NONE.INSTANCE);
    }

    public final SharerIds negate() {
        NONE r0 = NONE.INSTANCE;
        if (Intrinsics.areEqual(this, r0) == false) goto L6;
        return ALL.INSTANCE;
    L6:
        if ((this instanceof IN) == false) goto L9;
        return new OUT(this.ids);
    L9:
        if ((this instanceof OUT) == false) goto L12;
        return new IN(this.ids);
    L12:
        if (Intrinsics.areEqual(this, ALL.INSTANCE) == false) goto L15;
        return r0;
    L15:
        throw new NoWhenBranchMatchedException();
    }

    public final Set<String> getIds() {
        return this.ids;
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public Condition.Key<SharerIds> getKey() {
        return this.key;
    }

    private SharerIds(Set<String> r1) {
        this.ids = r1;
        this.key = Key;
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public <E extends Condition.Element<E>> E get(Condition.Key<E> r1) {
        return (E) DocCondition.DefaultImpls.get(this, r1);
    }

    public SharerIds inter(SharerIds r6) {
        Intrinsics.checkNotNullParameter(r6, "other");
        if ((this instanceof NONE) == true) goto L41;
        if ((r6 instanceof NONE) == true) goto L41;
        if ((this instanceof ALL) == false) goto L11;
        return r6;
    L11:
        if ((r6 instanceof ALL) == false) goto L13;
        return this;
    L13:
        boolean r0 = this instanceof IN;
        if (r0 == false) goto L16;
    L19:
        if (r0 == false) goto L21;
        Pair r7 = TuplesKt.to(this, r6);
    L22:
        SharerIds r1 = (SharerIds) r7.component1();
        SharerIds r8 = (SharerIds) r7.component2();
        if ((r8 instanceof OUT) == false) goto L31;
        Set<String> r2 = r1.ids;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L26:
        if (r4.hasNext() == false) goto L30;
        Object r5 = r4.next();
        if ((!r8.ids.contains((String) r5)) == false) goto L26;
        r3.add(r5);
        goto L26
    L30:
        IN r9 = new IN(CollectionsKt.toSet(r3));
    L39:
        return r9;
    L31:
        Set<String> r10 = r1.ids;
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L33:
        if (r12.hasNext() == false) goto L37;
        Object r13 = r12.next();
        if (r8.ids.contains((String) r13) == false) goto L33;
        r11.add(r13);
        goto L33
    L37:
        r9 = new IN(CollectionsKt.toSet(r11));
        goto L39
    L21:
        r7 = TuplesKt.to(r6, this);
        goto L22
    L16:
        if ((r6 instanceof IN) == true) goto L19;
        LinkedHashSet r14 = new LinkedHashSet();
        r14.addAll(this.ids);
        r14.addAll(r6.ids);
        return new OUT(r14);
    L41:
        return NONE.INSTANCE;
    }

    public SharerIds union(SharerIds r2) {
        Intrinsics.checkNotNullParameter(r2, "other");
        return negate().inter(r2.negate()).negate();
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element inter(Condition.Element r1) {
        return inter((SharerIds) r1);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element union(Condition.Element r1) {
        return union((SharerIds) r1);
    }
}
