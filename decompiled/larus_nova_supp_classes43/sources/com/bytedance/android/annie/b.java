package com.bytedance.android.annie;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.annie.util.ThreadUtils;
import com.bytedance.android.ec.core.utils.FontWeight;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements v9.b {
    public final /* synthetic */ com.bytedance.android.annie.param.a a;
    public final /* synthetic */ AnnieCard b;
    public final /* synthetic */ Uri c;
    public final /* synthetic */ Context d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ String f;

    @Override // v9.b
    public final void onSuccess(String r11) {
        Bundle r0 = this.a.getBundle();
        if (r0 == null) goto L6;
        r0.putLong("resolve_short_link_end", System.currentTimeMillis());
    L6:
        if (this.b.getMReleasedFlag() == false) goto L10;
        this.a.d.e("AnnieInner", this.b + " has released during the redirection of " + this.c + ", resulting in onSuccess() directly return!");
        return;
    L10:
        if (ThreadUtils.b() == true) goto L12;
        this.a.d.e("AnnieInner", this.c + " redirection is returned on sub thread!");
    L12:
        if (r11 != null) goto L14;
    L17:
        boolean r1 = true;
    L18:
        if (r1 == true) goto L21;
        Uri r10 = UriProtector.parse(r11);
        Annie.prefetchAndPreload$annie_release$default(Annie.INSTANCE, this.d, this.a, r10, UriProtector.getQueryParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL), 0, 16, null);
        AnnieCard r12 = this.b;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r11, "longScheme");
        ThreadUtils.c(new com.bytedance.android.annie.card.b(r12, r11));
        return;
    L21:
        if (this.e == false) goto L23;
        this.b.q(new AnnieInner$innerGetHybridCard$1$showErrorPage$1(this.c, this), this.f);
    L23:
        b7.b r13 = this.a.getCommonLifecycle();
        if (r13 == null) goto L28;
        r13.onContainerError(null, FontWeight.WEIGHT_300, this.c + " is redirected to null");
        return;
    L28:
        return;
    L14:
        if (r11.length() == 0) goto L17;
        r1 = false;
        goto L18
    }

    @Override // v9.b
    public final void onFail(int r10, String r11) {
        Bundle r0 = this.a.getBundle();
        if (r0 == null) goto L6;
        r0.putLong("resolve_short_link_end", System.currentTimeMillis());
    L6:
        if (this.e == false) goto L8;
        this.b.q(new AnnieInner$innerGetHybridCard$1$showErrorPage$1(this.c, this), this.f);
    L8:
        this.a.d.a("AnnieInner", "Scheme redirect failed for uri: " + this.c + " with error code: " + r10 + " and error msg: " + r11);
        b7.b r12 = this.a.getCommonLifecycle();
        if (r12 == null) goto L14;
        if (r11 != null) goto L12;
        r11 = "container redirect fail";
    L12:
        r12.onContainerError(null, FontWeight.WEIGHT_300, r11);
        return;
    }

    public b(com.bytedance.android.annie.param.a r1, AnnieCard r10, Uri r11, Context r12, boolean r13, String r14) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }
}
