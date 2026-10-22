package a1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import he.i;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import ne.g;

/* JADX INFO: loaded from: classes.dex */
public interface c extends Closeable {

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f16a;

        public a(int r8) {
            this.f16a = r8;
        }

        public static void a(String r8) {
            if (g.r0(r8, ":memory:") == true) goto L49;
            boolean r10 = true;
            int r11 = r8.length() - 1;
            int r12 = 0;
            boolean r13 = false;
        L5:
            if (r12 > r11) goto L26;
            if (r13 == true) goto L8;
            int r14 = r12;
        L9:
            char r15 = r8.charAt(r14);
            if (r15 >= ' ') goto L12;
            byte r16 = -1;
        L15:
            if (r16 > 0) goto L17;
            boolean r17 = true;
        L18:
            if (r13 == false) goto L19;
            if (r17 == false) goto L26;
            r11 = r11 - 1;
            goto L5
        L19:
            if (r17 == false) goto L20;
            r12 = r12 + 1;
            goto L5
        L20:
            r13 = true;
            goto L5
        L17:
            r17 = false;
            goto L18
        L12:
            if (r15 != ' ') goto L14;
            r16 = 0;
            goto L15
        L14:
            r16 = 1;
            goto L15
        L8:
            r14 = r11;
        L26:
            if (r8.subSequence(r12, r11 + 1).toString().length() == 0) goto L29;
            r10 = false;
        L29:
            if (r10 == true) goto L50;
            Log.w("SupportSQLite", "deleting the database file: ".concat(r8));
            SQLiteDatabase.deleteDatabase(new File(r8));     // Catch: Exception -> L34
            return;
        L34:
            e = move-exception;
            Log.w("SupportSQLite", "delete failed: ", e);
            return;
        L50:
            return;
        }

        public static void c(b1.c r8) {
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + r8 + ".path");
            if (r8.isOpen() == true) goto L8;
            String r10 = r8.k();
            if (r10 == null) goto L41;
            a(r10);
            return;
        L41:
            return;
        L8:
            List<Pair<String, String>> r11 = null;
            r11 = r8.i();     // Catch: Throwable -> L11 SQLiteException -> L33
        L11:
            th = move-exception;
            if (r11 == null) goto L20;
            Iterator<T> r12 = r11.iterator();
        L18:
            if (r12.hasNext() == false) goto L23;
            Object r13 = ((Pair) r12.next()).second;
            i.e(r13, "p.second");
            a((String) r13);
        L23:
            throw th;
        L20:
            String r14 = r8.k();
            if (r14 == null) goto L23;
            a(r14);
        L38:
            r8.close();     // Catch: Throwable -> L11 IOException -> L34
        L24:
            if (r11 == null) goto L29;
            Iterator<T> r15 = r11.iterator();
        L27:
            if (r15.hasNext() == false) goto L43;
            Object r16 = ((Pair) r15.next()).second;
            i.e(r16, "p.second");
            a((String) r16);
            goto L27
        L43:
            return;
        L29:
            String r17 = r8.k();
            if (r17 == null) goto L42;
            a(r17);
            return;
        }

        public abstract void b(b1.c r8);

        public abstract void d(b1.c r8);

        public abstract void e(b1.c r8, int r10, int r11);

        public abstract void f(b1.c r8);

        public abstract void g(b1.c r8, int r10, int r11);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f17a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f18b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f19c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f20d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f21e;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Context f22a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f23b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public a f24c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f25d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public boolean f26e;

            public a(Context r8) {
                i.f(r8, "context");
                this.f22a = r8;
            }

            public final b a() {
                a r8 = this.f24c;
                if (r8 == null) goto L22;
                boolean r10 = true;
                if (this.f25d == false) goto L16;
                String r11 = this.f23b;
                if (r11 != null) goto L9;
            L12:
                boolean r12 = true;
            L13:
                if (r12 == false) goto L16;
                r10 = false;
                goto L16
            L9:
                if (r11.length() == 0) goto L12;
                r12 = false;
            L16:
                if (r10 == false) goto L20;
                return new b(this.f22a, this.f23b, r8, this.f25d, this.f26e);
            L20:
                throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.".toString());
            L22:
                throw new IllegalArgumentException("Must set a callback to create the configuration.".toString());
            }
        }

        public b(Context r8, String r10, a r11, boolean r12, boolean r13) {
            i.f(r8, "context");
            this.f17a = r8;
            this.f18b = r10;
            this.f19c = r11;
            this.f20d = r12;
            this.f21e = r13;
        }
    }

    /* JADX INFO: renamed from: a1.c$c, reason: collision with other inner class name */
    public interface InterfaceC0001c {
        c a(b r8);
    }

    a1.b Z();

    String getDatabaseName();

    void setWriteAheadLoggingEnabled(boolean r8);
}
