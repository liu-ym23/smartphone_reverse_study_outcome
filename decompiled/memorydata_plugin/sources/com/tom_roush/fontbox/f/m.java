package com.tom_roush.fontbox.f;

import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class m extends af {
    private int[] c;
    private short[] d;
    private short[] e;
    private int f;

    m(ah r1) {
        super(r1);
    }

    public int a(int r3) {
        int[] r0 = this.c;
        if (r0.length != 0) goto L7;
        return ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
    L7:
        if (r3 >= this.f) goto L11;
        return r0[r3];
    L11:
        return r0[r0.length - 1];
    }

    @Override // com.tom_roush.fontbox.f.af
    void a(ah r8, ad r9) {
        l r0 = r8.n();
        if (r0 == null) goto L22;
        this.f = r0.a();
        int r10 = r8.u();
        int r1 = this.f;
        this.c = new int[r1];
        this.d = new short[r1];
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L5:
        int r5 = this.f;
        if (r3 >= r5) goto L8;
        this.c[r3] = r9.d();
        this.d[r3] = r9.e();
        r4 = r4 + 4;
        r3 = r3 + 1;
        goto L5
    L8:
        int r6 = r10 - r5;
        if (r6 < 0) goto L12;
        r10 = r6;
    L12:
        this.e = new short[r10];
        if (r4 >= h()) goto L19;
    L14:
        if (r2 >= r10) goto L19;
        if (r4 >= h()) goto L18;
        this.e[r2] = r9.e();
        r4 = r4 + 2;
    L18:
        r2 = r2 + 1;
    L19:
        this.f15974a = true;
        return;
    L22:
        throw new IOException("Could not get hmtx table");
    }
}
