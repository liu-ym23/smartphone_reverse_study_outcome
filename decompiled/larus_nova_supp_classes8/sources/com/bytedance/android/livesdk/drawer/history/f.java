package com.bytedance.android.livesdk.drawer.history;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f {
    public final NextLiveData<Boolean> a;
    public final Fragment b;

    public f(NextLiveData r2, LiveHistoryFragment r3) {
        Intrinsics.checkNotNullParameter(r2, "isLoading");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        this.a = r2;
        this.b = r3;
    }
}
