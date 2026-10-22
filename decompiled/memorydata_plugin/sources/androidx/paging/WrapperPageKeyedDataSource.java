package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0002*\b\b\u0002\u0010\u0004*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00040\u0005B9\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u001e\u0010\u0007\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J*\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0017H\u0016J*\u0010\u0018\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0017H\u0016J*\u0010\u0019\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR&\u0010\u0007\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/paging/WrapperPageKeyedDataSource;", "K", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Landroidx/paging/PageKeyedDataSource;", AILabCheckPermissionTask.KEY_SOURCE, "listFunction", "Landroidx/arch/core/util/Function;", "", "(Landroidx/paging/PageKeyedDataSource;Landroidx/arch/core/util/Function;)V", "isInvalid", "", "()Z", "addInvalidatedCallback", "", "onInvalidatedCallback", "Landroidx/paging/DataSource$InvalidatedCallback;", "invalidate", "loadAfter", TrackerImpl.PARAMS, "Landroidx/paging/PageKeyedDataSource$LoadParams;", "callback", "Landroidx/paging/PageKeyedDataSource$LoadCallback;", "loadBefore", "loadInitial", "Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "removeInvalidatedCallback", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WrapperPageKeyedDataSource<K, A, B> extends PageKeyedDataSource<K, B> {
    private final Function<List<A>, List<B>> listFunction;
    private final PageKeyedDataSource<K, A> source;

    public WrapperPageKeyedDataSource(PageKeyedDataSource<K, A> r3, Function<List<A>, List<B>> r4) {
        Function<List<A>, List<B>> r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r5, "listFunction");
        this.source = r3;
        this.listFunction = r5;
    }

    public static final /* synthetic */ Function access$getListFunction$p(WrapperPageKeyedDataSource r0) {
        return r0.listFunction;
    }

    @Override // androidx.paging.DataSource
    public void addInvalidatedCallback(DataSource.InvalidatedCallback r3) {
        DataSource.InvalidatedCallback r4 = (DataSource.InvalidatedCallback) ZeusTransformUtils.wrapperContextForParams(r3, DataSource.InvalidatedCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onInvalidatedCallback");
        this.source.addInvalidatedCallback(r4);
    }

    @Override // androidx.paging.DataSource
    public void invalidate() {
        this.source.invalidate();
    }

    @Override // androidx.paging.DataSource
    public boolean isInvalid() {
        return this.source.isInvalid();
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadAfter(PageKeyedDataSource.LoadParams<K> r3, final PageKeyedDataSource.LoadCallback<K, B> r4) {
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.source.loadAfter(r3, (PageKeyedDataSource.LoadCallback) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4, this), PageKeyedDataSource.LoadCallback.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadBefore(PageKeyedDataSource.LoadParams<K> r3, final PageKeyedDataSource.LoadCallback<K, B> r4) {
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.source.loadBefore(r3, (PageKeyedDataSource.LoadCallback) ZeusTransformUtils.preCheckCast(new C09711(r4, this), PageKeyedDataSource.LoadCallback.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadInitial(PageKeyedDataSource.LoadInitialParams<K> r3, final PageKeyedDataSource.LoadInitialCallback<K, B> r4) {
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.source.loadInitial(r3, (PageKeyedDataSource.LoadInitialCallback) ZeusTransformUtils.preCheckCast(new C09721(this, r4), PageKeyedDataSource.LoadInitialCallback.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.paging.DataSource
    public void removeInvalidatedCallback(DataSource.InvalidatedCallback r3) {
        DataSource.InvalidatedCallback r4 = (DataSource.InvalidatedCallback) ZeusTransformUtils.wrapperContextForParams(r3, DataSource.InvalidatedCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onInvalidatedCallback");
        this.source.removeInvalidatedCallback(r4);
    }
}
