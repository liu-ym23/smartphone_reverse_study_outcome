package com.ss.android.lark.newemoji.impl;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Runnable {
    public final /* synthetic */ EmojiMapManager2 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;

    public b(EmojiMapManager2 r1, String r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        Log.i("EmojiMapManager2", "onLoadImageCallback, imageResourceCallbackList size is " + this.a.g.size());
        if (this.a.g.isEmpty() == false) goto L5;
        return;
    L5:
        CopyOnWriteArrayList<WeakReference<IGetDataCallback<Boolean>>> r0 = this.a.g.get(this.b);
        if (r0 != null) goto L10;
        Log.i("EmojiMapManager2", "onLoadImageCallback, listeners of " + this.b + " is null");
        return;
    L10:
        if (r0.isEmpty() == false) goto L13;
        this.a.g.remove(this.b);
        Log.i("EmojiMapManager2", "onLoadImageCallback, listeners of " + this.b + " is empty");
        return;
    L13:
        boolean r2 = this.c;
        String r3 = this.b;
        Iterator<T> r1 = r0.iterator();
    L15:
        if (r1.hasNext() == false) goto L30;
        WeakReference r4 = (WeakReference) r1.next();
        if (r2 == true) goto L18;
        IGetDataCallback r5 = (IGetDataCallback) r4.get();
        if (r5 == null) goto L29;
        r5.onError(new ErrorResult("load image failed"));
    L29:
        Log.i("EmojiMapManager2", "onLoadImageCallback, emoji " + r3 + " image load err callback");
        goto L15
    L18:
        IGetDataCallback r6 = (IGetDataCallback) r4.get();
        if (r6 == null) goto L21;
        r6.onSuccess(Boolean.TRUE);
    L21:
        StringBuilder r7 = new StringBuilder("onLoadImageCallback, emoji: ");
        r7.append(r3);
        r7.append(" image load success callback，listener is null: ");
        if (r4.get() != null) goto L24;
        boolean r8 = true;
    L25:
        r7.append(r8);
        Log.i("EmojiMapManager2", r7.toString());
        goto L15
    L24:
        r8 = false;
        goto L25
    L30:
        this.a.g.remove(this.b);
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
