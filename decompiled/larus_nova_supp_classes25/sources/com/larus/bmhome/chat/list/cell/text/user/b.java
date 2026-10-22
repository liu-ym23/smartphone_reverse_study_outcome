package com.larus.bmhome.chat.list.cell.text.user;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Drawable a(TextView r2, com.larus.bmhome.chat.markdown.richtext.r r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "resource");
        boolean r0 = r3 instanceof com.larus.bmhome.chat.markdown.richtext.r.d;
        if (r0 == false) goto L5;
    L8:
        int r1 = r2.getCurrentTextColor();
    L9:
        if (r0 == false) goto L12;
        int r4 = 2131242112;
    L15:
        Drawable r5 = ContextCompat.getDrawable(r2.getContext(), r4);
        if (r5 != null) goto L18;
        return null;
    L18:
        Drawable r6 = DrawableCompat.wrap(r5).mutate();
        DrawableCompat.setTint(r6, r1);
        return r6;
    L12:
        if ((r3 instanceof com.larus.bmhome.chat.markdown.richtext.r.b) == false) goto L14;
        r4 = 2131240273;
        goto L15
    L14:
        r4 = 2131241523;
        goto L15
    L5:
        if ((r3 instanceof com.larus.bmhome.chat.markdown.richtext.r.b) == true) goto L8;
        r1 = -13405953;
        goto L9
    }
}
