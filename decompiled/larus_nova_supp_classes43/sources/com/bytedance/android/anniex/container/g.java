package com.bytedance.android.anniex.container;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements com.bytedance.android.anniex.container.popup.d {
    public final /* synthetic */ d a;

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean f(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        return false;
    }

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean a() {
        return this.a.isKitViewScrollReachTop();
    }

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean b() {
        ab.a r0 = this.a.j;
        if (r0 == null) goto L7;
        y36.a r1 = r0.d;
        if (r1 == null) goto L7;
        return Intrinsics.areEqual(((y36.i) r1).b, Boolean.TRUE);
    L7:
        return false;
    }

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean c() {
        return this.a.h;
    }

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean d() {
        return this.a.i;
    }

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean e() {
        this.a.getClass();
        ab.a r0 = this.a.j;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
    L12:
        return false;
    L10:
        if (this.a.g == false) goto L12;
        return true;
    L5:
        if (r0.w() != true) goto L7;
        r1 = true;
        goto L8
    }

    public g(d r1) {
        this.a = r1;
    }
}
