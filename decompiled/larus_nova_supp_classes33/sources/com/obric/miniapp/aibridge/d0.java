package com.obric.miniapp.aibridge;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d0 extends com.obric.miniapp.utils.f {
    public final /* synthetic */ f3.h<AbsTimePickerMethodIDL.b> a;

    public d0(f3.h<AbsTimePickerMethodIDL.b> r1) {
        this.a = r1;
    }

    @Override // com.obric.miniapp.utils.f
    public final void a(int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "pickerUnit");
        f3.h<AbsTimePickerMethodIDL.b> r0 = this.a;
        Intrinsics.checkNotNullParameter(AbsTimePickerMethodIDL.b.class, "<this>");
        AbsTimePickerMethodIDL.b r1 = k3.c.a(AbsTimePickerMethodIDL.b.class);
        AbsTimePickerMethodIDL.b r2 = r1;
        r2.setValue(r4);
        r2.setUnit(r5);
        f3.h.a.b(r0, r1);
    }
}
