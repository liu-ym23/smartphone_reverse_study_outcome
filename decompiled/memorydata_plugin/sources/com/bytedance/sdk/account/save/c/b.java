package com.bytedance.sdk.account.save.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.ss.android.account.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.account.save.c.a f3155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SQLiteDatabase f3156b;

    /* JADX INFO: renamed from: com.bytedance.sdk.account.save.c.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f3157a = null;

        static {
            f3157a = new b(null);
        }
    }

    private b() {
        this.f3155a = new com.bytedance.sdk.account.save.c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a().b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        this.f3156b = null;
    }

    /* synthetic */ b(AnonymousClass1 r1) {
        this();
    }

    public static b a() {
        return a.f3157a;
    }

    private void a(StringBuilder r1, String r2) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.length() <= 0) goto L7;
        r1.append(" and ");
    L7:
        r1.append(r2).append(" = ?");
    }

    public com.bytedance.sdk.account.save.entity.c a(int r39, Long r40, Integer r41, String r42, Long r43) {
        if (b() == true) goto L5;
        return null;
    L5:
        String[] r17 = {OaidModel.KEY_TIME, "type", "info", "uid", "avatar_url", "screen_name", "platform_avatar_url", "platform_screen_name", "sec_uid", "ext"};
        StringBuilder r3 = new StringBuilder();
        if (r39 == 1) goto L59;
        if (r39 != 2) goto L9;
        r3.append(OaidModel.KEY_TIME).append(" in (select min(").append(OaidModel.KEY_TIME).append(") from ").append("login_info").append(")");     // Catch: Throwable -> L53 Exception -> L55
        Cursor r0 = this.f3156b.query("login_info", r17, r3.toString(), null, null, null, null);     // Catch: Throwable -> L53 Exception -> L55
    L60:
        Cursor r1 = r0;
    L61:
        if (r1 != null) goto L87;
    L73:
        Cursor r4 = r1;
        com.bytedance.sdk.account.save.entity.c r2 = null;
    L74:
        if (r4 == null) goto L93;
        r4.close();
        return r2;
    L93:
        return r2;
    L87:
    L71:
        e = e;
        Cursor r5 = r1;
    L57:
        com.bytedance.sdk.account.save.entity.c r24 = null;
    L85:
        e.printStackTrace();     // Catch: Throwable -> L81
        if (r5 == null) goto L80;
        r5.close();
    L80:
        return r24;
    L81:
        th = th;
    L82:
        if (r5 == null) goto L84;
        r5.close();
    L84:
        throw th;
    L69:
        th = th;
        r5 = r1;
        goto L82
    L63:
        if (r1.getCount() <= 0) goto L73;
        r1.moveToFirst();     // Catch: Throwable -> L69 Exception -> L71
        r2 = new com.bytedance.sdk.account.save.entity.c(r1.getLong(0), r1.getInt(1), r1.getString(2), r1.getLong(3), r1.getString(8), r1.getString(4), r1.getString(5), r1.getString(6), r1.getString(7), com.bytedance.sdk.account.save.entity.b.a(r1.getString(9)));     // Catch: Throwable -> L69 Exception -> L71
        r1.close();     // Catch: Exception -> L67 Throwable -> L69
        r4 = null;
        goto L74
    L67:
        e = e;
        r5 = r1;
        r24 = r2;
        goto L85
    L9:
        if (r39 == 3) goto L36;
        if (r39 != 4) goto L51;
        ArrayList r6 = new ArrayList();     // Catch: Throwable -> L53 Exception -> L55
        if (r40 == null) goto L15;
        a(r3, OaidModel.KEY_TIME);     // Catch: Throwable -> L53 Exception -> L55
        r6.add(String.valueOf(r40));     // Catch: Throwable -> L53 Exception -> L55
    L15:
        if (r41 == null) goto L17;
        a(r3, "type");     // Catch: Throwable -> L53 Exception -> L55
        r6.add(String.valueOf(r41));     // Catch: Throwable -> L53 Exception -> L55
    L17:
        if (r43 != null) goto L19;
    L21:
        if (r42 != null) goto L23;
    L35:
        r0 = this.f3156b.query("login_info", r17, r3.toString(), (String[]) ZeusTransformUtils.preCheckCast(r6.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"), null, null, "time desc", "0,1");     // Catch: Throwable -> L53 Exception -> L55
        goto L60
    L23:
        if (r42.length() == 0) goto L35;
        String[] r7 = r42.split("\\*");     // Catch: Throwable -> L53 Exception -> L55
        StringBuilder r8 = new StringBuilder();     // Catch: Throwable -> L53 Exception -> L55
        int r9 = r7.length;     // Catch: Throwable -> L53 Exception -> L55
        if (r9 == 0) goto L51;
        int r13 = 0;
    L29:
        if (r13 >= r9) goto L31;
        r8.append("%");     // Catch: Throwable -> L53 Exception -> L55
        r8.append(r7[r13]);     // Catch: Throwable -> L53 Exception -> L55
        r13 = r13 + 1;     // Catch: Throwable -> L53 Exception -> L55
        goto L29
    L31:
        r8.append("%");     // Catch: Throwable -> L53 Exception -> L55
        if (r3.length() <= 0) goto L34;
        r3.append(" and ");     // Catch: Throwable -> L53 Exception -> L55
    L34:
        r3.append("info").append(" like ? ");     // Catch: Throwable -> L53 Exception -> L55
        r6.add(r8.toString());     // Catch: Throwable -> L53 Exception -> L55
        goto L35
    L19:
        if (r43.longValue() <= 0) goto L21;
        a(r3, "uid");     // Catch: Throwable -> L53 Exception -> L55
        r6.add(String.valueOf(r43));     // Catch: Throwable -> L53 Exception -> L55
    L51:
        r1 = null;
        goto L61
    L36:
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L53 Exception -> L55
        if (r40 == null) goto L39;
        a(r3, OaidModel.KEY_TIME);     // Catch: Throwable -> L53 Exception -> L55
        r10.add(String.valueOf(r40));     // Catch: Throwable -> L53 Exception -> L55
    L39:
        if (r41 == null) goto L41;
        a(r3, "type");     // Catch: Throwable -> L53 Exception -> L55
        r10.add(String.valueOf(r41));     // Catch: Throwable -> L53 Exception -> L55
    L41:
        if (r42 != null) goto L43;
    L45:
        if (r43 == null) goto L50;
        if (r43.longValue() <= 0) goto L50;
        a(r3, "uid");     // Catch: Throwable -> L53 Exception -> L55
        r10.add(String.valueOf(r43));     // Catch: Throwable -> L53 Exception -> L55
    L50:
        if (r3.length() == 0) goto L51;
        r0 = this.f3156b.query("login_info", r17, r3.toString(), (String[]) ZeusTransformUtils.preCheckCast(r10.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"), null, null, "time desc", "0,1");     // Catch: Throwable -> L53 Exception -> L55
        goto L60
    L43:
        if (r42.length() == 0) goto L45;
        a(r3, "info");     // Catch: Throwable -> L53 Exception -> L55
        r10.add(r42);     // Catch: Throwable -> L53 Exception -> L55
        goto L45
    L59:
        r3.append(OaidModel.KEY_TIME).append(" in (select max(").append(OaidModel.KEY_TIME).append(") from ").append("login_info").append(")");     // Catch: Throwable -> L53 Exception -> L55
        r0 = this.f3156b.query("login_info", r17, r3.toString(), null, null, null, null);     // Catch: Throwable -> L53 Exception -> L55
    L55:
        e = e;
        r5 = null;
    L53:
        th = th;
        r5 = null;
        goto L82
    }

    public com.bytedance.sdk.account.save.entity.c a(int r7, String r8, long r9) {
        return a(3, null, Integer.valueOf(r7), r8, Long.valueOf(r9));
    }

    public void a(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        c();     // Catch: Throwable -> L5 Exception -> L7
        r4.a();     // Catch: Throwable -> L5 Exception -> L7
        e();     // Catch: Throwable -> L5 Exception -> L7
    L9:
        d();
        r4.b();
        return;
    L5:
        th = move-exception;
        d();
        r4.b();
        throw th;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        goto L9
    }

    public boolean a(int r5) {
        if (b() == true) goto L6;
        return false;
    L6:
        if (this.f3156b.delete("login_info", "type = ?", new String[]{String.valueOf(r5)}) != 0) goto L8;
        return false;
    L8:
        return true;
    }

    public boolean a(long r4) {
        if (b() == true) goto L6;
        return false;
    L6:
        if (this.f3156b.delete("login_info", "time = ?", new String[]{String.valueOf(r4)}) != 0) goto L8;
        return false;
    L8:
        return true;
    }

    public boolean a(String r5) {
        if (b() == false) goto L10;
        if (r5 != null) goto L7;
        return false;
    L7:
        if (this.f3156b.delete("login_info", "info = ?", new String[]{r5}) != 0) goto L9;
        return false;
    L9:
        return true;
    L10:
        return false;
    }

    public boolean a(String r5, String r6) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r6) == false) goto L7;
        return false;
    L7:
        if (b() == false) goto L16;
        ContentValues r0 = new ContentValues();
        r0.put("sec_uid", r6);
        if (this.f3156b.update("login_info", r0, "uid = ?", new String[]{r5}) != 0) goto L12;
        return false;
    L12:
        return true;
    L16:
        return false;
    }

    public boolean b() {
        SQLiteDatabase r0 = this.f3156b;     // Catch: Exception -> L11
        if (r0 != null) goto L5;
    L7:
        com.bytedance.sdk.account.save.c.a r1 = this.f3155a;     // Catch: Exception -> L11
        if (r1 == null) goto L17;
        this.f3156b = r1.getWritableDatabase();     // Catch: Exception -> L11
        return true;
    L17:
        return false;
    L5:
        if (r0.isOpen() == false) goto L7;
        return true;
    L11:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public void c() {
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (b() == false) goto L11;
        this.f3156b.beginTransaction();     // Catch: Exception -> L6
        return;
    }

    public void d() {
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (b() == true) goto L5;
        return;
    L5:
        if (this.f3156b.inTransaction() == false) goto L14;
        this.f3156b.endTransaction();     // Catch: Exception -> L8
        return;
    }

    public boolean delete(int r4, Object r5) {
        if (b() == true) goto L6;
        return false;
    L6:
        if (r4 == 1) goto L31;
        if (r4 == 2) goto L29;
        if (r4 != 3) goto L12;
        if (r5 != null) goto L27;
        return false;
    L27:
        return a(((Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.memorydata.plugin")).longValue());
    L12:
        if (r4 != 4) goto L14;
        if (r5 != null) goto L23;
        return false;
    L23:
        return a(((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.memorydata.plugin")).intValue());
    L14:
        if (r4 == 5) goto L16;
        return false;
    L16:
        if (r5 != null) goto L19;
        return false;
    L19:
        return a((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin"));
    L29:
        return f();
    L31:
        return g();
    }

    public void e() {
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (b() == true) goto L5;
        return;
    L5:
        if (this.f3156b.inTransaction() == false) goto L14;
        this.f3156b.setTransactionSuccessful();     // Catch: Exception -> L8
        return;
    }

    public boolean f() {
        if (b() == true) goto L6;
        return false;
    L6:
        if (this.f3156b.delete("login_info", "time in (select min(time) from login_info)", null) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean g() {
        if (b() == true) goto L6;
        return false;
    L6:
        if (this.f3156b.delete("login_info", "time in (select max(time) from login_info)", null) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public int h() {
        if (b() == true) goto L6;
        return -1;
    L6:
        int r1 = 0;
        Cursor r2 = null;
        Cursor r3 = this.f3156b.rawQuery("select count(*) from login_info", null);     // Catch: Throwable -> L21 Exception -> L23
        if (r3 != null) goto L35;
        r2 = r3;
    L19:
        if (r2 == null) goto L31;
    L20:
        r2.close();
    L31:
        return r1;
    L35:
        r3.moveToFirst();     // Catch: Throwable -> L14 Exception -> L16
        if (r3.getCount() <= 0) goto L12;
        r1 = r3.getInt(0);     // Catch: Throwable -> L14 Exception -> L16
    L12:
        r3.close();     // Catch: Throwable -> L14 Exception -> L16
    L16:
        e = e;
        r2 = r3;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L21
        if (r2 == null) goto L31;
    L14:
        th = th;
        r2 = r3;
    L28:
        if (r2 == null) goto L30;
        r2.close();
    L30:
        throw th;
    L21:
        th = th;
    L23:
        e = e;
        goto L24
    }

    public boolean insert(com.bytedance.sdk.account.save.entity.c r7) {
        if (b() == true) goto L5;
        return false;
    L5:
        if (com.bytedance.sdk.account.save.entity.d.a(r7.getType()) == true) goto L7;
        return false;
    L7:
        if (r7.b() != null) goto L9;
        return false;
    L9:
        if (r7.b().length() != 0) goto L11;
        return false;
    L11:
        if (r7.c() > 0) goto L13;
        return false;
    L13:
        if (TextUtils.isEmpty(r7.d()) == false) goto L15;
        return false;
    L15:
        if (TextUtils.isEmpty(r7.e()) == true) goto L28;
        ContentValues r0 = new ContentValues();
        r0.put(OaidModel.KEY_TIME, Long.valueOf(r7.a()));
        r0.put("type", Integer.valueOf(r7.getType()));
        r0.put("info", r7.b());
        r0.put("uid", Long.valueOf(r7.c()));
        r0.put("avatar_url", r7.d());
        r0.put("screen_name", r7.e());
        r0.put("platform_avatar_url", r7.f());
        r0.put("platform_screen_name", r7.g());
        r0.put("sec_uid", r7.h());
        r0.put("ext", com.bytedance.sdk.account.save.entity.b.a(r7.i()));
        if (this.f3156b.insert("login_info", null, r0) == (-1)) goto L27;
        return true;
    L27:
        return false;
    L28:
        return false;
    }

    public boolean update(com.bytedance.sdk.account.save.entity.c r8) {
        if (b() == true) goto L5;
        return false;
    L5:
        if (com.bytedance.sdk.account.save.entity.d.a(r8.getType()) == true) goto L7;
        return false;
    L7:
        if (r8.b() != null) goto L9;
        return false;
    L9:
        if (r8.b().length() != 0) goto L11;
        return false;
    L11:
        if (r8.c() <= 0) goto L52;
        ContentValues r0 = new ContentValues();
        if (r8.a() <= 0) goto L17;
        r0.put(OaidModel.KEY_TIME, Long.valueOf(r8.a()));
    L17:
        if (com.bytedance.sdk.account.save.entity.d.a(r8.getType()) == false) goto L20;
        r0.put("type", Integer.valueOf(r8.getType()));
    L20:
        if (TextUtils.isEmpty(r8.b()) == true) goto L23;
        r0.put("info", r8.b());
    L23:
        if (r8.c() <= 0) goto L26;
        r0.put("uid", Long.valueOf(r8.c()));
    L26:
        if (TextUtils.isEmpty(r8.d()) == true) goto L29;
        r0.put("avatar_url", r8.d());
    L29:
        if (TextUtils.isEmpty(r8.e()) == true) goto L32;
        r0.put("screen_name", r8.e());
    L32:
        if (TextUtils.isEmpty(r8.f()) == true) goto L35;
        r0.put("platform_avatar_url", r8.f());
    L35:
        if (TextUtils.isEmpty(r8.g()) == true) goto L38;
        r0.put("platform_screen_name", r8.g());
    L38:
        if (TextUtils.isEmpty(r8.h()) == true) goto L40;
        r0.put("sec_uid", r8.h());
    L40:
        String r2 = com.bytedance.sdk.account.save.entity.b.a(r8.i());
        if (TextUtils.isEmpty(r2) == true) goto L44;
        r0.put("ext", r2);
    L44:
        if (this.f3156b.update("login_info", r0, "type = ? and info = ? and uid = ?", new String[]{String.valueOf(r8.getType()), r8.b(), String.valueOf(r8.c())}) != 0) goto L46;
        return false;
    L46:
        return true;
    L52:
        return false;
    }
}
