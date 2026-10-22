package com.ss.android.lark.picker.config.condition;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.config.condition.ThreadCondition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/ThreadCondition;", "C", "Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public interface ThreadCondition<C extends ThreadCondition<C>> extends Condition.Element<C> {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class DefaultImpls {
        public static <C extends ThreadCondition<C>, E extends Condition.Element<E>> E get(ThreadCondition<C> r1, Condition.Key<E> r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            return (E) Condition.Element.DefaultImpls.get(r1, r2);
        }
    }
}
