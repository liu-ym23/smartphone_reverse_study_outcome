package com.lynx.lottieadapter;

import com.lynx.animax.base.bridge.JavaOnlyArray;
import com.lynx.animax.property.AnimaXKeyPath;
import com.lynx.animax.property.AnimaXKeyPathListCallback;
import d6a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LottieAdapterAnimaX$a implements AnimaXKeyPathListCallback {
    public final /* synthetic */ List a;
    public final /* synthetic */ CountDownLatch b;

    @Override // com.lynx.animax.property.AnimaXKeyPathListCallback
    public final /* synthetic */ void onKeyPathListCallback(JavaOnlyArray r1) {
        AnimaXKeyPathListCallback.CC.$default$onKeyPathListCallback(this, r1);
    }

    @Override // com.lynx.animax.property.AnimaXKeyPathListCallback
    public final void onCallback(List<AnimaXKeyPath> r5) {
        Iterator r6 = ((ArrayList) r5).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        AnimaXKeyPath r0 = (AnimaXKeyPath) r6.next();
        List r1 = this.a;
        ArrayList r2 = (ArrayList) r0.a();
        r1.add(new a((String[]) r2.toArray(new String[0])));
        goto L4
    L6:
        this.b.countDown();
    }

    public LottieAdapterAnimaX$a(List r1, CountDownLatch r2) {
        this.a = r1;
        this.b = r2;
    }
}
