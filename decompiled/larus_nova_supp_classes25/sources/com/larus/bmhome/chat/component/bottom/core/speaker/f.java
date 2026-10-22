package com.larus.bmhome.chat.component.bottom.core.speaker;

import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f implements h {
    public final /* synthetic */ e a;

    public f(e r1) {
        this.a = r1;
    }

    public final void a(g r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        if (this.a.f == true) goto L5;
        return;
    L5:
        FLogger.a.i("ChatSpeakerPressLifecycle", "[" + this.a.d + "][ChatSpeakerStateListener]: receive new state: " + r5);
        if (Intrinsics.areEqual(r5, g.c.a) == false) goto L9;
        e r6 = this.a;
        r6.i = true;
        r6.c(e.c.C0048e.a);
        return;
    L9:
        if ((r5 instanceof g.d) == false) goto L12;
        g.d r7 = (g.d) r5;
        this.a.g = r7.a.length();
        this.a.c(new e.c.f(r7.a));
        return;
    L12:
        if ((r5 instanceof g.e) == false) goto L15;
        e r0 = this.a;
        g.e r8 = (g.e) r5;
        r0.c(new e.c.g(r8.a, r0.g, r8.b));
        this.a.d("speaker_success");
        return;
    L15:
        if (Intrinsics.areEqual(r5, g.b.a) == false) goto L18;
        this.a.c(e.c.b.a);
        this.a.d("speaker_failed");
        return;
    L18:
        if (Intrinsics.areEqual(r5, g.a.a) == false) goto L22;
        e r9 = this.a;
        r9.getClass();
        r9.c(e.c.a.a);
        r9.d("speaker_canceled");
        return;
    L22:
        throw new NoWhenBranchMatchedException();
    }
}
