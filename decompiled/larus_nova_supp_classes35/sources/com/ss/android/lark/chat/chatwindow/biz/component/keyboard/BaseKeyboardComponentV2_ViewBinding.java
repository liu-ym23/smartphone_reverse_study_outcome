package com.ss.android.lark.chat.chatwindow.biz.component.keyboard;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class BaseKeyboardComponentV2_ViewBinding implements Unbinder {
    public BaseKeyboardComponentV2 a;

    public final void unbind() {
        BaseKeyboardComponentV2 r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mKeyboardContainer = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public BaseKeyboardComponentV2_ViewBinding(BaseKeyboardComponentV2 r4, View r5) {
        this.a = r4;
        r4.mKeyboardContainer = (FrameLayout) Utils.findRequiredViewAsType(r5, 2131365617, "field 'mKeyboardContainer'", FrameLayout.class);
    }
}
