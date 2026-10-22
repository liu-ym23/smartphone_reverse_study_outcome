package com.bytedance.android.livesdk.interactivity.medialink.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.base.model.user.q0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkMicIdInfo;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.interactivity.medialink.intercomment.MediaInteractCommentDataContext;
import com.bytedance.android.livesdk.interactivity.medialink.intercomment.MediaInteractCommentView;
import com.bytedance.android.livesdk.interactivity.medialink.ui.layout.MediaMultiAnchorGuestInfoCleanScreenLayout;
import com.bytedance.android.livesdk.interactivity.medialink.ui.layout.MediaMultiAnchorGuestInfoLayout;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.UILayout;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.WindowLayoutType;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class MediaMultiAnchorWindowV2 extends FrameLayout implements n, com.bytedance.android.livesdk.interactivity.medialink.ui.a {
    public static final /* synthetic */ int I = 0;
    public final p A;
    public final q B;
    public final MediaMultiAnchorGuestInfoLayout C;
    public final MediaMultiAnchorGuestInfoCleanScreenLayout D;
    public final p E;
    public final p F;
    public WindowLayoutType G;
    public final h H;
    public View a;
    public AnchorLinkUser b;
    public final String c;
    public Disposable d;
    public CompositeDisposable e;
    public boolean f;
    public final DataCenter g;
    public final MediaMultiAnchorPauseTipsView h;
    public final View i;
    public final HSImageView j;
    public final LinearLayout k;
    public final FrameLayout l;
    public final LinearLayout m;
    public final LinearLayout n;
    public final View o;
    public boolean p;
    public boolean q;
    public int r;
    public SeiRegion s;
    public Integer t;
    public final Room u;
    public final com.bytedance.android.livesdk.interactivity.medialink.ui.window.l v;
    public int w;
    public final LinearLayout x;
    public FrameLayout y;
    public MediaInteractCommentView z;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ MediaMultiAnchorWindowV2 a;
        public final /* synthetic */ DataCenter b;

        public a(MediaMultiAnchorWindowV2 r1, DataCenter r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            AnchorLinkUser r11 = this.a.getAnchorLinkUser();
            if (r11 == null) goto L7;
            User r13 = r11.getMUser();
            if (r13 == null) goto L7;
            String r14 = r13.getIdStr();
        L8:
            o0.a r1 = o0.a;
            String r2 = ey.c.b();
            r1.getClass();
            boolean r3 = o0.a.a(r14, r2);
            boolean r4 = true;
            String r5 = "0";
            if (r3 == false) goto L16;
            int r6 = e92.d.a;
            if (e92.m.h() != 4) goto L13;
            boolean r7 = true;
        L14:
            if (r7 == false) goto L16;
        L22:
            x82.b.u2.getClass();
            x82.b r0 = x82.b.a.a();
            if (r0 == null) goto L50;
            if (r14 != null) goto L26;
            r14 = "0";
        L26:
            String r8 = this.a.getInteractId();
            if (r8 != null) goto L29;
            r8 = BuildConfig.FLAVOR;
        L29:
            r0.ik(r14, r8, this.a.r);
            return;
        L50:
            return;
        L13:
            r7 = false;
        L16:
            if (o0.a.a(r14, ey.c.b()) == true) goto L31;
            int r9 = e92.d.a;
            if (e92.m.h() > 2) goto L21;
            r4 = false;
        L21:
            if (r4 == true) goto L22;
        L31:
            MediaMultiAnchorWindowV2 r15 = this.a;
            DataCenter r16 = this.b;
            AnchorLinkUser r17 = r15.b;
            if (r17 == null) goto L51;
            RoomContext r18 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r18 == null) goto L42;
            com.bytedance.live.datacontext.m r19 = r18.getCleanMode();
            if (r19 == null) goto L42;
            if (((Number) r19.getValue()).intValue() != 2) goto L42;
            if (wt2.a.f(Boolean.valueOf(r15.f)) == false) goto L42;
            return;
        L42:
            User r20 = r17.getMUser();
            if (r20 == null) goto L48;
            String r21 = r20.getIdStr();
            if (r21 == null) goto L48;
            r5 = r21;
        L48:
            UserProfileEvent r110 = new UserProfileEvent(r5);
            r110.setClickUserPosition("linked_anchor");
            r110.interactLogLabel = "right_anchor";
            r110.setReportSource("anchor_linkmic");
            r110.setReportType("data_card_linked_anchor");
            r16.put("cmd_show_user_profile", r110);
            return;
        L51:
            return;
        L7:
            r14 = null;
            goto L8
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ MediaMultiAnchorWindowV2 a;

        public b(MediaMultiAnchorWindowV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            if (this.a.getMIsAnchor() == false) goto L19;
            MediaMultiAnchorWindowV2 r11 = this.a;
            boolean r1 = r11.p;
            if (r11.f == false) goto L24;
            x82.b.u2.getClass();
            x82.b r2 = x82.b.a.a();
            if (r2 == null) goto L21;
            m r3 = r2.getMuteManager();
            if (r3 == null) goto L22;
            AnchorLinkUser r13 = r11.b;
            if (r13 == null) goto L17;
            User r14 = r13.getMUser();
            if (r14 == null) goto L17;
            String r15 = r14.getIdStr();
            if (r15 == null) goto L17;
        L18:
            r3.a(r15, null, !r1, r.a.a, false);
            return;
        L17:
            r15 = "0";
            goto L18
        L22:
            return;
        L21:
            return;
        L24:
            return;
        L19:
            f2.c(s1.C(2131920281, new Object[]{this.a.C.getNickName()}), 0);
        }
    }

    public static final class c {
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ MediaMultiAnchorWindowV2 a;
        public final /* synthetic */ ObjectAnimator b;

        public d(MediaMultiAnchorWindowV2 r1, ObjectAnimator r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            if (e92.a.a() == true) goto L7;
            this.a.D.setVisibility(0);
            this.a.D.setAlpha(0.0f);
            this.b.setDuration(320);
            this.b.start();
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ MediaMultiAnchorWindowV2 a;
        public final /* synthetic */ ObjectAnimator b;

        public e(MediaMultiAnchorWindowV2 r1, ObjectAnimator r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            this.a.C.getComponent().j(true);
            this.a.C.setAlpha(0.0f);
            this.b.setDuration(320);
            this.b.start();
        }
    }

    public static final class f extends AnimatorListenerAdapter {
        public final /* synthetic */ MediaMultiAnchorWindowV2 a;
        public final /* synthetic */ boolean b;

        public f(MediaMultiAnchorWindowV2 r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "animation");
            if (this.b == false) goto L6;
            this.a.C.getComponent().j(false);
            return;
        }
    }

    public static final class g extends AnimatorListenerAdapter {
        public final /* synthetic */ MediaMultiAnchorWindowV2 a;
        public final /* synthetic */ boolean b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.b == true) goto L6;
            this.a.D.setVisibility(4);
            return;
        }

        public g(MediaMultiAnchorWindowV2 r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ MediaMultiAnchorWindowV2 a;

        public h(MediaMultiAnchorWindowV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            p r0 = this.a.A;
            if (r0 == null) goto L6;
            r0.j(Intrinsics.areEqual(r4, Boolean.TRUE));
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ MediaMultiAnchorWindowV2 a;

        public i(MediaMultiAnchorWindowV2 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            FollowPair r5 = (FollowPair) r4;
            Intrinsics.checkNotNullParameter(r5, "followPair");
            MediaMultiAnchorWindowV2 r0 = this.a;
            int r6 = r5.followStatus;
            int r1 = MediaMultiAnchorWindowV2.I;
            if (r6 <= 0) goto L5;
            int r2 = 2;
        L6:
            r0.r = r2;
            if (r6 <= 0) goto L9;
            boolean r7 = true;
        L10:
            UtilityKotlinExtentionsKt.z(r0.C.d, !r7);
            return;
        L9:
            r7 = false;
            goto L10
        L5:
            r2 = 1;
            goto L6
        }
    }

    public static final class j<T> implements Consumer {
        public static final j a = null;

        static {
            a = new j();
        }

        public j() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.a
    public View getView() {
        return this;
    }

    public final void setDebugText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
    }

    public static boolean e() {
        MediaInteractCommentDataContext r0 = MediaInteractCommentDataContext.Companion.getContext();
        if (r0 == null) goto L9;
        MutableLiveData<Boolean> r1 = r0.getShowInterCommentIcon();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        return r2.booleanValue();
    L9:
        return false;
    }

    private final int getAnchorInfoMarginTop() {
        return s1.f(4.0f);
    }

    private final String getSelfInteractId() {
        ey.g.a.getClass();
        nc0.b r0 = ey.g.a.a();
        if (r0 == null) goto L9;
        LiveData r1 = r0.c();
        if (r1 == null) goto L9;
        ey.f r2 = (ey.f) r1.getValue();
        if (r2 == null) goto L9;
        return r2.e;
    L9:
        return null;
    }

    public final String g() {
        StringBuilder r0 = new StringBuilder("Window{");
        r0.append(getInteractId());
        r0.append(",");
        AnchorLinkUser r1 = this.b;
        if (r1 == null) goto L5;
        String r2 = r1.toSimpleString();
    L6:
        r0.append(r2);
        if (this.G == WindowLayoutType.Normal) goto L9;
        r0.append(",layoutType=");
        r0.append(this.G);
    L9:
        r0.append("}");
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public final String getBackupLinkMicId() {
        AnchorLinkUser r0 = this.b;
        if (r0 == null) goto L7;
        AnchorLinkMicIdInfo r1 = r0.getAnchorLinkMicIdInfo();
        if (r1 == null) goto L7;
        return r1.backupLinkMicId;
    L7:
        return null;
    }

    public final String getLinkMicId() {
        AnchorLinkUser r0 = this.b;
        if (r0 == null) goto L10;
        AnchorLinkMicIdInfo r1 = r0.getAnchorLinkMicIdInfo();
        if (r1 == null) goto L10;
        if (r1.useBackupStream != true) goto L10;
        return getBackupLinkMicId();
    L10:
        return this.c;
    }

    public final String getUid() {
        AnchorLinkUser r0 = this.b;
        if (r0 == null) goto L7;
        User r1 = r0.getMUser();
        if (r1 == null) goto L7;
        return r1.getIdStr();
    L7:
        return null;
    }

    public final boolean j() {
        AnchorLinkUser r0 = this.b;
        String r1 = null;
        if (r0 == null) goto L5;
        IBaseUser r2 = r0.getUser();
    L7:
        if (r2 == null) goto L9;
    L22:
        AnchorLinkUser r3 = this.b;
        if (r3 == null) goto L28;
        User r4 = r3.getMUser();
        if (r4 == null) goto L28;
        r1 = r4.getIdStr();
    L28:
        if (Intrinsics.areEqual(r1, this.u.getOwnerUserIdString()) == true) goto L30;
        return false;
    L30:
        if (q0.a(this.u.getOwnerUserIdString()) == false) goto L36;
        return true;
    L36:
        return false;
    L9:
        if (this.f == false) goto L22;
        String r5 = this.c;
        if (r5 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == false) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.c, getSelfInteractId()) == false) goto L34;
        return true;
    L34:
        return false;
    L13:
        if (r5.length() == 0) goto L16;
        r6 = false;
        goto L17
    L5:
        r2 = null;
        goto L7
    }

    public final void k() {
        m(this, this.C, 16.0f, true, 14);
        if (i() == false) goto L16;
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == true) goto L8;
        r0 = null;
    L8:
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        if (r1 == null) goto L16;
        int r2 = r1.height + r1.topMargin;
        int r3 = s1.w() - r2;
        if (r3 >= s1.f(64.0f)) goto L13;
        int r4 = s1.f(64.0f) - r3;
    L14:
        UIUtils.updateLayoutMargin(this.l, -3, -3, -3, r4);
        UIUtils.updateLayoutMargin(this.l, 0, getAnchorInfoMarginTop(), 0, r4);
        goto L16
    L13:
        r4 = getAnchorInfoMarginBottom();
    L16:
        if (i() == false) goto L20;
        UIUtils.updateLayoutMargin(this.n, -3, getTopConflictHeightForPad(), -3, -3);
        return;
    }

    private final int getAnchorInfoMarginBottom() {
        if (i() == false) goto L7;
        return s1.f(16.0f);
    L7:
        if (e92.m.a() != UILayout.Enlarge) goto L11;
        return s1.f(3.0f);
    L11:
        return s1.f(5.0f);
    }

    private final int getTopConflictHeightForPad() {
        if (i() == false) goto L5;
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == true) goto L9;
        r0 = null;
    L9:
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        if (r1 == null) goto L19;
        int r2 = r1.topMargin;
        if (this.q == true) goto L17;
        if (r2 >= this.v.l()) goto L17;
        return this.v.l();
    L17:
        return s1.f(16.0f);
    L19:
        return s1.f(16.0f);
    L5:
        return s1.f(16.0f);
    }

    public final boolean i() {
        if (PadConfigUtils.c() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f == true) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        x82.b.u2.getClass();
        x82.b r0 = x82.b.a.a();
        if (r0 == null) goto L7;
        m r1 = r0.getMuteManager();
        if (r1 == null) goto L7;
        r1.b(this);
    L7:
        ((LinkedHashMap) this.B.a).clear();
        this.B.c(this.C.getComponent());
        this.B.c(this.F);
        this.B.c(this.E);
        this.B.c(this.A);
        q r2 = this.B;
        UILayout r3 = e92.m.a();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "uiLayout");
        if (r2.f == r3) goto L11;
        r2.f = r3;
        r2.b();
    L11:
        this.B.b();
        MediaInteractCommentDataContext r4 = MediaInteractCommentDataContext.Companion.getContext();
        if (r4 == null) goto L16;
        MutableLiveData<Boolean> r5 = r4.getShowInterCommentIcon();
        if (r5 == null) goto L16;
        r5.observeForever(this.H);
    L16:
        this.C.setUILayout(e92.m.a());
        AnchorLinkUser r6 = this.b;
        if (r6 == null) goto L31;
        User r7 = r6.getMUser();
        if (r7 == null) goto L26;
        String r8 = r7.getIdStr();
        if (r8 == null) goto L26;
        if (this.r != 0) goto L26;
        o(r8);
    L26:
        User r9 = r6.getMUser();
        if (r9 == null) goto L30;
        l(r9);
        return;
    L30:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x82.b.u2.getClass();
        x82.b r0 = x82.b.a.a();
        if (r0 == null) goto L7;
        m r1 = r0.getMuteManager();
        if (r1 == null) goto L7;
        r1.f(this);
    L7:
        MediaInteractCommentDataContext r2 = MediaInteractCommentDataContext.Companion.getContext();
        if (r2 == null) goto L12;
        MutableLiveData<Boolean> r3 = r2.getShowInterCommentIcon();
        if (r3 == null) goto L12;
        r3.removeObserver(this.H);
    L12:
        Disposable r4 = this.d;
        if (r4 != null) goto L15;
    L17:
        this.e.clear();
        ((LinkedHashMap) this.B.a).clear();
        return;
    L15:
        if (r4.isDisposed() == true) goto L17;
        r4.dispose();
        goto L17
    }

    public final AnchorLinkUser getAnchorLinkUser() {
        return this.b;
    }

    public final CompositeDisposable getCompositeDisposable() {
        return this.e;
    }

    public final FrameLayout getInterCommentContainer() {
        return this.y;
    }

    public final MediaInteractCommentView getInterCommentView() {
        return this.z;
    }

    public final String getInteractId() {
        return this.c;
    }

    public final Disposable getMDisposable() {
        return this.d;
    }

    public final boolean getMIsAnchor() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.a
    public Integer getMPosition() {
        return this.t;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.a
    public SeiRegion getMSeiRegion() {
        return this.s;
    }

    public static final /* synthetic */ int c(MediaMultiAnchorWindowV2 r0) {
        return r0.getAnchorInfoMarginBottom();
    }

    private final void setFollowStatus(final User r4) {
        int r1 = 1;
        int r2 = 2;
        if (r4.isVcdContentAuthorized() == false) goto L12;
        if (r4.isVcdRelationAuthorized() == false) goto L12;
        if (r4.isFollowing() == true) goto L10;
        r2 = 1;
    L10:
        this.r = r2;
        boolean r0 = r4.isFollowing();
        UtilityKotlinExtentionsKt.z(this.C.d, !r0);
        MediaMultiAnchorGuestInfoLayout r3 = this.C;
        Function0<Unit> r5 = new AnonymousClass1(this, r4);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "onClick");
        r3.d.setOnClickListener(new y82.i(r5));
        l(r4);
        return;
    L12:
        if (r4.isFollowing() == false) goto L14;
        r1 = 2;
    L14:
        this.r = r1;
        UtilityKotlinExtentionsKt.z(this.C.d, false);
    }

    public final void f(boolean r10) {
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this.C, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.D, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.C, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.D, "alpha", new float[]{1.0f, 0.0f});
        if (r10 == false) goto L5;
        r4.setDuration(360);
        r4.start();
        Disposable r3 = Observable.timer(40, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r2));
        this.e.add(r3);
    L6:
        r4.addListener(new f(this, r10));
        r1.addListener(new g(this, r10));
        return;
    L5:
        r1.setDuration(360);
        r1.start();
        Disposable r5 = Observable.timer(40, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r0));
        this.e.add(r5);
        goto L6
    }

    public final void l(User r3) {
        RxUtilKt.c(jc1.k.n(IUserService.class).user().u0(r3.getIdStr()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(this), j.a), this.e);
    }

    public final void o(String r3) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        Disposable r4 = jc1.k.n(IUserService.class).user().r(r3).map(com.bytedance.android.livesdk.interactivity.medialink.ui.h.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.interactivity.medialink.ui.i(this), com.bytedance.android.livesdk.interactivity.medialink.ui.j.a);
        this.e.add(r4);
    }

    public final void p(boolean r3) {
        this.p = r3;
        MediaMultiAnchorGuestInfoLayout r0 = this.C;
        if (r0.j == r3) goto L6;
        r0.j = r3;
        r0.a();
    L6:
        p r1 = this.F;
        if (r1 == null) goto L14;
        if (r3 == true) goto L10;
    L12:
        boolean r2 = false;
    L13:
        r1.j(r2);
        goto L14
    L10:
        if (i() == true) goto L12;
        r2 = true;
    L14:
        HSImageView r4 = this.j;
        if (r3 == false) goto L17;
        int r5 = 2131252596;
    L18:
        r4.setImageResource(r5);
        return;
    L17:
        r5 = 2131252598;
        goto L18
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void q(int r5) {
        Room r0 = jc1.k.n(IRoomService.class).getCurrentRoom();
        if (r5 != 2) goto L5;
    L18:
        this.h.setPadding(UtilityKotlinExtentionsKt.i(16), UtilityKotlinExtentionsKt.i(56), UtilityKotlinExtentionsKt.i(16), UtilityKotlinExtentionsKt.i(72));
        return;
    L5:
        if (r5 >= 4) goto L17;
        AnchorLinkUser r6 = this.b;
        String r1 = null;
        if (r6 == null) goto L11;
        User r7 = r6.getMUser();
        if (r7 == null) goto L11;
        String r8 = r7.getIdStr();
    L12:
        if (r0 == null) goto L15;
        r1 = r0.getOwnerUserIdString();
    L15:
        if (Intrinsics.areEqual(r8, r1) == false) goto L17;
    L11:
        r8 = null;
    L17:
        this.h.setPadding(UtilityKotlinExtentionsKt.i(16), UtilityKotlinExtentionsKt.i(13), UtilityKotlinExtentionsKt.i(16), UtilityKotlinExtentionsKt.i(32));
    }

    public final void s(AnchorLinkUser r8) {
        q r0 = this.B;
        if (r8 == null) goto L5;
        boolean r3 = true;
    L7:
        if (r0.e == r3) goto L10;
        r0.e = r3;
        r0.b();
    L10:
        this.b = jm2.a.d(r8);
        if (r8 != null) goto L13;
        return;
    L13:
        Room r1 = jc1.k.n(IRoomService.class).getCurrentRoom();
        IBaseUser r4 = r8.getUser();
        String r5 = null;
        if (r4 == null) goto L16;
        String r6 = r4.getIdString();
    L17:
        if (r1 == null) goto L19;
        String r7 = r1.getOwnerUserIdString();
    L21:
        if (Intrinsics.areEqual(r6, r7) == false) goto L23;
        setClickable(false);
    L51:
        MediaMultiAnchorGuestInfoLayout r2 = this.C;
        TextView r9 = r2.c;
        IBaseUser r10 = r8.getUser();
        if (r10 == null) goto L54;
        String r11 = r10.getRealNickName();
    L55:
        r9.setText(r11);
        HSImageView r13 = r2.a;
        IBaseUser r14 = r8.getUser();
        if (r14 == null) goto L58;
        py.k r15 = r14.getAvatarThumbKt();
    L59:
        a1.v(r13, r15, 2131250965);
        MediaMultiAnchorGuestInfoCleanScreenLayout r16 = this.D;
        TextView r17 = r16.b;
        IBaseUser r18 = r8.getUser();
        if (r18 == null) goto L62;
        String r19 = r18.getRealNickName();
    L63:
        r17.setText(r19);
        HSImageView r20 = r16.a;
        IBaseUser r21 = r8.getUser();
        if (r21 == null) goto L66;
        py.k r23 = r21.getAvatarThumbKt();
    L67:
        a1.v(r20, r23, 2131250965);
        q r24 = this.B;
        IBaseUser r25 = r8.getUser();
        if (r25 == null) goto L70;
        String r26 = r25.getIdString();
    L71:
        if (r1 == null) goto L73;
        r5 = r1.getOwnerUserIdString();
    L73:
        boolean r27 = Intrinsics.areEqual(r26, r5);
        if (r24.b == r27) goto L77;
        r24.b = r27;
        r24.b();
    L77:
        q r28 = this.B;
        boolean r29 = e92.a.a();
        if (r28.c == r29) goto L82;
        r28.c = r29;
        r28.b();
    L82:
        if (i() == false) goto L88;
        m(this, this.y, 16.0f, false, 30);
        if (j() == true) goto L94;
        com.bytedance.android.livesdk.interactivity.medialink.intercomment.b r30 = MediaInteractCommentDataContext.Companion.a();
        if (r30 == null) goto L95;
        r30.ao();
        return;
    L95:
        return;
    L94:
        return;
    L88:
        h(this.x, this.y, 0.0f, 6.0f, 1.0f, 0.0f, true);
        if (j() == true) goto L97;
        com.bytedance.android.livesdk.interactivity.medialink.intercomment.b r31 = MediaInteractCommentDataContext.Companion.a();
        if (r31 == null) goto L98;
        r31.ao();
        return;
    L98:
        return;
    L97:
        return;
    L70:
        r26 = null;
        goto L71
    L66:
        r23 = null;
        goto L67
    L62:
        r19 = null;
        goto L63
    L58:
        r15 = null;
        goto L59
    L54:
        r11 = null;
        goto L55
    L23:
        setClickable(true);
        Boolean r33 = (Boolean) this.g.get("DATA_IS_HIDE_INTERACTION", Boolean.FALSE);
        if (r33 == null) goto L26;
        boolean r34 = r33.booleanValue();
    L27:
        if (r34 == true) goto L29;
    L31:
        boolean r35 = false;
    L33:
        if (r35 == false) goto L35;
        this.D.setVisibility(0);
    L37:
        if (e92.a.a() == false) goto L39;
        this.D.setVisibility(4);
    L39:
        IBaseUser r36 = r8.getUser();
        if (r36 == null) goto L51;
        String r37 = r36.getIdString();
        if (r37 == null) goto L51;
        int r38 = this.r;
        if (r38 != 0) goto L47;
        o(r37);
        goto L51
    L47:
        if (r38 != 2) goto L49;
        boolean r39 = true;
    L50:
        UtilityKotlinExtentionsKt.z(this.C.d, true ^ r39);
        goto L51
    L49:
        r39 = false;
        goto L50
    L35:
        this.D.setVisibility(4);
        goto L37
    L29:
        if (wt2.a.f(Boolean.valueOf(this.f)) == false) goto L31;
        r35 = true;
        goto L33
    L26:
        r34 = false;
        goto L27
    L19:
        r7 = null;
        goto L21
    L16:
        r6 = null;
        goto L17
    L5:
        r3 = false;
        goto L7
    }

    public final void setAnchorLinkUser(AnchorLinkUser r1) {
        this.b = r1;
    }

    public final void setCompositeDisposable(CompositeDisposable r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public final void setCoverVisible(int r2) {
        this.i.setVisibility(r2);
    }

    public final void setInterCommentContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.y = r2;
    }

    public final void setInterCommentView(MediaInteractCommentView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.z = r2;
    }

    public final void setMDisposable(Disposable r1) {
        this.d = r1;
    }

    public final void setMIsAnchor(boolean r1) {
        this.f = r1;
    }

    public void setMPosition(Integer r1) {
        this.t = r1;
    }

    public void setMSeiRegion(SeiRegion r1) {
        this.s = r1;
    }

    public final void setTotalWindowCount(int r3) {
        q r0 = this.B;
        if (r0.d == r3) goto L6;
        r0.d = r3;
        r0.b();
    L6:
        this.C.setWindowCount(r3);
        this.D.setWindowCount(r3);
    }

    public final void setWindowLayoutType(WindowLayoutType r4) {
        Intrinsics.checkNotNullParameter(r4, "layoutType");
        if (this.G != r4) goto L5;
        return;
    L5:
        this.G = r4;
        q r0 = this.B;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "type");
        if (r0.g == r4) goto L9;
        r0.g = r4;
        r0.b();
    L9:
        this.h.setWindowLayoutType(r4);
        if (i() == false) goto L12;
        k();
        return;
    L12:
        WindowLayoutType r5 = this.G;
        Intrinsics.checkNotNullParameter(r5, "$this$isEnlarge");
        if (r5 != WindowLayoutType.EnlargeSmall) goto L15;
    L18:
        boolean r6 = true;
    L19:
        if (r6 == true) goto L21;
        n(this, this.C, 8.0f);
    L25:
        UIUtils.updateLayoutMargin(this.l, 0, getAnchorInfoMarginTop(), 0, getAnchorInfoMarginBottom());
        return;
    L21:
        if (this.G != WindowLayoutType.EnlargeBig) goto L23;
        n(this, this.C, 4.0f);
        goto L25
    L23:
        m(this, this.C, 0.0f, false, 31);
        goto L25
    L15:
        if (r5 == WindowLayoutType.EnlargeBig) goto L18;
        r6 = false;
        goto L19
    }

    public static final /* synthetic */ void d(MediaMultiAnchorWindowV2 r0, User r1) {
        r0.setFollowStatus(r1);
    }

    public final void r(boolean r1, int r2) {
        q(r2);
        if (r1 == false) goto L6;
        this.h.setVisibility(8);
        return;
    L6:
        if (this.f == false) goto L16;
        String r3 = this.c;
        gy.c.c2.getClass();
        gy.c r4 = gy.c.a.a();
        if (r4 == null) goto L12;
        gy.f r5 = r4.getRtcManager();
        if (r5 == null) goto L12;
        String r6 = r5.f0();
    L14:
        if (Intrinsics.areEqual(r3, r6) == false) goto L16;
        return;
    L12:
        r6 = null;
    L16:
        this.h.setVisibility(0);
    }

    public static void n(MediaMultiAnchorWindowV2 r7, MediaMultiAnchorGuestInfoLayout r8, float r9) {
        h(r7.m, r8, 0.0f, r9, 0.0f, 0.0f, false);
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.a
    public final void a(boolean r1, int r2, int r3) {
        if (i() == false) goto L6;
        this.q = r1;
        k();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.n
    public final void b(String r3, boolean r4, r.b r5) {
        Intrinsics.checkNotNullParameter(r3, "uid");
        Intrinsics.checkNotNullParameter(r5, "source");
        AnchorLinkUser r6 = this.b;
        if (r6 == null) goto L7;
        User r7 = r6.getMUser();
        if (r7 == null) goto L7;
        String r8 = r7.getIdStr();
    L9:
        if ((!Intrinsics.areEqual(r3, r8)) == false) goto L12;
        return;
    L12:
        if (r4 == false) goto L14;
        this.p = true;
        this.j.setImageResource(2131252596);
        f2.c(s1.C(2131920280, new Object[]{this.C.getNickName()}), 0);
    L15:
        MediaMultiAnchorGuestInfoLayout r9 = this.C;
        if (r9.j == r4) goto L20;
        r9.j = r4;
        r9.a();
        return;
    L20:
        return;
    L14:
        this.p = false;
        this.j.setImageResource(2131252598);
    L7:
        r8 = null;
        goto L9
    }

    public MediaMultiAnchorWindowV2(Context r28, DataCenter r29, String r30, AnchorLinkUser r31, com.bytedance.android.livesdk.interactivity.medialink.ui.window.l r33) {
        Intrinsics.checkNotNullParameter(r28, "context");
        Intrinsics.checkNotNullParameter(r29, "dataCenter");
        Intrinsics.checkNotNullParameter(r33, "wm");
        super(r28);
        this.e = new CompositeDisposable();
        this.q = true;
        this.r = 0;
        gy.c.c2.getClass();
        gy.c r8 = gy.c.a.a();
        String r9 = null;
        if (r8 == null) goto L5;
        gy.f r10 = r8.getRtcManager();
    L6:
        this.G = WindowLayoutType.Normal;
        this.H = new h(this);
        View r11 = LayoutInflater.from(r28).inflate(2131566206, this);
        this.B = new q();
        this.v = r33;
        MediaMultiAnchorGuestInfoLayout r5 = (MediaMultiAnchorGuestInfoLayout) r11.findViewById(2131389581);
        this.C = r5;
        r5.setIsPad(PadConfigUtils.c());
        MediaMultiAnchorGuestInfoCleanScreenLayout r13 = (MediaMultiAnchorGuestInfoCleanScreenLayout) r11.findViewById(2131389582);
        this.D = r13;
        if (r13 == null) goto L9;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
    L11:
        if ((r14 instanceof FrameLayout.LayoutParams) == true) goto L13;
        r14 = null;
    L13:
        FrameLayout.LayoutParams r15 = (FrameLayout.LayoutParams) r14;
        if (r15 == null) goto L16;
        r15.bottomMargin = getAnchorInfoMarginBottom();
    L16:
        r13.setIsPad(PadConfigUtils.c());
        MediaMultiAnchorPauseTipsView r16 = (MediaMultiAnchorPauseTipsView) r11.findViewById(2131381986);
        this.h = r16;
        this.i = r11.findViewById(2131368133);
        HSImageView r17 = r11.findViewById(2131376421);
        this.j = r17;
        FrameLayout r18 = (FrameLayout) r11.findViewById(2131364437);
        this.l = r18;
        this.m = (LinearLayout) r11.findViewById(2131364504);
        this.n = (LinearLayout) r11.findViewById(2131389179);
        this.k = (LinearLayout) r11.findViewById(2131378602);
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        if ((r19 instanceof FrameLayout.LayoutParams) == true) goto L19;
        r19 = null;
    L19:
        FrameLayout.LayoutParams r110 = (FrameLayout.LayoutParams) r19;
        if (r110 == null) goto L22;
        r110.bottomMargin = getAnchorInfoMarginBottom();
    L22:
        p r111 = new p((TextView) r11.findViewById(2131381776), false, true, null, AnonymousClass3.INSTANCE, AnonymousClass4.INSTANCE, 294);
        this.E = r111;
        r111.j(true);
        View r112 = r11.findViewById(2131366878);
        this.o = r112;
        this.x = (LinearLayout) r11.findViewById(2131389167);
        this.y = (FrameLayout) r11.findViewById(2131375498);
        this.z = (MediaInteractCommentView) r11.findViewById(2131375500);
        p r113 = new p(this.y, false, false, new AnonymousClass5(this), null, null, 478);
        r113.j(e());
        Unit r114 = Unit.INSTANCE;
        this.A = r113;
        p r115 = new p(r112, true, false, null, AnonymousClass7.INSTANCE, null, 432);
        this.F = r115;
        r115.j(!i());
        Room r116 = z.o(r29);
        this.u = r116;
        this.b = r31;
        this.c = r30;
        UIUtils.updateLayoutMargin(r16._$_findCachedViewById(2131388920), -3, -3, -3, (int) UIUtils.dip2Px(r28, 4.0f));
        r16.e.setTextSize(1, 15.0f);
        r16.f.setTextSize(1, 11.0f);
        Boolean r1 = (Boolean) r29.get("data_is_anchor");
        if (r1 == null) goto L25;
        boolean r2 = r1.booleanValue();
    L26:
        this.f = r2;
        this.g = r29;
        if (r2 == false) goto L54;
        if (r31 == null) goto L32;
        User r3 = r31.getMUser();
        if (r3 == null) goto L32;
        String r4 = r3.getIdStr();
    L33:
        if (r116 == null) goto L35;
        String r117 = r116.getOwnerUserIdString();
    L37:
        if ((!Intrinsics.areEqual(r4, r117)) == false) goto L54;
        r17.setImageResource(2131252598);
        if (r5.j == false) goto L42;
        r5.j = false;
        r5.a();
    L42:
        if (r10 == null) goto L54;
        nc0.s r6 = r10.L();
        if (r6 == null) goto L54;
        nc0.r r7 = r6.e(getLinkMicId());
        if (r7 == null) goto L54;
        if (r7.a.g != true) goto L54;
        this.p = true;
        r17.setImageResource(2131252596);
        if (r5.j == true) goto L54;
        r5.j = true;
        r5.a();
        goto L54
    L35:
        r117 = null;
    L32:
        r4 = null;
    L54:
        if (this.f == true) goto L57;
        ImageLoader.bindDrawableResource(this.z.a(2131379789), 2131251947);
    L57:
        if (j() == true) goto L60;
        this.y.setOnClickListener(x0.a(AnonymousClass8.INSTANCE));
    L60:
        if (i() == false) goto L62;
        int r20 = s1.f(32.0f);
        com.bytedance.android.live.core.utils.a1.k(this.y, r20);
        com.bytedance.android.live.core.utils.a1.p(this.y, r20);
        com.bytedance.android.live.core.utils.a1.k(this.z, r20);
        com.bytedance.android.live.core.utils.a1.p(this.z, r20);
    L62:
        StringBuilder r21 = new StringBuilder("MultiAnchorWindow init ");
        r21.append(r30);
        r21.append(' ');
        if (r31 == null) goto L65;
        r9 = r31.toSimpleString();
    L65:
        r21.append(r9);
        ALogger.e("ttlive_anchor_link_window", r21.toString());
        r112.setOnClickListener(new b(this));
        setOnClickListener(new a(this, r29));
        if (i() == false) goto L70;
        k();
        return;
    L70:
        return;
    L25:
        r2 = false;
        goto L26
    L9:
        r14 = null;
        goto L11
    L5:
        r10 = null;
        goto L6
    }

    public static void m(MediaMultiAnchorWindowV2 r7, View r8, float r9, boolean r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        float r2 = 0.0f;
    L7:
        if ((r11 & 16) == 0) goto L9;
        boolean r6 = false;
    L10:
        h(r7.k, r8, r2, 0.0f, 0.0f, 0.0f, r6);
        return;
    L9:
        r6 = r10;
        goto L10
    L5:
        r2 = r9;
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        MediaMultiAnchorGuestInfoLayout r6 = this.C;
        if (r6 == null) goto L5;
        Integer r7 = Integer.valueOf(r6.getWidth());
    L6:
        int r8 = r7.intValue();
        if (r8 == this.w) goto L10;
        this.C.b();
        this.C.getComponent().j(true);
        this.w = r8;
        return;
    L10:
        return;
    L5:
        r7 = null;
        goto L6
    }

    public static void h(LinearLayout r3, View r4, float r5, float r6, float r7, float r8, boolean r9) {
        ViewGroup r0 = UtilityKotlinExtentionsKt.p(r4);
        if (r0 == null) goto L5;
        r0.removeView(r4);
    L5:
        ViewGroup.LayoutParams r1 = r4.getLayoutParams();
        int r2 = -2;
        if (r1 == null) goto L8;
        int r10 = r1.width;
    L9:
        ViewGroup.LayoutParams r11 = r4.getLayoutParams();
        if (r11 == null) goto L12;
        r2 = r11.height;
    L12:
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(r10, r2);
        r13.leftMargin = s1.f(r5);
        r13.rightMargin = s1.f(r6);
        r13.topMargin = s1.f(r7);
        r13.bottomMargin = s1.f(r8);
        if (r9 == false) goto L15;
        r3.addView(r4, 0, r13);
        return;
    L15:
        r3.addView(r4, r13);
        return;
    L8:
        r10 = -2;
        goto L9
    }
}
