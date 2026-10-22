package com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FuncKeyboardComponent_ViewBinding implements Unbinder {
    public FuncKeyboardComponent a;

    public final void unbind() {
        FuncKeyboardComponent r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mSwitcherContainer = null;
        r0.mMenuContainer = null;
        r0.mRootContainer = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public FuncKeyboardComponent_ViewBinding(FuncKeyboardComponent r4, View r5) {
        this.a = r4;
        r4.mSwitcherContainer = (ConstraintLayout) Utils.findRequiredViewAsType(r5, 2131387893, "field 'mSwitcherContainer'", ConstraintLayout.class);
        r4.mMenuContainer = (FrameLayout) Utils.findRequiredViewAsType(r5, 2131379903, "field 'mMenuContainer'", FrameLayout.class);
        r4.mRootContainer = (ConstraintLayout) Utils.findRequiredViewAsType(r5, 2131373361, "field 'mRootContainer'", ConstraintLayout.class);
    }
}
