package com.ss.android.lark.feed.shared.page.guide;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import ujb.d;
import ujb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements d.a {
    public b(a.InterfaceC0205a r1, String r2) {
    }

    public final void a(View r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "delegate");
        heb.a.a.getGuideDependency().c();
        r3.close();
    }
}
