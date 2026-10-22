package com.ss.android.lark.forwardv3.plugins;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.forwardv3.x;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements SearchResultView.IOnBusinessConsumeItem {
    public final /* synthetic */ ForwardCreateGroupChatFragment a;

    public d(ForwardCreateGroupChatFragment r1) {
        this.a = r1;
    }

    public final SearchResultView.CheckBoxBindStatus onBusinessBindItemCheckBox(SearchBaseInfo r7) {
        Intrinsics.checkNotNullParameter(r7, "data");
        ForwardV3ViewModel r0 = this.a.k;
        ForwardV3ViewModel r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        boolean r3 = true;
        if (x.b(r7, r0) == true) goto L21;
        ForwardV3ViewModel r2 = this.a.k;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r2 = null;
    L11:
        if (r2.isDisableByCreateGroupChat(r7) == true) goto L21;
        ForwardV3ViewModel r4 = this.a.k;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r4 = null;
    L16:
        if (r4.disableByInclude(r7) == true) goto L21;
        if (ForwardCreateGroupChatFragment.V90(this.a, r7) == true) goto L21;
        boolean r5 = false;
    L22:
        ForwardV3ViewModel r6 = this.a.k;
        if (r6 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r6 = null;
    L26:
        if (x.c(r7, r6) == true) goto L41;
        ForwardV3ViewModel r8 = this.a.k;
        if (r8 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r8 = null;
    L31:
        if (r8.disableByInclude(r7) == true) goto L41;
        ForwardV3ViewModel r9 = this.a.k;
        if (r9 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L37:
        if (r1.isDisableByCreateGroupChat(r7) == true) goto L41;
        if (ForwardCreateGroupChatFragment.V90(this.a, r7) == true) goto L41;
    L42:
        Log.i("NewForward", "data id: " + r7.getId() + ", type: " + SearchCommonConstants.a(r7.getType()) + "\ndata is consumed by business: " + r5 + "\ndata is enable: " + r3);
        return new SearchResultView.CheckBoxBindStatus(r5, ForwardCreateGroupChatFragment.V90(this.a, r7), r3);
    L35:
        r1 = r9;
    L41:
        r3 = false;
    L21:
        r5 = true;
        goto L22
    }

    public final boolean onBusinessConsumeItemClick(SearchBaseInfo r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        ForwardCreateGroupChatFragment r0 = this.a;
        int r1 = ForwardCreateGroupChatFragment.r;
        r0.getClass();
        StringBuilder r2 = new StringBuilder();
        r2.append("data id: " + r10.getId() + ", type: " + SearchCommonConstants.a(r10.getType()) + '\n');
        ForwardV3ViewModel r3 = r0.k;
        ForwardV3ViewModel r4 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L5:
        boolean r5 = true;
        if (x.a(r10, r3) == false) goto L11;
        r2.append("consume: true, exceed limit\n");
        Context r6 = r0.requireContext();
        ForwardV3ViewModel r7 = r0.k;
        if (r7 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r7 = null;
    L10:
        UDToast.show(r6, y9c.d.j(2131892185, "select_count", String.valueOf(r7.getMaxLimitSelectNum())));
    L39:
        boolean r8 = true;
    L41:
        Log.i("NewForward", r2.toString());
        if (r8 == true) goto L51;
        ForwardV3ViewModel r9 = this.a.k;
        if (r9 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L48:
        if (r4.disableByInclude(r10) == true) goto L51;
        r5 = false;
        goto L51
    L46:
        r4 = r9;
    L51:
        Log.i("NewForward", "create group for forward consume item click: " + r5);
        return r5;
    L11:
        ForwardV3ViewModel r11 = r0.k;
        if (r11 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r11 = null;
    L15:
        if (r11.disable(r10) == false) goto L17;
        r2.append("consume: true, is disabled\n");
        UDToast.show(r0.requireContext(), y9c.d.h(2131892225));
        goto L39
    L17:
        ForwardV3ViewModel r12 = r0.k;
        if (r12 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r12 = null;
    L21:
        if (r12.customDisable(r10) == false) goto L28;
        r2.append("consume: true, custom disable\n");
        ForwardV3ViewModel r13 = r0.k;
        if (r13 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r13 = null;
    L25:
        String r14 = r13.customDisableToastText();
        if (TextUtils.isEmpty(r14) == true) goto L39;
        UDToast.show(r0.requireContext(), r14);
        goto L39
    L28:
        ForwardV3ViewModel r15 = r0.k;
        if (r15 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r15 = null;
    L32:
        if (r15.isDisableByCreateGroupChat(r10) == false) goto L40;
        r2.append("consume: true, createGroupChatDisable\n");
        ForwardV3ViewModel r16 = r0.k;
        if (r16 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r16 = null;
    L36:
        int r17 = r16.createGroupChatDisableToastText(r10);
        if (r17 == 0) goto L39;
        UDToast.show(r0.requireContext(), r17);
        goto L39
    L40:
        r2.append("consume: false\n");
        r8 = false;
        goto L41
    }
}
