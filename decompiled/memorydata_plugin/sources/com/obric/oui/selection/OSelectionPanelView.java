package com.obric.oui.selection;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001:\u0003WXYB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\f2\n\b\u0002\u00100\u001a\u0004\u0018\u000101J\u0010\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020\u0007H\u0002J\b\u00104\u001a\u00020.H\u0002J\b\u00105\u001a\u00020.H\u0002J\u0010\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0002J\b\u00108\u001a\u00020.H&J\b\u00109\u001a\u00020\nH$J\u000e\u0010:\u001a\u00020.2\u0006\u0010;\u001a\u00020\nJ0\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007H\u0014J\u0018\u0010B\u001a\u00020.2\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0014J\u0006\u0010E\u001a\u00020.J\u0010\u0010F\u001a\u00020.2\u0006\u00103\u001a\u00020\u0007H&J\u000e\u0010G\u001a\u00020.2\u0006\u0010H\u001a\u00020\u0014J.\u0010I\u001a\u00020.2\b\b\u0002\u0010J\u001a\u00020\u00072\b\b\u0002\u0010K\u001a\u00020\u00072\b\b\u0002\u0010L\u001a\u00020\u00072\b\b\u0002\u0010M\u001a\u00020\u0007J\u0014\u0010N\u001a\u00020.2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020Q0PJ\u000e\u0010R\u001a\u00020.2\u0006\u0010S\u001a\u00020\u0007J\u000e\u0010T\u001a\u00020.2\u0006\u0010U\u001a\u00020\nJ\u000e\u0010V\u001a\u00020.2\u0006\u0010U\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "theme", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allowDividersShow", "", "bottomDivider", "Landroid/view/View;", "getBottomDivider", "()Landroid/view/View;", "setBottomDivider", "(Landroid/view/View;)V", "btnContainer", "Landroid/widget/FrameLayout;", "iconLoader", "Lcom/obric/oui/selection/OSelectionPanelView$IIconLoader;", "itemContainer", "itemScrollView", "Landroidx/core/widget/NestedScrollView;", "itemViews", "", "Lcom/obric/oui/selection/OSelectionPanelItemView;", "getItemViews", "()Ljava/util/List;", "onItemSelectListener", "Lcom/obric/oui/selection/OSingleSelectionPanelView$OnItemSelectListener;", "getOnItemSelectListener", "()Lcom/obric/oui/selection/OSingleSelectionPanelView$OnItemSelectListener;", "setOnItemSelectListener", "(Lcom/obric/oui/selection/OSingleSelectionPanelView$OnItemSelectListener;)V", "onMultiItemSelectListener", "Lcom/obric/oui/selection/OMultiSelectionPanelView$OnMultiItemSelectListener;", "getOnMultiItemSelectListener", "()Lcom/obric/oui/selection/OMultiSelectionPanelView$OnMultiItemSelectListener;", "setOnMultiItemSelectListener", "(Lcom/obric/oui/selection/OMultiSelectionPanelView$OnMultiItemSelectListener;)V", "rootConstraintView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "showSelectLabel", "supportForMinHeight", "addBtnView", "", "view", TrackerImpl.PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "callConcreteItemSelected", "index", "callItemSelectListener", "callMultiItemSelectListener", "dpToPx", "dp", "initHeight", "isMultiSelect", "needShowSelectLabel", "show", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "removeMinHeightConstraint", "select", "setIconLoader", "loader", "setItemMargin", "left", "top", "right", "bottom", "setItems", "items", "", "Lcom/obric/oui/selection/OSelectionPanelView$SelectionItemData;", "setScrollViewHeight", "height", "showBottomDivider", "allowShow", "showDividers", "DrawableIconLoader", "IIconLoader", "SelectionItemData", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OSelectionPanelView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f14447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f14448b;
    private final LinearLayout c;
    private final FrameLayout d;
    private final NestedScrollView e;
    private final ConstraintLayout f;
    private b g;
    private boolean h;
    private boolean i;
    private final List<OSelectionPanelItemView> j;
    private OSingleSelectionPanelView.a k;
    private OMultiSelectionPanelView.a l;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelView$DrawableIconLoader;", "Lcom/obric/oui/selection/OSelectionPanelView$IIconLoader;", "()V", "loadIcon", "", "iconImageView", "Landroid/widget/ImageView;", "data", "Lcom/obric/oui/selection/OSelectionPanelView$SelectionItemData;", "context", "Landroid/content/Context;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements b {
        public a() {
        }

        @Override // com.obric.oui.selection.OSelectionPanelView.b
        public void a(ImageView r2, c r3, Context r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "iconImageView");
            Intrinsics.checkNotNullParameter(r3, "data");
            Intrinsics.checkNotNullParameter(r1, "context");
            r2.setImageDrawable(r3.a());
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelView$IIconLoader;", "", "loadIcon", "", "iconImageView", "Landroid/widget/ImageView;", "data", "Lcom/obric/oui/selection/OSelectionPanelView$SelectionItemData;", "context", "Landroid/content/Context;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface b {
        void a(ImageView r1, c r2, Context r3);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelView$SelectionItemData;", "", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "title", "", "iconUrl", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;)V", "getIconDrawable", "()Landroid/graphics/drawable/Drawable;", "getIconUrl", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable f14449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14450b;
        private final String c;

        public c() {
            this(null, null, null, 7, null);
        }

        public c(Drawable r1, String r2, String r3) {
            this.f14449a = r1;
            this.f14450b = r2;
            this.c = r3;
        }

        public /* synthetic */ c(Drawable r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = null;
        L11:
            this(r2, r3, r4);
        }

        public final Drawable a() {
            return this.f14449a;
        }

        public final String b() {
            return this.f14450b;
        }

        public final String c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f14449a, r6.f14449a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f14450b, r6.f14450b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            Drawable r0 = this.f14449a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f14450b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "SelectionItemData(iconDrawable=" + this.f14449a + ", title=" + this.f14450b + ", iconUrl=" + this.c + ')';
        }
    }

    public OSelectionPanelView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OSelectionPanelView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OSelectionPanelView(Context r4, AttributeSet r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        super((Context) ZeusTransformUtils.preCheckCast(new ContextThemeWrapper(r7, r6), Context.class, "com.obric.memorydata.plugin"), r8);
        this.f14448b = true;
        this.g = (b) ZeusTransformUtils.preCheckCast(new a(), b.class, "com.obric.memorydata.plugin");
        this.h = true;
        this.j = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        LinearLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.o_view_selection_panel, "layout", "o_view_selection_panel"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        setOrientation(1);
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.item_container, OaidModel.KEY_ID, "item_container"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.item_container)");
        this.c = (LinearLayout) ZeusTransformUtils.preCheckCast(r9, LinearLayout.class, "com.obric.memorydata.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_container, OaidModel.KEY_ID, "btn_container"));
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.btn_container)");
        this.d = (FrameLayout) ZeusTransformUtils.preCheckCast(r10, FrameLayout.class, "com.obric.memorydata.plugin");
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.item_scroll_view, OaidModel.KEY_ID, "item_scroll_view"));
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.item_scroll_view)");
        this.e = (NestedScrollView) ZeusTransformUtils.preCheckCast(r11, NestedScrollView.class, "com.obric.memorydata.plugin");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.root_constraint, OaidModel.KEY_ID, "root_constraint"));
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.root_constraint)");
        this.f = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r12, ConstraintLayout.class, "com.obric.memorydata.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.bottom_divider, OaidModel.KEY_ID, "bottom_divider"));
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.bottom_divider)");
        setBottomDivider(r13);
    }

    public /* synthetic */ OSelectionPanelView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = ZeusTransformUtils.mapRes(R.style.OSelectionPanel, "style", "OSelectionPanel");
    L8:
        this(r7, r8, r4);
    }

    private final void a(int r1) {
        OMultiSelectionPanelView.a r0 = this.l;
        if (r0 == null) goto L7;
        r0.a(r1);
        return;
    }

    private static final void a(OSelectionPanelView r2, OSelectionPanelItemView r3, int r4, View r5) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$this_apply");
        if (r2.a() == false) goto L8;
        r3.setItemSelected(!r3.isItemSelected());
        r2.d();
        if (r3.isItemSelected() == false) goto L16;
        r2.a(r4);
        return;
    L16:
        return;
    L8:
        if (r3.isItemSelected() == true) goto L13;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r2.j, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        OSelectionPanelItemView r7 = (OSelectionPanelItemView) ZeusTransformUtils.preCheckCast(r6.next(), OSelectionPanelItemView.class, "com.obric.memorydata.plugin");
        r7.setItemSelected(Intrinsics.areEqual(r5, r7));
    L13:
        r2.c();
    }

    private final void c() {
        if (a() == false) goto L5;
        return;
    L5:
        if (this.k == null) goto L24;
        int r1 = 0;
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.j, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r0.hasNext() == false) goto L25;
        Object r3 = r0.next();
        int r4 = r1 + 1;
        if (r1 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        OSelectionPanelItemView r5 = (OSelectionPanelItemView) ZeusTransformUtils.preCheckCast(r3, OSelectionPanelItemView.class, "com.obric.memorydata.plugin");
        if (r5.isItemSelected() == true) goto L14;
        r1 = r4;
        goto L8
    L14:
        OSingleSelectionPanelView.a r6 = getOnItemSelectListener();
        if (r6 == null) goto L23;
        r6.a(r5, r1);
        return;
    L23:
        return;
    L25:
        return;
    }

    private final void d() {
        if (a() == true) goto L5;
        return;
    L5:
        if (this.l == null) goto L25;
        List<OSelectionPanelItemView> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<Integer> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r4 = 0;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.j, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r3.hasNext() == false) goto L16;
        Object r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        OSelectionPanelItemView r7 = (OSelectionPanelItemView) ZeusTransformUtils.preCheckCast(r5, OSelectionPanelItemView.class, "com.obric.memorydata.plugin");
        if (r7.isItemSelected() == false) goto L15;
        r0.add(r7);
        r1.add(Integer.valueOf(r4));
    L15:
        r4 = r6;
        goto L8
    L16:
        OMultiSelectionPanelView.a r8 = this.l;
        if (r8 == null) goto L26;
        r8.a(r0, r1);
        return;
    L26:
        return;
    }

    public static /* synthetic */ void lambda$Ls0weN5DyoUTYsVFOOUPegrrAtw(OSelectionPanelView r0, OSelectionPanelItemView r1, int r2, View r3) {
        a(r0, r1, r2, r3);
    }

    public abstract boolean a();

    public abstract void b();

    public final View getBottomDivider() {
        View r0 = this.f14447a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("bottomDivider");
        return null;
    }

    public final List<OSelectionPanelItemView> getItemViews() {
        return this.j;
    }

    public final OSingleSelectionPanelView.a getOnItemSelectListener() {
        return this.k;
    }

    public final OMultiSelectionPanelView.a getOnMultiItemSelectListener() {
        return this.l;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public final void setBottomDivider(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f14447a = r2;
    }

    public final void setIconLoader(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "loader");
        this.g = r4;
    }

    public final void setItems(List<c> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "items");
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        final int r0 = 0;
    L4:
        if (r17.hasNext() == false) goto L15;
        Object r2 = r17.next();
        int r3 = r0 + 1;
        if (r0 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        c r4 = (c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.memorydata.plugin");
        List<OSelectionPanelItemView> r5 = getItemViews();
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r6, "context");
        final OSelectionPanelItemView r12 = new OSelectionPanelItemView(r6, null, false, this.i, 6, null);
        r12.setSelectMode(a());
        r12.showSelectLabel(this.f14448b);
        if (r4.a() == null) goto L11;
    L13:
        o.a((View) ZeusTransformUtils.preCheckCast(r12.getIconView(), View.class, "com.obric.memorydata.plugin"));
        b r7 = this.g;
        ImageView r8 = r12.getIconView();
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r9, "context");
        r7.a(r8, r4, r9);
    L14:
        r12.getTextView().setText((CharSequence) ZeusTransformUtils.preCheckCast(r4.b(), CharSequence.class, "com.obric.memorydata.plugin"));
        r12.setOnClickListener(new $$Lambda$OSelectionPanelView$Ls0weN5DyoUTYsVFOOUPegrrAtw(this, r12, r0));
        this.c.addView((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin"));
        r5.add(r12);
        r0 = r3;
        goto L4
    L11:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r4.c(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L13;
        o.b((View) ZeusTransformUtils.preCheckCast(r12.getIconView(), View.class, "com.obric.memorydata.plugin"));
        goto L14
    L15:
        ((OSelectionPanelItemView) ZeusTransformUtils.preCheckCast(CollectionsKt.last(this.j), OSelectionPanelItemView.class, "com.obric.memorydata.plugin")).dismissDivider();
        b();
    }

    public final void setOnItemSelectListener(OSingleSelectionPanelView.a r3) {
        this.k = (OSingleSelectionPanelView.a) ZeusTransformUtils.wrapperContextForParams(r3, OSingleSelectionPanelView.a.class, "com.obric.memorydata.plugin");
    }

    public final void setOnMultiItemSelectListener(OMultiSelectionPanelView.a r3) {
        this.l = (OMultiSelectionPanelView.a) ZeusTransformUtils.wrapperContextForParams(r3, OMultiSelectionPanelView.a.class, "com.obric.memorydata.plugin");
    }

    public final void setScrollViewHeight(int r6) {
        ConstraintLayout.LayoutParams r0 = new ConstraintLayout.LayoutParams(-1, r6);
        if (this.j.size() < 4) goto L5;
    L7:
        this.e.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        if (this.h == false) goto L7;
        ConstraintLayout.LayoutParams r7 = new ConstraintLayout.LayoutParams(-1, -2);
        r7.topToBottom = -1;
        r7.bottomToBottom = 0;
        this.d.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r0.bottomToTop = -1;
        goto L7
    }
}
