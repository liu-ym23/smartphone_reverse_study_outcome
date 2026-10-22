package androidx.customview.poolingcontainer;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "", "()V", "listeners", "Ljava/util/ArrayList;", "Landroidx/customview/poolingcontainer/PoolingContainerListener;", "Lkotlin/collections/ArrayList;", "addListener", "", "listener", "onRelease", "removeListener", "customview-poolingcontainer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class PoolingContainerListenerHolder {
    private final ArrayList<PoolingContainerListener> listeners;

    public PoolingContainerListenerHolder() {
        this.listeners = new ArrayList();
    }

    public final void addListener(PoolingContainerListener r3) {
        PoolingContainerListener r4 = (PoolingContainerListener) ZeusTransformUtils.wrapperContextForParams(r3, PoolingContainerListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.listeners.add(r4);
    }

    public final void onRelease() {
        int r0 = CollectionsKt.getLastIndex((List) ZeusTransformUtils.preCheckCast(this.listeners, List.class, "com.obric.memorydata.plugin"));
    L4:
        if ((-1) >= r0) goto L6;
        ((PoolingContainerListener) ZeusTransformUtils.preCheckCast(this.listeners.get(r0), PoolingContainerListener.class, "com.obric.memorydata.plugin")).onRelease();
        r0 = r0 - 1;
        goto L4
    }

    public final void removeListener(PoolingContainerListener r3) {
        PoolingContainerListener r4 = (PoolingContainerListener) ZeusTransformUtils.wrapperContextForParams(r3, PoolingContainerListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.listeners.remove(r4);
    }
}
