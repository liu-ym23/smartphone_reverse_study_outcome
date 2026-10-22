package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.util.Singleton;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class OaidVivoImpl implements OaidApi {
    private static final String ID_PROPERTY = "persist.sys.identifierid.supported";
    private static final String NOT_SUPPORTED = "0";
    private static final String SUPPORTED = "1";
    private static final int TYPE_AAID = 2;
    private static final int TYPE_OAID = 0;
    private static final int TYPE_VAID = 1;
    private static final Singleton<Boolean> support = null;

    static {
        support = new AnonymousClass1();
    }

    OaidVivoImpl(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ String access$000(String r0, String r1) {
        return getSystemProperties(r0, r1);
    }

    private static String getSystemProperties(String r0, String r1) {
        return SystemProperties.get(r0, r1);
    L7:
        return r1;
    }

    static boolean isSupport() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(support.get(new Object[0]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private static String query(Context r9, int r10, String r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        String r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        Cursor r2 = null;
        if (r10 != 0) goto L5;
        String r13 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID";
    L13:
        Uri r3 = Uri.parse(r13);
    L14:
        if (r3 != null) goto L57;
    L47:
        return r1;
    L57:
        Cursor r14 = ZeusProviderTransform.query(r12.getContentResolver(), r3, null, null, null, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29 Exception -> L31
        if (r14 != null) goto L48;
    L23:
        if (r14 == null) goto L47;
        r14.close();     // Catch: Exception -> L26
    L26:
        e = e;
        e.printStackTrace();
        StringBuilder r15 = new StringBuilder();
    L28:
        DrLog.d(r15.append("OaidVivo#query close cursor exception.").append(e).toString());
        goto L47
    L48:
    L21:
        e = e;
    L33:
        e.printStackTrace();     // Catch: Throwable -> L39
        DrLog.d("OaidVivo#query" + e);     // Catch: Throwable -> L39
        if (r14 == null) goto L47;
        r14.close();     // Catch: Exception -> L37
    L37:
        e = e;
        e.printStackTrace();
        r15 = new StringBuilder();
    L39:
        th = th;
        r2 = r14;
    L41:
        if (r2 != null) goto L53;
    L46:
        throw th;
    L53:
        r2.close();     // Catch: Exception -> L44
    L44:
        e = move-exception;
        e.printStackTrace();
        DrLog.d("OaidVivo#query close cursor exception." + e);
        goto L46
    L18:
        if (r14.moveToNext() == false) goto L23;
        r1 = r14.getString(r14.getColumnIndex(EventBody.KEY_VALUE));     // Catch: Exception -> L21 Throwable -> L39
        goto L23
    L31:
        e = e;
        r14 = null;
    L29:
        th = th;
        goto L41
    L5:
        if (r10 != 1) goto L7;
        StringBuilder r16 = new StringBuilder();
        String r4 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_";
    L11:
        r13 = r16.append(r4).append(r11).toString();
        goto L13
    L7:
        if (r10 == 2) goto L9;
        r3 = null;
        goto L14
    L9:
        r16 = new StringBuilder();
        r4 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_";
        goto L11
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Vivo";
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        OaidApi.Result r4 = new OaidApi.Result();
        r4.oaid = query(r2, 0, null);
        return r4;
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return isSupport();
    }
}
