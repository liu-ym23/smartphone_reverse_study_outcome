package com.airbnb.lottie.parser.moshi;

import ai.j0;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.k0;
import io.reactivex.disposables.Disposable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1315c;
    public Object d;

    public void a(int r10) {
        if (r10 < this.f1315c) goto L5;
        int r11 = this.f1314b;
    L6:
        if (r11 >= 0) goto L8;
        return;
    L8:
        int r5 = this.f1313a;
        int r12 = r5 + r11;
        lh.a[] r13 = (lh.a[]) this.d;
        if (r12 >= r13.length) goto L11;
        Arrays.fill(r13, r5, r12, null);
        this.f1313a += r11;
    L12:
        this.f1314b -= r11;
        return;
    L11:
        int r14 = r11 - (r13.length - r5);
        Arrays.fill(r13, r5, r13.length, null);
        Arrays.fill((lh.a[]) this.d, 0, r14, null);
        this.f1313a = r14;
        goto L12
    L5:
        r11 = g(r10);
        goto L6
    }

    public void b(byte[] r10, int r11) {
        int r5 = this.f1314b;
        lh.a[] r12 = (lh.a[]) this.d;
        if (r5 < r12.length) goto L6;
        lh.a[] r13 = new lh.a[r12.length * 2];
        int r14 = this.f1313a;
        System.arraycopy(r12, r14, r13, 0, r12.length - r14);
        lh.a[] r15 = (lh.a[]) this.d;
        int r16 = r15.length;
        int r17 = this.f1313a;
        System.arraycopy(r15, 0, r13, r16 - r17, r17);
        this.d = r13;
        this.f1313a = 0;
    L6:
        int r18 = this.f1313a;
        int r19 = this.f1314b;
        lh.a[] r20 = (lh.a[]) this.d;
        int r21 = (r18 + r19) % r20.length;
        int r22 = this.f1315c;
        r20[r21] = new lh.a(r10, r22, r11);
        this.f1315c = r22 + r11;
        this.f1314b = r19 + 1;
    }

    public void c(g r10) {
        r10.f1323c = null;
        r10.f1321a = null;
        r10.f1322b = null;
        r10.f1325i = 1;
        int r5 = this.f1313a;
        if (r5 <= 0) goto L7;
        int r11 = this.f1315c;
        if ((r11 & 1) != 0) goto L7;
        this.f1315c = r11 + 1;
        this.f1313a = r5 - 1;
        this.f1314b++;
    L7:
        r10.f1321a = (g) this.d;
        this.d = r10;
        int r12 = this.f1315c;
        int r13 = r12 + 1;
        this.f1315c = r13;
        int r14 = this.f1313a;
        if (r14 > 0) goto L10;
    L12:
        int r15 = 4;
    L13:
        int r16 = r15 - 1;
        if ((this.f1315c & r16) != r16) goto L24;
        int r17 = this.f1314b;
        if (r17 != 0) goto L19;
        g r18 = (g) this.d;
        g r19 = r18.f1321a;
        g r20 = r19.f1321a;
        r19.f1321a = r20.f1321a;
        this.d = r19;
        r19.f1322b = r20;
        r19.f1323c = r18;
        r19.f1325i = r18.f1325i + 1;
        r20.f1321a = r19;
        r18.f1321a = r19;
    L23:
        r15 = r15 * 2;
        goto L13
    L19:
        if (r17 != 1) goto L21;
        g r21 = (g) this.d;
        g r22 = r21.f1321a;
        this.d = r22;
        r22.f1323c = r21;
        r22.f1325i = r21.f1325i + 1;
        r21.f1321a = r22;
        this.f1314b = 0;
        goto L23
    L21:
        if (r17 != 2) goto L23;
        this.f1314b = 0;
        goto L23
    L24:
        return;
    L10:
        if ((r13 & 1) != 0) goto L12;
        this.f1315c = r12 + 2;
        this.f1313a = r14 - 1;
        this.f1314b++;
        goto L12
    }

    public void d(Disposable r10) {
        Object[] r5 = (Object[]) this.d;
        int r11 = this.f1313a;
        int r12 = r10.hashCode() * (-1640531527);
        int r13 = (r12 ^ (r12 >>> 16)) & r11;
        Object r14 = r5[r13];
        if (r14 != null) goto L5;
    L13:
        r5[r13] = r10;
        int r15 = this.f1314b + 1;
        this.f1314b = r15;
        if (r15 < this.f1315c) goto L37;
        Object[] r16 = (Object[]) this.d;
        int r17 = r16.length;
        int r18 = r17 << 1;
        int r19 = r18 - 1;
        Object[] r20 = new Object[r18];
    L16:
        int r21 = r15 - 1;
        if (r15 == 0) goto L26;
    L18:
        r17 = r17 - 1;
        Object r22 = r16[r17];
        if (r22 == null) goto L18;
        int r23 = r22.hashCode() * (-1640531527);
        int r24 = (r23 ^ (r23 >>> 16)) & r19;
        if (r20[r24] == null) goto L25;
    L23:
        r24 = (r24 + 1) & r19;
        if (r20[r24] != null) goto L23;
    L25:
        r20[r24] = r16[r17];
        r15 = r21;
        goto L16
    L26:
        this.f1313a = r19;
        this.f1315c = (int) (r18 * 0.75f);
        this.d = r20;
        return;
    L37:
        return;
    L5:
        if (r14.equals(r10) == false) goto L7;
        return;
    L7:
        r13 = (r13 + 1) & r11;
        Object r25 = r5[r13];
        if (r25 == null) goto L13;
        if (r25.equals(r10) == false) goto L7;
    }

    public void e(int r10, int r11) {
        if (r10 < 0) goto L15;
        if (r11 < 0) goto L13;
        int r5 = this.f1315c;
        int r12 = r5 * 2;
        int[] r13 = (int[]) this.d;
        if (r13 != null) goto L8;
        int[] r14 = new int[4];
        this.d = r14;
        Arrays.fill(r14, -1);
    L10:
        int[] r15 = (int[]) this.d;
        r15[r12] = r10;
        r15[r12 + 1] = r11;
        this.f1315c++;
        return;
    L8:
        if (r12 < r13.length) goto L10;
        int[] r16 = new int[r5 * 4];
        this.d = r16;
        System.arraycopy(r13, 0, r16, 0, r13.length);
        goto L10
    L13:
        throw new IllegalArgumentException("Pixel distance must be non-negative");
    L15:
        throw new IllegalArgumentException("Layout positions must be non-negative");
    }

    public void f() {
        int r5 = this.f1315c;
        View r10 = (View) this.d;
        ViewCompat.offsetTopAndBottom(r10, r5 - (r10.getTop() - this.f1313a));
        ViewCompat.offsetLeftAndRight(r10, 0 - (r10.getLeft() - this.f1314b));
    }

    public int g(int r10) {
        int r5 = this.f1314b - 1;
        int r11 = 0;
    L3:
        if (r11 > r5) goto L11;
        int r12 = j0.c(r5, r11, 2, r11);
        int r13 = this.f1313a + r12;
        lh.a[] r14 = (lh.a[]) this.d;
        lh.a r15 = r14[r13 % r14.length];
        int r16 = r15.f19612a;
        if (r10 < r16) goto L6;
        if (r10 < (r16 + r15.f19613b)) goto L10;
        r11 = r12 + 1;
        goto L3
    L10:
        return r12;
    L6:
        r5 = r12 - 1;
        goto L3
    L11:
        return -1;
    }

    public void h(RecyclerView r5, boolean r10) {
        this.f1315c = 0;
        int[] r11 = (int[]) this.d;
        if (r11 == null) goto L5;
        Arrays.fill(r11, -1);
    L5:
        k0 r12 = r5.f13743m;
        if (r5.f13742l == null) goto L21;
        if (r12 != null) goto L9;
        return;
    L9:
        if (r12.f == false) goto L23;
        if (r10 == false) goto L15;
        if (r5.d.g() == true) goto L17;
        r12.g(r5.f13742l.getItemCount(), this);
    L17:
        int r13 = this.f1315c;
        if (r13 <= r12.g) goto L24;
        r12.g = r13;
        r12.f13841h = r10;
        r5.f13728b.l();
        return;
    L24:
        return;
    L15:
        if (r5.G() == true) goto L17;
        r12.f(this.f1313a, this.f1314b, r5.f13729b0, this);
        goto L17
    L23:
        return;
    }

    public void i(int r5, int r10, Object[] r11) {
        this.f1314b--;
    L3:
        int r12 = r5 + 1;
    L4:
        int r13 = r12 & r10;
        Object r14 = r11[r13];
        if (r14 == null) goto L6;
        int r15 = r14.hashCode() * (-1640531527);
        int r16 = (r15 ^ (r15 >>> 16)) & r10;
        if (r5 > r13) goto L13;
        if (r5 >= r16) goto L15;
        if (r16 > r13) goto L15;
    L16:
        r12 = r13 + 1;
    L15:
        r11[r5] = r14;
        r5 = r13;
        goto L3
    L13:
        if (r5 < r16) goto L16;
        if (r16 <= r13) goto L16;
    L6:
        r11[r5] = null;
    }
}
