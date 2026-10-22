package com.obric.oui.selection;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.f;
import u8.h;
import u8.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0003345B'\b\u0007\u0012\u0006\u0010-\u001a\u00020,\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u00100\u001a\u00020\u0007¢\u0006\u0004\b1\u00102J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R$\u0010+\u001a\u0004\u0018\u00010$8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00066"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelView;", "Landroid/widget/LinearLayout;", "", "Lcom/obric/oui/selection/OSelectionPanelView$c;", "items", "", "setItems", "", "height", "setScrollViewHeight", "Lcom/obric/oui/selection/OSelectionPanelView$b;", "loader", "setIconLoader", "Landroid/view/View;", "l", "Landroid/view/View;", "getBottomDivider", "()Landroid/view/View;", "setBottomDivider", "(Landroid/view/View;)V", "bottomDivider", "Lcom/obric/oui/selection/OSingleSelectionPanelView$a;", "o", "Lcom/obric/oui/selection/OSingleSelectionPanelView$a;", "getOnItemSelectListener", "()Lcom/obric/oui/selection/OSingleSelectionPanelView$a;", "setOnItemSelectListener", "(Lcom/obric/oui/selection/OSingleSelectionPanelView$a;)V", "onItemSelectListener", "", "Lcom/obric/oui/selection/OSelectionPanelItemView;", "n", "Ljava/util/List;", "getItemViews", "()Ljava/util/List;", "itemViews", "Lcom/obric/oui/selection/OMultiSelectionPanelView$a;", "p", "Lcom/obric/oui/selection/OMultiSelectionPanelView$a;", "getOnMultiItemSelectListener", "()Lcom/obric/oui/selection/OMultiSelectionPanelView$a;", "setOnMultiItemSelectListener", "(Lcom/obric/oui/selection/OMultiSelectionPanelView$a;)V", "onMultiItemSelectListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "theme", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class OSelectionPanelView extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7349c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LinearLayout f7350g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final FrameLayout f7351h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final NestedScrollView f7352i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private b f7353j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f7354k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f7355l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f7356m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final List<OSelectionPanelItemView> f7357n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private OSingleSelectionPanelView.a f7358o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private OMultiSelectionPanelView.a f7359p;

    public static final class a implements b {
        public a() {
        }

        @Override // com.obric.oui.selection.OSelectionPanelView.b
        public void a(ImageView r10, c r11, Context r12) {
            Intrinsics.checkNotNullParameter(r10, "iconImageView");
            Intrinsics.checkNotNullParameter(r11, "data");
            Intrinsics.checkNotNullParameter(r12, "context");
            r10.setImageDrawable(r11.a());
        }
    }

    public interface b {
        void a(ImageView r10, c r11, Context r12);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable f7360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f7361b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f7362c;

        public c() {
            this(null, null, null, 7, null);
        }

        public c(Drawable r10, String r11, String r12) {
            this.f7360a = r10;
            this.f7361b = r11;
            this.f7362c = r12;
        }

        public /* synthetic */ c(Drawable r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 1) == 0) goto L6;
            r10 = null;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r11 = null;
        L9:
            if ((r13 & 4) == 0) goto L11;
            r12 = null;
        L11:
            this(r10, r11, r12);
        }

        public final Drawable a() {
            return this.f7360a;
        }

        public final String b() {
            return this.f7362c;
        }

        public final String c() {
            return this.f7361b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof c) == false) goto L12;
            c r11 = (c) r10;
            if (Intrinsics.areEqual(this.f7360a, r11.f7360a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f7361b, r11.f7361b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f7362c, r11.f7362c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            Drawable r10 = this.f7360a;
            int r11 = 0;
            if (r10 == null) goto L5;
            int r12 = r10.hashCode();
        L6:
            int r13 = r12 * 31;
            String r14 = this.f7361b;
            if (r14 == null) goto L9;
            int r15 = r14.hashCode();
        L10:
            int r16 = (r13 + r15) * 31;
            String r17 = this.f7362c;
            if (r17 == null) goto L14;
            r11 = r17.hashCode();
        L14:
            return r16 + r11;
        L9:
            r15 = 0;
            goto L10
        L5:
            r12 = 0;
            goto L6
        }

        public String toString() {
            return "SelectionItemData(iconDrawable=" + this.f7360a + ", title=" + this.f7361b + ", iconUrl=" + this.f7362c + ")";
        }
    }

    static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OSelectionPanelItemView f7363c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f7364g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ OSelectionPanelView f7365h;

        d(OSelectionPanelItemView r10, c r11, int r12, OSelectionPanelView r13) {
            this.f7363c = r10;
            this.f7364g = r12;
            this.f7365h = r13;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            if (this.f7365h.h() == false) goto L8;
            OSelectionPanelItemView r11 = this.f7363c;
            r11.setItemSelected(!r11.isItemSelected());
            OSelectionPanelView.c(this.f7365h);
            if (this.f7363c.isItemSelected() == false) goto L16;
            OSelectionPanelView.a(this.f7365h, this.f7364g);
            return;
        L16:
            return;
        L8:
            if (this.f7363c.isItemSelected() == true) goto L13;
            Iterator<T> r12 = this.f7365h.getItemViews().iterator();
        L11:
            if (r12.hasNext() == false) goto L13;
            OSelectionPanelItemView r13 = (OSelectionPanelItemView) r12.next();
            r13.setItemSelected(Intrinsics.areEqual(r10, r13));
        L13:
            OSelectionPanelView.b(this.f7365h);
        }
    }

    @JvmOverloads
    public OSelectionPanelView(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OSelectionPanelView(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OSelectionPanelView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(new ContextThemeWrapper(r10, r12), r11);
        this.f7349c = true;
        this.f7353j = new a();
        this.f7354k = true;
        this.f7357n = new ArrayList();
        LinearLayout.inflate(getContext(), h.o_view_selection_panel, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setOrientation(1);
        View r13 = findViewById(f.item_container);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.item_container)");
        this.f7350g = (LinearLayout) r13;
        View r14 = findViewById(f.btn_container);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.btn_container)");
        this.f7351h = (FrameLayout) r14;
        View r15 = findViewById(f.item_scroll_view);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.item_scroll_view)");
        this.f7352i = (NestedScrollView) r15;
        View r16 = findViewById(f.root_constraint);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.root_constraint)");
        ConstraintLayout r17 = (ConstraintLayout) r16;
        View r18 = findViewById(f.bottom_divider);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.bottom_divider)");
        this.f7355l = r18;
    }

    public /* synthetic */ OSelectionPanelView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = k.OSelectionPanel;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ void a(OSelectionPanelView r10, int r11) {
        r10.d(r11);
    }

    public static final /* synthetic */ void b(OSelectionPanelView r10) {
        r10.e();
    }

    public static final /* synthetic */ void c(OSelectionPanelView r10) {
        r10.f();
    }

    private final void d(int r10) {
        OMultiSelectionPanelView.a r11 = this.f7359p;
        if (r11 == null) goto L6;
        r11.a(r10);
        return;
    }

    private final void e() {
        if (h() == false) goto L5;
        return;
    L5:
        if (this.f7358o == null) goto L23;
        int r10 = 0;
        Iterator<T> r11 = this.f7357n.iterator();
    L8:
        if (r11.hasNext() == false) goto L24;
        Object r12 = r11.next();
        int r13 = r10 + 1;
        if (r10 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        OSelectionPanelItemView r14 = (OSelectionPanelItemView) r12;
        if (r14.isItemSelected() == true) goto L14;
        r10 = r13;
        goto L8
    L14:
        OSingleSelectionPanelView.a r15 = this.f7358o;
        if (r15 == null) goto L22;
        r15.a(r14, r10);
        return;
    L22:
        return;
    L24:
        return;
    }

    private final void f() {
        if (h() == true) goto L5;
        return;
    L5:
        if (this.f7359p == null) goto L24;
        ArrayList r10 = new ArrayList();
        ArrayList r11 = new ArrayList();
        int r12 = 0;
        Iterator<T> r13 = this.f7357n.iterator();
    L8:
        if (r13.hasNext() == false) goto L16;
        Object r14 = r13.next();
        int r15 = r12 + 1;
        if (r12 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        OSelectionPanelItemView r16 = (OSelectionPanelItemView) r14;
        if (r16.isItemSelected() == false) goto L15;
        r10.add(r16);
        r11.add(Integer.valueOf(r12));
    L15:
        r12 = r15;
        goto L8
    L16:
        OMultiSelectionPanelView.a r17 = this.f7359p;
        if (r17 == null) goto L25;
        r17.b(r10, r11);
        return;
    L25:
        return;
    }

    public abstract void g();

    public final View getBottomDivider() {
        View r10 = this.f7355l;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomDivider");
    L5:
        return r10;
    }

    protected final List<OSelectionPanelItemView> getItemViews() {
        return this.f7357n;
    }

    protected final OSingleSelectionPanelView.a getOnItemSelectListener() {
        return this.f7358o;
    }

    protected final OMultiSelectionPanelView.a getOnMultiItemSelectListener() {
        return this.f7359p;
    }

    protected abstract boolean h();

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    public final void setBottomDivider(View r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7355l = r10;
    }

    public final void setIconLoader(b r10) {
        Intrinsics.checkNotNullParameter(r10, "loader");
        this.f7353j = r10;
    }

    public final void setItems(List<c> r14) {
        Intrinsics.checkNotNullParameter(r14, "items");
        Iterator<T> r15 = r14.iterator();
        int r10 = 0;
    L4:
        if (r15.hasNext() == false) goto L15;
        Object r11 = r15.next();
        int r12 = r10 + 1;
        if (r10 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        c r13 = (c) r11;
        List<OSelectionPanelItemView> r16 = this.f7357n;
        Context r17 = getContext();
        Intrinsics.checkNotNullExpressionValue(r17, "context");
        OSelectionPanelItemView r18 = new OSelectionPanelItemView(r17, null, false, this.f7356m, 6, null);
        r18.setSelectMode(h());
        r18.showSelectLabel(this.f7349c);
        if (r13.a() == null) goto L11;
    L13:
        com.obric.oui.common.util.k.h(r18.getIconView());
        b r19 = this.f7353j;
        ImageView r20 = r18.getIconView();
        Context r21 = r18.getContext();
        Intrinsics.checkNotNullExpressionValue(r21, "context");
        r19.a(r20, r13, r21);
    L14:
        r18.getTextView().setText(r13.c());
        r18.setOnClickListener(new d(r18, r13, r10, this));
        this.f7350g.addView(r18);
        Unit r22 = Unit.INSTANCE;
        r16.add(r18);
        r10 = r12;
        goto L4
    L11:
        if (TextUtils.isEmpty(r13.b()) == false) goto L13;
        com.obric.oui.common.util.k.f(r18.getIconView());
        goto L14
    L15:
        ((OSelectionPanelItemView) CollectionsKt.last(this.f7357n)).dismissDivider();
        g();
    }

    protected final void setOnItemSelectListener(OSingleSelectionPanelView.a r10) {
        this.f7358o = r10;
    }

    protected final void setOnMultiItemSelectListener(OMultiSelectionPanelView.a r10) {
        this.f7359p = r10;
    }

    public final void setScrollViewHeight(int r10) {
        ConstraintLayout.LayoutParams r11 = new ConstraintLayout.LayoutParams(-1, r10);
        if (this.f7357n.size() < 4) goto L5;
    L7:
        this.f7352i.setLayoutParams(r11);
        return;
    L5:
        if (this.f7354k == false) goto L7;
        ConstraintLayout.LayoutParams r12 = new ConstraintLayout.LayoutParams(-1, -2);
        r12.topToBottom = -1;
        r12.bottomToBottom = 0;
        this.f7351h.setLayoutParams(r12);
        r11.bottomToTop = -1;
        goto L7
    }
}
