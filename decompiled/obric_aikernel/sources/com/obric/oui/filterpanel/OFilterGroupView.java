package com.obric.oui.filterpanel;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.oui.filter.OFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.h;
import u8.j;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0004HIJKB\u001d\b\u0007\u0012\u0006\u0010C\u001a\u00020B\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D¢\u0006\u0004\bF\u0010GJ \u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\f\u001a\u00020\u000bJ(\u0010\u000e\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0002J\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0018J\u000e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u001aJ\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001dJ\u000e\u0010#\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0007J\u000e\u0010#\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0013R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010+R\u0016\u0010,\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+R\u0019\u0010.\u001a\u00020-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010&R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u0003038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00106\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010+R\u0018\u00109\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010*R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0003038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00105R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0013038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00105R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010?\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u00105¨\u0006L"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterGroupView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "", "items", "", "columnCount", "", "addFilterItems", "title", "setTitle", "Landroid/widget/TextView;", "getTitle", "initRowCount", "setFilterItems", CommonConsts.COUNT_TYPE, "setMaxSelectCount", "getMaxSelectCount", "getSelectedIndexes", "Lcom/obric/oui/filter/OFilter;", "getSelectedFilters", "Lcom/obric/oui/filterpanel/OFilterGroupView$e;", "listener", "registerFilterSelectedListener", "Lcom/obric/oui/filterpanel/OFilterGroupView$d;", "registerFilterDataChangeListener", "Lcom/obric/oui/filterpanel/OFilterGroupView$c;", "registerFilterClickedListener", "style", "", "isAlwaysLight", "setFilterStyle", "enableClickWhenSelected", "setEnableClickWhenSelected", "index", "select", "unSelectAll", "filter", "Z", "onFilterSelectedListener", "Lcom/obric/oui/filterpanel/OFilterGroupView$e;", "tvTitle", "Landroid/widget/TextView;", "I", "filterStyle", "Landroid/widget/GridLayout;", "gridLayout", "Landroid/widget/GridLayout;", "getGridLayout", "()Landroid/widget/GridLayout;", "showingMore", "", "moreFiltersList", "Ljava/util/List;", "onFilterClickedListener", "Lcom/obric/oui/filterpanel/OFilterGroupView$c;", "maxSelectCount", "tvShowMore", "lessFiltersList", "filtersList", "", "TAG", "Ljava/lang/String;", "onFilterDataChangeListener", "Lcom/obric/oui/filterpanel/OFilterGroupView$d;", "curFiltersList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "b", "c", "d", "e", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OFilterGroupView extends ConstraintLayout {
    private final String TAG;
    private int columnCount;
    private List<? extends CharSequence> curFiltersList;
    private boolean enableClickWhenSelected;
    private int filterStyle;
    private final List<OFilter> filtersList;
    private final GridLayout gridLayout;
    private final List<CharSequence> lessFiltersList;
    private int maxSelectCount;
    private final List<CharSequence> moreFiltersList;
    private c onFilterClickedListener;
    private d onFilterDataChangeListener;
    private e onFilterSelectedListener;
    private boolean showingMore;
    private final TextView tvShowMore;
    private final TextView tvTitle;

    static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OFilterGroupView f6541c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f6542g;

        a(OFilterGroupView r10, Context r11) {
            this.f6541c = r10;
            this.f6542g = r11;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            this.f6541c.getGridLayout().removeAllViews();
            if (OFilterGroupView.access$getShowingMore$p(this.f6541c) == false) goto L8;
            TextView r11 = OFilterGroupView.access$getTvShowMore$p(this.f6541c);
            if (r11 == null) goto L7;
            r11.setText(this.f6542g.getResources().getString(j.oui_show_more));
        L7:
            OFilterGroupView r12 = this.f6541c;
            OFilterGroupView.access$addFilterItems(r12, OFilterGroupView.access$getLessFiltersList$p(r12), OFilterGroupView.access$getColumnCount$p(this.f6541c));
            OFilterGroupView r13 = this.f6541c;
            boolean r14 = false;
        L12:
            OFilterGroupView.access$setShowingMore$p(r13, r14);
            return;
        L8:
            TextView r15 = OFilterGroupView.access$getTvShowMore$p(this.f6541c);
            if (r15 == null) goto L11;
            r15.setText(this.f6542g.getResources().getString(j.oui_show_less));
        L11:
            OFilterGroupView r16 = this.f6541c;
            OFilterGroupView.access$addFilterItems(r16, OFilterGroupView.access$getMoreFiltersList$p(r16), OFilterGroupView.access$getColumnCount$p(this.f6541c));
            r13 = this.f6541c;
            r14 = true;
            goto L12
        }
    }

    public static final class b {
    }

    public interface c {
        void a(OFilter r10);
    }

    public interface d {
        void a(List<? extends CharSequence> r10);
    }

    public interface e {
        void a(OFilter r10);

        void b(OFilter r10);
    }

    public static final class f implements OFilter.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFilterGroupView f6543a;

        f(OFilterGroupView r10, int r11) {
            this.f6543a = r10;
        }

        @Override // com.obric.oui.filter.OFilter.b
        public void a(OFilter r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "filter");
            e r12 = OFilterGroupView.access$getOnFilterSelectedListener$p(this.f6543a);
            if (r11 == false) goto L6;
            if (r12 == null) goto L9;
            r12.a(r10);
            return;
        L9:
            return;
        L6:
            if (r12 == null) goto L11;
            r12.b(r10);
            return;
        }
    }

    static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OFilter f6544c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ OFilterGroupView f6545g;

        g(OFilter r10, OFilterGroupView r11, int r12) {
            this.f6544c = r10;
            this.f6545g = r11;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            Intrinsics.checkNotNullExpressionValue(r10, "it");
            if (r10.isSelected() == true) goto L5;
        L9:
            this.f6545g.select((OFilter) r10);
        L10:
            c r11 = OFilterGroupView.access$getOnFilterClickedListener$p(this.f6545g);
            if (r11 == null) goto L14;
            r11.a(this.f6544c);
            return;
        L14:
            return;
        L5:
            if (OFilterGroupView.access$getMaxSelectCount$p(this.f6545g) == 1) goto L7;
        L8:
            this.f6544c.setSelected(false);
            goto L10
        L7:
            if (OFilterGroupView.access$getEnableClickWhenSelected$p(this.f6545g) == false) goto L9;
            goto L8
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OFilterGroupView(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OFilterGroupView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.TAG = "OFilterPanelView";
        this.maxSelectCount = 1;
        this.columnCount = 3;
        this.lessFiltersList = new ArrayList();
        this.moreFiltersList = new ArrayList();
        this.filtersList = new ArrayList();
        this.enableClickWhenSelected = true;
        ViewGroup.inflate(r10, h.o_layout_filter_group_view, this);
        float r12 = 16;
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        int r14 = MathKt.roundToInt(TypedValue.applyDimension(1, r12, r13.getDisplayMetrics()));
        Resources r15 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r15, "Resources.getSystem()");
        int r16 = MathKt.roundToInt(TypedValue.applyDimension(1, r12, r15.getDisplayMetrics()));
        Resources r17 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r17, "Resources.getSystem()");
        setPadding(r14, 0, r16, MathKt.roundToInt(TypedValue.applyDimension(1, r12, r17.getDisplayMetrics())));
        View r18 = findViewById(u8.f.tv_title);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) r18;
        TextView r19 = (TextView) findViewById(u8.f.tv_show_more);
        this.tvShowMore = r19;
        View r20 = findViewById(u8.f.grid_layout);
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.grid_layout)");
        this.gridLayout = (GridLayout) r20;
        r19.setOnClickListener(new a(this, r10));
    }

    public /* synthetic */ OFilterGroupView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static final /* synthetic */ void access$addFilterItems(OFilterGroupView r10, List r11, int r12) {
        r10.addFilterItems(r11, r12);
    }

    public static final /* synthetic */ int access$getColumnCount$p(OFilterGroupView r10) {
        return r10.columnCount;
    }

    public static final /* synthetic */ boolean access$getEnableClickWhenSelected$p(OFilterGroupView r10) {
        return r10.enableClickWhenSelected;
    }

    public static final /* synthetic */ List access$getLessFiltersList$p(OFilterGroupView r10) {
        return r10.lessFiltersList;
    }

    public static final /* synthetic */ int access$getMaxSelectCount$p(OFilterGroupView r10) {
        return r10.maxSelectCount;
    }

    public static final /* synthetic */ List access$getMoreFiltersList$p(OFilterGroupView r10) {
        return r10.moreFiltersList;
    }

    public static final /* synthetic */ c access$getOnFilterClickedListener$p(OFilterGroupView r10) {
        return r10.onFilterClickedListener;
    }

    public static final /* synthetic */ e access$getOnFilterSelectedListener$p(OFilterGroupView r10) {
        return r10.onFilterSelectedListener;
    }

    public static final /* synthetic */ boolean access$getShowingMore$p(OFilterGroupView r10) {
        return r10.showingMore;
    }

    public static final /* synthetic */ TextView access$getTvShowMore$p(OFilterGroupView r10) {
        return r10.tvShowMore;
    }

    public static final /* synthetic */ void access$setColumnCount$p(OFilterGroupView r10, int r11) {
        r10.columnCount = r11;
    }

    public static final /* synthetic */ void access$setEnableClickWhenSelected$p(OFilterGroupView r10, boolean r11) {
        r10.enableClickWhenSelected = r11;
    }

    public static final /* synthetic */ void access$setMaxSelectCount$p(OFilterGroupView r10, int r11) {
        r10.maxSelectCount = r11;
    }

    public static final /* synthetic */ void access$setOnFilterClickedListener$p(OFilterGroupView r10, c r11) {
        r10.onFilterClickedListener = r11;
    }

    public static final /* synthetic */ void access$setOnFilterSelectedListener$p(OFilterGroupView r10, e r11) {
        r10.onFilterSelectedListener = r11;
    }

    public static final /* synthetic */ void access$setShowingMore$p(OFilterGroupView r10, boolean r11) {
        r10.showingMore = r11;
    }

    private final void addFilterItems(List<? extends CharSequence> r24, int r25) {
        this.filtersList.clear();
        this.curFiltersList = r24;
        Iterator<T> r10 = r24.iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L13;
        Object r12 = r10.next();
        int r13 = r11 + 1;
        if (r11 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        CharSequence r14 = (CharSequence) r12;
        GridLayout.LayoutParams r15 = new GridLayout.LayoutParams();
        r15.height = -2;
        r15.width = 0;
        Resources r16 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");
        r15.rightMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 8, r16.getDisplayMetrics()));
        float r17 = 5;
        Resources r18 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r18, "Resources.getSystem()");
        r15.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r17, r18.getDisplayMetrics()));
        r15.setGravity(17);
        int r19 = r11 % r25;
        int r20 = r11 / r25;
        if (Build.VERSION.SDK_INT < 21) goto L11;
        r15.columnSpec = GridLayout.spec(r19, 1.0f);
        r15.rowSpec = GridLayout.spec(r20, 1.0f);
    L12:
        Context r21 = getContext();
        Intrinsics.checkNotNullExpressionValue(r21, "context");
        OFilter r22 = new OFilter(r21, null, 0, true, 6, null);
        r22.setText(r14);
        r22.setStyle(this.filterStyle, true);
        r22.setSelectChangeListener(new f(this, r25));
        r22.setOnClickListener(new g(r22, this, r25));
        this.filtersList.add(r22);
        this.gridLayout.addView(r22, r15);
        r11 = r13;
        goto L4
    L11:
        r15.columnSpec = GridLayout.spec(r19);
        r15.rowSpec = GridLayout.spec(r20);
        Context r23 = getContext();
        Intrinsics.checkNotNullExpressionValue(r23, "context");
        int r26 = com.obric.oui.common.util.f.e(r23);
        Resources r110 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r110, "Resources.getSystem()");
        r15.width = (r26 - (MathKt.roundToInt(TypedValue.applyDimension(1, r17, r110.getDisplayMetrics())) * 2)) / 3;
        goto L12
    L13:
        d r27 = this.onFilterDataChangeListener;
        if (r27 == null) goto L20;
        r27.a(r24);
        return;
    }

    static /* synthetic */ void addFilterItems$default(OFilterGroupView r10, List r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = 3;
    L5:
        r10.addFilterItems(r11, r12);
    }

    public static /* synthetic */ void setFilterItems$default(OFilterGroupView r10, List r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 3;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = Integer.MAX_VALUE;
    L8:
        r10.setFilterItems(r11, r12, r13);
    }

    public static /* synthetic */ void setFilterStyle$default(OFilterGroupView r10, int r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = true;
    L5:
        r10.setFilterStyle(r11, r12);
    }

    public final GridLayout getGridLayout() {
        return this.gridLayout;
    }

    public final int getMaxSelectCount() {
        return this.maxSelectCount;
    }

    public final List<OFilter> getSelectedFilters() {
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = this.filtersList.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        OFilter r12 = (OFilter) r11.next();
        if (r12.isSelected() == false) goto L4;
        r10.add(r12);
        goto L4
    L8:
        return r10;
    }

    public final List<Integer> getSelectedIndexes() {
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = this.filtersList.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L12;
        Object r13 = r11.next();
        int r14 = r12 + 1;
        if (r12 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((OFilter) r13).isSelected() == false) goto L11;
        r10.add(Integer.valueOf(r12));
    L11:
        r12 = r14;
        goto L4
    L12:
        return r10;
    }

    public final TextView getTitle() {
        return this.tvTitle;
    }

    public final void registerFilterClickedListener(c r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.onFilterClickedListener = r10;
    }

    public final void registerFilterDataChangeListener(d r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.onFilterDataChangeListener = r10;
        List<? extends CharSequence> r11 = this.curFiltersList;
        if (r11 == null) goto L6;
        r10.a(r11);
        return;
    }

    public final void registerFilterSelectedListener(e r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.onFilterSelectedListener = r10;
    }

    public final void select(OFilter r10) {
        Intrinsics.checkNotNullParameter(r10, "filter");
        if (r10.isSelected() == false) goto L5;
        return;
    L5:
        List<OFilter> r11 = this.filtersList;
        int r12 = 0;
        if ((r11 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r13 = r11.iterator();
    L12:
        if (r13.hasNext() == false) goto L19;
        if (((OFilter) r13.next()).isSelected() == false) goto L12;
        r12 = r12 + 1;
        if (r12 >= 0) goto L12;
        CollectionsKt.throwCountOverflow();
    L19:
        if (r12 < this.maxSelectCount) goto L21;
        unSelectAll();
    L21:
        r10.setSelected(true);
        return;
    L8:
        if (r11.isEmpty() == false) goto L10;
        goto L10
    }

    public final boolean select(int r10) {
        int r11 = this.filtersList.size();
        if (r10 < 0) goto L7;
        if (r11 <= r10) goto L7;
        this.filtersList.get(r10).setSelected(true);     // Catch: IndexOutOfBoundsException -> L8
    L7:
        return false;
    }

    public final void setEnableClickWhenSelected(boolean r10) {
        this.enableClickWhenSelected = r10;
    }

    public final void setFilterItems(List<? extends CharSequence> r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "items");
        this.columnCount = r11;
        this.gridLayout.setAlignmentMode(0);
        this.gridLayout.setColumnCount(r11);
        this.gridLayout.setRowCount(((r10.size() + r11) - 1) / r11);
        if ((((r10.size() - 1) / r11) + 1) <= r12) goto L7;
        this.moreFiltersList.addAll(r10);
        List<? extends CharSequence> r13 = r10.subList(0, r12 * r11);
        this.lessFiltersList.addAll(r13);
        addFilterItems(r13, r11);
        TextView r14 = this.tvShowMore;
        if (r14 == null) goto L9;
        r14.setVisibility(0);
        return;
    L9:
        return;
    L7:
        addFilterItems(r10, r11);
    }

    public final void setFilterStyle(int r10, boolean r11) {
        this.filterStyle = r10;
        Iterator<T> r12 = this.filtersList.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((OFilter) r12.next()).setStyle(r10, r11);
        goto L4
    }

    public final void setMaxSelectCount(int r10) {
        this.maxSelectCount = r10;
    }

    public final void setTitle(CharSequence r10) {
        this.tvTitle.setText(r10);
    }

    public final void unSelectAll() {
        Log.d(this.TAG, "unSelectAll() called");
        Iterator<T> r10 = this.filtersList.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        OFilter r11 = (OFilter) r10.next();
        if (r11.isSelected() == false) goto L4;
        r11.setSelected(false);
        goto L4
    }
}
