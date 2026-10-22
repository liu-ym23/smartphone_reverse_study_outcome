package ec;

import android.os.FileObserver;
import android.text.TextUtils;
import com.bytedance.crash.c;
import com.bytedance.crash.f;
import com.bytedance.ies.bullet.service.base.a0;
import ja.d;
import zm.p;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends FileObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f16817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f16818c;

    public b(d r5, a0 r10, String r11) {
        this.f16816a = 0;
        this.f16817b = r5;
        this.f16818c = r10;
        super(r11, 1536);
    }

    @Override // android.os.FileObserver
    public final void onEvent(int r5, String r10) {
        switch(this.f16816a) {
            case 0: goto L19;
            default: goto L5;
        };
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L30;
        f r11 = (f) this.f16817b;     // Catch: Throwable -> L15
        String r12 = (String) this.f16818c;     // Catch: Throwable -> L15
        ((t9.a) r11).getClass();     // Catch: Throwable -> L15
        if (r10.startsWith("anr") == false) goto L12;
        String r13 = cl.a.D(r12 + "/" + r10);     // Catch: Throwable -> L25
    L13:
        p.g = r13;     // Catch: Throwable -> L15
        return;
    L12:
        r13 = null;
    L15:
        th = move-exception;
        c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        return;
    L30:
        return;
    L19:
        if (r5 != 512) goto L21;
    L23:
        ((d) this.f16817b).c((a0) this.f16818c);
        return;
    L21:
        if (r5 == 1024) goto L23;
    }

    public b(String r5, f r10, String r11) {
        this.f16816a = 1;
        this.f16817b = r10;
        this.f16818c = r11;
        super(r5, 136);
    }
}
