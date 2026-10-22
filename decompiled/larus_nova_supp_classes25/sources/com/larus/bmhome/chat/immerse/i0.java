package com.larus.bmhome.chat.immerse;

import com.larus.bmhome.auth.ImmersConfig;
import com.larus.bmhome.auth.LaunchCacheDelegate;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.bean.RecommendBot;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i0 implements j0 {
    public static final i0 a = null;
    public static boolean b;

    static {
        a = new i0();
    }

    public i0() {
    }

    public static int c() {
        LaunchInfo r0 = LaunchCacheDelegate.b.c();
        if (r0 == null) goto L7;
        ImmersConfig r1 = r0.L0();
        if (r1 == null) goto L7;
        String r2 = r1.a();
    L9:
        return !Intrinsics.areEqual(r2, "horizontal") ? 1 : 0;
    L7:
        r2 = null;
        goto L9
    }

    public static boolean d(RecommendBot r1) {
        Intrinsics.checkNotNullParameter(r1, "bot");
        if (r1.c() == true) goto L5;
    L9:
        return false;
    L5:
        if (com.larus.utils.o0.d(r1.e()) == false) goto L9;
        if (com.larus.utils.o0.d(r1.a()) == false) goto L9;
        return true;
    }

    @Override // com.larus.bmhome.chat.immerse.j0
    public final String a(RecommendBot r2) {
        Intrinsics.checkNotNullParameter(r2, "bot");
        if (d(r2) == false) goto L5;
        return "1";
    L5:
        return "0";
    }

    @Override // com.larus.bmhome.chat.immerse.j0
    public final String b(String r1, String r2, boolean r3) {
        if (r3 == true) goto L4;
    L8:
        return "0";
    L4:
        if (com.larus.utils.o0.d(r1) == false) goto L8;
        if (com.larus.utils.o0.d(r2) == false) goto L8;
        return "1";
    }
}
