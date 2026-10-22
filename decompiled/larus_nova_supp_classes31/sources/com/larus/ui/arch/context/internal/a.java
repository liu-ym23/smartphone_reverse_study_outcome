package com.larus.ui.arch.context.internal;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import kotlin.jvm.internal.Intrinsics;
import s1a.d;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final b a(LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if ((r3 instanceof FragmentActivity) == false) goto L6;
        return s1a.a.h((FragmentActivity) r3);
    L6:
        if ((r3 instanceof Fragment) == false) goto L9;
        return s1a.a.g((Fragment) r3);
    L9:
        if ((r3 instanceof ComponentFeature) == false) goto L12;
        return d.a((AttachReceiver) r3);
    L12:
        if ((r3 instanceof ViewModelStoreOwner) == false) goto L18;
        ViewModelStoreOwner r4 = (ViewModelStoreOwner) r3;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if ((r4 instanceof EmptyComponent) == true) goto L22;
        VContextStore.Companion.getClass();
        return VContextStore.getOrInit$default(VContextStore.a.a(r4), null, 1, null);
    L22:
        return new t0();
    L18:
        return null;
    }
}
