package fl0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.livepullstream.PullStreamService;
import com.ss.videoarch.liveplayer.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements i.a {
    public final /* synthetic */ PullStreamService a;

    public final void loadLibraryFromPath(String r1) throws Exception {
    }

    public final boolean loadPluginLibrary(String r1, String r2) throws Exception {
        return false;
    }

    public a(PullStreamService r1) {
        this.a = r1;
    }

    public final void loadLibrary(String r2) throws Exception {
        this.a.loadLibrary(r2);
    }

    public final boolean loadPlayerLibrary(String r4) {
        if (this.a.loadLibrary(r4) != 0) goto L11;
        return true;
    L11:
        return false;
    L7:
        ALogger.d("pull-stream-plugin-load", "load " + r4 + " so failed!");
        return false;
    }
}
