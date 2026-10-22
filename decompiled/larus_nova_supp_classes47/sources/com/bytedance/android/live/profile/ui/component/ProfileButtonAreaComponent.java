package com.bytedance.android.live.profile.ui.component;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.Appointment;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.UserProfileDataResp;
import com.bytedance.android.live.base.model.user.c0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.profile.NewLiveProfileDialogFragment;
import com.bytedance.android.live.profile.p000enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.component.base.DataAssembler;
import com.bytedance.android.live.profile.ui.component.view.ProfileButtonView;
import com.bytedance.android.live.profile.ui.component.view.button.ProfileAnchorSetButtonView;
import com.bytedance.android.live.profile.ui.component.view.button.ProfileFansGroupButtonView;
import com.bytedance.android.live.profile.ui.component.view.button.ProfileFollowButtonView;
import com.bytedance.android.live.profile.ui.component.view.button.ProfileJumpToOtherRoomButtonView;
import com.bytedance.android.live.profile.ui.component.view.button.ProfileOwnerCenterButtonView;
import com.bytedance.android.live.profile.ui.component.view.button.ProfileSquareJumpTaRoomButtonView;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfileButtonAreaComponent extends DataAssembler<st0.b> {
    public AnimatorSet g;
    public ProfileFollowButtonView h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public ProfileFansGroupButtonView l;
    public ProfileButtonView m;
    public ProfileButtonView n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final com.bytedance.android.live.profile.ui.base.l r;

    public static final class a<T> implements Observer {
        public final /* synthetic */ ProfileButtonAreaComponent a;

        public a(ProfileButtonAreaComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            Integer r9 = (Integer) r8;
            if (r9 == null) goto L85;
            int r10 = r9.intValue();
            if (r10 == 1) goto L9;
            if (r10 == 2) goto L9;
            boolean r3 = false;
        L11:
            if (this.a.q() == false) goto L40;
            ProfileFollowButtonView r4 = this.a.h;
            if (r4 == null) goto L15;
            r4.m(r10);
        L15:
            if (r3 == true) goto L19;
            ProfileFansGroupButtonView r0 = this.a.l;
            if (r0 == null) goto L86;
            r0.l(r3, r10);
            return;
        L86:
            return;
        L19:
            ProfileButtonAreaComponent r5 = this.a;
            r5.getClass();
            ArrayList r6 = new ArrayList();
            ProfileFollowButtonView r7 = r5.h;
            if (r7 != null) goto L22;
        L24:
            ProfileFansGroupButtonView r12 = r5.l;
            if (r12 == null) goto L29;
            List<Animator> r13 = r12.k(r10);
            if (r13 == null) goto L29;
            r6.addAll(r13);
        L29:
            ArrayList r14 = new ArrayList();
            ProfileFollowButtonView r15 = r5.h;
            if (r15 == null) goto L34;
            List<Animator> r16 = r15.getSecondFollowAnimatotsWithFansGroup();
            if (r16 == null) goto L34;
            r14.addAll(r16);
        L34:
            ProfileFansGroupButtonView r17 = r5.l;
            if (r17 == null) goto L39;
            List<Animator> r18 = r17.getSecondFollowAnimatotsWithFansGroup();
            if (r18 == null) goto L39;
            r14.addAll(r18);
        L39:
            AnimatorSet r19 = new AnimatorSet();
            r19.playTogether(r6);
            AnimatorSet r20 = new AnimatorSet();
            r20.playTogether(r14);
            r20.setStartDelay(505);
            AnimatorSet r22 = new AnimatorSet();
            r22.playSequentially(new Animator[]{r19, r20});
            r22.start();
            ProfileButtonAreaComponent.o(this.a);
            return;
        L22:
            if (r7.getFirstFollowAnimatorsWithFansGroup() == null) goto L24;
            r6.addAll(r6);
            goto L24
        L40:
            ProfileFollowButtonView r23 = this.a.h;
            if (r23 == null) goto L44;
            r23.l(r10);
        L44:
            if (r3 == false) goto L65;
            ProfileFansGroupButtonView r24 = this.a.l;
            if (r24 == null) goto L48;
            r24.l(true, r10);
        L48:
            ProfileButtonAreaComponent r25 = this.a;
            r25.getClass();
            ArrayList r26 = new ArrayList();
            ProfileFollowButtonView r27 = r25.h;
            if (r27 == null) goto L53;
            List<Animator> r28 = r27.getFollowAnimatorSet();
            if (r28 == null) goto L53;
            r26.addAll(r28);
        L53:
            ProfileFansGroupButtonView r29 = r25.l;
            if (r29 == null) goto L59;
            List<Animator> r30 = r29.getFollowAnimatorSet();
            if (r30 == null) goto L59;
            r26.addAll(r30);
        L59:
            if (r25.l == null) goto L61;
            ValueAnimator r1 = ValueAnimator.ofInt(new int[]{((Number) r25.j.getValue()).intValue(), ((Number) r25.k.getValue()).intValue()});
            r1.addUpdateListener(new com.bytedance.android.live.profile.ui.component.b(r25));
            r1.setDuration(300);
            r26.add(r1);
        L61:
            AnimatorSet r2 = new AnimatorSet();
            r25.g = r2;
            r2.playTogether(r26);
            AnimatorSet r32 = r25.g;
            if (r32 == null) goto L64;
            r32.start();
        L64:
            ProfileButtonAreaComponent.o(this.a);
            return;
        L65:
            ProfileFansGroupButtonView r33 = this.a.l;
            if (r33 == null) goto L68;
            r33.l(false, r10);
        L68:
            ProfileButtonAreaComponent r34 = this.a;
            r34.getClass();
            ArrayList r35 = new ArrayList();
            ProfileFollowButtonView r36 = r34.h;
            if (r36 == null) goto L73;
            List<Animator> r37 = r36.getCancelFollowAnimatorSet();
            if (r37 == null) goto L73;
            r35.addAll(r37);
        L73:
            ProfileFansGroupButtonView r38 = r34.l;
            if (r38 == null) goto L79;
            List<Animator> r39 = r38.getCancelFollowAnimatorSet();
            if (r39 == null) goto L79;
            r35.addAll(r39);
        L79:
            if (r34.l == null) goto L81;
            ValueAnimator r40 = ValueAnimator.ofInt(new int[]{((Number) r34.k.getValue()).intValue(), ((Number) r34.j.getValue()).intValue()});
            r40.addUpdateListener(new com.bytedance.android.live.profile.ui.component.a(r34));
            r40.setDuration(300);
            r35.add(r40);
        L81:
            AnimatorSet r42 = new AnimatorSet();
            r34.g = r42;
            r42.playTogether(r35);
            AnimatorSet r43 = r34.g;
            if (r43 == null) goto L90;
            r43.start();
            return;
        L90:
            return;
        L9:
            r3 = true;
            goto L11
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ProfileButtonAreaComponent a;

        public b(ProfileButtonAreaComponent r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            if (this.a.q() == true) goto L5;
        L10:
            this.a.p().attention(this.a.r.getHostFragment().getContext());
            this.a.r.b().recordBusinessClick("follow", null);
            return;
        L5:
            if (this.a.r.b().getTargetUser().isFollowing() == false) goto L10;
            FragmentActivity r4 = this.a.r.getHostFragment().getActivity();
            if (r4 == null) goto L9;
            this.a.p().showFansGroupDialog(r4);
        L9:
            this.a.r.b().recordBusinessClick("fans_group", null);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ProfileButtonAreaComponent a;

        public c(ProfileButtonAreaComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            ProfileButtonView r0 = this.a.m;
            if (r0 != null) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L7;
            int r5 = 2131919733;
        L8:
            r0.setTextResId(r5);
            return;
        L7:
            r5 = 2131919770;
            goto L8
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ ProfileButtonAreaComponent a;

        public d(ProfileButtonAreaComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            ProfileButtonAreaComponent r0 = this.a;
            r0.r((Integer) r2);
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ ProfileButtonAreaComponent a;

        public e(ProfileButtonAreaComponent r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            this.a.r.b().recordBusinessClick("secondary_follow", null);
            this.a.p().attention(this.a.r.getHostFragment().getContext());
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ ProfileButtonAreaComponent a;

        public f(ProfileButtonAreaComponent r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            if (this.a.q() == true) goto L5;
        L7:
            this.a.r.b().recordBusinessClick("fans_group", null);
            FragmentActivity r4 = this.a.r.getHostFragment().getActivity();
            if (r4 == null) goto L12;
            this.a.p().showFansGroupDialog(r4);
            return;
        L12:
            return;
        L5:
            if (this.a.r.b().getTargetUser().isFollowing() == false) goto L7;
            this.a.r.b().recordBusinessClick("follow", null);
            this.a.p().attention(this.a.r.getHostFragment().getContext());
        }
    }

    public final com.bytedance.android.live.profile.a p() {
        return (com.bytedance.android.live.profile.a) this.o.getValue();
    }

    public final boolean q() {
        return ((Boolean) this.p.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.BasicButtonArea.INSTANCE;
    }

    public static final void o(ProfileButtonAreaComponent r6) {
        NewLiveProfileDialogFragment r7 = r6.r.getHostFragment();
        if ((r7 instanceof NewLiveProfileDialogFragment) == false) goto L22;
        NewLiveProfileDialogFragment r8 = r7;
        BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra> r0 = r8.k;
        if (r0 == null) goto L23;
        Appointment r1 = r8.T90().getTargetUser().appointment;
        if (r1 == null) goto L9;
        Long r2 = Long.valueOf(r1.PushStates);
    L10:
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.longValue() != 0) goto L25;
        Appointment r3 = ((UserProfileDataResp) r0.data).profileUser.appointment;
        if (r3 == null) goto L16;
        r3.PushStates = r8.p;
    L16:
        NewProfileUser r4 = r8.T90().getPreTargetUser();
        if (r4 == null) goto L26;
        Appointment r5 = r4.appointment;
        if (r5 == null) goto L27;
        r5.PushStates = r8.p;
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L9:
        r2 = null;
        goto L10
    L23:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler, com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r7) {
        Intrinsics.checkNotNullParameter(r7, "user");
        Intrinsics.checkNotNullParameter(r7, "user");
        Intrinsics.checkNotNullParameter(r7, "user");
        Iterator r0 = ((ArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L30;
        com.bytedance.android.live.profile.ui.component.base.c r1 = (com.bytedance.android.live.profile.ui.component.base.c) r0.next();
        com.bytedance.android.live.profile.ui.component.base.e<T> r2 = r1.d;
        if (r2 == 0) goto L9;
        r2.a(r1.c, r7, this.e.a().getLogUseCaseForUi());
    L9:
        if (r1.d == null) goto L4;
        String r3 = st0.c.a((st0.b) r1.c);
        if (r3 == null) goto L4;
        if (q() == false) goto L27;
        if (r1.getType() == 0) goto L19;
        if (r1.getType() != 1) goto L27;
    L19:
        if (r7.isFollowing() == false) goto L20;
        int r4 = r1.getType();
        if (r4 != 0) goto L23;
        this.r.b().recordBusinessShow(TrackArea.BasicAreaArea, "fans_group");
        goto L4
    L23:
        if (r4 != 1) goto L4;
        this.r.b().recordBusinessShow(TrackArea.BasicAreaArea, "follow");
        goto L4
    L20:
        this.r.b().recordBusinessShow(TrackArea.BasicAreaArea, r3);
    L27:
        this.r.b().recordBusinessShow(TrackArea.BasicAreaArea, r3);
        if (r1.getType() != 15) goto L4;
        this.r.b().getLogUseCase().getClass();
        j0.l().h("show_create_public_group_entry", MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_method", "profile_card"), TuplesKt.to("enter_from", "live_room")}), new Object[0]);
        goto L4
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler, com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Intrinsics.checkNotNullParameter(r4, "user");
        a(r4);
        if (this.h == null) goto L7;
        p().getFollowInfoLiveData().observe(this.r.getHostFragment(), new a(this));
        ProfileFollowButtonView r0 = this.h;
        if (r0 == null) goto L7;
        r0.setOnClickListener(new b(this));
    L7:
        ProfileFansGroupButtonView r1 = this.l;
        if (r1 == null) goto L11;
        r1.setOnClickListener(new f(this));
    L11:
        if (this.m == null) goto L16;
        if (this.r.c() != 1) goto L16;
        p().getAnonymousSilentLiveData().observe(this.r.getHostFragment(), new c(this));
    L16:
        if (this.n == null) goto L21;
        r(Integer.valueOf((int) r4.followInfo.getFollowStatus()));
        p().getFollowInfoLiveData().observe(this.r.getHostFragment(), new d(this));
        ProfileButtonView r5 = this.n;
        if (r5 == null) goto L22;
        r5.setOnClickListener(new e(this));
        return;
    L22:
        return;
    }

    public final void r(Integer r6) {
        int r1 = 2131251369;
        int r2 = -1;
        if (r6 != null) goto L6;
    L17:
        if (r6 != null) goto L20;
    L31:
        if (r6 != null) goto L34;
    L49:
        if (r6 != null) goto L52;
        return;
    L52:
        if (r6.intValue() != 3) goto L70;
        ProfileButtonView r7 = this.n;
        if (r7 == null) goto L56;
        r7.setText(s1.B(2131919554));
    L56:
        ProfileButtonView r8 = this.n;
        if (r8 != null) goto L59;
        return;
    L59:
        if (this.r.isVertical() == true) goto L62;
        r1 = -1;
    L62:
        Integer r3 = Integer.valueOf(r1);
        int r4 = ProfileButtonView.e;
        r8.j(r3, null);
        return;
    L70:
        return;
    L34:
        if (r6.intValue() != 2) goto L49;
        if (p().showJumpLinkAnchorButton() == false) goto L38;
        int r9 = 2131919556;
    L40:
        if (p().showJumpLinkAnchorButton() == true) goto L43;
        r2 = 2131251363;
    L43:
        ProfileButtonView r5 = this.n;
        if (r5 == null) goto L46;
        r5.setText(s1.B(r9));
    L46:
        ProfileButtonView r10 = this.n;
        if (r10 == null) goto L68;
        Integer r12 = Integer.valueOf(r2);
        int r13 = ProfileButtonView.e;
        r10.j(r12, null);
        return;
    L68:
        return;
    L38:
        r9 = 2131919555;
        goto L40
    L20:
        if (r6.intValue() != 1) goto L31;
        if (p().showJumpLinkAnchorButton() == false) goto L24;
        int r14 = 2131919558;
    L25:
        ProfileButtonView r15 = this.n;
        if (r15 == null) goto L28;
        r15.setText(s1.B(r14));
    L28:
        ProfileButtonView r16 = this.n;
        if (r16 == null) goto L66;
        int r17 = ProfileButtonView.e;
        r16.j(-1, null);
        return;
    L66:
        return;
    L24:
        r14 = 2131919557;
        goto L25
    L6:
        if (r6.intValue() != 0) goto L17;
        ProfileButtonView r18 = this.n;
        if (r18 == null) goto L10;
        r18.setText(s1.B(2131919553));
    L10:
        ProfileButtonView r19 = this.n;
        if (r19 != null) goto L13;
        return;
    L13:
        if (this.r.isVertical() == true) goto L16;
        r1 = -1;
    L16:
        Integer r20 = Integer.valueOf(r1);
        int r22 = ProfileButtonView.e;
        r19.j(r20, null);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r7) {
        Intrinsics.checkNotNullParameter(r7, "newUser");
        ALogger.i("NewUserProfile_ProfilePre", "ProfileButtonAreaComponent update");
        com.bytedance.android.live.profile.profilecontext.a r1 = this.r.b();
        Long r2 = null;
        if (r1 == null) goto L5;
        NewProfileUser r3 = r1.getPreTargetUser();
    L6:
        StringBuilder r4 = new StringBuilder("before user follow status: ");
        if (r3 == null) goto L11;
        c0 r5 = r3.followInfo;
        if (r5 == null) goto L11;
        Long r6 = Long.valueOf(r5.getFollowStatus());
    L12:
        r4.append(r6);
        r4.append(", isFollowing: ");
        if (r3 == null) goto L15;
        Boolean r8 = Boolean.valueOf(r3.isFollowing());
    L16:
        r4.append(r8);
        ALogger.i("NewUserProfile_ProfilePre", r4.toString());
        StringBuilder r9 = new StringBuilder("current user follow status: ");
        c0 r10 = r7.followInfo;
        if (r10 == null) goto L19;
        r2 = Long.valueOf(r10.getFollowStatus());
    L19:
        r9.append(r2);
        r9.append(", isFollowing: ");
        r9.append(r7.isFollowing());
        ALogger.i("NewUserProfile_ProfilePre", r9.toString());
        c0 r12 = r7.followInfo;
        if (r12 != null) goto L22;
    L23:
        ALogger.e("NewUserProfile_ProfilePre", "new user follow info is error");
    L24:
        Iterator r0 = ((ArrayList) this.d).iterator();
    L26:
        if (r0.hasNext() == false) goto L35;
        com.bytedance.android.live.profile.ui.component.base.c r13 = (com.bytedance.android.live.profile.ui.component.base.c) r0.next();
        com.bytedance.android.live.profile.ui.component.base.e<T> r14 = r13.d;
        if (r14 == 0) goto L31;
        r14.update(r13.c, r7);
    L31:
        if (r13.getType() != 7) goto L26;
        c0 r15 = r7.followInfo;
        if (r15 == null) goto L26;
        r(Integer.valueOf((int) r15.getFollowStatus()));
        goto L26
    L35:
        return;
    L22:
        if (r12.getInvalidFollowStatus() != true) goto L24;
    L15:
        r8 = null;
    L11:
        r6 = null;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    public ProfileButtonAreaComponent(com.bytedance.android.live.profile.ui.base.l r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "hostBehavior");
        Intrinsics.checkNotNullParameter(r3, "container");
        super(r2, r3);
        this.r = r2;
        this.i = LazyKt.lazy(new ProfileButtonAreaComponent$fansGroupExtraSpace$2(this));
        this.j = LazyKt.lazy(new ProfileButtonAreaComponent$expandFollowWidth$2(this));
        this.k = LazyKt.lazy(new ProfileButtonAreaComponent$foldFollowWidth$2(this));
        this.o = LazyKt.lazy(new ProfileButtonAreaComponent$mUserInfoViewModel$2(this));
        this.p = LazyKt.lazy(new ProfileButtonAreaComponent$isFansGroupEnhance$2(this));
        this.q = LazyKt.lazy(ProfileButtonAreaComponent$isFansGroupTextOpt$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler
    public final View k(com.bytedance.android.live.profile.ui.component.base.b r4, NewProfileUser r5) {
        st0.b r6 = (st0.b) r4;
        Intrinsics.checkNotNullParameter(r6, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r5, "user");
        int r7 = r6.getType();
        if (r7 != 0) goto L5;
        ProfileFollowButtonView r8 = new ProfileFollowButtonView(this.f.getContext(), null, 6, 0);
        r8.setFansGroupEnhance(q());
        r8.setFansGroupTextOpt(((Boolean) this.q.getValue()).booleanValue());
        Unit r9 = Unit.INSTANCE;
        this.h = r8;
        Intrinsics.checkNotNull(r8);
        return r8;
    L5:
        if (r7 != 1) goto L7;
        ProfileFansGroupButtonView r10 = new ProfileFansGroupButtonView(this.f.getContext(), null, 6, 0);
        r10.setFansGroupEnhance(q());
        r10.setFansGroupTextOpt(((Boolean) this.q.getValue()).booleanValue());
        Unit r12 = Unit.INSTANCE;
        this.l = r10;
        Intrinsics.checkNotNull(r10);
        return r10;
    L7:
        if (r7 == 5) goto L23;
        if (r7 == 6) goto L32;
        if (r7 != 7) goto L12;
        ProfileButtonView r13 = new ProfileButtonView(this.f.getContext(), null, 6, 0);
        this.n = r13;
        return r13;
    L12:
        if (r7 == 10) goto L30;
        if (r7 != 11) goto L16;
        this.r.a().logOwnerCenterShow();
        return new ProfileOwnerCenterButtonView(this.f.getContext(), null, 6, 0);
    L16:
        if (r7 == 17) goto L28;
        return new ProfileButtonView(this.f.getContext(), null, 6, 0);
    L28:
        return new ProfileSquareJumpTaRoomButtonView(this.f.getContext(), null, 6, 0);
    L30:
        return new ProfileAnchorSetButtonView(this.f.getContext(), null, 6, 0);
    L32:
        return new ProfileJumpToOtherRoomButtonView(this.f.getContext(), null, 6, 0);
    L23:
        ProfileButtonView r14 = new ProfileButtonView(this.f.getContext(), null, 6, 0);
        this.m = r14;
        return r14;
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler
    public final ViewGroup.LayoutParams l(int r4, com.bytedance.android.live.profile.ui.component.base.b r5) {
        st0.b r6 = (st0.b) r5;
        Intrinsics.checkNotNullParameter(r6, Constants.Keys.DATA);
        if (r4 == 0) goto L7;
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(r6.c, -1);
        r7.leftMargin = UtilityKotlinExtentionsKt.i(6);
        if (r6.c != 0) goto L9;
        r7.weight = 1.0f;
    L9:
        if (r6.getType() != 14) goto L18;
        ns0.b.Companion.getClass();
        ns0.b r8 = ns0.b.access$getImpl$cp();
        if (r8 != null) goto L17;
        r8 = (ns0.b) jc1.k.f(ns0.b.class);
        if (r8 != null) goto L16;
        r8 = new ns0.b();
    L16:
        ns0.b.access$setImpl$cp(r8);
    L17:
        r8.modifyLayoutParamsIfIMButton(r7);
    L18:
        return r7;
    L7:
        r7 = new LinearLayout.LayoutParams(0, -1);
        r7.weight = 1.0f;
        r7.gravity = 17;
        goto L9
    }
}
