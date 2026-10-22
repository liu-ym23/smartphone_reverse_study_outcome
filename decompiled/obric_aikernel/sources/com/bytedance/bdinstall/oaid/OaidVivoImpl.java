package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.util.Singleton;
import com.bytedance.crash.entity.EventBody;

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

    OaidVivoImpl(Context r10) {
    }

    static /* synthetic */ String access$000(String r10, String r11) {
        return getSystemProperties(r10, r11);
    }

    private static String getSystemProperties(String r10, String r11) {
        return SystemProperties.get(r10, r11);
    L7:
        return r11;
    }

    static boolean isSupport() {
        return support.get(new Object[0]).booleanValue();
    }

    @Nullable
    @WorkerThread
    private static String query(@NonNull Context r10, @Type int r11, String r12) {
        String r13 = null;
        r13 = null;
        r13 = null;
        r13 = null;
        r13 = null;
        r13 = null;
        Cursor r14 = null;
        if (r11 != 0) goto L5;
        String r15 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID";
    L13:
        Uri r16 = Uri.parse(r15);
    L14:
        if (r16 != null) goto L57;
    L47:
        return r13;
    L57:
        Cursor r17 = r10.getContentResolver().query(r16, null, null, null, null);     // Catch: Throwable -> L29 Exception -> L31
        if (r17 != null) goto L50;
    L23:
        if (r17 == null) goto L47;
        r17.close();     // Catch: Exception -> L26
    L26:
        e = e;
        e.printStackTrace();
        StringBuilder r18 = new StringBuilder();
    L28:
        r18.append("OaidVivo#query close cursor exception.");
        r18.append(e);
        DrLog.d(r18.toString());
        goto L47
    L50:
    L21:
        e = e;
    L33:
        e.printStackTrace();     // Catch: Throwable -> L39
        DrLog.d("OaidVivo#query" + e);     // Catch: Throwable -> L39
        if (r17 == null) goto L47;
        r17.close();     // Catch: Exception -> L37
    L37:
        e = e;
        e.printStackTrace();
        r18 = new StringBuilder();
    L39:
        th = th;
        r14 = r17;
    L41:
        if (r14 != null) goto L55;
    L46:
        throw th;
    L55:
        r14.close();     // Catch: Exception -> L44
    L44:
        e = move-exception;
        e.printStackTrace();
        DrLog.d("OaidVivo#query close cursor exception." + e);
        goto L46
    L18:
        if (r17.moveToNext() == false) goto L23;
        r13 = r17.getString(r17.getColumnIndex(EventBody.KEY_VALUE));     // Catch: Exception -> L21 Throwable -> L39
        goto L23
    L31:
        e = e;
        r17 = null;
    L29:
        th = th;
        goto L41
    L5:
        if (r11 != 1) goto L7;
        StringBuilder r19 = new StringBuilder();
        String r20 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_";
    L11:
        r19.append(r20);
        r19.append(r12);
        r15 = r19.toString();
        goto L13
    L7:
        if (r11 == 2) goto L9;
        r16 = null;
        goto L14
    L9:
        r19 = new StringBuilder();
        r20 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_";
        goto L11
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Vivo";
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r10) {
        OaidApi.Result r11 = new OaidApi.Result();
        r11.oaid = query(r10, 0, null);
        return r11;
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r10) {
        return isSupport();
    }
}
