package com.bytedance.android.live.messagewindow.business.presenter;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends b7.a {
    public final /* synthetic */ AbsCommonCardPresenter a;

    public a(AbsCommonCardPresenter r1) {
        this.a = r1;
    }

    public final void onLoadSuccess(View r1) {
        super.onLoadSuccess(r1);
        AbsCommonCardPresenter.a r2 = (AbsCommonCardPresenter.a) ((q46.b) this.a).a;
        if (r2 == null) goto L6;
        r2.CA();
        return;
    }

    public final void onInnerFallback(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "errorMessage");
        super.onInnerFallback(r2, r3);
        AbsCommonCardPresenter.a r0 = (AbsCommonCardPresenter.a) ((q46.b) this.a).a;
        if (r0 == null) goto L6;
        r0.IG(r2, r3);
        return;
    }

    public final void onLoadStart(View r1, boolean r2) {
        super.onLoadStart(r1, r2);
        AbsCommonCardPresenter.a r3 = (AbsCommonCardPresenter.a) ((q46.b) this.a).a;
        if (r3 == null) goto L6;
        r3.yA();
        return;
    }

    public final void onLoadFail(View r1, String r2, String r3) {
        super.onLoadFail(r1, r2, r3);
        AbsCommonCardPresenter.a r4 = (AbsCommonCardPresenter.a) ((q46.b) this.a).a;
        if (r4 == null) goto L6;
        r4.bi(r3);
        return;
    }
}
