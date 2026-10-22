package com.zte.miboard.cards.common.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import c.m;
import com.obric.oui.indicator.OCarouselIndicator;
import com.zte.miboard.cards.R;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class CardPagerLayout extends LinearLayout {
    private static final boolean g = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CardPagerContainer f16269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewGroup f16270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OCarouselIndicator f16271c;
    private a d;
    private volatile HashMap<Object, ArrayList<View>> e;
    private ArrayList<Object> f;

    public interface a<D, T> {
        @NonNull
        View a(@NonNull ViewGroup r5, @NonNull T r10);

        @NonNull
        T a(int r5);

        @NonNull
        ArrayList<D> a();

        void a(@NonNull View r5);

        void a(@NonNull View r5, int r10);
    }

    public CardPagerLayout(Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ void a(CardPagerLayout r5, int r10) {
        r5.a(r10);
    }

    public void b() {
        this.f16269a.c();
    }

    public ArrayList<View> getAllPageViewList() {
        ArrayList<View> r5 = new ArrayList();
        int r10 = 0;
    L4:
        if (r10 >= this.f16269a.getChildCount()) goto L6;
        r5.add(this.f16269a.getChildAt(r10));
        r10 = r10 + 1;
        goto L4
    L6:
        return r5;
    }

    public int getShowItemListSize() {
        return this.f.size();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f16269a = (CardPagerContainer) findViewById(R.id.card_pager_layout_container);
        this.f16271c = (OCarouselIndicator) findViewById(R.id.card_pager_layout_page_indicator);
        this.f16270b = (ViewGroup) findViewById(R.id.card_pager_layout_page_indicator_layout);
        this.f16271c.l(0, 0, new androidx.core.view.inputmethod.a(this, 10));
        this.f16269a.setPageIndicator(this.f16271c);
    }

    public void setCardPagerCallback(@NonNull a r5) {
        this.d = r5;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r5) {
        this.f16269a.setOnPageChangeListener(r5);
    }

    public CardPagerLayout(Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    private View a(Object r5) {
        ArrayList<View> r10 = this.e.get(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.isEmpty() == false) goto L7;
        return null;
    L7:
        return r10.remove(0);
    }

    public CardPagerLayout(Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.e = new HashMap();
        this.f = new ArrayList();
    }

    private /* synthetic */ void a(int r5) {
        m.i("CardPagerLayout", "setManualPager OnManualPageSelectedListener onPageSelected index=" + r5);
        this.f16269a.a(r5, true);
    }

    public void a() {
        a r5 = this.d;
        if (r5 != null) goto L6;
        m.l("CardPagerLayout", "notifyDataSetChanged mCallback null return");
        return;
    L6:
        ArrayList r10 = r5.a();
        this.f.clear();
        this.f.addAll(r10);
        int r11 = this.f16269a.getCurrentPageIndex();
        if (r11 < r10.size()) goto L9;
        r11 = 0;
    L9:
        m.i("CardPagerLayout", "notifyDataSetChanged size=" + r10.size() + " getChildCount=" + this.f16269a.getChildCount() + " curSelectIndex=" + r11 + " getCurrentPageIndex=" + this.f16269a.getCurrentPageIndex());
        if (this.f16269a.getChildCount() <= r10.size()) goto L28;
        int r12 = this.f16269a.getChildCount() - 1;
    L13:
        if (r12 < r10.size()) goto L28;
        View r13 = this.f16269a.getChildAt(r12);
        this.f16269a.removeViewAt(r12);
        this.d.a(r13);
        if (r13 == null) goto L17;
        Object r14 = r13.getTag(R.id.card_pager_layout_view_type_obj_tag);
    L19:
        if (g == false) goto L25;
        StringBuilder r15 = new StringBuilder("notifyDataSetChanged cur child count more than size, remove i=");
        r15.append(r12);
        r15.append(" viewType=");
        r15.append(r14);
        r15.append(" child=");
        if (r13 == null) goto L23;
        boolean r16 = true;
    L24:
        r15.append(r16);
        m.i("CardPagerLayout", r15.toString());
        goto L25
    L23:
        r16 = false;
    L25:
        if (r14 == null) goto L27;
        a(r14, r13);
    L27:
        r12 = r12 - 1;
        goto L13
    L17:
        r14 = null;
    L28:
        int r17 = 0;
    L30:
        if (r17 >= r10.size()) goto L67;
        Object r18 = this.d.a(r17);
        if (r17 >= this.f16269a.getChildCount()) goto L51;
        View r19 = this.f16269a.getChildAt(r17);
        Object r110 = r19.getTag(R.id.card_pager_layout_view_type_obj_tag);
        if (r110 != null) goto L36;
    L45:
        View r111 = null;
    L46:
        if (r111 != r19) goto L48;
    L52:
        boolean r20 = g;
        if (r20 == false) goto L59;
        StringBuilder r112 = new StringBuilder("notifyDataSetChanged i=");
        r112.append(r17);
        r112.append(" viewType=");
        r112.append(r18);
        r112.append(" (showChildView == null)=");
        if (r111 != null) goto L57;
        boolean r113 = true;
    L58:
        r112.append(r113);
        m.i("CardPagerLayout", r112.toString());
        goto L59
    L57:
        r113 = false;
    L59:
        if (r111 != null) goto L66;
        View r114 = a(r18);
        if (r114 != null) goto L65;
        r114 = this.d.a(this.f16269a, r18);
        r114.setTag(R.id.card_pager_layout_view_type_obj_tag, r18);
        if (r20 == false) goto L65;
        m.i("CardPagerLayout", "notifyDataSetChanged i=" + r17 + " viewType=" + r18 + " cached null call onCreateChildView");
    L65:
        this.f16269a.addView(r114, r17);
        this.d.a(r114, r17);
    L66:
        r17 = r17 + 1;
        goto L30
    L48:
        if (g == false) goto L50;
        m.i("CardPagerLayout", "notifyDataSetChanged i=" + r17 + " viewType=" + r18 + " showChildView != child removeViewAt");
    L50:
        this.f16269a.removeViewAt(r17);
        this.d.a(r19);
        goto L52
    L36:
        if (r110.equals(r18) == false) goto L42;
        this.d.a(r19, r17);
        if (g == false) goto L40;
        m.i("CardPagerLayout", "notifyDataSetChanged i=" + r17 + " viewType=" + r18 + " use exist child");
    L40:
        r111 = r19;
        goto L46
    L42:
        if (g == false) goto L44;
        m.i("CardPagerLayout", "notifyDataSetChanged i=" + r17 + " viewType=" + r18 + " childViewType=" + r110 + " saveViewToCachedMap");
    L44:
        a(r110, r19);
        goto L45
    L51:
        r111 = null;
        goto L52
    L67:
        this.f16269a.a(r11, true);
        if (r10.size() <= 1) goto L70;
        this.f16271c.setManualCurrentItem(r11);
        this.f16270b.setVisibility(0);
        return;
    L70:
        this.f16271c.setManualCurrentItem(0);
        this.f16270b.setVisibility(8);
    }

    private void a(Object r5, View r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.e.get(r5) != null) goto L7;
        this.e.put(r5, new ArrayList());
    L7:
        this.e.get(r5).add(r10);
    }
}
