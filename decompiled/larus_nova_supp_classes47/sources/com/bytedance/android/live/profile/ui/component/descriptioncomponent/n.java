package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.model.EnterExitStateType;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.util.DressType;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n extends com.bytedance.android.live.profile.ui.base.k {
    public HSImageView b;
    public Disposable c;
    public final com.bytedance.android.live.profile.ui.base.h d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ n a;

        public a(n r1) {
            this.a = r1;
        }

        public final void accept(Object r12) {
            com.bytedance.android.live.profile.model.a r13 = (com.bytedance.android.live.profile.model.a) r12;
            if (r13 == null) goto L30;
            ALogger.i(NewProfileInfoViewModel.TAG, "exitComponent receive: " + r13.a);
            if (r13.a != EnterExitStateType.EXIT_START) goto L28;
            py.k r4 = this.a.d.getDressImageModelWithFallback(DressType.PanelExitWebp);
            if (r4 == null) goto L31;
            n r0 = this.a;
            com.bytedance.android.live.profile.ui.base.d r2 = r0.a;
            if (r2 == null) goto L17;
            com.bytedance.android.live.profile.ui.base.m r3 = com.bytedance.android.live.profile.ui.base.i.n(r0.d);
            if (r3 == null) goto L15;
            int r5 = r3.e();
        L16:
            r2.c(r5);
            goto L17
        L15:
            r5 = 0;
        L17:
            int r6 = r4.getWidth();
            int r7 = (int) ((((double) r4.getHeight()) / ((double) r6)) * ((double) r0.d.getProfileWidth(Boolean.TRUE)));
            HSImageView r1 = r0.b;
            if (r1 == null) goto L20;
            a1.k(r1, r7);
        L20:
            ImageLoader.bindImage(this.a.b, r4, null, -1, -1, null, null, true);
            StringBuilder r8 = new StringBuilder("exitComponent start exit: ");
            r8.append(r13.a);
            r8.append(", height: ");
            HSImageView r14 = this.a.b;
            if (r14 == null) goto L23;
            Integer r15 = Integer.valueOf(a1.d(r14));
        L24:
            r8.append(r15);
            ALogger.i(NewProfileInfoViewModel.TAG, r8.toString());
            Disposable r16 = this.a.c;
            if (r16 == null) goto L29;
            r16.dispose();
            return;
        L29:
            return;
        L23:
            r15 = null;
            goto L24
        L31:
            return;
        L28:
            return;
        }
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        Disposable r0 = this.c;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.ExitEffect.INSTANCE;
    }

    public n(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        this.d = r2;
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r5) {
        Context r0 = r5.getContext();
        if (r0 == null) goto L10;
        this.a = r5;
        View r1 = new HSImageView(r0);
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-1, -2);
        r2.gravity = 49;
        Unit r3 = Unit.INSTANCE;
        ((com.bytedance.android.live.profile.ui.base.e) r5).addView(r1, r2);
        this.b = r1;
        GenericDraweeHierarchy r6 = r1.getHierarchy();
        if (r6 == null) goto L9;
        r6.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Disposable r3 = this.c;
        if (r3 == null) goto L5;
        r3.dispose();
    L5:
        this.c = this.d.getEnterExitState().subscribe(new a(this));
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "newUser");
        ALogger.i("NewUserProfile_ProfilePre", "ProfileExitEffectComponent update");
    }
}
