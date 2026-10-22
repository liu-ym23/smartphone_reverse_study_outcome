package com.ss.android.lark.photoeditor.impl.ui;

import android.util.Pair;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k implements Runnable {
    public final /* synthetic */ File a;
    public final /* synthetic */ l b;

    public final void a() {
        if (UIUtils.isActivityRunning(this.b.b.c.a.a) == true) goto L5;
        return;
    L5:
        l r0 = this.b;
        o r1 = r0.b.c.a;
        o.a r2 = r1.f;
        if (r2 != null) goto L8;
        return;
    L8:
        if (this.a != null) goto L10;
        PhotoEditorFragment.b r3 = (PhotoEditorFragment.b) r2;
        r3.a(r0.a.getAbsolutePath(), new Pair(Integer.valueOf(this.b.b.a.getWidth()), Integer.valueOf(this.b.b.a.getHeight())), this.b.b.b);
        return;
    L10:
        if ("from_preview".equals(r1.c) == false) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == false) goto L18;
        b r5 = (b) this.b.b.c.a.getView();
        String r6 = this.a.getAbsolutePath();
        o r7 = this.b.b.c.a;
        r5.v2(r6, r7.d, r7.e, r7.g, r7.h, r7.i, r7.j);
        return;
    L18:
        l r8 = this.b;
        o.a r9 = r8.b.c.a.f;
        PhotoEditorFragment.b r10 = (PhotoEditorFragment.b) r9;
        r10.b(r8.a.getAbsolutePath(), this.a.getAbsolutePath(), new Pair(Integer.valueOf(this.b.b.a.getWidth()), Integer.valueOf(this.b.b.a.getHeight())), this.b.b.b);
        return;
    L12:
        if ("from_screenshot_forward_preview".equals(r1.c) == true) goto L15;
        r4 = false;
        goto L16
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public k(l r1, PolarisFileWrapper r2) {
        this.b = r1;
        this.a = r2;
    }
}
