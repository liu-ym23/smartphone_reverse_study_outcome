package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.GridView;
import android.widget.Scroller;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.obric.cae.R;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes.dex */
public final class i<S> extends z<S> {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f4683y = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4684b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public DateSelector<S> f4685m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CalendarConstraints f4686n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DayViewDecorator f4687o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Month f4688p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public e f4689q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.google.android.material.datepicker.b f4690r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RecyclerView f4691s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public RecyclerView f4692t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f4693u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f4694v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f4695w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f4696x;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f4697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f4698b;

        public a(i r8, int r10) {
            this.f4698b = r8;
            this.f4697a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f4698b.f4692t.smoothScrollToPosition(this.f4697a);
        }
    }

    public class b extends j0.a {
        @Override // j0.a
        public final void d(View r8, k0.f r10) {
            AccessibilityNodeInfo r11 = r10.f8890a;
            this.f8370a.onInitializeAccessibilityNodeInfo(r8, r11);
            r10.g(null);
        }
    }

    public class c extends e0 {
        public final /* synthetic */ int E;
        public final /* synthetic */ i F;

        public c(i r8, int r10, int r11) {
            this.F = r8;
            this.E = r11;
            super(r10);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public final void z0(RecyclerView.z r8, int[] r10) {
            int r11 = this.E;
            i r12 = this.F;
            if (r11 != 0) goto L5;
            r10[0] = r12.f4692t.getWidth();
            r10[1] = r12.f4692t.getWidth();
            return;
        L5:
            r10[0] = r12.f4692t.getHeight();
            r10[1] = r12.f4692t.getHeight();
        }
    }

    public class d implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f4699a;

        public d(i r8) {
            this.f4699a = r8;
        }
    }

    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f4700a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f4701b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final /* synthetic */ e[] f4702m = null;

        static {
            e r8 = new e("DAY", 0);
            f4700a = r8;
            e r10 = new e("YEAR", 1);
            f4701b = r10;
            f4702m = new e[]{r8, r10};
        }

        public e(String r8, int r10) {
            super(r8, r10);
        }

        public static e valueOf(String r8) {
            return (e) Enum.valueOf(e.class, r8);
        }

        public static e[] values() {
            return (e[]) f4702m.clone();
        }
    }

    public interface f {
    }

    public i() {
    }

    @Override // com.google.android.material.datepicker.z
    public final boolean a(r.c r8) {
        return super.a(r8);
    }

    public final void b(int r8) {
        this.f4692t.post(new a(this, r8));
    }

    public final void c(Month r8) {
        Month r10 = ((x) this.f4692t.getAdapter()).f4741c.f4599a;
        Calendar r11 = r10.f4621a;
        if ((r11 instanceof GregorianCalendar) == false) goto L25;
        int r12 = r8.f4623m;
        int r13 = r10.f4623m;
        int r14 = r8.f4622b;
        int r15 = r10.f4622b;
        int r16 = (r14 - r15) + ((r12 - r13) * 12);
        Month r17 = this.f4688p;
        if ((r11 instanceof GregorianCalendar) == false) goto L23;
        int r18 = r16 - ((r17.f4622b - r15) + ((r17.f4623m - r13) * 12));
        boolean r19 = true;
        if (Math.abs(r18) <= 3) goto L9;
        boolean r20 = true;
    L10:
        if (r18 > 0) goto L13;
        r19 = false;
    L13:
        this.f4688p = r8;
        if (r20 == false) goto L17;
        if (r19 == false) goto L17;
        RecyclerView r21 = this.f4692t;
        int r22 = r16 - 3;
    L19:
        r21.scrollToPosition(r22);
    L20:
        b(r16);
        return;
    L17:
        if (r20 == false) goto L20;
        r21 = this.f4692t;
        r22 = r16 + 3;
        goto L19
    L9:
        r20 = false;
        goto L10
    L23:
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    L25:
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    public final void d(e r8) {
        this.f4689q = r8;
        if (r8 != e.f4701b) goto L6;
        RecyclerView.o r10 = this.f4691s.getLayoutManager();
        i0 r11 = (i0) this.f4691s.getAdapter();
        r10.m0(this.f4688p.f4623m - r11.f4703c.f4686n.f4599a.f4623m);
        this.f4695w.setVisibility(0);
        this.f4696x.setVisibility(8);
        this.f4693u.setVisibility(8);
        this.f4694v.setVisibility(8);
        return;
    L6:
        if (r8 != e.f4700a) goto L10;
        this.f4695w.setVisibility(8);
        this.f4696x.setVisibility(0);
        this.f4693u.setVisibility(0);
        this.f4694v.setVisibility(0);
        c(this.f4688p);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r8) {
        super.onCreate(r8);
        if (r8 != null) goto L5;
        r8 = getArguments();
    L5:
        this.f4684b = r8.getInt("THEME_RES_ID_KEY");
        this.f4685m = (DateSelector) r8.getParcelable("GRID_SELECTOR_KEY");
        this.f4686n = (CalendarConstraints) r8.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f4687o = (DayViewDecorator) r8.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f4688p = (Month) r8.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        ContextThemeWrapper r13 = new ContextThemeWrapper(getContext(), this.f4684b);
        this.f4690r = new com.google.android.material.datepicker.b(r13);
        LayoutInflater r14 = r10.cloneInContext(r13);
        Month r8 = this.f4686n.f4599a;
        if (r.f(r13) == false) goto L5;
        int r15 = R.layout.mtrl_calendar_vertical;
        int r16 = 1;
    L6:
        View r17 = r14.inflate(r15, r11, false);
        Resources r18 = requireContext().getResources();
        int r19 = r18.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding) + (r18.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + r18.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height));
        int r20 = r18.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
        int r21 = v.f4731q;
        int r22 = r19 + r20;
        r17.setMinimumHeight((r22 + ((r18.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding) * (r21 - 1)) + (r18.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * r21))) + r18.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding));
        GridView r110 = (GridView) r17.findViewById(R.id.mtrl_calendar_days_of_week);
        j0.w.m(r110, new b());
        int r23 = this.f4686n.f4603o;
        if (r23 <= 0) goto L9;
        g r24 = new g(r23);
    L10:
        r110.setAdapter(r24);
        r110.setNumColumns(r8.f4624n);
        r110.setEnabled(false);
        this.f4692t = (RecyclerView) r17.findViewById(R.id.mtrl_calendar_months);
        getContext();
        this.f4692t.setLayoutManager(new c(this, r16, r16));
        this.f4692t.setTag("MONTHS_VIEW_GROUP_TAG");
        x r111 = new x(r13, this.f4685m, this.f4686n, this.f4687o, new d(this));
        this.f4692t.setAdapter(r111);
        int r25 = r13.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        RecyclerView r26 = (RecyclerView) r17.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.f4691s = r26;
        if (r26 == null) goto L14;
        r26.setHasFixedSize(true);
        this.f4691s.setLayoutManager(new GridLayoutManager(r25));
        this.f4691s.setAdapter(new i0(this));
        this.f4691s.addItemDecoration(new k(this));
    L14:
        if (r17.findViewById(R.id.month_navigation_fragment_toggle) == null) goto L17;
        MaterialButton r27 = (MaterialButton) r17.findViewById(R.id.month_navigation_fragment_toggle);
        r27.setTag("SELECTOR_TOGGLE_TAG");
        j0.w.m(r27, new l(this));
        View r28 = r17.findViewById(R.id.month_navigation_previous);
        this.f4693u = r28;
        r28.setTag("NAVIGATION_PREV_TAG");
        View r29 = r17.findViewById(R.id.month_navigation_next);
        this.f4694v = r29;
        r29.setTag("NAVIGATION_NEXT_TAG");
        this.f4695w = r17.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.f4696x = r17.findViewById(R.id.mtrl_calendar_day_selector_frame);
        d(e.f4700a);
        r27.setText(this.f4688p.v());
        this.f4692t.addOnScrollListener(new m(this, r111, r27));
        r27.setOnClickListener(new n(this));
        this.f4694v.setOnClickListener(new o(this, r111));
        this.f4693u.setOnClickListener(new h(this, r111));
    L17:
        if (r.f(r13) == true) goto L31;
        androidx.recyclerview.widget.u r112 = new androidx.recyclerview.widget.u();
        RecyclerView r30 = this.f4692t;
        RecyclerView r31 = r112.f2565a;
        if (r31 == r30) goto L31;
        androidx.recyclerview.widget.y.a r32 = r112.f2566b;
        if (r31 == null) goto L24;
        r31.removeOnScrollListener(r32);
        r112.f2565a.setOnFlingListener(null);
    L24:
        r112.f2565a = r30;
        if (r30 == null) goto L31;
        if (r30.getOnFlingListener() != null) goto L30;
        r112.f2565a.addOnScrollListener(r32);
        r112.f2565a.setOnFlingListener(r112);
        new Scroller(r112.f2565a.getContext(), new DecelerateInterpolator());
        r112.b();
        goto L31
    L30:
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    L31:
        RecyclerView r113 = this.f4692t;
        Month r33 = this.f4688p;
        Month r114 = r111.f4741c.f4599a;
        if ((r114.f4621a instanceof GregorianCalendar) == false) goto L36;
        r113.scrollToPosition((r33.f4622b - r114.f4622b) + ((r33.f4623m - r114.f4623m) * 12));
        j0.w.m(this.f4692t, new j());
        return r17;
    L36:
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    L9:
        r24 = new g();
        goto L10
    L5:
        r15 = R.layout.mtrl_calendar_horizontal;
        r16 = 0;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r8) {
        super.onSaveInstanceState(r8);
        r8.putInt("THEME_RES_ID_KEY", this.f4684b);
        r8.putParcelable("GRID_SELECTOR_KEY", this.f4685m);
        r8.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f4686n);
        r8.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f4687o);
        r8.putParcelable("CURRENT_MONTH_KEY", this.f4688p);
    }
}
