package androidx.customview.poolingcontainer;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u000f\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\n\u0010\u0013\u001a\u00020\u0010*\u00020\u0006\u001a\n\u0010\u0014\u001a\u00020\u0010*\u00020\u0015\u001a\u0014\u0010\u0016\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"(\u0010\u0005\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t\"\u0015\u0010\n\u001a\u00020\u0004*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007\"\u0018\u0010\u000b\u001a\u00020\f*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"IsPoolingContainerTag", "", "PoolingContainerListenerHolderTag", EventBody.KEY_VALUE, "", "isPoolingContainer", "Landroid/view/View;", "(Landroid/view/View;)Z", "setPoolingContainer", "(Landroid/view/View;Z)V", "isWithinPoolingContainer", "poolingContainerListenerHolder", "Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "getPoolingContainerListenerHolder", "(Landroid/view/View;)Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "addPoolingContainerListener", "", "listener", "Landroidx/customview/poolingcontainer/PoolingContainerListener;", "callPoolingContainerOnRelease", "callPoolingContainerOnReleaseForChildren", "Landroid/view/ViewGroup;", "removePoolingContainerListener", "customview-poolingcontainer_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PoolingContainer {
    private static final int IsPoolingContainerTag = 0;
    private static final int PoolingContainerListenerHolderTag = 0;

    static {
        PoolingContainerListenerHolderTag = ZeusTransformUtils.mapRes(R.id.pooling_container_listener_holder_tag, OaidModel.KEY_ID, "pooling_container_listener_holder_tag");
        IsPoolingContainerTag = ZeusTransformUtils.mapRes(R.id.is_pooling_container_tag, OaidModel.KEY_ID, "is_pooling_container_tag");
    }

    public static final void addPoolingContainerListener(View r2, PoolingContainerListener r3) {
        PoolingContainerListener r4 = (PoolingContainerListener) ZeusTransformUtils.wrapperContextForParams(r3, PoolingContainerListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "listener");
        getPoolingContainerListenerHolder(r2).addListener(r4);
    }

    public static final void callPoolingContainerOnRelease(View r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Iterator<View> r4 = ViewKt.getAllViews(r3).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        getPoolingContainerListenerHolder((View) ZeusTransformUtils.preCheckCast(r4.next(), View.class, "com.obric.memorydata.plugin")).onRelease();
        goto L4
    }

    public static final void callPoolingContainerOnReleaseForChildren(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Iterator<View> r4 = ViewGroupKt.getChildren(r3).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        getPoolingContainerListenerHolder((View) ZeusTransformUtils.preCheckCast(r4.next(), View.class, "com.obric.memorydata.plugin")).onRelease();
        goto L4
    }

    private static final PoolingContainerListenerHolder getPoolingContainerListenerHolder(View r4) {
        int r0 = PoolingContainerListenerHolderTag;
        PoolingContainerListenerHolder r1 = (PoolingContainerListenerHolder) ZeusTransformUtils.preCheckCast(r4.getTag(r0), PoolingContainerListenerHolder.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        PoolingContainerListenerHolder r2 = new PoolingContainerListenerHolder();
        r4.setTag(r0, r2);
        return r2;
    L6:
        return r1;
    }

    public static final boolean isPoolingContainer(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Object r3 = r2.getTag(IsPoolingContainerTag);
        if (ZeusTransformUtils.instanceOf(r3, Boolean.class) == false) goto L5;
        Boolean r4 = (Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 != null) goto L10;
        return false;
    L10:
        return r4.booleanValue();
    L5:
        r4 = null;
        goto L6
    }

    public static final boolean isWithinPoolingContainer(View r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Iterator<ViewParent> r4 = ViewKt.getAncestors(r3).iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        ViewParent r0 = (ViewParent) ZeusTransformUtils.preCheckCast(r4.next(), ViewParent.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, View.class) == false) goto L4;
        if (isPoolingContainer((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin")) == false) goto L4;
        return true;
    L11:
        return false;
    }

    public static final void removePoolingContainerListener(View r2, PoolingContainerListener r3) {
        PoolingContainerListener r4 = (PoolingContainerListener) ZeusTransformUtils.wrapperContextForParams(r3, PoolingContainerListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "listener");
        getPoolingContainerListenerHolder(r2).removeListener(r4);
    }

    public static final void setPoolingContainer(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setTag(IsPoolingContainerTag, Boolean.valueOf(r2));
    }
}
