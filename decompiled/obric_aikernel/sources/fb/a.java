package fb;

import ab.b;
import bb.d;
import bb.f;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.utils.c;
import java.util.List;
import nb.h;

/* JADX INFO: loaded from: classes2.dex */
public class a extends cb.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private h f8881l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private d f8882m;

    public a() {
    }

    private void y() {
        String r10 = this.f544h.getConnectionUrl();
        long r11 = c.p(this.f544h);
        int r12 = this.f545i.n("verify_response_pre_file_length");
        if (r12 > 0) goto L5;
    L9:
        long r13 = this.f544h.getStartOffset() + r11;
        List<HttpHeader> r14 = n(r13, this.f544h.getEndOffset(), true);
        this.f547k.f689n.n(r14);
        this.f544h.setHttpRequestHeader(r14.toString());
        this.f8881l = t(r10, r14, r13);
        if (m() == false) goto L12;
        return;
    L12:
        q(r10, r11, this.f8881l);
        long r15 = this.f544h.getTotalBytes();
        a(r15, this.f544h.getMaxBytes());
        if (m() == false) goto L15;
        return;
    L15:
        d r16 = new d(this.f547k, this.f8881l, r13, r15 - r11, this);
        this.f8882m = r16;
        r16.i();
        return;
    L5:
        if (r12 >= b.f132e) goto L9;
        long r17 = r12;
        if (r11 <= r17) goto L9;
        this.f544h.setVerifyCurBytes(r11);
        r11 = r11 - r17;
        this.f544h.setCurBytes(r11);
        goto L9
    }

    @Override // bb.a, bb.e
    public void c(long r10, int r11) {
        if (rb.a.g(this.f544h.getId()).o("use_default_throttle_speed", 1) == 1) goto L14;
        h r12 = this.f8881l;
        if (r12 != null) goto L7;
        return;
    L7:
        if ((r12 instanceof nb.a) == false) goto L21;
        ((nb.a) r12).m(r10);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    L21:
        return;
    L14:
        d r13 = this.f8882m;
        if (r13 == null) goto L23;
        r13.n(r10, r11);
        return;
    }

    @Override // bb.a, bb.e
    public void cancel() {
        d r10 = this.f8882m;
        if (r10 == null) goto L5;
        r10.d();
        return;
    L5:
        o(this.f8881l);
    }

    @Override // bb.a, bb.e
    public void f() {
        d r10 = this.f8882m;
        if (r10 == null) goto L5;
        r10.k();
        return;
    L5:
        o(this.f8881l);
    }

    @Override // bb.a, bb.e
    public void h(boolean r10) {
        d r11 = this.f8882m;
        if (r11 == null) goto L6;
        r11.m(r10);
        return;
    }

    @Override // cb.a, bb.e
    public void k(f r10) {
        if (lb.a.a() == false) goto L6;
        lb.a.g("DownloadSingleSegmentModule", this.f544h.getId(), "proceed", "Run");
    L6:
        if (r(r10, true) == false) goto L8;
        return;
    L8:
        if (m() == true) goto L19;
        y();     // Catch: Throwable -> L13
        o(this.f8881l);
        r10.b();
        return;
    L13:
        th = move-exception;
        o(this.f8881l);
        throw th;
    }
}
