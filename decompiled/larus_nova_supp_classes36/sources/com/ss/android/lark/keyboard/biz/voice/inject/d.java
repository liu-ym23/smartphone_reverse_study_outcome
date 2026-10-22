package com.ss.android.lark.keyboard.biz.voice.inject;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements TextWatcher {
    public final /* synthetic */ VoiceInnerEndPlugin a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public d(VoiceInnerEndPlugin r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r4, int r5, int r6, int r7) {
        boolean r8 = true;
        if (this.a.s() == false) goto L48;
        VoiceInputPreviewDelegate r9 = this.a.q();
        String r0 = r9.c();
        if (r9.i == true) goto L7;
    L16:
        boolean r1 = false;
    L18:
        if (r9.i == true) goto L20;
    L29:
        boolean r2 = false;
    L30:
        if (r1 == true) goto L46;
        if (r2 == true) goto L46;
        if (r9.m == true) goto L43;
        fya.a.d r3 = r9.b();
        if (r3 != null) goto L38;
    L40:
        boolean r10 = false;
    L41:
        if (r10 == false) goto L43;
        boolean r11 = true;
    L44:
        if (r11 == false) goto L48;
        r9.a(true);
        goto L48
    L38:
        if (r3.isLoading() != true) goto L40;
        r10 = true;
    L43:
        r11 = false;
    L46:
        r9.k = true;
        r9.a(true);
        r9.i = false;
        r9.k = false;
        r9.j = VoiceInputPreviewDelegate.PreviewOriginMode.INPUT_UNFOCUSED;
        r9.l = "";
        goto L48
    L20:
        if (r9.m == true) goto L29;
        if (r0.length() != 0) goto L24;
        boolean r12 = true;
    L25:
        if (r12 == false) goto L29;
        if (r9.a.z().y() == false) goto L29;
        r2 = true;
        goto L30
    L24:
        r12 = false;
        goto L25
    L7:
        if (r9.m == true) goto L16;
        if (r0.length() <= 0) goto L11;
        boolean r13 = true;
    L12:
        if (r13 == false) goto L16;
        if (Intrinsics.areEqual(r0, r9.l) == true) goto L16;
        r1 = true;
        goto L18
    L11:
        r13 = false;
    L48:
        if (this.a.n == false) goto L64;
        if (r4 != null) goto L51;
    L54:
        if (r8 == true) goto L65;
        fya.a r14 = this.a.p();
        if (r14 == null) goto L58;
        r14.y5();
    L58:
        VoiceInnerEndPlugin r15 = this.a;
        wnb.d r16 = r15.e;
        if (r16 == null) goto L61;
        Fragment r17 = r16.a;
    L62:
        r15.m(r17, false);
        return;
    L61:
        r17 = null;
        goto L62
    L65:
        return;
    L51:
        if (r4.length() == 0) goto L54;
        r8 = false;
        goto L54
    }
}
