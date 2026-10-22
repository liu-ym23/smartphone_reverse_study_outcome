package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public class l extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f2009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f2010b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f2011m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f2012n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2013o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2014p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2015q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f2016r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f2017s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f2018t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final d f2019u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Dialog f2020v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2021w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f2022x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f2023y;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f2024a;

        public a(l r8) {
            this.f2024a = r8;
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SyntheticAccessor"})
        public final void run() {
            l r8 = this.f2024a;
            r8.f2012n.onDismiss(r8.f2020v);
        }
    }

    public class b implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f2025a;

        public b(l r8) {
            this.f2025a = r8;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        @SuppressLint({"SyntheticAccessor"})
        public final void onCancel(DialogInterface r8) {
            l r10 = this.f2025a;
            Dialog r11 = r10.f2020v;
            if (r11 == null) goto L6;
            r10.onCancel(r11);
            return;
        }
    }

    public class c implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f2026a;

        public c(l r8) {
            this.f2026a = r8;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        @SuppressLint({"SyntheticAccessor"})
        public final void onDismiss(DialogInterface r8) {
            l r10 = this.f2026a;
            Dialog r11 = r10.f2020v;
            if (r11 == null) goto L6;
            r10.onDismiss(r11);
            return;
        }
    }

    public class d implements androidx.lifecycle.u<androidx.lifecycle.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f2027a;

        public d(l r8) {
            this.f2027a = r8;
        }

        @Override // androidx.lifecycle.u
        @SuppressLint({"SyntheticAccessor"})
        public final void a(androidx.lifecycle.m r8) {
            if (r8 == null) goto L16;
            l r10 = this.f2027a;
            if (r10.f2016r == false) goto L17;
            View r11 = r10.requireView();
            if (r11.getParent() != null) goto L15;
            if (r10.f2020v != null) goto L11;
            return;
        L11:
            if (FragmentManager.G(3) == false) goto L13;
            Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + r10.f2020v);
        L13:
            r10.f2020v.setContentView(r11);
            return;
        L15:
            throw new IllegalStateException("DialogFragment can not be attached to a container view");
        L17:
            return;
        }
    }

    public class e extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f2028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f2029b;

        public e(l r8, o r10) {
            this.f2029b = r8;
            this.f2028a = r10;
        }

        @Override // androidx.fragment.app.o
        public final View b(int r8) {
            o r10 = this.f2028a;
            if (r10.c() == true) goto L5;
            Dialog r11 = this.f2029b.f2020v;
            if (r11 != null) goto L11;
            return null;
        L11:
            return r11.findViewById(r8);
        L5:
            return r10.b(r8);
        }

        @Override // androidx.fragment.app.o
        public final boolean c() {
            if (this.f2028a.c() == false) goto L5;
        L8:
            return true;
        L5:
            if (this.f2029b.f2023y == true) goto L8;
            return false;
        }
    }

    public l() {
        this.f2010b = new a(this);
        this.f2011m = new b(this);
        this.f2012n = new c(this);
        this.f2013o = 0;
        this.f2014p = 0;
        this.f2015q = true;
        this.f2016r = true;
        this.f2017s = -1;
        this.f2019u = new d(this);
        this.f2023y = false;
    }

    public final void a(boolean r8, boolean r10) {
        if (this.f2022x == false) goto L5;
        return;
    L5:
        this.f2022x = true;
        Dialog r11 = this.f2020v;
        if (r11 == null) goto L13;
        r11.setOnDismissListener(null);
        this.f2020v.dismiss();
        if (r10 == true) goto L13;
        if (Looper.myLooper() != this.f2009a.getLooper()) goto L12;
        onDismiss(this.f2020v);
        goto L13
    L12:
        this.f2009a.post(this.f2010b);
    L13:
        this.f2021w = true;
        if (this.f2017s < 0) goto L20;
        FragmentManager r12 = getParentFragmentManager();
        int r13 = this.f2017s;
        r12.getClass();
        if (r13 < 0) goto L19;
        r12.v(new FragmentManager.l(r12, r13), false);
        this.f2017s = -1;
        return;
    L19:
        throw new IllegalArgumentException(defpackage.a.d("Bad id: ", r13));
    L20:
        FragmentManager r14 = getParentFragmentManager();
        r14.getClass();
        androidx.fragment.app.a r15 = new androidx.fragment.app.a(r14);
        FragmentManager r16 = this.mFragmentManager;
        if (r16 != null) goto L23;
    L27:
        r15.b(new z.a(this, 3));
        if (r8 == false) goto L30;
        r15.d(true);
        return;
    L30:
        r15.d(false);
        return;
    L23:
        if (r16 == r15.f1923q) goto L27;
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + toString() + " is already attached to a FragmentManager.");
    }

    public Dialog b() {
        if (FragmentManager.G(3) == false) goto L6;
        Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
    L6:
        return new Dialog(requireContext(), this.f2014p);
    }

    public final Dialog c() {
        Dialog r8 = this.f2020v;
        if (r8 == null) goto L6;
        return r8;
    L6:
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    @Override // androidx.fragment.app.Fragment
    public final o createFragmentContainer() {
        return new e(this, super.createFragmentContainer());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r8) {
        super.onAttach(r8);
        getViewLifecycleOwnerLiveData().d(this.f2019u);
        this.f2022x = false;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r8) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        this.f2009a = new Handler();
        if (this.mContainerId != 0) goto L5;
        boolean r10 = true;
    L6:
        this.f2016r = r10;
        if (r8 == null) goto L10;
        this.f2013o = r8.getInt("android:style", 0);
        this.f2014p = r8.getInt("android:theme", 0);
        this.f2015q = r8.getBoolean("android:cancelable", true);
        this.f2016r = r8.getBoolean("android:showsDialog", this.f2016r);
        this.f2017s = r8.getInt("android:backStackId", -1);
        return;
    L10:
        return;
    L5:
        r10 = false;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        Dialog r8 = this.f2020v;
        if (r8 == null) goto L9;
        this.f2021w = true;
        r8.setOnDismissListener(null);
        this.f2020v.dismiss();
        if (this.f2022x == true) goto L7;
        onDismiss(this.f2020v);
    L7:
        this.f2020v = null;
        this.f2023y = false;
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        if (this.f2022x == true) goto L5;
        this.f2022x = true;
    L5:
        getViewLifecycleOwnerLiveData().h(this.f2019u);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r8) {
        if (this.f2021w == false) goto L5;
        return;
    L5:
        if (FragmentManager.G(3) == false) goto L7;
        Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
    L7:
        a(true, true);
    }

    @Override // androidx.fragment.app.Fragment
    public final LayoutInflater onGetLayoutInflater(Bundle r8) {
        LayoutInflater r10 = super.onGetLayoutInflater(r8);
        boolean r11 = this.f2016r;
        if (r11 == false) goto L41;
        if (this.f2018t == true) goto L41;
        if (r11 == false) goto L34;
        if (this.f2023y == true) goto L34;
        this.f2018t = true;     // Catch: Throwable -> L30
        Dialog r12 = b();     // Catch: Throwable -> L30
        this.f2020v = r12;     // Catch: Throwable -> L30
        if (this.f2016r == false) goto L28;
        int r13 = this.f2013o;     // Catch: Throwable -> L30
        if (r13 == 1) goto L23;
        if (r13 == 2) goto L23;
        if (r13 != 3) goto L24;
        Window r14 = r12.getWindow();     // Catch: Throwable -> L30
        if (r14 == null) goto L23;
        r14.addFlags(24);     // Catch: Throwable -> L30
    L24:
        Context r15 = getContext();     // Catch: Throwable -> L30
        if ((r15 instanceof Activity) == false) goto L27;
        this.f2020v.setOwnerActivity((Activity) r15);     // Catch: Throwable -> L30
    L27:
        this.f2020v.setCancelable(this.f2015q);     // Catch: Throwable -> L30
        this.f2020v.setOnCancelListener(this.f2011m);     // Catch: Throwable -> L30
        this.f2020v.setOnDismissListener(this.f2012n);     // Catch: Throwable -> L30
        this.f2023y = true;     // Catch: Throwable -> L30
    L29:
        this.f2018t = false;
    L23:
        r12.requestWindowFeature(1);     // Catch: Throwable -> L30
        goto L24
    L28:
        this.f2020v = null;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        this.f2018t = false;
        throw th;
    L34:
        if (FragmentManager.G(2) == false) goto L36;
        Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
    L36:
        Dialog r16 = this.f2020v;
        if (r16 != null) goto L39;
        return r10;
    L39:
        return r10.cloneInContext(r16.getContext());
    L41:
        if (FragmentManager.G(2) == false) goto L47;
        String r17 = "getting layout inflater for DialogFragment " + this;
        if (this.f2016r == true) goto L45;
        StringBuilder r18 = new StringBuilder("mShowsDialog = false: ");
    L46:
        r18.append(r17);
        Log.d("FragmentManager", r18.toString());
        goto L47
    L45:
        r18 = new StringBuilder("mCreatingDialog = true: ");
    L47:
        return r10;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r8) {
        super.onSaveInstanceState(r8);
        Dialog r10 = this.f2020v;
        if (r10 == null) goto L5;
        Bundle r11 = r10.onSaveInstanceState();
        r11.putBoolean("android:dialogShowing", false);
        r8.putBundle("android:savedDialogState", r11);
    L5:
        int r12 = this.f2013o;
        if (r12 == 0) goto L8;
        r8.putInt("android:style", r12);
    L8:
        int r13 = this.f2014p;
        if (r13 == 0) goto L11;
        r8.putInt("android:theme", r13);
    L11:
        boolean r14 = this.f2015q;
        if (r14 == true) goto L14;
        r8.putBoolean("android:cancelable", r14);
    L14:
        boolean r15 = this.f2016r;
        if (r15 == true) goto L17;
        r8.putBoolean("android:showsDialog", r15);
    L17:
        int r16 = this.f2017s;
        if (r16 == (-1)) goto L21;
        r8.putInt("android:backStackId", r16);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog r8 = this.f2020v;
        if (r8 == null) goto L6;
        this.f2021w = false;
        r8.show();
        View r10 = this.f2020v.getWindow().getDecorView();
        he.i.f(r10, "<this>");
        r10.setTag(R.id.view_tree_lifecycle_owner, this);
        r10.setTag(R.id.view_tree_view_model_store_owner, this);
        r10.setTag(R.id.view_tree_saved_state_registry_owner, this);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Dialog r8 = this.f2020v;
        if (r8 == null) goto L6;
        r8.hide();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewStateRestored(Bundle r8) {
        super.onViewStateRestored(r8);
        if (this.f2020v == null) goto L9;
        if (r8 == null) goto L10;
        Bundle r10 = r8.getBundle("android:savedDialogState");
        if (r10 == null) goto L11;
        this.f2020v.onRestoreInstanceState(r10);
        return;
    L11:
        return;
    L10:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void performCreateView(LayoutInflater r8, ViewGroup r10, Bundle r11) {
        super.performCreateView(r8, r10, r11);
        if (this.mView == null) goto L5;
        return;
    L5:
        if (this.f2020v == null) goto L12;
        if (r11 == null) goto L13;
        Bundle r12 = r11.getBundle("android:savedDialogState");
        if (r12 == null) goto L14;
        this.f2020v.onRestoreInstanceState(r12);
        return;
    L14:
        return;
    L13:
        return;
    }
}
