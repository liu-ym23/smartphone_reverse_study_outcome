package k2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.api.model.view.AIFragmentBase;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.view.popup.AppletPopup;
import com.bytedance.ai.view.popup.anim.AnimationStyle;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class v implements p {
    public final String a;

    public static final class a {
    }

    static {
    }

    public v(String r10) {
        Intrinsics.checkNotNullParameter(r10, "pageId");
        this.a = r10;
    }

    @Override // k2.p
    public final View createPage(PageInfo r31, Context r32, Function1<? super Integer, Unit> r33, Function1<? super String, Unit> r34) {
        Intrinsics.checkNotNullParameter(r31, "pageInfo");
        if (r31.getPageName() != null) goto L7;
        if (r34 == null) goto L6;
        r34.invoke("pageName is null");
    L6:
        return null;
    L7:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r10 = AppletRuntimeManager.d;
        if (r10 == null) goto L10;
        Activity r11 = r10.currentActivity();
    L12:
        if ((r11 instanceof FragmentActivity) == false) goto L14;
        FragmentActivity r12 = (FragmentActivity) r11;
    L15:
        if (r12 == null) goto L17;
    L20:
        if (r12 == null) goto L167;
        String r13 = this.a;
        String r14 = "AppletPopup#" + r13.hashCode();
        AppletPopup r15 = r12.getSupportFragmentManager().findFragmentByTag(r14);
        String r16 = k2.a.a(r31);
        if ((r15 instanceof AppletPopup) == false) goto L27;
        com.bytedance.ai.utils.g.a.d("WebViewPopupPageV2", "Applet showPopup, oldAppletPopup is AppletPopup");
        AIFragmentBase r17 = r15.n;
        if (r17 == null) goto L26;
        r17.S90();
    L26:
        Function1<? super Integer, Unit> r0 = r33;
    L164:
        View r1 = null;
        if (r0 == null) goto L170;
        r0.invoke(null);
    L170:
        return r1;
    L27:
        com.bytedance.ai.utils.g r18 = com.bytedance.ai.utils.g.a;
        r18.d("WebViewPopupPageV2", "Applet showPopup, oldAppletPopup[" + r15 + "] is not AppletPopup");
        if (r16 != null) goto L30;
    L33:
        boolean r19 = true;
    L34:
        if (r19 == false) goto L36;
        Uri r110 = null;
    L37:
        if (r110 == null) goto L39;
        boolean r111 = r110.getBooleanQueryParameter("showSpeaker", false);
    L40:
        AppletPopup r112 = new AppletPopup();
        if (r110 == null) goto L47;
        String r20 = UriProtector.getQueryParameter(r110, "heightPercent");
        if (r20 == null) goto L47;
        Integer r21 = StringsKt.toIntOrNull(r20);
        if (r21 == null) goto L47;
        int r22 = r21.intValue();
    L48:
        if (r110 == null) goto L50;
        boolean r113 = r110.getBooleanQueryParameter("showMask", true);
    L51:
        if (r110 == null) goto L53;
        boolean r23 = r110.getBooleanQueryParameter("closeByMask", true);
    L54:
        if (r110 == null) goto L56;
        boolean r24 = false;
        boolean r114 = r110.getBooleanQueryParameter("dragByGesture", false);
    L57:
        if (r110 == null) goto L59;
        boolean r25 = r110.getBooleanQueryParameter("dragBack", r24);
    L61:
        if (r110 == null) goto L64;
        String r26 = UriProtector.getQueryParameter(r110, "gravity");
        if (r26 == null) goto L64;
    L65:
        if (r110 == null) goto L67;
        boolean r27 = false;
        boolean r28 = r110.getBooleanQueryParameter("disableBackPress", false);
    L68:
        if (r110 == null) goto L70;
        boolean r29 = r110.getBooleanQueryParameter("transNavigationBar", r27);
    L72:
        if (r110 == null) goto L75;
        String r30 = UriProtector.getQueryParameter(r110, "navigationBarColor");
        if (r30 == null) goto L75;
    L76:
        if (r110 == null) goto L78;
        boolean r115 = r110.getBooleanQueryParameter("closeByGesture", true);
    L79:
        if (r110 == null) goto L85;
        String r35 = UriProtector.getQueryParameter(r110, "radius");
        if (r35 == null) goto L85;
        Integer r36 = StringsKt.toIntOrNull(r35);
        if (r36 == null) goto L85;
        int r37 = r36.intValue();
    L86:
        boolean r210 = r23;
        boolean r211 = r25;
        int r38 = com.bytedance.ai.utils.o.b(r12, r37);
        if (r110 == null) goto L89;
        String r39 = UriProtector.getQueryParameter(r110, "animationInStyle");
    L90:
        if (r110 == null) goto L92;
        String r40 = UriProtector.getQueryParameter(r110, "animationOutStyle");
    L94:
        if (r110 == null) goto L97;
        String r41 = UriProtector.getQueryParameter(r110, "floatingPageId");
        if (r41 == null) goto L97;
    L98:
        String r212 = r30;
        if (r110 == null) goto L101;
        String r116 = UriProtector.getQueryParameter(r110, "bounceWithKeyboard");
    L102:
        boolean r42 = Intrinsics.areEqual(r116, "1");
        g2.b r117 = AppletRuntimeManager.d;
        if (r117 == null) goto L105;
        int r118 = r117.getStatusBarHeight(r12);
    L106:
        com.bytedance.ai.utils.l.a.getClass();
        int r213 = com.bytedance.ai.utils.l.a(r12);
        int r214 = com.bytedance.ai.utils.l.b(r12.getWindow());
        if (r22 == 100) goto L109;
        r214 = r214 - r118;
    L109:
        if (r29 == true) goto L111;
        r214 = r214 - r213;
    L111:
        boolean r215 = r28;
        int r119 = r214;
        if (1 > r22) goto L115;
        if (r22 >= 100) goto L115;
        boolean r43 = true;
    L116:
        if (r43 == false) goto L118;
        int r44 = (r22 * r119) / 100;
    L121:
        if (r114 == true) goto L124;
        r119 = -1;
    L124:
        r18.d("WebViewPopupPageV2", "popupHeight: " + r44);
        if (r111 == false) goto L127;
        String r45 = "bottom";
    L128:
        g2.b r46 = AppletRuntimeManager.d;
        if (r46 == null) goto L131;
        int r47 = r46.j(r12);
    L132:
        AppletPopupSchemaParam r48 = new AppletPopupSchemaParam();
        r48.setDragByGesture(r114);
        r48.setDragBack(r211);
        r48.setHeight(r44);
        r48.setDragHeight(r119);
        r48.setEnablePullDownClose(r115);
        r48.setTransStatusBar(true);
        r48.setTransNavigationBar(r29);
        r48.setShowMask(r113);
        if (r39 != null) goto L135;
    L138:
        boolean r49 = true;
    L139:
        if (r49 == false) goto L141;
        r39 = AnimationStyle.SLIDE.getValue();
    L141:
        r48.setTransitionAnimationIn(r39);
        if (r40 != null) goto L144;
    L147:
        boolean r50 = true;
    L148:
        if (r50 == false) goto L150;
        r40 = AnimationStyle.SLIDE.getValue();
    L150:
        r48.setTransitionAnimationOut(r40);
        r48.setFloatingPageName(r41);
        r48.setDisableOutsideClickClose(!r210);
        r48.setRadius(r38);
        r48.setGravity(r45);
        r48.setDisableBackPress(r215);
        r48.setPopupFollowActivityUi(false);
        if (r29 == false) goto L153;
        int r51 = 0;
    L159:
        r48.setNavigationBarBgColor(r51);
        r48.setWindowBackgroundColor(0);
        r48.setBounceWithKeyboard(r42);
        r112.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID, r13), TuplesKt.to(BdpAwemeConstant.KEY_APP_NAME, r31.getPageName()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, r16), TuplesKt.to("pageId", r13), TuplesKt.to("showFloatingSpeaker", Boolean.valueOf(r111)), TuplesKt.to("fullScreen", Boolean.FALSE), TuplesKt.to("bounceWithKeyboard", Boolean.valueOf(r48.getBounceWithKeyboard())), TuplesKt.to(BdpAwemeConstant.KEY_APP_ID, r31.getPackageName())}));
        w r52 = new w(r48);
        Intrinsics.checkNotNullParameter(r52, "listener");
        r112.Q = r52;
        com.bytedance.ai.utils.g.a.d("WebViewPopupPageV2", "call appletPopup[" + r15 + "] show, tag=" + r14);
        FragmentManager r53 = r12.getSupportFragmentManager();
        LandscapeRestrictionOperation r54 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r112, r14, r54);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r53, r112, r54) == false) goto L174;
    L161:
        r0 = r33;
        goto L164
    L174:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L171
    L163:
        r112.show(r53, r14);
        goto L161
    L153:
        if (com.bytedance.ai.utils.f.g(r212) == true) goto L172;
    L157:
        r51 = r47;
        goto L159
    L172:
        r51 = Color.parseColor(r212);     // Catch: IllegalArgumentException -> L156
    L144:
        if (r40.length() == 0) goto L147;
        r50 = false;
        goto L148
    L135:
        if (r39.length() == 0) goto L138;
        r49 = false;
        goto L139
    L131:
        r47 = 0;
        goto L132
    L127:
        r45 = r26;
        goto L128
    L118:
        if (r22 != 100) goto L120;
        r44 = r119;
        goto L121
    L120:
        r44 = (int) (r119 * 0.9f);
    L115:
        r43 = false;
        goto L116
    L105:
        r118 = 0;
        goto L106
    L101:
        r116 = null;
    L97:
        r41 = "";
        goto L98
    L92:
        r40 = null;
        goto L94
    L89:
        r39 = null;
    L85:
        r37 = 20;
        goto L86
    L78:
        r115 = true;
    L75:
        r30 = "";
        goto L76
    L70:
        r29 = false;
        goto L72
    L67:
        r27 = false;
        r28 = false;
    L64:
        r26 = "bottom";
        goto L65
    L59:
        r25 = false;
        goto L61
    L56:
        r24 = false;
        r114 = false;
        goto L57
    L53:
        r23 = true;
        goto L54
    L50:
        r113 = true;
    L47:
        r22 = 90;
        goto L48
    L39:
        r111 = false;
        goto L40
    L36:
        r110 = UriProtector.parse(r16);
        goto L37
    L30:
        if (r16.length() == 0) goto L33;
        r19 = false;
        goto L34
    L167:
        r1 = null;
        if (r34 == null) goto L170;
        r34.invoke("currentActivity is null");
        goto L170
    L17:
        if ((r32 instanceof FragmentActivity) == false) goto L19;
        r12 = (FragmentActivity) r32;
        goto L20
    L19:
        r12 = null;
        goto L20
    L14:
        r12 = null;
        goto L15
    L10:
        r11 = null;
        goto L12
    }
}
