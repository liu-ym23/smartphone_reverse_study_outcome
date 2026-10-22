package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0002H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"toRefreshLoadParams", "Landroidx/paging/PagingSource$LoadParams;", "Key", "", "Landroidx/paging/PagedList$Config;", "key", "(Landroidx/paging/PagedList$Config;Ljava/lang/Object;)Landroidx/paging/PagingSource$LoadParams;", "paging-common"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PagingSourceKt {
    public static final <Key> PagingSource.LoadParams<Key> toRefreshLoadParams(PagedList.Config r2, Key r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (PagingSource.LoadParams) ZeusTransformUtils.preCheckCast(new PagingSource.LoadParams.Refresh(r3, r2.initialLoadSizeHint, r2.enablePlaceholders), PagingSource.LoadParams.class, "com.obric.memorydata.plugin");
    }
}
