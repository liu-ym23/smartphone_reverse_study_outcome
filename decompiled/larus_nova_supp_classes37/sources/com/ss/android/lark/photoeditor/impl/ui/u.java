package com.ss.android.lark.photoeditor.impl.ui;

import android.graphics.Bitmap;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class u implements pfc.j.a {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ File b;
    public final /* synthetic */ r c;

    public final void a(Bitmap r2, ArrayList<pfc.f.a> r3) {
        if (r2 != null) goto L5;
        ((PhotoEditorFragment.a) this.c.g).a.finish();
        return;
    L5:
        if (r2 != this.a) goto L7;
        this.c.f.F6(this.b.getAbsolutePath(), this.a);
        return;
    L7:
        this.c.f.L7(r2, r3);
    }

    public u(r r1, Bitmap r2, File r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
