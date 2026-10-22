package com.obric.android.alog;

import android.content.Context;
import android.text.TextUtils;
import androidx.profileinstaller.ProfileVerifier;
import androidx.room.writer.DaoWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11231c;
    public String d;
    public String e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11232h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f11233i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f11234j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f11235k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f11236l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f11237m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f11238n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f11239o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f11240p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f11241q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f11242r;
    public String s;

    public b(Context r5) {
        this.f11230b = 0;
        this.f11231c = false;
        this.d = null;
        this.e = null;
        this.f = 2097152;
        this.g = 20971520;
        this.f11232h = 7;
        this.f11233i = null;
        this.f11234j = 65536;
        this.f11235k = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        this.f11236l = null;
        this.f11237m = Alog.access$000();
        this.f11238n = Alog.access$100();
        this.f11239o = Alog.access$200();
        this.f11240p = Alog.access$300();
        this.f11241q = Alog.access$400();
        this.f11242r = Alog.access$500();
        this.s = "b012e20c9aab1cb5257aca2069cb79a9339b3a2224f771c78d64972137936eaf0b2f7ebd8d46c2607e1d7fe7723d40b147b8ecfa8fe2eaeee05210c75822381a";
        Context r10 = r5.getApplicationContext();
        if (r10 == null) goto L5;
        r5 = r10;
    L5:
        this.f11229a = r5;
    }

    public final Alog a() {
        if (this.d != null) goto L5;
        this.d = "default";
    L5:
        ArrayList r5 = Alog.access$600();
        monitor-enter(r5);
        Iterator r10 = Alog.access$600().iterator();     // Catch: Throwable -> L14
    L8:
        String r11 = null;
        if (r10.hasNext() == false) goto L16;
        if (((String) r10.next()).equals(this.d) == false) goto L8;
        monitor-exit(r5);     // Catch: Throwable -> L14
        return null;
    L16:
        Alog.access$600().add(this.d);     // Catch: Throwable -> L14
        monitor-exit(r5);     // Catch: Throwable -> L14
        if (this.e != null) goto L25;
        File r12 = this.f11229a.getExternalFilesDir(null);
        if (r12 == null) goto L23;
        this.e = r12.getPath() + "/alog";
        goto L25
    L23:
        this.e = this.f11229a.getFilesDir() + "/alog";
    L25:
        if (this.f11233i != null) goto L28;
        this.f11233i = this.f11229a.getFilesDir() + "/alog";
    L28:
        if (this.f11236l != null) goto L35;
        Context r13 = this.f11229a;
        r11 = r13.getPackageManager().getPackageInfo(r13.getPackageName(), 0).versionName;     // Catch: Exception -> L45
    L32:
        if (TextUtils.isEmpty(r11) == false) goto L34;
        r11 = "unknown";
    L34:
        this.f11236l = r11;
    L35:
        int r14 = (this.f11234j / 4096) * 4096;
        this.f11234j = r14;
        int r15 = (this.f11235k / 4096) * 4096;
        this.f11235k = r15;
        if (r14 >= 4096) goto L38;
        this.f11234j = 4096;
    L38:
        int r16 = this.f11234j;
        if (r15 >= (r16 * 2)) goto L42;
        this.f11235k = r16 * 2;
    L42:
        return new Alog(this.f11229a, this.f11230b, this.f11231c, this.d, this.e, this.f, this.g, this.f11232h, this.f11233i, this.f11234j, this.f11235k, this.f11236l, this.f11237m, this.f11238n, this.f11239o, this.f11240p, this.f11241q, this.f11242r, this.s);
    L14:
        th = move-exception;
        throw th;
    }

    public final void b(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        if (r5.contains(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD) == false) goto L8;
        r5 = r5.replace(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD, "");
    L8:
        if (r5.contains("_") == false) goto L11;
        r5 = r5.replace("_", "");
    L11:
        if (TextUtils.isEmpty(r5) == true) goto L15;
        this.d = r5;
        return;
    }
}
