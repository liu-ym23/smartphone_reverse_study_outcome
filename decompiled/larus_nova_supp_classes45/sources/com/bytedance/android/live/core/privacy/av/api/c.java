package com.bytedance.android.live.core.privacy.av.api;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class c implements b {
    public c() {
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.b
    public final void a(String r2, String r3, String r4, Map r5, a r6, AudioAndVideoException r7) {
        Intrinsics.checkNotNullParameter(r2, "biz");
        Intrinsics.checkNotNullParameter(r3, "sense");
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "config");
        Intrinsics.checkNotNullParameter(r7, "exception");
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.b
    public final void b(String r2, String r3, String r4, Map<String, String> r5, a r6) {
        Intrinsics.checkNotNullParameter(r2, "biz");
        Intrinsics.checkNotNullParameter(r3, "sense");
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "config");
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.b
    public final void d(String r2, String r3, String r4, Map<String, String> r5, a r6) {
        Intrinsics.checkNotNullParameter(r2, "biz");
        Intrinsics.checkNotNullParameter(r3, "sense");
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "config");
    }
}
