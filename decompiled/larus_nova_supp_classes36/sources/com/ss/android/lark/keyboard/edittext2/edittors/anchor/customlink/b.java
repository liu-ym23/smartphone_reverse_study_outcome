package com.ss.android.lark.keyboard.edittext2.edittors.anchor.customlink;

import android.content.Context;
import android.text.Editable;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.keyboard.edittext2.span.k;
import com.ss.android.lark.keyboard.edittext2.widget.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends CharacterStyle implements f, com.ss.android.lark.keyboard.edittext2.span.f {
    public final Context a;

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        if (r3 == null) goto L5;
        r3.setColor(UDColorUtils.getColor(this.a, 2131106616));
        return;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.k
    public final k.a e(int r1, int r2, Editable r3) {
        return com.ss.android.lark.keyboard.edittext2.span.f.a.a(this, r1, r2, r3);
    }
}
