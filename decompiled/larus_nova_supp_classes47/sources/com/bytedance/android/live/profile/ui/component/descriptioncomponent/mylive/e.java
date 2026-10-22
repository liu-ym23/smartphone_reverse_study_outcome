package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive;

import am2.x;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.event.EventHub;
import com.bytedance.android.live.profile.event.SpreadStateType;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e extends com.bytedance.android.live.profile.ui.base.k {
    public ConstraintLayout b;
    public TextView c;
    public ImageView d;
    public View e;
    public View f;
    public final com.bytedance.android.live.profile.ui.base.h g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ e a;
        public final /* synthetic */ EventHub b;

        public b(e r1, EventHub r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            this.a.getClass();
            j0.l().sendLog("livesdk_my_live_profile_card_click", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_area", "gift_and_pk")}), new Object[]{IRoom.class, x.class});
            Object r7 = this.b.b.a;
            SpreadStateType r1 = ((com.bytedance.android.live.profile.event.a) r7).a;
            SpreadStateType r2 = SpreadStateType.Close;
            if (r1 != r2) goto L6;
            this.a.j(false);
            PropertyOwner<com.bytedance.android.live.profile.event.a> r8 = this.b.b;
            com.bytedance.android.live.profile.event.a r0 = new com.bytedance.android.live.profile.event.a(SpreadStateType.Open);
            r8.getClass();
            Intrinsics.checkNotNullParameter(r0, "t");
            r8.a(r0);
            return;
        L6:
            if (((com.bytedance.android.live.profile.event.a) r7).a != SpreadStateType.Open) goto L10;
            this.a.j(true);
            PropertyOwner<com.bytedance.android.live.profile.event.a> r9 = this.b.b;
            com.bytedance.android.live.profile.event.a r3 = new com.bytedance.android.live.profile.event.a(r2);
            r9.getClass();
            Intrinsics.checkNotNullParameter(r3, "t");
            r9.a(r3);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "newUser");
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.SpreadMore.INSTANCE;
    }

    public e(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        this.g = r2;
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r3) {
        ((com.bytedance.android.live.profile.ui.base.e) r3).f(2131567176, true);
        this.b = i(2131387124);
        this.c = (TextView) i(2131387125);
        this.d = (ImageView) i(2131387123);
        this.e = i(2131387121);
        this.f = i(2131387122);
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r2, "user");
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r9) {
        Intrinsics.checkNotNullParameter(r9, "user");
        EventHub r0 = this.g.getEventHub();
        int r1 = f.a[((com.bytedance.android.live.profile.event.a) r0.b.a).a.ordinal()];
        if (r1 == 1) goto L7;
        if (r1 != 2) goto L8;
        j(false);
    L8:
        ConstraintLayout r2 = this.b;
        if (r2 == null) goto L31;
        r2.setOnClickListener(new b(this, r0));
    L31:
        ProfileSkin r10 = r9.mProfileSkin;     // Catch: Exception -> L28
        if (r10 == null) goto L18;
        ProfileCustomSkin r12 = r10.skin;     // Catch: Exception -> L28
        if (r12 == null) goto L18;
        ProfileCustomSkin.HonorWallUI r13 = r12.honorWallSkin;     // Catch: Exception -> L28
        if (r13 == null) goto L18;
        String r14 = r13.titleColor;     // Catch: Exception -> L28
    L19:
        if (r14 != null) goto L21;
    L24:
        boolean r3 = true;
    L25:
        if (r3 == true) goto L33;
        int r15 = Color.parseColor(r14);     // Catch: Exception -> L28
        int r4 = com.bytedance.android.live.profile.ui.util.m.a;     // Catch: Exception -> L28
        com.bytedance.android.live.profile.ui.util.m.g(CollectionsKt.listOf(new View[]{this.e, this.f}), Color.argb(31, Color.red(r15), Color.green(r15), Color.blue(r15)));     // Catch: Exception -> L28
        com.bytedance.android.live.profile.ui.util.m.g(CollectionsKt.listOf(new View[]{this.c, this.d}), r15);     // Catch: Exception -> L28
        return;
    L33:
        return;
    L21:
        if (r14.length() == 0) goto L24;
        r3 = false;
    L18:
        r14 = null;
    L28:
        e = move-exception;
        ALogger.e("ProfileSpreadMoreComponent", "load skin error: " + e.getMessage());
        return;
    L7:
        j(true);
        goto L8
    }

    public final void j(boolean r2) {
        if (r2 == false) goto L9;
        TextView r3 = this.c;
        if (r3 == null) goto L6;
        r3.setText(s1.B(2131922634));
    L6:
        ImageView r4 = this.d;
        if (r4 == null) goto L16;
        r4.setRotation(0.0f);
        return;
    L16:
        return;
    L9:
        TextView r5 = this.c;
        if (r5 == null) goto L12;
        r5.setText(s1.B(2131922635));
    L12:
        ImageView r6 = this.d;
        if (r6 == null) goto L18;
        r6.setRotation(180.0f);
        return;
    }
}
