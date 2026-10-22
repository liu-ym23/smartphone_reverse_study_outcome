package com.ss.android.lark.keyboard.edittext2.span;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface f extends k {

    public static final class a {
        public static k.a b(int r2, int r3, Spannable r4) {
            Intrinsics.checkNotNullParameter(r4, "text");
            Log.d("InlineBlockSpan", "selectImpl: text len : " + r4.length() + ", start: " + r2 + ", end : " + r3);
            Selection.setSelection(r4, r2, r3);
            return new k.a(r2, r3);
        }

        public static k.a a(f r5, int r6, int r7, Editable r8) {
            Intrinsics.checkNotNullParameter(r8, "text");
            Log.d("InlineBlockSpan", "reselect: text len : " + r8.length() + ", start: " + r6 + ", end : " + r7);
            int r0 = r8.getSpanStart(r5);
            int r9 = r8.getSpanEnd(r5);
            int r1 = r0 + 1;
            boolean r2 = false;
            if (r1 > r6) goto L6;
            if (r6 >= r9) goto L6;
            boolean r4 = true;
        L7:
            if (r4 == true) goto L10;
            r0 = r6;
        L10:
            if (r1 > r7) goto L13;
            if (r7 >= r9) goto L13;
            r2 = true;
        L13:
            if (r2 == true) goto L16;
            r9 = r7;
        L16:
            if (r0 != r6) goto L21;
            if (r9 != r7) goto L21;
            return null;
        L21:
            Selection.setSelection(r8, r0, r9);
            return new k.a(r0, r9);
        L6:
            r4 = false;
            goto L7
        }
    }

    k.a a(int r1, int r2, Spannable r3);
}
