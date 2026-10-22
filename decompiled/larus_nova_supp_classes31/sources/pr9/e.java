package pr9;

import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class e implements b {
    public e() {
    }

    @Override // pr9.b
    public d a() {
        return null;
    }

    @Override // pr9.b
    public final void b(CustomFeedPlayerEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // pr9.b
    public final void c(boolean r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "aid");
    }

    @Override // pr9.b
    public final void onLoadError(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    @Override // pr9.b
    public final void onLoadSuccess() {
    }
}
