package com.ss.android.lark.keyboard.edittext2.base;

import android.widget.EditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface c extends com.ss.android.lark.keyboard.edittext2.base.a {

    public static final class a {
        public static EditText a(c r1) {
            Object r2 = r1.getTarget();
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.widget.EditText");
            return (EditText) r2;
        }
    }
}
