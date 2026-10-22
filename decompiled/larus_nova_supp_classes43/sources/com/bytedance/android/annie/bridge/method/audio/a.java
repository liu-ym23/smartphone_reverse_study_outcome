package com.bytedance.android.annie.bridge.method.audio;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import fna.g;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Deprecated;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Deprecated(message = "不支持 LLM 能力，请使用 AsrCoreWithLLM 代替")
public final class a implements Handler.Callback {
    public static final WeakHashMap<View, a> k = null;
    public JSBridgeManager a;
    public InterfaceC0059a b;
    public CallContext c;
    public String d;
    public com.bytedance.android.annie.bridge.method.audio.c e;
    public PthreadHandlerThreadV2 f;
    public Handler g;
    public final AtomicInteger h;
    public final d i;
    public final c j;

    /* JADX INFO: renamed from: com.bytedance.android.annie.bridge.method.audio.a$a, reason: collision with other inner class name */
    public interface InterfaceC0059a {
        void d(boolean r1);
    }

    public static final class b {
    }

    public static final class c {
        public c() {
        }
    }

    public static final class d implements com.bytedance.android.annie.bridge.method.audio.c.b {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.annie.bridge.method.audio.c.b
        public final void a(byte[] r10) {
            Intrinsics.checkNotNullParameter(r10, "pcmData");
            Handler r0 = this.a.g;
            if (r0 == null) goto L6;
            r0.sendMessage(r0.obtainMessage(104, r10));
            return;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            InterfaceC0059a r0 = this.a.b;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.d(true);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
        k = new WeakHashMap();
    }

    public final void b() {
        AndroidSchedulers.mainThread().scheduleDirect(new e(this));
        if (this.e != null) goto L5;
        com.bytedance.android.annie.bridge.method.audio.c r0 = new com.bytedance.android.annie.bridge.method.audio.c();
        r0.d = this.i;
        this.e = r0;
        a("init audio recorder");
        Unit r1 = Unit.INSTANCE;
    L5:
        com.bytedance.android.annie.bridge.method.audio.c r10 = this.e;
        if (r10 == null) goto L23;
        AudioRecord r11 = r10.c;     // Catch: IllegalStateException -> L17
        if (r11 != null) goto L10;
    L13:
        r10.f = 2;     // Catch: IllegalStateException -> L17
        Handler r12 = r10.e;     // Catch: IllegalStateException -> L17
        if (r12 == null) goto L19;
        r12.post(r10.g);     // Catch: IllegalStateException -> L17
    L19:
        a("start audio recorder");
        return;
    L10:
        if (g.d() == true) goto L12;
        com.bytedance.android.annie.bridge.method.audio.c.b(r11);     // Catch: IllegalStateException -> L17
        goto L13
    L12:
        com.bytedance.android.annie.bridge.method.audio.c.b(r11);     // Catch: IllegalStateException -> L17
        hna.a.b(r11.hashCode());     // Catch: IllegalStateException -> L17
    L17:
        e = move-exception;
        b8.a r13 = b8.a.a;
        b8.a.a(new b8.b("AudioRecorder", LogLevel.ERROR, e, "Start Record Exception: " + e.getMessage()), true);
        goto L19
    }

    public final CallContext getContext() {
        return this.c;
    }

    public static void a(String r10) {
        b8.a r0 = b8.a.a;
        b8.a.d(new b8.b("AsrCore", LogLevel.DEBUG, null, r10));
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r11) {
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        switch(r11.what) {
            case 103: goto L48;
            case 104: goto L71;
            case 105: goto L5;
            default: goto L70;
        };
    L5:
        a("=========clear======");
        a("stop record");
        com.bytedance.android.annie.bridge.method.audio.c r0 = this.e;
        if (r0 != null) goto L79;
    L24:
        this.e = null;
        a("=========destroyHandle======");
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L27
        CallContext r1 = this.c;     // Catch: Throwable -> L27
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L27
        ((a9.d) Annie.getService(a9.d.class, r1.a())).H();     // Catch: Throwable -> L27
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L32;
        b8.a r10 = b8.a.a;
        b8.a.a(new b8.b("AsrCore", LogLevel.ERROR, r14, "Failed to destroyHandle: IAnnieBridgeAsrService not implemented in host"), true);
    L32:
        PthreadHandlerThreadV2 r15 = this.f;
        if (r15 == null) goto L35;
        r15.quit();
    L35:
        this.f = null;
        this.g = null;
        CallContext r16 = this.c;
        if (r16 == null) goto L40;
        View r17 = r16.d;
        if (r17 == null) goto L40;
        a("========remove instance======");
        k.remove(r17);
    L40:
        this.c = null;
        this.b = null;
    L27:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L79:
        AudioRecord r19 = r0.c;     // Catch: IllegalStateException -> L15
        if (r19 != null) goto L10;
    L13:
        r0.f = 1;     // Catch: IllegalStateException -> L15
    L17:
        r0.d = null;
        AudioRecord r20 = r0.c;     // Catch: IllegalStateException -> L22
        if (r20 == null) goto L24;
        com.bytedance.android.annie.bridge.method.audio.c.a(r20);     // Catch: IllegalStateException -> L22
    L22:
        e = move-exception;
        b8.a r21 = b8.a.a;
        b8.a.a(new b8.b("AudioRecorder", LogLevel.ERROR, e, "Release Record Exception: " + e.getMessage()), true);
        goto L24
    L10:
        if (g.d() == true) goto L12;
        com.bytedance.android.annie.bridge.method.audio.c.c(r19);     // Catch: IllegalStateException -> L15
        goto L13
    L12:
        com.bytedance.android.annie.bridge.method.audio.c.c(r19);     // Catch: IllegalStateException -> L15
        hna.a.c(r19.hashCode());     // Catch: IllegalStateException -> L15
    L15:
        e = move-exception;
        b8.a r22 = b8.a.a;
        b8.a.a(new b8.b("AudioRecorder", LogLevel.ERROR, e, "Stop Record Exception: " + e.getMessage()), true);
        goto L17
    L48:
        a("createHandle connectState: " + this.h.get());
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L65
        this.h.compareAndSet(0, 1);     // Catch: Throwable -> L65
        String r111 = this.d;     // Catch: Throwable -> L65
        if (r111 != null) goto L52;
    L55:
        boolean r112 = true;
    L56:
        if (r112 == true) goto L58;
        String r113 = this.d;     // Catch: Throwable -> L65
        Intrinsics.checkNotNull(r113);     // Catch: Throwable -> L65
    L59:
        CallContext r23 = this.c;     // Catch: Throwable -> L65
        Intrinsics.checkNotNull(r23);     // Catch: Throwable -> L65
        if (((a9.d) Annie.getService(a9.d.class, r23.a())).t0(r113, this.j) == false) goto L62;
        b();     // Catch: Throwable -> L65
    L63:
        Object r114 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L65
    L67:
        Throwable r115 = Result.exceptionOrNull-impl(r114);
        if (r115 == null) goto L70;
        b8.a r24 = b8.a.a;
        b8.a.a(new b8.b("AsrCore", LogLevel.ERROR, r115, "Failed to createHandle: IAnnieBridgeAsrService not implemented in host"), true);
        this.h.set(0);
        AndroidSchedulers.mainThread().scheduleDirect(new com.bytedance.android.annie.bridge.method.audio.b(this));
        goto L70
    L62:
        this.h.set(0);     // Catch: Throwable -> L65
        AndroidSchedulers.mainThread().scheduleDirect(new com.bytedance.android.annie.bridge.method.audio.b(this));     // Catch: Throwable -> L65
        goto L63
    L58:
        r113 = "KHBEDXeGDw";
        goto L59
    L52:
        if (r111.length() == 0) goto L55;
        r112 = false;
    L65:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r114 = Result.constructor-impl(ResultKt.createFailure(th));
    L70:
        return false;
    L71:
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L43
        CallContext r27 = this.c;     // Catch: Throwable -> L43
        Intrinsics.checkNotNull(r27);     // Catch: Throwable -> L43
        a9.d r28 = (a9.d) Annie.getService(a9.d.class, r27.a());     // Catch: Throwable -> L43
        Object r116 = r11.obj;     // Catch: Throwable -> L43
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type kotlin.ByteArray");     // Catch: Throwable -> L43
        r28.Y0((byte[]) r116);     // Catch: Throwable -> L43
        Object r117 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L43
    L45:
        Throwable r118 = Result.exceptionOrNull-impl(r117);
        if (r118 == null) goto L70;
        b8.a r29 = b8.a.a;
        b8.a.a(new b8.b("AsrCore", LogLevel.ERROR, r118, "Failed to process audio: IAnnieBridgeAsrService not implemented in host"), true);
    L43:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r117 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L45
    }

    public a(JSBridgeManager r1, InterfaceC0059a r10, CallContext r11, String r12, int r13, int r14, int r15) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.h = new AtomicInteger(0);
        this.i = new d(this);
        this.j = new c();
    }
}
