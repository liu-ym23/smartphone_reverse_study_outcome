package com.ss.android.lark.keyboard.editor;

import android.text.Editable;
import android.view.KeyEvent;
import android.widget.EditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements lob.a {
    public final /* synthetic */ FlowChatKeyboardEditor a;

    @Override // lob.a, android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // lob.a, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // lob.a
    public final void r(Editable r1, int r2, int r3) {
    }

    @Override // lob.a
    public final boolean z(int r1, KeyEvent r2) {
        return false;
    }

    public h(FlowChatKeyboardEditor r1) {
        this.a = r1;
    }

    @Override // lob.a
    public final void j(EditText r2) {
        Intrinsics.checkNotNullParameter(r2, "editText");
    }

    @Override // lob.a, android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        if (r1 != null) goto L4;
    L7:
        boolean r5 = true;
    L8:
        if (r5 == false) goto L11;
        this.a.B();
        return;
    L11:
        return;
    L4:
        if (r1.length() == 0) goto L7;
        r5 = false;
        goto L8
    }
}
