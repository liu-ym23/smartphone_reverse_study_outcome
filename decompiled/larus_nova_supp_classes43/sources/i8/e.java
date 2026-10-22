package i8;

import com.bytedance.android.annie.card.AnnieCard;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements m9.d {
    public e() {
    }

    @Override // m9.d
    public final void j1(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        com.bytedance.android.annie.monitor.common.performance.a.b.a(r10);
    }

    @Override // m9.d
    public final void e0(String r10, String r11, String r12) {
        com.bytedance.android.annie.monitor.common.performance.a.b.b(r10, r11, r12);
    }

    @Override // m9.d
    public final void a0(String r10, String r11, AnnieCard r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r12, "view");
        com.bytedance.android.annie.monitor.common.performance.a.b.c(r10, r11, r12, r13);
    }
}
