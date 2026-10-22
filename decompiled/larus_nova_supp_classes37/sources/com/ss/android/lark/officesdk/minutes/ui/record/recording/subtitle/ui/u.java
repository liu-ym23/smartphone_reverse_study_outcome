package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.MmSubtitleScrollMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class u implements Runnable {
    public final /* synthetic */ MmSubtitleScrollHelper a;

    public u(MmSubtitleScrollHelper r1) {
        this.a = r1;
    }

    public final void a() {
        MmSubtitleScrollHelper r0 = this.a;
        String r1 = r0.h;
        if (r1 != null) goto L5;
        return;
    L5:
        r0.h = null;
        if (r0.f != MmSubtitleScrollMode.FOLLOW) goto L30;
        w r2 = r0.d;
        if (r2.e == true) goto L31;
        Intrinsics.checkNotNullParameter(r1, "source");
        if (r2.b == true) goto L12;
        return;
    L12:
        if (r2.e == true) goto L36;
        boolean r3 = r2.d();
        int r4 = bwb.b.a;
        bwb.b.g(MmUiLogScene.SUBTITLE, "recheckAfterItemHeightChanged", "full=" + r3 + ", stackFromEnd=" + r2.d + ", source=" + r1, null, 8);
        if (r3 == false) goto L24;
        if (r2.d == true) goto L20;
        r2.f(true, r1);
        return;
    L20:
        if (r2.c.getItemCount() <= 0) goto L37;
        LinearLayoutManager r5 = r2.c;
        r5.scrollToPositionWithOffset(r5.getItemCount() - 1, 0);
        return;
    L37:
        return;
    L24:
        if (r2.d == false) goto L27;
        r2.d = false;
        r2.c.setStackFromEnd(false);
    L27:
        if (r2.c.getItemCount() <= 0) goto L35;
        r2.c.scrollToPositionWithOffset(0, 0);
        return;
    L35:
        return;
    L36:
        return;
    L31:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
