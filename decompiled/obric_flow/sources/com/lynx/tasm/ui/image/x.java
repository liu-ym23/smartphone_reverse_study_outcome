package com.lynx.tasm.ui.image;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.resourceprovider.LynxResourceResponse$ResponseState;

/* JADX INFO: loaded from: classes2.dex */
public final class x implements go.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f11146c;
    public final /* synthetic */ a0 d;

    public x(a0 r5, int r10, int r11, long r12) {
        this.d = r5;
        this.f11144a = r10;
        this.f11145b = r11;
        this.f11146c = r12;
    }

    @Override // go.a
    public final void f(com.google.common.reflect.w r14) {
        LynxResourceResponse$ResponseState r5 = (LynxResourceResponse$ResponseState) r14.f9377c;
        LynxResourceResponse$ResponseState r10 = LynxResourceResponse$ResponseState.f10948b;
        a0 r11 = this.d;
        if (r5 != r10) goto L13;
        Object r15 = r14.f9376b;
        if ((r15 instanceof CloseableReference) == false) goto L13;
        r11.f11022z.i((CloseableReference) r15);
        long r12 = System.currentTimeMillis();
        Bitmap.Config r16 = r11.f11012o;
        if (r16 != null) goto L9;
        r16 = Bitmap.Config.ARGB_8888;
    L9:
        int r13 = td.b.a(this.f11144a, this.f11145b, r16);
        String r17 = r11.f11017u;
        LynxContext r18 = kk.a.i(r11.A);
        if (r11.G == false) goto L15;
        td.c.b(r13, 0, this.f11146c, r12, r18, r17, true, true);
        return;
    L15:
        return;
    L13:
        r11.f11022z.mo100a();
    }
}
