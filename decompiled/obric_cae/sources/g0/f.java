package g0;

import android.util.Base64;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<List<byte[]>> f7508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f7509e;

    public f(String r8, String r10, String r11, List<List<byte[]>> r12) {
        r8.getClass();
        this.f7505a = r8;
        r10.getClass();
        this.f7506b = r10;
        this.f7507c = r11;
        r12.getClass();
        this.f7508d = r12;
        this.f7509e = r8 + "-" + r10 + "-" + r11;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        r8.append("FontRequest {mProviderAuthority: " + this.f7505a + ", mProviderPackage: " + this.f7506b + ", mQuery: " + this.f7507c + ", mCertificates:");
        int r10 = 0;
    L3:
        List<List<byte[]>> r11 = this.f7508d;
        if (r10 >= r11.size()) goto L10;
        r8.append(" [");
        List<byte[]> r12 = r11.get(r10);
        int r13 = 0;
    L7:
        if (r13 >= r12.size()) goto L9;
        r8.append(" \"");
        r8.append(Base64.encodeToString(r12.get(r13), 0));
        r8.append("\"");
        r13 = r13 + 1;
        goto L7
    L9:
        r8.append(" ]");
        r10 = r10 + 1;
        goto L3
    L10:
        r8.append("}mCertificatesArray: 0");
        return r8.toString();
    }
}
