package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardPortraitInputDialog;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements k82.d {
    public final VSInputSectionType a;
    public k82.a b;
    public final a c;
    public boolean d;
    public View e;
    public vr1.f f;

    public static final class a implements j82.b {
        public final /* synthetic */ i a;

        public a(i r1) {
            this.a = r1;
        }

        @Override // j82.b
        public final void a(EditText r4) {
            KeyEvent r0 = new KeyEvent(0, 67);
            if (r4 == null) goto L6;
            r4.dispatchKeyEvent(r0);
            return;
        }

        @Override // j82.b
        public final void g(boolean r2) {
            if (((Boolean) nq1.b.a.getValue()).booleanValue() == false) goto L8;
            vr1.f r0 = this.a.f;
            if (r0 == null) goto L9;
            r0.a(r2);
            return;
        L9:
            return;
        }

        @Override // j82.b
        public final void b(BaseEmoji r3, String r4, EditText r5) {
            if (r5 != null) goto L4;
            return;
        L4:
            if (r3 != null) goto L6;
            return;
        L6:
            k82.a r6 = this.a.b;
            if (r6 == null) goto L9;
            int r7 = r6.e();
        L11:
            if (r7 <= 200) goto L14;
            f2.c(s1.C(2131917443, new Object[]{200}), 1);
            return;
        L14:
            if (TextUtils.isEmpty(r3.getDescription()) == false) goto L16;
            return;
        L16:
            r5.getText().insert(r5.getSelectionStart(), com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.g().c(r3.getDescription(), VSMsgBoardPortraitInputDialog.x));
            return;
        L9:
            r7 = 1;
            goto L11
        }
    }

    @Override // k82.d
    public final void a() {
    }

    @Override // k82.d
    public final k82.c c() {
        return null;
    }

    @Override // k82.d
    public final void d() {
    }

    @Override // k82.d
    public final void e() {
        k82.a r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = VSInputPanelSectionContainer.k;
        int r2 = VSInputPanelSectionContainer.k;
        if (r0.t() == 0) goto L8;
        r2 = r0.t();
    L8:
        View r3 = this.e;
        if (r3 == null) goto L12;
        a1.k(r3, r2);
        return;
    }

    public i() {
        this.a = VSInputSectionType.EMOJI;
        this.c = new a(this);
    }

    @Override // k82.d
    public final VSInputSectionType b() {
        return this.a;
    }

    @Override // k82.d
    public final View g(final h82.b r11) {
        Intrinsics.checkNotNullParameter(r11, "panelBridge");
        this.b = r11;
        if (this.d == true) goto L40;
        if (((Boolean) nq1.b.a.getValue()).booleanValue() == false) goto L23;
        vr1.g r3 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.g();
        int r0 = VSInputPanelSectionContainer.k;
        t9 r1 = r11.h.d;
        if (r1 != null) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r1 != null) goto L15;
    L17:
        boolean r5 = false;
    L18:
        com.bytedance.android.livesdk.chatroom.vs_host.impl.f r13 = r3.f(r4, r5, new VSMsgBoardEmojiSectionProvider$tryInitEmojiPanel$1(r11), new VSMsgBoardEmojiSectionProvider$tryInitEmojiPanel$2(r11), new VSMsgBoardEmojiSectionProvider$tryInitEmojiPanel$3(r11), new VSMsgBoardEmojiSectionProvider$tryInitEmojiPanel$4(r11));
        this.f = r13;
        if (r13 == null) goto L21;
        View r14 = r13.b();
    L22:
        this.e = r14;
    L35:
        ViewGroup.LayoutParams r15 = new ViewGroup.LayoutParams(-1, VSInputPanelSectionContainer.k);
        View r2 = this.e;
        if (r2 == null) goto L38;
        r2.setLayoutParams(r15);
    L38:
        this.d = true;
        goto L40
    L21:
        r14 = null;
        goto L22
    L15:
        if (r1.g != true) goto L17;
        r5 = true;
        goto L18
    L10:
        if (r1.h != true) goto L12;
        r4 = true;
        goto L13
    L23:
        vr1.g r6 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.g();
        int r7 = VSInputPanelSectionContainer.k;
        t9 r8 = r11.h.d;
        if (r8 != null) goto L26;
    L28:
        boolean r9 = false;
    L29:
        if (r8 != null) goto L31;
    L33:
        boolean r10 = false;
    L34:
        this.e = r6.d(r9, r10, new VSMsgBoardEmojiSectionProvider$tryInitEmojiPanel$5(r11), new VSMsgBoardEmojiSectionProvider$tryInitEmojiPanel$6(r11), new VSMsgBoardEmojiSectionProvider$tryInitEmojiPanel$7(r11));
        goto L35
    L31:
        if (r8.g != true) goto L33;
        r10 = true;
        goto L34
    L26:
        if (r8.h != true) goto L28;
        r9 = true;
    L40:
        return this.e;
    }

    @Override // k82.d
    public final void h(VSInputSectionType r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "sectionType");
        Intrinsics.checkNotNullParameter(r3, "view");
        k82.d.a.a(r2, r3);
    }
}
