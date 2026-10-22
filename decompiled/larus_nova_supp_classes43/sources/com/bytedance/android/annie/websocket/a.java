package com.bytedance.android.annie.websocket;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.ai.event.MessageIndication;
import java.nio.charset.StandardCharsets;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class a implements b, c {
    public final Context a;
    public final f b;
    public j c;
    public int d;

    /* JADX INFO: renamed from: com.bytedance.android.annie.websocket.a$a, reason: collision with other inner class name */
    public static final class C0086a {
    }

    static {
    }

    @Override // com.bytedance.android.annie.websocket.b
    public final void a() {
        monitor-enter(this);
        int r0 = this.d;     // Catch: Throwable -> L9
        monitor-exit(this);
        if (r0 == (-1)) goto L14;
        h();
        e(-1);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public abstract void g();

    public abstract void h();

    public final void d() {
        j r0 = this.c;
        if (r0 == null) goto L6;
        r0.onClosed();
        return;
    }

    public final void f() {
        Context r0 = this.a;
        boolean r1 = false;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L21
        Object r11 = r0.getSystemService("connectivity");     // Catch: Throwable -> L21
        NetworkInfo r12 = null;
        if ((r11 instanceof ConnectivityManager) == false) goto L6;
        ConnectivityManager r13 = (ConnectivityManager) r11;     // Catch: Throwable -> L21
    L7:
        if (r13 == null) goto L10;
        r12 = r13.getActiveNetworkInfo();     // Catch: Throwable -> L21
    L10:
        if (r12 != null) goto L12;
    L14:
        boolean r14 = false;
    L15:
        if (r14 == true) goto L17;
    L19:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        if (r1 == true) goto L28;
        Intrinsics.checkNotNullParameter("net error", "reason");
        j r15 = this.c;
        if (r15 == null) goto L32;
        r15.onFailed("net error");
        return;
    L32:
        return;
    L28:
        g();
        return;
    L17:
        if (r12.getState() != NetworkInfo.State.CONNECTED) goto L19;
        r1 = true;
        goto L23
    L12:
        if (r12.isConnected() != true) goto L14;
        r14 = true;
        goto L15
    L6:
        r13 = null;
    L21:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }

    public final Context getContext() {
        return this.a;
    }

    public final synchronized void e(int r1) {
        monitor-enter(this);
        this.d = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public a(Context r10, f r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "requestTask");
        this.a = r10;
        this.b = r11;
        this.d = -1;
    }

    @Override // com.bytedance.android.annie.websocket.c
    public final void c(int r10, String r11) {
        boolean r1 = true;
        if (r10 != 2) goto L5;
        if (r11 != null) goto L18;
    L21:
        if (r1 == false) goto L25;
        Intrinsics.checkNotNullParameter("unknown error", "reason");
        j r12 = this.c;
        if (r12 == null) goto L33;
        r12.onFailed("unknown error");
        return;
    L33:
        return;
    L25:
        Intrinsics.checkNotNullParameter(r11, "reason");
        j r13 = this.c;
        if (r13 == null) goto L35;
        r13.onFailed(r11);
        return;
    L35:
        return;
    L18:
        if (r11.length() == 0) goto L21;
        r1 = false;
        goto L21
    L5:
        if (r10 != 4) goto L36;
        monitor-enter(this);
        this.d = 1;     // Catch: Throwable -> L13
        monitor-exit(this);
        j r14 = this.c;
        if (r14 == null) goto L31;
        r14.onConnected();
        return;
    L31:
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.annie.websocket.c
    public final void onMessage(byte[] r10, int r11) {
        if (1 != r11) goto L10;
        if (r10 == null) goto L6;
        String r0 = new String(r10, StandardCharsets.UTF_8);
    L7:
        Intrinsics.checkNotNullParameter(r0, MessageIndication.MESSAGE_TYPE_MSG);
        j r12 = this.c;
        if (r12 == null) goto L16;
        r12.onMessage(r0);
        return;
    L16:
        return;
    L6:
        r0 = "";
        goto L7
    L10:
        if (r10 != null) goto L12;
        r10 = new byte[0];
    L12:
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        j r13 = this.c;
        if (r13 == null) goto L18;
        r13.onMessage(r10);
        return;
    }
}
