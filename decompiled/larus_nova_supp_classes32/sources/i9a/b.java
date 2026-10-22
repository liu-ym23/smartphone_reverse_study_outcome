package i9a;

import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class b {
    public final long a;
    public final boolean b;
    public final String c;
    public int d;
    public String e;
    public final long f;
    public final HashMap<String, String> g;

    public final String toString() {
        return "UploadInfo{lastUploadTime=" + this.a + ", isUploading=" + this.b + ", commandId='" + this.c + "', cloudMsgResponseCode=" + this.d + ", errorMsg='" + this.e + "', operateTime=" + this.f + ", specificParams=" + this.g + '}';
    }

    public b(String r4, HashMap r5) {
        this.d = 2;
        this.e = "no error";
        this.f = 0;
        this.g = null;
        this.a = 0;
        this.b = false;
        this.c = r4;
        this.f = System.currentTimeMillis();
        this.g = r5;
    }
}
