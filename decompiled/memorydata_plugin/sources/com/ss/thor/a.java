package com.ss.thor;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HandlerThread f15768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static HandlerC0840a f15769b;
    private static b c;
    private static int d;
    private static AtomicInteger e;

    /* JADX INFO: renamed from: com.ss.thor.a$a, reason: collision with other inner class name */
    private static class HandlerC0840a extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message r7) {
            if (a.b() != null) goto L5;
            return;
        L5:
            int r0 = r7.what;
            Context r8 = (Context) ZeusTransformUtils.preCheckCast(r7.obj, Context.class, "com.obric.memorydata.plugin");
            float r4 = -1.0f;
            if (r0 != 1) goto L8;
            a.b().a(c.b(r8), -1.0f, -1);     // Catch: Exception -> L24
            goto L22
        L8:
            if (r0 != 2) goto L10;
            b r1 = a.b();     // Catch: Exception -> L24
        L18:
            r1.a(r4, c.a(r8), -1);     // Catch: Exception -> L24
            goto L22
        L10:
            if (r0 != 3) goto L12;
            a.b().a(-1.0f, -1.0f, c.c(r8));     // Catch: Exception -> L24
            goto L22
        L12:
            if (r0 != 4) goto L14;
            r1 = a.b();     // Catch: Exception -> L24
            r4 = c.b(r8);     // Catch: Exception -> L24
            goto L18
        L14:
            if (r0 != 5) goto L22;
            a.b().a(c.b(r8), c.a(r8), c.c(r8));     // Catch: Exception -> L24
        L22:
            sendMessageDelayed(obtainMessage(r0, r8), a.c());
        }
    }

    static {
        e = new AtomicInteger(0);
    }

    public static void a() {
        HandlerThread r0 = f15768a;
        if (r0 == null) goto L6;
        r0.quit();
        c.a();
        f15768a = null;
        f15769b = null;
        c = null;
        return;
    }

    static /* synthetic */ b b() {
        return c;
    }

    static /* synthetic */ int c() {
        return d;
    }
}
