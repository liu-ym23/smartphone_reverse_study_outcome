package com.bytedance.apm.agent.v2.instrumentation;

import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class FragmentShowAgent {
    private static final String TAG = "FragmentShowAgent";

    public FragmentShowAgent() {
    }

    @Keep
    public static void onHiddenChanged(Fragment r8, boolean r10) {
    }

    @Keep
    public static void onPause(Fragment r8) {
        if (r8.getUserVisibleHint() == false) goto L6;
        r8.isHidden();
        return;
    }

    @Keep
    public static void onResume(Fragment r8) {
        if (r8.getUserVisibleHint() == false) goto L6;
        r8.isHidden();
        return;
    }

    @Keep
    public static void setUserVisibleHint(Fragment r8, boolean r10) {
        if (r8.isResumed() == false) goto L6;
        r8.isHidden();
        return;
    }
}
