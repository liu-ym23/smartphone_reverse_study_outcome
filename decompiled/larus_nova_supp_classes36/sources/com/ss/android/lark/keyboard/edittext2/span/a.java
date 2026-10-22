package com.ss.android.lark.keyboard.edittext2.span;

import android.content.Context;
import android.text.Editable;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.larksuite.component.universe_design.color.UDColorUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends CharacterStyle implements f {
    public final Context a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public int f;

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        int r0 = this.f;
        if (r0 == 0) goto L7;
        if (r3 == null) goto L17;
        r3.setColor(r0);
        return;
    L17:
        return;
    L7:
        if (this.e == false) goto L9;
    L14:
        if (r3 == null) goto L21;
        r3.setColor(UDColorUtils.getColor(this.a, 2131102425));
        return;
    L21:
        return;
    L9:
        if (this.d == false) goto L11;
    L12:
        if (r3 == null) goto L19;
        r3.setColor(UDColorUtils.getColor(this.a, 2131106622));
        return;
    L19:
        return;
    L11:
        if (this.c == false) goto L14;
        goto L12
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.k
    public final k.a e(int r1, int r2, Editable r3) {
        return f.a.a(this, r1, r2, r3);
    }

    public a(Context r2, String r3, boolean r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uid");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
