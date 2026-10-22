package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.util.DressType;
import com.bytedance.android.livesdk.utils.u6;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e extends com.bytedance.android.live.profile.ui.base.k {
    public HybridCard b;
    public final com.bytedance.android.live.profile.ui.base.h c;

    public final void j() {
        com.bytedance.android.live.profile.ui.base.d r0 = this.a;
        HybridCard r1 = null;
        if (r0 == null) goto L5;
        Context r2 = r0.getContext();
    L6:
        Activity r3 = ContextUtil.contextToActivity(r2);
        if (r3 != null) goto L9;
        return;
    L9:
        String r4 = this.c.getFlashCardAsset();
        String r5 = (String) rs0.d.a.getValue();
        Resources r6 = r3.getResources();
        float r7 = WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()).density;
        float r8 = UtilityKotlinExtentionsKt.j(this.c.getProfileWidth(Boolean.TRUE));
        if (r5 != null) goto L12;
    L15:
        boolean r9 = true;
    L16:
        if (r9 == true) goto L27;
        IBaseBrowserService r10 = jc1.k.f(IBaseBrowserService.class);
        if (r10 == null) goto L25;
        u6 r12 = new u6(r5);
        r12.b("flash_card_path", r4);
        r12.b("profile_width", String.valueOf(r8));
        r12.b("pixel_ratio", String.valueOf(r7));
        Unit r13 = Unit.INSTANCE;
        HybridCard r14 = r10.getHybridCard(r3, r12.c(), null);
        if (r14 == null) goto L25;
        com.bytedance.android.live.profile.ui.base.d r15 = this.a;
        if (r15 == null) goto L24;
        r15.e(r14);
    L24:
        r1 = r14;
    L25:
        this.b = r1;
        return;
    L27:
        return;
    L12:
        if (r5.length() == 0) goto L15;
        r9 = false;
        goto L16
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        HybridCard r0 = this.b;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.b = null;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.DressParallaxEffect.INSTANCE;
    }

    public e(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        this.c = r2;
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.a = r1;
        j();
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r7) {
        Intrinsics.checkNotNullParameter(r7, "user");
        com.bytedance.android.live.profile.ui.base.h r8 = this.c;
        DressType r0 = DressType.BorderLoopWebp;
        py.k r9 = r8.getDressImageModelWithFallback(r0);
        int r1 = 0;
        if (r9 == null) goto L5;
        int r10 = r9.getWidth();
    L6:
        py.k r2 = this.c.getDressImageModelWithFallback(r0);
        if (r2 == null) goto L9;
        r1 = r2.getHeight();
    L9:
        int r12 = (int) ((((double) this.c.getProfileWidth(Boolean.TRUE)) / ((double) r10)) * ((double) r1));
        HybridCard r3 = this.b;
        if (r3 == null) goto L12;
        a1.k(r3, r12);
    L12:
        HybridCard r13 = this.b;
        if (r13 == null) goto L15;
        a7.a.a(r13, null, null, 3);
        return;
    L15:
        j();
        HybridCard r14 = this.b;
        if (r14 == null) goto L20;
        a7.a.a(r14, null, null, 3);
        return;
    L20:
        return;
    L5:
        r10 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r3, "newUser");
        ALogger.i("NewUserProfile_ProfilePre", "ProfileDressParallaxComponent update");
        if (com.bytedance.android.live.profile.ui.base.i.g(this.c) == false) goto L12;
        com.bytedance.android.live.profile.ui.base.d r0 = this.a;
        if (r0 == null) goto L7;
        r0.removeAllViews();
    L7:
        HybridCard r1 = this.b;
        if (r1 == null) goto L10;
        r1.release();
    L10:
        this.b = null;
        b(this.a);
        g(r3);
        return;
    }
}
