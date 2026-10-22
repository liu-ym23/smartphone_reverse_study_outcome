package com.ss.android.deviceregister.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
final class r implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.ss.android.deviceregister.d.f<Boolean> f15146a = null;

    static {
        f15146a = new AnonymousClass1();
    }

    r() {
    }

    static /* synthetic */ String a(String r0, String r1) {
        return b(r0, r1);
    }

    static boolean a() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(f15146a.c(new Object[0]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private static String b(String r0, String r1) {
        return SystemProperties.get(r0, r1);
    L7:
        return r1;
    }

    private static String query(Context r9, int r10, String r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        String r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        Cursor r2 = null;
        r1 = null;
        if (r10 != 0) goto L5;
        String r13 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID";
    L13:
        Uri r3 = Uri.parse(r13);
    L51:
        if (r3 != null) goto L53;
    L44:
        return r1;
    L53:
        Cursor r14 = ZeusProviderTransform.query(r12.getContentResolver(), r3, null, null, null, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28 Exception -> L30
        if (r14 != null) goto L45;
    L23:
        if (r14 == null) goto L44;
        r14.close();     // Catch: Exception -> L26
    L50:
        goto L44
    L45:
    L21:
        e = e;
    L32:
        e.printStackTrace();     // Catch: Throwable -> L36
        com.ss.android.deviceregister.l.b(com.ss.android.deviceregister.l.f15219a, "OaidVivo#query", e);     // Catch: Throwable -> L36
        if (r14 == null) goto L44;
        r14.close();     // Catch: Exception -> L26
    L36:
        th = th;
        r2 = r14;
    L38:
        if (r2 != null) goto L47;
    L43:
        throw th;
    L47:
        r2.close();     // Catch: Exception -> L41
    L41:
        e = move-exception;
        e.printStackTrace();
        com.ss.android.deviceregister.l.b(com.ss.android.deviceregister.l.f15219a, "OaidVivo#query close cursor exception.", e);
        goto L43
    L18:
        if (r14.moveToNext() == false) goto L23;
        r1 = r14.getString(r14.getColumnIndex(EventBody.KEY_VALUE));     // Catch: Exception -> L21 Throwable -> L36
        goto L23
    L30:
        e = e;
        r14 = null;
    L28:
        th = th;
    L26:
        e = move-exception;
        e.printStackTrace();
        com.ss.android.deviceregister.l.b(com.ss.android.deviceregister.l.f15219a, "OaidVivo#query close cursor exception.", e);
        goto L44
    L5:
        if (r10 != 1) goto L7;
        StringBuilder r15 = new StringBuilder();
        String r4 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_";
    L11:
        r13 = r15.append(r4).append(r11).toString();
        goto L13
    L7:
        if (r10 == 2) goto L9;
        r3 = null;
        goto L51
    L9:
        r15 = new StringBuilder();
        r4 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_";
        goto L11
    }

    @Override // com.ss.android.deviceregister.a.n
    public boolean b(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return a();
    }

    @Override // com.ss.android.deviceregister.a.n
    public n.a c(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        n.a r4 = new n.a();
        r4.f15141a = query(r2, 0, null);
        return r4;
    }
}
