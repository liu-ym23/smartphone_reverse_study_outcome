package com.bytedance.android.livesdk.chatroom.utils;

import android.text.SpannableStringBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e4 {
    public static final void a(SpannableStringBuilder r2, CharSequence r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$appendSpan");
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r4, "what");
        int r0 = r2.length();
        r2.append(r3);
        r2.setSpan(r4, r0, r2.length(), 33);
    }
}
