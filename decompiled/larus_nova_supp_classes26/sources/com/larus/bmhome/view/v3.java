package com.larus.bmhome.view;

import android.text.Editable;
import android.text.NoCopySpan;
import android.text.SpannableStringBuilder;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class v3 extends Editable.Factory {
    public final NoCopySpan[] a;

    public v3(NoCopySpan... r2) {
        Intrinsics.checkNotNullParameter(r2, "spans");
        this.a = r2;
    }

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence r9) {
        Intrinsics.checkNotNullParameter(r9, MusicAppletPage.KEY_SOURCE);
        SpannableStringBuilder r0 = SpannableStringBuilder.valueOf(r9);
        NoCopySpan[] r1 = this.a;
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        r0.setSpan(r1[r4], 0, r9.length(), 18);
        r4 = r4 + 1;
        goto L3
    L5:
        return r0;
    }
}
