package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends ncc.d {
    public int b;
    public final /* synthetic */ u5b.c c;

    public final void invalidateDrawable(Drawable r3) {
        Intrinsics.checkNotNullParameter(r3, "who");
        if (r3.hashCode() != this.b) goto L6;
        super.invalidateDrawable(r3);
        return;
    L6:
        r3.mutate();
        this.b = r3.hashCode();
        r3.setTint(this.c.b);
        super.invalidateDrawable(r3);
    }

    public a(u5b.c r1, EllipsizedEmojiconTextView r2) {
        this.c = r1;
        super(r2);
    }
}
