package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget;

import io.reactivex.functions.Consumer;
import java.util.LinkedList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ PortraitSimpleZDanmakuWidget a;
    public final /* synthetic */ long b;

    public e(PortraitSimpleZDanmakuWidget r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r9) {
        Long r10 = (Long) r9;
        PortraitSimpleZDanmakuWidget r11 = this.a;
        final long r0 = this.b;
        int r2 = PortraitSimpleZDanmakuWidget.p;
        r11.getClass();
        if (i.a() == false) goto L13;
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r3 = r11.c;
        if (r3 == null) goto L13;
        if (r3.c() != 0) goto L13;
        PortraitSimpleZDanmakuPresenter r4 = r11.e;
        if (r4 == null) goto L13;
        if (((LinkedList) r4.e.c).size() != 0) goto L13;
        i.c("player and presenter is empty");
        return;
    L13:
        i.c("onDanmakuTimeout");
        final long r5 = System.currentTimeMillis();
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r6 = r11.c;
        if (r6 == null) goto L16;
        r6.postRunnable(new com.bytedance.live.zdanmaku.h(r6, new PortraitSimpleZDanmakuWidget$onDanmakuTimeout$1(r5, r0), new PortraitSimpleZDanmakuWidget$onDanmakuTimeout$2(r5, r0)));
    L16:
        PortraitSimpleZDanmakuPresenter r13 = r11.e;
        if (r13 == null) goto L21;
        r13.e.n(r0, r5);
        return;
    }
}
