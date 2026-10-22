package li;

import com.bytedance.sdk.xbridge.cn.auth.bean.RequestCheckAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RequestCheckAction f19672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f19673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f19674c;

    public m(Map r11) {
        this.f19672a = RequestCheckAction.f7334b;
        this.f19673b = new HashMap();
        this.f19674c = new HashMap();
        Object r5 = r11.get("action");
        Map r10 = null;
        if ((r5 instanceof Double) == false) goto L5;
        Double r12 = (Double) r5;
    L6:
        if (r12 == null) goto L8;
        double r13 = r12.doubleValue();
    L9:
        RequestCheckAction[] r14 = RequestCheckAction.values();
        int r15 = r14.length;
        int r16 = 0;
    L10:
        if (r16 >= r15) goto L15;
        RequestCheckAction r17 = r14[r16];
        if (r17.f7336a == ((int) r13)) goto L16;
        r16 = r16 + 1;
    L16:
        if (r17 == null) goto L18;
        this.f19672a = r17;
    L18:
        Map r18 = pi.a.e;
        if (r18 != null) goto L21;
        r18 = new HashMap();
    L21:
        Object r19 = r11.get("settings");
        if ((r19 instanceof Map) == false) goto L24;
        r10 = (Map) r19;
    L24:
        if (r10 == null) goto L44;
        Iterator r110 = r10.entrySet().iterator();
    L27:
        if (r110.hasNext() == false) goto L60;
        Map.Entry r20 = (Map.Entry) r110.next();
        Object r21 = r20.getKey();
        Object r22 = r20.getValue();
        if ((r21 instanceof String) == false) goto L27;
        ArrayList r23 = new ArrayList();
        ArrayList r24 = new ArrayList();
        if ((r22 instanceof String) == true) goto L33;
        if ((r22 instanceof List) == false) goto L27;
        Iterator r25 = ((List) r22).iterator();
    L38:
        if (r25.hasNext() == false) goto L43;
        Object r26 = r25.next();
        if ((r26 instanceof String) == false) goto L38;
        String r27 = (String) r26;
        r23.addAll(a(r27, r18, true));
        r24.addAll(a(r27, r18, false));
    L43:
        this.f19673b.put(r21, r23);
        this.f19674c.put(r21, r24);
        goto L27
    L33:
        String r28 = (String) r22;
        r23.addAll(a(r28, r18, true));
        r24.addAll(a(r28, r18, false));
        goto L43
    L60:
        return;
    L44:
        return;
    L15:
        r17 = null;
        goto L16
    L8:
        r13 = 0.0d;
        goto L9
    L5:
        r12 = null;
        goto L6
    }

    public static List a(String r5, Map r10, boolean r11) {
        if (r10.isEmpty() == true) goto L46;
        if (r5.length() == 0) goto L46;
        Object r12 = r10.get(r5);
        List r13 = null;
        if ((r12 instanceof Map) == false) goto L10;
        Map r14 = (Map) r12;
    L11:
        if (r14 == null) goto L44;
        if (r11 == false) goto L14;
        String r15 = "match_reg";
    L15:
        Object r16 = r14.get(r15);
        if ((r16 instanceof String) == false) goto L18;
        String r17 = (String) r16;
    L19:
        if (r17 != null) goto L21;
        Object r18 = r14.get(r15);
        if ((r18 instanceof List) == false) goto L29;
        r13 = (List) r18;
    L29:
        if (r13 == null) goto L44;
        ArrayList r19 = new ArrayList();
        Iterator r20 = r13.iterator();
    L32:
        if (r20.hasNext() == false) goto L36;
        Object r21 = r20.next();
        if ((r21 instanceof String) == false) goto L32;
        r19.add(r21);
        goto L32
    L36:
        ArrayList r22 = new ArrayList();
        Iterator r23 = r19.iterator();
    L38:
        if (r23.hasNext() == false) goto L42;
        Object r24 = r23.next();
        if (((String) r24).length() <= 0) goto L38;
        r22.add(r24);
        goto L38
    L42:
        return r22;
    L21:
        if (r17.length() <= 0) goto L25;
        return CollectionsKt.listOf(r17);
    L25:
        return CollectionsKt.emptyList();
    L18:
        r17 = null;
        goto L19
    L14:
        r15 = "exclude_reg";
    L44:
        return CollectionsKt.emptyList();
    L10:
        r14 = null;
    L46:
        return CollectionsKt.emptyList();
    }
}
