package com.bytedance.android.livesdk.interactivity.common.utils;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    static {
    }

    public static void a(a5 r6) {
        if (r6.getPieces() == null) goto L48;
        List r0 = r6.getPieces();
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isEmpty() == true) goto L50;
        List r1 = r6.getPieces();
        if (r1 != null) goto L11;
        r1 = new ArrayList();
    L11:
        Intrinsics.checkNotNullParameter(r1, "pieces");
        int r2 = r1.size();
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L19;
        i5 r4 = ((c5) ListProtector.get(r1, r3)).getUserValue();
        if (r4 == null) goto L18;
        IBaseUser r5 = r4.getUser();
        if (r5 == null) goto L18;
    L20:
        if (r5 != null) goto L22;
        return;
    L22:
        if (r5.getNickName() != null) goto L24;
        return;
    L24:
        if (Intrinsics.areEqual(r6.getKey(), "subscribe_purchase_tip") == false) goto L33;
        kz.a r7 = kz.b.a;
        String r8 = r5.getNickName();
        if (r7 == null) goto L31;
        if (r7.a() == false) goto L31;
        r5.setNickName(String.valueOf(r8.charAt(0)) + "***" + r8.charAt(r8.length() - 1));
        return;
    L31:
        if (r8.length() <= 6) goto L54;
        r5.setNickName(r8.substring(0, 5) + "...");
        return;
    L54:
        return;
    L33:
        String r9 = r5.getNickName();
        int r10 = r9.length();
        if (r10 != 0) goto L36;
    L42:
        r5.setNickName(r9);
        return;
    L36:
        if (r10 != 1) goto L38;
        r9 = r9.concat("****");
        goto L42
    L38:
        if (r10 == 2) goto L40;
        r9 = String.valueOf(r9.charAt(0)) + "****" + r9.charAt(r9.length() - 1);
        goto L42
    L40:
        r9 = String.valueOf(r9.charAt(0)) + "****";
    L18:
        r3 = r3 + 1;
        goto L12
    L19:
        r5 = null;
        goto L20
    L50:
        return;
    }
}
