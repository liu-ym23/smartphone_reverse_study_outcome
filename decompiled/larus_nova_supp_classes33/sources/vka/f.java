package vka;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Handler;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.common.apphost.AppHost;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.text.StringsKt;
import zka.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f {
    public static final f a = null;
    public static ContentProviderClient b;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final e e = null;

    public f() {
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [vka.e] */
    static {
        a = new f();
        c = LazyKt.lazy(new c());
        d = LazyKt.lazy(new d());
        e = new e();
    }

    public static Handler b() {
        return (Handler) c.getValue();
    }

    public static Context c() {
        return AppHost.a.getApplication();
    }

    public static ContentResolver d() {
        return c().getContentResolver();
    }

    public static ContentProviderClient a(ContentResolver r12, Uri r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240016, "android/content/ContentResolver", "acquireContentProviderClient", r12, r9, "android.content.ContentProviderClient", r10);
        if (r11.a == false) goto L6;
        r8.a(240016, "android/content/ContentResolver", "acquireContentProviderClient", r12, r9, null, r10, false);
        return (ContentProviderClient) r11.b;
    L6:
        ContentProviderClient r14 = r12.acquireContentProviderClient(r13);
        r8.a(240016, "android/content/ContentResolver", "acquireContentProviderClient", r12, r9, r14, r10, true);
        return r14;
    }

    public final Long insert(ala.e r7, ContentValues r8) {
        Intrinsics.checkNotNullParameter(r7, "token");
        r.a r0 = r.a;
        Context r1 = c();
        r0.getClass();
        if (r.a.a(r1) == false) goto L18;
        Uri r2 = r7.toUri();
        Handler r3 = b();
        monitor-enter(r3);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = a(d(), r2);     // Catch: Throwable -> L15
    L9:
        Handler r4 = b();     // Catch: Throwable -> L15
        e r5 = e;     // Catch: Throwable -> L15
        r4.removeCallbacks(r5);     // Catch: Throwable -> L15
        b().postDelayed(r5, 30000);     // Catch: Throwable -> L15
        ContentProviderClient r6 = b;     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L15
        Uri r9 = r6.insert(r7.toUri(), r8);     // Catch: Throwable -> L15
        monitor-exit(r3);
        if (r9 == null) goto L22;
        String r10 = r9.getLastPathSegment();
        if (r10 != null) goto L24;
        return null;
    L24:
        return Long.valueOf(CastLongProtector.parseLong(r10));
    L22:
        return null;
    L18:
        SQLiteDatabase r11 = (SQLiteDatabase) d.getValue();
        ala.e.a.getClass();
        return Long.valueOf(r11.insert(ala.e.a.a(r7), null, r8));
    }

    public static Pair e(ala.e r4, String r5, String[] r6) {
        Long r7 = r4.getId();
        if (r7 == null) goto L20;
        long r0 = r7.longValue();
        if (r5 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        String r8 = "_id = ?";
    L14:
        SpreadBuilder r3 = new SpreadBuilder(2);
        r3.add(String.valueOf(r0));
        if (r6 != null) goto L17;
        r6 = new String[0];
    L17:
        r3.addSpread(r6);
        return TuplesKt.to(r8, (String[]) r3.toArray(new String[r3.size()]));
    L13:
        r8 = "_id = ? AND (" + r5 + ')';
        goto L14
    L7:
        if (StringsKt.isBlank(r5) == true) goto L10;
        r2 = false;
        goto L11
    L20:
        return TuplesKt.to(r5, r6);
    }

    public final int delete(ala.e r6, String r7, String[] r8) {
        Intrinsics.checkNotNullParameter(r6, "token");
        r.a r0 = r.a;
        Context r1 = c();
        r0.getClass();
        if (r.a.a(r1) == false) goto L15;
        Uri r2 = r6.toUri();
        Handler r3 = b();
        monitor-enter(r3);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = a(d(), r2);     // Catch: Throwable -> L12
    L9:
        Handler r4 = b();     // Catch: Throwable -> L12
        e r5 = e;     // Catch: Throwable -> L12
        r4.removeCallbacks(r5);     // Catch: Throwable -> L12
        b().postDelayed(r5, 30000);     // Catch: Throwable -> L12
        ContentProviderClient r9 = b;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L12
        int r10 = r9.delete(r6.toUri(), r7, r8);     // Catch: Throwable -> L12
        monitor-exit(r3);
        return r10;
    L15:
        Pair r11 = e(r6, r7, r8);
        String r12 = (String) r11.component1();
        String[] r13 = (String[]) r11.component2();
        SQLiteDatabase r14 = (SQLiteDatabase) d.getValue();
        ala.e.a.getClass();
        return r14.delete(ala.e.a.a(r6), r12, r13);
    }

    public final int update(ala.e r6, ContentValues r7, String r8, String[] r9) {
        Intrinsics.checkNotNullParameter(r6, "token");
        r.a r0 = r.a;
        Context r1 = c();
        r0.getClass();
        if (r.a.a(r1) == false) goto L15;
        Uri r2 = r6.toUri();
        Handler r3 = b();
        monitor-enter(r3);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = a(d(), r2);     // Catch: Throwable -> L12
    L9:
        Handler r4 = b();     // Catch: Throwable -> L12
        e r5 = e;     // Catch: Throwable -> L12
        r4.removeCallbacks(r5);     // Catch: Throwable -> L12
        b().postDelayed(r5, 30000);     // Catch: Throwable -> L12
        ContentProviderClient r10 = b;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L12
        int r11 = r10.update(r6.toUri(), r7, r8, r9);     // Catch: Throwable -> L12
        monitor-exit(r3);
        return r11;
    L15:
        Pair r12 = e(r6, r8, r9);
        String r13 = (String) r12.component1();
        String[] r14 = (String[]) r12.component2();
        SQLiteDatabase r15 = (SQLiteDatabase) d.getValue();
        ala.e.a.getClass();
        return r15.update(ala.e.a.a(r6), r7, r13, r14);
    }

    public final Cursor query(ala.e r9, String[] r10, String r11, String[] r12, String r13) {
        Intrinsics.checkNotNullParameter(r9, "token");
        r.a r0 = r.a;
        Context r1 = c();
        r0.getClass();
        if (r.a.a(r1) == false) goto L15;
        Uri r2 = r9.toUri();
        Handler r14 = b();
        monitor-enter(r14);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = a(d(), r2);     // Catch: Throwable -> L12
    L9:
        Handler r3 = b();     // Catch: Throwable -> L12
        e r4 = e;     // Catch: Throwable -> L12
        r3.removeCallbacks(r4);     // Catch: Throwable -> L12
        b().postDelayed(r4, 30000);     // Catch: Throwable -> L12
        ContentProviderClient r5 = b;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L12
        Cursor r15 = r5.query(r2, r10, r11, r12, r13);     // Catch: Throwable -> L12
        monitor-exit(r14);
        return r15;
    L15:
        Pair r16 = e(r9, r11, r12);
        String r6 = (String) r16.component1();
        String[] r7 = (String[]) r16.component2();
        SQLiteDatabase r8 = (SQLiteDatabase) d.getValue();
        ala.e.a.getClass();
        return r8.query(ala.e.a.a(r9), r10, r6, r7, null, null, r13);
    }
}
