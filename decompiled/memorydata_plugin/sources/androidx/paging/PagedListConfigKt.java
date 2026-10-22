package androidx.paging;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003¨\u0006\t"}, d2 = {"Config", "Landroidx/paging/PagedList$Config;", "pageSize", "", "prefetchDistance", "enablePlaceholders", "", "initialLoadSizeHint", "maxSize", "paging-common"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PagedListConfigKt {
    public static final /* synthetic */ PagedList.Config Config(int r1, int r2, boolean r3, int r4, int r5) {
        return new PagedList.Config.Builder().setPageSize(r1).setPrefetchDistance(r2).setEnablePlaceholders(r3).setInitialLoadSizeHint(r4).setMaxSize(r5).build();
    }

    public static /* synthetic */ PagedList.Config Config$default(int r0, int r1, boolean r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r1 = r0;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r2 = true;
    L9:
        if ((r5 & 8) == 0) goto L12;
        r3 = r0 * 3;
    L12:
        if ((r5 & 16) == 0) goto L15;
        r4 = Integer.MAX_VALUE;
    L15:
        return Config(r0, r1, r2, r3, r4);
    }
}
