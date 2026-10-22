package com.ss.ugc.live.sdk.msg.data;

import com.ss.ugc.live.sdk.msg.network.g;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tlc.d;
import tlc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class a {
    public g a;
    public f b;
    public boolean c;
    public final SdkResponse d;
    public final List<d> e;
    public final c f;

    public final String a() {
        g r0 = this.a;
        String r1 = null;
        if (r0 == null) goto L6;
        if (r0 == null) goto L10;
        List<com.ss.ugc.live.sdk.msg.network.d> r2 = r0.c;
    L11:
        int r3 = com.ss.ugc.live.sdk.msg.utils.c.a;
        if (r2 == null) goto L23;
        Iterator<T> r4 = r2.iterator();
    L15:
        if (r4.hasNext() == false) goto L19;
        Object r5 = r4.next();
        if (StringsKt.equals("im-cursor", ((com.ss.ugc.live.sdk.msg.network.d) r5).a, true) == false) goto L15;
    L20:
        com.ss.ugc.live.sdk.msg.network.d r6 = (com.ss.ugc.live.sdk.msg.network.d) r5;
        if (r6 == null) goto L23;
        r1 = r6.b;
        goto L23
    L19:
        r5 = null;
    L23:
        if (r1 == null) goto L26;
        return r1;
    L26:
        return this.d.cursor;
    L10:
        r2 = null;
        goto L11
    L6:
        f r7 = this.b;
        if (r7 == null) goto L10;
        if (r7 == null) goto L10;
        r2 = r7.f;
        goto L11
    }

    public final String b() {
        g r0 = this.a;
        List<com.ss.ugc.live.sdk.msg.network.d> r1 = null;
        if (r0 == null) goto L6;
        if (r0 == null) goto L10;
        r1 = r0.c;
    L10:
        String r2 = com.ss.ugc.live.sdk.msg.utils.c.a(r1);
        if (r2 == null) goto L14;
        return r2;
    L14:
        return this.d.internal_ext;
    L6:
        f r3 = this.b;
        if (r3 == null) goto L10;
        if (r3 == null) goto L10;
        r1 = r3.f;
        goto L10
    }

    public /* synthetic */ a(SdkResponse r2, List r3) {
        this(r2, r3, new c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(SdkResponse r2, List<? extends d> r3, c r4) {
        Intrinsics.checkNotNullParameter(r2, "response");
        Intrinsics.checkNotNullParameter(r3, "decodeMessages");
        Intrinsics.checkNotNullParameter(r4, "sdkStat");
        this.d = r2;
        this.e = r3;
        this.f = r4;
    }
}
