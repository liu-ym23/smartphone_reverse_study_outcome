package h7a;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public ViewParent a;
    public ViewParent b;
    public final View c;
    public boolean d;
    public int[] e;

    public d(View r1) {
        this.c = r1;
    }

    public final ViewParent a(int r1) {
        if (r1 != 0) goto L5;
        return this.a;
    L5:
        return this.b;
    }
}
