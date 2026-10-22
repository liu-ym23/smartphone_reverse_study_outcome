package com.ss.android.lark.flow.threadwindow;

import com.ss.android.lark.biz.im.api.ThreadTopic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class s {
    public static final boolean a(ThreadTopic r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        boolean r0 = false;
        if (r6 != null) goto L5;
    L25:
        return false;
    L5:
        if (r6.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        String r3 = null;
        if (r1 == true) goto L12;
        r6 = null;
    L12:
        if (r6 == null) goto L25;
        String r2 = r5.getRootMsgId();
        if (r2 != null) goto L17;
    L21:
        if (r3 == null) goto L24;
        return Intrinsics.areEqual(r3, r6);
    L24:
        return Intrinsics.areEqual(r5.getId(), r6);
    L17:
        if (r2.length() <= 0) goto L19;
        r0 = true;
    L19:
        if (r0 == false) goto L21;
        r3 = r2;
        goto L21
    L7:
        r1 = false;
        goto L8
    }
}
