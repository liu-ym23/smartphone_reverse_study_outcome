package lc4;

import android.text.TextUtils;
import com.bytedance.bmf_mods_lite_api.exception.BmfException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public final Map<String, String> a;
    public String b;
    public int[] c;
    public int d;

    /* JADX INFO: renamed from: lc4.a$a, reason: collision with other inner class name */
    public static class C0244a {
        public final Map<String, String> a;
        public String b;
        public int[] c;
        public int d;

        public final a a() throws BmfException {
            if (((HashMap) this.a).containsKey("host") == false) goto L25;
            if (((HashMap) this.a).containsKey("accessKey") == false) goto L25;
            if (TextUtils.isEmpty((CharSequence) ((HashMap) this.a).get("host")) == true) goto L25;
            if (TextUtils.isEmpty((CharSequence) ((HashMap) this.a).get("accessKey")) == true) goto L25;
            int[] r0 = this.c;
            if (r0 == null) goto L23;
            if (r0.length == 0) goto L23;
            String r1 = this.b;
            if (r1 == null) goto L21;
            if (r1.isEmpty() == true) goto L21;
            a r2 = new a(this.a);
            r2.b = this.b;
            r2.c = this.c;
            r2.d = this.d;
            return r2;
        L21:
            throw new BmfException(BmfException.INPUT_PARAM_INVALID, "modelNamePrefix is null");
        L23:
            throw new BmfException(BmfException.INPUT_PARAM_INVALID, "groupIds is null");
        L25:
            throw new BmfException(BmfException.INPUT_PARAM_INVALID, "host or accessKey is null");
        }

        public C0244a() {
            this.a = new HashMap();
            this.b = "";
            this.d = 1;
        }
    }

    public final String toString() {
        return "{ modelNamePrefix: " + this.b + ", groupIds: " + Arrays.toString(this.c) + ", downsample: " + this.d + ", host: " + this.a.get("host") + ", accessKey: " + this.a.get("accessKey") + ", deviceId: " + this.a.get("deviceId") + ", appVersion: " + this.a.get("appVersion") + ", appID: " + this.a.get("appID") + ", platformSdkVersion: " + this.a.get("platformSdkVersion") + " }";
    }

    public a(Map r2) {
        this.b = "";
        this.d = 1;
        this.a = r2;
    }
}
