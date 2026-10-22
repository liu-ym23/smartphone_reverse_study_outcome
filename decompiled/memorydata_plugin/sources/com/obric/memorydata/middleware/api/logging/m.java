package com.obric.memorydata.middleware.api.logging;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ6\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007J&\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u00182\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0002J\u001c\u0010\u001a\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u00182\u0006\u0010\u0011\u001a\u00020\u0007H\u0002¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/middleware/api/logging/MemoryLogFormatter;", "", "<init>", "()V", "normalizeContext", "Lcom/obric/memorydata/middleware/api/logging/NormalizedLogContext;", "biz", "", "context", "Lcom/obric/memorydata/middleware/api/logging/LogContext;", "format", "event", "code", "message", "fields", "Lcom/obric/memorydata/middleware/api/logging/LogFields;", "normalizeMessage", EventBody.KEY_VALUE, "normalizeToken", "normalizeCode", "appendHeader", "", "output", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "key", "appendPart", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f11626a = null;

    static {
        f11626a = new m();
    }

    private m() {
    }

    public static /* synthetic */ String a(m r7, p r8, String r9, String r10, String r11, f r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        String r4 = null;
    L11:
        return r7.a(r8, r3, r4, r11, r12);
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    private final void a(StringBuilder r5, String r6) {
        boolean r1 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        return;
    L8:
        if (r5.length() < 1024) goto L11;
        return;
    L11:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L14;
        r1 = false;
    L14:
        if (r1 == false) goto L16;
        r5.append(' ');
    L16:
        r5.append((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), 0, Math.min(r6.length(), 1024 - r5.length()));
        return;
    L5:
        r4 = false;
        goto L6
    }

    private final void a(StringBuilder r1, String r2, String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        r1.append('[').append(r2).append('=').append(r3).append(']');
    }

    public final p a(String r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "biz");
        Intrinsics.checkNotNullParameter(r3, "context");
        String r0 = r3.a();
        if (r0 == null) goto L6;
        r2 = r0;
    L6:
        String r4 = c(r2);
        String r1 = b(r3.c());
        String r5 = r3.b();
        if (r5 == null) goto L9;
        String r6 = c(r5);
    L11:
        return new p(r4, r1, r6);
    L9:
        r6 = null;
        goto L11
    }

    public final String a(p r4, String r5, String r6, String r7, f r8) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r7, "message");
        Intrinsics.checkNotNullParameter(r8, "fields");
        StringBuilder r0 = new StringBuilder(Math.min(r7.length() + 128, 1024));
        a(r0, "biz", r4.a());
        a(r0, "trace", r4.b());
        a(r0, "stage", r4.c());
        a(r0, "event", r5);
        a(r0, "code", r6);
        a(r0, r7);
        r8.a(r0);
        String r3 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r3, "toString(...)");
        return r3;
    }

    public final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, EventBody.KEY_VALUE);
        return h.f11620a.a(r2, 512);
    }

    public final String b(String r3) {
        Intrinsics.checkNotNullParameter(r3, EventBody.KEY_VALUE);
        return h.f11620a.a(r3, 64, false);
    }

    public final String c(String r3) {
        Intrinsics.checkNotNullParameter(r3, EventBody.KEY_VALUE);
        return h.f11620a.a(r3, 64, true);
    }
}
