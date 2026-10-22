package com.bytedance.ai.view.popup;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\b\u0010\u0014\u001a\u00020\rH\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0003J$\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0016\u001a\u00020\u0005H\u0003J\"\u0010\u001c\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\b\u0010\u001f\u001a\u00020\rH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ai/view/popup/AppletPopUpDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "theme", "", "<init>", "(Landroid/content/Context;I)V", "schemaParams", "Lcom/bytedance/ai/view/popup/params/AppletPopupSchemaParam;", "supportFollowActivityUiList", "", "setContentView", "", "view", "Landroid/view/View;", "layoutResID", "params", "Landroid/view/ViewGroup$LayoutParams;", "init", "initImmersive", "setStatusBarDarkFont", "uiFlags", "setStatusBarDarkFontAboveR", "contentView", "Landroid/view/ViewGroup;", "window", "Landroid/view/Window;", "setStatusBarColor", "statusBarColor", "navigationColor", "show", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AppletPopUpDialog extends AppCompatDialog {
    public AppletPopupSchemaParam a;

    public AppletPopUpDialog() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void J0() {
        Window r0 = getWindow();
        if (r0 == null) goto L121;
        I0(r0).setPadding(0, 0, 0, 0);
        AppletPopupSchemaParam r10 = this.a;
        if (r10 == null) goto L7;
        int r11 = r10.getWindowBackgroundColor();
    L8:
        r0.setBackgroundDrawable(new ColorDrawable(r11));
        AppletPopupSchemaParam r1 = this.a;
        if (r1 == null) goto L11;
        int r12 = r1.getNavigationBarBgColor();
    L12:
        int r13 = Build.VERSION.SDK_INT;
        if (r13 < 23) goto L119;
        AppletPopupSchemaParam r14 = this.a;
        boolean r15 = true;
        if (r14 == null) goto L17;
        boolean r16 = r14.getPopupFollowActivityUi();
    L18:
        if (r16 == false) goto L34;
        Activity r17 = getOwnerActivity();
        if (r17 == null) goto L27;
        Window r18 = r17.getWindow();
        if (r18 == null) goto L27;
        WindowManager.LayoutParams r19 = r18.getAttributes();
        if (r19 == null) goto L27;
        r0.addFlags(r19.flags);
    L27:
        Activity r20 = getOwnerActivity();
        if (r20 == null) goto L34;
        Window r21 = r20.getWindow();
        if (r21 == null) goto L34;
        View r22 = I0(r21);
        if (r22 == null) goto L34;
        int r23 = r22.getSystemUiVisibility();
    L35:
        r0.setStatusBarColor(0);
        AppletPopupSchemaParam r24 = this.a;
        if (r24 != null) goto L38;
    L40:
        boolean r25 = false;
    L41:
        if (r25 == false) goto L43;
        r0.clearFlags(67108864);
        r23 = r23 | 1024;
        boolean r26 = false;
    L45:
        if (r13 < 30) goto L66;
        View r27 = I0(r0);
        if (r27 == null) goto L49;
        ViewGroup r28 = (ViewGroup) r27.findViewById(R.id.content);
    L50:
        if (r28 == null) goto L52;
        WindowInsetsController r29 = r28.getWindowInsetsController();
    L53:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r110 = AppletRuntimeManager.d;
        if (r110 != null) goto L56;
    L58:
        boolean r111 = false;
    L60:
        if (r111 == false) goto L64;
        r23 = r23 & (-8193);
        if (r29 == null) goto L74;
        r29.setSystemBarsAppearance(8, 8);
    L74:
        com.bytedance.ai.utils.g r30 = com.bytedance.ai.utils.g.a;
        StringBuilder r112 = new StringBuilder("transNavigationBar: ");
        AppletPopupSchemaParam r113 = this.a;
        if (r113 == null) goto L77;
        Boolean r114 = Boolean.valueOf(r113.getTransNavigationBar());
    L78:
        r112.append(r114);
        r30.d("AppletPopupDialog", r112.toString());
        AppletPopupSchemaParam r31 = this.a;
        if (r31 != null) goto L81;
    L83:
        boolean r32 = false;
    L85:
        if (r32 == false) goto L90;
        if (r13 < 29) goto L88;
        r0.setNavigationBarContrastEnforced(false);
    L88:
        r0.clearFlags(134217728);
        r23 = r23 | 512;
        r26 = false;
    L90:
        if (r13 < 26) goto L106;
        AppletPopupSchemaParam r33 = this.a;
        if (r33 == null) goto L94;
        String r34 = r33.getNavigationFontMode();
    L95:
        if (r34 == null) goto L106;
        AppletPopupSchemaParam r35 = this.a;
        if (r35 == null) goto L99;
        String r36 = r35.getNavigationFontMode();
    L101:
        if (Intrinsics.areEqual(r36, "light") == false) goto L103;
        r23 = r23 & (-17);
    L104:
        if (r13 < 29) goto L106;
        r0.setNavigationBarContrastEnforced(false);
        goto L106
    L103:
        r23 = r23 | 16;
        goto L104
    L99:
        r36 = null;
        goto L101
    L94:
        r34 = null;
    L106:
        if (r26 == true) goto L108;
        r0.addFlags(Integer.MIN_VALUE);
    L108:
        r0.setNavigationBarColor(r12);
        View r37 = I0(r0);
        if (r37 == null) goto L116;
        r37.setSystemUiVisibility(r23);
        WindowInsetsControllerCompat r38 = WindowCompat.getInsetsController(r0, I0(r0));
        if (r38 == null) goto L116;
        AppletPopupSchemaParam r39 = this.a;
        if (r39 == null) goto L115;
        r15 = r39.getAppearanceLightNavigationBars();
    L115:
        r38.setAppearanceLightNavigationBars(r15);
    L116:
        View r40 = r0.findViewById(R.id.content);
        if (r40 == null) goto L122;
        r40.setForeground(null);
        return;
    L122:
        return;
    L81:
        if (r31.getTransNavigationBar() != true) goto L83;
        r32 = true;
        goto L85
    L77:
        r114 = null;
        goto L78
    L64:
        if (r29 == null) goto L74;
        r29.setSystemBarsAppearance(0, 8);
        goto L74
    L56:
        if (r110.v(getContext()) == true) goto L58;
        r111 = true;
        goto L60
    L52:
        r29 = null;
        goto L53
    L49:
        r28 = null;
        goto L50
    L66:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r41 = AppletRuntimeManager.d;
        if (r41 != null) goto L69;
    L71:
        boolean r42 = false;
    L72:
        if (r42 == false) goto L74;
        r23 = r23 | 8192;
        goto L74
    L69:
        if (r41.v(getContext()) == true) goto L71;
        r42 = true;
        goto L72
    L43:
        r26 = true;
        goto L45
    L38:
        if (r24.getTransStatusBar() != true) goto L40;
        r25 = true;
    L34:
        r23 = 0;
        goto L35
    L17:
        r16 = true;
        goto L18
    L119:
        r0.setStatusBarColor(0);
        r0.setNavigationBarColor(r12);
        return;
    L11:
        r12 = 0;
        goto L12
    L7:
        r11 = 0;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void show() {
        Window r0 = getWindow();
        if (r0 == null) goto L6;
        r0.setFlags(8, 8);
    L6:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L23;
        DialogLancet.handleBlockedDialogShow(this);
    L10:
        Window r1 = getWindow();
        if (r1 == null) goto L13;
        r1.clearFlags(8);
    L13:
        AppletPopupSchemaParam r10 = this.a;
        if (r10 == null) goto L18;
        boolean r11 = true;
        if (r10.getForceDialogNonCancelable() != true) goto L18;
    L19:
        if (r11 == false) goto L25;
        setCancelable(false);
        return;
    L25:
        return;
    L18:
        r11 = false;
        goto L19
    L23:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22
    L9:
        DialogLancet.beforeDialogShow(this);
        super/*android.app.Dialog*/.show();
        DialogLancet.afterDialogShow(this);
        goto L10
    }

    public AppletPopUpDialog(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, 2131951702);
    }

    public static View I0(Window r10) {
        View r11 = r10.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r11;
    }

    public final void setContentView(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Result.constructor-impl(Boolean.valueOf(supportRequestWindowFeature(1)));     // Catch: Throwable -> L5
    L7:
        super.setContentView(r10);
        J0();
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final void setContentView(int r10) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Result.constructor-impl(Boolean.valueOf(supportRequestWindowFeature(1)));     // Catch: Throwable -> L4
    L6:
        super.setContentView(r10);
        J0();
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public final void setContentView(View r10, ViewGroup.LayoutParams r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Result.constructor-impl(Boolean.valueOf(supportRequestWindowFeature(1)));     // Catch: Throwable -> L5
    L7:
        super.setContentView(r10, r11);
        J0();
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
