package w0;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.bdinstall.INetworkClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import o1.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements INetworkClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.c f13213a;

    public a(com.bytedance.applog.c r10) {
        this.f13213a = r10;
    }

    private String a(String r10, Map<String, String> r11) {
        String r12 = UUID.randomUUID().toString();
        this.f13213a.r().m(r10, r12, null, 0, r11);
        return r12;
    }

    private String b(String r10, JSONObject r11, Map<String, String> r12) {
        String r13 = UUID.randomUUID().toString();
        this.f13213a.r().m(r10, r13, r11, 1, r12);
        return r13;
    }

    private String c(String r10, byte[] r11, Map<String, String> r12) {
        String r13 = UUID.randomUUID().toString();
        JSONObject r14 = new JSONObject(new String(r11));     // Catch: Throwable -> L5
    L6:
        this.f13213a.r().m(r10, r13, r14, 1, r12);
        return r13;
    L5:
        r14 = null;
        goto L6
    }

    private void d(String r10, String r11) {
        if (p.m(r11) == true) goto L9;
        this.f13213a.r().l(r10, -1, null, "BDInstall get response empty");
        return;
    L9:
        this.f13213a.r().l(r10, 200, r11.getBytes("UTF-8"), null);     // Catch: Throwable -> L8
        return;
    }

    private Map<String, String> e(String r10, Map<String, String> r11) {
        return r11;
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String get(String r10, Map<String, String> r11) {
        Map<String, String> r12 = e(r10, r11);
        String r13 = a(r10, r12);
        String r14 = this.f13213a.S().get(r10, r12);
        d(r13, r14);
        return r14;
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r10, List<Pair<String, String>> r11) {
        JSONObject r12 = new JSONObject();
        if (r11 == null) goto L8;
        Iterator<Pair<String, String>> r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L8;
        Pair<String, String> r14 = r13.next();
        r12.put((String) r14.first, r14.second);
    L8:
        HashMap r15 = new HashMap(2);
        r15.put(NetConst.KEY_CONTENT_TYPE, NetConst.CONTENT_TYPE);
        String r16 = b(r10, r12, r15);
        String r17 = this.f13213a.S().post(r10, r11);
        d(r16, r17);
        return r17;
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r10, byte[] r11, String r12) {
        HashMap r13 = new HashMap(2);
        if (TextUtils.isEmpty(r12) == true) goto L5;
        r13.put(NetConst.KEY_CONTENT_TYPE, r12);
    L5:
        String r14 = c(r10, r11, r13);
        String r15 = this.f13213a.S().post(r10, r11, r12);
        d(r14, r15);
        return r15;
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r10, byte[] r11, Map<String, String> r12) {
        Map<String, String> r13 = e(r10, r12);
        String r14 = c(r10, r11, r13);
        String r15 = this.f13213a.S().post(r10, r11, r13);
        d(r14, r15);
        return r15;
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public byte[] postStream(String r10, byte[] r11, Map<String, String> r12) {
        Map<String, String> r13 = e(r10, r12);
        String r14 = c(r10, r11, r13);
        byte[] r15 = this.f13213a.S().postStream(r10, r11, r13);
        if (r15 == null) goto L5;
        String r16 = new String(r15);
    L6:
        d(r14, r16);
        return r15;
    L5:
        r16 = "";
        goto L6
    }
}
