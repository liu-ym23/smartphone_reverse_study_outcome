package com.ss.android.lark.keyboard.editor.input;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class z extends ncc.d {
    public int b;
    public final /* synthetic */ RichTextInputShrinkPlugin c;

    public final void invalidateDrawable(Drawable r3) {
        Intrinsics.checkNotNullParameter(r3, "who");
        if (r3.hashCode() != this.b) goto L6;
        super.invalidateDrawable(r3);
        return;
    L6:
        r3.mutate();
        this.b = r3.hashCode();
        TextView r0 = this.c.T;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("rootMsgTV");
        r0 = null;
    L9:
        r3.setTint(r0.getCurrentTextColor());
        super.invalidateDrawable(r3);
    }

    public z(RichTextInputShrinkPlugin r1, EllipsizedEmojiconTextView r2) {
        this.c = r1;
        super(r2);
    }
}
