package com.bytedance.android.anniex.container.popup;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements d {
    public final /* synthetic */ d a;
    public final /* synthetic */ SheetBaseDialog b;

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean a() {
        return this.a.a();
    }

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean b() {
        return this.a.b();
    }

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean c() {
        if (this.a.e() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.a.c() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean d() {
        if (this.a.e() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.a.d() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean e() {
        if (this.a.e() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.b.h == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean f(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        return this.a.f(r10);
    }

    public a(d r1, SheetBaseDialog r10) {
        this.a = r1;
        this.b = r10;
    }
}
