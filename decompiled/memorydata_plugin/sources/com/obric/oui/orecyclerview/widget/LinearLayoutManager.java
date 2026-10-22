package com.obric.oui.orecyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.FragmentTransaction;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class LinearLayoutManager extends RecyclerView.h implements RecyclerView.r.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f14058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f14059b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private final b g;
    private int h;
    int i;
    v j;
    boolean k;
    int l;
    int m;
    SavedState n;
    final a o;
    private int[] z;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean mAnchorLayoutFromEnd;
        int mAnchorOffset;
        int mAnchorPosition;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState() {
        }

        SavedState(Parcel r2) {
            this.mAnchorPosition = r2.readInt();
            this.mAnchorOffset = r2.readInt();
            boolean r0 = true;
            if (r2.readInt() == 1) goto L6;
            r0 = false;
        L6:
            this.mAnchorLayoutFromEnd = r0;
        }

        public SavedState(SavedState r2) {
            this.mAnchorPosition = r2.mAnchorPosition;
            this.mAnchorOffset = r2.mAnchorOffset;
            this.mAnchorLayoutFromEnd = r2.mAnchorLayoutFromEnd;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        boolean hasValidAnchor() {
            if (this.mAnchorPosition < 0) goto L5;
            return true;
        L5:
            return false;
        }

        void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeInt(this.mAnchorPosition);
            r1.writeInt(this.mAnchorOffset);
            r1.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        }
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        v f14060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f14061b;
        int c;
        boolean d;
        boolean e;

        a() {
            a();
        }

        void a() {
            this.f14061b = -1;
            this.c = Integer.MIN_VALUE;
            this.d = false;
            this.e = false;
        }

        public void a(View r5, int r6) {
            int r0 = this.f14060a.b();
            if (r0 < 0) goto L6;
            b(r5, r6);
            return;
        L6:
            this.f14061b = r6;
            if (this.d == false) goto L13;
            int r7 = (this.f14060a.d() - r0) - this.f14060a.b(r5);
            this.c = this.f14060a.d() - r7;
            if (r7 <= 0) goto L19;
            int r2 = this.c - this.f14060a.e(r5);
            int r1 = this.f14060a.c();
            int r3 = r2 - (r1 + Math.min(this.f14060a.a(r5) - r1, 0));
            if (r3 >= 0) goto L20;
            this.c += Math.min(r7, -r3);
            return;
        L20:
            return;
        L19:
            return;
        L13:
            int r8 = this.f14060a.a(r5);
            int r4 = r8 - this.f14060a.c();
            this.c = r8;
            if (r4 <= 0) goto L22;
            int r9 = (this.f14060a.d() - Math.min(0, (this.f14060a.d() - r0) - this.f14060a.b(r5))) - (r8 + this.f14060a.e(r5));
            if (r9 >= 0) goto L23;
            this.c -= Math.min(r4, -r9);
            return;
        L23:
            return;
        }

        boolean a(View r2, RecyclerView.s r3) {
            RecyclerView.LayoutParams r1 = (RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), RecyclerView.LayoutParams.class, "com.obric.memorydata.plugin");
            if (r1.d() == false) goto L5;
        L9:
            return false;
        L5:
            if (r1.f() < 0) goto L9;
            if (r1.f() >= r3.e()) goto L9;
            return true;
        }

        void b() {
            if (this.d == false) goto L5;
            int r0 = this.f14060a.d();
        L6:
            this.c = r0;
            return;
        L5:
            r0 = this.f14060a.c();
            goto L6
        }

        public void b(View r2, int r3) {
            if (this.d == false) goto L5;
            int r4 = this.f14060a.b(r2) + this.f14060a.b();
        L6:
            this.c = r4;
            this.f14061b = r3;
            return;
        L5:
            r4 = this.f14060a.a(r2);
            goto L6
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f14061b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.e + '}';
        }
    }

    protected static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f14063b;
        public boolean c;
        public boolean d;

        public b() {
        }

        void a() {
            this.f14062a = 0;
            this.f14063b = false;
            this.c = false;
            this.d = false;
        }
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f14064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f14065b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h;
        int i;
        boolean j;
        int k;
        List<RecyclerView.v> l;
        boolean m;

        c() {
            this.f14064a = true;
            this.h = 0;
            this.i = 0;
            this.j = false;
            this.l = null;
        }

        private View b() {
            int r0 = this.l.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L12;
            View r2 = ((RecyclerView.v) ZeusTransformUtils.preCheckCast(this.l.get(r1), RecyclerView.v.class, "com.obric.memorydata.plugin")).c;
            RecyclerView.LayoutParams r3 = (RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), RecyclerView.LayoutParams.class, "com.obric.memorydata.plugin");
            if (r3.d() == true) goto L11;
            if (this.d != r3.f()) goto L11;
            a(r2);
            return r2;
        L11:
            r1 = r1 + 1;
            goto L3
        L12:
            return null;
        }

        View a(RecyclerView.o r3) {
            if (this.l != null) goto L5;
            View r4 = r3.c(this.d);
            this.d += this.e;
            return r4;
        L5:
            return b();
        }

        public void a() {
            a(null);
        }

        public void a(View r3) {
            View r4 = b(r3);
            if (r4 != null) goto L5;
            int r5 = -1;
        L6:
            this.d = r5;
            return;
        L5:
            r5 = ((RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), RecyclerView.LayoutParams.class, "com.obric.memorydata.plugin")).f();
            goto L6
        }

        boolean a(RecyclerView.s r1) {
            int r0 = this.d;
            if (r0 >= 0) goto L5;
        L7:
            return false;
        L5:
            if (r0 >= r1.e()) goto L7;
            return true;
        }

        public View b(View r9) {
            int r0 = this.l.size();
            View r1 = null;
            int r2 = Integer.MAX_VALUE;
            int r3 = 0;
        L3:
            if (r3 >= r0) goto L18;
            View r4 = ((RecyclerView.v) ZeusTransformUtils.preCheckCast(this.l.get(r3), RecyclerView.v.class, "com.obric.memorydata.plugin")).c;
            RecyclerView.LayoutParams r5 = (RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), RecyclerView.LayoutParams.class, "com.obric.memorydata.plugin");
            if (r4 == r9) goto L17;
            if (r5.d() == true) goto L17;
            int r6 = (r5.f() - this.d) * this.e;
            if (r6 < 0) goto L17;
            if (r6 >= r2) goto L17;
            r1 = r4;
            if (r6 == 0) goto L18;
            r2 = r6;
        L17:
            r3 = r3 + 1;
        L18:
            return r1;
        }
    }

    public LinearLayoutManager(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), 1, false);
    }

    public LinearLayoutManager(Context r3, int r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.i = 1;
        this.c = false;
        this.k = false;
        this.d = false;
        this.e = true;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.n = null;
        this.o = new a();
        this.g = new b();
        this.h = 2;
        this.z = new int[2];
        b(r4);
        b(r5);
    }

    private void N() {
        if (this.i != 1) goto L5;
    L8:
        boolean r0 = this.c;
    L9:
        this.k = r0;
        return;
    L5:
        if (i() == false) goto L8;
        r0 = !this.c;
        goto L9
    }

    private View O() {
        if (this.k == false) goto L5;
        int r0 = x() - 1;
    L7:
        return i(r0);
    L5:
        r0 = 0;
        goto L7
    }

    private View P() {
        if (this.k == false) goto L5;
        int r0 = 0;
    L7:
        return i(r0);
    L5:
        r0 = x() - 1;
        goto L7
    }

    private View Q() {
        if (this.k == false) goto L6;
        return S();
    L6:
        return T();
    }

    private View R() {
        if (this.k == false) goto L6;
        return T();
    L6:
        return S();
    }

    private View S() {
        return c(0, x());
    }

    private View T() {
        return c(x() - 1, -1);
    }

    private int a(int r2, RecyclerView.o r3, RecyclerView.s r4, boolean r5) {
        int r0 = this.j.d() - r2;
        if (r0 <= 0) goto L11;
        int r6 = -c(-r0, r3, r4);
        int r7 = r2 + r6;
        if (r5 == false) goto L10;
        int r8 = this.j.d() - r7;
        if (r8 <= 0) goto L10;
        this.j.a(r8);
        return r8 + r6;
    L10:
        return r6;
    L11:
        return 0;
    }

    private void a(int r4, int r5) {
        this.f14058a.c = this.j.d() - r5;
        c r0 = this.f14058a;
        if (this.k == false) goto L5;
        int r1 = -1;
    L6:
        r0.e = r1;
        this.f14058a.d = r4;
        this.f14058a.f = 1;
        this.f14058a.f14065b = r5;
        this.f14058a.g = Integer.MIN_VALUE;
        return;
    L5:
        r1 = 1;
        goto L6
    }

    private void a(int r5, int r6, boolean r7, RecyclerView.s r8) {
        this.f14058a.m = m();
        this.f14058a.f = r5;
        int[] r0 = this.z;
        boolean r1 = false;
        r0[0] = 0;
        int r2 = 1;
        r0[1] = 0;
        a(r8, r0);
        int r9 = Math.max(0, this.z[0]);
        int r3 = Math.max(0, this.z[1]);
        if (r5 != 1) goto L5;
        r1 = true;
    L5:
        c r10 = this.f14058a;
        if (r1 == false) goto L8;
        int r4 = r3;
    L9:
        r10.h = r4;
        c r11 = this.f14058a;
        if (r1 == true) goto L13;
        r9 = r3;
    L13:
        r11.i = r9;
        if (r1 == false) goto L19;
        this.f14058a.h += this.j.g();
        View r12 = P();
        c r13 = this.f14058a;
        if (this.k == false) goto L18;
        r2 = -1;
    L18:
        r13.e = r2;
        this.f14058a.d = d(r12) + this.f14058a.e;
        this.f14058a.f14065b = this.j.b(r12);
        int r14 = this.j.b(r12) - this.j.d();
    L24:
        this.f14058a.c = r6;
        if (r7 == false) goto L27;
        this.f14058a.c -= r14;
    L27:
        this.f14058a.g = r14;
        return;
    L19:
        View r15 = O();
        this.f14058a.h += this.j.c();
        c r16 = this.f14058a;
        if (this.k == true) goto L23;
        r2 = -1;
    L23:
        r16.e = r2;
        this.f14058a.d = d(r15) + this.f14058a.e;
        this.f14058a.f14065b = this.j.a(r15);
        r14 = (-this.j.a(r15)) + this.j.c();
        goto L24
    L8:
        r4 = r9;
        goto L9
    }

    private void a(a r2) {
        a(r2.f14061b, r2.c);
    }

    private void a(RecyclerView.o r1, int r2, int r3) {
        if (r2 != r3) goto L4;
        return;
    L4:
        if (r3 <= r2) goto L8;
        int r4 = r3 - 1;
    L6:
        if (r4 < r2) goto L10;
        a(r4, r1);
        r4 = r4 - 1;
        goto L6
    L10:
        return;
    L8:
        if (r2 <= r3) goto L13;
        a(r2, r1);
        r2 = r2 - 1;
        goto L8
    }

    private void a(RecyclerView.o r4, c r5) {
        if (r5.f14064a == true) goto L5;
        return;
    L5:
        if (r5.m == true) goto L14;
        int r0 = r5.g;
        int r1 = r5.i;
        if (r5.f != (-1)) goto L10;
        c(r4, r0, r1);
        return;
    L10:
        b(r4, r0, r1);
        return;
    }

    private void a(RecyclerView.o r2, RecyclerView.s r3, a r4) {
        if (a(r3, r4) == false) goto L6;
        return;
    L6:
        if (b(r2, r3, r4) == false) goto L8;
        return;
    L8:
        r4.b();
        if (this.d == false) goto L11;
        int r1 = r3.e() - 1;
    L12:
        r4.f14061b = r1;
        return;
    L11:
        r1 = 0;
        goto L12
    }

    private boolean a(RecyclerView.s r5, a r6) {
        boolean r1 = false;
        if (r5.a() == true) goto L62;
        int r0 = this.l;
        if (r0 == (-1)) goto L62;
        if (r0 >= 0) goto L10;
    L61:
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        goto L62
    L10:
        if (r0 >= r5.e()) goto L61;
        r6.f14061b = this.l;
        SavedState r7 = this.n;
        if (r7 == null) goto L23;
        if (r7.hasValidAnchor() == false) goto L23;
        r6.d = this.n.mAnchorLayoutFromEnd;
        if (r6.d == false) goto L19;
        int r8 = this.j.d() - this.n.mAnchorOffset;
    L20:
        r6.c = r8;
        return true;
    L19:
        r8 = this.j.c() + this.n.mAnchorOffset;
    L23:
        if (this.m != Integer.MIN_VALUE) goto L55;
        View r9 = c(this.l);
        if (r9 == null) goto L44;
        if (this.j.e(r9) <= this.j.f()) goto L31;
        r6.b();
        return true;
    L31:
        if ((this.j.a(r9) - this.j.c()) >= 0) goto L35;
        r6.c = this.j.c();
        r6.d = false;
        return true;
    L35:
        if ((this.j.d() - this.j.b(r9)) >= 0) goto L39;
        r6.c = this.j.d();
        r6.d = true;
        return true;
    L39:
        if (r6.d == false) goto L41;
        int r10 = this.j.b(r9) + this.j.b();
    L42:
        r6.c = r10;
    L54:
        return true;
    L41:
        r10 = this.j.a(r9);
        goto L42
    L44:
        if (x() > 0) goto L46;
    L53:
        r6.b();
        goto L54
    L46:
        if (this.l >= d(i(0))) goto L48;
        boolean r11 = true;
    L50:
        if (r11 != this.k) goto L52;
        r1 = true;
    L52:
        r6.d = r1;
        goto L53
    L48:
        r11 = false;
        goto L50
    L55:
        r6.d = this.k;
        if (this.k == false) goto L58;
        int r12 = this.j.d() - this.m;
    L59:
        r6.c = r12;
        return true;
    L58:
        r12 = this.j.c() + this.m;
    L62:
        return false;
    }

    private int b(int r2, RecyclerView.o r3, RecyclerView.s r4, boolean r5) {
        int r0 = r2 - this.j.c();
        if (r0 <= 0) goto L10;
        int r6 = -c(r0, r3, r4);
        int r7 = r2 + r6;
        if (r5 == false) goto L12;
        int r8 = r7 - this.j.c();
        if (r8 <= 0) goto L13;
        this.j.a(-r8);
        return r6 - r8;
    L13:
        return r6;
    L12:
        return r6;
    L10:
        return 0;
    }

    private void b(a r2) {
        h(r2.f14061b, r2.c);
    }

    private void b(RecyclerView.o r5, int r6, int r7) {
        if (r6 >= 0) goto L4;
        return;
    L4:
        int r8 = r6 - r7;
        int r9 = x();
        if (this.k == false) goto L16;
        int r10 = r9 - 1;
        int r0 = r10;
    L7:
        if (r0 < 0) goto L32;
        View r1 = i(r0);
        if (this.j.b(r1) > r8) goto L14;
        if (this.j.c(r1) > r8) goto L14;
        r0 = r0 - 1;
    L14:
        a(r5, r10, r0);
        return;
    L32:
        return;
    L16:
        int r2 = 0;
    L17:
        if (r2 >= r9) goto L33;
        View r3 = i(r2);
        if (this.j.b(r3) > r8) goto L24;
        if (this.j.c(r3) > r8) goto L24;
        r2 = r2 + 1;
    L24:
        a(r5, 0, r2);
        return;
    }

    private void b(RecyclerView.o r16, RecyclerView.s r17, int r18, int r19) {
        if (r17.b() == true) goto L5;
        return;
    L5:
        if (x() != 0) goto L7;
        return;
    L7:
        if (r17.a() == false) goto L9;
        return;
    L9:
        if (b() == false) goto L42;
        List<RecyclerView.v> r3 = r16.c();
        int r4 = r3.size();
        int r6 = d(i(0));
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
    L12:
        if (r7 >= r4) goto L28;
        RecyclerView.v r10 = (RecyclerView.v) ZeusTransformUtils.preCheckCast(r3.get(r7), RecyclerView.v.class, "com.obric.memorydata.plugin");
        if (r10.B() == true) goto L27;
        byte r12 = 1;
        if (r10.m() >= r6) goto L19;
        boolean r11 = true;
    L21:
        if (r11 == this.k) goto L23;
        r12 = -1;
    L23:
        int r13 = this.j.e(r10.c);
        if (r12 != (-1)) goto L26;
        r8 = r8 + r13;
        goto L27
    L26:
        r9 = r9 + r13;
        goto L27
    L19:
        r11 = false;
    L27:
        r7 = r7 + 1;
        goto L12
    L28:
        this.f14058a.l = r3;
        if (r8 <= 0) goto L31;
        h(d(O()), r18);
        this.f14058a.h = r8;
        this.f14058a.c = 0;
        this.f14058a.a();
        a(r16, this.f14058a, r17, false);
    L31:
        if (r9 <= 0) goto L33;
        a(d(P()), r19);
        this.f14058a.h = r9;
        this.f14058a.c = 0;
        this.f14058a.a();
        a(r16, this.f14058a, r17, false);
    L33:
        this.f14058a.l = null;
        return;
    }

    private boolean b(RecyclerView.o r5, RecyclerView.s r6, a r7) {
        boolean r1 = false;
        if (x() != 0) goto L5;
        return false;
    L5:
        View r0 = G();
        if (r0 == null) goto L12;
        if (r7.a(r0, r6) == false) goto L12;
        r7.a(r0, d(r0));
        return true;
    L12:
        if (this.f14059b == this.d) goto L14;
        return false;
    L14:
        View r8 = a(r5, r6, r7.d, this.d);
        if (r8 == null) goto L35;
        r7.b(r8, d(r8));
        if (r6.a() == false) goto L19;
    L34:
        return true;
    L19:
        if (b() == false) goto L34;
        int r9 = this.j.a(r8);
        int r10 = this.j.b(r8);
        int r2 = this.j.c();
        int r4 = this.j.d();
        if (r10 > r2) goto L24;
        if (r9 >= r2) goto L24;
        boolean r3 = true;
    L25:
        if (r9 < r4) goto L28;
        if (r10 <= r4) goto L28;
        r1 = true;
    L28:
        if (r3 == true) goto L31;
        if (r1 == false) goto L34;
    L31:
        if (r7.d == false) goto L33;
        r2 = r4;
    L33:
        r7.c = r2;
    L24:
        r3 = false;
        goto L25
    L35:
        return false;
    }

    private void c(RecyclerView.o r5, int r6, int r7) {
        int r0 = x();
        if (r6 >= 0) goto L5;
        return;
    L5:
        int r1 = (this.j.e() - r6) + r7;
        if (this.k == false) goto L17;
        int r8 = 0;
    L8:
        if (r8 >= r0) goto L33;
        View r2 = i(r8);
        if (this.j.a(r2) < r1) goto L15;
        if (this.j.d(r2) < r1) goto L15;
        r8 = r8 + 1;
    L15:
        a(r5, 0, r8);
        return;
    L33:
        return;
    L17:
        int r3 = r0 - 1;
        int r9 = r3;
    L18:
        if (r9 < 0) goto L34;
        View r10 = i(r9);
        if (this.j.a(r10) < r1) goto L25;
        if (this.j.d(r10) < r1) goto L25;
        r9 = r9 - 1;
    L25:
        a(r5, r3, r9);
        return;
    }

    private void h(int r3, int r4) {
        this.f14058a.c = r4 - this.j.c();
        this.f14058a.d = r3;
        c r5 = this.f14058a;
        if (this.k == false) goto L5;
        int r0 = 1;
    L6:
        r5.e = r0;
        this.f14058a.f = -1;
        this.f14058a.f14065b = r4;
        this.f14058a.g = Integer.MIN_VALUE;
        return;
    L5:
        r0 = -1;
        goto L6
    }

    private int i(RecyclerView.s r8) {
        if (x() != 0) goto L6;
        return 0;
    L6:
        j();
        return y.a(r8, this.j, a(!this.e, true), b(!this.e, true), this, this.e, this.k);
    }

    private int j(RecyclerView.s r7) {
        if (x() != 0) goto L6;
        return 0;
    L6:
        j();
        return y.a(r7, this.j, a(!this.e, true), b(!this.e, true), this, this.e);
    }

    private int k(RecyclerView.s r7) {
        if (x() != 0) goto L6;
        return 0;
    L6:
        j();
        return y.b(r7, this.j, a(!this.e, true), b(!this.e, true), this, this.e);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public int a(int r3, RecyclerView.o r4, RecyclerView.s r5) {
        if (this.i != 1) goto L7;
        return 0;
    L7:
        return c(r3, r4, r5);
    }

    int a(RecyclerView.o r8, c r9, RecyclerView.s r10, boolean r11) {
        int r0 = r9.c;
        if (r9.g != Integer.MIN_VALUE) goto L5;
    L8:
        int r1 = r9.c + r9.h;
        b r3 = this.g;
    L10:
        if (r9.m == true) goto L13;
        if (r1 > 0) goto L13;
    L34:
        return r0 - r9.c;
    L13:
        if (r9.a(r10) == false) goto L34;
        r3.a();
        a(r8, r10, r9, r3);
        if (r3.f14063b == true) goto L34;
        r9.f14065b += r3.f14062a * r9.f;
        if (r3.c == true) goto L20;
    L23:
        r9.c -= r3.f14062a;
        r1 = r1 - r3.f14062a;
    L25:
        if (r9.g == Integer.MIN_VALUE) goto L30;
        r9.g += r3.f14062a;
        if (r9.c >= 0) goto L29;
        r9.g += r9.c;
    L29:
        a(r8, r9);
    L30:
        if (r11 == false) goto L10;
        if (r3.d == false) goto L10;
    L20:
        if (r9.l != null) goto L23;
        if (r10.a() == true) goto L25;
    L5:
        if (r9.c >= 0) goto L7;
        r9.g += r9.c;
    L7:
        a(r8, r9);
        goto L8
    }

    View a(int r2, int r3, boolean r4, boolean r5) {
        j();
        int r0 = 320;
        if (r4 == false) goto L5;
        int r6 = 24579;
    L6:
        if (r5 == true) goto L10;
        r0 = 0;
    L10:
        if (this.i != 0) goto L12;
        ac r1 = this.r;
    L14:
        return r1.a(r2, r3, r6, r0);
    L12:
        r1 = this.s;
        goto L14
    L5:
        r6 = 320;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public View a(View r4, int r5, RecyclerView.o r6, RecyclerView.s r7) {
        N();
        if (x() != 0) goto L5;
        return null;
    L5:
        int r8 = f(r5);
        if (r8 != Integer.MIN_VALUE) goto L8;
        return null;
    L8:
        j();
        a(r8, (int) (this.j.f() * 0.33333334f), false, r7);
        this.f14058a.g = Integer.MIN_VALUE;
        this.f14058a.f14064a = false;
        a(r6, this.f14058a, r7, true);
        if (r8 != (-1)) goto L11;
        View r9 = R();
    L12:
        if (r8 != (-1)) goto L14;
        View r3 = O();
    L16:
        if (r3.hasFocusable() == false) goto L20;
        if (r9 != null) goto L19;
        return null;
    L19:
        return r3;
    L20:
        return r9;
    L14:
        r3 = P();
        goto L16
    L11:
        r9 = Q();
        goto L12
    }

    View a(RecyclerView.o r17, RecyclerView.s r18, boolean r19, boolean r20) {
        j();
        int r1 = x();
        int r2 = -1;
        if (r20 == false) goto L5;
        int r3 = x() - 1;
        int r5 = -1;
    L6:
        int r6 = r18.e();
        int r7 = this.j.c();
        int r8 = this.j.d();
        View r9 = null;
        View r10 = null;
        View r11 = null;
    L7:
        if (r3 == r2) goto L37;
        View r12 = i(r3);
        int r13 = d(r12);
        int r14 = this.j.a(r12);
        int r15 = this.j.b(r12);
        if (r13 < 0) goto L36;
        if (r13 >= r6) goto L36;
        if (((RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r12.getLayoutParams(), RecyclerView.LayoutParams.class, "com.obric.memorydata.plugin")).d() == false) goto L15;
        if (r11 != null) goto L36;
        r11 = r12;
        goto L36
    L15:
        if (r15 > r7) goto L18;
        if (r14 >= r7) goto L18;
        boolean r4 = true;
    L19:
        if (r14 < r8) goto L22;
        if (r15 <= r8) goto L22;
        boolean r16 = true;
    L23:
        if (r4 == true) goto L27;
        if (r16 == true) goto L27;
        return r12;
    L27:
        if (r19 == false) goto L32;
        if (r16 == true) goto L33;
        if (r9 != null) goto L36;
    L35:
        r9 = r12;
    L33:
        r10 = r12;
        goto L36
    L32:
        if (r4 == true) goto L33;
        if (r9 != null) goto L36;
    L22:
        r16 = false;
    L18:
        r4 = false;
    L36:
        r3 = r3 + r5;
        goto L7
    L37:
        if (r9 != null) goto L54;
        if (r10 == null) goto L42;
        return r10;
    L42:
        return r11;
    L54:
        return r9;
    L5:
        r2 = r1;
        r5 = 1;
        r3 = 0;
        goto L6
    }

    View a(boolean r3, boolean r4) {
        if (this.k == false) goto L7;
        int r0 = x() - 1;
        int r1 = -1;
    L6:
        return a(r0, r1, r3, r4);
    L7:
        r0 = 0;
        r1 = x();
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public RecyclerView.LayoutParams a() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void a(int r3, int r4, RecyclerView.s r5, RecyclerView.h.a r6) {
        RecyclerView.h.a r7 = (RecyclerView.h.a) ZeusTransformUtils.wrapperContextForParams(r6, RecyclerView.h.a.class, "com.obric.memorydata.plugin");
        if (this.i == 0) goto L7;
        r3 = r4;
    L7:
        if (x() == 0) goto L16;
        if (r3 == 0) goto L17;
        j();
        if (r3 <= 0) goto L13;
        int r0 = 1;
    L14:
        a(r0, Math.abs(r3), true, r5);
        a(r5, this.f14058a, r7);
        return;
    L13:
        r0 = -1;
        goto L14
    L17:
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void a(int r6, RecyclerView.h.a r7) {
        RecyclerView.h.a r8 = (RecyclerView.h.a) ZeusTransformUtils.wrapperContextForParams(r7, RecyclerView.h.a.class, "com.obric.memorydata.plugin");
        SavedState r0 = this.n;
        int r1 = -1;
        if (r0 != null) goto L5;
    L7:
        N();
        boolean r2 = this.k;
        int r3 = this.l;
        if (r3 != (-1)) goto L12;
        if (r2 == false) goto L11;
        r3 = r6 - 1;
        goto L12
    L11:
        r3 = 0;
    L12:
        if (r2 == true) goto L15;
        r1 = 1;
    L15:
        int r4 = 0;
    L17:
        if (r4 >= this.h) goto L21;
        if (r3 < 0) goto L25;
        if (r3 >= r6) goto L26;
        r8.b(r3, 0);
        r3 = r3 + r1;
        r4 = r4 + 1;
        goto L17
    L26:
        return;
    L25:
        return;
    L21:
        return;
    L5:
        if (r0.hasValidAnchor() == false) goto L7;
        r2 = this.n.mAnchorLayoutFromEnd;
        r3 = this.n.mAnchorPosition;
        goto L12
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void a(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SavedState.class) == false) goto L9;
        SavedState r5 = (SavedState) ZeusTransformUtils.preCheckCast(r4, SavedState.class, "com.obric.memorydata.plugin");
        this.n = r5;
        if (this.l == (-1)) goto L7;
        r5.invalidateAnchor();
    L7:
        q();
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void a(AccessibilityEvent r2) {
        super.a(r2);
        if (x() <= 0) goto L6;
        r2.setFromIndex(o());
        r2.setToIndex(p());
        return;
    }

    void a(RecyclerView.o r1, RecyclerView.s r2, a r3, int r4) {
    }

    void a(RecyclerView.o r8, RecyclerView.s r9, c r10, b r11) {
        View r12 = r10.a(r8);
        if (r12 != null) goto L6;
        r11.f14063b = true;
        return;
    L6:
        RecyclerView.LayoutParams r6 = (RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r12.getLayoutParams(), RecyclerView.LayoutParams.class, "com.obric.memorydata.plugin");
        if (r10.l != null) goto L15;
        boolean r0 = this.k;
        if (r10.f != (-1)) goto L11;
        boolean r3 = true;
    L12:
        if (r0 != r3) goto L14;
        b(r12);
    L22:
        a(r12, 0, 0);
        r11.f14062a = this.j.e(r12);
        if (this.i == 1) goto L25;
        int r1 = D();
        int r2 = this.j.f(r12) + r1;
        if (r10.f != (-1)) goto L35;
        int r4 = r10.f14065b;
        int r5 = r1;
        int r7 = r4;
        int r13 = r2;
        int r14 = r10.f14065b - r11.f14062a;
    L36:
        b(r12, r14, r5, r7, r13);
        if (r6.d() == false) goto L39;
    L40:
        r11.c = true;
    L41:
        r11.d = r12.hasFocusable();
        return;
    L39:
        if (r6.e() == false) goto L41;
    L35:
        int r15 = r10.f14065b;
        r7 = r10.f14065b + r11.f14062a;
        r5 = r1;
        r13 = r2;
        r14 = r15;
        goto L36
    L25:
        if (i() == false) goto L27;
        int r16 = A() - E();
        r14 = r16 - this.j.f(r12);
    L29:
        if (r10.f != (-1)) goto L31;
        int r17 = r10.f14065b;
        r5 = r10.f14065b - r11.f14062a;
        r7 = r16;
        r13 = r17;
        goto L36
    L31:
        int r18 = r10.f14065b;
        r13 = r10.f14065b + r11.f14062a;
        r7 = r16;
        r5 = r18;
        goto L36
    L27:
        r14 = C();
        r16 = this.j.f(r12) + r14;
        goto L29
    L14:
        b(r12, 0);
        goto L22
    L11:
        r3 = false;
        goto L12
    L15:
        boolean r19 = this.k;
        if (r10.f != (-1)) goto L18;
        boolean r20 = true;
    L19:
        if (r19 != r20) goto L21;
        a(r12);
        goto L22
    L21:
        a(r12, 0);
        goto L22
    L18:
        r20 = false;
        goto L19
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void a(RecyclerView.s r1) {
        super.a(r1);
        this.n = null;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.o.a();
    }

    void a(RecyclerView.s r2, c r3, RecyclerView.h.a r4) {
        RecyclerView.h.a r1 = (RecyclerView.h.a) ZeusTransformUtils.wrapperContextForParams(r4, RecyclerView.h.a.class, "com.obric.memorydata.plugin");
        int r5 = r3.d;
        if (r5 >= 0) goto L5;
        return;
    L5:
        if (r5 >= r2.e()) goto L9;
        r1.b(r5, Math.max(0, r3.g));
        return;
    }

    public void a(RecyclerView.s r3, int[] r4) {
        int r5 = f(r3);
        if (this.f14058a.f != (-1)) goto L5;
        int r2 = 0;
    L6:
        r4[0] = r5;
        r4[1] = r2;
        return;
    L5:
        r2 = r5;
        r5 = 0;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void a(RecyclerView r1, RecyclerView.o r2) {
        super.a(r1, r2);
        if (this.f == false) goto L6;
        c(r2);
        r2.a();
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void a(RecyclerView r3, RecyclerView.s r4, int r5) {
        p r6 = new p((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r6.c(r5);
        a(r6);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void a(String r2) {
        if (this.n != null) goto L6;
        super.a(r2);
        return;
    }

    public void a(boolean r2) {
        a(null);
        if (this.d != r2) goto L5;
        return;
    L5:
        this.d = r2;
        q();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public int b(int r2, RecyclerView.o r3, RecyclerView.s r4) {
        if (this.i != 0) goto L7;
        return 0;
    L7:
        return c(r2, r3, r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public int b(RecyclerView.s r1) {
        return k(r1);
    }

    View b(boolean r3, boolean r4) {
        if (this.k == false) goto L7;
        int r0 = 0;
        int r1 = x();
    L6:
        return a(r0, r1, r3, r4);
    L7:
        r0 = x() - 1;
        r1 = -1;
        goto L6
    }

    public void b(int r3) {
        if (r3 != 0) goto L4;
    L8:
        a(null);
        if (r3 == this.i) goto L11;
    L12:
        v r0 = v.a(this, r3);
        this.j = r0;
        this.o.f14060a = r0;
        this.i = r3;
        q();
        return;
    L11:
        if (this.j == null) goto L12;
        return;
    L4:
        if (r3 == 1) goto L8;
        throw new IllegalArgumentException("invalid orientation:" + r3);
    }

    public void b(int r1, int r2) {
        this.l = r1;
        this.m = r2;
        SavedState r3 = this.n;
        if (r3 == null) goto L5;
        r3.invalidateAnchor();
    L5:
        q();
    }

    public void b(boolean r2) {
        a(null);
        if (r2 != this.c) goto L5;
        return;
    L5:
        this.c = r2;
        q();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public boolean b() {
        if (this.n == null) goto L5;
    L7:
        return false;
    L5:
        if (this.f14059b != this.d) goto L7;
        return true;
    }

    int c(int r6, RecyclerView.o r7, RecyclerView.s r8) {
        if (x() == 0) goto L17;
        if (r6 == 0) goto L17;
        j();
        this.f14058a.f14064a = true;
        if (r6 <= 0) goto L9;
        int r0 = 1;
    L10:
        int r3 = Math.abs(r6);
        a(r0, r3, true, r8);
        int r2 = this.f14058a.g + a(r7, this.f14058a, r8, false);
        if (r2 >= 0) goto L13;
        return 0;
    L13:
        if (r3 <= r2) goto L15;
        r6 = r0 * r2;
    L15:
        this.j.a(-r6);
        this.f14058a.k = r6;
        return r6;
    L9:
        r0 = -1;
    L17:
        return 0;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public int c(RecyclerView.s r1) {
        return k(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public View c(int r3) {
        int r0 = x();
        if (r0 != 0) goto L6;
        return null;
    L6:
        int r1 = r3 - d(i(0));
        if (r1 < 0) goto L13;
        if (r1 >= r0) goto L13;
        View r2 = i(r1);
        if (d(r2) != r3) goto L13;
        return r2;
    L13:
        return super.c(r3);
    }

    View c(int r4, int r5) {
        j();
        if (r5 <= r4) goto L5;
        byte r0 = 1;
    L8:
        if (r0 != 0) goto L12;
        return i(r4);
    L12:
        if (this.j.a(i(r4)) >= this.j.c()) goto L14;
        int r1 = 16644;
        int r2 = 16388;
    L16:
        if (this.i != 0) goto L18;
        ac r3 = this.r;
    L20:
        return r3.a(r4, r5, r1, r2);
    L18:
        r3 = this.s;
        goto L20
    L14:
        r1 = 4161;
        r2 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        goto L16
    L5:
        if (r5 >= r4) goto L7;
        r0 = -1;
        goto L8
    L7:
        r0 = 0;
        goto L8
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void c(RecyclerView.o r9, RecyclerView.s r10) {
        int r1 = -1;
        if (this.n != null) goto L7;
        if (this.l != (-1)) goto L7;
    L10:
        SavedState r0 = this.n;
        if (r0 != null) goto L13;
    L15:
        j();
        this.f14058a.f14064a = false;
        N();
        View r2 = G();
        if (this.o.e == true) goto L18;
    L28:
        this.o.a();
        this.o.d = this.k ^ this.d;
        a(r9, r10, this.o);
        this.o.e = true;
    L29:
        c r3 = this.f14058a;
        if (r3.k < 0) goto L32;
        int r4 = 1;
    L33:
        r3.f = r4;
        int[] r5 = this.z;
        r5[0] = 0;
        r5[1] = 0;
        a(r10, r5);
        int r6 = Math.max(0, this.z[0]) + this.j.c();
        int r7 = Math.max(0, this.z[1]) + this.j.g();
        if (r10.a() == false) goto L50;
        int r8 = this.l;
        if (r8 == (-1)) goto L50;
        if (this.m == Integer.MIN_VALUE) goto L50;
        View r11 = c(r8);
        if (r11 == null) goto L50;
        if (this.k == false) goto L44;
        int r12 = this.j.d() - this.j.b(r11);
        int r13 = this.m;
    L45:
        int r14 = r12 - r13;
        if (r14 <= 0) goto L48;
        r6 = r6 + r14;
        goto L50
    L48:
        r7 = r7 - r14;
        goto L50
    L44:
        r13 = this.j.a(r11) - this.j.c();
        r12 = this.m;
    L50:
        if (this.o.d == false) goto L55;
        if (this.k == false) goto L56;
    L53:
        r1 = 1;
    L56:
        a(r9, r10, this.o, r1);
        a(r9);
        this.f14058a.m = m();
        this.f14058a.j = r10.a();
        this.f14058a.i = 0;
        if (this.o.d == false) goto L64;
        b(this.o);
        this.f14058a.h = r6;
        a(r9, this.f14058a, r10, false);
        int r15 = this.f14058a.f14065b;
        int r16 = this.f14058a.d;
        if (this.f14058a.c <= 0) goto L61;
        r7 = r7 + this.f14058a.c;
    L61:
        a(this.o);
        this.f14058a.h = r7;
        this.f14058a.d += this.f14058a.e;
        a(r9, this.f14058a, r10, false);
        int r17 = this.f14058a.f14065b;
        if (this.f14058a.c <= 0) goto L71;
        int r18 = this.f14058a.c;
        h(r16, r15);
        this.f14058a.h = r18;
        a(r9, this.f14058a, r10, false);
        r15 = this.f14058a.f14065b;
    L71:
        if (x() > 0) goto L73;
    L77:
        b(r9, r10, r15, r17);
        if (r10.a() == true) goto L80;
        this.j.a();
    L81:
        this.f14059b = this.d;
        return;
    L80:
        this.o.a();
        goto L81
    L73:
        if ((this.k ^ this.d) == false) goto L75;
        int r19 = a(r17, r9, r10, true);
        int r20 = r15 + r19;
        int r21 = r17 + r19;
        int r22 = b(r20, r9, r10, false);
    L76:
        r15 = r20 + r22;
        r17 = r21 + r22;
        goto L77
    L75:
        int r23 = b(r15, r9, r10, true);
        r20 = r15 + r23;
        r21 = r17 + r23;
        r22 = a(r21, r9, r10, false);
        goto L76
    L64:
        a(this.o);
        this.f14058a.h = r7;
        a(r9, this.f14058a, r10, false);
        r17 = this.f14058a.f14065b;
        int r24 = this.f14058a.d;
        if (this.f14058a.c <= 0) goto L67;
        r6 = r6 + this.f14058a.c;
    L67:
        b(this.o);
        this.f14058a.h = r6;
        this.f14058a.d += this.f14058a.e;
        a(r9, this.f14058a, r10, false);
        r15 = this.f14058a.f14065b;
        if (this.f14058a.c <= 0) goto L71;
        int r25 = this.f14058a.c;
        a(r24, r17);
        this.f14058a.h = r25;
        a(r9, this.f14058a, r10, false);
        r17 = this.f14058a.f14065b;
        goto L71
    L55:
        if (this.k == false) goto L53;
    L32:
        r4 = -1;
        goto L33
    L18:
        if (this.l != (-1)) goto L28;
        if (this.n != null) goto L28;
        if (r2 == null) goto L29;
        if (this.j.a(r2) < this.j.d()) goto L26;
    L27:
        this.o.a(r2, d(r2));
        goto L29
    L26:
        if (this.j.b(r2) > this.j.c()) goto L29;
    L13:
        if (r0.hasValidAnchor() == false) goto L15;
        this.l = this.n.mAnchorPosition;
    L7:
        if (r10.e() != 0) goto L10;
        c(r9);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public boolean c() {
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public int d(RecyclerView.s r1) {
        return i(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.r.b
    public PointF d(int r4) {
        if (x() != 0) goto L6;
        return null;
    L6:
        boolean r0 = false;
        int r2 = 1;
        if (r4 >= d(i(0))) goto L10;
        r0 = true;
    L10:
        if (r0 == this.k) goto L13;
        r2 = -1;
    L13:
        if (this.i != 0) goto L17;
        return new PointF(r2, 0.0f);
    L17:
        return new PointF(0.0f, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public Parcelable d() {
        if (this.n != null) goto L5;
        SavedState r0 = new SavedState();
        if (x() <= 0) goto L12;
        j();
        boolean r1 = this.f14059b ^ this.k;
        r0.mAnchorLayoutFromEnd = r1;
        if (r1 == false) goto L11;
        View r2 = P();
        r0.mAnchorOffset = this.j.d() - this.j.b(r2);
        r0.mAnchorPosition = d(r2);
    L13:
        return r0;
    L11:
        View r3 = O();
        r0.mAnchorPosition = d(r3);
        r0.mAnchorOffset = this.j.a(r3) - this.j.c();
        goto L13
    L12:
        r0.invalidateAnchor();
        goto L13
    L5:
        return new SavedState(this.n);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public int e(RecyclerView.s r1) {
        return i(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void e(int r1) {
        this.l = r1;
        this.m = Integer.MIN_VALUE;
        SavedState r2 = this.n;
        if (r2 == null) goto L5;
        r2.invalidateAnchor();
    L5:
        q();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public boolean e() {
        if (this.i != 0) goto L5;
        return true;
    L5:
        return false;
    }

    int f(int r5) {
        if (r5 == 1) goto L43;
        if (r5 == 2) goto L36;
        if (r5 == 17) goto L31;
        if (r5 == 33) goto L26;
        if (r5 == 66) goto L21;
        if (r5 == 130) goto L16;
        return Integer.MIN_VALUE;
    L16:
        if (this.i != 1) goto L19;
        return 1;
    L19:
        return Integer.MIN_VALUE;
    L21:
        if (this.i != 0) goto L24;
        return 1;
    L24:
        return Integer.MIN_VALUE;
    L26:
        if (this.i != 1) goto L29;
        return -1;
    L29:
        return Integer.MIN_VALUE;
    L31:
        if (this.i != 0) goto L34;
        return -1;
    L34:
        return Integer.MIN_VALUE;
    L36:
        if (this.i != 1) goto L39;
        return 1;
    L39:
        if (i() == false) goto L41;
        return -1;
    L41:
        return 1;
    L43:
        if (this.i != 1) goto L46;
        return -1;
    L46:
        if (i() == false) goto L48;
        return 1;
    L48:
        return -1;
    }

    @Deprecated
    public int f(RecyclerView.s r1) {
        if (r1.d() == true) goto L5;
        return 0;
    L5:
        return this.j.f();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public boolean f() {
        if (this.i == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public int g(RecyclerView.s r1) {
        return j(r1);
    }

    public boolean g() {
        return this.d;
    }

    public int h() {
        return this.i;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public int h(RecyclerView.s r1) {
        return j(r1);
    }

    public boolean i() {
        if (v() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    void j() {
        if (this.f14058a != null) goto L6;
        this.f14058a = k();
        return;
    }

    c k() {
        return new c();
    }

    public boolean l() {
        return this.e;
    }

    boolean m() {
        if (this.j.h() == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.j.e() != 0) goto L7;
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    boolean n() {
        if (z() != 1073741824) goto L5;
    L9:
        return false;
    L5:
        if (y() == 1073741824) goto L9;
        if (M() == false) goto L9;
        return true;
    }

    public int o() {
        View r0 = a(0, x(), false, true);
        if (r0 != null) goto L6;
        return -1;
    L6:
        return d(r0);
    }

    public int p() {
        View r0 = a(x() - 1, -1, false, true);
        if (r0 != null) goto L6;
        return -1;
    L6:
        return d(r0);
    }
}
