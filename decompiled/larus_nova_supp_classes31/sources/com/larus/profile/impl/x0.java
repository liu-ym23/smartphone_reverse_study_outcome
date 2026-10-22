package com.larus.profile.impl;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.common.apphost.AppHost;
import com.larus.profile.impl.databinding.LarusPageProfileEditBinding;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x0 implements TextWatcher {
    public final /* synthetic */ ProfileEditFragment a;
    public final /* synthetic */ LarusPageProfileEditBinding b;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r8) {
        ProfileEditFragment r0 = this.a;
        Pattern r1 = ProfileEditFragment.r;
        if (r0.aa0() == false) goto L5;
        this.a.W90();
        return;
    L5:
        r38.b r2 = this.a.j;
        String r3 = null;
        if (r2 == null) goto L8;
        String r4 = r2.g();
    L10:
        if (Intrinsics.areEqual(r4, String.valueOf(r8)) == false) goto L16;
        this.b.l.setVisibility(8);
        this.b.r.setVisibility(8);
        LarusPageProfileEditBinding r9 = this.b;
        AppCompatImageView r5 = r9.f;
        if (r9.n.hasFocus() == false) goto L14;
        int r10 = 0;
    L15:
        r5.setVisibility(r10);
        this.b.o.setVisibility(8);
        this.b.q.setVisibility(0);
        this.a.W90();
        return;
    L14:
        r10 = 8;
        goto L15
    L16:
        this.b.l.setVisibility(8);
        this.b.r.setVisibility(8);
        AppCompatImageView r6 = this.b.f;
        boolean r7 = true;
        if (r8 != null) goto L19;
    L22:
        boolean r11 = true;
    L23:
        if (r11 == false) goto L25;
    L27:
        r7 = false;
    L28:
        if (r7 == false) goto L30;
        int r12 = 0;
    L31:
        r6.setVisibility(r12);
        this.a.W90();
        ProfileEditFragment r13 = this.a;
        LarusPageProfileEditBinding r14 = r13.e;
        if (r14 == null) goto L62;
        String r15 = String.valueOf(r14.n.getText());
        if (com.larus.utils.o0.c(r15) >= 4) goto L46;
        r14.q.setVisibility(8);
        r14.o.setVisibility(0);
        if (AppHost.a.isOversea() == false) goto L41;
        AppCompatTextView r16 = r14.p;
        Context r17 = r13.getContext();
        if (r17 == null) goto L40;
        r3 = r17.getString(2131900862);
    L40:
        r16.setText(r3);
    L58:
        Unit r18 = Unit.INSTANCE;
        return;
    L41:
        AppCompatTextView r19 = r14.p;
        Context r20 = r13.getContext();
        if (r20 == null) goto L44;
        r3 = r20.getString(2131909230);
    L44:
        r19.setText(r3);
        goto L58
    L46:
        if (ProfileEditFragment.r.matcher(r15).matches() == true) goto L57;
        r14.q.setVisibility(8);
        r14.o.setVisibility(0);
        if (AppHost.a.isOversea() == false) goto L53;
        AppCompatTextView r21 = r14.p;
        Context r22 = r13.getContext();
        if (r22 == null) goto L52;
        r3 = r22.getString(2131900863);
    L52:
        r21.setText(r3);
        goto L58
    L53:
        AppCompatTextView r23 = r14.p;
        Context r24 = r13.getContext();
        if (r24 == null) goto L56;
        r3 = r24.getString(2131909232);
    L56:
        r23.setText(r3);
        goto L58
    L57:
        r13.Y90().checkUserName(r15);
        goto L58
    L62:
        return;
    L30:
        r12 = 8;
        goto L31
    L25:
        if (this.b.n.hasFocus() == false) goto L27;
    L19:
        if (r8.length() == 0) goto L22;
        r11 = false;
        goto L23
    L8:
        r4 = null;
        goto L10
    }

    public x0(ProfileEditFragment r1, LarusPageProfileEditBinding r2) {
        this.a = r1;
        this.b = r2;
    }
}
