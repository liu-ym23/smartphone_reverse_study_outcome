package com.bytedance.crypto.obfuscated;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile j f1501a;

    public j() {
    }

    public static j a() {
        if (f1501a != null) goto L15;
        monitor-enter(j.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1501a != null) goto L9;
        f1501a = new j();     // Catch: Throwable -> L11
    L9:
        monitor-exit(j.class);     // Catch: Throwable -> L11
    L15:
        return f1501a;
    }

    public a a(@NonNull Context r10, @NonNull i r11, Bundle r12) {
        l r13 = l.a(r10);
        r13.getClass();
        Log.i("a", "addData alias:" + r11.f1488a);
        if (TextUtils.isEmpty(r11.f1488a) == false) goto L5;
        Log.e("a", "input data is invalid!!");
        return new a(-2, "");
    L5:
        i r14 = r13.f1504a.a(r11.f1488a, r13.f1505b.getPackageName());
        if (r14 != null) goto L8;
    L11:
        boolean r15 = false;
    L12:
        if (r15 == false) goto L15;
        Log.e("a", "data already exist, alias: " + r11.f1488a);
        return new a(-7, r11.f1488a);
    L15:
        if (TextUtils.isEmpty(r11.f1493f) == true) goto L17;
    L21:
        i r16 = l.a(r11);
        String r17 = System.currentTimeMillis() + "";
        r16.f1499l = r17;
        r16.f1500m = r17;
        if (TextUtils.isEmpty(r16.f1493f) == true) goto L31;
        if (r16.f1493f.length() <= 4096) goto L26;
        Log.e("a", "input secret data is too long!!");
        return new a(-2, r11.f1488a);
    L26:
        Context r18 = r13.f1505b;
        Log.i("d", "getSecretEncKey");
        byte[] r19 = m.a(r13.f1505b, p.a(r18, "secret_enc_key"), 1, r16.f1493f.getBytes());
        if (r19.length != 0) goto L29;
        Log.e("a", "encrypt secret data fail, alias: " + r16.f1488a);
        return new a(-4, r16.f1488a);
    L29:
        r16.f1493f = o.a(r19);
    L31:
        if (TextUtils.isEmpty(r16.f1492e) == true) goto L40;
        Context r110 = r13.f1505b;
        Log.i("d", "getPrivateEncKey");
        SecretKeySpec r20 = p.f1508a;
        if (r20 != null) goto L36;
        r20 = p.a(r110, "private_enc_key");
        p.f1508a = r20;
    L36:
        byte[] r111 = m.a(r13.f1505b, r20, 1, r16.f1492e.getBytes());
        if (r111.length != 0) goto L39;
        Log.e("a", "encrypt private data fail, alias: " + r16.f1488a);
        return new a(-4, r16.f1488a);
    L39:
        r16.f1492e = o.a(r111);
    L40:
        k r112 = r13.f1504a;
        String r21 = r13.f1505b.getPackageName();
        r112.getClass();
        Log.i("a", "insertData, alias: " + r16.f1488a + ", pkgName: " + r21);
        SQLiteDatabase r113 = r112.getWritableDatabase();
        ContentValues r22 = new ContentValues();
        r22.put("alias", r16.f1488a);
        r22.put("pkg_name", r21);
        r22.put("public_data", r16.f1491d);
        r22.put("private_data", r16.f1492e);
        r22.put("secret_data", r16.f1493f);
        r22.put("data_type", r16.f1489b);
        r22.put("associate", r16.f1490c);
        r22.put("access_limit", "");
        r22.put("auth_limit", "");
        r22.put("sync_limit", 0);
        r22.put("search_info", r16.f1495h);
        r22.put("ext_info", r16.f1494g);
        r22.put("create_time", r16.f1499l);
        r22.put("latest_time", r16.f1500m);
        r22.put("global_id", "");
        r22.put("status", 0);
        r22.put("sync_status", 0);
        long r23 = r113.insert("secret_item", null, r22);
        if (r23 >= 0) goto L44;
        Log.e("a", "insert data fail, ret: " + r23);
        return new a(-6, "insert data fail");
    L44:
        return new a(0, r16.f1488a);
    L17:
        if (TextUtils.isEmpty(r11.f1492e) == false) goto L21;
        if (TextUtils.isEmpty(r11.f1491d) == false) goto L21;
        Log.e("a", "input core data is empty!!");
        return new a(-2, r11.f1488a);
    L8:
        if (TextUtils.isEmpty(r14.f1488a) == true) goto L11;
        r15 = true;
        goto L12
    }

    public h a(@NonNull Context r10, String r11, @NonNull Bundle r12) {
        l r13 = l.a(r10);
        r13.getClass();
        if (TextUtils.isEmpty(r11) == false) goto L5;
        Log.e("a", "query data fail, invalid param!");
        return new h(-2, new ArrayList());
    L5:
        int r14 = r12.getInt("query_mode", 2);
        Log.i("a", "queryData alias:" + r11 + " mode:" + r14);
        if (r14 != 2) goto L27;
        i r15 = r13.f1504a.a(r11, r13.f1505b.getPackageName());
        if (r15 != null) goto L11;
        Log.e("a", "precise query data fail, alias: " + r11);
        return new h(-5, new ArrayList());
    L11:
        if (TextUtils.isEmpty(r15.f1493f) == true) goto L17;
        Context r16 = r13.f1505b;
        Log.i("d", "getSecretEncKey");
        byte[] r17 = m.a(r13.f1505b, p.a(r16, "secret_enc_key"), 2, o.a(r15.f1493f));
        if (r17.length != 0) goto L15;
        Log.e("a", "decrypt secret data fail, alias: " + r11);
        return new h(-4, new ArrayList());
    L15:
        r15.f1493f = new String(r17);
    L17:
        if (TextUtils.isEmpty(r15.f1492e) == true) goto L26;
        Context r18 = r13.f1505b;
        Log.i("d", "getPrivateEncKey");
        SecretKeySpec r19 = p.f1508a;
        if (r19 != null) goto L22;
        r19 = p.a(r18, "private_enc_key");
        p.f1508a = r19;
    L22:
        byte[] r20 = m.a(r13.f1505b, r19, 2, o.a(r15.f1492e));
        if (r20.length != 0) goto L25;
        Log.e("a", "decrypt private data fail, alias: " + r11);
        return new h(-4, new ArrayList());
    L25:
        r15.f1492e = new String(r20);
    L26:
        ArrayList r21 = new ArrayList();
        r21.add(r15);
        return new h(0, r21);
    L27:
        if (r14 != 0) goto L29;
    L32:
        i r22 = r13.f1504a.a(r11, r13.f1505b.getPackageName());
        if (r22 != null) goto L35;
        Log.e("a", "query data if exist fail, alias: " + r11);
        return new h(-5, new ArrayList());
    L35:
        ArrayList r23 = new ArrayList();
        r23.add(r22);
        return new h(0, r23);
    L29:
        if (r14 == 1) goto L32;
        Log.e("a", "unsupported query mode: " + r14);
        return new h(-100, new ArrayList());
    }

    public int b(@NonNull Context r10, @NonNull i r11, Bundle r12) {
        l r13 = l.a(r10);
        r13.getClass();
        if (TextUtils.isEmpty(r11.f1488a) == false) goto L7;
        String r14 = "update data fail, invalid param!";
    L5:
        Log.e("a", r14);
        return -2;
    L7:
        if (TextUtils.isEmpty(r11.f1493f) == true) goto L9;
    L21:
        i r15 = l.a(r11);
        Log.i("a", "updateData alias:" + r15.f1488a);
        r15.f1500m = System.currentTimeMillis() + "";
        if (TextUtils.isEmpty(r15.f1493f) == true) goto L32;
        if (r15.f1493f.length() <= 4096) goto L26;
        r14 = "input secret data is too long!!";
        goto L5
    L26:
        Context r16 = r13.f1505b;
        Log.i("d", "getSecretEncKey");
        byte[] r17 = m.a(r13.f1505b, p.a(r16, "secret_enc_key"), 1, r15.f1493f.getBytes());
        if (r17.length != 0) goto L30;
        StringBuilder r18 = new StringBuilder("encrypt secret data fail, alias: ");
    L29:
        r18.append(r15.f1488a);
        Log.e("a", r18.toString());
        return -4;
    L30:
        r15.f1493f = o.a(r17);
    L32:
        if (TextUtils.isEmpty(r15.f1492e) == true) goto L41;
        Context r19 = r13.f1505b;
        Log.i("d", "getPrivateEncKey");
        SecretKeySpec r20 = p.f1508a;
        if (r20 != null) goto L37;
        r20 = p.a(r19, "private_enc_key");
        p.f1508a = r20;
    L37:
        byte[] r21 = m.a(r13.f1505b, r20, 1, r15.f1492e.getBytes());
        if (r21.length != 0) goto L40;
        r18 = new StringBuilder("encrypt private data fail, alias: ");
        goto L29
    L40:
        r15.f1492e = o.a(r21);
    L41:
        k r22 = r13.f1504a;
        String r23 = r13.f1505b.getPackageName();
        r22.getClass();
        Log.i("a", "updateData, alias: " + r15.f1488a + ", pkgName: " + r23);
        SQLiteDatabase r24 = r22.getWritableDatabase();
        ContentValues r25 = new ContentValues();
        if (TextUtils.isEmpty(r15.f1491d) == true) goto L45;
        r25.put("public_data", r15.f1491d);
    L45:
        if (TextUtils.isEmpty(r15.f1492e) == true) goto L48;
        r25.put("private_data", r15.f1492e);
    L48:
        if (TextUtils.isEmpty(r15.f1493f) == true) goto L51;
        r25.put("secret_data", r15.f1493f);
    L51:
        if (TextUtils.isEmpty(r15.f1489b) == true) goto L54;
        r25.put("data_type", r15.f1489b);
    L54:
        if (TextUtils.isEmpty(r15.f1490c) == true) goto L57;
        r25.put("associate", r15.f1490c);
    L57:
        if (TextUtils.isEmpty(r15.f1494g) == true) goto L60;
        r25.put("ext_info", r15.f1494g);
    L60:
        if (TextUtils.isEmpty(r15.f1495h) == true) goto L63;
        r25.put("search_info", r15.f1495h);
    L63:
        if (TextUtils.isEmpty(r15.f1500m) == true) goto L65;
        r25.put("latest_time", r15.f1500m);
    L65:
        int r26 = r24.update("secret_item", r25, "alias =? AND pkg_name =? ", new String[]{r15.f1488a, r23});
        if (r26 == 1) goto L71;
        Log.e("a", "update data fail, ret: " + r26);
        return -6;
    L71:
        return 0;
    L9:
        if (TextUtils.isEmpty(r11.f1492e) == false) goto L21;
        if (TextUtils.isEmpty(r11.f1491d) == false) goto L21;
        if (TextUtils.isEmpty(r11.f1494g) == false) goto L21;
        if (TextUtils.isEmpty(r11.f1495h) == false) goto L21;
        if (TextUtils.isEmpty(r11.f1489b) == false) goto L21;
        if (TextUtils.isEmpty(r11.f1490c) == false) goto L21;
        r14 = "all data is empty!!";
        goto L5
    }
}
