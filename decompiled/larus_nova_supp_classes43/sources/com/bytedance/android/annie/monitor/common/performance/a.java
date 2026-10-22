package com.bytedance.android.annie.monitor.common.performance;

import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements c {
    public static final a b = null;
    public final /* synthetic */ c a;

    static {
        b = new a();
    }

    @Override // com.bytedance.android.annie.monitor.common.performance.c
    public final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        this.a.a(r10);
    }

    @Override // com.bytedance.android.annie.monitor.common.performance.c
    public final void b(String r10, String r11, String r12) {
        this.a.b(r10, r11, r12);
    }

    @Override // com.bytedance.android.annie.monitor.common.performance.c
    public final void c(String r10, String r11, AnnieCard r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r12, "view");
        this.a.c(r10, r11, r12, r13);
    }

    @Override // com.bytedance.android.annie.monitor.common.performance.c
    public final void d(String r10, String r11, String r12) {
        this.a.d(r10, r11, r12);
    }

    @Override // com.bytedance.android.annie.monitor.common.performance.c
    public final void e() {
        this.a.e();
    }

    public a() {
        if (AnnieConfigSettingKeys.PERFORMANCE_CONFIG.a().b() == false) goto L5;
        c r0 = Perf.a;
    L6:
        this.a = r0;
        return;
    L5:
        r0 = b.a;
        goto L6
    }
}
