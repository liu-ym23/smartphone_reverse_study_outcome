package com.obric.aikernel.res.update;

import com.obric.aikernel.res.metadata.config.LoraConfig;
import com.obric.aikernel.res.metadata.config.UpdateTaskConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public static final g a(UpdateTaskConfig r10, com.obric.aikernel.res.metadata.config.d r11) {
        Intrinsics.checkNotNullParameter(r10, "owner");
        Intrinsics.checkNotNullParameter(r11, "model");
        String r12 = r10.h();
        String r13 = r10.g();
        String r14 = r10.i();
        String r15 = r10.k();
        boolean r16 = r10 instanceof LoraConfig;
        if (r16 == false) goto L5;
        String r17 = ((LoraConfig) r10).t();
    L6:
        if (r16 == false) goto L8;
        String r18 = r10.g();
    L10:
        return new g(r12, r13, r14, r15, r17, r18, r11.g(), r11.i());
    L8:
        r18 = "";
        goto L10
    L5:
        r17 = r10.g();
        goto L6
    }
}
