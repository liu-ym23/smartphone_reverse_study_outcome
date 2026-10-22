package qc8;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.bmhome.chat.bubble.floating.component.BubbleBannerComponent;
import com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService;
import kotlin.jvm.internal.Intrinsics;
import ns9.t;
import tc8.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ BubbleBannerComponent a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ ViewGroup d;

    public /* synthetic */ g(BubbleBannerComponent r1, int r2, String r3, ViewGroup r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BubbleBannerComponent r0 = this.a;
        int r1 = this.b;
        String r2 = this.c;
        ViewGroup r3 = this.d;
        if (r0.J == r1) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r0.I, r2) == false) goto L36;
        r0.I = null;
        if (Intrinsics.areEqual(r0.n, r2) == true) goto L11;
        return;
    L11:
        if (r0.K == true) goto L13;
        return;
    L13:
        if (r0.B4(r3).a() == false) goto L15;
        return;
    L15:
        if (r0.L == true) goto L21;
        View r4 = r0.t;
        if (r4 == null) goto L19;
        ViewParent r5 = r4.getParent();
    L20:
        if (r5 != null) goto L21;
    L24:
        r r6 = r.a;
        t r7 = r.j;
        if (r7 == null) goto L28;
        r.j = null;
        r.k.remove(r7.a.h);
        r.l.remove(r7.a.h);
        r.m.remove(r7.a.h);
        r.n.remove(r7.a.h);
        r.o.remove(r7.a.h);
        r.z();
    L28:
        r.a r8 = r.h;
        if (r8 == null) goto L31;
        r.o(r8);
    L31:
        r.w();
        return;
    L19:
        r5 = null;
    L21:
        int r9 = com.larus.bmhome.chat.bubble.floating.runtime.k.a;
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        IBubbleBannerRuntimeService r10 = com.larus.bmhome.chat.bubble.floating.runtime.k.c();
        if (r10 == null) goto L24;
        r10.e(r2);
        goto L24
    }
}
