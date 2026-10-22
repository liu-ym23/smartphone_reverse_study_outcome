package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "This class has been deprecated. Please use OListItemGeneral instead. For usage examples, refer to the ListItemActivity class in the example.")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001:\u0001\u0014B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0014J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/selection/OMultiSelectionPanelView;", "Lcom/obric/oui/selection/OSelectionPanelView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "theme", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getSelectedItems", "", "initHeight", "", "isMultiSelect", "", "registerMultiItemSelectListener", "listener", "Lcom/obric/oui/selection/OMultiSelectionPanelView$OnMultiItemSelectListener;", "select", "index", "OnMultiItemSelectListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OMultiSelectionPanelView extends OSelectionPanelView {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/selection/OMultiSelectionPanelView$OnMultiItemSelectListener;", "", "onConcreteItemSelected", "", "position", "", "onItemsSelected", "views", "", "Lcom/obric/oui/selection/OSelectionPanelItemView;", "positions", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface a {
        void a(int r1);

        void a(List<OSelectionPanelItemView> r1, List<Integer> r2);
    }

    public OMultiSelectionPanelView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public boolean a() {
        return true;
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public void b() {
        if (getItemViews().size() <= 7) goto L5;
        int r0 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 424);
    L6:
        setScrollViewHeight(r0);
        return;
    L5:
        r0 = -2;
        goto L6
    }

    public final List<Integer> getSelectedItems() {
        List<Integer> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(getItemViews(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r1 = 0;
    L4:
        if (r6.hasNext() == false) goto L12;
        Object r3 = r6.next();
        int r4 = r1 + 1;
        if (r1 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((OSelectionPanelItemView) ZeusTransformUtils.preCheckCast(r3, OSelectionPanelItemView.class, "com.obric.memorydata.plugin")).isItemSelected() == false) goto L11;
        r0.add(Integer.valueOf(r1));
    L11:
        r1 = r4;
        goto L4
    L12:
        return r0;
    }
}
