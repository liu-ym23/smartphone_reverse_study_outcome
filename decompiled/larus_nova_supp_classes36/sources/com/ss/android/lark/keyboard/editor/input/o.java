package com.ss.android.lark.keyboard.editor.input;

import android.widget.EditText;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o {
    public final EditText a;
    public final CharSequence[] b;

    public static final class a {
    }

    static {
    }

    public final void b() {
        CharSequence[] r0 = this.b;
        int r1 = r0.length - 1;
        if (r1 < 0) goto L13;
    L4:
        int r2 = r1 - 1;
        CharSequence r3 = r0[r1];
        if (r3.length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L14;
        if (r2 < 0) goto L13;
        r1 = r2;
    L14:
        if (r3 != null) goto L16;
        r3 = "";
    L16:
        this.a.setHint(r3);
        return;
    L7:
        r4 = false;
    L13:
        r3 = null;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(KeyboardFunctionEditText r4) {
        Intrinsics.checkNotNullParameter(r4, "editor");
        this.a = r4;
        CharSequence[] r0 = new CharSequence[10];
        int r1 = 0;
    L3:
        if (r1 >= 10) goto L5;
        r0[r1] = "";
        r1 = r1 + 1;
        goto L3
    L5:
        this.b = r0;
    }

    public final void a(int r2, CharSequence r3) {
        Intrinsics.checkNotNullParameter(r3, "hint");
        if (r2 >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
        return;
    L10:
        this.b[r2] = r3;
        b();
        return;
    L5:
        if (r2 >= 10) goto L7;
        r0 = true;
        goto L8
    }
}
