package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileBusinessArea;
import com.bytedance.android.live.base.model.user.ProfileOpenArea;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends com.bytedance.android.live.profile.ui.base.k {
    public b b;
    public com.bytedance.android.live.base.model.user.b c;
    public final com.bytedance.android.live.profile.ui.base.h d;

    /* JADX INFO: renamed from: com.bytedance.android.live.profile.ui.component.descriptioncomponent.a$a, reason: collision with other inner class name */
    public static final class C0014a {
    }

    public static final class b extends ka0.a {
        public final /* synthetic */ a c;
        public final /* synthetic */ int d;

        public final void a(HybridCard r2, String r3) {
            ALogger.e("AnchorHomelandEntrance", "on load failed, msg: " + r3);
        }

        public final void b(HybridCard r2, View r3, int r4) {
            ALogger.i("AnchorHomelandEntrance", "on load success");
            com.bytedance.android.live.profile.ui.base.d r5 = this.c.a;
            if (r5 == null) goto L5;
            r5.removeAllViews();
        L5:
            if (r2 == null) goto L10;
            ViewGroup.MarginLayoutParams r6 = new ViewGroup.MarginLayoutParams(-1, this.d);
            r6.bottomMargin = UtilityKotlinExtentionsKt.i(8);
            com.bytedance.android.live.profile.ui.base.d r7 = this.c.a;
            if (r7 == null) goto L11;
            r7.addView(r2, r6);
            return;
        L11:
            return;
        }

        public b(a r1, int r2, Context r3, Uri r4) {
            this.c = r1;
            this.d = r2;
            super(r3, r4, -1);
        }
    }

    static {
    }

    public final void k() {
        ALogger.i("AnchorHomelandEntrance", "release card");
        b r0 = this.b;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.b = null;
        this.c = null;
        com.bytedance.android.live.profile.ui.base.d r1 = this.a;
        if (r1 == null) goto L9;
        r1.removeAllViews();
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.AnchorHomeland.INSTANCE;
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        k();
    }

    public a(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        this.d = r2;
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r3, "user");
        ProfileOpenArea r4 = r3.openArea;
        if (r4 == null) goto L7;
        ProfileBusinessArea r5 = r4.businessAreaV3;
        if (r5 == null) goto L7;
        com.bytedance.android.live.base.model.user.b r6 = r5.anchorHomelandBanner;
    L8:
        ALogger.i("AnchorHomelandEntrance", "on bind user: " + r6);
        k();
        if (r6 == null) goto L12;
        j(r6);
        return;
    L12:
        return;
    L7:
        r6 = null;
        goto L8
    }

    public final void j(com.bytedance.android.live.base.model.user.b r8) {
        ALogger.i("AnchorHomelandEntrance", "on load lynx card");
        com.bytedance.android.live.profile.ui.base.d r1 = this.a;
        if (r1 == null) goto L19;
        Context r2 = r1.getContext();
        if (r2 == null) goto L20;
        int r3 = UtilityKotlinExtentionsKt.i(r8.a());
        String r4 = r8.c();
        if (r3 > 0) goto L10;
    L17:
        ALogger.e("AnchorHomelandEntrance", "on load failed, containerHeight: " + r3 + ", scheme: " + r4);
        return;
    L10:
        if (r4.length() != 0) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L17;
        this.c = r8;
        int r6 = com.bytedance.revenue.platform.api.core.e.a;
        Intrinsics.checkNotNullParameter(r4, "schemeString");
        b r0 = new b(this, r3, r2, UriProtector.parse(r4));
        this.b = r0;
        r0.d(r4, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("homeland_data", r8.b())}));
        return;
    L12:
        r5 = false;
        goto L13
    L20:
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r4) {
        Intrinsics.checkNotNullParameter(r4, "newUser");
        ProfileOpenArea r5 = r4.openArea;
        if (r5 == null) goto L7;
        ProfileBusinessArea r6 = r5.businessAreaV3;
        if (r6 == null) goto L7;
        com.bytedance.android.live.base.model.user.b r7 = r6.anchorHomelandBanner;
    L8:
        if (r7 != null) goto L12;
        k();
        return;
    L12:
        if (Intrinsics.areEqual(r7, this.c) == false) goto L14;
        return;
    L14:
        ALogger.i("AnchorHomelandEntrance", "user update user: " + r7 + ", card: " + this.b);
        b r0 = this.b;
        if (r0 == null) goto L17;
        r0.sendJsEvent("homeland_data_update", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("homeland_data", r7.b())}));
        return;
    L17:
        j(r7);
        return;
    L7:
        r7 = null;
        goto L8
    }
}
