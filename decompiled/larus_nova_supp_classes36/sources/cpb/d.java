package cpb;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.larksuite.framework.utils.x;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.log.LogLevel;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static Locale a(Context r1) {
            Intrinsics.checkNotNullParameter(r1, "context");
            if (x.b() == false) goto L5;
            Locale r2 = r1.getResources().getConfiguration().getLocales().get(0);
            Intrinsics.checkNotNull(r2);
            return r2;
        L5:
            Locale r3 = r1.getResources().getConfiguration().locale;
            Intrinsics.checkNotNull(r3);
            return r3;
        }

        @JvmStatic
        public static c c(String r4, Application r5) {
            Intrinsics.checkNotNullParameter(r4, "scene");
            Intrinsics.checkNotNullParameter(r5, "application");
            Locale r1 = a(r5);     // Catch: Exception -> L5
            c.a r2 = new c.a();     // Catch: Exception -> L5
            Intrinsics.checkNotNullParameter(r1, "locale");     // Catch: Exception -> L5
            r2.c = r1;     // Catch: Exception -> L5
            String r6 = z.b(r5);     // Catch: Exception -> L5
            Intrinsics.checkNotNullParameter(r6, "processName");     // Catch: Exception -> L5
            r2.a = r6;     // Catch: Exception -> L5
            Intrinsics.checkNotNullParameter(r4, "scene");     // Catch: Exception -> L5
            r2.e = r4;     // Catch: Exception -> L5
            return new c(r2);
        L5:
            e = move-exception;
            Log.e("LocaleWatchDog", "error: " + e.getMessage());
            return new c(new c.a());
        }

        @JvmStatic
        public static c b(String r5, Activity r6, Application r7) {
            Intrinsics.checkNotNullParameter(r5, "scene");
            Intrinsics.checkNotNullParameter(r6, "activity");
            Intrinsics.checkNotNullParameter(r7, "application");
        L9:
            e = move-exception;
            Log.e("LocaleWatchDog", "error: " + e.getMessage());
            return new c(new c.a());
        L4:
            if (x.b() == false) goto L6;
            Locale r2 = r6.getResources().getConfiguration().getLocales().get(0);     // Catch: Exception -> L9
            Locale r3 = r7.getResources().getConfiguration().getLocales().get(0);     // Catch: Exception -> L9
        L7:
            c.a r4 = new c.a();     // Catch: Exception -> L9
            Intrinsics.checkNotNullParameter(r2, "locale");     // Catch: Exception -> L9
            r4.b = r2;     // Catch: Exception -> L9
            Intrinsics.checkNotNullParameter(r3, "locale");     // Catch: Exception -> L9
            r4.c = r3;     // Catch: Exception -> L9
            String r8 = z.b(r7);     // Catch: Exception -> L9
            Intrinsics.checkNotNullParameter(r8, "processName");     // Catch: Exception -> L9
            r4.a = r8;     // Catch: Exception -> L9
            String r9 = r6.getClass().getSimpleName();     // Catch: Exception -> L9
            Intrinsics.checkNotNullParameter(r9, "activityName");     // Catch: Exception -> L9
            r4.d = r9;     // Catch: Exception -> L9
            Intrinsics.checkNotNullParameter(r5, "scene");     // Catch: Exception -> L9
            r4.e = r5;     // Catch: Exception -> L9
            return new c(r4);
        L6:
            r2 = r6.getResources().getConfiguration().locale;     // Catch: Exception -> L9
            r3 = r7.getResources().getConfiguration().locale;     // Catch: Exception -> L9
            goto L7
        }
    }

    public static final class b {
        public final String a;
        public final Locale b;
        public final Locale c;
        public final String d;

        public static final class a {
            public String a;
            public Locale b;
            public Locale c;
            public String d;

            public a() {
            }
        }

        public final String toString() {
            String r0 = this.a;
            String r1 = "";
            if (r0 != null) goto L6;
            r0 = "";
        L6:
            if (this.b == null) goto L11;
            if (this.c == null) goto L11;
            r1 = ", Locale change from " + this.b + " to " + this.c;
        L11:
            return "Locale(scene =" + this.d + ", processName=" + r0 + ' ' + r1 + ')';
        }

        public b(a r4) {
            String r0 = r4.a;
            Locale r1 = r4.b;
            Locale r2 = r4.c;
            String r5 = r4.d;
            this.a = r0;
            this.b = r1;
            this.c = r2;
            this.d = r5;
        }
    }

    public static final class c {
        public final String a;
        public final String b;
        public final Locale c;
        public final Locale d;
        public final String e;

        public static final class a {
            public String a;
            public Locale b;
            public Locale c;
            public String d;
            public String e;

            public a() {
            }
        }

        public final String toString() {
            String r1 = "";
            if (this.a != null) goto L5;
            String r0 = "";
        L7:
            if (this.c == null) goto L11;
            r1 = "activityLocale=" + this.c + ',';
        L11:
            return "Locale(scene =" + this.e + ", processName=" + this.b + ", " + r0 + ' ' + r1 + " application_locale=" + this.d + ')';
        L5:
            r0 = "activityName=" + this.a + ',';
            goto L7
        }

        public c(a r5) {
            String r0 = r5.d;
            String r1 = r5.a;
            Locale r2 = r5.b;
            Locale r3 = r5.c;
            String r6 = r5.e;
            this.a = r0;
            this.b = r1;
            this.c = r2;
            this.d = r3;
            this.e = r6;
        }

        public final void a(LogLevel r3) {
            Intrinsics.checkNotNullParameter(r3, "logLevel");
            if (this.e == null) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L14;
            LogLevel r1 = LogLevel.INFO;
            if (r3 != r1) goto L11;
            Log.i("LocaleWatchDog", toString());
            return;
        L11:
            if (r3.compareTo(r1) >= 0) goto L16;
            Log.d("LocaleWatchDog", toString());
            return;
        L16:
            return;
        L14:
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    static {
    }
}
