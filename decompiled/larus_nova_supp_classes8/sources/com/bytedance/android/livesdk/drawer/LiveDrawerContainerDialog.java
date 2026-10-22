package com.bytedance.android.livesdk.drawer;

import am2.x;
import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.BaseDialogFragment;
import com.bytedance.android.live.search.api.ILiveSearchService;
import com.bytedance.android.livehostapi.business.IHostFeed;
import com.bytedance.android.livesdk.chatroom.c0;
import com.bytedance.android.livesdk.chatroom.drawer.LiveDrawerHelper;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.f;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.VerticalTypeInfo;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ut1.h;
import ut1.k;
import ut1.l;
import ut1.m;
import ut1.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/LiveDrawerContainerDialog;", "Lcom/bytedance/android/live/core/widget/BaseDialogFragment;", "", "Lut1/k$a;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDrawerContainerDialog extends BaseDialogFragment implements k.a {
    public View d;
    public boolean e;
    public k f;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnKeyListener {
        public final /* synthetic */ LiveDrawerContainerDialog a;

        public b(LiveDrawerContainerDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
            if (4 == r2) goto L5;
        L7:
            return false;
        L5:
            if (1 != r3.getAction()) goto L7;
            return this.a.onBackPressed();
        }
    }

    public static final class c implements View.OnTouchListener {
        public final /* synthetic */ LiveDrawerContainerDialog a;

        public c(LiveDrawerContainerDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            if (r2.getAction() == 0) goto L5;
            return false;
        L5:
            if (this.a.isShowing() == true) goto L7;
            return false;
        L7:
            if (this.a.er() == true) goto L13;
            ALogger.e("LiveDrawerContainerDialog", "drawer state error! without continue show");
            this.a.H();
            return false;
        L13:
            return false;
        }
    }

    static {
    }

    @Override // ut1.k.a
    public final boolean er() {
        View r0 = this.d;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getX() >= s1.y()) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean onBackPressed() {
        k r0 = this.f;
        if (r0 == null) goto L17;
        DrawerLayout r2 = r0.a;
        if (r2 == null) goto L18;
        Intrinsics.checkNotNull(r2);
        if (ViewCompat.isAttachedToWindow(r2) == false) goto L19;
        LiveDrawerLayout r3 = r0.a;
        if (r3 != null) goto L11;
        return false;
    L11:
        if (r3.isDrawerOpen(8388613) != true) goto L21;
        LiveDrawerLayout r1 = r0.a;
        if (r1 == null) goto L15;
        r1.closeDrawer(8388613);
    L15:
        return true;
    L21:
        return false;
    L19:
        return false;
    L18:
        return false;
    L17:
        return false;
    }

    @Override // ut1.k.a
    public final void H() {
        dismissAllowingStateLoss();     // Catch: Exception -> L4
    L9:
        if (lo2.a.d() == false) goto L14;
        lo2.a.e().getClass();
        lo2.a.h(null, false);
        return;
    L14:
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L9;
        d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }

    public final void dismissAllowingStateLoss() {
        super/*androidx.fragment.app.DialogFragment*/.dismissAllowingStateLoss();     // Catch: Exception -> L4
    L8:
        f.d().f();
        if (this.e == true) goto L14;
        h.a("pull");
        this.e = true;
        return;
    L14:
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L8;
        d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L8
    }

    public LiveDrawerContainerDialog() {
    }

    public static View U90(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void onActivityCreated(Bundle r8) {
        super/*androidx.fragment.app.DialogFragment*/.onActivityCreated(r8);
        Dialog r9 = getDialog();
        if (r9 == null) goto L5;
        Window r10 = r9.getWindow();
    L7:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L9;
    L11:
        if (r10 == null) goto L19;
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        r10.addFlags(Integer.MIN_VALUE);
        r10.setNavigationBarColor(-16777216);
        r10.setLayout(-1, -1);
        if (getActivity() != null) goto L15;
        return;
    L15:
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(getActivity(), true, false) == false) goto L21;
        r10.clearFlags(1024);
        return;
    L21:
        return;
    L19:
        return;
    L9:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L11;
        Intrinsics.checkNotNull(r10);
        r10.clearFlags(1024);
        View r0 = U90(r10);
        com.bytedance.android.live.core.utils.statusbar.a.a r6 = com.bytedance.android.live.core.utils.statusbar.a.b;
        r6.a();
        r0.setSystemUiVisibility(1024);
        r6.a();
        r10.addFlags(Integer.MIN_VALUE);
        r10.setStatusBarColor(0);
        r10.setNavigationBarColor(-16777216);
        r10.setLayout(-1, -1);
        return;
    L5:
        r10 = null;
        goto L7
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        setStyle(0, 2131954391);
        this.f = new k(getContext(), getActivity(), getChildFragmentManager(), this);
    }

    public final Dialog onCreateDialog(Bundle r4) {
        Dialog r5 = super/*androidx.fragment.app.DialogFragment*/.onCreateDialog(r4);
        WindowManager.LayoutParams r0 = null;
        if (r5 == null) goto L5;
        Window r1 = r5.getWindow();
    L6:
        if (r1 == null) goto L8;
        r0 = r1.getAttributes();
    L8:
        if (r1 == null) goto L10;
        r1.addFlags(8);
    L10:
        if (r1 == null) goto L12;
        r1.setAttributes(r0);
    L12:
        r5.setCanceledOnTouchOutside(false);
        return r5;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r4v27, types: [android.view.View, com.bytedance.android.livesdk.drawer.LiveDrawerLayout] */
    public final void onViewCreated(View r17, Bundle r18) {
        Intrinsics.checkNotNullParameter(r17, "view");
        super.onViewCreated(r17, r18);
        boolean r1 = StatusBarUtil.STATUS_BAR_ADAPT_ENABLE;
        k r2 = this.f;
        if (r2 == null) goto L332;
        View r3 = this.d;
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L7;
    L9:
        boolean r4 = false;
    L10:
        r2.j = r4;
        DataCenter r5 = r2.q;
        if (r5 == null) goto L13;
        Room r6 = (Room) r5.get("data_room", null);
    L14:
        r2.l = r3;
        Bundle r7 = r2.s;
        if (r7 == null) goto L17;
        boolean r8 = r7.getBoolean("bundle_extra_direct_expend_drawer");
    L18:
        if (r8 == true) goto L21;
        if (r3 == null) goto L21;
        r3.setX(UIUtils.getScreenWidth(r2.n));
    L21:
        if (r3 == null) goto L23;
        LiveDrawerLayout r9 = (LiveDrawerLayout) r3.findViewById(2131370241);
    L24:
        r2.a = r9;
        if (r3 == null) goto L27;
        View r10 = r3.findViewById(2131372250);
    L28:
        r2.b = r10;
        if (r3 == null) goto L31;
        View r11 = r3.findViewById(2131372248);
    L32:
        r2.c = r11;
        if (r3 == null) goto L35;
        RelativeLayout r12 = (RelativeLayout) r3.findViewById(2131381879);
    L36:
        r2.i = r12;
        if (r3 == null) goto L39;
        RelativeLayout r13 = (RelativeLayout) r3.findViewById(2131370235);
    L40:
        r2.k = r13;
        if (r3 == null) goto L43;
        ImageView r14 = (ImageView) r3.findViewById(2131372249);
    L43:
        if (r3 == null) goto L45;
        View r15 = r3.findViewById(2131370244);
    L46:
        r2.h = r15;
        LiveDrawerLayout r16 = r2.a;
        if (r16 == null) goto L49;
        r16.addDrawerListener(r2.m);
    L49:
        LiveDrawerLayout r19 = r2.a;
        if (r19 == null) goto L52;
        r19.setScrimColor(0);
    L52:
        List<? extends DrawerLayout.DrawerListener> r20 = r2.r;
        if (r20 == null) goto L60;
        Iterator<T> r21 = r20.iterator();
    L56:
        if (r21.hasNext() == false) goto L60;
        DrawerLayout.DrawerListener r22 = (DrawerLayout.DrawerListener) r21.next();
        LiveDrawerLayout r23 = r2.a;
        if (r23 == null) goto L56;
        r23.addDrawerListener(r22);
    L60:
        if (r3 == null) goto L62;
        ViewGroup r24 = (ViewGroup) r3.findViewById(2131381878);
    L63:
        if (r3 == null) goto L65;
        ViewGroup r25 = (ViewGroup) r3.findViewById(2131381877);
    L66:
        if (r3 == null) goto L68;
        ViewGroup r26 = (ViewGroup) r3.findViewById(2131381854);
    L70:
        if (LiveDrawerHelper.e() == false) goto L93;
        float r110 = k.a(12.0f) + 12.0f;
        View r111 = r2.c;
        if (r111 == null) goto L75;
        r111.setVisibility(0);
    L75:
        if (r2.j == false) goto L85;
        int r112 = StatusBarUtil.getStatusBarHeight(r2.n);
        if (r25 == null) goto L79;
        r25.setPadding((int) UIUtils.dip2Px(r2.n, 8.0f), r112, (int) UIUtils.dip2Px(r2.n, 8.0f), 0);
    L79:
        RelativeLayout r27 = r2.k;
        if (r27 == null) goto L82;
        r27.setPadding(0, r112, 0, 0);
    L82:
        LinearLayout.LayoutParams r28 = new LinearLayout.LayoutParams(-2, -2);
        r28.setMargins(0, ((int) UIUtils.dip2Px(r2.n, 52.0f)) + r112, 0, 0);
        View r29 = r2.c;
        if (r29 == null) goto L87;
        r29.setLayoutParams(r28);
    L87:
        float r30 = k.a(r110) + 32.0f;
        View r31 = r2.b;
        if (r31 == null) goto L90;
        r31.setVisibility(8);
    L90:
        if (r26 == null) goto L150;
        r26.setBackgroundColor(ColorProtector.parseColor("#f3000000"));
    L150:
        int r32 = (int) (UIUtils.getScreenWidth(r2.n) - UIUtils.dip2Px(r2.n, r110));
        if (r32 <= 0) goto L332;
        r3.a(r2.c, s1.B(2131918649));
        View r33 = r2.c;
        if (r33 == null) goto L156;
        r33.setOnClickListener(new l(r2));
    L156:
        if (r24 == null) goto L158;
        ViewGroup.LayoutParams r34 = r24.getLayoutParams();
    L159:
        if (r34 == null) goto L161;
        r34.width = r32;
    L161:
        if (r24 == null) goto L163;
        r24.setLayoutParams(r34);
    L163:
        LiveDrawerLayout r35 = r2.a;
        if (r35 == null) goto L166;
        r35.openDrawer(8388613, false);
    L166:
        ?? r36 = r2.a;
        if (r36 == 0) goto L174;
        List<DrawerLayout.DrawerListener> r37 = r36.f;
        if (r37 == null) goto L174;
        Iterator r38 = ((ArrayList) r37).iterator();
    L172:
        if (r38.hasNext() == false) goto L174;
        ((DrawerLayout.DrawerListener) r38.next()).onDrawerOpened(r36);
    L174:
        if (r3 == null) goto L176;
        DouyinLoadingLayout r39 = (DouyinLoadingLayout) r3.findViewById(2131369262);
    L177:
        r2.g = r39;
        if (tb1.c.a == true) goto L181;
        if (r39 == null) goto L184;
        r39.setVisibility(8);
    L184:
        if (r2.d != null) goto L332;
        IHostFeed r40 = jc1.k.f(IHostFeed.class);
        if (r40 == null) goto L332;
        r2.d = r40.createDrawerFeedFragment(new m(r2), LiveDrawerHelper.e());
        ILiveSearchService r41 = jc1.k.f(ILiveSearchService.class);
        if (r2.d == null) goto L270;
        Bundle r42 = r2.s;
        if (r42 == null) goto L206;
        if (r41 != null) goto L194;
    L196:
        boolean r43 = false;
    L197:
        r42.putBoolean("live_drawer_support_search", r43);
        DataCenter r44 = r2.q;
        if (r44 == null) goto L200;
        Boolean r45 = (Boolean) r44.get("data_more_entrance_follow", Boolean.FALSE);
    L202:
        if (Intrinsics.areEqual(r45, Boolean.TRUE) == false) goto L206;
        Bundle r46 = r2.s;
        if (r46 == null) goto L206;
        boolean r47 = true;
        r46.putBoolean("switch_follow", true);
    L207:
        Bundle r48 = new Bundle();
        Bundle r49 = r2.s;
        if (r49 == null) goto L210;
        r48.putAll(r49);
    L210:
        o r50 = u.l().c(x.class);
        if (r50.getMap().get("enter_from_merge") == null) goto L213;
        String r113 = (String) r50.getMap().get("enter_from_merge");
    L215:
        if (r50.getMap().get("enter_method") == null) goto L218;
        String r51 = (String) r50.getMap().get("enter_method");
    L218:
        if (LiveDrawerHelper.a(r2.q, r6) == true) goto L220;
    L266:
        Fragment r52 = r2.d;
        if (r52 == null) goto L270;
        r52.setArguments(r48);
        goto L270
    L220:
        if (LiveDrawerHelper.d(r113) == true) goto L235;
        if (LiveDrawerHelper.c(r113) == true) goto L235;
        if (TextUtils.isEmpty(r113) == false) goto L228;
    L230:
        boolean r53 = false;
    L231:
        if (r53 == true) goto L235;
        r47 = false;
        goto L235
    L228:
        if (CollectionsKt.contains(LiveDrawerHelper.d, r113) == false) goto L230;
        r53 = true;
    L235:
        if (r47 == true) goto L237;
        int r54 = c0.b().k;
        if (r6 == null) goto L242;
        VerticalTypeInfo r114 = r6.mVerticalTypeInfo;
    L243:
        if (r114 == null) goto L266;
        if (r54 == 0) goto L259;
        long r55 = r54;
        VerticalTypeInfo r115 = r6.mVerticalTypeInfo;
        if (r115 == null) goto L248;
        Long r116 = r115.tabType;
    L249:
        if (r116 != null) goto L252;
    L253:
        VerticalTypeInfo r117 = r6.mVerticalTypeInfo;
        if (r117 == null) goto L256;
        Long r118 = r117.tabType;
    L257:
        if (r118 != null) goto L259;
        r48.putLong("default_tab_type", r55);
        goto L266
    L256:
        r118 = null;
        goto L257
    L252:
        if (r55 == r116.longValue()) goto L259;
    L248:
        r116 = null;
    L259:
        VerticalTypeInfo r56 = r6.mVerticalTypeInfo;
        if (r56 == null) goto L264;
        Long r57 = r56.tabType;
        if (r57 == null) goto L264;
        long r58 = r57.longValue();
    L265:
        r48.putLong("default_tab_type", r58);
    L264:
        r58 = 0;
        goto L265
    L242:
        r114 = null;
        goto L243
    L237:
        if (LiveDrawerHelper.d(r113) == false) goto L266;
        r48.putLong("default_tab_type", 2);
        goto L266
    L213:
        r113 = "";
        goto L215
    L200:
        r45 = null;
        goto L202
    L194:
        if (r41.supportSearch() == false) goto L196;
        r43 = true;
    L206:
        r47 = true;
    L270:
        if (r2.e != null) goto L286;
        if (r41 == null) goto L286;
        if (r41.supportSearch() == false) goto L286;
        if (r2.n == null) goto L286;
        if (LiveDrawerHelper.e() == true) goto L281;
        RelativeLayout r59 = r2.i;
        if (r59 == null) goto L281;
        r59.setVisibility(0);
    L281:
        Context r60 = r2.n;
        Intrinsics.checkNotNull(r60);
        if (LiveDrawerHelper.e() == false) goto L284;
        RelativeLayout r61 = null;
    L285:
        r2.e = r41.createSearchResultFragment(r60, r61, r2.s, new n(r2, r25, r30));
    L289:
        if (r6 == null) goto L296;
        pa1.a r62 = r2.e;
        if ((r62 instanceof pa1.a) == false) goto L296;
        if (r62 == null) goto L295;
        r62.iV(r6.id);
        goto L296
    L295:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.search.api.ILiveSearchFragment");
    L296:
        if (r6 == null) goto L325;
        if (r41 == null) goto L325;
        if (r41.shouldJumpToSearch(r6.id, r2.o) == false) goto L325;
        DouyinLoadingLayout r63 = r2.g;
        if (r63 == null) goto L303;
        r63.setVisibility(8);
    L303:
        Fragment r64 = r2.e;
        if ((r64 instanceof pa1.a) == false) goto L332;
        if (r64 == null) goto L307;
        Bundle r65 = r64.getArguments();
    L308:
        if (r65 == null) goto L318;
        VerticalTypeInfo r66 = r6.mVerticalTypeInfo;
        if (r66 == null) goto L318;
        if (TextUtils.isEmpty(r66.name) == true) goto L318;
        VerticalTypeInfo r67 = r6.mVerticalTypeInfo;
        if (r67 == null) goto L316;
        String r68 = r67.name;
    L317:
        r65.putString("default_search_key", r68);
        goto L318
    L316:
        r68 = null;
    L318:
        pa1.a r69 = r2.e;
        if ((r69 instanceof pa1.a) == true) goto L321;
        pa1.a r70 = null;
    L322:
        pa1.a r71 = r70;
        if (r71 == null) goto L332;
        r71.OC(false);
        goto L332
    L321:
        r70 = r69;
        goto L322
    L307:
        r65 = null;
    L325:
        r2.b(r2.e, r2.d);
        pa1.a r72 = r2.e;
        if ((r72 instanceof pa1.a) == true) goto L328;
        pa1.a r73 = null;
    L329:
        pa1.a r75 = r73;
        if (r75 == null) goto L332;
        r75.tl();
        goto L332
    L328:
        r73 = r72;
        goto L329
    L284:
        r61 = r2.i;
    L286:
        RelativeLayout r76 = r2.i;
        if (r76 == null) goto L289;
        r76.setVisibility(8);
        goto L289
    L181:
        if (r39 == null) goto L184;
        r39.setVisibility(0);
        goto L184
    L176:
        r39 = null;
        goto L177
    L158:
        r34 = null;
        goto L159
    L85:
        if (r25 == null) goto L87;
        r25.setPadding((int) UIUtils.dip2Px(r2.n, 8.0f), 0, (int) UIUtils.dip2Px(r2.n, 8.0f), 0);
        goto L87
    L93:
        if (tb1.c.a == false) goto L127;
        r110 = k.a(12.0f) + 12.0f;
        View r77 = r2.b;
        if (r77 == null) goto L97;
        r77.setVisibility(8);
    L97:
        View r78 = r2.c;
        if (r78 == null) goto L100;
        r78.setVisibility(0);
    L100:
        float r79 = k.a(r110) + 16.0f;
        ILiveSearchService r119 = jc1.k.f(ILiveSearchService.class);
        if (r2.e != null) goto L108;
        if (r119 == null) goto L108;
        if (r119.supportSearch() == false) goto L108;
        if (r2.n == null) goto L108;
        float r120 = 16.0f;
    L110:
        if (r2.j == false) goto L119;
        if (r25 == null) goto L113;
        r25.setPadding((int) UIUtils.dip2Px(r2.n, 8.0f), ((int) UIUtils.dip2Px(r2.n, r120)) + StatusBarUtil.getStatusBarHeight(r2.n), (int) UIUtils.dip2Px(r2.n, 8.0f), 0);
    L113:
        RelativeLayout r80 = r2.k;
        if (r80 == null) goto L116;
        r80.setPadding(0, ((int) UIUtils.dip2Px(r2.n, r120)) + StatusBarUtil.getStatusBarHeight(r2.n), 0, 0);
    L116:
        LinearLayout.LayoutParams r81 = new LinearLayout.LayoutParams(-2, -2);
        r81.setMargins(0, ((int) UIUtils.dip2Px(r2.n, 52.0f)) + StatusBarUtil.getStatusBarHeight(r2.n), 0, 0);
        View r121 = r2.c;
        if (r121 == null) goto L124;
        r121.setLayoutParams(r81);
    L124:
        if (r26 == null) goto L126;
        r26.setBackgroundColor(ColorProtector.parseColor("#f3000000"));
    L126:
        r30 = r79;
        goto L150
    L119:
        if (r25 == null) goto L121;
        r25.setPadding((int) UIUtils.dip2Px(r2.n, 8.0f), (int) UIUtils.dip2Px(r2.n, r120), (int) UIUtils.dip2Px(r2.n, 8.0f), 0);
    L121:
        RelativeLayout r82 = r2.k;
        if (r82 == null) goto L124;
        r82.setPadding(0, (int) UIUtils.dip2Px(r2.n, r120), 0, 0);
    L108:
        r120 = 44.0f;
        goto L110
    L127:
        View r83 = r2.b;
        if (r83 == null) goto L130;
        r83.setVisibility(0);
    L130:
        View r84 = r2.c;
        if (r84 == null) goto L133;
        r84.setVisibility(8);
    L133:
        r110 = 50.0f;
        r30 = k.a(50.0f) + 12.0f;
        if (r2.j == false) goto L143;
        if (r25 == null) goto L137;
        r25.setPadding(0, ((int) UIUtils.dip2Px(r2.n, 14.0f)) + StatusBarUtil.getStatusBarHeight(r2.n), 0, 0);
    L137:
        RelativeLayout r85 = r2.k;
        if (r85 == null) goto L140;
        r85.setPadding(0, (int) UIUtils.dip2Px(r2.n, 14.0f), 0, 0);
    L140:
        LinearLayout.LayoutParams r86 = new LinearLayout.LayoutParams(-2, -2);
        r86.setMargins(0, ((int) UIUtils.dip2Px(r2.n, 52.0f)) + StatusBarUtil.getStatusBarHeight(r2.n), 0, 0);
        View r122 = r2.c;
        if (r122 == null) goto L148;
        r122.setLayoutParams(r86);
    L148:
        if (r26 == null) goto L150;
        r26.setBackgroundResource(2131249410);
        goto L150
    L143:
        if (r25 == null) goto L145;
        r25.setPadding(0, (int) UIUtils.dip2Px(r2.n, 14.0f), 0, 0);
    L145:
        RelativeLayout r87 = r2.k;
        if (r87 == null) goto L148;
        r87.setPadding(0, (int) UIUtils.dip2Px(r2.n, 14.0f), 0, 0);
        goto L148
    L68:
        r26 = null;
        goto L70
    L65:
        r25 = null;
        goto L66
    L62:
        r24 = null;
        goto L63
    L45:
        r15 = null;
        goto L46
    L39:
        r13 = null;
        goto L40
    L35:
        r12 = null;
        goto L36
    L31:
        r11 = null;
        goto L32
    L27:
        r10 = null;
        goto L28
    L23:
        r9 = null;
        goto L24
    L17:
        r8 = false;
        goto L18
    L13:
        r6 = null;
        goto L14
    L7:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L9;
        r4 = true;
    L332:
        Dialog r88 = getDialog();
        if (r88 == null) goto L335;
        r88.setOnKeyListener(new b(this));
    L335:
        Dialog r89 = getDialog();
        if (r89 == null) goto L351;
        Window r90 = r89.getWindow();
        if (r90 == null) goto L352;
        View r91 = U90(r90);
        if (r91 == null) goto L353;
        ViewGroup r92 = (ViewGroup) r91.findViewById(R.id.content);
        if (r92 == null) goto L354;
        r92.setOnTouchListener(new c(this));
        return;
    L354:
        return;
    L353:
        return;
    L352:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131565828, r3, false);
        this.d = r5;
        return r5;
    }
}
