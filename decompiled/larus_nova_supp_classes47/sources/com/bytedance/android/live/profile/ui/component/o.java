package com.bytedance.android.live.profile.ui.component;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o implements v32.d {
    public final float a;
    public final float b;
    public final float c;
    public final /* synthetic */ v32.b d;
    public final /* synthetic */ FrameLayout e;
    public final /* synthetic */ ProfileDynamicOperateComponent f;

    public final View b() {
        return this.d.getTapView();
    }

    public final Bitmap c() {
        return this.d.a();
    }

    public final boolean needPerformHapticFeedback() {
        return this.f.C.a().needPerformHapticFeedback();
    }

    public final ViewGroup a() {
        return this.e;
    }

    public final float d() {
        return this.a;
    }

    public final float e() {
        return this.b;
    }

    public final float f() {
        return this.c;
    }

    public o(v32.b r1, FrameLayout r2, ProfileDynamicOperateComponent r3) {
        this.d = r1;
        this.e = r2;
        this.f = r3;
        float r4 = ProfileDynamicOperateComponent.H;
        this.a = r4;
        this.b = r4;
        this.c = ProfileDynamicOperateComponent.J;
    }
}
