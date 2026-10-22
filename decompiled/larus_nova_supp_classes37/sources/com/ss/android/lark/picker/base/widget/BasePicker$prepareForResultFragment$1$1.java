package com.ss.android.lark.picker.base.widget;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public /* synthetic */ class BasePicker$prepareForResultFragment$1$1 extends FunctionReferenceImpl implements Function1<List<? extends SearchBaseInfo>, Unit> {
    public BasePicker$prepareForResultFragment$1$1(Object r8) {
        super(1, r8, BasePicker.class, "removeData", "removeData(Ljava/util/List;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((List) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(List<? extends SearchBaseInfo> r2) {
        BasePicker.access$removeData((BasePicker) ((CallableReference) this).receiver, r2);
    }
}
