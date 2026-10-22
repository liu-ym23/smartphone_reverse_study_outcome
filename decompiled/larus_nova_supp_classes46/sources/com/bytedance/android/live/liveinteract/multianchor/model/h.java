package com.bytedance.android.live.liveinteract.multianchor.model;

import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h {
    public static final LinkmicPositionItem a(LinkmicPositionItem r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$copy");
        LinkmicPositionItem.Companion.getClass();
        LinkmicPositionItem r0 = (LinkmicPositionItem) vh7.f.c(LinkmicPositionItem.class);
        r0.setPosition(r3.getPosition());
        r0.setStatus(r3.getStatus());
        r0.setActiveName(r3.getActiveName());
        r0.setVerifyStatus(r3.getVerifyStatus());
        r0.setPositionType(r3.getPositionType());
        return r0;
    }

    public static final boolean b(LinkmicPositionItem r7, Object r8) {
        Intrinsics.checkNotNullParameter(r7, "$this$isEquals");
        if (r7 != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L23:
        return false;
    L8:
        if ((!Intrinsics.areEqual(r7.getClass(), r8.getClass())) == true) goto L23;
        LinkmicPositionItem r9 = (LinkmicPositionItem) r8;
        if (r7.getPosition() == r9.getPosition()) goto L13;
    L21:
        return false;
    L13:
        if (r7.getStatus() != r9.getStatus()) goto L21;
        if (r7.getVerifyStatus() != r9.getVerifyStatus()) goto L21;
        if (r7.getPositionType() != r9.getPositionType()) goto L21;
        if (TextUtils.equals(r7.getActiveName(), r9.getActiveName()) == false) goto L21;
        return true;
    }
}
