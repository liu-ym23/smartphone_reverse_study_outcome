package com.bytedance.android.livesdk.event;

import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b0 implements ISendCommentEvent {
    public final long a;
    public final int b;
    public final ISendCommentEvent.Sender c;
    public final Map<String, Object> d;
    public final Object e;

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31;
        ISendCommentEvent.Sender r2 = this.c;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        Map<String, Object> r6 = this.d;
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        int r8 = (r5 + r7) * 31;
        Object r9 = this.e;
        if (r9 == null) goto L14;
        r3 = r9.hashCode();
    L14:
        return r8 + r3;
    L9:
        r7 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "SendOGCFixedEmojiEvent(emojiId=" + this.a + ", type=" + this.b + ", sender=" + this.c + ", args=" + this.d + ", commentFlowContext=" + this.e + ")";
    }

    @Override // com.bytedance.android.livesdk.event.ISendCommentEvent
    public final Map<String, Object> a() {
        return this.d;
    }

    public final int getType() {
        return this.b;
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b0) == false) goto L16;
        b0 r7 = (b0) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public b0(long r2, ISendCommentEvent.Sender r4, Map r5, CommentFlowContext r6) {
        Intrinsics.checkNotNullParameter(r4, "sender");
        Intrinsics.checkNotNullParameter(r5, "args");
        this.a = r2;
        this.b = 3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
