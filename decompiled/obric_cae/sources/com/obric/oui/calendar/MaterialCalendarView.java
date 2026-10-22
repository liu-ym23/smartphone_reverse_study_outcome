package com.obric.oui.calendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.s;
import androidx.viewpager.widget.ViewPager;
import com.obric.cae.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.WeekFields;
import xb.h;
import xb.i;
import xb.j;
import xb.k;
import xb.l;
import xb.m;
import xb.n;
import xb.o;
import xb.p;
import xb.q;
import yb.g;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialCalendarView extends ViewGroup {
    public static final /* synthetic */ int H = 0;
    public int A;
    public int B;
    public int C;
    public boolean D;
    public DayOfWeek E;
    public boolean F;
    public e G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f6211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f6212b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageView f6213m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ImageView f6214n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final xb.c f6215o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public xb.d<?> f6216p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CalendarDay f6217q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LinearLayout f6218r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public xb.b f6219s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f6220t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public CalendarDay f6221u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public CalendarDay f6222v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CharSequence f6223w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f6224x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f6225y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f6226z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f6228b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public CalendarDay f6229m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public CalendarDay f6230n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public List<CalendarDay> f6231o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f6232p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f6233q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f6234r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public CalendarDay f6235s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f6236t;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r8) {
                return new SavedState(r8);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r8) {
                return new SavedState[r8];
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r8) {
            super(r8);
            this.f6227a = 4;
            boolean r10 = true;
            this.f6228b = true;
            this.f6229m = null;
            this.f6230n = null;
            this.f6231o = new ArrayList();
            this.f6232p = true;
            this.f6233q = 1;
            this.f6234r = false;
            this.f6235s = null;
            this.f6227a = r8.readInt();
            if (r8.readByte() == 0) goto L5;
            boolean r11 = true;
        L6:
            this.f6228b = r11;
            ClassLoader r12 = CalendarDay.class.getClassLoader();
            this.f6229m = (CalendarDay) r8.readParcelable(r12);
            this.f6230n = (CalendarDay) r8.readParcelable(r12);
            r8.readTypedList(this.f6231o, CalendarDay.CREATOR);
            if (r8.readInt() != 1) goto L9;
            boolean r13 = true;
        L10:
            this.f6232p = r13;
            this.f6233q = r8.readInt();
            if (r8.readInt() != 1) goto L13;
            boolean r14 = true;
        L14:
            this.f6234r = r14;
            this.f6235s = (CalendarDay) r8.readParcelable(r12);
            if (r8.readByte() != 0) goto L18;
            r10 = false;
        L18:
            this.f6236t = r10;
            return;
        L13:
            r14 = false;
            goto L14
        L9:
            r13 = false;
            goto L10
        L5:
            r11 = false;
            goto L6
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            super.writeToParcel(r8, r10);
            r8.writeInt(this.f6227a);
            r8.writeByte(this.f6228b ? 1 : 0);
            r8.writeParcelable(this.f6229m, 0);
            r8.writeParcelable(this.f6230n, 0);
            r8.writeTypedList(this.f6231o);
            r8.writeInt(this.f6232p ? 1 : 0);
            r8.writeInt(this.f6233q);
            r8.writeInt(this.f6234r ? 1 : 0);
            r8.writeParcelable(this.f6235s, 0);
            r8.writeByte(this.f6236t ? 1 : 0);
        }

        public SavedState(Parcelable r8) {
            super(r8);
            this.f6227a = 4;
            this.f6228b = true;
            this.f6229m = null;
            this.f6230n = null;
            this.f6231o = new ArrayList();
            this.f6232p = true;
            this.f6233q = 1;
            this.f6234r = false;
            this.f6235s = null;
        }
    }

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialCalendarView f6237a;

        public a(MaterialCalendarView r8) {
            this.f6237a = r8;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            MaterialCalendarView r10 = this.f6237a;
            if (r8 != r10.f6214n) goto L7;
            xb.c r11 = r10.f6215o;
            int r12 = r11.getCurrentItem() + 1;
        L5:
            r11.t(r12, true);
            return;
        L7:
            if (r8 != r10.f6213m) goto L10;
            r11 = r10.f6215o;
            r12 = r11.getCurrentItem() - 1;
            goto L5
        }
    }

    public class b implements ViewPager.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialCalendarView f6238a;

        public b(MaterialCalendarView r8) {
            this.f6238a = r8;
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public final void a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public final void b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public final void c(int r8) {
            MaterialCalendarView r10 = this.f6238a;
            q r11 = r10.f6211a;
            r11.f13833i = r10.f6217q;
            r10.f6217q = r10.f6216p.f(r8);
            r10.e();
        }
    }

    public class c implements ViewPager.i {
    }

    public static class d extends ViewGroup.MarginLayoutParams {
        public d(int r8) {
            super(-1, r8);
        }
    }

    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xb.b f6239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DayOfWeek f6240b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CalendarDay f6241c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final CalendarDay f6242d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f6243e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f6244f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ MaterialCalendarView f6245g;

        public e(MaterialCalendarView r8, f r10) {
            this.f6245g = r8;
            this.f6239a = r10.f6246a;
            this.f6240b = r10.f6247b;
            this.f6241c = r10.f6249d;
            this.f6242d = r10.f6250e;
            this.f6243e = r10.f6248c;
            this.f6244f = r10.f6251f;
        }

        public static /* synthetic */ xb.b a(e r8) {
            return r8.f6239a;
        }

        public static /* synthetic */ DayOfWeek b(e r8) {
            return r8.f6240b;
        }

        public static /* synthetic */ CalendarDay c(e r8) {
            return r8.f6241c;
        }

        public static /* synthetic */ CalendarDay d(e r8) {
            return r8.f6242d;
        }

        public static /* synthetic */ boolean e(e r8) {
            return r8.f6244f;
        }

        public static /* synthetic */ boolean f(e r8) {
            return r8.f6243e;
        }
    }

    public class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public xb.b f6246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public DayOfWeek f6247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6248c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CalendarDay f6249d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CalendarDay f6250e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f6251f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ MaterialCalendarView f6252g;

        public f(MaterialCalendarView r8) {
            this.f6252g = r8;
            this.f6248c = false;
            this.f6249d = null;
            this.f6250e = null;
            this.f6246a = xb.b.f13771b;
            this.f6247b = LocalDate.now().with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1).getDayOfWeek();
        }

        public final void a() {
            MaterialCalendarView r8 = this.f6252g;
            e r10 = new e(r8, this);
            int r11 = MaterialCalendarView.H;
            r8.b(r10);
        }

        public final void b(xb.b r8) {
            this.f6246a = r8;
        }

        public final void c(DayOfWeek r8) {
            this.f6247b = r8;
        }

        public final void d(boolean r8) {
            this.f6251f = r8;
        }

        public f(MaterialCalendarView r8, e r10) {
            this.f6252g = r8;
            this.f6246a = r10.f6239a;
            this.f6247b = r10.f6240b;
            this.f6249d = r10.f6241c;
            this.f6250e = r10.f6242d;
            this.f6248c = r10.f6243e;
            this.f6251f = r10.f6244f;
        }
    }

    public MaterialCalendarView(Context r11, AttributeSet r12) {
        super(r11, r12);
        new ArrayList();
        a r8 = new a(this);
        b r10 = new b(this);
        this.f6221u = null;
        this.f6222v = null;
        this.f6224x = 0;
        this.f6225y = -10;
        this.f6226z = -10;
        this.A = -10;
        this.B = -10;
        this.C = 1;
        this.D = true;
        setClipToPadding(false);
        setClipChildren(false);
        View r13 = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.calendar_view, null, false);
        this.f6218r = (LinearLayout) r13.findViewById(R.id.header);
        ImageView r14 = (ImageView) r13.findViewById(R.id.previous);
        this.f6213m = r14;
        TextView r15 = (TextView) r13.findViewById(R.id.month_name);
        this.f6212b = r15;
        ImageView r16 = (ImageView) r13.findViewById(R.id.next);
        this.f6214n = r16;
        xb.c r17 = new xb.c(getContext());
        this.f6215o = r17;
        r14.setOnClickListener(r8);
        r16.setOnClickListener(r8);
        q r18 = new q(r15);
        this.f6211a = r18;
        r17.setOnPageChangeListener(r10);
        r17.v(new c());
        TypedArray r19 = r11.getTheme().obtainStyledAttributes(r12, nb.a.f9511y, 0, 0);
        int r20 = r19.getInteger(1, 0);     // Catch: Throwable -> L31 Exception -> L33
        int r21 = r19.getInteger(3, -1);     // Catch: Throwable -> L31 Exception -> L33
        r18.c(r19.getInteger(17, 0));     // Catch: Throwable -> L31 Exception -> L33
        if (r21 < 1) goto L7;
        if (r21 > 7) goto L7;
        DayOfWeek r22 = DayOfWeek.of(r21);     // Catch: Throwable -> L31 Exception -> L33
    L8:
        this.E = r22;     // Catch: Throwable -> L31 Exception -> L33
        this.F = r19.getBoolean(11, true);     // Catch: Throwable -> L31 Exception -> L33
        f r23 = new f(this);     // Catch: Throwable -> L31 Exception -> L33
        r23.c(this.E);     // Catch: Throwable -> L31 Exception -> L33
        r23.b(xb.b.values()[r20]);     // Catch: Throwable -> L31 Exception -> L33
        r23.d(this.F);     // Catch: Throwable -> L31 Exception -> L33
        r23.a();     // Catch: Throwable -> L31 Exception -> L33
        setSelectionMode(r19.getInteger(9, 1));     // Catch: Throwable -> L31 Exception -> L33
        int r24 = r19.getLayoutDimension(14, -10);     // Catch: Throwable -> L31 Exception -> L33
        if (r24 <= (-10)) goto L11;
        setTileSize(r24);     // Catch: Throwable -> L31 Exception -> L33
    L11:
        int r25 = r19.getLayoutDimension(16, -10);     // Catch: Throwable -> L31 Exception -> L33
        if (r25 <= (-10)) goto L14;
        setTileWidth(r25);     // Catch: Throwable -> L31 Exception -> L33
    L14:
        int r26 = r19.getLayoutDimension(13, -10);     // Catch: Throwable -> L31 Exception -> L33
        if (r26 <= (-10)) goto L17;
        setTileHeight(r26);     // Catch: Throwable -> L31 Exception -> L33
    L17:
        int r27 = r19.getLayoutDimension(12, -10);     // Catch: Throwable -> L31 Exception -> L33
        if (r25 <= (-10)) goto L20;
        setTileHSpacing(r27);     // Catch: Throwable -> L31 Exception -> L33
    L20:
        int r28 = r19.getLayoutDimension(15, -10);     // Catch: Throwable -> L31 Exception -> L33
        if (r25 <= (-10)) goto L23;
        setTileVSpacing(r28);     // Catch: Throwable -> L31 Exception -> L33
    L23:
        setLeftArrow(r19.getResourceId(5, R.drawable.o_mcv_action_previous));     // Catch: Throwable -> L31 Exception -> L33
        setRightArrow(r19.getResourceId(7, R.drawable.o_mcv_action_next));     // Catch: Throwable -> L31 Exception -> L33
        TypedValue r29 = new TypedValue();     // Catch: Throwable -> L31 Exception -> L33
        r11.getTheme().resolveAttribute(android.R.attr.colorAccent, r29, true);     // Catch: Throwable -> L31 Exception -> L33
        setSelectionColor(r19.getColor(8, r29.data));     // Catch: Throwable -> L31 Exception -> L33
        CharSequence[] r110 = r19.getTextArray(18);     // Catch: Throwable -> L31 Exception -> L33
        if (r110 == null) goto L26;
        setWeekDayFormatter(new yb.a(r110));     // Catch: Throwable -> L31 Exception -> L33
    L26:
        CharSequence[] r111 = r19.getTextArray(6);     // Catch: Throwable -> L31 Exception -> L33
        if (r111 == null) goto L29;
        setTitleFormatter(new s(r111));     // Catch: Throwable -> L31 Exception -> L33
    L29:
        setHeaderTextAppearance(r19.getResourceId(4, R.style.TextAppearance_MaterialCalendarWidget_Header));     // Catch: Throwable -> L31 Exception -> L33
        setWeekDayTextAppearance(r19.getResourceId(19, R.style.TextAppearance_MaterialCalendarWidget_WeekDay));     // Catch: Throwable -> L31 Exception -> L33
        setDateTextAppearance(r19.getResourceId(2, R.style.TextAppearance_MaterialCalendarWidget_Date));     // Catch: Throwable -> L31 Exception -> L33
        setShowOtherDates(r19.getInteger(10, 4));     // Catch: Throwable -> L31 Exception -> L33
        setAllowClickDaysOutsideCurrentMonth(r19.getBoolean(0, true));     // Catch: Throwable -> L31 Exception -> L33
    L35:
        r19.recycle();
        addView(this.f6218r);
        xb.c r112 = this.f6215o;
        r112.setId(R.id.mcv_pager);
        r112.setOffscreenPageLimit(1);
        if (this.F == false) goto L38;
        int r113 = this.f6219s.f13774a + 1;
    L39:
        addView(r112, new d(r113));
        CalendarDay r114 = CalendarDay.A();
        this.f6217q = r114;
        setCurrentDate(r114);
        if (isInEditMode() == false) goto L48;
        removeView(this.f6215o);
        l r115 = new l(this, this.f6217q, getFirstDayOfWeek(), true);
        r115.l(getSelectionColor());
        r115.g(this.f6216p.d());
        r115.p(this.f6216p.h());
        r115.n(getShowOtherDates());
        addView(r115, new d(this.f6219s.f13774a + 1));
        return;
    L48:
        return;
    L38:
        r113 = this.f6219s.f13774a;
        goto L39
    L7:
        r22 = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek();     // Catch: Throwable -> L31 Exception -> L33
    L33:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        r19.recycle();
        throw th;
    }

    public static boolean d(int r8) {
        if ((r8 & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private int getWeekCountBasedOnMode() {
        xb.b r8 = this.f6219s;
        int r10 = r8.f13774a;
        if (r8.equals(xb.b.f13771b) == false) goto L12;
        if (this.f6220t == false) goto L12;
        xb.d<?> r11 = this.f6216p;
        if (r11 == null) goto L12;
        xb.c r12 = this.f6215o;
        if (r12 == null) goto L12;
        LocalDate r13 = r11.f(r12.getCurrentItem()).u();
        r10 = r13.withDayOfMonth(r13.lengthOfMonth()).get(WeekFields.of(this.E, 1).weekOfMonth());
    L12:
        if (this.F == true) goto L14;
        return r10;
    L14:
        return r10 + 1;
    }

    public final void a() {
        List<CalendarDay> r8 = getSelectedDates();
        xb.d<?> r10 = this.f6216p;
        r10.f13786m.clear();
        r10.j();
        Iterator<CalendarDay> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        CalendarDay r12 = r11.next();
        goto L4
    }

    public final void b(e r8) {
        xb.d<?> r10 = this.f6216p;
        xb.c r11 = this.f6215o;
        if (r10 != null) goto L5;
    L32:
        CalendarDay r12 = null;
    L33:
        this.G = r8;
        this.f6219s = e.a(r8);
        this.E = e.b(r8);
        this.f6221u = e.c(r8);
        this.f6222v = e.d(r8);
        this.F = e.e(r8);
        int r13 = this.f6219s.ordinal();
        if (r13 == 0) goto L39;
        if (r13 != 1) goto L38;
        xb.d<?> r14 = new xb.s(this);
    L40:
        xb.d<?> r15 = this.f6216p;
        if (r15 == null) goto L44;
        r15.l(r14);
    L44:
        this.f6216p = r14;
        r14.p(this.F);
        r11.setAdapter(this.f6216p);
        CalendarDay r16 = this.f6221u;
        CalendarDay r17 = this.f6222v;
        CalendarDay r18 = this.f6217q;
        this.f6216p.o(r16, r17);
        this.f6217q = r18;
        if (r16 != null) goto L47;
    L51:
        r11.t(this.f6216p.e(r18), false);
        e();
        if (this.F == false) goto L54;
        int r19 = this.f6219s.f13774a + 1;
    L55:
        r11.setLayoutParams(new d(r19));
        if (this.C == 1) goto L58;
    L60:
        CalendarDay r20 = CalendarDay.A();
    L61:
        setCurrentDate(r20);
        if (r12 == null) goto L64;
        r11.setCurrentItem(this.f6216p.e(r12));
    L64:
        xb.d<?> r21 = this.f6216p;
        r21.getClass();
        r21.f13791r = new ArrayList();
        Iterator<h> r22 = r21.f13790q.iterator();
    L66:
        if (r22.hasNext() == false) goto L70;
        h r23 = r22.next();
        i r24 = new i();
        r23.a();
        if (r24.f13816a == false) goto L66;
        r21.f13791r.add(new j(r23, r24));
        goto L66
    L70:
        Iterator r25 = r21.f13776c.iterator();
    L72:
        if (r25.hasNext() == false) goto L74;
        ((xb.e) r25.next()).j(r21.f13791r);
        goto L72
    L74:
        e();
        return;
    L58:
        if (this.f6216p.g().isEmpty() == true) goto L60;
        r20 = this.f6216p.g().get(0);
        goto L61
    L54:
        r19 = this.f6219s.f13774a;
        goto L55
    L47:
        if (r16.y(r18) == true) goto L50;
        r16 = this.f6217q;
    L50:
        this.f6217q = r16;
        goto L51
    L38:
        throw new IllegalArgumentException("Provided display mode which is not yet implemented");
    L39:
        r14 = new k(this);
        goto L40
    L5:
        if (e.f(r8) == false) goto L32;
        r12 = this.f6216p.f(r11.getCurrentItem());
        if (this.f6219s == e.a(r8)) goto L33;
        CalendarDay r26 = getSelectedDate();
        xb.b r27 = this.f6219s;
        if (r27 != xb.b.f13771b) goto L19;
        if (r26 == null) goto L19;
        CalendarDay r28 = CalendarDay.t(r12.u().plusDays(1));
        if (r26.equals(r12) == false) goto L14;
    L30:
        r12 = r26;
        goto L33
    L14:
        if (r26.y(r12) == false) goto L33;
        if (r26.z(r28) == false) goto L33;
    L19:
        if (r27 != xb.b.f13772m) goto L33;
        CalendarDay r29 = CalendarDay.t(r12.u().plusDays(6));
        if (r26 != null) goto L23;
    L31:
        r12 = r29;
        goto L33
    L23:
        if (r26.equals(r12) == true) goto L30;
        if (r26.equals(r29) == true) goto L30;
        if (r26.y(r12) == false) goto L31;
        if (r26.z(r29) == false) goto L31;
        goto L30
    }

    public final int c(int r8) {
        return (int) TypedValue.applyDimension(1, r8, getResources().getDisplayMetrics());
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r8) {
        return r8 instanceof d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray<Parcelable> r8) {
        dispatchThawSelfOnly(r8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray<Parcelable> r8) {
        dispatchFreezeSelfOnly(r8);
    }

    public final void e() {
        CalendarDay r8 = this.f6217q;
        q r10 = this.f6211a;
        r10.getClass();
        long r11 = System.currentTimeMillis();
        boolean r12 = true;
        if (r8 != null) goto L6;
    L18:
        xb.c r13 = this.f6215o;
        if (r13.getCurrentItem() <= 0) goto L21;
        boolean r14 = true;
    L22:
        ImageView r15 = this.f6213m;
        r15.setEnabled(r14);
        float r16 = 1.0f;
        if (r14 == false) goto L25;
        float r17 = 1.0f;
    L26:
        r15.setAlpha(r17);
        if (r13.getCurrentItem() < (this.f6216p.a() - 1)) goto L30;
        r12 = false;
    L30:
        ImageView r18 = this.f6214n;
        r18.setEnabled(r12);
        if (r12 == true) goto L34;
        r16 = 0.1f;
    L34:
        r18.setAlpha(r16);
        return;
    L25:
        r17 = 0.1f;
        goto L26
    L21:
        r14 = false;
        goto L22
    L6:
        if (TextUtils.isEmpty(r10.f13825a.getText()) == false) goto L8;
    L9:
        r10.a(r11, r8, false);
    L11:
        if (r8.equals(r10.f13833i) == true) goto L18;
        if (r8.w() == r10.f13833i.w()) goto L15;
    L17:
        r10.a(r11, r8, true);
        goto L18
    L15:
        if (r8.x() != r10.f13833i.x()) goto L17;
    L8:
        if ((r11 - r10.f13832h) >= r10.f13827c) goto L11;
        goto L9
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new d(1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r8) {
        return new d(1);
    }

    public CharSequence getCalendarContentDescription() {
        CharSequence r8 = this.f6223w;
        if (r8 == null) goto L6;
        return r8;
    L6:
        return getContext().getString(R.string.oui_calendar);
    }

    public xb.b getCalendarMode() {
        return this.f6219s;
    }

    public CalendarDay getCurrentDate() {
        return this.f6216p.f(this.f6215o.getCurrentItem());
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.E;
    }

    public Drawable getLeftArrow() {
        return this.f6213m.getDrawable();
    }

    public CalendarDay getMaximumDate() {
        return this.f6222v;
    }

    public CalendarDay getMinimumDate() {
        return this.f6221u;
    }

    public Drawable getRightArrow() {
        return this.f6214n.getDrawable();
    }

    public CalendarDay getSelectedDate() {
        List<CalendarDay> r8 = this.f6216p.g();
        if (r8.isEmpty() == false) goto L7;
        return null;
    L7:
        return r8.get(r8.size() - 1);
    }

    public List<CalendarDay> getSelectedDates() {
        return this.f6216p.g();
    }

    public int getSelectionColor() {
        return this.f6224x;
    }

    public int getSelectionMode() {
        return this.C;
    }

    public int getShowOtherDates() {
        return this.f6216p.f13782i;
    }

    public int getTileHSpacing() {
        return this.A;
    }

    public int getTileHeight() {
        return this.f6225y;
    }

    @Deprecated
    public int getTileSize() {
        return Math.max(this.f6225y, this.f6226z);
    }

    public int getTileVSpacing() {
        return this.B;
    }

    public int getTileWidth() {
        return this.f6226z;
    }

    public int getTitleAnimationOrientation() {
        return this.f6211a.f13831g;
    }

    public boolean getTopbarVisible() {
        if (this.f6218r.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent r8) {
        super.onInitializeAccessibilityEvent(r8);
        r8.setClassName(MaterialCalendarView.class.getName());
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r8) {
        super.onInitializeAccessibilityNodeInfo(r8);
        r8.setClassName(MaterialCalendarView.class.getName());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        int r14 = getChildCount();
        int r15 = getPaddingLeft();
        int r16 = ((r12 - r10) - r15) - getPaddingRight();
        int r17 = getPaddingTop();
        int r18 = 0;
    L3:
        if (r18 >= r14) goto L9;
        View r19 = getChildAt(r18);
        if (r19.getVisibility() == 8) goto L8;
        int r20 = r19.getMeasuredWidth();
        int r21 = ((r16 - r20) / 2) + r15;
        int r22 = r19.getMeasuredHeight() + r17;
        r19.layout(r21, r17, r20 + r21, r22);
        r17 = r22;
    L8:
        r18 = r18 + 1;
        goto L3
    }

    @Override // android.view.View
    public final void onMeasure(int r12, int r13) {
        int r8 = View.MeasureSpec.getSize(r12);
        int r10 = View.MeasureSpec.getMode(r12);
        int r11 = View.MeasureSpec.getSize(r13);
        int r14 = View.MeasureSpec.getMode(r13);
        int r15 = (r8 - getPaddingLeft()) - getPaddingRight();
        int r16 = (r11 - getPaddingTop()) - getPaddingBottom();
        int r17 = getWeekCountBasedOnMode();
        if (getTopbarVisible() == false) goto L5;
        r17 = r17 + 1;
    L5:
        int r18 = r15 / 7;
        int r19 = r16 / r17;
        int r20 = this.f6226z;
        if (r20 == (-10)) goto L8;
    L22:
        if (r20 <= 0) goto L24;
        r18 = r20;
    L24:
        int r21 = this.f6225y;
        if (r21 <= 0) goto L27;
        r19 = r21;
    L27:
        int r22 = r18;
        r18 = -1;
    L28:
        if (r18 <= 0) goto L30;
        r19 = r18;
    L39:
        int r23 = 0;
        int r24 = r18 * 7;
        int r25 = ((Math.max(this.B, 0) + r19) * Math.max(0, r17 - 1)) + r19;
        int r26 = (getPaddingRight() + getPaddingLeft()) + r24;
        int r27 = (getPaddingBottom() + getPaddingTop()) + r25;
        int r28 = View.MeasureSpec.getMode(r12);
        int r110 = View.MeasureSpec.getSize(r12);
        if (r28 == Integer.MIN_VALUE) goto L44;
        if (r28 != 1073741824) goto L45;
        r26 = r110;
    L45:
        int r111 = View.MeasureSpec.getMode(r13);
        int r112 = View.MeasureSpec.getSize(r13);
        if (r111 == Integer.MIN_VALUE) goto L50;
        if (r111 != 1073741824) goto L51;
        r27 = r112;
    L51:
        setMeasuredDimension(r26, r27);
        int r113 = getChildCount();
        int r114 = Math.max(this.A, 0);
    L52:
        if (r23 >= r113) goto L54;
        View r29 = getChildAt(r23);
        r29.measure(View.MeasureSpec.makeMeasureSpec((r114 * 6) + r24, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) ((d) r29.getLayoutParams())).height * r19, 1073741824));
        r23 = r23 + 1;
        goto L52
    L54:
        return;
    L50:
        r27 = Math.min(r27, r112);
        goto L51
    L44:
        r26 = Math.min(r26, r110);
        goto L45
    L30:
        if (r18 <= 0) goto L32;
    L38:
        r18 = r22;
        goto L39
    L32:
        if (r22 > 0) goto L34;
        r22 = c(44);
    L34:
        if (r19 > 0) goto L36;
        int r30 = c(44);
    L37:
        r19 = r30;
        goto L38
    L36:
        r30 = r19;
        goto L37
    L8:
        if (this.f6225y != (-10)) goto L22;
        if (r10 == 1073741824) goto L18;
        if (r10 == Integer.MIN_VALUE) goto L18;
        if (r14 == 1073741824) goto L17;
        if (r14 == Integer.MIN_VALUE) goto L17;
        r18 = -1;
        r22 = -1;
    L21:
        r19 = r22;
    L17:
        r18 = r19;
    L20:
        r22 = -1;
    L18:
        if (r14 != 1073741824) goto L20;
        r18 = Math.min(r18, r19);
        goto L20
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r8) {
        SavedState r10 = (SavedState) r8;
        super.onRestoreInstanceState(r10.getSuperState());
        e r11 = this.G;
        f r12 = new f(r11.f6245g, r11);
        r12.f6249d = r10.f6229m;
        r12.f6250e = r10.f6230n;
        r12.f6248c = r10.f6236t;
        r12.a();
        setShowOtherDates(r10.f6227a);
        setAllowClickDaysOutsideCurrentMonth(r10.f6228b);
        a();
        Iterator<CalendarDay> r13 = r10.f6231o.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        CalendarDay r14 = r13.next();
        if (r14 == null) goto L4;
        this.f6216p.n(r14, true);
        goto L4
    L9:
        setTopbarVisible(r10.f6232p);
        setSelectionMode(r10.f6233q);
        setDynamicHeightEnabled(r10.f6234r);
        setCurrentDate(r10.f6235s);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r8 = new SavedState(super.onSaveInstanceState());
        r8.f6227a = getShowOtherDates();
        r8.f6228b = this.D;
        r8.f6229m = getMinimumDate();
        r8.f6230n = getMaximumDate();
        r8.f6231o = getSelectedDates();
        r8.f6233q = getSelectionMode();
        r8.f6232p = getTopbarVisible();
        r8.f6234r = this.f6220t;
        r8.f6235s = this.f6217q;
        r8.f6236t = this.G.f6243e;
        return r8;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        return this.f6215o.dispatchTouchEvent(r8);
    }

    public void setAllowClickDaysOutsideCurrentMonth(boolean r8) {
        this.D = r8;
    }

    public void setContentDescriptionArrowFuture(CharSequence r8) {
        this.f6214n.setContentDescription(r8);
    }

    public void setContentDescriptionArrowPast(CharSequence r8) {
        this.f6213m.setContentDescription(r8);
    }

    public void setContentDescriptionCalendar(CharSequence r8) {
        this.f6223w = r8;
    }

    public void setCurrentDate(CalendarDay r8) {
        if (r8 == null) goto L6;
        int r10 = this.f6216p.e(r8);
        this.f6215o.t(r10, true);
        e();
        return;
    }

    public void setDateTextAppearance(int r8) {
        xb.d<?> r10 = this.f6216p;
        if (r8 != 0) goto L5;
        r10.getClass();
        return;
    L5:
        r10.f13780g = Integer.valueOf(r8);
        Iterator r11 = r10.f13776c.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        ((xb.e) r11.next()).g(r8);
        goto L7
    }

    public void setDayFormatter(yb.e r8) {
        xb.d<?> r10 = this.f6216p;
        if (r8 != null) goto L5;
        r8 = yb.e.f14109a;
    L5:
        yb.e r11 = r10.f13789p;
        if (r11 != r10.f13788o) goto L8;
        r11 = r8;
    L8:
        r10.f13789p = r11;
        r10.f13788o = r8;
        Iterator r12 = r10.f13776c.iterator();
    L10:
        if (r12.hasNext() == false) goto L12;
        ((xb.e) r12.next()).h(r8);
        goto L10
    }

    public void setDayFormatterContentDescription(yb.e r8) {
        xb.d<?> r10 = this.f6216p;
        r10.f13789p = r8;
        Iterator r11 = r10.f13776c.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((xb.e) r11.next()).i(r8);
        goto L4
    }

    public void setDynamicHeightEnabled(boolean r8) {
        this.f6220t = r8;
    }

    public void setHeaderTextAppearance(int r8) {
        this.f6212b.setTextAppearance(getContext(), r8);
    }

    public void setLeftArrow(int r8) {
        this.f6213m.setImageResource(r8);
    }

    public void setOnDateChangedListener(n r8) {
    }

    public void setOnDateLongClickListener(m r8) {
    }

    public void setOnMonthChangedListener(o r8) {
    }

    public void setOnRangeSelectedListener(p r8) {
    }

    public void setOnTitleClickListener(View.OnClickListener r8) {
        this.f6212b.setOnClickListener(r8);
    }

    public void setPagingEnabled(boolean r8) {
        this.f6215o.f13775l0 = r8;
        e();
    }

    public void setRightArrow(int r8) {
        this.f6214n.setImageResource(r8);
    }

    public void setSelectedDate(CalendarDay r8) {
        a();
        if (r8 == null) goto L6;
        this.f6216p.n(r8, true);
        return;
    }

    public void setSelectionColor(int r8) {
        if (r8 == 0) goto L4;
    L7:
        this.f6224x = r8;
        xb.d<?> r10 = this.f6216p;
        r10.f13779f = Integer.valueOf(r8);
        Iterator r11 = r10.f13776c.iterator();
    L9:
        if (r11.hasNext() == false) goto L11;
        ((xb.e) r11.next()).l(r8);
        goto L9
    L11:
        invalidate();
        return;
    L4:
        if (isInEditMode() == true) goto L6;
        return;
    L6:
        r8 = -7829368;
        goto L7
    }

    public void setSelectionMode(int r8) {
        int r10 = this.C;
        this.C = r8;
        boolean r11 = false;
        if (r8 == 1) goto L9;
        if (r8 == 2) goto L14;
        if (r8 == 3) goto L8;
        this.C = 0;
        if (r10 == 0) goto L14;
    L8:
        a();
    L14:
        xb.d<?> r12 = this.f6216p;
        if (this.C == 0) goto L17;
        r11 = true;
    L17:
        r12.f13792s = r11;
        Iterator r13 = r12.f13776c.iterator();
    L19:
        if (r13.hasNext() == false) goto L21;
        ((xb.e) r13.next()).m(r12.f13792s);
        goto L19
    L21:
        return;
    L9:
        if (r10 == 2) goto L12;
        if (r10 != 3) goto L14;
    L12:
        if (getSelectedDates().isEmpty() == true) goto L14;
        setSelectedDate(getSelectedDate());
        goto L14
    }

    public void setShowOtherDates(int r8) {
        xb.d<?> r10 = this.f6216p;
        r10.f13782i = r8;
        Iterator r11 = r10.f13776c.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((xb.e) r11.next()).n(r8);
        goto L4
    }

    public void setTileHSpacing(int r8) {
        this.A = r8;
        requestLayout();
    }

    public void setTileHeight(int r8) {
        this.f6225y = r8;
        requestLayout();
    }

    public void setTileHeightDp(int r8) {
        setTileHeight(c(r8));
    }

    public void setTileSize(int r8) {
        this.f6226z = r8;
        this.f6225y = r8;
        requestLayout();
    }

    public void setTileSizeDp(int r8) {
        setTileSize(c(r8));
    }

    public void setTileVSpacing(int r8) {
        this.B = r8;
        requestLayout();
    }

    public void setTileWidth(int r8) {
        this.f6226z = r8;
        requestLayout();
    }

    public void setTileWidthDp(int r8) {
        setTileWidth(c(r8));
    }

    public void setTitleAnimationOrientation(int r8) {
        this.f6211a.f13831g = r8;
    }

    public void setTitleFormatter(yb.f r8) {
        q r10 = this.f6211a;
        if (r8 != null) goto L5;
        r10.getClass();
        yb.f r11 = yb.f.f14110a;
    L6:
        r10.f13826b = r11;
        xb.d<?> r12 = this.f6216p;
        if (r8 != null) goto L9;
        r12.getClass();
        yb.d r13 = yb.f.f14110a;
    L9:
        r12.getClass();
        e();
        return;
    L5:
        r11 = r8;
        goto L6
    }

    public void setTitleMonths(int r8) {
        setTitleMonths(getResources().getTextArray(r8));
    }

    public void setTopbarVisible(boolean r8) {
        if (r8 == false) goto L4;
        int r10 = 0;
    L5:
        this.f6218r.setVisibility(r10);
        requestLayout();
        return;
    L4:
        r10 = 8;
        goto L5
    }

    public void setWeekDayFormatter(g r8) {
        xb.d<?> r10 = this.f6216p;
        if (r8 != null) goto L5;
        r8 = g.f14111a;
    L5:
        r10.f13787n = r8;
        Iterator r11 = r10.f13776c.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        ((xb.e) r11.next()).o(r8);
        goto L7
    }

    public void setWeekDayLabels(int r8) {
        setWeekDayLabels(getResources().getTextArray(r8));
    }

    public void setWeekDayTextAppearance(int r8) {
        xb.d<?> r10 = this.f6216p;
        if (r8 != 0) goto L5;
        r10.getClass();
        return;
    L5:
        r10.f13781h = Integer.valueOf(r8);
        Iterator r11 = r10.f13776c.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        ((xb.e) r11.next()).p(r8);
        goto L7
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r8) {
        return new d(1);
    }

    public void setCurrentDate(LocalDate r8) {
        setCurrentDate(CalendarDay.t(r8));
    }

    public void setSelectedDate(LocalDate r8) {
        setSelectedDate(CalendarDay.t(r8));
    }

    public void setTitleMonths(CharSequence[] r8) {
        setTitleFormatter(new s(r8));
    }

    public void setWeekDayLabels(CharSequence[] r8) {
        setWeekDayFormatter(new yb.a(r8));
    }
}
