package com.ss.android.lark.officesdk.minutes.ui.record.recording.content;

import androidx.viewpager2.widget.ViewPager2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements Runnable {
    public final /* synthetic */ ViewPager2 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ MmRecordingContentController c;

    public d(ViewPager2 r1, String r2, MmRecordingContentController r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        if (this.a.isAttachedToWindow() == true) goto L6;
        int r0 = bwb.b.a;
        bwb.b.f(MmUiLogScene.CONTENT, "onHostConfigurationChanged", "skip detached pager, reason=" + this.b, this.c.c());
        return;
    L6:
        int r1 = this.a.getWidth();
        int r2 = this.a.getHeight();
        if (r1 <= 0) goto L22;
        if (r2 <= 0) goto L22;
        if (r1 == this.c.i) goto L13;
        boolean r5 = true;
    L14:
        int r7 = bwb.b.a;
        bwb.b.a(MmUiLogScene.CONTENT, "onHostConfigurationChanged", "reason=" + this.b + ", width=" + r1 + ", height=" + r2 + ", lastWidth=" + this.c.i + ", sizeChanged=" + r5, this.c.c());
        MmRecordingContentController.a(this.c);
        if (r5 == true) goto L17;
        return;
    L17:
        this.c.j = true;
        this.a.requestLayout();
        MmRecordingContentController r3 = this.c;
        String r4 = "config_" + this.b;
        if (r3.k == true) goto L24;
        r3.k = true;
        r3.a.b().post(new e(r3, r4));
        return;
    L24:
        return;
    L13:
        r5 = false;
    L22:
        int r6 = bwb.b.a;
        bwb.b.f(MmUiLogScene.CONTENT, "onHostConfigurationChanged", "skip invalid size, reason=" + this.b + ", width=" + r1 + ", height=" + r2, this.c.c());
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
