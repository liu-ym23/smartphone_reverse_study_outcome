package com.bytedance.android.annie.monitor.common.performance;

import com.bytedance.android.annie.card.AnnieCard;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements c {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // com.bytedance.android.annie.monitor.common.performance.c
    public final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
    }

    @Override // com.bytedance.android.annie.monitor.common.performance.c
    public final void b(String r1, String r10, String r11) {
    }

    @Override // com.bytedance.android.annie.monitor.common.performance.c
    public final void c(String r1, String r10, AnnieCard r11, String r12) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "view");
    }

    @Override // com.bytedance.android.annie.monitor.common.performance.c
    public final void d(String r1, String r10, String r11) {
    }

    @Override // com.bytedance.android.annie.monitor.common.performance.c
    public final void e() {
    }
}
