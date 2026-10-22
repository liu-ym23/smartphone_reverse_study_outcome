package com.suite.lark.platform.feature.forward.doubao;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.image.api.SimpleTarget;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e0 extends SimpleTarget<Drawable> {
    public final /* synthetic */ ForwardDoubaoActivity a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Float c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Function1<String, Unit> e;
    public final /* synthetic */ boolean f;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r8) {
        ForwardDoubaoActivity r0 = this.a;
        String r1 = this.b;
        Intrinsics.checkNotNull(r1);
        Float r3 = this.c;
        String r4 = this.d;
        Function1<String, Unit> r5 = this.e;
        boolean r6 = this.f;
        int r2 = ForwardDoubaoActivity.p;
        r0.D1(r1, r8, r3, r4, r5, r6);
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r8) {
        Drawable r2 = (Drawable) r8;
        ForwardDoubaoActivity r0 = this.a;
        String r1 = this.b;
        Intrinsics.checkNotNull(r1);
        Float r3 = this.c;
        String r4 = this.d;
        Function1<String, Unit> r5 = this.e;
        boolean r6 = this.f;
        int r9 = ForwardDoubaoActivity.p;
        r0.D1(r1, r2, r3, r4, r5, r6);
    }

    public e0(ForwardDoubaoActivity r1, String r2, String r3, Function1 r4, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = null;
        this.d = r3;
        this.e = r4;
        this.f = r5;
    }
}
