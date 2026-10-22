package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c2 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ PortraitQuickShotLayerWidget a;
    public final /* synthetic */ Ref.FloatRef b;
    public final /* synthetic */ float c;
    public final /* synthetic */ Ref.IntRef d;
    public final /* synthetic */ Ref.IntRef e;
    public final /* synthetic */ Ref.IntRef f;
    public final /* synthetic */ Ref.IntRef g;
    public final /* synthetic */ Ref.IntRef h;
    public final /* synthetic */ Ref.IntRef i;
    public final /* synthetic */ float j;
    public final /* synthetic */ Ref.IntRef k;
    public final /* synthetic */ Ref.IntRef l;
    public final /* synthetic */ int m;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r6) {
        Intrinsics.checkNotNullParameter(r6, "animation");
        float r7 = r6.getAnimatedFraction();
        Ref.FloatRef r0 = this.b;
        float r2 = 1;
        float r3 = r2 - ((r2 - this.c) * r7);
        r0.element = r3;
        this.d.element = (int) (this.e.element * r3);
        this.f.element = (int) (this.g.element * r3);
        this.h.element = (int) (this.i.element + (this.j * r7));
        this.k.element = (int) (this.l.element + (this.m * r7));
        ImageView r8 = this.a.b;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L5:
        r8.getLayoutParams().width = this.d.element;
        r8.getLayoutParams().height = this.f.element;
        r8.setLayoutParams(r8.getLayoutParams());
        View r9 = ((Widget) this.a).contentView;
        float r4 = 12;
        r9.getLayoutParams().width = (int) (this.d.element + UtilityKotlinExtentionsKt.h(r4));
        ViewGroup.LayoutParams r1 = r9.getLayoutParams();
        float r5 = this.f.element;
        int r10 = bs1.a.a;
        IRoom r11 = this.a.f;
        if (r11 == null) goto L12;
        IRoomAuthStatus r12 = r11.getRoomAuthStatus();
        if (r12 == null) goto L12;
        if (r12.enableVerticalScreenShare() != true) goto L12;
        float r13 = UtilityKotlinExtentionsKt.h(52);
    L13:
        r1.height = (int) (r5 + r13);
        r9.setX(this.h.element);
        r9.setY(this.k.element);
        r9.setLayoutParams(r9.getLayoutParams());
        return;
    L12:
        r13 = UtilityKotlinExtentionsKt.h(r4);
        goto L13
    }

    public c2(PortraitQuickShotLayerWidget r1, Ref.FloatRef r2, float r3, Ref.IntRef r4, Ref.IntRef r5, Ref.IntRef r6, Ref.IntRef r7, Ref.IntRef r8, Ref.IntRef r9, float r10, Ref.IntRef r11, Ref.IntRef r12, int r13) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
        this.m = r13;
    }
}
