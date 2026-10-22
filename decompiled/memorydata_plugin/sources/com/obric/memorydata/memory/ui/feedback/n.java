package com.obric.memorydata.memory.ui.feedback;

import android.content.res.AssetFileDescriptor;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u001f\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0000¢\u0006\u0002\b\u000fJ!\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackTranscriptReader;", "", "<init>", "()V", "TAG", "", "MAX_TRANSCRIPT_BYTES", "", "READ_BUFFER_BYTES", "read", "transcriptFileEntityJson", "readSafely", "openInputStream", "Lkotlin/Function0;", "Ljava/io/InputStream;", "readSafely$memory_obricRelease", "input", "maxBytes", "read$memory_obricRelease", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f10961a = null;

    static {
        f10961a = new n();
    }

    private n() {
    }

    private static final InputStream a(AssetFileDescriptor r2) {
        return (InputStream) ZeusTransformUtils.preCheckCast(r2.createInputStream(), InputStream.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ String a(n r0, InputStream r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 1048576;
    L6:
        return r0.a(r1, r2);
    }

    public static /* synthetic */ InputStream lambda$ppHAR6dQ82fFUefzQ2JmyGfoxdA(AssetFileDescriptor r0) {
        return a(r0);
    }

    public final String a(InputStream r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "input");
        ByteArrayOutputStream r11 = new ByteArrayOutputStream(Math.min(r13, 8192));
        byte[] r0 = new byte[8192];
        int r2 = 0;
    L3:
        int r3 = r12.read(r0);
        if (r3 < 0) goto L11;
        if (r3 == 0) goto L3;
        r2 = r2 + r3;
        if (r2 > r13) goto L8;
        r11.write(r0, 0, r3);
        goto L3
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryFeedbackTranscript", "skip transcript because file exceeds maxBytes=" + r13, null, 4, null);
        return null;
    L11:
        String r14 = r11.toString(Charsets.UTF_8.name());
        Intrinsics.checkNotNull(r14);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L14;
        return null;
    L14:
        return r14;
    }

    public final String a(String r9) {
        FileEntity r10 = com.obric.memorydata.personalcontext.util.f.c(r9);
        Object r1 = null;
        if (r10 != null) goto L41;
        return null;
    L41:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L29
        n r8 = (n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        UriFileAccessSession r11 = (UriFileAccessSession) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryFeedbackTranscriptReader$read$1$accessSession$1(r10, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), UriFileAccessSession.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        if (r11 == null) goto L8;
        AssetFileDescriptor r3 = r11.getFd();     // Catch: Throwable -> L29
    L9:
        if (r3 != null) goto L19;
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        StringBuilder r12 = new StringBuilder().append("open transcript failed, status=");     // Catch: Throwable -> L29
        if (r11 == null) goto L13;
        Integer r5 = Integer.valueOf(r11.getStatus());     // Catch: Throwable -> L29
    L14:
        StringBuilder r13 = r12.append(r5).append(", message=");     // Catch: Throwable -> L29
        if (r11 == null) goto L17;
        String r14 = r11.getMessage();     // Catch: Throwable -> L29
    L18:
        IRunLog.a.a(r4, "MemoryFeedbackTranscript", r13.append(r14).toString(), null, 4, null);     // Catch: Throwable -> L29
        String r15 = null;
    L22:
        Object r16 = Result.m1421constructorimpl(r15);     // Catch: Throwable -> L29
    L31:
        Throwable r17 = Result.m1424exceptionOrNullimpl(r16);
        if (r17 != null) goto L34;
        r1 = r16;
    L36:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
    L34:
        RunLog.INSTANCE.warn("MemoryFeedbackTranscript", "read transcript failed", r17);
        goto L36
    L17:
        r14 = null;
        goto L18
    L13:
        r5 = null;
        goto L14
    L19:
        Closeable r18 = (Closeable) ZeusTransformUtils.preCheckCast(r3, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        final AssetFileDescriptor r6 = (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r18, AssetFileDescriptor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        r15 = r8.a(new $$Lambda$n$ppHAR6dQ82fFUefzQ2JmyGfoxdA(r6));     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r18, null);     // Catch: Throwable -> L29
        goto L22
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L8:
        r3 = null;
    L29:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L31
    }

    public final String a(Function0<? extends InputStream> r6) {
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "openInputStream");
        Object r0 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L17
        n r5 = (n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        InputStream r8 = (InputStream) ZeusTransformUtils.preCheckCast(r7.invoke(), InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r8 == null) goto L14;
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(r8, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        String r10 = a(r5, (InputStream) ZeusTransformUtils.preCheckCast(r9, InputStream.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r9, null);     // Catch: Throwable -> L17
    L15:
        Object r11 = Result.m1421constructorimpl(r10);     // Catch: Throwable -> L17
    L19:
        Throwable r12 = Result.m1424exceptionOrNullimpl(r11);
        if (r12 != null) goto L22;
        r0 = r11;
    L24:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    L22:
        RunLog.INSTANCE.warn("MemoryFeedbackTranscript", "read transcript input stream failed", r12);
        goto L24
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L14:
        r10 = null;
    L17:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L19
    }
}
