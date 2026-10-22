package com.larus.bmhome.view;

import android.content.Context;
import android.util.AttributeSet;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import rs8.n;
import rs8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h4 {
    public static BaseTextAnswerActionButton a(rs8.g r7, Context r8) {
        Intrinsics.checkNotNullParameter(r7, "action");
        Intrinsics.checkNotNullParameter(r8, "context");
        int r1 = 0;
        int r2 = 6;
        AttributeSet r3 = null;
        if ((r7 instanceof rs8.j) == false) goto L6;
        BaseTextAnswerActionButton r0 = new TextAnswerSingleActionButton(r8, null, 6, 0);
    L12:
        FLogger.a.d("TextAnswerActionButtonFactory", "create action type: ".concat(r7.getClass().getName()));
        return r0;
    L6:
        if ((r7 instanceof n) == false) goto L9;
        r0 = new TextAnswerSingleActionButton(r8, null, 6, 0);
        goto L12
    L9:
        if ((r7 instanceof o) == false) goto L11;
        r0 = new TextAnswerMultiActionButton(r8, r3, r2, r1);
        goto L12
    L11:
        FLogger.a.w("TextAnswerActionButtonFactory", "unknown action type: ".concat(r7.getClass().getName()));
        r0 = new TextAnswerSingleActionButton(r8, null, 6, 0);
        goto L12
    }
}
