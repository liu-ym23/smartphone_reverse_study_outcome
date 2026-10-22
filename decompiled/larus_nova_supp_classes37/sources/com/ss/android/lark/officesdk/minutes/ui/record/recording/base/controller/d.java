package com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.model.MmRecordingSlotKey;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mwb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final Function0<e> a;
    public final Function0<com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.controller.a> b;
    public final Function0<MmRecordingUILaunchMode> c;
    public final Function0<uub.b> d;
    public final Function0<Boolean> e;
    public final Function0<String> f;

    public final void a() {
        e r0 = (e) this.a.invoke();
        com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.controller.a r1 = (com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.controller.a) this.b.invoke();
        if (r1 == null) goto L11;
        ConstraintLayout r2 = (View) ((LinkedHashMap) r1.l).get(MmRecordingSlotKey.TITLE);
        if (r2 != null) goto L10;
        r2 = r1.n;
        if (r2 != null) goto L10;
        r2 = r1.c.e;
    L10:
        if (r2 == null) goto L11;
    L12:
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
    L16:
        if (r4 == null) goto L18;
        int r5 = r4.topMargin;
    L19:
        int r6 = bwb.b.a;
        bwb.b.a(MmUiLogScene.RECORDING, "applyTopSlotOffset", "hasTopOverride=" + ((Boolean) this.e.invoke()).booleanValue() + ", activeTopBarHeight=" + b().getHeight() + ", titleTopMargin=" + r5 + ", navHeight=" + r0.d.getHeight() + ", toolbarHeight=" + r0.g.getHeight() + ", middleSlotHeight=" + r0.f.getHeight(), (String) this.f.invoke());
        return;
    L18:
        r5 = 0;
        goto L19
    L15:
        r4 = null;
    L11:
        r2 = r0.e;
        goto L12
    }

    public final View b() {
        e r0 = (e) this.a.invoke();
        com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.controller.a r1 = (com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.controller.a) this.b.invoke();
        if (r1 == null) goto L7;
        View r2 = r1.e();
        if (r2 == null) goto L7;
        return r2;
    L7:
        return r0.c;
    }

    public final void c(int r3) {
        KeyEvent.Callback r0 = b();
        if ((r0 instanceof a) == false) goto L5;
        a r1 = (a) r0;
    L6:
        if (r1 == null) goto L9;
        r1.setTopPadding(r3);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function0<e> r2, Function0<com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.controller.a> r3, Function0<? extends MmRecordingUILaunchMode> r4, Function0<? extends uub.b> r5, Function0<Boolean> r6, Function0<String> r7) {
        Intrinsics.checkNotNullParameter(r2, "recordingViewProvider");
        Intrinsics.checkNotNullParameter(r3, "slotsControllerProvider");
        Intrinsics.checkNotNullParameter(r4, "uiLaunchModeProvider");
        Intrinsics.checkNotNullParameter(r5, "navRectProviderProvider");
        Intrinsics.checkNotNullParameter(r6, "hasTopSlotOverrideProvider");
        Intrinsics.checkNotNullParameter(r7, "logDetailProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
