package com.bytedance.android.livesdk.interactivity.like;

import com.facebook.drawee.view.SimpleDraweeView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u implements Action {
    public final /* synthetic */ DiggWidget.c a;
    public final /* synthetic */ Disposable b;

    public u(DiggWidget.c r1, Disposable r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        this.b.dispose();
        SimpleDraweeView r0 = this.a.g.e;
        if (r0 == null) goto L6;
        r0.setController(null);
        return;
    }
}
