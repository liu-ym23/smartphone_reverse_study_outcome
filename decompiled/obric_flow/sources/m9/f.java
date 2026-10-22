package m9;

import android.content.Context;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.n;
import com.bytedance.crash.upload.k;
import org.json.JSONObject;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends e {
    public final /* synthetic */ int f;

    public /* synthetic */ f(CrashType r5, Context r10, c r11, k r12, int r13) {
        this.f = r13;
        super(r5, r10, r11, r12);
    }

    @Override // m9.e
    public z8.c a(int r5, z8.c r10) {
        switch(this.f) {
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        z8.c r11 = super.a(r5, r10);
        if (r5 != 0) goto L9;
        Header r12 = Header.a();
        r12.b(n.d().u());
        mh.e.g(r12.f4029a, "header", r11.f23416a);
        r11.f23417b = r12;
        io.reactivex.internal.observers.h.c(r11, r12, this.f20050a);
    L19:
        return r11;
    L9:
        if (r5 != 1) goto L11;
        Header r13 = r11.o();
        r13.j();
        r13.k();
        goto L19
    L11:
        if (r5 != 2) goto L13;
        Header.addRuntimeHeader(r11.o().f4029a);
        goto L19
    L13:
        if (r5 != 5) goto L19;
        Header.d(r11.o());
        goto L19
    L5:
        return super.a(r5, r10);
    }

    @Override // m9.e
    public z8.c b(z8.c r5) {
        switch(this.f) {
            case 0: goto L5;
            default: goto L4;
        };
    L4:
        return r5;
    L5:
        Header r10 = Header.a();
        JSONObject r11 = r10.f4029a;
        Header.addRuntimeHeader(r11);
        Header.d(r10);
        r10.b(n.d().u());
        r10.j();
        r10.k();
        JSONObject r12 = r5.f23416a;
        mh.e.g(r11, "header", r12);
        r5.f23417b = r10;
        mh.e.g(m.o(this.f20051b), "process_name", r12);
        io.reactivex.internal.observers.h.c(r5, r10, this.f20050a);
        return r5;
    }

    public f(Context r5, c r10, k r11, boolean r12) {
        this.f = 2;
        if (r12 == false) goto L5;
        CrashType r13 = CrashType.LAUNCH;
    L6:
        super(r13, r5, r10, r11);
        return;
    L5:
        r13 = CrashType.JAVA;
        goto L6
    }
}
