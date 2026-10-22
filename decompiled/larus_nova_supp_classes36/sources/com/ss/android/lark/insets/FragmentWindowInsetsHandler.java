package com.ss.android.lark.insets;

import android.view.View;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0002\u0012\u0013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/insets/FragmentWindowInsetsHandler;", "Lcom/ss/android/lark/insets/BaseWindowInsetsHandler;", "Landroidx/lifecycle/LifecycleOwner;", "fragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V", "resetSystemLightSystemBarsIfNeed", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "consumeOP", "op", "Lcom/ss/android/lark/insets/WindowInsetsHandlerOP;", "obtainInsetsControllerInner", "Landroidx/core/view/WindowInsetsControllerCompat;", "InsetsHandlerHolder", "Companion", "insets_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FragmentWindowInsetsHandler extends c implements LifecycleOwner {
    public static final Map<Integer, j> p = null;
    public final Fragment o;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/insets/FragmentWindowInsetsHandler$InsetsHandlerHolder;", "Landroidx/lifecycle/ViewModel;", "insetsHandler", "Lcom/ss/android/lark/insets/FragmentWindowInsetsHandler;", "<init>", "(Lcom/ss/android/lark/insets/FragmentWindowInsetsHandler;)V", "getInsetsHandler", "()Lcom/ss/android/lark/insets/FragmentWindowInsetsHandler;", "insets_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class InsetsHandlerHolder extends ViewModel {
        private final FragmentWindowInsetsHandler insetsHandler;

        public final FragmentWindowInsetsHandler getInsetsHandler() {
            return this.insetsHandler;
        }

        public InsetsHandlerHolder(FragmentWindowInsetsHandler r2) {
            Intrinsics.checkNotNullParameter(r2, "insetsHandler");
            this.insetsHandler = r2;
        }
    }

    public static final class a {
    }

    static {
        p = new LinkedHashMap();
    }

    public final Lifecycle getLifecycle() {
        return this.o.getLifecycle();
    }

    @Override // com.ss.android.lark.insets.c
    public final WindowInsetsControllerCompat u() {
        FragmentActivity r0 = this.o.getActivity();
        if (r0 != null) goto L5;
        return null;
    L5:
        View r2 = this.o.getView();
        if (r2 != null) goto L9;
        return null;
    L9:
        return WindowCompat.getInsetsController(r0.getWindow(), r2);
    }

    public FragmentWindowInsetsHandler(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        this.o = r3;
        Observer<LifecycleOwner> r0 = new FragmentWindowInsetsHandler$observer$1(this);
        r3.getViewLifecycleOwnerLiveData().observe(this, r0);
        WindowInsetsControllerCompat r4 = u();
        boolean r1 = true;
        if (r4 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        p(r5);
        WindowInsetsControllerCompat r6 = u();
        if (r6 != null) goto L11;
    L13:
        r1 = false;
    L14:
        v(r1);
        return;
    L11:
        if (r6.isAppearanceLightStatusBars() != true) goto L13;
    L5:
        if (r4.isAppearanceLightNavigationBars() != true) goto L7;
        r5 = true;
        goto L8
    }
}
