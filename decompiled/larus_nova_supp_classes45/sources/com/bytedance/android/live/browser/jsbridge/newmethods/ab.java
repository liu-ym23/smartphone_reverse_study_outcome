package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.auth.IAuthGuideService;
import com.bytedance.android.livesdkapi.auth.INewAuthReport;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ab<T> implements sy.a {
    public final /* synthetic */ za a;
    public final /* synthetic */ za.b b;

    public ab(za r1, za.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // sy.a
    public final void invoke(Object r7) {
        String r8 = (String) r7;
        za r0 = this.a;
        za.b r1 = this.b;
        r0.getClass();
        boolean r3 = false;
        if (StringsKt.equals$default(r1.a(), "pop_click", false, 2, null) == false) goto L8;
        if (Intrinsics.areEqual(r1.b(), "other_aweme_account") == false) goto L8;
    L10:
        INewAuthReport r9 = jc1.k.n(IAuthGuideService.class).report();
        String r2 = this.b.a();
        if (r2 == null) goto L28;
        int r4 = r2.hashCode();
        if (r4 == (-1257301478)) goto L22;
        if (r4 == 652651563) goto L19;
        return;
    L19:
        if (r2.equals("pop_show") == false) goto L25;
        r9.logAuthDialogShow(r3, this.b.c());
        return;
    L25:
        return;
    L22:
        if (r2.equals("pop_click") == false) goto L27;
        r9.logAuthDialogClick(r3, this.b.b(), this.b.c());
        return;
    L27:
        return;
    L28:
        return;
    L8:
        if (r8.length() <= 0) goto L10;
        r3 = true;
        goto L10
    }
}
