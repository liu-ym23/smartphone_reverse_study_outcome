package web;

import com.ss.android.lark.feed.shared.page.experiment.FeedPreloadConfig;
import com.ss.ttvideoengine.utils.ScreenUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends iua.a<FeedPreloadConfig> {

    public static final class a {
    }

    static {
    }

    public final Object getDefault() {
        return new FeedPreloadConfig(false, false, false, false, false, false, false, false, ScreenUtils.MAX_SYSTEM_BRIGHTNESS, null);
    }

    public final iua.b getLarkExperimentInfo() {
        return new iua.b("feed_preload_chat_config", "Feed Preload Chat Experiment");
    }

    public e() {
    }
}
