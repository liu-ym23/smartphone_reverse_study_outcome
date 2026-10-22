package com.bytedance.bdinstall.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.LocalConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SPCache extends Cache {
    private final InstallOptions installOptions;
    private final Context mContext;
    private final SharedPreferences mSharedPref;

    public SPCache(Context r10, SharedPreferences r11, InstallOptions r12) {
        if (r10 == null) goto L7;
        this.mContext = r10;
        this.mSharedPref = r11;
        this.installOptions = r12;
        return;
    L7:
        throw new IllegalArgumentException("context can't be null");
    }

    private SharedPreferences getSp(String r10) {
        if ("device_id".equals(r10) == true) goto L12;
        if ("install_id".equals(r10) == true) goto L12;
        if ("bd_did".equals(r10) == true) goto L12;
        return LocalConstants.getCommonSp(this.mContext, this.installOptions);
    L12:
        return this.mSharedPref;
    }

    private String getValue(String r10) {
        return getSp(r10).getString(r10, null);
    }

    private void storeValue(String r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return;
    L5:
        SharedPreferences.Editor r12 = getSp(r10).edit();
        r12.putString(r10, r11);
        r12.apply();
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public void cacheString(String r10, String r11) {
        storeValue(r10, r11);
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    protected void cacheStringArray(String r10, String[] r11) {
        if (r10 == null) goto L7;
        if (r11 == null) goto L8;
        storeValue(r10, TextUtils.join("\n", r11));
        return;
    L8:
        return;
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public void clear(List<String> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        HashMap r11 = new HashMap();
        Iterator<String> r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L16;
        String r13 = r12.next();
        if (TextUtils.isEmpty(r13) == true) goto L6;
        SharedPreferences r14 = getSp(r13);
        SharedPreferences.Editor r15 = (SharedPreferences.Editor) r11.get(r14);
        if (r15 != null) goto L12;
        r15 = getSp(r13).edit();
        r11.put(r14, r15);
    L12:
        if (r14 == null) goto L6;
        if (r14.contains(r13) == false) goto L6;
        r15.remove(r13);
        goto L6
    L16:
        Iterator r16 = r11.entrySet().iterator();
    L18:
        if (r16.hasNext() == false) goto L20;
        ((SharedPreferences.Editor) ((Map.Entry) r16.next()).getValue()).apply();
        goto L18
    L20:
        super.clear(r10);
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public String getCachedString(String r10) {
        return getValue(r10);
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    protected String[] getCachedStringArray(String r10) {
        String r11 = getValue(r10);
        if (TextUtils.isEmpty(r11) == false) goto L7;
        return null;
    L7:
        return r11.split("\n");
    }
}
