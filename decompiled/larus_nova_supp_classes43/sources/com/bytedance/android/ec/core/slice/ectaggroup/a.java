package com.bytedance.android.ec.core.slice.ectaggroup;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.r;
import com.bytedance.android.ecom.arch.slice.render.b;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements b {
    public final /* synthetic */ ECTagGroupViewWrapper a;

    public a(ECTagGroupViewWrapper r1) {
        this.a = r1;
    }

    public final void a(r r10) {
        Intrinsics.checkNotNullParameter(r10, "actionInfo");
        IAction r11 = r10.a;
        String r0 = r11.getType();
        if (r0.hashCode() == (-1444844223)) goto L6;
        return;
    L6:
        if (r0.equals("ectagCouponExpire") == false) goto L17;
        Map r12 = r11.getParams();
        Object r1 = null;
        if (r12 == null) goto L10;
        Object r13 = r12.get("tag_info");
    L12:
        if ((r13 instanceof Map) == false) goto L15;
        r1 = r13;
    L15:
        Map r14 = (Map) r1;
        ECTagGroupViewWrapper r15 = this.a;
        Lazy r16 = ECTagGroupViewWrapper.c;
        r15.getClass();
        return;
    L10:
        r13 = null;
        goto L12
    }
}
