package rc;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.obric.cae.R;
import he.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f11783b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final FrameLayout f11784m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final NestedScrollView f11785n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ConstraintLayout f11786o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f11787p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f11788q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f11789r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f11790s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ArrayList f11791t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public e.a f11792u;

    public static final class a implements b {
        @Override // rc.d.b
        public final void a(ImageView r8, c r10, Context r11) {
            i.f(r8, "iconImageView");
            r8.setImageDrawable(r10.f11793a);
        }
    }

    public interface b {
        void a(ImageView r8, c r10, Context r11);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable f11793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f11794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f11795c;

        public c() {
            this(null, null, null);
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L4;
            return true;
        L4:
            if ((r8 instanceof c) == false) goto L12;
            c r10 = (c) r8;
            Drawable r11 = r10.f11793a;
            if (i.a(this.f11793a, r11) == true) goto L8;
            return false;
        L8:
            if (i.a(this.f11794b, r10.f11794b) == true) goto L10;
            return false;
        L10:
            if (i.a(this.f11795c, r10.f11795c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            int r8 = 0;
            Drawable r10 = this.f11793a;
            if (r10 == null) goto L5;
            int r11 = r10.hashCode();
        L6:
            int r12 = r11 * 31;
            String r13 = this.f11794b;
            if (r13 == null) goto L9;
            int r14 = r13.hashCode();
        L10:
            int r15 = (r12 + r14) * 31;
            String r16 = this.f11795c;
            if (r16 == null) goto L14;
            r8 = r16.hashCode();
        L14:
            return r15 + r8;
        L9:
            r14 = 0;
            goto L10
        L5:
            r11 = 0;
            goto L6
        }

        public final String toString() {
            StringBuilder r8 = new StringBuilder("SelectionItemData(iconDrawable=");
            r8.append(this.f11793a);
            r8.append(", title=");
            r8.append(this.f11794b);
            r8.append(", iconUrl=");
            return android.aimedia.a.i(r8, this.f11795c, ")");
        }

        public c(Drawable r8, String r10, String r11) {
            this.f11793a = r8;
            this.f11794b = r10;
            this.f11795c = r11;
        }
    }

    /* JADX INFO: renamed from: rc.d$d, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0148d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rc.c f11796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f11797b;

        public ViewOnClickListenerC0148d(rc.c r8, int r10, d r11) {
            this.f11796a = r8;
            this.f11797b = r11;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            d r10 = this.f11797b;
            r10.b();
            if (this.f11796a.s() == true) goto L8;
            Iterator<T> r11 = r10.getItemViews().iterator();
        L6:
            if (r11.hasNext() == false) goto L8;
            rc.c r12 = (rc.c) r11.next();
            r12.setItemSelected(i.a(r8, r12));
        L8:
            r10.b();
            if (r10.f11792u == null) goto L23;
            Iterator r13 = r10.f11791t.iterator();
            int r14 = 0;
        L12:
            if (r13.hasNext() == false) goto L30;
            Object r15 = r13.next();
            int r16 = r14 + 1;
            if (r14 < 0) goto L21;
            rc.c r17 = (rc.c) r15;
            if (r17.s() == true) goto L17;
            r14 = r16;
            goto L12
        L17:
            e.a r18 = r10.f11792u;
            if (r18 == null) goto L28;
            r18.onItemSelected(r17, r14);
            return;
        L28:
            return;
        L21:
            l6.a.T0();
            throw null;
        L30:
            return;
        }
    }

    public d(Context r8) {
        i.f(r8, "context");
        super(new ContextThemeWrapper(r8, 0), null);
        this.f11782a = true;
        this.f11787p = new a();
        this.f11788q = true;
        this.f11791t = new ArrayList();
        LinearLayout.inflate(getContext(), R.layout.o_view_selection_panel, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setOrientation(1);
        View r10 = findViewById(R.id.item_container);
        i.e(r10, "findViewById(R.id.item_container)");
        this.f11783b = (LinearLayout) r10;
        View r11 = findViewById(R.id.btn_container);
        i.e(r11, "findViewById(R.id.btn_container)");
        this.f11784m = (FrameLayout) r11;
        View r12 = findViewById(R.id.item_scroll_view);
        i.e(r12, "findViewById(R.id.item_scroll_view)");
        this.f11785n = (NestedScrollView) r12;
        View r13 = findViewById(R.id.root_constraint);
        i.e(r13, "findViewById(R.id.root_constraint)");
        this.f11786o = (ConstraintLayout) r13;
        View r14 = findViewById(R.id.bottom_divider);
        i.e(r14, "findViewById(R.id.bottom_divider)");
        this.f11789r = r14;
    }

    public abstract void a();

    public abstract void b();

    public final View getBottomDivider() {
        View r8 = this.f11789r;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("bottomDivider");
        throw null;
    }

    public final List<rc.c> getItemViews() {
        return this.f11791t;
    }

    public final e.a getOnItemSelectListener() {
        return this.f11792u;
    }

    public final rc.a getOnMultiItemSelectListener() {
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
    }

    public final void setBottomDivider(View r8) {
        i.f(r8, "<set-?>");
        this.f11789r = r8;
    }

    public final void setIconLoader(b r8) {
        i.f(r8, "loader");
        this.f11787p = r8;
    }

    public final void setItems(List<c> r11) {
        i.f(r11, "items");
        Iterator<T> r12 = r11.iterator();
        int r8 = 0;
    L3:
        boolean r10 = r12.hasNext();
        ArrayList r13 = this.f11791t;
        if (r10 == false) goto L20;
        Object r14 = r12.next();
        int r15 = r8 + 1;
        if (r8 < 0) goto L18;
        c r16 = (c) r14;
        Context r17 = getContext();
        i.e(r17, "context");
        rc.c r18 = new rc.c(r17, this.f11790s);
        b();
        r18.setSelectMode(false);
        boolean r19 = this.f11782a;
        r18.L = r19;
        if (r19 == false) goto L10;
        r18.setSelectMode(r18.M);
    L12:
        if (r16.f11793a == null) goto L14;
    L16:
        bc.a.c(r18.getIconView());
        b r20 = this.f11787p;
        ImageView r21 = r18.getIconView();
        Context r22 = r18.getContext();
        i.e(r22, "context");
        r20.a(r21, r16, r22);
    L17:
        r18.getTextView().setText(r16.f11794b);
        r18.setOnClickListener(new ViewOnClickListenerC0148d(r18, r8, this));
        this.f11783b.addView(r18);
        j r23 = j.f13877a;
        r13.add(r18);
        r8 = r15;
        goto L3
    L14:
        if (TextUtils.isEmpty(r16.f11795c) == false) goto L16;
        bc.a.b(r18.getIconView());
        goto L17
    L10:
        bc.a.b(r18.J);
        bc.a.b(r18.I);
        goto L12
    L18:
        l6.a.T0();
        throw null;
    L20:
        i.f(r13, "<this>");
        if (r13.isEmpty() == true) goto L25;
        bc.a.b(((rc.c) r13.get(l6.a.O(r13))).K);
        a();
        return;
    L25:
        throw new NoSuchElementException("List is empty.");
    }

    public final void setOnItemSelectListener(e.a r8) {
        this.f11792u = r8;
    }

    public final void setOnMultiItemSelectListener(rc.a r8) {
    }

    public final void setScrollViewHeight(int r8) {
        ConstraintLayout.a r10 = new ConstraintLayout.a(-1, r8);
        if (this.f11791t.size() < 4) goto L5;
    L7:
        this.f11785n.setLayoutParams(r10);
        return;
    L5:
        if (this.f11788q == false) goto L7;
        ConstraintLayout.a r11 = new ConstraintLayout.a(-1, -2);
        r11.f1375j = -1;
        r11.f1379l = 0;
        this.f11784m.setLayoutParams(r11);
        r10.f1377k = -1;
        goto L7
    }
}
