package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.AlertController;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class AppCompatSpinner extends Spinner {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @SuppressLint({"ResourceType"})
    public static final int[] f972s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.appcompat.widget.d f973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f974b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final v f975m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SpinnerAdapter f976n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f977o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final h f978p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f979q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Rect f980r;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f981a;

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
            if (r8.readByte() == 0) goto L5;
            boolean r10 = true;
        L6:
            this.f981a = r10;
            return;
        L5:
            r10 = false;
            goto L6
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            super.writeToParcel(r8, r10);
            r8.writeByte(this.f981a ? 1 : 0);
        }
    }

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatSpinner f982a;

        public a(AppCompatSpinner r8) {
            this.f982a = r8;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            AppCompatSpinner r8 = this.f982a;
            if (r8.getInternalPopup().isShowing() == true) goto L5;
            int r10 = c.b(r8);
            int r11 = c.a(r8);
            r8.f978p.show(r10, r11);
        L5:
            ViewTreeObserver r12 = r8.getViewTreeObserver();
            if (r12 == null) goto L9;
            b.a(r12, this);
            return;
        }
    }

    public static final class b {
        public static void a(ViewTreeObserver r8, ViewTreeObserver.OnGlobalLayoutListener r10) {
            r8.removeOnGlobalLayoutListener(r10);
        }
    }

    public static final class c {
        public static int a(View r8) {
            return r8.getTextAlignment();
        }

        public static int b(View r8) {
            return r8.getTextDirection();
        }

        public static void c(View r8, int r10) {
            r8.setTextAlignment(r10);
        }

        public static void d(View r8, int r10) {
            r8.setTextDirection(r10);
        }
    }

    public static final class d {
        public static void a(ThemedSpinnerAdapter r8, Resources.Theme r10) {
            if (i0.b.a(r8.getDropDownViewTheme(), r10) == true) goto L6;
            r8.setDropDownViewTheme(r10);
            return;
        }
    }

    public class e implements h, DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public androidx.appcompat.app.d f983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ListAdapter f984b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public CharSequence f985m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ AppCompatSpinner f986n;

        public e(AppCompatSpinner r8) {
            this.f986n = r8;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.h
        public final void b(int r8) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.h
        public final void dismiss() {
            androidx.appcompat.app.d r8 = this.f983a;
            if (r8 == null) goto L6;
            r8.dismiss();
            this.f983a = null;
            return;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.h
        public final Drawable getBackground() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.h
        public final CharSequence getHintText() {
            return this.f985m;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.h
        public final int getHorizontalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.h
        public final int getVerticalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.h
        public final boolean isShowing() {
            androidx.appcompat.app.d r8 = this.f983a;
            if (r8 != null) goto L7;
            return false;
        L7:
            return r8.isShowing();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r8, int r10) {
            AppCompatSpinner r11 = this.f986n;
            r11.setSelection(r10);
            if (r11.getOnItemClickListener() == null) goto L5;
            r11.performItemClick(null, r10, this.f984b.getItemId(r10));
        L5:
            dismiss();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.h
        public final void setAdapter(ListAdapter r8) {
            this.f984b = r8;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.h
        public final void setBackgroundDrawable(Drawable r8) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.h
        public final void setHorizontalOffset(int r8) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.h
        public final void setPromptText(CharSequence r8) {
            this.f985m = r8;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.h
        public final void setVerticalOffset(int r8) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.h
        public final void show(int r8, int r10) {
            if (this.f984b != null) goto L5;
            return;
        L5:
            AppCompatSpinner r11 = this.f986n;
            androidx.appcompat.app.d.a r12 = new androidx.appcompat.app.d.a(r11.getPopupContext());
            CharSequence r13 = this.f985m;
            AlertController.b r14 = r12.f642a;
            if (r13 == null) goto L8;
            r14.f565d = r13;
        L8:
            ListAdapter r15 = this.f984b;
            int r16 = r11.getSelectedItemPosition();
            r14.f568g = r15;
            r14.f569h = this;
            r14.f571j = r16;
            r14.f570i = true;
            androidx.appcompat.app.d r17 = r12.a();
            this.f983a = r17;
            AlertController.RecycleListView r18 = r17.f641p.f539e;
            c.d(r18, r8);
            c.c(r18, r10);
            this.f983a.show();
        }
    }

    public static class f implements ListAdapter, SpinnerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SpinnerAdapter f987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ListAdapter f988b;

        public f(SpinnerAdapter r8, Resources.Theme r10) {
            this.f987a = r8;
            if ((r8 instanceof ListAdapter) == false) goto L5;
            this.f988b = (ListAdapter) r8;
        L5:
            if (r10 != null) goto L7;
            return;
        L7:
            if ((r8 instanceof ThemedSpinnerAdapter) == false) goto L10;
            d.a((ThemedSpinnerAdapter) r8, r10);
            return;
        L10:
            if ((r8 instanceof r0) == false) goto L17;
            r0 r11 = (r0) r8;
            if (r11.getDropDownViewTheme() != null) goto L18;
            r11.a();
            return;
        L18:
            return;
        }

        @Override // android.widget.ListAdapter
        public final boolean areAllItemsEnabled() {
            ListAdapter r8 = this.f988b;
            if (r8 != null) goto L5;
            return true;
        L5:
            return r8.areAllItemsEnabled();
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            SpinnerAdapter r8 = this.f987a;
            if (r8 != null) goto L6;
            return 0;
        L6:
            return r8.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public final View getDropDownView(int r8, View r10, ViewGroup r11) {
            SpinnerAdapter r12 = this.f987a;
            if (r12 != null) goto L6;
            return null;
        L6:
            return r12.getDropDownView(r8, r10, r11);
        }

        @Override // android.widget.Adapter
        public final Object getItem(int r8) {
            SpinnerAdapter r10 = this.f987a;
            if (r10 != null) goto L6;
            return null;
        L6:
            return r10.getItem(r8);
        }

        @Override // android.widget.Adapter
        public final long getItemId(int r8) {
            SpinnerAdapter r10 = this.f987a;
            if (r10 != null) goto L6;
            return -1;
        L6:
            return r10.getItemId(r8);
        }

        @Override // android.widget.Adapter
        public final int getItemViewType(int r8) {
            return 0;
        }

        @Override // android.widget.Adapter
        public final View getView(int r8, View r10, ViewGroup r11) {
            return getDropDownView(r8, r10, r11);
        }

        @Override // android.widget.Adapter
        public final int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public final boolean hasStableIds() {
            SpinnerAdapter r8 = this.f987a;
            if (r8 != null) goto L5;
        L7:
            return false;
        L5:
            if (r8.hasStableIds() == false) goto L7;
            return true;
        }

        @Override // android.widget.Adapter
        public final boolean isEmpty() {
            if (getCount() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // android.widget.ListAdapter
        public final boolean isEnabled(int r8) {
            ListAdapter r10 = this.f988b;
            if (r10 != null) goto L5;
            return true;
        L5:
            return r10.isEnabled(r8);
        }

        @Override // android.widget.Adapter
        public final void registerDataSetObserver(DataSetObserver r8) {
            SpinnerAdapter r10 = this.f987a;
            if (r10 == null) goto L6;
            r10.registerDataSetObserver(r8);
            return;
        }

        @Override // android.widget.Adapter
        public final void unregisterDataSetObserver(DataSetObserver r8) {
            SpinnerAdapter r10 = this.f987a;
            if (r10 == null) goto L6;
            r10.unregisterDataSetObserver(r8);
            return;
        }
    }

    public class g extends i0 implements h {
        public CharSequence K;
        public ListAdapter L;
        public final Rect M;
        public int N;
        public final /* synthetic */ AppCompatSpinner O;

        public class a implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f989a;

            public a(g r8) {
                this.f989a = r8;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> r8, View r10, int r11, long r12) {
                g r13 = this.f989a;
                r13.O.setSelection(r11);
                if (r13.O.getOnItemClickListener() == null) goto L5;
                r13.O.performItemClick(r10, r11, r13.L.getItemId(r11));
            L5:
                r13.dismiss();
            }
        }

        public class b implements ViewTreeObserver.OnGlobalLayoutListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f990a;

            public b(g r8) {
                this.f990a = r8;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                g r8 = this.f990a;
                AppCompatSpinner r10 = r8.O;
                r8.getClass();
                WeakHashMap<View, j0.h0> r11 = j0.w.f8437a;
                if (j0.w.g.b(r10) == true) goto L5;
            L7:
                boolean r12 = false;
            L8:
                if (r12 == true) goto L10;
                r8.dismiss();
                return;
            L10:
                r8.j();
                r8.show();
                return;
            L5:
                if (r10.getGlobalVisibleRect(r8.M) == false) goto L7;
                r12 = true;
                goto L8
            }
        }

        public class c implements PopupWindow.OnDismissListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f991a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ g f992b;

            public c(g r8, b r10) {
                this.f992b = r8;
                this.f991a = r10;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                ViewTreeObserver r8 = this.f992b.O.getViewTreeObserver();
                if (r8 == null) goto L6;
                r8.removeGlobalOnLayoutListener(this.f991a);
                return;
            }
        }

        public g(AppCompatSpinner r8, Context r10, AttributeSet r11, int r12) {
            this.O = r8;
            super(r10, r11, r12, 0);
            this.M = new Rect();
            this.f1184y = r8;
            this.I = true;
            this.J.setFocusable(true);
            this.f1185z = new a(this);
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.h
        public final void b(int r8) {
            this.N = r8;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.h
        public final CharSequence getHintText() {
            return this.K;
        }

        public final void j() {
            Drawable r8 = getBackground();
            AppCompatSpinner r10 = this.O;
            if (r8 == null) goto L8;
            r8.getPadding(r10.f980r);
            if (b1.a(r10) == false) goto L7;
            int r11 = r10.f980r.right;
        L9:
            int r12 = r10.getPaddingLeft();
            int r13 = r10.getPaddingRight();
            int r14 = r10.getWidth();
            int r15 = r10.f979q;
            if (r15 != (-2)) goto L16;
            int r16 = r10.a((SpinnerAdapter) this.L, getBackground());
            int r17 = r10.getContext().getResources().getDisplayMetrics().widthPixels;
            Rect r18 = r10.f980r;
            int r19 = (r17 - r18.left) - r18.right;
            if (r16 <= r19) goto L14;
            r16 = r19;
        L14:
            r15 = Math.max(r16, (r14 - r12) - r13);
        L18:
            i(r15);
            if (b1.a(r10) == false) goto L21;
            int r20 = (((r14 - r13) - this.f1174o) - this.N) + r11;
        L22:
            this.f1175p = r20;
            return;
        L21:
            r20 = (r12 + this.N) + r11;
            goto L22
        L16:
            if (r15 != (-1)) goto L18;
            r15 = (r14 - r12) - r13;
            goto L18
        L7:
            r11 = -r10.f980r.left;
            goto L9
        L8:
            Rect r21 = r10.f980r;
            r21.right = 0;
            r21.left = 0;
            r11 = 0;
            goto L9
        }

        @Override // androidx.appcompat.widget.i0, androidx.appcompat.widget.AppCompatSpinner.h
        public final void setAdapter(ListAdapter r8) {
            super.setAdapter(r8);
            this.L = r8;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.h
        public final void setPromptText(CharSequence r8) {
            this.K = r8;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.h
        public final void show(int r8, int r10) {
            boolean r11 = isShowing();
            j();
            p r12 = this.J;
            r12.setInputMethodMode(2);
            show();
            e0 r13 = this.f1172m;
            r13.setChoiceMode(1);
            c.d(r13, r8);
            c.c(r13, r10);
            AppCompatSpinner r14 = this.O;
            int r15 = r14.getSelectedItemPosition();
            e0 r16 = this.f1172m;
            if (isShowing() == false) goto L8;
            if (r16 == null) goto L8;
            r16.setListSelectionHidden(false);
            r16.setSelection(r15);
            if (r16.getChoiceMode() == 0) goto L8;
            r16.setItemChecked(r15, true);
        L8:
            if (r11 == false) goto L10;
            return;
        L10:
            ViewTreeObserver r17 = r14.getViewTreeObserver();
            if (r17 == null) goto L14;
            b r18 = new b(this);
            r17.addOnGlobalLayoutListener(r18);
            r12.setOnDismissListener(new c(this, r18));
            return;
        }
    }

    public interface h {
        void b(int r8);

        void dismiss();

        Drawable getBackground();

        CharSequence getHintText();

        int getHorizontalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter r8);

        void setBackgroundDrawable(Drawable r8);

        void setHorizontalOffset(int r8);

        void setPromptText(CharSequence r8);

        void setVerticalOffset(int r8);

        void show(int r8, int r10);
    }

    static {
        f972s = new int[]{R.attr.spinnerMode};
    }

    public AppCompatSpinner(Context r11, AttributeSet r12, int r13) {
        super(r11, r12, r13);
        this.f980r = new Rect();
        q0.a(this, getContext());
        int[] r8 = c.a.f3236v;
        v0 r10 = new v0(r11, r11.obtainStyledAttributes(r12, r8, r13, 0));
        this.f973a = new androidx.appcompat.widget.d(this);
        int r14 = r10.i(4, 0);
        if (r14 == 0) goto L5;
        this.f974b = new g.d(r11, r14);
    L6:
        int r15 = -1;
        TypedArray r16 = null;
        TypedArray r17 = r11.obtainStyledAttributes(r12, f972s, r13, 0);     // Catch: Throwable -> L16 Exception -> L18
    L14:
        Exception e10 = e;
    L20:
        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e10);     // Catch: Throwable -> L12
        if (r17 == null) goto L24;
    L22:
        r17.recycle();
    L24:
        if (r15 == 0) goto L28;
        if (r15 != 1) goto L29;
        g r18 = new g(this, this.f974b, r12, r13);
        v0 r19 = v0.m(this.f974b, r12, r8, r13);
        this.f979q = r19.f1275b.getLayoutDimension(3, -2);
        r18.setBackgroundDrawable(r19.e(1));
        r18.K = r10.j(2);
        r19.n();
        this.f978p = r18;
        this.f975m = new v(this, this, r18);
    L29:
        CharSequence[] r20 = r10.f1275b.getTextArray(0);
        if (r20 == null) goto L32;
        ArrayAdapter r21 = new ArrayAdapter(r11, R.layout.simple_spinner_item, r20);
        r21.setDropDownViewResource(com.obric.cae.R.layout.support_simple_spinner_dropdown_item);
        setAdapter(r21);
    L32:
        r10.n();
        this.f977o = true;
        SpinnerAdapter r110 = this.f976n;
        if (r110 == null) goto L35;
        setAdapter(r110);
        this.f976n = null;
    L35:
        this.f973a.d(r12, r13);
        return;
    L28:
        e r22 = new e(this);
        this.f978p = r22;
        r22.f985m = r10.j(2);
    L12:
        th = th;
        r16 = r17;
    L37:
        if (r16 == null) goto L39;
        r16.recycle();
    L39:
        throw th;
    L9:
        if (r17.hasValue(0) == false) goto L22;
        r15 = r17.getInt(0, 0);     // Catch: Throwable -> L12 Exception -> L14
        goto L22
    L18:
        e = move-exception;
        e10 = e;
        r17 = null;
    L16:
        th = th;
        goto L37
    L5:
        this.f974b = r11;
        goto L6
    }

    public final int a(SpinnerAdapter r11, Drawable r12) {
        int r8 = 0;
        if (r11 != null) goto L5;
        return 0;
    L5:
        int r10 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int r13 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int r14 = Math.max(0, getSelectedItemPosition());
        int r15 = Math.min(r11.getCount(), r14 + 15);
        int r16 = Math.max(0, r14 - (15 - (r15 - r14)));
        View r17 = null;
        int r18 = 0;
    L6:
        if (r16 >= r15) goto L14;
        int r19 = r11.getItemViewType(r16);
        if (r19 == r8) goto L10;
        r17 = null;
        r8 = r19;
    L10:
        r17 = r11.getView(r16, r17, this);
        if (r17.getLayoutParams() != null) goto L13;
        r17.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    L13:
        r17.measure(r10, r13);
        r18 = Math.max(r18, r17.getMeasuredWidth());
        r16 = r16 + 1;
        goto L6
    L14:
        if (r12 == null) goto L20;
        Rect r110 = this.f980r;
        r12.getPadding(r110);
        return r18 + (r110.left + r110.right);
    L20:
        return r18;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.d r8 = this.f973a;
        if (r8 == null) goto L6;
        r8.a();
        return;
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        h r8 = this.f978p;
        if (r8 == null) goto L7;
        return r8.getHorizontalOffset();
    L7:
        return super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        h r8 = this.f978p;
        if (r8 == null) goto L7;
        return r8.getVerticalOffset();
    L7:
        return super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f978p == null) goto L7;
        return this.f979q;
    L7:
        return super.getDropDownWidth();
    }

    public final h getInternalPopup() {
        return this.f978p;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        h r8 = this.f978p;
        if (r8 == null) goto L7;
        return r8.getBackground();
    L7:
        return super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f974b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        h r8 = this.f978p;
        if (r8 == null) goto L6;
        return r8.getHintText();
    L6:
        return super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        androidx.appcompat.widget.d r8 = this.f973a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.b();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        androidx.appcompat.widget.d r8 = this.f973a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.c();
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h r8 = this.f978p;
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.isShowing() == false) goto L9;
        r8.dismiss();
        return;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
        if (this.f978p != null) goto L5;
        return;
    L5:
        if (View.MeasureSpec.getMode(r8) != Integer.MIN_VALUE) goto L9;
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(r8)), getMeasuredHeight());
        return;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable r8) {
        SavedState r10 = (SavedState) r8;
        super.onRestoreInstanceState(r10.getSuperState());
        if (r10.f981a == false) goto L8;
        ViewTreeObserver r11 = getViewTreeObserver();
        if (r11 == null) goto L9;
        r11.addOnGlobalLayoutListener(new a(this));
        return;
    L9:
        return;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r8 = new SavedState(super.onSaveInstanceState());
        h r10 = this.f978p;
        if (r10 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        r8.f981a = r11;
        return r8;
    L5:
        if (r10.isShowing() == false) goto L7;
        r11 = true;
        goto L8
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        v r10 = this.f975m;
        if (r10 == null) goto L9;
        if (r10.onTouch(this, r8) == false) goto L9;
        return true;
    L9:
        return super.onTouchEvent(r8);
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        h r8 = this.f978p;
        if (r8 == null) goto L10;
        if (r8.isShowing() == true) goto L11;
        r8.show(c.b(this), c.a(this));
        return true;
    L11:
        return true;
    L10:
        return super.performClick();
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter r8) {
        setAdapter((SpinnerAdapter) r8);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r8) {
        super.setBackgroundDrawable(r8);
        androidx.appcompat.widget.d r10 = this.f973a;
        if (r10 == null) goto L6;
        r10.e();
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(int r8) {
        super.setBackgroundResource(r8);
        androidx.appcompat.widget.d r10 = this.f973a;
        if (r10 == null) goto L6;
        r10.f(r8);
        return;
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int r8) {
        h r10 = this.f978p;
        if (r10 == null) goto L5;
        r10.b(r8);
        r10.setHorizontalOffset(r8);
        return;
    L5:
        super.setDropDownHorizontalOffset(r8);
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int r8) {
        h r10 = this.f978p;
        if (r10 == null) goto L5;
        r10.setVerticalOffset(r8);
        return;
    L5:
        super.setDropDownVerticalOffset(r8);
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int r8) {
        if (this.f978p == null) goto L5;
        this.f979q = r8;
        return;
    L5:
        super.setDropDownWidth(r8);
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable r8) {
        h r10 = this.f978p;
        if (r10 == null) goto L5;
        r10.setBackgroundDrawable(r8);
        return;
    L5:
        super.setPopupBackgroundDrawable(r8);
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int r8) {
        setPopupBackgroundDrawable(d.a.a(getPopupContext(), r8));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence r8) {
        h r10 = this.f978p;
        if (r10 == null) goto L5;
        r10.setPromptText(r8);
        return;
    L5:
        super.setPrompt(r8);
    }

    public void setSupportBackgroundTintList(ColorStateList r8) {
        androidx.appcompat.widget.d r10 = this.f973a;
        if (r10 == null) goto L6;
        r10.h(r8);
        return;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode r8) {
        androidx.appcompat.widget.d r10 = this.f973a;
        if (r10 == null) goto L6;
        r10.i(r8);
        return;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner
    public void setAdapter(SpinnerAdapter r8) {
        if (this.f977o == true) goto L6;
        this.f976n = r8;
        return;
    L6:
        super.setAdapter(r8);
        h r10 = this.f978p;
        if (r10 == null) goto L13;
        Context r11 = this.f974b;
        if (r11 != null) goto L11;
        r11 = getContext();
    L11:
        r10.setAdapter(new f(r8, r11.getTheme()));
        return;
    }
}
