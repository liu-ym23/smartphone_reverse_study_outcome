package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileBusinessArea;
import com.bytedance.android.live.base.model.user.ProfileOpenArea;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.livesdk.config.yk0;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b0 extends com.bytedance.android.live.profile.ui.base.k implements qt0.b {
    public static final int g = 0;
    public static final int h = 0;
    public View b;
    public ViewGroup c;
    public c0 d;
    public Context e;
    public final com.bytedance.android.live.profile.ui.base.h f;

    public static final class a {
    }

    @Override // qt0.b
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
    }

    @Override // qt0.b
    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "newUser");
    }

    static {
        g = UtilityKotlinExtentionsKt.i(108);
        h = UtilityKotlinExtentionsKt.i(38);
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        c0 r0 = this.d;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.d = null;
        ViewGroup r1 = this.c;
        if (r1 == null) goto L9;
        r1.removeAllViews();
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.MultiLinkPermanentRoom.INSTANCE;
    }

    public b0(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        this.f = r2;
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r3) {
        Context r0 = r3.getContext();
        if (r0 == null) goto L13;
        this.e = r0;
        View r4 = ((com.bytedance.android.live.profile.ui.base.e) r3).f(2131567184, true);
        ViewGroup r1 = null;
        if (r4 == null) goto L7;
        View r5 = r4.findViewById(2131382150);
    L8:
        this.b = r5;
        if (r5 == null) goto L11;
        r1 = (ViewGroup) r5.findViewById(2131379288);
    L11:
        this.c = r1;
        return;
    L7:
        r5 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r9) {
        Intrinsics.checkNotNullParameter(r9, "user");
        Context r0 = this.e;
        if (r0 == null) goto L50;
        String r1 = (String) yk0.a.getValue();
        c0 r2 = this.d;
        if (r2 == null) goto L8;
        r2.release();
    L8:
        ViewGroup.LayoutParams r3 = null;
        this.d = null;
        ViewGroup r4 = this.c;
        if (r4 == null) goto L11;
        r4.removeAllViews();
    L11:
        ProfileOpenArea r5 = r9.openArea;
        if (r5 == null) goto L16;
        ProfileBusinessArea r6 = r5.businessAreaV3;
        if (r6 == null) goto L16;
        com.bytedance.android.live.base.model.user.i0 r7 = r6.residentGuestBanner;
    L17:
        if (r7 == null) goto L19;
        List r8 = r7.a();
    L20:
        List r10 = r8;
        boolean r12 = true;
        int r13 = 0;
        if (r10 != null) goto L23;
    L26:
        boolean r14 = true;
    L27:
        boolean r15 = !r14;
        if (r7 == null) goto L30;
        IBaseUser r16 = r7.b();
    L31:
        if (r16 != null) goto L34;
        r12 = false;
    L34:
        String r17 = GsonProtectorUtils.toJson(GsonHelper.get(), r7);
        if (r15 == false) goto L37;
        r13 = g;
    L39:
        ViewGroup r18 = this.c;
        if (r18 == null) goto L45;
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        if (r19 == null) goto L44;
        r19.height = r13;
        Unit r20 = Unit.INSTANCE;
        r3 = r19;
    L44:
        r18.setLayoutParams(r3);
    L45:
        this.d = new c0(this, r0, x6.a.d(r1), s1.y());
        LinkedHashMap r22 = new LinkedHashMap();
        r22.put("resident_guest_data", r17);
        r22.put("target_user_id", r9.baseProfileInfo.getIdStr());
        c0 r23 = this.d;
        if (r23 == null) goto L49;
        r23.d(r1, r22);
        return;
    L49:
        return;
    L37:
        if (r12 == false) goto L39;
        r13 = h;
        goto L39
    L30:
        r16 = null;
        goto L31
    L23:
        if (r10.isEmpty() == true) goto L26;
        r14 = false;
        goto L27
    L19:
        r8 = null;
    L16:
        r7 = null;
        goto L17
    }
}
