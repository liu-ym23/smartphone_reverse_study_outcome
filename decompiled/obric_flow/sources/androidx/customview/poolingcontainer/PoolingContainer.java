package androidx.customview.poolingcontainer;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u000f\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\n\u0010\u0013\u001a\u00020\u0010*\u00020\u0006\u001a\n\u0010\u0014\u001a\u00020\u0010*\u00020\u0015\u001a\u0014\u0010\u0016\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"(\u0010\u0005\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t\"\u0015\u0010\n\u001a\u00020\u0004*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007\"\u0018\u0010\u000b\u001a\u00020\f*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"IsPoolingContainerTag", "", "PoolingContainerListenerHolderTag", "value", "", "isPoolingContainer", "Landroid/view/View;", "(Landroid/view/View;)Z", "setPoolingContainer", "(Landroid/view/View;Z)V", "isWithinPoolingContainer", "poolingContainerListenerHolder", "Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "getPoolingContainerListenerHolder", "(Landroid/view/View;)Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "addPoolingContainerListener", "", "listener", "Landroidx/customview/poolingcontainer/PoolingContainerListener;", "callPoolingContainerOnRelease", "callPoolingContainerOnReleaseForChildren", "Landroid/view/ViewGroup;", "removePoolingContainerListener", "customview-poolingcontainer_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "PoolingContainer")
public final class PoolingContainer {
    private static final int IsPoolingContainerTag = 0;
    private static final int PoolingContainerListenerHolderTag = 0;

    static {
        PoolingContainerListenerHolderTag = R.id.pooling_container_listener_holder_tag;
        IsPoolingContainerTag = R.id.is_pooling_container_tag;
    }

    @SuppressLint({"ExecutorRegistration"})
    public static final void addPoolingContainerListener(View r5, PoolingContainerListener r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "listener");
        getPoolingContainerListenerHolder(r5).addListener(r10);
    }

    public static final void callPoolingContainerOnRelease(View r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator<View> r10 = ViewKt.getAllViews(r5).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        getPoolingContainerListenerHolder(r10.next()).onRelease();
        goto L4
    }

    public static final void callPoolingContainerOnReleaseForChildren(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator<View> r10 = ViewGroupKt.getChildren(r5).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        getPoolingContainerListenerHolder(r10.next()).onRelease();
        goto L4
    }

    private static final PoolingContainerListenerHolder getPoolingContainerListenerHolder(View r5) {
        int r10 = PoolingContainerListenerHolderTag;
        PoolingContainerListenerHolder r11 = (PoolingContainerListenerHolder) r5.getTag(r10);
        if (r11 != null) goto L6;
        PoolingContainerListenerHolder r12 = new PoolingContainerListenerHolder();
        r5.setTag(r10, r12);
        return r12;
    L6:
        return r11;
    }

    public static final boolean isPoolingContainer(View r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Object r10 = r5.getTag(IsPoolingContainerTag);
        if ((r10 instanceof Boolean) == false) goto L5;
        Boolean r11 = (Boolean) r10;
    L6:
        if (r11 != null) goto L10;
        return false;
    L10:
        return r11.booleanValue();
    L5:
        r11 = null;
        goto L6
    }

    public static final boolean isWithinPoolingContainer(View r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator<ViewParent> r10 = ViewKt.getAncestors(r5).iterator();
    L4:
        if (r10.hasNext() == false) goto L11;
        Object r11 = (ViewParent) r10.next();
        if ((r11 instanceof View) == false) goto L4;
        if (isPoolingContainer((View) r11) == false) goto L4;
        return true;
    L11:
        return false;
    }

    @SuppressLint({"ExecutorRegistration"})
    public static final void removePoolingContainerListener(View r5, PoolingContainerListener r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "listener");
        getPoolingContainerListenerHolder(r5).removeListener(r10);
    }

    public static final void setPoolingContainer(View r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5.setTag(IsPoolingContainerTag, Boolean.valueOf(r10));
    }
}
