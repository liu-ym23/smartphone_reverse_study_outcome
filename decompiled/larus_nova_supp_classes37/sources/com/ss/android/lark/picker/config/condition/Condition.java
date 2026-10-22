package com.ss.android.lark.picker.config.condition;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/Condition;", "", "Key", "Element", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public interface Condition {

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\bf\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002J.\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u000e\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004H\u0096\u0002¢\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\fJ\u0015\u0010\r\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\fJ\b\u0010\u000e\u001a\u00020\u000fH&R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "C", "Lcom/ss/android/lark/picker/config/condition/Condition;", "key", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "getKey", "()Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "get", "E", "(Lcom/ss/android/lark/picker/config/condition/Condition$Key;)Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "inter", "other", "(Lcom/ss/android/lark/picker/config/condition/Condition$Element;)Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "union", "isNone", "", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface Element<C extends Element<C>> extends Condition {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        public static final class DefaultImpls {
            /* JADX WARN: Multi-variable type inference failed */
            public static <C extends Element<C>, E extends Element<E>> E get(Element<C> r1, Key<E> r2) {
                Intrinsics.checkNotNullParameter(r2, "key");
                if (Intrinsics.areEqual(r1.getKey(), r2) == false) goto L5;
                Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type E of com.ss.android.lark.picker.config.condition.Condition.Element.get");
                return r1;
            L5:
                return null;
            }
        }

        <E extends Element<E>> E get(Key<E> r1);

        Key<C> getKey();

        C inter(C r1);

        boolean isNone();

        C union(C r1);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "E", "Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface Key<E extends Element<E>> {
    }
}
