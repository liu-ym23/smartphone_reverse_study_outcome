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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00030\u0004B3\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u001e\u0010\u0006\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u001e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0018H\u0016J\u001e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u001a2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR)\u0010\u0006\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/paging/WrapperPositionalDataSource;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "B", "Landroidx/paging/PositionalDataSource;", AILabCheckPermissionTask.KEY_SOURCE, "listFunction", "Landroidx/arch/core/util/Function;", "", "(Landroidx/paging/PositionalDataSource;Landroidx/arch/core/util/Function;)V", "isInvalid", "", "()Z", "getListFunction", "()Landroidx/arch/core/util/Function;", "addInvalidatedCallback", "", "onInvalidatedCallback", "Landroidx/paging/DataSource$InvalidatedCallback;", "invalidate", "loadInitial", TrackerImpl.PARAMS, "Landroidx/paging/PositionalDataSource$LoadInitialParams;", "callback", "Landroidx/paging/PositionalDataSource$LoadInitialCallback;", "loadRange", "Landroidx/paging/PositionalDataSource$LoadRangeParams;", "Landroidx/paging/PositionalDataSource$LoadRangeCallback;", "removeInvalidatedCallback", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WrapperPositionalDataSource<A, B> extends PositionalDataSource<B> {
    private final Function<List<A>, List<B>> listFunction;
    private final PositionalDataSource<A> source;

    public WrapperPositionalDataSource(PositionalDataSource<A> r3, Function<List<A>, List<B>> r4) {
        Function<List<A>, List<B>> r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r5, "listFunction");
        this.source = r3;
        this.listFunction = r5;
    }

    @Override // androidx.paging.DataSource
    public void addInvalidatedCallback(DataSource.InvalidatedCallback r3) {
        DataSource.InvalidatedCallback r4 = (DataSource.InvalidatedCallback) ZeusTransformUtils.wrapperContextForParams(r3, DataSource.InvalidatedCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onInvalidatedCallback");
        this.source.addInvalidatedCallback(r4);
    }

    public final Function<List<A>, List<B>> getListFunction() {
        return this.listFunction;
    }

    @Override // androidx.paging.DataSource
    public void invalidate() {
        this.source.invalidate();
    }

    @Override // androidx.paging.DataSource
    public boolean isInvalid() {
        return this.source.isInvalid();
    }

    @Override // androidx.paging.PositionalDataSource
    public void loadInitial(PositionalDataSource.LoadInitialParams r3, final PositionalDataSource.LoadInitialCallback<B> r4) {
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.source.loadInitial(r3, (PositionalDataSource.LoadInitialCallback) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4, this), PositionalDataSource.LoadInitialCallback.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.paging.PositionalDataSource
    public void loadRange(PositionalDataSource.LoadRangeParams r3, final PositionalDataSource.LoadRangeCallback<B> r4) {
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.source.loadRange(r3, (PositionalDataSource.LoadRangeCallback) ZeusTransformUtils.preCheckCast(new C09731(r4, this), PositionalDataSource.LoadRangeCallback.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.paging.DataSource
    public void removeInvalidatedCallback(DataSource.InvalidatedCallback r3) {
        DataSource.InvalidatedCallback r4 = (DataSource.InvalidatedCallback) ZeusTransformUtils.wrapperContextForParams(r3, DataSource.InvalidatedCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onInvalidatedCallback");
        this.source.removeInvalidatedCallback(r4);
    }
}
