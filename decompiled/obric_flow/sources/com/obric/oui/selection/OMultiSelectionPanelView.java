package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import com.lynx.tasm.utils.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "This class has been deprecated. Please use OListItemGeneral instead. For usage examples, refer to the ListItemActivity class in the example.")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001:\u0001\rB%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/selection/OMultiSelectionPanelView;", "Lcom/obric/oui/selection/OSelectionPanelView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "theme", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "getSelectedItems", "()Ljava/util/List;", "ds/a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OMultiSelectionPanelView extends OSelectionPanelView {
    public OMultiSelectionPanelView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public final void a() {
        if (getItemViews().size() <= 7) goto L5;
        setScrollViewHeight(a.B(424, this));
        return;
    L5:
        setScrollViewHeight(-2);
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public final boolean b() {
        return true;
    }

    public final List<Integer> getSelectedItems() {
        ArrayList r5 = new ArrayList();
        Iterator<T> r10 = getItemViews().iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L12;
        Object r12 = r10.next();
        int r13 = r11 + 1;
        if (r11 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((OSelectionPanelItemView) r12).e() == false) goto L11;
        r5.add(Integer.valueOf(r11));
    L11:
        r11 = r13;
        goto L4
    L12:
        return r5;
    }
}
