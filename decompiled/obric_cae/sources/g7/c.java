package g7;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f7713n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f7714o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f7715p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final HashMap f7716q;

    public c() {
        this.f7713n = 0;
        this.f7714o = 0;
        this.f7715p = 0;
        this.f7716q = new HashMap();
    }

    @Override // g7.a
    public final boolean b(long r8, String r10, JSONObject r11) {
        e(r11);
        String r12 = r11.optString(LocationMonitorConst.TAG);
        boolean r13 = TextUtils.isEmpty(r12);
        HashMap r14 = this.f7716q;
        int r15 = 0;
        if (r13 == true) goto L17;
        String[] r16 = r12.split(";");
        int r17 = r16.length;
        int r18 = 0;
    L5:
        if (r18 >= r17) goto L17;
        String r19 = r16[r18];
        ArrayList r20 = new ArrayList();
        if (t2.b.W(r19, ",", r20) == false) goto L16;
        Iterator r21 = r20.iterator();
    L11:
        if (r21.hasNext() == false) goto L16;
        Pair r22 = (Pair) r21.next();
        Set r23 = (Set) r14.get(r22.first);
        if (r23 != null) goto L15;
        r23 = new HashSet();
    L15:
        r23.add(r22.second);
        r14.put(r22.first, r23);
    L16:
        r18 = r18 + 1;
    L17:
        this.f7713n = r11.optInt("delay");
        JSONArray r24 = r11.optJSONArray("random");
        if (this.f7713n > 0) goto L37;
        if (r24 == null) goto L37;
        if (r24.length() == 2) goto L42;
        return false;
    L42:
        int r25 = r24.getInt(0);     // Catch: JSONException -> L28
        int r26 = r24.getInt(1);     // Catch: JSONException -> L26
    L31:
        if (r25 <= 0) goto L36;
        if (r26 <= 0) goto L36;
        if (r25 >= r26) goto L36;
        r15 = r25;
    L38:
        this.f7714o = r15;
        this.f7715p = r26;
        if (Logger.debug() == false) goto L41;
        Logger.d("c", "initwithparam tnc tag map is " + r14);
    L41:
        return true;
    L36:
        return false;
    L26:
        e = e;
    L30:
        e.printStackTrace();
        r26 = 0;
    L28:
        e = e;
        r25 = 0;
    L37:
        r26 = 0;
        goto L38
    }

    public final int g() {
        int r8 = this.f7713n;
        if (r8 <= 0) goto L6;
        return r8;
    L6:
        if (this.f7714o < this.f7715p) goto L8;
        return 0;
    L8:
        return new Random().nextInt(this.f7715p - this.f7714o) + this.f7714o;
    }
}
