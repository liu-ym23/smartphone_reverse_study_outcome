package com.ss.android.lark.inline.ai.utils;

import android.content.Context;
import com.larksuite.framework.utils.ApkUtil;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        ArrayList r1 = new ArrayList();
        String r11 = ApkUtil.getAppVersionName(r10);
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isMempopeApp() == false) goto L9;
        r1.add("MemPope/".concat(r11));
    L9:
        return CollectionsKt.joinToString$default(r1, " ", null, null, 0, null, null, 62, null);
    }
}
