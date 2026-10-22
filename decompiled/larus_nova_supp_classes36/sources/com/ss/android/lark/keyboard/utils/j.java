package com.ss.android.lark.keyboard.utils;

import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.keyboard.base.r;
import com.ss.android.lark.log.Log;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j {
    public static final boolean a(com.ss.android.lark.keyboard.b r10, Fragment r11, String r12, String r13, Long r14, r r15) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "logTag");
        com.ss.android.lark.keyboard.keyboard2.b r0 = r10.L();
        FragmentActivity r2 = null;
        if ((r0 instanceof com.ss.android.lark.keyboard.base.f) == false) goto L5;
        com.ss.android.lark.keyboard.base.f r5 = (com.ss.android.lark.keyboard.base.f) r0;
    L7:
        if (r5 != null) goto L29;
        Log.w(r12, "sendContentByKeyboardEditor failed: keyboardEditor is not IIMKeyboardEditor");
        return false;
    L29:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        Object r3 = Result.constructor-impl(r5.c());     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r3) == false) goto L17;
        r3 = null;
    L17:
        EditText r4 = (EditText) r3;
        if (r4 != null) goto L21;
        Log.w(r12, "sendContentByKeyboardEditor failed: editor.getEditText() is null");
        return false;
    L21:
        if (r11 == null) goto L23;
        r2 = r11.getActivity();
    L23:
        i r16 = new i(r10, r5, r14, r13, r15, r12);
        if (r2 == null) goto L26;
        r2.runOnUiThread(r16);
        return true;
    L26:
        r4.post(r16);
        return true;
    L12:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L5:
        r5 = null;
        goto L7
    }
}
