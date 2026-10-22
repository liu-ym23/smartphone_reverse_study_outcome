package com.larus.canvas.service.internal.sse;

import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.io.BufferedReader;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CanvasChunkParser {
    public static final CanvasChunkParser a = null;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/canvas/service/internal/sse/CanvasChunkParser$ReadChunkException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getMessage", "()Ljava/lang/String;", "getCause", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReadChunkException extends RuntimeException {
        private final Throwable cause;
        private final String message;

        public static /* synthetic */ ReadChunkException copy$default(ReadChunkException r0, String r1, Throwable r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.message;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.cause;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.message;
        }

        public final Throwable component2() {
            return this.cause;
        }

        public final ReadChunkException copy(String r2, Throwable r3) {
            return new ReadChunkException(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ReadChunkException) == true) goto L8;
            return false;
        L8:
            ReadChunkException r6 = (ReadChunkException) r5;
            if (Intrinsics.areEqual(this.message, r6.message) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.cause, r6.cause) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r0 = this.message;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Throwable r4 = this.cause;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "ReadChunkException(message=" + this.message + ", cause=" + this.cause + ')';
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public ReadChunkException(String r1, Throwable r2) {
            super(r1, r2);
            this.message = r1;
            this.cause = r2;
        }
    }

    static {
        a = new CanvasChunkParser();
    }

    public CanvasChunkParser() {
    }

    public static b b(BufferedReader r10) {
    L2:
        String r0 = StringsKt.trim(r10.readLine()).toString();
        if ((!StringsKt.isBlank(r0)) == false) goto L2;
        b r1 = new b();
        StringBuilder r2 = new StringBuilder();
    L6:
        if ((!StringsKt.isBlank(r0)) == false) goto L38;
        int r3 = StringsKt.indexOf$default(r0, ":", 0, false, 6, null);
        int r4 = -1;
        if (r3 == (-1)) goto L6;
        String r5 = StringsKt.trim(r0.substring(0, r3)).toString();
        String r6 = StringsKt.trim(r0.substring(r3 + 1)).toString();
        r2.append(r0);
        if (StringsKt.isBlank(r6) == true) goto L12;
        int r7 = r5.hashCode();
        if (r7 == 3355) goto L29;
        if (r7 == 3076010) goto L25;
        if (r7 != 96891546) goto L36;
        if (r5.equals("event") == false) goto L36;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r1.b = r6;
    L36:
        if (Intrinsics.areEqual(r1.b, "done") == true) goto L38;
        r0 = r10.readLine();
        goto L6
    L25:
        if (r5.equals("data") == false) goto L36;
        String r8 = r1.c + r6;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r1.c = r8;
        goto L36
    L29:
        if (r5.equals("id") == false) goto L36;
        Integer r9 = StringsKt.toIntOrNull(r6);
        if (r9 == null) goto L34;
        r4 = r9.intValue();
    L34:
        r1.a = r4;
        goto L36
    L12:
        r0 = r10.readLine();
    L38:
        Intrinsics.checkNotNullParameter(r2.toString(), "<set-?>");
        FLogger.a.i("CanvasChunkParser", "chunk data : " + r1);
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.canvas.service.internal.sse.c] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00d2 -> B:41:0x00d5). Please report as a decompilation issue!!! */
    public final Object a(BufferedReader r17, Function2<? super b, ? super Continuation<? super Unit>, ? extends Object> r18, Continuation<? super Unit> r19) {
        if ((r19 instanceof CanvasChunkParser$parseStream$1) == false) goto L7;
        CanvasChunkParser$parseStream$1 r1 = (CanvasChunkParser$parseStream$1) r19;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
        CanvasChunkParser r3 = this;
    L8:
        Object r0 = r1.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r1.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        b r6 = (b) r1.L$2;
        Function2<? super b, ? super Continuation<? super Unit>, ? extends Object> r8 = (Function2) r1.L$1;
        BufferedReader r9 = (BufferedReader) r1.L$0;
        ResultKt.throwOnFailure(r0);
        CanvasChunkParser r14 = r3;
        final BufferedReader r7 = r9;
        CanvasChunkParser$parseStream$1 r10 = r1;
        Function2<? super b, ? super Continuation<? super Unit>, ? extends Object> r11 = r8;
        b r12 = r6;
        Object r13 = r4;
    L42:
        if (Intrinsics.areEqual(r12.b, "done") == false) goto L45;
        FLogger.a.i("CanvasChunkParser", "receive chunk end");
    L48:
        r7.close();
        return Unit.INSTANCE;
    L45:
        if (Intrinsics.areEqual(r12.b, "error") == false) goto L18;
        FLogger.a.i("CanvasChunkParser", "receive chunk error");
    L18:
        if (JobKt.isActive(r10.getContext()) == false) goto L48;
        long r15 = z2.a.getCreationCanvasClientConfig().c;
        CanvasChunkParser$parseStream$chunkRet$1 r16 = new CanvasChunkParser$parseStream$chunkRet$1(null);
        ?? r110 = new c(r7);
        r10.L$0 = r7;
        r10.L$1 = r11;
        r10.L$2 = null;
        r10.label = 1;
        Object r20 = r14.c(r15, r16, r110, r10);
        if (r20 != r13) goto L22;
        return r13;
    L22:
        BufferedReader r21 = r7;
        r0 = r20;
    L23:
        Object r22 = ((Result) r0).unbox-impl();
        if (Result.isFailure-impl(r22) == false) goto L30;
        r21.close();
        Throwable r23 = Result.exceptionOrNull-impl(r22);
        if (r23 == null) goto L30;
        throw r23;
    L30:
        if (Result.isSuccess-impl(r22) == false) goto L47;
        r7 = r21;
        goto L18
    L32:
        if (Result.isFailure-impl(r22) == false) goto L34;
        r22 = null;
    L34:
        b r24 = (b) r22;
        if (r24 == null) goto L47;
        r10.L$0 = r21;
        r10.L$1 = r11;
        r10.L$2 = r24;
        r10.label = 2;
        if (r11.invoke(r24, r10) != r13) goto L40;
        return r13;
    L40:
        BufferedReader r111 = r21;
        r12 = r24;
        r7 = r111;
        goto L42
    L47:
        r7 = r21;
        goto L18
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Function2<? super b, ? super Continuation<? super Unit>, ? extends Object> r25 = (Function2) r1.L$1;
        r21 = (BufferedReader) r1.L$0;
        ResultKt.throwOnFailure(r0);
        r14 = r3;
        r10 = r1;
        r11 = r25;
        r13 = r4;
        goto L23
    L16:
        ResultKt.throwOnFailure(r0);
        r7 = r17;
        r14 = r3;
        r13 = r4;
        r10 = r1;
        r11 = r18;
    L7:
        r3 = this;
        r1 = new CanvasChunkParser$parseStream$1(r3, r19);
        goto L8
    }

    public final Object c(long r7, Function3 r9, c r10, Continuation r11) {
        if ((r11 instanceof CanvasChunkParser$waitOrTimeout$1) == false) goto L7;
        CanvasChunkParser$waitOrTimeout$1 r0 = (CanvasChunkParser$waitOrTimeout$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r12);
    L26:
        return r12;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r9 = (Function3) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L22
    L27:
        goto L26
    L18:
        ResultKt.throwOnFailure(r12);
        CanvasChunkParser$waitOrTimeout$2 r13 = new CanvasChunkParser$waitOrTimeout$2(r10, null);     // Catch: Throwable -> L22
        r0.L$0 = r9;     // Catch: Throwable -> L22
        r0.label = 1;     // Catch: Throwable -> L22
        r12 = TimeoutKt.b(r7, r13, r0);     // Catch: Throwable -> L22
        if (r12 != r2) goto L27;
        return r2;
    L22:
        th = move-exception;
        CoroutineContext.Element r8 = r0.getContext().get(Job.Key);
        r0.L$0 = null;
        r0.label = 2;
        r12 = r9.invoke(th, r8, r0);
        if (r12 != r2) goto L26;
        return r2;
    L7:
        r0 = new CanvasChunkParser$waitOrTimeout$1(this, r11);
        goto L8
    }
}
