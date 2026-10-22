package com.ss.android.lark.officewebview.pool.impl;

import com.ss.android.lark.officesdk.utils.di.g;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
class WebViewPoolQueue extends ConcurrentLinkedQueue<OfficeWebView> {
    private String mBizTag;
    private int mMaxPoolSize;

    public void release() {
    L2:
        OfficeWebView r0 = poll();
        if (r0 == null) goto L5;
        r0.destroy();
        goto L2
    }

    public boolean add(OfficeWebView r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        int r1 = g.a;
        Intrinsics.checkNotNullParameter("openplatform.webview.pool.jump.dup.add.disable", "key");
        if (g.a.a("openplatform.webview.pool.jump.dup.add.disable") == true) goto L12;
        if (contains(r6) == false) goto L12;
        j.e("WebViewPoolQueue", "biz : " + this.mBizTag + " exist so return, currentSize: " + size() + " webView: " + r6.hashCode());
        return false;
    L12:
        if (this.mMaxPoolSize > 0) goto L14;
    L17:
        j.e("WebViewPoolQueue", "biz : " + this.mBizTag + " add webView: " + r6.hashCode() + " before size=" + size());
        return super.add(r6);
    L14:
        if (size() < this.mMaxPoolSize) goto L17;
        j.e("WebViewPoolQueue", "biz : " + this.mBizTag + " , reach to max pool size of " + this.mMaxPoolSize);
        r6.destroy();
        return false;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public /* bridge */ /* synthetic */ boolean add(Object r1) {
        return add((OfficeWebView) r1);
    }

    public WebViewPoolQueue(String r1, int r2) {
        this.mBizTag = r1;
        this.mMaxPoolSize = r2;
        if (r2 > 0) goto L6;
        this.mMaxPoolSize = 3;
        j.f("WebViewPoolQueue", "losing max pool size config, will use default size 3.");
        return;
    }
}
