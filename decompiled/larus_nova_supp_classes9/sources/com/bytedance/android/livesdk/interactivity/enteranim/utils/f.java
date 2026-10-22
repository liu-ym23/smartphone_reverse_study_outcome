package com.bytedance.android.livesdk.interactivity.enteranim.utils;

import android.text.TextUtils;
import com.bytedance.android.livesdk.message.model.va;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(k32.a r4) {
        va.a r0 = r4.k;
        if (r0 == null) goto L18;
        py.k r1 = r0.getTextIcon();
        if (r1 == null) goto L21;
        va.a r5 = r4.k;
        if (r5 != null) goto L10;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == false) goto L19;
        int r7 = t72.a.a;
        if (TextUtils.isEmpty(t72.a.C0283a.a(r1)) == false) goto L20;
        return true;
    L20:
        return false;
    L19:
        return false;
    L10:
        if (r5.getType() != 3) goto L12;
        r6 = true;
        goto L13
    L21:
        return false;
    L18:
        return false;
    }
}
