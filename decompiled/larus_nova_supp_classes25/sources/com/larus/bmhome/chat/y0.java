package com.larus.bmhome.chat;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.view.BottomMenuGridLayout;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class y0 implements Runnable {
    public final /* synthetic */ h1 a;
    public final /* synthetic */ int b;

    public /* synthetic */ y0(h1 r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h1 r0 = this.a;
        int r1 = this.b;
        FLogger.a.i(r0.f, "postFrameCallback, setupBottomImmerse");
        com.larus.bmhome.chat.component.bottom.core.speaker.l r2 = r0.a.WF().getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r2 == null) goto L5;
        r2.cl(r1);
    L5:
        int r3 = r0.d(r1);
        r0.b.e.setBackgroundColor(r3);
        BottomMenuGridLayout r4 = r0.b.e;
        int r5 = com.larus.bmhome.chat.immerse.k0.a(r1, 0.1f, 0.35f);
        r4.b = true;
        r4.c = r5;
        Context r6 = r0.a.getContext();
        if (r6 == null) goto L11;
        va8.o r7 = r0.a.WF().getAbility(va8.o.class);
        if (r7 == null) goto L12;
        Intrinsics.checkNotNullParameter(r6, "context");
        r7.AZ(ContextCompat.getColor(r6, 2131106539));
        return;
    L12:
        return;
    }
}
