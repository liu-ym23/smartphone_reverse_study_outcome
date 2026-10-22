package com.bytedance.android.livesdk.gift.platform.core.utils.recorder;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements g {
    public final g[] a;

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void c() {
        g[] r0 = this.a;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0[r2].c();
        r2 = r2 + 1;
        goto L3
    }

    public b(g... r2) {
        Intrinsics.checkNotNullParameter(r2, "recorder");
        this.a = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void e(String r5) {
        Intrinsics.checkNotNullParameter("GiftTrayMessageManager", "msgId");
        Intrinsics.checkNotNullParameter(r5, "stage");
        g[] r0 = this.a;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0[r2].e(r5);
        r2 = r2 + 1;
        goto L3
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void b(Object r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "msgId");
        Intrinsics.checkNotNullParameter(r6, "stage");
        g[] r0 = this.a;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0[r2].b(r5, r6);
        r2 = r2 + 1;
        goto L3
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void d(Object r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "msgId");
        Intrinsics.checkNotNullParameter(r6, "stage");
        g[] r0 = this.a;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0[r2].d(r5, r6);
        r2 = r2 + 1;
        goto L3
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void f(Object r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "msgId");
        Intrinsics.checkNotNullParameter(r6, "otherInfo");
        g[] r0 = this.a;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0[r2].f(r5, r6);
        r2 = r2 + 1;
        goto L3
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void a(Object r5, String r6, d r7) {
        Intrinsics.checkNotNullParameter(r5, "msgId");
        Intrinsics.checkNotNullParameter(r6, "stage");
        g[] r0 = this.a;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0[r2].a(r5, r6, r7);
        r2 = r2 + 1;
        goto L3
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void g(Object r5, String r6, Function1<? super h, Unit> r7) {
        Intrinsics.checkNotNullParameter(r5, "msgId");
        Intrinsics.checkNotNullParameter(r6, "stage");
        Intrinsics.checkNotNullParameter(r7, "record");
        g[] r0 = this.a;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0[r2].g(r5, r6, r7);
        r2 = r2 + 1;
        goto L3
    }
}
