package com.ss.android.lark.keyboard.edittext.span;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.larksuite.component.universe_design.toast.UDToast;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends ClickableSpan {
    public final Context a;
    public final String b;

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        UDToast.show(this.a, "enters doubao profile, chatterId: " + this.b);
    }

    public a(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chatterId");
        this.a = r2;
        this.b = r3;
    }
}
