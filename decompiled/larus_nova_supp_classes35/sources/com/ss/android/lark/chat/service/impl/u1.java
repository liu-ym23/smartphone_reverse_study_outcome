package com.ss.android.lark.chat.service.impl;

import com.ss.android.lark.image.entity.Image;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.Collections;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class u1 implements ObservableOnSubscribe<Image> {
    public final /* synthetic */ dcb.a a;

    public u1(dcb.a r1) {
        this.a = r1;
    }

    public final void subscribe(ObservableEmitter<Image> r5) throws Exception {
        int[] r0 = com.ss.android.lark.utils.p.g(this.a.a);
        int r1 = r0[0];
        int r2 = 80;
        if (r1 > 0) goto L5;
        r1 = 80;
    L5:
        int r3 = r0[1];
        if (r3 <= 0) goto L9;
        r2 = r3;
    L9:
        Image r4 = new Image();
        r4.setWidth(r1);
        r4.setHeight(r2);
        r4.setToken(this.a.b);
        r4.setUrls(Collections.singletonList(this.a.a));
        r5.onNext(r4);
        r5.onComplete();
    }
}
