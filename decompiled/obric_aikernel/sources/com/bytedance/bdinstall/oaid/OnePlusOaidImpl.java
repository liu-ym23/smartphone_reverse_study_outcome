package com.bytedance.bdinstall.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import com.bytedance.bdinstall.util.Singleton;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
final class OnePlusOaidImpl implements OaidApi {
    private final OaidApi mFallback;
    private Singleton<Boolean> support;

    OnePlusOaidImpl() {
        this(null);
    }

    OnePlusOaidImpl(OaidApi r10) {
        this.support = new AnonymousClass1(this);
        this.mFallback = r10;
    }

    static /* synthetic */ String access$000(OnePlusOaidImpl r10, Context r11) {
        return r10.getSign(r11);
    }

    private String getSign(Context r10) {
        PackageInfo r11 = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 64);     // Catch: Exception -> L7
        if (r11 == null) goto L9;
        Signature[] r12 = r11.signatures;     // Catch: Exception -> L7
    L10:
        if (r12 != null) goto L12;
    L23:
        return null;
    L12:
        if (r12.length <= 0) goto L23;
        int r13 = 0;
        byte[] r14 = r12[0].toByteArray();
        MessageDigest r15 = MessageDigest.getInstance("SHA1");     // Catch: Exception -> L21
        if (r15 == null) goto L23;
        byte[] r16 = r15.digest(r14);     // Catch: Exception -> L21
        StringBuilder r17 = new StringBuilder();     // Catch: Exception -> L21
        int r18 = r16.length;     // Catch: Exception -> L21
    L17:
        if (r13 >= r18) goto L19;
        r17.append(Integer.toHexString((r16[r13] & 255) | 256).substring(1, 3));     // Catch: Exception -> L21
        r13 = r13 + 1;     // Catch: Exception -> L21
        goto L17
    L19:
        return r17.toString();
    L21:
        e = move-exception;
        e.printStackTrace();
    L9:
        r12 = null;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        if (this.mFallback != null) goto L5;
        return "OnePlus/Oppo";
    L5:
        if (this.support.get(new Object[0]).booleanValue() == false) goto L7;
        return "OnePlus/Oppo";
    L7:
        return this.mFallback.getName();
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(final Context r10) {
        if (this.mFallback != null) goto L5;
    L8:
        Intent r11 = new Intent();
        r11.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        r11.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String r12 = (String) new ServiceBlockBinder(r10, r11, new AnonymousClass2(this, r10)).blockFetchResult();
        OaidApi.Result r13 = new OaidApi.Result();
        r13.oaid = r12;
        return r13;
    L5:
        if (this.support.get(new Object[0]).booleanValue() == true) goto L8;
        return this.mFallback.getOaid(r10);
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        Boolean r11 = this.support.get(new Object[]{r10});
        if (this.mFallback == null) goto L12;
        if (r11.booleanValue() == true) goto L12;
        return this.mFallback.support(r10);
    L12:
        return r11.booleanValue();
    }
}
