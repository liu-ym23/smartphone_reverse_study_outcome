package com.ss.android.lark.picker.config;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.config.condition.Condition;
import com.ss.android.lark.picker.config.condition.FoldCondition;
import com.ss.android.lark.picker.config.condition.FoldCondition$inter$2;
import com.ss.android.lark.picker.config.condition.FoldCondition$inter$3;
import com.ss.android.lark.picker.config.condition.WikiCondition;
import com.ss.android.lark.picker.config.condition.WikiFoldCondition;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016J!\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0002*\u0006\u0012\u0002\b\u00030\u00022\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0096\u0002¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/picker/config/WikiFilter;", "Lcom/ss/android/lark/picker/config/Filter;", "Lcom/ss/android/lark/picker/config/condition/WikiCondition;", "<init>", "()V", "withDefault", "defaultConditions", "times", "other", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class WikiFilter extends Filter<WikiCondition<?>> {
    @Override // com.ss.android.lark.picker.config.Filter
    public WikiCondition<?> defaultConditions() {
        return null;
    }

    public WikiCondition<?> withDefault(WikiCondition<?> r1) {
        return r1;
    }

    @Override // com.ss.android.lark.picker.config.Filter
    public /* bridge */ /* synthetic */ Condition.Element defaultConditions() {
        return defaultConditions();
    }

    public WikiFilter() {
    }

    @Override // com.ss.android.lark.picker.config.Filter
    public /* bridge */ /* synthetic */ Condition.Element withDefault(Condition.Element r1) {
        return withDefault((WikiCondition) r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WikiCondition<?> times(WikiCondition<?> r6, WikiCondition<?> r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "other");
        WikiFoldCondition r0 = new WikiFoldCondition();
        boolean r1 = r6 instanceof WikiFoldCondition;
        if (r1 == false) goto L5;
    L13:
        if (r1 == false) goto L15;
        Pair r8 = TuplesKt.to((WikiFoldCondition) r6, r7);
    L16:
        FoldCondition r9 = (FoldCondition) r8.component1();
        Condition.Element r10 = (Condition.Element) r8.component2();
        Iterator<C> r11 = r9.iterator();
    L17:
        Condition.Element r2 = null;
        if (r11.hasNext() == false) goto L28;
        Condition.Element r3 = (Condition.Element) r11.next();
        Condition.Element r4 = r10.get(r3.getKey());
        if ((r4 instanceof Condition.Element) == false) goto L22;
        r2 = r4;
    L22:
        if (r2 == null) goto L25;
        r3 = FoldCondition.access$interInternal(r0, r3, r2);
    L25:
        if (r3 == null) goto L17;
        r0.getSet().put(r3.getKey(), r3);
        goto L17
    L28:
        if ((r10 instanceof WikiFoldCondition) == false) goto L31;
        MapsKt.putAll(r0.getSet(), SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence((Iterable) r10), new FoldCondition$inter$2(r0)), FoldCondition$inter$3.INSTANCE));
    L36:
        return r0;
    L31:
        if ((!r0.getSet().containsKey(r10.getKey())) == true) goto L34;
        r10 = null;
    L34:
        if (r10 == null) goto L36;
        r0.getSet().put(r10.getKey(), r10);
        goto L36
    L15:
        r8 = TuplesKt.to((WikiFoldCondition) r7, r6);
        goto L16
    L5:
        if ((r7 instanceof WikiFoldCondition) == true) goto L13;
        if (Intrinsics.areEqual(r6.getKey(), r7.getKey()) == false) goto L12;
        Condition.Element r12 = FoldCondition.access$interInternal(r0, r6, r7);
        if (r12 == null) goto L36;
        r0.getSet().put(r12.getKey(), r12);
        goto L36
    L12:
        r0.getSet().put(r6.getKey(), r6);
        r0.getSet().put(r7.getKey(), r7);
        goto L36
    }

    @Override // com.ss.android.lark.picker.config.Filter
    public /* bridge */ /* synthetic */ Condition.Element times(Condition.Element r1, Condition.Element r2) {
        return times((WikiCondition) r1, (WikiCondition) r2);
    }
}
