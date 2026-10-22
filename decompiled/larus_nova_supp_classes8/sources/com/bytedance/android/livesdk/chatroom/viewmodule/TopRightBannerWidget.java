package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.browser.LynxThreadStrategy;
import com.bytedance.android.live.core.activity.ActivityHybridMonitor;
import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.y3;
import com.bytedance.android.live.core.utils.AnchorMainPostOptUtils;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.banner.InRoomBannerManager;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.event.TopRightBannerAdjustEvent;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.stats.ToolbarLoadTimeStatsVM;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.config.PerformanceTestSettings;
import com.bytedance.android.livesdk.config.br;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.message.model.IAnchorTaskMessage;
import com.bytedance.android.livesdk.message.model.n5;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.o6;
import com.bytedance.android.livesdk.vs.model.VSBannerInfo;
import com.bytedance.android.livesdkapi.banner.BannerData;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.annotations.SerializedName;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.TopRightWidget, needDynamicControl = true, type = PlayerViewControl.Type.TOP)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005:\u0002\b\tB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/TopRightBannerWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/a;", "<init>", "()V", "a", "b", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TopRightBannerWidget extends MiddlewareRoomRecyclableWidget implements vlc.l, Observer<KVData>, com.bytedance.android.livesdk.chatroom.vsplayer.model.a {
    public static final /* synthetic */ int q = 0;
    public vo1.a a;
    public LinearLayout b;
    public vlc.d c;
    public Room d;
    public boolean e;
    public ImageView f;
    public AnimatorSet g;
    public View h;
    public boolean i;
    public long j;
    public boolean k;
    public j l;
    public Runnable m;
    public com.bytedance.android.livesdk.chatroom.monitor.c n;
    public final x40.d o;
    public Disposable p;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/TopRightBannerWidget$b;", "", "", "gift_id", "J", "getGift_id", "()J", "setGift_id", "(J)V", LiveEndPageData.TAG_COUNT, "getCount", "setCount", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName(LiveEndPageData.TAG_COUNT)
        private long count;

        @SerializedName("gift_id")
        private long gift_id;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof b) == false) goto L10;
            b r7 = (b) r6;
            if (this.gift_id == r7.gift_id) goto L8;
            return false;
        L8:
            if (this.count == r7.count) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            long r0 = this.gift_id;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.count;
            return r1 + ((int) (r3 ^ (r3 >>> 32)));
        }

        public final String toString() {
            return "SendGiftData(gift_id=" + this.gift_id + ", count=" + this.count + ")";
        }

        public b() {
            this(0, 0);
        }

        public b(long r1, long r3) {
            this.gift_id = r1;
            this.count = r3;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ TopRightBannerWidget a;
        public final /* synthetic */ BannerInRoomCollection.BannerInfo b;

        public c(TopRightBannerWidget r1, BannerInRoomCollection.BannerInfo r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TopRightBannerWidget r0 = this.a;     // Catch: Throwable -> L4
            BannerInRoomCollection.BannerInfo r1 = this.b;     // Catch: Throwable -> L4
            int r2 = TopRightBannerWidget.q;     // Catch: Throwable -> L4
            r0.Bq(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ TopRightBannerWidget b;

        public d(String r1, TopRightBannerWidget r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TopRightBannerWidget r0 = this.b;     // Catch: Throwable -> L6
            r0.k = false;     // Catch: Throwable -> L6
            vo1.a r1 = r0.a;     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            r1.loadUrl(this.a);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class e<T> implements h80.a {
        public final /* synthetic */ TopRightBannerWidget a;

        public e(TopRightBannerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            IRoom r4 = (IRoom) r3;
            if (r4 == null) goto L7;
            RoomExtra r5 = r4.getExtra();
            if (r5 == null) goto L7;
            Boolean r6 = Boolean.valueOf(r5.isGroupLiveScene());
        L8:
            TopRightBannerWidget r0 = this.a;
            int r1 = TopRightBannerWidget.q;
            r0.zq(r6);
            return;
        L7:
            r6 = null;
            goto L8
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ TopRightBannerWidget a;

        public f(TopRightBannerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            BannerData r4 = (BannerData) r3;
            int r0 = TopRightBannerWidget.q;
            ALogger.i("TopRightBannerWidget", "request success, data=" + r4);
            BannerInRoomCollection r5 = r4.getData();
            if (k60.b.a() == false) goto L8;
            this.a.m = new e3(this, r5);
            if (k60.b.c() == false) goto L7;
            com.bytedance.android.live.core.utils.i0.d(this.a.m);
            return;
        L7:
            com.bytedance.android.live.core.utils.i0.i(c50.b.b(((Widget) this.a).dataCenter), this.a.m);
            return;
        L8:
            this.a.Eq(r5.getTopRightBanner());
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ TopRightBannerWidget a;

        public g(TopRightBannerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.i = true;
            int r0 = TopRightBannerWidget.q;
            ALogger.e("TopRightBannerWidget", "request failed", (Throwable) r3);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ TopRightBannerWidget a;

        public h(TopRightBannerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            TopRightBannerAdjustEvent r7 = (TopRightBannerAdjustEvent) r6;
            vo1.a r0 = this.a.a;
            if (r0 == null) goto L8;
            View r1 = r0.c();
            if (r1 == null) goto L9;
            int r2 = r1.getWidth();
            int r3 = com.bytedance.android.live.core.utils.s1.f(r7.getNewWidth());
            UIUtils.updateLayout(r1, r3, -3);
            this.a.Gq(Integer.valueOf(r3), Integer.valueOf(r1.getHeight()));
            int r4 = TopRightBannerWidget.q;
            ALogger.i("TopRightBannerWidget", "update layout. newWidth=" + r7 + ". origin is " + r2 + ", now is " + r3);
            return;
        L9:
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ TopRightBannerWidget a;

        public i(TopRightBannerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            zg1.n3 r4 = (zg1.n3) r3;
            int r1 = 0;
            if (VrUtils.t(((Widget) this.a).dataCenter, false) == false) goto L17;
            if (r4 != null) goto L7;
        L9:
            LinearLayout r5 = this.a.b;
            if (r5 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("staticContainer");
        L12:
            r5.setVisibility(r1);
            ImageView r6 = this.a.f;
            if (r6 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("mAnimateView");
        L15:
            r6.setVisibility(r1);
            return;
        L7:
            if (r4.a != true) goto L9;
            r1 = 8;
            goto L9
        }
    }

    public static final class j extends com.bytedance.android.live.core.tetris.task.a {
        public final void run() {
            b(true);
        }

        public j() {
            super("top_right_banner_load");
        }
    }

    public static final class k extends com.bytedance.android.live.core.utils.q0 {
        public final /* synthetic */ TopRightBannerWidget a;

        public k(TopRightBannerWidget r1) {
            this.a = r1;
        }

        public final void f(py.k r1, Exception r2) {
            LinearLayout r3 = this.a.b;
            if (r3 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("staticContainer");
        L5:
            r3.setVisibility(0);
            ImageView r4 = this.a.f;
            if (r4 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("mAnimateView");
        L8:
            r4.setVisibility(8);
        }

        public final void h(py.k r19, int r20, int r21) {
            TopRightBannerWidget r1 = this.a;
            ImageView r2 = r1.f;
            if (r2 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mAnimateView");
        L5:
            Object r3 = r2.getParent();
            if (r3 == null) goto L30;
            int r4 = ((View) r3).getWidth();
            ImageView r5 = r1.f;
            if (r5 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("mAnimateView");
        L10:
            float r6 = ((r4 - r5.getWidth()) * 0.5f) + com.bytedance.android.live.core.utils.s1.f(10.0f);
            ImageView r7 = r1.f;
            if (r7 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mAnimateView");
        L13:
            float r8 = (r7.getHeight() * 0.8f) + com.bytedance.android.live.core.utils.s1.f(10.0f);
            ImageView r9 = r1.f;
            if (r9 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("mAnimateView");
        L16:
            Object r10 = r9.getParent();
            if (r10 == null) goto L28;
            float r11 = r8 - ((View) r10).getHeight();
            AnimatorSet r12 = r1.g;
            if (r12 == null) goto L22;
            r12.removeAllListeners();
            r12.end();
        L22:
            ImageView r13 = r1.f;
            if (r13 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("mAnimateView");
        L25:
            f3 r14 = new f3(r1);
            AnimatorSet r15 = new AnimatorSet();
            AnimatorSet r16 = new AnimatorSet();
            r16.playTogether(new Animator[]{ObjectAnimator.ofFloat(r13, "scaleX", new float[]{0.0f, 1.1f}).setDuration(400), ObjectAnimator.ofFloat(r13, "scaleY", new float[]{0.0f, 1.1f}).setDuration(400), ObjectAnimator.ofFloat(r13, "alpha", new float[]{0.0f, 1.0f}).setDuration(400)});
            AnimatorSet r17 = new AnimatorSet();
            r17.playTogether(new Animator[]{ObjectAnimator.ofFloat(r13, "scaleX", new float[]{1.1f, 1.0f}).setDuration(400), ObjectAnimator.ofFloat(r13, "scaleY", new float[]{1.1f, 1.0f}).setDuration(400)});
            r15.playSequentially(new Animator[]{r16, r17});
            AnimatorSet r18 = new AnimatorSet();
            AnimatorSet r22 = new AnimatorSet();
            r22.playTogether(new Animator[]{ObjectAnimator.ofFloat(r13, "scaleX", new float[]{1.0f, 0.6f}).setDuration(800), ObjectAnimator.ofFloat(r13, "scaleY", new float[]{1.0f, 0.6f}).setDuration(800), ObjectAnimator.ofFloat(r13, "translationX", new float[]{0.0f, r6}).setDuration(800), ObjectAnimator.ofFloat(r13, "translationY", new float[]{0.0f, r11}).setDuration(800)});
            AnimatorSet r0 = new AnimatorSet();
            ObjectAnimator r23 = ObjectAnimator.ofFloat(r13, "rotation", new float[]{0.0f, 8.0f}).setDuration(120);
            ObjectAnimator r110 = ObjectAnimator.ofFloat(r13, "rotation", new float[]{8.0f, -8.0f}).setDuration(120);
            ObjectAnimator r111 = ObjectAnimator.ofFloat(r13, "rotation", new float[]{-8.0f, 0.0f}).setDuration(120);
            r0.setStartDelay(1000);
            r0.playSequentially(new Animator[]{r23, r110, r111});
            AnimatorSet r24 = new AnimatorSet();
            r24.playTogether(new Animator[]{ObjectAnimator.ofFloat(r13, "scaleX", new float[]{0.6f, 0.5f}).setDuration(400), ObjectAnimator.ofFloat(r13, "scaleY", new float[]{0.6f, 0.5f}).setDuration(400), ObjectAnimator.ofFloat(r13, "alpha", new float[]{1.0f, 0.0f}).setDuration(400)});
            r24.setStartDelay(2200);
            r18.playTogether(new Animator[]{r22, r0, r24});
            AnimatorSet r25 = new AnimatorSet();
            r25.playSequentially(new Animator[]{r15, r18});
            r25.addListener(r14);
            r1.g = r25;
            r25.start();
            return;
        L28:
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        L30:
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
    }

    static {
    }

    public final String getSpm() {
        return "a100.a100.a186";
    }

    public final Animator startShowAnimation() {
        return null;
    }

    public final int getLayoutId() {
        if (((Boolean) y3.a.getValue()).booleanValue() == false) goto L12;
        if (com.bytedance.android.live.core.utils.z.k(((Widget) this).dataCenter) == false) goto L7;
    L10:
        return 2131568038;
    L7:
        if (com.bytedance.android.live.core.utils.z.g(((Widget) this).dataCenter) == true) goto L10;
        return 2131568039;
    L12:
        if (com.bytedance.android.live.core.utils.z.k(((Widget) this).dataCenter) == false) goto L14;
    L17:
        return 2131568037;
    L14:
        if (com.bytedance.android.live.core.utils.z.g(((Widget) this).dataCenter) == true) goto L17;
        return 2131568036;
    }

    public final void onUnload() {
        ALogger.i("TopRightBannerWidget", "onUnload");
        this.i = false;
        this.k = false;
        com.bytedance.android.live.core.utils.i0.k(c50.b.b(((Widget) this).dataCenter), this.m);
        vlc.d r0 = this.c;
        if (r0 == null) goto L5;
        r0.removeMessageListener(this);
    L5:
        vo1.a r1 = this.a;
        if (r1 == null) goto L13;
        View r2 = r1.c();
        if (r2 == null) goto L13;
        LinearLayout r3 = this.b;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("staticContainer");
    L12:
        r3.removeView(r2);
    L13:
        View r4 = this.h;
        if (r4 == null) goto L22;
        View r5 = ((Widget) this).contentView;
        if ((r5 instanceof ViewGroup) == true) goto L18;
        r5 = null;
    L18:
        ViewGroup r6 = (ViewGroup) r5;
        if (r6 == null) goto L21;
        r6.removeView(r4);
    L21:
        this.h = null;
    L22:
        vo1.a r7 = this.a;
        if (r7 == null) goto L25;
        r7.release();
    L25:
        this.a = null;
        this.l = null;
        this.m = null;
        AnimatorSet r8 = this.g;
        if (r8 == null) goto L29;
        r8.removeAllListeners();
        r8.end();
    L29:
        Disposable r9 = this.p;
        if (r9 == null) goto L33;
        r9.dispose();
        return;
    }

    public final int supportClearScene() {
        if (((Boolean) com.bytedance.android.live.core.setting.l2.a.getValue()).booleanValue() == false) goto L5;
        return 281;
    L5:
        return 280;
    }

    public final View yq() {
        View r0 = new View(getContext());
        vo1.a r1 = this.a;
        View r2 = null;
        if (r1 == null) goto L5;
        View r3 = r1.c();
    L7:
        if (r3 == null) goto L9;
        int r5 = r3.getWidth();
    L10:
        if (r3 == null) goto L12;
        int r4 = r3.getHeight();
    L13:
        r0.setLayoutParams(new ViewGroup.LayoutParams(r5, r4));
        r0.setBackground(new ColorDrawable(0));
        this.h = r0;
        View r6 = ((Widget) this).contentView;
        if ((r6 instanceof ViewGroup) == false) goto L17;
        r2 = r6;
    L17:
        ViewGroup r7 = (ViewGroup) r2;
        if (r7 == null) goto L20;
        r7.addView(r0);
    L20:
        return r0;
    L12:
        r4 = 0;
        goto L13
    L9:
        r5 = 0;
        goto L10
    L5:
        r3 = null;
        goto L7
    }

    public TopRightBannerWidget() {
        this.o = new x40.d();
    }

    public final void Aq(BannerInRoomCollection.BannerInfo r13) {
        Fq("load banner check", false);
        String r0 = r13.getUrl();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L32;
        y50.c.d.b("top_right_banner_show_native");
        List r2 = r13.getBannerList();
        if (r2 != null) goto L14;
        ALogger.i("TopRightBannerWidget", "loadStaticBanners failed: no banner data");
        this.i = true;
    L31:
        int r3 = o6.a;
        o6.b(((Widget) this).dataCenter, r13.getBannerList().size());
    L36:
        DataCenter r14 = ((Widget) this).dataCenter;
        if (r14 == null) goto L39;
        r14.put("cmd_top_right_banner_load_url", Boolean.TRUE);
    L39:
        y50.c r15 = y50.c.d;
        r15.a("top_right_banner_show_native");
        r15.a("top_right_banner_show_front");
        return;
    L14:
        LinearLayout r6 = this.b;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("staticContainer");
    L17:
        r6.removeAllViews();
        Iterator r7 = r2.iterator();
    L19:
        if (r7.hasNext() == false) goto L30;
        com.bytedance.android.livesdk.gift.model.b1 r8 = (com.bytedance.android.livesdk.gift.model.b1) r7.next();
        LayoutInflater r9 = LayoutInflater.from(((Widget) this).context);
        LinearLayout r10 = this.b;
        if (r10 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("staticContainer");
    L23:
        View r11 = r9.inflate(2131566420, r10, false);
        ImageUtil.loadImage((ImageView) r11.findViewById(2131374718), r8.getImage(), 0);
        LinearLayout r12 = this.b;
        if (r12 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("staticContainer");
    L26:
        r12.setVisibility(0);
        LinearLayout r16 = this.b;
        if (r16 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("staticContainer");
    L29:
        r16.addView(r11);
        r11.setOnClickListener(new d3(r8, this));
        Cq(String.valueOf(r8.getId()), "live_banner_show");
        goto L19
    L30:
        this.i = true;
        ALogger.i("TopRightBannerWidget", "loadStaticBanners success. number=" + r2.size());
        goto L31
    L32:
        y50.c.d.b("top_right_banner_show_front");
        if (com.bytedance.android.livesdk.config.b0.a() == false) goto L35;
        AnchorMainPostOptUtils.c("loadDynamicBanner", ((Widget) this).dataCenter, this, new c(this, r13));
        goto L36
    L35:
        Bq(r13);
        goto L36
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    public final void Bq(BannerInRoomCollection.BannerInfo r17) {
        String r8 = null;
        if ((((Widget) this).context instanceof Activity) == true) goto L9;
        StringBuilder r0 = new StringBuilder("loadDynamicBanner: context = ");
        Context r1 = ((Widget) this).context;
        if (r1 == null) goto L7;
        r8 = r1.toString();
    L7:
        r0.append(r8);
        ALogger.e("TopRightBannerWidget", r0.toString());
        this.i = true;
        return;
    L9:
        int r2 = o6.a;
        o6.b(((Widget) this).dataCenter, 1);
        vo1.a r3 = this.a;
        if (r3 == null) goto L13;
        ALogger.i("TopRightBannerWidget", "release old component");
        r3.release();
        this.a = null;
    L13:
        if (this.a != null) goto L44;
        int r4 = vo1.e.a;
        this.a = new vo1.a();
        VSBannerInfo r5 = r17.castToOrNull(VSBannerInfo.class);
        if (r5 == null) goto L17;
        boolean r6 = r5.isLynxContainerEnabled();
    L19:
        if (r6 == true) goto L21;
    L33:
        long r7 = System.currentTimeMillis();
        com.bytedance.android.livesdk.chatroom.monitor.c r9 = this.n;
        if (r9 == null) goto L36;
        r9.d("lt_load_start");
    L36:
        vo1.a r10 = this.a;
        if (r10 == null) goto L43;
        Context r11 = ((Widget) this).context;
        if (r11 == null) goto L42;
        vo1.i.a.a(r10, (Activity) r11, r17.getUrl(), new a3(this, r17, r7), new b3(this));
        ALogger.i("TopRightBannerWidget", "create Container success");
        goto L43
    L42:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L43:
        String r12 = r17.getUrl();
    L45:
        vo1.a r13 = this.a;
        if (r13 == null) goto L59;
        View r14 = r13.c();
        if (r14 == null) goto L59;
        r14.setBackgroundColor(0);
        r14.setLayoutParams(new FrameLayout.LayoutParams(com.bytedance.android.live.core.utils.s1.f(112.0f), com.bytedance.android.live.core.utils.s1.f(36.0f)));
        LinearLayout r15 = this.b;
        if (r15 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("staticContainer");
    L52:
        r15.removeAllViews();
        LinearLayout r16 = this.b;
        if (r16 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("staticContainer");
    L55:
        r16.addView(r14);
        LinearLayout r18 = this.b;
        if (r18 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("staticContainer");
    L58:
        r18.setVisibility(0);
    L59:
        vo1.a r19 = this.a;
        if (r19 == null) goto L62;
        View r20 = r19.c();
    L63:
        com.bytedance.android.livesdk.r3.k(r20);
        yq();
        View r21 = ((Widget) this).contentView;
        if (r21 == null) goto L68;
        r21.setFocusable(true);
        r21.setFocusableInTouchMode(true);
        if (((Boolean) br.a.getValue()).booleanValue() == false) goto L68;
        r21.setOnHoverListener(y2.a);
    L68:
        com.bytedance.android.livesdk.r3.c(((Widget) this).contentView, "长触", true);
        vo1.a r22 = this.a;
        if (r22 == null) goto L71;
        r22.registerMethod("setContentDescription", new z2(this));
    L71:
        if (r12 != null) goto L73;
        return;
    L73:
        if (((Boolean) com.bytedance.android.live.core.setting.y1.a.getValue()).booleanValue() == false) goto L75;
        d r23 = new d(r12, this);
        com.bytedance.android.live.core.utils.i0.i(c50.b.b(((Widget) this).dataCenter), r23);
        return;
    L75:
        this.k = false;
        vo1.a r24 = this.a;
        if (r24 == null) goto L81;
        r24.loadUrl(r12);
        return;
    L81:
        return;
    L62:
        r20 = null;
        goto L63
    L21:
        if (((Boolean) com.bytedance.android.live.core.setting.e1.a.getValue()).booleanValue() == false) goto L33;
        long r25 = System.currentTimeMillis();
        com.bytedance.android.livesdk.chatroom.monitor.c r26 = this.n;
        if (r26 == null) goto L25;
        r26.d("lt_load_start");
    L25:
        vo1.a r110 = this.a;
        if (r110 == null) goto L32;
        String r111 = r17.lynxUrl;
        Context r27 = ((Widget) this).context;
        if (r27 == null) goto L31;
        r110.f((Activity) r27, r111, LynxThreadStrategy.ALL_ON_UI, new c3(r111, this, r17, r25));
        ALogger.i("TopRightBannerWidget", "create Container success");
        goto L32
    L31:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L32:
        r12 = r17.lynxUrl;
        goto L45
    L17:
        r6 = false;
        goto L19
    L44:
        this.i = true;
        r12 = "";
        goto L45
    }

    public final void Eq(BannerInRoomCollection.BannerInfo r8) {
        com.bytedance.android.livesdk.chatroom.monitor.c r0 = this.n;
        if (r0 == null) goto L5;
        r0.d("lt_fetch_data");
    L5:
        ALogger.i("TopRightBannerWidget", "showBannerAnimation: enter");
        if (r8 != null) goto L19;
        ALogger.i("TopRightBannerWidget", "showBannerAnimation: empty data");
        ImageView r9 = this.f;
        if (r9 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mAnimateView");
    L10:
        r9.setVisibility(8);
        LinearLayout r10 = this.b;
        if (r10 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("staticContainer");
    L13:
        r10.setVisibility(8);
        LinearLayout r11 = this.b;
        if (r11 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("staticContainer");
    L16:
        r11.removeAllViews();
        this.i = true;
        Fq("no banner info", false);
        int r12 = o6.a;
        o6.b(((Widget) this).dataCenter, 0);
        return;
    L19:
        if (r8.getAnimationImage() == null) goto L35;
        Room r5 = this.d;
        if (r5 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L24:
        if (r5.getStreamType() != LiveMode.VIDEO) goto L35;
        ImageView r1 = this.f;
        if (r1 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mAnimateView");
    L28:
        r1.setVisibility(0);
        LinearLayout r2 = this.b;
        if (r2 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("staticContainer");
    L31:
        r2.setVisibility(8);
        Aq(r8);
        ImageView r3 = this.f;
        if (r3 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mAnimateView");
    L34:
        ImageUtil.loadImage(r3, r8.getAnimationImage(), new k(this));
        return;
    L35:
        ALogger.i("TopRightBannerWidget", "showBannerAnimation: load data");
        Aq(r8);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.model.a
    public final boolean canControlByPlayer(PlayerViewControl.KEY r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (PadConfigUtils.c() == true) goto L13;
        DataContext r3 = this.dataContext;
        if (r3 == null) goto L13;
        Intrinsics.checkNotNull(r3);
        com.bytedance.android.livesdk.chatroom.r r4 = z51.a.d(r3);
        if (r4 == null) goto L13;
        if (r4.H(((Widget) this).dataCenter) != true) goto L13;
        if (com.bytedance.android.live.core.utils.z.m(((Widget) this).dataCenter, true) == true) goto L13;
        return true;
    L13:
        return false;
    }

    public final void onChanged(Object r7) {
        KVData r8 = (KVData) r7;
        if (isViewValid() == false) goto L59;
        if (r8 == null) goto L75;
        String r0 = r8.getKey();
        int r1 = r0.hashCode();
        int r3 = 0;
        if (r1 == (-1540323875)) goto L44;
        if (r1 == (-1143848920)) goto L29;
        if (r1 == 294674590) goto L14;
        return;
    L14:
        if (r0.equals("data_keyboard_status_douyin") == false) goto L60;
        Boolean r9 = (Boolean) r8.getData();
        ViewGroup r2 = ((Widget) this).containerView;
        if (Intrinsics.areEqual(r9, Boolean.TRUE) == false) goto L19;
    L26:
        r3 = 8;
    L27:
        UIUtils.setViewVisibility(r2, r3);
        return;
    L19:
        if (((Boolean) ((Widget) this).dataCenter.get("data_is_hiding_landscape_buttons", Boolean.FALSE)).booleanValue() == true) goto L26;
        if (((Boolean) l42.a.g.getValue()).booleanValue() == true) goto L26;
        if (isScreenPortrait() == true) goto L27;
        boolean r10 = isScreenPortrait();
        int r4 = com.bytedance.android.livesdk.utils.landscape.d.a;
        if ((!r10) == true) goto L27;
    L60:
        return;
    L29:
        if (r0.equals("data_activity_top_right_banner_show") == true) goto L31;
        return;
    L31:
        if (isScreenPortrait() == true) goto L63;
        zg1.m3 r11 = (zg1.m3) r8.getData();
        if (r11 != null) goto L35;
        return;
    L35:
        if (r11.b == 1) goto L37;
        return;
    L37:
        if (r11.a == true) goto L39;
        UIUtils.updateLayoutMargin(((Widget) this).containerView, -3, -3, 0, -3);
        return;
    L39:
        boolean r12 = isScreenPortrait();
        int r5 = com.bytedance.android.livesdk.utils.landscape.d.a;
        if ((!r12) == true) goto L42;
        UIUtils.updateLayoutMargin(((Widget) this).containerView, -3, -3, com.bytedance.android.live.core.utils.s1.f(4.0f), -3);
        return;
    L42:
        UIUtils.updateLayoutMargin(((Widget) this).containerView, -3, -3, 0, -3);
        return;
    L63:
        return;
    L44:
        if (r0.equals("cmd_pk_state_change") == false) goto L69;
        JSONObject r6 = new JSONObject();
        zg1.z0 r13 = (zg1.z0) r8.getData();
        if (r13 != null) goto L48;
    L52:
        if (r13 != null) goto L54;
        return;
    L54:
        if (r13.a != 1) goto L73;
        r6.put("is_pk", 0);
        vo1.a r14 = this.a;
        if (r14 == null) goto L74;
        r14.sendJsEvent("H5_PKStatusChange", r6);
        return;
    L74:
        return;
    L73:
        return;
    L48:
        if (r13.a != 0) goto L52;
        r6.put("is_pk", 1);
        vo1.a r15 = this.a;
        if (r15 == null) goto L70;
        r15.sendJsEvent("H5_PKStatusChange", r6);
        return;
    L70:
        return;
    L69:
        return;
    L75:
        return;
    }

    public final void onEnterClear(int r3) {
        if (r3 != 8) goto L5;
    L10:
        View r4 = ((Widget) this).contentView;
        if (r4 == null) goto L15;
        r4.setVisibility(8);
        return;
    L15:
        return;
    L5:
        if (r3 == 16) goto L10;
        if (r3 == 256) goto L10;
        if (r3 == 1) goto L10;
    }

    public final void onExitClear(int r2) {
        if (r2 != 8) goto L5;
    L10:
        View r3 = ((Widget) this).contentView;
        if (r3 == null) goto L15;
        r3.setVisibility(0);
        return;
    L15:
        return;
    L5:
        if (r2 == 16) goto L10;
        if (r2 == 256) goto L10;
        if (r2 == 1) goto L10;
    }

    public final void onInit(Object[] r2) {
        ALogger.i("TopRightBannerWidget", "onInit");
        this.b = (LinearLayout) ((Widget) this).contentView.findViewById(2131387275);
        this.f = (ImageView) ((Widget) this).contentView.findViewById(2131375988);
    }

    public final void onLoad(Object[] r9) {
        int r10 = 0;
        this.i = false;
        this.k = false;
        if (PerformanceTestSettings.TEST_DISABLE_LONG_TOUCH.getValue().booleanValue() == false) goto L5;
        return;
    L5:
        ALogger.i("TopRightBannerWidget", "onLoad");
        Fq("onLoad check", false);
        Room r0 = (Room) ((Widget) this).dataCenter.get("data_room", new Room());
        this.d = r0;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L8:
        long r2 = r0.id;
        int r1 = com.bytedance.android.livesdk.chatroom.monitor.a.a;
        Boolean r4 = null;
        if (((Boolean) LiveInfraSettingKeys.LIVE_ACTIVIY_TIME_MONITOR_SWITCH.getValue()).booleanValue() == false) goto L11;
        com.bytedance.android.livesdk.chatroom.monitor.c r3 = new com.bytedance.android.livesdk.chatroom.monitor.c(r2);
    L12:
        this.n = r3;
        this.e = gb2.a.a(((Widget) this).dataCenter, false);
        vlc.d r5 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        if (r5 == null) goto L15;
        r5.addMessageListener(MessageType.IN_ROOM_BANNER_MESSAGE.getIntType(), this);
        r5.addMessageListener(MessageType.ANCHOR_TASK_MESSAGE.getIntType(), this);
        r5.addMessageListener(MessageType.GIFT.getIntType(), this);
        r5.addMessageListener(MessageType.DOODLE_GIFT.getIntType(), this);
        Unit r6 = Unit.INSTANCE;
    L16:
        this.c = r5;
        this.e = gb2.a.a(((Widget) this).dataCenter, false);
        vlc.d r7 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        if (r7 == null) goto L19;
        r7.addMessageListener(MessageType.IN_ROOM_BANNER_MESSAGE.getIntType(), this);
        r7.addMessageListener(MessageType.ANCHOR_TASK_MESSAGE.getIntType(), this);
        r7.addMessageListener(MessageType.GIFT.getIntType(), this);
        r7.addMessageListener(MessageType.DOODLE_GIFT.getIntType(), this);
        Unit r8 = Unit.INSTANCE;
    L20:
        this.c = r7;
        InRoomBannerManager r11 = (InRoomBannerManager) ((Widget) this).dataCenter.get("data_in_room_banner_manager", null);
        if (r11 == null) goto L31;
        IRoom r12 = gb2.a.e(((Widget) this).dataCenter);
        if (r12 == null) goto L25;
        Long r13 = Long.valueOf(r12.getId());
    L26:
        Observable r14 = r11.d(Long.valueOf(r13.longValue()), 2);
        if (r14 == null) goto L31;
        ObservableSubscribeProxy r15 = (ObservableSubscribeProxy) r14.as(autoDispose());
        if (r15 == null) goto L31;
        r15.subscribe(new f(this), new g(this));
        goto L31
    L25:
        r13 = null;
    L31:
        ((Widget) this).dataCenter.observeForever("data_keyboard_status_douyin", this);
        ((Widget) this).dataCenter.observeForever("cmd_pk_state_change", this);
        ((Widget) this).dataCenter.observeForever("data_activity_top_right_banner_show", this);
        ((ObservableSubscribeProxy) RxUtilKt.h(xs2.b.a().b(TopRightBannerAdjustEvent.class)).as(autoDispose())).subscribe(new h(this));
        if (VrUtils.t(((Widget) this).dataCenter, false) == false) goto L47;
        ((ObservableSubscribeProxy) RxUtilKt.h(RxBusAbility.INSTANCE.getRxBus(((Widget) this).dataCenter).b(zg1.n3.class)).as(autoDispose())).subscribe(new i(this));
        IRoomContextService r16 = jc1.k.f(IRoomContextService.class);
        if (r16 == null) goto L40;
        com.bytedance.android.livesdk.chatroom.o r17 = IRoomContextService.a.a(r16, ((Widget) this).dataCenter, 0, 2);
        if (r17 == null) goto L40;
        com.bytedance.live.datacontext.m r18 = r17.A1();
        if (r18 == null) goto L40;
        Boolean r19 = (Boolean) r18.getValue();
    L41:
        View r20 = ((Widget) this).contentView;
        if (r20 == null) goto L47;
        if (Intrinsics.areEqual(r19, Boolean.TRUE) == false) goto L46;
        r10 = 8;
    L46:
        r20.setVisibility(r10);
    L40:
        r19 = null;
    L47:
        final j r21 = new j();
        this.l = r21;
        DataContext r22 = this.dataContext;
        if (r22 == null) goto L52;
        com.bytedance.android.livesdk.chatroom.r r23 = z51.a.d(r22);
        if (r23 == null) goto L52;
        r23.j("public_screen");
    L52:
        com.bytedance.android.livesdk.chatroom.o r24 = com.bytedance.android.livesdk.chatroom.utils.o3.f();
        if (r24 == null) goto L57;
        com.bytedance.live.datacontext.j r25 = r24.B2();
        if (r25 == null) goto L57;
        r25.c(new AnonymousClass8(this, r21));
    L57:
        Room r26 = this.d;
        if (r26 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L61:
        if (r26.isMergeVSRoom() == true) goto L70;
        DataContext r27 = this.dataContext;
        if (r27 == null) goto L67;
        com.bytedance.android.livesdk.chatroom.r r28 = z51.a.d(r27);
        if (r28 == null) goto L67;
        Boolean r29 = Boolean.valueOf(r28.k());
    L69:
        if (Intrinsics.areEqual(r29, Boolean.TRUE) == true) goto L70;
    L76:
        if (((Boolean) y3.a.getValue()).booleanValue() == false) goto L96;
        Room r30 = this.d;
        if (r30 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L80:
        if (r30 != null) goto L82;
        return;
    L82:
        if (r30.isPrivatePlay() != true) goto L98;
        com.bytedance.android.livesdk.chatroom.o r31 = z51.a.h(((Widget) this).dataCenter, 2);
        if (r31 == null) goto L92;
        com.bytedance.live.datacontext.m r32 = r31.getRoom();
        if (r32 == null) goto L92;
        IRoom r33 = (IRoom) r32.getValue();
        if (r33 == null) goto L92;
        RoomExtra r34 = r33.getExtra();
        if (r34 == null) goto L92;
        r4 = Boolean.valueOf(r34.isGroupLiveScene());
    L92:
        if (r4 != null) goto L94;
        MiddlewareRoomContext r35 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        ToolbarLoadTimeStatsVM.a r36 = ToolbarLoadTimeStatsVM.Companion;
        AutoDisposeConverter r37 = autoDispose();
        e r38 = new e(this);
        r36.getClass();
        ToolbarLoadTimeStatsVM.a.a(r37, r35, r38);
        return;
    L94:
        zq(r4);
        return;
    L98:
        return;
    L96:
        return;
    L67:
        r29 = null;
    L70:
        lk1.c.a r39 = lk1.c.i2;
        DataCenter r40 = ((Widget) this).dataCenter;
        r39.getClass();
        com.bytedance.android.live.core.arch.mvvm.d r41 = lk1.c.a.a(r40).observeStatusChanged("room_auth_long_touch");
        if (r41 == null) goto L73;
        Disposable r42 = RxUtilKt.n(r41, new TopRightBannerWidget$observeRoomAuth$1(this));
    L74:
        this.p = r42;
        goto L76
    L73:
        r42 = null;
        goto L74
    L19:
        r7 = null;
        goto L20
    L15:
        r5 = null;
        goto L16
    L11:
        r3 = null;
        goto L12
    }

    public final void onMessage(tlc.d r13) {
        String r1 = "";
        BannerInRoomCollection.BannerInfo r2 = null;
        if ((r13 instanceof com.bytedance.android.live.base.model.message.h1) == false) goto L78;
        com.bytedance.android.live.base.model.message.h1 r0 = (com.bytedance.android.live.base.model.message.h1) r13;
        if (r0.getPosition() != 2) goto L78;
        if (this.i == true) goto L9;
        ALogger.i("TopRightBannerWidget", "discard InRoomBannerMessage");
        return;
    L9:
        JSONObject r14 = new JSONObject();
        r14.put("type", "refresh");
        r14.put("data", GsonProtectorUtils.toJson(GsonHelper.get(), r0.getExtra()));
        JSONObject r5 = new JSONObject();
        com.bytedance.android.livesdk.log.filter.t r6 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r6 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L28;
        com.bytedance.android.livesdk.log.filter.t r7 = r6;
        if (r7.getMap().containsKey("enter_from") == false) goto L15;
        String r8 = (String) r7.getMap().get("enter_from");
        if (r8 == null) goto L15;
    L17:
        if (r7.getMap().containsKey("source") == false) goto L22;
        String r9 = (String) r7.getMap().get("source");
        if (r9 == null) goto L22;
        r1 = r9;
    L22:
        HashMap r10 = new HashMap();
        DataContext r11 = this.dataContext;
        if (r11 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.r r12 = z51.a.d(r11);
        if (r12 == null) goto L27;
        r12.dataMapping(r8, r1, r10);
    L27:
        r1 = (String) r10.get("enter_from_merge");
        String r15 = (String) r10.get("enter_method");
    L29:
        JSONObject r3 = r5.put("enter_from_merge", r1).put("enter_method", r15);
        if (this.e == false) goto L32;
        String r16 = "live_take_detail";
    L33:
        JSONObject r4 = r3.put("event_page", r16);
        Room r17 = this.d;
        if (r17 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L36:
        JSONObject r18 = r4.put("room_id", String.valueOf(r17.id));
        Room r19 = this.d;
        if (r19 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L39:
        JSONObject r20 = r18.put("anchor_id", r19.getOwnerUserIdString());
        Room r21 = this.d;
        if (r21 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L42:
        JSONObject r22 = r20.put("request_id", r21.getRequestId());
        Room r23 = this.d;
        if (r23 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L45:
        r22.put("log_pb", r23.getLog_pb());
        r14.put("log", r5);
        if (this.a != null) goto L48;
    L51:
        boolean r24 = true;
    L52:
        if (r24 == true) goto L54;
        ALogger.i("TopRightBannerWidget", "update banner status");
        vo1.a r25 = this.a;
        if (r25 == null) goto L135;
        r25.sendJsEvent("H5_roomStatusChange", r14);
        return;
    L135:
        return;
    L54:
        if (r0.getOperationType() != 1) goto L133;
        ALogger.i("TopRightBannerWidget", "load banner using InRoomBannerMessage");
        String r26 = r0.getH5Url();
        if (r26 != null) goto L58;
    L61:
        boolean r27 = true;
    L62:
        if (r27 == false) goto L72;
        String r28 = r0.getLynxUrl();
        if (r28 != null) goto L66;
    L69:
        boolean r29 = true;
    L70:
        if (r29 == false) goto L72;
    L73:
        this.i = false;
        Eq(r2);
        return;
    L66:
        if (r28.length() == 0) goto L69;
        r29 = false;
    L72:
        BannerInRoomCollection.BannerInfo r30 = new BannerInRoomCollection.BannerInfo();
        r30.setH5Url(r0.getH5Url());
        r30.lynxUrl = r0.getLynxUrl();
        r30.setContainerType(r0.getContainerType());
        r30.setBannerList(null);
        r30.isLoadMessageBanner = true;
        r30.loadMessageBannerJson = r14;
        r2 = r30;
        goto L73
    L58:
        if (r26.length() == 0) goto L61;
        r27 = false;
        goto L62
    L133:
        return;
    L48:
        if (this.k == true) goto L51;
        r24 = false;
        goto L52
    L32:
        r16 = "live_detail";
    L15:
        r8 = "";
        goto L17
    L28:
        r15 = "";
    L78:
        if ((r13 instanceof IAnchorTaskMessage) == false) goto L89;
        HashMap r31 = new HashMap();
        IAnchorTaskMessage r110 = (IAnchorTaskMessage) r13;
        r31.put("action", Integer.valueOf(r110.getAction()));
        List r111 = r110.getTaskRecords();
        if (r111 == null) goto L85;
        String r112 = r111.toString();
        if (r112 == null) goto L85;
        r1 = r112;
    L85:
        r31.put("task_records", r1);
        String r113 = GsonProtectorUtils.toJson(GsonHelper.get(), r31).toString();
        vo1.a r32 = this.a;
        if (r32 == null) goto L137;
        r32.sendJsEvent("H5_refreshTaskInfo", r113);
        return;
    L137:
        return;
    L89:
        if ((r13 instanceof n5) == false) goto L139;
        n5 r114 = (n5) r13;
        if (r114.getFromUser() != null) goto L93;
        return;
    L93:
        if (jc1.k.f(IMiddlewareUserService.class) == null) goto L143;
        com.bytedance.android.livesdk.user.e r33 = jc1.k.n(IMiddlewareUserService.class).user();
        if (r33 == null) goto L141;
        String r34 = r33.n();
        IBaseUser r35 = r114.getFromUser();
        if (r35 == null) goto L101;
        r2 = r35.getIdString();
    L101:
        if ((!Intrinsics.areEqual(r34, r2)) == false) goto L104;
        return;
    L104:
        if (r114.getClientGiftSource() != 1) goto L106;
    L111:
        com.bytedance.android.livesdk.gift.model.h2 r36 = r114.getGift();
    L112:
        if (r36 != null) goto L115;
        return;
    L115:
        if (r36.getType() == 1) goto L119;
        if (r36.getType() == 15) goto L119;
    L121:
        if (r36.getType() == 1) goto L142;
    L122:
        HashMap r37 = new HashMap();
        ArrayList r38 = new ArrayList();
        if (r36.getType() == 1) goto L127;
        if (r36.getType() == 15) goto L127;
    L129:
        r38.add(new b(r114.getGiftId(), r114.getGroupCount()));
    L130:
        r37.put("gift_list", r38);
        jc1.k.n(IBaseBrowserService.class).sendEventToAllJsBridges("H5_sendGiftStatusChange", GsonProtectorUtils.toJson(GsonHelper.get(), r37).toString());
        return;
    L127:
        if (r114.getRepeatEnd() != 1) goto L129;
        r38.add(new b(r114.getGiftId(), r114.getRepeatCount()));
        goto L130
    L142:
        return;
    L119:
        if (r114.getRepeatEnd() == 1) goto L122;
    L106:
        if (r114.getClientGiftSource() == 0) goto L108;
    L110:
        boolean r39 = com.bytedance.android.live.revenue.core.util.h.a;
        r36 = com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).findLiteGiftById(r114.getGiftId());
        goto L112
    L108:
        if (r114.getGift() == null) goto L110;
    L141:
        return;
    L143:
        return;
    }

    public final void zq(Boolean r2) {
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

    public final void Cq(String r10, String r11) {
        HashMap r0 = new HashMap();
        r0.put("banner_id", r10);
        r0.put("request_page", "topright");
        if (isScreenPortrait() == false) goto L5;
        String r12 = "0";
    L6:
        r0.put("room_orientation", r12);
        qm0.b r13 = om0.c.g();
        String r2 = "live_take_detail";
        if (r13 == null) goto L13;
        Object[] r7 = new Object[3];
        r7[0] = Room.class;
        am2.x r6 = new am2.x();
        r6.a = "live_function";
        if (this.e == true) goto L12;
        r2 = "live_detail";
    L12:
        r6.b = r2;
        r7[1] = r6;
        r7[2] = new am2.z();
        r13.sendLog(r11, r0, r7);
        return;
    L13:
        com.bytedance.android.livesdk.log.j0 r14 = com.bytedance.android.livesdk.log.j0.l();
        Object[] r8 = new Object[3];
        r8[0] = Room.class;
        am2.x r9 = new am2.x();
        r9.a = "live_function";
        if (this.e == true) goto L17;
        r2 = "live_detail";
    L17:
        r9.b = r2;
        r8[1] = r9;
        r8[2] = new am2.z();
        r14.sendLog(r11, r0, r8);
        return;
    L5:
        r12 = "1";
        goto L6
    }

    public final void Fq(String r5, boolean r6) {
        boolean r1 = true;
        if (isScreenLandscape() == false) goto L19;
        boolean r0 = isScreenPortrait();
        int r2 = com.bytedance.android.livesdk.utils.landscape.d.a;
        if ((!r0) == false) goto L18;
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L11;
        if (((Boolean) r3.get("data_is_hiding_landscape_buttons", Boolean.FALSE)).booleanValue() == true) goto L18;
    L11:
        if (this.dataContext == null) goto L18;
        if (((Boolean) l42.a.g.getValue()).booleanValue() == false) goto L19;
        DataContext r4 = this.dataContext;
        Intrinsics.checkNotNull(r4);
        com.bytedance.android.livesdk.chatroom.r r7 = z51.a.d(r4);
        if (r7 == null) goto L18;
        if (r7.H(((Widget) this).dataCenter) == true) goto L19;
    L18:
        r1 = false;
    L19:
        if (r1 == false) goto L21;
        if (r6 == true) goto L21;
        return;
    L21:
        ViewGroup r8 = ((Widget) this).containerView;
        if (r8 == null) goto L24;
        UtilityKotlinExtentionsKt.t(r8);
    L24:
        ALogger.i("TopRightBannerWidget", "hide. reason=".concat(r5));
    }

    public final void Gq(Integer r3, Integer r4) {
        vo1.a r0 = this.a;
        if (r0 == null) goto L18;
        View r1 = r0.c();
        if (r1 == null) goto L19;
        View r2 = this.h;
        if (r2 != null) goto L10;
        r2 = yq();
    L10:
        if (r3 == null) goto L12;
        int r5 = r3.intValue();
    L13:
        if (r4 == null) goto L15;
        int r6 = r4.intValue();
    L16:
        UIUtils.updateLayout(r2, r5, r6);
        return;
    L15:
        r6 = r1.getHeight();
        goto L16
    L12:
        r5 = r1.getWidth();
        goto L13
    L19:
        return;
    }

    public static final void xq(TopRightBannerWidget r10, String r11, String r12, boolean r13) {
        r10.getClass();
        ALogger.e("TopRightBannerWidget", "onReceiveError, url=" + r11 + ", msg=" + r12);
        r10.k = true;
        j r0 = r10.l;
        if (r0 == null) goto L5;
        r0.b(false);
    L5:
        View r1 = ((Widget) r10).contentView;
        if (r1 == null) goto L8;
        UtilityKotlinExtentionsKt.u(r1);
    L8:
        r10.i = true;
        Room r14 = r10.d;
        if (r14 == null) goto L11;
        r10.j = Long.valueOf(r14.id).longValue();
    L11:
        x40.d r15 = r10.o;
        int r2 = ActivityMonitor.ActivityStatusCode.UNKNOWN_CODE.getCode();
        if (r13 == false) goto L14;
        ActivityHybridMonitor.ContainerType r16 = ActivityHybridMonitor.ContainerType.WEB;
    L15:
        String r5 = String.valueOf(r10.j);
        int r17 = x40.d.a;
        r15.getClass();
        x40.d.a(r2, "onReceiveError", r16, "-1", r5, r11, null, 0);
        return;
    L14:
        r16 = ActivityHybridMonitor.ContainerType.LYNX;
        goto L15
    }

    public static final void wq(TopRightBannerWidget r10, BannerInRoomCollection.BannerInfo r11, String r12, long r13, boolean r15) {
        r10.getClass();
        ALogger.i("TopRightBannerWidget", "onPageFinished. url=" + r12);
        com.bytedance.android.livesdk.chatroom.monitor.c r0 = r10.n;
        if (r0 == null) goto L5;
        r0.d("lt_load_finish");
        r0.g();
    L5:
        r10.Gq(null, null);
        if (r11.isLoadMessageBanner == true) goto L8;
    L15:
        JSONObject r1 = new JSONObject();
        r1.put("data", JsonUtil.toJSONString(r11.getBannerList()));
        r1.put("type", "init");
        vo1.a r14 = r10.a;
        if (r14 == null) goto L18;
        r14.sendJsEvent("H5_roomStatusChange", r1);
    L18:
        j r16 = r10.l;
        if (r16 == null) goto L22;
        r16.b(true);
    L22:
        if (r10.k == true) goto L25;
        UtilityKotlinExtentionsKt.w(((Widget) r10).contentView);
    L25:
        if (VrUtils.t(((Widget) r10).dataCenter, false) == false) goto L33;
        DataContext r17 = r10.dataContext;
        Intrinsics.checkNotNull(r17);
        com.bytedance.android.livesdk.chatroom.r r18 = z51.a.d(r17);
        if (r18 == null) goto L33;
        if (r18.A1() != true) goto L33;
        View r19 = ((Widget) r10).contentView;
        if (r19 == null) goto L33;
        r19.setVisibility(8);
    L33:
        r10.i = true;
        Room r110 = r10.d;
        if (r110 == null) goto L36;
        r10.j = Long.valueOf(r110.id).longValue();
    L36:
        x40.d r111 = r10.o;
        int r2 = ActivityMonitor.ActivityStatusCode.SUCCESS.getCode();
        if (r15 == false) goto L39;
        ActivityHybridMonitor.ContainerType r112 = ActivityHybridMonitor.ContainerType.WEB;
    L40:
        String r5 = String.valueOf(r10.j);
        long r8 = System.currentTimeMillis() - r13;
        r111.getClass();
        x40.d.a(r2, "onLoadSuccess", r112, "1", r5, r12, null, r8);
        return;
    L39:
        r112 = ActivityHybridMonitor.ContainerType.LYNX;
        goto L40
    L8:
        if (r11.loadMessageBannerJson == null) goto L15;
        JSONObject r3 = new JSONObject();
        r3.put("type", "init");
        r3.put("data", "[]");
        vo1.a r4 = r10.a;
        if (r4 == null) goto L12;
        r4.sendJsEvent("H5_roomStatusChange", r3);
    L12:
        vo1.a r6 = r10.a;
        if (r6 == null) goto L18;
        r6.sendJsEvent("H5_roomStatusChange", r11.loadMessageBannerJson);
        goto L18
    }
}
