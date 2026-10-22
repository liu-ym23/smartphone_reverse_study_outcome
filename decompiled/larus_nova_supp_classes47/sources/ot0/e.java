package ot0;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.BaseProfileInfo;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfilePoiInfo;
import com.bytedance.android.live.base.model.user.WhiteCategoryCert;
import com.bytedance.android.live.base.model.user.x;
import com.bytedance.android.live.base.model.user.y;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.usecase.NewProfileTrackUseCase;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.m;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import py.k;
import st0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements com.bytedance.android.live.profile.ui.component.base.a<f> {
    public final Fragment a;
    public final com.bytedance.android.live.profile.a b;

    public e(Fragment r2, NewProfileInfoViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "mNewProfileInfoViewModel");
        this.a = r2;
        this.b = r3;
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.a
    public final void a(View r13, NewProfileUser r14, f r15) {
        f r7 = r15;
        Intrinsics.checkNotNullParameter(r13, "view");
        Intrinsics.checkNotNullParameter(r14, "user");
        Intrinsics.checkNotNullParameter(r7, Constants.Keys.DATA);
        int r16 = r7.getType();
        String r8 = "";
        WhiteCategoryCert.SubCertInfo r9 = null;
        if (r16 != 0) goto L5;
        Context r17 = this.a.getContext();
        if (r17 == null) goto L139;
        Object r18 = r13.getTag(2131389678);
        if ((r18 instanceof vs0.c) == true) goto L71;
        r18 = null;
    L71:
        vs0.c r19 = (vs0.c) r18;
        if (Intrinsics.areEqual(r19, vs0.b.a) == false) goto L88;
        x r110 = r14.industryCertification;
        if (r110 == null) goto L78;
        y r111 = r110.getProfile();
        if (r111 == null) goto L78;
        String r112 = r111.getSchema();
    L80:
        if (StringsKt.equals$default(r112, "", false, 2, null) == true) goto L140;
        com.bytedance.android.live.profile.a r113 = this.b;
        x r114 = r14.industryCertification;
        if (r114 == null) goto L86;
        y r115 = r114.getProfile();
        if (r115 == null) goto L86;
        r9 = r115.getSchema();
    L86:
        r113.onVerifyViewClick(r17, r9);
        return;
    L140:
        return;
    L78:
        r112 = null;
        goto L80
    L88:
        if (Intrinsics.areEqual(r19, vs0.d.a) == false) goto L104;
        py.c r116 = r14.mAuthenticationInfo;
        if (r116 == null) goto L94;
        k r117 = r116.getAuthenticationBadge();
        if (r117 == null) goto L94;
        String r118 = r117.getSchema();
    L96:
        if (StringsKt.equals$default(r118, "", false, 2, null) == true) goto L142;
        com.bytedance.android.live.profile.a r119 = this.b;
        py.c r120 = r14.mAuthenticationInfo;
        if (r120 == null) goto L102;
        k r121 = r120.getAuthenticationBadge();
        if (r121 == null) goto L102;
        r9 = r121.getSchema();
    L102:
        r119.showVerifyPage(r17, r9);
        return;
    L142:
        return;
    L94:
        r118 = null;
        goto L96
    L104:
        if (Intrinsics.areEqual(r19, vs0.a.a) == false) goto L116;
        y r122 = r14.industryCertificationProfile;
        if (r122 == null) goto L108;
        String r123 = r122.getSchema();
    L110:
        if (StringsKt.equals$default(r123, "", false, 2, null) == true) goto L144;
        com.bytedance.android.live.profile.a r124 = this.b;
        y r125 = r14.industryCertificationProfile;
        if (r125 == null) goto L114;
        r9 = r125.getSchema();
    L114:
        r124.showNewCertDescPage(r17, r9);
        return;
    L144:
        return;
    L108:
        r123 = null;
        goto L110
    L116:
        if (Intrinsics.areEqual(r19, vs0.e.a) == false) goto L146;
        WhiteCategoryCert r126 = r14.whiteCategoryCert;
        if (r126 == null) goto L120;
        WhiteCategoryCert.SubCertInfo r127 = r126.subCertInfo;
    L121:
        if (r127 == null) goto L147;
        com.bytedance.android.live.profile.a r128 = this.b;
        if (r126 == null) goto L125;
        r9 = r126.subCertInfo;
    L125:
        r128.showWhiteCertPage(r17, r9);
        return;
    L147:
        return;
    L120:
        r127 = null;
        goto L121
    L146:
        return;
    L139:
        return;
    L5:
        if (r16 != 7) goto L148;
        WhiteCategoryCert.SubCertInfo r129 = this.a.getContext();
        if (r129 == null) goto L149;
        o r10 = os0.b.a();
        if (r10 == null) goto L13;
        Boolean r0 = r10.isAnchor();
    L15:
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L62;
        BaseProfileInfo r1 = r14.baseProfileInfo;
        if (r1 == null) goto L130;
        ProfilePoiInfo r2 = r1.poiInfo;
        if (r2 == null) goto L131;
        long r3 = r2.getPoiId();
        if (r3 <= 0) goto L150;
        d r12 = new d(this, r3, r10, r14, r13, r7);
        gz.a r130 = new gz.a();
        s1.w();
        Intrinsics.checkNotNullParameter(String.valueOf(r14.baseProfileInfo.poiInfo.getPoiId()), "<set-?>");
        if (r10 == null) goto L28;
        m r131 = r10.getRoom();
        if (r131 == null) goto L28;
        IRoom r132 = (IRoom) r131.getValue();
    L29:
        Map r4 = r130.a;
        if (r132 == null) goto L36;
        IBaseUser r5 = r132.getOwner();
        if (r5 == null) goto L36;
        String r6 = r5.getIdString();
        if (r6 == null) goto L36;
    L37:
        r4.put("anchor_id", r6);
        r130.a.put("live_status", "living");
        Map r20 = r130.a;
        if (r132 == null) goto L43;
        String r133 = String.valueOf(r132.getId());
        if (r133 == null) goto L43;
        r8 = r133;
    L43:
        r20.put("room_id", r8);
        IMiddlewareHostBusiness r134 = jc1.k.f(IMiddlewareHostBusiness.class);
        if (r134 == null) goto L46;
        DialogFragment r135 = r134.getPoiSearchModalDialog(r129, r130, r12);
    L48:
        if ((r129 instanceof FragmentActivity) == false) goto L51;
        r9 = r129;
    L51:
        FragmentActivity r22 = (FragmentActivity) r9;
        if (r22 == null) goto L132;
        FragmentManager r136 = r22.getSupportFragmentManager();
        if (r136 == null) goto L133;
        if (r135 == null) goto L134;
        LandscapeRestrictionOperation r137 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r135, "ProfileTag", r137);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r136, r135, r137) == true) goto L151;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L127
    L60:
        r135.showNow(r136, "ProfileTag");
        return;
    L151:
        return;
    L134:
        return;
    L133:
        return;
    L132:
        return;
    L46:
        r135 = null;
    L36:
        r6 = "";
    L28:
        r132 = null;
        goto L29
    L150:
        return;
    L131:
        return;
    L130:
        return;
    L62:
        if (r14.baseProfileInfo.poiInfo.getJumpSchema() == null) goto L136;
        jc1.k.n(IBaseLiveActionHandler.class).handle(this.a.getContext(), r14.baseProfileInfo.poiInfo.getJumpSchema());
        com.bytedance.android.live.profile.a r138 = this.b;
        if (r138 == null) goto L137;
        r138.logProile(NewProfileTrackUseCase.LogProfileType.POI_VIEW_CLK, new HashMap());
        return;
    L137:
        return;
    L136:
        return;
    L13:
        r0 = null;
        goto L15
    L149:
        return;
    }
}
