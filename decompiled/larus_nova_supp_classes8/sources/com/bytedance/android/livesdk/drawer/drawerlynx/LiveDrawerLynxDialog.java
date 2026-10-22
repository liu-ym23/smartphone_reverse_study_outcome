package com.bytedance.android.livesdk.drawer.drawerlynx;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.live.core.log.g;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.widget.BaseDialogFragment;
import com.bytedance.android.livehostapi.business.depend.feed.ILiveDrawerLayoutInterceptor;
import com.bytedance.android.livesdk.chatroom.drawer.LiveDrawerHelper;
import com.bytedance.android.livesdk.config.fp;
import com.bytedance.android.livesdk.drawer.LiveDrawerLayout;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.k4;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import j40.b4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/drawerlynx/LiveDrawerLynxDialog;", "Lcom/bytedance/android/live/core/widget/BaseDialogFragment;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDrawerLynxDialog extends BaseDialogFragment {
    public Room d;
    public DataCenter e;
    public View f;
    public View g;
    public View h;
    public LiveDrawerLayout i;
    public ViewGroup j;
    public View k;
    public LiveDrawerLynxCard l;
    public FrameLayout m;
    public final LiveDrawerLynxDialog$mDrawerListener$1 n;
    public boolean o;
    public int p;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LiveDrawerLynxDialog a;

        public b(LiveDrawerLynxDialog r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.V90();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ LiveDrawerLynxDialog a;

        public c(LiveDrawerLynxDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.V90();
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ LiveDrawerLynxDialog a;

        public d(LiveDrawerLynxDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.V90();
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ LiveDrawerLynxDialog a;

        public static final class a extends ut1.a {
            public final /* synthetic */ e a;

            public a(e r1) {
                this.a = r1;
            }

            public final void setInterceptor(ILiveDrawerLayoutInterceptor r2) {
                LiveDrawerLayout r0 = this.a.a.i;
                if (r0 == null) goto L6;
                r0.setDrawerLayoutInterceptor(r2);
                return;
            }
        }

        public e(LiveDrawerLynxDialog r1) {
            this.a = r1;
        }

        public final void a() {
            LiveDrawerLayout r0 = this.a.i;
            if (r0 == null) goto L6;
            r0.openDrawer(8388613);
        L6:
            if (this.a.getContext() == null) goto L17;
            LiveDrawerLynxCard r1 = this.a.l;
            if (r1 == null) goto L10;
            r1.setInterceptor(new a(this));
        L10:
            LiveDrawerLynxDialog r2 = this.a;
            FrameLayout r3 = r2.m;
            if (r3 == null) goto L13;
            r3.addView(r2.l, 0);
        L13:
            LiveDrawerLynxCard r4 = this.a.l;
            if (r4 == null) goto L18;
            r4.g();
            return;
        L18:
            return;
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

    static {
    }

    public final void V90() {
        DrawerLayout r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        if (ViewCompat.isAttachedToWindow(r0) == true) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L13;
        r0 = null;
    L13:
        if (r0 == null) goto L17;
        r0.closeDrawer(8388613);
        return;
    L17:
        return;
    L7:
        if (r0.isDrawerOpen(8388613) == false) goto L9;
        r1 = true;
        goto L10
    }

    public final boolean onBackPressed() {
        DrawerLayout r0 = this.i;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (ViewCompat.isAttachedToWindow(r0) == true) goto L7;
        return false;
    L7:
        if (r0.isDrawerOpen(8388613) == false) goto L13;
        r0.closeDrawer(8388613);
        return true;
    L13:
        return false;
    }

    public final void onDestroy() {
        LiveDrawerLynxCard r0 = this.l;
        if (r0 == null) goto L5;
        r0.f();
    L5:
        super.onDestroy();
    }

    public final void onDestroyView() {
        LiveDrawerLynxCard r0 = this.l;
        if (r0 == null) goto L5;
        r0.e();
    L5:
        FrameLayout r1 = this.m;
        if (r1 == null) goto L8;
        r1.removeAllViews();
    L8:
        super.onDestroyView();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.android.livesdk.drawer.drawerlynx.LiveDrawerLynxDialog$mDrawerListener$1] */
    public LiveDrawerLynxDialog() {
        this.n = new LiveDrawerLynxDialog$mDrawerListener$1(this);
        this.p = -1;
    }

    public final void U90() {
        if (b4.a() == false) goto L8;
        if (k4.e(getActivity()) == false) goto L8;
        float r0 = 24.0f;
    L12:
        if (W90() == true) goto L14;
    L16:
        float r1 = UIUtils.getScreenWidth(getContext()) - UIUtils.dip2Px(getContext(), r0);
    L17:
        ViewGroup r2 = this.j;
        if (r2 == null) goto L20;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
    L21:
        if (r3 == null) goto L23;
        r3.width = (int) r1;
    L23:
        ViewGroup r4 = this.j;
        if (r4 == null) goto L27;
        r4.setLayoutParams(r3);
        return;
    L27:
        return;
    L20:
        r3 = null;
        goto L21
    L14:
        if (this.p != 0) goto L16;
        r1 = (UIUtils.getScreenWidth(getContext()) - UIUtils.dip2Px(getContext(), r0)) / 2;
    L8:
        if (PadConfigUtils.c() == false) goto L10;
        r0 = s1.G(s1.y()) - 378.0f;
        goto L12
    L10:
        r0 = 12.0f;
        goto L12
    }

    public final boolean W90() {
        if (FoldScreenUtils.f() == true) goto L5;
        return false;
    L5:
        Iterator<? extends String> r0 = fp.a.getValue().iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(r0.next(), FoldScreenUtils.d()) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public final void onActivityCreated(Bundle r10) {
        super/*androidx.fragment.app.DialogFragment*/.onActivityCreated(r10);
        Dialog r11 = getDialog();
        if (r11 == null) goto L5;
        Window r12 = r11.getWindow();
    L7:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L9;
    L28:
        if (r12 == null) goto L37;
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        r12.addFlags(Integer.MIN_VALUE);
        r12.setNavigationBarColor(-16777216);
        r12.setLayout(-1, -1);
        if (getActivity() != null) goto L32;
        return;
    L32:
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(getActivity(), true, false) == false) goto L39;
        r12.clearFlags(1024);
        return;
    L39:
        return;
    L37:
        return;
    L9:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L28;
        if (r12 == null) goto L12;
        r12.clearFlags(1024);
    L12:
        if (r12 == null) goto L20;
        View r0 = r12.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L18;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r6 = ThreadMethodProxy.currentThread();
        if (r6 == com.larus.home.impl.utils.c.a) goto L18;
        com.larus.home.impl.utils.c.a(r6, "getDecorView");
    L18:
        if (r0 == null) goto L20;
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        r0.setSystemUiVisibility(1024);
    L20:
        if (r12 == null) goto L22;
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        r12.addFlags(Integer.MIN_VALUE);
    L22:
        if (r12 == null) goto L24;
        r12.setStatusBarColor(0);
    L24:
        if (r12 == null) goto L26;
        r12.setNavigationBarColor(-16777216);
    L26:
        if (r12 == null) goto L35;
        r12.setLayout(-1, -1);
        return;
    L35:
        return;
    L5:
        r12 = null;
        goto L7
    }

    public final void onConfigurationChanged(Configuration r5) {
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r5);
        if (b4.a() == false) goto L10;
        if (this.o == k4.e(getContext())) goto L10;
        View r0 = this.f;
        if (r0 == null) goto L10;
        r0.post(new b(this));
    L10:
        if (FoldScreenUtils.f() == false) goto L26;
        int r6 = FoldScreenUtils.c(r5);
        if (r6 == this.p) goto L16;
        b0 r1 = b0.o();
        String r2 = "onConfigurationChanged: oldFoldScreenType: " + this.p + " newFoldScreenType: " + r6;
        r1.getClass();
        g.i("LiveDrawerLynxDialog", r2);
        this.p = r6;
        if (W90() == false) goto L26;
        U90();
        goto L26
    L16:
        ViewGroup r7 = this.j;
        if (r7 == null) goto L26;
        if (ViewCompat.isAttachedToWindow(r7) == false) goto L26;
        if (r7.getWidth() <= UIUtils.getScreenWidth(getContext())) goto L26;
        if (W90() == false) goto L26;
        b0.o().getClass();
        g.i("LiveDrawerLynxDialog", "onConfigurationChanged: enter workaround");
        U90();
    L26:
        if (PadConfigUtils.a() == false) goto L29;
        U90();
        return;
    }

    public final void onCreate(Bundle r18) {
        super.onCreate(r18);
        setStyle(0, 2131954391);
        if (PadConfigUtils.c() == false) goto L5;
        this.o = k4.e(getContext());
    L5:
        DataCenter r0 = this.e;
        Room r3 = null;
        if (r0 == null) goto L8;
        r3 = (Room) r0.get("data_room", null);
    L8:
        this.d = r3;
        Context r5 = getContext();
        if (r5 == null) goto L41;
        Bundle r1 = getArguments();
        if (r1 == null) goto L13;
        boolean r7 = r1.getBoolean("switch_follow");
    L14:
        Bundle r2 = getArguments();
        if (r2 == null) goto L17;
        boolean r10 = r2.getBoolean("smart_client_preload");
    L18:
        LiveDrawerLynxCard r4 = this.l;
        if (r4 == null) goto L37;
        if (r4 == null) goto L43;
        r4.h(this.d, r7);
        return;
    L43:
        return;
    L37:
        String r6 = BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, "a1128.b3295.c96469.d85730", PageFinder.via(getActivity()), null, 4, null);     // Catch: Exception -> L25
        Room r8 = this.d;     // Catch: Exception -> L25
        if (r6 != null) goto L23;
        r6 = "";
    L23:
        this.l = new LiveDrawerLynxCard(r5, r8, r7, r6, getArguments(), r10);     // Catch: Exception -> L25
        Unit r9 = Unit.INSTANCE;     // Catch: Exception -> L25
        return;
    L26:
        if (isAdded() == true) goto L39;
    L33:
        Unit r11 = Unit.INSTANCE;
        return;
    L39:
        dismissAllowingStateLoss();     // Catch: Exception -> L29
    L29:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r12 = DialogFragmentLancet.sLastShowStack;
        if (r12 == null) goto L33;
        com.bytedance.crash.d.d(r12, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L33
    L17:
        r10 = false;
        goto L18
    L13:
        r7 = false;
        goto L14
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        if (FoldScreenUtils.f() == false) goto L5;
        this.p = FoldScreenUtils.a();
        b0 r6 = b0.o();
        String r7 = "current foldType is " + this.p;
        r6.getClass();
        g.i("LiveDrawerDialog", r7);
    L5:
        View r8 = this.f;
        FrameLayout r9 = null;
        if (r8 == null) goto L8;
        View r10 = r8.findViewById(2131370236);
    L9:
        this.g = r10;
        View r11 = this.f;
        if (r11 == null) goto L12;
        View r12 = r11.findViewById(2131372212);
    L13:
        this.h = r12;
        View r13 = this.f;
        if (r13 == null) goto L16;
        LiveDrawerLayout r14 = (LiveDrawerLayout) r13.findViewById(2131370241);
    L17:
        this.i = r14;
        if (r14 == null) goto L20;
        r14.addDrawerListener(this.n);
    L20:
        List r15 = LiveDrawerHelper.a;
        if (r15 == null) goto L28;
        Iterator r16 = ((ArrayList) r15).iterator();
    L24:
        if (r16.hasNext() == false) goto L28;
        DrawerLayout.DrawerListener r0 = (DrawerLayout.DrawerListener) r16.next();
        LiveDrawerLayout r1 = this.i;
        if (r1 == null) goto L24;
        r1.addDrawerListener(r0);
    L28:
        View r17 = this.f;
        if (r17 == null) goto L31;
        ViewGroup r18 = (ViewGroup) r17.findViewById(2131381866);
    L32:
        this.j = r18;
        View r19 = this.f;
        if (r19 == null) goto L35;
        View r20 = r19.findViewById(2131370244);
    L36:
        this.k = r20;
        View r21 = this.f;
        if (r21 == null) goto L39;
        FrameLayout r22 = (FrameLayout) r21.findViewById(2131379286);
    L40:
        this.m = r22;
        LiveDrawerLayout r23 = this.i;
        if (r23 == null) goto L43;
        r23.setScrimColor(0);
    L43:
        View r24 = this.f;
        if (r24 == null) goto L46;
        r9 = (FrameLayout) r24.findViewById(2131381854);
    L46:
        if (r9 == null) goto L49;
        r9.setBackgroundColor(ColorProtector.parseColor("#f3000000"));
    L49:
        if (PadConfigUtils.c() == false) goto L56;
        if (r9 == null) goto L52;
        r9.setBackgroundResource(2131249411);
    L52:
        ViewGroup r25 = this.j;
        if (r25 == null) goto L56;
        r25.setPadding(0, s1.f(20.0f), s1.f(20.0f), s1.f(20.0f));
    L56:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L58;
    L62:
        U90();
        View r26 = this.g;
        if (r26 == null) goto L65;
        r26.setOnClickListener(new c(this));
    L65:
        View r27 = this.h;
        if (r27 == null) goto L68;
        r27.setOnClickListener(new d(this));
    L68:
        DrawerLayout r28 = this.i;
        if (r28 == null) goto L77;
        r28.post(new e(this));
        return;
    L77:
        return;
    L58:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L62;
        LinearLayout.LayoutParams r29 = new LinearLayout.LayoutParams(-2, -2);
        r29.setMargins(0, ((int) UIUtils.dip2Px(getContext(), 52.0f)) + StatusBarUtil.getStatusBarHeight(getContext()), 0, 0);
        View r30 = this.h;
        if (r30 == null) goto L62;
        r30.setLayoutParams(r29);
        goto L62
    L39:
        r22 = null;
        goto L40
    L35:
        r20 = null;
        goto L36
    L31:
        r18 = null;
        goto L32
    L16:
        r14 = null;
        goto L17
    L12:
        r12 = null;
        goto L13
    L8:
        r10 = null;
        goto L9
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131567037, r3, false);
        this.f = r5;
        return r5;
    }
}
