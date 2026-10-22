package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.text.Spannable;
import android.text.Spanned;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a2<T, R> implements Function {
    public a2(t1.c r1) {
    }

    public final Object apply(Object r11) {
        CharSequence r13 = (CharSequence) r11;
        Intrinsics.checkNotNullParameter(r13, "keyword");
        String r0 = r13.toString();
        if ((r13 instanceof Spannable) == false) goto L28;
        StringBuilder r1 = new StringBuilder();
        Object[] r2 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.x.a((Spanned) r13, r13.length(), com.bytedance.android.livesdk.interactivity.comment.input.b.class);
        if (r2 == null) goto L27;
        int r4 = 0;
        if (r2.length != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L29;
        int r5 = r2.length;
        int r6 = 0;
    L14:
        if (r4 >= r5) goto L20;
        Object r7 = r2[r4];
        Spannable r8 = (Spannable) r13;
        int r9 = r8.getSpanStart(r7);
        int r10 = r8.getSpanEnd(r7);
        if (r6 >= r0.length()) goto L18;
        r1.append(StringsKt.slice(r0, RangesKt.until(r6, r9)));
        r1.append(((com.bytedance.android.livesdk.interactivity.comment.input.b) r7).getDesc());
    L18:
        r4 = r4 + 1;
        r6 = r10;
        goto L14
    L20:
        if (r6 >= r0.length()) goto L23;
        r1.append(StringsKt.slice(r0, RangesKt.until(r6, r0.length())));
    L23:
        return r1.toString();
    L29:
        return r0;
    L10:
        r3 = false;
        goto L11
    L27:
        return r0;
    L28:
        return r0;
    }
}
