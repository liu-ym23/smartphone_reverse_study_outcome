package com.lynx.tasm.ui.image;

import android.graphics.Bitmap;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f11106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f11107c;
    public final /* synthetic */ LynxContext d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ a0 f;

    public u(a0 r5, String r10, String r11, boolean r12, LynxContext r13, boolean r14) {
        this.f = r5;
        this.f11105a = r10;
        this.f11106b = r11;
        this.f11107c = r12;
        this.d = r13;
        this.e = r14;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r5 = this.f11105a;
        String r10 = this.f11106b;
        boolean r11 = this.f11107c;     // Catch: Throwable -> L7
        LynxContext r12 = this.d;
        a0 r13 = this.f;
        if (r11 == false) goto L9;
        Bitmap.Config r14 = a0.l0;     // Catch: Throwable -> L7
        String r15 = r13.a(r12, r5);     // Catch: Throwable -> L7
    L11:
        if (this.e == false) goto L13;
        Bitmap.Config r16 = a0.l0;     // Catch: Throwable -> L7
        r10 = r13.a(r12, r10);     // Catch: Throwable -> L7
    L13:
        r5 = r15;
    L15:
        com.lynx.tasm.utils.j.a().post(new com.bytedance.android.anniex.scene.core.i(this, 14, r5, r10));
        return;
    L9:
        r15 = r5;
    L7:
        th = move-exception;
        LynxLog.b(4, "Lynx-Image", "async redirect url failed, placeholder: " + r10 + ", url:" + r5 + ", msg:" + th.getMessage());
        goto L15
    }
}
