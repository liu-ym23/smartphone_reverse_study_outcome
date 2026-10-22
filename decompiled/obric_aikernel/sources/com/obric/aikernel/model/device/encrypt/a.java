package com.obric.aikernel.model.device.encrypt;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final boolean a(ScriptModelFile r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ModelEncryptType.Companion.a(r10.getEncrypt_type());
    }

    public static final boolean b(ScriptModelFile r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.getDownload_url().length() <= 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L14;
        if (r10.getFilename().length() <= 0) goto L10;
        boolean r12 = true;
    L11:
        if (r12 == false) goto L14;
        return true;
    L10:
        r12 = false;
    L14:
        return false;
    L5:
        r11 = false;
        goto L6
    }
}
