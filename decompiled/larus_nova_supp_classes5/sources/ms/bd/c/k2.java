package ms.bd.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k2 implements m2 {
    public final long a;
    public final Context b;
    public final c2 c;

    @Override // ms.bd.c.m2
    public final String getToken() {
        long r2 = this.a;
        if (r2 != (-1)) goto L5;
        return "";
    L5:
        return (String) p2.a(33554439, 0, r2, null, null);
    }

    public static String a(Map r3) {
        if (r3 != null) goto L4;
    L14:
        return "";
    L4:
        if (r3.isEmpty() == true) goto L14;
        JSONArray r0 = new JSONArray();
        Iterator r4 = r3.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L23;
        Map.Entry r1 = (Map.Entry) r4.next();
        if (TextUtils.isEmpty((CharSequence) r1.getKey()) == true) goto L7;
        if (TextUtils.isEmpty((CharSequence) r1.getValue()) == true) goto L7;
        r0.put(r1.getKey());
        r0.put(r1.getValue());
        goto L7
    L23:
        return r0.toString();
    }

    @Override // ms.bd.c.m2
    public final void postEventMessage(MSManagerUtils.MSBusinessHelper r12) {
        if (this.a == (-1)) goto L6;
        p2.a(33554443, 0, 0, null, r12);
        return;
    }

    @Override // ms.bd.c.m2
    public final void setBDDeviceID(String r8) {
        this.c.mBDDeviceID = r8;
        long r3 = this.a;
        if (r3 == (-1)) goto L6;
        p2.a(33554437, 0, r3, r8, this.b);
        return;
    }

    @Override // ms.bd.c.m2
    public final void setCollectMode(int r7) {
        long r2 = this.a;
        if (r2 == (-1)) goto L6;
        p2.a(33554441, r7, r2, null, null);
        return;
    }

    @Override // ms.bd.c.m2
    public final void setDeviceID(String r8) {
        this.c.mDeviceID = r8;
        long r3 = this.a;
        if (r3 == (-1)) goto L6;
        p2.a(33554434, 0, r3, r8, this.b);
        return;
    }

    @Override // ms.bd.c.m2
    public final void setInstallID(String r8) {
        this.c.mInstallID = r8;
        long r3 = this.a;
        if (r3 == (-1)) goto L6;
        p2.a(33554435, 0, r3, r8, this.b);
        return;
    }

    @Override // ms.bd.c.m2
    public final void setMsSettingConfig(String r7) {
        if (this.a == (-1)) goto L14;
        if (TextUtils.isEmpty(r7) == false) goto L7;
        return;
    L7:
        if (r7.contains("content") == false) goto L9;
        r7 = JSONObjectProtectorUtils.getString(new JSONObject(r7), "content");     // Catch: Exception -> L11
    L9:
        long r2 = this.a;     // Catch: Exception -> L11
        p2.a(33554447, 0, r2, r7, this.b);     // Catch: Exception -> L11
        return;
    L16:
        return;
    }

    @Override // ms.bd.c.m2
    public final void setSessionID(String r8) {
        this.c.mSessionID = r8;
        long r3 = this.a;
        if (r3 == (-1)) goto L6;
        p2.a(33554436, 0, r3, r8, this.b);
        return;
    }

    @Override // ms.bd.c.m2
    public final Map frameSign(String r8, int r9) {
        if (this.a == (-1)) goto L22;
        HashMap r0 = new HashMap();
        if (TextUtils.isEmpty(r8) == true) goto L7;
        String[] r10 = (String[]) p2.a(33554442, r9, this.a, r8, null);
        if ((r10 instanceof String[]) == true) goto L11;
    L20:
        return r0;
    L11:
        if ((r10.length % 2) != 0) goto L20;
        int r11 = 0;
    L14:
        if (r11 >= r10.length) goto L20;
        String r1 = r10[r11];
        String r2 = r10[r11 + 1];
        if (r1 == null) goto L19;
        if (r2 == null) goto L19;
        r0.put(r1, r2);
    L19:
        r11 = r11 + 2;
        goto L14
    L7:
        return Collections.emptyMap();
    L22:
        return Collections.emptyMap();
    }

    @Override // ms.bd.c.m2
    public final Map getFeatureHash(String r9, byte[] r10) {
        HashMap r0 = new HashMap();
        if (r9 != null) goto L5;
    L19:
        return r0;
    L5:
        if (r9.length() == 0) goto L19;
        String[] r11 = (String[]) p2.a(33554438, 0, this.a, r9, r10);
        if (r11 == null) goto L19;
        if ((r11.length % 2) != 0) goto L19;
        int r12 = 0;
    L13:
        if (r12 >= r11.length) goto L19;
        String r1 = r11[r12];
        String r2 = r11[r12 + 1];
        if (r1 == null) goto L18;
        if (r2 == null) goto L18;
        r0.put(r1, r2);
    L18:
        r12 = r12 + 2;
        goto L13
    }

    @Override // ms.bd.c.m2
    public final void qurryMsRiskInfo(String r9, MSManagerUtils.IMsBundleCallback r10) {
        t2 r0 = t2.b;
        if (r0.a.size() >= 20) goto L6;
        if (r10 == null) goto L6;
        HashMap r1 = new HashMap();
        r1.put(r9, r10);
        r0.a.add(r1);
    L6:
        long r4 = this.a;
        if (r4 == (-1)) goto L10;
        p2.a(33554450, 0, r4, r9, null);
        return;
    }

    @Override // ms.bd.c.m2
    public final void report(String r8, String r9) {
        if (this.a != (-1)) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r8) == true) goto L9;
        p2.a(33554433, 0, this.a, r8, r9);
        return;
    }

    @Override // ms.bd.c.m2
    public final void setCustomInfo(Map r12, boolean r13) {
        if (this.a == (-1)) goto L6;
        String r9 = a(r12);
        long r7 = this.a;
        p2.a(33554448, r13 ? 1 : 0, r7, r9, null);
        return;
    }

    public k2(c2 r1, Context r2, long r3) {
        if (r2 == null) goto L7;
        this.c = r1;
        this.b = r2.getApplicationContext();
        this.a = r3;
        return;
    L7:
        throw new NullPointerException("context could not be null");
    }

    @Override // ms.bd.c.m2
    public final Map getReportRaw(String r12, int r13, Map r14) {
        if (this.a == (-1)) goto L15;
        String r10 = a(r14);
        Object r15 = p2.a(33554440, r13, this.a, r12, r10);
        if ((r15 instanceof Object[]) == false) goto L15;
        Object[] r16 = (Object[]) r15;
        if (r16.length < 2) goto L15;
        if (r16[0] == null) goto L15;
        if (r16[1] == null) goto L15;
        HashMap r0 = new HashMap();
        r0.put(r16[0].toString(), r16[1].toString());
        return r0;
    L15:
        return Collections.emptyMap();
    }
}
