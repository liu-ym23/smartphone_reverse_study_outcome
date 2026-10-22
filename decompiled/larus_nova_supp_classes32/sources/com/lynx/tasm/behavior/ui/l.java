package com.lynx.tasm.behavior.ui;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l {
    public final ViewGroup a;
    public int b;
    public int[] c;

    public class a implements Comparator<View> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(View r2, View r3) {
            View r4 = r3;
            Integer r5 = UIGroup.getViewZIndex(r2);
            Integer r0 = 0;
            if (r5 != null) goto L5;
            r5 = r0;
        L5:
            Integer r6 = UIGroup.getViewZIndex(r4);
            if (r6 == null) goto L10;
            r0 = r6;
        L10:
            return r5.intValue() - r0.intValue();
        }
    }

    public void update() {
        int r0 = 0;
        this.b = 0;
    L4:
        if (r0 >= this.a.getChildCount()) goto L9;
        if (UIGroup.getViewZIndex(this.a.getChildAt(r0)) == null) goto L8;
        this.b++;
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        this.c = null;
    }

    public final void a() {
        int r0 = this.a.getChildCount();
        if (this.c != null) goto L10;
        ArrayList r1 = new ArrayList();
        int r2 = 0;
        int r3 = 0;
    L5:
        if (r3 >= r0) goto L7;
        r1.add(this.a.getChildAt(r3));
        r3 = r3 + 1;
        goto L5
    L7:
        Collections.sort(r1, new a());
        this.c = new int[r0];
    L8:
        if (r2 >= r0) goto L13;
        View r4 = (View) ListProtector.get(r1, r2);
        this.c[r2] = this.a.indexOfChild(r4);
        r2 = r2 + 1;
        goto L8
    L13:
        return;
    }

    public l(ViewGroup r2) {
        this.b = 0;
        this.a = r2;
    }
}
