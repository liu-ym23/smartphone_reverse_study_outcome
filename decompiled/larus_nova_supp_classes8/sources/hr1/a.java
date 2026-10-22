package hr1;

import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.util.r;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoModel;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(DataCenter r2) {
        ReplayDataContext.Companion.getClass();
        ReplayDataContext r3 = ReplayDataContext.a.b(r2);
        if (r3 == null) goto L9;
        n<Episode> r4 = r3.getEpisode();
        if (r4 == null) goto L9;
        Episode r5 = (Episode) r4.getValue();
        if (r5 == null) goto L9;
        String r6 = r5.getPlayVideoModel();
    L10:
        int r0 = r.a;
        VideoModel r7 = r.e(r6);
        if (r7 == null) goto L15;
        Resolution[] r8 = r7.getSupportResolutions();
        if (r8 == null) goto L15;
        int r9 = r8.length;
    L17:
        if (r9 <= 1) goto L20;
        return true;
    L20:
        return false;
    L15:
        r9 = 0;
    L9:
        r6 = null;
        goto L10
    }
}
