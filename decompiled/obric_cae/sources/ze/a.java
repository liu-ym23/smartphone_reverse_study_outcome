package ze;

import android.text.TextUtils;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.io.IOException;
import we.a0;
import we.i;
import we.s;
import we.v;
import we.y;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f14367a;

    public a(v r8) {
        this.f14367a = r8;
    }

    @Override // we.s
    public final a0 a(af.f r10) {
        y r8 = r10.f364f;
        g r11 = r10.f360b;
        boolean r12 = !r8.f13339c.equals(HttpMethodContrants.GET);
        v r13 = this.f14367a;
        r11.getClass();
        int r14 = r10.f367i;
        int r15 = r10.f368j;
        int r16 = r10.f369k;
        int r17 = r13.J;
        we.d r18 = r11.f14404e;
        if (r18 == null) goto L29;
        if (r18.request() == null) goto L29;
        if (r11.f14404e.request().f13337a == null) goto L29;
        if (r11.f14404e.request().f13337a.f13244d == null) goto L29;
        String r19 = r11.f14404e.request().f13337a.f13244d;
        int r20 = r11.f14404e.request().f13337a.f13245e;
        if (TextUtils.isEmpty(r19) == false) goto L13;
    L15:
        r17 = r13.J;
        goto L29
    L13:
        if (p000if.a.b().f8332b.contains(r19 + BdimCategoryConstants.SEPARATOR_COLON + r20) == false) goto L15;
        r17 = p000if.a.b().f8331a.get();
    L29:
        af.c r21 = r11.e(r14, r15, r16, r17, r13.E, r12).j(r13, r10, r11);     // Catch: IOException -> L26
        i r22 = r11.f14403d;     // Catch: IOException -> L26
        monitor-enter(r22);     // Catch: IOException -> L26
        r11.f14414o = r21;     // Catch: Throwable -> L23
        monitor-exit(r22);     // Catch: Throwable -> L23
    L22:
        return r10.f(r8, r11, r21, r11.b());
    L23:
        th = move-exception;
        throw th;     // Catch: IOException -> L26
    L26:
        e = move-exception;
        throw new e(e);
    }
}
