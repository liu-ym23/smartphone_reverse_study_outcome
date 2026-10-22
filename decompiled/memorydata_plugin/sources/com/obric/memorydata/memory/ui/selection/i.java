package com.obric.memorydata.memory.ui.selection;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.memory.ui.selection.SelectionPanelItemView;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010R\u0013\u0010\u0005\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/ui/selection/SelectionViewHolder;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/obric/memorydata/memory/ui/selection/SelectionPanelItemView;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemPanelView", "<init>", "(Lcom/obric/memorydata/memory/ui/selection/SelectionPanelItemView;)V", "getItemPanelView", "()Lcom/obric/memorydata/memory/ui/selection/SelectionPanelItemView;", "Lcom/obric/memorydata/memory/ui/selection/SelectionPanelItemView;", "bind", "", "item", "isMultiSelect", "", "(Ljava/lang/Object;Z)V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i<T, V extends SelectionPanelItemView<T>> extends RecyclerView.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final V f11399a;

    public i(V r3) {
        Intrinsics.checkNotNullParameter(r3, "itemPanelView");
        super((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
        this.f11399a = r3;
    }

    public final V a() {
        return this.f11399a;
    }

    public final void a(T r2, boolean r3) {
        this.f11399a.b(r2);
        this.f11399a.setSelectMode(r3);
    }
}
