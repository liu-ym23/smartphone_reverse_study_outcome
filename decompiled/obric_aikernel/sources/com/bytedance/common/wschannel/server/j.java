package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f1441a;

    static class a implements WeakHandler.IHandler {
        a() {
        }

        @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
        public void handleMsg(Message r10) {
        }
    }

    private static b a(Context r10) {
        HandlerThread r11 = new HandlerThread("wschannel");
        r11.start();
        com.bytedance.common.wschannel.server.a r12 = new com.bytedance.common.wschannel.server.a();
        l r13 = new l(r10, r12);
        k r14 = new k(r10, new WeakHandler(r11.getLooper(), new a()));
        b r15 = new b(r10, r11.getLooper(), new n(r10), r12, r13, r14);
        r13.o(r15);
        return r15;
    }

    public static b b(Context r10) {
        if (f1441a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1441a != null) goto L9;
        f1441a = a(r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f1441a;
    }
}
