package com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool;

import com.bytedance.common.utility.collection.CollectionUtils;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.idependency.Log;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class WebViewPool implements IWebViewPool {
    private static final String TAG = "CML_TAG_WebViewPool";
    private final Deque<WebViewItem> list;
    private IWebViewPool.WebViewLifecycleListener listener;

    public static class WebViewItem {
        private Object tag;
        private ChameleonWebView webView;

        public WebViewItem() {
        }

        public Object getTag() {
            return this.tag;
        }

        public ChameleonWebView getWebView() {
            return this.webView;
        }

        public static /* synthetic */ Object access$000(WebViewItem r0) {
            return r0.tag;
        }

        public static /* synthetic */ ChameleonWebView access$100(WebViewItem r0) {
            return r0.webView;
        }

        public void setTag(Object r1) {
            this.tag = r1;
        }

        public static /* synthetic */ Object access$002(WebViewItem r0, Object r1) {
            r0.tag = r1;
            return r1;
        }

        public static /* synthetic */ ChameleonWebView access$102(WebViewItem r0, ChameleonWebView r1) {
            r0.webView = r1;
            return r1;
        }
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public synchronized void destroyAll() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (CollectionUtils.isEmpty(this.list) == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        ArrayList r0 = new ArrayList(this.list);     // Catch: Throwable -> L16
        this.list.clear();     // Catch: Throwable -> L16
        Iterator r1 = r0.iterator();     // Catch: Throwable -> L16
    L9:
        if (r1.hasNext() == false) goto L14;
        WebViewItem r2 = (WebViewItem) r1.next();     // Catch: Throwable -> L16
        IWebViewPool.WebViewLifecycleListener r3 = this.listener;     // Catch: Throwable -> L16
        if (r3 == null) goto L9;
        r3.onWebViewDestroyed(WebViewItem.access$100(r2));     // Catch: Throwable -> L16
        goto L9
    L14:
        monitor-exit(this);
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public int occupiedSize() {
        Iterator<WebViewItem> r0 = this.list.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L8;
        if (WebViewItem.access$000(r0.next()) == null) goto L4;
        r1 = r1 + 1;
        goto L4
    L8:
        return r1;
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public int poolSize() {
        return this.list.size();
    }

    public WebViewPool() {
        this.list = new LinkedList();
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public synchronized ChameleonWebView createWebView(ChameleonConfig r4) {
        monitor-enter(this);
        WebViewItem r0 = new WebViewItem();     // Catch: Throwable -> L9
        WebViewItem.access$102(r0, new ChameleonWebView(Env.getApplication(), r4));     // Catch: Throwable -> L9
        this.list.addLast(r0);     // Catch: Throwable -> L9
        IWebViewPool.WebViewLifecycleListener r5 = this.listener;     // Catch: Throwable -> L9
        if (r5 == null) goto L6;
        r5.onWebViewCreated(WebViewItem.access$100(r0));     // Catch: Throwable -> L9
    L6:
        ChameleonWebView r6 = WebViewItem.access$100(r0);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r6;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public synchronized void destroyWebView(ChameleonWebView r3) {
        monitor-enter(this);
        if (r3 != null) goto L24;
        monitor-exit(this);
        return;
    L24:
        IWebViewPool.WebViewLifecycleListener r0 = this.listener;     // Catch: Throwable -> L21
        if (r0 == null) goto L10;
        r0.onWebViewDestroyed(r3);     // Catch: Throwable -> L21
    L10:
        if (CollectionUtils.isEmpty(this.list) == false) goto L13;
        monitor-exit(this);
        return;
    L13:
        Iterator<WebViewItem> r1 = this.list.iterator();     // Catch: Throwable -> L21
    L15:
        if (r1.hasNext() == false) goto L19;
        if (WebViewItem.access$100(r1.next()) != r3) goto L15;
        r1.remove();     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public synchronized ChameleonWebView detachWebView(Object r5) {
        monitor-enter(this);
        ChameleonWebView r0 = null;
        if (r5 != null) goto L23;
        monitor-exit(this);
        return null;
    L23:
        Iterator<WebViewItem> r1 = this.list.iterator();     // Catch: Throwable -> L20
    L9:
        if (r1.hasNext() == false) goto L13;
        WebViewItem r2 = r1.next();     // Catch: Throwable -> L20
        if (r5.equals(WebViewItem.access$000(r2)) == false) goto L9;
        r1.remove();     // Catch: Throwable -> L20
    L14:
        if (r2 == null) goto L16;
        WebViewItem.access$002(r2, null);     // Catch: Throwable -> L20
        this.list.addLast(r2);     // Catch: Throwable -> L20
    L16:
        if (r2 == null) goto L18;
        r0 = WebViewItem.access$100(r2);     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return r0;
    L13:
        r2 = null;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public ChameleonWebView getOverMaxUsedWebView(int r5) {
        if (CollectionUtils.isEmpty(this.list) == false) goto L6;
        Log.e(TAG, "getOverMaxUsedChameleonWebView without initializing pool!");
        return null;
    L6:
        Iterator<WebViewItem> r0 = this.list.descendingIterator();
    L8:
        if (r0.hasNext() == false) goto L12;
        WebViewItem r2 = r0.next();
        if (WebViewItem.access$100(r2).getUsedCount() <= r5) goto L8;
    L13:
        if (r2 != null) goto L16;
        return null;
    L16:
        return WebViewItem.access$100(r2);
    L12:
        r2 = null;
        goto L13
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public void setWebViewLifeCycleListener(IWebViewPool.WebViewLifecycleListener r1) {
        this.listener = r1;
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public synchronized void traversePool(IWebViewPool.TraverseAction r3) {
        monitor-enter(this);
        Iterator r0 = new ArrayList(this.list).iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L8;
        if (r3.onWebViewTraverse(WebViewItem.access$100((WebViewItem) r0.next())) == false) goto L5;
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public synchronized ChameleonWebView getCurWebView(Object r1, boolean r2) {
        monitor-enter(this);
        WebViewItem r3 = getCurWebViewItem(r1, r2);     // Catch: Throwable -> L10
        if (r3 == null) goto L7;
        ChameleonWebView r4 = WebViewItem.access$100(r3);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r4;
    L7:
        r4 = null;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public WebViewItem getCurWebViewItem(Object r5, boolean r6) {
        WebViewItem r1 = null;
        if (CollectionUtils.isEmpty(this.list) == true) goto L16;
        if (r5 == null) goto L16;
        Iterator<WebViewItem> r0 = this.list.iterator();
    L8:
        if (r0.hasNext() == false) goto L12;
        WebViewItem r2 = r0.next();
        if (r5.equals(WebViewItem.access$000(r2)) == false) goto L8;
        r1 = r2;
    L12:
        if (r1 == null) goto L16;
        WebViewItem.access$002(r1, r5);
        if (r6 == false) goto L16;
        this.list.remove(r1);
        this.list.addFirst(r1);
    L16:
        return r1;
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public synchronized ChameleonWebView provideWebView(Object r7, boolean r8) {
        monitor-enter(this);
        WebViewItem r1 = null;
        if (CollectionUtils.isEmpty(this.list) == false) goto L8;
        Log.e(TAG, "call provideChameleonWebView without initializing pool!");     // Catch: Throwable -> L28
        monitor-exit(this);
        return null;
    L8:
        Iterator<WebViewItem> r0 = this.list.descendingIterator();     // Catch: Throwable -> L28
        WebViewItem r2 = null;
    L10:
        if (r0.hasNext() == false) goto L20;
        WebViewItem r3 = r0.next();     // Catch: Throwable -> L28
        if (WebViewItem.access$000(r3) != null) goto L10;
        if (WebViewItem.access$100(r3).isReady() == r8) goto L15;
        if (r2 == null) goto L19;
        if (WebViewItem.access$100(r3).getUsedCount() <= WebViewItem.access$100(r2).getUsedCount()) goto L10;
    L19:
        r2 = r3;
        goto L10
    L15:
        r1 = r3;
    L20:
        if (r1 == null) goto L23;
        r2 = r1;
    L23:
        if (r2 != null) goto L25;
        r2 = this.list.getLast();     // Catch: Throwable -> L28
    L25:
        this.list.remove(r2);     // Catch: Throwable -> L28
        this.list.addFirst(r2);     // Catch: Throwable -> L28
        WebViewItem.access$002(r2, r7);     // Catch: Throwable -> L28
        ChameleonWebView r9 = WebViewItem.access$100(r2);     // Catch: Throwable -> L28
        monitor-exit(this);
        return r9;
    L28:
        th = move-exception;
        throw th;
    }
}
