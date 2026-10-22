package ne;

import com.qualcomm.qti.qesdk.QesdkUtils;
import ge.p;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements me.b<ke.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f9532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p<CharSequence, Integer, xd.d<Integer, Integer>> f9535d;

    /* JADX INFO: renamed from: ne.a$a, reason: collision with other inner class name */
    public static final class C0123a implements Iterator<ke.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9537b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f9538m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public ke.c f9539n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f9540o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ a f9541p;

        public C0123a(a r8) {
            this.f9541p = r8;
            this.f9536a = -1;
            int r10 = l6.a.x(r8.f9533b, r8.f9532a.length());
            this.f9537b = r10;
            this.f9538m = r10;
        }

        public final void a() {
            int r8 = this.f9538m;
            int r10 = 0;
            if (r8 >= 0) goto L5;
            this.f9536a = 0;
            this.f9539n = null;
            return;
        L5:
            a r11 = this.f9541p;
            int r12 = r11.f9534c;
            CharSequence r13 = r11.f9532a;
            if (r12 <= 0) goto L10;
            int r14 = this.f9540o + 1;
            this.f9540o = r14;
            if (r14 < r12) goto L10;
        L11:
            ke.c r15 = new ke.c(this.f9537b, j.x0(r13));
        L15:
            this.f9539n = r15;
            this.f9538m = -1;
        L24:
            this.f9536a = 1;
            return;
        L10:
            if (r8 > r13.length()) goto L11;
            xd.d<Integer, Integer> r16 = r11.f9535d.invoke(r13, Integer.valueOf(this.f9538m));
            if (r16 != null) goto L16;
            r15 = new ke.c(this.f9537b, j.x0(r13));
            goto L15
        L16:
            int r17 = r16.f13867a.intValue();
            int r18 = r16.f13868b.intValue();
            int r19 = this.f9537b;
            if (r17 > Integer.MIN_VALUE) goto L19;
            ke.c r20 = ke.c.f9116n;
        L20:
            this.f9539n = r20;
            int r21 = r17 + r18;
            this.f9537b = r21;
            if (r18 != 0) goto L23;
            r10 = 1;
        L23:
            this.f9538m = r21 + r10;
            goto L24
        L19:
            r20 = new ke.c(r19, r17 - 1);
            goto L20
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f9536a != (-1)) goto L6;
            a();
        L6:
            if (this.f9536a == 1) goto L10;
            return false;
        L10:
            return true;
        }

        @Override // java.util.Iterator
        public final ke.c next() {
            if (this.f9536a != (-1)) goto L6;
            a();
        L6:
            if (this.f9536a == 0) goto L10;
            ke.c r8 = this.f9539n;
            he.i.d(r8, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f9539n = null;
            this.f9536a = -1;
            return r8;
        L10:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public a(CharSequence r8, int r10, int r11, h r12) {
        he.i.f(r8, QesdkUtils.TAGS.TAG_INPUT);
        this.f9532a = r8;
        this.f9533b = r10;
        this.f9534c = r11;
        this.f9535d = r12;
    }

    @Override // me.b
    public final Iterator<ke.c> iterator() {
        return new C0123a(this);
    }
}
