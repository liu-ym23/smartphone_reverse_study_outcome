package com.bytedance.android.accessibilityLib_Core.processor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final boolean a(TraverseFromType r1) {
        if (r1 != TraverseFromType.ActivityCreated_PageIn) goto L5;
    L10:
        return true;
    L5:
        if (r1 == TraverseFromType.FragmentCreated) goto L10;
        if (r1 == TraverseFromType.ActivityPostResumed) goto L10;
        return false;
    }
}
