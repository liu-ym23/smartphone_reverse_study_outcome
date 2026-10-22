package nv1;

import android.content.Context;
import com.bytedance.android.live.core.IInnerSDKCore;
import com.bytedance.android.livesdk.feed.context.LiveFeedContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements IInnerSDKCore {
    public c() {
    }

    public final String getChannel() {
        return LiveFeedContext.hostService().appContext().getChannel();
    }

    public Context getContext() {
        return LiveFeedContext.hostService().appContext().context();
    }
}
