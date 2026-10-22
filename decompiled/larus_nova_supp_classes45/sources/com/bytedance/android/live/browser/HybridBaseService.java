package com.bytedance.android.live.browser;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livesdk.LiveDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/browser/HybridBaseService;", "Lcom/bytedance/android/live/browser/IHybridBaseService;", "()V", "showHybridDebugFragment", "", "activity", "Landroidx/fragment/app/FragmentActivity;", LiveSlardarConstants.EXTRA_KEY_URL, "", "isLynx", "", "originSchema", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class HybridBaseService implements IHybridBaseService {
    public HybridBaseService() {
    }

    @Override // com.bytedance.android.live.browser.IHybridBaseService
    public void showHybridDebugFragment(FragmentActivity r3, String r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, LiveSlardarConstants.EXTRA_KEY_URL);
        int r1 = HybridDebugFragment.k;
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, LiveSlardarConstants.EXTRA_KEY_URL);
        Bundle r7 = new Bundle();
        r7.putString(LiveSlardarConstants.EXTRA_KEY_URL, r4);
        r7.putBoolean("is_lynx", r5);
        r7.putString("origin_schema", "");
        HybridDebugFragment r8 = new HybridDebugFragment();
        r8.setArguments(r7);
        LiveDialogFragment.Companion.getClass();
        LiveDialogFragment.a.a(r3, r8);
    }
}
