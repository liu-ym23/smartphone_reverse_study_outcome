package com.bytedance.android.anniex.container;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import com.bytedance.ies.bullet.ui.common.BulletCardView;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f3141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f3142c;
    public final /* synthetic */ Object d;

    public /* synthetic */ f(Ref.IntRef r5, Ref.IntRef r10, Object r11, int r12) {
        this.f3140a = r12;
        this.f3141b = r5;
        this.f3142c = r10;
        this.d = r11;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18) {
        Object r5 = this.d;
        Ref.IntRef r19 = this.f3142c;
        Ref.IntRef r20 = this.f3141b;
        switch(this.f3140a) {
            case 0: goto L36;
            default: goto L4;
        };
    L4:
        int r21 = r13 - r11;
        if (r21 <= 0) goto L48;
        int r22 = r14 - r12;
        if (r22 > 0) goto L10;
        return;
    L10:
        if (r20.element == r21) goto L12;
    L14:
        r20.element = r21;
        r19.element = r22;
        boolean r23 = BulletCardView.D;
        BulletCardView r24 = (BulletCardView) r5;
        r24.getClass();
        Ref.IntRef r25 = new Ref.IntRef();
        Resources r26 = r24.getContext().getResources();
        if (r26 == null) goto L19;
        Configuration r27 = r26.getConfiguration();
        if (r27 == null) goto L19;
        int r28 = r27.orientation;
    L20:
        r25.element = r28;
        Lazy r29 = com.bytedance.android.anniex.base.depend.a.f3114c;
        ((com.bytedance.android.anniex.base.depend.c) r29.getValue()).getClass();
        ((com.bytedance.android.anniex.base.depend.c) r29.getValue()).getClass();
        List r30 = nb.a.f20224a;
        com.bytedance.ies.bullet.core.e r31 = r24.d;
        if (r31 == null) goto L23;
        Context r32 = r31.f5294h;
    L24:
        LinkedHashMap r33 = nb.a.d(r25.element, r32);
        xq.b.f();
        int r34 = r25.element;
        if (Intrinsics.areEqual(r33, r24.f6179q) == true) goto L49;
        r24.f6179q = r33;
        if (r33 == null) goto L32;
        com.bytedance.ies.bullet.service.base.h r35 = r24.g;
        if (r35 == null) goto L32;
        r35.b(r33);
    L32:
        if (r24.f6180r == false) goto L34;
        r24.d(r34, r33);
    L34:
        ((com.bytedance.android.anniex.base.depend.c) r29.getValue()).getClass();
        ((com.bytedance.android.anniex.base.depend.c) r29.getValue()).getClass();
        return;
    L49:
        return;
    L23:
        r32 = null;
    L19:
        r28 = 0;
        goto L20
    L12:
        if (r19.element != r22) goto L14;
        return;
    L48:
        return;
    L36:
        int r36 = r13 - r11;
        if (r36 <= 0) goto L52;
        int r37 = r14 - r12;
        if (r37 > 0) goto L42;
        return;
    L42:
        if (r20.element == r36) goto L44;
    L46:
        r20.element = r36;
        r19.element = r37;
        AnnieXContainer.access$onRootViewLayoutChanged((AnnieXContainer) r5, r11, r12, r13, r14, r15, r16, r17, r18);
        return;
    L44:
        if (r19.element != r37) goto L46;
        return;
    }
}
