package com.larus.xbridge.custom;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u {
    public static final Fragment a(FragmentManager r4) {
        Fragment r0 = r4.getPrimaryNavigationFragment();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L13;
        Fragment r5 = a(r0.getChildFragmentManager());
        if (r5 != null) goto L12;
        return r0;
    L12:
        return r5;
    L13:
        Iterator r6 = CollectionsKt.asReversedMutable(r4.getFragments()).iterator();
    L15:
        if (r6.hasNext() == false) goto L26;
        Fragment r2 = (Fragment) r6.next();
        if (r2 == r0) goto L15;
        Intrinsics.checkNotNull(r2);
        if (b(r2) == false) goto L15;
        Fragment r7 = a(r2.getChildFragmentManager());
        if (r7 != null) goto L25;
        return r2;
    L25:
        return r7;
    L26:
        return null;
    L5:
        if (b(r0) != true) goto L7;
        r1 = true;
        goto L7
    }

    public static final boolean b(Fragment r3) {
        LifecycleOwner r0 = (LifecycleOwner) r3.getViewLifecycleOwnerLiveData().getValue();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r3.isAdded() == true) goto L8;
        return false;
    L8:
        if (r3.isDetached() == false) goto L10;
        return false;
    L10:
        if (r3.isHidden() == true) goto L19;
        Lifecycle.State r4 = r3.getLifecycle().getCurrentState();
        Lifecycle.State r2 = Lifecycle.State.RESUMED;
        if (r4.isAtLeast(r2) == true) goto L14;
        return false;
    L14:
        if (r0.getLifecycle().getCurrentState().isAtLeast(r2) == false) goto L21;
        return true;
    L21:
        return false;
    L19:
        return false;
    }
}
