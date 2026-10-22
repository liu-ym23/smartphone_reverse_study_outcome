package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.internal.CheckableImageButton;
import com.obric.cae.R;
import j0.k0;
import j0.n0;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class r<S> extends androidx.fragment.app.l {
    public final LinkedHashSet<View.OnClickListener> A;
    public final LinkedHashSet<DialogInterface.OnCancelListener> B;
    public final LinkedHashSet<DialogInterface.OnDismissListener> C;
    public int D;
    public DateSelector<S> E;
    public z<S> F;
    public CalendarConstraints G;
    public DayViewDecorator H;
    public i<S> I;
    public int J;
    public CharSequence K;
    public boolean L;
    public int M;
    public int N;
    public CharSequence O;
    public int P;
    public CharSequence Q;
    public int R;
    public CharSequence S;
    public int T;
    public CharSequence U;
    public TextView V;
    public TextView W;
    public CheckableImageButton X;
    public aa.f Y;
    public Button Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f4717a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public CharSequence f4718b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public CharSequence f4719c0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final LinkedHashSet<t<? super S>> f4720z;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f4721a;

        public a(r r8) {
            this.f4721a = r8;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            r r10 = this.f4721a;
            Iterator<t<? super S>> r11 = r10.f4720z.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            t<? super S> r12 = r11.next();
            r10.d().p();
            r12.a();
            goto L4
        L6:
            r10.a(false, false);
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f4722a;

        public b(r r8) {
            this.f4722a = r8;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            r r10 = this.f4722a;
            Iterator<View.OnClickListener> r11 = r10.A.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            r11.next().onClick(r8);
            goto L4
        L6:
            r10.a(false, false);
        }
    }

    public class c extends y<S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f4723a;

        public c(r r8) {
            this.f4723a = r8;
        }

        @Override // com.google.android.material.datepicker.y
        public final void a() {
            this.f4723a.Z.setEnabled(false);
        }

        @Override // com.google.android.material.datepicker.y
        public final void b(S r8) {
            r r10 = this.f4723a;
            String r11 = r10.d().d(r10.getContext());
            r10.W.setContentDescription(r10.d().a(r10.requireContext()));
            r10.W.setText(r11);
            r10.Z.setEnabled(r10.d().h());
        }
    }

    public r() {
        this.f4720z = new LinkedHashSet();
        this.A = new LinkedHashSet();
        this.B = new LinkedHashSet();
        this.C = new LinkedHashSet();
    }

    public static int e(Context r8) {
        Resources r10 = r8.getResources();
        int r11 = r10.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        Month r12 = new Month(g0.f());
        int r13 = r10.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width);
        int r14 = r10.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding);
        int r15 = r12.f4624n;
        int r16 = r13 * r15;
        return ((r15 - 1) * r14) + (r16 + (r11 * 2));
    }

    public static boolean f(Context r8) {
        return g(r8, android.R.attr.windowFullscreen);
    }

    public static boolean g(Context r8, int r10) {
        TypedArray r11 = r8.obtainStyledAttributes(x9.b.c(r8, R.attr.materialCalendarStyle, i.class.getCanonicalName()).data, new int[]{r10});
        boolean r12 = r11.getBoolean(0, false);
        r11.recycle();
        return r12;
    }

    @Override // androidx.fragment.app.l
    public final Dialog b() {
        Context r8 = requireContext();
        Context r10 = requireContext();
        int r11 = this.D;
        if (r11 != 0) goto L6;
        r11 = d().b(r10);
    L6:
        Dialog r12 = new Dialog(r8, r11);
        Context r13 = r12.getContext();
        this.L = f(r13);
        this.Y = new aa.f(r13, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        TypedArray r14 = r13.obtainStyledAttributes(null, g9.a.f7772m, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        int r15 = r14.getColor(1, 0);
        r14.recycle();
        this.Y.i(r13);
        this.Y.k(ColorStateList.valueOf(r15));
        aa.f r16 = this.Y;
        View r17 = r12.getWindow().getDecorView();
        WeakHashMap<View, j0.h0> r18 = j0.w.f8437a;
        r16.j(j0.w.i.i(r17));
        return r12;
    }

    public final DateSelector<S> d() {
        if (this.E != null) goto L6;
        this.E = (DateSelector) getArguments().getParcelable("DATE_SELECTOR_KEY");
    L6:
        return this.E;
    }

    public final void h() {
        Context r8 = requireContext();
        int r10 = this.D;
        if (r10 != 0) goto L6;
        r10 = d().b(r8);
    L6:
        DateSelector<S> r11 = d();
        CalendarConstraints r12 = this.G;
        DayViewDecorator r13 = this.H;
        u r14 = new i();
        Bundle r15 = new Bundle();
        r15.putInt("THEME_RES_ID_KEY", r10);
        r15.putParcelable("GRID_SELECTOR_KEY", r11);
        r15.putParcelable("CALENDAR_CONSTRAINTS_KEY", r12);
        r15.putParcelable("DAY_VIEW_DECORATOR_KEY", r13);
        r15.putParcelable("CURRENT_MONTH_KEY", r12.f4602n);
        r14.setArguments(r15);
        this.I = r14;
        boolean r16 = true;
        if (this.M != 1) goto L9;
        DateSelector<S> r17 = d();
        CalendarConstraints r18 = this.G;
        u r19 = new u();
        Bundle r20 = new Bundle();
        r20.putInt("THEME_RES_ID_KEY", r10);
        r20.putParcelable("DATE_SELECTOR_KEY", r17);
        r20.putParcelable("CALENDAR_CONSTRAINTS_KEY", r18);
        r19.setArguments(r20);
        r14 = r19;
    L9:
        this.F = r14;
        TextView r21 = this.V;
        if (this.M == 1) goto L12;
    L17:
        CharSequence r22 = this.f4718b0;
    L18:
        r21.setText(r22);
        String r23 = d().d(getContext());
        this.W.setContentDescription(d().a(requireContext()));
        this.W.setText(r23);
        FragmentManager r24 = getChildFragmentManager();
        r24.getClass();
        androidx.fragment.app.a r25 = new androidx.fragment.app.a(r24);
        r25.e(R.id.mtrl_calendar_frame, this.F, null, 2);
        if (r25.f2073g == true) goto L23;
        r25.f2074h = false;
        r25.f1923q.y(r25, false);
        this.F.a(new c(this));
        return;
    L23:
        throw new IllegalStateException("This transaction is already being added to the back stack");
    L12:
        if (getResources().getConfiguration().orientation == 2) goto L15;
        r16 = false;
    L15:
        if (r16 == false) goto L17;
        r22 = this.f4719c0;
        goto L18
    }

    @Override // androidx.fragment.app.l, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r8) {
        Iterator<DialogInterface.OnCancelListener> r10 = this.B.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onCancel(r8);
        goto L4
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r8) {
        super.onCreate(r8);
        if (r8 != null) goto L5;
        r8 = getArguments();
    L5:
        this.D = r8.getInt("OVERRIDE_THEME_RES_ID");
        this.E = (DateSelector) r8.getParcelable("DATE_SELECTOR_KEY");
        this.G = (CalendarConstraints) r8.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.H = (DayViewDecorator) r8.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.J = r8.getInt("TITLE_TEXT_RES_ID_KEY");
        this.K = r8.getCharSequence("TITLE_TEXT_KEY");
        this.M = r8.getInt("INPUT_MODE_KEY");
        this.N = r8.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.O = r8.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.P = r8.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.Q = r8.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.R = r8.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.S = r8.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.T = r8.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.U = r8.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence r10 = this.K;
        if (r10 != null) goto L9;
        r10 = requireContext().getResources().getText(this.J);
    L9:
        this.f4718b0 = r10;
        if (r10 == null) goto L14;
        CharSequence[] r11 = TextUtils.split(String.valueOf(r10), "\n");
        if (r11.length <= 1) goto L15;
        r10 = r11[0];
    L15:
        this.f4719c0 = r10;
        return;
    L14:
        r10 = null;
        goto L15
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r8, ViewGroup r10, Bundle r11) {
        if (this.L == false) goto L5;
        int r12 = R.layout.mtrl_picker_fullscreen;
    L6:
        View r13 = r8.inflate(r12, r10);
        Context r14 = r13.getContext();
        if (this.L == false) goto L9;
        View r15 = r13.findViewById(R.id.mtrl_calendar_frame);
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(e(r14), -2);
    L10:
        r15.setLayoutParams(r16);
        TextView r17 = (TextView) r13.findViewById(R.id.mtrl_picker_header_selection_text);
        this.W = r17;
        WeakHashMap<View, j0.h0> r18 = j0.w.f8437a;
        j0.w.g.f(r17, 1);
        this.X = (CheckableImageButton) r13.findViewById(R.id.mtrl_picker_header_toggle);
        this.V = (TextView) r13.findViewById(R.id.mtrl_picker_title_text);
        this.X.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton r19 = this.X;
        StateListDrawable r20 = new StateListDrawable();
        r20.addState(new int[]{android.R.attr.state_checked}, d.a.a(r14, R.drawable.material_ic_calendar_black_24dp));
        r20.addState(new int[0], d.a.a(r14, R.drawable.material_ic_edit_black_24dp));
        r19.setImageDrawable(r20);
        CheckableImageButton r21 = this.X;
        if (this.M == 0) goto L13;
        boolean r22 = true;
    L14:
        r21.setChecked(r22);
        j0.w.m(this.X, null);
        CheckableImageButton r23 = this.X;
        int r24 = this.M;
        Context r25 = r23.getContext();
        if (r24 != 1) goto L17;
        int r26 = R.string.mtrl_picker_toggle_to_calendar_input_mode;
    L18:
        this.X.setContentDescription(r25.getString(r26));
        this.X.setOnClickListener(new q(this, 0));
        this.Z = (Button) r13.findViewById(R.id.confirm_button);
        if (d().h() == false) goto L21;
        this.Z.setEnabled(true);
    L22:
        this.Z.setTag("CONFIRM_BUTTON_TAG");
        CharSequence r27 = this.O;
        if (r27 == null) goto L25;
        this.Z.setText(r27);
    L28:
        CharSequence r28 = this.Q;
        if (r28 == null) goto L32;
        this.Z.setContentDescription(r28);
    L34:
        this.Z.setOnClickListener(new a(this));
        Button r29 = (Button) r13.findViewById(R.id.cancel_button);
        r29.setTag("CANCEL_BUTTON_TAG");
        CharSequence r30 = this.S;
        if (r30 == null) goto L37;
        r29.setText(r30);
    L40:
        CharSequence r31 = this.U;
        if (r31 == null) goto L44;
    L46:
        r29.setContentDescription(r31);
    L47:
        r29.setOnClickListener(new b(this));
        return r13;
    L44:
        if (this.T == 0) goto L47;
        r31 = getContext().getResources().getText(this.T);
        goto L46
    L37:
        int r32 = this.R;
        if (r32 == 0) goto L40;
        r29.setText(r32);
        goto L40
    L32:
        if (this.P == 0) goto L34;
        this.Z.setContentDescription(getContext().getResources().getText(this.P));
        goto L34
    L25:
        int r33 = this.N;
        if (r33 == 0) goto L28;
        this.Z.setText(r33);
        goto L28
    L21:
        this.Z.setEnabled(false);
        goto L22
    L17:
        r26 = R.string.mtrl_picker_toggle_to_text_input_mode;
        goto L18
    L13:
        r22 = false;
        goto L14
    L9:
        r15 = r13.findViewById(R.id.mtrl_calendar_main_pane);
        r16 = new LinearLayout.LayoutParams(e(r14), -1);
        goto L10
    L5:
        r12 = R.layout.mtrl_picker_dialog;
        goto L6
    }

    @Override // androidx.fragment.app.l, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r8) {
        Iterator<DialogInterface.OnDismissListener> r10 = this.C.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onDismiss(r8);
        goto L4
    L6:
        ViewGroup r11 = (ViewGroup) getView();
        if (r11 == null) goto L9;
        r11.removeAllViews();
    L9:
        super.onDismiss(r8);
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r12) {
        super.onSaveInstanceState(r12);
        r12.putInt("OVERRIDE_THEME_RES_ID", this.D);
        r12.putParcelable("DATE_SELECTOR_KEY", this.E);
        CalendarConstraints.b r8 = new CalendarConstraints.b(this.G);
        i<S> r10 = this.I;
        Month r11 = null;
        if (r10 != null) goto L5;
        Month r13 = null;
    L6:
        if (r13 == null) goto L8;
        r8.f4610c = Long.valueOf(r13.f4626p);
    L8:
        Bundle r14 = new Bundle();
        r14.putParcelable("DEEP_COPY_VALIDATOR_KEY", r8.f4612e);
        Month r15 = Month.u(r8.f4608a);
        Month r16 = Month.u(r8.f4609b);
        CalendarConstraints.DateValidator r17 = (CalendarConstraints.DateValidator) r14.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long r18 = r8.f4610c;
        if (r18 == null) goto L12;
        r11 = Month.u(r18.longValue());
    L12:
        r12.putParcelable("CALENDAR_CONSTRAINTS_KEY", new CalendarConstraints(r15, r16, r17, r11, r8.f4611d));
        r12.putParcelable("DAY_VIEW_DECORATOR_KEY", this.H);
        r12.putInt("TITLE_TEXT_RES_ID_KEY", this.J);
        r12.putCharSequence("TITLE_TEXT_KEY", this.K);
        r12.putInt("INPUT_MODE_KEY", this.M);
        r12.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.N);
        r12.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.O);
        r12.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.P);
        r12.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.Q);
        r12.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.R);
        r12.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.S);
        r12.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.T);
        r12.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.U);
        return;
    L5:
        r13 = r10.f4688p;
        goto L6
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Window r8 = c().getWindow();
        if (this.L == false) goto L50;
        r8.setLayout(-1, -1);
        r8.setBackgroundDrawable(this.Y);
        if (this.f4717a0 == true) goto L51;
        View r10 = requireView().findViewById(R.id.fullscreen_header);
        ColorStateList r11 = r9.a.a(r10.getBackground());
        if (r11 == null) goto L10;
        Integer r12 = Integer.valueOf(r11.getDefaultColor());
    L12:
        if (r12 != null) goto L14;
    L17:
        boolean r13 = true;
    L18:
        int r14 = t2.b.y(r8.getContext(), android.R.attr.colorBackground, -16777216);
        if (r13 == false) goto L21;
        r12 = Integer.valueOf(r14);
    L21:
        Integer r15 = Integer.valueOf(r14);
        k0.a(r8, false);
        r8.getContext();
        r8.getContext();
        r8.setStatusBarColor(0);
        r8.setNavigationBarColor(0);
        boolean r16 = t2.b.F(r12.intValue());
        if (t2.b.F(0) == true) goto L26;
        if (r16 == true) goto L26;
        boolean r17 = false;
    L27:
        r8.getDecorView();
        n0.a r18 = new n0(r8).f8429a;
        WindowInsetsController r19 = r18.f8430a;
        Window r20 = r18.f8431b;
        if (r17 == false) goto L32;
        if (r20 == null) goto L31;
        View r21 = r20.getDecorView();
        r21.setSystemUiVisibility(r21.getSystemUiVisibility() | 8192);
    L31:
        r19.setSystemBarsAppearance(8, 8);
    L35:
        boolean r22 = t2.b.F(r15.intValue());
        if (t2.b.F(0) == true) goto L40;
        if (r22 == true) goto L40;
        boolean r23 = false;
    L41:
        r8.getDecorView();
        n0.a r24 = new n0(r8).f8429a;
        WindowInsetsController r25 = r24.f8430a;
        Window r26 = r24.f8431b;
        if (r23 == false) goto L46;
        if (r26 == null) goto L45;
        View r27 = r26.getDecorView();
        r27.setSystemUiVisibility(r27.getSystemUiVisibility() | 16);
    L45:
        r25.setSystemBarsAppearance(16, 16);
    L49:
        s r28 = new s(r10.getLayoutParams().height, r10, r10.getPaddingTop());
        WeakHashMap<View, j0.h0> r29 = j0.w.f8437a;
        j0.w.i.u(r10, r28);
        this.f4717a0 = true;
        goto L51
    L46:
        if (r26 == null) goto L48;
        View r30 = r26.getDecorView();
        r30.setSystemUiVisibility(r30.getSystemUiVisibility() & (-17));
    L48:
        r25.setSystemBarsAppearance(0, 16);
    L40:
        r23 = true;
        goto L41
    L32:
        if (r20 == null) goto L34;
        View r31 = r20.getDecorView();
        r31.setSystemUiVisibility(r31.getSystemUiVisibility() & (-8193));
    L34:
        r19.setSystemBarsAppearance(0, 8);
    L26:
        r17 = true;
        goto L27
    L14:
        if (r12.intValue() == 0) goto L17;
        r13 = false;
        goto L18
    L10:
        r12 = null;
    L51:
        h();
        return;
    L50:
        r8.setLayout(-2, -2);
        int r32 = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
        Rect r33 = new Rect(r32, r32, r32, r32);
        r8.setBackgroundDrawable(new InsetDrawable(this.Y, r32, r32, r32, r32));
        r8.getDecorView().setOnTouchListener(new q9.a(c(), r33));
        goto L51
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public final void onStop() {
        this.F.f4748a.clear();
        super.onStop();
    }
}
