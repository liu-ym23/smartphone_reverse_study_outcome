package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.IMiddleHostService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostConfig;
import com.bytedance.android.livehostapi.platform.depend.IMiddlewareHostAppConfig;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.config.gk0;
import com.bytedance.android.livesdk.config.mk0;
import com.bytedance.android.livesdk.config.ok0;
import com.bytedance.android.livesdk.config.rm;
import com.bytedance.android.livesdk.config.sw;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.a0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.b0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.c0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.d0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.y;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.z;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.android.livesdk.interactivity.zdanmaku.binder.h0;
import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.settingmanager.SimpleSettingManager;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.setting.LivePreviewDanmakuConfig;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.artist.core.CoreEngine;
import com.bytedance.live.zdanmaku.DanmakuController;
import com.bytedance.live.zdanmaku.data.Danmaku;
import com.bytedance.live.zdanmaku.render.canvas.RenderEngineView;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import ec2.k1;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p22.n;
import p22.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/simplewidget/PortraitSimpleZDanmakuWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lcom/bytedance/android/livesdk/interactivity/zdanmaku/simplewidget/PortraitSimpleZDanmakuPresenter$IView;", "Lap2/b;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PortraitSimpleZDanmakuWidget extends MiddlewareRoomRecyclableWidget implements PortraitSimpleZDanmakuPresenter.IView, ap2.b {
    public static final /* synthetic */ int p = 0;
    public RenderEngineView a;
    public n b;
    public com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> c;
    public h d;
    public PortraitSimpleZDanmakuPresenter e;
    public BarrageWidgetContext f;
    public final CompositeDisposable g;
    public Disposable h;
    public Room i;
    public boolean j;
    public boolean k;
    public final b l;
    public boolean m;
    public Disposable n;
    public boolean o;

    public static final class a {
    }

    public static final class b implements DanmakuController.b<com.bytedance.android.livesdk.interactivity.zdanmaku.i> {
        public final /* synthetic */ PortraitSimpleZDanmakuWidget a;

        public b(PortraitSimpleZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void a(Danmaku r3) {
            com.bytedance.android.livesdk.interactivity.zdanmaku.i r4 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r3;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            PortraitSimpleZDanmakuPresenter r1 = this.a.e;
            if (r1 == null) goto L6;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            r1.e.k();
            return;
        }

        public final void b(Danmaku r7) {
            com.bytedance.android.livesdk.interactivity.zdanmaku.i r8 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r7;
            Intrinsics.checkNotNullParameter(r8, "danmaku");
            this.a.getUnRecyclableData();
            PortraitSimpleZDanmakuWidget r1 = this.a;
            PortraitSimpleZDanmakuPresenter r2 = r1.e;
            if (r2 == null) goto L18;
            boolean r3 = r1.k;
            Intrinsics.checkNotNullParameter(r8, "danmaku");
            if (r3 == true) goto L7;
            i.b("danmaku is not preview valid");
        L7:
            if (r3 == false) goto L18;
            if (r2.j0() == false) goto L18;
            PortraitSimpleZDanmakuPresenter.IView r9 = ((q46.b) r2).a;
            if (r9 == null) goto L13;
            int r10 = r9.U();
        L14:
            if (r10 != 0) goto L18;
            if (((LinkedList) r2.e.c).size() != 0) goto L18;
            i.c("history danmaku end");
            r2.h0();
            r2.i0(4);
            goto L18
        L13:
            r10 = 0;
        L18:
            PortraitSimpleZDanmakuWidget r11 = this.a;
            if (r11.m == true) goto L56;
            r11.m = true;
            LinkedHashMap r0 = new LinkedHashMap();
            r0.put("event_page", "live");
            DataCenter r4 = ((Widget) r11).dataCenter;
            String r5 = BuildConfig.FLAVOR;
            if (r4 == null) goto L43;
            Bundle r6 = (Bundle) r4.get("data_preview_outer_merge_data", new Bundle());
            if (r6 == null) goto L43;
            String r13 = r6.getString("request_id");
            if (r13 != null) goto L31;
            Room r14 = r11.i;
            if (r14 == null) goto L30;
            r13 = r14.getRequestId();
            goto L31
        L30:
            r13 = null;
        L31:
            if (r13 != null) goto L33;
            r13 = BuildConfig.FLAVOR;
        L33:
            r0.put("request_id", r13);
            String r15 = r6.getString("enter_method");
            if (r15 != null) goto L36;
            r15 = BuildConfig.FLAVOR;
        L36:
            r0.put("enter_method", r15);
            String r16 = r6.getString("enter_from_merge");
            if (r16 != null) goto L39;
            r16 = BuildConfig.FLAVOR;
        L39:
            r0.put("enter_from_merge", r16);
            String r17 = r6.getString("action_type");
            if (r17 != null) goto L42;
            r17 = BuildConfig.FLAVOR;
        L42:
            r0.put("action_type", r17);
        L43:
            Room r18 = r11.i;
            if (r18 == null) goto L47;
            String r19 = r18.getIdStr();
            if (r19 == null) goto L47;
        L48:
            r0.put("room_id", r19);
            Room r20 = r11.i;
            if (r20 == null) goto L54;
            String r21 = r20.getOwnerUserIdString();
            if (r21 == null) goto L54;
            r5 = r21;
        L54:
            r0.put("anchor_id", r5);
            j0.l().sendLog("livesdk_preview_bullet_comment_show", r0, new Object[0]);
            return;
        L47:
            r19 = BuildConfig.FLAVOR;
            goto L48
        }
    }

    public static final class c<T> implements h80.d {
        public final /* synthetic */ PortraitSimpleZDanmakuWidget a;

        public c(PortraitSimpleZDanmakuWidget r1) {
            this.a = r1;
        }

        public final Object get() {
            return this.a.b;
        }
    }

    public static final class d<T> implements h80.d {
        public final /* synthetic */ PortraitSimpleZDanmakuWidget a;

        public d(PortraitSimpleZDanmakuWidget r1) {
            this.a = r1;
        }

        public final Object get() {
            return this.a.f;
        }
    }

    public static final class e implements com.bytedance.live.zdanmaku.data.c<com.bytedance.android.livesdk.interactivity.zdanmaku.i> {
        public e() {
        }

        public final com.bytedance.android.livesdk.interactivity.zdanmaku.i a() {
            return new com.bytedance.android.livesdk.interactivity.zdanmaku.i();
        }
    }

    public static final class f implements Function1<com.bytedance.android.livesdk.interactivity.zdanmaku.i, Boolean> {
        public boolean a;
        public final /* synthetic */ PortraitSimpleZDanmakuWidget b;

        public f(PortraitSimpleZDanmakuWidget r1) {
            this.b = r1;
        }

        public final Object invoke(Object r3) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.interactivity.zdanmaku.i) r3, "p1");
            if (this.a == true) goto L12;
            h r4 = this.b.d;     // Catch: Throwable -> L8
            if (r4 == null) goto L10;
            r4.a();     // Catch: Throwable -> L8
        L10:
            this.a = true;
        L8:
            th = move-exception;
            int r0 = i.a;
            i.b("resetLines error: " + th.getMessage());
        L12:
            return Boolean.TRUE;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566756;
    }

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.PortraitSimpleZDanmakuPresenter.IView
    public final int U() {
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.c;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.c();
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.PortraitSimpleZDanmakuPresenter.IView
    public final boolean isEnablePreviewDanmaku() {
        Room r0 = this.i;
        if (r0 != null) goto L9;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L7;
        r0 = (Room) r1.get("data_room", null);
        goto L9
    L7:
        r0 = null;
    L9:
        if (r0 == null) goto L13;
        RoomAuthStatus r2 = r0.getRoomAuthStatus();
        if (r2 == null) goto L13;
        boolean r3 = r2.isEnablePreviewDanmaku();
    L14:
        if (r3 == true) goto L16;
    L18:
        return false;
    L16:
        if (this.b.a == false) goto L18;
        return true;
    L13:
        r3 = true;
        goto L14
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.PortraitSimpleZDanmakuPresenter.IView
    public final void jR() {
        if (this.j == true) goto L9;
        RenderEngineView r0 = this.a;
        if (r0 != null) goto L8;
        i.b("renderEngineView is null");
        return;
    L8:
        wq(r0);
    L9:
        Disposable r1 = this.h;
        if (r1 != null) goto L12;
    L13:
        PortraitSimpleZDanmakuPresenter r2 = this.e;
        if (r2 != null) goto L16;
    L17:
        int r3 = i.a;
        StringBuilder r4 = new StringBuilder("PortraitSimpleZDanmakuWidget.startDanmakuValidTimer, widget.hashCode: ");
        r4.append(hashCode());
        r4.append(", room.hashCode: ");
        Room r5 = this.i;
        Long r6 = null;
        if (r5 == null) goto L20;
        Integer r7 = Integer.valueOf(r5.hashCode());
    L21:
        r4.append(r7);
        r4.append(", roomId: ");
        Room r8 = this.i;
        if (r8 == null) goto L24;
        r6 = Long.valueOf(r8.id);
    L24:
        r4.append(r6);
        i.c(r4.toString());
        long r9 = LivePreviewDanmakuConfig.Companion.getDanmakuTimeoutTime();
        Disposable r10 = this.h;
        if (r10 == null) goto L27;
        r10.dispose();
    L27:
        this.h = Observable.interval(r9, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.e(this, r9));
        return;
    L20:
        r7 = null;
        goto L21
    L16:
        if (r2.j0() != true) goto L17;
        return;
    L12:
        if (r1.isDisposed() == true) goto L13;
    }

    public final void onUnload() {
        int r0 = i.a;
        StringBuilder r1 = new StringBuilder("PortraitSimpleZDanmakuWidget.onUnload, widget.hashCode: ");
        r1.append(hashCode());
        r1.append(", room.hashCode: ");
        Room r2 = this.i;
        if (r2 == null) goto L5;
        Integer r3 = Integer.valueOf(r2.hashCode());
    L6:
        r1.append(r3);
        r1.append(", roomId: ");
        Room r4 = this.i;
        if (r4 == null) goto L9;
        Long r5 = Long.valueOf(r4.id);
    L10:
        r1.append(r5);
        i.c(r1.toString());
        if (i.a() == true) goto L16;
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r6 = this.c;
        if (r6 == null) goto L15;
        r6.e();
    L15:
        this.c = null;
        this.d = null;
        this.j = false;
    L16:
        PortraitSimpleZDanmakuPresenter r7 = this.e;
        if (r7 == null) goto L19;
        r7.detachView();
    L19:
        this.e = null;
        this.g.clear();
        Disposable r8 = this.h;
        if (r8 == null) goto L22;
        r8.dispose();
    L22:
        this.h = null;
        getUnRecyclableData();
        this.m = false;
        this.k = false;
        Disposable r9 = this.n;
        if (r9 == null) goto L26;
        r9.dispose();
        return;
    L26:
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.PortraitSimpleZDanmakuPresenter.IView
    public final void ps() {
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.c;
        if (r0 == null) goto L17;
        CoreEngine r1 = r0.b;
        if (r1 == null) goto L7;
        boolean r2 = r1.f;
    L9:
        if (r2 != true) goto L18;
        if (r0 != null) goto L12;
        return;
    L12:
        if (r0.g.a() == true) goto L20;
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r3 = this.c;
        if (r3 == null) goto L21;
        r3.postRunnable(new com.bytedance.live.zdanmaku.g(r3));
        return;
    L21:
        return;
    L20:
        return;
    L18:
        return;
    L7:
        r2 = false;
        goto L9
    }

    public PortraitSimpleZDanmakuWidget() {
        com.bytedance.android.livesdk.sharedpref.e<Integer> r0 = SimpleSettingManager.a;
        if (((Boolean) rm.a.getValue()).booleanValue() == false) goto L5;
        o r1 = SimpleSettingManager.c();
    L6:
        RenderEngineView r2 = this.a;
        if (r2 == null) goto L17;
        Integer r3 = Integer.valueOf(r2.getWidth());
        if (r3.intValue() <= 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == true) goto L15;
        r3 = null;
    L15:
        if (r3 == null) goto L17;
        int r5 = r3.intValue();
    L18:
        this.b = SimpleSettingManager.a(r1, r5);
        this.g = new CompositeDisposable();
        this.l = new b(this);
        return;
    L11:
        r4 = false;
    L17:
        r5 = s1.y();
        goto L18
    L5:
        r1 = SimpleSettingManager.b();
        goto L6
    }

    public final void onMergeHolderUnSelect() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onMergeHolderUnSelect();
        if (isRunOnLivePreview() == true) goto L6;
        return;
    L6:
        if (this.b.a == true) goto L8;
        return;
    L8:
        IMiddlewareHostConfig r0 = k.f(IMiddlewareHostConfig.class);
        Map r1 = null;
        if (r0 == null) goto L11;
        IMiddlewareHostAppConfig r2 = r0.appConfig();
    L12:
        if (r2 == null) goto L14;
        Map r3 = r2.getPreviewScrollAlphaConfig(getMergeContext().getEnterFromMerge());
    L15:
        if (r3 != null) goto L17;
        return;
    L17:
        if ((!r3.isEmpty()) == false) goto L19;
        r1 = r3;
    L19:
        if (r1 == null) goto L45;
        String r4 = (String) r1.get("enable");
        if (r4 == null) goto L23;
        boolean r5 = Boolean.parseBoolean(r4);
    L24:
        if (r5 == true) goto L26;
        return;
    L26:
        if (this.o == false) goto L47;
        String r6 = (String) r1.get("duration");
        if (r6 == null) goto L30;
        long r7 = CastLongProtector.parseLong(r6);
    L31:
        ViewGroup r8 = ((Widget) this).containerView;
        if (r8 == null) goto L48;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L38
        ViewPropertyAnimator r10 = r8.animate();     // Catch: Throwable -> L38
        if (r10 == null) goto L36;
        r10.cancel();     // Catch: Throwable -> L38
    L36:
        r8.animate().alpha(1.0f).setDuration(r7).setListener(new com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.d(this)).start();     // Catch: Throwable -> L38
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L38
    L40:
        Result.box-impl(r11);
        return;
    L38:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L40
    L48:
        return;
    L30:
        r7 = 200;
        goto L31
    L47:
        return;
    L23:
        r5 = false;
        goto L24
    L45:
        return;
    L14:
        r3 = null;
        goto L15
    L11:
        r2 = null;
        goto L12
    }

    public final void onMergeUnLoad() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget*/.onMergeUnLoad();
        if (i.a() == true) goto L5;
        return;
    L5:
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.c;
        if (r0 == null) goto L8;
        r0.e();
    L8:
        this.c = null;
        this.d = null;
        this.j = false;
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        int r0 = i.a;
        StringBuilder r1 = new StringBuilder("PortraitSimpleZDanmakuWidget.stopDanmaku, widget.hashCode: ");
        r1.append(hashCode());
        r1.append(", room.hashCode: ");
        Room r2 = this.i;
        if (r2 == null) goto L5;
        Integer r3 = Integer.valueOf(r2.hashCode());
    L6:
        r1.append(r3);
        r1.append(", roomId: ");
        Room r4 = this.i;
        if (r4 == null) goto L9;
        Long r5 = Long.valueOf(r4.id);
    L10:
        r1.append(r5);
        i.c(r1.toString());
        PortraitSimpleZDanmakuPresenter r6 = this.e;
        if (r6 == null) goto L54;
        vlc.d r7 = ((com.bytedance.android.livesdk.chatroom.presenter.n) r6).d;
        if (r7 == null) goto L15;
        r7.removeMessageListener("WebcastChatMessage", r6);
    L15:
        r6.e.d();
        Disposable r8 = r6.f;
        if (r8 == null) goto L18;
        r8.dispose();
    L18:
        r6.f = null;
        r6.h0();
        r6.i0(0);
    L54:
    L39:
        th = move-exception;
        int r9 = i.a;
        i.b("stopDanmaku error: " + th.getMessage());
    L41:
        h r10 = this.d;
        if (r10 == null) goto L44;
        r10.a();
    L44:
        Disposable r11 = this.h;
        if (r11 == null) goto L47;
        r11.dispose();
    L47:
        this.h = null;
        if (((Boolean) k1.a.getValue()).booleanValue() == false) goto L52;
        RenderEngineView r13 = this.a;
        if (r13 == null) goto L52;
        r13.j();
    L52:
        getUnRecyclableData();
        this.k = false;
        return;
    L20:
        if (((Boolean) gk0.a.getValue()).booleanValue() == false) goto L35;
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r14 = this.c;     // Catch: Throwable -> L39
        if (r14 == null) goto L41;
        CoreEngine r15 = r14.b;     // Catch: Throwable -> L39
        if (r15 == null) goto L26;
        boolean r16 = r15.f;     // Catch: Throwable -> L39
    L28:
        if (r16 != true) goto L41;
        if (r14 == null) goto L41;
        if (r14.g.a() == true) goto L41;
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r17 = this.c;     // Catch: Throwable -> L39
        if (r17 == null) goto L41;
        r17.b();     // Catch: Throwable -> L39
        goto L41
    L26:
        r16 = false;
        goto L28
    L35:
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r18 = this.c;     // Catch: Throwable -> L39
        if (r18 == null) goto L41;
        r18.b();     // Catch: Throwable -> L39
        goto L41
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        int r0 = i.a;
        StringBuilder r1 = new StringBuilder("PortraitSimpleZDanmakuWidget.startDanmaku, widget.hashCode: ");
        r1.append(hashCode());
        r1.append(", room.hashCode: ");
        Room r2 = this.i;
        Long r3 = null;
        if (r2 == null) goto L5;
        Integer r4 = Integer.valueOf(r2.hashCode());
    L6:
        r1.append(r4);
        r1.append(", roomId: ");
        Room r5 = this.i;
        if (r5 == null) goto L9;
        r3 = Long.valueOf(r5.id);
    L9:
        r1.append(r3);
        i.c(r1.toString());
        h r6 = this.d;
        if (r6 == null) goto L12;
        r6.a();
    L12:
        PortraitSimpleZDanmakuPresenter r7 = this.e;
        if (r7 == null) goto L25;
        r7.i0(0);
        if (LivePreviewDanmakuConfig.Companion.isHistoryDanmakuEnable() == false) goto L21;
        PortraitSimpleZDanmakuPresenter.IView r8 = ((q46.b) r7).a;
        if (r8 == null) goto L21;
        if (r8.isEnablePreviewDanmaku() != true) goto L21;
        r7.l0();
    L21:
        vlc.d r9 = ((com.bytedance.android.livesdk.chatroom.presenter.n) r7).d;
        if (r9 == null) goto L25;
        r9.addMessageListener("WebcastChatMessage", r7);
    L25:
        if (((Boolean) k1.a.getValue()).booleanValue() == false) goto L29;
        RenderEngineView r10 = this.a;
        if (r10 == null) goto L29;
        r10.i();
    L29:
        getUnRecyclableData();
        this.k = true;
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.PortraitSimpleZDanmakuPresenter.IView
    public final Room getRoom() {
        return this.i;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.PortraitSimpleZDanmakuPresenter.IView
    public final n mp() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.PortraitSimpleZDanmakuPresenter.IView
    public final boolean t7() {
        return this.k;
    }

    public final void onInit(Object[] r5) {
        DataCenter r6 = ((Widget) this).dataCenter;
        Long r0 = null;
        if (r6 == null) goto L5;
        Room r7 = (Room) r6.get("data_room", null);
    L6:
        int r1 = i.a;
        StringBuilder r2 = new StringBuilder("PortraitSimpleZDanmakuWidget.onInit, widget.hashCode: ");
        r2.append(hashCode());
        r2.append(", room.hashCode: ");
        if (r7 == null) goto L9;
        Integer r3 = Integer.valueOf(r7.hashCode());
    L10:
        r2.append(r3);
        r2.append(", roomId: ");
        if (r7 == null) goto L13;
        r0 = Long.valueOf(r7.id);
    L13:
        r2.append(r0);
        i.c(r2.toString());
        this.a = findViewById(2131384277);
        if (((Boolean) mk0.a.getValue()).booleanValue() == false) goto L26;
        View r8 = findViewById(2131384278);
        if (r8 == null) goto L27;
        IMiddleHostService r4 = TTMiddlewareLiveSDK.sHostService;
        if (r4 == null) goto L24;
        IMiddleWareHostContext r9 = r4.appContext();
        if (r9 == null) goto L24;
        if (r9.getTopSpaceHeight() != 0) goto L24;
        a1.o(r8, StatusBarUtil.getStatusBarHeight(s1.getContext()) + UtilityKotlinExtentionsKt.i(56));
        return;
    L24:
        a1.o(r8, UtilityKotlinExtentionsKt.i(56));
        return;
    L27:
        return;
    L26:
        return;
    L9:
        r3 = null;
        goto L10
    L5:
        r7 = null;
        goto L6
    }

    public final void onLoad(Object[] r4) {
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L5;
        Room r6 = (Room) r5.get("data_room", null);
    L6:
        this.i = r6;
        int r7 = i.a;
        StringBuilder r8 = new StringBuilder("PortraitSimpleZDanmakuWidget.onLoad, widget.hashCode: ");
        r8.append(hashCode());
        r8.append(", room.hashCode: ");
        Room r1 = this.i;
        if (r1 == null) goto L9;
        Integer r2 = Integer.valueOf(r1.hashCode());
    L10:
        r8.append(r2);
        r8.append(", roomId: ");
        Room r3 = this.i;
        if (r3 == null) goto L13;
        Long r9 = Long.valueOf(r3.id);
    L14:
        r8.append(r9);
        i.c(r8.toString());
        RenderEngineView r10 = this.a;
        if (r10 != null) goto L18;
        i.b("renderEngineView is null");
        return;
    L18:
        this.f = com.bytedance.android.livesdk.interactivity.barrage.widget.b.a(getRoomContext(), ((Widget) this).dataCenter);
        com.bytedance.android.livesdk.sharedpref.e<Integer> r11 = SimpleSettingManager.a;
        RxUtilKt.c(xs2.b.a().b(com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.settingmanager.b.class).observeOn(AndroidSchedulers.mainThread()).map(com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.settingmanager.c.a).subscribe(new com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.c(this)), this.g);
        com.bytedance.android.livesdk.sharedpref.e<Integer> r13 = SimpleSettingManager.a;
        if (((Boolean) rm.a.getValue()).booleanValue() == false) goto L21;
        o r14 = SimpleSettingManager.c();
    L23:
        if (r10.getWidth() <= 0) goto L25;
        int r15 = r10.getWidth();
    L26:
        n r16 = SimpleSettingManager.a(r14, r15);
        if (i.a() == true) goto L29;
    L31:
        yq(r16);
    L32:
        PortraitSimpleZDanmakuPresenter r17 = new PortraitSimpleZDanmakuPresenter();
        this.e = r17;
        r17.g0(this);
        if (isEnablePreviewDanmaku() == false) goto L38;
        if (i.a() == true) goto L38;
        wq(r10);
    L38:
        if (((Boolean) sw.a.getValue()).booleanValue() == false) goto L41;
        r10.b = null;
        r10.postInvalidate();
    L41:
        if (isRunOnLivePreview() == false) goto L44;
        this.n = getMergeContext().getVhEvent().onEvent().subscribe(new com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.f(this));
    L44:
        if (((Boolean) k1.a.getValue()).booleanValue() == false) goto L47;
        r10.j();
        return;
    L47:
        return;
    L29:
        if (this.j == false) goto L31;
        i.c("onLoad, player inited, on config change");
        xq(r16);
        goto L32
    L25:
        r15 = s1.y();
        goto L26
    L21:
        r14 = SimpleSettingManager.b();
        goto L23
    L13:
        r9 = null;
        goto L14
    L9:
        r2 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    public final void wq(RenderEngineView r11) {
        if (this.j == false) goto L5;
        return;
    L5:
        int r0 = i.a;
        StringBuilder r1 = new StringBuilder("initDanmakuPlayer, widget.hashCode: ");
        r1.append(hashCode());
        r1.append(", room.hashCode: ");
        Room r2 = this.i;
        Long r3 = null;
        if (r2 == null) goto L8;
        Integer r4 = Integer.valueOf(r2.hashCode());
    L9:
        r1.append(r4);
        r1.append(", roomId: ");
        Room r5 = this.i;
        if (r5 == null) goto L12;
        r3 = Long.valueOf(r5.id);
    L12:
        r1.append(r3);
        i.c(r1.toString());
        this.j = true;
        h r6 = new h(this.b);
        this.d = r6;
        e r7 = new e();
        com.bytedance.live.zdanmaku.data.d r8 = new com.bytedance.live.zdanmaku.data.d();
        r8.a(z.class, com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class);
        r8.a(d0.class, com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class);
        r8.a(c0.class, com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class);
        r8.a(y.class, com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class);
        r8.a(a0.class, com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class);
        r8.a(b0.class, com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class);
        int r9 = com.bytedance.live.zdanmaku.e.i;
        com.bytedance.live.zdanmaku.e.a r10 = new com.bytedance.live.zdanmaku.e.a();
        if (((Boolean) ok0.a.getValue()).booleanValue() == false) goto L15;
        View r13 = (View) DanmakuCacheProviders.c.getValue();
    L16:
        r10.b(com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class, new h0(r13, new c(this), new d(this)));
        r10.b = r8;
        r10.d = AsyncTask.THREAD_POOL_EXECUTOR;
        r10.a = new vc2.a("SimplePortrait");
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r14 = r10.a(r11, r7, r6);
        this.c = r14;
        r14.g.h = this.l;
        if (i.a() == false) goto L22;
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r15 = this.c;
        if (r15 == null) goto L23;
        r15.g.g = 1;
        return;
    L23:
        return;
    L22:
        return;
    L15:
        r13 = (View) DanmakuCacheProviders.b.getValue();
        goto L16
    L8:
        r4 = null;
        goto L9
    }

    public final void xq(n r11) {
        n r0 = this.b;
        yq(r11);
        h r1 = this.d;
        if (r1 == null) goto L19;
        Intrinsics.checkNotNullParameter(r11, "newConfig");
        r1.b = r11;
        g r2 = r1.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r11, "newConfig");
        int r6 = r2.d.c;
        int r7 = r11.c;
        if (r7 >= r6) goto L11;
    L6:
        if (r7 >= r6) goto L18;
        uc2.b r8 = (uc2.b) CollectionsKt.getOrNull(r2.a, r7);
        if (r8 == null) goto L10;
        r8.e = false;
    L10:
        r7 = r7 + 1;
    L18:
        r2.d = r11;
        goto L19
    L11:
        if (r7 <= r6) goto L18;
    L12:
        if (r6 >= r7) goto L18;
        uc2.b r9 = (uc2.b) CollectionsKt.getOrNull(r2.a, r6);
        if (r9 == null) goto L16;
        r9.e = true;
    L17:
        r6 = r6 + 1;
        goto L12
    L16:
        r2.a.add(new uc2.h(r6, true, false, null));
    L19:
        PortraitSimpleZDanmakuPresenter r3 = this.e;
        if (r3 == null) goto L51;
        Intrinsics.checkNotNullParameter(r0, "oldConfig");
        Intrinsics.checkNotNullParameter(r11, "newConfig");
        PortraitSimpleZDanmakuPresenter.IView r4 = ((q46.b) r3).a;
        if (r4 == null) goto L30;
        if (r4.isEnablePreviewDanmaku() == true) goto L30;
        i.c("danmaku is off, stop request history danmaku");
        Disposable r5 = r3.f;
        if (r5 == null) goto L28;
        r5.dispose();
    L28:
        r3.f = null;
        r3.h0();
        r3.i0(0);
    L30:
        if (LivePreviewDanmakuConfig.Companion.isHistoryDanmakuEnable() == true) goto L32;
        return;
    L32:
        if (r0.a == false) goto L34;
        return;
    L34:
        if (r11.a == false) goto L54;
        PortraitSimpleZDanmakuPresenter.IView r13 = ((q46.b) r3).a;
        if (r13 != null) goto L38;
        return;
    L38:
        if (r13.isEnablePreviewDanmaku() != true) goto L56;
        PortraitSimpleZDanmakuPresenter.IView r14 = ((q46.b) r3).a;
        if (r14 != null) goto L42;
        return;
    L42:
        if (r14.t7() != true) goto L58;
        i.c("danmaku is on, start request history danmaku");
        r3.l0();
        return;
    L58:
        return;
    L56:
        return;
    L54:
        return;
    }

    public final void yq(n r5) {
        int r0 = i.a;
        i.c("widget.hashCode: " + hashCode() + ", setDanmakuConfig: " + r5);
        if (this.b.i == r5.i) goto L25;
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r1 = this.c;
        if (r1 == null) goto L25;
        CoreEngine r2 = r1.b;
        if (r2 == null) goto L9;
        boolean r3 = r2.f;
    L11:
        if (r3 != true) goto L25;
        if (r1 == null) goto L25;
        if (r1.g.a() == true) goto L25;
        f r4 = new f(this);
        PortraitSimpleZDanmakuPresenter r6 = this.e;
        if (r6 != null) goto L18;
    L22:
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r7 = this.c;
        if (r7 == null) goto L25;
        r7.postRunnable(new com.bytedance.live.zdanmaku.f(r7, r4, PortraitSimpleZDanmakuWidget$setDanmakuConfig$2.INSTANCE));
        goto L25
    L18:
        if (r6.j0() != true) goto L22;
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r8 = this.c;
        if (r8 == null) goto L25;
        r8.postRunnable(new com.bytedance.live.zdanmaku.f(r8, r4, PortraitSimpleZDanmakuWidget$setDanmakuConfig$1.INSTANCE));
        goto L25
    L9:
        r3 = false;
    L25:
        this.b = r5;
        if (r5.a == false) goto L30;
        View r9 = ((Widget) this).contentView;
        if (r9 == null) goto L37;
        UtilityKotlinExtentionsKt.w(r9);
    L37:
        BarrageWidgetContext r10 = this.f;
        if (r10 == null) goto L43;
        pk6.a r11 = (pk6.a) r10.getDanmakuAlpha().getValue();
        if (r11 == null) goto L44;
        r11.a = (int) ((r5.h / 100) * 255);
        return;
    L44:
        return;
    L43:
        return;
    L30:
        View r13 = ((Widget) this).contentView;
        if (r13 == null) goto L33;
        UtilityKotlinExtentionsKt.u(r13);
    L33:
        Disposable r14 = this.h;
        if (r14 == null) goto L36;
        r14.dispose();
    L36:
        this.h = null;
        goto L37
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.PortraitSimpleZDanmakuPresenter.IView
    public final void X(Object r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "danmakuData");
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r4 = this.c;
        if (r4 == null) goto L6;
        r4.a(r2, false);
        return;
    }
}
