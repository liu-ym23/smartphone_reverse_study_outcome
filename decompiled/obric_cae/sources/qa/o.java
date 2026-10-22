package qa;

import com.obric.cae.userAware.datacollection.NetworkClient;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class o extends n4 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final byte[] f10863k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f10864l;

    public o(String r8, byte[] r10) {
        this.f10864l = "1";
        this.f10863k = (byte[]) r10.clone();
        this.f10864l = r8;
        this.f10805i = m0.a.f10810n;
        b(m0.c.f10821a);
    }

    @Override // qa.m0
    public final Map<String, String> a() {
        HashMap r8 = new HashMap();
        r8.put("Content-Type", NetworkClient.UPLOAD_FILE_TYPE_ZIP);
        r8.put("Content-Length", String.valueOf(this.f10863k.length));
        return r8;
    }

    @Override // qa.m0
    public final String c() {
        byte[] r8 = b.f10220a;
        String r10 = t4.n("IaHR0cDovL2xvZ3MuYW1hcC5jb20vd3MvbG9nL3VwbG9hZD9wcm9kdWN0PSVzJnR5cGU9JXMmcGxhdGZvcm09JXMmY2hhbm5lbD0lcyZzaWduPSVz");
        byte[] r11 = t4.i("9aj&#k81");
        byte[] r12 = new byte[r11.length + 50];
        System.arraycopy(this.f10863k, 0, r12, 0, 50);
        System.arraycopy(r11, 0, r12, 50, r11.length);
        String r13 = null;
        MessageDigest r14 = MessageDigest.getInstance(t4.n("ETUQ1"));     // Catch: Throwable -> L5
        r14.update(r12);     // Catch: Throwable -> L5
        byte[] r15 = r14.digest();     // Catch: Throwable -> L5
    L15:
        r13 = t4.r(r15);     // Catch: Throwable -> L9
    L12:
        return String.format(r10, new Object[]{"1", this.f10864l, "1", "open", r13});
    L9:
        th = move-exception;
        l.a("ut", "h2s", th);
    L5:
        th = move-exception;
        l.a("MD5", "gmb", th);
        r15 = null;
        goto L15
    }

    @Override // qa.m0
    public final boolean g() {
        return false;
    }

    @Override // qa.m0
    public final Map<String, String> h() {
        return null;
    }

    @Override // qa.m0
    public final byte[] i() {
        return this.f10863k;
    }
}
