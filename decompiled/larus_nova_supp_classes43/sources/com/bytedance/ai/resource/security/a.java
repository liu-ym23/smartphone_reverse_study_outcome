package com.bytedance.ai.resource.security;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        if (4 > r10.length) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return ((r10[3] & 255) << 24) | (((r10[0] & 255) | ((r10[1] & 255) << 8)) | ((r10[2] & 255) << 16));
    L10:
        throw new IllegalArgumentException(("u32_le overflow: offset=0 size=" + r10.length).toString());
    L5:
        r0 = false;
        goto L6
    }
}
