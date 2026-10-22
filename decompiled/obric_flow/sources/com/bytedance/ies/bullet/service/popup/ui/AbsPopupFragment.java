package com.bytedance.ies.bullet.service.popup.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import cn.nubia.neopush.commons.Constant;
import com.airbnb.lottie.t;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.android.anniex.container.view.RadiusFrameLayout;
import com.bytedance.android.monitorV2.k;
import com.bytedance.forest.utils.m;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.container.e;
import com.bytedance.ies.bullet.pool.g;
import com.bytedance.ies.bullet.service.base.CacheType;
import com.bytedance.ies.bullet.service.base.d;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.ies.bullet.service.base.n;
import com.bytedance.ies.bullet.service.base.p;
import com.bytedance.ies.bullet.service.popup.ui.primary.PrimaryDialog;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.launcher.widget.R$id;
import com.obric.launcher.widget.R$layout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.json.JSONObject;
import w8.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00022\u00020\u00042\u00020\u0005:\u0002\b\tB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "", "Lcom/bytedance/ies/bullet/service/base/n;", "Lcom/bytedance/ies/bullet/core/n;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "CloseReason", "z5/a", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@SourceDebugExtension({"SMAP\nAbsPopupFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbsPopupFragment.kt\ncom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Cast.kt\ncom/ss/android/ugc/aweme/uncheckedcast/CastKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1026:1\n1#2:1027\n4#3:1028\n4#3:1029\n4#3:1030\n4#3:1031\n4#3:1032\n4#3:1033\n1819#4,2:1034\n1819#4,2:1036\n*E\n*S KotlinDebug\n*F\n+ 1 AbsPopupFragment.kt\ncom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment\n*L\n243#1:1028\n247#1:1029\n258#1:1030\n263#1:1031\n278#1:1032\n287#1:1033\n835#1,2:1034\n845#1,2:1036\n*E\n"})
public class AbsPopupFragment extends AppCompatDialogFragment implements n, com.bytedance.ies.bullet.core.n, View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CloseReason f6063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FragmentActivity f6064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public md.c f6065c;
    public t9.a d;
    public f e;
    public com.bytedance.ies.bullet.base.utils.logger.b f;
    public View g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BulletContainerView f6066h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f6067i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f6068j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f6069k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public e f6070l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6071m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f6072n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public d f6073o;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment$CloseReason;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final enum CloseReason extends Enum<CloseReason> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CloseReason f6074a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final CloseReason f6075b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final CloseReason f6076c = null;
        public static final CloseReason d = null;
        public static final /* synthetic */ CloseReason[] e = null;

        static {
            CloseReason r5 = new CloseReason("UNKNOWN", 0);
            f6074a = r5;
            CloseReason r10 = new CloseReason("TAP_MASK", 1);
            CloseReason r11 = new CloseReason("GESTURE", 2);
            f6075b = r11;
            CloseReason r12 = new CloseReason("JSB", 3);
            f6076c = r12;
            CloseReason r13 = new CloseReason("TITLE_BAR", 4);
            d = r13;
            e = new CloseReason[]{r5, r10, r11, r12, r13};
        }

        public CloseReason(String r5, int r10) {
            super(r5, r10);
        }

        public static CloseReason valueOf(String r5) {
            return (CloseReason) Enum.valueOf(CloseReason.class, r5);
        }

        public static CloseReason[] values() {
            return (CloseReason[]) e.clone();
        }
    }

    public AbsPopupFragment() {
        this.f6063a = CloseReason.f6074a;
        c r5 = new c();
        AnimController$AnimProcessType r10 = AnimController$AnimProcessType.f6091a;
        r5.f6100b = r10;
        r5.f6101c = r10;
        this.f6067i = r5;
        this.f6068j = LazyKt.lazy(new AbsPopupFragment$poolService$2(this));
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void b() {
        if (this.d == null) goto L5;
        Intrinsics.checkNotNullParameter(this, "component");
    L5:
        com.bytedance.ies.bullet.service.router.a r5 = (com.bytedance.ies.bullet.service.router.a) yc.a.a(com.bytedance.ies.bullet.service.router.a.class, "default_bid");
        if (r5 == null) goto L9;
        r5.a(i().f20065b, getChannel(), d(), this);
        return;
    }

    public final void c() {
        if (getFragmentManager() != null) goto L7;
        com.bytedance.ies.bullet.service.base.b.a(4, "dismissSafely found fragmentManager=null", null);
        return;
    L7:
        if (this.f6064b != null) goto L9;
    L12:
        super.dismissAllowingStateLoss();
        return;
    L9:
        if (g().isFinishing() == false) goto L12;
        com.bytedance.ies.bullet.service.base.b.a(4, "dismissSafely found act finishing", null);
    }

    @Override // androidx.fragment.app.DialogFragment, com.bytedance.ies.bullet.service.base.n
    public final void close() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r10 = MapsKt.mapOf(TuplesKt.to("close popup url", String.valueOf(i().f20066c)));
        com.bytedance.ies.bullet.base.utils.logger.b r11 = this.f;
        Intrinsics.checkNotNullParameter("XPopup", "moduleTag");
        Intrinsics.checkNotNullParameter("AbsPopupFragment close", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XPopup", "AbsPopupFragment close", r10, r11);
        CloseReason r12 = CloseReason.f6074a;
        Intrinsics.checkNotNullParameter(r12, "closeReason");
        CloseReason r13 = CloseReason.f6076c;
        if (this.f6063a != r12) goto L27;
        this.f6063a = r13;
        if (this.g != null) goto L7;
        return;
    L7:
        if (this.f6069k == true) goto L29;
        Dialog r14 = getDialog();
        ObjectAnimator r15 = null;
        if ((r14 instanceof AbsPopupDialog) == false) goto L12;
        AbsPopupDialog r16 = (AbsPopupDialog) r14;
    L13:
        if (r16 == null) goto L25;
        c r17 = this.f6067i;
        Dialog r18 = getDialog();
        if (r18 == null) goto L19;
        Window r19 = r18.getWindow();
        if (r19 == null) goto L19;
        View r20 = r19.getDecorView();
    L20:
        f r21 = this.e;
        if (r21 == null) goto L23;
        r15 = r21.h();
    L23:
        r17.b(r20, r15, i().e, new AbsPopupFragment$dismissAllowingStateLossWithReason$1$1(this), new AbsPopupFragment$dismissAllowingStateLossWithReason$1$2(this));
        return;
    L19:
        r20 = null;
        goto L20
    L25:
        c();
        return;
    L12:
        r16 = null;
        goto L13
    L29:
        return;
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final String d() {
        if (this.f6065c != null) goto L6;
        com.bytedance.ies.bullet.service.base.b.a(2, "popup config is not initialized", "XPopup");
        return "";
    L6:
        String r5 = (String) new vd.a(i().f20065b.g.f21723a, "bundle", null).f22372b;
        if (r5 != null) goto L12;
        String r10 = i().d.getString("__x_param_bundle");
        if (r10 != null) goto L11;
        return "";
    L11:
        return r10;
    L12:
        return r5;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismiss() {
        Dialog r5 = getDialog();
        ObjectAnimator r10 = null;
        if (r5 == null) goto L18;
        Window r11 = r5.getWindow();
        if (r11 == null) goto L18;
        View r12 = r11.getCurrentFocus();
        if (r12 != null) goto L12;
        View r13 = r11.getDecorView();
        View r14 = r13.findViewWithTag("keyboardTagView");
        if (r14 != null) goto L11;
        r14 = new EditText(r11.getContext());
        r14.setTag("keyboardTagView");
        ((ViewGroup) r13).addView(r14, 0, 0);
    L11:
        r12 = r14;
        r12.requestFocus();
    L12:
        Context r15 = getContext();
        if (r15 == null) goto L15;
        Object r16 = r15.getSystemService("input_method");
    L16:
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r16).hideSoftInputFromWindow(r12.getWindowToken(), 0);
        goto L18
    L15:
        r16 = null;
    L18:
        if (this.g != null) goto L20;
        c();
        return;
    L20:
        if (this.f6069k == false) goto L22;
        return;
    L22:
        Dialog r17 = getDialog();
        if ((r17 instanceof AbsPopupDialog) == false) goto L25;
        AbsPopupDialog r18 = (AbsPopupDialog) r17;
    L26:
        if (r18 == null) goto L38;
        c r19 = this.f6067i;
        Dialog r20 = getDialog();
        if (r20 == null) goto L32;
        Window r21 = r20.getWindow();
        if (r21 == null) goto L32;
        View r22 = r21.getDecorView();
    L33:
        f r23 = this.e;
        if (r23 == null) goto L36;
        r10 = r23.h();
    L36:
        r19.b(r22, r10, i().e, new AbsPopupFragment$dismiss$2$1(this), new AbsPopupFragment$dismiss$2$2(this));
        return;
    L32:
        r22 = null;
        goto L33
    L38:
        c();
        return;
    L25:
        r18 = null;
        goto L26
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final String e() {
        if (this.f6065c != null) goto L7;
        com.bytedance.ies.bullet.service.base.b.a(2, "popup config is not initialized", "XPopup");
        return null;
    L7:
        return (String) new vd.a(i().f20065b.g.f21723a, "bdx_tag", null).f22372b;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void f() {
    }

    public final FragmentActivity g() {
        FragmentActivity r5 = this.f6064b;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("act");
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final String getBid() {
        return "default_bid";
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final String getChannel() {
        if (this.f6065c != null) goto L6;
        com.bytedance.ies.bullet.service.base.b.a(2, "popup config is not initialized", "XPopup");
        return "";
    L6:
        String r5 = (String) new vd.a(i().f20065b.g.f21723a, LynxMonitorService.KEY_CHANNEL, null).f22372b;
        if (r5 != null) goto L12;
        String r10 = i().d.getString("__x_param_channel");
        if (r10 != null) goto L11;
        return "";
    L11:
        return r10;
    L12:
        return r5;
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final String getContainerId() {
        e r5 = this.f6070l;
        if (r5 == null) goto L5;
        String r10 = r5.getSessionId();
    L6:
        if (r10 != null) goto L9;
        return "";
    L9:
        return r10;
    L5:
        r10 = null;
        goto L6
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final vc.c getLynxClient() {
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final Uri getSchema() {
        return i().f20066c;
    }

    public final com.bytedance.ies.bullet.core.e h() {
        if (this.f6065c != null) goto L7;
        return null;
    L7:
        return i().f20065b;
    }

    public final md.c i() {
        md.c r5 = this.f6065c;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("config");
        return null;
    }

    public final View j() {
        View r5 = this.g;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("popupContainerView");
        return null;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void n() {
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void o(Uri r5, h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r21) {
        super.onActivityCreated(r21);
        FragmentActivity r5 = getActivity();
        String r10 = "<set-?>";
        if (r5 == null) goto L5;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f6064b = r5;
    L5:
        String r11 = "XPopup";
        if (this.f6064b == null) goto L173;
        if (this.f6065c == null) goto L173;
        Dialog r12 = getDialog();
        if (r12 == null) goto L13;
        r12.setOwnerActivity(g());
    L13:
        i().getClass();
        Dialog r13 = getDialog();
        if (r13 == null) goto L20;
        Window r14 = r13.getWindow();
        if (r14 == null) goto L20;
        View r15 = r14.getDecorView();
        if (r15 == null) goto L20;
        i().getClass();
        r15.setBackgroundColor(0);
    L20:
        this.f6069k = false;
        int r16 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.core.e r17 = h();
        if (r17 == null) goto L25;
        rd.e r18 = r17.g;
        if (r18 == null) goto L25;
        Uri r19 = ((com.bytedance.ies.bullet.service.sdk.b) r18.f21723a).f6135c;
    L26:
        Map r20 = MapsKt.mapOf(TuplesKt.to("popup schema", String.valueOf(r19)));
        com.bytedance.ies.bullet.base.utils.logger.b r110 = this.f;
        Intrinsics.checkNotNullParameter("XPopup", "moduleTag");
        Intrinsics.checkNotNullParameter("popup status onActivityCreated", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XPopup", "popup status onActivityCreated", r20, r110);
        View r22 = LayoutInflater.from(g()).inflate(R$layout.bullet_popup_container, null);
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        this.g = r22;
        c r23 = this.f6067i;
        Dialog r111 = getDialog();
        if (r111 == null) goto L31;
        Window r112 = r111.getWindow();
        if (r112 == null) goto L31;
        View r113 = r112.getDecorView();
    L32:
        f r114 = this.e;
        if (r114 == null) goto L35;
        ObjectAnimator r24 = ObjectAnimator.ofFloat(((AbsPopupFragment) r114.f22816a).j(), "alpha", new float[]{0.0f, 1.0f});
    L36:
        int r115 = i().e;
        Function0<Unit> r25 = new AnonymousClass2(this);
        Function1<Float, Unit> r26 = new AnonymousClass3(this);
        r23.getClass();
        Intrinsics.checkNotNullParameter(r25, "succUnits");
        Intrinsics.checkNotNullParameter(r26, "animProgressListener");
        if (((AnimController$AnimProcessType) r23.f6100b) != AnimController$AnimProcessType.f6091a) goto L45;
        if (r24 != null) goto L42;
        r25.invoke();
        goto L45
    L42:
        if (r113 == null) goto L44;
        ObjectAnimator r27 = ObjectAnimator.ofFloat(r113, "alpha", new float[]{0.0f, 1.0f}).setDuration(300);
        r24.setDuration(r115);
        r24.addListener(new b(r23, r25, 0));
        r24.addUpdateListener(new t(r26, 1));
        AnimatorSet r28 = new AnimatorSet();
        r28.playTogether(new Animator[]{r27, r24});
        r28.start();
        goto L45
    L44:
        r10 = "<set-?>";
        r24.setDuration(r115);
        r24.addListener(new b(r23, r25, 0));
        r24.addUpdateListener(new t(r26, 1));
        r24.start();
    L45:
        i().getClass();
        BulletContainerView r29 = new BulletContainerView(g(), null, 6, 0);
        r29.f("default_bid");
        Intrinsics.checkNotNullParameter(r29, "view");
        d(r29, null);
        r29.setMCurrentScene(Scenes.f5283c);
        Intrinsics.checkNotNullParameter(r29, r10);
        this.f6066h = r29;
        Intrinsics.checkNotNullParameter(r29, r10);
        this.f6066h = r29;
        LinearLayout r30 = (LinearLayout) j().findViewById(R$id.bullet_popup_linear);
        BulletContainerView r31 = this.f6066h;
        if (r31 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("popupContentView");
        r31 = null;
    L49:
        r30.addView(r31, new ViewGroup.LayoutParams(-1, -1));
        final Uri r32 = i().f20066c;
        Intrinsics.checkNotNullParameter(r32, LynxResourceModule.URI_KEY);
        final Bundle r33 = i().d;
        i().getClass();
        r33.putInt("lynx_preset_width", i().g);
        r33.putInt("lynx_preset_height", i().f);
        i().getClass();     // Catch: Exception -> L52
    L54:
        i().f20065b.f5293c.c(System.currentTimeMillis(), false);
        BulletContainerView r34 = this.f6066h;
        if (r34 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("popupContentView");
        r34 = null;
    L58:
        if (r34 != null) goto L61;
        r34 = null;
    L61:
        if (r34 == null) goto L115;
        Function2<BulletContainerView, CacheType, Unit> r35 = new AbsPopupFragment$load$2$1(this, r32, r33);
        boolean r36 = Intrinsics.areEqual(i().d.getString("prerender"), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        g r37 = (g) this.f6068j.getValue();
        if (r37 == null) goto L110;
        Uri r38 = i().f20066c;
        Intrinsics.checkNotNullParameter(r38, "schema");
        Intrinsics.checkNotNullParameter(r34, "originView");
        boolean r39 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "start to fetch on schema: " + r38 + ", openPreRender: " + r36 + ", openReUse: false", "XPreRender");
        com.bytedance.ies.bullet.pool.d r40 = (com.bytedance.ies.bullet.pool.d) r37.f5813c.get(r37.f5811a);
        if (r40 == null) goto L67;
        if (r38 == null) goto L67;
        r40.d.getClass();
        Intrinsics.checkNotNullParameter(r38, "schema");
        String r41 = a.a.b(r38, "url");
        if (r41 == null) goto L74;
        String r42 = a.a.b(Uri.parse(r41), "view_cache_key");
        if (r42 == null) goto L74;
    L73:
        String r116 = r42;
        boolean r117 = r36;
        if (r116 != null) goto L78;
    L87:
        String r118 = "moduleTag";
        String r119 = "msg";
        String r120 = "uniqueSchema";
    L88:
        we.a r43 = r40.f5807c;
        r43.getClass();
        Intrinsics.checkNotNullParameter(r38, r120);
        f r44 = (f) r43.f22857a;
        r44.getClass();
        Intrinsics.checkNotNullParameter(r38, r120);
        com.bytedance.ies.bullet.service.base.e r121 = (com.bytedance.ies.bullet.service.base.e) ((k) r44.f22816a).remove(r38);
        StringBuilder r45 = new StringBuilder("fetchReUsed uniqueSchema, status: ");
        if (r121 == null) goto L91;
        boolean r46 = true;
    L92:
        r45.append(r46);
        r45.append(", pool left: ");
        r45.append(((k) ((f) r40.f5807c.f22857a).f22816a).size());
        com.bytedance.ies.bullet.service.base.b.a(2, r45.toString(), "XPreRender");
        if (r121 == null) goto L95;
        Intrinsics.checkNotNullParameter(r121, "<this>");
        Intrinsics.checkNotNullParameter(new com.bytedance.ies.bullet.service.base.f(r121.f5984a, r121.f5985b, CacheType.f5916a), "event");
    L97:
        String r47 = a.a.b(r38, "url");
        if (r47 == null) goto L100;
        String r48 = a.a.b(Uri.parse(r47), "view_cache_key");
    L101:
        if (r121 == null) goto L111;
        BulletContainerView r49 = r121.f5986c;
        if (r48 != null) goto L105;
        boolean r50 = r117;
    L109:
        com.bytedance.ies.bullet.pool.util.a.c(r49, r34, r50);
        com.bytedance.ies.bullet.service.base.b.a(2, "fetch pool cache item success: " + r121.f5986c, "XPreRender");
    L112:
        if (r121 != null) goto L114;
        r35.mo2invoke(r34, CacheType.f5917b);
    L116:
        Dialog r51 = getDialog();
        if ((r51 instanceof AbsPopupDialog) == false) goto L119;
        AbsPopupDialog r52 = (AbsPopupDialog) r51;
    L120:
        if (r52 == null) goto L122;
        r52.setContentView(j());
        i().getClass();
        r52.f6060a = new AbsPopupFragment$constructUIBody$4$1(this);
        r52.f6061b = new AbsPopupFragment$constructUIBody$4$2(this);
        r52.d = new AbsPopupFragment$constructUIBody$4$3(this);
    L122:
        f r53 = this.e;
        if (r53 == null) goto L142;
        AbsPopupFragment r54 = (AbsPopupFragment) r53.f22816a;
        if (r54.g == null) goto L142;
        RadiusFrameLayout r55 = (RadiusFrameLayout) r54.j().findViewById(R$id.bullet_popup_round);
        if (r55 == null) goto L142;
        ViewGroup.LayoutParams r56 = r55.getLayoutParams();
        r54.i().getClass();
        r56.width = -1;
        r54.i().getClass();
        r56.height = -1;
        if (r54.f6065c == null) goto L131;
        r54.i().getClass();
        float r57 = 0;
        r54.i().getClass();
        r54.i().getClass();
        r54.i().getClass();
        r54.i().getClass();
        r54.i().getClass();
        r54.i().getClass();
        r54.i().getClass();
        float[] r58 = {r57, r57, r57, r57, r57, r57, r57, r57};
    L132:
        r55.setRadius(r58);
        if ((r54.g().getWindow().getDecorView().getSystemUiVisibility() & 4) != 0) goto L135;
        r54.i().getClass();
        r54.i().getClass();
    L135:
        ViewGroup.LayoutParams r59 = r55.getLayoutParams();
        if ((r59 instanceof FrameLayout.LayoutParams) == false) goto L138;
        FrameLayout.LayoutParams r60 = (FrameLayout.LayoutParams) r59;
    L139:
        if (r60 == null) goto L141;
        r60.gravity = 17;
    L141:
        r54.i().getClass();
        goto L142
    L138:
        r60 = null;
        goto L139
    L131:
        r58 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    L142:
        String r61 = r11;
        com.bytedance.ies.bullet.service.base.b.a(2, "created default_bid", r61);
        i().getClass();
        i().getClass();
        i().getClass();
        Dialog r62 = getDialog();
        if (r62 == null) goto L148;
        Window r63 = r62.getWindow();
        if (r63 == null) goto L148;
        r63.setSoftInputMode(32);
    L148:
        if (this.f6073o != null) goto L155;
        tc.c r64 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r65 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r65 == null) goto L152;
        d r66 = (d) r65.f6163b.getValue();
    L153:
        this.f6073o = r66;
        goto L155
    L152:
        r66 = null;
    L155:
        if (this.f6073o == null) goto L171;
        i().getClass();
        ArrayList r67 = md.b.f;
        i().getClass();
        Intrinsics.checkNotNullParameter("", "containerId");
        Iterator r68 = md.b.f.iterator();
    L158:
        if (r68.hasNext() == false) goto L162;
        Object r69 = r68.next();
        if (Intrinsics.areEqual(((AbsPopupFragment) r69).getContainerId(), "") == false) goto L158;
        Object r70 = r69;
    L163:
        AbsPopupFragment r71 = (AbsPopupFragment) r70;
        if (r71 == null) goto L170;
        f r72 = r71.e;
        if (r72 == null) goto L170;
        Dialog r73 = ((AbsPopupFragment) r72.f22816a).getDialog();
        if (r73 == null) goto L170;
        r73.dismiss();
    L170:
        int r74 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Pair r75 = TuplesKt.to("popup url", String.valueOf(i().f20066c));
        i().getClass();
        Map r76 = MapsKt.mapOf(new Pair[]{r75, TuplesKt.to("handleTriggerPopupOnCreate", "FINISH")});
        com.bytedance.ies.bullet.base.utils.logger.b r77 = this.f;
        Intrinsics.checkNotNullParameter(r61, r118);
        Intrinsics.checkNotNullParameter("handleTriggerPopupOnCreate", r119);
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, r61, "handleTriggerPopupOnCreate", r76, r77);
        goto L171
    L162:
        r70 = null;
    L171:
        b();
        return;
    L119:
        r52 = null;
        goto L120
    L114:
        BulletContainerView r78 = r121.f5986c;
        Intrinsics.checkNotNull(r78, "null cannot be cast to non-null type com.bytedance.ies.bullet.ui.common.BulletContainerView");
        r35.mo2invoke(r78, CacheType.f5916a);
        goto L116
    L105:
        if (r48.length() <= 0) goto L107;
        r50 = true;
        goto L109
    L107:
        r50 = false;
    L111:
        r121 = null;
        goto L112
    L100:
        r48 = null;
        goto L101
    L95:
        Intrinsics.checkNotNullParameter(new com.bytedance.ies.bullet.service.base.f(r38, r38, CacheType.f5917b), "event");
    L96:
        r121 = null;
        goto L97
    L91:
        r46 = false;
        goto L92
    L78:
        if (r116.length() <= 0) goto L87;
        r119 = "msg";
        com.bytedance.ies.bullet.pool.impl.a r122 = r40.f5806b;
        r122.getClass();
        Intrinsics.checkNotNullParameter(r116, "uniqueSchema");
        ug.e r123 = r122.f5817a;
        r123.getClass();
        Intrinsics.checkNotNullParameter(r116, "uniqueSchema");
        r121 = (com.bytedance.ies.bullet.service.base.e) ((m) r123.f22361b).remove(r116);
        r118 = "moduleTag";
        StringBuilder r79 = com.lynx.tasm.utils.e.b("fetchPreRendered cache key: ", r116, ", status: ");
        if (r121 == null) goto L82;
        boolean r124 = true;
    L83:
        r79.append(r124);
        r79.append(", pool left: ");
        r79.append(((m) r40.f5806b.f5817a.f22361b).size());
        com.bytedance.ies.bullet.service.base.b.a(2, r79.toString(), "XPreRender");
        r120 = "uniqueSchema";
        if (r121 == null) goto L86;
        Intrinsics.checkNotNullParameter(r121, "<this>");
        Intrinsics.checkNotNullParameter(new com.bytedance.ies.bullet.service.base.f(r121.f5984a, r121.f5985b, CacheType.f5916a), "event");
        wn.f.f(r38, "success", ((m) r40.f5806b.f5817a.f22361b).size(), r116, r40.f5805a);
        r11 = r11;
        goto L97
    L86:
        wn.f.f(r38, "fail", ((m) r40.f5806b.f5817a.f22361b).size(), r116, r40.f5805a);
        goto L88
    L82:
        r124 = false;
    L74:
        r42 = a.a.b(r38, "view_cache_key");
    L67:
        r117 = r36;
        r11 = r11;
        r118 = "moduleTag";
        r119 = "msg";
        goto L96
    L110:
        r11 = r11;
        r118 = "moduleTag";
        r119 = "msg";
        goto L111
    L115:
        r11 = r11;
        r118 = "moduleTag";
        r119 = "msg";
    L52:
        e = move-exception;
        e.printStackTrace();
        goto L54
    L35:
        r24 = null;
    L31:
        r113 = null;
    L25:
        r19 = null;
    L173:
        com.bytedance.ies.bullet.service.base.b.a(2, "act and config is not init, dismiss dialog fragment", "XPopup");
        Dialog r80 = getDialog();
        if ((r80 instanceof AbsPopupDialog) == false) goto L176;
        AbsPopupDialog r81 = (AbsPopupDialog) r80;
    L177:
        if (r81 == null) goto L179;
        r81.supportRequestWindowFeature(1);
    L179:
        super.dismissAllowingStateLoss();
        return;
    L176:
        r81 = null;
        goto L177
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        CloseReason r10 = CloseReason.d;
        if (this.f6063a != CloseReason.f6074a) goto L6;
        this.f6063a = r10;
        dismiss();
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        if (this.f6065c == null) goto L6;
        i().f20065b.f5293c.i(null);
        i().getClass();
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r5) {
        if (this.e == null) goto L5;
    L7:
        f r10 = this.e;
        if (r10 == null) goto L12;
        return new PrimaryDialog(((AbsPopupFragment) r10.f22816a).requireContext());
    L12:
        return super.onCreateDialog(r5);
    L5:
        if (this.f6065c == null) goto L7;
        Log.e("liucheng", "onCreateDialog: pop mode is " + i() + ".type");
        i().getClass();
        this.e = new f(this);
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        int r5 = 1;
        super.onDestroy();
        if (this.f6064b != null) goto L5;
        return;
    L5:
        if (this.f6065c == null) goto L46;
        JSONObject r10 = new JSONObject();
        JSONObject r11 = new JSONObject();
        r11.put("containerID", getContainerId());
        Unit r12 = Unit.INSTANCE;
        r10.put("data", r11);
        r10.put("eventName", "onClosePanel");
        Intrinsics.checkNotNullParameter(Constant.NOTIFICATION, "name");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        e r13 = this.f6070l;
        if (r13 == null) goto L10;
        r13.c(new com.bytedance.ies.bullet.lynx.impl.b(1, Constant.NOTIFICATION, r10));
    L10:
        JSONObject r14 = new JSONObject();
        r14.put(NotificationCompat.CATEGORY_STATUS, "destroy");
        Intrinsics.checkNotNullParameter("popupStatusChange", "name");
        Intrinsics.checkNotNullParameter(r14, LynxResourceModule.PARAMS_KEY);
        e r15 = this.f6070l;
        if (r15 == null) goto L14;
        r15.c(new com.bytedance.ies.bullet.lynx.impl.b(1, "popupStatusChange", r14));
    L14:
        if (this.d == null) goto L16;
        Intrinsics.checkNotNullParameter(this, "component");
    L16:
        new Handler().postDelayed(new a(this, r5), 100);
        ArrayList r16 = md.b.f;
        String r17 = i().f20064a;
        Intrinsics.checkNotNullParameter(this, OpenPageMethod.APP_POPUP);
        ArrayList r18 = md.b.f;
        r18.remove(this);
        int r19 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.core.e r20 = h();
        Uri r21 = null;
        if (r20 == null) goto L21;
        rd.b r22 = r20.e;
        if (r22 == null) goto L21;
        Uri r23 = ((com.bytedance.ies.bullet.service.sdk.b) r22).f6135c;
    L22:
        Map r24 = MapsKt.mapOf(new Pair[]{TuplesKt.to("popup url", String.valueOf(r23)), TuplesKt.to("bid", "default_bid")});
        com.bytedance.ies.bullet.base.utils.logger.b r25 = new com.bytedance.ies.bullet.base.utils.logger.b();
        if (r17 != null) goto L25;
        r17 = "";
    L25:
        Intrinsics.checkNotNullParameter("session_id", "name");
        Intrinsics.checkNotNullParameter(r17, "sessionId");
        r25.f5260a.add(new com.bytedance.ies.bullet.base.utils.logger.c("session_id", r17));
        Intrinsics.checkNotNullParameter("XPopup", "moduleTag");
        Intrinsics.checkNotNullParameter("createBulletPopup", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XPopup", "createBulletPopup", r24, r25);
        AbsPopupFragment r26 = (AbsPopupFragment) CollectionsKt.lastOrNull(r18);
        if (r26 == null) goto L28;
        r26.i().getClass();
    L28:
        md.b.g.add(this);
        if (this.f6073o != null) goto L36;
        tc.c r27 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r28 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r28 == null) goto L33;
        d r29 = (d) r28.f6163b.getValue();
    L34:
        this.f6073o = r29;
        goto L36
    L33:
        r29 = null;
    L36:
        if (this.f6073o == null) goto L38;
        i().getClass();
    L38:
        Pair r30 = TuplesKt.to("closeReason", this.f6063a);
        com.bytedance.ies.bullet.core.e r31 = h();
        if (r31 == null) goto L43;
        rd.e r32 = r31.g;
        if (r32 == null) goto L43;
        r21 = ((com.bytedance.ies.bullet.service.sdk.b) r32.f21723a).f6135c;
    L43:
        Map r33 = MapsKt.mapOf(new Pair[]{r30, TuplesKt.to("popup schema", String.valueOf(r21))});
        com.bytedance.ies.bullet.base.utils.logger.b r34 = this.f;
        Intrinsics.checkNotNullParameter("XPopup", "moduleTag");
        Intrinsics.checkNotNullParameter("popup status onDestroy", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XPopup", "popup status onDestroy", r33, r34);
        return;
    L21:
        r23 = null;
        goto L22
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        Dialog r5 = getDialog();
        if ((r5 instanceof AbsPopupDialog) == false) goto L5;
        AbsPopupDialog r10 = (AbsPopupDialog) r5;
    L6:
        if (r10 == null) goto L8;
        r10.d();
    L8:
        this.f6069k = true;
        super.onDestroyView();
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        this.f6071m = false;
        if (this.f6072n == false) goto L7;
        e r5 = this.f6070l;
        if (r5 == null) goto L7;
        r5.e();
    L7:
        boolean r10 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(8, i().f20064a, "popup status:onPause", "XPopup");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f6071m = true;
        if (this.f6072n == false) goto L7;
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r10 = MapsKt.mapOf(TuplesKt.to("popup url", String.valueOf(i().f20066c)));
        com.bytedance.ies.bullet.base.utils.logger.b r11 = this.f;
        Intrinsics.checkNotNullParameter("XPopup", "moduleTag");
        Intrinsics.checkNotNullParameter("AbsPopupFragment onResume call onEnterForeground", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XPopup", "AbsPopupFragment onResume call onEnterForeground", r10, r11);
        e r12 = this.f6070l;
        if (r12 == null) goto L7;
        r12.d();
    L7:
        int r13 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.core.e r14 = h();
        if (r14 == null) goto L12;
        rd.e r15 = r14.g;
        if (r15 == null) goto L12;
        Uri r16 = ((com.bytedance.ies.bullet.service.sdk.b) r15.f21723a).f6135c;
    L13:
        Map r17 = MapsKt.mapOf(TuplesKt.to("popup schema", String.valueOf(r16)));
        com.bytedance.ies.bullet.base.utils.logger.b r18 = this.f;
        Intrinsics.checkNotNullParameter("XPopup", "moduleTag");
        Intrinsics.checkNotNullParameter("popup status onResume", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XPopup", "popup status onResume", r17, r18);
        return;
    L12:
        r16 = null;
        goto L13
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r5) {
        Intrinsics.checkNotNullParameter(r5, "outState");
        if (((AnimController$AnimProcessType) this.f6067i.f6101c) == AnimController$AnimProcessType.f6091a) goto L6;
        super.dismissAllowingStateLoss();
        this.f6069k = true;
        super.onSaveInstanceState(r5);
        return;
    L6:
        super.onSaveInstanceState(r5);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        boolean r5 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(8, i().f20064a, "popup status:onStop", "XPopup");
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void p(Uri r5, h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        com.bytedance.ies.bullet.service.base.b.a(2, "onLoadUriSuccess", "XPopup");
        ArrayList r11 = md.b.f;
        String r12 = i().f20064a;
        Intrinsics.checkNotNullParameter(this, OpenPageMethod.APP_POPUP);
        int r13 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.core.e r14 = h();
        if (r14 == null) goto L7;
        rd.b r15 = r14.e;
        if (r15 == null) goto L7;
        Uri r16 = ((com.bytedance.ies.bullet.service.sdk.b) r15).f6135c;
    L8:
        Map r17 = MapsKt.mapOf(new Pair[]{TuplesKt.to("popup url", String.valueOf(r16)), TuplesKt.to("bid", "default_bid")});
        com.bytedance.ies.bullet.base.utils.logger.b r18 = new com.bytedance.ies.bullet.base.utils.logger.b();
        if (r12 != null) goto L11;
        r12 = "";
    L11:
        Intrinsics.checkNotNullParameter("session_id", "name");
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("session_id", r12, r18.f5260a);
        Unit r19 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter("XPopup", "moduleTag");
        Intrinsics.checkNotNullParameter("createBulletPopup", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XPopup", "createBulletPopup", r17, r18);
        md.b.f.add(this);
        if (this.d == null) goto L15;
        Intrinsics.checkNotNullParameter(this, "component");
        return;
    L15:
        return;
    L7:
        r16 = null;
        goto L8
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void q(Uri r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "e");
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void r(Uri r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "e");
        boolean r11 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "onLoadUriFailed " + r10, "XPopup");
        if (this.d == null) goto L5;
        Intrinsics.checkNotNullParameter(r10, "throwable");
    L5:
        dismiss();
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void s(Uri r5, hb.a r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void u(Uri r5, e r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        this.f6070l = r10;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void v(Uri r5, h r10, rd.e r11) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "schemaModelUnion");
        r11.getClass();
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void w(Uri r5, h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        View r11 = j();
        if (r11 == null) goto L6;
        r11.post(new a(this, 0));
        return;
    }

    public final void d(BulletContainerView r5, Uri r10) {
        Intrinsics.checkNotNullParameter(r5, "view");
        String r11 = null;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L6
        if (r10 == null) goto L8;
        String r13 = io.reactivex.exceptions.a.h(r10, "url");     // Catch: Throwable -> L6
    L9:
        if (r13 != null) goto L11;
        r13 = "";
    L11:
        Object r14 = Result.m124constructorimpl(Uri.parse(r13));     // Catch: Throwable -> L6
    L15:
        if (Result.m130isFailureimpl(r14) == false) goto L17;
        r14 = null;
    L17:
        Uri r15 = (Uri) r14;
        if (r15 == null) goto L20;
        String r16 = io.reactivex.exceptions.a.h(r15, "loading_style");
    L21:
        Intrinsics.areEqual(r16, "host");
        if (r15 == null) goto L24;
        r11 = io.reactivex.exceptions.a.h(r15, "error_page_style");
    L24:
        Intrinsics.areEqual(r11, "host");
        h();
        com.bytedance.ies.bullet.service.base.b.a(2, "AbsPopupFragment.setStatusView: viewService is null = true", "XPopup");
        com.bytedance.ies.bullet.service.base.b.a(2, "AbsPopupFragment.setStatusView: loadingBid = default_bid, errorBid = default_bid", "XPopup");
        tc.c r17 = tc.c.f22119c;
        if (tc.c.f22119c.a(p.class, "default_bid") != null) goto L32;
        if (tc.c.f22119c.a(p.class, "default_bid") != null) goto L30;
        return;
    L30:
        throw new ClassCastException();
    L32:
        throw new ClassCastException();
    L20:
        r16 = null;
        goto L21
    L8:
        r13 = null;
    L6:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L15
    }
}
