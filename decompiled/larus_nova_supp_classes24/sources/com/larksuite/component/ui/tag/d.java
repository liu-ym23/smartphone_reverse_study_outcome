package com.larksuite.component.ui.tag;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d extends StateListDrawable {
    public final HashMap<int[], Drawable> a;

    public d() {
        this.a = new HashMap(2);
    }

    @Override // android.graphics.drawable.StateListDrawable
    public final void addState(int[] r2, Drawable r3) {
        super.addState(r2, r3);
        if (r2 == null) goto L7;
        if (r3 == null) goto L8;
        this.a.put(r2, r3);
        return;
    L8:
        return;
    }
}
