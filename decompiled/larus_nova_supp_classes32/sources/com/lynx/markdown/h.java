package com.lynx.markdown;

import android.graphics.drawable.Drawable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.textra.JavaFontManager;
import com.lynx.textra.TTText;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h {
    public final ArrayList<Drawable> a;
    public final Map<Object, Integer> b;
    public final JavaFontManager c;

    public h() {
        ArrayList<Drawable> r0 = new ArrayList();
        this.a = r0;
        r0.add(null);
        this.b = new Hashtable();
        this.c = TTText.mFontManager;
    }

    public final Drawable a(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < this.a.size()) goto L7;
        return null;
    L7:
        return (Drawable) ListProtector.get(this.a, r2);
    }
}
