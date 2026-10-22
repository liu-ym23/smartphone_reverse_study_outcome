package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import com.obric.cae.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ActionMenuPresenter extends androidx.appcompat.view.menu.a {
    public boolean A;
    public final SparseBooleanArray B;
    public e C;
    public a D;
    public c E;
    public b F;
    public final f G;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public d f938s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Drawable f939t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f940u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f941v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f942w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f943x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f944y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f945z;

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f946a;

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

        public SavedState() {
        }

        public SavedState(Parcel r8) {
            this.f946a = r8.readInt();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            r8.writeInt(this.f946a);
        }
    }

    public class a extends androidx.appcompat.view.menu.i {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ ActionMenuPresenter f947m;

        public a(ActionMenuPresenter r8, Context r10, androidx.appcompat.view.menu.m r11, View r12) {
            this.f947m = r8;
            boolean r13 = false;
            super(r10, r11, r12, false);
            if ((r11.B.f866x & 32) != 32) goto L5;
            r13 = true;
        L5:
            if (r13 == true) goto L10;
            View r14 = r8.f938s;
            if (r14 != null) goto L9;
            r14 = (View) r8.f774r;
        L9:
            this.f875f = r14;
        L10:
            e(r8.G);
        }

        @Override // androidx.appcompat.view.menu.i
        public final void d() {
            this.f947m.D = null;
            super.d();
        }
    }

    public class b extends ActionMenuItemView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionMenuPresenter f948a;

        public b(ActionMenuPresenter r8) {
            this.f948a = r8;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActionMenuPresenter f950b;

        public c(ActionMenuPresenter r8, e r10) {
            this.f950b = r8;
            this.f949a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionMenuPresenter r8 = this.f950b;
            androidx.appcompat.view.menu.f r10 = r8.f769m;
            if (r10 == null) goto L7;
            androidx.appcompat.view.menu.f.a r11 = r10.f819e;
            if (r11 == null) goto L7;
            r11.b(r10);
        L7:
            View r12 = (View) r8.f774r;
            if (r12 != null) goto L10;
        L20:
            r8.E = null;
            return;
        L10:
            if (r12.getWindowToken() == null) goto L20;
            e r13 = this.f949a;
            boolean r14 = true;
            if (r13.c() == false) goto L15;
        L18:
            if (r14 == false) goto L20;
            r8.C = r13;
            goto L20
        L15:
            if (r13.f875f != null) goto L17;
            r14 = false;
            goto L18
        L17:
            r13.f(0, 0, false, false);
            goto L18
        }
    }

    public class d extends AppCompatImageView implements ActionMenuView.a {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ ActionMenuPresenter f951n;

        public class a extends g0 {

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            public final /* synthetic */ d f952t;

            public a(d r8, View r10) {
                this.f952t = r8;
                super(r10);
            }

            @Override // androidx.appcompat.widget.g0
            public final h.f b() {
                e r8 = this.f952t.f951n.C;
                if (r8 != null) goto L7;
                return null;
            L7:
                return r8.b();
            }

            @Override // androidx.appcompat.widget.g0
            public final boolean c() {
                this.f952t.f951n.l();
                return true;
            }

            @Override // androidx.appcompat.widget.g0
            public final boolean d() {
                ActionMenuPresenter r8 = this.f952t.f951n;
                if (r8.E == null) goto L6;
                return false;
            L6:
                r8.j();
                return true;
            }
        }

        public d(ActionMenuPresenter r8, Context r10) {
            this.f951n = r8;
            super(r10, null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            y0.a(this, getContentDescription());
            setOnTouchListener(new a(this, this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public final boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public final boolean b() {
            return false;
        }

        @Override // android.view.View
        public final boolean performClick() {
            if (super.performClick() == false) goto L5;
            return true;
        L5:
            playSoundEffect(0);
            this.f951n.l();
            return true;
        }

        @Override // android.widget.ImageView
        public final boolean setFrame(int r8, int r10, int r11, int r12) {
            boolean r13 = super.setFrame(r8, r10, r11, r12);
            Drawable r14 = getDrawable();
            Drawable r15 = getBackground();
            if (r14 == null) goto L6;
            if (r15 == null) goto L6;
            int r16 = getWidth();
            int r17 = getHeight();
            int r18 = Math.max(r16, r17) / 2;
            int r19 = getPaddingLeft() - getPaddingRight();
            int r20 = (r16 + r19) / 2;
            int r21 = (r17 + (getPaddingTop() - getPaddingBottom())) / 2;
            b0.a.b.f(r15, r20 - r18, r21 - r18, r20 + r18, r21 + r18);
        L6:
            return r13;
        }
    }

    public class e extends androidx.appcompat.view.menu.i {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ ActionMenuPresenter f953m;

        public e(ActionMenuPresenter r8, Context r10, androidx.appcompat.view.menu.f r11, d r12) {
            this.f953m = r8;
            super(r10, r11, r12, true);
            this.f876g = 8388613;
            e(r8.G);
        }

        @Override // androidx.appcompat.view.menu.i
        public final void d() {
            ActionMenuPresenter r8 = this.f953m;
            androidx.appcompat.view.menu.f r10 = r8.f769m;
            if (r10 == null) goto L5;
            r10.d(true);
        L5:
            r8.C = null;
            super.d();
        }
    }

    public class f implements androidx.appcompat.view.menu.j.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionMenuPresenter f954a;

        public f(ActionMenuPresenter r8) {
            this.f954a = r8;
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final void a(androidx.appcompat.view.menu.f r8, boolean r10) {
            if ((r8 instanceof androidx.appcompat.view.menu.m) == false) goto L5;
            r8.l().d(false);
        L5:
            androidx.appcompat.view.menu.j.a r11 = this.f954a.f771o;
            if (r11 == null) goto L9;
            r11.a(r8, r10);
            return;
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final boolean b(androidx.appcompat.view.menu.f r8) {
            ActionMenuPresenter r10 = this.f954a;
            if (r8 != r10.f769m) goto L5;
            return false;
        L5:
            ((androidx.appcompat.view.menu.m) r8).B.getClass();
            r10.getClass();
            androidx.appcompat.view.menu.j.a r11 = r10.f771o;
            if (r11 != null) goto L8;
            return false;
        L8:
            return r11.b(r8);
        }
    }

    public ActionMenuPresenter(Context r8) {
        super(r8);
        this.B = new SparseBooleanArray();
        this.G = new f(this);
    }

    @Override // androidx.appcompat.view.menu.j
    public final void a(androidx.appcompat.view.menu.f r8, boolean r10) {
        j();
        a r11 = this.D;
        if (r11 == null) goto L5;
        r11.a();
    L5:
        androidx.appcompat.view.menu.j.a r12 = this.f771o;
        if (r12 == null) goto L9;
        r12.a(r8, r10);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.j
    public final void d() {
        ViewGroup r8 = (ViewGroup) this.f774r;
        ArrayList<androidx.appcompat.view.menu.h> r10 = null;
        boolean r11 = false;
        if (r8 == null) goto L37;
        androidx.appcompat.view.menu.f r12 = this.f769m;
        if (r12 == null) goto L28;
        r12.j();
        ArrayList<androidx.appcompat.view.menu.h> r13 = this.f769m.m();
        int r14 = r13.size();
        int r15 = 0;
        int r16 = 0;
    L8:
        if (r15 >= r14) goto L30;
        androidx.appcompat.view.menu.h r17 = r13.get(r15);
        if ((r17.f866x & 32) != 32) goto L12;
        boolean r18 = true;
    L13:
        if (r18 == false) goto L27;
        View r19 = r8.getChildAt(r16);
        if ((r19 instanceof androidx.appcompat.view.menu.k.a) == false) goto L17;
        androidx.appcompat.view.menu.h r110 = ((androidx.appcompat.view.menu.k.a) r19).getItemData();
    L18:
        View r111 = i(r17, r19, r8);
        if (r17 == r110) goto L21;
        r111.setPressed(false);
        r111.jumpDrawablesToCurrentState();
    L21:
        if (r111 == r19) goto L26;
        ViewGroup r20 = (ViewGroup) r111.getParent();
        if (r20 == null) goto L25;
        r20.removeView(r111);
    L25:
        ((ViewGroup) this.f774r).addView(r111, r16);
    L26:
        r16 = r16 + 1;
        goto L27
    L17:
        r110 = null;
    L27:
        r15 = r15 + 1;
        goto L8
    L12:
        r18 = false;
    L30:
        if (r16 >= r8.getChildCount()) goto L37;
        if (r8.getChildAt(r16) != this.f938s) goto L34;
        boolean r21 = false;
    L35:
        if (r21 == true) goto L30;
        r16 = r16 + 1;
        goto L30
    L34:
        r8.removeViewAt(r16);
        r21 = true;
        goto L35
    L28:
        r16 = 0;
    L37:
        ((View) this.f774r).requestLayout();
        androidx.appcompat.view.menu.f r22 = this.f769m;
        if (r22 == null) goto L42;
        r22.j();
        ArrayList<androidx.appcompat.view.menu.h> r23 = r22.f823i;
        int r24 = r23.size();
        int r25 = 0;
    L40:
        if (r25 >= r24) goto L42;
        j0.b r26 = r23.get(r25).A;
        r25 = r25 + 1;
    L42:
        androidx.appcompat.view.menu.f r27 = this.f769m;
        if (r27 == null) goto L46;
        r27.j();
        r10 = r27.f824j;
    L46:
        if (this.f941v == false) goto L53;
        if (r10 == null) goto L53;
        int r28 = r10.size();
        if (r28 != 1) goto L51;
        r11 = !r10.get(0).C;
        goto L53
    L51:
        if (r28 <= 0) goto L53;
        r11 = true;
    L53:
        d r29 = this.f938s;
        if (r11 == false) goto L62;
        if (r29 != null) goto L57;
        this.f938s = new d(this, this.f767a);
    L57:
        ViewGroup r30 = (ViewGroup) this.f938s.getParent();
        if (r30 == this.f774r) goto L66;
        if (r30 == null) goto L61;
        r30.removeView(this.f938s);
    L61:
        ActionMenuView r31 = (ActionMenuView) this.f774r;
        d r32 = this.f938s;
        r31.getClass();
        ActionMenuView.c r33 = new ActionMenuView.c();
        ((LinearLayout.LayoutParams) r33).gravity = 16;
        r33.f956a = true;
        r31.addView(r32, r33);
    L66:
        ((ActionMenuView) this.f774r).setOverflowReserved(this.f941v);
        return;
    L62:
        if (r29 == null) goto L66;
        Object r34 = r29.getParent();
        Object r35 = this.f774r;
        if (r34 != r35) goto L66;
        ((ViewGroup) r35).removeView(this.f938s);
        goto L66
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.j
    public final boolean e(androidx.appcompat.view.menu.m r10) {
        boolean r8 = false;
        if (r10.hasVisibleItems() == true) goto L5;
        return false;
    L5:
        androidx.appcompat.view.menu.m r11 = r10;
    L6:
        androidx.appcompat.view.menu.f r12 = r11.A;
        if (r12 == this.f769m) goto L9;
        r11 = (androidx.appcompat.view.menu.m) r12;
        goto L6
    L9:
        ViewGroup r13 = (ViewGroup) this.f774r;
        if (r13 == null) goto L20;
        int r14 = r13.getChildCount();
        int r15 = 0;
    L13:
        if (r15 >= r14) goto L20;
        View r16 = r13.getChildAt(r15);
        if ((r16 instanceof androidx.appcompat.view.menu.k.a) == false) goto L19;
        if (((androidx.appcompat.view.menu.k.a) r16).getItemData() != r11.B) goto L19;
    L21:
        if (r16 != 0) goto L23;
        return false;
    L23:
        r10.B.getClass();
        int r17 = r10.size();
        int r18 = 0;
    L25:
        if (r18 >= r17) goto L32;
        MenuItem r19 = r10.getItem(r18);
        if (r19.isVisible() == false) goto L31;
        if (r19.getIcon() == null) goto L31;
        boolean r20 = true;
    L33:
        a r21 = new a(this, this.f768b, r10, r16);
        this.D = r21;
        r21.f877h = r20;
        h.d r22 = r21.f879j;
        if (r22 == null) goto L36;
        r22.m(r20);
    L36:
        a r23 = this.D;
        if (r23.c() == false) goto L40;
    L38:
        r8 = true;
    L43:
        if (r8 == false) goto L49;
        androidx.appcompat.view.menu.j.a r24 = this.f771o;
        if (r24 == null) goto L47;
        r24.b(r10);
    L47:
        return true;
    L49:
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    L40:
        if (r23.f875f == null) goto L43;
        r23.f(0, 0, false, false);
    L31:
        r18 = r18 + 1;
        goto L25
    L32:
        r20 = false;
    L19:
        r15 = r15 + 1;
    L20:
        r16 = 0;
        goto L21
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.widget.ActionMenuPresenter] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r12v3, types: [androidx.appcompat.view.menu.h] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r9v3, types: [android.util.SparseBooleanArray] */
    @Override // androidx.appcompat.view.menu.j
    public final boolean g() {
        ActionMenuPresenter r8 = this;
        androidx.appcompat.view.menu.f r10 = r8.f769m;
        View r11 = null;
        boolean r12 = false;
        if (r10 == null) goto L5;
        ArrayList<androidx.appcompat.view.menu.h> r13 = r10.m();
        int r14 = r13.size();
    L6:
        int r15 = r8.f945z;
        int r16 = r8.f944y;
        int r17 = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup r18 = (ViewGroup) r8.f774r;
        int r19 = 0;
        boolean r110 = false;
        int r111 = 0;
        int r112 = 0;
    L7:
        ?? r113 = 1;
        if (r19 >= r14) goto L26;
        androidx.appcompat.view.menu.h r114 = r13.get(r19);
        if (r114.requiresActionButton() == false) goto L13;
        r111 = r111 + 1;
        boolean r115 = r110;
    L20:
        if (r8.A == false) goto L24;
        if (r114.C == false) goto L24;
        r15 = 0;
    L24:
        r19 = r19 + 1;
        r110 = r115;
        goto L7
    L13:
        if ((r114.f867y & 1) != 1) goto L15;
        boolean r116 = true;
    L16:
        if (r116 == false) goto L18;
        r112 = r112 + 1;
        r115 = r110;
        goto L20
    L18:
        r115 = true;
        goto L20
    L15:
        r116 = false;
        goto L16
    L26:
        if (r8.f941v == false) goto L31;
        if (r110 == false) goto L29;
    L30:
        r15 = r15 - 1;
        goto L31
    L29:
        if ((r112 + r111) > r15) goto L30;
    L31:
        int r20 = r15 - r111;
        ?? r21 = r8.B;
        r21.clear();
        int r117 = 0;
        int r118 = 0;
        ?? r22 = r8;
    L32:
        if (r117 >= r14) goto L84;
        androidx.appcompat.view.menu.h r119 = r13.get(r117);
        boolean r120 = r119.requiresActionButton();
        int r121 = r119.f844b;
        if (r120 == false) goto L42;
        View r122 = r22.i(r119, r11, r18);
        r122.measure(r17, r17);
        int r123 = r122.getMeasuredWidth();
        r16 = r16 - r123;
        if (r118 != 0) goto L38;
        r118 = r123;
    L38:
        if (r121 == 0) goto L40;
        r21.put(r121, r113);
    L40:
        r119.f(r113);
        boolean r23 = r12;
    L82:
        r117 = r117 + 1;
        r12 = r23;
        r11 = null;
        r113 = 1;
        r22 = this;
        goto L32
    L42:
        if ((r119.f867y & r113) != r113) goto L44;
        ?? r124 = r113;
    L45:
        if (r124 == 0) goto L81;
        boolean r125 = r21.get(r121);
        if (r20 > 0) goto L49;
        if (r125 == true) goto L49;
    L51:
        ?? r126 = r12;
    L52:
        if (r126 == 0) goto L61;
        View r24 = r22.i(r119, r11, r18);
        r24.measure(r17, r17);
        int r25 = r24.getMeasuredWidth();
        r16 = r16 - r25;
        if (r118 != 0) goto L57;
        r118 = r25;
    L57:
        if ((r16 + r118) <= 0) goto L59;
        ?? r26 = r113;
    L60:
        r126 = (r126 == true ? 1 : 0) & r26;
        goto L61
    L59:
        r26 = 0;
    L61:
        ?? r27 = r126;
        if (r27 == 0) goto L65;
        if (r121 == 0) goto L65;
        r21.put(r121, r113);
    L78:
        if (r27 == 0) goto L80;
        r20 = r20 - 1;
    L80:
        r119.f(r27);
        r23 = false;
    L65:
        if (r125 == false) goto L78;
        r21.put(r121, false);
        int r127 = 0;
    L67:
        if (r127 >= r117) goto L78;
        androidx.appcompat.view.menu.h r28 = r13.get(r127);
        if (r28.f844b != r121) goto L77;
        if ((r28.f866x & 32) != 32) goto L73;
        boolean r29 = true;
    L74:
        if (r29 == false) goto L76;
        r20 = r20 + 1;
    L76:
        r28.f(false);
        goto L77
    L73:
        r29 = false;
    L77:
        r127 = r127 + 1;
    L49:
        if (r16 <= 0) goto L51;
        r126 = r113;
        goto L52
    L81:
        r23 = r12;
        r119.f(r23);
        goto L82
    L44:
        r124 = r12;
        goto L45
    L84:
        return r113;
    L5:
        r13 = null;
        r14 = 0;
        goto L6
    }

    @Override // androidx.appcompat.view.menu.j
    public final void h(Context r8, androidx.appcompat.view.menu.f r10) {
        this.f768b = r8;
        LayoutInflater.from(r8);
        this.f769m = r10;
        Resources r11 = r8.getResources();
        g.a r12 = new g.a(r8);
        if (this.f942w == true) goto L5;
        this.f941v = true;
    L5:
        this.f943x = r8.getResources().getDisplayMetrics().widthPixels / 2;
        this.f945z = r12.a();
        int r13 = this.f943x;
        if (this.f941v == true) goto L8;
        this.f938s = null;
    L15:
        this.f944y = r13;
        float r14 = r11.getDisplayMetrics().density;
        return;
    L8:
        if (this.f938s != null) goto L13;
        d r15 = new d(this, this.f767a);
        this.f938s = r15;
        if (this.f940u == false) goto L12;
        r15.setImageDrawable(this.f939t);
        this.f939t = null;
        this.f940u = false;
    L12:
        int r16 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f938s.measure(r16, r16);
    L13:
        r13 = r13 - this.f938s.getMeasuredWidth();
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View i(androidx.appcompat.view.menu.h r8, View r10, ViewGroup r11) {
        View r12 = r8.getActionView();
        int r13 = 0;
        if (r12 == null) goto L7;
        if (r8.e() == true) goto L7;
    L15:
        if (r8.C == false) goto L17;
        r13 = 8;
    L17:
        r12.setVisibility(r13);
        ViewGroup.LayoutParams r14 = r12.getLayoutParams();
        if (((ActionMenuView) r11).checkLayoutParams(r14) == true) goto L20;
        r12.setLayoutParams(ActionMenuView.j(r14));
    L20:
        return r12;
    L7:
        if ((r10 instanceof androidx.appcompat.view.menu.k.a) == false) goto L9;
        androidx.appcompat.view.menu.k.a r15 = (androidx.appcompat.view.menu.k.a) r10;
    L10:
        r15.c(r8);
        ActionMenuItemView r16 = (ActionMenuItemView) r15;
        r16.setItemInvoker((ActionMenuView) this.f774r);
        if (this.F != null) goto L13;
        this.F = new b(this);
    L13:
        r16.setPopupCallback(this.F);
        r12 = (View) r15;
        goto L15
    L9:
        int r17 = this.f773q;
        r15 = (androidx.appcompat.view.menu.k.a) this.f770n.inflate(r17, r11, false);
        goto L10
    }

    public final boolean j() {
        c r8 = this.E;
        if (r8 == null) goto L8;
        Object r10 = this.f774r;
        if (r10 == null) goto L8;
        ((View) r10).removeCallbacks(r8);
        this.E = null;
        return true;
    L8:
        e r11 = this.C;
        if (r11 == null) goto L12;
        r11.a();
        return true;
    L12:
        return false;
    }

    public final boolean k() {
        e r8 = this.C;
        if (r8 != null) goto L5;
    L7:
        return false;
    L5:
        if (r8.c() == false) goto L7;
        return true;
    }

    public final boolean l() {
        if (this.f941v == true) goto L5;
        return false;
    L5:
        if (k() == true) goto L18;
        androidx.appcompat.view.menu.f r8 = this.f769m;
        if (r8 != null) goto L9;
        return false;
    L9:
        if (this.f774r != null) goto L11;
        return false;
    L11:
        if (this.E != null) goto L21;
        r8.j();
        if (r8.f824j.isEmpty() == true) goto L22;
        c r10 = new c(this, new e(this, this.f768b, this.f769m, this.f938s));
        this.E = r10;
        ((View) this.f774r).post(r10);
        return true;
    L22:
        return false;
    L21:
        return false;
    L18:
        return false;
    }
}
