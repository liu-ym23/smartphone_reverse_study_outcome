package com.bytedance.awemeopen.infra.util;

import java.util.Collection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static <T> boolean a(Collection<T> r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.isEmpty() == true) goto L7;
        return false;
    }
}
