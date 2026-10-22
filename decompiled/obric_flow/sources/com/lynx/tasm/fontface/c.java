package com.lynx.tasm.fontface;

import android.graphics.Typeface;
import android.os.Handler;
import android.util.Pair;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.core.resource.LynxResourceLoader;
import java.util.Iterator;
import zm.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10859c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object g;

    public c(LynxResourceLoader r5, int r10, String r11, String r12, String r13, String r14) {
        this.f10857a = 1;
        this.g = r5;
        this.f10858b = r10;
        this.f10859c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f10857a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        com.lynx.tasm.g r5 = (com.lynx.tasm.g) ((LynxResourceLoader) this.g).e.get();
        if (r5 == null) goto L63;
        LynxError r10 = new LynxError(this.f10858b, "LynxResourceLoader " + ((String) this.f10859c) + " failed, the error message is: " + ((String) this.d), "Please refer to the solution in Doc 'LynxError FAQ' on the official website.", "error");
        r10.g = null;
        r10.f10000o = (String) this.e;
        r10.b("src", (String) this.f);
        r5.onErrorOccurred(r10);
        return;
    L63:
        return;
    L9:
        g r11 = (g) this.g;
        LynxContext r12 = (LynxContext) this.f10859c;
        a r13 = (a) this.d;
        int r14 = this.f10858b;
        f0 r15 = (f0) this.e;
        Handler r16 = (Handler) this.f;
        monitor-enter(r11);
        i r17 = r11.b(r13);     // Catch: Throwable -> L17
        if (r17 == null) goto L22;
        r13.f10854b = r17;     // Catch: Throwable -> L17
        r11.f(r13, r17);     // Catch: Throwable -> L17
        Typeface r18 = r17.a(r14);     // Catch: Throwable -> L17
        if (r15 != null) goto L19;
        monitor-exit(r11);     // Catch: Throwable -> L17
        return;
    L19:
        r16.post(new a7.a(r15, r18, r14));     // Catch: Throwable -> L17
        monitor-exit(r11);     // Catch: Throwable -> L17
        return;
    L22:
        Iterator r19 = r11.f10868b.iterator();     // Catch: Throwable -> L17
    L24:
        if (r19.hasNext() == false) goto L45;
        b r20 = (b) r19.next();     // Catch: Throwable -> L17
        if (r20.f10856b.contains(r13) == true) goto L42;
        Iterator r21 = r20.f10856b.iterator();     // Catch: Throwable -> L17
    L30:
        if (r21.hasNext() == false) goto L24;
        a r22 = (a) r21.next();     // Catch: Throwable -> L17
        if (r22 == r13) goto L33;
        Iterator r23 = r22.f10853a.iterator();     // Catch: Throwable -> L17
    L36:
        if (r23.hasNext() == false) goto L30;
        Pair r24 = (Pair) r23.next();     // Catch: Throwable -> L17
        Iterator r110 = r13.f10853a.iterator();     // Catch: Throwable -> L17
    L39:
        if (r110.hasNext() == false) goto L36;
        if (r24.equals((Pair) r110.next()) == false) goto L39;
    L33:
        r22.getClass();     // Catch: Throwable -> L17
    L42:
        r20.f10856b.add(r13);     // Catch: Throwable -> L17
        r20.f10855a.add(new Pair(r15, Integer.valueOf(r14)));     // Catch: Throwable -> L17
        monitor-exit(r11);     // Catch: Throwable -> L17
        return;
    L45:
        b r111 = new b();     // Catch: Throwable -> L17
        r111.f10855a.add(new Pair(r15, Integer.valueOf(r14)));     // Catch: Throwable -> L17
        r111.f10856b.add(r13);     // Catch: Throwable -> L17
        r11.f10868b.add(r111);     // Catch: Throwable -> L17
        Iterator r25 = r13.f10853a.iterator();     // Catch: Throwable -> L17
        Iterator r26 = r13.f10853a.iterator();     // Catch: Throwable -> L17
        monitor-exit(r11);     // Catch: Throwable -> L17
        if (r12.D == null) goto L50;
        TraceEvent.c("FontFaceManager.loadTypefaceWithGenericLynxResourceFetcher");
        LynxLog.b(2, "FontFaceManager", "Try to loadTypeface with GenericLynxResourceFetcher.");
        r11.e(r12, r111, r25, r26, r16);
        TraceEvent.a(0, "FontFaceManager.loadTypefaceWithGenericLynxResourceFetcher");
        return;
    L50:
        TraceEvent.c("FontFaceManager.loadTypeface");
        r11.d(r12, r111, r25, r16);
        TraceEvent.a(0, "FontFaceManager.loadTypeface");
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public c(g r5, LynxContext r10, a r11, int r12, f0 r13, Handler r14) {
        this.f10857a = 0;
        this.g = r5;
        this.f10859c = r10;
        this.d = r11;
        this.f10858b = r12;
        this.e = r13;
        this.f = r14;
    }
}
