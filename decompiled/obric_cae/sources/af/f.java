package af;

import java.util.List;
import we.a0;
import we.o;
import we.s;
import we.y;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements s.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<s> f359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ze.g f360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ze.d f362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f363e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y f364f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final we.d f365g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o f366h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f367i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f368j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f369k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f370l;

    public f(List<s> r8, ze.g r10, c r11, ze.d r12, int r13, y r14, we.d r15, o r16, int r17, int r18, int r19) {
        this.f359a = r8;
        this.f362d = r12;
        this.f360b = r10;
        this.f361c = r11;
        this.f363e = r13;
        this.f364f = r14;
        this.f365g = r15;
        this.f366h = r16;
        this.f367i = r17;
        this.f368j = r18;
        this.f369k = r19;
    }

    public final we.d a() {
        return this.f365g;
    }

    public final ze.d b() {
        return this.f362d;
    }

    public final o c() {
        return this.f366h;
    }

    public final c d() {
        return this.f361c;
    }

    public final a0 e(y r8) {
        c r10 = this.f361c;
        ze.d r11 = this.f362d;
        return f(r8, this.f360b, r10, r11);
    }

    public final a0 f(y r22, ze.g r23, c r24, ze.d r25) {
        List<s> r8 = this.f359a;
        int r10 = r8.size();
        int r11 = this.f363e;
        if (r11 >= r10) goto L37;
        this.f370l++;
        c r12 = this.f361c;
        if (r12 == null) goto L12;
        if (this.f362d.l(r22.f13337a) == true) goto L12;
        throw new IllegalStateException("network interceptor " + r8.get(r11 - 1) + " must retain the same host and port");
    L12:
        if (r12 != null) goto L14;
    L18:
        List<s> r14 = this.f359a;
        int r13 = r11 + 1;
        f r15 = new f(r14, r23, r24, r25, r13, r22, this.f365g, this.f366h, this.f367i, this.f368j, this.f369k);
        s r16 = r14.get(r11);
        a0 r17 = r16.a(r15);
        if (r24 == null) goto L28;
        if (r13 >= r8.size()) goto L28;
        if (r15.f370l == 1) goto L28;
        throw new IllegalStateException("network interceptor " + r16 + " must call proceed() exactly once");
    L28:
        if (r17 == null) goto L35;
        if (r17.f13120q == null) goto L33;
        return r17;
    L33:
        throw new IllegalStateException("interceptor " + r16 + " returned a response with no body");
    L35:
        throw new NullPointerException("interceptor " + r16 + " returned null");
    L14:
        if (this.f370l <= 1) goto L18;
        throw new IllegalStateException("network interceptor " + r8.get(r11 - 1) + " must call proceed() exactly once");
    L37:
        throw new AssertionError();
    }

    public final int g() {
        return this.f368j;
    }

    public final y h() {
        return this.f364f;
    }

    public final ze.g i() {
        return this.f360b;
    }

    public final int j() {
        return this.f369k;
    }
}
