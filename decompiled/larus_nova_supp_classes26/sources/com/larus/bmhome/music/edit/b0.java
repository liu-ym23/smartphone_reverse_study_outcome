package com.larus.bmhome.music.edit;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.music.databinding.LarusDialogFragmentMusicNameEditBinding;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b0 implements TextWatcher {
    public final /* synthetic */ MusicNameEditSheetDialogFragment a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public b0(MusicNameEditSheetDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r5) {
        if (r5 == null) goto L12;
        CharSequence r6 = StringsKt.trim(r5);
        if (r6 == null) goto L12;
        if (r6.length() != 0) goto L9;
        boolean r7 = true;
    L10:
        if (r7 != true) goto L12;
        boolean r8 = true;
    L13:
        LarusDialogFragmentMusicNameEditBinding r2 = null;
        if (r8 == false) goto L25;
        LarusDialogFragmentMusicNameEditBinding r9 = this.a.l;
        if (r9 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L18:
        r9.c.setClickable(false);
        Context r10 = this.a.getContext();
        if (r10 == null) goto L36;
        LarusDialogFragmentMusicNameEditBinding r0 = this.a.l;
        if (r0 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L24:
        r2.c.setTextColor(ContextCompat.getColor(r10, v19.c.b(2130972081, r10, 2131103143)));
        return;
    L23:
        r2 = r0;
        goto L24
    L36:
        return;
    L25:
        LarusDialogFragmentMusicNameEditBinding r11 = this.a.l;
        if (r11 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L28:
        r11.c.setClickable(true);
        Context r12 = this.a.getContext();
        if (r12 == null) goto L38;
        LarusDialogFragmentMusicNameEditBinding r1 = this.a.l;
        if (r1 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L34:
        r2.c.setTextColor(ContextCompat.getColor(r12, v19.c.b(2130972123, r12, 2131103203)));
        return;
    L33:
        r2 = r1;
        goto L34
    L38:
        return;
    L9:
        r7 = false;
    L12:
        r8 = false;
        goto L13
    }
}
