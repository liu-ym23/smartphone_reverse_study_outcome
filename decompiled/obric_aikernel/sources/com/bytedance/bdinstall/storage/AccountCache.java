package com.bytedance.bdinstall.storage;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.ExecutorUtil;
import com.bytedance.bdinstall.InstallOptions;
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

    AccountCache(Context r10, String r11, InstallOptions r12) {
        this.mCache = new ConcurrentHashMap();
        this.mAccountManager = AccountManager.get(r10);
        this.mSuffix = r11;
        this.mOptions = r12;
    }

    static /* synthetic */ ConcurrentHashMap access$000(AccountCache r10) {
        return r10.mCache;
    }

    static /* synthetic */ AccountManager access$100(AccountCache r10) {
        return r10.mAccountManager;
    }

    private String wrapKey(String r10) {
        StringBuffer r11 = new StringBuffer(r10);
        r11.append(this.mSuffix);
        if (this.mOptions.isMainInstance() == true) goto L6;
        r11.append("_");
        r11.append(this.mOptions.getAidString());
    L6:
        return r11.toString();
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    @SuppressLint({"MissingPermission"})
    public void cacheString(String r10, String r11) {
        String r12 = wrapKey(r10);
        Account r13 = this.mAccount;
        if (r13 != null) goto L6;
        this.mCache.put(r12, r11);
        return;
    L6:
        if (r11 != null) goto L13;
        return;
    L13:
        this.mAccountManager.setUserData(r13, r12, r11);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    protected void cacheStringArray(String r10, String[] r11) {
        if (r10 == null) goto L7;
        if (r11 == null) goto L8;
        cacheString(r10, TextUtils.join("\n", r11));
        return;
    L8:
        return;
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    @SuppressLint({"MissingPermission"})
    public void clear(List<String> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Iterator<String> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L14;
        String r12 = wrapKey(r11.next());
        this.mCache.remove(r12);
        Account r13 = this.mAccount;     // Catch: Exception -> L16
        if (r13 == null) goto L6;
        AccountManager r14 = this.mAccountManager;     // Catch: Exception -> L16
        if (r14 == null) goto L6;
        r14.setUserData(r13, r12, null);     // Catch: Exception -> L16
        goto L6
    L14:
        super.clear(r10);
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    @SuppressLint({"MissingPermission"})
    public String getCachedString(String r10) {
        String r11 = wrapKey(r10);
        String r12 = this.mCache.get(r11);
        if (TextUtils.isEmpty(r12) == true) goto L5;
        return r12;
    L5:
        Account r13 = this.mAccount;
        if (r13 != null) goto L13;
        return null;
    L13:
        return this.mAccountManager.getUserData(r13, r11);
    L10:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    protected String[] getCachedStringArray(String r10) {
        String r11 = getCachedString(r10);
        if (TextUtils.isEmpty(r11) == false) goto L7;
        return null;
    L7:
        return r11.split("\n");
    }

    void setAccount(String r10, final Account r11) {
        if (r11 == null) goto L8;
        this.mAccount = r11;
        if (this.mCache.size() > 0) goto L6;
        return;
    L6:
        ExecutorUtil.runOnIOExecutor(r10, new AnonymousClass1(this, r11));
        return;
    }
}
