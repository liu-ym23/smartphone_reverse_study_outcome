package com.bytedance.bdinstall.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.LocalConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SPCache extends Cache {
    private final InstallOptions installOptions;
    private final Context mContext;
    private final SharedPreferences mSharedPref;

    public SPCache(Context r3, SharedPreferences r4, InstallOptions r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        SharedPreferences r7 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r4, SharedPreferences.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L7;
        this.mContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.mSharedPref = r7;
        this.installOptions = r5;
        return;
    L7:
        throw new IllegalArgumentException("context can't be null");
    }

    private SharedPreferences getSp(String r2) {
        if ("device_id".equals(r2) == true) goto L12;
        if ("install_id".equals(r2) == true) goto L12;
        if ("bd_did".equals(r2) == true) goto L12;
        return LocalConstants.getCommonSp(this.mContext, this.installOptions);
    L12:
        return this.mSharedPref;
    }

    private String getValue(String r2) {
        return getSp(r2).getString(r2, null);
    }

    private void storeValue(String r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        SharedPreferences.Editor r1 = getSp(r2).edit();
        r1.putString(r2, r3);
        r1.apply();
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public void cacheString(String r1, String r2) {
        storeValue(r1, r2);
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    public void cacheStringArray(String r2, String[] r3) {
        if (r2 == null) goto L7;
        if (r3 == null) goto L8;
        storeValue(r2, TextUtils.join("\n", r3));
        return;
    L8:
        return;
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public void clear(List<String> r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        Iterator<String> r2 = r9.iterator();
    L7:
        if (r2.hasNext() == false) goto L17;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r3) == true) goto L7;
        SharedPreferences r4 = getSp(r3);
        SharedPreferences.Editor r5 = (SharedPreferences.Editor) ZeusTransformUtils.preCheckCast(r0.get(r4), SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L13;
        r5 = getSp(r3).edit();
        r0.put(r4, r5);
    L13:
        if (r4 == null) goto L7;
        if (r4.contains(r3) == false) goto L7;
        r5.remove(r3);
        goto L7
    L17:
        Iterator r1 = r0.entrySet().iterator();
    L19:
        if (r1.hasNext() == false) goto L21;
        ((SharedPreferences.Editor) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), SharedPreferences.Editor.class, "com.obric.memorydata.plugin")).apply();
        goto L19
    L21:
        super.clear(r9);
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public String getCachedString(String r1) {
        return getValue(r1);
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    public String[] getCachedStringArray(String r1) {
        String r0 = getValue(r1);
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return null;
    L7:
        return r0.split("\n");
    }
}
