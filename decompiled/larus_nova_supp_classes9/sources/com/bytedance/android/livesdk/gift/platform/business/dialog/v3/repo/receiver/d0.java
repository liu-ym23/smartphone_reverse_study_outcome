package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.j0;
import com.bytedance.android.livesdk.gift.model.t2;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d0 {
    public static final boolean a(int r0, int r1) {
        if ((r0 & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public static final List c(List r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$rankN");
        int r1 = 3;
        if (3 <= r2.size()) goto L7;
        r1 = r2.size();
    L7:
        return r2.subList(0, r1);
    }

    public static final boolean b(List<h> r8, List<h> r9) {
        Intrinsics.checkNotNullParameter(r8, "lastReceiverList");
        Intrinsics.checkNotNullParameter(r9, "currentReceiverList");
        List r0 = c(r8);
        List r10 = c(r9);
        if (r0.size() == r10.size()) goto L5;
        return true;
    L5:
        Iterator r11 = c(r8).iterator();
        int r1 = 0;
    L7:
        if (r11.hasNext() == false) goto L35;
        Object r3 = r11.next();
        int r4 = r1 + 1;
        if (r1 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        h r5 = (h) r3;
        h r2 = (h) CollectionsKt.getOrNull(r10, r1);
        String r6 = r5.a.getIdString();
        String r7 = null;
        if (r2 == null) goto L16;
        IBaseUser r13 = r2.a;
        if (r13 == null) goto L16;
        String r14 = r13.getIdString();
    L18:
        if ((!Intrinsics.areEqual(r6, r14)) == true) goto L19;
        t2 r15 = r5.b;
        if (r15 == null) goto L25;
        j0 r16 = r15.getExtraInfo();
        if (r16 == null) goto L25;
        String r17 = r16.getLabel();
    L26:
        t2 r18 = r2.b;
        if (r18 == null) goto L32;
        j0 r19 = r18.getExtraInfo();
        if (r19 == null) goto L32;
        r7 = r19.getLabel();
    L32:
        if ((!Intrinsics.areEqual(r17, r7)) == true) goto L33;
        r1 = r4;
        goto L7
    L33:
        return true;
    L25:
        r17 = null;
        goto L26
    L19:
        return true;
    L16:
        r14 = null;
        goto L18
    L35:
        return false;
    }
}
