package com.obric.aiproactive.ui.settings;

import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.aiproactive.ui.util.AiProactiveUiModeController;
import com.obric.memorydata.plugin.R;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001aP\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0000¨\u0006\u000f"}, d2 = {"setupOuiSettingsPageChrome", "", "Landroidx/appcompat/app/AppCompatActivity;", "root", "Landroid/view/View;", "titleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", Params.CONTENT, "title", "", "maskBlurRadius", "", "cutOff", "contentTopGapDp", "", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class c {
    private static final WindowInsetsCompat a(View r10, AppCompatActivity r11, OFloatingTitleBar r12, int r13, View r14, int r15, int r16, View r17, View r18, WindowInsetsCompat r19) {
        AppCompatActivity r3 = (AppCompatActivity) ZeusTransformUtils.wrapperContextForParams(r11, AppCompatActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r18, "<unused var>");
        Intrinsics.checkNotNullParameter(r19, "insets");
        a(r10, r3, r12, r13, r14, r15, r16, r17);
        return r19;
    }

    private static final void a(View r7, AppCompatActivity r8, OFloatingTitleBar r9, int r10, View r11, int r12, int r13, View r14) {
        AppCompatActivity r15 = (AppCompatActivity) ZeusTransformUtils.wrapperContextForParams(r8, AppCompatActivity.class, "com.obric.memorydata.plugin");
        WindowInsetsCompat r16 = ViewCompat.getRootWindowInsets(r7);
        ViewGroup.LayoutParams r0 = null;
        if (r16 == null) goto L5;
        Insets r17 = r16.getInsets(WindowInsetsCompat.Type.systemBars());
    L6:
        boolean r2 = false;
        if (r17 == null) goto L9;
        int r18 = r17.top;
    L13:
        if (r17 == null) goto L15;
        int r19 = r17.bottom;
    L16:
        View r3 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.title_bar_container, OaidModel.KEY_ID, "title_bar_container"));
        if (r3 == null) goto L27;
        Integer r4 = Integer.valueOf(r3.getHeight());
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == true) goto L25;
        r4 = null;
    L25:
        if (r4 == null) goto L27;
        r10 = r4.intValue();
    L35:
        int r20 = r18 + r10;
        int r110 = r13 + r19;
        r11.setPadding(r11.getPaddingLeft(), r12 + r20, r11.getPaddingRight(), r110);
        if (r14 == null) goto L38;
        r0 = r14.getLayoutParams();
    L38:
        if (r0 != null) goto L40;
        return;
    L40:
        if (r0.height == r20) goto L44;
        r0.height = r20;
        r14.setLayoutParams(r0);
        return;
    L44:
        return;
    L21:
        r5 = false;
    L27:
        Integer r21 = Integer.valueOf(r9.getHeight());
        if (((Number) ZeusTransformUtils.preCheckCast(r21, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L30;
        r2 = true;
    L30:
        if (r2 == true) goto L33;
        r21 = null;
    L33:
        if (r21 == null) goto L35;
        r10 = r21.intValue();
        goto L35
    L15:
        r19 = 0;
        goto L16
    L9:
        int r6 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r15, "com.obric.memorydata.plugin"), "status_bar_height", "dimen", "android", "com.obric.memorydata.plugin");
        if (r6 <= 0) goto L12;
        r18 = ZeusTransformUtils.getResources(r15, "com.obric.memorydata.plugin").getDimensionPixelSize(r6);
        goto L13
    L12:
        r18 = 0;
        goto L13
    L5:
        r17 = null;
        goto L6
    }

    private static final void a(View r3, AppCompatActivity r4, OFloatingTitleBar r5, int r6, View r7, int r8, int r9, View r10, View r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
        a(r3, (AppCompatActivity) ZeusTransformUtils.wrapperContextForParams(r4, AppCompatActivity.class, "com.obric.memorydata.plugin"), r5, r6, r7, r8, r9, r10);
    }

    private static final void a(AppCompatActivity r1, View r2) {
        ((AppCompatActivity) ZeusTransformUtils.wrapperContextForParams(r1, AppCompatActivity.class, "com.obric.memorydata.plugin")).getOnBackPressedDispatcher().onBackPressed();
    }

    public static final void a(AppCompatActivity r16, final View r17, final OFloatingTitleBar r18, final View r19, String r20, float r21, final View r22, int r23) {
        final AppCompatActivity r11 = (AppCompatActivity) ZeusTransformUtils.wrapperContextForParams(r16, AppCompatActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r17, "root");
        Intrinsics.checkNotNullParameter(r18, "titleBar");
        Intrinsics.checkNotNullParameter(r19, Params.CONTENT);
        boolean r2 = false;
        WindowCompat.setDecorFitsSystemWindows(r11.getWindow(), false);
        r11.getWindow().setStatusBarColor(0);
        r11.getWindow().setNavigationBarColor(0);
        r11.getWindow().setNavigationBarContrastEnforced(false);
        AiProactiveUiModeController r1 = AiProactiveUiModeController.f6869a;
        Configuration r3 = ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin").getConfiguration();
        Intrinsics.checkNotNullExpressionValue(r3, "getConfiguration(...)");
        boolean r4 = !r1.b(r3);
        WindowInsetsControllerCompat r5 = new WindowInsetsControllerCompat(r11.getWindow(), r17);
        r5.setAppearanceLightStatusBars(r4);
        r5.setAppearanceLightNavigationBars(r4);
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
    L6:
        r2 = true;
    L7:
        if (r2 == true) goto L9;
        r18.setCenterTitle(r20);
    L9:
        r18.setMaskBlurRadius(r21);
        OFloatingTitleBar.a(r18, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$c$QW4Xb1Yit2BS5vXiYCJjMWim74o(r11), 2, null);
        float r0 = ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin").getDisplayMetrics().density;
        final int r13 = MathKt.roundToInt(56.0f * r0);
        final int r14 = MathKt.roundToInt(r23 * r0);
        final int r15 = r19.getPaddingBottom();
        r18.addOnLayoutChangeListener(new $$Lambda$c$YGR5bjazM6dw2xDhqN46qeJouoQ(r17, r11, r18, r13, r19, r14, r15, r22));
        ViewCompat.setOnApplyWindowInsetsListener(r17, new $$Lambda$c$SzkGPVZHgwnTX6Y8UNfDzYlypi8(r17, r11, r18, r13, r19, r14, r15, r22));
        ViewCompat.requestApplyInsets(r17);
        r17.post(new $$Lambda$c$HZogMt1slx6g_iZcDU7pIR15cY(r17, r11, r18, r13, r19, r14, r15, r22));
        return;
    L5:
        if (StringsKt.isBlank(r6) == false) goto L7;
        goto L6
    }

    public static /* synthetic */ void a(AppCompatActivity r9, View r10, OFloatingTitleBar r11, View r12, String r13, float r14, View r15, int r16, int r17, Object r18) {
        AppCompatActivity r1 = (AppCompatActivity) ZeusTransformUtils.wrapperContextForParams(r9, AppCompatActivity.class, "com.obric.memorydata.plugin");
        if ((r17 & 8) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r17 & 16) == 0) goto L9;
        float r6 = 8.0f;
    L11:
        if ((r17 & 32) == 0) goto L13;
        View r7 = null;
    L15:
        if ((r17 & 64) == 0) goto L17;
        int r8 = 16;
    L18:
        a(r1, r10, r11, r12, r5, r6, r7, r8);
        return;
    L17:
        r8 = r16;
        goto L18
    L13:
        r7 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    /* JADX INFO: renamed from: lambda$HZogMt1slx6g_iZcDU7-pIR15cY, reason: not valid java name */
    public static /* synthetic */ void m349lambda$HZogMt1slx6g_iZcDU7pIR15cY(View r0, AppCompatActivity r1, OFloatingTitleBar r2, int r3, View r4, int r5, int r6, View r7) {
        a(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ void lambda$QW4Xb1Yit2BS5vXiYCJjMWim74o(AppCompatActivity r0, View r1) {
        a(r0, r1);
    }

    public static /* synthetic */ WindowInsetsCompat lambda$SzkGPVZHgwnTX6Y8UNfDzYlypi8(View r0, AppCompatActivity r1, OFloatingTitleBar r2, int r3, View r4, int r5, int r6, View r7, View r8, WindowInsetsCompat r9) {
        return a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void lambda$YGR5bjazM6dw2xDhqN46qeJouoQ(View r0, AppCompatActivity r1, OFloatingTitleBar r2, int r3, View r4, int r5, int r6, View r7, View r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15, int r16) {
        a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    }
}
