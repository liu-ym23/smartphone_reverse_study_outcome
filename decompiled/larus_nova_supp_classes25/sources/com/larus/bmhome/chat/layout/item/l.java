package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l extends g {
    public boolean r;
    public boolean s;

    @Override // com.larus.bmhome.chat.layout.item.i
    public int getBoxType() {
        return super.getBoxType();
    }

    public l(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public void setBoxType(int r1) {
        super.setBoxType(r1);
        if (this.r == false) goto L6;
        setBackground(null);
        return;
    }

    public final void setupDisableBoxBackground(boolean r1) {
        this.r = r1;
        this.d = true;
        setBoxType(getBoxType());
    }

    public final void setupDisableUpdateBoxWidth(boolean r1) {
        this.s = r1;
    }

    @Override // com.larus.bmhome.chat.layout.item.g, com.larus.bmhome.chat.layout.item.i
    public final void l(boolean r2, boolean r3) {
        if (this.s == false) goto L5;
        return;
    L5:
        super.l(r2, r3);
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public final void i(int r3, int r4, int[] r5) {
        Intrinsics.checkNotNullParameter(r5, "outSpec");
        if (this.s == false) goto L13;
        t1a.b r0 = ei9.c.a(this);
        if (r0 == null) goto L9;
        va8.m r1 = r0.getAbility(va8.m.class);
        if (r1 == null) goto L9;
        Fragment r2 = r1.getChatFragment();
    L10:
        Lazy r6 = com.larus.bmhome.utils.z1.a;
        int r7 = com.larus.bmhome.utils.z1.e(r2);
        if (r7 <= 0) goto L13;
        setMaxWidth(r7);
    L9:
        r2 = null;
    L13:
        super.i(r3, r4, r5);
    }
}
