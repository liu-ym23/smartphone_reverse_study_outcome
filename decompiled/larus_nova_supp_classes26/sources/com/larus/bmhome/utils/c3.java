package com.larus.bmhome.utils;

import com.larus.bmhome.share.panel.ShareType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c3 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(String r4) {
        Intrinsics.checkNotNullParameter(r4, ShareType.TEXT);
        return StringsKt.contains$default(r4, "pc_guide_scene=", false, 2, null);
    }
}
