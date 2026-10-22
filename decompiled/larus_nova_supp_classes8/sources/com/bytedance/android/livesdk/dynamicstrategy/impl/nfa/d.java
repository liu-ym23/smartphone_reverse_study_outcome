package com.bytedance.android.livesdk.dynamicstrategy.impl.nfa;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.t;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements j {
    public int a;
    public m b;
    public boolean c;
    public final String d;
    public final String e;
    public final t f;
    public final long g;
    public final l h;
    public final com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.a i;
    public final c j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.j
    public final void a(long r7) {
        int r8 = this.f.d();
        if (r8 != 1) goto L5;
    L10:
        b(true, "Pattern TimeOut");
        return;
    L5:
        if (r8 == 2) goto L10;
        if (r8 != 4) goto L13;
        c r0 = this.j;
        String r1 = this.e;
        com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.a r9 = this.i;
        r0.d(r1, r9.b, r9.c);
        return;
    }

    public final void b(boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "stopReason");
        int r0 = b.a;
        b.c(this.d, "NoneEvent", this.i.a + "_:" + this.f.e(), r5);
        this.c = true;
        this.a = 0;
        if (r4 == true) goto L9;
        m r6 = this.b;
        if (r6 == null) goto L9;
        l r7 = this.h;
        if (r7 == null) goto L9;
        r7.c(r6);
    L9:
        this.b = null;
    }

    public d(String r3, String r4, t r5, long r6, l r8, com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.a r9, c r10) {
        Intrinsics.checkNotNullParameter(r3, "roomId");
        Intrinsics.checkNotNullParameter(r4, "nfaName");
        Intrinsics.checkNotNullParameter(r5, "pattern");
        Intrinsics.checkNotNullParameter(r9, "cepNfaStateWrapper");
        Intrinsics.checkNotNullParameter(r10, "moveToNextCallback");
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        if (r5.g() <= 0) goto L9;
        m r7 = new m(r9.a + '_' + r5.e(), System.nanoTime() + (((long) (r5.g() * BubbleId.PadCast)) * 1000000), this);
        if (r8 == null) goto L7;
        r8.b(r7);
    L7:
        Unit r11 = Unit.INSTANCE;
        this.b = r7;
        return;
    }
}
