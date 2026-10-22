package d3;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class b extends c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f8449l = "b";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<String> f8450i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f8451j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f8452k;

    static {
    }

    public b(int r10) {
        super(r10);
        this.f8450i = new ArrayList();
        this.f8451j = false;
        this.f8452k = false;
    }

    private static String o(List<Pair<String, List<String>>> r10) {
        StringBuilder r11 = new StringBuilder();
        Iterator<Pair<String, List<String>>> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L17;
        Pair<String, List<String>> r13 = r12.next();
        String r14 = (String) r13.first;
        List r15 = (List) r13.second;
        if (r15 == null) goto L4;
        if (r15.size() <= 0) goto L4;
        Iterator r16 = r15.iterator();
    L11:
        if (r16.hasNext() == false) goto L4;
        String r17 = (String) r16.next();
        if (r11.length() <= 0) goto L15;
        r11.append("&");
    L15:
        r11.append(r14);
        r11.append("=");
        r11.append(r17);
        goto L11
    L17:
        return r11.toString();
    }

    @Override // d3.c
    protected boolean b(n4.c r10, Map<String, List<String>> r11) {
        boolean r12 = false;
        if (this.f8451j == false) goto L5;
    L48:
        return r12;
    L5:
        if (h(r10) == false) goto L48;
        if (this.f8452k == false) goto L11;
        r10.Q(true);
        r12 = true;
    L11:
        if (r11.isEmpty() == false) goto L14;
        return r12;
    L14:
        if (this.f8450i.isEmpty() == true) goto L48;
        if (r11.containsKey("x-tt-encrypt-queries") == true) goto L48;
        LinkedList r13 = new LinkedList();
        Iterator<String> r14 = this.f8450i.iterator();
    L20:
        if (r14.hasNext() == false) goto L25;
        String r15 = r14.next();
        if (r11.containsKey(r15) == false) goto L20;
        r13.add(new Pair(r15, r11.get(r15)));
        goto L20
    L25:
        if (r13.isEmpty() == false) goto L27;
        return r12;
    L27:
        String r16 = o(r13);
        if (TextUtils.isEmpty(r16) == false) goto L30;
        return r12;
    L30:
        byte[] r17 = null;
        r17 = r16.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L33
    L35:
        if (r17 != null) goto L37;
        return r12;
    L37:
        byte[] r18 = EncryptorUtil.a(r17, r17.length);
        if (r18 != null) goto L40;
        return r12;
    L40:
        String r19 = Base64.encodeToString(r18, 2);
        if (Logger.debug() == false) goto L43;
        Logger.d(f8449l, "encryptBytes:" + r18 + " , encryptString:" + r19);
    L43:
        LinkedList r20 = new LinkedList();
        r20.add(r19);
        r10.T(true);
        r11.put("x-tt-encrypt-queries", r20);
        Iterator<String> r21 = this.f8450i.iterator();
    L45:
        if (r21.hasNext() == false) goto L47;
        r11.remove(r21.next());
        goto L45
    L47:
        return true;
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L35
    }

    @Override // d3.c
    protected void i(JSONObject r10) {
        j(r10);
        d.i(r10.optJSONArray("encrypt_query_list"), this.f8450i);
        boolean r11 = false;
        if (r10.optInt("encrypt_body_enabled", 0) <= 0) goto L5;
        r11 = true;
    L5:
        this.f8452k = r11;
        if (this.f8450i.isEmpty() == true) goto L8;
        return;
    L8:
        if (this.f8452k == true) goto L12;
        this.f8451j = true;
        return;
    }
}
