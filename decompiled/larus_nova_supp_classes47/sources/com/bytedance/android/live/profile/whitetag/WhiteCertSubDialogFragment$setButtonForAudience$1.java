package com.bytedance.android.live.profile.whitetag;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdk.user.l;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class WhiteCertSubDialogFragment$setButtonForAudience$1 extends FunctionReferenceImpl implements Function1<View, Unit> {
    public WhiteCertSubDialogFragment$setButtonForAudience$1(WhiteCertSubDialogFragment r8) {
        super(1, r8, WhiteCertSubDialogFragment.class, "goToCert", "goToCert(Landroid/view/View;)V", 0);
    }

    public final void invoke(View r5) {
        WhiteCertSubDialogFragment r6 = (WhiteCertSubDialogFragment) ((CallableReference) this).receiver;
        int r0 = WhiteCertSubDialogFragment.j;
        r6.getClass();
        IMiddlewareUserService r1 = k.f(IMiddlewareUserService.class);
        if (r1 == null) goto L10;
        e r2 = r1.user();
        if (r2 == null) goto L10;
        if (r2.isLogin() != true) goto L10;
        r6.T90();
        return;
    L10:
        IMiddlewareUserService r3 = k.f(IMiddlewareUserService.class);
        if (r3 == null) goto L17;
        e r4 = r3.user();
        if (r4 == null) goto L17;
        Context r7 = r6.getContext();
        l.a r8 = new l.a();
        r8.a = s1.B(2131921761);
        r8.e = "live_detail";
        r8.g = "newprofile";
        r8.d = "live";
        r8.c = -1;
        Observable r9 = r4.login(r7, new l(r8));
        if (r9 == null) goto L17;
        Disposable r10 = r9.subscribe(new a(r6), b.a);
    L18:
        r6.i = r10;
        return;
    L17:
        r10 = null;
        goto L18
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((View) r1);
        return Unit.INSTANCE;
    }
}
