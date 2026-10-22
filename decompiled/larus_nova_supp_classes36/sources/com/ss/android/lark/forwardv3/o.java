package com.ss.android.lark.forwardv3;

import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import z5c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o extends BasePicker.IOnPickNotify {
    public final /* synthetic */ ForwardNewFragment a;

    public final void onChanged(List<String> r2, List<SearchBaseInfo> r3) {
        Intrinsics.checkNotNullParameter(r2, "ids");
        Intrinsics.checkNotNullParameter(r3, "infoList");
    }

    public o(ForwardNewFragment r1) {
        this.a = r1;
    }

    public final void onDeSelected(String r5, SearchBaseInfo r6) {
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r6, "info");
        ForwardV3ViewModel r0 = this.a.f;
        ForwardV3ViewModel r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        Integer r2 = (Integer) r0.getSelectMode().getValue();
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.intValue() != 1) goto L21;
        Log.i("NewForward", "deselect target id: " + r5 + ", type: " + SearchCommonConstants.a(r6.getType()));
        ForwardV3ViewModel r3 = this.a.f;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L13:
        r3.updateMultiItemSelect(r6, false);
        ForwardV3ViewModel r4 = this.a.f;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L18:
        if (r1.getEnableRecentForward() == false) goto L22;
        ForwardNewFragment.U90(this.a, r6, r5, false);
        return;
    L22:
        return;
    L16:
        r1 = r4;
        goto L18
    }

    public final void onSelected(String r9, SearchBaseInfo r10) {
        Intrinsics.checkNotNullParameter(r9, "id");
        Intrinsics.checkNotNullParameter(r10, "info");
        ForwardV3ViewModel r0 = this.a.f;
        ForwardV3ViewModel r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        Integer r1 = (Integer) r0.getSelectMode().getValue();
        if (r1 != null) goto L9;
    L11:
        if (r1 != null) goto L14;
        return;
    L14:
        if (r1.intValue() != 1) goto L28;
        Log.i("NewForward", "select target id: " + r9 + ", type: " + SearchCommonConstants.a(r10.getType()));
        ForwardV3ViewModel r3 = this.a.f;
        if (r3 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L18:
        r3.updateMultiItemSelect(r10, true);
        ForwardV3ViewModel r4 = this.a.f;
        if (r4 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L23:
        if (r2.getEnableRecentForward() == false) goto L25;
        ForwardNewFragment.U90(this.a, r10, r9, true);
    L25:
        boolean r11 = zib.b.d;
        zib.b.a(false, false);
        ForwardNewFragment.W90(this.a, r10, false, r.l);
        return;
    L21:
        r2 = r4;
        goto L23
    L28:
        return;
    L9:
        if (r1.intValue() != 0) goto L11;
        Log.i("NewForward", "show confirm forward dialog from: recent visit\nclick id: " + r9 + ", type: " + SearchCommonConstants.a(r10.getType()) + '\n');
        this.a.ca0(CollectionsKt.mutableListOf(new SearchBaseInfo[]{r10}), "from_normal_select");
        boolean r12 = zib.b.d;
        zib.b.a(true, false);
        ForwardNewFragment.W90(this.a, r10, false, r.l);
    }
}
