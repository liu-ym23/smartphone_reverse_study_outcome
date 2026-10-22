package com.obric.cae.userAware;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.obric.cae.log.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class PnoSavedNetworkStore {
    private static final String KEY_PNO_SAVED_COMPANY = "pno_saved_company";
    private static final String KEY_PNO_SAVED_HOME = "pno_saved_home";
    private static final int PNO_SAVED_NETWORK_MAX = 16;
    private static final String PREF_PNO_SAVED_NETWORKS = "cae_pno_saved_networks";
    private static final String TAG = "PnoSavedNetworkStore";
    private final Context mAppContext;
    private final LinkedHashMap<String, LinkedHashSet<Integer>> mCompany;
    private final LinkedHashMap<String, LinkedHashSet<Integer>> mHome;
    private final Object mLock;

    public PnoSavedNetworkStore(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        this.mLock = new Object();
        this.mHome = new LinkedHashMap(16, 0.75f, true);
        this.mCompany = new LinkedHashMap(16, 0.75f, true);
        if (r7 == null) goto L5;
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L6:
        this.mAppContext = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
        loadFromPrefs();
        return;
    L5:
        r8 = null;
        goto L6
    }

    private static String dumpPnoMapToJson(LinkedHashMap<String, LinkedHashSet<Integer>> r7) {
        JSONArray r0 = new JSONArray();
        Iterator<Map.Entry<String, LinkedHashSet<Integer>>> r8 = r7.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L23;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r2) == true) goto L4;
        LinkedHashSet r3 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r1.getValue(), LinkedHashSet.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L4;
        if (r3.isEmpty() == true) goto L4;
        JSONObject r4 = new JSONObject();
        r4.put(Api.KEY_SSID, r2);
        JSONArray r5 = new JSONArray();
        Iterator r6 = r3.iterator();
    L15:
        if (r6.hasNext() == false) goto L21;
        Integer r9 = (Integer) ZeusTransformUtils.preCheckCast(r6.next(), Integer.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L15;
        if (r9.intValue() <= 0) goto L15;
        r5.put(r9);
        goto L15
    L21:
        r4.put("freqs", r5);
        r0.put(r4);
        goto L4
    L23:
        return r0.toString();
    }

    private void loadFromPrefs() {
        Context r1 = this.mAppContext;
        if (r1 != null) goto L17;
        return;
    L17:
        SharedPreferences r2 = r1.getSharedPreferences(PREF_PNO_SAVED_NETWORKS, 0);     // Catch: Throwable -> L14
        String r3 = r2.getString(KEY_PNO_SAVED_HOME, "");     // Catch: Throwable -> L14
        String r4 = r2.getString(KEY_PNO_SAVED_COMPANY, "");     // Catch: Throwable -> L14
        Object r5 = this.mLock;     // Catch: Throwable -> L14
        monitor-enter(r5);     // Catch: Throwable -> L14
        this.mHome.clear();     // Catch: Throwable -> L11
        this.mCompany.clear();     // Catch: Throwable -> L11
        restorePnoMapFromJson(r3, this.mHome);     // Catch: Throwable -> L11
        restorePnoMapFromJson(r4, this.mCompany);     // Catch: Throwable -> L11
        monitor-exit(r5);     // Catch: Throwable -> L11
        a.e(TAG, "loadSavedPnoNetworks: home=" + this.mHome.size() + ", company=" + this.mCompany.size());     // Catch: Throwable -> L14
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        a.a(TAG, "loadSavedPnoNetworks failed", th);
    }

    private void persistLocked() {
        Context r0 = this.mAppContext;
        if (r0 != null) goto L10;
        return;
    L10:
        r0.getSharedPreferences(PREF_PNO_SAVED_NETWORKS, 0).edit().putString(KEY_PNO_SAVED_HOME, dumpPnoMapToJson(this.mHome)).putString(KEY_PNO_SAVED_COMPANY, dumpPnoMapToJson(this.mCompany)).apply();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        a.a(TAG, "persistSavedPnoNetworksLocked failed", th);
    }

    private static void restorePnoMapFromJson(String r7, LinkedHashMap<String, LinkedHashSet<Integer>> r8) {
        if (TextUtils.isEmpty(r7) == false) goto L5;
        return;
    L5:
        JSONArray r0 = new JSONArray(r7);
        int r1 = 0;
    L7:
        if (r1 >= r0.length()) goto L27;
        JSONObject r2 = r0.optJSONObject(r1);
        if (r2 == null) goto L26;
        String r3 = r2.optString(Api.KEY_SSID, "");
        if (TextUtils.isEmpty(r3) == true) goto L26;
        JSONArray r4 = r2.optJSONArray("freqs");
        LinkedHashSet<Integer> r5 = new LinkedHashSet();
        if (r4 == null) goto L24;
        int r6 = 0;
    L18:
        if (r6 >= r4.length()) goto L24;
        int r9 = r4.optInt(r6, -1);
        if (r9 <= 0) goto L22;
        r5.add(Integer.valueOf(r9));
    L22:
        r6 = r6 + 1;
    L24:
        if (r5.isEmpty() == true) goto L26;
        r8.put(r3, r5);
    L26:
        r1 = r1 + 1;
        goto L7
    }

    public Set<Map<String, Integer>> getSavedPnoNetworkSetForFence(int r7) {
        boolean r0 = false;
        if (r7 != 1) goto L5;
        boolean r2 = true;
    L7:
        if (r7 != 3) goto L9;
        r0 = true;
    L9:
        if (r2 == true) goto L14;
        if (r0 == true) goto L14;
        return Collections.emptySet();
    L14:
        if (this.mAppContext == null) goto L16;
        Object r8 = this.mLock;
        monitor-enter(r8);
        if (r2 == false) goto L21;
        LinkedHashMap<String, LinkedHashSet<Integer>> r6 = this.mHome;     // Catch: Throwable -> L47
    L23:
        if (r6.isEmpty() == false) goto L27;
        Set<Map<String, Integer>> r9 = Collections.emptySet();     // Catch: Throwable -> L47
        monitor-exit(r8);     // Catch: Throwable -> L47
        return r9;
    L27:
        LinkedHashSet r1 = new LinkedHashSet();     // Catch: Throwable -> L47
        Iterator<Map.Entry<String, LinkedHashSet<Integer>>> r10 = r6.entrySet().iterator();     // Catch: Throwable -> L47
    L29:
        if (r10.hasNext() == false) goto L45;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        LinkedHashSet r5 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r3.getValue(), LinkedHashSet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        if (TextUtils.isEmpty(r4) == true) goto L29;
        if (r5 == null) goto L29;
        if (r5.isEmpty() == true) goto L29;
        Iterator r11 = r5.iterator();     // Catch: Throwable -> L47
    L38:
        if (r11.hasNext() == false) goto L29;
        Integer r12 = (Integer) ZeusTransformUtils.preCheckCast(r11.next(), Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        if (r12 == null) goto L38;
        if (r12.intValue() <= 0) goto L38;
        HashMap r13 = new HashMap();     // Catch: Throwable -> L47
        r13.put(r4, r12);     // Catch: Throwable -> L47
        r1.add(r13);     // Catch: Throwable -> L47
        goto L38
    L45:
        monitor-exit(r8);     // Catch: Throwable -> L47
        return r1;
    L21:
        r6 = this.mCompany;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        throw th;
    L16:
        return Collections.emptySet();
    L5:
        r2 = false;
        goto L7
    }

    public void maybeSaveForGeofenceEvent(int r6, String r7, int r8) {
        if (this.mAppContext != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r7) == true) goto L41;
        if (r8 <= 0) goto L46;
        boolean r0 = false;
        if (r6 != 1) goto L12;
        boolean r2 = true;
    L14:
        if (r6 != 3) goto L16;
        r0 = true;
    L16:
        if (r2 == true) goto L19;
        if (r0 == true) goto L19;
        return;
    L19:
        Object r9 = this.mLock;
        monitor-enter(r9);
        if (r2 == false) goto L23;
        LinkedHashMap<String, LinkedHashSet<Integer>> r1 = this.mHome;     // Catch: Throwable -> L38
    L24:
        LinkedHashSet<Integer> r3 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r1.get(r7), LinkedHashSet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        if (r3 != null) goto L27;
        r3 = new LinkedHashSet();     // Catch: Throwable -> L38
        r1.put(r7, r3);     // Catch: Throwable -> L38
    L27:
        r3.add(Integer.valueOf(r8));     // Catch: Throwable -> L38
    L29:
        if (r1.size() <= 16) goto L34;
        Iterator<String> r10 = r1.keySet().iterator();     // Catch: Throwable -> L38
        if (r10.hasNext() == false) goto L34;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        r10.remove();     // Catch: Throwable -> L38
        a.e(TAG, "PNO saved list evict, isHome=" + r2);     // Catch: Throwable -> L38
    L34:
        persistLocked();     // Catch: Throwable -> L38
        monitor-exit(r9);     // Catch: Throwable -> L38
        a.e(TAG, "PNO saved update: freq=" + r8 + " isHome=" + r2);
        return;
    L23:
        r1 = this.mCompany;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    L12:
        r2 = false;
        goto L14
    L46:
        return;
    }
}
