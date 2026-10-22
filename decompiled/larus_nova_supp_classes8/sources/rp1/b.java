package rp1;

import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.live.network.response.ListResponse;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeUserStatistics;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T, R> implements Function {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final Object apply(Object r3) {
        ListResponse r4 = (ListResponse) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        List r5 = ((BaseListResponse) r4).data;
        if (r5 == null) goto L9;
        Episode r6 = (Episode) ListProtector.get(r5, 0);
        if (r6 == null) goto L9;
        EpisodeUserStatistics r7 = r6.userStatistics;
        if (r7 == null) goto L9;
        return Long.valueOf(r7.getWatchDuration());
    L9:
        return null;
    }
}
