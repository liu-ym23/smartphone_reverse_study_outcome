package com.ss.android.lark.picker.config.condition;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.config.condition.Condition.Element;
import com.ss.android.lark.picker.config.condition.FoldCondition;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KFunction;
import kotlin.reflect.full.KClasses;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0010\b&\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0002*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00002\b\u0012\u0004\u0012\u0002H\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J.\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\u000e\b\u0002\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\tH\u0096\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0002J8\u0010\u0016\u001a\u0002H\u0017\"\u0016\b\u0002\u0010\u0017\u0018\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00170\u00002\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001dJ\u0015\u0010\u001e\u001a\u00028\u00012\u0006\u0010\u001f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00028\u00002\u0006\u0010\"\u001a\u00028\u0000¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00028\u00002\u0006\u0010\"\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010#R*\u0010\u0007\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00028\u00000\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006%"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/FoldCondition;", "C", "Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "F", "", "<init>", "()V", "set", "", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "getSet", "()Ljava/util/Map;", "setSet", "(Ljava/util/Map;)V", "get", "E", "key", "(Lcom/ss/android/lark/picker/config/condition/Condition$Key;)Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "isNone", "", "iterator", "", "inter", "FOLD", "condition0", "condition1", "inter$picker_release", "(Lcom/ss/android/lark/picker/config/condition/Condition$Element;Lcom/ss/android/lark/picker/config/condition/Condition$Element;)Lcom/ss/android/lark/picker/config/condition/FoldCondition;", "interInternal", "(Lcom/ss/android/lark/picker/config/condition/Condition$Element;Lcom/ss/android/lark/picker/config/condition/Condition$Element;)Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "union", "other", "(Lcom/ss/android/lark/picker/config/condition/FoldCondition;)Lcom/ss/android/lark/picker/config/condition/FoldCondition;", "replace", "condition", "(Lcom/ss/android/lark/picker/config/condition/Condition$Element;)Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "replaceSingle", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class FoldCondition<C extends Condition.Element<?>, F extends FoldCondition<C, F>> implements Condition.Element<F>, Iterable<C>, KMappedMarker {
    private Map<Condition.Key<?>, C> set;

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public boolean isNone() {
        Iterator r0 = MapsKt.asSequence(this.set).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if ((!((Condition.Element) ((Map.Entry) r0.next()).getValue()).isNone()) == false) goto L4;
        boolean r1 = true;
    L10:
        return !r1;
    L8:
        r1 = false;
        goto L10
    }

    @Override // java.lang.Iterable
    public Iterator<C> iterator() {
        return this.set.values().iterator();
    }

    public FoldCondition() {
        this.set = new LinkedHashMap();
    }

    public final Map<Condition.Key<?>, C> getSet() {
        return this.set;
    }

    private final C replaceSingle(C r3) {
        this.set.put(r3.getKey(), r3);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type C of com.ss.android.lark.picker.config.condition.FoldCondition");
        return this;
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public <E extends Condition.Element<E>> E get(Condition.Key<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.set.get(r2);
    }

    public final C replace(C r3) {
        Intrinsics.checkNotNullParameter(r3, "condition");
        if ((r3 instanceof FoldCondition) == false) goto L8;
        Iterator r4 = ((Iterable) r3).iterator();
    L6:
        if (r4.hasNext() == false) goto L9;
        Condition.Element r0 = (Condition.Element) r4.next();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type C of com.ss.android.lark.picker.config.condition.FoldCondition");
        replaceSingle(r0);
    L9:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type C of com.ss.android.lark.picker.config.condition.FoldCondition");
        return this;
    L8:
        replaceSingle(r3);
        goto L9
    }

    public final void setSet(Map<Condition.Key<?>, C> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.set = r2;
    }

    public F union(F r2) {
        Intrinsics.checkNotNullParameter(r2, "other");
        throw new IllegalAccessException("Can't union FoldCondition!");
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element union(Condition.Element r1) {
        return union((FoldCondition) r1);
    }

    private final C interInternal(C r6, C r7) {
        Iterator r1 = KClasses.getFunctions(Reflection.getOrCreateKotlinClass(r6.getClass())).iterator();     // Catch: Throwable -> L14
    L5:
        if (r1.hasNext() == false) goto L9;
        Object r2 = r1.next();     // Catch: Throwable -> L14
        if (Intrinsics.areEqual(((KFunction) r2).getName(), "inter") == false) goto L5;
    L10:
        KFunction r3 = (KFunction) r2;     // Catch: Throwable -> L14
        if (r3 == null) goto L22;
        Object r8 = r3.call(new Object[]{r6, r7});     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type C of com.ss.android.lark.picker.config.condition.FoldCondition");     // Catch: Throwable -> L14
        return (C) r8;
    L22:
        return null;
    L9:
        r2 = null;
    L14:
        th = move-exception;
        Log.e("Picker_FoldCondition", th.getMessage(), th);
        return null;
    }

    public final /* synthetic */ <FOLD extends FoldCondition<C, FOLD>> FOLD inter$picker_release(C r8, C r9) {
        Intrinsics.checkNotNullParameter(r8, "condition0");
        Intrinsics.checkNotNullParameter(r9, "condition1");
        Intrinsics.reifiedOperationMarker(3, "FOLD");
        boolean r2 = r8 instanceof FoldCondition;
        if (r2 == true) goto L13;
        Intrinsics.reifiedOperationMarker(3, "FOLD");
        if ((r9 instanceof FoldCondition) == true) goto L13;
        if (Intrinsics.areEqual(r8.getKey(), r9.getKey()) == false) goto L12;
        Condition.Element r10 = access$interInternal(this, r8, r9);
        if (r10 == null) goto L37;
        getSet().put(r10.getKey(), r10);
    L37:
        Intrinsics.reifiedOperationMarker(1, "FOLD");
        return this;
    L12:
        getSet().put(r8.getKey(), r8);
        getSet().put(r9.getKey(), r9);
    L13:
        Intrinsics.reifiedOperationMarker(3, "FOLD");
        if (r2 == false) goto L16;
        Intrinsics.reifiedOperationMarker(1, "FOLD");
        Pair r11 = TuplesKt.to((FoldCondition) r8, r9);
    L17:
        FoldCondition r12 = (FoldCondition) r11.component1();
        Condition.Element r13 = (Condition.Element) r11.component2();
        Iterator<C> r14 = r12.iterator();
    L18:
        Condition.Element r4 = null;
        if (r14.hasNext() == false) goto L28;
        Condition.Element r3 = (Condition.Element) r14.next();
        Condition.Element r5 = r13.get(r3.getKey());
        if ((r5 instanceof Condition.Element) == false) goto L23;
        r4 = r5;
    L23:
        if (r4 == null) goto L26;
        r3 = access$interInternal(this, r3, r4);
    L26:
        if (r3 == null) goto L18;
        getSet().put(r3.getKey(), r3);
        goto L18
    L28:
        Intrinsics.reifiedOperationMarker(3, "FOLD");
        if ((r13 instanceof FoldCondition) == false) goto L32;
        MapsKt.putAll(getSet(), SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence((Iterable) r13), new FoldCondition$inter$2(this)), FoldCondition$inter$3.INSTANCE));
        goto L37
    L32:
        if ((!getSet().containsKey(r13.getKey())) == true) goto L35;
        r13 = null;
    L35:
        if (r13 == null) goto L37;
        getSet().put(r13.getKey(), r13);
        goto L37
    L16:
        Intrinsics.reifiedOperationMarker(1, "FOLD");
        r11 = TuplesKt.to((FoldCondition) r9, r8);
        goto L17
    }

    public static final /* synthetic */ Condition.Element access$interInternal(FoldCondition r0, Condition.Element r1, Condition.Element r2) {
        return r0.interInternal(r1, r2);
    }
}
