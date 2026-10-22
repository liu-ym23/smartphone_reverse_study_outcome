package com.larus.ui.arch.component.internal.attach;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final FragmentActivity a(BaseComponentFeatureInternal r1, LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "current");
        if ((r2 instanceof Fragment) == false) goto L6;
        return ((Fragment) r2).requireActivity();
    L6:
        if ((r2 instanceof FragmentActivity) == false) goto L9;
        return (FragmentActivity) r2;
    L9:
        if ((r2 instanceof ComponentFeature) == false) goto L13;
        return a(r1, ((ComponentFeature) r2).getParent());
    L13:
        throw new UnsupportedOperationException("find Activity failed, only support Fragment and Component");
    }

    public static final Fragment b(AttachReceiver r1, LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "current");
        if ((r2 instanceof r1a.a) == false) goto L6;
        return ((r1a.a) r2).p7();
    L6:
        if ((r2 instanceof Fragment) == false) goto L9;
        return (Fragment) r2;
    L9:
        if ((r2 instanceof BaseComponentFeatureInternal) == false) goto L13;
        return b(r1, ((BaseComponentFeatureInternal) r2).getParent());
    L13:
        throw new UnsupportedOperationException("find Fragment failed, only support Component");
    }
}
