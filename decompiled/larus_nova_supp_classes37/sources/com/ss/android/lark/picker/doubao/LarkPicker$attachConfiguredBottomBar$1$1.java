package com.ss.android.lark.picker.doubao;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public /* synthetic */ class LarkPicker$attachConfiguredBottomBar$1$1 extends FunctionReferenceImpl implements Function1<SearchBaseInfo, Unit> {
    public LarkPicker$attachConfiguredBottomBar$1$1(Object r8) {
        super(1, r8, LarkPicker.class, "onSelectedAvatarClick", "onSelectedAvatarClick(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;)V", 0);
    }

    public final void invoke(SearchBaseInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        LarkPicker.access$onSelectedAvatarClick((LarkPicker) ((CallableReference) this).receiver, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((SearchBaseInfo) r1);
        return Unit.INSTANCE;
    }
}
