package com.ss.android.lark.chat.chatwindow.chat.perload;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.core.extension.ChatCoreRuntimeProvider;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.service.p;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import t3b.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public final b a;
    public final Map<Class<? extends u3b.a>, com.ss.android.lark.chat.chatwindow.chat.perload.loader.c> b;

    public static final class a {
        public static final c a = null;

        static {
            a = new c(ImSdkService.b(), ImSdkService.f());
        }
    }

    public final void b(u3b.a r5) {
        Map<Class<? extends u3b.a>, com.ss.android.lark.chat.chatwindow.chat.perload.loader.c> r0 = this.b;
        HashMap r1 = (HashMap) r0;
        com.ss.android.lark.chat.chatwindow.chat.perload.loader.c r2 = (com.ss.android.lark.chat.chatwindow.chat.perload.loader.c) r1.get(r5.getClass());
        if (r2 != null) goto L6;
        Log.e("DataPreLoadManager", "Could not find a loader for target task");
        return;
    L6:
        t3b.c r3 = t3b.c.a.a;
        Map<Class, e> r4 = r3.a;
        HashMap r6 = (HashMap) r4;
        e r7 = (e) r6.get(r5.getClass());
        if (r7 != null) goto L9;
        r7 = r3.b;
    L9:
        u3b.d r8 = new u3b.d(r7.b(r5), r5);
        this.a.a(r8, r2);
    }

    public c(ImSdkChatService r4, p r5) {
        this.a = new b();
        this.b = new HashMap(5);
        c(u3b.c.class, new com.ss.android.lark.chat.chatwindow.chat.perload.loader.b(r5), new t3b.b());
        c(u3b.b.class, new com.ss.android.lark.chat.chatwindow.chat.perload.loader.a(r4, r5), new t3b.a());
        Collection<d<? extends u3b.a, ?>> r6 = ChatCoreRuntimeProvider.a.h();
        Log.i("DataPreLoadManager", "holder count:" + r6.size());
        Iterator<d<? extends u3b.a, ?>> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        d<? extends u3b.a, ?> r8 = r7.next();
        Log.i("DataPreLoadManager", "holder task class:".concat(r8.a.getName()));
        c(r8.a, r8.b, r8.c);
        goto L4
    }

    public final void a(u3b.a r6, IGetDataCallback<u3b.e> r7) {
        t3b.c r0 = t3b.c.a.a;
        e r1 = (e) ((HashMap) r0.a).get(r6.getClass());
        if (r1 != null) goto L5;
        r1 = r0.b;
    L5:
        String r2 = r1.a(r6);
        b r3 = this.a;
        ((ReentrantLock) r3.d).lock();
        u3b.e r4 = (u3b.e) ((ConcurrentHashMap) r3.b).remove(r2);     // Catch: Throwable -> L25
        if (r4 != null) goto L10;
        u3b.d r5 = r3.c.get(r2);     // Catch: Throwable -> L25
        if (r5 == null) goto L20;
        r5.c = r7;     // Catch: Throwable -> L25
    L23:
        ((ReentrantLock) r3.d).unlock();
        return;
    L20:
        Log.e("DataPreLoadEngine", "Failed to find task when fetch data：" + r2 + BuildConfig.FLAVOR);     // Catch: Throwable -> L25
        u3b.d r8 = new u3b.d(r2, r6);     // Catch: Throwable -> L25
        r8.c = r7;     // Catch: Throwable -> L25
        com.ss.android.lark.chat.chatwindow.chat.perload.loader.c r9 = (com.ss.android.lark.chat.chatwindow.chat.perload.loader.c) ((HashMap) a.a.b).get(r6.getClass());     // Catch: Throwable -> L25
        if (r9 == null) goto L23;
        r3.a(r8, r9);     // Catch: Throwable -> L25
        goto L23
    L10:
        if (r4.b != null) goto L12;
        boolean r10 = true;
    L14:
        if (r10 == false) goto L16;
        Log.i("DataPreLoadEngine", "Task:" + r2 + " Fetch data after task finish, return result");     // Catch: Throwable -> L25
        r7.onSuccess(r4);     // Catch: Throwable -> L25
        goto L23
    L16:
        Log.e("DataPreLoadEngine", "Task:" + r2 + " Fetch data after task finish, return error:" + r4.b);     // Catch: Throwable -> L25
        r7.onError(r4.b);     // Catch: Throwable -> L25
        goto L23
    L12:
        r10 = false;
    L25:
        th = move-exception;
        ((ReentrantLock) r3.d).unlock();
        throw th;
    }

    public final <Task extends u3b.a, DATA> void c(Class<Task> r2, com.ss.android.lark.chat.chatwindow.chat.perload.loader.c<Task, u3b.e<DATA>> r3, e<Task> r4) {
        this.b.put(r2, r3);
        if (r4 == null) goto L6;
        ((HashMap) t3b.c.a.a.a).put(r2, r4);
        return;
    }
}
