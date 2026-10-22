package com.ss.android.lark.forwardv2.impl.view;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ss.android.lark.search.widget.ChatPicker;
import com.ss.android.lark.ui.CommonTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class BaseForwardView_ViewBinding implements Unbinder {
    public BaseForwardView a;

    public final void unbind() {
        BaseForwardView r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mTitleBar = null;
        r0.mChatPicker = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public BaseForwardView_ViewBinding(BaseForwardView r4, View r5) {
        this.a = r4;
        r4.mTitleBar = (CommonTitleBar) Utils.findRequiredViewAsType(r5, 2131388928, "field 'mTitleBar'", CommonTitleBar.class);
        r4.mChatPicker = (ChatPicker) Utils.findRequiredViewAsType(r5, 2131373236, "field 'mChatPicker'", ChatPicker.class);
    }
}
