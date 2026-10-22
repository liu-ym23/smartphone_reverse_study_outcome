package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.text.Editable;
import android.widget.TextView;
import com.larus.bmhome.chat.component.bottom.core.m6;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.view.ChatInputText;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q extends f {
    public final ChatInputText e;

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final Object b1() {
        Editable r0 = this.e.getText();
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public q(ChatInputText r2) {
        Intrinsics.checkNotNullParameter(r2, "inputText");
        super(r2);
        this.e = r2;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void T0(m6 r2) {
        this.e.setOnEnterKeySend(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void a(boolean r1) {
        this.e.getClass();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.f, com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void m1(Function1<? super Boolean, Unit> r2) {
        this.e.setVisibilityChangeCallback(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void setText(CharSequence r3) {
        Intrinsics.checkNotNullParameter(r3, ChatDraftItem.TYPE_TEXT);
        this.e.setText(r3, TextView.BufferType.SPANNABLE);
    }
}
