package com.suite.lark.platform.feature.forward.doubao;

import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m extends BasePicker.IOnPickNotify {
    public final /* synthetic */ DoubaoForwardFragment a;

    public final void onChanged(List<String> r2, List<SearchBaseInfo> r3) {
        Intrinsics.checkNotNullParameter(r2, "ids");
        Intrinsics.checkNotNullParameter(r3, "infoList");
    }

    public m(DoubaoForwardFragment r1) {
        this.a = r1;
    }

    public final void onDeSelected(String r2, SearchBaseInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "info");
        ForwardV3ViewModel r4 = this.a.e;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r4 = null;
    L5:
        r4.updateMultiItemSelect(r3, false);
    }

    public final void onSelected(String r3, SearchBaseInfo r4) {
        Intrinsics.checkNotNullParameter(r3, "id");
        Intrinsics.checkNotNullParameter(r4, "info");
        ForwardV3ViewModel r5 = this.a.e;
        tib.e r1 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r5 = null;
    L5:
        Integer r6 = (Integer) r5.getSelectMode().getValue();
        if (r6 != null) goto L9;
    L14:
        ForwardV3ViewModel r7 = this.a.e;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r7 = null;
    L17:
        r7.updateMultiItemSelect(r4, true);
        DoubaoForwardFragment r8 = this.a;
        tib.e r9 = r8.f;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
    L21:
        r1.h();
        KeyboardUtils.hideKeyboard(r8.requireActivity());
        return;
    L20:
        r1 = r9;
        goto L21
    L9:
        if (r6.intValue() != 0) goto L14;
        ForwardV3ViewModel r10 = this.a.e;
        if (r10 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r10 = null;
    L13:
        r10.clearSelectedItem();
        goto L14
    }
}
