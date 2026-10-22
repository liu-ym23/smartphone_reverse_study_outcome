package com.bytedance.android.livesdk.interactivity.notifications;

import am2.x;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.fresco.TagCompat;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.live.room.api.experience.utils.PlatformExpUtils;
import com.bytedance.android.live.uikit.rtl.AutoRTLImageView;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdk.chatroom.bl.PlatformMessageHelper;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.android.livesdk.config.PerformanceTestSettings;
import com.bytedance.android.livesdk.config.fz;
import com.bytedance.android.livesdk.config.id0;
import com.bytedance.android.livesdk.config.xo0;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.VSBarrageSetting;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.RoomNotifyMessageExtra;
import com.bytedance.android.livesdk.message.model.ik;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherWrapperEvent;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import i92.g;
import i92.n;
import i92.o;
import i92.p;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import j92.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import jc1.k;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import vlc.d;
import vlc.l;
import w50.h;
import zg1.e3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class LiveRoomNotifyWidget extends LiveRecyclableWidget implements WeakHandler.IHandler, Observer<KVData>, l {
    public View a;
    public AutoRTLImageView b;
    public TextView c;
    public Room d;
    public WeakHandler e;
    public int f;
    public AnimatorSet g;
    public AnimatorSet h;
    public AnimatorSet i;
    public boolean j;
    public CompositeDisposable k;
    public long l;
    public int m;
    public View n;
    public c o;
    public View p;
    public int q;
    public final ArrayList<ik> r;
    public Boolean s;
    public Boolean t;
    public Boolean u;
    public Disposable v;
    public Boolean w;
    public final boolean x;
    public d y;

    public class a implements a3.b {
        public final /* synthetic */ LiveRoomNotifyWidget a;

        public final void onFail() {
            LiveRoomNotifyWidget r0 = this.a;
            r0.s = Boolean.TRUE;
            AutoRTLImageView r1 = r0.b;
            final PlatformMessageHelper r2 = PlatformMessageHelper.INSTANCE;
            Objects.requireNonNull(r2);
            r1.post(new o(r2));
        }

        public a(LiveRoomNotifyWidget r1) {
            this.a = r1;
        }

        public final void a(NinePatchDrawable r2) {
            LiveRoomNotifyWidget r3 = this.a;
            if (r3.j == false) goto L5;
        L7:
            this.a.b.post(new n(this));
            return;
        L5:
            if (RTLUtil.isAppRTL(((Widget) r3).context) == false) goto L7;
            this.a.b.setRotationY(180.0f);
            goto L7
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MessageType.values().length];
            a = r0;
            r0[MessageType.ROOM_NOTIFY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    public class c implements View.OnTouchListener {
        public int a;
        public int b;
        public int c;
        public int d;
        public float e;
        public boolean f;
        public VelocityTracker g;
        public boolean h;
        public final int[] i;
        public int j;
        public int k;
        public ValueAnimator l;
        public ValueAnimator m;
        public final /* synthetic */ LiveRoomNotifyWidget n;

        public c(LiveRoomNotifyWidget r1) {
            this.n = r1;
            this.i = new int[2];
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r9, MotionEvent r10) {
            int r11 = (int) r10.getRawX();
            int r0 = (int) r10.getRawY();
            int r1 = r10.getAction();
            if (r1 == 0) goto L49;
            if (r1 == 1) goto L24;
            if (r1 != 2) goto L7;
            int r13 = r11 - this.c;
            int r2 = r0 - this.d;
            ViewGroup.LayoutParams r3 = ((Widget) this.n).containerView.getLayoutParams();
            if ((r3 instanceof RelativeLayout.LayoutParams) == false) goto L17;
            RelativeLayout.LayoutParams r4 = (RelativeLayout.LayoutParams) r3;
            int r5 = r4.topMargin + r2;
            LiveRoomNotifyWidget r6 = this.n;
            int r7 = r6.m;
            if (r5 <= r7) goto L16;
            r5 = r7;
        L16:
            r4.topMargin = r5;
            ((Widget) r6).containerView.setLayoutParams(r4);
        L17:
            int r14 = Math.abs(r13);
            int r8 = Math.abs(r2);
            float r15 = r14;
            float r16 = this.e;
            if (r15 <= r16) goto L20;
        L21:
            this.f = false;
        L22:
            this.c = r11;
            this.d = r0;
        L60:
            return true;
        L20:
            if (r8 <= r16) goto L22;
        L7:
            if (r1 == 3) goto L24;
            View r17 = this.n.n;
            if (r17 == null) goto L60;
            r17.setEnabled(true);
        L24:
            if (this.g != null) goto L26;
            this.g = VelocityTracker.obtain();
        L26:
            this.g.addMovement(r10);
            VelocityTracker r18 = this.g;
            r18.computeCurrentVelocity(IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
            float r19 = r18.getYVelocity();
            ((Widget) this.n).containerView.getLocationOnScreen(this.i);
            if (r19 <= 1000.0f) goto L29;
        L32:
            boolean r110 = true;
        L33:
            this.h = r110;
            if (r110 == false) goto L36;
        L42:
            View r20 = this.n.n;
            if (r20 == null) goto L46;
            r20.setEnabled(true);
        L46:
            if (this.h == false) goto L48;
            ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) ((Widget) this.n).containerView.getLayoutParams();
            ValueAnimator r111 = ValueAnimator.ofInt(new int[]{r21.topMargin, this.k});
            this.l = r111;
            r111.setDuration(400);
            this.l.setInterpolator(new DecelerateInterpolator());
            this.l.addListener(new com.bytedance.android.livesdk.interactivity.notifications.a(this));
            this.l.addUpdateListener(new com.bytedance.android.livesdk.interactivity.notifications.b(this, r21));
            this.l.start();
            goto L60
        L48:
            ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) ((Widget) this.n).containerView.getLayoutParams();
            ValueAnimator r112 = ValueAnimator.ofInt(new int[]{r23.topMargin, this.n.m});
            this.m = r112;
            r112.addUpdateListener(new com.bytedance.android.livesdk.interactivity.notifications.c(this, r23));
            this.m.setInterpolator(new DecelerateInterpolator());
            this.m.setDuration(400);
            this.m.start();
            goto L60
        L36:
            if (this.f == false) goto L42;
            if (Math.abs(r11 - this.a) >= this.e) goto L42;
            if (Math.abs(r0 - this.b) >= this.e) goto L42;
            this.n.a.performClick();
            goto L42
        L29:
            if (this.j > this.i[1]) goto L32;
            r110 = false;
            goto L33
        L49:
            View r113 = this.n.n;
            if (r113 == null) goto L52;
            r113.setEnabled(false);
        L52:
            this.h = false;
            this.a = r11;
            this.b = r0;
            this.c = r11;
            this.d = r0;
            if (this.n.getContext() == null) goto L55;
            float r24 = ViewConfiguration.get(this.n.getContext()).getScaledTouchSlop();
        L56:
            this.e = r24;
            this.f = true;
            if (this.j > 0) goto L60;
            int[] r25 = new int[2];
            ((Widget) this.n).containerView.getLocationOnScreen(r25);
            int r26 = r25[1];
            this.j = r26 >> 1;
            LiveRoomNotifyWidget r114 = this.n;
            this.k = ((r114.m - r26) - ((Widget) r114).containerView.getHeight()) - 5;
            goto L60
        L55:
            r24 = 0.0f;
            goto L56
        }
    }

    public final int getLayoutId() {
        return 2131566979;
    }

    public final String getSpm() {
        return "a100.a100.a128";
    }

    public final void handleMsg(Message r1) {
    }

    public final int supportClearScene() {
        return 256;
    }

    public final void onUnload() {
        if (e.a.booleanValue() == true) goto L5;
    L26:
        ((Widget) this).contentView.setVisibility(8);
        this.e.removeCallbacksAndMessages(null);
        this.r.clear();
        this.g.cancel();
        this.h.cancel();
        this.i.cancel();
        CompositeDisposable r0 = this.k;
        if (r0 == null) goto L29;
        r0.dispose();
    L29:
        c r1 = this.o;
        if (r1 == null) goto L37;
        ValueAnimator r2 = r1.m;
        if (r2 == null) goto L34;
        r2.cancel();
    L34:
        ValueAnimator r3 = r1.l;
        if (r3 == null) goto L37;
        r3.cancel();
    L37:
        d r4 = this.y;
        if (r4 == null) goto L40;
        r4.removeMessageListener(this);
    L40:
        Disposable r5 = this.v;
        if (r5 == null) goto L44;
        r5.dispose();
        return;
    L44:
        return;
    L5:
        if (e.b <= 0) goto L25;
        HashMap r6 = new HashMap();
        r6.put("show_msg_cnt", String.valueOf(e.b));
        r6.put("show_msg_cost", String.valueOf(e.c / e.b));
        IUserService r7 = k.f(IUserService.class);
        String r8 = "0";
        if (r7 == null) goto L13;
        f r9 = r7.user();
        if (r9 == null) goto L13;
        String r10 = r9.n();
        if (r10 == null) goto L13;
    L14:
        r6.put("user_id", r10);
        RoomContext r11 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r11 == null) goto L24;
        m r13 = r11.getRoom();
        if (r13 == null) goto L24;
        Room r14 = (Room) r13.getValue();
        if (r14 == null) goto L24;
        String r15 = String.valueOf(r14.getRoomId());
        if (r15 == null) goto L24;
        r8 = r15;
    L24:
        r6.put("room_id", r8);
        u.l().sendLog("ttlive_global_msg_performance", r6, new Object[0]);
    L13:
        r10 = "0";
    L25:
        e.c = 0;
        e.b = 0;
        goto L26
    }

    public LiveRoomNotifyWidget() {
        this.l = 2000;
        this.m = 0;
        this.q = 4;
        this.r = new ArrayList();
        this.s = Boolean.TRUE;
        Boolean r0 = Boolean.FALSE;
        this.t = r0;
        this.u = r0;
        this.v = null;
        this.w = r0;
        this.x = true;
        this.y = null;
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        this.t = Boolean.TRUE;
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        this.t = Boolean.FALSE;
    }

    public static void yq(String r3) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("reason", "unrecognised schema");     // Catch: JSONException -> L4
        r0.put("schema", r3);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        ALogger.e("LiveRoomNotifyWidget", e);
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (r6 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r6.getKey()) == false) goto L7;
        return;
    L7:
        if (r6.getData() == null) goto L29;
        String r0 = r6.getKey();
        r0.getClass();
        int r2 = 0;
        if (r0.equals("cmd_live_clear_screen_notify") == true) goto L19;
        if (r0.equals("data_keyboard_status_douyin") == false) goto L30;
        boolean r7 = ((Boolean) r6.getData()).booleanValue();
        ViewGroup r1 = ((Widget) this).containerView;
        if (r7 == false) goto L17;
        r2 = 4;
    L17:
        UIUtils.setViewVisibility(r1, r2);
        return;
    L30:
        return;
    L19:
        if ((r6.getData() instanceof Boolean) == false) goto L31;
        ViewGroup r3 = ((Widget) this).containerView;
        if (((Boolean) r6.getData()).booleanValue() == false) goto L24;
        r2 = 4;
    L24:
        UIUtils.setViewVisibility(r3, r2);
        return;
    L31:
        return;
    }

    public final void onEnterClear(int r2) {
        if (r2 != 256) goto L6;
        this.u = Boolean.TRUE;
        return;
    }

    public final void onExitClear(int r2) {
        if (r2 != 256) goto L6;
        this.u = Boolean.FALSE;
        return;
    }

    public final void onInit(Object... r11) {
        this.j = "huawei&honor".contains(Build.BRAND.toLowerCase(Locale.getDefault()));
        View r13 = ((Widget) this).contentView;
        this.a = r13;
        this.b = r13.findViewById(2131363806);
        this.c = (TextView) ((Widget) this).contentView.findViewById(2131381061);
        this.p = ((Widget) this).contentView.findViewById(2131384540);
        if (RTLUtil.isAppRTL(((Widget) this).context) == false) goto L8;
        if (this.j == false) goto L8;
        TextView r14 = (TextView) ((Widget) this).contentView.findViewById(2131381062);
        this.c = r14;
        r14.setGravity(8388613);
    L10:
        this.f = UIUtils.getScreenWidth(((Widget) this).context);
        this.e = new WeakHandler(this);
        if (RTLUtil.isAppRTL(((Widget) this).context) == true) goto L13;
    L15:
        ObjectAnimator r15 = ObjectAnimator.ofFloat(this.a, "translationX", new float[]{this.f, -12.0f});
    L16:
        r15.setInterpolator(PathInterpolatorCompat.create(0.01f, 0.34f, 0.07f, 1.12f));
        r15.setDuration(1500);
        if (RTLUtil.isAppRTL(((Widget) this).context) == true) goto L19;
    L21:
        ObjectAnimator r8 = ObjectAnimator.ofFloat(this.a, "translationX", new float[]{-12.0f, 0.0f});
    L22:
        r8.setInterpolator(PathInterpolatorCompat.create(0.01f, 0.34f, 0.07f, 1.12f));
        r8.setDuration(200);
        if (RTLUtil.isAppRTL(((Widget) this).context) == true) goto L25;
    L27:
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this.a, "translationX", new float[]{0.0f, -this.f});
    L28:
        r0.setInterpolator(PathInterpolatorCompat.create(0.4f, 0.0f, 0.68f, 0.06f));
        r0.setDuration(1000);
        this.g = new AnimatorSet();
        this.i = new AnimatorSet();
        this.h = new AnimatorSet();
        this.g.playSequentially(new Animator[]{r15});
        this.i.playSequentially(new Animator[]{r8});
        this.h.playSequentially(new Animator[]{r0});
        this.g.addListener(new i92.l(this));
        this.h.addListener(new i92.m(this));
        return;
    L25:
        if (this.j == true) goto L27;
        r0 = ObjectAnimator.ofFloat(this.a, "translationX", new float[]{0.0f, this.f});
        goto L28
    L19:
        if (this.j == true) goto L21;
        r8 = ObjectAnimator.ofFloat(this.a, "translationX", new float[]{12.0f, 0.0f});
        goto L22
    L13:
        if (this.j == true) goto L15;
        r15 = ObjectAnimator.ofFloat(this.a, "translationX", new float[]{-this.f, 12.0f});
    L8:
        if (RTLUtil.isAppRTL(((Widget) this).context) == true) goto L10;
        this.c.setTextDirection(3);
        goto L10
    }

    public final void onLoad(Object... r9) {
        if (((Boolean) PerformanceTestSettings.TEST_DISABLE_NOTIFY.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        boolean r0 = false;
        if (e.a.booleanValue() == false) goto L8;
        e.c = 0;
        e.b = 0;
    L8:
        this.d = (Room) ((Widget) this).dataCenter.get("data_room");
        ((Widget) this).dataCenter.observeForever("data_keyboard_status_douyin", this);
        ((Widget) this).dataCenter.observeForever("cmd_live_clear_screen_notify", this);
        Boolean r10 = (Boolean) ((Widget) this).dataCenter.get("data_is_portrait");
        if (r10 == null) goto L14;
        if (r10.booleanValue() == true) goto L14;
        ViewGroup.LayoutParams r11 = this.a.getLayoutParams();
        r11.width = s1.f(400.0f);
        this.a.setLayoutParams(r11);
    L14:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L24;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L24;
        boolean r13 = ((Boolean) ((Widget) this).dataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        if (((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L26;
        if (r13 == true) goto L21;
        Context r14 = ((Widget) this).context;
        this.q = UIUtils.px2dip(r14, StatusBarUtil.getStatusBarHeight(r14)) + 47;
    L22:
        UIUtils.updateLayoutMargin(((Widget) this).containerView, -3, (int) UIUtils.dip2Px(((Widget) this).context, this.q), -3, -3);
        goto L26
    L21:
        this.q = 47;
    L26:
        CompositeDisposable r15 = new CompositeDisposable();
        this.k = r15;
        r15.add(xs2.b.a().b(JumpToOtherWrapperEvent.class).subscribe(new p(this)));
        if (isScreenPortrait() == true) goto L35;
        if (((Boolean) id0.a.getValue()).booleanValue() == false) goto L31;
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        ALogger.e("ImmersiveStatusBarMgr", "Config not initialized, returning default false");
    L31:
        this.q = 32;
        ViewGroup.LayoutParams r16 = this.a.getLayoutParams();
        if ((r16 instanceof FrameLayout.LayoutParams) == false) goto L42;
        FrameLayout.LayoutParams r17 = (FrameLayout.LayoutParams) r16;
        r17.gravity = 8388611;
        r17.leftMargin = s1.f(14.0f);
        r17.rightMargin = s1.f(14.0f);
    L42:
        Activity r18 = ContextUtil.contextToActivity(getContext());
        if (r18 == null) goto L45;
        this.n = r18.findViewById(2131392622);
    L45:
        View r19 = ((Widget) this).contentView;
        c r2 = new c(this);
        this.o = r2;
        r19.setOnTouchListener(r2);
        this.a.setOnTouchListener(this.o);
        this.c.setOnTouchListener(this.o);
        UIUtils.updateLayout(((Widget) this).containerView, -3, (int) UIUtils.dip2Px(((Widget) this).context, 36.0f));
        UIUtils.updateLayoutMargin(((Widget) this).containerView, -3, (int) UIUtils.dip2Px(((Widget) this).context, this.q), -3, -3);
        UIUtils.updateLayoutMargin(this.c, -3, -3, (int) UIUtils.dip2Px(((Widget) this).context, 20.0f), -3);
        if ((((Widget) this).containerView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L48;
        this.m = ((ViewGroup.MarginLayoutParams) ((Widget) this).containerView.getLayoutParams()).topMargin;
    L48:
        DataCenter r20 = ((Widget) this).dataCenter;
        if (r20 == null) goto L59;
        Room r21 = (Room) r20.get("data_room");
        if (r21 == null) goto L59;
        if (r21.isKoiRoom() == false) goto L59;
        this.q = 47;
        UIUtils.updateLayoutMargin(((Widget) this).containerView, -3, (int) UIUtils.dip2Px(((Widget) this).context, 47), -3, -3);
        ViewGroup r23 = ((Widget) this).containerView;
        if (r23 == null) goto L59;
        if ((r23.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L59;
        this.m = ((ViewGroup.MarginLayoutParams) ((Widget) this).containerView.getLayoutParams()).topMargin;
    L59:
        ((ObservableSubscribeProxy) xs2.b.a().b(e3.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new i92.b(this));
        d r24 = (d) ((Widget) this).dataCenter.get("data_message_manager", null);
        this.y = r24;
        if (r24 == null) goto L62;
        r24.addMessageListener(MessageType.ROOM_NOTIFY.getIntType(), this);
    L62:
        int r25 = j92.d.a;
        if ((System.currentTimeMillis() - ((Long) com.bytedance.android.livesdk.sharedpref.b.I.getValue()).longValue()) <= (((Number) fz.a.getValue()).longValue() * ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW))) goto L65;
        r0 = true;
    L65:
        if (r0 == false) goto L72;
        HashMap r1 = new HashMap();
        IUser r3 = k.n(IUserService.class).user().b();
        r1.put("target_uid", r3.getIdString());
        r1.put("user_open_id", r3.getIdString());
        r1.put("packed_level", String.valueOf(2));
        r1.put("request_from", "gift_effect_config");
        Intrinsics.checkNotNullParameter(r3, "$this$secUidExt");
        String r4 = r3.getCastSecUid();
        if (r4 != null) goto L70;
        r4 = BuildConfig.FLAVOR;
    L70:
        r1.put("sec_target_uid", r4);
        k.n(IUserService.class).user().d(r1).observeOn(AndroidSchedulers.mainThread()).subscribe(j92.b.a, j92.c.a);
    L72:
        if (((Boolean) xo0.a.getValue()).booleanValue() == true) goto L74;
    L79:
        Disposable r26 = this.v;
        if (r26 == null) goto L82;
        r26.dispose();
    L82:
        this.v = k.f(ILiveExpOptService.class).registerExpBizListener(l61.d.a.w.e, new g(this));
        return;
    L74:
        if ((this.a.getParent() instanceof ViewGroup) == false) goto L79;
        ViewGroup r5 = (ViewGroup) this.a.getParent();
        if (r5.getClipChildren() == true) goto L78;
        r5.setClipChildren(true);
    L78:
        ALogger.d("dirtyRegionOpt", "live room notify clipChildren");
        goto L79
    L35:
        if (j92.a.a(((Widget) this).dataCenter) == false) goto L42;
        if (((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L42;
        if (((Boolean) id0.a.getValue()).booleanValue() == false) goto L41;
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        ALogger.e("ImmersiveStatusBarMgr", "Config not initialized, returning default false");
    L41:
        this.q = 47;
    L24:
        if (((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L26;
        this.q = 47;
        UIUtils.updateLayoutMargin(((Widget) this).containerView, -3, (int) UIUtils.dip2Px(((Widget) this).context, 47), -3, -3);
        goto L26
    }

    public final void onMessage(tlc.d r9) {
        if ((r9 instanceof o0) == false) goto L67;
        boolean r1 = true;
        if (b.a[((o0) r9).getMessageType().ordinal()] != 1) goto L68;
        ik r10 = (ik) r9;
        if (((Boolean) PerformanceTestSettings.TEST_DISABLE_NOTIFY.getValue()).booleanValue() == false) goto L11;
        return;
    L11:
        if (this.w.booleanValue() == false) goto L57;
        Lazy r0 = PlatformExpUtils.a;
        Intrinsics.checkNotNullParameter(r10, "msg");
        IMiddlewareUserService r2 = k.f(IMiddlewareUserService.class);
        String r3 = null;
        if (r2 == null) goto L17;
        com.bytedance.android.livesdk.user.e r4 = r2.user();
        if (r4 == null) goto L17;
        String r5 = r4.n();
    L19:
        if (r5 == null) goto L53;
        m0 r6 = r10.getBaseMessage();
        if (r6 == null) goto L53;
        a5 r7 = r6.getDisplayText();
        if (r7 == null) goto L53;
        List r8 = r7.getPieces();
        if (r8 == null) goto L53;
        ArrayList r11 = new ArrayList();
        Iterator r13 = r8.iterator();
    L28:
        if (r13.hasNext() == false) goto L35;
        Object r14 = r13.next();
        if (((c5) r14).getType() != PieceType.USER.getPieceType()) goto L32;
        boolean r15 = true;
    L33:
        if (r15 == false) goto L28;
        r11.add(r14);
        goto L28
    L32:
        r15 = false;
        goto L33
    L35:
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r17 = r11.iterator();
    L37:
        if (r17.hasNext() == false) goto L45;
        i5 r18 = ((c5) r17.next()).getUserValue();
        if (r18 == null) goto L43;
        IBaseUser r19 = r18.getUser();
        if (r19 == null) goto L43;
        String r20 = r19.getIdString();
    L44:
        r16.add(r20);
    L43:
        r20 = null;
        goto L44
    L45:
        IMiddlewareUserService r21 = k.f(IMiddlewareUserService.class);
        if (r21 == null) goto L51;
        com.bytedance.android.livesdk.user.e r23 = r21.user();
        if (r23 == null) goto L51;
        r3 = r23.n();
    L51:
        if (r16.contains(r3) != true) goto L53;
    L54:
        ALogger.d("LiveRoomNotify", "filter notify msg , the msg is related with us:" + r1);
        if (r1 == true) goto L57;
        return;
    L53:
        r1 = false;
    L17:
        r5 = null;
    L57:
        Aq(r10, Boolean.FALSE);
        return;
    L68:
        return;
    }

    public final void wq(final ik r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.getSchema() == null) goto L13;
        Runnable r0 = new i92.c(this, r8);
        Boolean r9 = e.a;
        Intrinsics.checkNotNullParameter(r0, "action");
        if (e.a.booleanValue() == true) goto L9;
        r0.run();
        return;
    L9:
        long r1 = System.nanoTime();
        r0.run();
        e.c += System.nanoTime() - r1;
        e.b++;
        return;
    }

    public final void Aq(ik r7, Boolean r8) {
        if (isViewValid() == false) goto L108;
        if (r7 == null) goto L108;
        if (this.u.booleanValue() == true) goto L108;
        VSDataContext r0 = VSDataContext.getInteractionContext(((Widget) this).dataCenter);
        if (r0 != null) goto L11;
    L13:
        boolean r1 = ((BarrageSetting) l42.a.d.getValue()).isGiftOpen();
    L14:
        if (r1 == true) goto L23;
        if (isScreenPortrait() == true) goto L23;
        if (r7.H() != 1) goto L20;
        return;
    L20:
        if (r7.H() != 11) goto L23;
        return;
    L23:
        if (this.s.booleanValue() == true) goto L29;
        if (r8.booleanValue() == true) goto L29;
        this.r.add(r7);
        return;
    L29:
        if (this.t.booleanValue() == false) goto L33;
        this.r.add(r7);
        return;
    L33:
        if ("subscribe_anchor_mvp".equals(r7.getScene()) == false) goto L35;
        return;
    L35:
        Boolean r9 = Boolean.FALSE;
        this.s = r9;
        if (r7.getSchema() != null) goto L38;
    L46:
        UIUtils.setViewVisibility(this.p, 8);
        this.p.setVisibility(8);
    L47:
        this.a.setVisibility(0);
        this.a.setTranslationX(this.f);
        this.c.setScrollX(0);
        xq(r7, "show");
        if (r7.E() == null) goto L62;
        if (r7.E().c() == null) goto L62;
        if (r7.E().c().isEmpty() == true) goto L62;
        Map r2 = r7.E().c();
        if (TextUtils.equals((CharSequence) r2.get("gift_role_is_character"), "1") == false) goto L62;
        if (((Boolean) ((Widget) this).dataCenter.get("data_is_anchor", r9)).booleanValue() == false) goto L62;
        HashMap r10 = new HashMap();
        r10.put("is_anchor", "1");
        r10.putAll(r2);
        u.l().sendLog("livesdk_gift_role_skill_effect_show", r10, new Object[]{new x(), Room.class});
    L62:
        if (r7.supportDisplayText() == false) goto L89;
        Text r11 = r7.getBaseMessage().getDisplayText();
        List r3 = r11.getPieces();
        if (CollectionUtils.isEmpty(r3) == true) goto L75;
        Iterator r4 = r3.iterator();
    L67:
        if (r4.hasNext() == false) goto L75;
        c5 r5 = (c5) r4.next();
        if (r5.getUserValue() == null) goto L67;
        if (r5.getUserValue().getUser() == null) goto L67;
        if ((r5.getUserValue().getUser() instanceof User) == false) goto L67;
        r5.getUserValue().getUser().setShouldUseRealName(true);
    L75:
        String r6 = r11.getDefaultPattern();
        if (TextUtils.isEmpty(r11.getKey()) == true) goto L82;
        String r13 = com.bytedance.android.live.core.i18n.a.b().a(r11.getKey());
        if (TextUtils.isEmpty(r6) == false) goto L84;
        if (TextUtils.isEmpty(r13) == true) goto L84;
        h.a().b(r11.getKey(), r13, BuildConfig.FLAVOR);
    L84:
        if (TextUtils.isEmpty(r13) == true) goto L87;
        r6 = r13;
    L87:
        this.c.setText(sb2.a.i(r6, r11));
    L94:
        if (r7.E() == null) goto L102;
        if (r7.E().a() == null) goto L102;
        if (Lists.isEmpty(r7.E().a().getUrls()) == true) goto L102;
        this.b.setBackgroundResource(0);
        TagCompat.setTag(this.b, String.valueOf(2131363806), r7);
        int r14 = a3.d;
        a3.a.a(this.b, r7.E().a(), new a(this), 0.0f);
        return;
    L102:
        if (((o0) r7).isLocalInsertMsg2 == false) goto L106;
        int r15 = r7.a;
        if (r15 == 0) goto L106;
        this.b.setBackgroundResource(r15);
    L106:
        TagCompat.setTag(this.b, String.valueOf(2131363806), r7);
        this.b.post(new i92.a(this));
        return;
    L82:
        r13 = null;
        goto L84
    L89:
        if (r7.E() == null) goto L94;
        if (r7.E().highlightInfo == null) goto L94;
        this.c.setText(r7.E().highlightInfo.a());
        goto L94
    L38:
        if (r7.getSchema().isEmpty() == true) goto L46;
        if (TextUtils.isEmpty(r7.getSchema()) == true) goto L46;
        if (r7.getSchema().equals("sslocal://webcast_room") == false) goto L45;
        UIUtils.setViewVisibility(this.p, 8);
        goto L47
    L45:
        UIUtils.setViewVisibility(this.p, 0);
        this.p.setVisibility(0);
        goto L47
    L11:
        if (r0.isVSRoom() == false) goto L13;
        r1 = ((VSBarrageSetting) l42.a.e.getValue()).isGiftOpen();
    L108:
        PlatformMessageHelper.INSTANCE.onMessageFinish();
    }

    public final void xq(ik r9, String r10) {
        HashMap r2 = new HashMap(7);
        Room r3 = this.d;
        if (r3 == null) goto L6;
        r2.put("room_id", r3.getIdStr());
        r2.put("anchor_id", this.d.getOwnerUserIdString());
    L6:
        if (r9 == null) goto L72;
        int r7 = (int) r9.H();
        if (r7 == 1) goto L41;
        if (r7 != 2) goto L11;
        String r6 = "upgrade";
    L42:
        r2.put("message_type", r6);
        r2.put("action_type", r10);
        if (((Boolean) ((Widget) this).dataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L45;
        String r11 = "anchor";
    L51:
        r2.put("user_type", r11);
        Uri r13 = UriProtector.parse(r9.getSchema());     // Catch: Exception -> L65
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r13, "room_id")) == true) goto L56;
        r2.put("to_room_id", UriProtector.getQueryParameter(r13, "room_id"));     // Catch: Exception -> L65
    L56:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r13, "user_id")) == true) goto L59;
        r2.put("to_anchor_id", UriProtector.getQueryParameter(r13, "user_id"));     // Catch: Exception -> L65
    L59:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r13, "gift_id")) == true) goto L62;
        r2.put("present_id", UriProtector.getQueryParameter(r13, "gift_id"));     // Catch: Exception -> L65
        r2.put("gift_id", UriProtector.getQueryParameter(r13, "gift_id"));     // Catch: Exception -> L65
    L62:
        if (TextUtils.isEmpty(r9.getScene()) == true) goto L67;
        r2.put("biz_scene", r9.getScene());     // Catch: Exception -> L65
    L67:
        RoomNotifyMessageExtra r14 = r9.E();
        if (r14 == null) goto L72;
        Map r15 = r14.c();
        if (r15 == null) goto L72;
        r2.putAll(r15);
    L65:
        e = move-exception;
        ALogger.e("LiveRoomNotifyWidget", e);
        goto L67
    L45:
        com.bytedance.android.livesdk.user.e r16 = k.f(IMiddlewareUserService.class).user();
        if (r16 != null) goto L48;
    L50:
        r11 = "user";
        goto L51
    L48:
        if (r16.isAdmin() == false) goto L50;
        r11 = "admin";
        goto L51
    L11:
        if (r7 != 3) goto L13;
        r6 = "activity";
        goto L42
    L13:
        if (r7 != 4) goto L15;
        r6 = "fans_club";
        goto L42
    L15:
        if (r7 != 6) goto L17;
        r6 = "warden_buy";
        goto L42
    L17:
        if (r7 != 16) goto L19;
        r6 = "privilege_buff";
        goto L42
    L19:
        if (r7 != 19) goto L21;
        r6 = "rank_fresh";
        goto L42
    L21:
        if (r7 == 999) goto L34;
        switch(r7) {
            case 10: goto L29;
            case 11: goto L28;
            case 12: goto L27;
            case 13: goto L26;
            case 14: goto L25;
            default: goto L23;
        };
    L23:
        switch(r7) {
            case 66: goto L33;
            case 67: goto L32;
            case 68: goto L31;
            case 69: goto L30;
            default: goto L24;
        };
    L24:
        r6 = String.valueOf(r9.H());
        goto L42
    L30:
        r6 = "barrage_game_rank";
        goto L42
    L31:
        r6 = "mystery_shop";
        goto L42
    L32:
        r6 = "rank_game";
        goto L42
    L33:
        r6 = "rank_ktv";
        goto L42
    L25:
        r6 = "rank_region";
        goto L42
    L26:
        r6 = "rank_hour";
        goto L42
    L27:
        r6 = "vip";
        goto L42
    L28:
        r6 = "endless_gift";
        goto L42
    L29:
        r6 = "vehicle";
        goto L42
    L34:
        r6 = "999";
        goto L42
    L41:
        r6 = "gift";
    L72:
        u.l().sendLog("livesdk_top_message", r2, new Object[]{new x(), Room.class});
    }

    public final void zq(String r4, User r5, long r6, int r8, int r9) {
        if (r9 != 999) goto L61;
        if (this.x == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r4) == false) goto L11;
        ALogger.i("notify_widget_inroom_jump", "jumpfailed empty schema");
        return;
    L11:
        Uri r7 = UriProtector.parse(r4);
        String r10 = r7.getHost();
        if (TextUtils.isEmpty(r10) == false) goto L16;
        ALogger.i("notify_widget_inroom_jump", "jump failed host invalidate");
        return;
    L16:
        if (((Widget) this).dataCenter != null) goto L20;
        ALogger.i("notify_widget_inroom_jump", "jump failed datacenter null");
        return;
    L20:
        if ("webcast_room".equals(r10) == false) goto L57;
        if (getContext() != null) goto L26;
        ALogger.i("notify_widget_inroom_jump", "failed , context null");
        return;
    L26:
        if (((Boolean) ((Widget) this).dataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L78;
        Context r11 = ((Widget) this).context;
        x0.d r13 = new x0.d();
        r13.b = r11;
        r13.a = 0;
        r13.k = false;
        r13.d = r11.getText(2131920768);
        String r14 = getContext().getString(2131918147);
        DialogInterface.OnClickListener r15 = new i92.f();
        x0.c[] r16 = r13.g;
        x0.c r17 = r16[0];
        if (r17 != null) goto L30;
        r17 = new x0.c();
        r16[0] = r17;
    L30:
        r17.a = r14;
        r17.b = r15;
        x0.b.g(new x0(r13.b, r13));
        return;
    L78:
        String r18 = UriProtector.getQueryParameter(r7, "room_id");     // Catch: Throwable -> L54
        if (r18 != null) goto L36;
    L39:
        String r0 = null;
        Room r19 = (Room) ((Widget) this).dataCenter.get("data_room", null);     // Catch: Throwable -> L54 Throwable -> L54
        if (r19 == null) goto L42;
        r0 = String.valueOf(r19.getOwnerUserIdString());     // Catch: Throwable -> L54 Throwable -> L54
    L42:
        String r20 = UriProtector.getQueryParameter(r7, "user_id");     // Catch: Throwable -> L54 Throwable -> L54
        if (r0 != null) goto L45;
    L48:
        String r21 = UriProtector.getQueryParameter(r7, "anchor_id");     // Catch: Throwable -> L54 Throwable -> L54
        if (r0 == null) goto L57;
        if (r0.equals(r21) == false) goto L57;
        ALogger.i("notify_widget_inroom_jump", "jump failed ,same room");     // Catch: Throwable -> L54 Throwable -> L54
        return;
    L45:
        if (r0.equals(r20) == false) goto L48;
        ALogger.i("notify_widget_inroom_jump", "jump failed ,same room");     // Catch: Throwable -> L54 Throwable -> L54
        return;
    L36:
        if (String.valueOf(((Widget) this).dataCenter.get("data_room_id", 0L)).equals(r18) == false) goto L39;
        ALogger.i("notify_widget_inroom_jump", "jump failed ,same room");     // Catch: Throwable -> L54 Throwable -> L54
        return;
    L54:
        ALogger.i("notify_widget_inroom_jump", "jump failed, query decode exception");
        return;
    L57:
        if (k.f(ILiveActionHandler.class).handle(((Widget) this).context, r4) == true) goto L79;
        yq(r4);
        return;
    L79:
        return;
    L61:
        if (TextUtils.isEmpty(r4) == false) goto L63;
    L76:
        yq(r4);
        return;
    L63:
        if (r4.equals("sslocal://webcast_room") == true) goto L76;
        Uri r23 = UriProtector.parse(r4);
        if (r23.getQuery() != null) goto L68;
        String r24 = "enter_from_widget=notify&msg_type=" + r8;
    L70:
        if ((!TextUtils.isEmpty(UriProtector.getQueryParameter(r23, "gift_id"))) == false) goto L72;
        r24 = r24 + "&enter_live_source=top_message&enter_from_v3=live_detail&enter_from_module=top_message&top_message_type=gift";
        k.f(IRoomService.class).setCrossRoomGift(new a91.a(r24, r5, r6));
    L72:
        String r25 = ((r24 + "&back_room=true") + String.format(Locale.US, "&%s=%s", new Object[]{"data_live_new_feed_style", Boolean.valueOf(j92.a.a(((Widget) this).dataCenter))})) + "&enter_from_merge=live_detail&enter_method=top_message";
        if (k.f(ILiveActionHandler.class).handle(((Widget) this).context, r25) == true) goto L80;
        yq(r25);
        return;
    L80:
        return;
    L68:
        r24 = r4 + "&enter_from_widget=notify&msg_type=" + r8;
        goto L70
    }
}
