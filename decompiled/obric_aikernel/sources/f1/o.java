package f1;

import android.util.Log;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class o extends n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f8839e;

    public o(String r10) {
        this.f8839e = "NativeLoggerImpl";
        this.f8839e = r10;
    }

    @Override // f1.b
    protected void z(int r10, int r11, List<String> r12, Throwable r13, String r14, Object... r15) {
        i r16 = i.b().c(r10).d(r11).g(Thread.currentThread().getName()).h(r13).f(y(r12)).e(w(r14, r15)).b();
        int r17 = r16.e();
        if (r17 != 0) goto L5;
        Log.v(this.f8839e, r16.s(), r16.h());
        return;
    L5:
        if (r17 != 2) goto L7;
        Log.i(this.f8839e, r16.s(), r16.h());
        return;
    L7:
        if (r17 != 3) goto L9;
        Log.w(this.f8839e, r16.s(), r16.h());
        return;
    L9:
        if (r17 != 4) goto L11;
    L13:
        Log.e(this.f8839e, r16.s(), r16.h());
        return;
    L11:
        if (r17 == 5) goto L13;
        Log.d(this.f8839e, r16.s(), r16.h());
    }
}
