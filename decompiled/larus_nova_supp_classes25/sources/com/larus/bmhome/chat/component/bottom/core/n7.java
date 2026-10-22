package com.larus.bmhome.chat.component.bottom.core;

import android.text.Editable;
import android.widget.EditText;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n7 implements Runnable {
    public final /* synthetic */ EditText a;
    public final /* synthetic */ CoreInputComponent b;

    public n7(EditText r1, CoreInputComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Editable r0 = this.a.getEditableText();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L13;
        FLogger.a.i("CoreInputComponent", "inputText afterTextChanged: inputText.editableText is null or empty");
        return;
    L13:
        if (Intrinsics.areEqual(this.b.Jn(), "") == true) goto L15;
        this.b.bm("");
    L15:
        int r3 = this.b.Q5();
        EditText r4 = this.b.V4();
        if (r4 != null) goto L18;
    L20:
        r1 = false;
    L21:
        if (r1 == true) goto L24;
        this.b.c70(r3);
        return;
    L24:
        return;
    L18:
        if (r4.getMaxHeight() != r3) goto L20;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
