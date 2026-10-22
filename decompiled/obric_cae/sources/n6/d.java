package n6;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.obric.security.secretdata.QueryResult;
import com.obric.security.secretdata.SecretData;
import com.obric.security.secretdata.SecretDataManager;
import java.security.SecureRandom;
import java.util.List;
import p.f;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f9459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f9460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f9461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f9462e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f9463f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f9464g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f9465h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f9466i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f9467j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f9468k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f9469l;

    public d() {
        this.f9458a = true;
        this.f9461d = 0;
        this.f9463f = -1;
        this.f9466i = false;
        this.f9467j = false;
        this.f9468k = -1;
    }

    public static void a(Context r8, String r10) {
        int r11 = SecretDataManager.getInstance().deleteData(r8, r10, new Bundle());
        if (r11 == 0) goto L6;
        l6.a.H("SensitiveData", "delete sessionEncryptKey failed, code: " + r11);
        return;
    }

    public final void b(Context r17, String r18, String r19) {
        Bundle r8 = new Bundle();     // Catch: Exception -> L34
        r8.putInt("query_mode", 2);     // Catch: Exception -> L34
        QueryResult r10 = SecretDataManager.getInstance().queryData(r17, r18, r8);     // Catch: Exception -> L34
        if (r10.getResultCode() != (-5)) goto L7;
    L32:
        l6.a.W("SensitiveData", "bd sessionEncryptKey info not exist");     // Catch: Exception -> L34
        return;
    L7:
        if (r10.getDataList().isEmpty() == true) goto L32;
        this.f9466i = true;     // Catch: Exception -> L34
        if (((SecretData) r10.getDataList().get(0)).secretData.isEmpty() == false) goto L13;
        l6.a.W("SensitiveData", "bd sessionEncryptKey exist, but get secretData failed!");     // Catch: Exception -> L34
        return;
    L13:
        SecretData r11 = (SecretData) r10.getDataList().get(0);     // Catch: Exception -> L34
        byte[] r12 = s6.b.b(r11.secretData);     // Catch: Exception -> L34
        this.f9460c = r12;     // Catch: Exception -> L34
        if (r12.length != 0) goto L17;
        l6.a.W("SensitiveData", "bd sessionEncryptKey exist, but get key failed!");     // Catch: Exception -> L34
        return;
    L17:
        this.f9465h = s6.b.b(r11.extInfo);     // Catch: Exception -> L34
        this.f9463f = Long.parseLong(r11.searchInfo);     // Catch: Exception -> L34
        this.f9461d = Long.parseLong(r11.publicData);     // Catch: Exception -> L34
        if (s6.a.a(r19) == false) goto L20;
        String r13 = s6.a.b(r19);     // Catch: Exception -> L34
    L21:
        l6.a.W("SensitiveData", "bd sessionEncryptKey pkgName:" + r13);     // Catch: Exception -> L34
        this.f9464g = e.h(r13.getBytes());     // Catch: Exception -> L34
        s6.b.a(this.f9465h);     // Catch: Exception -> L34
        s6.b.a(this.f9464g);     // Catch: Exception -> L34
        e(this.f9460c);     // Catch: Exception -> L34
        String r14 = "old_" + r18;     // Catch: Exception -> L34
        Bundle r15 = new Bundle();     // Catch: Exception -> L34
        r15.putInt("query_mode", 2);     // Catch: Exception -> L34
        QueryResult r16 = SecretDataManager.getInstance().queryData(r17, r14, r15);     // Catch: Exception -> L34
        if (r16.getResultCode() != (-5)) goto L24;
        return;
    L24:
        if (r16.getDataList().isEmpty() == true) goto L43;
        SecretData r20 = (SecretData) r16.getDataList().get(0);     // Catch: Exception -> L34
        if ((System.currentTimeMillis() - Long.parseLong(r20.publicData)) <= 172800000) goto L30;
        d(r17, r14);     // Catch: Exception -> L34
        l6.a.W("SensitiveData", "old bd sessionEncryptKey info is expired");     // Catch: Exception -> L34
        this.f9467j = false;     // Catch: Exception -> L34
        return;
    L30:
        this.f9467j = true;     // Catch: Exception -> L34
        this.f9469l = s6.b.b(r20.secretData);     // Catch: Exception -> L34
        this.f9468k = Long.parseLong(r20.searchInfo);     // Catch: Exception -> L34
        l6.a.b1("old key load, key version: " + this.f9468k);     // Catch: Exception -> L34
        return;
    L43:
        return;
    L20:
        r13 = r17.getPackageName();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        if ((e instanceof c) == false) goto L40;
        throw ((c) e);
    L40:
        throw new c("initSessionEncryptKey failed", e);
    }

    public final void c(Context r8, String r10, String r11) {
    L23:
        e = move-exception;
        if ((e instanceof c) == false) goto L29;
        throw ((c) e);
    L29:
        throw new c("saveDeviceShareKey failed, ", e);
    L4:
        if (s6.a.a(r11) == false) goto L6;
        String r12 = s6.a.b(r11);     // Catch: Exception -> L23
    L7:
        l6.a.W("SensitiveData", "bdSaveDeviceShareKey pkgName:" + r12);     // Catch: Exception -> L23
        this.f9464g = e.h(r12.getBytes());     // Catch: Exception -> L23
        e(this.f9460c);     // Catch: Exception -> L23
        SecretData r13 = new SecretData();     // Catch: Exception -> L23
        r13.alias = r10;     // Catch: Exception -> L23
        r13.secretData = s6.b.a(this.f9460c);     // Catch: Exception -> L23
        r13.publicData = String.valueOf(this.f9461d);     // Catch: Exception -> L23
        r13.searchInfo = String.valueOf(this.f9463f);     // Catch: Exception -> L23
        r13.extInfo = s6.b.a(this.f9465h);     // Catch: Exception -> L23
        if (this.f9466i == false) goto L10;
        SecretDataManager.getInstance().updateData(r8, r13, new Bundle());     // Catch: Exception -> L23
    L11:
        long r14 = this.f9468k;     // Catch: Exception -> L23
        if (r14 < this.f9463f) goto L14;
        return;
    L14:
        if (r14 > (-1)) goto L16;
        return;
    L16:
        if (this.f9469l == null) goto L34;
        SecretData r15 = new SecretData();     // Catch: Exception -> L23
        r15.alias = "old_" + r10;     // Catch: Exception -> L23
        r15.secretData = s6.b.a(this.f9469l);     // Catch: Exception -> L23
        r15.searchInfo = String.valueOf(this.f9468k);     // Catch: Exception -> L23
        r15.publicData = String.valueOf(System.currentTimeMillis());     // Catch: Exception -> L23
        if (this.f9467j == false) goto L20;
        SecretDataManager.getInstance().updateData(r8, r15, new Bundle());     // Catch: Exception -> L23
    L21:
        this.f9467j = true;     // Catch: Exception -> L23
        return;
    L20:
        SecretDataManager.getInstance().addData(r8, r15, new Bundle());     // Catch: Exception -> L23
        goto L21
    L34:
        return;
    L10:
        SecretDataManager.getInstance().addData(r8, r13, new Bundle());     // Catch: Exception -> L23
        goto L11
    L6:
        r12 = r8.getPackageName();     // Catch: Exception -> L23
        goto L7
    }

    public final void d(Context r8, String r10) {
        if (this.f9458a == false) goto L5;
        a(r8, r10);
        return;
    L5:
        Bundle r11 = new Bundle();
        r6.b.b().getClass();
        r6.d r12 = r6.d.b(r8);
        r12.getClass();
        Log.i("a", "deleteData alias:" + r10);
        int r13 = 0;
        int r14 = r11.getInt("delete_all", 0);
        Object r15 = r12.f11536c;
        Object r16 = r12.f11535b;
        if (r14 != 1) goto L11;
        r6.c r17 = (r6.c) r16;
        String r18 = ((Context) r15).getPackageName();
        r17.getClass();
        Log.i("a", "deleteAllData, pkgName: " + r18);
        int r19 = r17.getWritableDatabase().delete("secret_item", "pkg_name =? ", new String[]{r18});
        if (r19 > 0) goto L26;
        StringBuilder r20 = new StringBuilder("delete all data failed, ret: ");
    L25:
        r20.append(r19);
        Log.e("a", r20.toString());
        r13 = -6;
    L26:
        if (r13 == 0) goto L30;
        Log.e("SensitiveData", "delete sessionEncryptKey failed, code: " + r13);
        return;
    L30:
        return;
    L11:
        if (TextUtils.isEmpty(r10) == false) goto L13;
        Log.e("a", "delete single data, alias is empty!");
        r13 = -2;
        goto L26
    L13:
        r6.c r21 = (r6.c) r16;
        Context r22 = (Context) r15;
        r6.a r23 = r21.a(r10, r22.getPackageName());
        if (r23 != null) goto L16;
    L19:
        boolean r24 = false;
    L20:
        if (r24 == true) goto L22;
        Log.e("a", "delete single data, data not exist!");
        r13 = -5;
        goto L26
    L22:
        String r25 = r22.getPackageName();
        Log.i("a", "deleteData, alias: " + r10 + ", pkgName: " + r25);
        r19 = r21.getWritableDatabase().delete("secret_item", "alias =? AND pkg_name =? ", new String[]{r10, r25});
        if (r19 == 1) goto L26;
        r20 = new StringBuilder("delete single data failed, ret: ");
        goto L25
    L16:
        if (TextUtils.isEmpty(r23.f11522a) == true) goto L19;
        r24 = true;
        goto L20
    }

    public final void e(byte[] r8) {
        if (r8 == null) goto L13;
        if (r8.length == 0) goto L13;
        Log.i("SensitiveData", "Derive session key enter.");
        byte[] r10 = new byte[32];
        new SecureRandom().nextBytes(r10);
        this.f9459b = l6.a.F(r8, r10, this.f9464g);
        this.f9462e = r10;
        return;
    L9:
        e = move-exception;
        throw new c("generateSharedSecret failed, derive session key failed", e);
    L13:
        throw new c("deriveSessionKey failed, sek is empty!!");
    }

    public final void f(Context r11, String r12, String r13, boolean r14) {
        this.f9458a = r14;
        if (r14 == false) goto L42;
        b(r11, r12, r13);
        return;
    L42:
        Bundle r8 = new Bundle();     // Catch: Exception -> L35
        r8.putInt("query_mode", 2);     // Catch: Exception -> L35
        r6.b.b().getClass();     // Catch: Exception -> L35
        f r10 = r6.b.a(r11, r12, r8);     // Catch: Exception -> L35
        Object r15 = r10.f9888b;
        if (r10.f9887a != (-5)) goto L12;
    L32:
        String r16 = "sessionEncryptKey info not exist";
    L33:
        Log.i("SensitiveData", r16);     // Catch: Exception -> L35
        return;
    L12:
        if (((List) r15).isEmpty() == true) goto L32;
        this.f9466i = true;     // Catch: Exception -> L35
        if (((r6.a) ((List) r15).get(0)).f11527f.isEmpty() == false) goto L17;
        r16 = "sessionEncryptKey exist, but get secretData failed!";
        goto L33
    L17:
        r6.a r17 = (r6.a) ((List) r15).get(0);     // Catch: Exception -> L35
        byte[] r18 = s6.b.b(r17.f11527f);     // Catch: Exception -> L35
        this.f9460c = r18;     // Catch: Exception -> L35
        if (r18.length != 0) goto L20;
        r16 = "sessionEncryptKey exist, but get key failed!";
        goto L33
    L20:
        this.f9465h = s6.b.b(r17.f11528g);     // Catch: Exception -> L35
        this.f9463f = Long.parseLong(r17.f11529h);     // Catch: Exception -> L35
        this.f9461d = Long.parseLong(r17.f11525d);     // Catch: Exception -> L35
        this.f9464g = e.h(r11.getPackageName().getBytes());     // Catch: Exception -> L35
        e(this.f9460c);     // Catch: Exception -> L35
        String r19 = "old_" + r12;     // Catch: Exception -> L35
        Bundle r20 = new Bundle();     // Catch: Exception -> L35
        r20.putInt("query_mode", 2);     // Catch: Exception -> L35
        r6.b.b().getClass();     // Catch: Exception -> L35
        f r110 = r6.b.a(r11, r19, r20);     // Catch: Exception -> L35
        Object r21 = r110.f9888b;
        if (r110.f9887a != (-5)) goto L25;
    L31:
        this.f9467j = false;     // Catch: Exception -> L35
        return;
    L25:
        if (((List) r21).isEmpty() == true) goto L31;
        r6.a r111 = (r6.a) ((List) r21).get(0);     // Catch: Exception -> L35
        if ((System.currentTimeMillis() - Long.parseLong(r111.f11525d)) <= 172800000) goto L30;
        d(r11, r19);     // Catch: Exception -> L35
        Log.i("SensitiveData", "old bd sessionEncryptKey info is expired");     // Catch: Exception -> L35
        goto L31
    L30:
        this.f9467j = true;     // Catch: Exception -> L35
        this.f9469l = s6.b.b(r111.f11527f);     // Catch: Exception -> L35
        this.f9468k = Long.parseLong(r111.f11529h);     // Catch: Exception -> L35
        Log.w("SensitiveData", "old key load, key version: " + this.f9468k);     // Catch: Exception -> L35
        return;
    L35:
        e = move-exception;
        if ((e instanceof c) == false) goto L41;
        throw ((c) e);
    L41:
        throw new c("initSessionEncryptKey failed", e);
    }

    public final void g(byte[] r8) {
        this.f9469l = this.f9460c;
        this.f9460c = r8;
    }

    public final void h(long r8) {
        this.f9461d = r8;
    }

    public final void i(long r8) {
        this.f9468k = this.f9463f;
        this.f9463f = r8;
    }

    public final void j(Context r8, String r10, String r11) {
        if (this.f9458a == false) goto L28;
        c(r8, r10, r11);
        return;
    L28:
        this.f9464g = e.h(r8.getPackageName().getBytes());     // Catch: Exception -> L21
        e(this.f9460c);     // Catch: Exception -> L21
        r6.a r12 = new r6.a();     // Catch: Exception -> L21
        r12.f11522a = r10;     // Catch: Exception -> L21
        r12.f11527f = s6.b.a(this.f9460c);     // Catch: Exception -> L21
        r12.f11529h = String.valueOf(this.f9463f);     // Catch: Exception -> L21
        r12.f11525d = String.valueOf(this.f9461d);     // Catch: Exception -> L21
        r12.f11528g = s6.b.a(this.f9465h);     // Catch: Exception -> L21
        if (this.f9466i == false) goto L9;
        r6.b r13 = r6.b.b();     // Catch: Exception -> L21
        new Bundle();     // Catch: Exception -> L21
        r13.getClass();     // Catch: Exception -> L21
        r6.b.d(r8, r12);     // Catch: Exception -> L21
    L10:
        long r14 = this.f9468k;     // Catch: Exception -> L21
        if (r14 < this.f9463f) goto L13;
        return;
    L13:
        if (r14 > (-1)) goto L15;
        return;
    L15:
        if (this.f9469l == null) goto L32;
        r6.a r15 = new r6.a();     // Catch: Exception -> L21
        r15.f11522a = "old_" + r10;     // Catch: Exception -> L21
        r15.f11527f = s6.b.a(this.f9469l);     // Catch: Exception -> L21
        r15.f11529h = String.valueOf(this.f9468k);     // Catch: Exception -> L21
        r15.f11525d = String.valueOf(System.currentTimeMillis());     // Catch: Exception -> L21
        if (this.f9467j == false) goto L19;
        r6.b r16 = r6.b.b();     // Catch: Exception -> L21
        new Bundle();     // Catch: Exception -> L21
        r16.getClass();     // Catch: Exception -> L21
        r6.b.d(r8, r15);     // Catch: Exception -> L21
        return;
    L19:
        r6.b r17 = r6.b.b();     // Catch: Exception -> L21
        new Bundle();     // Catch: Exception -> L21
        r17.getClass();     // Catch: Exception -> L21
        r6.b.c(r8, r15);     // Catch: Exception -> L21
        this.f9467j = true;     // Catch: Exception -> L21
        return;
    L32:
        return;
    L9:
        r6.b r18 = r6.b.b();     // Catch: Exception -> L21
        new Bundle();     // Catch: Exception -> L21
        r18.getClass();     // Catch: Exception -> L21
        r6.b.c(r8, r12);     // Catch: Exception -> L21
    L21:
        e = move-exception;
        if ((e instanceof c) == false) goto L27;
        throw ((c) e);
    L27:
        throw new c("saveDeviceShareKey failed, ", e);
    }
}
