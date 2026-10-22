package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmRecordingNavLayout;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingTopBarView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements MmRecordingNavLayout.b {
    public final /* synthetic */ MmRecordingFragment a;

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmRecordingNavLayout.b
    public final void a() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmRecordingNavLayout.b
    public final void b() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmRecordingNavLayout.b
    public final void d() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmRecordingNavLayout.b
    public final void e() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmRecordingNavLayout.b
    public final void f() {
    }

    public d(MmRecordingFragment r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmRecordingNavLayout.b
    public final void c(boolean r13) {
        if (MmRecordingFragment.da0(this.a) == false) goto L5;
        return;
    L5:
        mwb.h r1 = null;
        if (r13 == false) goto L43;
        MmRecordingTopBarView r14 = this.a.ia0().h;
        if (r14 == null) goto L92;
        mwb.h r9 = r14.a;
        if (r9 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L13:
        if (r9.c.getVisibility() == 0) goto L26;
        mwb.h r10 = r14.a;
        if (r10 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L18:
        if (r10.c.getAlpha() > 0.01f) goto L26;
        int r2 = bwb.b.a;
        MmUiLogScene r3 = MmUiLogScene.TOOLBAR;
        StringBuilder r4 = new StringBuilder("skip, already hidden, alpha=");
        mwb.h r5 = r14.a;
        if (r5 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L22:
        r4.append(r5.c.getAlpha());
        r4.append(", title=");
        mwb.h r15 = r14.a;
        if (r15 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L25:
        r4.append(r15.c.getText());
        bwb.b.b(r3, "hideTitleInBar", r4.toString(), null, 8);
        return;
    L26:
        int r11 = bwb.b.a;
        MmUiLogScene r12 = MmUiLogScene.TOOLBAR;
        StringBuilder r16 = new StringBuilder("start, visibility=");
        mwb.h r6 = r14.a;
        if (r6 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L29:
        r16.append(r6.c.getVisibility());
        r16.append(", alpha=");
        mwb.h r7 = r14.a;
        if (r7 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L32:
        r16.append(r7.c.getAlpha());
        r16.append(", title=");
        mwb.h r8 = r14.a;
        if (r8 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L35:
        r16.append(r8.c.getText());
        bwb.b.b(r12, "hideTitleInBar", r16.toString(), null, 8);
        mwb.h r0 = r14.a;
        if (r0 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L38:
        r0.c.animate().cancel();
        mwb.h r17 = r14.a;
        if (r17 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L42:
        r1.c.animate().alpha(0.0f).setDuration(250).withEndAction(new com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.c(r14)).start();
        return;
    L41:
        r1 = r17;
        goto L42
    L92:
        return;
    L43:
        MmRecordingTopBarView r18 = this.a.ia0().h;
        if (r18 == null) goto L95;
        mwb.h r19 = r18.a;
        if (r19 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L49:
        if (r19.c.getVisibility() != 0) goto L62;
        mwb.h r20 = r18.a;
        if (r20 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L54:
        if (r20.c.getAlpha() < 0.99f) goto L62;
        int r21 = bwb.b.a;
        MmUiLogScene r22 = MmUiLogScene.TOOLBAR;
        StringBuilder r23 = new StringBuilder("skip, already visible, alpha=");
        mwb.h r24 = r18.a;
        if (r24 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r24 = null;
    L58:
        r23.append(r24.c.getAlpha());
        r23.append(", title=");
        mwb.h r110 = r18.a;
        if (r110 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L61:
        r23.append(r110.c.getText());
        bwb.b.b(r22, "showTitleInBar", r23.toString(), null, 8);
        return;
    L62:
        int r25 = bwb.b.a;
        MmUiLogScene r26 = MmUiLogScene.TOOLBAR;
        StringBuilder r111 = new StringBuilder("start, visibility=");
        mwb.h r27 = r18.a;
        if (r27 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r27 = null;
    L65:
        r111.append(r27.c.getVisibility());
        r111.append(", alpha=");
        mwb.h r28 = r18.a;
        if (r28 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r28 = null;
    L68:
        r111.append(r28.c.getAlpha());
        r111.append(", title=");
        mwb.h r29 = r18.a;
        if (r29 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r29 = null;
    L71:
        r111.append(r29.c.getText());
        bwb.b.b(r26, "showTitleInBar", r111.toString(), null, 8);
        mwb.h r30 = r18.a;
        if (r30 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r30 = null;
    L74:
        r30.c.animate().cancel();
        mwb.h r31 = r18.a;
        if (r31 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r31 = null;
    L78:
        if (r31.c.getVisibility() == 0) goto L86;
        mwb.h r32 = r18.a;
        if (r32 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r32 = null;
    L82:
        r32.c.setVisibility(0);
        mwb.h r33 = r18.a;
        if (r33 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r33 = null;
    L85:
        r33.c.setAlpha(0.0f);
    L86:
        mwb.h r34 = r18.a;
        if (r34 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L90:
        r1.c.animate().alpha(1.0f).setDuration(250).withEndAction(new com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.d(r18)).start();
        return;
    L89:
        r1 = r34;
        goto L90
    }
}
