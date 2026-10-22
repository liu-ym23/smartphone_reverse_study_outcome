package com.ss.android.lark.keyboard.keyboard2;

import android.content.Context;
import com.ss.android.lark.keyboard.ime.ImeWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class KeyboardImeWrapper extends ImeWrapper implements c {
    public static final a D = null;
    public com.ss.android.lark.keyboard.b C;

    public static final class a implements c.a<KeyboardImeWrapper> {
        public a() {
        }
    }

    static {
        D = new a();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void j() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void d() {
        setFocusDelegate(new KeyboardImeWrapper$onAttached$1(this));
    }

    public com.ss.android.lark.keyboard.b getKeyboard() {
        com.ss.android.lark.keyboard.b r0 = this.C;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        return null;
    }

    public KeyboardImeWrapper(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public void setKeyboard(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.C = r2;
    }
}
