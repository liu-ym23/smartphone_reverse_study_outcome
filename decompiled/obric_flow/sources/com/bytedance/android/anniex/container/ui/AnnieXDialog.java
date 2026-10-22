package com.bytedance.android.anniex.container.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.anniex.container.m;
import com.bytedance.android.anniex.container.popup.SheetBaseDialog;
import com.obric.launcher.widget.R$layout;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/content/DialogInterface$OnShowListener;", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@SourceDebugExtension({"SMAP\nAnnieXDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnieXDialog.kt\ncom/bytedance/android/anniex/container/ui/AnnieXDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,157:1\n1#2:158\n*E\n"})
public final class AnnieXDialog extends DialogFragment implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f3180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f3181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f3182c;

    public AnnieXDialog() {
        this.f3182c = new a(this, 0);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        if (getShowsDialog() == false) goto L8;
        Dialog r10 = getDialog();
        if (r10 == null) goto L9;
        r10.setOnShowListener(this);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super.onAttach(r5);
        m r10 = this.f3180a;
        if (r10 == null) goto L6;
        a r11 = this.f3182c;
        Intrinsics.checkNotNullParameter(r11, "popupComponent");
        r10.setUiComponent(r11);
        Intrinsics.checkNotNullParameter(this, "dialogFragment");
        r10.f3159b = this;
        return;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r5) {
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        super.onConfigurationChanged(r5);
        m r10 = this.f3180a;
        if (r10 == null) goto L6;
        r10.onConfigurationChanged(r5);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        m r10 = this.f3180a;
        if (r10 == null) goto L6;
        r10.onCreate(r5);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r10) {
        m r5 = this.f3180a;
        if (r5 == null) goto L27;
        Context r11 = r5.getContext();
        FragmentActivity r12 = r5.f3158a;
        boolean r13 = kk.a.h(r12);
        boolean r14 = kk.a.h(r12);
        if (RangesKt.coerceAtMost(0 / 100.0f, 1.0f) < 1.0f) goto L8;
        if (r14 == true) goto L8;
        r14 = true;
    L8:
        Window r15 = r12.getWindow();
        if (r15 == null) goto L13;
        View r16 = r15.getDecorView();
        if (r16 == null) goto L13;
        r16.getWidth();
    L13:
        SheetBaseDialog r17 = new SheetBaseDialog(r11, r13, r14);
        Window r18 = r17.getWindow();
        if (r18 == null) goto L16;
        r18.setBackgroundDrawable(new ColorDrawable(0));
        r18.addFlags(256);
    L16:
        r5.f3160c = r17;
        AnnieXDialog r19 = r5.f3159b;
        if (r19 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
        r19 = null;
    L19:
        r19.setCancelable(true);
        SheetBaseDialog r20 = r5.f3160c;
        if (r20 == null) goto L22;
        r20.setCanceledOnTouchOutside(true);
    L22:
        SheetBaseDialog r21 = r5.f3160c;
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type android.app.Dialog");
        if (r21 == null) goto L27;
        return r21;
    L27:
        return super.onCreateDialog(r10);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r5, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        super.onCreateView(r5, r10, r11);
        View r12 = r5.inflate(R$layout.annie_x_dialog, r10, false);
        this.f3181b = r12;
        m r13 = this.f3180a;
        if (r13 == null) goto L6;
        r13.a(r12);
    L6:
        return this.f3181b;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        m r5 = this.f3180a;
        if (r5 == null) goto L6;
        r5.release();
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r5) {
        Intrinsics.checkNotNullParameter(r5, "dialog");
        super.onDismiss(r5);
        m r10 = this.f3180a;
        if (r10 == null) goto L10;
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXPopupContainer", "===onDismiss: " + r10.getUrl(), null, 12);
        Window r12 = r10.f3158a.getWindow();
        if (r12 == null) goto L11;
        int r13 = r12.getStatusBarColor();
        int r14 = r10.d;
        if (r13 == r14) goto L12;
        r12.setStatusBarColor(r14);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        m r5 = this.f3180a;
        if (r5 == null) goto L6;
        r5.a();
        return;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r5) {
        m r10 = this.f3180a;
        if (r10 == null) goto L12;
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXPopupContainer", "===onShow: " + r10.getUrl(), null, 12);
        if (kk.a.h(r10.f3158a) == false) goto L13;
        SheetBaseDialog r12 = r10.f3160c;
        if (r12 == null) goto L14;
        Window r13 = r12.getWindow();
        if (r13 == null) goto L15;
        r13.clearFlags(8);
        r13.getDecorView().setSystemUiVisibility(5894);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        m r5 = this.f3180a;
        if (r5 == null) goto L6;
        r5.enterBackground();
        r5.onVisibleChange(false, Boolean.TRUE);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r5, Bundle r10) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r10);
        m r11 = this.f3180a;
        if (r11 == null) goto L5;
        r11.b(r5);
    L5:
        Bundle r12 = getArguments();
        if (r12 != null) goto L8;
        return;
    L8:
        if (r12.getBoolean("bundle_annie_x_flow", false) == false) goto L16;
        String r13 = r12.getString("__x_inner_schema");
        if (r13 == null) goto L17;
        m r14 = this.f3180a;
        if (r14 == null) goto L18;
        r14.loadSchema(r13, null);
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r5) {
        super.setUserVisibleHint(r5);
        m r10 = this.f3180a;
        if (r10 == null) goto L6;
        r10.a(r5);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void show(FragmentManager r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "manager");
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXDialog", "===show()===", null, 12);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
        if (r5.isDestroyed() == true) goto L16;
        r5.beginTransaction().remove(this).commit();     // Catch: Throwable -> L8
        super.show(r5, r10);     // Catch: Throwable -> L8
        Object r12 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r13 = Result.m127exceptionOrNullimpl(r12);
        if (r13 == null) goto L17;
        int r14 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("AnnieXDialog", "===show error:" + r13.getMessage() + "===", null, 12);
        return;
    L17:
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
