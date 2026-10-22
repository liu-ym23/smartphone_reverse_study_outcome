package com.bytedance.android.livesdk.interactivity.barrage.setting.vs;

import a62.g;
import a62.h;
import a62.i;
import a62.j;
import a62.k;
import am2.x;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.matchroom.MatchLandFullShadowLinearLayout;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.live.matchroom.b;
import com.bytedance.android.livesdk.castscreen.AdaptiveDialogFragment;
import com.bytedance.android.livesdk.f;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.android.livesdk.interactivity.api.settings.config.a1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n22.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/setting/vs/VSLiveLandscapeBarrageSettingDialog;", "Lcom/bytedance/android/livesdk/castscreen/AdaptiveDialogFragment;", "Lcom/bytedance/android/live/matchroom/b;", "Ln22/c;", "Lcom/bytedance/android/livesdk/interactivity/barrage/setting/vs/AbsBarrageSettingWidget$a;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSLiveLandscapeBarrageSettingDialog extends AdaptiveDialogFragment implements b, c, AbsBarrageSettingWidget.a {
    public static final /* synthetic */ int m = 0;
    public boolean e;
    public DataCenter f;
    public View g;
    public BarrageSetting h;
    public BarrageSettingArea i;
    public BarrageSetting j;
    public String k;
    public WidgetManager l;

    public static final class a {
        public static void a(VSLiveLandscapeBarrageSettingDialog r2, FragmentManager r3) {
            LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "VSLandscapeBarrageSettingDialog", r0);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
            return;
        L9:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r2.showNow(r3, "VSLandscapeBarrageSettingDialog");
        }

        public static void b(Context r2, DataCenter r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            FragmentActivity r5 = ContextUtil.contextToFragmentActivity(r2);
            if (r5 == null) goto L13;
            FragmentManager r6 = r5.getSupportFragmentManager();
            if ((r6.findFragmentByTag("VSLandscapeBarrageSettingDialog") instanceof VSLiveLandscapeBarrageSettingDialog) == false) goto L11;
            VSLiveLandscapeBarrageSettingDialog r0 = r6.findFragmentByTag("VSLandscapeBarrageSettingDialog");
            if (r0 == null) goto L10;
            VSLiveLandscapeBarrageSettingDialog r1 = r0;
            r1.f = r3;
            r1.k = r4;
            a(r1, r6);
            return;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.barrage.setting.vs.VSLiveLandscapeBarrageSettingDialog");
        L11:
            VSLiveLandscapeBarrageSettingDialog r7 = new VSLiveLandscapeBarrageSettingDialog();
            r7.f = r3;
            r7.k = r4;
            a(r7, r6);
            return;
        }
    }

    static {
    }

    @Override // n22.c
    public final void dismiss() {
        View r0 = this.g;
        if (r0 == null) goto L5;
        r0.setOnClickListener(null);
    L5:
        this.l = null;
        MatchRoomLandScapeAnimUtil.E.j("VSLandscapeBarrageSettingDialog");
        super/*com.bytedance.android.livesdk.LiveDialogFragment*/.dismiss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L15;
        d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void dismissAllowingStateLoss() {
        View r0 = this.g;
        if (r0 == null) goto L5;
        r0.setOnClickListener(null);
    L5:
        this.l = null;
        MatchRoomLandScapeAnimUtil.E.j("VSLandscapeBarrageSettingDialog");
        super/*androidx.fragment.app.DialogFragment*/.dismissAllowingStateLoss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L15;
        d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final int getActualContentWidth() {
        return UtilityKotlinExtentionsKt.i(375);
    }

    public final void onStop() {
        BarrageSetting r0 = this.h;
        if (r0 == null) goto L48;
        HashMap r1 = new HashMap();
        BarrageSettingArea r2 = r0.getBarrageArea();
        String r3 = "null";
        String r5 = "close";
        if (r2 == null) goto L13;
        int r4 = g.a[r2.ordinal()];
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L12;
        String r6 = "top";
    L18:
        r1.put("barrage_position", r6);
        BarrageSettingFont r7 = r0.getFontSize();
        if (r7 == null) goto L29;
        int r8 = g.b[r7.ordinal()];
        if (r8 == 1) goto L28;
        if (r8 == 2) goto L27;
        if (r8 != 3) goto L29;
        r3 = "small";
        goto L29
    L27:
        r3 = "medium";
        goto L29
    L28:
        r3 = "big";
    L29:
        r1.put("barrage_size", r3);
        StringBuilder r9 = new StringBuilder();
        r9.append(String.valueOf((int) r0.getAlpha()));
        String r10 = BuildConfig.FLAVOR;
        r9.append(BuildConfig.FLAVOR);
        r1.put("opacity", r9.toString());
        if (r0.isGiftOpen() == false) goto L32;
        Object r11 = "open";
    L33:
        r1.put("gift_message", r11);
        int r13 = a1.a;
        if (a1.a.a().d() == false) goto L40;
        if (r0.isCarnivalBarrageOpen() == false) goto L38;
        r5 = "open";
    L38:
        r1.put("carnival_message", r5);
    L40:
        if ((!S90(r0, this.j)) == false) goto L42;
        String r14 = "1";
    L43:
        r1.put("is_change", r14);
        String r15 = this.k;
        if (r15 == null) goto L47;
        r10 = r15;
    L47:
        r1.put("request_page", r10);
        j0.l().sendLog("livesdk_landscape_barrage_settings_change", r1, new Object[]{new x(), IRoom.class});
        X50(r0);
        goto L48
    L42:
        r14 = "0";
        goto L43
    L32:
        r11 = "close";
        goto L33
    L12:
        if (r4 != 4) goto L13;
        r6 = "close";
        goto L18
    L16:
        r6 = "half";
        goto L18
    L17:
        r6 = "full_screen";
    L13:
        r6 = "null";
    L48:
        this.i = null;
        super/*androidx.fragment.app.DialogFragment*/.onStop();
    }

    public final void onPause() {
        f.d().d = false;
        super/*androidx.fragment.app.Fragment*/.onPause();
    }

    public final void onResume() {
        f.d().d = true;
        super/*androidx.fragment.app.Fragment*/.onResume();
    }

    public VSLiveLandscapeBarrageSettingDialog() {
    }

    public final boolean isVertical() {
        return this.e;
    }

    @Override // com.bytedance.android.livesdk.interactivity.barrage.setting.vs.AbsBarrageSettingWidget.a
    public final void X50(BarrageSetting r2) {
        Intrinsics.checkNotNullParameter(r2, "barrageSetting");
        if (r2.isNeedRollback() == false) goto L7;
        BarrageSettingArea r0 = this.i;
        if (r0 == null) goto L7;
        r2.setBarrageArea(r0);
    L7:
        e<BarrageSetting> r1 = l42.a.d;
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, r2);
    }

    public final void onActivityCreated(Bundle r6) {
        super.onActivityCreated(r6);
        View r7 = getView();
        ViewGroup.LayoutParams r0 = null;
        if (r7 == null) goto L5;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
    L7:
        if ((r8 instanceof FrameLayout.LayoutParams) == true) goto L9;
        r8 = null;
    L9:
        FrameLayout.LayoutParams r9 = (FrameLayout.LayoutParams) r8;
        if (r9 == null) goto L14;
        r9.width = UtilityKotlinExtentionsKt.i(600);
        r9.gravity = 8388613;
        r9.height = s1.s(getActivity());
        View r3 = getView();
        if (r3 == null) goto L14;
        r3.setLayoutParams(r9);
    L14:
        Dialog r10 = getDialog();
        if ((r10 instanceof LiveBottomSheetDialog) == true) goto L17;
        r10 = null;
    L17:
        LiveBottomSheetDialog r11 = (LiveBottomSheetDialog) r10;
        if (r11 == null) goto L20;
        View r13 = r11.getBottomSheetView();
    L21:
        if (r13 == null) goto L23;
        ViewGroup.LayoutParams r4 = r13.getLayoutParams();
    L25:
        if ((r4 instanceof CoordinatorLayout.LayoutParams) == false) goto L28;
        r0 = r4;
    L28:
        CoordinatorLayout.LayoutParams r1 = (CoordinatorLayout.LayoutParams) r0;
        if (r1 == null) goto L32;
        ((ViewGroup.MarginLayoutParams) r1).width = UtilityKotlinExtentionsKt.i(600);
        r1.gravity = 8388613;
        ((ViewGroup.MarginLayoutParams) r1).height = s1.s(getActivity());
        r13.setLayoutParams(r1);
        return;
    L32:
        return;
    L23:
        r4 = null;
        goto L25
    L20:
        r13 = null;
        goto L21
    L5:
        r8 = null;
        goto L7
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L12;
        d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    public final void setVertical(boolean r1) {
        this.e = r1;
    }

    public static boolean S90(BarrageSetting r3, BarrageSetting r4) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r4 != null) goto L8;
        return false;
    L8:
        if (r3.getBarrageArea() == r4.getBarrageArea()) goto L10;
        return false;
    L10:
        if (r3.getFontSize() == r4.getFontSize()) goto L12;
        return false;
    L12:
        if (r3.getAlpha() == r4.getAlpha()) goto L14;
        return false;
    L14:
        if (r3.isGiftOpen() == r4.isGiftOpen()) goto L16;
        return false;
    L16:
        if (r3.isCarnivalBarrageOpen() != r4.isCarnivalBarrageOpen()) goto L23;
        return true;
    L23:
        return false;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        boolean r0 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.y("VSLandscapeBarrageSettingDialog", this, -1);
        super/*com.bytedance.android.livesdk.LiveDialogFragment*/.onViewCreated(r6, r7);
        BarrageSetting r8 = (BarrageSetting) l42.a.d.getValue();
        this.h = r8;
        View r1 = null;
        if (r8 != null) goto L5;
    L11:
        this.h = BarrageSetting.getDefaultVSLiveSetting();
    L12:
        BarrageSetting r9 = this.h;
        if (r9 == null) goto L16;
        BarrageSetting r2 = new BarrageSetting();
        r2.setBarrageArea(r9.getBarrageArea());
        r2.setFontSize(r9.getFontSize());
        r2.setAlpha(r9.getAlpha());
        r2.setGiftOpen(r9.isGiftOpen());
        r2.setNeedRollback(r9.isNeedRollback());
        this.j = r2;
    L16:
        if (((Boolean) l42.a.g.getValue()).booleanValue() == false) goto L24;
        BarrageSetting r10 = this.h;
        if (r10 == null) goto L20;
        BarrageSettingArea r11 = r10.getBarrageArea();
    L21:
        this.i = r11;
        BarrageSetting r13 = this.h;
        if (r13 == null) goto L34;
        r13.setBarrageArea(BarrageSettingArea.CLOSE);
    L34:
        if ((r6 instanceof MatchLandFullShadowLinearLayout) == true) goto L36;
        View r14 = null;
    L37:
        MatchLandFullShadowLinearLayout r15 = (MatchLandFullShadowLinearLayout) r14;
        if (r15 == null) goto L40;
        r15.setEnableShader(false);
    L40:
        r6.setBackgroundResource(2131250067);
        r6.findViewById(2131389274).setOnClickListener(new h(this));
        WidgetManager r16 = WidgetManager.of(this, getView());
        this.l = r16;
        if (r16 == null) goto L43;
        r16.setDataCenter(this.f);
    L43:
        BarrageSetting r17 = this.h;
        if (r17 == null) goto L57;
        WidgetManager r3 = this.l;
        if (r3 == null) goto L48;
        r3.load(2131373136, new BarrageSettingFontSizeWidget(r17, this), false);
    L48:
        WidgetManager r4 = this.l;
        if (r4 == null) goto L51;
        r4.load(2131362540, new BarrageSettingAlphaWidget(r17, this), false);
    L51:
        WidgetManager r5 = this.l;
        if (r5 == null) goto L54;
        r5.load(2131363226, new BarrageSettingAreaWidget(r17, this), false);
    L54:
        WidgetManager r18 = this.l;
        if (r18 == null) goto L57;
        r18.load(2131364271, new BarrageSettingBlockWidget(r17, this), false);
    L57:
        View r19 = getView();
        if (r19 == null) goto L60;
        r1 = r19.findViewById(2131378247);
    L60:
        this.g = r1;
        if (r1 == null) goto L63;
        r1.setOnClickListener(new i(this));
    L63:
        boolean r20 = S90(this.h, BarrageSetting.getDefaultVSLiveSetting());
        View r21 = this.g;
        if (r21 == null) goto L69;
        if (r20 == false) goto L67;
        float r23 = 0.5f;
    L68:
        r21.setAlpha(r23);
        goto L69
    L67:
        r23 = 1.0f;
    L69:
        View r24 = this.g;
        if (r24 == null) goto L72;
        r24.setClickable(!r20);
    L72:
        ((ObservableSubscribeProxy) xs2.b.a().b(q22.b.class).as(AutoDispose.bind(this))).subscribe(new j(this));
        r6.post(new k(this));
        return;
    L36:
        r14 = r6;
        goto L37
    L20:
        r11 = null;
        goto L21
    L24:
        BarrageSetting r25 = this.h;
        if (r25 == null) goto L27;
        BarrageSettingArea r26 = r25.getBarrageArea();
    L29:
        if (r26 != BarrageSettingArea.CLOSE) goto L34;
        BarrageSetting r27 = this.h;
        if (r27 == null) goto L34;
        r27.setBarrageArea(BarrageSettingArea.TOP);
        goto L34
    L27:
        r26 = null;
        goto L29
    L5:
        if (r8.getBarrageArea() == null) goto L11;
        BarrageSetting r28 = this.h;
        if (r28 == null) goto L9;
        BarrageSettingFont r29 = r28.getFontSize();
    L10:
        if (r29 != null) goto L12;
    L9:
        r29 = null;
        goto L10
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566813, r3, false);
    }
}
