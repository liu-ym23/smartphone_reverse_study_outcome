package com.obric.oui.filterpanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import cn.nubia.neopush.commons.Constant;
import com.lynx.tasm.utils.a;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.filter.OFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import ym.d;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u0015\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010$\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterGroupView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", Constant.TITLE, "", "setTitle", "(Ljava/lang/CharSequence;)V", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "", "count", "setMaxSelectCount", "(I)V", "getMaxSelectCount", "()I", "", "getSelectedIndexes", "()Ljava/util/List;", "Lcom/obric/oui/filter/OFilter;", "getSelectedFilters", "", "enableClickWhenSelected", "setEnableClickWhenSelected", "(Z)V", "Landroid/widget/GridLayout;", "j", "Landroid/widget/GridLayout;", "getGridLayout", "()Landroid/widget/GridLayout;", "gridLayout", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OFilterGroupView extends ConstraintLayout {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f13211r = 0;
    public final String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f13212h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f13213i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final GridLayout f13214j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13215k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f13216l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f13217m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList f13218n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList f13219o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList f13220p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f13221q;

    @JvmOverloads
    public OFilterGroupView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    public final void e(ArrayList r13, int r14) {
        ArrayList r5 = this.f13220p;
        r5.clear();
        Iterator r15 = r13.iterator();
        int r10 = 0;
    L4:
        if (r15.hasNext() == false) goto L9;
        Object r11 = r15.next();
        int r12 = r10 + 1;
        if (r10 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        GridLayout.LayoutParams r16 = new GridLayout.LayoutParams();
        r16.height = -2;
        r16.width = 0;
        r16.rightMargin = a.B(8, this);
        r16.topMargin = a.B(5, this);
        r16.setGravity(17);
        r16.columnSpec = GridLayout.spec(r10 % r14, 1.0f);
        r16.rowSpec = GridLayout.spec(r10 / r14, 1.0f);
        OFilter r17 = new OFilter(getContext(), null, 0, true, 6);
        r17.setText((CharSequence) r11);
        r17.e = 0;
        r17.f13201h = true;
        r17.a();
        r17.setSelectChangeListener(new d(this));
        r17.setOnClickListener(new com.google.android.material.snackbar.a(7, this, r17));
        r5.add(r17);
        getGridLayout().addView(r17, r16);
        r10 = r12;
        goto L4
    }

    public final GridLayout getGridLayout() {
        return this.f13214j;
    }

    public final int getMaxSelectCount() {
        return this.f13215k;
    }

    public final List<OFilter> getSelectedFilters() {
        ArrayList r5 = new ArrayList();
        Iterator r10 = this.f13220p.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        OFilter r11 = (OFilter) r10.next();
        if (r11.isSelected() == false) goto L4;
        r5.add(r11);
        goto L4
    L8:
        return r5;
    }

    public final List<Integer> getSelectedIndexes() {
        ArrayList r5 = new ArrayList();
        Iterator r10 = this.f13220p.iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L12;
        Object r12 = r10.next();
        int r13 = r11 + 1;
        if (r11 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((OFilter) r12).isSelected() == false) goto L11;
        r5.add(Integer.valueOf(r11));
    L11:
        r11 = r13;
        goto L4
    L12:
        return r5;
    }

    public final TextView getTitle() {
        return this.f13212h;
    }

    public final void setEnableClickWhenSelected(boolean r5) {
        this.f13221q = r5;
    }

    public final void setMaxSelectCount(int r5) {
        this.f13215k = r5;
    }

    public final void setTitle(CharSequence r5) {
        this.f13212h.setText(r5);
    }

    @JvmOverloads
    public OFilterGroupView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        this.g = "OFilterPanelView";
        this.f13215k = 1;
        this.f13216l = 3;
        this.f13218n = new ArrayList();
        this.f13219o = new ArrayList();
        this.f13220p = new ArrayList();
        this.f13221q = true;
        View.inflate(r5, R$layout.o_layout_filter_group_view, this);
        setPadding(a.B(16, this), 0, a.B(16, this), a.B(16, this));
        this.f13212h = (TextView) findViewById(R$id.tv_title);
        TextView r11 = (TextView) findViewById(R$id.tv_show_more);
        this.f13213i = r11;
        this.f13214j = (GridLayout) findViewById(R$id.grid_layout);
        r11.setOnClickListener(new com.google.android.material.snackbar.a(6, this, r5));
    }
}
