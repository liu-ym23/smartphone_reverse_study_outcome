package com.bytedance.android.live.profile;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.BaseProfileInfo;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.UserProfileDataResp;
import com.bytedance.android.live.base.model.user.c0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.monitor.EndType;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.monitor.TimeType;
import com.bytedance.android.live.profile.mysteriousman.MysteriousManDialogFragment;
import com.bytedance.android.live.profile.p000enum.ProfileMode;
import com.bytedance.android.live.profile.ui.util.r;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.event.FollowStatusDataErrorEvent;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import zg1.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ NewProfileDialogLauncher a;
    public final /* synthetic */ UserProfileEvent b;
    public final /* synthetic */ ProfileMonitor c;
    public final /* synthetic */ long d;
    public final /* synthetic */ IRoom e;
    public final /* synthetic */ long f;
    public final /* synthetic */ Function1 g;
    public final /* synthetic */ ProfileMode h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ String j;
    public final /* synthetic */ DataCenter k;
    public final /* synthetic */ boolean l;
    public final /* synthetic */ FragmentActivity m;
    public final /* synthetic */ IBaseUser n;
    public final /* synthetic */ String o;
    public final /* synthetic */ boolean p;
    public final /* synthetic */ Function3 q;

    public g(NewProfileDialogLauncher r4, UserProfileEvent r5, ProfileMonitor r6, long r7, IRoom r9, long r10, Function1 r12, ProfileMode r13, boolean r14, String r15, DataCenter r16, boolean r17, FragmentActivity r18, IBaseUser r19, String r20, boolean r22, Function3 r23) {
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r9;
        this.f = r10;
        this.g = r12;
        this.h = r13;
        this.i = r14;
        this.j = r15;
        this.k = r16;
        this.l = r17;
        this.m = r18;
        this.n = r19;
        this.o = r20;
        this.p = r22;
        this.q = r23;
    }

    public final void accept(Object r15) {
        BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra> r16 = (BaseResponse) r15;
        Intrinsics.checkNotNullParameter(r16, "response");
        int r1 = ys0.c.a;
        UserProfileEvent r2 = this.b;
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r16, "response");
        if (ys0.c.a() == false) goto L21;
        IBaseUser r0 = r2.user;
        if (r0 != null) goto L8;
        String r3 = r2.getUserIdStr();
    L9:
        UserProfileDataResp r4 = (UserProfileDataResp) r16.data;
        if (r4 == null) goto L16;
        NewProfileUser r5 = r4.profileUser;
        if (r5 == null) goto L16;
        BaseProfileInfo r6 = r5.baseProfileInfo;
        if (r6 == null) goto L16;
        r6.setIdStr(r3.toString());
    L16:
        UserProfileDataResp r7 = (UserProfileDataResp) r16.data;
        if (r7 == null) goto L21;
        IBaseUser r8 = r7.roomUser;
        if (r8 == null) goto L21;
        r8.setIdString(r3.toString());
        goto L21
    L8:
        r3 = r0.getIdString();
    L21:
        ProfileMonitor r9 = this.c;
        r9.i(TimeType.RequestEnd);
        r9.d(DataType.RequestLogId, r16.logId);
        r9.d(DataType.RequestSuccess, Boolean.TRUE);
        NewProfileDialogLauncher r10 = this.a;
        long r12 = this.d;
        IRoom r13 = this.e;
        r10.getClass();
        NewProfileDialogLauncher.d(r12, r13, DataType.TRUE);
        boolean r14 = false;
        this.a.a = false;
        String r17 = r16.logId;
        if (r17 != null) goto L24;
        r17 = "";
    L24:
        ALogger.i("NewProfileDialogLauncher", "livesdk_new_profile_load_success_".concat(r17));
        NewProfileDialogLauncher.a(this.a, 0, this.f);
        if (this.a.b == false) goto L30;
        ALogger.i("NewProfileDialogLauncher", "livesdk_new_profile_return");
        Function1 r18 = this.g;
        if (r18 == null) goto L29;
        Unit r19 = (Unit) r18.invoke(this.h);
    L29:
        ProfileMonitor.b(this.c, EndType.Dismissed);
        return;
    L30:
        r.a(r16);
        UserProfileDataResp r20 = (UserProfileDataResp) r16.data;
        String r110 = null;
        if (r20 == null) goto L33;
        NewProfileUser r22 = r20.profileUser;
    L34:
        int r23 = com.bytedance.android.live.profile.mysteriousman.a.a;
        if (r22 == null) goto L41;
        BaseProfileInfo r24 = r22.baseProfileInfo;
        if (r24 == null) goto L41;
        if (r24.isMysteryMan() != true) goto L41;
        r14 = true;
    L41:
        this.c.d(DataType.TargetIsMysteryMan, Boolean.valueOf(r14));
        if (this.i == false) goto L66;
        if (r14 == false) goto L60;
        LiveDialogFragment r25 = this.a.c;
        if (r25 != null) goto L103;
    L52:
        ua1.a r26 = com.bytedance.android.live.service.b.a();
        if (r26 == null) goto L57;
        com.bytedance.android.live.service.prerequest.a r27 = r26.getPreRequestManager();
        if (r27 == null) goto L57;
        r27.b(this.j);
    L57:
        NewProfileDialogLauncher r28 = this.a;
        MysteriousManDialogFragment.a r29 = MysteriousManDialogFragment.j;
        ProfileMonitor r30 = this.c;
        DataCenter r32 = this.k;
        boolean r33 = this.l;
        IRoom r34 = this.e;
        UserProfileEvent r35 = this.b;
        r29.getClass();
        r28.e(MysteriousManDialogFragment.a.a(r30, r32, r33, r34, r35, r16));
        FragmentManager r36 = this.m.getSupportFragmentManager();
        LiveDialogFragment r37 = this.a.c;
        if (r37 == null) goto L88;
        a(r37, r36, "MysteriousManProfile");
    L88:
        if (this.i == true) goto L90;
        xs2.b r38 = xs2.b.a();
        w1 r39 = new w1(true);
        WeakReference r40 = new WeakReference(this.a.c);
        Intrinsics.checkNotNullParameter(r40, "<set-?>");
        r39.a = r40;
        Unit r42 = Unit.INSTANCE;
        r38.post(r39);
    L90:
        xs2.b r43 = xs2.b.a();
        UserProfileDataResp r44 = (UserProfileDataResp) r16.data;
        if (r44 == null) goto L95;
        NewProfileUser r45 = r44.profileUser;
        if (r45 == null) goto L95;
        c0 r46 = r45.followInfo;
    L96:
        FollowStatusDataErrorEvent.FollowDataSource r47 = FollowStatusDataErrorEvent.FollowDataSource.PROFILE_FOLLOW;
        String r48 = r16.logId;
        IRoom r111 = this.e;
        if (r111 == null) goto L101;
        IBaseUser r112 = r111.getOwner();
        if (r112 == null) goto L101;
        r110 = r112.getIdString();
    L101:
        r43.post(new FollowStatusDataErrorEvent(r46, r47, "", r48, r110, this.j));
        return;
    L95:
        r46 = null;
        goto L96
    L103:
        r25.dismissAllowingStateLoss();     // Catch: Exception -> L48
    L48:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r49 = DialogFragmentLancet.sLastShowStack;
        if (r49 == null) goto L52;
        com.bytedance.crash.d.d(r49, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L52
    L60:
        LiveDialogFragment r50 = this.a.c;
        if ((r50 instanceof NewLiveProfileDialogFragment) == true) goto L63;
        r50 = null;
    L63:
        NewLiveProfileDialogFragment r52 = (NewLiveProfileDialogFragment) r50;
        if (r52 == null) goto L88;
        r52.update(r16);
        goto L88
    L66:
        if (r14 == false) goto L70;
        NewProfileDialogLauncher r53 = this.a;
        MysteriousManDialogFragment.a r54 = MysteriousManDialogFragment.j;
        ProfileMonitor r55 = this.c;
        DataCenter r56 = this.k;
        boolean r57 = this.l;
        IRoom r58 = this.e;
        UserProfileEvent r59 = this.b;
        r54.getClass();
        r53.e(MysteriousManDialogFragment.a.a(r55, r56, r57, r58, r59, r16));
        FragmentManager r60 = this.m.getSupportFragmentManager();
        LiveDialogFragment r62 = this.a.c;
        if (r62 == null) goto L88;
        a(r62, r60, "MysteriousManProfile");
        goto L88
    L70:
        NewProfileDialogLauncher r113 = this.a;
        NewLiveProfileDialogFragment.a r63 = NewLiveProfileDialogFragment.A;
        ProfileMonitor r64 = this.c;
        DataCenter r65 = this.k;
        boolean r66 = this.l;
        IRoom r67 = this.e;
        String r68 = this.o;
        UserProfileEvent r69 = this.b;
        long r70 = this.f;
        ProfileMode r72 = this.h;
        boolean r114 = this.p;
        r63.getClass();
        r113.e(NewLiveProfileDialogFragment.a.a(r64, r65, r66, r67, r68, r69, r16, r70, r72, r114));
        LiveDialogFragment r73 = this.a.c;
        if ((r73 instanceof NewLiveProfileDialogFragment) == true) goto L73;
        r73 = null;
    L73:
        NewLiveProfileDialogFragment r74 = (NewLiveProfileDialogFragment) r73;
        if (r74 == null) goto L78;
        String r75 = this.b.interactLogLabel;
        if (r75 == null) goto L78;
        r74.T90().setInteractLogLabel(r75);
    L78:
        Function3 r76 = this.q;
        if (r76 == null) goto L84;
        ProfileMode r77 = this.h;
        LiveDialogFragment r78 = this.a.c;
        if ((r78 instanceof com.bytedance.android.live.profile.seeselftransition.b) == true) goto L83;
        r78 = null;
    L83:
        r76.invoke(r77, (com.bytedance.android.live.profile.seeselftransition.b) r78, this.m.getSupportFragmentManager());
        goto L88
    L84:
        FragmentManager r79 = this.m.getSupportFragmentManager();
        LiveDialogFragment r80 = this.a.c;
        if (r80 == null) goto L88;
        a(r80, r79, "NewLiveProfileDialogFragment");
        goto L88
    L33:
        r22 = null;
        goto L34
    }

    public static void a(LiveDialogFragment r1, FragmentManager r2, String r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r1, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r1.show(r2, r3);
    }
}
