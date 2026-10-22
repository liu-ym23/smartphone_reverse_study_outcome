package f1;

import com.bytedance.bdinstall.ILogger;

/* JADX INFO: loaded from: classes.dex */
public class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ILogger f8790a;

    public d(ILogger r10) {
        this.f8790a = r10;
    }

    @Override // f1.h
    public void a(i r10) {
        if (this.f8790a == null) goto L18;
        int r11 = r10.e();
        if (r11 != 1) goto L7;
        this.f8790a.d(r10.s(), r10.h());
        return;
    L7:
        if (r11 != 2) goto L9;
        this.f8790a.i(r10.s(), r10.h());
        return;
    L9:
        if (r11 == 3) goto L14;
        ILogger r12 = this.f8790a;
        if (r11 == 4) goto L13;
        r12.v(r10.s(), r10.h());
        return;
    L13:
        r12.e(r10.s(), r10.h());
        return;
    L14:
        this.f8790a.w(r10.s(), r10.h());
        return;
    }
}
