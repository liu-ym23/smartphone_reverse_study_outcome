package com.bytedance.ai.view.popup;

import android.R;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.ai.model.p;
import com.bytedance.ai.utils.c;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import t0.b;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/view/popup/AppletPopUpDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AppletPopUpDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppletPopupSchemaParam f2851a;

    public final void b() {
        Window r5 = getWindow();
        if (r5 == null) goto L84;
        boolean r10 = false;
        r5.getDecorView().setPadding(0, 0, 0, 0);
        r5.setBackgroundDrawable(new ColorDrawable(0));
        AppletPopupSchemaParam r11 = this.f2851a;
        if (r11 == null) goto L7;
        int r12 = r11.f2904w;
    L8:
        boolean r13 = true;
        if (r11 == null) goto L11;
        boolean r14 = r11.f2900r;
    L12:
        if (r14 == false) goto L28;
        Activity r15 = getOwnerActivity();
        if (r15 == null) goto L21;
        Window r16 = r15.getWindow();
        if (r16 == null) goto L21;
        WindowManager.LayoutParams r17 = r16.getAttributes();
        if (r17 == null) goto L21;
        r5.addFlags(r17.flags);
    L21:
        Activity r18 = getOwnerActivity();
        if (r18 == null) goto L28;
        Window r19 = r18.getWindow();
        if (r19 == null) goto L28;
        View r20 = r19.getDecorView();
        if (r20 == null) goto L28;
        int r21 = r20.getSystemUiVisibility();
    L29:
        r5.setStatusBarColor(0);
        AppletPopupSchemaParam r22 = this.f2851a;
        if (r22 != null) goto L32;
    L34:
        boolean r23 = false;
    L35:
        if (r23 == false) goto L37;
        r5.clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        r21 = r21 | 1024;
        boolean r24 = false;
    L38:
        View r25 = r5.getDecorView();
        if (r25 == null) goto L41;
        ViewGroup r26 = (ViewGroup) r25.findViewById(R.id.content);
    L42:
        if (r26 == null) goto L44;
        WindowInsetsController r27 = r26.getWindowInsetsController();
    L45:
        b r28 = p.f2294c;
        if (r28 != null) goto L48;
    L52:
        if (r27 == null) goto L54;
        r27.setSystemBarsAppearance(0, 8);
    L54:
        StringBuilder r29 = new StringBuilder("transNavigationBar: ");
        AppletPopupSchemaParam r30 = this.f2851a;
        if (r30 == null) goto L57;
        Boolean r31 = Boolean.valueOf(r30.f2902u);
    L58:
        r29.append(r31);
        String r32 = r29.toString();
        Intrinsics.checkNotNullParameter("AppletPopupDialog", "tag");
        d r110 = c.f2846a;
        if (r110 == null) goto L61;
        r110.d("AppletPopupDialog", r32);
    L61:
        AppletPopupSchemaParam r33 = this.f2851a;
        if (r33 != null) goto L64;
    L66:
        boolean r34 = false;
    L67:
        if (r34 == false) goto L69;
        r5.setNavigationBarContrastEnforced(false);
        r5.clearFlags(134217728);
        r21 = r21 | 512;
    L70:
        if (r10 == true) goto L72;
        r5.addFlags(Integer.MIN_VALUE);
    L72:
        r5.setNavigationBarColor(r12);
        View r35 = r5.getDecorView();
        if (r35 == null) goto L80;
        r35.setSystemUiVisibility(r21);
        WindowInsetsControllerCompat r36 = WindowCompat.getInsetsController(r5, r5.getDecorView());
        if (r36 == null) goto L80;
        AppletPopupSchemaParam r111 = this.f2851a;
        if (r111 == null) goto L79;
        r13 = r111.f2905x;
    L79:
        r36.setAppearanceLightNavigationBars(r13);
    L80:
        View r112 = r5.findViewById(R.id.content);
        if (r112 == null) goto L85;
        r112.setForeground(null);
        return;
    L85:
        return;
    L69:
        r10 = r24;
        goto L70
    L64:
        if (r33.f2902u != true) goto L66;
        r34 = true;
        goto L67
    L57:
        r31 = null;
        goto L58
    L48:
        if (r28.isDarkMode() == true) goto L52;
        r21 = r21 & (-8193);
        if (r27 == null) goto L54;
        r27.setSystemBarsAppearance(8, 8);
        goto L54
    L44:
        r27 = null;
        goto L45
    L41:
        r26 = null;
        goto L42
    L37:
        r24 = true;
        goto L38
    L32:
        if (r22.s != true) goto L34;
        r23 = true;
    L28:
        r21 = 0;
        goto L29
    L11:
        r14 = true;
        goto L12
    L7:
        r12 = 0;
        goto L8
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void setContentView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Result.m124constructorimpl(Boolean.valueOf(supportRequestWindowFeature(1)));     // Catch: Throwable -> L5
    L7:
        super.setContentView(r5);
        b();
        return;
    L5:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // android.app.Dialog
    public final void show() {
        Window r5 = getWindow();
        if (r5 == null) goto L5;
        r5.setFlags(8, 8);
    L5:
        super.show();
        Window r10 = getWindow();
        if (r10 == null) goto L9;
        r10.clearFlags(8);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void setContentView(int r5) {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L4
        Result.m124constructorimpl(Boolean.valueOf(supportRequestWindowFeature(1)));     // Catch: Throwable -> L4
    L6:
        super.setContentView(r5);
        b();
        return;
    L4:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void setContentView(View r5, ViewGroup.LayoutParams r10) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        Result.m124constructorimpl(Boolean.valueOf(supportRequestWindowFeature(1)));     // Catch: Throwable -> L5
    L7:
        super.setContentView(r5, r10);
        b();
        return;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
