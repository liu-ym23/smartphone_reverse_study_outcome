package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.RoomPermissionContext;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.roommanage.AnchorManageAdminDataContext;
import com.bytedance.android.livesdk.chatroom.roommanage.permission.AnchorModifyAdminPermissionView;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.lifecycle.ILiveLifecycle;
import com.bytedance.android.livesdkapi.lifecycle.ILiveLifecycleObserver;
import com.bytedance.live.datacontext.DataContext;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveProfileManageDialogV2 extends Dialog implements ILiveLifecycleObserver {
    public View a;
    public boolean b;
    public boolean c;
    public final int d;
    public LiveDialogFragment e;
    public HybridDialog f;
    public Disposable g;
    public final com.bytedance.android.live.core.utils.rxutils.x h;
    public final List<Disposable> i;
    public final j7 j;
    public final i7 k;
    public final Room l;
    public final User m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final UserProfileEvent q;
    public final Bundle r;
    public final boolean s;
    public final User t;

    public static final class a {
    }

    public interface b {
        void dismissDialog();

        void onClick(int r1);
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LiveProfileManageDialogV2 a;

        public c(LiveProfileManageDialogV2 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            zg1.g1 r5 = (zg1.g1) r4;
            LiveProfileManageDialogV2 r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r6));
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ LiveProfileManageDialogV2 a;

        public d(LiveProfileManageDialogV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            LiveProfileManageDialogV2 r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ LiveProfileManageDialogV2 a;

        public e(LiveProfileManageDialogV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            LiveProfileManageDialogV2 r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public final class f implements Consumer {
        public final /* synthetic */ Function1 a;

        public f(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.b = false;
        Iterator r0 = ((ArrayList) this.i).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Disposable r1 = (Disposable) r0.next();
        if (r1.isDisposed() == true) goto L4;
        r1.dispose();
        goto L4
    L9:
        ((ArrayList) this.i).clear();
        super.onDetachedFromWindow();
        Disposable r2 = this.g;
        if (r2 == null) goto L12;
        r2.dispose();
    L12:
        this.h.dispose();
        jc1.k.n(ILiveLifecycle.class).removeObserver(this);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (this.c == false) goto L13;
        Object r0 = getContext().getSystemService("input_method");
        if (r0 == null) goto L12;
        InputMethodManager r1 = (InputMethodManager) r0;
        View r3 = this.a;
        if (r3 == null) goto L9;
        IBinder r4 = r3.getWindowToken();
    L10:
        r1.hideSoftInputFromWindow(r4, 0);
        goto L13
    L9:
        r4 = null;
        goto L10
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    L13:
        Handler r2 = DialogLancet.resolveDialogHandler(this);
        if (r2 != null) goto L16;
    L18:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L21 Exception -> L23
    L27:
        DialogLancet.afterDialogDismiss(this);
    L28:
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r5 != null) goto L31;
        return;
    L31:
        if (r5.isBroadcastMedia() != true) goto L66;
        com.bytedance.android.livesdk.log.g r6 = com.bytedance.android.livesdk.log.u.l();
        HashMap r7 = new HashMap();
        r7.put("live_type", "media");
        String r8 = "1";
        if (((Number) r5.getMediaReviewStatus().getValue()).intValue() < 5) goto L35;
        Object r9 = "1";
    L36:
        r7.put("live_status", r9);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.L0.getValue()).booleanValue() == false) goto L39;
        Object r10 = "1";
    L40:
        r7.put("replay_status", r10);
        RoomAuthStatus r11 = ((Room) r5.getRoom().getValue()).getRoomAuthStatus();
        if (r11 != null) goto L43;
    L45:
        Object r12 = "0";
    L46:
        r7.put("check_status", r12);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.V0.getValue()).booleanValue() == false) goto L49;
        Object r13 = "1";
    L50:
        r7.put("gift_status", r13);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.G1.getValue()).booleanValue() == false) goto L53;
        Object r14 = "1";
    L54:
        r7.put("comment_status", r14);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.H1.getValue()).booleanValue() == true) goto L58;
        r8 = "0";
    L58:
        r7.put("share_status", r8);
        Unit r15 = Unit.INSTANCE;
        r6.sendLog("livesdk_anchor_inlive_setting_close", r7, new Object[0]);
        return;
    L53:
        r14 = "0";
        goto L54
    L49:
        r13 = "0";
        goto L50
    L43:
        if (r11.getEnableUserCard() != true) goto L45;
        r12 = "1";
        goto L46
    L39:
        r10 = "0";
        goto L40
    L35:
        r9 = "0";
        goto L36
    L66:
        return;
    L23:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L21
        Throwable r16 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L21
        if (r16 == null) goto L27;
        com.bytedance.crash.d.d(r16, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L16:
        if (Looper.myLooper() == r2.getLooper()) goto L18;
        r2.post(DialogLancet.createDismissRunnable(this));
        goto L28
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b = true;
        this.g = xs2.b.a().b(zg1.g1.class).subscribe(new c(this));
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.i r1 = r0.isAnchor();
        if (r1 == null) goto L8;
        if (((Boolean) r1.getValue()).booleanValue() == true) goto L8;
    L9:
        jc1.k.n(ILiveLifecycle.class).addObserver(this);
        if (PadConfigUtils.c() == false) goto L13;
        Disposable r2 = xs2.b.a().b(com.bytedance.android.livesdk.event.f.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(new LiveProfileManageDialogV2$onAttachedToWindow$disposable$1(this)));
        ((ArrayList) this.i).add(r2);
        return;
    L13:
        return;
    L8:
        Pair r3 = com.bytedance.live.datacontext.d.a(AnonymousClass2.INSTANCE);
        com.bytedance.live.datacontext.d.c((DataContext) r3.getFirst(), Reflection.getOrCreateKotlinClass(AnchorManageAdminDataContext.class));
        this.h.b((Disposable) r3.getSecond());
        goto L9
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        super.cancel();
    }

    public static void a(LiveProfileManageDialogV2 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r18) {
        Window r1 = getWindow();
        if (r1 == null) goto L5;
        r1.setGravity(80);
    L5:
        AnchorModifyAdminPermissionView r3 = null;
        if (PadConfigUtils.c() == false) goto L11;
        View r2 = getLayoutInflater().inflate(2131565609, null);
        this.a = r2;
        if (r2 == null) goto L28;
        setContentView(r2);
    L28:
        if (r1 == null) goto L37;
        r1.setLayout(-1, -1);
        if (this.o == false) goto L37;
        r1.setSoftInputMode(18);
        View r4 = r1.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L36;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r5 = ThreadMethodProxy.currentThread();
        if (r5 == com.larus.home.impl.utils.c.a) goto L36;
        com.larus.home.impl.utils.c.a(r5, "getDecorView");
    L36:
        r4.addOnLayoutChangeListener(this.k);
    L37:
        findViewById(2131386017).setOnClickListener(new e(this));
        ((LiveProfileManageViewPager) findViewById(2131386019)).setAdapter(new LiveProfileManageViewPager.ProfileManageViewAdapter(this.o, getContext(), getLayoutInflater(), this.j, this.l, this.m, this.n, this.p, this.q, this.r));
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r6 == null) goto L44;
        com.bytedance.live.datacontext.i r7 = r6.isAnchor();
        if (r7 == null) goto L44;
        if (((Boolean) r7.getValue()).booleanValue() == true) goto L44;
        boolean r8 = true;
    L45:
        if (r8 == false) goto L52;
        if (this.n == false) goto L52;
        if (RoomPermissionContext.a.c(RoomPermissionContext.Companion) == false) goto L52;
        ((LiveProfileManageViewPager) findViewById(2131386019)).j();
    L67:
        boolean r9 = true;
    L68:
        com.bytedance.android.livesdk.r3.c(findViewById(2131386017), com.bytedance.android.live.core.utils.s1.B(2131918650), r9);
        return;
    L52:
        if (this.s == false) goto L67;
        LiveProfileManageViewPager r10 = (LiveProfileManageViewPager) findViewById(2131386019);
        final User r11 = this.t;
        final LiveProfileManageViewPager.ProfileManageViewAdapter r12 = r10.a;
        if (r12 == null) goto L67;
        if (r11 == null) goto L67;
        r10.setCurrentItem(3, false);
        r10.k(r12.f());
        AnchorModifyAdminPermissionView r13 = r12.f();
        if ((r13 instanceof AnchorModifyAdminPermissionView) == false) goto L62;
        r3 = r13;
    L62:
        AnchorModifyAdminPermissionView r14 = r3;
        if (r14 == null) goto L65;
        UtilityKotlinExtentionsKt.t(r14.d);
        r9 = true;
        r14.i = true;
    L66:
        r12.g(new LiveProfileManageViewPager$switchToAdminPrivilegePage$1(r11, r12));
        goto L68
    L65:
        r9 = true;
    L44:
        r8 = false;
        goto L45
    L11:
        if (this.o == false) goto L13;
    L25:
        View r15 = getLayoutInflater().inflate(2131565607, null);
        this.a = r15;
        if (r15 == null) goto L28;
        setContentView(r15);
        goto L28
    L13:
        if (this.n == true) goto L25;
        if (this.p == false) goto L25;
        View r16 = getLayoutInflater().inflate(2131565608, null);
        this.a = r16;
        if (r16 == null) goto L19;
        setContentView(r16);
    L19:
        View r17 = this.a;
        if (r17 == null) goto L24;
        View r19 = r17.findViewById(2131386018);
        if (r19 == null) goto L24;
        r19.setOnClickListener(new d(this));
    L24:
        ((LiveProfileManageViewPager) findViewById(2131386019)).setNeedUpdateHeightOnHorizontal(true);
        goto L28
    }

    public final void onEvent(com.bytedance.android.livesdk.event.f r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        a(this);
    }

    public final void onLifecycleEvent(ILiveLifecycleObserver.Event r1, String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r1, "event");
        Intrinsics.checkNotNullParameter(r2, "roomId");
        if (isShowing() == true) goto L5;
        return;
    L5:
        if (r1 != ILiveLifecycleObserver.Event.EndSession) goto L9;
        a(this);
        return;
    }

    public LiveProfileManageDialogV2(Context r3, Room r4, User r5, boolean r6, boolean r7, boolean r8, UserProfileEvent r9, Bundle r10, boolean r11, User r12, int r13) {
        if ((r13 & 32) == 0) goto L6;
        r8 = true;
    L6:
        if ((r13 & 64) == 0) goto L9;
        r9 = null;
    L9:
        if ((r13 & 128) == 0) goto L12;
        r10 = Bundle.EMPTY;
    L12:
        if ((r13 & 256) == 0) goto L15;
        r11 = false;
    L15:
        if ((r13 & 512) == 0) goto L17;
        r12 = null;
    L17:
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r10, "bundle");
        if (r7 == false) goto L20;
        int r14 = 2131954591;
    L21:
        super(r3, r14);
        this.l = r4;
        this.m = r5;
        this.n = r6;
        this.o = r7;
        this.p = r8;
        this.q = r9;
        this.r = r10;
        this.s = r11;
        this.t = r12;
        Resources r15 = r3.getResources();
        this.d = WindowDisplayMetricsOverride.apply(r15, r15.getDisplayMetrics()).heightPixels;
        this.h = new com.bytedance.android.live.core.utils.rxutils.x();
        this.i = new ArrayList();
        this.j = new j7(this);
        this.k = new i7(this);
        return;
    L20:
        r14 = 2131954592;
        goto L21
    }
}
