package com.bytedance.bdinstall.storage;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.ExecutorUtil;
import com.bytedance.bdinstall.InstallOptions;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class AccountCache extends Cache {
    private static final String TAG = "AccountCache";
    private Account mAccount;
    private final AccountManager mAccountManager;
    private final ConcurrentHashMap<String, String> mCache;
    private InstallOptions mOptions;
    private final String mSuffix;

    AccountCache(Context r3, String r4, InstallOptions r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mCache = new ConcurrentHashMap();
        this.mAccountManager = AccountManager.get(r6);
        this.mSuffix = r4;
        this.mOptions = r5;
    }

    static /* synthetic */ ConcurrentHashMap access$000(AccountCache r0) {
        return r0.mCache;
    }

    static /* synthetic */ AccountManager access$100(AccountCache r0) {
        return r0.mAccountManager;
    }

    private String wrapKey(String r2) {
        StringBuffer r0 = new StringBuffer(r2);
        r0.append(this.mSuffix);
        if (this.mOptions.isMainInstance() == true) goto L6;
        r0.append("_");
        r0.append(this.mOptions.getAidString());
    L6:
        return r0.toString();
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public void cacheString(String r2, String r3) {
        String r4 = wrapKey(r2);
        Account r0 = this.mAccount;
        if (r0 != null) goto L6;
        this.mCache.put(r4, r3);
        return;
    L6:
        if (r3 != null) goto L13;
        return;
    L13:
        this.mAccountManager.setUserData(r0, r4, r3);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    public void cacheStringArray(String r2, String[] r3) {
        if (r2 == null) goto L7;
        if (r3 == null) goto L8;
        cacheString(r2, TextUtils.join("\n", r3));
        return;
    L8:
        return;
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public void clear(List<String> r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
        return;
    L5:
        Iterator<String> r0 = r8.iterator();
    L7:
        if (r0.hasNext() == false) goto L15;
        String r2 = wrapKey((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin"));
        this.mCache.remove(r2);
        Account r3 = this.mAccount;     // Catch: Exception -> L17
        if (r3 == null) goto L7;
        AccountManager r4 = this.mAccountManager;     // Catch: Exception -> L17
        if (r4 == null) goto L7;
        r4.setUserData(r3, r2, null);     // Catch: Exception -> L17
        goto L7
    L15:
        super.clear(r8);
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public String getCachedString(String r4) {
        String r5 = wrapKey(r4);
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.mCache.get(r5), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        Account r1 = this.mAccount;
        if (r1 != null) goto L13;
        return null;
    L13:
        return this.mAccountManager.getUserData(r1, r5);
    L10:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    public String[] getCachedStringArray(String r1) {
        String r0 = getCachedString(r1);
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return null;
    L7:
        return r0.split("\n");
    }

    void setAccount(String r2, final Account r3) {
        if (r3 == null) goto L8;
        this.mAccount = r3;
        if (this.mCache.size() > 0) goto L6;
        return;
    L6:
        ExecutorUtil.runOnIOExecutor(r2, new AnonymousClass1(this, r3));
        return;
    }
}
