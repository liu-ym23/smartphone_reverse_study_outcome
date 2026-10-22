package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends ncc.d {
    public int b;
    public final /* synthetic */ u5b.b c;

    public a(EllipsizedEmojiconTextView r2) {
        this.c = u5b.b.e;
        super(r2);
    }

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
}
