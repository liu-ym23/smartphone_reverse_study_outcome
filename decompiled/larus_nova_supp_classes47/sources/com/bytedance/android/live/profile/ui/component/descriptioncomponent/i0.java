package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.app.Activity;
import android.graphics.PointF;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.util.DressType;
import com.bytedance.android.livesdk.utils.u6;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import io.reactivex.Observable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i0 extends com.bytedance.android.live.profile.ui.base.k {
    public HybridCard b;
    public py.k c;
    public HSImageView d;
    public final h0 e;
    public final com.bytedance.android.live.profile.ui.base.h f;

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        ALogger.i("NewUserProfile_ProfilePre", "ProfilePanelEffectComponent destroy");
        HybridCard r0 = this.b;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.b = null;
        this.d = null;
        this.c = null;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.PanelEffect.INSTANCE;
    }

    public i0(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        this.f = r2;
        this.e = new h0(this);
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Activity r0 = ContextUtil.contextToActivity(r10.getContext());
        if (r0 != null) goto L7;
        return;
    L7:
        String r1 = this.f.getParallaxAsset();
        boolean r2 = ((Boolean) rs0.e.a.getValue()).booleanValue();
        String r3 = (String) rs0.f.a.getValue();
        Float r4 = (Float) com.bytedance.android.live.core.setting.p.a.getValue();
        Float r5 = (Float) rs0.h0.a.getValue();
        boolean r7 = true;
        if (r4.floatValue() < r5.floatValue()) goto L10;
    L13:
        boolean r6 = true;
    L14:
        HybridCard r8 = null;
        if (r6 == false) goto L36;
        if (r1 != null) goto L18;
    L21:
        boolean r9 = true;
    L22:
        if (r9 == true) goto L36;
        if (r2 == false) goto L36;
        if (r3 != null) goto L26;
    L29:
        if (r7 == true) goto L36;
        IBaseBrowserService r12 = jc1.k.f(IBaseBrowserService.class);
        if (r12 == null) goto L35;
        u6 r13 = new u6(r3);
        r13.b("parallax_path", r1);
        Unit r14 = Unit.INSTANCE;
        HybridCard r15 = r12.getHybridCard(r0, r13.c(), null);
        if (r15 == null) goto L35;
        r10.e(r15);
        r15.setOnTouchListener(this.e);
        r8 = r15;
    L35:
        this.b = r8;
        return;
    L26:
        if (r3.length() == 0) goto L29;
        r7 = false;
        goto L29
    L18:
        if (r1.length() == 0) goto L21;
        r9 = false;
    L36:
        int r16 = com.bytedance.android.live.profile.ui.util.t.a;
        if (((ss0.a) rs0.b0.a.getValue()).j() == false) goto L44;
        py.k r17 = this.f.getDressImageModelWithFallback(DressType.PanelLoopWebp);
        if (r17 == null) goto L41;
        this.c = r17;
        r8 = new HSImageView(r0);
        r10.e(r8);
        r8.setOnTouchListener(this.e);
    L41:
        this.d = r8;
        return;
    L44:
        return;
    L10:
        if (r4.floatValue() <= 0.0f) goto L13;
        r6 = false;
        goto L14
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r9) {
        Intrinsics.checkNotNullParameter(r9, "user");
        HybridCard r10 = this.b;
        if (r10 == null) goto L5;
        a7.a.a(r10, null, null, 3);
        return;
    L5:
        HSImageView r12 = this.d;
        py.k r1 = this.c;
        if (r12 == null) goto L25;
        if (r1 != null) goto L11;
        return;
    L11:
        if (this.f.isMyLive() == false) goto L15;
        int r2 = r1.getWidth();
        int r3 = r1.getHeight();
        a1.k(r12, (int) ((((double) this.f.getProfileWidth(null)) / ((double) r2)) * ((double) r3)));
        GenericDraweeHierarchy r0 = r12.getHierarchy();
        if (r0 == null) goto L18;
        r0.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
    L18:
        com.bytedance.android.live.profile.ui.base.h r4 = this.f;
        int r5 = com.bytedance.android.live.profile.ui.util.d.a;
        if (UtilityKotlinExtentionsKt.n(r1) == false) goto L21;
        Observable r13 = Observable.empty();
    L22:
        com.bytedance.android.live.profile.ui.base.i.b(r4, r13);
        return;
    L21:
        r13 = Observable.create(new com.bytedance.android.live.profile.ui.util.b(r1, r12));
        goto L22
    L15:
        GenericDraweeHierarchy r6 = r12.getHierarchy();
        if (r6 == null) goto L18;
        r6.setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP);
        r6.setActualImageFocusPoint(new PointF(0.5f, 0.0f));
        goto L18
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r3, "newUser");
        ALogger.i("NewUserProfile_ProfilePre", "ProfilePanelEffectComponent update");
        if (com.bytedance.android.live.profile.ui.base.i.g(this.f) == false) goto L12;
        com.bytedance.android.live.profile.ui.base.d r0 = this.a;
        if (r0 == null) goto L7;
        r0.removeAllViews();
    L7:
        HybridCard r1 = this.b;
        if (r1 == null) goto L10;
        r1.release();
    L10:
        this.b = null;
        this.c = null;
        this.d = null;
        b(this.a);
        g(r3);
        return;
    }
}
