package com.bytedance.android.livesdk.event;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class d0 implements ISendCommentEvent, k {
    public final String a;
    public final ISendCommentEvent.Sender b;
    public final Map<String, Object> c;
    public final m d;
    public final q e;
    public final boolean f;

    @Override // com.bytedance.android.livesdk.event.ISendCommentEvent
    public final Map<String, Object> a() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.event.k
    public final m b() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.event.k
    public final q c() {
        return this.e;
    }

    public d0(String r2, ISendCommentEvent.Sender r3, Map<String, ? extends Object> r4, m r5, q r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "content");
        Intrinsics.checkNotNullParameter(r3, "sender");
        Intrinsics.checkNotNullParameter(r4, "args");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public /* synthetic */ d0(String r8, ISendCommentEvent.Sender r9, Map r10, m r11, q r12, boolean r13, int r14) {
        if ((r14 & 4) == 0) goto L5;
        r10 = MapsKt.emptyMap();
    L5:
        Map r3 = r10;
        if ((r14 & 8) == 0) goto L8;
        m r4 = null;
    L10:
        if ((r14 & 16) == 0) goto L12;
        q r5 = null;
    L14:
        if ((r14 & 32) == 0) goto L16;
        boolean r6 = false;
    L17:
        this(r8, r9, r3, r4, r5, r6);
        return;
    L16:
        r6 = r13;
        goto L17
    L12:
        r5 = r12;
        goto L14
    L8:
        r4 = r11;
        goto L10
    }
}
