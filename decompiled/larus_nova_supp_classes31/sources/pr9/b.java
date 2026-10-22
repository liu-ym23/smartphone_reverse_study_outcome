package pr9;

import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface b {
    d a();

    void b(CustomFeedPlayerEvent r1);

    void c(boolean r1, String r2);

    void onLoadError(String r1);

    void onLoadSuccess();
}
