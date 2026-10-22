package o09;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class b implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ b(String r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        String r0 = this.a;
        String r1 = this.b;
        String r2 = this.c;
        Pair r3 = c.a(r0);
        String r4 = null;
        Uri r5 = UriProtector.parse(r1);     // Catch: Exception -> L21
        String r6 = r5.getHost();     // Catch: Exception -> L21
        if (r6 == null) goto L11;
        String r7 = r5.getPath();     // Catch: Exception -> L21
        if (r7 != null) goto L9;
        r7 = "/";
    L9:
        Pair r8 = new Pair(r6, r7);     // Catch: Exception -> L21
    L12:
        JSONObject r9 = new JSONObject();
        r9.put("scene", r2);
        if (r8 == null) goto L15;
        String r10 = (String) r8.getFirst();
    L16:
        r9.put("host", r10);
        if (r8 == null) goto L19;
        r4 = (String) r8.getSecond();
    L19:
        r9.put("path", r4);
        FLogger.a.e("TTNet_encrypt", "onTTNetEncryptSuccess = " + r8 + ", encryptResult = " + r3);
        return r9;
    L15:
        r10 = null;
    L11:
        r8 = null;
        goto L12
    }
}
