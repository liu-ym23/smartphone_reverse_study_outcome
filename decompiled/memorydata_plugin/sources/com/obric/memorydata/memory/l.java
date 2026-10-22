package com.obric.memorydata.memory;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0005J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/InAppSignalPayloadDecoder;", "", "<init>", "()V", "MAX_INFLATED_BYTES", "", "ENCODING_GZIP_JSON", "", "decode", "encoding", "plainJson", "gzipPayload", "", "originalBytes", "decodeGzip", "payload", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f10234a = null;

    static {
        f10234a = new l();
    }

    private l() {
    }

    public final String a(String r2, String r3, byte[] r4, int r5) {
        if (r2 != null) goto L4;
        return r3;
    L4:
        if (Intrinsics.areEqual(r2, "") == false) goto L7;
        return r3;
    L7:
        if (Intrinsics.areEqual(r2, ObricMemoryConstants.VALUE_IN_APP_SIGNALS_ENCODING_GZIP_JSON) == true) goto L12;
        return null;
    L12:
        return a(r4, r5);
    }

    public final String a(byte[] r12, int r13) {
        Object r1 = null;
        if (r12 == null) goto L55;
        boolean r3 = true;
        if (r12.length != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L55;
        if (r13 <= 0) goto L55;
        if (r13 > 1048576) goto L55;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L47
        l r11 = (l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        Closeable r14 = (Closeable) ZeusTransformUtils.preCheckCast(new GZIPInputStream((InputStream) ZeusTransformUtils.preCheckCast(new ByteArrayInputStream(r12), InputStream.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        GZIPInputStream r15 = (GZIPInputStream) ZeusTransformUtils.preCheckCast(r14, GZIPInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(new ByteArrayOutputStream(Math.min(r13, 8192)), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        ByteArrayOutputStream r7 = (ByteArrayOutputStream) ZeusTransformUtils.preCheckCast(r6, ByteArrayOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        byte[] r8 = new byte[8192];     // Catch: Throwable -> L37
        int r9 = 0;
    L17:
        int r10 = r15.read(r8);     // Catch: Throwable -> L37
        if (r10 == (-1)) goto L27;
        r9 = r9 + r10;     // Catch: Throwable -> L37
        if (r9 > 1048576) goto L22;
        boolean r16 = true;
    L23:
        if (r16 == false) goto L26;
        r7.write(r8, 0, r10);     // Catch: Throwable -> L37
        goto L17
    L26:
        throw new IllegalStateException("in-app signals payload exceeds inflate limit".toString());     // Catch: Throwable -> L37
    L22:
        r16 = false;
        goto L23
    L27:
        if (r9 == r13) goto L30;
        r3 = false;
    L30:
        if (r3 == false) goto L36;
        String r17 = r7.toString(Charsets.UTF_8.name());     // Catch: Throwable -> L37
        CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L42
        CloseableKt.closeFinally(r14, null);     // Catch: Throwable -> L47
        Object r18 = Result.m1421constructorimpl(r17);     // Catch: Throwable -> L47
    L50:
        if (Result.m1427isFailureimpl(r18) == true) goto L54;
        r1 = r18;
    L54:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
    L36:
        throw new IllegalStateException("in-app signals payload size mismatch".toString());     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);     // Catch: Throwable -> L47
        throw th;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r18 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L50
    L7:
        r2 = false;
    L55:
        return null;
    }
}
