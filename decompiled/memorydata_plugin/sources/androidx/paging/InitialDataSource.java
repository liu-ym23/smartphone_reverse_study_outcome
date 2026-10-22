package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u0005¢\u0006\u0002\u0010\u0005J*\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bH\u0016J*\u0010\f\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bH\u0016J*\u0010\r\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000fH\u0016¨\u0006\u0010"}, d2 = {"Landroidx/paging/InitialDataSource;", "K", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/paging/PageKeyedDataSource;", "()V", "loadAfter", "", TrackerImpl.PARAMS, "Landroidx/paging/PageKeyedDataSource$LoadParams;", "callback", "Landroidx/paging/PageKeyedDataSource$LoadCallback;", "loadBefore", "loadInitial", "Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InitialDataSource<K, V> extends PageKeyedDataSource<K, V> {
    public InitialDataSource() {
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadAfter(PageKeyedDataSource.LoadParams<K> r1, PageKeyedDataSource.LoadCallback<K, V> r2) {
        Intrinsics.checkNotNullParameter(r1, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r2, "callback");
        r2.onResult(CollectionsKt.emptyList(), null);
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadBefore(PageKeyedDataSource.LoadParams<K> r1, PageKeyedDataSource.LoadCallback<K, V> r2) {
        Intrinsics.checkNotNullParameter(r1, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r2, "callback");
        r2.onResult(CollectionsKt.emptyList(), null);
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadInitial(PageKeyedDataSource.LoadInitialParams<K> r7, PageKeyedDataSource.LoadInitialCallback<K, V> r8) {
        Intrinsics.checkNotNullParameter(r7, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r8, "callback");
        r8.onResult(CollectionsKt.emptyList(), 0, 0, null, null);
    }
}
