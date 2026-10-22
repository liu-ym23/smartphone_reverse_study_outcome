package com.bytedance.android.livesdk.interactivity.interactive.episode;

import android.R;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.util.h;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.landscape.e;
import com.bytedance.android.livesdk.vs.model.VSRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o82.f;
import vr1.j;
import vr1.o;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/episode/EpisodeInteractiveDialog;", "Landroid/app/Dialog;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroidx/fragment/app/FragmentActivity;", "h", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activity", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EpisodeInteractiveDialog extends Dialog implements Observer<KVData> {
    public static final /* synthetic */ int l = 0;
    public final String a;
    public View b;
    public View c;
    public int d;
    public final Function1<Boolean, Unit> e;
    public CompositeDisposable f;
    public final Lazy g;
    public final FragmentActivity h;
    public final DataCenter i;
    public final int j;
    public final int k;

    public final void b() {
        FragmentActivity r0 = this.h;
        IRoom r1 = null;
        if (r0 == null) goto L5;
        Integer r2 = Integer.valueOf(r0.getRequestedOrientation());
    L6:
        int r3 = r2.intValue();
        boolean r4 = false;
        if (r3 != 0) goto L9;
    L30:
        int r5 = 0;
    L31:
        this.d = r5;
        DataCenter r6 = this.i;
        float r7 = 0.0f;
        if (r6 == null) goto L35;
        VideoViewParams r8 = (VideoViewParams) r6.get("live_render_view_params", null);
        if (r8 == null) goto L35;
    L36:
        DataCenter r9 = this.i;
        if (r9 == null) goto L39;
        IRoom r10 = (IRoom) r9.get("data_room", null);
    L41:
        if (s1.F() == false) goto L43;
    L75:
        int r11 = 0;
        int r13 = 0;
    L76:
        DataCenter r14 = this.i;
        if (r14 == null) goto L81;
        Boolean r15 = (Boolean) r14.get("data_vs_room_big_gift_combo_dialog_show", Boolean.FALSE);
        if (r15 == null) goto L81;
        boolean r16 = r15.booleanValue();
    L82:
        if (r16 == false) goto L87;
        Window r17 = getWindow();
        if (r17 == null) goto L86;
        r17.setType(1);
    L86:
        ALogger.w(this.a, "isVSBigGiftDialogShowing true");
    L90:
        int r18 = f.a;
        FragmentActivity r19 = this.h;
        Window r110 = getWindow();
        DataCenter r111 = this.i;
        int r112 = this.k;
        ValueAnimator r113 = f.e;
        if (r113 == null) goto L93;
        r113.cancel();
    L93:
        if (r113 == null) goto L95;
        r113.setInterpolator(new AccelerateDecelerateInterpolator());
    L95:
        if (r111 == null) goto L98;
        VideoViewParams r20 = (VideoViewParams) r111.get("live_render_view_params", null);
        if (r20 == null) goto L98;
    L100:
        if (PadConfigUtils.c() == false) goto L103;
        int r114 = s1.f(20.0f);
    L110:
        if (r110 == null) goto L190;
        f.a = r11 + r114;
        f.b = r13 + r114;
        f.d = r112;
        m r21 = r.i().y(r111);
        if (r21 != null) goto L114;
    L116:
        int r23 = f.a;
    L117:
        f.c = r23;
        WindowManager.LayoutParams r24 = r110.getAttributes();
        if (r24 == null) goto L120;
        r24.x = f.c;
    L120:
        WindowManager.LayoutParams r25 = r110.getAttributes();
        if (r25 == null) goto L189;
        if (r111 == null) goto L124;
        Boolean r115 = (Boolean) r111.get("data_is_portrait");
    L126:
        if (Intrinsics.areEqual(r115, Boolean.TRUE) == false) goto L177;
        int r26 = s1.k(2131169047);
        if (PadConfigUtils.c() == false) goto L130;
        r26 = s1.k(2131169049);
    L130:
        ALogger.d("InteractiveDialogAnimController", "EpisodeInteractiveDialog get getPortraitY start get window diff");
        Rect r27 = new Rect();
        if (r19 == null) goto L135;
        View r116 = r19.findViewById(R.id.content);
        if (r116 == null) goto L135;
        r116.getGlobalVisibleRect(r27);
    L135:
        int r28 = s1.s(r19);
        int r117 = r27.bottom;
        if (r117 == 0) goto L139;
        if (r117 == r28) goto L139;
        int r118 = Math.abs(r28 - r117);
        r26 = r26 + r118;
        ALogger.d("InteractiveDialogAnimController", "EpisodeInteractiveDialog get getPortraitY add diff,diff=" + r118 + ",realScreenHeight = " + r28 + ",activityBottom = " + r27.bottom);
    L141:
        ALogger.d("InteractiveDialogAnimController", "EpisodeInteractiveDialog get getPortraitY=" + r26);
        u r29 = r.u(r111, null, 2);
        if (r29 == null) goto L152;
        Room r30 = r29.j0();
        if (r30 == null) goto L152;
        VSRoom r31 = r30.castToOrNull(VSRoom.class);
        if (r31 == null) goto L152;
        EpisodeExtraInfo r33 = r31.getEpisodeExtra();
        if (r33 == null) goto L152;
        if (r33.getStyle() != 2) goto L152;
    L161:
        if (r111 == null) goto L176;
        m r34 = r.i().g(r111);
        if (r34 != null) goto L165;
    L167:
        if (r4 == false) goto L176;
        u r35 = r.u(r111, null, 2);
        if (r35 == null) goto L171;
        r7 = r35.y0();
    L171:
        f.f = r26;
        f.g = ((int) UtilityKotlinExtentionsKt.h(r7)) + r26;
        m r36 = r.i().y(r111);
        if (r36 == null) goto L176;
        if (((Boolean) r36.getValue()).booleanValue() != true) goto L176;
        r26 = r26 + ((int) UtilityKotlinExtentionsKt.h(r7));
        goto L176
    L165:
        if (((Boolean) r34.getValue()).booleanValue() != true) goto L167;
        r4 = true;
    L176:
        f.h = r26;
    L188:
        r25.y = r26;
    L152:
        if (PadConfigUtils.c() == false) goto L176;
        u r37 = r.u(r111, null, 2);
        if (r37 == null) goto L158;
        n r38 = r37.w();
        if (r38 == null) goto L158;
        PadOrientation r39 = (PadOrientation) r38.getValue();
    L160:
        if (r39 != PadOrientation.LANDSCAPE) goto L176;
    L158:
        r39 = null;
    L139:
        if (r117 != r28) goto L141;
        ALogger.d("InteractiveDialogAnimController", "EpisodeInteractiveDialog get getPortraitY, activity same as realScreen");
        goto L141
    L177:
        IRoom r40 = h.a;
        if (r111 == null) goto L182;
        Boolean r41 = (Boolean) r111.get("data_is_anchor", Boolean.FALSE);
        if (r41 == null) goto L182;
        r4 = r41.booleanValue();
    L182:
        if (r111 == null) goto L185;
        r1 = h.e(r111);
    L185:
        if (e.b(r4, r1) == false) goto L187;
        r26 = (s1.w() - f.d) / 2;
        goto L188
    L187:
        r26 = (r20.b - f.d) / 2;
        goto L188
    L124:
        r115 = null;
    L189:
        r110.setAttributes(r110.getAttributes());
        ALogger.i("InteractiveDialogAnimController", "left:" + f.b + "  right:" + f.a + ' ');
        goto L190
    L114:
        if (((Boolean) r21.getValue()).booleanValue() != true) goto L116;
        r23 = f.b;
    L190:
        gr1.a r43 = jr1.c.a();
        if (r43 == null) goto L202;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r44 = r43.provideVSPlayerViewControlService(this.i);
        if (r44 == null) goto L203;
        VSPlayerViewControlContext r45 = r44.provideContext();
        if (r45 == null) goto L204;
        m r46 = r45.getPlayerViewVisible();
        if (r46 == null) goto L205;
        Disposable r47 = i80.a.a(r46, this.e);
        if (r47 == null) goto L206;
        RxUtilKt.c(r47, this.f);
        return;
    L206:
        return;
    L205:
        return;
    L204:
        return;
    L203:
        return;
    L202:
        return;
    L103:
        if (s1.F() == false) goto L105;
        r114 = s1.f(12.0f);
        goto L110
    L105:
        if (r111 != null) goto L107;
    L109:
        r114 = s1.f(13.0f);
        goto L110
    L107:
        if (h.c(r111) != true) goto L109;
        r114 = s1.f(9.0f);
    L98:
        r20 = new VideoViewParams(0, 0, 0, 0.0f);
        goto L100
    L87:
        Window r48 = getWindow();
        if (r48 == null) goto L90;
        r48.setType(IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
    L81:
        r16 = false;
        goto L82
    L43:
        if (PadConfigUtils.c() == true) goto L75;
        DataCenter r49 = this.i;
        IRoom r119 = h.a;
        if (r49 == null) goto L49;
        Boolean r50 = (Boolean) r49.get("data_is_anchor", Boolean.FALSE);
        if (r50 == null) goto L49;
        boolean r51 = r50.booleanValue();
    L50:
        DataCenter r120 = this.i;
        if (r120 == null) goto L53;
        IRoom r121 = h.e(r120);
    L54:
        boolean r53 = e.b(r51, r121);
        u r122 = r.u(this.i, null, 2);
        if (r122 == null) goto L57;
        boolean r123 = r122.X();
    L58:
        if (r53 == false) goto L61;
        if (r123 == false) goto L61;
        r11 = (s1.f(200.0f) + this.d) + 0;
    L62:
        if (r10 != null) goto L64;
    L74:
        r13 = r11;
        goto L76
    L64:
        if (r10.isMergeVSRoom() != true) goto L74;
        IRoomAuthStatus r54 = r10.getRoomAuthStatus();
        if (r54 != null) goto L68;
    L69:
        IRoomAuthStatus r55 = r10.getRoomAuthStatus();
        if (r55 == null) goto L74;
        if (r55.enableLandscapeQuickRecord() != true) goto L74;
    L73:
        r13 = (((int) s1.e(48.0f)) + ((int) s1.e(1.0f))) + r11;
        goto L76
    L68:
        if (r54.enableLandscapeQuickShot() == true) goto L73;
    L61:
        r11 = 0 + (((s1.t() - r8.a) / 2) + this.d);
        goto L62
    L57:
        r123 = false;
        goto L58
    L53:
        r121 = null;
    L49:
        r51 = false;
        goto L50
    L39:
        r10 = null;
    L35:
        r8 = new VideoViewParams(0, 0, 0, 0.0f);
        goto L36
    L9:
        if (r3 != 8) goto L30;
        FragmentActivity r56 = this.h;
        if (r56 == null) goto L20;
        Window r57 = r56.getWindow();
        if (r57 == null) goto L20;
        View r58 = r57.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L21;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r59 = ThreadMethodProxy.currentThread();
        if (r59 == com.larus.home.impl.utils.c.a) goto L21;
        com.larus.home.impl.utils.c.a(r59, "getDecorView");
    L21:
        if (r58 == null) goto L26;
        int r60 = r58.getHeight();
        int r61 = r58.getWidth();
        int r63 = s1.r();
        int r64 = s1.t();
        if (r60 != r63) goto L25;
        if (r64 == r61) goto L26;
    L25:
        boolean r65 = true;
    L27:
        if (r65 == true) goto L30;
        r5 = s1.o();
    L26:
        r65 = false;
    L20:
        r58 = null;
        goto L21
    L5:
        r2 = null;
        goto L6
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        this.f.dispose();
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // android.app.Dialog
    public final void show() {
        r.i().w(getWindow());
        DataCenter r0 = this.i;
        if (r0 != null) goto L5;
    L25:
        DataCenter r1 = this.i;
        if (r1 != null) goto L28;
    L32:
        b();
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L39;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L39:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L38
    L36:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        return;
    L28:
        if (h.d(r1, true) == true) goto L32;
        if (PadConfigUtils.c() == true) goto L32;
        r.i().j(this.i, this.f, new EpisodeInteractiveDialog$observeEvents$2(this));
        goto L32
    L5:
        if (h.d(r0, true) == false) goto L25;
        u r2 = r.u(this.i, null, 2);
        if (r2 == null) goto L25;
        Room r3 = r2.j0();
        if (r3 == null) goto L25;
        VSRoom r4 = r3.castToOrNull(VSRoom.class);
        if (r4 == null) goto L25;
        EpisodeExtraInfo r5 = r4.getEpisodeExtra();
        if (r5 == null) goto L25;
        if (r5.getStyle() != 2) goto L25;
        j r6 = r.i();
        if (r6 == null) goto L25;
        m r7 = r6.g(r0);
        if (r7 == null) goto L25;
        Observable r8 = r7.a();
        if (r8 == null) goto L25;
        Disposable r9 = r8.subscribe(new b(this));
        if (r9 == null) goto L25;
        RxUtilKt.c(r9, this.f);
        goto L25
    }

    public final FragmentActivity getActivity() {
        return this.h;
    }

    public static void a(boolean r6) {
        o r0 = r.l();
        Pair[] r2 = new Pair[1];
        if (r6 == false) goto L5;
        String r7 = "1";
    L6:
        r2[0] = TuplesKt.to("create_success", r7);
        r0.s("livesdk_flexinteract_view_init", MapsKt.mutableMapOf(r2), "live", "show", "live_detail");
        return;
    L5:
        r7 = "0";
        goto L6
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return this.h.dispatchKeyEvent(r2);
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        View r0 = this.b;
        if (r0 == null) goto L6;
        r0.post(new c(this, r4));
        return;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        ALogger.d(this.a, "onCreate");
        this.f = new CompositeDisposable();
        Window r6 = getWindow();
        if (r6 == null) goto L5;
        r6.requestFeature(1);
        r6.setLayout(this.j, this.k);
        r6.setAttributes(r6.getAttributes());
        r6.setDimAmount(0.0f);
        r6.setGravity(8388693);
        r6.setFlags(32, 32);
        r6.setFlags(262144, 262144);
    L5:
        int r7 = 0;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        View r1 = LayoutInflater.from(this.h).inflate(2131566847, null, false);
        this.b = r1;
        if (r1 == null) goto L71;
        setContentView(r1);
        if (this.c == null) goto L70;
        FragmentActivity r2 = this.h;
        if (r2 != null) goto L12;
    L14:
        View r3 = this.c;
        if (r3 == null) goto L24;
        ViewParent r4 = r3.getParent();
        if (r4 == null) goto L24;
        if ((r4 instanceof ViewGroup) == true) goto L22;
        r4 = null;
    L22:
        if (r4 == null) goto L24;
        ((ViewGroup) r4).removeView(this.c);
    L24:
        FrameLayout r8 = (FrameLayout) this.g.getValue();
        if (r8 == null) goto L27;
        r7 = r8.getChildCount();
    L27:
        if (r7 <= 0) goto L31;
        FrameLayout r9 = (FrameLayout) this.g.getValue();
        if (r9 == null) goto L31;
        r9.removeAllViews();
    L31:
        FrameLayout r10 = (FrameLayout) this.g.getValue();
        if (r10 == null) goto L34;
        r10.addView(this.c);
    L34:
        FrameLayout r11 = (FrameLayout) this.g.getValue();
        if (r11 == null) goto L37;
        a1.p(r11, this.j);
    L37:
        FrameLayout r13 = (FrameLayout) this.g.getValue();
        if (r13 == null) goto L40;
        a1.k(r13, this.k);
    L40:
        View r14 = this.c;
        if (r14 == null) goto L43;
        a1.j(r14, 17);
    L43:
        DataCenter r15 = this.i;
        if (r15 == null) goto L46;
        IRoom r16 = (IRoom) r15.get("data_room", null);
    L47:
        if (r16 == null) goto L59;
        DataCenter r17 = this.i;
        if (r17 == null) goto L59;
        if (h.d(r17, true) != true) goto L59;
        View r18 = this.b;
        if (r18 == null) goto L55;
        r18.setScaleX(1.07f);
    L55:
        View r19 = this.b;
        if (r19 == null) goto L59;
        r19.setScaleY(1.07f);
    L59:
        if (PadConfigUtils.c() == false) goto L69;
        u r20 = r.u(this.i, null, 2);
        if (r20 == null) goto L69;
        n r21 = r20.w();
        if (r21 == null) goto L69;
        Observable r23 = r21.a();
        if (r23 == null) goto L69;
        Disposable r24 = r23.subscribe(new a(this));
        if (r24 == null) goto L69;
        RxUtilKt.c(r24, this.f);
    L69:
        o82.h.b("EpisodeInteractiveDialog add hybridRootView complete");
        a(true);
        goto L71
    L46:
        r16 = null;
        goto L47
    L12:
        if (r2.isFinishing() != true) goto L14;
    L70:
        a(false);
    L71:
        List r25 = CollectionsKt.mutableListOf(new String[]{"data_live_screen_orientation_change"});
        if (r25 == null) goto L79;
        Iterator r26 = r25.iterator();
    L75:
        if (r26.hasNext() == false) goto L85;
        String r0 = (String) r26.next();
        DataCenter r27 = this.i;
        if (r27 == null) goto L75;
        r27.observe(r0, this);
        goto L75
    L85:
        return;
    }

    public EpisodeInteractiveDialog(FragmentActivity r2, DataCenter r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        super(r2, 2131954802);
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.a = "EpisodeInteractiveDialog[" + hashCode() + ']';
        this.e = new EpisodeInteractiveDialog$notify$1(this);
        this.f = new CompositeDisposable();
        this.g = com.bytedance.android.livesdk.chatroom.vs_base.base.a.a(new EpisodeInteractiveDialog$mEpisodeInteractiveContainer$2(this));
    }
}
