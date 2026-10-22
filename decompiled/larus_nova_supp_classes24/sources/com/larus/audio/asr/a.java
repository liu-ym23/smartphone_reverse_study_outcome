package com.larus.audio.asr;

import b68.b;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.business.debug.base.audio.module.ASRModule;
import java.io.ByteArrayOutputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final String a;
    public final String b;
    public final Function1<Boolean, Unit> c;
    public final Object d;
    public ByteArrayOutputStream e;
    public boolean f;

    /* JADX INFO: renamed from: com.larus.audio.asr.a$a, reason: collision with other inner class name */
    public static final class C0072a {
    }

    static {
    }

    public final boolean a() {
        ByteArrayOutputStream r2 = this.e;
        if (r2 != null) goto L44;
        return false;
    L44:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        String r1 = b.h(b.a, this.a, r2);     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r1, "result");     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl(Boolean.valueOf(Intrinsics.areEqual(r1, "SUCCESS")));     // Catch: Throwable -> L8
    L10:
        Throwable r4 = Result.exceptionOrNull-impl(r3);     // Catch: Throwable -> L34
        if (r4 == null) goto L14;
        int r6 = c68.b.a;     // Catch: Throwable -> L34
        c68.b.c("AsrAudioFileStore", "[" + this.b + "] close retryable audio file failed path=" + this.a, r4);     // Catch: Throwable -> L34
    L14:
        Boolean r5 = Boolean.FALSE;     // Catch: Throwable -> L34
        if (Result.isFailure-impl(r3) == false) goto L17;
        r3 = r5;
    L17:
        boolean r7 = ((Boolean) r3).booleanValue();     // Catch: Throwable -> L34
        m58.q r8 = m58.h.d;     // Catch: Throwable -> L26
        if (r8 == null) goto L23;
        ASRModule r9 = r8.c();     // Catch: Throwable -> L26
        if (r9 == null) goto L23;
        r9.r(this.b, r2.toByteArray(), new y58.a(null, this.b, null, null, null, false, false, null, null, 0, 0, null, 0, 0, false, 0, 0, null, null, null, null, 0, null, 268435453));     // Catch: Throwable -> L26
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L24:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L26
    L28:
        Throwable r12 = Result.exceptionOrNull-impl(r11);     // Catch: Throwable -> L34
        if (r12 == null) goto L31;
        int r13 = c68.b.a;     // Catch: Throwable -> L34
        c68.b.c("AsrAudioFileStore", "[" + this.b + "] dump debug audio file failed", r12);     // Catch: Throwable -> L34
    L31:
        r2.reset();     // Catch: Throwable -> L34
        CloseableKt.closeFinally(r2, null);
        this.e = null;
        int r14 = c68.b.a;
        c68.b.d("AsrAudioFileStore", "[" + this.b + "] retryable audio file save result=" + r7 + " path=" + this.a);
        return r7;
    L23:
        r10 = null;
    L26:
        th = move-exception;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L34
        r11 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L34
        goto L28
    L8:
        th = move-exception;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L34
        r3 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    }

    public final void b() {
        PolarisFileWrapper r0 = new PolarisFileWrapper(this.a);
        String r1 = "[" + this.b + "] delete failed retryable audio file";
        if (r0.exists() == true) goto L33;
    L21:
        ByteArrayOutputStream r2 = this.e;
        if (r2 != null) goto L35;
        return;
    L35:
        r2.reset();     // Catch: Throwable -> L25
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r2, null);
        return;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    L33:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L14
        if (r0.delete() == false) goto L8;
    L11:
        boolean r5 = true;
    L12:
        Object r6 = Result.constructor-impl(Boolean.valueOf(r5));     // Catch: Throwable -> L14
    L16:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L20;
        int r8 = c68.b.a;
        c68.b.c("AsrAudioFileStore", r1 + " failed path=" + r0.getPath(), r7);
        r6 = Boolean.FALSE;
    L20:
        ((Boolean) r6).booleanValue();
        goto L21
    L8:
        if (r0.exists() == false) goto L11;
        int r9 = c68.b.a;     // Catch: Throwable -> L14
        c68.b.b("AsrAudioFileStore", r1 + " failed path=" + r0.getPath());     // Catch: Throwable -> L14
        r5 = false;
    L14:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public final void delete() {
        Object r1 = this.d;
        monitor-enter(r1);
        int r2 = c68.b.a;     // Catch: Throwable -> L7
        c68.b.d("AsrAudioFileStore", "[delete][" + this.b + "][" + this.a + ']');     // Catch: Throwable -> L7
        b();     // Catch: Throwable -> L7
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r1);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r2, String r3, Function1<? super Boolean, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "filePath");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new Object();
    }
}
