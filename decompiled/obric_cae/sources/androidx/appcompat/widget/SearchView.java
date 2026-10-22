package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.customview.view.AbsSavedState;
import com.obric.cae.R;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements g.c {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final /* synthetic */ int f1019n0 = 0;
    public final View A;
    public final View B;
    public final View C;
    public final ImageView D;
    public final ImageView E;
    public final ImageView F;
    public final ImageView G;
    public final View H;
    public o I;
    public final Rect J;
    public final Rect K;
    public final int[] L;
    public final int[] M;
    public final ImageView N;
    public final Drawable O;
    public final int P;
    public final int Q;
    public final Intent R;
    public final Intent S;
    public final CharSequence T;
    public View.OnFocusChangeListener U;
    public View.OnClickListener V;
    public boolean W;
    public boolean X;
    public n0.a Y;
    public boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public CharSequence f1020a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f1021b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f1022c0;
    public int d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f1023e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public CharSequence f1024f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f1025g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f1026h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public SearchableInfo f1027i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public Bundle f1028j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final b f1029k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final c f1030l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final WeakHashMap<String, Drawable.ConstantState> f1031m0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final SearchAutoComplete f1032z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f1033m;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel r8) {
                return new SavedState(r8, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r8) {
                return new SavedState[r8];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel r8, ClassLoader r10) {
                return new SavedState(r8, r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r8, ClassLoader r10) {
            super(r8, r10);
            this.f1033m = ((Boolean) r8.readValue(null)).booleanValue();
        }

        public final String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1033m + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            r8.writeParcelable(this.f1731a, r10);
            r8.writeValue(Boolean.valueOf(this.f1033m));
        }
    }

    public static class SearchAutoComplete extends androidx.appcompat.widget.c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f1034o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public SearchView f1035p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f1036q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final a f1037r;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SearchAutoComplete f1038a;

            public a(SearchAutoComplete r8) {
                this.f1038a = r8;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SearchAutoComplete r8 = this.f1038a;
                if (r8.f1036q == false) goto L6;
                ((InputMethodManager) r8.getContext().getSystemService("input_method")).showSoftInput(r8, 0);
                r8.f1036q = false;
                return;
            }
        }

        public SearchAutoComplete(Context r8, AttributeSet r10) {
            super(r8, r10, 0);
            this.f1037r = new a(this);
            this.f1034o = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration r8 = getResources().getConfiguration();
            int r10 = r8.screenWidthDp;
            int r11 = r8.screenHeightDp;
            if (r10 < 960) goto L11;
            if (r11 < 720) goto L11;
            if (r8.orientation != 2) goto L11;
            return 256;
        L11:
            if (r10 < 600) goto L13;
            return 192;
        L13:
            if (r10 >= 640) goto L15;
            return 160;
        L15:
            if (r11 >= 480) goto L22;
            return 160;
        L22:
            return 192;
        }

        @Override // android.widget.AutoCompleteTextView
        public final boolean enoughToFilter() {
            if (this.f1034o > 0) goto L5;
        L8:
            return true;
        L5:
            if (super.enoughToFilter() == true) goto L8;
            return false;
        }

        @Override // androidx.appcompat.widget.c, android.widget.TextView, android.view.View
        public final InputConnection onCreateInputConnection(EditorInfo r8) {
            InputConnection r10 = super.onCreateInputConnection(r8);
            if (this.f1036q == false) goto L5;
            a r11 = this.f1037r;
            removeCallbacks(r11);
            post(r11);
        L5:
            return r10;
        }

        @Override // android.view.View
        public final void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onFocusChanged(boolean r8, int r10, Rect r11) {
            super.onFocusChanged(r8, r10, r11);
            SearchView r12 = this.f1035p;
            r12.v(r12.X);
            r12.post(r12.f1029k0);
            SearchAutoComplete r13 = r12.f1032z;
            if (r13.hasFocus() == false) goto L6;
            k.a(r13);
            return;
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final boolean onKeyPreIme(int r8, KeyEvent r10) {
            if (r8 != 4) goto L24;
            if (r10.getAction() != 0) goto L13;
            if (r10.getRepeatCount() != 0) goto L13;
            KeyEvent.DispatcherState r11 = getKeyDispatcherState();
            if (r11 == null) goto L11;
            r11.startTracking(r10, this);
        L11:
            return true;
        L13:
            if (r10.getAction() != 1) goto L24;
            KeyEvent.DispatcherState r12 = getKeyDispatcherState();
            if (r12 == null) goto L18;
            r12.handleUpEvent(r10);
        L18:
            if (r10.isTracking() == false) goto L24;
            if (r10.isCanceled() == true) goto L24;
            this.f1035p.clearFocus();
            setImeVisibility(false);
            return true;
        L24:
            return super.onKeyPreIme(r8, r10);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onWindowFocusChanged(boolean r8) {
            super.onWindowFocusChanged(r8);
            if (r8 == true) goto L5;
            return;
        L5:
            if (this.f1035p.hasFocus() == true) goto L7;
            return;
        L7:
            if (getVisibility() != 0) goto L19;
            this.f1036q = true;
            Context r10 = getContext();
            int r11 = SearchView.f1019n0;
            if (r10.getResources().getConfiguration().orientation != 2) goto L11;
            boolean r12 = true;
        L12:
            if (r12 == false) goto L20;
            k.b(this, 1);
            if (enoughToFilter() == false) goto L21;
            showDropDown();
            return;
        L21:
            return;
        L20:
            return;
        L11:
            r12 = false;
            goto L12
        }

        @Override // android.widget.AutoCompleteTextView
        public final void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public final void replaceText(CharSequence r8) {
        }

        public void setImeVisibility(boolean r8) {
            InputMethodManager r10 = (InputMethodManager) getContext().getSystemService("input_method");
            a r11 = this.f1037r;
            if (r8 == true) goto L7;
            this.f1036q = false;
            removeCallbacks(r11);
            r10.hideSoftInputFromWindow(getWindowToken(), 0);
            return;
        L7:
            if (r10.isActive(this) == false) goto L10;
            this.f1036q = false;
            removeCallbacks(r11);
            r10.showSoftInput(this, 0);
            return;
        L10:
            this.f1036q = true;
        }

        public void setSearchView(SearchView r8) {
            this.f1035p = r8;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int r8) {
            super.setThreshold(r8);
            this.f1034o = r8;
        }
    }

    public class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchView f1039a;

        public a(SearchView r8) {
            this.f1039a = r8;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r8) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r8, int r10, int r11, int r12) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r8, int r10, int r11, int r12) {
            SearchView r13 = this.f1039a;
            Editable r14 = r13.f1032z.getText();
            r13.f1024f0 = r14;
            boolean r15 = !TextUtils.isEmpty(r14);
            r13.u(r15);
            boolean r16 = !r15;
            int r17 = 8;
            if (r13.f1023e0 == true) goto L5;
        L8:
            r13.G.setVisibility(r17);
            r13.q();
            r13.t();
            r8.toString();
            r13.getClass();
            return;
        L5:
            if (r13.X == true) goto L8;
            if (r16 == false) goto L8;
            r13.E.setVisibility(8);
            r17 = 0;
            goto L8
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchView f1040a;

        public b(SearchView r8) {
            this.f1040a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f1040a.r();
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchView f1041a;

        public c(SearchView r8) {
            this.f1041a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            n0.a r8 = this.f1041a.Y;
            if ((r8 instanceof p0) == false) goto L6;
            r8.c(null);
            return;
        }
    }

    public class d implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchView f1042a;

        public d(SearchView r8) {
            this.f1042a = r8;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r8, boolean r10) {
            SearchView r11 = this.f1042a;
            View.OnFocusChangeListener r12 = r11.U;
            if (r12 == null) goto L6;
            r12.onFocusChange(r11, r10);
            return;
        }
    }

    public class e implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchView f1043a;

        public e(SearchView r8) {
            this.f1043a = r8;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r8, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17) {
            SearchView r18 = this.f1043a;
            View r19 = r18.H;
            if (r19.getWidth() <= 1) goto L14;
            Resources r20 = r18.getContext().getResources();
            int r21 = r18.B.getPaddingLeft();
            Rect r22 = new Rect();
            boolean r23 = b1.a(r18);
            if (r18.W == false) goto L7;
            int r24 = r20.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width);
            int r25 = r20.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) + r24;
        L8:
            SearchAutoComplete r26 = r18.f1032z;
            r26.getDropDownBackground().getPadding(r22);
            if (r23 == false) goto L11;
            int r27 = -r22.left;
        L12:
            r26.setDropDownHorizontalOffset(r27);
            r26.setDropDownWidth((((r19.getWidth() + r22.left) + r22.right) + r25) - r21);
            return;
        L11:
            r27 = r21 - (r22.left + r25);
            goto L12
        L7:
            r25 = 0;
            goto L8
        }
    }

    public class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchView f1044a;

        public f(SearchView r8) {
            this.f1044a = r8;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            SearchView r10 = this.f1044a;
            ImageView r11 = r10.D;
            SearchAutoComplete r12 = r10.f1032z;
            if (r8 != r11) goto L8;
            r10.v(false);
            r12.requestFocus();
            r12.setImeVisibility(true);
            View.OnClickListener r13 = r10.V;
            if (r13 == null) goto L34;
            r13.onClick(r10);
            return;
        L34:
            return;
        L8:
            if (r8 != r10.F) goto L11;
            r10.l();
            return;
        L11:
            if (r8 != r10.E) goto L14;
            r10.p();
            return;
        L14:
            if (r8 != r10.G) goto L30;
            SearchableInfo r14 = r10.f1027i0;
            if (r14 == null) goto L42;
        L29:
            Log.w("SearchView", "Could not find voice search activity");
            return;
        L19:
            if (r14.getVoiceSearchLaunchWebSearch() == false) goto L26;
            Intent r15 = new Intent(r10.R);     // Catch: ActivityNotFoundException -> L29
            ComponentName r16 = r14.getSearchActivity();     // Catch: ActivityNotFoundException -> L29
            if (r16 != null) goto L23;
            String r17 = null;
        L24:
            r15.putExtra("calling_package", r17);     // Catch: ActivityNotFoundException -> L29
            r10.getContext().startActivity(r15);     // Catch: ActivityNotFoundException -> L29
            return;
        L23:
            r17 = r16.flattenToShortString();     // Catch: ActivityNotFoundException -> L29
            goto L24
        L26:
            if (r14.getVoiceSearchLaunchRecognizer() == false) goto L39;
            Intent r18 = r10.k(r10.S, r14);     // Catch: ActivityNotFoundException -> L29
            r10.getContext().startActivity(r18);     // Catch: ActivityNotFoundException -> L29
            return;
        L39:
            return;
        L42:
            return;
        L30:
            if (r8 != r12) goto L41;
            k.a(r12);
            return;
        }
    }

    public class g implements View.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchView f1045a;

        public g(SearchView r8) {
            this.f1045a = r8;
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View r8, int r10, KeyEvent r11) {
            SearchView r12 = this.f1045a;
            if (r12.f1027i0 != null) goto L5;
            return false;
        L5:
            SearchAutoComplete r13 = r12.f1032z;
            if (r13.isPopupShowing() == false) goto L43;
            if (r13.getListSelection() == (-1)) goto L43;
            if (r12.f1027i0 != null) goto L13;
            return false;
        L13:
            if (r12.Y != null) goto L16;
            return false;
        L16:
            if (r11.getAction() == 0) goto L18;
            return false;
        L18:
            if (r11.hasNoModifiers() == false) goto L56;
            if (r10 != 66) goto L21;
        L39:
            r12.m(r13.getListSelection());
        L41:
            return true;
        L21:
            if (r10 == 84) goto L39;
            if (r10 == 61) goto L39;
            if (r10 != 21) goto L28;
        L33:
            if (r10 != 21) goto L35;
            int r14 = 0;
        L36:
            r13.setSelection(r14);
            r13.setListSelection(0);
            r13.clearListSelection();
            k.b(r13, 1);
            if (r13.enoughToFilter() == false) goto L41;
            r13.showDropDown();
            goto L41
        L35:
            r14 = r13.length();
            goto L36
        L28:
            if (r10 == 22) goto L33;
            if (r10 != 19) goto L57;
            r13.getListSelection();
            return false;
        L57:
            return false;
        L56:
            return false;
        L43:
            if (TextUtils.getTrimmedLength(r13.getText()) != 0) goto L45;
            boolean r15 = true;
        L46:
            if (r15 == false) goto L48;
        L54:
            return false;
        L48:
            if (r11.hasNoModifiers() == false) goto L54;
            if (r11.getAction() != 1) goto L54;
            if (r10 != 66) goto L54;
            r8.cancelLongPress();
            r12.getContext().startActivity(r12.j("android.intent.action.SEARCH", null, null, r13.getText().toString()));
            return true;
        L45:
            r15 = false;
            goto L46
        }
    }

    public class h implements TextView.OnEditorActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchView f1046a;

        public h(SearchView r8) {
            this.f1046a = r8;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r8, int r10, KeyEvent r11) {
            this.f1046a.p();
            return true;
        }
    }

    public class i implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchView f1047a;

        public i(SearchView r8) {
            this.f1047a = r8;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> r8, View r10, int r11, long r12) {
            this.f1047a.m(r11);
        }
    }

    public class j implements AdapterView.OnItemSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchView f1048a;

        public j(SearchView r8) {
            this.f1048a = r8;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onItemSelected(AdapterView<?> r8, View r10, int r11, long r12) {
            this.f1048a.n(r11);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onNothingSelected(AdapterView<?> r8) {
        }
    }

    public static class k {
        public static void a(AutoCompleteTextView r8) {
            r8.refreshAutoCompleteResults();
        }

        public static void b(SearchAutoComplete r8, int r10) {
            r8.setInputMethodMode(r10);
        }
    }

    public interface l {
    }

    public interface m {
    }

    public interface n {
    }

    public static class o extends TouchDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f1049a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f1050b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Rect f1051c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Rect f1052d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f1053e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f1054f;

        public o(Rect r8, Rect r10, SearchAutoComplete r11) {
            super(r8, r11);
            int r12 = ViewConfiguration.get(r11.getContext()).getScaledTouchSlop();
            this.f1053e = r12;
            Rect r13 = new Rect();
            this.f1050b = r13;
            Rect r14 = new Rect();
            this.f1052d = r14;
            Rect r15 = new Rect();
            this.f1051c = r15;
            r13.set(r8);
            r14.set(r8);
            int r16 = -r12;
            r14.inset(r16, r16);
            r15.set(r10);
            this.f1049a = r11;
        }

        @Override // android.view.TouchDelegate
        public final boolean onTouchEvent(MotionEvent r10) {
            int r8 = (int) r10.getX();
            int r11 = (int) r10.getY();
            int r12 = r10.getAction();
            boolean r13 = true;
            if (r12 == 0) goto L17;
            if (r12 == 1) goto L10;
            if (r12 == 2) goto L10;
            if (r12 != 3) goto L19;
            boolean r14 = this.f1054f;
            this.f1054f = false;
        L15:
            r13 = r14;
            boolean r15 = true;
        L20:
            if (r13 == false) goto L29;
            Rect r16 = this.f1051c;
            View r17 = this.f1049a;
            if (r15 == true) goto L24;
        L26:
            float r18 = r8 - r16.left;
            int r19 = r11 - r16.top;
        L27:
            r10.setLocation(r18, r19);
            return r17.dispatchTouchEvent(r10);
        L24:
            if (r16.contains(r8, r11) == true) goto L26;
            r18 = r17.getWidth() / 2;
            r19 = r17.getHeight() / 2;
            goto L27
        L29:
            return false;
        L19:
            r15 = true;
            r13 = false;
        L10:
            r14 = this.f1054f;
            if (r14 == false) goto L15;
            if (this.f1052d.contains(r8, r11) == true) goto L15;
            r13 = r14;
            r15 = false;
            goto L20
        L17:
            if (this.f1050b.contains(r8, r11) == false) goto L19;
            this.f1054f = true;
            r15 = true;
            goto L20
        }
    }

    public SearchView(Context r8) {
        this(r8, null);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence r8) {
        SearchAutoComplete r10 = this.f1032z;
        r10.setText(r8);
        if (TextUtils.isEmpty(r8) == false) goto L5;
        int r11 = 0;
    L6:
        r10.setSelection(r11);
        return;
    L5:
        r11 = r8.length();
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        this.f1022c0 = true;
        super.clearFocus();
        SearchAutoComplete r8 = this.f1032z;
        r8.clearFocus();
        r8.setImeVisibility(false);
        this.f1022c0 = false;
    }

    public int getImeOptions() {
        return this.f1032z.getImeOptions();
    }

    public int getInputType() {
        return this.f1032z.getInputType();
    }

    public int getMaxWidth() {
        return this.d0;
    }

    public CharSequence getQuery() {
        return this.f1032z.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence r8 = this.f1020a0;
        if (r8 != null) goto L13;
        SearchableInfo r10 = this.f1027i0;
        if (r10 == null) goto L11;
        if (r10.getHintId() == 0) goto L11;
        return getContext().getText(this.f1027i0.getHintId());
    L11:
        return this.T;
    L13:
        return r8;
    }

    public int getSuggestionCommitIconResId() {
        return this.Q;
    }

    public int getSuggestionRowLayout() {
        return this.P;
    }

    public n0.a getSuggestionsAdapter() {
        return this.Y;
    }

    public final Intent j(String r8, Uri r10, String r11, String r12) {
        Intent r13 = new Intent(r8);
        r13.addFlags(268435456);
        if (r10 == null) goto L5;
        r13.setData(r10);
    L5:
        r13.putExtra("user_query", this.f1024f0);
        if (r12 == null) goto L8;
        r13.putExtra("query", r12);
    L8:
        if (r11 == null) goto L10;
        r13.putExtra("intent_extra_data_key", r11);
    L10:
        Bundle r14 = this.f1028j0;
        if (r14 == null) goto L13;
        r13.putExtra("app_data", r14);
    L13:
        r13.setComponent(this.f1027i0.getSearchActivity());
        return r13;
    }

    public final Intent k(Intent r8, SearchableInfo r10) {
        ComponentName r11 = r10.getSearchActivity();
        Intent r12 = new Intent("android.intent.action.SEARCH");
        r12.setComponent(r11);
        PendingIntent r13 = PendingIntent.getActivity(getContext(), 0, r12, 1107296256);
        Bundle r14 = new Bundle();
        Bundle r15 = this.f1028j0;
        if (r15 == null) goto L5;
        r14.putParcelable("app_data", r15);
    L5:
        Intent r16 = new Intent(r8);
        Resources r17 = getResources();
        if (r10.getVoiceLanguageModeId() == 0) goto L8;
        String r18 = r17.getString(r10.getVoiceLanguageModeId());
    L9:
        String r19 = null;
        if (r10.getVoicePromptTextId() == 0) goto L12;
        String r20 = r17.getString(r10.getVoicePromptTextId());
    L14:
        if (r10.getVoiceLanguageId() == 0) goto L16;
        String r21 = r17.getString(r10.getVoiceLanguageId());
    L18:
        if (r10.getVoiceMaxResults() == 0) goto L20;
        int r22 = r10.getVoiceMaxResults();
    L21:
        r16.putExtra("android.speech.extra.LANGUAGE_MODEL", r18);
        r16.putExtra("android.speech.extra.PROMPT", r20);
        r16.putExtra("android.speech.extra.LANGUAGE", r21);
        r16.putExtra("android.speech.extra.MAX_RESULTS", r22);
        if (r11 == null) goto L25;
        r19 = r11.flattenToShortString();
    L25:
        r16.putExtra("calling_package", r19);
        r16.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", r13);
        r16.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", r14);
        return r16;
    L20:
        r22 = 1;
        goto L21
    L16:
        r21 = null;
        goto L18
    L12:
        r20 = null;
        goto L14
    L8:
        r18 = "free_form";
        goto L9
    }

    public final void l() {
        SearchAutoComplete r8 = this.f1032z;
        if (TextUtils.isEmpty(r8.getText()) == true) goto L5;
        r8.setText("");
        r8.requestFocus();
        r8.setImeVisibility(true);
        return;
    L5:
        if (this.W == false) goto L9;
        clearFocus();
        v(true);
        return;
    }

    public final void m(int r8) {
        Cursor r10 = this.Y.f9408m;
        if (r10 != null) goto L5;
    L35:
        SearchAutoComplete r11 = this.f1032z;
        r11.setImeVisibility(false);
        r11.dismissDropDown();
        return;
    L5:
        if (r10.moveToPosition(r8) == false) goto L35;
        Intent r12 = null;
        int r13 = p0.H;     // Catch: RuntimeException -> L24
        String r14 = p0.i(r10, r10.getColumnIndex("suggest_intent_action"));     // Catch: RuntimeException -> L24
        if (r14 != null) goto L10;
        r14 = this.f1027i0.getSuggestIntentAction();     // Catch: RuntimeException -> L24
    L10:
        if (r14 != null) goto L12;
        r14 = "android.intent.action.SEARCH";
    L12:
        String r15 = p0.i(r10, r10.getColumnIndex("suggest_intent_data"));     // Catch: RuntimeException -> L24
        if (r15 != null) goto L15;
        r15 = this.f1027i0.getSuggestIntentData();     // Catch: RuntimeException -> L24
    L15:
        if (r15 == null) goto L19;
        String r16 = p0.i(r10, r10.getColumnIndex("suggest_intent_data_id"));     // Catch: RuntimeException -> L24
        if (r16 == null) goto L19;
        r15 = r15 + "/" + Uri.encode(r16);     // Catch: RuntimeException -> L24
    L19:
        if (r15 != null) goto L21;
        Uri r17 = null;
    L22:
        r12 = j(r14, r17, p0.i(r10, r10.getColumnIndex("suggest_intent_extra_data")), p0.i(r10, r10.getColumnIndex("suggest_intent_query")));     // Catch: RuntimeException -> L24
    L29:
        if (r12 == null) goto L35;
        getContext().startActivity(r12);     // Catch: RuntimeException -> L33
    L33:
        e = move-exception;
        Log.e("SearchView", "Failed launch activity: " + r12, e);
        goto L35
    L21:
        r17 = Uri.parse(r15);     // Catch: RuntimeException -> L24
    L24:
        e = move-exception;
        int r18 = r10.getPosition();     // Catch: RuntimeException -> L27
    L28:
        Log.w("SearchView", "Search suggestions cursor at row " + r18 + " returned exception.", e);
    L27:
        r18 = -1;
        goto L28
    }

    public final void n(int r8) {
        Editable r10 = this.f1032z.getText();
        Cursor r11 = this.Y.f9408m;
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.moveToPosition(r8) == false) goto L10;
        String r12 = this.Y.d(r11);
        if (r12 == null) goto L10;
        setQuery(r12);
        return;
    L10:
        setQuery(r10);
    }

    public final void o(CharSequence r8) {
        setQuery(r8);
    }

    @Override // g.c
    public final void onActionViewCollapsed() {
        SearchAutoComplete r8 = this.f1032z;
        r8.setText("");
        r8.setSelection(r8.length());
        this.f1024f0 = "";
        clearFocus();
        v(true);
        r8.setImeOptions(this.f1026h0);
        this.f1025g0 = false;
    }

    @Override // g.c
    public final void onActionViewExpanded() {
        if (this.f1025g0 == false) goto L5;
        return;
    L5:
        this.f1025g0 = true;
        SearchAutoComplete r8 = this.f1032z;
        int r10 = r8.getImeOptions();
        this.f1026h0 = r10;
        r8.setImeOptions(r10 | 33554432);
        r8.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f1029k0);
        post(this.f1030l0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
        if (r8 == false) goto L9;
        SearchAutoComplete r14 = this.f1032z;
        int[] r15 = this.L;
        r14.getLocationInWindow(r15);
        int[] r16 = this.M;
        getLocationInWindow(r16);
        int r17 = r15[1] - r16[1];
        int r18 = r15[0] - r16[0];
        int r19 = r14.getWidth() + r18;
        int r20 = r14.getHeight() + r17;
        Rect r21 = this.J;
        r21.set(r18, r17, r19, r20);
        int r22 = r21.left;
        int r23 = r21.right;
        int r24 = r13 - r11;
        Rect r25 = this.K;
        r25.set(r22, 0, r23, r24);
        o r26 = this.I;
        if (r26 != null) goto L7;
        o r27 = new o(r25, r21, r14);
        this.I = r27;
        setTouchDelegate(r27);
        return;
    L7:
        r26.f1050b.set(r25);
        Rect r28 = r26.f1052d;
        r28.set(r25);
        int r29 = -r26.f1053e;
        r28.inset(r29, r29);
        r26.f1051c.set(r21);
        return;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int r8, int r10) {
        if (this.X == false) goto L6;
        super.onMeasure(r8, r10);
        return;
    L6:
        int r11 = View.MeasureSpec.getMode(r8);
        int r12 = View.MeasureSpec.getSize(r8);
        if (r11 == Integer.MIN_VALUE) goto L18;
        if (r11 == 0) goto L14;
        if (r11 != 1073741824) goto L23;
        int r13 = this.d0;
        if (r13 <= 0) goto L23;
    L22:
        r12 = Math.min(r13, r12);
    L23:
        int r14 = View.MeasureSpec.getMode(r10);
        int r15 = View.MeasureSpec.getSize(r10);
        if (r14 == Integer.MIN_VALUE) goto L28;
        if (r14 != 0) goto L29;
        r15 = getPreferredHeight();
    L29:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r12, 1073741824), View.MeasureSpec.makeMeasureSpec(r15, 1073741824));
        return;
    L28:
        r15 = Math.min(getPreferredHeight(), r15);
        goto L29
    L14:
        r12 = this.d0;
        if (r12 > 0) goto L23;
        r12 = getPreferredWidth();
        goto L23
    L18:
        r13 = this.d0;
        if (r13 > 0) goto L22;
        r13 = getPreferredWidth();
        goto L22
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r8) {
        if ((r8 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r8);
        return;
    L6:
        SavedState r10 = (SavedState) r8;
        super.onRestoreInstanceState(r10.f1731a);
        v(r10.f1033m);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r8 = new SavedState(super.onSaveInstanceState());
        r8.f1033m = this.X;
        return r8;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean r8) {
        super.onWindowFocusChanged(r8);
        post(this.f1029k0);
    }

    public final void p() {
        SearchAutoComplete r8 = this.f1032z;
        Editable r10 = r8.getText();
        if (r10 != null) goto L5;
        return;
    L5:
        if (TextUtils.getTrimmedLength(r10) > 0) goto L7;
        return;
    L7:
        if (this.f1027i0 == null) goto L9;
        Intent r11 = j("android.intent.action.SEARCH", null, null, r10.toString());
        getContext().startActivity(r11);
    L9:
        r8.setImeVisibility(false);
        r8.dismissDropDown();
    }

    public final void q() {
        boolean r8 = true;
        boolean r10 = !TextUtils.isEmpty(this.f1032z.getText());
        int r11 = 0;
        if (r10 == false) goto L5;
    L10:
        if (r8 == true) goto L13;
        r11 = 8;
    L13:
        ImageView r12 = this.F;
        r12.setVisibility(r11);
        Drawable r13 = r12.getDrawable();
        if (r13 == null) goto L20;
        if (r10 == false) goto L17;
        int[] r14 = ViewGroup.ENABLED_STATE_SET;
    L18:
        r13.setState(r14);
        return;
    L17:
        r14 = ViewGroup.EMPTY_STATE_SET;
        goto L18
    L20:
        return;
    L5:
        if (this.W == true) goto L7;
    L9:
        r8 = false;
        goto L10
    L7:
        if (this.f1025g0 == true) goto L9;
        goto L9
    }

    public final void r() {
        if (this.f1032z.hasFocus() == false) goto L5;
        int[] r8 = ViewGroup.FOCUSED_STATE_SET;
    L6:
        Drawable r10 = this.B.getBackground();
        if (r10 == null) goto L9;
        r10.setState(r8);
    L9:
        Drawable r11 = this.C.getBackground();
        if (r11 == null) goto L12;
        r11.setState(r8);
    L12:
        invalidate();
        return;
    L5:
        r8 = ViewGroup.EMPTY_STATE_SET;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int r8, Rect r10) {
        if (this.f1022c0 == false) goto L6;
        return false;
    L6:
        if (isFocusable() == true) goto L9;
        return false;
    L9:
        if (this.X == true) goto L15;
        boolean r11 = this.f1032z.requestFocus(r8, r10);
        if (r11 == false) goto L13;
        v(false);
    L13:
        return r11;
    L15:
        return super.requestFocus(r8, r10);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void s() {
        CharSequence r8 = getQueryHint();
        CharSequence r10 = r8;
        if (r8 != null) goto L5;
        r10 = "";
    L5:
        boolean r11 = this.W;
        SearchAutoComplete r12 = this.f1032z;
        CharSequence r13 = r10;
        if (r11 == false) goto L11;
        Drawable r14 = this.O;
        r13 = r10;
        if (r14 == null) goto L11;
        int r15 = (int) (((double) r12.getTextSize()) * 1.25d);
        r14.setBounds(0, 0, r15, r15);
        SpannableStringBuilder r16 = new SpannableStringBuilder("   ");
        r16.setSpan(new ImageSpan(r14), 1, 2, 33);
        r16.append(r10);
        r13 = r16;
    L11:
        r12.setHint(r13);
    }

    public void setAppSearchData(Bundle r8) {
        this.f1028j0 = r8;
    }

    public void setIconified(boolean r8) {
        if (r8 == false) goto L4;
        l();
        return;
    L4:
        v(false);
        SearchAutoComplete r10 = this.f1032z;
        r10.requestFocus();
        r10.setImeVisibility(true);
        View.OnClickListener r11 = this.V;
        if (r11 == null) goto L9;
        r11.onClick(this);
        return;
    }

    public void setIconifiedByDefault(boolean r8) {
        if (this.W != r8) goto L5;
        return;
    L5:
        this.W = r8;
        v(r8);
        s();
    }

    public void setImeOptions(int r8) {
        this.f1032z.setImeOptions(r8);
    }

    public void setInputType(int r8) {
        this.f1032z.setInputType(r8);
    }

    public void setMaxWidth(int r8) {
        this.d0 = r8;
        requestLayout();
    }

    public void setOnCloseListener(l r8) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener r8) {
        this.U = r8;
    }

    public void setOnQueryTextListener(m r8) {
    }

    public void setOnSearchClickListener(View.OnClickListener r8) {
        this.V = r8;
    }

    public void setOnSuggestionListener(n r8) {
    }

    public void setQueryHint(CharSequence r8) {
        this.f1020a0 = r8;
        s();
    }

    public void setQueryRefinementEnabled(boolean r8) {
        this.f1021b0 = r8;
        n0.a r10 = this.Y;
        if ((r10 instanceof p0) == false) goto L10;
        p0 r11 = (p0) r10;
        if (r8 == false) goto L7;
        int r12 = 2;
    L8:
        r11.f1239z = r12;
        return;
    L7:
        r12 = 1;
        goto L8
    }

    public void setSearchableInfo(SearchableInfo r8) {
        this.f1027i0 = r8;
        SearchAutoComplete r10 = this.f1032z;
        boolean r11 = true;
        Intent r12 = null;
        if (r8 == null) goto L20;
        r10.setThreshold(r8.getSuggestThreshold());
        r10.setImeOptions(this.f1027i0.getImeOptions());
        int r13 = this.f1027i0.getInputType();
        if ((r13 & 15) != 1) goto L9;
        r13 = r13 & (-65537);
        if (this.f1027i0.getSuggestAuthority() == null) goto L9;
        r13 = (r13 | 65536) | 524288;
    L9:
        r10.setInputType(r13);
        n0.a r14 = this.Y;
        if (r14 == null) goto L13;
        r14.c(null);
    L13:
        if (this.f1027i0.getSuggestAuthority() == null) goto L19;
        p0 r15 = new p0(getContext(), this, this.f1027i0, this.f1031m0);
        this.Y = r15;
        r10.setAdapter(r15);
        p0 r16 = (p0) this.Y;
        if (this.f1021b0 == false) goto L17;
        int r17 = 2;
    L18:
        r16.f1239z = r17;
        goto L19
    L17:
        r17 = 1;
    L19:
        s();
    L20:
        SearchableInfo r18 = this.f1027i0;
        if (r18 != null) goto L23;
    L34:
        r11 = false;
    L35:
        this.f1023e0 = r11;
        if (r11 == false) goto L38;
        r10.setPrivateImeOptions("nm");
    L38:
        v(this.X);
        return;
    L23:
        if (r18.getVoiceSearchEnabled() == false) goto L34;
        if (this.f1027i0.getVoiceSearchLaunchWebSearch() == false) goto L28;
        r12 = this.R;
    L30:
        if (r12 == null) goto L34;
        if (getContext().getPackageManager().resolveActivity(r12, 65536) == null) goto L34;
    L28:
        if (this.f1027i0.getVoiceSearchLaunchRecognizer() == false) goto L30;
        r12 = this.S;
        goto L30
    }

    public void setSubmitButtonEnabled(boolean r8) {
        this.Z = r8;
        v(this.X);
    }

    public void setSuggestionsAdapter(n0.a r8) {
        this.Y = r8;
        this.f1032z.setAdapter(r8);
    }

    public final void t() {
        int r8 = 0;
        if (this.Z == true) goto L7;
        if (this.f1023e0 == true) goto L7;
    L9:
        boolean r10 = false;
    L10:
        if (r10 == true) goto L12;
    L16:
        r8 = 8;
    L17:
        this.C.setVisibility(r8);
        return;
    L12:
        if (this.E.getVisibility() == 0) goto L17;
        if (this.G.getVisibility() != 0) goto L16;
    L7:
        if (this.X == true) goto L9;
        r10 = true;
        goto L10
    }

    public final void u(boolean r8) {
        boolean r10 = this.Z;
        if (r10 == false) goto L19;
        int r11 = 0;
        if (r10 == true) goto L9;
        if (this.f1023e0 == true) goto L9;
    L11:
        boolean r12 = false;
    L12:
        if (r12 == false) goto L19;
        if (hasFocus() == false) goto L19;
        if (r8 == false) goto L17;
    L20:
        this.E.setVisibility(r11);
        return;
    L17:
        if (this.f1023e0 == true) goto L19;
    L9:
        if (this.X == true) goto L11;
        r12 = true;
    L19:
        r11 = 8;
        goto L20
    }

    public final void v(boolean r8) {
        this.X = r8;
        int r10 = 0;
        if (r8 == false) goto L5;
        int r11 = 0;
    L6:
        boolean r12 = !TextUtils.isEmpty(this.f1032z.getText());
        this.D.setVisibility(r11);
        u(r12);
        if (r8 == false) goto L9;
        int r13 = 8;
    L10:
        this.A.setVisibility(r13);
        ImageView r14 = this.N;
        if (r14.getDrawable() != null) goto L13;
    L16:
        int r15 = 8;
    L17:
        r14.setVisibility(r15);
        q();
        boolean r16 = !r12;
        if (this.f1023e0 == true) goto L20;
    L23:
        r10 = 8;
    L24:
        this.G.setVisibility(r10);
        t();
        return;
    L20:
        if (this.X == true) goto L23;
        if (r16 == false) goto L23;
        this.E.setVisibility(8);
        goto L24
    L13:
        if (this.W == true) goto L16;
        r15 = 0;
        goto L17
    L9:
        r13 = 0;
        goto L10
    L5:
        r11 = 8;
        goto L6
    }

    public SearchView(Context r8, AttributeSet r10) {
        this(r8, r10, R.attr.searchViewStyle);
    }

    public SearchView(Context r18, AttributeSet r19, int r20) {
        super(r18, r19, r20);
        this.J = new Rect();
        this.K = new Rect();
        this.L = new int[2];
        this.M = new int[2];
        this.f1029k0 = new b(this);
        this.f1030l0 = new c(this);
        this.f1031m0 = new WeakHashMap();
        f r10 = new f(this);
        g r11 = new g(this);
        h r12 = new h(this);
        i r13 = new i(this);
        j r14 = new j(this);
        a r15 = new a(this);
        int[] r8 = c.a.f3235u;
        TypedArray r16 = r18.obtainStyledAttributes(r19, r8, r20, 0);
        v0 r17 = new v0(r18, r16);
        WeakHashMap<View, j0.h0> r21 = j0.w.f8437a;
        j0.w.m.c(this, r18, r8, r19, r16, r20, 0);
        LayoutInflater.from(r18).inflate(r17.i(19, R.layout.abc_search_view), this, true);
        SearchAutoComplete r22 = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.f1032z = r22;
        r22.setSearchView(this);
        this.A = findViewById(R.id.search_edit_frame);
        View r23 = findViewById(R.id.search_plate);
        this.B = r23;
        View r24 = findViewById(R.id.submit_area);
        this.C = r24;
        ImageView r25 = (ImageView) findViewById(R.id.search_button);
        this.D = r25;
        ImageView r26 = (ImageView) findViewById(R.id.search_go_btn);
        this.E = r26;
        ImageView r27 = (ImageView) findViewById(R.id.search_close_btn);
        this.F = r27;
        ImageView r28 = (ImageView) findViewById(R.id.search_voice_btn);
        this.G = r28;
        ImageView r29 = (ImageView) findViewById(R.id.search_mag_icon);
        this.N = r29;
        j0.w.d.q(r23, r17.e(20));
        j0.w.d.q(r24, r17.e(25));
        r25.setImageDrawable(r17.e(23));
        r26.setImageDrawable(r17.e(15));
        r27.setImageDrawable(r17.e(12));
        r28.setImageDrawable(r17.e(28));
        r29.setImageDrawable(r17.e(23));
        this.O = r17.e(22);
        y0.a(r25, getResources().getString(R.string.abc_searchview_description_search));
        this.P = r17.i(26, R.layout.abc_search_dropdown_item_icons_2line);
        this.Q = r17.i(13, 0);
        r25.setOnClickListener(r10);
        r27.setOnClickListener(r10);
        r26.setOnClickListener(r10);
        r28.setOnClickListener(r10);
        r22.setOnClickListener(r10);
        r22.addTextChangedListener(r15);
        r22.setOnEditorActionListener(r12);
        r22.setOnItemClickListener(r13);
        r22.setOnItemSelectedListener(r14);
        r22.setOnKeyListener(r11);
        r22.setOnFocusChangeListener(new d(this));
        setIconifiedByDefault(r17.a(18, true));
        int r30 = r17.d(2, -1);
        if (r30 == (-1)) goto L5;
        setMaxWidth(r30);
    L5:
        this.T = r17.k(14);
        this.f1020a0 = r17.k(21);
        int r31 = r17.h(6, -1);
        if (r31 == (-1)) goto L8;
        setImeOptions(r31);
    L8:
        int r32 = r17.h(5, -1);
        if (r32 == (-1)) goto L11;
        setInputType(r32);
    L11:
        setFocusable(r17.a(1, true));
        r17.n();
        Intent r33 = new Intent("android.speech.action.WEB_SEARCH");
        this.R = r33;
        r33.addFlags(268435456);
        r33.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent r34 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.S = r34;
        r34.addFlags(268435456);
        View r35 = findViewById(r22.getDropDownAnchor());
        this.H = r35;
        if (r35 == null) goto L14;
        r35.addOnLayoutChangeListener(new e(this));
    L14:
        v(this.W);
        s();
    }
}
