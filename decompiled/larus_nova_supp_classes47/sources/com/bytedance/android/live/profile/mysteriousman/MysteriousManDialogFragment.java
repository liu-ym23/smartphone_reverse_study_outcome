package com.bytedance.android.live.profile.mysteriousman;

import am2.x;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.BaseProfileInfo;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileBadgeSuffix;
import com.bytedance.android.live.base.model.user.ProfileBasicArea;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.base.model.user.UserProfileDataResp;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.profile.NewLiveProfileDialogFragment;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.monitor.EndType;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.ui.component.view.ProfileBadgeSuffixView;
import com.bytedance.android.live.profit.privilege.c;
import com.bytedance.android.live.profit.privilege.model.ProfitCheckType;
import com.bytedance.android.live.revenue.core.util.h;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import py.f;
import py.t;
import rs0.i0;
import xs2.b;
import zg1.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profile/mysteriousman/MysteriousManDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MysteriousManDialogFragment extends LiveDialogFragment {
    public static final a j = null;
    public View d;
    public DataCenter e;
    public IRoom f;
    public UserProfileEvent g;
    public BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra> h;
    public ProfileMonitor i;

    public static final class a {
        public a() {
        }

        public static MysteriousManDialogFragment a(ProfileMonitor r5, DataCenter r6, boolean r7, IRoom r8, UserProfileEvent r9, BaseResponse r10) {
            Intrinsics.checkNotNullParameter(r5, "profileMonitor");
            Intrinsics.checkNotNullParameter(r9, "userProfileEvent");
            long r0 = SystemClock.uptimeMillis();
            a r2 = MysteriousManDialogFragment.j;
            if ((r0 - 0) >= 200) goto L6;
            ALogger.i("MysteriousManProfile", "stop_quick_click");
            EndType r12 = EndType.ClickFrequently;
            ProfileMonitor.a r13 = ProfileMonitor.g;
            r5.a(r12, "");
            return null;
        L6:
            MysteriousManDialogFragment r1 = new MysteriousManDialogFragment();
            r1.i = r5;
            r1.setVertical(r7);
            r1.e = r6;
            r1.f = r8;
            Intrinsics.checkNotNullParameter(r9, "<set-?>");
            r1.g = r9;
            r1.h = r10;
            NewLiveProfileDialogFragment.a r14 = NewLiveProfileDialogFragment.A;
            long r15 = SystemClock.uptimeMillis();
            r14.getClass();
            NewLiveProfileDialogFragment.z = r15;
            return r1;
        }
    }

    static {
        j = new a();
    }

    public MysteriousManDialogFragment() {
        setShouldUseNewPanel(true);
        setNoTitleAndCancelOutside(true);
        this.g = new UserProfileEvent(DataType.FALSE);
    }

    public final void onActivityCreated(Bundle r7) {
        Dialog r0 = getDialog();
        setBanLandscapeStyleSetting(true);
        super.onActivityCreated(r7);
        if (r0 == null) goto L25;
        Window r8 = r0.getWindow();
        if (r8 != null) goto L7;
        return;
    L7:
        if (isVertical() == true) goto L22;
        r8.setType(WebcastRedirectException.UNKNOWN);
        r8.addFlags(1024);
        r8.setLayout(UtilityKotlinExtentionsKt.i(340) + UtilityKotlinExtentionsKt.i(12), -1);
        View r1 = this.d;
        ViewParent r4 = null;
        if (r1 == null) goto L11;
        ViewParent r2 = r1.getParent();
    L13:
        if ((r2 instanceof ViewGroup) == false) goto L16;
        r4 = r2;
    L16:
        ViewGroup r5 = (ViewGroup) r4;
        if (r5 == null) goto L19;
        a1.p(r5, -1);
    L19:
        if (r5 == null) goto L21;
        r5.setPadding(0, 0, UtilityKotlinExtentionsKt.i(12), UtilityKotlinExtentionsKt.i(12));
    L21:
        r8.setGravity(85);
    L23:
        r8.setBackgroundDrawable(new ColorDrawable(0));
        return;
    L11:
        r2 = null;
        goto L13
    L22:
        r8.setLayout(-1, s1.w() - s1.A());
        r8.setGravity(80);
        goto L23
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (isVertical() == false) goto L5;
        int r3 = 2131954579;
    L6:
        setStyle(1, r3);
        return;
    L5:
        r3 = 2131954852;
        goto L6
    }

    public final void onDismiss(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");     // Catch: Throwable -> L8
        super.onDismiss(r3);     // Catch: Throwable -> L8
        ProfileMonitor r4 = this.i;     // Catch: Throwable -> L8
        if (r4 == null) goto L5;
        r4.a(EndType.Success, "MysteriousManProfile");     // Catch: Throwable -> L8
    L5:
        b.a().post(new w1(false));     // Catch: Throwable -> L8
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L8:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v12, types: [android.view.View, com.bytedance.android.live.profile.ui.component.view.ProfileBadgeSuffixView] */
    public final void onViewCreated(View r23, Bundle r24) {
        Intrinsics.checkNotNullParameter(r23, "view");
        super.onViewCreated(r23, r24);
        BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra> r0 = this.h;
        if (r0 == null) goto L7;
        UserProfileDataResp r2 = (UserProfileDataResp) r0.data;
        if (r2 == null) goto L7;
        IBaseUser r7 = r2.roomUser;
    L8:
        if (r0 == null) goto L12;
        UserProfileDataResp r3 = (UserProfileDataResp) r0.data;
        if (r3 == null) goto L12;
        NewProfileUser r9 = r3.profileUser;
    L13:
        if (r0 == null) goto L17;
        UserProfileDataResp.UserProfileExtra r1 = r0.extra;
        if (r1 == null) goto L17;
        String r8 = r1.mysteryDetailJumpSchema;
    L18:
        if (r7 == null) goto L183;
        MysteriousManViewHolder r13 = new MysteriousManViewHolder(r23, this, this.e, this.f, isVertical(), this.g, r7, r8, r9, new MysteriousManDialogFragment$onViewCreated$1$1(this));
        DataCenter r4 = r13.d;
        if (r4 == null) goto L22;
        IBaseUser r5 = (IBaseUser) r4.get("data_user_in_room", null);
    L23:
        if (r5 != null) goto L30;
        IMiddlewareUserService r6 = k.f(IMiddlewareUserService.class);
        if (r6 == null) goto L29;
        e r10 = r6.user();
        if (r10 == null) goto L29;
        r5 = r10.b();
    L29:
        r5 = null;
    L30:
        if (r5 == null) goto L32;
        String r12 = r5.getIdString();
    L33:
        IRoom r14 = r13.e;
        if (r14 == null) goto L36;
        String r15 = r14.getOwnerUserIdString();
    L38:
        if (Intrinsics.areEqual(r12, r15) == false) goto L40;
        int r16 = 1;
    L53:
        r13.a = r16;
        HashMap r17 = new HashMap();
        if (r13.a != 0) goto L56;
        String r18 = "mystery";
    L57:
        r17.put("shown_user_status", r18);
        j0.l().sendLog("livesdk_mystery_personal_card_show", r17, new Object[]{IRoom.class, x.class});
        if (r13.a != 0) goto L93;
        NewProfileUser r19 = r13.k;
        if (r19 == null) goto L65;
        BaseProfileInfo r20 = r19.baseProfileInfo;
        if (r20 == null) goto L65;
        String r22 = r20.getIdStr();
    L67:
        if ((!Intrinsics.areEqual(r22, k.n(IMiddlewareUserService.class).user().n())) == true) goto L93;
        LinkedHashMap r25 = new LinkedHashMap();
        NewProfileUser r26 = r13.k;
        if (r26 == null) goto L74;
        BaseProfileInfo r27 = r26.baseProfileInfo;
        if (r27 == null) goto L74;
        r25.put("mystery_man", Integer.valueOf(r27.mysteryMan));
    L74:
        NewProfileUser r28 = r13.k;
        if (r28 == null) goto L83;
        ProfileSkin r29 = r28.mProfileSkin;
        if (r29 == null) goto L83;
        ProfileCustomSkin r30 = r29.skin;
        if (r30 == null) goto L83;
        String r32 = r30.avatarBorderDressId;
        if (r32 == null) goto L83;
        r25.put("avatar_border_dress_id", r32);
    L83:
        NewProfileUser r33 = r13.k;
        if (r33 == null) goto L92;
        ProfileSkin r34 = r33.mProfileSkin;
        if (r34 == null) goto L92;
        ProfileCustomSkin r35 = r34.skin;
        if (r35 == null) goto L92;
        String r36 = r35.dressId;
        if (r36 == null) goto L92;
        r25.put("profile_skin_dress_id", r36);
    L92:
        r25.put("source", 1);
        boolean r37 = h.a;
        ((c) h.d(c.class)).B1(ProfitCheckType.DRESS_SHOW, r25, null);
    L65:
        r22 = null;
    L93:
        HSImageView r38 = r13.b.findViewById(2131380587);
        if (r38 == null) goto L96;
        ImageLoader.bindImage(r38, r13.h.getPersonalCard());
    L96:
        View r39 = r13.b;
        int r40 = r13.a;
        int r42 = 8;
        if (r40 == 0) goto L115;
        if (r40 == 1) goto L105;
        if (r40 == 2) goto L105;
        r13.b(r39, 2131379512, 8, false);
        if (r13.c() == true) goto L104;
        r42 = 0;
    L104:
        r13.b(r39, 2131384367, r42, true);
    L116:
        View r43 = r13.b;
        HSImageView r44 = r43.findViewById(2131380585);
        if (r44 == null) goto L119;
        ImageLoader.bindAvatar(r44, r13.h.getAvatarThumbKt(), UtilityKotlinExtentionsKt.i(65), UtilityKotlinExtentionsKt.i(65));
    L119:
        zt0.e r45 = yt0.c.a();
        f r46 = r13.h.getBorder();
        if (r46 == null) goto L122;
        String r47 = r46.getDressId();
    L123:
        com.bytedance.android.live.profit.dress.a r48 = (com.bytedance.android.live.profit.dress.a) r45.getDressData(r47, 1, "MysteriousManProfile: initAvatarArea");
        if (r48 == null) goto L127;
        py.k r49 = r48.a;
        if (r49 == null) goto L127;
    L131:
        HSImageView r50 = r43.findViewById(2131380586);
        if (r50 == null) goto L134;
        ImageLoader.bindImage(r50, r49, UtilityKotlinExtentionsKt.i(82), UtilityKotlinExtentionsKt.i(85));
    L134:
        TextView r52 = (TextView) r43.findViewById(2131380588);
        if (r52 == null) goto L138;
        r52.setText(r13.h.getNickName());
    L138:
        if (((Boolean) i0.a.getValue()).booleanValue() == false) goto L172;
        ViewGroup r53 = (ViewGroup) r13.b.findViewById(2131373879);
        ViewGroup r54 = (ViewGroup) r13.b.findViewById(2131373878);
        if (r54 == 0) goto L172;
        Context r55 = r54.getContext();
        if (r55 == null) goto L172;
        r54.removeAllViews();
        NewProfileUser r56 = r13.k;
        if (r56 == null) goto L170;
        ProfileBasicArea r57 = r56.basicArea;
        if (r57 == null) goto L170;
        List r58 = r57.badgeList;
        if (r58 == null) goto L170;
        if ((!r58.isEmpty()) == true) goto L154;
        r58 = null;
    L154:
        if (r58 == null) goto L170;
        if (r53 == null) goto L157;
        UtilityKotlinExtentionsKt.w(r53);
    L157:
        ProfileBasicArea r59 = r13.k.basicArea;
        if (r59 == null) goto L161;
        Map r60 = r59.badgeSuffixMap;
        if (r60 == null) goto L161;
    L162:
        Iterator r62 = r58.iterator();
    L164:
        if (r62.hasNext() == false) goto L172;
        py.k r110 = (py.k) r62.next();
        Context r63 = r13.c.getActivity();
        if (r63 != null) goto L169;
        r63 = r55;
    L169:
        ?? r64 = new ProfileBadgeSuffixView(r63, null, 6, 0);
        ProfileBadgeSuffix r65 = (ProfileBadgeSuffix) r60.get(r110.getImageType());
        Intrinsics.checkNotNullParameter(r110, "badge");
        ImageLoader.bindImage(r64.b, r110, null, -1, -1, null, new com.bytedance.android.live.profile.ui.component.view.a(r64, r110, r65), true);
        r54.addView(r64);
    L161:
        r60 = MapsKt.emptyMap();
    L170:
        if (r53 == null) goto L172;
        UtilityKotlinExtentionsKt.t(r53);
    L172:
        TextView r66 = (TextView) r13.b.findViewById(2131380591);
        if (r66 != null) goto L175;
    L178:
        r13.b(r13.b, 2131372537, 0, true);
        Unit r67 = Unit.INSTANCE;
        return;
    L175:
        if (r13.a != 0) goto L177;
        r66.setText(s1.B(2131920655));
        goto L178
    L177:
        r66.setText(s1.B(2131920654));
    L127:
        f r68 = r13.h.getBorder();
        if (r68 == null) goto L130;
        r49 = r68.getIcon();
        goto L131
    L130:
        r49 = null;
        goto L131
    L122:
        r47 = null;
    L105:
        r13.b(r39, 2131379512, 0, true);
        int r69 = r13.j;
        if (r69 == 1) goto L111;
        if (r69 == 3) goto L109;
        r13.b(r39, 2131384367, 0, true);
        goto L116
    L109:
        r13.b(r39, 2131384367, 8, false);
        goto L116
    L111:
        if (r13.c() == true) goto L114;
        r42 = 0;
    L114:
        r13.b(r39, 2131384367, r42, true);
        goto L116
    L115:
        r13.b(r39, 2131379512, 8, false);
        r13.b(r39, 2131384367, 8, false);
        goto L116
    L56:
        r18 = "regular";
        goto L57
    L40:
        if (r5 == null) goto L42;
        String r70 = r5.getIdString();
    L44:
        if (Intrinsics.areEqual(r70, r13.h.getIdString()) == false) goto L46;
        r16 = 0;
        goto L53
    L46:
        if (r5 == null) goto L52;
        t r72 = r5.getUserAttrExt();
        if (r72 == null) goto L52;
        if (r72.isAdmin() != true) goto L52;
        r16 = 2;
    L52:
        r16 = 3;
        goto L53
    L42:
        r70 = null;
        goto L44
    L36:
        r15 = null;
        goto L38
    L32:
        r12 = null;
        goto L33
    L22:
        r5 = null;
        goto L23
    L183:
        return;
    L17:
        r8 = null;
    L12:
        r9 = null;
    L7:
        r7 = null;
        goto L8
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131565660, r3, false);
        this.d = r5;
        return r5;
    }
}
