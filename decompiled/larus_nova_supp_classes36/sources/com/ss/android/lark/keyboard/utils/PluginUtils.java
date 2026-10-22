package com.ss.android.lark.keyboard.utils;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class PluginUtils {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(PluginUtils$tokenService$2.INSTANCE);
    }

    public static boolean c() {
        return ((com.ss.android.lark.passport.dpop.b) a.getValue()).isDoubaoBUser();
    }

    public static int b() {
        if (c() == false) goto L5;
        return 2131237477;
    L5:
        return 2131237476;
    }

    public static CharSequence a(CharSequence r3, TextPaint r4, float r5) {
        Intrinsics.checkNotNullParameter(r3, "hint");
        Intrinsics.checkNotNullParameter(r4, "paint");
        CharSequence r6 = TextUtils.ellipsize(r3, r4, r5, TextUtils.TruncateAt.END);
        Intrinsics.checkNotNull(r6);
        boolean r0 = true;
        if (r6.length() != 0) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L9;
        return r6;
    L9:
        if ((r3 instanceof Spanned) == true) goto L11;
    L17:
        r0 = false;
    L18:
        if (r0 == true) goto L20;
        return r6;
    L20:
        SpannableStringBuilder r8 = new SpannableStringBuilder(r6);
        r8.setSpan(new u6b.a(), 0, r8.length(), 17);
        return r8;
    L11:
        if (((Spanned) r3).getSpans(0, r3.length(), u6b.a.class).length != 0) goto L13;
        boolean r9 = true;
    L15:
        if ((!r9) == false) goto L17;
    L13:
        r9 = false;
        goto L15
    L5:
        r7 = false;
        goto L6
    }
}
