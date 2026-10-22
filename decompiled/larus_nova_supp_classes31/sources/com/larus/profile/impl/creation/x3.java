package com.larus.profile.impl.creation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x3 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Integer r3) {
        String r0 = ProfileCreationListFragmentV2.class.getName();
        if (r3 != null) goto L6;
    L8:
        if (r3 != null) goto L11;
    L13:
        if (r3 != null) goto L16;
    L18:
        Intrinsics.checkNotNull(r0);
        return r0;
    L16:
        if (r3.intValue() != 0) goto L18;
        return r0.concat("mix");
    L11:
        if (r3.intValue() != 1) goto L13;
        return r0.concat("public");
    L6:
        if (r3.intValue() != 2) goto L8;
        return r0.concat("private");
    }
}
