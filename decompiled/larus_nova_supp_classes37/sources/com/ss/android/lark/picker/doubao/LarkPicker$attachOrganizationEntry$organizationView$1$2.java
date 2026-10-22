package com.ss.android.lark.picker.doubao;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public /* synthetic */ class LarkPicker$attachOrganizationEntry$organizationView$1$2 extends FunctionReferenceImpl implements Function2<SearchBaseInfo, Boolean, Unit> {
    public LarkPicker$attachOrganizationEntry$organizationView$1$2(Object r8) {
        super(2, r8, LarkPicker.class, "handleOrganizationItemClick", "handleOrganizationItemClick(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;Z)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((SearchBaseInfo) r1, ((Boolean) r2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(SearchBaseInfo r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        LarkPicker.access$handleOrganizationItemClick((LarkPicker) ((CallableReference) this).receiver, r2, r3);
    }
}
