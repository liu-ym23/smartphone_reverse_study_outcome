package com.ss.android.lark.keyboard.utils;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements View.OnKeyListener {
    public boolean a;
    public final /* synthetic */ Function0<Unit> b;

    public c(Function0<Unit> r1) {
        this.b = r1;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r3, int r4, KeyEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if ((r3 instanceof EditText) == false) goto L5;
        EditText r6 = (EditText) r3;
    L7:
        if (r6 != null) goto L10;
        return false;
    L10:
        if (r4 == 66) goto L13;
        return false;
    L13:
        if (r5.getAction() != 0) goto L29;
        if (r5.getRepeatCount() > 0) goto L17;
        this.a = false;
        if (r5.isShiftPressed() == false) goto L22;
        return false;
    L22:
        if (r5.isCtrlPressed() == false) goto L27;
        this.a = true;
        if (TextUtils.isEmpty(StringsKt.trim(r6.getText())) == true) goto L26;
        this.b.invoke();
    L26:
        return true;
    L27:
        return false;
    L17:
        return this.a;
    L29:
        if (r5.getAction() == 1) goto L31;
        return false;
    L31:
        return this.a;
    L5:
        r6 = null;
        goto L7
    }
}
