package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.gift.BaseCommentGiftGuideView;
import com.bytedance.android.livesdk.chatroom.ui.KeyboardShadowView;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.r3;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o1 implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<a, Object> {
    public final InputSectionType a;
    public a b;
    public BaseCommentGiftGuideView c;

    public final class a extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j {
        public KeyboardShadowView c;
        public FrameLayout d;
        public final /* synthetic */ o1 e;

        public a(o1 r2, View r3, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "bridges");
            this.e = r2;
            super(r3, r4);
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r1) {
    }

    public o1() {
        this.a = InputSectionType.SHADOW;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r7) {
        Intrinsics.checkNotNullParameter(r7, "panelBridge");
        Activity r0 = r7.getActivity();
        if (r0 != null) goto L5;
        return null;
    L5:
        View r1 = LayoutInflater.from(r0).inflate(2131566194, null);
        a r2 = new a(this, r1, r7);
        r2.c = r2.a.findViewById(2131375433);
        r2.d = (FrameLayout) r2.a.findViewById(2131373721);
        KeyboardShadowView r8 = r2.c;
        if (r8 == null) goto L8;
        r8.setOnClickListener(new l1(r2));
    L8:
        KeyboardShadowView r9 = r2.c;
        boolean r3 = false;
        if (r9 == null) goto L11;
        r9.enableDispatchTouchEventToActivity(false);
    L11:
        KeyboardShadowView r10 = r2.c;
        if (r10 == null) goto L14;
        r10.setIsAnchor(r2.b.k0());
    L14:
        KeyboardShadowView r11 = r2.c;
        if (r11 == null) goto L17;
        r11.setIsPortrait(r2.b.n0());
    L17:
        KeyboardShadowView r13 = r2.c;
        if (r13 == null) goto L20;
        r13.setActivity(r2.b.getActivity());
    L20:
        r3.c(r2.c, com.bytedance.android.live.core.utils.s1.B(2131914440), true);
        if (((com.bytedance.android.livesdk.interactivity.api.settings.config.c) ec2.b.a.getValue()).a() == false) goto L40;
        Context r14 = r2.b.getContext();
        if (r14 == null) goto L41;
        o1 r4 = r2.e;
        boolean r5 = com.bytedance.android.live.revenue.core.util.h.a;
        r4.c = com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).getCommentGiftGuideView(r14);
        View r15 = r2.e.c;
        if (r15 != null) goto L28;
    L39:
        r2.b.k(new m1(r2));
        goto L40
    L28:
        if (r2.b.m0() == true) goto L36;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r6 = r2.b.V();
        if (r6 == null) goto L36;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r16 = r6.g;
        if (r16 == null) goto L36;
        if ((!TextUtils.isEmpty(r16.f)) == true) goto L36;
        r3 = true;
    L36:
        r15.setGuideEnable(r3);
        FrameLayout r17 = r2.d;
        if (r17 == null) goto L39;
        r17.addView(r15);
    L41:
        Unit r18 = Unit.INSTANCE;
        this.b = r2;
        return r1;
    L40:
        r2.b.w(new n1(r2));
        goto L41
    }
}
