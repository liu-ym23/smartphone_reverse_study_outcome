package com.bytedance.android.livesdk.explore;

import com.bytedance.android.livesdkapi.explore.ILiveExploreLynxFragmentCreator;
import com.bytedance.android.livesdkapi.explore.ILiveExploreService;
import com.bytedance.android.livesdkapi.explore.LiveExploreLynxCallback;
import hv1.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/explore/LiveExploreService;", "Lcom/bytedance/android/livesdkapi/explore/ILiveExploreService;", "()V", "getLiveExploreLynxFragmentCreator", "Lcom/bytedance/android/livesdkapi/explore/ILiveExploreLynxFragmentCreator;", "isDark", "", "liveExploreLyncCallback", "Lcom/bytedance/android/livesdkapi/explore/LiveExploreLynxCallback;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveExploreService implements ILiveExploreService {
    public LiveExploreService() {
    }

    public ILiveExploreLynxFragmentCreator getLiveExploreLynxFragmentCreator(boolean r2, LiveExploreLynxCallback r3) {
        Intrinsics.checkNotNullParameter(r3, "liveExploreLyncCallback");
        return new a(r2, r3);
    }
}
