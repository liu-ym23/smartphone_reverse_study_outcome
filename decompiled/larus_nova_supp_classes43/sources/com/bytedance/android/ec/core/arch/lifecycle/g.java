package com.bytedance.android.ec.core.arch.lifecycle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public static final LifecycleOwner a(QContext r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$viewLifecycleOwner");
        Fragment r0 = r1.a;
        if (r0 == null) goto L7;
        LifecycleOwner r10 = r0.getViewLifecycleOwner();
        if (r10 == null) goto L7;
        return r10;
    L7:
        return r1.e();
    }
}
