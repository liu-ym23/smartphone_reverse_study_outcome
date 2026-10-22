package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0002*\b\b\u0002\u0010\u0004*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00040\u0005B9\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u001e\u0010\u0007\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\tJ\u0015\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0011H\u0016J$\u0010\u0019\u001a\u00020\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00020\u001dH\u0016J$\u0010\u001e\u001a\u00020\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00020\u001dH\u0016J$\u0010\u001f\u001a\u00020\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000 2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00000\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/paging/WrapperItemKeyedDataSource;", "K", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Landroidx/paging/ItemKeyedDataSource;", AILabCheckPermissionTask.KEY_SOURCE, "listFunction", "Landroidx/arch/core/util/Function;", "", "(Landroidx/paging/ItemKeyedDataSource;Landroidx/arch/core/util/Function;)V", "isInvalid", "", "()Z", "keyMap", "Ljava/util/IdentityHashMap;", "addInvalidatedCallback", "", "onInvalidatedCallback", "Landroidx/paging/DataSource$InvalidatedCallback;", "convertWithStashedKeys", "getKey", "item", "(Ljava/lang/Object;)Ljava/lang/Object;", "invalidate", "loadAfter", TrackerImpl.PARAMS, "Landroidx/paging/ItemKeyedDataSource$LoadParams;", "callback", "Landroidx/paging/ItemKeyedDataSource$LoadCallback;", "loadBefore", "loadInitial", "Landroidx/paging/ItemKeyedDataSource$LoadInitialParams;", "Landroidx/paging/ItemKeyedDataSource$LoadInitialCallback;", "removeInvalidatedCallback", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WrapperItemKeyedDataSource<K, A, B> extends ItemKeyedDataSource<K, B> {
    private final IdentityHashMap<B, K> keyMap;
    private final Function<List<A>, List<B>> listFunction;
    private final ItemKeyedDataSource<K, A> source;

    public WrapperItemKeyedDataSource(ItemKeyedDataSource<K, A> r3, Function<List<A>, List<B>> r4) {
        Function<List<A>, List<B>> r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r5, "listFunction");
        this.source = r3;
        this.listFunction = r5;
        this.keyMap = new IdentityHashMap();
    }

    @Override // androidx.paging.DataSource
    public void addInvalidatedCallback(DataSource.InvalidatedCallback r3) {
        DataSource.InvalidatedCallback r4 = (DataSource.InvalidatedCallback) ZeusTransformUtils.wrapperContextForParams(r3, DataSource.InvalidatedCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onInvalidatedCallback");
        this.source.addInvalidatedCallback(r4);
    }

    public final List<B> convertWithStashedKeys(List<? extends A> r9) {
        List<? extends A> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, AILabCheckPermissionTask.KEY_SOURCE);
        List<B> r0 = DataSource.Companion.convert$paging_common(this.listFunction, r10);
        IdentityHashMap<B, K> r1 = this.keyMap;
        monitor-enter(r1);
        int r2 = 0;
        int r3 = r0.size();     // Catch: Throwable -> L11
    L6:
        if (r2 >= r3) goto L8;
        ((Map) ZeusTransformUtils.preCheckCast(this.keyMap, Map.class, "com.obric.memorydata.plugin")).put(r0.get(r2), this.source.getKey(r10.get(r2)));     // Catch: Throwable -> L11
        r2 = r2 + 1;     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r1);
        return r0;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public K getKey(B r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        IdentityHashMap<B, K> r0 = this.keyMap;
        monitor-enter(r0);
        K r1 = this.keyMap.get(r2);     // Catch: Throwable -> L7
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.paging.DataSource
    public void invalidate() {
        this.source.invalidate();
    }

    @Override // androidx.paging.DataSource
    public boolean isInvalid() {
        return this.source.isInvalid();
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public void loadAfter(ItemKeyedDataSource.LoadParams<K> r3, final ItemKeyedDataSource.LoadCallback<B> r4) {
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.source.loadAfter(r3, (ItemKeyedDataSource.LoadCallback) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4, this), ItemKeyedDataSource.LoadCallback.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public void loadBefore(ItemKeyedDataSource.LoadParams<K> r3, final ItemKeyedDataSource.LoadCallback<B> r4) {
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.source.loadBefore(r3, (ItemKeyedDataSource.LoadCallback) ZeusTransformUtils.preCheckCast(new C09691(r4, this), ItemKeyedDataSource.LoadCallback.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public void loadInitial(ItemKeyedDataSource.LoadInitialParams<K> r3, final ItemKeyedDataSource.LoadInitialCallback<B> r4) {
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.source.loadInitial(r3, (ItemKeyedDataSource.LoadInitialCallback) ZeusTransformUtils.preCheckCast(new C09701(r4, this), ItemKeyedDataSource.LoadInitialCallback.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.paging.DataSource
    public void removeInvalidatedCallback(DataSource.InvalidatedCallback r3) {
        DataSource.InvalidatedCallback r4 = (DataSource.InvalidatedCallback) ZeusTransformUtils.wrapperContextForParams(r3, DataSource.InvalidatedCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onInvalidatedCallback");
        this.source.removeInvalidatedCallback(r4);
    }
}
