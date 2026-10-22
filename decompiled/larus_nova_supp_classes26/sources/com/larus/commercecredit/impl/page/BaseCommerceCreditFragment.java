package com.larus.commercecredit.impl.page;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H$¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0014\u0018\u00010\u0013H$J\b\u0010\u0015\u001a\u00020\u0016H$J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\b\u0010\u0018\u001a\u00020\u0016H\u0004J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0016H\u0004J\b\u0010#\u001a\u00020!H\u0014J\b\u0010$\u001a\u00020\u0016H\u0014J\b\u0010%\u001a\u00020\u0016H\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006&"}, d2 = {"Lcom/larus/commercecredit/impl/page/BaseCommerceCreditFragment;", "T", "Landroidx/viewbinding/ViewBinding;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroidx/viewbinding/ViewBinding;", "getAssociatedActivityClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "initViews", "", "initEvents", "finishActivity", "onCreateView", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupLandscape", "getTheme", "", "updateBottomSheetHeight", "getAvailableBottomSheetHeight", "postUpdateBottomSheetHeight", "onDestroyView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseCommerceCreditFragment<T extends ViewBinding> extends BottomSheetDialogFragment {
    public static final /* synthetic */ int e = 0;
    public T d;

    public abstract T S90(LayoutInflater r1, ViewGroup r2);

    public abstract Class<? extends Activity> T90();

    public void W90() {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public abstract void initViews();

    public int U90() {
        Dialog r0 = getDialog();
        if (r0 == null) goto L14;
        View r1 = r0.findViewById(2131368870);
        if (r1 == null) goto L14;
        T r2 = this.d;
        if (r2 == null) goto L14;
        View r3 = r2.getRoot();
        if (r3 == null) goto L14;
        r3.measure(View.MeasureSpec.makeMeasureSpec(r1.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return r3.getMeasuredHeight();
    L14:
        return 0;
    }

    public void V90() {
        Dialog r0 = getDialog();
        if (r0 == null) goto L6;
        r0.setOnDismissListener(new c(this));
        return;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.d = null;
    }

    public final void y() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L12;
        Class<? extends Activity> r1 = T90();
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.isInstance(r0) == true) goto L9;
        return;
    L9:
        if (r0.isFinishing() == true) goto L15;
        r0.finish();
        return;
    L15:
        return;
    }

    public BaseCommerceCreditFragment() {
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        BottomSheetDialog r4 = getDialog();
        final View r0 = null;
        if ((r4 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r5 = r4;
    L6:
        if (r5 == null) goto L8;
        r0 = r5.findViewById(2131368870);
    L8:
        Dialog r6 = getDialog();
        if (r6 == null) goto L11;
        r6.setOnShowListener(new a(r0));
    L11:
        initViews();
        V90();
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        T r4 = (T) S90(r1, r2);
        this.d = r4;
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.getRoot();
    }
}
