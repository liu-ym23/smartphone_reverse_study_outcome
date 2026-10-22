package h82;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.widget.EditText;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.SkinSelection;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardPortraitInputDialog;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.o;
import com.bytedance.android.livesdkapi.interact.IVSInputDialog;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import i40.h;
import j82.e;
import j82.f;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nq1.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends k82.a {
    public final /* synthetic */ VSMsgBoardPortraitInputDialog h;
    public final /* synthetic */ f i;
    public final /* synthetic */ j82.a j;
    public final /* synthetic */ j82.c k;
    public final /* synthetic */ e l;

    @Override // k82.a
    public final void v() {
    }

    @Override // k82.a
    public final void B() {
        VSInputPanelSectionContainer r0 = this.h.s;
        if (r0 == null) goto L5;
        VSInputPanelSectionContainer.d(r0, VSInputSectionType.PAID_LIVE_PACKAGE, null, 6);
    L5:
        f r1 = this.i;
        if (r1 == null) goto L9;
        r1.l(VSInputSectionType.PAID_LIVE_PACKAGE);
        return;
    }

    @Override // k82.a
    public Activity getActivity() {
        return this.h.getActivity();
    }

    @Override // k82.a
    public Context getContext() {
        return this.h.getContext();
    }

    @Override // k82.a
    public final void p() {
        this.h.dismissInputDialog();
    }

    @Override // k82.a
    public final VSInputSectionType q() {
        VSInputPanelSectionContainer r0 = this.h.s;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurrentSectionType();
    }

    @Override // k82.a
    public final DataCenter r() {
        return this.h.i;
    }

    @Override // k82.a
    public final t9 s() {
        return this.h.d;
    }

    @Override // k82.a
    public final int t() {
        VSInputPanelSectionContainer r0 = this.h.s;
        if (r0 != null) goto L5;
    L7:
        VSInputPanelSectionContainer r1 = this.h.s;
        if (r1 != null) goto L13;
        return 0;
    L13:
        return r1.getKeyboardHeight();
    L5:
        if (r0.getKeyboardHeight() != 0) goto L7;
        com.bytedance.android.livesdk.sharedpref.e r2 = d.a;
        return ((Number) d.v.getValue()).intValue();
    }

    @Override // k82.a
    public final boolean u() {
        DataCenter r0 = this.h.i;
        if (r0 == null) goto L7;
        Boolean r1 = (Boolean) r0.get("data_is_anchor", Boolean.FALSE);
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return false;
    }

    @Override // k82.a
    public final void x() {
        VSMsgBoardPortraitInputDialog r0 = this.h;
        k82.a r1 = r0.g;
        if (r1 == null) goto L7;
        EditText r2 = r1.a;
        if (r2 == null) goto L7;
        Editable r3 = r2.getText();
    L8:
        if (r3 != null) goto L10;
        h.a("V3 send click error, text null");
        return;
    L10:
        k82.a r4 = r0.g;
        if (r4 == null) goto L37;
        EditText r5 = r4.a;
        if (r5 == null) goto L38;
        Editable r6 = r5.getText();
        if (r6 == null) goto L41;
        String r7 = r6.toString();
        if (StringsKt.isBlank(r7) == false) goto L20;
        h.a("send click error, invalide content ");
        return;
    L20:
        IVSInputDialog.InputListener r8 = r0.e;
        if (r8 != null) goto L24;
        h.a("V3 send click error, listener null");
        return;
    L24:
        if (r0.l == true) goto L42;
        boolean r9 = true;
        r0.l = true;
        Map<String, String> r10 = r0.W90();
        if (((Boolean) nq1.b.a.getValue()).booleanValue() == false) goto L33;
        k82.a r11 = r0.g;
        if (r11 == null) goto L33;
        if (r11.m() != true) goto L33;
    L34:
        r8.onSendMessage(r7, r10, r9);
        return;
    L33:
        r9 = false;
        goto L34
    L42:
        return;
    L41:
        return;
    L38:
        return;
    L37:
        return;
    L7:
        r3 = null;
        goto L8
    }

    @Override // k82.a
    public final void z() {
        VSInputPanelSectionContainer r0 = this.h.s;
        if (r0 == null) goto L5;
        VSInputPanelSectionContainer.d(r0, VSInputSectionType.EMOJI, null, 6);
    L5:
        f r1 = this.i;
        if (r1 == null) goto L9;
        r1.l(VSInputSectionType.EMOJI);
        return;
    }

    @Override // k82.a
    public final void A() {
        k();
        VSInputPanelSectionContainer r0 = this.h.s;
        if (r0 == null) goto L5;
        VSInputPanelSectionContainer.d(r0, VSInputSectionType.KEYBOARD, null, 6);
    L5:
        f r1 = this.i;
        if (r1 == null) goto L9;
        r1.l(VSInputSectionType.KEYBOARD);
        return;
    }

    @Override // k82.a
    public final void C(String r4) {
        VSMsgBoardPortraitInputDialog r0 = this.h;
        SkinSelection r1 = r0.v;
        if (r1 == null) goto L9;
        t9 r2 = r0.d;
        if (r2 == null) goto L7;
        DataCenter r3 = r2.l;
    L8:
        r1.d = SkinSelection.DressType.BADGE;
        r1.b = r4;
        r1.b(r3);
        goto L9
    L7:
        r3 = null;
    L9:
        j82.a r5 = this.j;
        if (r5 == null) goto L12;
        r5.f(this.h.v);
    L12:
        f r6 = this.i;
        if (r6 == null) goto L15;
        r6.h(this.h.v);
    L15:
        j82.c r7 = this.k;
        if (r7 == null) goto L19;
        r7.n(this.h.v);
        return;
    }

    @Override // k82.a
    public final void D(String r4) {
        VSMsgBoardPortraitInputDialog r0 = this.h;
        SkinSelection r1 = r0.v;
        if (r1 == null) goto L9;
        t9 r2 = r0.d;
        if (r2 == null) goto L7;
        DataCenter r3 = r2.l;
    L8:
        r1.d = SkinSelection.DressType.SKIN;
        r1.a = r4;
        r1.b(r3);
        goto L9
    L7:
        r3 = null;
    L9:
        j82.a r5 = this.j;
        if (r5 == null) goto L12;
        r5.f(this.h.v);
    L12:
        f r6 = this.i;
        if (r6 == null) goto L15;
        r6.h(this.h.v);
    L15:
        j82.c r7 = this.k;
        if (r7 == null) goto L19;
        r7.n(this.h.v);
        return;
    }

    @Override // k82.a
    public final void w(boolean r4) {
        if (r4 == false) goto L32;
        int r0 = n82.c.a;
        t9 r1 = this.h.d;
        SkinSelection.DressType r2 = null;
        if (r1 == null) goto L6;
        DataCenter r3 = r1.l;
    L7:
        com.bytedance.android.livesdk.chatroom.msgboard.b r5 = n82.c.i(r3);
        if (r5 == null) goto L10;
        List r6 = r5.a();
    L12:
        if (CollectionUtils.isEmpty(r6) == true) goto L19;
        if (r5 == null) goto L15;
        List r7 = r5.c();
    L17:
        if (CollectionUtils.isEmpty(r7) == true) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L32;
        SkinSelection r9 = this.h.v;
        if (r9 == null) goto L25;
        r2 = r9.d;
    L25:
        if (r2 != SkinSelection.DressType.BADGE) goto L29;
        e r10 = this.l;
        if (r10 == null) goto L36;
        r10.j(r4);
        return;
    L36:
        return;
    L29:
        e r11 = this.l;
        if (r11 == null) goto L38;
        r11.scrollToTop(r4);
        return;
    L38:
        return;
    L15:
        r7 = null;
    L19:
        r8 = false;
        goto L20
    L10:
        r6 = null;
        goto L12
    L6:
        r3 = null;
    L32:
        e r13 = this.l;
        if (r13 == null) goto L40;
        r13.scrollToTop(r4);
        return;
    }

    @Override // k82.a
    public final void y(o r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        VSInputPanelSectionContainer r1 = this.h.s;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "listener");
        r1.j.add(r3);
        return;
    }

    public b(VSMsgBoardPortraitInputDialog r1, f r2, j82.a r3, j82.c r4, e r5, j82.d r6, j82.b r7, j82.a r8, j82.d r9, j82.b r10, j82.c r11, e r13, f r14) {
        this.h = r1;
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.l = r5;
        super(r8, r9, r10, r11, r13, r14);
    }
}
