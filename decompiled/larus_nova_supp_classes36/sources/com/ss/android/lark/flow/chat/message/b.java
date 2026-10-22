package com.ss.android.lark.flow.chat.message;

import com.ss.android.lark.utils.LarkContext;
import jdb.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(g r1) {
        Intrinsics.checkNotNullParameter(r1, "fgService");
        if (r1.isEnable("disable.flow.card.render") == false) goto L5;
    L7:
        return false;
    L5:
        if (((itb.a) LarkContext.spiByDwarf(itb.a.class)).i1() == false) goto L7;
        return true;
    }
}
