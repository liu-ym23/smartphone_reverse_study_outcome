package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w<T> implements Consumer {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ int b;
    public final /* synthetic */ WeakReference c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ int e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ long g;

    public w(boolean r1, int r2, WeakReference r3, boolean r4, int r5, boolean r6, long r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final void accept(Object r6) {
        Exception r0 = new Exception((Throwable) r6);
        r0.printStackTrace();
        if (r0.getCause() == null) goto L20;
        Throwable r7 = r0.getCause();
        String r1 = null;
        if (r7 == null) goto L7;
        StackTraceElement[] r8 = r7.getStackTrace();
    L8:
        if (r8 == null) goto L20;
        Throwable r9 = r0.getCause();
        if (r9 == null) goto L12;
        StackTraceElement[] r10 = r9.getStackTrace();
    L13:
        jy0.b.c("GIFT_MANAGER", "syncgiftlist error! " + Arrays.toString(r10), null, 4);
        if (this.a == false) goto L20;
        com.bytedance.android.livesdk.gift.platform.core.c0 r2 = com.bytedance.android.livesdk.gift.platform.core.c0.a;
        StringBuilder r3 = new StringBuilder();
        Throwable r4 = r0.getCause();
        if (r4 == null) goto L18;
        r1 = r4.getMessage();
    L18:
        r3.append(r1);
        r3.append(" ");
        r3.append(Arrays.toString(r10));
        r2.d(r3.toString(), com.bytedance.android.live.revenue.common.r0.a(r0), this.b);
        goto L20
    L12:
        r10 = null;
        goto L13
    L7:
        r8 = null;
    L20:
        if (this.c.get() == null) goto L25;
        ca0.w r11 = (ca0.w) this.c.get();
        if (r11 == null) goto L25;
        r11.a();
    L25:
        if (this.d == false) goto L27;
        ((AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class)).f1(this.e, this.f);
        return;
    L27:
        GiftListRepo.b(GiftListRepo.k, this.e, this.f, this.g);
    }
}
