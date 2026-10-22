package com.bytedance.android.live.broadcastgame.opengame.panel;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel$initPanelAndHide$3;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.s;
import com.bytedance.android.live.broadcastgame.opengame.runtime.t;
import com.bytedance.android.live.broadcastgame.opengame.runtime.u;
import com.bytedance.android.live.broadcastgame.opengame.service.CommercialService;
import com.bytedance.android.live.broadcastgame.opengame.service.TrackMiniGameService;
import com.bytedance.android.live.broadcastgame.opengame.view.PanelTopRightButtonView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.config.be0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.live.datacontext.m;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class OpenPanel extends Dialog implements h, s<i> {
    public static final /* synthetic */ int u = 0;
    public View a;
    public ViewGroup b;
    public ViewGroup c;
    public LiveDoubleColorBallAnimationView d;
    public ViewGroup e;
    public TextView f;
    public ViewGroup g;
    public PanelTopRightButtonView h;
    public ViewGroup i;
    public final int j;
    public boolean k;
    public ValueAnimator l;
    public final ShowTipsHelper m;
    public DialogInterface.OnDismissListener n;
    public final d o;
    public View.OnClickListener p;
    public final PluginContext q;
    public final b r;
    public PanelType s;
    public final /* synthetic */ t<i> t;

    public static final class a {
    }

    public interface b {
        void isLandscape();
    }

    public static final class c extends ViewOutlineProvider {
        public c() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r5, Outline r6) {
            if (r5 == null) goto L7;
            float r0 = s1.e(12.0f);
            Rect r1 = new Rect();
            r5.getGlobalVisibleRect(r1);
            Rect r7 = new Rect(0, 0, r1.right - r1.left, (int) ((r1.bottom - r1.top) + r0));
            if (r6 == null) goto L8;
            r6.setRoundRect(r7, r0);
            return;
        L8:
            return;
        }
    }

    public static final class d implements DialogInterface.OnDismissListener {
        public final /* synthetic */ OpenPanel a;

        public d(OpenPanel r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r3) {
            this.a.getClass();
            OpenPanel r0 = this.a;
            i r1 = r0.t.b;
            if (r1 == null) goto L5;
            r1.b();
        L5:
            ((ArrayList) r0.t.a).clear();
            DialogInterface.OnDismissListener r2 = this.a.n;
            if (r2 == null) goto L8;
            r2.onDismiss(r3);
        L8:
            this.a.m.a();
        }
    }

    public static final class e implements View.OnClickListener {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ OpenPanel a;

        public f(OpenPanel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            ViewGroup r0 = this.a.c;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("retryLayout");
        L5:
            r0.setVisibility(8);
            this.a.h();
            View.OnClickListener r1 = this.a.p;
            if (r1 == null) goto L9;
            r1.onClick(r3);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void F() {
        if (((Boolean) be0.a.getValue()).booleanValue() == false) goto L7;
        Window r0 = getWindow();
        if (r0 == null) goto L10;
        r0.setLayout(-1, this.s.getHeight());
    L10:
        Window r1 = getWindow();
        if (r1 == null) goto L13;
        r1.setBackgroundDrawable(new ColorDrawable());
    L13:
        V(true);
        return;
    L7:
        Window r2 = getWindow();
        if (r2 == null) goto L10;
        r2.setLayout(-1, -2);
        goto L10
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        i r0 = this.t.b;
        if (r0 == null) goto L6;
        r0.onPanelCancel();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.s
    public final List<i> getListeners() {
        return this.t.a;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void h() {
        UtilityKotlinExtentionsKt.s(0, false, false, new OpenPanel$showDoubleBallLoading$1(this), 7);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final ViewGroup h0() {
        ViewGroup r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L5:
        return r0;
    }

    @Override // android.app.Dialog, com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void hide() {
        if (this.k == false) goto L7;
        this.k = false;
        this.m.a();
        UtilityKotlinExtentionsKt.s(100, false, false, new OpenPanel$fakeHide$1(this), 6);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void i() {
        UtilityKotlinExtentionsKt.s(0, false, false, new OpenPanel$hideDoubleBallLoading$1(this), 7);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void init() {
        int r0 = q.a;
        q.f("OpenPanel", new Object[]{"init panel"});
        create();
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        i r0 = this.t.b;
        if (r0 == null) goto L6;
        r0.onBackPressed();
        return;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        ValueAnimator r0 = this.l;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        super.onDetachedFromWindow();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final Context J() {
        return getContext();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void L0() {
        i();
        ViewGroup r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("retryLayout");
    L5:
        UtilityKotlinExtentionsKt.w(r0);
        TextView r1 = this.f;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("retryBtn");
    L8:
        UtilityKotlinExtentionsKt.w(r1);
    }

    @Override // android.app.Dialog, android.content.DialogInterface, com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
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
    }

    @Override // android.app.Dialog, com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final boolean isShowing() {
        if (super.isShowing() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.k == false) goto L7;
        return true;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        this.r.isLandscape();
    }

    @Override // android.app.Dialog, com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void show() {
        Window r0 = getWindow();
        if (r0 == null) goto L13;
        final WindowManager.LayoutParams r1 = r0.getAttributes();
        if (r1 == null) goto L13;
        r1.width = -1;
        View r2 = this.a;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L9:
        Function0<Unit> r3 = new OpenPanel$show$$inlined$let$lambda$1(r1, this);
        if (ViewCompat.isAttachedToWindow(r2) == false) goto L13;
        r3.invoke();
    L13:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L38;
        DialogLancet.handleBlockedDialogShow(this);
    L18:
        if (this.k == true) goto L21;
        this.k = true;
        UtilityKotlinExtentionsKt.s(100, false, false, new OpenPanel$restoreFakeHide$1(this), 6);
    L21:
        this.m.b();
        TrackMiniGameService.a r4 = TrackMiniGameService.g;
        String r5 = String.valueOf(this.q.m.a);
        PluginContext r6 = this.q;
        boolean r7 = r6.o;
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, r6.i, 0, 2);
        if (r8 == null) goto L28;
        m r9 = r8.getRoom();
        if (r9 == null) goto L28;
        Room r11 = (Room) r9.getValue();
        if (r11 == null) goto L28;
        String r12 = r11.getOwnerUserIdString();
    L29:
        String r13 = String.valueOf(r12);
        String r14 = jc1.k.n(IUserService.class).user().b().getIdString();
        String r15 = String.valueOf(this.q.m.h);
        PluginContext r16 = this.q;
        String r17 = r16.m.b(r16.o);
        String r18 = ((BootInfoService) this.q.o(BootInfoService.class)).e();
        PluginContext r19 = this.q;
        if (r19 == null) goto L34;
        com.bytedance.android.live.broadcastgame.opengame.t r21 = r19.m;
        if (r21 == null) goto L34;
        String r110 = r21.i;
    L35:
        r4.getClass();
        TrackMiniGameService.a.c(r5, r7, r13, r14, r15, r17, r18, r110);
        return;
    L34:
        r110 = null;
    L28:
        r12 = null;
        goto L29
    L38:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L37
    L16:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L18
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final Window v0() {
        return getWindow();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final OpenPanelType c() {
        return OpenPanelType.OPEN_PANEL;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final ViewGroup getContentView() {
        return this.b;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final PanelType getPanelType() {
        return this.s;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.bytedance.android.live.broadcastgame.opengame.panel.i, java.lang.Object] */
    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.s
    public final void C(i r2) {
        i r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "delegate");
        this.t.b = r3;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void K(boolean r2) {
        PanelTopRightButtonView r0 = this.h;
        if (r0 == null) goto L6;
        r0.setTopRightTheme(r2);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void M(int r2) {
        if (r2 != 0) goto L8;
        ViewGroup r3 = this.i;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("topMessageContainer");
    L7:
        UIUtils.setViewVisibility(r3, 0);
        return;
    L8:
        ViewGroup r4 = this.i;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("topMessageContainer");
    L11:
        UIUtils.setViewVisibility(r4, 8);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void V(boolean r3) {
        if (r3 == false) goto L8;
        View r4 = this.a;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L7:
        r4.setBackground(s1.m(2131249678));
        return;
    L8:
        View r5 = this.a;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L11:
        r5.setBackground(new ColorDrawable(-16777216));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void addTopMessageView(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        ViewGroup r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topMessageContainer");
    L5:
        r0.addView(r3);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void addTopRightBtnView(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        this.h = (PanelTopRightButtonView) r3;
        ViewGroup r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L5:
        r0.addView(r3);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void i1(boolean r3) {
        if (r3 == false) goto L4;
        View r4 = findViewById(2131374647);
        FrameLayout r0 = (FrameLayout) r4;
        r0.setClipToOutline(true);
        r0.setOutlineProvider(new c());
        Unit r1 = Unit.INSTANCE;
        this.b = (ViewGroup) r4;
        return;
    L4:
        ViewGroup r5 = this.b;
        if (r5 == null) goto L7;
        r5.setClipToOutline(false);
    L7:
        ViewGroup r6 = this.b;
        if (r6 == null) goto L12;
        r6.setOutlineProvider(null);
        return;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        int r5 = q.a;
        q.f("OpenPanel", new Object[]{"onCreate"});
        Window r0 = getWindow();
        if (r0 == null) goto L5;
        r0.setLayout(-1, -2);
        r0.setGravity(80);
        r0.setFlags(512, 512);
    L5:
        setContentView(2131567109);
        this.a = findViewById(2131373452);
        r(this.s);
        i1(true);
        TextView r6 = (TextView) findViewById(2131387280);
        this.c = (ViewGroup) findViewById(2131379079);
        this.d = findViewById(2131370107);
        ViewGroup r7 = (ViewGroup) findViewById(2131370108);
        this.e = r7;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("doubleBallLoadingLayoutBg");
    L8:
        r7.setOnClickListener(e.a);
        TextView r8 = (TextView) findViewById(2131384465);
        this.f = r8;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("retryBtn");
    L11:
        r8.setOnClickListener(new f(this));
        ViewGroup r9 = (ViewGroup) findViewById(2131389207);
        this.g = r9;
        if (r9 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L14:
        r9.setVisibility(8);
        ViewGroup r11 = (ViewGroup) findViewById(2131389187);
        this.i = r11;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("topMessageContainer");
    L17:
        r11.setVisibility(8);
        h();
        super.setOnDismissListener(this.o);
        i r12 = this.t.b;
        if (r12 == null) goto L21;
        r12.a();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void p(int r2) {
        if (r2 != 0) goto L8;
        ViewGroup r3 = this.g;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L7:
        UIUtils.setViewVisibility(r3, 0);
        return;
    L8:
        ViewGroup r4 = this.g;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L11:
        UIUtils.setViewVisibility(r4, 8);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void r(PanelType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        this.s = r5;
        CommercialService r0 = (CommercialService) this.q.o(CommercialService.class);
        PanelType r1 = this.s;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.a = r1;
        int r6 = r5.getHeight();
        View r2 = this.a;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-1, r6);
        r3.gravity = 17;
        Unit r4 = Unit.INSTANCE;
        r2.setLayoutParams(r3);
        if (((Boolean) be0.a.getValue()).booleanValue() == false) goto L11;
        Window r7 = getWindow();
        if (r7 == null) goto L12;
        r7.setLayout(-1, r6);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.s
    public final void registerListener(i r2) {
        i r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.t.registerListener(r3);
    }

    @Override // android.app.Dialog
    public final void setOnDismissListener(DialogInterface.OnDismissListener r1) {
        this.n = r1;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void u0(Bitmap r4) {
        Intrinsics.checkNotNullParameter(r4, KtvSubElement.BACKGROUND);
        Window r0 = getWindow();
        if (r0 == null) goto L5;
        r0.setLayout(-1, -1);
        r0.setBackgroundDrawable(new BitmapDrawable(r0.getContext().getResources(), r4));
    L5:
        View r5 = this.a;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L8:
        r5.setBackground(null);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void z(LiveBasePluginWithPanel$initPanelAndHide$3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "clickListener");
        this.p = r2;
    }

    public OpenPanel(PluginContext r3, b r4, PanelType r5) {
        Intrinsics.checkNotNullParameter(r3, "pluginContext");
        Intrinsics.checkNotNullParameter(r4, "provider");
        Intrinsics.checkNotNullParameter(r5, "panelType");
        super(r3.getContext(), 2131954754);
        this.t = new t();
        this.q = r3;
        this.r = r4;
        this.s = r5;
        u.a(this, i.class);
        this.j = 80;
        this.m = new ShowTipsHelper(r3, new OpenPanel$showTipsHelper$1(this), new OpenPanel$showTipsHelper$2(this));
        this.o = new d(this);
    }

    public static final void a(final OpenPanel r3, int r4, int r5, final boolean r6) {
        ValueAnimator r0 = r3.l;
        if (r0 != null) goto L5;
    L9:
        r3.l = ValueAnimator.ofInt(new int[]{1, 60});
        IntEvaluator r1 = new IntEvaluator();
        ValueAnimator r2 = r3.l;
        if (r2 == null) goto L12;
        r2.addUpdateListener(new OpenPanel$performPanelAnimation$1(r3, r1, r4, r5));
    L12:
        View r7 = r3.a;
        if (r7 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L15:
        Function0<Unit> r8 = new OpenPanel$performPanelAnimation$2(r3, r6);
        if (ViewCompat.isAttachedToWindow(r7) == false) goto L18;
        r8.invoke();
    L18:
        ValueAnimator r9 = r3.l;
        if (r9 == null) goto L21;
        r9.setInterpolator(new AccelerateDecelerateInterpolator());
    L21:
        ValueAnimator r11 = r3.l;
        if (r11 == null) goto L27;
        ValueAnimator r12 = r11.setDuration(200);
        if (r12 == null) goto L28;
        r12.start();
        return;
    L28:
        return;
    L27:
        return;
    L5:
        if (r0.isRunning() != true) goto L9;
        ValueAnimator r13 = r3.l;
        if (r13 == null) goto L9;
        r13.cancel();
        goto L9
    }
}
