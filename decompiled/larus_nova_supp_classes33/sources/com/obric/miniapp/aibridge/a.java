package com.obric.miniapp.aibridge;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a extends com.obric.miniapp.utils.g {
    public final /* synthetic */ f3.h<AbsDatePickerMethodIDL.b> a;

    public a(f3.h<AbsDatePickerMethodIDL.b> r1) {
        this.a = r1;
    }

    @Override // com.obric.miniapp.utils.g
    public final void a(Long r6) {
        if (r6 == null) goto L4;
        f3.h<AbsDatePickerMethodIDL.b> r0 = this.a;
        Intrinsics.checkNotNullParameter(AbsDatePickerMethodIDL.b.class, "<this>");
        AbsDatePickerMethodIDL.b r1 = k3.c.a(AbsDatePickerMethodIDL.b.class);
        r1.setTime(r6.longValue());
        f3.h.a.b(r0, r1);
        return;
    L4:
        f3.h.a.a(this.a, "用户取消选择", null, null, 14);
    }
}
