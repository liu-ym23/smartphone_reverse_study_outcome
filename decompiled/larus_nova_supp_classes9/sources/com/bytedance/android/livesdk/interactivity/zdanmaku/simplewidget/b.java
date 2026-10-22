package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ PortraitSimpleZDanmakuPresenter a;

    public b(PortraitSimpleZDanmakuPresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        int r4 = i.a;
        StringBuilder r5 = new StringBuilder("history danmaku timeout, residue count: ");
        PortraitSimpleZDanmakuPresenter.IView r0 = ((q46.b) this.a).a;
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.U());
    L6:
        r5.append(r1);
        i.c(r5.toString());
        PortraitSimpleZDanmakuPresenter.IView r6 = ((q46.b) this.a).a;
        if (r6 == null) goto L9;
        r6.ps();
    L9:
        this.a.i0(4);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
