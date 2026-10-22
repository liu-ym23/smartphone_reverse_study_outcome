package zka;

import android.content.Context;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface r {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static boolean a(Context r1) {
            Intrinsics.checkNotNullParameter(r1, "context");
            if (ContextCompat.checkSelfPermission(r1, "android.permission.READ_CALENDAR") == 0) goto L5;
        L7:
            return false;
        L5:
            if (ContextCompat.checkSelfPermission(r1, "android.permission.WRITE_CALENDAR") != 0) goto L7;
            return true;
        }
    }

    static {
        a = a.a;
    }
}
