package com.obric.flow.cardlistpage.ui;

import com.obric.flow.cardlistpage.ui.component.feedlist.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CardFeedLayout f11773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f11774c;

    public /* synthetic */ e(CardFeedLayout r5, com.obric.oui.dialog.v2.alert.f r10) {
        this.f11772a = 0;
        this.f11774c = r10;
        this.f11773b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object r5 = this.f11774c;
        CardFeedLayout r10 = this.f11773b;
        switch(this.f11772a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r10, "this$0");
        String r11 = (String) r5;
        Intrinsics.checkNotNullParameter(r11, "$appletId");
        s r12 = r10.C;
        if (r12 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("feedListComponent");
        r12 = null;
    L7:
        r12.f(new com.obric.flow.cardlistpage.ui.component.feedlist.k(r11));
        return;
    L9:
        int r13 = CardFeedLayout.f11536c0;
        com.obric.oui.dialog.v2.alert.f r14 = (com.obric.oui.dialog.v2.alert.f) r5;
        Intrinsics.checkNotNullParameter(r14, "$modal");
        Intrinsics.checkNotNullParameter(r10, "this$0");
        r14.e(r10);
    }

    public /* synthetic */ e(CardFeedLayout r5, String r10) {
        this.f11772a = 1;
        this.f11773b = r5;
        this.f11774c = r10;
    }
}
