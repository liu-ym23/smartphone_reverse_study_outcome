package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l0 implements TextView.OnEditorActionListener {
    public final /* synthetic */ TalkRoomSearchFragment a;

    public l0(TalkRoomSearchFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r5, int r6, KeyEvent r7) {
        TalkRoomSearchFragment r8 = this.a;
        if (r6 != 3) goto L43;
        EditText r9 = r8.k;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("searchEt");
    L8:
        if (r9.getText().length() <= 0) goto L10;
        boolean r10 = true;
    L11:
        if (r10 == false) goto L41;
        r8.da0();
        Activity r11 = ContextUtil.contextToActivity(r8.getContext());
        Object r3 = null;
        if (r11 == null) goto L15;
        Object r12 = r11.getSystemService("input_method");
    L17:
        if ((r12 instanceof InputMethodManager) == false) goto L28;
        Activity r13 = ContextUtil.contextToActivity(r8.getContext());
        if (r13 == null) goto L21;
        r3 = r13.getSystemService("input_method");
    L21:
        if (r3 == null) goto L27;
        InputMethodManager r4 = (InputMethodManager) r3;
        EditText r14 = r8.k;
        if (r14 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("searchEt");
    L25:
        r4.hideSoftInputFromWindow(r14.getWindowToken(), 0);
        goto L28
    L27:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    L28:
        n0 r15 = r8.i;
        if (r15 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L31:
        yz0.g r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.g.class);
        if (r0 == null) goto L36;
        IRoomBase r1 = r0.getRoom();
        if (r1 == null) goto L36;
        long r2 = IRoomKtKt.getId(r1);
    L37:
        EditText r16 = r8.k;
        if (r16 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("searchEt");
    L40:
        r15.e(r2, r16.getText().toString(), r8.r);
    L42:
        return true;
    L36:
        r2 = 0;
        goto L37
    L15:
        r12 = null;
        goto L17
    L41:
        f2.c("请输入用户名字/抖音号", 0);
        goto L42
    L10:
        r10 = false;
        goto L11
    L43:
        int r17 = TalkRoomSearchFragment.t;
        r8.getClass();
        return false;
    }
}
