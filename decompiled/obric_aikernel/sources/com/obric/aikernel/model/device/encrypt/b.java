package com.obric.aikernel.model.device.encrypt;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final String a(ScriptModelInfo r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getName() + '@' + r10.getVersion();
    }
}
