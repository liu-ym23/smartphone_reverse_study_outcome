package zv8;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.business.debug.base.register.EntranceGroup;
import com.larus.business.debug.base.register.EntrancePage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k {
    public static final k a = null;
    public static final Keva b = null;
    public static final List<m> c = null;
    public static final List<EntrancePage> d = null;
    public static final Map<EntranceGroup, LinkedList<e>> e = null;
    public static final List<Map<EntranceGroup, LinkedList<e>>> f = null;
    public static String g;
    public static String h;
    public static final Map<EntranceGroup, LinkedList<e>> i = null;
    public static final List<Map<EntranceGroup, LinkedList<e>>> j = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[EntrancePage.values().length];
            r0[EntrancePage.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[EntrancePage.RECENTLY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public k() {
    }

    static {
        a = new k();
        b = Keva.getRepo("debug_entrance_data");
        c = new ArrayList();
        d = CollectionsKt.listOf(new EntrancePage[]{EntrancePage.ALL, EntrancePage.RECENTLY, EntrancePage.FAVORITE});
        e = new EnumMap(EntranceGroup.class);
        f = new ArrayList();
        g = "";
        h = "";
        i = new EnumMap(EntranceGroup.class);
        j = new ArrayList();
    }

    public static List c(EntrancePage r4) {
        Intrinsics.checkNotNullParameter(r4, "tab");
        int r5 = a.a[r4.ordinal()];
        boolean r0 = false;
        if (r5 == 1) goto L29;
        if (r5 == 2) goto L18;
        if (aw8.c.d.length() != 0) goto L9;
        r0 = true;
    L9:
        if (r0 == false) goto L11;
        List<Map<EntranceGroup, LinkedList<e>>> r6 = aw8.c.a;
    L12:
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L14:
        if (r7.hasNext() == false) goto L38;
        r1.add((EntranceGroup) CollectionsKt.first(((Map) r7.next()).keySet()));
        goto L14
    L38:
        return CollectionsKt.toMutableList(r1);
    L11:
        r6 = aw8.c.e;
        goto L12
    L18:
        if (h.length() != 0) goto L20;
        r0 = true;
    L20:
        if (r0 == false) goto L22;
        List<Map<EntranceGroup, LinkedList<e>>> r8 = f;
    L23:
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L25:
        if (r9.hasNext() == false) goto L39;
        r2.add((EntranceGroup) CollectionsKt.first(((Map) r9.next()).keySet()));
        goto L25
    L39:
        return CollectionsKt.toMutableList(r2);
    L22:
        r8 = j;
        goto L23
    L29:
        if (g.length() != 0) goto L31;
        r0 = true;
    L31:
        if (r0 == false) goto L33;
        Map<EntranceGroup, LinkedList<e>> r10 = e;
    L35:
        return CollectionsKt.toMutableList(r10.keySet());
    L33:
        r10 = i;
        goto L35
    }

    @JvmStatic
    public static final void e(e r10) {
        Intrinsics.checkNotNullParameter(r10, "entrance");
        EntranceGroup r1 = r10.b();
        Intrinsics.checkNotNullParameter(r10, "entrance");
        List<Map<EntranceGroup, LinkedList<e>>> r0 = f;
        Object r4 = null;
        if (((ArrayList) r0).size() != 0) goto L5;
    L4:
        boolean r2 = false;
    L16:
        if (r2 == false) goto L18;
        return;
    L18:
        Iterator<T> r3 = r0.iterator();
    L20:
        if (r3.hasNext() == false) goto L33;
        Object r5 = r3.next();
        Iterator r6 = ((Map) r5).keySet().iterator();
    L23:
        if (r6.hasNext() == false) goto L27;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(((EntranceGroup) r7).getDes(), r1.getDes()) == false) goto L23;
    L28:
        if (r7 == null) goto L30;
        boolean r8 = true;
    L31:
        if (r8 == false) goto L20;
        r4 = r5;
        goto L33
    L30:
        r8 = false;
        goto L31
    L27:
        r7 = null;
    L33:
        Map r9 = (Map) r4;
        if (r9 == null) goto L47;
        List r11 = (LinkedList) r9.get(r1);
        if (r11 != null) goto L39;
        r11 = CollectionsKt.emptyList();
    L39:
        LinkedList r12 = new LinkedList();
        r12.add(r10);
        Iterator r13 = r11.iterator();
    L41:
        if (r13.hasNext() == false) goto L46;
        e r14 = (e) r13.next();
        if (Intrinsics.areEqual(r14.c(), r10.c()) == true) goto L41;
        r12.add(r14);
        goto L41
    L46:
        List<Map<EntranceGroup, LinkedList<e>>> r15 = f;
        ((ArrayList) r15).remove(r9);
        LinkedHashMap r16 = new LinkedHashMap();
        r16.put(r1, r12);
        Unit r17 = Unit.INSTANCE;
        ListProtector.add(r15, 0, r16);
    L48:
        JSONArray r18 = new JSONArray();
        Iterator<T> r19 = f.iterator();
    L50:
        if (r19.hasNext() == false) goto L66;
        Map r20 = (Map) r19.next();
        Iterator r21 = r20.keySet().iterator();
    L53:
        if (r21.hasNext() == false) goto L50;
        EntranceGroup r22 = (EntranceGroup) r21.next();
        JSONArray r23 = new JSONArray();
        LinkedList r24 = (LinkedList) r20.get(r22);
        if (r24 == null) goto L60;
        Collection r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));
        Iterator r26 = r24.iterator();
    L58:
        if (r26.hasNext() == false) goto L61;
        r25.add(((e) r26.next()).c());
    L61:
        Iterator r27 = r25.iterator();
    L63:
        if (r27.hasNext() == false) goto L65;
        r23.put((String) r27.next());
        goto L63
    L65:
        JSONObject r28 = new JSONObject();
        r28.put(r22.getDes(), r23);
        r18.put(r28);
        goto L53
    L60:
        r25 = CollectionsKt.emptyList();
        goto L61
    L66:
        b.storeString("KEVA_KEY_RECENTLY_USED_ENTRANCE", r18.toString());
        Iterator<T> r110 = c.iterator();
    L68:
        if (r110.hasNext() == false) goto L70;
        ((m) r110.next()).b();
        goto L68
    L70:
        return;
    L47:
        List<Map<EntranceGroup, LinkedList<e>>> r29 = f;
        LinkedHashMap r30 = new LinkedHashMap();
        LinkedList r31 = new LinkedList();
        r31.add(r10);
        Unit r111 = Unit.INSTANCE;
        r30.put(r1, r31);
        ListProtector.add(r29, 0, r30);
        goto L48
    L5:
        Map r32 = (Map) ListProtector.get(r0, 0);
        if (r32.isEmpty() == true) goto L4;
        LinkedList r33 = (LinkedList) r32.get((EntranceGroup) ListProtector.get(CollectionsKt.toList(r32.keySet()), 0));
        if (r33 == null) goto L4;
        if ((!r33.isEmpty()) == true) goto L14;
        r33 = null;
    L14:
        if (r33 == null) goto L4;
        r2 = Intrinsics.areEqual(((e) r33.get(0)).toString(), r10.toString());
        goto L16
    }

    public static Map b(String r20, Map r21) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r20.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return r0;
    L8:
        Iterator r2 = r21.keySet().iterator();
    L10:
        if (r2.hasNext() == false) goto L22;
        EntranceGroup r4 = (EntranceGroup) r2.next();
        LinkedList r5 = new LinkedList();
        LinkedList r7 = (LinkedList) r21.get(r4);
        if (r7 == null) goto L20;
        Iterator r8 = r7.iterator();
    L15:
        if (r8.hasNext() == false) goto L20;
        e r9 = (e) r8.next();
        r9.getClass();
        if (StringsKt.contains$default((r9.b().getDes() + r9.c() + CollectionsKt.joinToString$default(r9.e(), null, null, null, 0, null, null, 63, null)).toLowerCase(Locale.getDefault()), r20.toLowerCase(Locale.getDefault()), false, 2, null) == false) goto L15;
        r5.add(r9);
    L20:
        if ((!r5.isEmpty()) == false) goto L10;
        r0.put(r4, r5);
        goto L10
    L22:
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    public static Pair a(String r16, List r17, List r18) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r17.iterator();
    L3:
        Map r5 = null;
        if (r2.hasNext() == false) goto L11;
        Map r3 = (Map) r2.next();
        a.getClass();
        Map r4 = b(r16, r3);
        if ((true ^ r4.isEmpty()) == false) goto L8;
        r5 = r4;
    L8:
        if (r5 == null) goto L3;
        r1.add(r5);
        goto L3
    L11:
        if (r1.isEmpty() == true) goto L13;
        ArrayList r6 = (ArrayList) r18;
        if (r1.size() == r6.size()) goto L17;
        boolean r7 = true;
    L18:
        Iterator r8 = r1.iterator();
    L20:
        if (r8.hasNext() == false) goto L63;
        Map r9 = (Map) r8.next();
        Iterator r10 = r9.keySet().iterator();
    L23:
        if (r10.hasNext() == false) goto L20;
        EntranceGroup r11 = (EntranceGroup) r10.next();
        Iterator r12 = r6.iterator();
    L26:
        if (r12.hasNext() == false) goto L41;
        Object r13 = r12.next();
        Iterator r14 = ((Map) r13).keySet().iterator();
    L29:
        if (r14.hasNext() == false) goto L34;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((EntranceGroup) r15).getDes(), r11.getDes()) == false) goto L29;
    L35:
        if (r15 == null) goto L37;
        boolean r19 = true;
    L38:
        if (r19 == false) goto L26;
    L42:
        Map r110 = (Map) r13;
        if (r110 == null) goto L61;
        List r20 = (LinkedList) r9.get(r11);
        if (r20 != null) goto L48;
        r20 = CollectionsKt.emptyList();
    L48:
        List r111 = (LinkedList) r110.get(r11);
        if (r111 != null) goto L53;
        r111 = CollectionsKt.emptyList();
    L53:
        if (r20.size() != r111.size()) goto L61;
        int r112 = r20.size();
        int r113 = 0;
    L56:
        if (r113 >= r112) goto L23;
        if (Intrinsics.areEqual(((e) ListProtector.get(r20, r113)).toString(), ((e) ListProtector.get(r111, r113)).toString()) == false) goto L61;
        r113 = r113 + 1;
    L61:
        r7 = true;
        goto L23
    L37:
        r19 = false;
        goto L38
    L34:
        r15 = null;
        goto L35
    L41:
        r13 = null;
        goto L42
    L63:
        if (r7 == false) goto L66;
        r0.clear();
        r0.addAll(r1);
    L66:
        return TuplesKt.to(r0, Boolean.valueOf(r7));
    L17:
        r7 = false;
        goto L18
    L13:
        return TuplesKt.to(r0, Boolean.TRUE);
    }

    public static List d(EntrancePage r7, EntranceGroup r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "tab");
        Intrinsics.checkNotNullParameter(r8, "group");
        int r10 = a.a[r7.ordinal()];
        boolean r0 = false;
        if (r10 == 1) goto L65;
        Object r3 = null;
        if (r10 == 2) goto L35;
        if (aw8.c.d.length() != 0) goto L9;
        boolean r11 = true;
    L10:
        if (r11 == false) goto L12;
        List<Map<EntranceGroup, LinkedList<e>>> r12 = aw8.c.a;
    L13:
        Iterator<T> r13 = r12.iterator();
    L15:
        if (r13.hasNext() == false) goto L28;
        Object r14 = r13.next();
        Iterator r2 = ((Map) r14).keySet().iterator();
    L18:
        if (r2.hasNext() == false) goto L22;
        Object r4 = r2.next();
        if (Intrinsics.areEqual(((EntranceGroup) r4).getDes(), r8.getDes()) == false) goto L18;
    L23:
        if (r4 == null) goto L25;
        boolean r5 = true;
    L26:
        if (r5 == false) goto L15;
        r3 = r14;
        goto L28
    L25:
        r5 = false;
        goto L26
    L22:
        r4 = null;
    L28:
        Map r6 = (Map) r3;
        if (r6 == null) goto L93;
        LinkedList r15 = (LinkedList) r6.get(r8);
        if (r15 == null) goto L93;
        return r15;
    L93:
        return CollectionsKt.emptyList();
    L12:
        r12 = aw8.c.e;
        goto L13
    L9:
        r11 = false;
        goto L10
    L35:
        if (h.length() != 0) goto L37;
        boolean r16 = true;
    L38:
        if (r16 == true) goto L42;
        if (r9 == true) goto L42;
        List<Map<EntranceGroup, LinkedList<e>>> r17 = j;
    L43:
        Iterator<T> r18 = r17.iterator();
    L45:
        if (r18.hasNext() == false) goto L58;
        Object r19 = r18.next();
        Iterator r20 = ((Map) r19).keySet().iterator();
    L48:
        if (r20.hasNext() == false) goto L52;
        Object r21 = r20.next();
        if (Intrinsics.areEqual(((EntranceGroup) r21).getDes(), r8.getDes()) == false) goto L48;
    L53:
        if (r21 == null) goto L55;
        boolean r22 = true;
    L56:
        if (r22 == false) goto L45;
        r3 = r19;
        goto L58
    L55:
        r22 = false;
        goto L56
    L52:
        r21 = null;
    L58:
        Map r23 = (Map) r3;
        if (r23 == null) goto L94;
        LinkedList r24 = (LinkedList) r23.get(r8);
        if (r24 == null) goto L94;
        return r24;
    L94:
        return CollectionsKt.emptyList();
    L42:
        r17 = f;
        goto L43
    L37:
        r16 = false;
        goto L38
    L65:
        if (g.length() != 0) goto L67;
        r0 = true;
    L67:
        if (r0 == true) goto L71;
        if (r9 == true) goto L71;
        Map<EntranceGroup, LinkedList<e>> r25 = i;
    L72:
        LinkedList<e> r26 = r25.get(r8);
        if (r26 == null) goto L76;
        return r26;
    L76:
        return CollectionsKt.emptyList();
    L71:
        r25 = e;
        goto L72
    }
}
