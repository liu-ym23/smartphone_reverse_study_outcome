package com.bytedance.bdinstall.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import com.bytedance.bdinstall.util.Singleton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
final class OnePlusOaidImpl implements OaidApi {
    private final OaidApi mFallback;
    private Singleton<Boolean> support;

    OnePlusOaidImpl() {
        this(null);
    }

    OnePlusOaidImpl(OaidApi r3) {
        OaidApi r4 = (OaidApi) ZeusTransformUtils.wrapperContextForParams(r3, OaidApi.class, "com.obric.memorydata.plugin");
        this.support = new AnonymousClass1(this);
        this.mFallback = r4;
    }

    static /* synthetic */ String access$000(OnePlusOaidImpl r2, Context r3) {
        return r2.getSign((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    private String getSign(Context r7) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        PackageInfo r8 = r6.getPackageManager().getPackageInfo(r6.getPackageName(), 64);     // Catch: Exception -> L7
        if (r8 == null) goto L9;
        Signature[] r9 = r8.signatures;     // Catch: Exception -> L7
    L10:
        if (r9 != null) goto L12;
    L23:
        return null;
    L12:
        if (r9.length <= 0) goto L23;
        int r0 = 0;
        byte[] r10 = r9[0].toByteArray();
        MessageDigest r1 = MessageDigest.getInstance("SHA1");     // Catch: Exception -> L21
        if (r1 == null) goto L23;
        byte[] r11 = r1.digest(r10);     // Catch: Exception -> L21
        StringBuilder r2 = new StringBuilder();     // Catch: Exception -> L21
        int r3 = r11.length;     // Catch: Exception -> L21
    L17:
        if (r0 >= r3) goto L19;
        r2.append(Integer.toHexString((r11[r0] & 255) | 256).substring(1, 3));     // Catch: Exception -> L21
        r0 = r0 + 1;     // Catch: Exception -> L21
        goto L17
    L19:
        return r2.toString();
    L21:
        e = move-exception;
        e.printStackTrace();
    L9:
        r9 = null;
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
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.support.get(new Object[0]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        return "OnePlus/Oppo";
    L7:
        return this.mFallback.getName();
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r6) {
        final Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (this.mFallback != null) goto L5;
    L8:
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        r0.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String r5 = (String) ZeusTransformUtils.preCheckCast(new ServiceBlockBinder(r7, r0, new AnonymousClass2(this, r7)).blockFetchResult(), String.class, "com.obric.memorydata.plugin");
        OaidApi.Result r8 = new OaidApi.Result();
        r8.oaid = r5;
        return r8;
    L5:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.support.get(new Object[0]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L8;
        return this.mFallback.getOaid(r7);
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return false;
    L5:
        Boolean r0 = (Boolean) ZeusTransformUtils.preCheckCast(this.support.get(new Object[]{r6}), Boolean.class, "com.obric.memorydata.plugin");
        if (this.mFallback == null) goto L12;
        if (r0.booleanValue() == true) goto L12;
        return this.mFallback.support(r6);
    L12:
        return r0.booleanValue();
    }
}
