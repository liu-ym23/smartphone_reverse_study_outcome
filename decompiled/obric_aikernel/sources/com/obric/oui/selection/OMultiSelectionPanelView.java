package com.obric.oui.selection;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "This class has been deprecated. Please use OListItemGeneral instead. For usage examples, refer to the ListItemActivity class in the example.")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0001\fB%\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\r"}, d2 = {"Lcom/obric/oui/selection/OMultiSelectionPanelView;", "Lcom/obric/oui/selection/OSelectionPanelView;", "", "", "getSelectedItems", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "theme", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OMultiSelectionPanelView extends OSelectionPanelView {

    public interface a {
        void a(int r10);

        void b(List<OSelectionPanelItemView> r10, List<Integer> r11);
    }

    public OMultiSelectionPanelView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public void g() {
        if (getItemViews().size() <= 7) goto L5;
        float r10 = TypedValues.CycleType.TYPE_WAVE_OFFSET;
        Resources r11 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r11, "Resources.getSystem()");
        int r12 = MathKt.roundToInt(TypedValue.applyDimension(1, r10, r11.getDisplayMetrics()));
    L6:
        setScrollViewHeight(r12);
        return;
    L5:
        r12 = -2;
        goto L6
    }

    public final List<Integer> getSelectedItems() {
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = getItemViews().iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L12;
        Object r13 = r11.next();
        int r14 = r12 + 1;
        if (r12 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((OSelectionPanelItemView) r13).isItemSelected() == false) goto L11;
        r10.add(Integer.valueOf(r12));
    L11:
        r12 = r14;
        goto L4
    L12:
        return r10;
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    protected boolean h() {
        return true;
    }
}
