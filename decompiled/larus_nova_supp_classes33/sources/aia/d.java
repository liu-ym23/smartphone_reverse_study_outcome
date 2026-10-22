package aia;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.obric.assistant.interaction.api.window.IWindowContextKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(View r3, View r4) {
        if (r3 == null) goto L5;
        int r1 = r3.getPaddingBottom();
    L6:
        if (r1 > 0) goto L24;
        if (r3 == null) goto L13;
        Context r5 = r3.getContext();
        if (r5 == null) goto L13;
        boolean r2 = true;
        if (IWindowContextKt.isWindowContext(r5) != true) goto L13;
    L14:
        if (r2 == false) goto L24;
        if (r4 == null) goto L25;
        ViewGroup.LayoutParams r6 = r4.getLayoutParams();
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
    L21:
        if (r7 != null) goto L23;
        return 0;
    L23:
        return r7.bottomMargin;
    L20:
        r7 = null;
        goto L21
    L25:
        return 0;
    L13:
        r2 = false;
    L24:
        return r1;
    L5:
        r1 = 0;
        goto L6
    }
}
