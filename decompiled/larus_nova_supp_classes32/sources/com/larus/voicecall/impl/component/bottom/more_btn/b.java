package com.larus.voicecall.impl.component.bottom.more_btn;

import androidx.fragment.app.Fragment;
import com.larus.av_call.util.RealtimeBottomMoreBtn;
import com.larus.voicecall.impl.continue_talk.u1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b extends com.larus.voicecall.impl.component.bottom.a {
    public final Fragment a;
    public final t1a.b b;
    public final Function0<RealtimeBottomMoreBtn> c;
    public int d;
    public jd9.c e;
    public final BottomMoreAction$ctx$1 f;
    public c g;

    public static final class a {
    }

    static {
    }

    public final void a() {
        if ((this.e instanceof jd9.c.a) == true) goto L5;
    L7:
        final boolean r0 = false;
    L8:
        RealtimeBottomMoreBtn r1 = this.f.getHostView();
        if (r1 == null) goto L12;
        r1.post(new com.larus.voicecall.impl.component.bottom.more_btn.a(r0, this));
        return;
    L12:
        return;
    L5:
        if (this.d == 7) goto L7;
        r0 = true;
        goto L8
    }

    public b(w3a.k r2, Fragment r3, t1a.b r4, u1 r5) {
        Intrinsics.checkNotNullParameter(r4, "vCtx");
        Intrinsics.checkNotNullParameter(r5, "hViewProvider");
        super(r2);
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = -1;
        this.e = jd9.c.e.c;
        BottomMoreAction$ctx$1 r6 = new BottomMoreAction$ctx$1(this, r2);
        this.f = r6;
        this.g = new k(r6);
    }
}
