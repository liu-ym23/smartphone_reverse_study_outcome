package com.larus.search.impl;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.search.impl.databinding.LarusBaseWebDialogFragmentBinding;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020\u000bH\u0016J\u000e\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%J\n\u0010&\u001a\u0004\u0018\u00010\u0019H\u0004J\b\u0010'\u001a\u00020\u000bH\u0004J\b\u0010(\u001a\u00020\u000bH\u0004J\b\u0010)\u001a\u00020\u000bH\u0004J\b\u0010*\u001a\u00020\u000bH$R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/search/impl/BaseWebDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "value", "Lcom/larus/search/impl/databinding/LarusBaseWebDialogFragmentBinding;", "binding", "getBinding", "()Lcom/larus/search/impl/databinding/LarusBaseWebDialogFragmentBinding;", "configDialogTask", "Lkotlin/Function0;", "", "configViewTask", "onDismissTask", "onCancelTask", "onStartTask", "onStopTask", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "onStop", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "onDestroy", "updateWebDialogConfig", "config", "Lcom/larus/search/impl/WebDialogConfig;", "getWebContainer", "onSuccess", "onLoading", "onError", "onRefresh", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public abstract class BaseWebDialogFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int k = 0;
    public LarusBaseWebDialogFragmentBinding d;
    public Function0<Unit> e;
    public Function0<Unit> f;
    public Function0<Unit> g;
    public Function0<Unit> h;
    public Function0<Unit> i;
    public Function0<Unit> j;

    public abstract void onRefresh();

    public final void onLoading() {
        LarusBaseWebDialogFragmentBinding r0 = this.d;
        boolean r1 = false;
        if (r0 == null) goto L12;
        ConstraintLayout r2 = r0.d;
        if (r2 == null) goto L12;
        if (r2.getVisibility() != 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 != true) goto L12;
        r1 = true;
        goto L12
    L9:
        r3 = false;
    L12:
        if (r1 == false) goto L14;
        return;
    L14:
        LarusBaseWebDialogFragmentBinding r4 = this.d;
        if (r4 == null) goto L18;
        e1.x(r4.d);
        e1.o(r4.c);
        e1.o(r4.f);
        return;
    }

    public BaseWebDialogFragment() {
        this.e = new o();
        this.f = new p();
        this.g = new q();
        this.h = new s();
        this.i = new g();
        this.j = new h();
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.d = null;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        this.i.invoke();
    }

    public final void onStop() {
        super/*androidx.fragment.app.DialogFragment*/.onStop();
        this.j.invoke();
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super/*androidx.fragment.app.DialogFragment*/.onCancel(r2);
        this.h.invoke();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.search.impl.j, kotlin.jvm.functions.Function0<kotlin.Unit>] */
    public void onCreate(Bundle r3) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
        setStyle(0, 2131954330);
        h0 r4 = new h0(true, 509);
        Intrinsics.checkNotNullParameter(r4, "config");
        final e r5 = r4.j;
        this.e = new f(r5, this);
        if (getDialog() == null) goto L5;
        this.e.invoke();
    L5:
        ?? r0 = new j(r5, this);
        this.f = r0;
        if (this.d == null) goto L8;
        r0.invoke();
    L8:
        this.i = new k(r5, this);
        this.j = new l(r5);
        this.g = new m(r5);
        this.h = new n(r5);
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L5
        this.g.invoke();     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        this.e.invoke();
        this.f.invoke();
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ConstraintLayout r11 = r8.inflate(2131561819, r9, false);
        int r12 = 2131366974;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r11, 2131366974);
        if (r2 == null) goto L23;
        r12 = 2131371745;
        ConstraintLayout r3 = ViewBindings.findChildViewById(r11, 2131371745);
        if (r3 == null) goto L23;
        r12 = 2131378978;
        ConstraintLayout r4 = ViewBindings.findChildViewById(r11, 2131378978);
        if (r4 == null) goto L23;
        r12 = 2131383286;
        if (((ProgressBar) ViewBindings.findChildViewById(r11, 2131383286)) == null) goto L23;
        r12 = 2131384462;
        if (((ImageView) ViewBindings.findChildViewById(r11, 2131384462)) == null) goto L23;
        r12 = 2131384463;
        if (((TextView) ViewBindings.findChildViewById(r11, 2131384463)) == null) goto L23;
        r12 = 2131388775;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r11, 2131388775);
        if (r5 == null) goto L23;
        r12 = 2131388777;
        if (ViewBindings.findChildViewById(r11, 2131388777) == null) goto L23;
        r12 = 2131393115;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r11, 2131393115);
        if (r6 == null) goto L23;
        ConstraintLayout r13 = r11;
        this.d = new LarusBaseWebDialogFragmentBinding(r13, r2, r3, r4, r5, r6);
        return r13;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
