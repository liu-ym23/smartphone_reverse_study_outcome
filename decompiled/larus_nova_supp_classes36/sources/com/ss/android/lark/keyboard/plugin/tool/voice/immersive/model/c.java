package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public final RichText a;
    public final SpannableStringBuilder b;
    public final boolean c;
    public final Boolean d;
    public final String e;
    public final boolean f;

    public c(RichText r2, SpannableStringBuilder r3, boolean r4, Boolean r5, String r6, boolean r7, int r8) {
        if ((r8 & 2) == 0) goto L6;
        r3 = new SpannableStringBuilder();
    L6:
        if ((r8 & 8) == 0) goto L9;
        r5 = Boolean.FALSE;
    L9:
        if ((r8 & 16) == 0) goto L12;
        r6 = null;
    L12:
        if ((r8 & 32) == 0) goto L14;
        r7 = false;
    L14:
        Intrinsics.checkNotNullParameter(r2, "richTextResult");
        Intrinsics.checkNotNullParameter(r3, "loadingSpan");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
