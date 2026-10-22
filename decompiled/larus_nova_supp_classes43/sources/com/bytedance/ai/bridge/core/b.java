package com.bytedance.ai.bridge.core;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import f3.h;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final <T extends ResultModel> void a(a<? extends T> r10, h<T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "callback");
        if ((r10 instanceof a.c) == false) goto L6;
        a.c r12 = (a.c) r10;
        r11.b((ResultModel) r12.b, r12.c);
        return;
    L6:
        if ((r10 instanceof a.b) == false) goto L10;
        a.b r13 = (a.b) r10;
        r11.c(r13.c, r13.b, r13.e, r13.d);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
