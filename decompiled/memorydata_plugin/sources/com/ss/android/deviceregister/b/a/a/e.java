package com.ss.android.deviceregister.b.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.ss.android.deviceregister.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class e extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f15181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f15182b;

    public e(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        this.f15181a = r4.getSharedPreferences(com.ss.android.deviceregister.a.b.c(), 0);
        this.f15182b = com.ss.android.deviceregister.a.b.a(r4);
        return;
    L7:
        throw new IllegalArgumentException("context can't be null");
    }

    private String c(String r2) {
        return d(r2).getString(r2, null);
    }

    private void c(String r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        SharedPreferences.Editor r1 = d(r2).edit();
        r1.putString(r2, r3);
        r1.apply();
    }

    private SharedPreferences d(String r2) {
        if ("device_id".equals(r2) == false) goto L6;
        return this.f15182b;
    L6:
        return this.f15181a;
    }

    @Override // com.ss.android.deviceregister.b.a.a.b
    public String a(String r3) {
        String r2 = c(r3);
        if (Logger.debug() == false) goto L5;
        Logger.d("SharePreferenceCacheHandler", "getCachedString key = " + r3 + " value = " + r2);
    L5:
        return r2;
    }

    @Override // com.ss.android.deviceregister.b.a.a.b
    public void a(String r3, String r4) {
        if (Logger.debug() == false) goto L5;
        Logger.d("SharePreferenceCacheHandler", "cacheString key = " + r3 + " value = " + r4);
    L5:
        c(r3, r4);
    }

    @Override // com.ss.android.deviceregister.b.a.a.b
    public void b(String r4) {
        SharedPreferences r0 = d(r4);
        if (r0 != null) goto L5;
    L7:
        l.b(l.f15219a, "SharePreferenceCacheHandler#clear key=" + r4 + " getCachedString(key)=" + a(r4));
        super.b(r4);
        return;
    L5:
        if (r0.contains(r4) == false) goto L7;
        d(r4).edit().remove(r4).commit();
        goto L7
    }
}
