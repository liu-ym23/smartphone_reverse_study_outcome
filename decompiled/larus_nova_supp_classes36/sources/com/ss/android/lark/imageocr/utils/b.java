package com.ss.android.lark.imageocr.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean b(Context r7, CharSequence r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        if (r8 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L17;
        Object r9 = r7.getSystemService("clipboard");
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager r10 = (ClipboardManager) r9;
        qf7.a.a.a(r10, ClipData.newPlainText("ocr_result", r8), new Token("LARK-PSDA-ocr_copy_to_clip_board"));     // Catch: Exception -> L13 SensitiveAPIException -> L15
        return true;
    L13:
        e = move-exception;
        Log.e("ImageOCRUtils", "Copy failed:" + e);
    L15:
        e = move-exception;
        UDToast.show(LarkContext.getApplication(), 2131891032);
        Log.e("ImageOCRUtils", "Copy failed:" + e);
    L17:
        return false;
    L5:
        if (r8.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    public static List c(CharSequence r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        Intrinsics.checkNotNullParameter(r9, "child");
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (StringsKt.indexOf$default(r8, r9, r1, false, 4, null) == (-1)) goto L6;
        int r2 = StringsKt.indexOf$default(r8, r9, r1, false, 4, null);
        r0.add(Integer.valueOf(r2));
        r1 = r2 + r9.length();
        goto L4
    L6:
        return r0;
    }

    public static float a(float r4, float r5, float r6, float r7) {
        return (float) Math.sqrt(Math.pow(Math.abs(r4 - r6), 2.0d) + Math.pow(Math.abs(r5 - r7), 2.0d));
    }
}
