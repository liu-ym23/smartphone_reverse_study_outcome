package com.bytedance.ies.bullet.service.popup.ui;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public abstract class AbsPopupDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0 f6060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0 f6061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f6062c;
    public Function0 d;
    public final boolean e;

    public AbsPopupDialog(Context r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        this.e = true;
    }

    public final void b() {
        Window r5 = getWindow();
        if (r5 == null) goto L19;
        r5.clearFlags(1024);
        r5.setSoftInputMode(16);
        r5.clearFlags(2);
        r5.clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        r5.addFlags(Integer.MIN_VALUE);
        r5.setStatusBarColor(0);
        View r10 = r5.findViewById(R.id.content);
        if (r10 == null) goto L8;
        r10.setForeground(null);
    L8:
        View r11 = r5.getDecorView();
        r11.setPadding(0, 0, 0, 0);
        Activity r12 = getOwnerActivity();
        if (r12 == null) goto L15;
        Window r13 = r12.getWindow();
        if (r13 == null) goto L15;
        View r14 = r13.getDecorView();
        if (r14 == null) goto L15;
        r11.setSystemUiVisibility(r14.getSystemUiVisibility());
    L15:
        Activity r15 = getOwnerActivity();
        if (r15 == null) goto L20;
        r5.setNavigationBarColor(r15.getWindow().getNavigationBarColor());
        return;
    L20:
        return;
    }

    public final void d() {
        super.dismiss();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (this.f6062c == false) goto L5;
        return;
    L5:
        this.f6062c = true;
        Function0 r5 = this.d;
        if (r5 == null) goto L9;
        ((AbsPopupFragment$constructUIBody$4$3) r5).invoke();
        return;
    L9:
        super.dismiss();
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public final void onBackPressed() {
        Function0 r5 = this.f6061b;
        if (r5 == null) goto L6;
        r5.invoke();
        return;
    L6:
        super.onBackPressed();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void setContentView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        supportRequestWindowFeature(1);
        super.setContentView(r5);
        r5.setFitsSystemWindows(false);
        b();
    }

    @Override // android.app.Dialog
    public final void show() {
        Window r5 = getWindow();
        if (r5 == null) goto L27;
        r5.setFlags(8, 8);
    L27:
        super.show();     // Catch: Throwable -> L19
        Activity r10 = getOwnerActivity();     // Catch: Throwable -> L19
        if (r10 == null) goto L21;
        Window r11 = r10.getWindow();     // Catch: Throwable -> L19
        if (r11 == null) goto L21;
        View r12 = r11.getDecorView();     // Catch: Throwable -> L19
        if (r12 == null) goto L21;
        int r13 = r12.getSystemUiVisibility();     // Catch: Throwable -> L19
        if (this.e == true) goto L14;
        r13 = r13 ^ 512;     // Catch: Throwable -> L19
    L14:
        Window r14 = getWindow();     // Catch: Throwable -> L19
        if (r14 == null) goto L21;
        View r15 = r14.getDecorView();     // Catch: Throwable -> L19
        if (r15 == null) goto L21;
        r15.setSystemUiVisibility(r13);     // Catch: Throwable -> L19
    L21:
        Window r16 = getWindow();     // Catch: Throwable -> L19
        if (r16 == null) goto L29;
        r16.clearFlags(8);     // Catch: Throwable -> L19
        return;
    L29:
        return;
    L19:
        th = move-exception;
        boolean r17 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("AbsPopupDialog show error: " + th, LogLevel.d, "XPopup");
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void setContentView(int r5) {
        supportRequestWindowFeature(1);
        super.setContentView(r5);
        b();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void setContentView(View r5, ViewGroup.LayoutParams r10) {
        Intrinsics.checkNotNullParameter(r5, "view");
        supportRequestWindowFeature(1);
        super.setContentView(r5, r10);
        b();
    }
}
