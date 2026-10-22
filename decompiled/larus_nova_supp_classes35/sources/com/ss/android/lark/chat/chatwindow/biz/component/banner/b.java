package com.ss.android.lark.chat.chatwindow.biz.component.banner;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void a() {
        a r0 = this.a;
        r0.getClass();
        Log.i("BannerController", "traverseBannerVisibility");
        ArrayList r1 = new ArrayList(((LinkedHashMap) r0.c).values());
        CollectionsKt.sortWith(r1, d.a);
        boolean r3 = false;
        r0.d = 0;
        r0.a.removeAllViews();
        Iterator r2 = r1.iterator();
        int r4 = 0;
    L4:
        if (r2.hasNext() == false) goto L21;
        wya.b r5 = (wya.b) r2.next();
        if (r5.isShown() == false) goto L19;
        if (r5.isEnabled() == false) goto L19;
        if ((r5.e() & r4) != 0) goto L4;
        View r6 = r5.getBanner();
        if (r6 != null) goto L15;
    L18:
        r0.a.addView(r6);
        r0.d |= r5.getType();
        r4 = r4 | (r5.e() | r5.getType());
        Log.d("BannerController", "traverse visible:" + r5.getType() + '/' + r0.d);
        r3 = true;
        goto L4
    L15:
        if (r6.getParent() == null) goto L18;
        ViewParent r7 = r6.getParent();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r7).removeView(r6);
    L19:
        r0.a.removeView(r5.getBanner());
        r0.d &= ~r5.getType();
        Log.d("BannerController", "traverse not visible:" + r5.getType() + '/' + r0.d);
        goto L4
    L21:
        if (r0.e == r3) goto L26;
        if (r3 == false) goto L24;
        r0.b.onShow();
    L25:
        r0.e = r3;
        return;
    L24:
        r0.b.b();
        goto L25
    L26:
        if (r3 == false) goto L39;
        r0.b.a();
        return;
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
