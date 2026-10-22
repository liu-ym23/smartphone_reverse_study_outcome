package com.bytedance.android.livesdk.chatroom.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r5 extends ClickableSpan {
    public final int a;
    public final Function0<Unit> b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        this.b.invoke();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
        r2.setColor(this.a);
        r2.setUnderlineText(false);
    }

    public r5(int r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "onClick");
        this.a = r2;
        this.b = r3;
    }
}
