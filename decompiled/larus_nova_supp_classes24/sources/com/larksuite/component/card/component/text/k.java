package com.larksuite.component.card.component.text;

import android.view.View;
import com.ss.android.lark.widget.span.UrlInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k implements mcc.o {
    public final /* synthetic */ UniversalCardTextLynxUI a;

    public final boolean t(View r2, UrlInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "urlInfo");
        return false;
    }

    public k(UniversalCardTextLynxUI r1) {
        this.a = r1;
    }

    public final void r(View r2, UrlInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "urlInfo");
        UniversalCardTextLynxUI r4 = this.a;
        int r0 = UniversalCardTextLynxUI.g;
        r4.P(r3);
    }
}
