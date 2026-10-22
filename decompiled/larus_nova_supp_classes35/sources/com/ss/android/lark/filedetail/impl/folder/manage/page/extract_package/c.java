package com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package;

import android.view.View;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements Runnable {
    public final /* synthetic */ ExtractPackageFragment a;

    public c(ExtractPackageFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ExtractPackageFragment r0 = this.a;     // Catch: Throwable -> L14
        if (r0.n != 2) goto L17;
        CircularProgressDrawable r1 = r0.m;     // Catch: Throwable -> L14
        View r2 = null;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");     // Catch: Throwable -> L14
        r1 = null;
    L8:
        r1.start();     // Catch: Throwable -> L14
        View r3 = this.a.k;     // Catch: Throwable -> L14
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");     // Catch: Throwable -> L14
    L12:
        r2.setVisibility(0);     // Catch: Throwable -> L14
        return;
    L11:
        r2 = r3;
        goto L12
    L17:
        return;
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    }
}
