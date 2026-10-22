package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.DressSuitInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.profile.p000enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k extends com.bytedance.android.live.profile.ui.base.k {
    public static final float d = 0.0f;
    public View b;
    public final com.bytedance.android.live.profile.ui.base.h c;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ k a;
        public final /* synthetic */ ProfileCustomSkin.SuitShopEnterButton b;
        public final /* synthetic */ View c;

        public b(k r1, ProfileCustomSkin.SuitShopEnterButton r2, View r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            this.a.c.recordBusinessClick("get_same_dress_button", null);
            String r9 = this.b.schema;
            if (r9 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L11;
            return;
        L11:
            jc1.k.n(IBaseLiveActionHandler.class).handle(this.c.getContext(), r9);
            k r10 = this.a;
            com.bytedance.android.live.profile.ui.base.h r3 = r10.c;
            Pair[] r4 = new Pair[5];
            DressSuitInfo r5 = r3.getTargetUser().getDressSuitInfo();
            String r6 = "";
            if (r5 == null) goto L15;
            String r7 = r5.getUserSuitId();
            if (r7 == null) goto L15;
        L16:
            r4[0] = TuplesKt.to("package_id", r7);
            r4[1] = TuplesKt.to("show_from", "profile_card");
            UserProfileEvent r12 = r10.c.getUserProfileEvent();
            if (r12 == null) goto L20;
            String r13 = r12.getClickUserPosition();
            if (r13 == null) goto L20;
        L21:
            r4[2] = TuplesKt.to("request_page", r13);
            ProfileSkin r14 = r10.c.getTargetUser().mProfileSkin;
            if (r14 == null) goto L27;
            ProfileCustomSkin r15 = r14.skin;
            if (r15 == null) goto L27;
            String r16 = r15.dressId;
            if (r16 == null) goto L27;
        L28:
            r4[3] = TuplesKt.to("wear_id", r16);
            qs0.m r17 = os0.b.c().getILiveOntologyInfoManager();
            if (r17 == null) goto L34;
            String r18 = r17.getEnterFromMerge();
            if (r18 == null) goto L34;
            r6 = r18;
        L34:
            r4[4] = TuplesKt.to("drawer_page", r6);
            r3.sendLog("livesdk_package_center_get_same_click", MapsKt.mapOf(r4), new Object[]{am2.x.class, IRoom.class});
            return;
        L27:
            r16 = "";
        L20:
            r13 = "";
        L15:
            r7 = "";
            goto L16
        L5:
            if (StringsKt.isBlank(r9) == true) goto L8;
            r2 = false;
            goto L9
        }
    }

    static {
        d = UtilityKotlinExtentionsKt.h(16);
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        ALogger.i("NewUserProfile_ProfilePre", "ProfileDressPreviewDefaultComponent destroy");
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.DressPreviewDefault.INSTANCE;
    }

    public k(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        this.c = r2;
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r3) {
        if (ProfilePreInflateUtil.a() == false) goto L5;
        com.bytedance.android.live.profile.ui.base.e r4 = (com.bytedance.android.live.profile.ui.base.e) r3;
        View r5 = r4.b(ProfilePreInflateViewInfo.TTLIVE_PROFILE_DRESS_PREVIEW_DEFAULT, true);
    L6:
        if (r5 == null) goto L8;
        View r6 = r5.findViewById(2131389561);
    L9:
        this.b = r6;
        return;
    L8:
        r6 = null;
        goto L9
    L5:
        r5 = ((com.bytedance.android.live.profile.ui.base.e) r3).f(2131567199, true);
        goto L6
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r8) {
        Intrinsics.checkNotNullParameter(r8, "user");
        Intrinsics.checkNotNullParameter(r8, "user");
        Intrinsics.checkNotNullParameter(r8, "user");
        com.bytedance.android.live.profile.ui.base.h r9 = this.c;
        Pair[] r0 = new Pair[5];
        DressSuitInfo r1 = r9.getTargetUser().getDressSuitInfo();
        String r2 = "";
        if (r1 == null) goto L6;
        String r3 = r1.getUserSuitId();
        if (r3 == null) goto L6;
    L7:
        r0[0] = TuplesKt.to("package_id", r3);
        r0[1] = TuplesKt.to("show_from", "profile_card");
        UserProfileEvent r4 = this.c.getUserProfileEvent();
        if (r4 == null) goto L11;
        String r5 = r4.getClickUserPosition();
        if (r5 == null) goto L11;
    L12:
        r0[2] = TuplesKt.to("request_page", r5);
        ProfileSkin r6 = this.c.getTargetUser().mProfileSkin;
        if (r6 == null) goto L18;
        ProfileCustomSkin r7 = r6.skin;
        if (r7 == null) goto L18;
        String r10 = r7.dressId;
        if (r10 == null) goto L18;
    L19:
        r0[3] = TuplesKt.to("wear_id", r10);
        qs0.m r12 = os0.b.c().getILiveOntologyInfoManager();
        if (r12 == null) goto L25;
        String r13 = r12.getEnterFromMerge();
        if (r13 == null) goto L25;
        r2 = r13;
    L25:
        r0[4] = TuplesKt.to("drawer_page", r2);
        r9.sendLog("livesdk_package_center_get_same_show", MapsKt.mapOf(r0), new Object[]{am2.x.class, IRoom.class});
        this.c.recordBusinessShow(TrackArea.TopWhiteArea, "get_same_dress_button");
        return;
    L18:
        r10 = "";
    L11:
        r5 = "";
    L6:
        r3 = "";
        goto L7
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r8) {
        Intrinsics.checkNotNullParameter(r8, "user");
        View r1 = this.b;
        if (r1 != null) goto L5;
        return;
    L5:
        ProfileSkin r9 = r8.mProfileSkin;
        if (r9 == null) goto L40;
        ProfileCustomSkin r10 = r9.skin;
        if (r10 == null) goto L41;
        ProfileCustomSkin.SuitShopEnterButton r12 = r10.suitShopEnterButton;
        if (r12 == null) goto L42;
        ShapeDrawable r2 = new ShapeDrawable();
        float[] r4 = new float[8];
        int r5 = 0;
    L13:
        if (r5 >= 8) goto L15;
        r4[r5] = d;
        r5 = r5 + 1;
        goto L13
    L15:
        r2.setShape(new RoundRectShape(r4, null, null));
        String r6 = "#7F209B79";
        r2.getPaint().setColor(ColorProtector.parseColor("#7F209B79"));
        Paint r3 = r2.getPaint();     // Catch: Exception -> L22
        String r7 = r12.bgColor;     // Catch: Exception -> L22
        if (r7 == null) goto L20;
        r6 = r7;
    L20:
        r3.setColor(Color.parseColor(r6));     // Catch: Exception -> L22
    L24:
        Unit r13 = Unit.INSTANCE;
        r1.setBackground(r2);
        TextView r14 = (TextView) r1.findViewById(2131389562);
        r14.setText(r12.text);
        String r15 = "#FFFFFF";
        r14.setTextColor(ColorProtector.parseColor("#FFFFFF"));
        String r16 = r12.color;     // Catch: Exception -> L31
        if (r16 == null) goto L29;
        r15 = r16;
    L29:
        r14.setTextColor(Color.parseColor(r15));     // Catch: Exception -> L31
    L33:
        r1.setOnClickListener(new b(this, r12, r1));
        return;
    L31:
        e = move-exception;
        ALogger.e("ProfileDressPreviewDefaultComponent", "parse textColor error: " + e.getMessage());
    L22:
        e = move-exception;
        ALogger.e("ProfileDressPreviewDefaultComponent", "parse background error: " + e.getMessage());
        goto L24
    L42:
        return;
    L41:
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r3, "newUser");
        ALogger.i("NewUserProfile_ProfilePre", "ProfileDressPreviewDefaultComponent update");
        g(r3);
    }
}
