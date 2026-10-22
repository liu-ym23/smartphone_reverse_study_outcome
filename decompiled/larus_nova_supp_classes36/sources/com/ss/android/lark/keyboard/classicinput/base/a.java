package com.ss.android.lark.keyboard.classicinput.base;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements View.OnKeyListener {
    public final /* synthetic */ EditText a;
    public final /* synthetic */ View b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(KeyboardFunctionEditText r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r2, int r3, KeyEvent r4) {
        Intrinsics.checkNotNullParameter(r2, "v");
        Intrinsics.checkNotNullParameter(r4, "event");
        if (r3 == 66) goto L5;
        return false;
    L5:
        if (r4.getAction() == 0) goto L7;
        return false;
    L7:
        if (r4.isShiftPressed() == true) goto L15;
        if (r4.isCtrlPressed() == true) goto L15;
        if (TextUtils.isEmpty(StringsKt.trim(this.a.getText())) == true) goto L15;
        this.b.performClick();
        return true;
    L15:
        if (TextUtils.isEmpty(StringsKt.trim(this.a.getText())) == false) goto L18;
        return true;
    L18:
        if (r4.isCtrlPressed() == false) goto L20;
    L21:
        this.a.append("\n");
        return true;
    L20:
        if (r4.isShiftPressed() == true) goto L21;
        return false;
    }
}
