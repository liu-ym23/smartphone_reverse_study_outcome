package com.bytedance.android.anniex.scene.listener;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.anniex.scene.core.SceneManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AppPageStackMonitor implements Application.ActivityLifecycleCallbacks {
    public static AppPageStackMonitor b;
    public boolean a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/anniex/scene/listener/AppPageStackMonitor$FragmentStackCallback;", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public final class FragmentStackCallback extends FragmentManager.FragmentLifecycleCallbacks {
        public final void onFragmentDestroyed(FragmentManager r10, Fragment r11) {
            Intrinsics.checkNotNullParameter(r10, "fm");
            Intrinsics.checkNotNullParameter(r11, "f");
        }

        public FragmentStackCallback() {
        }

        public final void onFragmentDetached(FragmentManager r10, Fragment r11) {
            Intrinsics.checkNotNullParameter(r10, "fm");
            Intrinsics.checkNotNullParameter(r11, "f");
            super.onFragmentDetached(r10, r11);
        }

        public final void onFragmentPaused(FragmentManager r10, Fragment r11) {
            Intrinsics.checkNotNullParameter(r10, "fm");
            Intrinsics.checkNotNullParameter(r11, "f");
            super.onFragmentPaused(r10, r11);
        }

        public final void onFragmentResumed(FragmentManager r10, Fragment r11) {
            Intrinsics.checkNotNullParameter(r10, "fm");
            Intrinsics.checkNotNullParameter(r11, "f");
            super.onFragmentResumed(r10, r11);
            String r12 = r11.getClass().getSimpleName();
            SceneManager r13 = SceneManager.n;
            SceneManager.a.a().h(r12);
        }

        public final void onFragmentStopped(FragmentManager r10, Fragment r11) {
            Intrinsics.checkNotNullParameter(r10, "fm");
            Intrinsics.checkNotNullParameter(r11, "f");
            super.onFragmentStopped(r10, r11);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r1, Bundle r10) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    public AppPageStackMonitor() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        String r0 = r10.getClass().getSimpleName();
        if ((r10 instanceof FragmentActivity) == false) goto L5;
        ((FragmentActivity) r10).getSupportFragmentManager().registerFragmentLifecycleCallbacks(new FragmentStackCallback(), true);
    L5:
        SceneManager r11 = SceneManager.n;
        SceneManager.a.a().h(r0);
    }
}
