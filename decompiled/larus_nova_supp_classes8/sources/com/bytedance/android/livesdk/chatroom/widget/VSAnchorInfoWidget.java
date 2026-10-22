package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdk.chatroom.ui.d9;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.chatroom.widget.unionlive.UnionAnchorWidget;
import com.bytedance.android.livesdk.common.MarqueeTextView;
import com.bytedance.android.livesdk.common.MinMaxWidthLinearLayout;
import com.bytedance.android.livesdk.config.sr;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.PortraitTopAnchor, needDynamicControl = true, type = PlayerViewControl.Type.TOP)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/VSAnchorInfoWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSAnchorInfoWidget extends LiveRecyclableWidget implements com.bytedance.android.livesdk.chatroom.vsplayer.model.a, Observer<KVData> {
    public static final /* synthetic */ int t = 0;
    public HSImageView a;
    public TextView b;
    public TextView c;
    public View d;
    public View e;
    public HSImageView f;
    public ProgressBar g;
    public FrameLayout h;
    public MinMaxWidthLinearLayout i;
    public MarqueeTextView j;
    public HSImageView k;
    public final CompositeDisposable l;
    public com.bytedance.android.live.profit.fansclub.o m;
    public final int n;
    public Room o;
    public long p;
    public UnionAnchorWidget q;
    public final b r;
    public final VSAnchorInfoWidget$timerListener$1 s;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ VSAnchorInfoWidget a;

        public b(VSAnchorInfoWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            KVData r5 = (KVData) r4;
            if (r5 == null) goto L5;
            String r0 = r5.getKey();
        L6:
            if (r0 != null) goto L9;
            return;
        L9:
            if (r0.hashCode() == 1060055221) goto L12;
            return;
        L12:
            if (r0.equals("data_keyboard_status") == false) goto L23;
            Boolean r6 = (Boolean) r5.getData();
            int r1 = 0;
            if (r6 == null) goto L16;
            boolean r7 = r6.booleanValue();
        L17:
            ViewGroup r2 = ((Widget) this.a).containerView;
            if (r2 == null) goto L24;
            if (r7 == false) goto L21;
            r1 = 8;
        L21:
            r2.setVisibility(r1);
            return;
        L24:
            return;
        L16:
            r7 = false;
            goto L17
        L23:
            return;
        L5:
            r0 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ VSAnchorInfoWidget a;

        public c(VSAnchorInfoWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Room r3 = (Room) sh6.c.b((sh6.b) r2);
            if (r3 == null) goto L6;
            VSAnchorInfoWidget r0 = this.a;
            r0.o = r3;
            r0.Aq();
            return;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567954;
    }

    public final void onInit(Object[] r1) {
    }

    public final void Aq() {
        Room r0 = this.o;
        if (r0 == null) goto L124;
        HSImageView r2 = this.a;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("vsAnchorAvatar");
    L7:
        User r3 = r0.getOwner();
        Long r4 = null;
        if (r3 == null) goto L10;
        py.k r5 = r3._avatarMedium;
    L11:
        ImageLoader.bindAvatar(r2, r5, UtilityKotlinExtentionsKt.i(18), UtilityKotlinExtentionsKt.i(18));
        boolean r6 = false;
        if (wt2.e.a() == false) goto L29;
        TextView r7 = (TextView) ((Widget) this).contentView.findViewById(2131392884);
        if (r7 == null) goto L16;
        r7.setVisibility(8);
    L16:
        HSImageView r8 = ((Widget) this).contentView.findViewById(2131392885);
        if (r8 == null) goto L19;
        r8.setVisibility(8);
    L19:
        this.i = (MinMaxWidthLinearLayout) ((Widget) this).contentView.findViewById(2131379640);
        this.j = (MarqueeTextView) ((Widget) this).contentView.findViewById(2131379639);
        this.k = ((Widget) this).contentView.findViewById(2131379641);
        MinMaxWidthLinearLayout r9 = this.i;
        if (r9 == null) goto L22;
        r9.setVisibility(0);
    L22:
        ConstraintSet r10 = new ConstraintSet();
        ConstraintLayout r11 = findViewById(2131384813);
        r10.clone(r11);
        r10.connect(2131392943, 1, 2131379640, 2);
        r10.connect(2131392940, 1, 2131379640, 2);
        r10.applyTo(r11);
        MinMaxWidthLinearLayout r12 = this.i;
        if (r12 == null) goto L25;
        r12.setMinWidth(UtilityKotlinExtentionsKt.i(48));
    L25:
        MarqueeTextView r13 = this.j;
        if (r13 == null) goto L29;
        r13.setMaxWidth(UtilityKotlinExtentionsKt.i(59));
    L29:
        if (wt2.e.a() == false) goto L67;
        RoomContext.a r14 = RoomContext.Companion;
        RoomContext r15 = RoomContext.a.c(r14, ((Widget) this).dataCenter, 0, 2);
        if (r15 == null) goto L37;
        com.bytedance.live.datacontext.m r16 = r15.isAnchorNameMarqueed();
        if (r16 == null) goto L37;
        Boolean r17 = (Boolean) r16.getValue();
        if (r17 == null) goto L37;
        boolean r18 = r17.booleanValue();
    L38:
        if (r18 == false) goto L46;
        MarqueeTextView r19 = this.j;
        if (r19 == null) goto L53;
        User r110 = r0.getOwner();
        if (r110 == null) goto L44;
        String r111 = r110.getRemarkNameOrNickname();
    L45:
        r19.setTextWithEllipsis(r111);
        goto L53
    L44:
        r111 = null;
    L53:
        RoomContext r20 = RoomContext.a.c(r14, ((Widget) this).dataCenter, 0, 2);
        if (r20 == null) goto L56;
        com.bytedance.live.datacontext.j r21 = r20.getRoomTitleAndAnchorNameTimer();
    L57:
        if (r21 != null) goto L59;
    L60:
        if (r21 == null) goto L62;
        final long r22 = 111;
        final long r112 = 1000;
        r21.e(new VSAnchorInfoWidget$startAnimationListener$1(r22, r112));
    L62:
        if (r21 == null) goto L64;
        r21.c(new VSAnchorInfoWidget$startAnimationListener$2(this));
    L64:
        MarqueeTextView r23 = this.j;
        if (r23 == null) goto L75;
        r23.setOnClickListener(new VSAnchorInfoWidget$renderData$$inlined$also$lambda$1(this));
    L75:
        User r24 = r0.getOwner();
        if (r24 == null) goto L93;
        py.c r25 = r24.getMAuthenticationInfo();
        if (r25 == null) goto L93;
        py.k r26 = r25.getAuthenticationBadge();
        if (r26 == null) goto L93;
        if (wt2.e.a() == false) goto L86;
        ImageLoader.bindImage(this.k, r26);
        HSImageView r27 = this.k;
        if (r27 == null) goto L101;
        r27.setVisibility(0);
    L101:
        if (sr.a.getValue().booleanValue() == false) goto L103;
        com.bytedance.android.live.room.api.follow.b.c(r0.getOwner(), "VSAnchorInfoWidget", r0, new VSAnchorInfoWidget$renderData$$inlined$also$lambda$2(this));
        return;
    L103:
        User r1 = r0.getOwner();
        if (r1 == null) goto L106;
        FollowInfo r28 = r1.getFollowInfo();
    L107:
        if (r28 == null) goto L121;
        FollowInfo r29 = r1.getFollowInfo();
        if (r29 == null) goto L111;
        r4 = Long.valueOf(r29.getFollowStatus());
    L111:
        if (r4 != null) goto L114;
    L115:
        long r30 = 2;
        if (r4 == null) goto L121;
        if (r30 != r4.longValue()) goto L121;
    L120:
        r6 = true;
        goto L121
    L114:
        if (1 == r4.longValue()) goto L120;
    L121:
        if (r6 == false) goto L123;
        yq();
        return;
    L123:
        zq();
        return;
    L106:
        r28 = null;
        goto L107
    L86:
        HSImageView r31 = this.f;
        if (r31 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("vsVerifyIcon");
    L89:
        ImageLoader.bindImage(r31, r26);
        HSImageView r32 = this.f;
        if (r32 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("vsVerifyIcon");
    L92:
        r32.setVisibility(0);
    L93:
        HSImageView r33 = this.k;
        if (r33 == null) goto L96;
        r33.setVisibility(8);
    L96:
        HSImageView r34 = this.f;
        if (r34 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("vsVerifyIcon");
    L99:
        r34.setVisibility(8);
        Unit r35 = Unit.INSTANCE;
        goto L101
    L59:
        if (r21.hasValue() == true) goto L62;
    L56:
        r21 = null;
        goto L57
    L46:
        MarqueeTextView r36 = this.j;
        if (r36 == null) goto L53;
        User r113 = r0.getOwner();
        if (r113 == null) goto L51;
        String r114 = r113.getRemarkNameOrNickname();
    L52:
        r36.setTextWithFading(r114);
        goto L53
    L51:
        r114 = null;
    L37:
        r18 = false;
        goto L38
    L67:
        TextView r37 = this.b;
        if (r37 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("vsAnchorName");
    L70:
        User r38 = r0.getOwner();
        if (r38 == null) goto L73;
        String r39 = r38.getRemarkNameOrNickname();
    L74:
        r37.setText(r39);
        goto L75
    L73:
        r39 = null;
        goto L74
    L10:
        r5 = null;
        goto L11
    L124:
        ALogger.e("VSAnchorInfoWidget", "vs_episode_info_widget load info failed cause of empty null data");
    }

    public final void onUnload() {
        MarqueeTextView r0 = this.j;
        if (r0 == null) goto L5;
        r0.cancelAnimation();
    L5:
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.j r2 = r1.getRoomTitleAndAnchorNameTimer();
        if (r2 == null) goto L12;
        d9 r3 = (d9) r2.getValue();
        if (r3 == null) goto L12;
        r3.c(this.s);
    L12:
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L15;
        r4.removeObserver(this);
    L15:
        this.q = null;
        this.l.clear();
    }

    public final void xq() {
        int r0 = com.bytedance.android.live.room.utils.c.a;
        if (com.bytedance.android.live.room.utils.c.b(this.o) == true) goto L5;
    L25:
        UnionAnchorWidget r1 = this.q;
        if (r1 == null) goto L30;
        View r2 = ((Widget) r1).contentView;
        if (r2 == null) goto L30;
        UtilityKotlinExtentionsKt.t(r2);
    L30:
        View r3 = ((Widget) this).contentView;
        if (r3 == null) goto L37;
        UtilityKotlinExtentionsKt.w(r3);
        return;
    L37:
        return;
    L5:
        if (com.bytedance.android.live.core.utils.z.m(((Widget) this).dataCenter, true) == false) goto L25;
        if (this.q != null) goto L11;
        this.q = new UnionAnchorWidget(false);
        enableSubWidgetManager();
        WidgetManager r4 = ((Widget) this).subWidgetManager;
        if (r4 == null) goto L11;
        r4.load(((Widget) this).containerView, this.q, false);
    L11:
        View r5 = ((Widget) this).contentView;
        if (r5 == null) goto L14;
        UtilityKotlinExtentionsKt.t(r5);
    L14:
        View r6 = ((Widget) this).contentView;
        if (r6 == null) goto L17;
        com.bytedance.android.live.core.utils.a1.o(r6, UtilityKotlinExtentionsKt.i(2));
    L17:
        View r7 = ((Widget) this).contentView;
        if (r7 == null) goto L20;
        com.bytedance.android.live.core.utils.a1.l(r7, UtilityKotlinExtentionsKt.i(2));
    L20:
        UnionAnchorWidget r8 = this.q;
        if (r8 == null) goto L34;
        View r9 = ((Widget) r8).contentView;
        if (r9 == null) goto L35;
        UtilityKotlinExtentionsKt.w(r9);
        return;
    L35:
        return;
    }

    public final void yq() {
        View r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vsFollowContainer");
    L5:
        r0.setVisibility(8);
        Room r1 = this.o;
        if (r1 != null) goto L8;
    L22:
        FrameLayout r2 = this.h;
        if (r2 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("vsFansClubContainer");
    L25:
        r2.setVisibility(0);
        return;
    L8:
        if (r1.isMergeVSRoom() != true) goto L22;
        Room r3 = this.o;
        if (r3 != null) goto L12;
    L13:
        Room r4 = this.o;
        if (r4 == null) goto L22;
        if (r4.allowFansClub() == true) goto L22;
    L17:
        View r5 = this.e;
        if (r5 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("vsFollowedContainer");
    L20:
        UtilityKotlinExtentionsKt.w(r5);
        return;
    L12:
        if (r3.allowGift() == false) goto L17;
        goto L13
    }

    public final void zq() {
        View r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vsFollowContainer");
    L5:
        r0.setVisibility(0);
        FrameLayout r1 = this.h;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("vsFansClubContainer");
    L8:
        r1.setVisibility(8);
        View r2 = this.e;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("vsFollowedContainer");
    L11:
        UtilityKotlinExtentionsKt.t(r2);
    }

    public VSAnchorInfoWidget() {
        this.l = new CompositeDisposable();
        this.n = 32;
        this.p = -1;
        this.r = new b(this);
        this.s = new VSAnchorInfoWidget$timerListener$1(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.model.a
    public final boolean canControlByPlayer(PlayerViewControl.KEY r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        if (com.bytedance.android.live.core.utils.z.m(((Widget) this).dataCenter, true) == true) goto L11;
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L11;
        Room r5 = com.bytedance.android.live.core.utils.z.o(r4);
        if (r5 == null) goto L11;
        if (r5.isMergeVSRoom() != true) goto L11;
        return true;
    L11:
        VSDataContext r6 = VSDataContext.a.c(VSDataContext.Companion, ((Widget) this).dataCenter);
        if (r6 != null) goto L14;
    L16:
        return false;
    L14:
        if (((Boolean) r6.isVerticalVideo().getValue()).booleanValue() != true) goto L16;
        return ((Boolean) r6.isVerticalVideoLock().getValue()).booleanValue();
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        Intrinsics.checkNotNullParameter(r4, "t");
        String r5 = r4.getKey();
        if (r5.hashCode() == 560852175) goto L6;
        return;
    L6:
        if (r5.equals("data_union_room_change") == false) goto L9;
        xq();
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r2);
        if (PadConfigUtils.c() == false) goto L11;
        if (r2 == null) goto L8;
        boolean r0 = true;
        if (r2.orientation != 1) goto L8;
    L9:
        wq(r0);
        return;
    L8:
        r0 = false;
        goto L9
    }

    public final void onLoad(Object[] r8) {
        ((Widget) this).contentView.setVisibility(0);
        this.o = com.bytedance.android.live.core.utils.z.o(((Widget) this).dataCenter);
        this.m = yt0.c.c();
        com.bytedance.android.livesdk.user.f0 r9 = (com.bytedance.android.livesdk.user.f0) ((Widget) this).dataCenter.get("data_user_center");
        Room r1 = this.o;
        if (r1 == null) goto L9;
        String r2 = r1.getOwnerUserIdString();
        if (r9 == null) goto L7;
        String r10 = r9.n();
    L8:
        Intrinsics.areEqual(r2, r10);
        goto L9
    L7:
        r10 = null;
    L9:
        View r11 = ((Widget) this).contentView;
        if (r11 == null) goto L31;
        this.a = r11.findViewById(2131392880);
        this.b = (TextView) r11.findViewById(2131392884);
        this.c = (TextView) r11.findViewById(2131392882);
        this.f = r11.findViewById(2131392885);
        this.g = (ProgressBar) r11.findViewById(2131392944);
        this.d = r11.findViewById(2131392943);
        this.e = r11.findViewById(2131392945);
        View r3 = this.d;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("vsFollowContainer");
    L14:
        r3.setVisibility(8);
        View r4 = this.e;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("vsFollowedContainer");
    L17:
        r4.setVisibility(8);
        FrameLayout r5 = (FrameLayout) r11.findViewById(2131392940);
        this.h = r5;
        if (r5 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("vsFansClubContainer");
    L20:
        r5.setVisibility(8);
        this.i = (MinMaxWidthLinearLayout) r11.findViewById(2131379640);
        this.j = (MarqueeTextView) r11.findViewById(2131379639);
        this.k = r11.findViewById(2131379641);
        if (com.bytedance.android.live.core.utils.z.m(((Widget) this).dataCenter, true) == true) goto L26;
        HSImageView r12 = this.a;
        if (r12 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("vsAnchorAvatar");
    L25:
        r12.setVisibility(8);
        float r6 = 2;
        ((Widget) this).contentView.setPadding((int) UtilityKotlinExtentionsKt.h(r6), 0, (int) UtilityKotlinExtentionsKt.h(r6), 0);
    L30:
        wq(com.bytedance.android.live.core.utils.z.m(((Widget) this).dataCenter, true));
        goto L31
    L26:
        HSImageView r13 = this.a;
        if (r13 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("vsAnchorAvatar");
    L29:
        r13.setVisibility(0);
        ((Widget) this).contentView.setPadding(0, 0, (int) UtilityKotlinExtentionsKt.h(2), 0);
    L31:
        DataCenter r14 = ((Widget) this).dataCenter;
        if (r14 == null) goto L34;
        r14.observe("data_keyboard_status", this.r);
    L34:
        ((Widget) this).contentView.setOnClickListener(new k2(this));
        View r15 = this.e;
        if (r15 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("vsFollowedContainer");
    L37:
        r15.setOnClickListener(l2.a);
        Disposable r16 = jc1.k.n(IUserService.class).user().followStateChanged().observeOn(AndroidSchedulers.mainThread()).subscribe(new m2(this), n2.a);
        if (r16 == null) goto L40;
        this.l.add(r16);
    L40:
        TextView r17 = this.c;
        if (r17 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("vsAnchorFollow");
    L43:
        r17.setOnClickListener(new o2(this));
        RoomContext.a r18 = RoomContext.Companion;
        DataCenter r0 = ((Widget) this).dataCenter;
        r18.getClass();
        RoomContext r19 = RoomContext.a.a(r0, 0);
        if (r19 == null) goto L52;
        com.bytedance.live.datacontext.n r20 = r19.getInteractionDataPrepared();
        if (r20 == null) goto L52;
        if (r20.getValue() != null) goto L52;
        ObservableSubscribeProxy r21 = (ObservableSubscribeProxy) r20.a().as(autoDispose());
        if (r21 == null) goto L52;
        r21.subscribe(new c(this));
    L52:
        Aq();
        DataCenter r22 = ((Widget) this).dataCenter;
        if (r22 == null) goto L55;
        r22.observe("data_union_room_change", this);
    L55:
        com.bytedance.android.live.room.a0.b r23 = com.bytedance.android.live.room.a0.a;
        com.bytedance.android.live.room.a0.g = ((Widget) this).containerView;
        xq();
        com.bytedance.android.live.profit.fansclub.o r24 = this.m;
        if (r24 == null) goto L62;
        Context r7 = ((Widget) this).context;
        DataCenter r25 = ((Widget) this).dataCenter;
        FrameLayout r26 = this.h;
        if (r26 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("vsFansClubContainer");
    L60:
        com.bytedance.android.live.profit.fansclub.o.a.a(r24, r7, r25, r26);
        return;
    }

    public final void wq(boolean r6) {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isVSRoom() != true) goto L17;
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) ((Widget) this).contentView.getLayoutParams();
        if (r1 != null) goto L10;
        return;
    L10:
        if (r6 == true) goto L12;
        r1.height = UtilityKotlinExtentionsKt.i(24);
        r1.topMargin = 0;
        r1.bottomMargin = 0;
    L13:
        ((Widget) this).contentView.setLayoutParams(r1);
        return;
    L12:
        r1.height = UtilityKotlinExtentionsKt.i(22);
        r1.topMargin = 0;
        r1.bottomMargin = 0;
        goto L13
    }
}
