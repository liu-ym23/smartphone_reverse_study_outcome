package com.larus.common.account.platform.larklogin;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class LarkEntryActivityKt$handleLarkEntry$1 extends FunctionReferenceImpl implements Function1<Uri, Boolean> {
    public LarkEntryActivityKt$handleLarkEntry$1(Object r8) {
        super(1, r8, LarkLogin.a.class, "isAuthorizationRedirect", "isAuthorizationRedirect(Landroid/net/Uri;)Z", 0);
    }

    public final Boolean invoke(Uri r2) {
        ((LarkLogin.a) ((CallableReference) this).receiver).getClass();
        return Boolean.valueOf(LarkLogin.h.f(r2));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Uri) r1);
    }
}
