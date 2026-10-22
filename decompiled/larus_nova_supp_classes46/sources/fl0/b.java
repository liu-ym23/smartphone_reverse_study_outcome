package fl0;

import com.bytedance.android.live.livepullstream.PullStreamService;
import com.ss.videoarch.liveplayer.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements i.a {
    public final /* synthetic */ PullStreamService a;

    public final void loadLibrary(String r1) throws Exception {
    }

    public final void loadLibraryFromPath(String r1) throws Exception {
    }

    public final boolean loadPlayerLibrary(String r1) {
        return false;
    }

    public b(PullStreamService r1) {
        this.a = r1;
    }

    public final boolean loadPluginLibrary(String r2, String r3) throws Exception {
        return this.a.loadPluginLibrary(r2, r3);
    }
}
