package com.obric.oui.selection;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "This class has been deprecated. Please use OListItemGeneral instead. For usage examples, refer to the ListItemActivity class in the example.")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0001\u000bB%\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/obric/oui/selection/OSingleSelectionPanelView;", "Lcom/obric/oui/selection/OSelectionPanelView;", "", "getSelectedItem", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "theme", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OSingleSelectionPanelView extends OSelectionPanelView {

    public interface a {
        void a(OSelectionPanelItemView r10, int r11);
    }

    public OSingleSelectionPanelView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public void g() {
        Context r10 = getContext();
        Intrinsics.checkNotNullExpressionValue(r10, "context");
        Resources r11 = r10.getResources();
        Intrinsics.checkNotNullExpressionValue(r11, "context.resources");
        if (r11.getConfiguration().orientation != 2) goto L5;
        boolean r12 = true;
    L7:
        if (r12 == true) goto L12;
        if (getItemViews().size() <= 7) goto L15;
        int r13 = TypedValues.CycleType.TYPE_WAVE_OFFSET;
    L14:
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        setScrollViewHeight(MathKt.roundToInt(TypedValue.applyDimension(1, r13, r14.getDisplayMetrics())));
        return;
    L15:
        setScrollViewHeight(-2);
        return;
    L12:
        if (getItemViews().size() <= 2) goto L15;
        r13 = 112;
        goto L14
    L5:
        r12 = false;
        goto L7
    }

    public final int getSelectedItem() {
        Iterator<T> r10 = getItemViews().iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L12;
        Object r12 = r10.next();
        int r13 = r11 + 1;
        if (r11 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((OSelectionPanelItemView) r12).isItemSelected() == true) goto L10;
        r11 = r13;
        goto L4
    L10:
        return r11;
    L12:
        return -1;
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    protected boolean h() {
        return false;
    }
}
