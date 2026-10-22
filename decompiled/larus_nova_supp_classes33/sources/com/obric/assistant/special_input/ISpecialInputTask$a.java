package com.obric.assistant.special_input;

import com.obric.aiagent.assistant.idl.bean.StateInfo;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ISpecialInputTask$a {
    public static /* synthetic */ void a(ISpecialInputTask r6, StateInfo r7, boolean r8, boolean r9, boolean r10, Function0 r11, int r12) {
        if ((r12 & 4) == 0) goto L5;
        boolean r3 = false;
    L7:
        if ((r12 & 8) == 0) goto L9;
        boolean r4 = true;
    L11:
        if ((r12 & 16) == 0) goto L13;
        r11 = null;
    L13:
        r6.e(r7, r8, r3, r4, r11);
        return;
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }
}
