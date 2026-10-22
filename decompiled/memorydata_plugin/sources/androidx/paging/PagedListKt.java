package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aq\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004\"\b\b\u0001\u0010\u0002*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u0001H\u0003H\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"PagedList", "Landroidx/paging/PagedList;", "Value", "Key", "", "dataSource", "Landroidx/paging/DataSource;", "config", "Landroidx/paging/PagedList$Config;", "notifyExecutor", "Ljava/util/concurrent/Executor;", "fetchExecutor", "boundaryCallback", "Landroidx/paging/PagedList$BoundaryCallback;", "initialKey", "(Landroidx/paging/DataSource;Landroidx/paging/PagedList$Config;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Landroidx/paging/PagedList$BoundaryCallback;Ljava/lang/Object;)Landroidx/paging/PagedList;", "paging-common"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PagedListKt {
    @Deprecated(message = "DataSource is deprecated and has been replaced by PagingSource")
    public static final /* synthetic */ PagedList PagedList(DataSource r2, PagedList.Config r3, Executor r4, Executor r5, PagedList.BoundaryCallback r6, Object r7) {
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
        Executor r9 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "dataSource");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r8, "notifyExecutor");
        Intrinsics.checkNotNullParameter(r9, "fetchExecutor");
        return new PagedList.Builder(r2, r3).setNotifyExecutor(r8).setFetchExecutor(r9).setBoundaryCallback(r6).setInitialKey(r7).build();
    }

    public static /* synthetic */ PagedList PagedList$default(DataSource r7, PagedList.Config r8, Executor r9, Executor r10, PagedList.BoundaryCallback r11, Object r12, int r13, Object r14) {
        Executor r3 = (Executor) ZeusTransformUtils.wrapperContextForParams(r9, Executor.class, "com.obric.memorydata.plugin");
        Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r10, Executor.class, "com.obric.memorydata.plugin");
        if ((r13 & 16) == 0) goto L5;
        PagedList.BoundaryCallback r5 = null;
    L7:
        if ((r13 & 32) == 0) goto L9;
        Object r6 = null;
    L11:
        return PagedList(r7, r8, r3, r4, r5, r6);
    L9:
        r6 = r12;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }
}
