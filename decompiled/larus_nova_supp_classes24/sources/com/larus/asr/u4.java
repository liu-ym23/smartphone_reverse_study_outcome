package com.larus.asr;

import com.bytedance.keva.Keva;
import com.larus.bmhome.actionbar.model.r;
import com.larus.platform.service.AccountService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class u4 {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new t4());
    }

    public static boolean a(com.larus.bmhome.instruction.g r5, String r6) {
        if (r5 == null) goto L11;
        com.larus.bmhome.actionbar.model.z0 r1 = r5.yF();
        if (r1 == null) goto L11;
        r r2 = r1.q;
        if (r2 == null) goto L11;
        com.larus.bmhome.actionbar.model.j1 r3 = r2.e;
        if (r3 == null) goto L11;
        String r4 = r3.l;
    L13:
        if (r4 == null) goto L19;
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        if (StringsKt.contains$default(r4, r6, false, 2, null) != true) goto L19;
        boolean r7 = true;
    L20:
        if (r5 != null) goto L22;
    L24:
        boolean r8 = false;
    L25:
        String r0 = ((Keva) a.getValue()).getString(AccountService.a.getUserId().concat("-selected_translator_mode"), "-1");
        boolean r9 = Intrinsics.areEqual(r0, "1");
        boolean r10 = Intrinsics.areEqual(r0, "0");
        if (r8 == false) goto L31;
        if (r9 == true) goto L33;
        if (r10 == false) goto L31;
        if (r7 == false) goto L31;
        return true;
    L33:
        return true;
    L31:
        return false;
    L22:
        if (r5.Q1() != 5) goto L24;
        r8 = true;
    L19:
        r7 = false;
    L11:
        r4 = null;
        goto L13
    }
}
