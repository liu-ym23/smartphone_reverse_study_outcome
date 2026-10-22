package com.ss.android.lark.picker.config;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.config.Extra;
import com.ss.android.lark.picker.config.Filter;
import com.ss.android.lark.picker.config.condition.Condition;
import com.ss.android.lark.picker.config.condition.Condition.Element;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@PickerMaker
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u0004*\b\b\u0002\u0010\u0005*\u00020\u00062\u00020\u0007J!\u0010\b\u001a\u00020\u000e2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\u0002\b\u0011H\u0016J!\u0010\u000b\u001a\u00020\u000e2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\u0002\b\u0011H\u0016R\u0012\u0010\b\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00028\u0002X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/picker/config/Entity;", "C", "Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "F", "Lcom/ss/android/lark/picker/config/Filter;", "E", "Lcom/ss/android/lark/picker/config/Extra;", "", "filter", "getFilter", "()Lcom/ss/android/lark/picker/config/Filter;", "extra", "getExtra", "()Lcom/ss/android/lark/picker/config/Extra;", "", "init", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public interface Entity<C extends Condition.Element<?>, F extends Filter<C>, E extends Extra> {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class DefaultImpls {
        public static <C extends Condition.Element<?>, F extends Filter<C>, E extends Extra> void extra(Entity<C, F, E> r1, Function1<? super E, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "init");
            r2.invoke(r1.getExtra());
        }

        public static <C extends Condition.Element<?>, F extends Filter<C>, E extends Extra> void filter(Entity<C, F, E> r1, Function1<? super F, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "init");
            r2.invoke(r1.getFilter());
        }
    }

    void extra(Function1<? super E, Unit> r1);

    void filter(Function1<? super F, Unit> r1);

    E getExtra();

    F getFilter();
}
