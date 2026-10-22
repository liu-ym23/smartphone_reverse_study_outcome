package com.bytedance.android.livesdk.interactivity.publicscreen.stylesetting.ui;

import android.content.DialogInterface;
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
import com.bytedance.android.livesdk.chatroom.ui.SmoothLinearLayoutManager;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.n;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.s;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.PublicScreenConfigSliderView;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.mock.FakeMessageListAdapter;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.y;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.w2;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import ec2.e1;
import g52.e;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ma2.b;
import na2.c;
import na2.f;
import na2.g;
import py.k;
import tb2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/stylesetting/ui/PublicScreenStyleSettingDialog;", "Landroidx/fragment/app/DialogFragment;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/n;", "Lma2/b$b;", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublicScreenStyleSettingDialog extends DialogFragment implements n, b.InterfaceC0249b {
    public static final /* synthetic */ int u = 0;
    public n.a d;
    public View e;
    public RecyclerView f;
    public SpaceItemDecoration g;
    public FakeMessageListAdapter h;
    public e i;
    public PublicScreenConfigSliderView j;
    public PublicScreenConfigSliderView k;
    public View l;
    public View m;
    public HSImageView n;
    public HSImageView o;
    public HSImageView p;
    public final List<d> q;
    public final int r;
    public final DataCenter s;
    public final b t;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.n
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

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        ((ArrayList) this.q).clear();
        this.t.a = null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.n
    public final void RE(n.a r1) {
        this.d = r1;
    }

    public final void T90(int r3) {
        int r0 = s.a;
        String r1 = "fake public screen use height: " + r3;
        Intrinsics.checkNotNullParameter(r1, "string");
        ALogger.i("PublicScreenStyleSetting", r1);
        RecyclerView r2 = this.f;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L5:
        ViewGroup.LayoutParams r4 = r2.getLayoutParams();
        if (r4 == null) goto L11;
        r4.height = r3;
        RecyclerView r5 = this.f;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L10:
        r5.setLayoutParams(r4);
    L11:
        RecyclerView r6 = this.f;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L14:
        r6.scrollToPosition(CollectionsKt.getLastIndex(this.q));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.n
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

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super.onCancel(r2);
        dismiss();     // Catch: Exception -> L5
    L9:
        this.t.g();
        n.a r3 = this.d;
        if (r3 == null) goto L15;
        r3.onCancel();
        return;
    L15:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L9;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(0, 2131954615);
        b r3 = this.t;
        r3.a = this;
        r3.f();
    }

    public PublicScreenStyleSettingDialog(DataCenter r2, ma2.a r3) {
        Intrinsics.checkNotNullParameter(r3, "presenter");
        this.s = r2;
        this.t = r3;
        this.q = new ArrayList();
        if (PadConfigUtils.c() == false) goto L5;
        int r4 = UtilityKotlinExtentionsKt.i(64);
    L6:
        this.r = r4;
        return;
    L5:
        r4 = UtilityKotlinExtentionsKt.i(60);
        goto L6
    }

    public final void S90(List r2, y r3) {
        ((SingleSubscribeProxy) Single.create(new na2.e(r2, r3)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new f(this), g.a);
    }

    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r14, r15);
        SmoothLinearLayoutManager r16 = new SmoothLinearLayoutManager(getContext());
        r16.p(1.0f);
        this.g = new SpaceItemDecoration(1, q.e(gb2.a.a(this.s, false), true), false);
        l r17 = com.bytedance.android.livesdk.interactivity.api.q.i();
        if (r17 == null) goto L13;
        e52.a r18 = r17.getTextConfig();
        if (r18 == null) goto L13;
        DataCenter r3 = this.s;
        if (r3 == null) goto L11;
        Boolean r0 = (Boolean) r3.get("data_is_anchor");
        if (r0 == null) goto L11;
        boolean r1 = r0.booleanValue();
    L12:
        e r19 = q.a(r18, true, r1);
    L20:
        this.i = r19;
        FakeMessageListAdapter r110 = new FakeMessageListAdapter();
        e r2 = this.i;
        if (r2 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("textConfig");
    L23:
        r110.b = r2;
        Unit r4 = Unit.INSTANCE;
        this.h = r110;
        RecyclerView r111 = this.f;
        if (r111 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L26:
        r111.setLayoutManager(r16);
        FakeMessageListAdapter r112 = this.h;
        if (r112 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L29:
        r111.setAdapter(r112);
        SpaceItemDecoration r113 = this.g;
        if (r113 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("spaceItemDecoration");
    L32:
        r111.addItemDecoration(r113);
        if (((Boolean) e1.a.getValue()).booleanValue() == true) goto L38;
        RecyclerView r114 = this.f;
        if (r114 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L37:
        r114.setVerticalFadingEdgeEnabled(false);
    L38:
        r111.addOnItemTouchListener(new PublicScreenStyleSettingDialog$configViews$2$1());
        View r115 = this.l;
        if (r115 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("btnClose");
    L41:
        r115.setOnClickListener(new c(this));
        View r116 = this.m;
        if (r116 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("btnComplete");
    L44:
        r116.setOnClickListener(new na2.d(this));
        String r117 = i2.a;
        HSImageView r118 = this.n;
        if (r118 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("giftTray1");
    L47:
        i2.h(r118, "/publicscreen/mock/ttlive_gift_tray_mock1.png");
        HSImageView r119 = this.o;
        if (r119 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("giftTray2");
    L50:
        i2.h(r119, "/publicscreen/mock/ttlive_gift_tray_mock2.png");
        HSImageView r120 = this.p;
        if (r120 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("enterAnim");
    L53:
        i2.h(r120, "/publicscreen/mock/ttlive_enter_anim_mock.png");
        PublicScreenConfigSliderView r121 = this.j;
        if (r121 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("fontSlider");
    L56:
        d52.a r5 = (d52.a) this.t.a(d52.a.class);
        if (r5 == null) goto L59;
        int r6 = r5.a();
    L60:
        r121.b(r6, false);
        PublicScreenConfigSliderView r122 = this.j;
        if (r122 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("fontSlider");
    L63:
        r122.setCallback(new na2.a(this));
        PublicScreenConfigSliderView r123 = this.k;
        if (r123 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("heightSlider");
    L66:
        d52.b r7 = (d52.b) this.t.a(d52.b.class);
        if (r7 == null) goto L69;
        int r8 = r7.a();
    L70:
        r123.b(r8, false);
        PublicScreenConfigSliderView r124 = this.k;
        if (r124 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("heightSlider");
    L73:
        r124.setCallback(new na2.b(this));
        this.t.j(this.s);
        if (PadConfigUtils.c() == false) goto L100;
        View r125 = this.e;
        if (r125 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("toolbar");
    L78:
        a1.k(r125, this.r);
        RecyclerView r126 = this.f;
        if (r126 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L81:
        ViewParent r127 = r126.getParent();
        if ((r127 instanceof ConstraintLayout) == true) goto L84;
        r127 = null;
    L84:
        ConstraintLayout r128 = (ConstraintLayout) r127;
        if (r128 == null) goto L100;
        ConstraintSet r11 = new ConstraintSet();
        r11.clone(r128);
        r11.clear(2131383412);
        RecyclerView r9 = this.f;
        if (r9 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L90:
        r11.constrainWidth(r9.getId(), (int) (s1.y() * 0.4f));
        RecyclerView r10 = this.f;
        if (r10 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L93:
        r11.connect(r10.getId(), 1, 0, 1, UtilityKotlinExtentionsKt.i(16));
        RecyclerView r13 = this.f;
        if (r13 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L96:
        int r20 = r13.getId();
        View r21 = this.e;
        if (r21 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("toolbar");
    L99:
        r11.connect(r20, 4, r21.getId(), 3, UtilityKotlinExtentionsKt.i(14));
        r11.applyTo(r128);
    L100:
        Integer r129 = (Integer) this.t.b(d52.b.class, Integer.TYPE);
        if (r129 == null) goto L103;
        T90(r129.intValue());
    L103:
        IBaseUser r130 = vh7.f.c(IBaseUser.class);
        r130.setNickName("用户昵称");
        tb2.c r23 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r130, null, true, false);
        tb2.c r24 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r130, null, false, false);
        yb2.a r25 = w.a();
        d r26 = new d();
        r26.c(r23);
        r26.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f("评论内容"));
        r26.b = r25;
        int r27 = 0;
    L105:
        if (r27 >= 17) goto L107;
        ((ArrayList) this.q).add(r26);
        r27 = r27 + 1;
        goto L105
    L107:
        d r28 = new d();
        r28.c(r24);
        r28.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(" 关注了主播"));
        yb2.a r29 = w.a();
        r29.d = s1.h(2131107646);
        Unit r30 = Unit.INSTANCE;
        r28.b = r29;
        ((ArrayList) this.q).add(r28);
        d r31 = new d();
        r31.c(r23);
        r31.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f("送出摩天大厦 "));
        k r33 = vh7.f.c(k.class);
        r33.setUri("webcast/dbdf519c73851373747e13f92b114013.png");
        r33.setUrls(CollectionsKt.listOf(new String[]{"https://p3-webcast.douyinpic.com/img/webcast/public_area_setting_gift.png~tplv-obj.image", "https://p6-webcast.douyinpic.com/img/webcast/public_area_setting_gift.png~tplv-obj.image", "https://p9-webcast.douyinpic.com/img/webcast/public_area_setting_gift.png~tplv-obj.image"}));
        r33.setAvgColor("#DCF4FA");
        r31.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.b("$*", r33, UtilityKotlinExtentionsKt.i(16), UtilityKotlinExtentionsKt.i(16)));
        r31.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(" x1"));
        yb2.a r34 = w.a();
        r34.d = s1.h(2131107649);
        r31.b = r34;
        ((ArrayList) this.q).add(r31);
        k r35 = vh7.f.c(k.class);
        k r36 = r35;
        r36.setUrls(CollectionsKt.listOf(new String[]{"https://p3-webcast.douyinpic.com/img/webcast/public_area_setting_user_grade_level.png~tplv-obj.image", "https://p6-webcast.douyinpic.com/img/webcast/public_area_setting_user_grade_level.png~tplv-obj.image", "https://p9-webcast.douyinpic.com/img/webcast/public_area_setting_user_grade_level.png~tplv-obj.image"}));
        r36.setImageType(1);
        r36.setHeight(16);
        r36.setWidth(32);
        k.b r37 = vh7.f.c(k.b.class);
        r37.setLevel(22);
        r37.setAccessibilityText("荣誉等级22级勋章");
        r36.setContent(r37);
        List r38 = CollectionsKt.listOf(r35);
        d r39 = new d();
        r39.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r130, null, true, false));
        r39.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f("评论内容"));
        r39.b = r25;
        r39.d(com.bytedance.android.livesdk.interactivity.service.textrender.utils.d.b(r38));
        ((ArrayList) this.q).add(r39);
        d r131 = new d();
        r131.c(r24);
        r131.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(" 来了"));
        yb2.a r132 = w.a();
        r132.d = s1.h(2131107651);
        r131.b = r132;
        ((ArrayList) this.q).add(r131);
        Float r133 = (Float) this.t.b(d52.a.class, Float.TYPE);
        if (r133 == null) goto L112;
        S90(this.q, new y(r133.floatValue() * q.d(true, false)));
        return;
    L112:
        return;
    L69:
        r8 = 0;
        goto L70
    L59:
        r6 = 0;
    L11:
        r1 = false;
    L13:
        float r40 = w2.a(14.0f);
        int r41 = (int) s1.b(24.0f);
        Typeface r43 = Typeface.DEFAULT_BOLD;
        int r44 = UtilityKotlinExtentionsKt.i(8);
        int r45 = UtilityKotlinExtentionsKt.i(3);
        int r134 = UtilityKotlinExtentionsKt.i(8);
        int r135 = UtilityKotlinExtentionsKt.i(3);
        float r136 = PublicScreenStyleHelper.g;
        DataCenter r46 = this.s;
        if (r46 == null) goto L18;
        Boolean r47 = (Boolean) r46.get("data_is_anchor");
        if (r47 == null) goto L18;
        boolean r48 = r47.booleanValue();
    L19:
        r19 = new e(r40, r41, r43, r44, r45, r134, r135, r136, q.c(r48, true));
    L18:
        r48 = false;
        goto L19
    }

    @Override // ma2.b.InterfaceC0249b
    public final void Cn(Class r2, d52.b r3, la2.a r4) {
        Intrinsics.checkNotNullParameter(r2, "styleType");
        Intrinsics.checkNotNullParameter(r3, "defaultStyle");
        Intrinsics.checkNotNullParameter(r4, "callback");
        if (Intrinsics.areEqual(r2, d52.b.class) == false) goto L8;
        PublicScreenConfigSliderView r5 = this.k;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("heightSlider");
    L12:
        r5.setDisable(true);
        r5.b(r3.a(), false);
        r5.setDisableSettingCallback(r4);
        return;
    L8:
        if (Intrinsics.areEqual(r2, d52.a.class) == false) goto L14;
        r5 = this.j;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("fontSlider");
        goto L12
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
