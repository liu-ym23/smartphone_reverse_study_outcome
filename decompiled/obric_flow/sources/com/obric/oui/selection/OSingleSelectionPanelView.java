package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import com.lynx.tasm.utils.a;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "This class has been deprecated. Please use OListItemGeneral instead. For usage examples, refer to the ListItemActivity class in the example.")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001:\u0001\fB%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/obric/oui/selection/OSingleSelectionPanelView;", "Lcom/obric/oui/selection/OSelectionPanelView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "theme", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getSelectedItem", "()I", "ds/d", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OSingleSelectionPanelView extends OSelectionPanelView {
    public OSingleSelectionPanelView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public final void a() {
        if (getContext().getResources().getConfiguration().orientation != 2) goto L9;
        if (getItemViews().size() <= 2) goto L7;
        setScrollViewHeight(a.B(112, this));
        return;
    L7:
        setScrollViewHeight(-2);
        return;
    L9:
        if (getItemViews().size() <= 7) goto L11;
        setScrollViewHeight(a.B(424, this));
        return;
    L11:
        setScrollViewHeight(-2);
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public final boolean b() {
        return false;
    }

    public final int getSelectedItem() {
        Iterator<T> r5 = getItemViews().iterator();
        int r10 = 0;
    L4:
        if (r5.hasNext() == false) goto L12;
        Object r11 = r5.next();
        int r12 = r10 + 1;
        if (r10 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((OSelectionPanelItemView) r11).e() == true) goto L10;
        r10 = r12;
        goto L4
    L10:
        return r10;
    L12:
        return -1;
    }
}
