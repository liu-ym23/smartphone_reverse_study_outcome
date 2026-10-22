package o4;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f9648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, List<Set<String>>> f9649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, List<Map<String, Object>>> f9650d;

    public a(int r8, HashSet r10, HashMap r11, HashMap r12) {
        this.f9647a = r8;
        this.f9648b = r10;
        this.f9649c = r11;
        this.f9650d = r12;
    }

    public final int a() {
        int r8 = this.f9647a;
        if (r8 > 0) goto L7;
        return -1;
    L7:
        if (r8 < 10000) goto L10;
        return 1;
    L10:
        return 0;
    }

    public final boolean b(String r8, JSONObject r10) {
        Map<String, List<Set<String>>> r11 = this.f9649c;
        if (r11 != null) goto L5;
    L26:
        Map<String, List<Map<String, Object>>> r12 = this.f9650d;
        if (r12 != null) goto L29;
    L61:
        return false;
    L29:
        if (r12.containsKey(r8) == false) goto L61;
        List<Map<String, Object>> r13 = r12.get(r8);
        if (r13 == null) goto L61;
        if (r13.isEmpty() == true) goto L61;
        Iterator<Map<String, Object>> r14 = r13.iterator();
    L36:
        if (r14.hasNext() == false) goto L61;
        Map<String, Object> r15 = r14.next();
        if (r15 == null) goto L36;
        if (r15.isEmpty() == true) goto L36;
        Iterator<String> r16 = r15.keySet().iterator();
    L43:
        if (r16.hasNext() == false) goto L47;
        if (r10.has(r16.next()) == true) goto L43;
        boolean r17 = false;
    L48:
        if (r17 == false) goto L36;
        Iterator<Map.Entry<String, Object>> r18 = r15.entrySet().iterator();
    L51:
        if (r18.hasNext() == false) goto L58;
        Map.Entry<String, Object> r19 = r18.next();
        String r20 = r19.getKey();
        Object r21 = r19.getValue();
        if (TextUtils.isEmpty(r20) == true) goto L57;
        if (r21 == null) goto L57;
        if (r21.equals(r10.opt(r20)) == true) goto L51;
    L57:
        boolean r22 = false;
    L59:
        if (r22 == false) goto L36;
        return true;
    L58:
        r22 = true;
        goto L59
    L47:
        r17 = true;
        goto L48
    L5:
        if (r11.containsKey(r8) == false) goto L26;
        List<Set<String>> r23 = r11.get(r8);
        if (r23 == null) goto L26;
        if (r23.isEmpty() == true) goto L26;
        Iterator<Set<String>> r24 = r23.iterator();
    L12:
        if (r24.hasNext() == false) goto L26;
        Set<String> r25 = r24.next();
        if (r25 == null) goto L12;
        if (r25.isEmpty() == true) goto L12;
        Iterator<String> r26 = r25.iterator();
    L19:
        if (r26.hasNext() == false) goto L23;
        if (r10.has(r26.next()) == true) goto L19;
        boolean r27 = false;
    L24:
        if (r27 == false) goto L12;
        return true;
    L23:
        r27 = true;
        goto L24
    }

    public abstract boolean c(b r8);
}
