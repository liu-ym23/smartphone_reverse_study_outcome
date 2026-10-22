package yn0;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdkapi.depend.model.live.abs.IVSCompatRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeBasic;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements l81.c {
    public static final c a = null;

    public c() {
    }

    static {
        a = new c();
    }

    public final EpisodeBasic a(DataCenter r1) {
        if (r1 == null) goto L6;
        IVSCompatRoom r2 = z.q(r1);
        if (r2 == null) goto L6;
        return r2.getEpisodeBasic();
    L6:
        return null;
    }
}
