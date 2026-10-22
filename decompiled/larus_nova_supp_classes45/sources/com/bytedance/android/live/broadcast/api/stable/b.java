package com.bytedance.android.live.broadcast.api.stable;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface b extends Comparable<b> {

    public static final class a {
        public static int a(b r1, b r2) {
            Intrinsics.checkNotNullParameter(r2, "other");
            r1.getPriority();
            r2.getPriority();
            return 0;
        }
    }

    void getPriority();
}
