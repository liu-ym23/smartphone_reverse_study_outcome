package com.bytedance.android.annie.lynx.service.latch;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k {
    public final Function0<List<String>> a;

    public final class a {
        public final com.bytedance.android.annie.service.prefetch.n a;
        public final String b;

        public a(com.bytedance.android.annie.service.prefetch.n r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "loader");
            Intrinsics.checkNotNullParameter(r11, "channel");
            this.a = r10;
            this.b = r11;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(Function0<? extends List<String>> r10) {
        Intrinsics.checkNotNullParameter(r10, "channels");
        this.a = r10;
    }
}
