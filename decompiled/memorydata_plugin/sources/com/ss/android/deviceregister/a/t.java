package com.ss.android.deviceregister.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes6.dex */
final class t implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f15150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.ss.android.deviceregister.d.f<Boolean> f15151b;

    t() {
        this(null);
    }

    t(n r3) {
        n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin");
        this.f15151b = new AnonymousClass1(this);
        this.f15150a = r4;
    }

    private String a(Context r7) {
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

    static /* synthetic */ String a(t r2, Context r3) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.deviceregister.a.n
    public boolean b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return false;
    L5:
        n r2 = this.f15150a;
        if (r2 == null) goto L12;
        if (r2.b(r5) == false) goto L12;
        return this.f15150a.b(r5);
    L12:
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.f15151b.c(new Object[]{r5}), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // com.ss.android.deviceregister.a.n
    public n.a c(Context r6) {
        final Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        n r0 = this.f15150a;
        if (r0 != null) goto L5;
    L8:
        Intent r1 = new Intent();
        r1.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        r1.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String r5 = (String) ZeusTransformUtils.preCheckCast(new w(r7, r1, new AnonymousClass2(this, r7)).a(), String.class, "com.obric.memorydata.plugin");
        n.a r8 = new n.a();
        r8.f15141a = r5;
        return r8;
    L5:
        if (r0.b(r7) == false) goto L8;
        return this.f15150a.c(r7);
    }
}
