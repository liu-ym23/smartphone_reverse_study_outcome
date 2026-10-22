package com.obric.memorydata.memory.review.provider;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0005¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptCursorCodec;", "", "<init>", "()V", "encode", "", "snapshot", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptSnapshot;", "absoluteOffset", "", "decode", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptCursor;", "encodedCursor", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {
    public e() {
    }

    public final d a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "encodedCursor");
        byte[] r5 = Base64.getUrlDecoder().decode(r4);     // Catch: Throwable -> L9
        Intrinsics.checkNotNullExpressionValue(r5, "decode(...)");     // Catch: Throwable -> L9
        Charset r1 = StandardCharsets.UTF_8;     // Catch: Throwable -> L9
        Intrinsics.checkNotNullExpressionValue(r1, "UTF_8");     // Catch: Throwable -> L9
        JSONObject r0 = new JSONObject(new String(r5, r1));     // Catch: Throwable -> L9
        d r6 = d.f10447a.a(r0);     // Catch: Throwable -> L9
        if (r6 == null) goto L12;
        if (r6.e() == true) goto L8;
        return null;
    L8:
        return r6;
    L12:
        return null;
    L14:
        return null;
    }

    public final String a(k r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "snapshot");
        g r12 = r13.a(r14);
        String r1 = r13.a();
        String r2 = r13.b();
        String r3 = r13.c();
        String r4 = r13.d();
        int r5 = r12.a();
        int r6 = r12.b();
        int r7 = r12.c();
        String r15 = r13.e().substring(0, r14);
        Intrinsics.checkNotNullExpressionValue(r15, "substring(...)");
        String r16 = new d(r1, r2, r3, r4, r5, r6, r7, r14, i.c(r15), r13.f()).d().toString();
        Intrinsics.checkNotNullExpressionValue(r16, "toString(...)");
        Charset r17 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(r17, "UTF_8");
        byte[] r18 = r16.getBytes(r17);
        Intrinsics.checkNotNullExpressionValue(r18, "getBytes(...)");
        String r19 = Base64.getUrlEncoder().withoutPadding().encodeToString(r18);
        Intrinsics.checkNotNullExpressionValue(r19, "encodeToString(...)");
        return r19;
    }
}
