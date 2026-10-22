package r6;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import javax.crypto.spec.SecretKeySpec;
import p.f;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f11532a;

    public b() {
    }

    public static f a(Context r8, String r10, Bundle r11) {
        d r12 = d.b(r8);
        r12.getClass();
        if (TextUtils.isEmpty(r10) == false) goto L5;
        Log.e("a", "query data fail, invalid param!");
        return new f(-2, new ArrayList());
    L5:
        int r13 = r11.getInt("query_mode", 2);
        Log.i("a", "queryData alias:" + r10 + " mode:" + r13);
        Object r14 = r12.f11535b;
        Object r15 = r12.f11536c;
        if (r13 != 2) goto L27;
        Context r16 = (Context) r15;
        a r17 = ((c) r14).a(r10, r16.getPackageName());
        if (r17 != null) goto L11;
        Log.e("a", "precise query data fail, alias: " + r10);
        return new f(-5, new ArrayList());
    L11:
        if (TextUtils.isEmpty(r17.f11527f) == true) goto L17;
        Log.i("d", "getSecretEncKey");
        byte[] r18 = android.support.v4.media.a.e(r16, android.support.v4.media.a.c(r16, "secret_enc_key"), 2, android.support.v4.media.a.f(r17.f11527f));
        if (r18.length != 0) goto L15;
        Log.e("a", "decrypt secret data fail, alias: " + r10);
        return new f(-4, new ArrayList());
    L15:
        r17.f11527f = new String(r18);
    L17:
        if (TextUtils.isEmpty(r17.f11526e) == true) goto L26;
        Log.i("d", "getPrivateEncKey");
        SecretKeySpec r19 = android.support.v4.media.a.f404a;
        if (r19 != null) goto L22;
        r19 = android.support.v4.media.a.c(r16, "private_enc_key");
        android.support.v4.media.a.f404a = r19;
    L22:
        byte[] r20 = android.support.v4.media.a.e(r16, r19, 2, android.support.v4.media.a.f(r17.f11526e));
        if (r20.length != 0) goto L25;
        Log.e("a", "decrypt private data fail, alias: " + r10);
        return new f(-4, new ArrayList());
    L25:
        r17.f11526e = new String(r20);
    L26:
        ArrayList r21 = new ArrayList();
        r21.add(r17);
        return new f(0, r21);
    L27:
        if (r13 != 0) goto L29;
    L32:
        a r22 = ((c) r14).a(r10, ((Context) r15).getPackageName());
        if (r22 != null) goto L35;
        Log.e("a", "query data if exist fail, alias: " + r10);
        return new f(-5, new ArrayList());
    L35:
        ArrayList r23 = new ArrayList();
        r23.add(r22);
        return new f(0, r23);
    L29:
        if (r13 == 1) goto L32;
        Log.e("a", "unsupported query mode: " + r13);
        return new f(-100, new ArrayList());
    }

    public static b b() {
        if (f11532a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11532a != null) goto L9;
        f11532a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f11532a;
    }

    public static void c(Context r8, a r10) {
        d r11 = d.b(r8);
        r11.getClass();
        Log.i("a", "addData alias:" + r10.f11522a);
        if (TextUtils.isEmpty(r10.f11522a) == false) goto L6;
        String r12 = "input data is invalid!!";
    L5:
        Log.e("a", r12);
        return;
    L6:
        String r13 = r10.f11522a;
        c r14 = (c) r11.f11535b;
        Context r15 = (Context) r11.f11536c;
        a r16 = r14.a(r13, r15.getPackageName());
        if (r16 != null) goto L9;
    L12:
        boolean r17 = false;
    L13:
        if (r17 == false) goto L17;
        StringBuilder r18 = new StringBuilder("data already exist, alias: ");
    L15:
        r18.append(r10.f11522a);
        r12 = r18.toString();
        goto L5
    L17:
        if (TextUtils.isEmpty(r10.f11527f) == true) goto L19;
    L23:
        r10 = d.a(r10);
        String r19 = System.currentTimeMillis() + "";
        r10.f11530i = r19;
        r10.f11531j = r19;
        if (TextUtils.isEmpty(r10.f11527f) == true) goto L33;
        if (r10.f11527f.length() <= 4096) goto L28;
        r12 = "input secret data is too long!!";
        goto L5
    L28:
        Log.i("d", "getSecretEncKey");
        byte[] r20 = android.support.v4.media.a.e(r15, android.support.v4.media.a.c(r15, "secret_enc_key"), 1, r10.f11527f.getBytes());
        if (r20.length != 0) goto L31;
        r18 = new StringBuilder("encrypt secret data fail, alias: ");
        goto L15
    L31:
        r10.f11527f = android.support.v4.media.a.a(r20);
    L33:
        if (TextUtils.isEmpty(r10.f11526e) == true) goto L42;
        Log.i("d", "getPrivateEncKey");
        SecretKeySpec r21 = android.support.v4.media.a.f404a;
        if (r21 != null) goto L38;
        r21 = android.support.v4.media.a.c(r15, "private_enc_key");
        android.support.v4.media.a.f404a = r21;
    L38:
        byte[] r22 = android.support.v4.media.a.e(r15, r21, 1, r10.f11526e.getBytes());
        if (r22.length != 0) goto L41;
        r18 = new StringBuilder("encrypt private data fail, alias: ");
        goto L15
    L41:
        r10.f11526e = android.support.v4.media.a.a(r22);
    L42:
        String r23 = r15.getPackageName();
        r14.getClass();
        Log.i("a", "insertData, alias: " + r10.f11522a + ", pkgName: " + r23);
        SQLiteDatabase r24 = r14.getWritableDatabase();
        ContentValues r25 = new ContentValues();
        r25.put("alias", r10.f11522a);
        r25.put("pkg_name", r23);
        r25.put("public_data", r10.f11525d);
        r25.put("private_data", r10.f11526e);
        r25.put("secret_data", r10.f11527f);
        r25.put("data_type", r10.f11523b);
        r25.put("associate", r10.f11524c);
        r25.put("access_limit", "");
        r25.put("auth_limit", "");
        r25.put("sync_limit", 0);
        r25.put("search_info", r10.f11529h);
        r25.put("ext_info", r10.f11528g);
        r25.put("create_time", r10.f11530i);
        r25.put("latest_time", r10.f11531j);
        r25.put("global_id", "");
        r25.put("status", 0);
        r25.put("sync_status", 0);
        long r26 = r24.insert("secret_item", null, r25);
        if (r26 >= 0) goto L46;
        r12 = "insert data fail, ret: " + r26;
        goto L5
    L46:
        return;
    L19:
        if (TextUtils.isEmpty(r10.f11526e) == false) goto L23;
        if (TextUtils.isEmpty(r10.f11525d) == false) goto L23;
        r12 = "input core data is empty!!";
        goto L5
    L9:
        if (TextUtils.isEmpty(r16.f11522a) == true) goto L12;
        r17 = true;
        goto L13
    }

    public static void d(Context r8, a r10) {
        d r11 = d.b(r8);
        r11.getClass();
        if (TextUtils.isEmpty(r10.f11522a) == false) goto L6;
        String r12 = "update data fail, invalid param!";
    L25:
        Log.e("a", r12);
        return;
    L6:
        if (TextUtils.isEmpty(r10.f11527f) == true) goto L8;
    L20:
        a r13 = d.a(r10);
        Log.i("a", "updateData alias:" + r13.f11522a);
        r13.f11531j = System.currentTimeMillis() + "";
        boolean r14 = TextUtils.isEmpty(r13.f11527f);
        Object r15 = r11.f11536c;
        if (r14 == true) goto L31;
        if (r13.f11527f.length() <= 4096) goto L26;
        r12 = "input secret data is too long!!";
        goto L25
    L26:
        Context r16 = (Context) r15;
        Log.i("d", "getSecretEncKey");
        byte[] r17 = android.support.v4.media.a.e(r16, android.support.v4.media.a.c(r16, "secret_enc_key"), 1, r13.f11527f.getBytes());
        if (r17.length != 0) goto L29;
        StringBuilder r18 = new StringBuilder("encrypt secret data fail, alias: ");
    L39:
        r18.append(r13.f11522a);
        r12 = r18.toString();
        goto L25
    L29:
        r13.f11527f = android.support.v4.media.a.a(r17);
    L31:
        if (TextUtils.isEmpty(r13.f11526e) == true) goto L41;
        Context r19 = (Context) r15;
        Log.i("d", "getPrivateEncKey");
        SecretKeySpec r20 = android.support.v4.media.a.f404a;
        if (r20 != null) goto L36;
        r20 = android.support.v4.media.a.c(r19, "private_enc_key");
        android.support.v4.media.a.f404a = r20;
    L36:
        byte[] r21 = android.support.v4.media.a.e(r19, r20, 1, r13.f11526e.getBytes());
        if (r21.length != 0) goto L40;
        r18 = new StringBuilder("encrypt private data fail, alias: ");
        goto L39
    L40:
        r13.f11526e = android.support.v4.media.a.a(r21);
    L41:
        c r22 = (c) r11.f11535b;
        String r23 = ((Context) r15).getPackageName();
        r22.getClass();
        Log.i("a", "updateData, alias: " + r13.f11522a + ", pkgName: " + r23);
        SQLiteDatabase r24 = r22.getWritableDatabase();
        ContentValues r25 = new ContentValues();
        if (TextUtils.isEmpty(r13.f11525d) == true) goto L45;
        r25.put("public_data", r13.f11525d);
    L45:
        if (TextUtils.isEmpty(r13.f11526e) == true) goto L48;
        r25.put("private_data", r13.f11526e);
    L48:
        if (TextUtils.isEmpty(r13.f11527f) == true) goto L51;
        r25.put("secret_data", r13.f11527f);
    L51:
        if (TextUtils.isEmpty(r13.f11523b) == true) goto L54;
        r25.put("data_type", r13.f11523b);
    L54:
        if (TextUtils.isEmpty(r13.f11524c) == true) goto L57;
        r25.put("associate", r13.f11524c);
    L57:
        if (TextUtils.isEmpty(r13.f11528g) == true) goto L60;
        r25.put("ext_info", r13.f11528g);
    L60:
        if (TextUtils.isEmpty(r13.f11529h) == true) goto L63;
        r25.put("search_info", r13.f11529h);
    L63:
        if (TextUtils.isEmpty(r13.f11531j) == true) goto L65;
        r25.put("latest_time", r13.f11531j);
    L65:
        int r26 = r24.update("secret_item", r25, "alias =? AND pkg_name =? ", new String[]{r13.f11522a, r23});
        if (r26 == 1) goto L69;
        r12 = "update data fail, ret: " + r26;
        goto L25
    L69:
        return;
    L8:
        if (TextUtils.isEmpty(r10.f11526e) == false) goto L20;
        if (TextUtils.isEmpty(r10.f11525d) == false) goto L20;
        if (TextUtils.isEmpty(r10.f11528g) == false) goto L20;
        if (TextUtils.isEmpty(r10.f11529h) == false) goto L20;
        if (TextUtils.isEmpty(r10.f11523b) == false) goto L20;
        if (TextUtils.isEmpty(r10.f11524c) == false) goto L20;
        r12 = "all data is empty!!";
        goto L25
    }
}
