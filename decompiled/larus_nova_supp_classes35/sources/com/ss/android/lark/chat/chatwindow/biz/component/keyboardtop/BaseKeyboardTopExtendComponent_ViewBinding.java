package com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ss.android.lark.view.SizeDetectConstraintLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class BaseKeyboardTopExtendComponent_ViewBinding implements Unbinder {
    public BaseKeyboardTopExtendComponent a;

    public final void unbind() {
        BaseKeyboardTopExtendComponent r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mTimeZoneContainer = null;
        r0.mButtonExtendContainer = null;
        r0.mTextExtendContainer = null;
        r0.mRootLayout = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public BaseKeyboardTopExtendComponent_ViewBinding(BaseKeyboardTopExtendComponent r4, View r5) {
        this.a = r4;
        r4.mTimeZoneContainer = (ViewGroup) Utils.findRequiredViewAsType(r5, 2131372867, "field 'mTimeZoneContainer'", ViewGroup.class);
        r4.mButtonExtendContainer = (FrameLayout) Utils.findRequiredViewAsType(r5, 2131365015, "field 'mButtonExtendContainer'", FrameLayout.class);
        r4.mTextExtendContainer = (FrameLayout) Utils.findRequiredViewAsType(r5, 2131388433, "field 'mTextExtendContainer'", FrameLayout.class);
        r4.mRootLayout = (SizeDetectConstraintLayout) Utils.findRequiredViewAsType(r5, 2131384822, "field 'mRootLayout'", SizeDetectConstraintLayout.class);
    }
}
