package com.obric.cae.userAware;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.obric.cae.log.CommSenseLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class PnoSavedNetworkStore {
    private static final String KEY_PNO_SAVED_COMPANY = "pno_saved_company";
    private static final String KEY_PNO_SAVED_HOME = "pno_saved_home";
    private static final int PNO_SAVED_NETWORK_MAX = 20;
    private static final String PREF_PNO_SAVED_NETWORKS = "cae_pno_saved_networks";
    private static final String TAG = "PnoSavedNetworkStore";
    private final Context mAppContext;
    private final LinkedHashMap<String, LinkedHashSet<Integer>> mCompany;
    private final LinkedHashMap<String, LinkedHashSet<Integer>> mHome;
    private final Object mLock;

    public PnoSavedNetworkStore(Context r8) {
        this.mLock = new Object();
        this.mHome = new LinkedHashMap(16, 0.75f, true);
        this.mCompany = new LinkedHashMap(16, 0.75f, true);
        if (r8 == null) goto L5;
        Context r10 = r8.getApplicationContext();
    L6:
        this.mAppContext = r10;
        loadFromPrefs();
        return;
    L5:
        r10 = null;
        goto L6
    }

    private static String dumpPnoMapToJson(LinkedHashMap<String, LinkedHashSet<Integer>> r8) {
        JSONArray r10 = new JSONArray();
        Iterator<Map.Entry<String, LinkedHashSet<Integer>>> r11 = r8.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L23;
        Map.Entry<String, LinkedHashSet<Integer>> r12 = r11.next();
        String r13 = r12.getKey();
        if (TextUtils.isEmpty(r13) == true) goto L4;
        LinkedHashSet<Integer> r14 = r12.getValue();
        if (r14 == null) goto L4;
        if (r14.isEmpty() == true) goto L4;
        JSONObject r15 = new JSONObject();
        r15.put("ssid", r13);
        JSONArray r16 = new JSONArray();
        Iterator<Integer> r17 = r14.iterator();
    L15:
        if (r17.hasNext() == false) goto L21;
        Integer r18 = r17.next();
        if (r18 == null) goto L15;
        if (r18.intValue() <= 0) goto L15;
        r16.put(r18);
        goto L15
    L21:
        r15.put("freqs", r16);
        r10.put(r15);
        goto L4
    L23:
        return r10.toString();
    }

    private void loadFromPrefs() {
        Context r8 = this.mAppContext;
        if (r8 != null) goto L19;
        return;
    L19:
        SharedPreferences r10 = r8.getSharedPreferences(PREF_PNO_SAVED_NETWORKS, 0);     // Catch: Throwable -> L14
        String r11 = r10.getString(KEY_PNO_SAVED_HOME, "");     // Catch: Throwable -> L14
        String r12 = r10.getString(KEY_PNO_SAVED_COMPANY, "");     // Catch: Throwable -> L14
        Object r13 = this.mLock;     // Catch: Throwable -> L14
        monitor-enter(r13);     // Catch: Throwable -> L14
        this.mHome.clear();     // Catch: Throwable -> L11
        this.mCompany.clear();     // Catch: Throwable -> L11
        restorePnoMapFromJson(r11, this.mHome);     // Catch: Throwable -> L11
        restorePnoMapFromJson(r12, this.mCompany);     // Catch: Throwable -> L11
        monitor-exit(r13);     // Catch: Throwable -> L11
        CommSenseLog.i(TAG, "loadSavedPnoNetworks: home=" + this.mHome.size() + ", company=" + this.mCompany.size());     // Catch: Throwable -> L14
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CommSenseLog.e(TAG, "loadSavedPnoNetworks failed", th);
    }

    private void persistLocked() {
        Context r8 = this.mAppContext;
        if (r8 != null) goto L10;
        return;
    L10:
        r8.getSharedPreferences(PREF_PNO_SAVED_NETWORKS, 0).edit().putString(KEY_PNO_SAVED_HOME, dumpPnoMapToJson(this.mHome)).putString(KEY_PNO_SAVED_COMPANY, dumpPnoMapToJson(this.mCompany)).apply();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        CommSenseLog.e(TAG, "persistSavedPnoNetworksLocked failed", th);
    }

    private static void restorePnoMapFromJson(String r8, LinkedHashMap<String, LinkedHashSet<Integer>> r10) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        JSONArray r11 = new JSONArray(r8);
        int r12 = 0;
    L7:
        if (r12 >= r11.length()) goto L27;
        JSONObject r13 = r11.optJSONObject(r12);
        if (r13 == null) goto L26;
        String r14 = r13.optString("ssid", "");
        if (TextUtils.isEmpty(r14) == true) goto L26;
        JSONArray r15 = r13.optJSONArray("freqs");
        LinkedHashSet<Integer> r16 = new LinkedHashSet();
        if (r15 == null) goto L24;
        int r17 = 0;
    L18:
        if (r17 >= r15.length()) goto L24;
        int r18 = r15.optInt(r17, -1);
        if (r18 <= 0) goto L22;
        r16.add(Integer.valueOf(r18));
    L22:
        r17 = r17 + 1;
    L24:
        if (r16.isEmpty() == true) goto L26;
        r10.put(r14, r16);
    L26:
        r12 = r12 + 1;
        goto L7
    }

    public Set<Map<String, Integer>> getSavedPnoNetworkSetForFence(int r8) {
        boolean r10 = false;
        if (r8 != 1) goto L5;
        boolean r11 = true;
    L7:
        if (r8 != 3) goto L9;
        r10 = true;
    L9:
        if (r11 == true) goto L14;
        if (r10 == true) goto L14;
        return Collections.emptySet();
    L14:
        if (this.mAppContext == null) goto L16;
        Object r12 = this.mLock;
        monitor-enter(r12);
        if (r11 == false) goto L21;
        LinkedHashMap<String, LinkedHashSet<Integer>> r13 = this.mHome;     // Catch: Throwable -> L47
    L23:
        if (r13.isEmpty() == false) goto L27;
        Set<Map<String, Integer>> r14 = Collections.emptySet();     // Catch: Throwable -> L47
        monitor-exit(r12);     // Catch: Throwable -> L47
        return r14;
    L27:
        LinkedHashSet r15 = new LinkedHashSet();     // Catch: Throwable -> L47
        Iterator<Map.Entry<String, LinkedHashSet<Integer>>> r16 = r13.entrySet().iterator();     // Catch: Throwable -> L47
    L29:
        if (r16.hasNext() == false) goto L45;
        Map.Entry<String, LinkedHashSet<Integer>> r17 = r16.next();     // Catch: Throwable -> L47
        String r18 = r17.getKey();     // Catch: Throwable -> L47
        LinkedHashSet<Integer> r19 = r17.getValue();     // Catch: Throwable -> L47
        if (TextUtils.isEmpty(r18) == true) goto L29;
        if (r19 == null) goto L29;
        if (r19.isEmpty() == true) goto L29;
        Iterator<Integer> r20 = r19.iterator();     // Catch: Throwable -> L47
    L38:
        if (r20.hasNext() == false) goto L29;
        Integer r21 = r20.next();     // Catch: Throwable -> L47
        if (r21 == null) goto L38;
        if (r21.intValue() <= 0) goto L38;
        HashMap r22 = new HashMap();     // Catch: Throwable -> L47
        r22.put(r18, r21);     // Catch: Throwable -> L47
        r15.add(r22);     // Catch: Throwable -> L47
        goto L38
    L45:
        monitor-exit(r12);     // Catch: Throwable -> L47
        return r15;
    L21:
        r13 = this.mCompany;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        throw th;
    L16:
        return Collections.emptySet();
    L5:
        r11 = false;
        goto L7
    }

    public void maybeSaveForGeofenceEvent(int r8, String r10, int r11) {
        if (this.mAppContext != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == true) goto L41;
        if (r11 <= 0) goto L46;
        boolean r12 = false;
        if (r8 != 1) goto L12;
        boolean r13 = true;
    L14:
        if (r8 != 3) goto L16;
        r12 = true;
    L16:
        if (r13 == true) goto L19;
        if (r12 == true) goto L19;
        return;
    L19:
        Object r14 = this.mLock;
        monitor-enter(r14);
        if (r13 == false) goto L23;
        LinkedHashMap<String, LinkedHashSet<Integer>> r15 = this.mHome;     // Catch: Throwable -> L38
    L24:
        LinkedHashSet<Integer> r16 = r15.get(r10);     // Catch: Throwable -> L38
        if (r16 != null) goto L27;
        r16 = new LinkedHashSet();     // Catch: Throwable -> L38
        r15.put(r10, r16);     // Catch: Throwable -> L38
    L27:
        r16.add(Integer.valueOf(r11));     // Catch: Throwable -> L38
    L29:
        if (r15.size() <= 20) goto L34;
        Iterator<String> r17 = r15.keySet().iterator();     // Catch: Throwable -> L38
        if (r17.hasNext() == false) goto L34;
        String r18 = r17.next();     // Catch: Throwable -> L38
        r17.remove();     // Catch: Throwable -> L38
        CommSenseLog.i(TAG, "PNO saved list evict ssid=" + r18 + ", isHome=" + r13);     // Catch: Throwable -> L38
    L34:
        persistLocked();     // Catch: Throwable -> L38
        monitor-exit(r14);     // Catch: Throwable -> L38
        CommSenseLog.i(TAG, "PNO saved update: ssid=" + r10 + " freq=" + r11 + " isHome=" + r13);
        return;
    L23:
        r15 = this.mCompany;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    L12:
        r13 = false;
        goto L14
    L46:
        return;
    }
}
