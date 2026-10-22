package com.bytedance.android.live.room.navi.landtoptool;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.landscape.d;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import l81.t;
import zg1.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.LandscapeTopToolBar, type = PlayerViewControl.Type.TOP)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/room/navi/landtoptool/LandscapeTopToolbarWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeTopToolbarWidget extends MiddlewareRoomRecyclableWidget implements Observer<KVData> {
    public static final /* synthetic */ int h = 0;
    public final String a;
    public ViewGroup b;
    public final CompositeDisposable c;
    public x3 d;
    public final List<ToolbarButton> e;
    public Map<ExtendedToolbarButton, View> f;
    public final Map<ExtendedToolbarButton, View> g;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LandscapeTopToolbarWidget a;

        public b(LandscapeTopToolbarWidget r1) {
            this.a = r1;
        }

        public final void a() {
            if (((Widget) this.a).contentView.getWidth() <= 0) goto L5;
            float r0 = ((Widget) this.a).contentView.getWidth() - UIUtils.dip2Px(((Widget) this.a).context, 14.0f);
        L6:
            MiddlewareRoomContext r1 = this.a.getMiddlewareRoomContext();
            if (r1 == null) goto L12;
            m r2 = r1.getLandscapeToolbarWidth();
            if (r2 == null) goto L13;
            r2.setValue(Float.valueOf(r0));
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r0 = UIUtils.dip2Px(((Widget) this.a).context, 14.0f);
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final class c implements Consumer {
        public final /* synthetic */ Function1 a;

        public c(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567764;
    }

    public final String getSpm() {
        return "a100.a100.a266";
    }

    public final void onUnload() {
        this.c.clear();
        ((Widget) this).dataCenter.removeObserver(this);
        Iterator r0 = ((ArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        ToolbarButton r1 = (ToolbarButton) r0.next();
        Map<ExtendedToolbarButton, View> r2 = this.g;
        ExtendedToolbarButton.a r3 = ExtendedToolbarButton.h;
        r3.getClass();
        LinkedHashMap r4 = (LinkedHashMap) r2;
        View r5 = (View) r4.get(ExtendedToolbarButton.a.a(r1));
        if (r5 == null) goto L4;
        ViewGroup r6 = this.b;
        if (r6 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
    L10:
        r6.removeView(r5);
        x3 r7 = this.d;
        if (r7 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("toolbarManager");
    L13:
        r7.getClass();
        r3.getClass();
        r7.C(ExtendedToolbarButton.a.a(r1), r5);
        goto L4
    L14:
        ((ArrayList) this.e).clear();
        ((LinkedHashMap) this.g).clear();
    }

    public LandscapeTopToolbarWidget() {
        this.a = "LandscapeTopToolbarWidget";
        this.c = new CompositeDisposable();
        this.e = new ArrayList();
        this.f = new LinkedHashMap();
        this.g = new LinkedHashMap();
    }

    public final void onClear() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget*/.onClear();
        this.c.clear();
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        if (r7 == null) goto L5;
        String r0 = r7.getKey();
    L6:
        if (r0 == null) goto L38;
        int r1 = r0.hashCode();
        int r2 = 4;
        if (r1 == 309908432) goto L24;
        if (r1 == 1939188655) goto L14;
        return;
    L14:
        if (r0.equals("data_screen_record_is_open") == false) goto L35;
        Boolean r3 = Boolean.FALSE;
        Boolean r8 = (Boolean) r7.getData(r3);
        if (r8 == null) goto L20;
        r3 = r8;
    L20:
        if (r3.booleanValue() == true) goto L22;
        r2 = 0;
    L22:
        ((Widget) this).contentView.setVisibility(r2);
        return;
    L35:
        return;
    L24:
        if (r0.equals("data_media_introduction_showing") == false) goto L37;
        Boolean r4 = Boolean.FALSE;
        Boolean r9 = (Boolean) r7.getData(r4);
        if (r9 == null) goto L29;
        r4 = r9;
    L29:
        boolean r10 = r4.booleanValue();
        View r5 = ((Widget) this).contentView;
        if (r10 == true) goto L33;
        r2 = 0;
    L33:
        r5.setVisibility(r2);
        return;
    L37:
        return;
    L38:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void onInit(Object[] r2) {
        this.b = (ViewGroup) ((Widget) this).contentView.findViewById(2131377135);
    }

    public final void onLoad(Object[] r12) {
        boolean r13 = isScreenPortrait();
        int r0 = d.a;
        if ((!r13) == false) goto L8;
        ViewGroup r14 = this.b;
        if (r14 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
    L7:
        UIUtils.updateLayoutMargin(r14, -3, -3, 0, 0);
    L8:
        x3 r15 = y3.i(((Widget) this).dataCenter);
        if (r15 == null) goto L80;
        x3 r16 = r15;
        this.d = r16;
        r16.E(((Widget) this).dataCenter);
        x3 r17 = this.d;
        if (r17 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("toolbarManager");
    L13:
        this.f = r17.c;
        ((Widget) this).dataCenter.observe("data_screen_record_is_open", this).observe("data_media_introduction_showing", this);
        if ((!isScreenPortrait()) == false) goto L23;
        o r18 = z51.a.h(((Widget) this).dataCenter, 2);
        if (r18 == null) goto L23;
        m r19 = r18.G2();
        if (r19 == null) goto L23;
        x0 r5 = (x0) r19.getValue();
        ViewGroup r6 = this.b;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
    L22:
        UIUtils.updateLayoutMargin(r6, -3, -3, s1.f(0.0f), -3);
        ((ObservableSubscribeProxy) r19.a().observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new c(new LandscapeTopToolbarWidget$onLoad$1$1(this)));
    L23:
        x3 r110 = this.d;
        if (r110 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("toolbarManager");
    L26:
        this.c.add(r110.i.subscribe(new com.bytedance.android.live.room.navi.landtoptool.a(this), com.bytedance.android.live.room.navi.landtoptool.b.a));
        t r111 = ((INavigationProxyService) k.n(INavigationProxyService.class)).getToolbarConfig();
        if (r111 == null) goto L29;
        r111.a(((Widget) this).dataCenter, this.e);
    L29:
        LayoutInflater r112 = LayoutInflater.from(((Widget) this).context);
        if (r112 == null) goto L74;
        Iterator r7 = ((ArrayList) this.e).iterator();
    L34:
        if (r7.hasNext() == false) goto L74;
        ToolbarButton r8 = (ToolbarButton) r7.next();
        if (r8 != ToolbarButton.SWITCH_VIDEO_QUALITY) goto L38;
    L39:
        INavigationProxyService r9 = (INavigationProxyService) k.f(INavigationProxyService.class);
        if (r9 == null) goto L46;
        l81.k r10 = r9.getLivePlatformPlayerManager();
        if (r10 == null) goto L46;
        ILivePlayerClient r20 = r10.getCurrentClient();
        if (r20 == null) goto L46;
        ILivePlayerExtraRenderController r22 = r20.extraRenderController();
    L47:
        if (r22 != null) goto L49;
    L51:
        boolean r23 = false;
    L52:
        if (r23 == true) goto L34;
    L54:
        ExtendedToolbarButton.h.getClass();
        ExtendedToolbarButton r24 = ExtendedToolbarButton.a.a(r8);
        ViewGroup r25 = this.b;
        if (r25 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
    L57:
        View r26 = r112.inflate(r8.getLayoutId(), r25, false);
        if (r8.getLayoutId() != 2131567861) goto L60;
        r26.setBackgroundResource(r8.getDrawableUnfolded());
    L60:
        r26.setTag(r8);
        r26.setVisibility(8);
        boolean r27 = isScreenPortrait();
        int r113 = d.a;
        if ((!r27) == false) goto L63;
        int r28 = 0;
    L64:
        UIUtils.updateLayoutMargin(r26, (int) UtilityKotlinExtentionsKt.h(14.0f), -3, -3, r28);
        r3.i(r26, r8);
        this.f.put(r24, r26);
        this.g.put(r24, r26);
        ViewParent r29 = r26.getParent();
        if ((r29 instanceof ViewGroup) == false) goto L67;
        ((ViewGroup) r29).removeView(r26);
    L67:
        ViewGroup r30 = this.b;
        if (r30 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
    L70:
        r30.addView(r26);
        x3 r32 = this.d;
        if (r32 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("toolbarManager");
    L73:
        r32.D(r24, r26);
        goto L34
    L63:
        r28 = -3;
        goto L64
    L49:
        if (r22.isUgcRoom() != true) goto L51;
        r23 = true;
    L46:
        r22 = null;
        goto L47
    L38:
        if (r8 != ToolbarButton.RECORD_LANDSCAPE) goto L54;
    L74:
        View r114 = ((Widget) this).contentView;
        if (r114 == null) goto L77;
        r114.post(new b(this));
    L77:
        ALogger.d(this.a, "LandscapeTopToolbarWidget = " + System.currentTimeMillis());
        return;
    L80:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    }
}
