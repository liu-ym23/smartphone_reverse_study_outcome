package com.ss.android.lark.floating;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.log.Log;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import wfb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements LifecycleEventObserver {
    public final /* synthetic */ PermissionFragment a;

    public a(PermissionFragment r1) {
        this.a = r1;
    }

    public final void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "event");
        if (r3 != Lifecycle.Event.ON_RESUME) goto L12;
        boolean r4 = b.a(this.a.requireActivity());
        Log.i("PermissionFragment onActivityResult: " + r4);
        g r0 = PermissionFragment.f;     // Catch: Throwable -> L9
        if (r0 == null) goto L8;
        r0.a(r4);     // Catch: Throwable -> L9
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L8:
        PermissionFragment.f = null;
        this.a.requireActivity().getSupportFragmentManager().beginTransaction().remove(this.a).commitAllowingStateLoss();
        return;
    L9:
        th = move-exception;
        PermissionFragment.f = null;
        this.a.requireActivity().getSupportFragmentManager().beginTransaction().remove(this.a).commitAllowingStateLoss();
        throw th;
    }
}
