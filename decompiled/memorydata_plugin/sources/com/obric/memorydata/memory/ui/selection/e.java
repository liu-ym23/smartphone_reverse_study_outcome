package com.obric.memorydata.memory.ui.selection;

import android.content.Context;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.ui.selection.SelectionPanelItemView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&Jp\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000626\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00028\u00010\u00142\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\u00142\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0080\u0001\u0010\u001d\u001a\u00020\u000e2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000626\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00028\u00010\u00142\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010 H&J\b\u0010!\u001a\u00020\u000eH&J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0017\u0010#\u001a\u0004\u0018\u00018\u00012\u0006\u0010$\u001a\u00020\nH&¢\u0006\u0002\u0010%R\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006&"}, d2 = {"Lcom/obric/memorydata/memory/ui/selection/SelectionContainer;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/obric/memorydata/memory/ui/selection/SelectionPanelItemView;", "", "itemViews", "", "getItemViews", "()Ljava/util/List;", "itemCount", "", "getItemCount", "()I", "attach", "", "parent", "Landroid/view/ViewGroup;", "setItems", "items", "itemFactory", "Lkotlin/Function2;", "Landroid/content/Context;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "context", "item", "onItemClick", "isMultiSelect", "", "updateItems", "newItems", "diffCallback", "Lcom/obric/memorydata/memory/ui/selection/SelectionDiffCallback;", "clearItems", "updateSelectMode", "getItemViewAt", "index", "(I)Lcom/obric/memorydata/memory/ui/selection/SelectionPanelItemView;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface e<T, V extends SelectionPanelItemView<T>> {
    List<V> a();

    void a(ViewGroup r1);

    void a(List<? extends T> r1, Function2<? super Context, ? super T, ? extends V> r2, Function2<? super V, ? super Integer, Unit> r3, boolean r4);

    void a(List<? extends T> r1, Function2<? super Context, ? super T, ? extends V> r2, Function2<? super V, ? super Integer, Unit> r3, boolean r4, f<T> r5);

    void a(boolean r1);

    int b();
}
