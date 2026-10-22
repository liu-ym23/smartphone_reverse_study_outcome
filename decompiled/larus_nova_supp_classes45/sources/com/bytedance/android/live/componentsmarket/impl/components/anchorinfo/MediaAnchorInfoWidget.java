package com.bytedance.android.live.componentsmarket.impl.components.anchorinfo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsWidget;
import com.bytedance.android.live.componentsmarket.impl.components.anchorinfo.model.MediaAnchorInfoViewModel;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.setting.CoreSettingUtil;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.FitTextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.config.sr;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.LiveHotSpotInfo;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAvator;
import com.bytedance.android.livesdkapi.depend.model.live.RoomPlatformComponentsData;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import zg1.k1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.LandscapeAnchorInfo, needDynamicControl = true, type = PlayerViewControl.Type.TOP)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u00062\u00020\u0007:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/componentsmarket/impl/components/anchorinfo/MediaAnchorInfoWidget;", "Lcom/bytedance/android/live/componentsmarket/impl/components/BaseComponentsWidget;", "Lcom/bytedance/android/live/componentsmarket/impl/components/anchorinfo/model/MediaAnchorInfoViewModel;", "Lo70/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/a;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", "a", "livecomponentsmarket-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaAnchorInfoWidget extends BaseComponentsWidget<MediaAnchorInfoViewModel> implements o70.a, Observer<KVData>, ViewModelProvider.Factory, com.bytedance.android.livesdk.chatroom.vsplayer.model.a {
    public static final /* synthetic */ int x = 0;
    public ConstraintLayout c;
    public HSImageView d;
    public TextView e;
    public HSImageView f;
    public View g;
    public TextView h;
    public ProgressBar i;
    public ImageView j;
    public FrameLayout k;
    public final CompositeDisposable l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public FragmentActivity q;
    public boolean r;
    public boolean s;
    public LiveRecyclableWidget t;
    public com.bytedance.android.live.profit.fansclub.o u;
    public final Lazy v;
    public final CompositeDisposable w;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ MediaAnchorInfoWidget a;

        public b(MediaAnchorInfoWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            MediaAnchorInfoWidget r3 = this.a;
            r3.s = true;
            MediaAnchorInfoWidget.Eq(r3);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ MediaAnchorInfoWidget a;

        public c(MediaAnchorInfoWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            MediaAnchorInfoWidget r3 = this.a;
            r3.s = true;
            MediaAnchorInfoWidget.Eq(r3);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ MediaAnchorInfoWidget a;

        public d(MediaAnchorInfoWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            MediaAnchorInfoWidget r5 = this.a;
            int r0 = MediaAnchorInfoWidget.x;
            Room r1 = r5.b;
            String r2 = null;
            if (r1 == null) goto L5;
            User r3 = r1.getOwner();
        L7:
            if (r3 == null) goto L9;
            r2 = r3.getIdStr();
        L9:
            UserProfileEvent r6 = new UserProfileEvent(r2);
            r6.setClickUserPosition("live_open_top_left_anchor");
            Room r7 = r5.b;
            if (r7 != null) goto L12;
        L14:
            LiveFollowScene r8 = LiveFollowScene.PROFILE_USER_INFO;
        L15:
            r6.setExtraFollowParams(com.bytedance.android.livesdk.user.j.b(r8));
            xs2.b.a().post(r6);
            return;
        L12:
            if (r7.isMergeVSRoom() != true) goto L14;
            r8 = LiveFollowScene.VS_USER_PROFILE;
            goto L15
        L5:
            r3 = null;
            goto L7
        }
    }

    static {
    }

    public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final int getLayoutId() {
        return 2131565146;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsWidget
    public final void Aq() {
        Room r0 = this.b;
        Room r1 = null;
        if (r0 == null) goto L5;
        User r2 = r0.getOwner();
    L6:
        this.r = false;
        if (r2 == null) goto L12;
        Room r3 = this.b;
        if (r3 == null) goto L11;
        Gq(r3);
    L11:
        this.w.add(jc1.k.n(IUserService.class).user().u0(r2.getIdStr()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new t(this), u.a));
    L12:
        RoomContext r4 = getDataContext();
        if (r4 == null) goto L17;
        com.bytedance.live.datacontext.n r5 = r4.getInteractionDataPrepared();
        if (r5 == null) goto L17;
        r1 = (Room) r5.getValue();
    L17:
        if (r1 != null) goto L27;
        RoomContext r6 = getDataContext();
        if (r6 == null) goto L27;
        com.bytedance.live.datacontext.n r7 = r6.getInteractionDataPrepared();
        if (r7 == null) goto L27;
        Observable r8 = r7.a();
        if (r8 == null) goto L27;
        ObservableSubscribeProxy r9 = (ObservableSubscribeProxy) r8.as(autoDispose());
        if (r9 == null) goto L27;
        r9.subscribe(new v(this));
    L27:
        ((Widget) this).dataCenter.observeForever("data_login_event", this).observe("cmd_update_live_hotspot_show", this).observe("data_union_room_change", this);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsWidget
    public final void Bq() {
        MediaAnchorInfoViewModel r0 = this.a;
        py.k r1 = null;
        if (r0 == null) goto L13;
        Room r2 = this.b;
        if (r2 == null) goto L11;
        RoomPlatformComponentsData r3 = r2.roomPlatformComponentsData;
        if (r3 == null) goto L11;
        RoomAvator r4 = r3.getRoomAvator();
        if (r4 == null) goto L11;
        py.k r5 = r4.getAvatar();
    L12:
        r0.avatarImageModle(r5);
    L11:
        r5 = null;
    L13:
        MediaAnchorInfoViewModel r6 = this.a;
        if (r6 == null) goto L25;
        Room r7 = this.b;
        if (r7 == null) goto L23;
        RoomPlatformComponentsData r8 = r7.roomPlatformComponentsData;
        if (r8 == null) goto L23;
        RoomAvator r9 = r8.getRoomAvator();
        if (r9 == null) goto L23;
        String r11 = r9.getNickName();
        if (r11 == null) goto L23;
    L24:
        r6.anchorName(r11);
    L23:
        r11 = "";
    L25:
        MediaAnchorInfoViewModel r12 = this.a;
        if (r12 == null) goto L35;
        Room r13 = this.b;
        if (r13 == null) goto L34;
        RoomPlatformComponentsData r14 = r13.roomPlatformComponentsData;
        if (r14 == null) goto L34;
        RoomAvator r15 = r14.getRoomAvator();
        if (r15 == null) goto L34;
        r1 = r15.getAuthenticationInfo();
    L34:
        r12.verifyInfo(r1);
    L35:
        MediaAnchorInfoViewModel r16 = this.a;
        if (r16 == null) goto L47;
        Room r17 = this.b;
        if (r17 == null) goto L44;
        RoomPlatformComponentsData r18 = r17.roomPlatformComponentsData;
        if (r18 == null) goto L44;
        RoomAvator r19 = r18.getRoomAvator();
        if (r19 == null) goto L44;
        boolean r21 = r19.getHasFansClub();
    L45:
        r16.hasFansClub(r21);
        return;
    L44:
        r21 = false;
        goto L45
    }

    public final void Fq() {
        TextView r0 = this.h;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        ((ImageView) this.n.getValue()).setAlpha(0.0f);
        ((ImageView) this.o.getValue()).setAlpha(1.0f);
        ((FitTextView) this.p.getValue()).setVisibility(0);
        ((FitTextView) this.p.getValue()).setAlpha(1.0f);
        MediaAnchorInfoViewModel r1 = this.a;
        if (r1 == null) goto L10;
        LiveData<Boolean> r2 = r1.getHasFansClub();
        if (r2 == null) goto L10;
        Boolean r3 = (Boolean) r2.getValue();
    L12:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L20;
        FrameLayout r4 = this.k;
        if (r4 == null) goto L16;
        r4.setVisibility(0);
    L16:
        View r5 = this.g;
        if (r5 == null) goto L21;
        UtilityKotlinExtentionsKt.t(r5);
        return;
    L21:
        return;
    L20:
        return;
    L10:
        r3 = null;
        goto L12
    }

    public final void Iq() {
        FrameLayout r0 = this.k;
        if (r0 != null) goto L5;
    L9:
        View r1 = this.g;
        if (r1 == null) goto L12;
        UtilityKotlinExtentionsKt.w(r1);
    L12:
        TextView r2 = this.h;
        if (r2 == null) goto L15;
        r2.setVisibility(0);
    L15:
        ((ImageView) this.n.getValue()).setAlpha(1.0f);
        ((ImageView) this.o.getValue()).setAlpha(0.0f);
        ((FitTextView) this.p.getValue()).setVisibility(8);
        return;
    L5:
        if (r0.getVisibility() != 0) goto L9;
        FrameLayout r3 = this.k;
        if (r3 == null) goto L9;
        r3.setVisibility(8);
        goto L9
    }

    public final void Jq() {
        int r0 = com.bytedance.android.live.room.utils.c.a;
        RoomContext r1 = getDataContext();
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L7;
        Room r3 = (Room) r2.getValue();
    L9:
        if (com.bytedance.android.live.room.utils.c.b(r3) == true) goto L11;
    L27:
        View r4 = ((Widget) this).contentView;
        if (r4 == null) goto L30;
        UtilityKotlinExtentionsKt.w(r4);
    L30:
        LiveRecyclableWidget r5 = this.t;
        if (r5 == null) goto L39;
        View r6 = ((Widget) r5).contentView;
        if (r6 == null) goto L40;
        UtilityKotlinExtentionsKt.t(r6);
        return;
    L40:
        return;
    L39:
        return;
    L11:
        if (com.bytedance.android.live.core.utils.z.m(((Widget) this).dataCenter, true) == false) goto L27;
        enableSubWidgetManager();
        if (this.t != null) goto L19;
        LiveRecyclableWidget r7 = jc1.k.n(IRoomService.class).getUnionAnchorInfoWidget(false);
        this.t = r7;
        if (r7 == null) goto L19;
        enableSubWidgetManager();
        WidgetManager r8 = ((Widget) this).subWidgetManager;
        if (r8 == null) goto L19;
        r8.load(((Widget) this).containerView, this.t, false);
    L19:
        View r9 = ((Widget) this).contentView;
        if (r9 == null) goto L22;
        UtilityKotlinExtentionsKt.t(r9);
    L22:
        LiveRecyclableWidget r11 = this.t;
        if (r11 == null) goto L36;
        View r12 = ((Widget) r11).contentView;
        if (r12 == null) goto L37;
        UtilityKotlinExtentionsKt.w(r12);
        return;
    L37:
        return;
    L36:
        return;
    L7:
        r3 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Kq() {
        ProgressBar r0 = this.i;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        TextView r1 = this.h;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        ImageView r2 = this.j;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        a0 r3 = new a0(this);
        PipelineDraweeControllerBuilder r4 = Fresco.newDraweeControllerBuilder();
        r4.setUri((String) this.v.getValue());
        r4.setControllerListener(r3);
        r4.setAutoPlayAnimations(true);
        AbstractDraweeController r5 = r4.build();
        ((HSImageView) this.m.getValue()).getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        ((HSImageView) this.m.getValue()).setController(r5);
        ((HSImageView) this.m.getValue()).setVisibility(0);
        ImageView r6 = (ImageView) findViewById(2131380979);
        ImageView r7 = (ImageView) findViewById(2131373108);
        TextView r8 = (TextView) findViewById(2131373107);
        r8.setAlpha(0.0f);
        r8.setVisibility(0);
        AnimatorSet r9 = new AnimatorSet();
        ObjectAnimator r11 = ObjectAnimator.ofFloat(r6, LiveDegradeFpsAnimator.ALPHA, new float[]{1.0f, 0.0f});
        r11.setDuration(150);
        Unit r12 = Unit.INSTANCE;
        ObjectAnimator r13 = ObjectAnimator.ofFloat(r7, LiveDegradeFpsAnimator.ALPHA, new float[]{0.0f, 1.0f});
        r13.setDuration(150);
        ObjectAnimator r14 = ObjectAnimator.ofFloat(r8, LiveDegradeFpsAnimator.ALPHA, new float[]{0.0f, 1.0f});
        r14.setDuration(150);
        r14.setStartDelay(1000);
        r9.playTogether(new Animator[]{r11, r13, r14});
        r9.start();
        if (isScreenLandscape() == false) goto L16;
        SimpleDraweeView r15 = this.d;
        if (r15 == null) goto L16;
        r15.setVisibility(8);
    L16:
        MediaAnchorInfoViewModel r16 = this.a;
        if (r16 == null) goto L21;
        LiveData<Boolean> r17 = r16.getHasFansClub();
        if (r17 == null) goto L21;
        Boolean r18 = (Boolean) r17.getValue();
    L23:
        if (Intrinsics.areEqual(r18, Boolean.TRUE) == false) goto L31;
        FrameLayout r19 = this.k;
        if (r19 == null) goto L27;
        r19.setVisibility(0);
    L27:
        View r21 = this.g;
        if (r21 == null) goto L32;
        UtilityKotlinExtentionsKt.t(r21);
        return;
    L32:
        return;
    L31:
        return;
    L21:
        r18 = null;
        goto L23
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Lq() {
        ((ImageView) this.n.getValue()).setVisibility(0);
        ((ImageView) this.o.getValue()).setVisibility(0);
        final Room r8 = (Room) ((Widget) this).dataCenter.get("data_room");
        if (r8 == null) goto L26;
        User r6 = r8.getOwner();
        if (r6 == null) goto L26;
        if (((Boolean) sr.a.getValue()).booleanValue() == false) goto L22;
        MediaAnchorInfoViewModel r0 = this.a;
        if (r0 == null) goto L11;
        boolean r2 = r0.isFollowing();
    L12:
        MediaAnchorInfoViewModel r1 = this.a;
        if (r1 == null) goto L15;
        boolean r3 = r1.isInvalidFollowStatus();
    L16:
        MediaAnchorInfoViewModel r4 = this.a;
        if (r4 == null) goto L19;
        long r5 = r4.getFollowStatus();
    L20:
        com.bytedance.android.live.room.api.follow.b.d(r2, r3, r5, r6, "MediaAnchor-updateUiOnLoad", r8, new MediaAnchorInfoWidget$updateUiOnLoad$$inlined$let$lambda$1(this, r8));
        goto L26
    L19:
        r5 = 0;
        goto L20
    L15:
        r3 = false;
        goto L16
    L11:
        r2 = false;
        goto L12
    L22:
        if (r6.isFollowing() == false) goto L24;
        Fq();
        goto L26
    L24:
        Iq();
    L26:
        if (isScreenLandscape() == false) goto L31;
        SimpleDraweeView r7 = this.d;
        if (r7 == null) goto L32;
        r7.setVisibility(8);
        return;
    L32:
        return;
    }

    @Override // o70.a
    public final List<Class<? extends o70.b>> Mg() {
        if (VrUtils.t(((Widget) this).dataCenter, false) == false) goto L6;
        return CollectionsKt.listOf(new Class[]{zg1.s.class, bh1.b.class});
    L6:
        return CollectionsKt.listOf(bh1.b.class);
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsWidget
    public final void onUnload() {
        this.w.clear();
        this.l.clear();
        this.t = null;
        UIUtils.setViewVisibility(this.f, 8);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L6;
        r0.removeObserver(this);
        return;
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsWidget
    public final void wq() {
        r3.e(this.c, new MediaAnchorInfoWidget$accessibilityCompat$1(this));
        p r0 = new p(this);
        r3.f(((Widget) this).context, r0);
        ConstraintLayout r1 = this.c;
        if (r1 == null) goto L6;
        r1.addOnAttachStateChangeListener(new o(this, r0));
        return;
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsWidget
    public final void xq() {
        MediaAnchorInfoViewModel r0 = this.a;
        if (r0 == null) goto L7;
        LiveData<py.k> r1 = r0.getAvatarImageModle();
        if (r1 == null) goto L7;
        r1.observe(this, new q(this));
    L7:
        MediaAnchorInfoViewModel r2 = this.a;
        if (r2 == null) goto L12;
        LiveData<String> r3 = r2.getAnchorName();
        if (r3 == null) goto L12;
        r3.observe(this, new r(this));
    L12:
        MediaAnchorInfoViewModel r4 = this.a;
        if (r4 == null) goto L17;
        LiveData<py.k> r5 = r4.getVerifyInfo();
        if (r5 == null) goto L17;
        r5.observe(this, new s(this));
    L17:
        MediaAnchorInfoViewModel r6 = this.a;
        if (r6 == null) goto L28;
        Room r7 = this.b;
        if (r7 == null) goto L26;
        RoomPlatformComponentsData r8 = r7.roomPlatformComponentsData;
        if (r8 == null) goto L26;
        RoomAvator r9 = r8.getRoomAvator();
        if (r9 == null) goto L26;
        long r11 = r9.getFollowStatus();
    L27:
        r6.setFollowStatus(r11);
    L26:
        r11 = 0;
    L28:
        MediaAnchorInfoViewModel r12 = this.a;
        if (r12 == null) goto L35;
        int r13 = com.bytedance.android.live.room.api.follow.b.a;
        if (r12 == null) goto L33;
        Long r14 = Long.valueOf(r12.getFollowStatus());
    L34:
        r12.setFollowing(com.bytedance.android.live.room.api.follow.b.b(r14));
        goto L35
    L33:
        r14 = null;
    L35:
        Room r15 = this.b;
        if (r15 == null) goto L46;
        RoomPlatformComponentsData r16 = r15.roomPlatformComponentsData;
        if (r16 == null) goto L46;
        RoomAvator r17 = r16.getRoomAvator();
        if (r17 == null) goto L46;
        if (r17.getFollowReportScene() != RoomAvator.FollowReportScene.FollowReportSceneVS.getScene()) goto L46;
        MediaAnchorInfoViewModel r18 = this.a;
        if (r18 == null) goto L49;
        r18.setFollowExtraPramsMap(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.VS_USER_INFO));
    L49:
        MediaAnchorInfoViewModel r19 = this.a;
        if (r19 == null) goto L60;
        Room r21 = this.b;
        if (r21 == null) goto L58;
        RoomPlatformComponentsData r22 = r21.roomPlatformComponentsData;
        if (r22 == null) goto L58;
        RoomAvator r23 = r22.getRoomAvator();
        if (r23 == null) goto L58;
        boolean r24 = r23.getInvalidFollowStatus();
    L59:
        r19.setInvalidFollowStatus(r24);
    L58:
        r24 = false;
    L60:
        ((Widget) this).dataCenter.put("cmd_userinfo_widget_show", Boolean.TRUE);
        return;
    L46:
        MediaAnchorInfoViewModel r25 = this.a;
        if (r25 == null) goto L49;
        r25.setFollowExtraPramsMap(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.MEDIA_USER_INFO));
        goto L49
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsWidget
    public final void yq() {
        ((Widget) this).contentView.setBackgroundResource(2131248599);
        TextView r0 = this.e;
        if (r0 == null) goto L16;
        Room r2 = this.b;
        if (r2 == null) goto L9;
        LiveHotSpotInfo r3 = r2.getLiveHotSpotInfo();
        if (r3 == null) goto L9;
        String r4 = r3.title;
    L11:
        if (TextUtils.isEmpty(r4) == true) goto L14;
        float r5 = UtilityKotlinExtentionsKt.h(60.0f);
    L15:
        r0.setMaxWidth((int) r5);
        goto L16
    L14:
        r5 = UtilityKotlinExtentionsKt.h(90.0f);
    L9:
        r4 = null;
    L16:
        TextView r1 = this.e;
        if (r1 == null) goto L19;
        r1.setAlpha(1.0f);
    L19:
        TextView r6 = this.e;
        if (r6 == null) goto L22;
        r6.setTypeface(null, 1);
    L22:
        TextView r7 = this.h;
        if (r7 == null) goto L26;
        r7.setCompoundDrawables(null, null, null, null);
    L26:
        if (isScreenLandscape() == false) goto L31;
        SimpleDraweeView r8 = this.d;
        if (r8 == null) goto L32;
        r8.setVisibility(8);
        return;
    L32:
        return;
    }

    public MediaAnchorInfoWidget() {
        this.l = new CompositeDisposable();
        this.m = LazyKt.lazy(new MediaAnchorInfoWidget$mFollowAnimator$2(this));
        this.n = LazyKt.lazy(new MediaAnchorInfoWidget$normalBg$2(this));
        this.o = LazyKt.lazy(new MediaAnchorInfoWidget$successBg$2(this));
        this.p = LazyKt.lazy(new MediaAnchorInfoWidget$successLabel$2(this));
        this.v = LazyKt.lazy(MediaAnchorInfoWidget$mFollowAniPath$2.INSTANCE);
        this.w = new CompositeDisposable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        if (r3.l(((Widget) this).context) == false) goto L6;
        r3.p(this.c);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void Eq(MediaAnchorInfoWidget r14) {
        if (r14.isViewValid() == true) goto L6;
        return;
    L6:
        if (jc1.k.n(IUserService.class).user().isLogin() == true) goto L8;
        r14.r = true;
        com.bytedance.android.livesdk.user.f r0 = jc1.k.n(IUserService.class).user();
        Context r15 = ((Widget) r14).context;
        com.bytedance.android.livesdk.user.l.a r4 = new com.bytedance.android.livesdk.user.l.a();
        r4.a = CoreSettingUtil.getLoginPromptForFollow();
        r4.b = CoreSettingUtil.getLoginImageForFollow();
        r4.e = "live_detail";
        r4.g = "follow";
        r4.d = GamePromoteDataContext.LIVE;
        r4.c = 1;
        r0.login(r15, new com.bytedance.android.livesdk.user.l(r4)).subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    L8:
        Room r1 = r14.b;
        String r5 = null;
        if (r1 == null) goto L11;
        User r2 = r1.getOwner();
    L12:
        com.bytedance.android.livesdk.user.d.c r6 = new com.bytedance.android.livesdk.user.d.c();
        if (r2 == null) goto L15;
        String r7 = r2.getIdStr();
    L16:
        com.bytedance.android.livesdk.user.b.a r8 = r6.c(r7);
        Room r9 = r14.b;
        if (r9 == null) goto L19;
        r9.getRequestId();
    L19:
        com.bytedance.android.livesdk.user.d.c r11 = r8.e();
        r11.e();
        com.bytedance.android.livesdk.user.d.c r12 = r11.g(GamePromoteDataContext.LIVE);
        Room r13 = r14.b;
        if (r13 == null) goto L22;
        Long r16 = Long.valueOf(r13.id);
    L23:
        Intrinsics.checkNotNull(r16);
        com.bytedance.android.livesdk.user.d.c r17 = r12.h(r16.longValue());
        Room r18 = r14.b;
        if (r18 == null) goto L26;
        r18.getLabels();
    L26:
        r17.e();
        MediaAnchorInfoViewModel r19 = r14.a;
        if (r19 == null) goto L29;
        HashMap<String, String> r21 = r19.getFollowExtraPramsMap();
    L30:
        com.bytedance.android.livesdk.user.d.c r22 = r17.f(r21);
        r22.e();
        jc1.k.n(IUserService.class).user().e(new com.bytedance.android.livesdk.user.d(r22)).observeOn(AndroidSchedulers.mainThread()).compose(r14.getAutoUnbindTransformer()).subscribe(new b0(r14, r2));
        UIUtils.setViewVisibility(r14.h, 4);
        ProgressBar r23 = r14.i;
        if (r23 == null) goto L34;
        r23.setVisibility(0);
    L34:
        if (r14.isScreenPortrait() == true) goto L36;
    L75:
        HashMap r24 = new HashMap();     // Catch: Exception -> L74
        r24.put("growth_deepevent", String.valueOf(1));     // Catch: Exception -> L74
        Room r25 = r14.b;     // Catch: Exception -> L74
        if (r25 == null) goto L41;
        LiveMode r26 = r25.getStreamType();     // Catch: Exception -> L74
    L42:
        int r110 = h1.a;     // Catch: Exception -> L74
        r24.put("live_type", i1.a(r26));     // Catch: Exception -> L74
        boolean r27 = ((Boolean) com.bytedance.android.livesdk.sharedpref.b.V.getValue()).booleanValue();     // Catch: Exception -> L74
        String r111 = GamePromoteDataContext.GAME_TYPE_MOBILE;
        if (r27 == false) goto L46;
        Object r28 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L47:
        r24.put("is_screen_clear", r28);     // Catch: Exception -> L74
        r24.putAll(h1.a(r14.b));     // Catch: Exception -> L74
        AudienceGameContext.Companion.getClass();     // Catch: Exception -> L74
        AudienceGameContext r112 = AudienceGameContext.a.a();     // Catch: Exception -> L74
        if (r112 == null) goto L52;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.r> r113 = r112.getCurrentGame();     // Catch: Exception -> L74
        if (r113 == null) goto L52;
        com.bytedance.android.live.broadcastgame.api.model.r r114 = (com.bytedance.android.live.broadcastgame.api.model.r) r113.getValue();     // Catch: Exception -> L74
    L54:
        if (r114 == null) goto L56;
        Long r29 = Long.valueOf(r114.p());     // Catch: Exception -> L74
    L57:
        r24.put("game_id", String.valueOf(r29));     // Catch: Exception -> L74
        if (r114 == null) goto L60;
        String r115 = r114.q();     // Catch: Exception -> L74
    L61:
        r24.put("game_name", String.valueOf(r115));     // Catch: Exception -> L74
        RoomContext r31 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);     // Catch: Exception -> L74
        if (r31 == null) goto L68;
        com.bytedance.live.datacontext.m r32 = r31.isCleanMode();     // Catch: Exception -> L74
        if (r32 == null) goto L68;
        if (((Boolean) r32.getValue()).booleanValue() != true) goto L68;
    L69:
        r24.put("if_clear_mode", r111);     // Catch: Exception -> L74
        com.bytedance.android.livesdk.log.g r116 = com.bytedance.android.livesdk.log.u.l();     // Catch: Exception -> L74
        Object[] r117 = new Object[6];     // Catch: Exception -> L74
        r117[0] = am2.u.class;     // Catch: Exception -> L74
        if (r2 == null) goto L72;
        r5 = r2.getIdString();     // Catch: Exception -> L74
    L72:
        Intrinsics.checkNotNull(r5);     // Catch: Exception -> L74
        r117[1] = new FollowLog(GamePromoteDataContext.LIVE, r5, 1);     // Catch: Exception -> L74
        am2.x r3 = new am2.x();     // Catch: Exception -> L74
        r3.a = "live_interact";     // Catch: Exception -> L74
        r3.b = "live_detail";     // Catch: Exception -> L74
        r117[2] = r3;     // Catch: Exception -> L74
        r117[3] = Room.class;     // Catch: Exception -> L74
        r117[4] = am2.y.class;     // Catch: Exception -> L74
        r117[5] = am2.n.f();     // Catch: Exception -> L74
        r116.sendLog("livesdk_follow", r24, r117);     // Catch: Exception -> L74
        return;
    L68:
        r111 = "0";
        goto L69
    L60:
        r115 = null;
        goto L61
    L56:
        r29 = null;
    L52:
        r114 = null;
        goto L54
    L46:
        r28 = "0";
        goto L47
    L41:
        r26 = null;
    L80:
        return;
    L36:
        if (r14.s == true) goto L75;
        return;
    L29:
        r21 = null;
        goto L30
    L22:
        r16 = null;
        goto L23
    L15:
        r7 = null;
        goto L16
    L11:
        r2 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Gq(Room r12) {
        if (r12 != null) goto L5;
        return;
    L5:
        if (((Boolean) sr.a.getValue()).booleanValue() == false) goto L19;
        MediaAnchorInfoViewModel r0 = this.a;
        if (r0 == null) goto L9;
        boolean r3 = r0.isFollowing();
    L10:
        MediaAnchorInfoViewModel r1 = this.a;
        if (r1 == null) goto L13;
        boolean r4 = r1.isInvalidFollowStatus();
    L14:
        MediaAnchorInfoViewModel r2 = this.a;
        if (r2 == null) goto L17;
        long r5 = r2.getFollowStatus();
    L18:
        com.bytedance.android.live.room.api.follow.b.d(r3, r4, r5, r12.getOwner(), "MediaAnchor-handleChanged", r12, new MediaAnchorInfoWidget$handleFollowStatusChanged$1(this));
    L40:
        if (isScreenLandscape() == false) goto L45;
        SimpleDraweeView r13 = this.d;
        if (r13 == null) goto L46;
        r13.setVisibility(8);
        return;
    L46:
        return;
    L45:
        return;
    L17:
        r5 = 0;
        goto L18
    L13:
        r4 = false;
        goto L14
    L9:
        r3 = false;
        goto L10
    L19:
        View r14 = this.g;
        if (r14 == null) goto L29;
        MediaAnchorInfoViewModel r6 = this.a;
        if (r6 == null) goto L24;
        boolean r7 = r6.isFollowing();
    L25:
        if (r7 == false) goto L27;
        int r8 = 8;
    L28:
        r14.setVisibility(r8);
        goto L29
    L27:
        r8 = 0;
        goto L28
    L24:
        r7 = false;
    L29:
        View r15 = this.g;
        if (r15 == null) goto L32;
        r15.setVisibility(0);
    L32:
        MediaAnchorInfoViewModel r16 = this.a;
        if (r16 == null) goto L35;
        boolean r17 = r16.isFollowing();
    L36:
        if (r17 == false) goto L38;
        UIUtils.setViewVisibility(findViewById(2131387023), 0);
    L38:
        Lq();
        goto L40
    L35:
        r17 = false;
        goto L36
    }

    public final boolean canControlByPlayer(PlayerViewControl.KEY r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return !com.bytedance.android.live.core.utils.z.m(((Widget) this).dataCenter, true);
    }

    public final <T extends ViewModel> T create(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "modelClass");
        return new MediaAnchorInfoViewModel(((Widget) this).dataCenter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (isViewValid() == false) goto L40;
        if (r5 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r5.getKey()) == true) goto L51;
        String r0 = r5.getKey();
        int r1 = r0.hashCode();
        if (r1 == 256598095) goto L30;
        if (r1 == 506917167) goto L19;
        if (r1 == 560852175) goto L16;
        return;
    L16:
        if (r0.equals("data_union_room_change") == false) goto L42;
        Jq();
        return;
    L42:
        return;
    L19:
        if (r0.equals("data_login_event") == false) goto L44;
        k1 r6 = (k1) r5.getData();
        Intrinsics.checkNotNull(r6);
        if (r6.a == false) goto L45;
        com.bytedance.android.livesdk.user.f r7 = jc1.k.n(IUserService.class).user();
        Room r2 = this.b;
        if (r2 == null) goto L27;
        User r3 = r2.getOwner();
        if (r3 == null) goto L27;
        String r8 = r3.getIdStr();
    L28:
        ((SingleSubscribeProxy) r7.k(r8).observeOn(AndroidSchedulers.mainThread()).map(w.a).as(autoDispose())).subscribe(new x(this), y.a);
        return;
    L27:
        r8 = null;
        goto L28
    L45:
        return;
    L44:
        return;
    L30:
        if (r0.equals("cmd_update_live_hotspot_show") == true) goto L32;
        return;
    L32:
        if (Intrinsics.areEqual((Boolean) r5.getData(), Boolean.TRUE) == false) goto L36;
        TextView r9 = this.e;
        if (r9 == null) goto L48;
        r9.setMaxWidth((int) UIUtils.dip2Px(this.q, 60.0f));
        return;
    L48:
        return;
    L36:
        TextView r11 = this.e;
        if (r11 == null) goto L50;
        r11.setMaxWidth((int) UIUtils.dip2Px(this.q, 90.0f));
        return;
    L50:
        return;
    L51:
        return;
    }

    @Override // o70.a
    public void onEvent(o70.b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if ((r3 instanceof bh1.b) == false) goto L8;
        int r4 = ((bh1.b) r3).a;
        ConstraintLayout r0 = this.c;
        if (r0 == null) goto L18;
        r0.setTranslationY(r4);
        return;
    L18:
        return;
    L8:
        if ((r3 instanceof zg1.s) == false) goto L20;
        int r1 = 0;
        if (VrUtils.t(((Widget) this).dataCenter, false) == false) goto L21;
        View r2 = ((Widget) this).contentView;
        if (r2 != null) goto L14;
        return;
    L14:
        if (((zg1.s) r3).a == false) goto L16;
        r1 = 8;
    L16:
        r2.setVisibility(r1);
        return;
    L21:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsWidget
    public final void onInit(Object[] r2) {
        super.onInit(r2);
        this.d = (HSImageView) findViewById(2131362565);
        this.c = findViewById(2131389503);
        this.e = (TextView) findViewById(2131362587);
        this.f = (HSImageView) findViewById(2131362912);
        this.g = findViewById(2131373096);
        this.h = (TextView) findViewById(2131373079);
        this.i = (ProgressBar) findViewById(2131373102);
        FrameLayout r3 = (FrameLayout) findViewById(2131392940);
        this.k = r3;
        if (r3 == null) goto L5;
        r3.setVisibility(8);
    L5:
        View r4 = this.g;
        if (r4 == null) goto L8;
        UtilityKotlinExtentionsKt.w(r4);
    L8:
        TextView r5 = this.h;
        if (r5 == null) goto L11;
        r5.setOnClickListener(new b(this));
    L11:
        ImageView r6 = (ImageView) findViewById(2131373105);
        this.j = r6;
        if (r6 == null) goto L14;
        r6.setOnClickListener(new c(this));
    L14:
        View r7 = ((Widget) this).contentView;
        if (r7 == null) goto L18;
        r7.setOnClickListener(new d(this));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsWidget
    public final void onLoad(Object[] r5) {
        if (isScreenLandscape() == false) goto L7;
        int r0 = com.bytedance.android.live.room.utils.c.a;
        if (com.bytedance.android.live.room.utils.c.b(this.b) == false) goto L7;
        UtilityKotlinExtentionsKt.t(((Widget) this).containerView);
    L8:
        FragmentActivity r1 = ((Widget) this).context;
        if (r1 == null) goto L37;
        this.q = r1;
        TextView r2 = this.h;
        int r3 = 0;
        if (r2 == null) goto L13;
        r2.setVisibility(0);
    L13:
        this.u = yt0.c.c();
        String r4 = (String) ((Widget) this).dataCenter.get("log_enter_live_source", "");
        ((Widget) this).contentView.setBackgroundResource(2131248599);
        ((Widget) this).contentView.setPadding(0, 0, 0, 0);
        UIUtils.setLayoutParams(this.d, UtilityKotlinExtentionsKt.i(18), UtilityKotlinExtentionsKt.i(18));
        Jq();
        View r6 = this.g;     // Catch: Exception -> L21
        if (r6 == null) goto L17;
        r6.setBackgroundResource(0);     // Catch: Exception -> L21
    L17:
        ((ImageView) findViewById(2131380979)).setAlpha(1.0f);     // Catch: Exception -> L21
        ((ImageView) findViewById(2131373108)).setAlpha(0.0f);     // Catch: Exception -> L21
        ((ImageView) findViewById(2131380979)).setImageDrawable(s1.m(2131249418));     // Catch: Exception -> L21
        TextView r7 = this.h;     // Catch: Exception -> L21
        if (r7 == null) goto L23;
        r7.setTextColor(s1.h(2131109391));     // Catch: Exception -> L21
    L23:
        super.onLoad(r5);
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r8 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.a;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.h = ((Widget) this).containerView;
        SimpleDraweeView r9 = this.d;
        if (r9 != null) goto L26;
    L29:
        FrameLayout r11 = this.k;
        if (r11 == null) goto L34;
        com.bytedance.android.live.profit.fansclub.o r12 = this.u;
        if (r12 == null) goto L34;
        com.bytedance.android.live.profit.fansclub.o.a.a(r12, ((Widget) this).context, ((Widget) this).dataCenter, r11);
    L34:
        Lq();
        return;
    L26:
        if (isScreenLandscape() == false) goto L28;
        r3 = 8;
    L28:
        r9.setVisibility(r3);
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L37:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L7:
        UtilityKotlinExtentionsKt.w(((Widget) this).containerView);
        goto L8
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsWidget
    public final MediaAnchorInfoViewModel zq(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "cxt");
        return getViewModel(MediaAnchorInfoViewModel.class, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void Cq(MediaAnchorInfoWidget r4, FollowPair r5) {
        if (r4.isViewValid() == false) goto L65;
        if (r5 == null) goto L32;
        Room r0 = r4.b;
        if (r0 == null) goto L11;
        User r1 = r0.getOwner();
        if (r1 == null) goto L11;
        r1.setFollowStatus(r5.getFollowStatus());
    L11:
        Room r2 = r4.b;
        if (r2 == null) goto L18;
        RoomPlatformComponentsData r3 = r2.roomPlatformComponentsData;
        if (r3 == null) goto L18;
        RoomAvator r6 = r3.getRoomAvator();
        if (r6 == null) goto L18;
        r6.setFollowStatus(r5.getFollowStatus());
    L18:
        MediaAnchorInfoViewModel r7 = r4.a;
        if (r7 == null) goto L29;
        Room r8 = r4.b;
        if (r8 == null) goto L27;
        RoomPlatformComponentsData r9 = r8.roomPlatformComponentsData;
        if (r9 == null) goto L27;
        RoomAvator r11 = r9.getRoomAvator();
        if (r11 == null) goto L27;
        long r12 = r11.getFollowStatus();
    L28:
        r7.setFollowStatus(r12);
    L27:
        r12 = 0;
    L29:
        MediaAnchorInfoViewModel r13 = r4.a;
        if (r13 == null) goto L32;
        int r14 = com.bytedance.android.live.room.api.follow.b.a;
        r13.setFollowing(com.bytedance.android.live.room.api.follow.b.b(Long.valueOf(r13.getFollowStatus())));
    L32:
        DataCenter r15 = ((Widget) r4).dataCenter;
        if (r5 != null) goto L35;
    L38:
        boolean r16 = true;
    L39:
        r15.put("data_is_followed", Boolean.valueOf(r16));
        if (r5 != null) goto L42;
    L61:
        r4.Kq();
        return;
    L42:
        if (r5.getFollowStatus() != 0) goto L61;
        ((ImageView) r4.findViewById(2131380979)).setAlpha(1.0f);
        ((ImageView) r4.findViewById(2131373108)).setAlpha(0.0f);
        ((TextView) r4.findViewById(2131373107)).setVisibility(8);
        TextView r17 = r4.h;
        if (r17 == null) goto L47;
        r17.setVisibility(0);
    L47:
        if (r4.isScreenLandscape() == false) goto L51;
        SimpleDraweeView r18 = r4.d;
        if (r18 == null) goto L51;
        r18.setVisibility(8);
    L51:
        FrameLayout r19 = r4.k;
        if (r19 != null) goto L54;
    L58:
        View r21 = r4.g;
        if (r21 == null) goto L63;
        UtilityKotlinExtentionsKt.w(r21);
        return;
    L63:
        return;
    L54:
        if (r19.getVisibility() != 0) goto L58;
        FrameLayout r22 = r4.k;
        if (r22 == null) goto L58;
        UtilityKotlinExtentionsKt.t(r22);
        goto L58
    L35:
        if (r5.getFollowStatus() != 0) goto L38;
        r16 = false;
        goto L39
    }
}
