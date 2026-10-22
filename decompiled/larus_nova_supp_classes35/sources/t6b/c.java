package t6b;

import com.ss.android.lark.biz.im.api.b1;
import com.ss.android.lark.biz.im.api.f0;
import com.ss.android.lark.biz.im.api.u0;
import com.ss.android.lark.biz.im.api.v0;
import com.ss.android.lark.biz.im.api.z0;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class c implements s6b.b<c, d> {
    public final z0 a;
    public final int b;
    public final List<b1> c;
    public final f0 d;
    public final List<u0> e;
    public final Class<?> f;
    public final Boolean g;
    public final y6b.e<y6b.c<?>> h;
    public final boolean i;

    public c() {
        this(null, 0, null, null, null, null, 2047);
    }

    public v0 e() {
        return null;
    }

    public jya.b i() {
        return null;
    }

    @Override // s6b.b
    public final s6b.b a() {
        return new d(this);
    }

    public boolean c() {
        return this.i;
    }

    public List<u0> d() {
        return this.e;
    }

    public z0 f() {
        return this.a;
    }

    public List<b1> g() {
        return this.c;
    }

    public f0 h() {
        return this.d;
    }

    public int j() {
        return this.b;
    }

    public y6b.e<y6b.c<?>> k() {
        return this.h;
    }

    public Boolean l() {
        return this.g;
    }

    public Class<?> m() {
        return this.f;
    }

    @Override // s6b.b
    public final s6b.b b(s6b.b r14) {
        c r15 = (c) r14;
        Intrinsics.checkNotNullParameter(r15, "patch");
        return new c(r15.f(), r15.j(), r15.g(), r15.h(), r15.d(), r15.e(), r15.i(), r15.m(), r15.l(), r15.k(), r15.c());
    }

    public /* synthetic */ c(z0 r16, int r17, List r18, List r19, Class r20, y6b.e r21, int r22) {
        if ((r22 & 1) == 0) goto L5;
        z0 r4 = null;
    L7:
        if ((r22 & 2) == 0) goto L9;
        int r5 = 0;
    L11:
        if ((r22 & 4) == 0) goto L13;
        List r6 = CollectionsKt.emptyList();
    L15:
        if ((r22 & 16) == 0) goto L17;
        List r8 = CollectionsKt.emptyList();
    L19:
        if ((r22 & 128) == 0) goto L21;
        Class r11 = null;
    L23:
        if ((r22 & 512) == 0) goto L25;
        y6b.e r13 = null;
    L27:
        if ((r22 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L29;
        boolean r14 = true;
    L30:
        this(r4, r5, r6, null, r8, null, null, r11, null, r13, r14);
        return;
    L29:
        r14 = false;
        goto L30
    L25:
        r13 = r21;
        goto L27
    L21:
        r11 = r20;
        goto L23
    L17:
        r8 = r19;
        goto L19
    L13:
        r6 = r18;
        goto L15
    L9:
        r5 = r17;
        goto L11
    L5:
        r4 = r16;
        goto L7
    }

    public c(z0 r1, int r2, List<? extends b1> r3, f0 r4, List<? extends u0> r5, v0 r6, jya.b r7, Class<?> r8, Boolean r9, y6b.e<y6b.c<?>> r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r3, "messagePushInterceptors");
        Intrinsics.checkNotNullParameter(r5, "messageListChangeInterceptors");
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
    }
}
