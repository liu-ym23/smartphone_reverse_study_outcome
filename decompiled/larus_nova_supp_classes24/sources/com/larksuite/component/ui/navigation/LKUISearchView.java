package com.larksuite.component.ui.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKUISearchView extends LinearLayout implements TextWatcher {
    public final TextView A;
    public final ImageView B;
    public final RelativeLayout C;
    public View.OnFocusChangeListener D;
    public int a;
    public int b;
    public int c;
    public int d;
    public float e;
    public float f;
    public boolean g;
    public boolean h;
    public String i;
    public CharSequence j;
    public int k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public int r;
    public int s;
    public int t;
    public int u;
    public SearchIconGravity v;
    public final LKUIClearEditText w;
    public final TextView x;
    public final ImageView y;
    public final ImageView z;

    public static final enum SearchIconGravity extends Enum<SearchIconGravity> {
        public static final SearchIconGravity CENTER = null;
        public static final SearchIconGravity LEFT = null;
        public static final /* synthetic */ SearchIconGravity[] a = null;

        static {
            SearchIconGravity r0 = new SearchIconGravity("LEFT", 0);
            LEFT = r0;
            SearchIconGravity r1 = new SearchIconGravity("CENTER", 1);
            CENTER = r1;
            a = new SearchIconGravity[]{r0, r1};
        }

        public static SearchIconGravity[] values() {
            return (SearchIconGravity[]) a.clone();
        }

        public int toGravity() {
            if (c.a[ordinal()] == 2) goto L6;
            return 8388611;
        L6:
            return 17;
        }

        public static SearchIconGravity valueOf(String r1) {
            return (SearchIconGravity) r27.a.a(SearchIconGravity.class, r1);
        }

        public SearchIconGravity(String r1, int r2) {
            super(r1, r2);
        }
    }

    public class a implements View.OnClickListener {
        public final /* synthetic */ LKUISearchView a;

        public a(LKUISearchView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r12) {
            LKUISearchView r13 = this.a;
            r13.w.setText(r13.j);
            r13.x.setVisibility(8);
            r13.w.setVisibility(0);
            r13.w.requestFocus();
            if (r13.g == false) goto L5;
            r13.A.setVisibility(0);
        L5:
            TranslateAnimation r0 = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            r0.setDuration(200);
            r13.A.startAnimation(r0);
            r13.postDelayed(new e08.b(r13), 50);
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ LKUISearchView a;

        public b(LKUISearchView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.a();
        }
    }

    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SearchIconGravity.values().length];
            a = r0;
            r0[SearchIconGravity.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[SearchIconGravity.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public final void a() {
        this.j = "";
        this.w.setText("");
        this.w.setVisibility(8);
        this.x.setVisibility(0);
        this.A.setVisibility(8);
        this.w.clearFocus();
        TranslateAnimation r0 = new TranslateAnimation(1, 0.0f, 1, 1.5f, 1, 0.0f, 1, 0.0f);
        r0.setDuration(200);
        this.A.startAnimation(r0);
        postDelayed(new e08.c(this), 50);
    }

    public ImageView getBackImageView() {
        return this.B;
    }

    public TextView getCancelView() {
        return this.A;
    }

    public LKUIClearEditText getEditView() {
        return this.w;
    }

    public TextView getHintView() {
        return this.x;
    }

    public RelativeLayout getInputLayout() {
        return this.C;
    }

    public ImageView getLeftImageView() {
        return this.y;
    }

    public ImageView getRightImageView() {
        return this.z;
    }

    public CharSequence getSearchText() {
        return this.j;
    }

    public LKUISearchView(Context r2) {
        this(r2, null);
    }

    public static void b(View r2) {
        InputMethodManager r0 = (InputMethodManager) r2.getContext().getSystemService("input_method");
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isActive() == false) goto L9;
        r0.hideSoftInputFromWindow(r2.getApplicationWindowToken(), 0);
        return;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
        this.j = r1;
    }

    public void setCancelEnabled(boolean r2) {
        this.g = r2;
        if (r2 == true) goto L6;
        this.A.setVisibility(8);
        return;
    }

    public void setCancelTextColor(int r2) {
        this.c = r2;
        this.A.setTextColor(r2);
    }

    public void setCancelTextSize(float r2) {
        this.e = r2;
        this.A.setTextSize(r2);
    }

    public void setClearDrawable(Drawable r2) {
        this.w.setClearDrawable(r2);
    }

    public void setClearDrawableResId(int r2) {
        this.k = r2;
        this.w.setClearDrawable(r2);
    }

    public void setClearEnabled(boolean r2) {
        this.l = r2;
        this.w.setClearIconVisible(r2);
    }

    public void setEditTextCursorColor(int r2) {
        this.d = r2;
        this.w.setCursorColor(r2);
    }

    public void setFocusChangeListener(View.OnFocusChangeListener r1) {
        this.D = r1;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setHintTextColor(int r2) {
        this.a = r2;
        this.x.setTextColor(r2);
        this.w.setHintTextColor(r2);
        invalidate();
    }

    public void setInputLayoutBackGroundColor(int r3) {
        RelativeLayout r0 = this.C;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getBackground() == null) goto L17;
        Drawable r1 = this.C.getBackground();
        r1.mutate();
        if ((r1 instanceof GradientDrawable) == false) goto L10;
        ((GradientDrawable) r1).setColor(r3);
        return;
    L10:
        if ((r1 instanceof ShapeDrawable) == false) goto L13;
        ((ShapeDrawable) r1).getPaint().setColor(r3);
        return;
    L13:
        if ((r1 instanceof ColorDrawable) == false) goto L20;
        ((ColorDrawable) r1).setColor(r3);
        return;
    L20:
        return;
    }

    public void setLeftDrawable(Drawable r2) {
        this.y.setImageDrawable(r2);
    }

    public void setLeftDrawableResId(int r2) {
        this.m = r2;
        this.y.setImageResource(r2);
    }

    public void setRightDrawable(Drawable r2) {
        this.z.setImageDrawable(r2);
    }

    public void setRightDrawableEnabled(boolean r2) {
        this.q = r2;
        ImageView r0 = this.z;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setRightDrawableResId(int r2) {
        this.p = r2;
        this.z.setImageResource(r2);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setTextSize(float r2) {
        this.f = r2;
        this.x.setTextSize(r2);
        this.w.setTextSize(r2);
    }

    public LKUISearchView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Type inference failed for: r8v3, types: [android.widget.EditText, com.larksuite.component.ui.navigation.LKUIClearEditText] */
    public LKUISearchView(Context r17, AttributeSet r19, int r110) {
        super(r17, r19, r110);
        this.g = true;
        int r3 = 0;
        this.h = false;
        this.k = 2131243848;
        this.l = true;
        this.m = 2131243847;
        this.p = 2131243847;
        this.q = false;
        this.t = 2131243849;
        SearchIconGravity r7 = SearchIconGravity.LEFT;
        this.v = r7;
        LinearLayout.inflate(r17, 2131563567, this);
        ?? r8 = (LKUIClearEditText) findViewById(2131375422);
        this.w = r8;
        ImageView r9 = (ImageView) findViewById(2131370224);
        this.y = r9;
        ImageView r10 = (ImageView) findViewById(2131370225);
        this.z = r10;
        RelativeLayout r11 = (RelativeLayout) findViewById(2131375386);
        this.C = r11;
        TextView r12 = (TextView) findViewById(2131374378);
        this.x = r12;
        TextView r13 = (TextView) findViewById(2131365114);
        this.A = r13;
        ImageView r14 = (ImageView) findViewById(2131385621);
        this.B = r14;
        r8.setSingleLine(true);
        r8.setInputType(1);
        if (r19 == null) goto L24;
        TypedArray r1 = getContext().obtainStyledAttributes(r19, new int[]{2130973955, 2130973957, 2130973958, 2130973959, 2130973960, 2130973961, 2130973962, 2130973963, 2130973965, 2130973966, 2130973968, 2130973969, 2130973970, 2130973971, 2130973972, 2130973973, 2130973974, 2130973975, 2130973976, 2130973977, 2130973978, 2130973979});
        this.a = r1.getColor(9, ContextCompat.getColor(getContext(), 2131106620));
        this.f = r1.getDimension(21, j08.b.e(getContext(), 14.0f));
        this.b = r1.getColor(20, ContextCompat.getColor(getContext(), 2131106622));
        this.h = r1.getBoolean(0, false);
        this.g = r1.getBoolean(1, true);
        this.c = r1.getColor(3, ContextCompat.getColor(getContext(), 2131105548));
        r1.getString(2);
        this.e = r1.getDimension(4, j08.b.e(getContext(), 14.0f));
        this.d = r1.getColor(7, ContextCompat.getColor(getContext(), 2131105548));
        this.m = r1.getResourceId(12, 2131243847);
        if (AppCompatResources.getDrawable(getContext(), this.m) == null) goto L7;
        float r2 = AppCompatResources.getDrawable(getContext(), this.m).getIntrinsicWidth();
    L8:
        this.n = (int) r1.getDimension(14, r2);
        if (AppCompatResources.getDrawable(getContext(), this.m) == null) goto L11;
        float r4 = AppCompatResources.getDrawable(getContext(), this.m).getIntrinsicHeight();
    L12:
        this.o = (int) r1.getDimension(13, r4);
        this.p = r1.getResourceId(15, 2131243847);
        if (AppCompatResources.getDrawable(getContext(), this.p) == null) goto L15;
        float r5 = AppCompatResources.getDrawable(getContext(), this.p).getIntrinsicWidth();
    L16:
        this.r = (int) r1.getDimension(18, r5);
        if (AppCompatResources.getDrawable(getContext(), this.p) == null) goto L19;
        float r6 = AppCompatResources.getDrawable(getContext(), this.p).getIntrinsicHeight();
    L20:
        this.s = (int) r1.getDimension(17, r6);
        this.q = r1.getBoolean(16, false);
        this.k = r1.getResourceId(5, 2131243848);
        this.l = r1.getBoolean(6, true);
        this.u = r1.getColor(11, ContextCompat.getColor(getContext(), 2131100556));
        this.t = r1.getResourceId(10, 2131243849);
        String r15 = r1.getString(8);
        this.i = r15;
        if (r15 != null) goto L23;
        this.i = getResources().getString(2131892155);
        getResources().getString(2131891541);
    L23:
        this.v = SearchIconGravity.values()[r1.getInt(19, r7.ordinal())];
        r1.recycle();
    L41:
        r12.setTextSize(0, a08.b.a(this.f, getContext()));
        r12.setTextColor(this.a);
        r8.setHintTextColor(this.a);
        r8.setTextSize(0, a08.b.a(this.f, getContext()));
        r8.setTextColor(this.b);
        r8.setCursorColor(this.d);
        r13.setTextColor(this.c);
        r13.setTextSize(0, a08.b.a(this.e, getContext()));
        if (this.g == true) goto L44;
        r13.setVisibility(8);
    L44:
        r9.setImageResource(this.m);
        ViewGroup.LayoutParams r16 = r9.getLayoutParams();
        r16.width = this.n;
        r16.height = this.o;
        r9.setLayoutParams(r16);
        ViewGroup.LayoutParams r20 = r10.getLayoutParams();
        r20.width = this.r;
        r20.height = this.s;
        r10.setLayoutParams(r20);
        r10.setImageResource(this.p);
        if (this.q == false) goto L47;
        int r21 = 0;
    L48:
        r10.setVisibility(r21);
        r8.setClearDrawable(this.k);
        r8.setClearEnable(this.l);
        r12.setText(this.i);
        r8.setHint(this.i);
        r11.setGravity(this.v.toGravity());
        r11.setBackgroundResource(this.t);
        setInputLayoutBackGroundColor(this.u);
        if (this.h == true) goto L52;
        r3 = 8;
    L52:
        r14.setVisibility(r3);
        if (this.h == false) goto L55;
        r14.setOnClickListener(new e08.a(this));
    L55:
        ((ViewGroup) findViewById(2131384813)).getLayoutTransition().setDuration(200);
        r11.setOnClickListener(new a(this));
        r13.setOnClickListener(new b(this));
        r8.addTextChangedListener(this);
        return;
    L47:
        r21 = 8;
        goto L48
    L19:
        r6 = j08.b.a(getContext(), 16.0f);
        goto L20
    L15:
        r5 = j08.b.a(getContext(), 16.0f);
        goto L16
    L11:
        r4 = j08.b.a(getContext(), 16.0f);
        goto L12
    L7:
        r2 = j08.b.a(getContext(), 16.0f);
        goto L8
    L24:
        this.a = ContextCompat.getColor(getContext(), 2131103450);
        this.f = j08.b.e(getContext(), 14.0f);
        this.b = ContextCompat.getColor(getContext(), 2131103463);
        this.e = j08.b.e(getContext(), 14.0f);
        this.c = ContextCompat.getColor(getContext(), 2131103404);
        this.d = ContextCompat.getColor(getContext(), 2131103404);
        this.i = getResources().getString(2131892155);
        this.u = ContextCompat.getColor(getContext(), 2131103450);
        if (AppCompatResources.getDrawable(getContext(), this.m) == null) goto L27;
        int r22 = AppCompatResources.getDrawable(getContext(), this.m).getIntrinsicWidth();
    L28:
        this.n = r22;
        if (AppCompatResources.getDrawable(getContext(), this.m) == null) goto L31;
        int r23 = AppCompatResources.getDrawable(getContext(), this.m).getIntrinsicHeight();
    L32:
        this.o = r23;
        if (AppCompatResources.getDrawable(getContext(), this.p) == null) goto L35;
        int r24 = AppCompatResources.getDrawable(getContext(), this.p).getIntrinsicHeight();
    L36:
        this.s = r24;
        if (AppCompatResources.getDrawable(getContext(), this.p) == null) goto L39;
        int r25 = AppCompatResources.getDrawable(getContext(), this.p).getIntrinsicWidth();
    L40:
        this.r = r25;
        goto L41
    L39:
        r25 = (int) j08.b.a(getContext(), 16.0f);
        goto L40
    L35:
        r24 = (int) j08.b.a(getContext(), 16.0f);
        goto L36
    L31:
        r23 = (int) j08.b.a(getContext(), 16.0f);
        goto L32
    L27:
        r22 = (int) j08.b.a(getContext(), 16.0f);
        goto L28
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        this.j = r1;
        if (TextUtils.isEmpty(r1) == true) goto L10;
        if (this.l == false) goto L10;
        if (this.z.getVisibility() != 0) goto L10;
        this.z.setVisibility(8);
        return;
    L10:
        if (TextUtils.isEmpty(r1) == true) goto L12;
        return;
    L12:
        if (this.q == false) goto L17;
        this.z.setVisibility(0);
        return;
    }
}
