package com.bytedance.android.livesdk.interactivity.medialink.widget;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.ILinkControlWidget;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodel.LinkRequestMonitor;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.widget.RoomWidget;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.medialink.BaseMediaLinkControlWidget;
import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaRoomContext;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.MediaLinkDialog;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.MediaMultiLinkAudienceWindowManager;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.g0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import gd0.v;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import m60.i;
import org.json.JSONException;
import org.json.JSONObject;
import zg1.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/widget/MediaLinkControlWidget;", "Lcom/bytedance/android/livesdk/interactivity/api/medialink/BaseMediaLinkControlWidget;", "Lcom/bytedance/android/livesdk/interactivity/medialink/widget/MediaLinkControlPresenter$IView;", "Lcom/bytedance/android/livesdk/interactivity/medialink/widget/g$b;", "Lcom/bytedance/android/livesdk/interactivity/medialink/contract/a;", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaLinkControlWidget extends BaseMediaLinkControlWidget implements MediaLinkControlPresenter.IView, g.b, com.bytedance.android.livesdk.interactivity.medialink.contract.a {
    public static final /* synthetic */ int r = 0;
    public int b;
    public MediaMultiLinkAnchorWidget c;
    public MediaMultiLinkAudienceWidget d;
    public MediaLinkControlPresenter e;
    public Room f;
    public boolean g;
    public boolean h;
    public int i;
    public MediaLinkDialog j;
    public final g k;
    public Disposable l;
    public com.bytedance.android.livesdk.interactivity.medialink.widget.a m;
    public String n;
    public final CompositeDisposable o;
    public final BaseMediaLinkControlWidget.a p;
    public final ViewGroup q;

    public static final class a {
        public a() {
        }

        public static void a(boolean r3) {
            int r0 = MediaLinkControlWidget.r;
            Intrinsics.checkNotNullParameter("multi_linker", "type");
            HashMap r1 = new HashMap();
            r1.put("mode", "multi_linker");
            String r2 = "0";
            r1.put("stream_mix_on_client", "0");
            if (r3 == true) goto L9;
            Integer r4 = (Integer) ((ge1.a) hd0.c.f()).b;
            if (r4 != null) goto L8;
        L10:
            r1.put("is_in", r2);
            k.n(IPerformanceManager.class).onModuleStart("link_mic_media", r1);
            return;
        L8:
            if (r4.intValue() != 2) goto L10;
        L9:
            r2 = "1";
            goto L10
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MediaLinkControlWidget a;
        public final /* synthetic */ c0 b;

        public b(MediaLinkControlWidget r1, c0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            if (((mk1.a) r4).a() == false) goto L5;
            this.b.k(ToolbarButton.PK, this.a.k);
            return;
        L5:
            this.b.d(ToolbarButton.PK, this.a.k);
            com.bytedance.android.livesdk.interactivity.medialink.contract.b.R0.getClass();
            com.bytedance.android.livesdk.interactivity.medialink.contract.b r5 = com.bytedance.android.livesdk.interactivity.medialink.contract.b.a.a();
            if (r5 == null) goto L10;
            r5.jg(17, "ceiling_view_leave", true);
            return;
        }
    }

    public static final class c extends mk1.b {
        public final /* synthetic */ lk1.c a;

        public final mk1.a a() {
            mk1.a r0 = this.a.getComponentStatusByConfig("room_auth_media_linkmic", mk1.c.c);
            if (r0 != null) goto L6;
            r0 = new mk1.a(2, 6);
        L6:
            if (r0.a != 0) goto L8;
            boolean r3 = true;
        L9:
            if (r3 == true) goto L11;
            return r0;
        L11:
            return new mk1.a(2, 6);
        L8:
            r3 = false;
            goto L9
        }

        public c(lk1.c r1) {
            this.a = r1;
        }
    }

    public static final class d implements o60.e {
        public final /* synthetic */ MediaLinkControlWidget a;

        public d(MediaLinkControlWidget r1) {
            this.a = r1;
        }

        public final void onPermissionDenied(String... r2) {
            Intrinsics.checkNotNullParameter(r2, "permissions");
            ALogger.e("PK_BLUETOOTH_CONNECT", "permission_denied");
            MediaLinkControlWidget r3 = this.a;
            int r0 = MediaLinkControlWidget.r;
            r3.xq();
        }

        public final void onPermissionGrant(String... r2) {
            Intrinsics.checkNotNullParameter(r2, "permissions");
            ALogger.e("PK_BLUETOOTH_CONNECT", "permission_grant");
            MediaLinkControlWidget r3 = this.a;
            int r0 = MediaLinkControlWidget.r;
            r3.xq();
        }
    }

    public static final class e implements Runnable {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    public static final class f implements Runnable {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    static {
        new a();
    }

    public final int getLayoutId() {
        return 2131567724;
    }

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    public final String getSpm() {
        return "a100.a100.a315";
    }

    public final boolean qa(Runnable r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "afterInterceptRunnable");
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.medialink.BaseMediaLinkControlWidget
    public final String tag() {
        return "MediaLinkControlWidget";
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.widget.MediaLinkControlPresenter.IView
    public final void OF() {
        if (this.h == true) goto L6;
        gq(null);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.widget.g.b
    public final void Vp() {
        m r0 = (m) ((Widget) this).dataCenter.get("data_broadcast_pause_state");
        if (r0 == null) goto L9;
        int r1 = r0.a;
        boolean r2 = true;
        if (r1 != 1) goto L7;
    L10:
        if (r2 == false) goto L13;
        f2.b(2131917825, 0);
        return;
    L13:
        HashMap r3 = new HashMap();
        r3.put("current_mode", String.valueOf(this.i));
        b0.o().j("ttlive_pk", r3);
        int r4 = this.i;
        if (r4 != 0) goto L17;
        xq();
        return;
    L17:
        if (v.a(r4, 256) == false) goto L24;
        MediaMultiLinkAnchorWidget r5 = this.c;
        if (r5 == null) goto L25;
        if (r5 == null) goto L26;
        r5.Bq();
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L7:
        if (r1 == 2) goto L10;
    L9:
        r2 = false;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.a
    public final LiveWidget Yf() {
        if (this.h == false) goto L6;
        return this.c;
    L6:
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.a
    public final void Zh() {
        MediaLinkDialog r0 = new MediaLinkDialog();
        r0.k = this;
        r0.d = 10;
        MediaLinkDialog r1 = this.j;
        if (r1 == null) goto L5;
        r1.setOnDismissListener(new com.bytedance.android.livesdk.interactivity.medialink.widget.d(this));
    L5:
        FragmentActivity r2 = ((Widget) this).context;
        if (r2 == null) goto L10;
        wq(r0, r2.getSupportFragmentManager());
        Unit r3 = Unit.INSTANCE;
        this.j = r0;
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.a
    public final void m() {
        k.n(ILinkServiceExternal.class).getControlServiceExternal().m();
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.a
    public final void onClickLinkIcon() {
        MediaMultiLinkAnchorWidget r0 = this.c;
        if (r0 == null) goto L6;
        r0.Bq();
        return;
    }

    public final void xq() {
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.P;
        if (((Boolean) r0.getValue()).booleanValue() == false) goto L5;
    L14:
        HashMap r1 = new HashMap();
        r1.put("from_media", "1");
        u.l().sendLog("livesdk_connection_icon_click", r1, new Object[]{this.f});
        if (this.k.d == 0) goto L26;
        MediaLinkDialog r2 = new MediaLinkDialog();
        r2.k = this;
        r2.d = 10;
        MediaLinkDialog r3 = this.j;
        if (r3 == null) goto L19;
        r3.setOnDismissListener(new com.bytedance.android.livesdk.interactivity.medialink.widget.d(this));
    L19:
        FragmentActivity r4 = ((Widget) this).context;
        if (r4 == null) goto L24;
        wq(r2, r4.getSupportFragmentManager());
        Unit r5 = Unit.INSTANCE;
        this.j = r2;
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L26:
        if (isViewValid() == true) goto L28;
        return;
    L28:
        MediaLinkDialog r6 = this.j;
        if (r6 != null) goto L31;
    L32:
        MediaLinkDialog r7 = new MediaLinkDialog();
        r7.k = this;
        r7.d = 10;
        FragmentActivity r8 = ((Widget) this).context;
        if (r8 == null) goto L40;
        wq(r7, r8.getSupportFragmentManager());
        Unit r9 = Unit.INSTANCE;
        this.j = r7;
    L35:
        MediaLinkDialog r10 = this.j;
        if (r10 == null) goto L42;
        r10.setOnDismissListener(new com.bytedance.android.livesdk.interactivity.medialink.widget.d(this));
        return;
    L42:
        return;
    L40:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L31:
        if (r6.isVisible() == true) goto L35;
    L5:
        if (m60.c.d(((Widget) this).context, new String[]{"android.permission.BLUETOOTH_CONNECT"}) == true) goto L14;
        if (((Boolean) com.bytedance.android.livesdk.config.b.a.getValue()).booleanValue() == false) goto L14;
        if (Build.VERSION.SDK_INT < 31) goto L14;
        com.bytedance.android.livesdk.sharedpref.f.d(r0, Boolean.TRUE);
        Activity r11 = ContextUtil.contextToActivity(((Widget) this).context);
        if (r11 == null) goto L41;
        SettingKey r13 = i.a;
        i.b r14 = new i.b(r11);
        r14.d = e.a;
        r14.e = f.a;
        r14.b(new d(this), null, i.b, new String[]{"android.permission.BLUETOOTH_CONNECT"});
        return;
    }

    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.f = (Room) ((Widget) this).dataCenter.get("data_room");
        Object r0 = ((Widget) this).dataCenter.get("data_is_anchor");
        Intrinsics.checkNotNull(r0);
        this.h = ((Boolean) r0).booleanValue();
        LiveMode r1 = (LiveMode) ((Widget) this).dataCenter.get("data_live_mode");
        this.g = ((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        Room r2 = this.f;
        if (r2 == null) goto L9;
        RoomContext r3 = ((RoomWidget) this).a;
        if (r3 == null) goto L9;
        j r4 = r3.getLinkRequestMonitor();
        if (r4 == null) goto L9;
        r4.d(new LinkRequestMonitor(r2, ((Widget) this).dataCenter));
    L9:
        c0 r5 = y3.m(((Widget) this).dataCenter);
        if (this.g == false) goto L21;
        lk1.c.a r6 = lk1.c.i2;
        DataCenter r7 = ((Widget) this).dataCenter;
        r6.getClass();
        lk1.c r8 = lk1.c.a.a(r7);
        r8.addComponentRule("room_auth_media_linkmic", new c(r8));
        mk1.a r9 = r8.getComponentStatus("room_auth_media_linkmic");
        if (r9 != null) goto L14;
    L16:
        com.bytedance.android.live.core.arch.mvvm.d r10 = r8.observeStatusChanged("room_auth_media_linkmic");
        if (r10 == null) goto L21;
        ObservableSubscribeProxy r11 = (ObservableSubscribeProxy) r10.as(autoDispose());
        if (r11 == null) goto L21;
        r11.subscribe(new b(this, r5));
        goto L21
    L14:
        if (r9.a() != true) goto L16;
        r5.k(ToolbarButton.PK, this.k);
    L21:
        MediaLinkControlPresenter r13 = new MediaLinkControlPresenter(this.f, this.h);
        r13.g0();
        Room r14 = this.f;
        if (r14 == null) goto L24;
        this.m = new com.bytedance.android.livesdk.interactivity.medialink.widget.a(r14, r13);
    L24:
        Unit r15 = Unit.INSTANCE;
        this.e = r13;
        Pair r16 = com.bytedance.live.datacontext.d.a(AnonymousClass4.INSTANCE);
        MediaRoomContext r17 = (MediaRoomContext) r16.component1();
        Disposable r18 = (Disposable) r16.component2();
        r17.getLinkInternalService().d(this);
        com.bytedance.live.datacontext.b.a(r17, "IMediaRoomService");
        this.l = r18;
        enableSubWidgetManager();
        boolean r19 = k60.b.a();
        if (this.h == false) goto L27;
        MediaMultiLinkAnchorControlWidget r20 = new MediaMultiLinkAnchorControlWidget();
        ((Widget) this).subWidgetManager.load(r20, r19, r19);
    L28:
        RoomContext r21 = ((RoomWidget) this).a;
        if (r21 == null) goto L33;
        j r23 = r21.getLinkRequestMonitor();
        if (r23 == null) goto L33;
        LinkRequestMonitor r24 = (LinkRequestMonitor) r23.getValue();
    L34:
        if (r24 == null) goto L37;
        r24.a();
    L37:
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.b(getComponentContext()) == false) goto L40;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.c(getComponentContext(), x32.a.class, this);
        return;
    L40:
        return;
    L33:
        r24 = null;
        goto L34
    L27:
        MediaMultiLinkAudienceControlWidget r25 = new MediaMultiLinkAudienceControlWidget();
        ((Widget) this).subWidgetManager.load(r25, r19, r19);
        goto L28
    }

    public final void onDestroy() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.d(getComponentContext(), x32.a.class);
        k.n(IPerformanceManager.class).onModuleStop("link_mic_media");
        com.bytedance.android.livesdk.interactivity.medialink.widget.a r0 = this.m;
        if (r0 == null) goto L7;
        CompositeDisposable r1 = r0.d;
        if (r1 == null) goto L7;
        r1.dispose();
    L7:
        LinkRequestMonitor r2 = null;
        this.m = null;
        MediaLinkControlPresenter r3 = this.e;
        if (r3 == null) goto L39;
        r3.detachView();
    L39:
        MediaLinkDialog r4 = this.j;     // Catch: Throwable -> L21
        if (r4 != null) goto L13;
    L23:
        Disposable r5 = this.l;
        if (r5 != null) goto L26;
    L28:
        com.bytedance.android.livesdk.sharedpref.e r6 = com.bytedance.android.livesdk.sharedpref.b.Q1;
        r6.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r6, 0L);
        RoomContext r7 = ((RoomWidget) this).a;
        if (r7 == null) goto L33;
        j r8 = r7.getLinkRequestMonitor();
        if (r8 == null) goto L33;
        r2 = (LinkRequestMonitor) r8.getValue();
    L33:
        if (r2 == null) goto L35;
        r2.b();
    L35:
        g0.a.clear();
        this.o.dispose();
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        return;
    L26:
        if (r5.isDisposed() == true) goto L28;
        r5.dispose();
        goto L28
    L13:
        if (r4.isVisible() == false) goto L23;
        r4.dismiss();     // Catch: Exception -> L16 Throwable -> L21
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Throwable -> L21
        Throwable r9 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L21
        if (r9 == null) goto L23;
        com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        SafetyGuard.a(null, th, null);
        goto L23
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.a
    public final int getCurrentMode() {
        return this.i;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.a
    public final DialogFragment rg() {
        return this.j;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.a
    public final void K4(@ILinkControlWidget.Mode int r4) {
        if (v.a(this.i, 256) == true) goto L5;
        return;
    L5:
        ArrayList r1 = new ArrayList((List) ((Widget) this).dataCenter.get("data_online_changed_list", new ArrayList()));
        r1.clear();
        this.i = v.b(this.i, 256);
        DataCenter r5 = ((Widget) this).dataCenter;
        r5.put("data_online_changed_list", r1);
        r5.put("data_link_state", Integer.valueOf(this.i));
        if (this.h == false) goto L8;
        this.p.a(this.c);
        this.c = null;
    L9:
        RoomContext r6 = ((RoomWidget) this).a;
        if (r6 == null) goto L14;
        com.bytedance.live.datacontext.m r7 = r6.isMultiAnchorLinkOn();
        if (r7 == null) goto L14;
        r7.setValue(Boolean.FALSE);
    L14:
        onMultiAnchorStateChange(0);
        g r0 = this.k;
        if (r0.b == null) goto L23;
        LottieAnimationView r2 = r0.c;
        if (r2 == null) goto L20;
        r2.clearAnimation();
        r2.setVisibility(0);
    L20:
        LottieAnimationView r3 = r0.c;
        if (r3 == null) goto L23;
        r3.setVisibility(0);
        r3.setImageResource(2131250846);
    L23:
        k.n(IPerformanceManager.class).onModuleStop("link_mic_media");
        return;
    L8:
        this.p.a(this.d);
        this.d = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.a
    public final void gq(com.bytedance.android.livesdk.interactivity.medialink.contract.e r4) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        ALogger.e("ttlive_link", "switchMode 256 " + v.a(this.i, 256));
        if (v.a(this.i, 256) == false) goto L9;
        ALogger.i("ktv", "duplicate switchMode " + this.i + " target=256");
        return;
    L9:
        int r0 = this.i | 256;
        this.i = r0;
        ((Widget) this).dataCenter.put("data_link_state", Integer.valueOf(r0));
        if (this.h == false) goto L12;
        this.c = this.p.b(r4);
    L13:
        RoomContext r5 = ((RoomWidget) this).a;
        if (r5 == null) goto L18;
        com.bytedance.live.datacontext.m r6 = r5.isMultiAnchorLinkOn();
        if (r6 == null) goto L18;
        r6.setValue(Boolean.TRUE);
    L18:
        a.a(this.h);
        this.k.a(2);
        return;
    L12:
        this.d = this.p.b(r4);
        goto L13
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.a
    public final boolean k0(@ILinkControlWidget.Mode int r2) {
        return v.a(this.i, r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.a
    public final void onMultiAnchorStateChange(int r2) {
        this.k.a(r2);
    }

    @Override // x32.a
    public final void onSei(String r8) {
        if (this.h == false) goto L6;
        return;
    L6:
        if (TextUtils.equals(r8, this.n) == false) goto L9;
        return;
    L9:
        if ((this.b % 10) != 0) goto L11;
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_pk", r8);
    L11:
        boolean r1 = true;
        this.b++;
        if (v.a(this.i, 256) == false) goto L19;
        MediaMultiLinkAudienceWidget r0 = this.d;
        if (r0 == null) goto L19;
        r0.h = r8;
        MediaMultiLinkAudienceWindowManager r2 = r0.g;
        if (r2 == null) goto L18;
        MediaMultiLinkAudienceWindowManager.r(r2, r8, false, false, 6);
    L18:
        this.n = r8;
    L19:
        com.bytedance.android.livesdk.interactivity.medialink.widget.a r3 = this.m;
        if (r3 == null) goto L72;
        com.bytedance.android.livesdk.interactivity.medialink.contract.a.Q0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.a r4 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
        List r5 = null;
        if (r4 == null) goto L24;
        Integer r6 = Integer.valueOf(r4.getCurrentMode());
    L25:
        com.bytedance.android.live.liveinteract.plantform.base.i r7 = k.n(IInteractService.class).getLinkUserInfoCenter();
        if (r7 == null) goto L28;
        r5 = r7.getOnlineUserList();
    L28:
        boolean r9 = Lists.isEmpty(r5);
        if (r6 != null) goto L32;
    L35:
        r1 = false;
    L36:
        if (r6 != null) goto L39;
    L40:
        if (r1 == true) goto L43;
        return;
    L43:
        if ((System.currentTimeMillis() - r3.e) < IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW) goto L79;
        r3.e = System.currentTimeMillis();
        if (r8 == null) goto L73;
        e92.c r10 = r3.a;
        r10.getClass();
        if (TextUtils.isEmpty(r8) == false) goto L50;
        return;
    L50:
        if (r8.contains("app_data") == false) goto L80;
        LiveSeiUtil.i.getClass();     // Catch: JSONException -> L69
        JSONObject r11 = LiveSeiUtil.c(r8);     // Catch: JSONException -> L69
        if (r11.has("info") == false) goto L60;
        if (r11.has("source") == false) goto L60;
        if (TextUtils.equals(r11.optString("source"), "zego") == false) goto L60;
        r11 = (JSONObject) r11.get("info");     // Catch: JSONException -> L69
    L60:
        if (r11.has("app_data") == false) goto L75;
        JSONObject r13 = new JSONObject(JSONObjectProtectorUtils.getString(r11, "app_data").replaceAll("\\\\", BuildConfig.FLAVOR));     // Catch: JSONException -> L69
        long r14 = r13.optLong("timestamp");     // Catch: JSONException -> L69
        if (r14 > r10.a) goto L65;
        return;
    L65:
        if (r13.has("ver") == false) goto L77;
        r13.optInt("ver");     // Catch: JSONException -> L69
        r10.b.a();     // Catch: JSONException -> L69
        r10.a = r14;     // Catch: JSONException -> L69
        r10.b.onSeiUpdated(e92.c.a(r13));     // Catch: JSONException -> L69
        return;
    L77:
        return;
    L75:
        return;
    L81:
        return;
    L80:
        return;
    L73:
        return;
    L79:
        return;
    L39:
        if (r6.intValue() == 0) goto L43;
    L32:
        if (r6.intValue() != 2) goto L35;
        if (r9 == false) goto L35;
    L24:
        r6 = null;
        goto L25
    }

    public MediaLinkControlWidget(BaseMediaLinkControlWidget.a r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "mCallback");
        this.p = r2;
        this.q = r3;
        this.k = new g(this, this);
        this.o = new CompositeDisposable();
    }

    public static void wq(MediaLinkDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "MediaLinkControlWidget", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "MediaLinkControlWidget");
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.medialink.BaseMediaLinkControlWidget, x32.a
    public final void a(View r2, MotionEvent r3) {
        MediaMultiLinkAnchorWidget r0 = this.c;
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }
}
