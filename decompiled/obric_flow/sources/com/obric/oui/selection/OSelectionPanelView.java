package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$style;
import ds.a;
import ds.b;
import ds.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010%\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R$\u0010'\u001a\u0004\u0018\u00010&8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010.\u001a\u0004\u0018\u00010-8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00064"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "theme", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "", "items", "", "setItems", "(Ljava/util/List;)V", "height", "setScrollViewHeight", "(I)V", "Lds/b;", "loader", "setIconLoader", "(Lds/b;)V", "Landroid/view/View;", "e", "Landroid/view/View;", "getBottomDivider", "()Landroid/view/View;", "setBottomDivider", "(Landroid/view/View;)V", "bottomDivider", "", "Lcom/obric/oui/selection/OSelectionPanelItemView;", "f", "Ljava/util/List;", "getItemViews", "()Ljava/util/List;", "itemViews", "Lds/d;", "onItemSelectListener", "Lds/d;", "getOnItemSelectListener", "()Lds/d;", "setOnItemSelectListener", "(Lds/d;)V", "Lds/a;", "onMultiItemSelectListener", "Lds/a;", "getOnMultiItemSelectListener", "()Lds/a;", "setOnMultiItemSelectListener", "(Lds/a;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OSelectionPanelView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f14392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f14393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NestedScrollView f14394c;
    public final boolean d;
    public View e;
    public final ArrayList f;

    @JvmOverloads
    public OSelectionPanelView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public abstract void a();

    public abstract boolean b();

    public final View getBottomDivider() {
        View r5 = this.e;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("bottomDivider");
        return null;
    }

    public final List<OSelectionPanelItemView> getItemViews() {
        return this.f;
    }

    public final d getOnItemSelectListener() {
        return null;
    }

    public final a getOnMultiItemSelectListener() {
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
    }

    public final void setBottomDivider(View r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.e = r5;
    }

    public final void setIconLoader(b r5) {
        Intrinsics.checkNotNullParameter(r5, "loader");
    }

    public final void setItems(List<Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "items");
        Iterator<T> r10 = r5.iterator();
        if (r10.hasNext() == true) goto L5;
        com.lynx.tasm.utils.d.s(((OSelectionPanelItemView) CollectionsKt.last(this.f)).f14389t);
        a();
        return;
    L5:
        if (r10.next() != null) goto L12;
        getItemViews();
        OSelectionPanelItemView r11 = new OSelectionPanelItemView(getContext(), null, 6);
        r11.setSelectMode(b());
        boolean r12 = this.f14392a;
        r11.f14390u = r12;
        if (r12 == false) goto L9;
        r11.setSelectMode(r11.f14384n);
        throw null;
    L9:
        com.lynx.tasm.utils.d.s(r11.s);
        com.lynx.tasm.utils.d.s(r11.f14388r);
        throw null;
    L12:
        throw new ClassCastException();
    }

    public final void setOnItemSelectListener(d r5) {
    }

    public final void setOnMultiItemSelectListener(a r5) {
    }

    public final void setScrollViewHeight(int r5) {
        ConstraintLayout.LayoutParams r10 = new ConstraintLayout.LayoutParams(-1, r5);
        if (this.f.size() < 4) goto L5;
    L7:
        this.f14394c.setLayoutParams(r10);
        return;
    L5:
        if (this.d == false) goto L7;
        ConstraintLayout.LayoutParams r11 = new ConstraintLayout.LayoutParams(-1, -2);
        r11.topToBottom = -1;
        r11.bottomToBottom = 0;
        this.f14393b.setLayoutParams(r11);
        r10.bottomToTop = -1;
        goto L7
    }

    @JvmOverloads
    public OSelectionPanelView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OSelectionPanelView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, R$style.OSelectionPanel);
    }

    @JvmOverloads
    public OSelectionPanelView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(new ContextThemeWrapper(r5, r11), r10);
        this.f14392a = true;
        this.d = true;
        this.f = new ArrayList();
        View.inflate(getContext(), R$layout.o_view_selection_panel, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setOrientation(1);
        LinearLayout r12 = (LinearLayout) findViewById(R$id.item_container);
        this.f14393b = (FrameLayout) findViewById(R$id.btn_container);
        this.f14394c = (NestedScrollView) findViewById(R$id.item_scroll_view);
        ConstraintLayout r13 = (ConstraintLayout) findViewById(R$id.root_constraint);
        setBottomDivider(findViewById(R$id.bottom_divider));
    }
}
