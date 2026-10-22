package nv1;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.base.service.ILiveDrawerFeed;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.feed.LiveDrawerTabViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.TabFeedViewModel;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements ILiveDrawerFeed {
    public d() {
        if (LiveInitAssistant.INSTANCE.optimizeConfig().getPreInitLiveOptV2() == false) goto L11;
        ConcurrentHashMap r1 = k.a;     // Catch: Exception -> L9
        if (r1.containsKey(ILiveDrawerFeed.class) == true) goto L16;
        r1.put(ILiveDrawerFeed.class, this);     // Catch: Exception -> L9
        return;
    L16:
        return;
    L17:
        return;
    L11:
        if (k.f(ILiveDrawerFeed.class) != null) goto L18;
        k.l(ILiveDrawerFeed.class, this);
        return;
    }

    public final void clearDrawerData(FragmentActivity r3) {
        if (r3 == null) goto L10;
        ((LiveDrawerTabViewModel) ViewModelProviders.of(r3).get(LiveDrawerTabViewModel.class)).doClear();     // Catch: Exception -> L5
        TabFeedViewModel r4 = ViewModelProviders.of(r3).get(TabFeedViewModel.class);     // Catch: Exception -> L5
        r4.setStarted(false);     // Catch: Exception -> L5
        r4.setLastOffset(0);     // Catch: Exception -> L5
        r4.setLastPosition(0);     // Catch: Exception -> L5
        r4.clearDataCache();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ALogger.e("LiveDrawerFeedService.clearDrawerData", e);
        return;
    }
}
