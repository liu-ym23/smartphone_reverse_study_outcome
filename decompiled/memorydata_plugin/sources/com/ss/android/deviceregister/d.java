package com.ss.android.deviceregister;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.bdinstall.storage.CommonDeviceParamProviderCreator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes6.dex */
public class d extends a {
    private static String d;
    private static JSONArray e;
    private static String[] f;
    private static String g;

    d(Context r3, boolean r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.ss.android.deviceregister.a
    public void a(c r11, com.ss.android.deviceregister.b.a.a.b r12) {
        StringBuilder r0 = new StringBuilder().append(CommonDeviceParamProviderCreator.FILE_NAME);
        if (i.a() == false) goto L5;
        String r1 = "_i18n";
    L6:
        String r2 = r0.append(r1).toString();
        if (this.f15125b == false) goto L9;
        r2 = r2 + "_local";
    L9:
        String r3 = r2 + ".dat";
        String r7 = a(this.f15124a);
    L16:
        e = move-exception;
        e.printStackTrace();
    L18:
        boolean r8 = !com.ss.android.deviceregister.a.b.b();
        com.ss.android.deviceregister.b.a.a.d r9 = new com.ss.android.deviceregister.b.a.a.d(this.f15124a, r8, Environment.getExternalStorageDirectory().getPath() + com.ss.android.deviceregister.b.a.a.c.a("L0FuZHJvaWQvZGF0YS9jb20uc25zc2RrLmFwaS9ieXRlZGFuY2U="), r3, r7);     // Catch: Exception -> L21
        r12.a(r9);     // Catch: Exception -> L21
        r12 = r9;
    L30:
        r12.a(new com.ss.android.deviceregister.b.a.a.d(this.f15124a, r8, Environment.getExternalStorageDirectory().getPath() + "/" + com.ss.android.deviceregister.b.a.a.c.a(), r3, r7));     // Catch: Exception -> L25
        return;
    L25:
        e = move-exception;
        e.printStackTrace();
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L30
    L11:
        if (com.ss.android.deviceregister.a.b.b() == false) goto L13;
        String r4 = "device_id";
    L14:
        com.ss.android.deviceregister.b.a.a.d r10 = new com.ss.android.deviceregister.b.a.a.d(this.f15124a, true, this.f15124a.getExternalCacheDir().getParent() + "/" + r4, r3, r7);     // Catch: Exception -> L16
        r12.a(r10);     // Catch: Exception -> L16
        r12 = r10;
        goto L18
    L13:
        r4 = com.ss.android.deviceregister.b.a.a.c.a();     // Catch: Exception -> L16
        goto L14
    L5:
        r1 = "";
        goto L6
    }

    @Override // com.ss.android.deviceregister.b.a.a
    public String c() {
        if (com.bytedance.common.utility.h.a(g) == false) goto L5;
        String r0 = com.ss.android.deviceregister.d.c.a(this.f15124a);     // Catch: Exception -> L11
        if (com.bytedance.common.utility.h.a(r0) == true) goto L9;
        r0 = r0 + this.c;     // Catch: Exception -> L11
    L9:
        g = r0;     // Catch: Exception -> L11
        return r0;
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return g;
    }

    @Override // com.ss.android.deviceregister.b.a.a
    public String[] d() {
        String[] r0 = f;
        if (r0 != null) goto L5;
    L18:
        String[] r1 = com.ss.android.deviceregister.d.c.b(this.f15124a);     // Catch: Exception -> L15
        int r2 = 0;
        if (r1 != null) goto L11;
        r1 = new String[0];     // Catch: Exception -> L15
    L11:
        if (r2 >= r1.length) goto L13;
        r1[r2] = r1[r2] + this.c;     // Catch: Exception -> L15
        r2 = r2 + 1;     // Catch: Exception -> L15
        goto L11
    L13:
        f = r1;     // Catch: Exception -> L15
        return r1;
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        if (r0.length <= 0) goto L18;
        return r0;
    }

    @Override // com.ss.android.deviceregister.b.a.a
    public String e() {
        if (com.bytedance.common.utility.h.a(d) == false) goto L5;
        String r0 = com.ss.android.deviceregister.d.c.g(this.f15124a);     // Catch: Exception -> L11
        if (com.bytedance.common.utility.h.a(r0) == true) goto L9;
        r0 = r0 + this.c;     // Catch: Exception -> L11
    L9:
        d = r0;     // Catch: Exception -> L11
        return r0;
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return d;
    }

    @Override // com.ss.android.deviceregister.b.a.a
    public JSONArray f() {
        JSONArray r0 = e;
        if (r0 == null) goto L13;
        return r0;
    L13:
        JSONArray r1 = com.ss.android.deviceregister.d.c.j(this.f15124a);     // Catch: Exception -> L10
        if (TextUtils.isEmpty(this.c) == true) goto L8;
        a(r1, this.c);     // Catch: Exception -> L10
    L8:
        e = r1;     // Catch: Exception -> L10
        return r1;
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
