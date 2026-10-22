package com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.android.live.base.model.message.h1;
import com.bytedance.android.live.browser.LynxThreadStrategy;
import com.bytedance.android.live.browser.jsbridge.event.RoomBannerBarEvent;
import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.bytedance.android.live.core.activity.BannerFullMonitor;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.l2;
import com.bytedance.android.live.core.setting.v4;
import com.bytedance.android.live.core.setting.y3;
import com.bytedance.android.live.core.setting.z;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.presenter.ActivityTopRightBannerPresenter;
import com.bytedance.android.livesdk.chatroom.ui.BannerFrameLayout;
import com.bytedance.android.livesdk.chatroom.utils.i3;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.view.LiveBannerNameView;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.base.BaseBannerWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.presenter.TopRightBannerPresenter;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.stats.ToolbarLoadTimeStatsVM;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.common.h;
import com.bytedance.android.livesdk.common.i;
import com.bytedance.android.livesdk.config.PerformanceTestSettings;
import com.bytedance.android.livesdk.config.br;
import com.bytedance.android.livesdk.config.v0;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.c0;
import com.bytedance.android.livesdk.utils.g2;
import com.bytedance.android.livesdk.utils.o6;
import com.bytedance.android.livesdk.utils.p4;
import com.bytedance.android.livesdk.vs.model.VSBannerInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.ActivityBannerWidget, needDynamicControl = true, type = PlayerViewControl.Type.TOP)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/activity/banner/ActivityTopBannerWidget;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/activity/banner/base/BaseBannerWidget;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/activity/banner/presenter/TopRightBannerPresenter;", "Lcom/bytedance/android/livesdk/chatroom/presenter/ActivityTopRightBannerPresenter$IView;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/activity/banner/g;", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/a;", "Lcom/bytedance/android/livesdk/common/i;", "<init>", "()V", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActivityTopBannerWidget extends BaseBannerWidget<TopRightBannerPresenter> implements ActivityTopRightBannerPresenter.IView, g, com.bytedance.android.livesdk.chatroom.vsplayer.model.a, i {
    public final TopRightBannerPresenter h;
    public BannerFrameLayout i;
    public LiveBannerNameView j;
    public ImageView k;
    public Boolean l;
    public com.bytedance.android.livesdk.chatroom.monitor.b m;
    public boolean n;
    public NativeTopRightComponent o;
    public FrameLayout p;
    public ViewPager2 q;
    public final v0 r;
    public long s;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ActivityTopBannerWidget a;
        public final /* synthetic */ String b;

        public a(ActivityTopBannerWidget r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            UIUtils.setViewVisibility(this.a.k, 8);
            ActivityTopBannerWidget r11 = this.a;
            String r0 = this.b;
            if (r0 == null) goto L8;
            r11.b = false;
            vo1.i r1 = r11.e;
            if (r1 == null) goto L7;
            r1.loadUrl(r0);
        L7:
            r11.d = r0;
        L9:
            IRoom r12 = this.a.h.g;
            if (r12 == null) goto L12;
            Long r13 = Long.valueOf(r12.getId());
        L13:
            BannerFullMonitor.a("ttlive_activity_banner_manual_reload", 0, String.valueOf(r13), this.b, null, BannerFullMonitor.BannerType.TOP_RIGHT, "");
            return;
        L12:
            r13 = null;
            goto L13
        L8:
            r11.getClass();
            goto L9
        }
    }

    public static final class b<T> implements h80.a {
        public final /* synthetic */ ActivityTopBannerWidget a;

        public b(ActivityTopBannerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IRoom r3 = (IRoom) r2;
            if (r3 == null) goto L7;
            RoomExtra r4 = r3.getExtra();
            if (r4 == null) goto L7;
            Boolean r5 = Boolean.valueOf(r4.isGroupLiveScene());
        L8:
            this.a.Iq(r5);
            return;
        L7:
            r5 = null;
            goto L8
        }
    }

    @Override // com.bytedance.android.livesdk.common.i
    public final /* synthetic */ String Lg() {
        return h.b(this);
    }

    @Override // com.bytedance.android.livesdk.common.i
    public final /* synthetic */ String cg() {
        return h.c(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ String getLogTag() {
        return IWidget.CC.$default$getLogTag(this);
    }

    public final String getSpm() {
        return "a100.a100.a311";
    }

    @Override // com.bytedance.android.livesdk.common.i
    public final String nc() {
        return "ActivityTopBannerWidget";
    }

    @Override // com.bytedance.android.livesdk.common.i
    public final /* synthetic */ boolean nq() {
        return h.a();
    }

    public final void Gq() {
        if (this.h.f() == false) goto L5;
        UIUtils.setViewVisibility(((Widget) this).containerView, 0);
        return;
    L5:
        UIUtils.setViewVisibility(((Widget) this).containerView, 8);
    }

    public final int getLayoutId() {
        if (((Boolean) y3.a.getValue()).booleanValue() == false) goto L5;
        return 2131568020;
    L5:
        return 2131568019;
    }

    public final int supportClearScene() {
        if (((Boolean) l2.a.getValue()).booleanValue() == false) goto L5;
        return 25;
    L5:
        return 24;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.base.BaseBannerWidget
    public final void zq() {
        IRoom r0 = this.h.g;
        if (r0 == null) goto L5;
        Long r1 = Long.valueOf(r0.getId());
    L6:
        String r3 = String.valueOf(r1);
        String r4 = this.d;
        BannerFullMonitor.BannerType r6 = BannerFullMonitor.BannerType.TOP_RIGHT;
        if (this.h.h == false) goto L9;
        String r2 = "isAnchor";
    L10:
        BannerFullMonitor.a("ttlive_activity_banner_on_click", 0, r3, r4, null, r6, r2);
        return;
    L9:
        r2 = " false isAnchor";
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public ActivityTopBannerWidget() {
        this.h = new TopRightBannerPresenter(this);
        this.l = Boolean.FALSE;
        this.r = (v0) z.a.getValue();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.base.BaseBannerWidget
    public final void Eq() {
        super.Eq();
        if (this.n == true) goto L19;
        View r0 = ((Widget) this).contentView;
        if ((r0 instanceof ViewGroup) == true) goto L7;
        r0 = null;
    L7:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L23;
        int r2 = r1.getChildCount();
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L24;
        ViewPager2 r4 = r1.getChildAt(r3);
        ViewPager2 r5 = this.j;
        if (r4 != r5) goto L15;
    L17:
        UIUtils.setViewVisibility(r5, 4);
    L18:
        r3 = r3 + 1;
        goto L11
    L15:
        if (r4 == this.q) goto L17;
        r1.removeView(r4);
        goto L18
    L24:
        return;
    L23:
        return;
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget*/.onDestroy();
        IRoom r0 = this.h.g;
        if (r0 == null) goto L5;
        Long r1 = Long.valueOf(r0.getRoomId());
    L6:
        int r2 = com.bytedance.android.livesdk.c.a;
        if (r1 == null) goto L16;
        long r3 = r1.longValue();
        k.n(IMiddlewareHostAction.class).clearLiveBannerTag(String.valueOf(r3));     // Catch: Throwable -> L11
        ALogger.i("reportLiveBanner", "clearLiveBannerTag success");     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        ALogger.e("clearLiveBannerTag", th);
        return;
    L16:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        xq(new ActivityTopBannerViewIntent.c(ActivityTopBannerViewIntent.LifeCycle.ON_PAUSE));
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        xq(new ActivityTopBannerViewIntent.c(ActivityTopBannerViewIntent.LifeCycle.ON_RESUME));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.base.BaseBannerWidget
    public final void onUnload() {
        super.onUnload();
        ALogger.i("tag_banner_TOP", "onUnload");
        this.l = Boolean.FALSE;
        this.n = false;
        this.k = null;
        this.m = null;
        NativeTopRightComponent r1 = this.o;
        if (r1 == null) goto L10;
        Runnable r2 = r1.b;
        if (r2 == null) goto L9;
        Handler r3 = r1.a;
        if (r3 == null) goto L9;
        r3.removeCallbacks(r2);
    L9:
        r1.d = true;
        r1.e = null;
    L10:
        NativeTopRightComponent r0 = this.o;
        if (r0 == null) goto L18;
        NativeTopRightComponent$buildAdapter$2 r4 = r0.c;
        if (r4 == null) goto L19;
        ViewPager2 r5 = this.q;
        if (r5 == null) goto L20;
        r5.unregisterOnPageChangeCallback(r4);
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.livesdk.common.i
    public final View getContentView() {
        return ((Widget) this).contentView;
    }

    @Override // com.bytedance.android.livesdk.common.i
    public final Boolean uk() {
        return this.l;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.base.BaseBannerWidget
    public final void Cq(BannerInRoomCollection.BannerInfo r4) {
        Jq(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.d(true, r4, "fallback to web"), true, true);
    }

    public final void Iq(Boolean r2) {
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L14;
        eu2.a r3 = ((Widget) this).contentView;
        if (r3 != null) goto L7;
        return;
    L7:
        if ((r3 instanceof eu2.a) == false) goto L16;
        r3.T3(new d80.c());
        if (((Widget) this).contentView.getVisibility() != 0) goto L17;
        View r4 = ((Widget) this).contentView;
        if (r4 == null) goto L18;
        r4.setVisibility(4);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public final void Lq(g2 r11) {
        final com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a r12 = (com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a) r11;
        if ((r12 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.e) == false) goto L6;
    L137:
        ALogger.i("tag_banner_TOP", "state =" + r12);
        return;
    L6:
        if ((r12 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.d) == false) goto L17;
        com.bytedance.android.livesdk.chatroom.monitor.b r0 = this.m;
        if (r0 == null) goto L10;
        r0.d("FETCH_BANNER_DATA_END");
    L10:
        Function0<Unit> r1 = new ActivityTopBannerWidget$onStateChanged$1(this, r12);
        Intrinsics.checkNotNullParameter(r1, "function");
        if (k60.b.a() == false) goto L16;
        this.c = new ro1.f(r1);
        if (k60.b.c() == false) goto L15;
        i0.d(this.c);
        goto L137
    L15:
        i0.i(c50.b.b(((Widget) this).dataCenter), this.c);
        goto L137
    L16:
        r1.invoke();
        goto L137
    L17:
        boolean r3 = false;
        int r2 = 8;
        boolean r5 = false;
        Long r6 = null;
        if ((r12 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.i) == false) goto L64;
        com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.i r4 = (com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.i) r12;
        this.s = System.currentTimeMillis();
        com.bytedance.android.livesdk.chatroom.monitor.b r7 = this.m;
        if (r7 == null) goto L22;
        r7.d("LOAD_URL_START");
    L22:
        String r8 = r4.b;
        if (r8 == null) goto L28;
        this.b = false;
        vo1.i r9 = this.e;
        if (r9 == null) goto L27;
        r9.loadUrl(r8);
    L27:
        this.d = r8;
    L28:
        String r10 = r4.b;
        TopRightBannerPresenter r13 = this.h;
        r13.getClass();
        if (TextUtils.isEmpty(r10) == false) goto L139;
    L36:
        if (r5 == true) goto L38;
    L57:
        Gq();
        IRoom r14 = this.h.g;
        if (r14 == null) goto L60;
        r6 = Long.valueOf(r14.getId());
    L60:
        BannerFullMonitor.a("ttlive_activity_banner_on_load_start", 0, String.valueOf(r6), r4.b, null, BannerFullMonitor.BannerType.TOP_RIGHT, "origin url= " + r4.a);
        com.bytedance.android.livesdk.chatroom.monitor.b r15 = this.m;
        if (r15 == null) goto L137;
        r15.d("LOAD_URL_END");
        goto L137
    L38:
        if (((Widget) this).context == null) goto L57;
        if ((((Widget) this).contentView instanceof ViewGroup) == false) goto L57;
        if (this.k != null) goto L57;
        ImageView r16 = new ImageView(((Widget) this).context);
        this.k = r16;
        r16.setImageDrawable(s1.m(2131250874));
        ImageView r17 = this.k;
        if (r17 == null) goto L47;
        r17.setScaleType(ImageView.ScaleType.CENTER_CROP);
    L47:
        ImageView r18 = this.k;
        if (r18 == null) goto L50;
        r18.setLayoutParams(new FrameLayout.LayoutParams(-1, s1.j(2131169109)));
    L50:
        View r19 = ((Widget) this).contentView;
        if (r19 == null) goto L56;
        ((ViewGroup) r19).addView(this.k, 1);
        ImageView r20 = this.k;
        if (r20 == null) goto L57;
        r20.setVisibility(8);
        goto L57
    L56:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L139:
        String r21 = UriProtector.getQueryParameter(UriProtector.parse(r10), r13.f);     // Catch: Exception -> L34
    L35:
        r5 = TextUtils.equals(r21, "1");
    L34:
        r21 = "";
        goto L35
    L64:
        if ((r12 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.f) == false) goto L67;
        com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.f r22 = (com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.f) r12;
        Fq(r22.a, r22.b);
        goto L137
    L67:
        if ((r12 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.g) == false) goto L90;
        boolean r23 = ((com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.g) r12).a;
        View r24 = ((Widget) this).contentView;
        if (r23 == false) goto L71;
        int r25 = 8;
    L72:
        UIUtils.setViewVisibility(r24, r25);
        LiveBannerNameView r26 = this.j;
        if (r26 == null) goto L84;
        if (r23 == false) goto L78;
        UIUtils.setViewVisibility(r26, 8);
        goto L84
    L78:
        if (i3.a(this.h.h) != 0) goto L80;
        boolean r27 = true;
    L81:
        if (r27 == false) goto L83;
        r2 = 0;
    L83:
        UIUtils.setViewVisibility(r26, r2);
        goto L84
    L80:
        r27 = false;
    L84:
        boolean r28 = !r23;
        vo1.i r29 = this.e;
        if (r29 == null) goto L137;
        View r30 = r29.g();
        if (r30 == null) goto L137;
        r30.setFocusable(r28);
        goto L137
    L71:
        r25 = 0;
        goto L72
    L90:
        if ((r12 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.b) == false) goto L96;
        if (((com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.b) r12).a == false) goto L94;
        UIUtils.setViewVisibility(((Widget) this).containerView, 0);
        goto L137
    L94:
        UIUtils.setViewVisibility(((Widget) this).containerView, 8);
        goto L137
    L96:
        if ((r12 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.C0035a) == false) goto L103;
        LiveBannerNameView r31 = this.j;
        RoomBannerBarEvent r32 = ((com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.C0035a) r12).a;
        if (r32 == null) goto L137;
        if (r31 == null) goto L137;
        r31.setText(r32.getTitle());
        float r33 = r32.getFontSize();
        r31.a.setTextSize(1, r33);
        r31.b.setTextSize(1, r33);
        r31.c.setTextSize(1, r33);
        r31.setBackgroundColor(ColorProtector.parseColor(r32.getBackgroundColor()));
        r31.setTextColor(ColorProtector.parseColor(r32.getColor()));
        goto L137
    L103:
        if ((r12 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.c) == false) goto L106;
        UIUtils.setViewVisibility(((Widget) this).contentView, ((com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.c) r12).a);
        goto L137
    L106:
        if ((r12 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.h) == false) goto L132;
        com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.h r34 = (com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.h) r12;
        ALogger.i("tag_banner_TOP", "message: operationType=" + r34.b + ", bannerInfo = " + r34.a);
        if (this.e == null) goto L117;
        if (this.b == true) goto L117;
        BannerInRoomCollection.BannerInfo r35 = r34.a;
        if (r35.isLoadMessageBanner == false) goto L137;
        JSONObject r36 = r35.loadMessageBannerJson;
        if (r36 == null) goto L137;
        Fq("H5_roomStatusChange", r36);
    L117:
        if (this.n == false) goto L126;
        NativeTopRightComponent r37 = this.o;
        if (r37 == null) goto L123;
        com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.d r38 = r37.e;
        if (r38 == null) goto L123;
        r6 = r38.b;
    L123:
        if (r6 == null) goto L125;
        BannerInRoomCollection.BannerInfo r39 = r34.a;
        ((BannerInRoomCollection.BannerInfo) r6).isLoadMessageBanner = r39.isLoadMessageBanner;
        ((BannerInRoomCollection.BannerInfo) r6).loadMessageBannerJson = r39.loadMessageBannerJson;
    L125:
        Jq(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.d(true, r6, "reloadBanner"), false, true);
        r3 = true;
    L126:
        if (r3 == true) goto L137;
        if (r34.b != 1) goto L137;
        Jq(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.d(true, r34.a, "reloadBanner"), false, false);
        goto L137
    L132:
        if ((r12 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.j) == false) goto L137;
        int r40 = ((com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.j) r12).a;
        TopRightBannerPresenter r41 = this.h;
        r41.j(true);
        DataCenter r42 = ((p4) r41).d;
        if (r42 == null) goto L136;
        r42.put("data_activity_banner_number", Integer.valueOf(r40));
    L136:
        int r43 = o6.a;
        o6.a(((p4) r41).d, r40);
        Gq();
        goto L137
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.g
    public final void Yb(int r2) {
        UIUtils.setViewVisibility(this.j, r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.model.a
    public final boolean canControlByPlayer(PlayerViewControl.KEY r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (PadConfigUtils.c() == false) goto L5;
    L7:
        return false;
    L5:
        if (gb2.a.c(((Widget) this).dataCenter, true) == true) goto L7;
        return true;
    }

    public final void m5(h1 r2) {
        if (isViewValid() == false) goto L10;
        if (r2 != null) goto L6;
        return;
    L6:
        if (r2.getExtra() == null) goto L12;
        xq(new ActivityTopBannerViewIntent.a(r2));
        return;
    L12:
        return;
    }

    public final void onEnterClear(int r3) {
        if (r3 != 8) goto L5;
    L8:
        View r4 = ((Widget) this).contentView;
        if (r4 == null) goto L13;
        r4.setVisibility(8);
        return;
    L13:
        return;
    L5:
        if (r3 == 16) goto L8;
        if (r3 == 1) goto L8;
    }

    public final void onExitClear(int r2) {
        if (r2 != 8) goto L5;
    L8:
        View r3 = ((Widget) this).contentView;
        if (r3 == null) goto L13;
        r3.setVisibility(0);
        return;
    L13:
        return;
    L5:
        if (r2 == 16) goto L8;
        if (r2 == 1) goto L8;
    }

    public final void onInit(Object[] r3) {
        ALogger.i("tag_banner_TOP", "onInit");
        View r4 = ((Widget) this).contentView;
        if (r4 == null) goto L5;
        ViewPager2 r5 = (ViewPager2) r4.findViewById(2131389205);
    L6:
        this.q = r5;
        this.p = (FrameLayout) ((Widget) this).contentView.findViewById(2131362194);
        this.i = (BannerFrameLayout) ((Widget) this).contentView.findViewById(2131362193);
        this.j = (LiveBannerNameView) ((Widget) this).contentView.findViewById(2131362176);
        if (this.r.b() == false) goto L10;
        this.o = new NativeTopRightComponent(((Widget) this).contentView, ((Widget) this).context);
        return;
    L10:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void onLoad(Object[] r19) {
        super/*com.bytedance.android.live.core.arch.mvi.widgetcompat.MVIDataWidget*/.onLoad(r19);
        boolean r2 = !this.r.b();
        if (r2 == true) goto L5;
    L12:
        xq(new ActivityTopBannerViewIntent.b(BaseBannerWidget.BannerPosition.TOP_RIGHT));
        ALogger.i("tag_banner_TOP", "onLoad");
        com.bytedance.android.livesdk.chatroom.monitor.b r3 = this.m;
        if (r3 == null) goto L16;
        r3.d("FETCH_BANNER_DATA_START");
    L16:
        if (r19 != null) goto L18;
    L24:
        boolean r6 = true;
    L25:
        Boolean r7 = null;
        if (r6 == true) goto L41;
        if (Intrinsics.areEqual(r19[0], Boolean.TRUE) == false) goto L41;
        PlayerViewControl r1 = (PlayerViewControl) ActivityTopBannerWidget.class.getAnnotation(PlayerViewControl.class);
        if (r1 == null) goto L41;
        IVSPlayerService r4 = (IVSPlayerService) k.f(IVSPlayerService.class);
        if (r4 == null) goto L34;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r5 = r4.provideVSPlayerViewControlService(((Widget) this).dataCenter);
    L35:
        com.bytedance.android.livesdk.chatroom.vsplayer.model.c r8 = new com.bytedance.android.livesdk.chatroom.vsplayer.model.c(r1.key(), null, ((Widget) this).containerView, r1.type(), r1.style(), 0.0f, true, false, false);
        if (r5 == null) goto L38;
        r5.c(r1.key());
    L38:
        if (r5 == null) goto L41;
        r5.e(r8);
        goto L41
    L34:
        r5 = null;
    L41:
        if (((Boolean) y3.a.getValue()).booleanValue() == false) goto L63;
        o r9 = z51.a.h(((Widget) this).dataCenter, 2);
        if (r9 == null) goto L64;
        m r10 = r9.getRoom();
        if (r10 == null) goto L65;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 != null) goto L49;
        return;
    L49:
        if (r11.isPrivatePlay() != true) goto L67;
        o r12 = z51.a.h(((Widget) this).dataCenter, 2);
        if (r12 == null) goto L59;
        m r13 = r12.getRoom();
        if (r13 == null) goto L59;
        IRoom r14 = (IRoom) r13.getValue();
        if (r14 == null) goto L59;
        RoomExtra r15 = r14.getExtra();
        if (r15 == null) goto L59;
        r7 = Boolean.valueOf(r15.isGroupLiveScene());
    L59:
        if (r7 != null) goto L61;
        MiddlewareRoomContext r16 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        ToolbarLoadTimeStatsVM.a r17 = ToolbarLoadTimeStatsVM.Companion;
        AutoDisposeConverter r18 = autoDispose();
        b r20 = new b(this);
        r17.getClass();
        ToolbarLoadTimeStatsVM.a.a(r18, r16, r20);
        return;
    L61:
        Iq(r7);
        return;
    L67:
        return;
    L65:
        return;
    L64:
        return;
    L63:
        return;
    L18:
        if (r19.length != 0) goto L20;
        boolean r21 = true;
    L21:
        if (r21 == true) goto L24;
        r6 = false;
        goto L25
    L20:
        r21 = false;
        goto L21
    L5:
        if (PerformanceTestSettings.TEST_DISABLE_BANNER.getValue().booleanValue() == true) goto L12;
        IRoom r22 = this.h.g;
        if (r22 == null) goto L10;
        long r23 = r22.getId();
    L11:
        int r24 = x40.b.a;
        com.bytedance.android.livesdk.chatroom.monitor.b r25 = new com.bytedance.android.livesdk.chatroom.monitor.b(r23, r2);
        this.m = r25;
        r25.d("BANNER_WIDGET_ONLOAD");
        goto L12
    L10:
        r23 = 0;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.common.i
    public final void qo(Boolean r1) {
        this.l = r1;
    }

    public final void Kq(BannerInRoomCollection.BannerInfo r9, BaseHybridParamVo.HybridType r10) {
        Eq();
        com.bytedance.android.livesdk.chatroom.monitor.b r0 = this.m;
        if (r0 == null) goto L5;
        String r1 = r10.toString();
        Intrinsics.checkNotNullParameter(r1, "containerType");
        r0.f = r1;
    L5:
        Context r2 = ((Widget) this).context;
        String r3 = null;
        if ((r2 instanceof Activity) == true) goto L8;
        r2 = null;
    L8:
        Activity r4 = (Activity) r2;
        if (r4 == null) goto L44;
        int r5 = c0.a;
        v.a();
        if (r10 == null) goto L34;
        int r6 = ro1.b.a[r10.ordinal()];
        if (r6 == 1) goto L33;
        if (r6 != 2) goto L34;
        if (r9 == null) goto L34;
        if (this.e != null) goto L26;
        int r7 = vo1.e.a;
        if (((Boolean) com.bytedance.android.live.core.setting.a.a.getValue()).booleanValue() == false) goto L24;
        vo1.i r8 = new vo1.f();
    L25:
        this.e = r8;
        goto L26
    L24:
        r8 = new vo1.a();
    L26:
        String r11 = r9.lynxUrl;
        if (r11 == null) goto L34;
        vo1.i r12 = this.e;
        if (r12 == null) goto L32;
        r12.f(r4, r11, LynxThreadStrategy.ALL_ON_UI, new ro1.e(this, r9));
    L32:
        this.f = BaseHybridParamVo.HybridType.LYNX;
        goto L34
    L33:
        yq(r4, r9);
    L34:
        vo1.i r13 = this.e;
        if (r13 != null) goto L37;
    L39:
        vo1.i r14 = this.e;
        if (r14 == null) goto L44;
        View r15 = r14.g();
        if (r15 == null) goto L44;
        r15.setOnTouchListener(new ro1.g(this));
        goto L44
    L37:
        if (r13.e() == true) goto L39;
        yq(r4, r9);
    L44:
        vo1.i r16 = this.e;
        if (r16 == null) goto L47;
        View r17 = r16.g();
    L49:
        if ((r17 instanceof WebView) == false) goto L60;
        vo1.i r18 = this.e;
        if (r18 == null) goto L55;
        View r19 = r18.g();
        if (r19 == null) goto L55;
        r19.setBackgroundColor(0);
    L55:
        vo1.i r20 = this.e;
        if (r20 == null) goto L60;
        View r21 = r20.g();
        if (r21 == null) goto L60;
        r21.setVisibility(8);
    L60:
        vo1.i r22 = this.e;
        if (r22 == null) goto L65;
        View r23 = r22.g();
        if (r23 == null) goto L65;
        r23.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    L65:
        ViewPager2 r24 = this.q;
        if (r24 == null) goto L68;
        r24.setVisibility(8);
    L68:
        vo1.i r25 = this.e;
        if (r25 == null) goto L78;
        View r26 = r25.c();
        if (r26 == null) goto L78;
        View r27 = ((Widget) this).contentView;
        if ((r27 instanceof ViewGroup) == true) goto L75;
        r27 = null;
    L75:
        ViewGroup r28 = (ViewGroup) r27;
        if (r28 == null) goto L78;
        r28.addView(r26, 0);
    L78:
        LiveBannerNameView r29 = this.j;
        if (r29 != null) goto L81;
    L88:
        vo1.i r30 = this.e;
        if (r30 == null) goto L91;
        View r31 = r30.c();
    L92:
        r3.k(r31);
        View r32 = new View(getContext());
        r32.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View r33 = ((Widget) this).contentView;
        if (r33 == null) goto L160;
        ((FrameLayout) r33).addView(r32);
        r32.setBackground(new ColorDrawable(0));
        ((Widget) this).contentView.setFocusable(true);
        ((Widget) this).contentView.setFocusableInTouchMode(true);
        if (((Boolean) br.a.getValue()).booleanValue() == false) goto L97;
        ((Widget) this).contentView.setOnHoverListener(ro1.c.a);
    L97:
        r3.c(((Widget) this).contentView, "活动入口", true);
        vo1.i r34 = this.e;
        if (r34 == null) goto L101;
        r34.registerMethod("setContentDescription", new ro1.d(this));
    L101:
        if (((Boolean) v4.a.getValue()).booleanValue() == false) goto L127;
        BaseHybridParamVo.HybridType r35 = this.f;
        if (r35 == BaseHybridParamVo.HybridType.LYNX) goto L127;
        if (r35 != BaseHybridParamVo.HybridType.H5) goto L110;
        LayerEventDispatcher r36 = o70.c.a(Integer.valueOf(((Widget) this).dataCenter.hashCode()));
        if (r36 == null) goto L110;
        r36.b(new yn1.d());
    L110:
        UIUtils.setLayoutParams(this.i, s1.j(2131169110), s1.j(2131168941));
        if (isScreenPortrait() == true) goto L127;
        boolean r37 = isScreenPortrait();
        int r38 = com.bytedance.android.livesdk.utils.landscape.d.a;
        if ((!r37) == false) goto L127;
        if (i3.a(this.h.h) != 0) goto L127;
        if (((Widget) this).containerView.getId() != 2131377137) goto L127;
        BannerFrameLayout r39 = this.i;
        if (r39 == null) goto L121;
        ViewGroup.LayoutParams r40 = r39.getLayoutParams();
    L122:
        if (r40 == null) goto L124;
        r40.width = s1.f(21);
    L124:
        BannerFrameLayout r41 = this.i;
        if (r41 == null) goto L127;
        r41.setLayoutParams(r40);
        goto L127
    L121:
        r40 = null;
    L127:
        if (r9 == null) goto L137;
        if (r9.isLoadMessageBanner == true) goto L131;
    L135:
        this.h.i(r9);
        goto L137
    L131:
        if (r9.loadMessageBannerJson == null) goto L135;
        TopRightBannerPresenter r42 = this.h;
        r42.j(true);
        int r43 = o6.a;
        o6.a(((p4) r42).d, 1);
        DataCenter r44 = ((p4) r42).d;
        if (r44 == null) goto L137;
        r44.put("data_activity_banner_number", 1);
    L137:
        if (r10 != BaseHybridParamVo.HybridType.H5) goto L140;
        if (r9 == null) goto L142;
        String r45 = r9.getUrl();
    L143:
        if (r9 == null) goto L145;
        r3 = r9.logId;
    L145:
        xq(new ActivityTopBannerViewIntent.g(r45, r3));
        if (v.a() == false) goto L161;
        int r46 = c0.a;
        r10.ordinal();
        int r110 = com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.b.b[r10.ordinal()];
        if (r110 == 1) goto L152;
        if (r110 == 2) goto L154;
        if (r9 == null) goto L154;
        r9.getUrl();
    L154:
        if (r9 == null) goto L162;
        List r47 = r9.getBannerList();
        if (r47 == null) goto L163;
        r47.size();
        return;
    L163:
        return;
    L162:
        return;
    L152:
        if (r9 == null) goto L154;
        r9.getUrl();
        goto L154
    L161:
        return;
    L142:
        r45 = null;
        goto L143
    L140:
        if (r9 == null) goto L142;
        r45 = r9.lynxUrl;
        goto L143
    L160:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    L91:
        r31 = null;
        goto L92
    L81:
        if (r29.getParent() != null) goto L88;
        View r48 = ((Widget) this).contentView;
        if ((r48 instanceof ViewGroup) == true) goto L85;
        r48 = null;
    L85:
        ViewGroup r49 = (ViewGroup) r48;
        if (r49 == null) goto L88;
        r49.addView(this.j);
        goto L88
    L47:
        r17 = null;
        goto L49
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.base.BaseBannerWidget
    public final void Aq(View r11, String r12, BannerInRoomCollection.BannerInfo r13) {
        TopRightBannerPresenter.c r0 = this.h.e;
        if (r0 == null) goto L6;
        r0.b(true);
    L6:
        if (((Widget) this).isViewValid == false) goto L71;
        if (r11 == null) goto L73;
        com.bytedance.android.livesdk.chatroom.monitor.b r1 = this.m;
        if (r1 == null) goto L12;
        r1.d("ON_PAGE_FINISHED");
        r1.g();
    L12:
        int r2 = 0;
        r11.setVisibility(0);
        Gq();
        if (((Boolean) l42.a.g.getValue()).booleanValue() == true) goto L15;
    L17:
        if (r13 != null) goto L19;
    L23:
        BaseBannerWidget.BannerPosition r3 = BaseBannerWidget.BannerPosition.TOP_RIGHT;
        xq(new ActivityTopBannerViewIntent.d(r3, r13));
        xq(new ActivityTopBannerViewIntent.e(r3));
        IRoom r14 = this.h.g;
        if (r14 == null) goto L26;
        Long r15 = Long.valueOf(r14.getId());
    L27:
        BannerFullMonitor.a("ttlive_activity_banner_on_load_finish", 0, String.valueOf(r15), r12, null, BannerFullMonitor.BannerType.TOP_RIGHT, "");
        int r16 = x40.a.a;
        x40.a.a(0, r12, System.currentTimeMillis() - this.s);
        IRoom r17 = this.h.g;
        if (r17 == null) goto L30;
        Long r18 = Long.valueOf(r17.getId());
    L31:
        if (r13 == null) goto L33;
        List r4 = r13.tokenList;
    L34:
        int r5 = com.bytedance.android.livesdk.c.a;
        if (r18 == null) goto L43;
        if (r4 == null) goto L43;
        if ((!r4.isEmpty()) != true) goto L43;
        k.n(IMiddlewareHostAction.class).reportLiveBanner(String.valueOf(r18.longValue()), r4);     // Catch: Throwable -> L41
        ALogger.i("reportLiveBanner", "reportLiveBanner success");     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        ALogger.e("reportLiveBanner", th);
    L43:
        IRoom r19 = this.h.g;
        if (r19 == null) goto L46;
        Long r110 = Long.valueOf(r19.getId());
    L47:
        String r111 = String.valueOf(r110);
        BannerFullMonitor.BannerType r6 = BannerFullMonitor.BannerType.TOP_RIGHT;
        if (r13 == null) goto L50;
        List r112 = r13.getBannerList();
    L66:
    L63:
        e = move-exception;
        ALogger.e("BannerFullMonitor", e);
        return;
    L52:
        if (ActivityMonitor.a() == false) goto L72;
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L63
        r7.put("position", BannerFullMonitor.BannerType.access$000(r6));     // Catch: Exception -> L63
        if (r112 != null) goto L57;
    L61:
        JSONObject r113 = new JSONObject();     // Catch: Exception -> L63
        r113.put("room_id", r111);     // Catch: Exception -> L63
        r113.put("url", r12);     // Catch: Exception -> L63
        ActivityMonitor.c("ttlive_banner_id_on_load_finish", r7, null, r113);     // Catch: Exception -> L63
        return;
    L57:
        if (r112.isEmpty() == true) goto L61;
    L59:
        if (r2 >= r112.size()) goto L61;
        r7.put("banner" + r2, ((b1) ListProtector.get(r112, r2)).getId());     // Catch: Exception -> L63
        r2 = r2 + 1;     // Catch: Exception -> L63
        goto L59
    L72:
        return;
    L50:
        r112 = null;
        goto L66
    L46:
        r110 = null;
        goto L47
    L33:
        r4 = null;
        goto L34
    L30:
        r18 = null;
        goto L31
    L26:
        r15 = null;
        goto L27
    L19:
        if (r13.isLoadMessageBanner == false) goto L23;
        JSONObject r114 = r13.loadMessageBannerJson;
        if (r114 == null) goto L23;
        Fq("H5_roomStatusChange", r114);
        goto L23
    L15:
        if (isScreenPortrait() == true) goto L17;
        UIUtils.setViewVisibility(((Widget) this).containerView, 8);
        goto L17
    L73:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.base.BaseBannerWidget
    public final void Bq(View r9, String r10, String r11) {
        TopRightBannerPresenter.c r0 = this.h.e;
        if (r0 == null) goto L5;
        r0.b(false);
    L5:
        UIUtils.setViewVisibility(((Widget) this).contentView, 8);
        TopRightBannerPresenter r1 = this.h;
        r1.getClass();
        if (TextUtils.isEmpty(r10) == false) goto L27;
        boolean r2 = false;
    L13:
        if (r2 == true) goto L15;
    L21:
        IRoom r12 = this.h.g;
        if (r12 == null) goto L24;
        Long r13 = Long.valueOf(r12.getId());
    L25:
        BannerFullMonitor.a("ttlive_activity_banner_on_load_error", 0, String.valueOf(r13), r10, r11, BannerFullMonitor.BannerType.TOP_RIGHT, "msg=" + r11);
        int r14 = x40.a.a;
        x40.a.a(-1, r10, System.currentTimeMillis() - this.s);
        return;
    L24:
        r13 = null;
        goto L25
    L15:
        if (this.k == null) goto L21;
        if (TextUtils.isEmpty(r10) == true) goto L21;
        UIUtils.setViewVisibility(r9, 8);
        UIUtils.setViewVisibility(((Widget) this).contentView, 0);
        UIUtils.setViewVisibility(this.k, 0);
        ImageView r15 = this.k;
        if (r15 == null) goto L21;
        r15.setOnClickListener(new a(this, r10));
        goto L21
    L27:
        String r3 = UriProtector.getQueryParameter(UriProtector.parse(r10), r1.f);     // Catch: Exception -> L11
    L12:
        r2 = TextUtils.equals(r3, "1");
    L11:
        r3 = "";
        goto L12
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback, com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.NativeTopRightComponent$buildAdapter$2] */
    public final void Jq(com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.d r13, boolean r14, boolean r15) {
        com.bytedance.android.livesdk.chatroom.monitor.b r0 = this.m;
        if (r0 == null) goto L5;
        r0.d("PROCESS_BANNER_DATA_START");
    L5:
        View r1 = ((Widget) this).contentView;
        if (r1 == null) goto L8;
        r1.setTranslationX(0.0f);
    L8:
        LiveBannerNameView r2 = this.j;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        BannerInRoomCollection.BannerInfo r3 = r13.b;
        if (r3 != null) goto L14;
    L59:
        boolean r4 = true;
    L60:
        Long r5 = null;
        if (r4 == false) goto L63;
    L209:
        UIUtils.setViewVisibility(((Widget) this).containerView, 8);
        TopRightBannerPresenter r16 = this.h;
        DataCenter r17 = ((p4) r16).d;
        if (r17 == null) goto L214;
        Boolean r18 = (Boolean) r17.get("data_is_anchor", Boolean.FALSE);
        if (r18 == null) goto L214;
        r18.booleanValue();
    L214:
        DataCenter r19 = ((p4) r16).d;
        if (r19 == null) goto L217;
        Integer r110 = Integer.valueOf(r19.hashCode());
    L218:
        LayerEventDispatcher r111 = o70.c.a(r110);
        if (r111 == null) goto L221;
        r111.b(new yn1.f());
    L221:
        this.h.j(false);
        int r112 = o6.a;
        o6.a(((Widget) this).dataCenter, 0);
        IRoom r113 = this.h.g;
        if (r113 == null) goto L224;
        r5 = Long.valueOf(r113.getId());
    L224:
        BannerFullMonitor.a("ttlive_activity_banner_on_load_error", -2, String.valueOf(r5), "", "", BannerFullMonitor.BannerType.TOP_RIGHT, "collection 返回数据不对，collection 元素为空了");
        return;
    L217:
        r110 = null;
        goto L218
    L63:
        if (r13.a == false) goto L209;
        com.bytedance.android.livesdk.chatroom.monitor.b r6 = this.m;
        if (r6 == null) goto L68;
        r6.d("PROCESS_BANNER_DATA_END");
    L68:
        com.bytedance.android.livesdk.chatroom.monitor.b r7 = this.m;
        if (r7 == null) goto L71;
        r7.d("CREATE_HYBRID_VIEW_START");
    L71:
        if (r14 == false) goto L73;
        BaseHybridParamVo.HybridType r114 = BaseHybridParamVo.HybridType.H5;
    L138:
        int r115 = com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.b.a[r114.ordinal()];
        if (r115 != 1) goto L141;
        Kq(r13.b, BaseHybridParamVo.HybridType.H5);
        ALogger.i("tag_banner_TOP", "h5 loadHybridComponent");
    L205:
        com.bytedance.android.livesdk.chatroom.monitor.b r116 = this.m;
        if (r116 == null) goto L240;
        r116.d("CREATE_HYBRID_VIEW_END");
        return;
    L240:
        return;
    L141:
        if (r115 != 2) goto L143;
        Kq(r13.b, BaseHybridParamVo.HybridType.LYNX);
        ALogger.i("tag_banner_TOP", "lynx loadHybridComponent");
        goto L205
    L143:
        if (r115 != 3) goto L205;
        this.n = true;
        ALogger.i("tag_banner_TOP", "loadStaticNative");
        BannerInRoomCollection.BannerInfo r117 = r13.b;
        if (r117 != null) goto L148;
    L202:
        ALogger.i("tag_banner_TOP", "loadStaticNativeComponent");
        goto L205
    L148:
        if ((!r117.getBannerList().isEmpty()) == false) goto L202;
        o r8 = o3.f();
        if (r8 == null) goto L152;
        Boolean r9 = r8.isVSRoom();
    L154:
        if (Intrinsics.areEqual(r9, Boolean.TRUE) == false) goto L179;
        Boolean r10 = o3.f().isPortraitInteraction();
        if (r10 == null) goto L158;
        boolean r11 = r10.booleanValue();
    L159:
        Boolean r12 = o3.f().isVSVerticalStream();
        if (r12 == null) goto L162;
        boolean r20 = r12.booleanValue();
    L163:
        eq1.b r21 = new eq1.b(r11, r20);
        Iterator r22 = r117.getBannerList().iterator();
    L165:
        if (r22.hasNext() == false) goto L179;
        b1 r23 = (b1) r22.next();
        String r24 = r23.getSchemaUrl();
        if (r24 == null) goto L165;
        if (r24.length() <= 0) goto L171;
        boolean r25 = true;
    L172:
        if (r25 == true) goto L175;
        r24 = null;
    L175:
        if (r24 == null) goto L165;
        String r26 = r21.b(r24);
        if (r26 == null) goto L165;
        r23.setSchemaUrl(r26);
        goto L165
    L171:
        r25 = false;
        goto L172
    L162:
        r20 = false;
        goto L163
    L158:
        r11 = true;
    L179:
        UIUtils.setViewVisibility(((Widget) this).containerView, 0);
        BannerFrameLayout r27 = this.i;
        if (r27 == null) goto L182;
        r27.setVisibility(8);
    L182:
        UIUtils.setViewVisibility(((Widget) this).contentView, 0);
        ViewPager2 r28 = this.q;
        if (r28 == null) goto L185;
        r28.setVisibility(0);
    L185:
        final NativeTopRightComponent r29 = this.o;
        if (r29 == null) goto L199;
        final List r30 = r117.getBannerList();
        final ViewPager2 r31 = this.q;
        NativeTopRightComponent r32 = this.o;
        final String r33 = r117.logId;
        Intrinsics.checkNotNullParameter(r13, "state");
        Intrinsics.checkNotNullParameter(r30, "items");
        if (r31 == null) goto L190;
        r31.setAdapter(new NativeTopRightComponent.NativeActivityTopRightAdapter(r30, r32, r33));
    L190:
        NativeTopRightComponent$buildAdapter$2 r34 = r29.c;
        if (r34 == null) goto L194;
        if (r31 == null) goto L194;
        r31.unregisterOnPageChangeCallback(r34);
    L194:
        ?? r35 = new NativeTopRightComponent$buildAdapter$2(r29, r30, r33, r31);
        r29.c = r35;
        if (r31 == null) goto L197;
        r31.registerOnPageChangeCallback(r35);
    L197:
        r29.e = r13;
        ALogger.i("tag_banner_TOP", "native buildAdapter");
    L199:
        if ((!r117.getBannerList().isEmpty()) == false) goto L201;
        ((Widget) this).contentView.setFocusable(true);
        ((Widget) this).contentView.setImportantForAccessibility(1);
        r3.c(((Widget) this).contentView, ((b1) ListProtector.get(r117.getBannerList(), 0)).getTitle() + "，当前第1项，共" + r117.getBannerList().size() + 39033, true);
    L201:
        r3.k(this.q);
        this.h.i(r117);
        Gq();
        goto L202
    L152:
        r9 = null;
        goto L154
    L73:
        if (r15 == false) goto L96;
        TopRightBannerPresenter r118 = this.h;
        BannerInRoomCollection.BannerInfo r119 = r13.b;
        r118.getClass();
        if (r119 == null) goto L79;
        VSBannerInfo r120 = r119.castToOrNull(VSBannerInfo.class);
        if (r120 == null) goto L79;
        boolean r121 = r120.isLynxContainerEnabled();
    L80:
        if (r121 == false) goto L92;
        if (r119 == null) goto L83;
        String r122 = r119.lynxUrl;
    L84:
        if (r122 != null) goto L86;
    L89:
        boolean r123 = true;
    L90:
        if (r123 == false) goto L92;
        boolean r124 = true;
    L93:
        if (r124 == false) goto L95;
        r114 = BaseHybridParamVo.HybridType.LYNX;
        goto L138
    L95:
        r114 = BaseHybridParamVo.HybridType.H5;
        goto L138
    L86:
        if (r122.length() == 0) goto L89;
        r123 = false;
        goto L90
    L83:
        r122 = null;
    L92:
        r124 = false;
    L79:
        r121 = false;
        goto L80
    L96:
        TopRightBannerPresenter r125 = this.h;
        BannerInRoomCollection.BannerInfo r126 = r13.b;
        r125.getClass();
        if (r126 == null) goto L117;
        List r127 = r126.getBannerList();
        if (r127 == null) goto L117;
        List r128 = r127;
        if ((r128 instanceof Collection) == true) goto L103;
    L105:
        Iterator r129 = r128.iterator();
    L107:
        if (r129.hasNext() == false) goto L114;
        if (((b1) r129.next()).getFrameType() != 1) goto L111;
        boolean r130 = true;
    L112:
        if (r130 == true) goto L107;
        boolean r131 = false;
    L115:
        if (r131 != true) goto L117;
        boolean r132 = true;
    L118:
        if (r132 == true) goto L120;
        r114 = BaseHybridParamVo.HybridType.H5;
        goto L138
    L120:
        if (this.r.b() == false) goto L125;
        if (this.o == null) goto L125;
        r114 = BaseHybridParamVo.HybridType.NATIVE;
    L125:
        if (this.r.a() == false) goto L136;
        BannerInRoomCollection.BannerInfo r133 = r13.b;
        if (r133 == null) goto L136;
        String r134 = r133.lynxUrl;
        if (r134 == null) goto L136;
        if (r134.length() <= 0) goto L133;
        boolean r135 = true;
    L134:
        if (r135 != true) goto L136;
        r114 = BaseHybridParamVo.HybridType.LYNX;
        goto L138
    L133:
        r135 = false;
    L136:
        r114 = BaseHybridParamVo.HybridType.H5;
        goto L138
    L111:
        r130 = false;
    L114:
        r131 = true;
        goto L115
    L103:
        if (r128.isEmpty() == false) goto L105;
    L117:
        r132 = false;
        goto L118
    L14:
        if (r3.isLoadMessageBanner == false) goto L35;
        if (isViewValid() == false) goto L59;
        String r36 = r3.getUrl();
        if (r36 != null) goto L20;
    L23:
        boolean r37 = true;
    L24:
        if (r37 == false) goto L58;
        String r38 = r3.lynxUrl;
        if (r38 != null) goto L28;
    L31:
        boolean r39 = true;
    L32:
        if (r39 == false) goto L58;
    L28:
        if (r38.length() == 0) goto L31;
        r39 = false;
    L58:
        r4 = false;
        goto L60
    L20:
        if (r36.length() == 0) goto L23;
        r37 = false;
        goto L24
    L35:
        if (isViewValid() == false) goto L59;
        String r40 = r3.getUrl();
        if (r40 != null) goto L39;
    L42:
        boolean r41 = true;
    L43:
        if (r41 == false) goto L52;
        String r42 = r3.lynxUrl;
        if (r42 != null) goto L47;
    L50:
        boolean r43 = true;
    L51:
        if (r43 == true) goto L59;
    L47:
        if (r42.length() == 0) goto L50;
        r43 = false;
    L52:
        List r44 = r3.getBannerList();
        if (r44 == null) goto L55;
        boolean r45 = r44.isEmpty();
    L56:
        if (r45 == false) goto L58;
    L55:
        r45 = false;
        goto L56
    L39:
        if (r40.length() == 0) goto L42;
        r41 = false;
        goto L43
    }
}
