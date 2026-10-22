package o1;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.bdinstall.INetworkClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e implements INetworkClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k1.a f11375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.applog.c f11376b;

    public e(com.bytedance.applog.c r10) {
        this.f11376b = r10;
        this.f11375a = r10.r();
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String get(String r10, Map<String, String> r11) {
        return this.f11375a.h(0, r10, (HashMap) r11, null);
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r10, List<Pair<String, String>> r11) {
        JSONObject r12 = new JSONObject();
        if (r11 == null) goto L12;
        Iterator<Pair<String, String>> r13 = r11.iterator();     // Catch: Throwable -> L9
    L6:
        if (r13.hasNext() == false) goto L12;
        Pair<String, String> r14 = r13.next();     // Catch: Throwable -> L9
        r12.put((String) r14.first, r14.second);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        this.f11376b.P().v(11, "post parse params to json failed", th, new Object[0]);
    L12:
        return post(r10, r12.toString().getBytes(), NetConst.CONTENT_TYPE);
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r10, byte[] r11, String r12) {
        HashMap r13 = new HashMap();
        if (TextUtils.isEmpty(r12) == true) goto L6;
        r13.put(NetConst.KEY_CONTENT_TYPE, r12);
    L6:
        return post(r10, r11, r13);
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r10, byte[] r11, Map<String, String> r12) {
        return this.f11375a.h(1, r10, (HashMap) r12, r11);
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public byte[] postStream(String r10, byte[] r11, Map<String, String> r12) {
        return this.f11375a.j(1, r10, (HashMap) r12, r11);
    }
}
