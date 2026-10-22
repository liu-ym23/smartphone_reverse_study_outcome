package ib;

import android.util.Pair;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9453a = "c";

    static {
    }

    public c() {
    }

    @Override // ib.a0
    public void D0(DownloadInfo r10) {
        if (lb.a.a() == false) goto L7;
        if (r10 == null) goto L8;
        lb.a.g(f9453a, r10.getId(), "onStart", "Name: " + r10.getName());
        return;
    L8:
        return;
    }

    @Override // ib.a0
    public void G(DownloadInfo r10, BaseException r11) {
        if (lb.a.a() == false) goto L11;
        if (r10 == null) goto L12;
        String r12 = f9453a;
        int r13 = r10.getId();
        Object[] r14 = new Object[2];
        r14[0] = r10.getName();
        if (r11 == null) goto L8;
        String r15 = r11.getErrorMessage();
    L9:
        r14[1] = r15;
        lb.a.g(r12, r13, "onRetry", String.format("Name: %s because of : %s", r14));
        return;
    L8:
        r15 = "unkown";
        goto L9
    L12:
        return;
    }

    @Override // ib.a0
    public void I(DownloadInfo r10) {
        if (lb.a.a() == false) goto L7;
        if (r10 == null) goto L8;
        lb.a.g(f9453a, r10.getId(), "onFirstStart", "Name: " + r10.getName());
        return;
    L8:
        return;
    }

    @Override // ib.a0
    public void N(DownloadInfo r10, BaseException r11) {
        if (lb.a.a() == false) goto L11;
        if (r10 == null) goto L12;
        String r12 = f9453a;
        int r13 = r10.getId();
        Object[] r14 = new Object[2];
        r14[0] = r10.getName();
        if (r11 == null) goto L8;
        String r15 = r11.getErrorMessage();
    L9:
        r14[1] = r15;
        lb.a.g(r12, r13, "onRetryDelay", String.format("Name: %s because of : %s", r14));
        return;
    L8:
        r15 = "unkown";
        goto L9
    L12:
        return;
    }

    @Override // ib.a0
    public void R(DownloadInfo r10) {
        if (lb.a.a() == false) goto L7;
        if (r10 == null) goto L8;
        lb.a.g(f9453a, r10.getId(), "onFirstSuccess", "Name: " + r10.getName());
        return;
    L8:
        return;
    }

    @Override // ib.a0
    public void W(DownloadInfo r10) {
        if (lb.a.a() == false) goto L7;
        if (r10 == null) goto L8;
        lb.a.g(f9453a, r10.getId(), "onSuccessed", "Name: " + r10.getName() + " " + r10.isSuccessByCache());
        return;
    L8:
        return;
    }

    @Override // ib.a0
    public void Z(DownloadInfo r10) {
        if (lb.a.a() == false) goto L9;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.getTotalBytes() == 0) goto L11;
        lb.a.g(f9453a, r10.getId(), "onProgress", String.format("Name: %s %.2f%%", new Object[]{r10.getName(), Float.valueOf((r10.getCurBytes() / r10.getTotalBytes()) * 100.0f)}));
        return;
    L11:
        return;
    }

    public void a(DownloadInfo r10) {
        if (lb.a.a() == false) goto L7;
        if (r10 == null) goto L8;
        lb.a.g(f9453a, r10.getId(), "onIntercept", "Name: " + r10.getName());
        return;
    L8:
        return;
    }

    public void b(DownloadInfo r10, byte[] r11, int r12) {
        if (lb.a.a() == false) goto L7;
        if (r10 == null) goto L8;
        lb.a.g(f9453a, r10.getId(), "onReceiveData", "Name: " + r10.getName() + " data len:" + r12);
        return;
    L8:
        return;
    }

    public void c(DownloadInfo r10, List<Pair<String, String>> r11) {
        if (lb.a.a() == false) goto L7;
        if (r10 == null) goto L8;
        lb.a.g(f9453a, r10.getId(), "onReceiveHeader", "Name: " + r10.getName() + " header:" + r11);
        return;
    L8:
        return;
    }

    public void d(DownloadInfo r10, String r11) {
        if (lb.a.a() == false) goto L7;
        if (r10 == null) goto L8;
        lb.a.g(f9453a, r10.getId(), "onReceiveRequestLog", "Name: " + r10.getName() + " requestLog:" + r11);
        return;
    L8:
        return;
    }

    @Override // ib.a0
    public void l0(DownloadInfo r10) {
        if (lb.a.a() == false) goto L7;
        if (r10 == null) goto L8;
        lb.a.g(f9453a, r10.getId(), "onPause", "Name: " + r10.getName());
        return;
    L8:
        return;
    }

    @Override // ib.a0
    public void p0(DownloadInfo r10, BaseException r11) {
        if (lb.a.a() == false) goto L11;
        if (r10 == null) goto L12;
        String r12 = f9453a;
        int r13 = r10.getId();
        Object[] r14 = new Object[2];
        r14[0] = r10.getName();
        if (r11 == null) goto L8;
        String r15 = r11.getErrorMessage();
    L9:
        r14[1] = r15;
        lb.a.g(r12, r13, "onFailed", String.format("Name: %s because of : %s", r14));
        return;
    L8:
        r15 = "unkown";
        goto L9
    L12:
        return;
    }

    @Override // ib.a0
    public void q0(DownloadInfo r10) {
        if (lb.a.a() == false) goto L7;
        if (r10 == null) goto L8;
        lb.a.g(f9453a, r10.getId(), "onCanceled", "Name: " + r10.getName());
        return;
    L8:
        return;
    }

    @Override // ib.a0
    public void r0(DownloadInfo r10) {
        if (lb.a.a() == false) goto L7;
        if (r10 == null) goto L8;
        lb.a.g(f9453a, r10.getId(), "onPrepare", "Name: " + r10.getName());
        return;
    L8:
        return;
    }
}
