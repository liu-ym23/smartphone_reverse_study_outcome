package v80;

import com.bytedance.android.livehostapi.business.depend.ILiveFaceCertCallback;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c extends h {
    public ILiveFaceCertCallback b;
    public final HashMap<String, String> c;
    public boolean d;
    public final HashMap<String, String> e;

    public c() {
        this.c = new HashMap();
        new JSONObject();
        this.e = new HashMap();
    }

    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.e.put(r2, r3);
    }
}
