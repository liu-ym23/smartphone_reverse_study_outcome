package com.ss.android.lark.newemoji.impl;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements Runnable {
    public final /* synthetic */ EmojiMapManager2 a;

    public a(EmojiMapManager2 r1) {
        this.a = r1;
    }

    public final void a() {
        Log.i("EmojiMapManager2", "onFetchEntitySuccess, entityCallbackList list size is " + this.a.f.size());
        if (this.a.f.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, CopyOnWriteArrayList<WeakReference<IGetDataCallback<Boolean>>>>> r0 = this.a.f.entrySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L22;
        Map.Entry<String, CopyOnWriteArrayList<WeakReference<IGetDataCallback<Boolean>>>> r2 = r0.next();
        if (r2.getValue().isEmpty() == true) goto L10;
        if (this.a.l4(r2.getKey()) == true) goto L15;
        if (this.a.mo1505if(r2.getKey()) == false) goto L7;
    L15:
        Iterator<T> r3 = r2.getValue().iterator();
    L17:
        if (r3.hasNext() == false) goto L21;
        WeakReference r4 = (WeakReference) r3.next();
        Log.i("EmojiMapManager2", "onFetchEntitySuccess, emoji " + r2.getKey() + " entity load success callback");
        IGetDataCallback r5 = (IGetDataCallback) r4.get();
        if (r5 == null) goto L17;
        r5.onSuccess(Boolean.TRUE);
        goto L17
    L21:
        r0.remove();
        goto L7
    L10:
        Log.i("EmojiMapManager2", "onFetchEntitySuccess, list of " + r2.getKey() + " is null or empty");
        r0.remove();
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
