package com.ss.android.lark.filedetail.impl.detail.menu;

import android.content.Context;
import com.ss.android.lark.filedetail.impl.open.OpenFileInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements d {
    public final /* synthetic */ OpenFileInfo a;
    public final /* synthetic */ Context b;

    @Override // com.ss.android.lark.filedetail.impl.detail.menu.d
    public final void v() {
        hfb.b.d r0 = a.a;
        a.a(this.b, this.a);
    }

    @Override // com.ss.android.lark.filedetail.impl.detail.menu.d
    public final boolean w() {
        String r0 = this.a.threadId;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L14;
        hfb.b.d r2 = a.a;
        if (r2 == null) goto L19;
        String r3 = this.a.threadId;
        r2.h();
    L19:
        return true;
    L14:
        if (this.a.mJumpPosition != (-1)) goto L16;
        return false;
    L16:
        hfb.b.d r4 = a.a;
        if (r4 == null) goto L19;
        r4.f();
        goto L19
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public b(OpenFileInfo r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }
}
