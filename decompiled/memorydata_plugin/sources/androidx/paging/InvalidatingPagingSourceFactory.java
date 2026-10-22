package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u001f\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\u0006¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0096\u0002R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\n8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Landroidx/paging/InvalidatingPagingSourceFactory;", "Key", "", "Value", "Landroidx/paging/PagingSourceFactory;", "pagingSourceFactory", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "(Lkotlin/jvm/functions/Function0;)V", "pagingSources", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getPagingSources$paging_common$annotations", "()V", "getPagingSources$paging_common", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "invalidate", "", "invoke", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InvalidatingPagingSourceFactory<Key, Value> implements PagingSourceFactory<Key, Value> {
    private final Function0<PagingSource<Key, Value>> pagingSourceFactory;
    private final CopyOnWriteArrayList<PagingSource<Key, Value>> pagingSources;

    public InvalidatingPagingSourceFactory(Function0<? extends PagingSource<Key, Value>> r3) {
        Function0<PagingSource<Key, Value>> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "pagingSourceFactory");
        this.pagingSourceFactory = r4;
        this.pagingSources = new CopyOnWriteArrayList();
    }

    public static /* synthetic */ void getPagingSources$paging_common$annotations() {
    }

    public final CopyOnWriteArrayList<PagingSource<Key, Value>> getPagingSources$paging_common() {
        return this.pagingSources;
    }

    public final void invalidate() {
        Iterator<PagingSource<Key, Value>> r0 = this.pagingSources.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        PagingSource r1 = (PagingSource) ZeusTransformUtils.preCheckCast(r0.next(), PagingSource.class, "com.obric.memorydata.plugin");
        if (r1.getInvalid() == true) goto L4;
        r1.invalidate();
        goto L4
    L8:
        CollectionsKt.removeAll((List) ZeusTransformUtils.preCheckCast(this.pagingSources, List.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.paging.PagingSourceFactory, kotlin.jvm.functions.Function0
    public PagingSource<Key, Value> invoke() {
        PagingSource<Key, Value> r0 = this.pagingSourceFactory.invoke();
        PagingSource<Key, Value> r1 = (PagingSource) ZeusTransformUtils.preCheckCast(r0, PagingSource.class, "com.obric.memorydata.plugin");
        this.pagingSources.add(r1);
        return (PagingSource) ZeusTransformUtils.preCheckCast(r0, PagingSource.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        return invoke();
    }
}
