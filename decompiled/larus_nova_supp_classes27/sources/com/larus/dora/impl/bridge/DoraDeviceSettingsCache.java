package com.larus.dora.impl.bridge;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraDeviceSettingsCache {
    public static final DoraDeviceSettingsCache a = null;
    public static final MutexImpl b = null;
    public static volatile String c;
    public static volatile n d;

    public DoraDeviceSettingsCache() {
    }

    static {
        a = new DoraDeviceSettingsCache();
        b = kotlinx.coroutines.sync.b.a();
    }

    public static String b(String r1) {
        if (r1 != null) goto L4;
    L6:
        return null;
    L4:
        if ((!StringsKt.isBlank(r1)) == false) goto L6;
        return r1;
    }

    public final void update(String r3, Function1<? super n, n> r4) {
        Intrinsics.checkNotNullParameter(r4, "updater");
        monitor-enter(this);
        a.getClass();     // Catch: Throwable -> L21
        String r5 = b(r3);     // Catch: Throwable -> L21
        n r1 = null;
        if (Intrinsics.areEqual(c, r5) == false) goto L7;
        n r0 = d;     // Catch: Throwable -> L21
    L8:
        n r6 = (n) r4.invoke(r0);     // Catch: Throwable -> L21
        c = r5;     // Catch: Throwable -> L21
        if (r6 != null) goto L11;
    L18:
        d = r1;     // Catch: Throwable -> L21
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L11:
        if (r6.a == null) goto L13;
    L15:
        boolean r8 = false;
    L16:
        if (r8 == true) goto L18;
        r1 = r6;
        goto L18
    L13:
        if (r6.b != null) goto L15;
        r8 = true;
        goto L16
    L7:
        r0 = null;
    L21:
        th = move-exception;
        throw th;
    }

    public final Object a(String r9, Function1<? super Continuation<? super n>, ? extends Object> r10, Continuation<? super n> r11) {
        if ((r11 instanceof DoraDeviceSettingsCache$getOrLoad$1) == false) goto L7;
        DoraDeviceSettingsCache$getOrLoad$1 r0 = (DoraDeviceSettingsCache$getOrLoad$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        DoraDeviceSettingsCache r13 = (DoraDeviceSettingsCache) r0.L$2;
        String r14 = (String) r0.L$1;
        kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L15
    L42:
        n r15 = (n) r12;     // Catch: Throwable -> L15
        r13.getClass();     // Catch: Throwable -> L15
        c = r14;     // Catch: Throwable -> L15
        if (r15 != null) goto L45;
    L52:
        r15 = null;
    L53:
        d = r15;     // Catch: Throwable -> L15
        n r6 = d;     // Catch: Throwable -> L15
        kotlinx.coroutines.sync.a r16 = r5;
    L55:
        r16.unlock(null);
        return r6;
    L45:
        if (r15.a == null) goto L47;
    L49:
        r4 = false;
    L50:
        if (r4 == true) goto L52;
    L47:
        if (r15.b != null) goto L49;
    L15:
        th = move-exception;
        th = th;
        r16 = r5;
    L58:
        r16.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r16 = (kotlinx.coroutines.sync.a) r0.L$2;
        r14 = (String) r0.L$1;
        Function1<? super Continuation<? super n>, ? extends Object> r7 = (Function1) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L62:
        DoraDeviceSettingsCache r17 = a;     // Catch: Throwable -> L33
        r17.getClass();     // Catch: Throwable -> L33
        if (Intrinsics.areEqual(c, r14) == false) goto L35;
        r6 = d;     // Catch: Throwable -> L33
    L36:
        if (r6 != null) goto L55;
        r0.L$0 = r16;     // Catch: Throwable -> L33
        r0.L$1 = r14;     // Catch: Throwable -> L33
        r0.L$2 = r17;     // Catch: Throwable -> L33
        r0.label = 2;     // Catch: Throwable -> L33
        Object r8 = r7.invoke(r0);     // Catch: Throwable -> L33
        if (r8 != r2) goto L41;
        return r2;
    L41:
        r5 = r16;
        r13 = r17;
        r12 = r8;
        goto L42
    L35:
        r6 = null;
    L33:
        th = th;
        goto L58
    L20:
        ResultKt.throwOnFailure(r12);
        String r18 = b(r9);
        if (Intrinsics.areEqual(c, r18) == false) goto L23;
        n r110 = d;
    L24:
        if (r110 == null) goto L26;
        return r110;
    L26:
        kotlinx.coroutines.sync.a r111 = b;
        r0.L$0 = r10;
        r0.L$1 = r18;
        r0.L$2 = r111;
        r0.label = 1;
        if (r111.a(null, r0) != r2) goto L29;
        return r2;
    L29:
        r7 = r10;
        r14 = r18;
        r16 = r111;
        goto L62
    L23:
        r110 = null;
    L7:
        r0 = new DoraDeviceSettingsCache$getOrLoad$1(this, r11);
        goto L8
    }
}
