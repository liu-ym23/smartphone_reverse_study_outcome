package com.bytedance.gkfs.io;

import com.bytedance.gkfs.UtilsKt$traceTime$1$1;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "<anonymous parameter 0>", "Lcom/bytedance/gkfs/io/f;", "chunk", "", "invoke", "(ILcom/bytedance/gkfs/io/f;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class GkFSChunkReader$2 extends Lambda implements Function2<Integer, f, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f4838a;

    public GkFSChunkReader$2(i r5) {
        this.f4838a = r5;
        super(2);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Unit mo2invoke(Integer r10, f r11) {
        r10.intValue();
        f r12 = r11;
        UtilsKt$traceTime$1$1 r13 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
        cb.a r5 = (cb.a) this.f4838a.d.get(r12.f4865a);
        c r14 = r12.f4865a;
        if (r5 != null) goto L26;
        Object r15 = null;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L10
        com.bytedance.gkfs.storage.e r17 = com.bytedance.gkfs.storage.d.a(r14);     // Catch: Throwable -> L10
        Closeable r18 = (Closeable) r17.d.invoke();     // Catch: Throwable -> L10
        cb.a r19 = com.lynx.tasm.utils.j.b((InputStream) r18, r17.f4928i);     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r18, null);     // Catch: Throwable -> L10
        Object r20 = Result.m124constructorimpl(r19);     // Catch: Throwable -> L10
    L18:
        Throwable r21 = Result.m127exceptionOrNullimpl(r20);
        if (r21 == null) goto L22;
        String r22 = androidx.room.jarjarred.org.antlr.runtime.a.x(r21, new StringBuilder("read chunk content failed, cause by "));
        this.f4838a.c(r22, new IOException(r22, r21), 0);
    L22:
        if (Result.m130isFailureimpl(r20) == true) goto L25;
        r15 = r20;
    L25:
        r5 = (cb.a) r15;
        goto L26
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r20 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L26:
        p r24 = this.f4838a.e;
        long r25 = r24.f4901c;
        r24.f4901c = ((Number) r13.invoke()).longValue() + r25;
        if (r5 == null) goto L29;
        this.f4838a.d.putIfAbsent(r14, r5);
    L29:
        p r26 = this.f4838a.e;
        long r27 = r26.f4900b;
        r26.f4900b = ((Number) r13.invoke()).longValue() + r27;
        return Unit.INSTANCE;
    }
}
