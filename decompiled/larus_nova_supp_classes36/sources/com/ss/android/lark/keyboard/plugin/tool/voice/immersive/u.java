package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class u extends ncc.d {
    public int b;

    public final void invalidateDrawable(Drawable r3) {
        Intrinsics.checkNotNullParameter(r3, "who");
        if (r3.hashCode() != this.b) goto L6;
        super.invalidateDrawable(r3);
        return;
    L6:
        r3.mutate();
        this.b = r3.hashCode();
        throw null;
    }

    public u(v r1, EllipsizedEmojiconTextView r2) {
        super(r2);
    }
}
