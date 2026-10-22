package com.bytedance.android.livesdk.event;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c0 implements ISendCommentEvent {
    public final long a;
    public final int b;
    public final int c;
    public final boolean d;
    public final ISendCommentEvent.Sender e;
    public final Map<String, Object> f;
    public final Object g;
    public final Map<String, String> h;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31) + this.c) * 31;
        boolean r2 = this.d;
        ?? r3 = r2;
        if (r2 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r1 + r3) * 31;
        ISendCommentEvent.Sender r5 = this.e;
        int r6 = 0;
        if (r5 == null) goto L8;
        int r7 = r5.hashCode();
    L9:
        int r8 = (r4 + r7) * 31;
        Map<String, Object> r9 = this.f;
        if (r9 == null) goto L12;
        int r10 = r9.hashCode();
    L13:
        int r11 = (r8 + r10) * 31;
        Object r12 = this.g;
        if (r12 == null) goto L16;
        int r13 = r12.hashCode();
    L17:
        int r14 = (r11 + r13) * 31;
        Map<String, String> r15 = this.h;
        if (r15 == null) goto L21;
        r6 = r15.hashCode();
    L21:
        return r14 + r6;
    L16:
        r13 = 0;
        goto L17
    L12:
        r10 = 0;
        goto L13
    L8:
        r7 = 0;
        goto L9
    }

    public final String toString() {
        return "SendSubscribeEmojiEvent(emojiId=" + this.a + ", type=" + this.b + ", ratioType=" + this.c + ", isNew=" + this.d + ", sender=" + this.e + ", args=" + this.f + ", commentFlowContext=" + this.g + ", extraLogMap=" + this.h + ")";
    }

    @Override // com.bytedance.android.livesdk.event.ISendCommentEvent
    public final Map<String, Object> a() {
        return this.f;
    }

    public final int getType() {
        return this.b;
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c0) == false) goto L22;
        c0 r7 = (c0) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public c0(long r2, int r4, boolean r5, ISendCommentEvent.Sender r6, Map r7, Object r8, Map r9) {
        Intrinsics.checkNotNullParameter(r6, "sender");
        Intrinsics.checkNotNullParameter(r7, "args");
        this.a = r2;
        this.b = 3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
