package i1;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f9363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<String> f9364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, List<Set<String>>> f9365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, List<Map<String, Object>>> f9366d;

    a(int r10, Set<String> r11, Map<String, List<Set<String>>> r12, Map<String, List<Map<String, Object>>> r13) {
        this.f9363a = r10;
        this.f9364b = r11;
        this.f9365c = r12;
        this.f9366d = r13;
    }

    private boolean c(String r10, JSONObject r11) {
        HashSet r12 = new HashSet();
        Iterator<String> r13 = r11.keys();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(r13.next());
        goto L4
    L6:
        Map<String, List<Set<String>>> r14 = this.f9365c;
        if (r14 != null) goto L9;
    L24:
        Map<String, List<Map<String, Object>>> r15 = this.f9366d;
        if (r15 != null) goto L27;
    L53:
        return false;
    L27:
        if (r15.containsKey(r10) == false) goto L53;
        List<Map<String, Object>> r16 = this.f9366d.get(r10);
        if (r16 == null) goto L53;
        if (r16.isEmpty() == true) goto L53;
        Iterator<Map<String, Object>> r17 = r16.iterator();
    L34:
        if (r17.hasNext() == false) goto L53;
        Map<String, Object> r18 = r17.next();
        if (r18 == null) goto L34;
        if (r18.isEmpty() == true) goto L34;
        if (r12.containsAll(r18.keySet()) == false) goto L34;
        Iterator<Map.Entry<String, Object>> r19 = r18.entrySet().iterator();
    L43:
        if (r19.hasNext() == false) goto L50;
        Map.Entry<String, Object> r20 = r19.next();
        String r21 = r20.getKey();
        Object r22 = r20.getValue();
        if (TextUtils.isEmpty(r21) == true) goto L49;
        if (r22 == null) goto L49;
        if (r22.equals(r11.opt(r21)) == true) goto L43;
    L49:
        boolean r23 = false;
    L51:
        if (r23 == false) goto L34;
        return true;
    L50:
        r23 = true;
        goto L51
    L9:
        if (r14.containsKey(r10) == false) goto L24;
        List<Set<String>> r24 = this.f9365c.get(r10);
        if (r24 == null) goto L24;
        if (r24.isEmpty() == true) goto L24;
        Iterator<Set<String>> r25 = r24.iterator();
    L16:
        if (r25.hasNext() == false) goto L24;
        Set<String> r26 = r25.next();
        if (r26 == null) goto L16;
        if (r26.isEmpty() == true) goto L16;
        if (r12.containsAll(r26) == false) goto L16;
        return true;
    }

    final int a() {
        int r10 = this.f9363a;
        if (r10 > 0) goto L7;
        return -1;
    L7:
        if (r10 < 10000) goto L10;
        return 1;
    L10:
        return 0;
    }

    final boolean b(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        Set<String> r12 = this.f9364b;
        if (r12 == null) goto L12;
        if (r12.contains(r10) == false) goto L12;
        return true;
    L12:
        if (TextUtils.isEmpty(r11) == false) goto L14;
        return false;
    L14:
        Map<String, List<Set<String>>> r13 = this.f9365c;
        if (r13 != null) goto L17;
    L18:
        Map<String, List<Map<String, Object>>> r14 = this.f9366d;
        if (r14 != null) goto L21;
    L24:
        return false;
    L21:
        if (r14.containsKey(r10) == false) goto L24;
    L26:
        return c(r10, new JSONObject(r11));
    L17:
        if (r13.containsKey(r10) == true) goto L26;
        goto L18
    }

    abstract boolean d(i r10);
}
