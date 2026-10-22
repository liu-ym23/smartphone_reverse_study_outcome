package com.bytedance.android.live.core.privacy.av.impl;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/live/core/privacy/av/impl/AudioAndVideoPermissionMonitor$fragmentLifeCycleCb$1", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioAndVideoPermissionMonitor$fragmentLifeCycleCb$1 extends FragmentManager.FragmentLifecycleCallbacks {
    public final void onFragmentDetached(FragmentManager r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        Intrinsics.checkNotNullParameter(r3, "f");
        super.onFragmentDetached(r2, r3);
        ALogger.i("AudioAndVideoPrivacy", "AudioAndVideoPermissionMonitor,fragment:" + r3.getClass().getName() + ',' + r3.getTag() + " detached");
        throw null;
    }

    public final void onFragmentResumed(FragmentManager r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        Intrinsics.checkNotNullParameter(r3, "f");
        super.onFragmentResumed(r2, r3);
        ALogger.i("AudioAndVideoPrivacy", "AudioAndVideoPermissionMonitor,fragment:" + r3.getClass().getName() + ",fragment tag:" + r3.getTag() + " resumed");
        throw null;
    }
}
