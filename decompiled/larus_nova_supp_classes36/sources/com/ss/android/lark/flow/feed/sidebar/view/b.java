package com.ss.android.lark.flow.feed.sidebar.view;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Runnable {
    public final /* synthetic */ ImageView a;
    public final /* synthetic */ Bitmap b;

    public b(FeedSidebarCommonViewHolder r1, ImageView r2, Bitmap r3) {
        this.a = r2;
        this.b = r3;
    }

    public final void a() {
        ImageView r0 = this.a;
        Bitmap r1 = this.b;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        ViewGroup r3 = null;
        r0.setRenderEffect(null);     // Catch: Throwable -> L13
        r0.setImageDrawable(null);     // Catch: Throwable -> L13
        ViewParent r4 = r0.getParent();     // Catch: Throwable -> L13
        if ((r4 instanceof ViewGroup) == false) goto L6;
        r3 = (ViewGroup) r4;     // Catch: Throwable -> L13
    L6:
        if (r3 == null) goto L9;
        r3.removeView(r0);     // Catch: Throwable -> L13
    L9:
        if (r1.isRecycled() == true) goto L11;
        r1.recycle();     // Catch: Throwable -> L13
    L11:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
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
}
