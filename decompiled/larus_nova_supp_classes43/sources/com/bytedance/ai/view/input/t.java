package com.bytedance.ai.view.input;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t implements TextWatcher {
    public final /* synthetic */ ChatInput a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r10, int r11, int r12) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r10, int r11, int r12) {
    }

    public t(ChatInput r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r10) {
        Function0<z0<FloatingChatStatus>> r0 = this.a.getChatStatus();
        if (r0 == null) goto L17;
        z0 r1 = (z0) r0.invoke();
        if (r1 == null) goto L18;
        if (r10 != null) goto L8;
    L11:
        boolean r11 = true;
    L12:
        if (r11 == false) goto L14;
        FloatingChatStatus r12 = FloatingChatStatus.READY_TO_INPUT;
    L15:
        r1.tryEmit(r12);
        return;
    L14:
        r12 = FloatingChatStatus.READY_TO_SEND;
        goto L15
    L8:
        if (r10.length() == 0) goto L11;
        r11 = false;
        goto L12
    L18:
        return;
    }
}
