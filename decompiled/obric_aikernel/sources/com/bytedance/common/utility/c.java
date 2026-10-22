package com.bytedance.common.utility;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static <T> boolean a(List<T> r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (r10.size() == 0) goto L7;
        return false;
    }
}
