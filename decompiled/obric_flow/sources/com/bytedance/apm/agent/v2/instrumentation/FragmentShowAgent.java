package com.bytedance.apm.agent.v2.instrumentation;

import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class FragmentShowAgent {
    private static final String TAG = "FragmentShowAgent";

    public FragmentShowAgent() {
    }

    @Keep
    public static void onHiddenChanged(Fragment r5, boolean r10) {
    }

    @Keep
    public static void onPause(Fragment r5) {
        if (r5.getUserVisibleHint() == false) goto L6;
        r5.isHidden();
        return;
    }

    @Keep
    public static void onResume(Fragment r5) {
        if (r5.getUserVisibleHint() == false) goto L6;
        r5.isHidden();
        return;
    }

    @Keep
    public static void setUserVisibleHint(Fragment r5, boolean r10) {
        if (r5.isResumed() == false) goto L6;
        r5.isHidden();
        return;
    }
}
