package com.bytedance.android.livesdk.interactivity.comment.frequentchat.util;

import android.widget.EditText;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public static final int a = 0;

    static {
        a = s1.f(15.0f);
    }

    public static void a(EditText r2, CharSequence r3, int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "editText");
        Intrinsics.checkNotNullParameter(r3, "content");
        int r0 = r2.getSelectionStart();
        r2.getEditableText().insert(r0, ab2.b.a().c(r3.toString(), r4));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r5 == false) goto L8;
        String r6 = "recommend";
    L9:
        SafetyGuard.a(null, e, "input " + r6 + " comment failed");
        return;
    L8:
        r6 = "frequent";
        goto L9
    }
}
