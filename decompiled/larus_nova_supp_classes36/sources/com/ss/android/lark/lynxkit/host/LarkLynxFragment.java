package com.ss.android.lark.lynxkit.host;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tqb.c;
import tqb.d;
import tqb.e;
import tqb.f;
import tqb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\t\u001a\u0004\u0018\u00010\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0016J \u0010\"\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u0010&\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010'\u001a\u00020\u0012H\u0002J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/ss/android/lark/lynxkit/host/LarkLynxFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/lark/lynxkit/host/LarkLynxHostController;", "<init>", "()V", "hostId", "", "entry", "Lcom/ss/android/lark/lynxkit/host/LarkLynxHostEntry;", "container", "Lcom/ss/android/lark/lynxkit/container/ILarkLynxContainer;", "rootView", "Landroid/widget/FrameLayout;", "loadingView", "Landroid/view/View;", "closeNotified", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onPause", "onDestroyView", "onDestroy", HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, "source", "Lcom/ss/android/lark/lynxkit/host/LarkLynxCloseSource;", "attachContainer", "lynxContainer", "params", "Lcom/ss/android/lark/lynxkit/host/LarkLynxHostParams;", "showLoading", "hideLoading", "notifyClose", "shouldRenderOnCreate", "hostEntry", "Companion", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LarkLynxFragment extends Fragment implements c {
    public static final /* synthetic */ int j = 0;
    public String d;
    public d e;
    public ILarkLynxContainer f;
    public FrameLayout g;
    public View h;
    public boolean i;

    public static final class a {
    }

    public static final class b implements e {
        public final /* synthetic */ LarkLynxFragment a;
        public final /* synthetic */ FrameLayout b;
        public final /* synthetic */ d c;

        @Override // tqb.e
        public final void a() {
            LarkLynxFragment r0 = this.a;
            View r1 = r0.h;
            if (r1 == null) goto L10;
            ViewParent r3 = r1.getParent();
            if ((r3 instanceof ViewGroup) == false) goto L7;
            ViewGroup r4 = (ViewGroup) r3;
        L8:
            if (r4 == null) goto L10;
            r4.removeView(r1);
            goto L10
        L7:
            r4 = null;
        L10:
            r0.h = null;
        }

        @Override // tqb.e
        public final void onLoadStart() {
            LarkLynxFragment r0 = this.a;
            FrameLayout r1 = this.b;
            LarkLynxHostParams r2 = this.c.a;
            int r3 = LarkLynxFragment.j;
            r0.T90(r1, r2);
        }

        public b(LarkLynxFragment r1, FrameLayout r2, d r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public final void onDestroy() {
        d r0 = this.e;
        if (r0 == null) goto L7;
        g r1 = r0.d;
        if (r1 == null) goto L7;
        r1.b(this);
    L7:
        super.onDestroy();
    }

    public final void onDestroyView() {
        ILarkLynxContainer r0 = this.f;
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L7;
        boolean r2 = true;
        if (r1.isChangingConfigurations() != true) goto L7;
    L8:
        if (r2 == false) goto L10;
    L12:
        if (r0 == null) goto L26;
        d r3 = this.e;
        if (r3 == null) goto L18;
        g r4 = r3.d;
        if (r4 == null) goto L18;
        r4.a(r0);
    L18:
        d r5 = this.e;
        if (r5 == null) goto L25;
        LarkLynxHostOptions r6 = r5.b;
        if (r6 == null) goto L25;
        LarkLynxHostLifecycleCallback r7 = r6.getLifecycleCallback();
        if (r7 == null) goto L25;
        r7.onDestroy(r0);
    L25:
        r0.destroy();
    L26:
        this.f = null;
        this.g = null;
        this.h = null;
        if (r2 == true) goto L33;
        ConcurrentHashMap<String, d> r8 = f.a;
        f.c(this.d);
        d r9 = this.e;
        if (r9 == null) goto L33;
        g r10 = r9.d;
        if (r10 == null) goto L33;
        r10.d();
    L33:
        super.onDestroyView();
        return;
    L10:
        if (this.i == true) goto L12;
        S90(LarkLynxCloseSource.PROGRAMMATIC);
    L7:
        r2 = false;
        goto L8
    }

    public final void onPause() {
        ILarkLynxContainer r0 = this.f;
        if (r0 == null) goto L11;
        r0.hide();
        d r1 = this.e;
        if (r1 == null) goto L11;
        LarkLynxHostOptions r2 = r1.b;
        if (r2 == null) goto L11;
        LarkLynxHostLifecycleCallback r3 = r2.getLifecycleCallback();
        if (r3 == null) goto L11;
        r3.onHide(r0);
    L11:
        super.onPause();
    }

    public final void onResume() {
        super.onResume();
        ILarkLynxContainer r0 = this.f;
        if (r0 == null) goto L12;
        r0.show();
        d r1 = this.e;
        if (r1 == null) goto L13;
        LarkLynxHostOptions r2 = r1.b;
        if (r2 == null) goto L14;
        LarkLynxHostLifecycleCallback r3 = r2.getLifecycleCallback();
        if (r3 == null) goto L15;
        r3.onShow(r0);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public LarkLynxFragment() {
    }

    @Override // tqb.c
    public final void K40(LarkLynxCloseSource r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        S90(r2);
        if (isAdded() == false) goto L6;
        getParentFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        return;
    }

    public final void S90(LarkLynxCloseSource r4) {
        if (this.i == true) goto L19;
        FragmentActivity r0 = getActivity();
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == true) goto L23;
        this.i = true;
        d r2 = this.e;
        if (r2 == null) goto L20;
        LarkLynxHostOptions r3 = r2.b;
        if (r3 == null) goto L21;
        LarkLynxHostCloseCallback r5 = r3.getCloseCallback();
        if (r5 == null) goto L22;
        r5.onClose(r4);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L23:
        return;
    L7:
        if (r0.isChangingConfigurations() != true) goto L9;
        r1 = true;
        goto L9
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        String r4 = r3.getString("extra_lynx_host_id");
    L6:
        this.d = r4;
        ConcurrentHashMap<String, d> r0 = f.a;
        d r5 = f.a(r4);
        this.e = r5;
        if (r5 == null) goto L12;
        g r6 = r5.d;
        if (r6 == null) goto L13;
        r6.c(this);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void T90(FrameLayout r4, LarkLynxHostParams r5) {
        if (r5.getShowLoading() == true) goto L5;
        return;
    L5:
        if (this.h != null) goto L10;
        ProgressBar r6 = new ProgressBar(requireContext());
        r4.addView(r6, new FrameLayout.LayoutParams(-2, -2, 17));
        this.h = r6;
        return;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        d r8 = this.e;
        if (r8 != null) goto L5;
        return;
    L5:
        FrameLayout r9 = this.g;
        if (r9 != null) goto L8;
        return;
    L8:
        b r0 = new b(this, r9, r8);
        int r1 = tqb.b.a;     // Catch: Throwable -> L32
        ILarkLynxContainer r2 = tqb.b.a(requireContext(), r8.a, r8.b, r0);     // Catch: Throwable -> L32
        this.f = r2;     // Catch: Throwable -> L32
        g r3 = r8.d;     // Catch: Throwable -> L32
        if (r3 == null) goto L12;
        r3.e(r2);     // Catch: Throwable -> L32
    L12:
        LarkLynxHostParams r4 = r8.a;     // Catch: Throwable -> L32
        View r5 = r2.getLynxView();     // Catch: Throwable -> L32
        ViewParent r10 = r5.getParent();     // Catch: Throwable -> L32
        if ((r10 instanceof ViewGroup) == false) goto L15;
        ViewGroup r11 = (ViewGroup) r10;     // Catch: Throwable -> L32
    L16:
        if (r11 == null) goto L18;
        r11.removeView(r5);     // Catch: Throwable -> L32
    L18:
        ViewGroup.LayoutParams r12 = r4.getLayoutParams();     // Catch: Throwable -> L32
        if (r12 != null) goto L21;
        r12 = new FrameLayout.LayoutParams(-1, -1);     // Catch: Throwable -> L32
    L21:
        r9.addView(r5, r12);     // Catch: Throwable -> L32
        g r13 = r8.d;     // Catch: Throwable -> L32
        if (r13 == null) goto L24;
        boolean r14 = r13.f();     // Catch: Throwable -> L32
    L26:
        if (r8.a.getShowLoading() == false) goto L29;
        if (r14 == false) goto L29;
        T90(r9, r8.a);     // Catch: Throwable -> L32
    L29:
        if (r14 == false) goto L37;
        tqb.b.c(r2, r8.a);     // Catch: Throwable -> L32
        return;
    L37:
        return;
    L24:
        r14 = r8.c;     // Catch: Throwable -> L32
        goto L26
    L15:
        r11 = null;
    L32:
        th = move-exception;
        Log.e("LynxFragment", "create lynx fragment host failed", th);
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        d r4 = this.e;
        if (r4 != null) goto L6;
        Log.e("LynxFragment", "onCreateView failed, host entry not found");
        return new FrameLayout(requireContext());
    L6:
        FrameLayout r5 = new FrameLayout(requireContext());
        Integer r6 = r4.a.getContainerBackgroundColor();
        if (r6 == null) goto L9;
        int r7 = r6.intValue();
    L10:
        r5.setBackgroundColor(r7);
        this.g = r5;
        return r5;
    L9:
        r7 = 0;
        goto L10
    }
}
