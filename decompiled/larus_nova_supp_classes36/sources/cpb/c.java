package cpb;

import android.content.Context;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.log.LogLevel;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static void a(String r4, Context r5, Locale r6, Locale r7) {
            Intrinsics.checkNotNullParameter(r4, "scene");
            d.b.a r3 = new d.b.a();     // Catch: Exception -> L16
            Intrinsics.checkNotNullParameter(r4, "scene");     // Catch: Exception -> L16
            r3.d = r4;     // Catch: Exception -> L16
            if (r5 == null) goto L6;
            String r8 = z.b(r5);     // Catch: Exception -> L16
            Intrinsics.checkNotNullParameter(r8, "processName");     // Catch: Exception -> L16
            r3.a = r8;     // Catch: Exception -> L16
        L6:
            if (r6 == null) goto L9;
            if (r7 == null) goto L9;
            Intrinsics.checkNotNullParameter(r7, "locale");     // Catch: Exception -> L16
            r3.b = r7;     // Catch: Exception -> L16
            Intrinsics.checkNotNullParameter(r6, "locale");     // Catch: Exception -> L16
            r3.c = r6;     // Catch: Exception -> L16
        L9:
            d.b r9 = new d.b(r3);     // Catch: Exception -> L16
            Intrinsics.checkNotNullParameter(LogLevel.INFO, "logLevel");     // Catch: Exception -> L16
            if (r9.d == null) goto L12;
            boolean r10 = true;
        L13:
            if (r10 == false) goto L21;
            Log.i("LocaleWatchDog", r9.toString());     // Catch: Exception -> L16
            return;
        L21:
            return;
        L12:
            r10 = false;
        L16:
            e = move-exception;
            Log.e("LocaleWatchDog", "error: " + e.getMessage());
        }
    }

    static {
    }
}
