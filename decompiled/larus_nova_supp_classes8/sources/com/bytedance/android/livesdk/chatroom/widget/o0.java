package com.bytedance.android.livesdk.chatroom.widget;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o0<T> implements Consumer {
    public final /* synthetic */ LiveGiftMenuStickerServiceWidget a;

    public o0(LiveGiftMenuStickerServiceWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        zg1.p r7 = (zg1.p) r6;
        if (Intrinsics.areEqual(r7.a, "zongyiyouxi") == true) goto L5;
        return;
    L5:
        if (r7.c == true) goto L13;
        LiveGiftMenuStickerServiceWidget r0 = this.a;
        List<LiveGiftMenuStickerServiceWidget.a> r1 = r0.b;
        ArrayList r2 = new ArrayList();
        Iterator r3 = ((ArrayList) r1).iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        Object r4 = r3.next();
        if (((LiveGiftMenuStickerServiceWidget.a) r4).b == false) goto L8;
        r2.add(r4);
        goto L8
    L12:
        ((ArrayList) r0.b).clear();
        ((ArrayList) r0.b).addAll(r2);
    L13:
        List<LiveGiftMenuStickerServiceWidget.a> r5 = this.a.b;
        ArrayList r8 = (ArrayList) r5;
        r8.add(new LiveGiftMenuStickerServiceWidget.a(r7));
        this.a.zq();
    }
}
