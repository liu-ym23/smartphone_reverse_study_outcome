package gz1;

import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static /* synthetic */ String b(ArrayList r1) {
        return a(r1, 0);
    }

    public static final ArrayList<e3> d(JSONArray r5) {
    L6:
        e = move-exception;
        jy0.b.c(e3.TAG, "convertJsonToArray： " + e.getMessage(), null, 4);
        return new ArrayList();
    L3:
        if (r5.length() == 0) goto L5;
        ArrayList<e3> r0 = new ArrayList();     // Catch: Exception -> L6
        int r1 = r5.length();     // Catch: Exception -> L6
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L15;
        e3 r3 = (e3) f.c(e3.class);     // Catch: Exception -> L6
        Object r4 = r5.get(r2);     // Catch: Exception -> L6
        if (r4 == null) goto L14;
        c(r3, (JSONObject) r4);     // Catch: Exception -> L6
        r0.add(r3);     // Catch: Exception -> L6
        r2 = r2 + 1;     // Catch: Exception -> L6
        goto L9
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.revenue.platform.api.core.JSONObject /* = org.json.JSONObject */");     // Catch: Exception -> L6
    L15:
        return r0;
    L5:
        return new ArrayList();
    }

    public static final JSONObject e(e3 r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$convertToJSON");
        JSONObject r0 = new JSONObject();
        r0.put(e3.KEY_PLUGIN_ID, r5.getPluginId());
        JSONObject r1 = new JSONObject();
        Map<String, String> r2 = r5.getItemPotentialValueHint();
        if (r2 != null) goto L5;
    L19:
        r0.put(e3.KEY_ITEM_POTENTIAL_VALUE_HINT, r1);
        return r0;
    L5:
        if ((!r2.isEmpty()) != true) goto L19;
        Map<String, String> r3 = r5.getItemPotentialValueHint();
        if (r3 == null) goto L19;
        Set<String> r4 = r3.keySet();
        if (r4 == null) goto L19;
        Iterator<T> r6 = r4.iterator();
    L12:
        if (r6.hasNext() == false) goto L19;
        String r7 = (String) r6.next();
        Map<String, String> r8 = r5.getItemPotentialValueHint();
        if (r8 == null) goto L17;
        String r9 = r8.get(r7);
        if (r9 == null) goto L17;
    L18:
        r1.put(r7, r9);
    L17:
        r9 = BuildConfig.FLAVOR;
        goto L18
    }

    public static final ArrayList<e3> g(n r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$plugins");
        return new ArrayList(CollectionsKt.toList(r1.getPluginsFlex()));
    }

    public static final String a(ArrayList<e3> r1, int r2) {
        if (r2 != 0) goto L4;
        ArrayList r3 = new ArrayList();
        if (r1 == null) goto L22;
        Iterator<T> r4 = r1.iterator();
    L19:
        if (r4.hasNext() == false) goto L22;
        r3.add(e((e3) r4.next()).toString());
    L22:
        return r3.toString();
    L4:
        if (r2 == 1) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        JSONArray r5 = new JSONArray();
        if (r1 == null) goto L14;
        Iterator<T> r6 = r1.iterator();
    L11:
        if (r6.hasNext() == false) goto L14;
        r5.put(e((e3) r6.next()));
    L14:
        return r5.toString();
    }

    public static final void c(e3 r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$convertFromJSON");
        Intrinsics.checkNotNullParameter(r5, "target");
        r4.setPluginId(JSONObjectProtectorUtils.getInt(r5, e3.KEY_PLUGIN_ID));     // Catch: Exception -> L17
        LinkedHashMap r0 = new LinkedHashMap();     // Catch: Exception -> L17
        JSONObject r6 = JSONObjectProtectorUtils.getJSONObject(r5, e3.KEY_ITEM_POTENTIAL_VALUE_HINT);     // Catch: Exception -> L17
        if (r6 == null) goto L15;
        Iterator<String> r1 = r6.keys();     // Catch: Exception -> L17
        if (r1 == null) goto L15;
    L8:
        if (r1.hasNext() == false) goto L15;
        String r2 = r1.next();     // Catch: Exception -> L17
        Object r3 = r6.get(r2);     // Catch: Exception -> L17
        if (r3 == null) goto L13;
        String r7 = r3.toString();     // Catch: Exception -> L17
        if (r7 == null) goto L13;
    L14:
        r0.put(r2, r7);     // Catch: Exception -> L17
    L13:
        r7 = BuildConfig.FLAVOR;
    L15:
        r4.setItemPotentialValueHint(r0);     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        jy0.b.c(e3.TAG, "convertFromJSON： " + e.getMessage(), null, 4);
    }

    public static final boolean h(ArrayList<e3> r13, ArrayList<e3> r14) {
        if (r13 == null) goto L5;
        Integer r1 = Integer.valueOf(r13.size());
    L6:
        if (r14 == null) goto L8;
        Integer r2 = Integer.valueOf(r14.size());
    L10:
        if ((!Intrinsics.areEqual(r1, r2)) == true) goto L77;
        if (r13 != null) goto L13;
    L15:
        if (r14 == null) goto L17;
        int r3 = r14.size();
    L18:
        if (r13 == null) goto L76;
        Iterator<T> r15 = r13.iterator();
    L21:
        if (r15.hasNext() == false) goto L76;
        e3 r4 = (e3) r15.next();
        int r5 = 0;
    L23:
        if (r5 >= r3) goto L73;
        if (r14 == null) goto L26;
        e3 r6 = (e3) ListProtector.get(r14, r5);
    L27:
        Intrinsics.checkNotNullParameter(r4, "$this$isSame");
        if (r6 != null) goto L31;
    L29:
        boolean r9 = false;
    L70:
        if (r9 == true) goto L71;
        r5 = r5 + 1;
        goto L23
    L71:
        boolean r7 = true;
    L74:
        if (r7 == true) goto L21;
        return false;
    L31:
        if (r6.getPluginId() != r4.getPluginId()) goto L29;
        Map<String, String> r8 = r6.getItemPotentialValueHint();
        if (r8 == null) goto L35;
        Integer r10 = Integer.valueOf(r8.size());
    L36:
        Map<String, String> r11 = r4.getItemPotentialValueHint();
        if (r11 == null) goto L39;
        Integer r16 = Integer.valueOf(r11.size());
    L41:
        if (Intrinsics.areEqual(r10, r16) == false) goto L29;
        Map<String, String> r17 = r6.getItemPotentialValueHint();
        if (r17 == null) goto L45;
        Set<String> r18 = r17.keySet();
    L46:
        Map<String, String> r19 = r4.getItemPotentialValueHint();
        if (r19 == null) goto L49;
        Set<String> r20 = r19.keySet();
    L50:
        if (r18 == null) goto L69;
        Iterator<T> r21 = r18.iterator();
        r9 = true;
    L53:
        if (r21.hasNext() == false) goto L70;
        String r110 = (String) r21.next();
        if (r20 == null) goto L68;
        if (r20.contains(r110) != true) goto L68;
        Map<String, String> r111 = r6.getItemPotentialValueHint();
        if (r111 == null) goto L68;
        String r112 = r111.get(r110);
        if (r112 == null) goto L68;
        Map<String, String> r113 = r4.getItemPotentialValueHint();
        if (r113 == null) goto L65;
        String r114 = r113.get(r110);
    L67:
        if (r112.equals(r114) == true) goto L53;
    L65:
        r114 = null;
    L68:
        r9 = false;
        goto L53
    L69:
        r9 = true;
        goto L70
    L49:
        r20 = null;
        goto L50
    L45:
        r18 = null;
        goto L46
    L39:
        r16 = null;
        goto L41
    L35:
        r10 = null;
        goto L36
    L26:
        r6 = null;
        goto L27
    L73:
        r7 = false;
    L76:
        return true;
    L17:
        r3 = 0;
        goto L18
    L13:
        if (r13.size() != 0) goto L15;
    L77:
        return false;
    L8:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public static final String f(ArrayList<e3> r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "cardName");
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<e3> r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r0.add(String.valueOf(r6.next().getPluginId()));
        goto L4
    L6:
        Set r7 = CollectionsKt.toMutableSet(r0);
        r7.add(r4);
        if (r5 == null) goto L10;
        r7.add(r5);
    L10:
        return String.valueOf(r7.hashCode());
    }
}
