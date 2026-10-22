package com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends ncc.d {
    public int b;
    public final /* synthetic */ int c;

    public final void invalidateDrawable(Drawable r3) {
        Intrinsics.checkNotNullParameter(r3, "who");
        if (r3.hashCode() != this.b) goto L6;
        super.invalidateDrawable(r3);
        return;
    L6:
        r3.mutate();
        this.b = r3.hashCode();
        r3.setTint(this.c);
        super.invalidateDrawable(r3);
    }

    public d(ThreadReplyExposureView r1, int r2) {
        this.c = r2;
        super(r1);
    }
}
