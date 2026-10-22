package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import am2.x;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.ui.SmoothLinearLayoutManager;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.y;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.mock.FakeMessageListAdapter;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.w2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import ec2.e1;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/ui/AnchorPublicScreenConfigDialog;", "Landroidx/fragment/app/DialogFragment;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/a;", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPublicScreenConfigDialog extends DialogFragment implements com.bytedance.android.livesdk.interactivity.api.publicscreen.a {
    public static final /* synthetic */ int B = 0;
    public final boolean A;
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.a.InterfaceC0093a d;
    public View e;
    public RecyclerView f;
    public SpaceItemDecoration g;
    public FakeMessageListAdapter h;
    public g52.e i;
    public PublicScreenConfigSliderView j;
    public PublicScreenConfigSliderView k;
    public View l;
    public View m;
    public HSImageView n;
    public HSImageView o;
    public HSImageView p;
    public final List<tb2.d> q;
    public float r;
    public int s;
    public int t;
    public int u;
    public int v;
    public final int w;
    public final int x;
    public final int y;
    public final float z;

    public static final class a {
    }

    static {
    }

    public AnchorPublicScreenConfigDialog() {
        this(false, null);
    }

    public final Map<String, String> S90() {
        HashMap r0 = new HashMap();
        if (jc1.k.f(IRoomContextService.class) != null) goto L5;
    L6:
        r0.put("anchor_id", jc1.k.n(IMiddlewareUserService.class).user().n());
        r0.put("live_type", "video_live");
    L7:
        return r0;
    L5:
        if (IRoomContextService.a.a(jc1.k.n(IRoomContextService.class), null, 0, 3).h2() == true) goto L7;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.a
    public final void dismissDialog() {
        dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Exception -> L9
        Throwable r0 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L9
        if (r0 == null) goto L16;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L9
        return;
    L16:
        return;
    L9:
        e = move-exception;
        SafetyGuard.a("dismiss AnchorPublicScreenConfigDialog failed", e, null);
    }

    public final void onCancel() {
        j0.l().sendLog("livesdk_anchor_screen_message_setting_exit_click", S90(), new Object[]{IRoom.class, x.class});
        dismiss();     // Catch: Exception -> L5
    L9:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.a.InterfaceC0093a r0 = this.d;
        if (r0 == null) goto L15;
        r0.onCancel();
        return;
    L15:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L9;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        ((ArrayList) this.q).clear();
    }

    public final void U90(int r3) {
        RecyclerView r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L11;
        r1.height = r3;
        RecyclerView r4 = this.f;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L10:
        r4.setLayoutParams(r1);
    L11:
        RecyclerView r5 = this.f;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L14:
        r5.scrollToPosition(CollectionsKt.getLastIndex(this.q));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.a
    public final void V4(FragmentManager r3) {
        Intrinsics.checkNotNullParameter(r3, "fragmentManager");
    L13:
        e = move-exception;
        SafetyGuard.a("open AnchorPublicScreenConfigDialog failed", e, null);
        return;
    L4:
        if (r3.isDestroyed() == false) goto L6;
        return;
    L6:
        if (r3.isStateSaved() == true) goto L22;
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L13
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, "AnchorPublicScreenConfigDialog", r1);     // Catch: Exception -> L13
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r1) == true) goto L23;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L11:
        show(r3, "AnchorPublicScreenConfigDialog");     // Catch: Exception -> L13
        return;
    L23:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.a
    public final void fP(com.bytedance.android.livesdk.interactivity.api.publicscreen.a.InterfaceC0093a r1) {
        this.d = r1;
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super.onCancel(r2);
        onCancel();
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(0, 2131954615);
        this.r = q.c(true, true);
        this.s = PublicScreenStyleHelper.a();
        int r3 = PublicScreenStyleHelper.c();
        this.t = r3;
        this.u = this.s;
        this.v = r3;
    }

    public AnchorPublicScreenConfigDialog(boolean r5, Integer r6) {
        this.A = r5;
        this.q = new ArrayList();
        if (PadConfigUtils.c() == false) goto L5;
        int r0 = (int) (s1.w() * 0.28f);
    L6:
        this.w = r0;
        if (PadConfigUtils.c() == false) goto L9;
        int r1 = UtilityKotlinExtentionsKt.i(64);
    L10:
        this.x = r1;
        if (r5 == true) goto L13;
        int r2 = (((s1.w() - s1.A()) - UtilityKotlinExtentionsKt.i(322)) - r0) - r1;
    L20:
        this.y = r2;
        int r7 = PublicScreenStyleHelper.a;
        this.z = 0.28571427f;
        return;
    L13:
        if (r6 == null) goto L17;
        int r3 = (s1.w() - s1.A()) - r6.intValue();
        InteractionWidgetsPosContext.Companion.getClass();
        r2 = ((r3 - InteractionWidgetsPosContext.access$getENTER_ANIMATION_HEIGHT$cp()) - r0) - r1;
        if (r2 > 0) goto L20;
        ALogger.e("AnchorPublicScreenConfigDialog", "landscape video bottom too low, bottom pos: " + r6 + ", height: " + r2);
    L18:
        r2 = 0;
        goto L20
    L17:
        ALogger.e("AnchorPublicScreenConfigDialog", "null landscape video bottom");
        goto L18
    L9:
        r1 = UtilityKotlinExtentionsKt.i(60);
        goto L10
    L5:
        r0 = y.a();
        goto L6
    }

    public final void T90(List r2, com.bytedance.android.livesdk.interactivity.service.textrender.core.y r3) {
        ((SingleSubscribeProxy) Single.create(new f(r2, r3)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new g(this), h.a);
    }

    public final void onViewCreated(View r28, Bundle r29) {
        Intrinsics.checkNotNullParameter(r28, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r28, r29);
        SmoothLinearLayoutManager r1 = new SmoothLinearLayoutManager(getContext());
        r1.p(1.0f);
        this.g = new SpaceItemDecoration(1, q.e(true, true), false);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r2 = com.bytedance.android.livesdk.interactivity.api.q.i();
        if (r2 == null) goto L9;
        e52.a r3 = r2.getTextConfig();
        if (r3 == null) goto L9;
        n42.a r4 = r3.h();
        if (r4 == null) goto L9;
        Rect r5 = r4.d;
        g52.e r16 = new g52.e(r4.a, r4.c, r4.b, UtilityKotlinExtentionsKt.i(r5.left), UtilityKotlinExtentionsKt.i(r5.top), UtilityKotlinExtentionsKt.i(r5.right), UtilityKotlinExtentionsKt.i(r5.bottom), PublicScreenStyleHelper.g, this.r);
    L10:
        this.i = r16;
        FakeMessageListAdapter r6 = new FakeMessageListAdapter();
        g52.e r7 = this.i;
        if (r7 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("textConfig");
    L13:
        r6.b = r7;
        Unit r8 = Unit.INSTANCE;
        this.h = r6;
        RecyclerView r9 = this.f;
        if (r9 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L16:
        r9.setLayoutManager(r1);
        FakeMessageListAdapter r10 = this.h;
        if (r10 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L19:
        r9.setAdapter(r10);
        SpaceItemDecoration r11 = this.g;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("spaceItemDecoration");
    L22:
        r9.addItemDecoration(r11);
        if (((Boolean) e1.a.getValue()).booleanValue() == true) goto L28;
        RecyclerView r13 = this.f;
        if (r13 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L27:
        r13.setVerticalFadingEdgeEnabled(false);
    L28:
        r9.addOnItemTouchListener(new AnchorPublicScreenConfigDialog$configViews$2$1());
        View r14 = this.l;
        if (r14 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("btnClose");
    L31:
        r14.setOnClickListener(new d(this));
        View r15 = this.l;
        if (r15 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("btnClose");
    L34:
        r3.c(r15, s1.B(2131914868), true);
        View r17 = this.m;
        if (r17 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("btnComplete");
    L37:
        r17.setOnClickListener(new e(this));
        String r18 = i2.a;
        HSImageView r19 = this.n;
        if (r19 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("giftTray1");
    L40:
        i2.h(r19, "/publicscreen/mock/ttlive_gift_tray_mock1.png");
        HSImageView r20 = this.o;
        if (r20 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("giftTray2");
    L43:
        i2.h(r20, "/publicscreen/mock/ttlive_gift_tray_mock2.png");
        HSImageView r21 = this.p;
        if (r21 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("enterAnim");
    L46:
        i2.h(r21, "/publicscreen/mock/ttlive_enter_anim_mock.png");
        PublicScreenConfigSliderView r23 = this.j;
        if (r23 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("fontSlider");
    L49:
        r23.b(this.s, false);
        PublicScreenConfigSliderView r24 = this.j;
        if (r24 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("fontSlider");
    L52:
        r24.setCallback(new com.bytedance.android.livesdk.interactivity.publicscreen.ui.a(this));
        if (this.A == false) goto L55;
    L74:
        PublicScreenConfigSliderView r25 = this.k;
        if (r25 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("heightSlider");
    L77:
        r25.b(this.t, false);
        PublicScreenConfigSliderView r26 = this.k;
        if (r26 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("heightSlider");
    L80:
        r26.setCallback(new b(this));
    L82:
        if (PadConfigUtils.c() == false) goto L108;
        View r27 = this.e;
        if (r27 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("toolbar");
    L86:
        a1.k(r27, this.x);
        RecyclerView r30 = this.f;
        if (r30 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L89:
        ViewParent r31 = r30.getParent();
        if ((r31 instanceof ConstraintLayout) == true) goto L92;
        r31 = null;
    L92:
        ConstraintLayout r33 = (ConstraintLayout) r31;
        if (r33 == null) goto L108;
        ConstraintSet r110 = new ConstraintSet();
        r110.clone(r33);
        r110.clear(2131383412);
        RecyclerView r34 = this.f;
        if (r34 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L98:
        r110.constrainWidth(r34.getId(), (int) (s1.y() * 0.4f));
        RecyclerView r35 = this.f;
        if (r35 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L101:
        r110.connect(r35.getId(), 1, 0, 1, UtilityKotlinExtentionsKt.i(16));
        RecyclerView r36 = this.f;
        if (r36 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L104:
        int r37 = r36.getId();
        View r38 = this.e;
        if (r38 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("toolbar");
    L107:
        r110.connect(r37, 4, r38.getId(), 3, UtilityKotlinExtentionsKt.i(14));
        r110.applyTo(r33);
    L108:
        int r39 = this.v;
        if (r39 != 0) goto L111;
        int r40 = this.w;
    L118:
        U90(r40);
    L119:
        IBaseUser r41 = vh7.f.c(IBaseUser.class);
        r41.setNickName("用户昵称");
        tb2.c r43 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r41, null, true, false);
        tb2.c r44 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r41, null, false, false);
        yb2.a r45 = w.a();
        tb2.d r46 = new tb2.d();
        r46.c(r43);
        r46.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f("评论内容"));
        r46.b = r45;
        int r111 = 0;
    L121:
        if (r111 >= 17) goto L123;
        ((ArrayList) this.q).add(r46);
        r111 = r111 + 1;
        goto L121
    L123:
        tb2.d r47 = new tb2.d();
        r47.c(r44);
        r47.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(" 关注了主播"));
        yb2.a r112 = w.a();
        r112.d = s1.h(2131107646);
        Unit r113 = Unit.INSTANCE;
        r47.b = r112;
        ((ArrayList) this.q).add(r47);
        tb2.d r48 = new tb2.d();
        r48.c(r43);
        r48.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f("送出摩天大厦 "));
        py.k r49 = vh7.f.c(py.k.class);
        r49.setUri("webcast/dbdf519c73851373747e13f92b114013.png");
        r49.setUrls(CollectionsKt.listOf(new String[]{"https://p3-webcast.douyinpic.com/img/webcast/public_area_setting_gift.png~tplv-obj.image", "https://p6-webcast.douyinpic.com/img/webcast/public_area_setting_gift.png~tplv-obj.image", "https://p9-webcast.douyinpic.com/img/webcast/public_area_setting_gift.png~tplv-obj.image"}));
        r49.setAvgColor("#DCF4FA");
        r48.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.b("$*", r49, UtilityKotlinExtentionsKt.i(16), UtilityKotlinExtentionsKt.i(16)));
        r48.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(" x1"));
        yb2.a r50 = w.a();
        r50.d = s1.h(2131107649);
        r48.b = r50;
        ((ArrayList) this.q).add(r48);
        py.k r51 = vh7.f.c(py.k.class);
        py.k r53 = r51;
        r53.setUrls(CollectionsKt.listOf(new String[]{"https://p3-webcast.douyinpic.com/img/webcast/public_area_setting_user_grade_level.png~tplv-obj.image", "https://p6-webcast.douyinpic.com/img/webcast/public_area_setting_user_grade_level.png~tplv-obj.image", "https://p9-webcast.douyinpic.com/img/webcast/public_area_setting_user_grade_level.png~tplv-obj.image"}));
        r53.setImageType(1);
        r53.setHeight(16);
        r53.setWidth(32);
        py.k.b r54 = vh7.f.c(py.k.b.class);
        r54.setLevel(22);
        r54.setAccessibilityText("荣誉等级22级勋章");
        r53.setContent(r54);
        List r55 = CollectionsKt.listOf(r51);
        tb2.d r56 = new tb2.d();
        r56.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r41, null, true, false));
        r56.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f("评论内容"));
        r56.b = r45;
        r56.d(com.bytedance.android.livesdk.interactivity.service.textrender.utils.d.b(r55));
        ((ArrayList) this.q).add(r56);
        tb2.d r57 = new tb2.d();
        r57.c(r44);
        r57.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(" 来了"));
        yb2.a r58 = w.a();
        r58.d = s1.h(2131107651);
        r57.b = r58;
        ((ArrayList) this.q).add(r57);
        T90(this.q, new com.bytedance.android.livesdk.interactivity.service.textrender.core.y(this.r));
        return;
    L111:
        if (r39 == 1) goto L115;
        if (r39 != 2) goto L119;
        int r59 = this.w;
        int r60 = this.y;
    L116:
        r40 = r59 + r60;
        goto L118
    L115:
        r59 = this.w;
        r60 = this.y / 2;
        goto L116
    L55:
        if (this.y > 0) goto L57;
    L64:
        PublicScreenStyleHelper.f(0);
        PublicScreenConfigSliderView r61 = this.k;
        if (r61 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("heightSlider");
    L67:
        r61.setDisable(true);
        PublicScreenConfigSliderView r63 = this.k;
        if (r63 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("heightSlider");
    L70:
        r63.b(0, false);
        PublicScreenConfigSliderView r64 = this.k;
        if (r64 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("heightSlider");
    L73:
        r64.setDisableSettingCallback(new c());
        goto L82
    L57:
        if (PublicScreenStyleHelper.n == true) goto L59;
    L61:
        boolean r65 = false;
    L62:
        if (r65 == true) goto L64;
    L59:
        if (PublicScreenStyleHelper.b().f() == false) goto L61;
        r65 = true;
    L9:
        r16 = new g52.e(w2.a(14.0f), (int) s1.b(24.0f), Typeface.DEFAULT_BOLD, UtilityKotlinExtentionsKt.i(8), UtilityKotlinExtentionsKt.i(3), UtilityKotlinExtentionsKt.i(8), UtilityKotlinExtentionsKt.i(3), PublicScreenStyleHelper.g, this.r);
        goto L10
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131567235, r3, false);
        this.l = r5.findViewById(2131364679);
        this.m = r5.findViewById(2131364688);
        this.f = r5.findViewById(2131383412);
        this.j = (PublicScreenConfigSliderView) r5.findViewById(2131386890);
        this.k = (PublicScreenConfigSliderView) r5.findViewById(2131386892);
        this.n = r5.findViewById(2131373788);
        this.o = r5.findViewById(2131373789);
        this.p = r5.findViewById(2131371683);
        this.e = r5.findViewById(2131389057);
        return r5;
    }
}
