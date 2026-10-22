package hy;

import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T> implements Comparator<T> {
    public c() {
    }

    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        return ComparisonsKt.compareValues(Long.valueOf(((AnchorLinkUser) r3).getLinkMicId()), Long.valueOf(((AnchorLinkUser) r4).getLinkMicId()));
    }
}
