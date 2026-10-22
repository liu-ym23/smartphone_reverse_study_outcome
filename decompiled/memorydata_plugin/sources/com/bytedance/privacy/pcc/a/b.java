package com.bytedance.privacy.pcc.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.privacy.e.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3044a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SQLiteOpenHelper f3045b;

    static {
    }

    public b(Context r7) {
        final Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        final String r3 = "pcc_channel.db";
        final SQLiteDatabase.CursorFactory r4 = null;
        final int r5 = 3;
        this.f3045b = new AnonymousClass1(this, r2, r3, r4, r5);
    }

    static /* synthetic */ String a() {
        return f3044a;
    }

    public a a(String r9, String r10, String r11, String r12) {
        Cursor r8 = this.f3045b.getReadableDatabase().query("pcc_channel", new String[]{"client_lane_type", "server_lane_type", "final_lane_type"}, "rpdid=? AND rpuid=? AND app_id=? AND svc_id=?", new String[]{r9, r10, r11, r12}, null, null, null);     // Catch: Exception -> L31
        if (r8 != null) goto L38;
    L28:
        if (r8 == null) goto L40;
        r8.close();     // Catch: Exception -> L31
        return null;
    L40:
        return null;
    L38:
    L21:
        th = move-exception;
        if (r8 != null) goto L36;
    L27:
        throw th;     // Catch: Exception -> L31
    L36:
        r8.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L31
        goto L27
    L6:
        if (r8.moveToFirst() == false) goto L28;
        int r13 = r8.getColumnIndex("client_lane_type");     // Catch: Throwable -> L21
        int r14 = r8.getColumnIndex("server_lane_type");     // Catch: Throwable -> L21
        int r15 = r8.getColumnIndex("final_lane_type");     // Catch: Throwable -> L21
        if (r13 == (-1)) goto L28;
        if (r14 == (-1)) goto L28;
        if (r15 == (-1)) goto L28;
        if (r8.isNull(r13) == true) goto L28;
        if (r8.isNull(r14) == true) goto L28;
        if (r8.isNull(r15) == true) goto L28;
        a r16 = new a(r8.getInt(r13), r8.getInt(r14), r8.getInt(r15));     // Catch: Throwable -> L21
        if (r8 == null) goto L20;
        r8.close();     // Catch: Exception -> L31
    L20:
        return r16;
    L31:
        e = move-exception;
        c.d(f3044a, "getLaneTypeInfo exception: " + e.getMessage());
        return null;
    }

    public boolean a(String r8, String r9, String r10, String r11, com.bytedance.privacy.pcc.b.a.c r12) {
        SQLiteDatabase r7 = this.f3045b.getWritableDatabase();     // Catch: Exception -> L18
        if (r12.a() == null) goto L6;
        String r1 = r12.a().b();     // Catch: Exception -> L18
    L8:
        if (r12.b() == null) goto L10;
        String r3 = r12.b().b();     // Catch: Exception -> L18
    L11:
        ContentValues r4 = new ContentValues();     // Catch: Exception -> L18
        r4.put("rpdid", r8);     // Catch: Exception -> L18
        r4.put("rpuid", r9);     // Catch: Exception -> L18
        r4.put("access_token", r12.c());     // Catch: Exception -> L18
        r4.put("service_info", r1);     // Catch: Exception -> L18
        r4.put("evidence_info", r3);     // Catch: Exception -> L18
        r4.put("created_at", Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L18
        r4.put("app_id", r10);     // Catch: Exception -> L18
        r4.put("svc_id", r11);     // Catch: Exception -> L18
        if (r7.insert("key_attestation_history", null, r4) != (-1)) goto L15;
        c.d(f3044a, "saveKeyAttestationHistory: insert returned -1");     // Catch: Exception -> L18
        return false;
    L15:
        r7.execSQL("DELETE FROM key_attestation_history WHERE id NOT IN (  SELECT id  FROM key_attestation_history  ORDER BY created_at DESC  LIMIT 1000)");     // Catch: Exception -> L18
        c.b(f3044a, "saveKeyAttestationHistory success: rpdid=" + r8 + " rpuid=" + r9 + " appId=" + r10 + " svcId=" + r11);     // Catch: Exception -> L18
        return true;
    L10:
        r3 = null;
        goto L11
    L6:
        r1 = null;
    L18:
        e = move-exception;
        c.d(f3044a, "saveKeyAttestationHistory exception: " + e.getMessage());
        return false;
    }

    public boolean a(String r6, String r7, String r8, String r9, com.bytedance.privacy.pcc.b.a.c r10, int r11, a r12) {
    L18:
        e = move-exception;
        c.d(f3044a, "save exception: " + e.getMessage());
        return false;
    L4:
        String r2 = "";
        if (r10.a() == null) goto L7;
        String r1 = r10.a().b();     // Catch: Exception -> L18
    L9:
        if (r10.b() == null) goto L11;
        r2 = r10.b().b();     // Catch: Exception -> L18
    L11:
        ContentValues r3 = new ContentValues();     // Catch: Exception -> L18
        r3.put("rpdid", r6);     // Catch: Exception -> L18
        r3.put("rpuid", r7);     // Catch: Exception -> L18
        r3.put("app_id", r8);     // Catch: Exception -> L18
        r3.put("svc_id", r9);     // Catch: Exception -> L18
        r3.put("access_token", r10.c());     // Catch: Exception -> L18
        r3.put(WsConstants.KEY_CHANNEL_ID, r10.d());     // Catch: Exception -> L18
        r3.put("channel_expiry_time", r10.e());     // Catch: Exception -> L18
        r3.put("service_info", r1);     // Catch: Exception -> L18
        r3.put("evidence_info", r2);     // Catch: Exception -> L18
        r3.put("payload_json", r10.f());     // Catch: Exception -> L18
        r3.put("response_id", r10.g());     // Catch: Exception -> L18
        r3.put("signature", r10.h());     // Catch: Exception -> L18
        r3.put("protocol_version", Integer.valueOf(r11));     // Catch: Exception -> L18
        r3.put("client_lane_type", Integer.valueOf(r12.f3042a));     // Catch: Exception -> L18
        r3.put("server_lane_type", Integer.valueOf(r12.f3043b));     // Catch: Exception -> L18
        r3.put("final_lane_type", Integer.valueOf(r12.c));     // Catch: Exception -> L18
        if (this.f3045b.getWritableDatabase().insertWithOnConflict("pcc_channel", null, r3, 5) != (-1)) goto L15;
        c.d(f3044a, "save: insertWithOnConflict returned -1");     // Catch: Exception -> L18
        return false;
    L15:
        c.b(f3044a, "save success: rpdid=" + r6 + " appId=" + r8 + " svcId=" + r9 + " protocolVersion=" + r11 + " " + r12);     // Catch: Exception -> L18
        return true;
    L7:
        r1 = "";
        goto L9
    }

    public int b(String r5, String r6, String r7, String r8) {
        int r4 = this.f3045b.getWritableDatabase().delete("pcc_channel", "app_id=? AND svc_id=? AND (rpdid!=? OR rpuid!=?)", new String[]{r7, r8, r5, r6});     // Catch: Exception -> L5
        c.b(f3044a, "deleteOtherRpuidChannels: deleted " + r4 + " rows for appId=" + r7 + " svcId=" + r8 + " (keeping rpdid=" + r5 + " rpuid=" + r6 + ")");     // Catch: Exception -> L5
        return r4;
    L5:
        e = move-exception;
        c.d(f3044a, "deleteOtherRpuidChannels exception: " + e.getMessage());
        return 0;
    }

    public int delete(String r5, String r6, String r7, String r8) {
        int r4 = this.f3045b.getWritableDatabase().delete("pcc_channel", "rpdid=? AND rpuid=? AND app_id=? AND svc_id=?", new String[]{r5, r6, r7, r8});     // Catch: Exception -> L5
        c.b(f3044a, "delete: deleted " + r4 + " rows for rpdid=" + r5 + " rpuid=" + r6 + " appId=" + r7 + " svcId=" + r8);     // Catch: Exception -> L5
        return r4;
    L5:
        e = move-exception;
        c.d(f3044a, "delete exception: " + e.getMessage());
        return 0;
    }

    public com.bytedance.privacy.pcc.b.a.c query(String r10, String r11, String r12, String r13) {
        Cursor r9 = this.f3045b.getReadableDatabase().query("pcc_channel", null, "rpdid=? AND rpuid=? AND app_id=? AND svc_id=?", new String[]{r10, r11, r12, r13}, null, null, null);     // Catch: Exception -> L21
        if (r9 != null) goto L28;
    L18:
        if (r9 == null) goto L30;
        r9.close();     // Catch: Exception -> L21
        return null;
    L30:
        return null;
    L28:
    L11:
        th = move-exception;
        if (r9 != null) goto L26;
    L17:
        throw th;     // Catch: Exception -> L21
    L26:
        r9.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L21
        goto L17
    L6:
        if (r9.moveToFirst() == false) goto L18;
        com.bytedance.privacy.pcc.b.a.c r14 = com.bytedance.privacy.pcc.b.a.c.a(r9.getString(r9.getColumnIndexOrThrow("service_info")), r9.getString(r9.getColumnIndexOrThrow("evidence_info")), r9.getString(r9.getColumnIndexOrThrow("access_token")), r9.getString(r9.getColumnIndexOrThrow(WsConstants.KEY_CHANNEL_ID)), r9.getString(r9.getColumnIndexOrThrow("channel_expiry_time")), r9.getString(r9.getColumnIndexOrThrow("payload_json")), r9.getString(r9.getColumnIndexOrThrow("response_id")), r9.getString(r9.getColumnIndexOrThrow("signature")), r9.getInt(r9.getColumnIndexOrThrow("protocol_version")));     // Catch: Throwable -> L11
        if (r9 == null) goto L10;
        r9.close();     // Catch: Exception -> L21
    L10:
        return r14;
    L21:
        e = move-exception;
        c.d(f3044a, "query exception: " + e.getMessage());
        return null;
    }
}
