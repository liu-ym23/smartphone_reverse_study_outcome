package com.obric.aiproactive.ui.artifact;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tR\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/aiproactive/ui/artifact/DocumentContentReader;", "", "<init>", "()V", "readUtf8", "", "input", "Ljava/io/InputStream;", "limitBytes", "", "MAX_DOCUMENT_BYTES", "DEFAULT_BUFFER_SIZE", "UTF8_BOM", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f6547a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f6548b = null;

    static {
        f6547a = new c();
        f6548b = new byte[]{-17, -69, -65};
    }

    private c() {
    }

    public static /* synthetic */ String a(c r0, InputStream r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 2097152;
    L6:
        return r0.a(r1, r2);
    }

    public final String a(InputStream r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "input");
        ByteArrayOutputStream r4 = new ByteArrayOutputStream(Math.min(r6, 8192));
        byte[] r0 = new byte[8192];
        int r1 = 0;
        int r2 = 0;
    L3:
        int r3 = r5.read(r0);
        if (r3 < 0) goto L10;
        r2 = r2 + r3;
        if (r2 > r6) goto L9;
        r4.write(r0, 0, r3);
        goto L3
    L9:
        throw new DocumentTooLargeException();
    L10:
        byte[] r7 = r4.toByteArray();
        int r8 = r7.length;
        byte[] r9 = f6548b;
        if (r8 < r9.length) goto L15;
        Intrinsics.checkNotNull(r7);
        if (Arrays.equals(ArraysKt.copyOfRange(r7, 0, r9.length), r9) == false) goto L15;
        r1 = r9.length;
    L15:
        String r10 = StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(r7, r1, r7.length - r1)).toString();
        Intrinsics.checkNotNullExpressionValue(r10, "toString(...)");
        return r10;
    }
}
