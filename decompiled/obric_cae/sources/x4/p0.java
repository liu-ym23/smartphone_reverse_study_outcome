package x4;

import android.content.Context;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class p0 implements v0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q0.a f13538a;

    public p0(q0.a r8) {
        this.f13538a = r8;
    }

    @Override // x4.v0.c
    public final void a(String r8, String r10) {
        int r11 = r.f13543a;
        i0 r12 = i0.b(r8);
        if (r12 != null) goto L5;
    L19:
        Objects.toString(r12);
        return;
    L5:
        if (TextUtils.isEmpty(r12.f13443a) == true) goto L19;
        if (TextUtils.isEmpty(r12.f13444b) == true) goto L19;
        q0.a r13 = this.f13538a;
        if (r13 == null) goto L21;
        r0 r14 = (r0) r13;
        Objects.toString(r12);
        j r15 = (j) r14.f13546c;
        Context r16 = r15.a();
        if (r16 == null) goto L15;
        ((i5.b) r15.f13457g.b(new Object[]{r16})).j(r12);
    L15:
        z4.c r17 = r14.f13545b;
        if (r17 == null) goto L22;
        r17.a(new a5.b(r12));
        return;
    L22:
        return;
    }
}
