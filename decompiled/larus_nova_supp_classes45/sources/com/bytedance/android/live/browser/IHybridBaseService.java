package com.bytedance.android.live.browser;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/browser/IHybridBaseService;", "Lcom/bytedance/android/live/base/IService;", "showHybridDebugFragment", "", "activity", "Landroidx/fragment/app/FragmentActivity;", LiveSlardarConstants.EXTRA_KEY_URL, "", "isLynx", "", "originSchema", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHybridBaseService extends IService {
    void showHybridDebugFragment(FragmentActivity r1, String r2, boolean r3, String r4);
}
