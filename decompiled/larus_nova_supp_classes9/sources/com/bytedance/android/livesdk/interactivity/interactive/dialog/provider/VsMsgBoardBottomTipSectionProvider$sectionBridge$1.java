package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.msgboard.DressListTextConfig;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.SkinSelection;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import com.bytedance.android.livesdk.utils.w0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class VsMsgBoardBottomTipSectionProvider$sectionBridge$1 implements j82.f {
    public final /* synthetic */ VsMsgBoardBottomTipSectionProvider a;

    public VsMsgBoardBottomTipSectionProvider$sectionBridge$1(VsMsgBoardBottomTipSectionProvider r1) {
        this.a = r1;
    }

    @Override // j82.f
    public final void h(final SkinSelection r6) {
        if (r6 == null) goto L29;
        k82.a r0 = this.a.b;
        DataCenter r1 = null;
        if (r0 == null) goto L8;
        t9 r2 = r0.s();
        if (r2 == null) goto L8;
        DataCenter r3 = r2.l;
    L10:
        if (r6.a(r3) != true) goto L29;
        VsMsgBoardBottomTipSectionProvider r4 = this.a;
        TextView r5 = r4.d;
        if (r5 == null) goto L26;
        int r7 = n82.c.a;
        k82.a r8 = r4.b;
        if (r8 == null) goto L18;
        t9 r9 = r8.s();
        if (r9 == null) goto L18;
        r1 = r9.l;
    L18:
        com.bytedance.android.livesdk.chatroom.msgboard.b r10 = n82.c.i(r1);
        if (r10 == null) goto L24;
        DressListTextConfig r11 = r10.b();
        if (r11 == null) goto L24;
        String r13 = r11.getPurchaseText();
        if (r13 == null) goto L24;
    L25:
        r5.setText(r13);
    L24:
        r13 = "立即购买";
    L26:
        VsMsgBoardBottomTipSectionProvider.f(this.a, true, r6);
        TextView r14 = this.a.d;
        if (r14 == null) goto L31;
        r14.setOnClickListener(new w0(new VsMsgBoardBottomTipSectionProvider$sectionBridge$1$updateTips$1(this, r6), 500));
        return;
    L31:
        return;
    L8:
        r3 = null;
    L29:
        VsMsgBoardBottomTipSectionProvider.f(this.a, false, r6);
    }

    @Override // j82.f
    public final void l(VSInputSectionType r2) {
        Intrinsics.checkNotNullParameter(r2, "panelType");
        this.a.g = r2;
    }
}
