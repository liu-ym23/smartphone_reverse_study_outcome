package com.ss.android.lark.feed.app.view;

import android.content.Context;
import android.util.AttributeSet;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class AdvanceAvatarView extends LarkAvatarView {
    /* JADX WARN: Multi-variable type inference failed */
    public final void requestLayout() {
        if (getMeasuredWidth() != 0) goto L5;
    L7:
        super/*android.widget.ImageView*/.requestLayout();
        return;
    L5:
        if (getMeasuredHeight() == 0) goto L7;
    }

    public AdvanceAvatarView(Context r1) {
        super(r1);
    }

    public AdvanceAvatarView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public AdvanceAvatarView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
