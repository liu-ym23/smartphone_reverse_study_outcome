package nv1;

import com.bytedance.android.livesdkapi.feed.IDislikeRepository;
import com.bytedance.android.livesdkapi.feed.IOpenFeedRepository;
import com.bytedance.android.livesdkapi.feed.IOpenFeedService;
import com.bytedance.android.livesdkapi.feed.open.IOpenLiveListFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class f implements IOpenFeedService {
    public f() {
    }

    public IDislikeRepository getDislikeRepository() {
        return new tw1.a();
    }

    public IOpenFeedRepository getFeedRepository() {
        return new tw1.b();
    }

    public IOpenLiveListFactory getOpenLiveListFactory() {
        return mw1.e.a;
    }
}
