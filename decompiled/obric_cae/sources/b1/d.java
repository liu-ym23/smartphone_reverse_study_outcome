package b1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.qualcomm.qti.qesdk.QesdkUtils;
import he.i;
import he.j;
import java.io.File;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class d implements a1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2975b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a1.c.a f2976m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f2977n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f2978o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final xd.f f2979p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2980q;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b1.c f2981a;

        public a() {
            this.f2981a = null;
        }
    }

    public static final class b extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final /* synthetic */ int f2982r = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f2983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f2984b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final a1.c.a f2985m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f2986n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f2987o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final c1.a f2988p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f2989q;

        public static final class a extends RuntimeException {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final EnumC0029b f2990a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Throwable f2991b;

            public a(EnumC0029b r8, Throwable r10) {
                super(r10);
                this.f2990a = r8;
                this.f2991b = r10;
            }

            @Override // java.lang.Throwable
            public final Throwable getCause() {
                return this.f2991b;
            }
        }

        /* JADX INFO: renamed from: b1.d$b$b, reason: collision with other inner class name */
        public static final enum EnumC0029b extends Enum<EnumC0029b> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final EnumC0029b f2992a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final EnumC0029b f2993b = null;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public static final EnumC0029b f2994m = null;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public static final EnumC0029b f2995n = null;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public static final EnumC0029b f2996o = null;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public static final /* synthetic */ EnumC0029b[] f2997p = null;

            static {
                EnumC0029b r8 = new EnumC0029b("ON_CONFIGURE", 0);
                f2992a = r8;
                EnumC0029b r10 = new EnumC0029b("ON_CREATE", 1);
                f2993b = r10;
                EnumC0029b r11 = new EnumC0029b("ON_UPGRADE", 2);
                f2994m = r11;
                EnumC0029b r12 = new EnumC0029b("ON_DOWNGRADE", 3);
                f2995n = r12;
                EnumC0029b r13 = new EnumC0029b("ON_OPEN", 4);
                f2996o = r13;
                f2997p = new EnumC0029b[]{r8, r10, r11, r12, r13};
            }

            public EnumC0029b(String r8, int r10) {
                super(r8, r10);
            }

            public static EnumC0029b valueOf(String r8) {
                return (EnumC0029b) Enum.valueOf(EnumC0029b.class, r8);
            }

            public static EnumC0029b[] values() {
                return (EnumC0029b[]) f2997p.clone();
            }
        }

        public static final class c {
            public static b1.c a(a r8, SQLiteDatabase r10) {
                i.f(r8, "refHolder");
                i.f(r10, "sqLiteDatabase");
                b1.c r11 = r8.f2981a;
                if (r11 != null) goto L5;
            L6:
                b1.c r12 = new b1.c(r10);
                r8.f2981a = r12;
                return r12;
            L5:
                if (i.a(r11.f2972a, r10) == false) goto L6;
                return r11;
            }
        }

        public b(Context r8, String r10, final a r11, final a1.c.a r12, boolean r13) {
            i.f(r8, "context");
            i.f(r12, QesdkUtils.TAGS.JSON_TAG_CALLBACK);
            super(r8, r10, null, r12.f16a, new e(r12, r11));
            this.f2983a = r8;
            this.f2984b = r11;
            this.f2985m = r12;
            this.f2986n = r13;
            if (r10 != null) goto L5;
            r10 = UUID.randomUUID().toString();
            i.e(r10, "randomUUID().toString()");
        L5:
            this.f2988p = new c1.a(r10, r8.getCacheDir(), false);
        }

        public final a1.b a(boolean r8) {
            c1.a r10 = this.f2988p;
        L17:
            th = move-exception;
            r10.b();
            throw th;
        L4:
            if (this.f2989q == false) goto L6;
        L8:
            boolean r11 = false;
        L9:
            r10.a(r11);     // Catch: Throwable -> L17
            this.f2987o = false;     // Catch: Throwable -> L17
            SQLiteDatabase r12 = n(r8);     // Catch: Throwable -> L17
            if (this.f2987o == false) goto L14;
            close();     // Catch: Throwable -> L17
            a1.b r13 = a(r8);     // Catch: Throwable -> L17
            r10.b();
            return r13;
        L14:
            b1.c r14 = i(r12);     // Catch: Throwable -> L17
            r10.b();
            return r14;
        L6:
            if (getDatabaseName() == null) goto L8;
            r11 = true;
            goto L9
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public final void close() {
            c1.a r8 = this.f2988p;
            r8.a(r8.f3242a);     // Catch: Throwable -> L6
            super.close();     // Catch: Throwable -> L6
            this.f2984b.f2981a = null;     // Catch: Throwable -> L6
            this.f2989q = false;     // Catch: Throwable -> L6
            r8.b();
            return;
        L6:
            th = move-exception;
            r8.b();
            throw th;
        }

        public final b1.c i(SQLiteDatabase r8) {
            i.f(r8, "sqLiteDatabase");
            return c.a(this.f2984b, r8);
        }

        public final SQLiteDatabase k(boolean r8) {
            if (r8 == false) goto L5;
            SQLiteDatabase r10 = getWritableDatabase();
        L6:
            i.e(r10, "{\n                super.…eDatabase()\n            }");
            return r10;
        L5:
            r10 = getReadableDatabase();
            goto L6
        }

        public final SQLiteDatabase n(boolean r8) {
            String r10 = getDatabaseName();
            boolean r11 = this.f2989q;
            Context r12 = this.f2983a;
            if (r10 == null) goto L50;
            if (r11 == true) goto L50;
            File r13 = r12.getDatabasePath(r10).getParentFile();
            if (r13 == null) goto L50;
            r13.mkdirs();
            if (r13.isDirectory() == true) goto L50;
            Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + r13);
        L50:
            return k(r8);
        L12:
            super.close();
            Thread.sleep(500);     // Catch: InterruptedException -> L45
        L46:
            return k(r8);
        L16:
            th = move-exception;
            super.close();
            if ((th instanceof a) == false) goto L33;
            a r14 = th;
            int r15 = r14.f2990a.ordinal();
            Throwable r16 = r14.f2991b;
            if (r15 != 0) goto L22;
        L31:
            throw r16;
        L22:
            if (r15 == 1) goto L31;
            if (r15 == 2) goto L31;
            if (r15 == 3) goto L31;
            if ((r16 instanceof SQLiteException) == true) goto L37;
            throw r16;
        L37:
            r12.deleteDatabase(r10);
            return k(r8);
        L40:
            e = move-exception;
            throw e.f2991b;
        L33:
            if ((th instanceof SQLiteException) == false) goto L44;
            if (r10 != null) goto L36;
        L43:
            throw th;
        L36:
            if (this.f2986n == false) goto L43;
        L44:
            throw th;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onConfigure(SQLiteDatabase r8) {
            i.f(r8, "db");
            boolean r10 = this.f2987o;
            a1.c.a r11 = this.f2985m;
            if (r10 == false) goto L5;
        L12:
            r11.b(i(r8));     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw new a(EnumC0029b.f2992a, th);
        L5:
            if (r11.f16a == r8.getVersion()) goto L12;
            r8.setMaxSqlCacheSize(1);
            goto L12
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase r8) {
            i.f(r8, "sqLiteDatabase");
            this.f2985m.d(i(r8));     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            throw new a(EnumC0029b.f2993b, th);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase r8, int r10, int r11) {
            i.f(r8, "db");
            this.f2987o = true;
            this.f2985m.e(i(r8), r10, r11);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            throw new a(EnumC0029b.f2995n, th);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onOpen(SQLiteDatabase r8) {
            i.f(r8, "db");
            if (this.f2987o == false) goto L11;
        L9:
            this.f2989q = true;
            return;
        L11:
            this.f2985m.f(i(r8));     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw new a(EnumC0029b.f2996o, th);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase r8, int r10, int r11) {
            i.f(r8, "sqLiteDatabase");
            this.f2987o = true;
            this.f2985m.g(i(r8), r10, r11);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            throw new a(EnumC0029b.f2994m, th);
        }
    }

    public static final class c extends j implements ge.a<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f2998a;

        public c(d r8) {
            this.f2998a = r8;
            super(0);
        }

        @Override // ge.a
        public final b f() {
            d r15 = this.f2998a;
            if (r15.f2975b != null) goto L5;
        L7:
            b r8 = new b(r15.f2974a, r15.f2975b, new a(), r15.f2976m, r15.f2978o);
        L8:
            r8.setWriteAheadLoggingEnabled(r15.f2980q);
            return r8;
        L5:
            if (r15.f2977n == false) goto L7;
            Context r10 = r15.f2974a;
            i.f(r10, "context");
            File r11 = r10.getNoBackupFilesDir();
            i.e(r11, "context.noBackupFilesDir");
            File r12 = new File(r11, r15.f2975b);
            r8 = new b(r15.f2974a, r12.getAbsolutePath(), new a(), r15.f2976m, r15.f2978o);
            goto L8
        }
    }

    public d(Context r8, String r10, a1.c.a r11, boolean r12, boolean r13) {
        i.f(r8, "context");
        i.f(r11, QesdkUtils.TAGS.JSON_TAG_CALLBACK);
        this.f2974a = r8;
        this.f2975b = r10;
        this.f2976m = r11;
        this.f2977n = r12;
        this.f2978o = r13;
        this.f2979p = defpackage.c.R(new c(this));
    }

    @Override // a1.c
    public final a1.b Z() {
        return ((b) this.f2979p.getValue()).a(true);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f2979p.f13872b == defpackage.c.f3214s) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L9;
        ((b) this.f2979p.getValue()).close();
        return;
    L9:
        return;
    L5:
        r8 = false;
        goto L6
    }

    @Override // a1.c
    public final String getDatabaseName() {
        return this.f2975b;
    }

    @Override // a1.c
    public final void setWriteAheadLoggingEnabled(boolean r8) {
        if (this.f2979p.f13872b == defpackage.c.f3214s) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L8;
        b r11 = (b) this.f2979p.getValue();
        i.f(r11, "sQLiteOpenHelper");
        r11.setWriteAheadLoggingEnabled(r8);
    L8:
        this.f2980q = r8;
        return;
    L5:
        r10 = false;
        goto L6
    }
}
