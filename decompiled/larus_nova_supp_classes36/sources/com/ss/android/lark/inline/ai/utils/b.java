package com.ss.android.lark.inline.ai.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(FragmentActivity r5, CharSequence r6, Token r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "copyText");
        Intrinsics.checkNotNullParameter(r7, "token");
        String r8 = (String) r6;
        if (r8.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return;
    L8:
        Object r2 = r5.getSystemService("clipboard");
        if ((r2 instanceof ClipboardManager) == false) goto L11;
        ClipboardManager r3 = (ClipboardManager) r2;
    L12:
        if (r3 != null) goto L21;
        return;
    L21:
        qf7.a.a.a(r3, ClipData.newPlainText("", r8), r7);     // Catch: Exception -> L16 SensitiveAPIException -> L18
        UDToast.show(r5, 2131891641);     // Catch: Exception -> L16 SensitiveAPIException -> L18
    L24:
        return;
    L18:
        e = move-exception;
        Log.e("DebugCopyUtils", "copy failed: " + e.getMessage());
        return;
    L16:
        e = move-exception;
        Log.e("DebugCopyUtils", "copy failed", e, true);
        return;
    L11:
        r3 = null;
        goto L12
    L5:
        r1 = false;
        goto L6
    }
}
