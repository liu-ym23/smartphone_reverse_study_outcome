package com.bytedance.android.live.liveinteract.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i {
    public static final boolean a(FragmentManager r4) {
        Intrinsics.checkNotNullParameter(r4, "fragmentManager");
        Intrinsics.checkNotNullParameter("LivePlayFragment", "fragmentName");
        Iterator r5 = r4.getFragments().iterator();
    L4:
        if (r5.hasNext() == false) goto L15;
        Fragment r0 = (Fragment) r5.next();
        if (Intrinsics.areEqual("LivePlayFragment", r0.getClass().getSimpleName()) == false) goto L11;
        if (r0.isVisible() == false) goto L11;
        return true;
    L11:
        if (r0.isAdded() == false) goto L4;
        if (a(r0.getChildFragmentManager()) == false) goto L4;
        return true;
    L15:
        return false;
    }
}
