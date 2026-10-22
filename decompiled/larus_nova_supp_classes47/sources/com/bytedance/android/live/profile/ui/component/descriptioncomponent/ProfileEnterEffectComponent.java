package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.model.EnterExitStateType;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.util.DressType;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfileEnterEffectComponent extends com.bytedance.android.live.profile.ui.base.k {
    public Disposable b;
    public HSImageView c;
    public final com.bytedance.android.live.profile.ui.base.h d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ProfileEnterEffectComponent a;

        public a(ProfileEnterEffectComponent r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            com.bytedance.android.live.profile.model.a r7 = (com.bytedance.android.live.profile.model.a) r6;
            if (r7 == null) goto L5;
            EnterExitStateType r8 = r7.a;
        L7:
            if (r8 != EnterExitStateType.ENTER_START) goto L20;
            py.k r9 = this.a.d.getDressImageModelWithFallback(DressType.PanelEnterWebp);
            if (r9 == null) goto L22;
            int r1 = com.bytedance.android.live.profile.ui.util.d.a;
            HSImageView r2 = this.a.c;
            int r3 = com.bytedance.android.live.profile.ui.util.t.a;
            boolean r4 = ((ss0.a) rs0.b0.a.getValue()).m();
            Function0<Unit> r5 = new ProfileEnterEffectComponent$bindUserData$1$1(this);
            AbstractDraweeController r10 = com.bytedance.android.live.profile.ui.util.d.a(r9);
            if (r10 == null) goto L16;
            r10.addControllerListener(new com.bytedance.android.live.profile.ui.util.a(r4, null, r5));
            if (r2 == null) goto L16;
            r2.setController(r10);
        L16:
            Disposable r12 = this.a.b;
            if (r12 == null) goto L21;
            r12.dispose();
            return;
        L21:
            return;
        L22:
            return;
        L20:
            return;
        L5:
            r8 = null;
            goto L7
        }
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        Disposable r0 = this.b;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.EnterEffect.INSTANCE;
    }

    public ProfileEnterEffectComponent(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        this.d = r2;
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r4) {
        Context r0 = r4.getContext();
        if (r0 == null) goto L10;
        View r1 = new HSImageView(r0);
        ((com.bytedance.android.live.profile.ui.base.e) r4).e(r1);
        Unit r5 = Unit.INSTANCE;
        this.c = r1;
        GenericDraweeHierarchy r6 = r1.getHierarchy();
        if (r6 == null) goto L9;
        r6.setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP);
        r6.setActualImageFocusPoint(new PointF(0.5f, 0.0f));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Disposable r3 = this.b;
        if (r3 == null) goto L5;
        r3.dispose();
    L5:
        this.b = this.d.getEnterExitState().subscribe(new a(this));
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r3, "newUser");
        ALogger.i("NewUserProfile_ProfilePre", "ProfileEnterEffectComponent update");
        if (com.bytedance.android.live.profile.ui.base.i.g(this.d) == false) goto L9;
        Disposable r4 = this.b;
        if (r4 == null) goto L7;
        r4.dispose();
    L7:
        this.b = com.bytedance.android.live.profile.ui.base.i.i(this.d, EnterExitStateType.ENTER_START, new AnonymousClass1(this));
        return;
    }
}
