package tq1;

import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final List<Episode> a(List<? extends EpisodeGroup> r2) {
        if (r2 == null) goto L12;
        ArrayList r0 = new ArrayList();
        Iterator<T> r3 = r2.iterator();
    L5:
        if (r3.hasNext() == false) goto L16;
        List r1 = ((EpisodeGroup) r3.next()).episodes;
        if (r1 != null) goto L10;
        r1 = CollectionsKt.emptyList();
    L10:
        r0.addAll(r1);
        goto L5
    L16:
        return r0;
    L12:
        return CollectionsKt.emptyList();
    }
}
