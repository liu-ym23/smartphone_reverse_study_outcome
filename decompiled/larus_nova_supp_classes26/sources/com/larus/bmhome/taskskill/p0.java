package com.larus.bmhome.taskskill;

import ic8.w;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class p0 implements Function1 {
    public final /* synthetic */ SkillComponent a;

    public /* synthetic */ p0(SkillComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        SkillComponent r0 = this.a;
        Regex r1 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter((w) r4, "it");
        boolean r2 = false;
        if (l2.c() == false) goto L22;
        if (r0.yW() == false) goto L22;
        if (Intrinsics.areEqual(r0.p1.getValue(), Boolean.TRUE) == false) goto L22;
        be8.e r5 = r0.getSelectedFolder();
        if (r5 == null) goto L11;
        String r6 = r5.b;
    L13:
        if (r6 != null) goto L15;
    L18:
        boolean r7 = true;
    L19:
        if (r7 == true) goto L22;
        r2 = true;
        goto L22
    L15:
        if (StringsKt.isBlank(r6) == true) goto L18;
        r7 = false;
        goto L19
    L11:
        r6 = null;
    L22:
        return Boolean.valueOf(r2);
    }
}
