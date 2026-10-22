package w6;

import androidx.annotation.NonNull;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected long f13405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f13406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    protected String f13407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f13408d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f13409e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected long f13410f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected HashMap<String, String> f13411g;

    public b(long r10, boolean r11, String r12, HashMap<String, String> r13) {
        this.f13408d = 2;
        this.f13409e = "no error";
        this.f13410f = 0;
        this.f13411g = null;
        this.f13405a = r10;
        this.f13406b = r11;
        this.f13407c = r12;
        this.f13410f = System.currentTimeMillis();
        this.f13411g = r13;
    }

    public int a() {
        return this.f13408d;
    }

    @NonNull
    public String b() {
        return this.f13407c;
    }

    public String c() {
        return this.f13409e;
    }

    public long d() {
        return this.f13405a;
    }

    public long e() {
        return this.f13410f;
    }

    public HashMap<String, String> f() {
        return this.f13411g;
    }

    public boolean g() {
        return this.f13406b;
    }

    public void h(int r10) {
        this.f13408d = r10;
    }

    public void i(String r10) {
        this.f13409e = r10;
    }

    public String toString() {
        return "UploadInfo{lastUploadTime=" + this.f13405a + ", isUploading=" + this.f13406b + ", commandId='" + this.f13407c + "', cloudMsgResponseCode=" + this.f13408d + ", errorMsg='" + this.f13409e + "', operateTime=" + this.f13410f + ", specificParams=" + this.f13411g + '}';
    }
}
