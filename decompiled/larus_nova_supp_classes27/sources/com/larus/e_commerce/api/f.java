package com.larus.e_commerce.api;

import android.net.Uri;
import android.util.Log;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.share.api.IShareService;
import com.larus.share.service.e;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ ECommerceRouterInterceptor a;
    public final /* synthetic */ IShareService b;
    public final /* synthetic */ FragmentActivity c;
    public final /* synthetic */ e d;
    public final /* synthetic */ g e;
    public final /* synthetic */ Uri f;

    public /* synthetic */ f(ECommerceRouterInterceptor r1, IShareService r2, FragmentActivity r3, e r4, g r5, Uri r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECommerceRouterInterceptor r0 = this.a;
        IShareService r1 = this.b;
        FragmentActivity r2 = this.c;
        e r3 = this.d;
        g r6 = this.e;
        Uri r10 = this.f;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L9
        DialogFragment r5 = IShareService.a.g(r1, r2, r3.a, r3.b, r3.c, r6, null, false, 224);     // Catch: Throwable -> L9
        if (r5 == null) goto L6;
        String r7 = r5.getClass().getName();     // Catch: Throwable -> L9
    L7:
        Object r8 = Result.constructor-impl(Integer.valueOf(Log.i("ECommerceRouterInterceptor", "[saas_share_panel] showSharePanel(UI) returned dialog=".concat(r7))));     // Catch: Throwable -> L9
    L12:
        if (Result.exceptionOrNull-impl(r8) == null) goto L17;
        r0.getClass();
        ECommerceRouterInterceptor.k(r10);
        return;
    L17:
        return;
    L6:
        r7 = "null";
    L9:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
