package ob;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Queue<c> f11630b;

    static {
    }

    public d(int r10) {
        this.f11629a = 5;
        if (r10 > 0) goto L6;
        r10 = 5;
    L6:
        this.f11629a = r10;
        this.f11630b = new LinkedList();
    }

    public void a(c r10) {
        if (r10 != null) goto L20;
        return;
    L20:
        Queue<c> r11 = this.f11630b;     // Catch: Throwable -> L15
        monitor-enter(r11);     // Catch: Throwable -> L15
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L7:
        if (this.f11630b.size() < this.f11629a) goto L9;
        this.f11630b.poll();     // Catch: Throwable -> L12
    L9:
        this.f11630b.add(r10);     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
    L22:
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
    }

    public void b(d r10) {
    L3:
        if (r10.f() == true) goto L7;
        c r11 = r10.h();
        if (r11 == null) goto L3;
        a(r11);
        goto L3
    }

    public int c(c r10) {
        Queue<c> r11 = this.f11630b;
        monitor-enter(r11);
        int r12 = 4095;
        Iterator<c> r13 = this.f11630b.iterator();     // Catch: Throwable -> L12
    L7:
        if (r13.hasNext() == false) goto L9;
        r12 = r12 & r13.next().f11628f;     // Catch: Throwable -> L12
        goto L7
    L9:
        int r14 = r10.f11628f & r12;     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return r14;
    L12:
        th = move-exception;
        throw th;
    }

    public void d() {
        Queue<c> r10 = this.f11630b;
        monitor-enter(r10);
        this.f11630b.clear();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public c e() {
        c r10 = new c(0, 0, 0, 0, 0);
        Queue<c> r11 = this.f11630b;
        monitor-enter(r11);
        Iterator<c> r12 = this.f11630b.iterator();     // Catch: Throwable -> L23
        int r13 = 0;
    L6:
        if (r12.hasNext() == false) goto L8;
        r13 = r13 + 1;     // Catch: Throwable -> L23
        c r14 = r12.next();     // Catch: Throwable -> L23
        r10.f11623a += r14.f11623a;     // Catch: Throwable -> L23
        r10.f11624b += r14.f11624b;     // Catch: Throwable -> L23
        r10.f11626d += r14.f11626d;     // Catch: Throwable -> L23
        r10.f11625c = r14.f11625c;     // Catch: Throwable -> L23
        goto L6
    L8:
        monitor-exit(r11);     // Catch: Throwable -> L23
        int r15 = r10.f11623a;
        if (r13 <= 0) goto L12;
        int r16 = r13;
    L13:
        r10.f11623a = r15 / r16;
        int r17 = r10.f11624b;
        if (r13 <= 0) goto L16;
        int r18 = r13;
    L17:
        r10.f11624b = r17 / r18;
        int r19 = r10.f11626d;
        if (r13 > 0) goto L21;
        r13 = 1;
    L21:
        r10.f11626d = r19 / r13;
        return r10;
    L16:
        r18 = 1;
        goto L17
    L12:
        r16 = 1;
    L23:
        th = move-exception;
        throw th;
    }

    public boolean f() {
        Queue<c> r10 = this.f11630b;
        monitor-enter(r10);
        boolean r11 = this.f11630b.isEmpty();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean g() {
        Queue<c> r10 = this.f11630b;
        monitor-enter(r10);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f11630b.size() < this.f11629a) goto L7;
        boolean r11 = true;
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return r11;
    L7:
        r11 = false;
        goto L8
    }

    public c h() {
        Queue<c> r10 = this.f11630b;     // Catch: Exception -> L14
        monitor-enter(r10);     // Catch: Exception -> L14
    L11:
        th = move-exception;
        throw th;     // Catch: Exception -> L14
    L5:
        if (this.f11630b.isEmpty() == true) goto L9;
        c r11 = this.f11630b.poll();     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        return r11;
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L11
        return null;
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public int i(c r17, float r18, int r19, int r20) {
        Queue<c> r10 = this.f11630b;
        monitor-enter(r10);
        int r11 = (int) Math.ceil(this.f11630b.size() * r18);     // Catch: Throwable -> L44
        Iterator<c> r12 = this.f11630b.iterator();     // Catch: Throwable -> L44
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        int r21 = 0;
        int r22 = 0;
        int r110 = 0;
        int r111 = 0;
    L6:
        if (r12.hasNext() == false) goto L27;
        c r112 = r12.next();     // Catch: Throwable -> L44
        int r113 = r17.f11623a;     // Catch: Throwable -> L44
        int r114 = r112.f11623a;     // Catch: Throwable -> L44
        if (r113 <= (r114 + r19)) goto L11;
        r14 = r14 + 1;     // Catch: Throwable -> L44
    L13:
        int r115 = r17.f11624b;     // Catch: Throwable -> L44
        int r116 = r112.f11624b;     // Catch: Throwable -> L44
        if (r115 <= (r116 + r19)) goto L17;
        r16 = r16 + 1;     // Catch: Throwable -> L44
    L19:
        int r117 = r17.f11625c;     // Catch: Throwable -> L44
        int r118 = r112.f11625c;     // Catch: Throwable -> L44
        if (r117 <= r118) goto L22;
        r22 = r22 + 1;     // Catch: Throwable -> L44
    L25:
        if ((r17.f11626d + r20) >= r17.f11627e) goto L6;
        r111 = r111 + 1;     // Catch: Throwable -> L44
        goto L6
    L22:
        if (r117 >= r118) goto L25;
        r110 = r110 + 1;     // Catch: Throwable -> L44
        goto L25
    L17:
        if ((r115 + r19) >= r116) goto L19;
        r21 = r21 + 1;     // Catch: Throwable -> L44
        goto L19
    L11:
        if ((r113 + r19) >= r114) goto L13;
        r15 = r15 + 1;     // Catch: Throwable -> L44
        goto L13
    L27:
        monitor-exit(r10);     // Catch: Throwable -> L44
        if (r14 < r11) goto L30;
        r13 = 1;
    L30:
        if (r15 < r11) goto L32;
        r13 = r13 | 2;
    L32:
        if (r16 < r11) goto L34;
        r13 = r13 | 4;
    L34:
        if (r21 < r11) goto L36;
        r13 = r13 | 8;
    L36:
        if (r22 < r11) goto L38;
        r13 = r13 | 16;
    L38:
        if (r110 < r11) goto L40;
        r13 = r13 | 32;
    L40:
        if (r111 < r11) goto L42;
        r13 = r13 | 64;
    L42:
        r17.f11628f = r13;
        return r13;
    L44:
        th = move-exception;
        throw th;
    }
}
