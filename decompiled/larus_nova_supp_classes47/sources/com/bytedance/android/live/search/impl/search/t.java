package com.bytedance.android.live.search.impl.search;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t {
    public Disposable a;
    public int b;
    public final LifecycleOwner c;
    public final a d;

    public interface a {
        void H6();

        void Xp(ra1.h r1);
    }

    public t(FragmentActivity r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.c = r2;
        this.d = r3;
    }
}
