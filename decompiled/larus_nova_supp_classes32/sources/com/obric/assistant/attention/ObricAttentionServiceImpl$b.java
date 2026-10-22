package com.obric.assistant.attention;

import com.obric.assistant.util.m;
import kotlin.jvm.internal.Intrinsics;
import oba.a;
import oba.b;
import oba.g;
import oba.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricAttentionServiceImpl$b implements b {
    public final a a;
    public final long b;
    public volatile boolean c;
    public boolean d;
    public final ObricAttentionServiceImpl$a e;
    public final h f;
    public final /* synthetic */ ObricAttentionServiceImpl g;

    @Override // oba.b
    public final void cancel() {
        this.c = true;
        final ObricAttentionServiceImpl r0 = this.g;
        r0.a.post(new g(r0, this));
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [oba.h] */
    public ObricAttentionServiceImpl$b(final ObricAttentionServiceImpl r2, m r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.g = r2;
        this.a = r3;
        this.b = r4;
        this.e = new ObricAttentionServiceImpl$a(r2, this);
        this.f = new h(r2, this);
    }
}
