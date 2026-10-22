package ala;

import android.net.Uri;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface e {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static String a(e r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            if ((r2 instanceof ala.a) == false) goto L6;
            return "Calendars";
        L6:
            if ((r2 instanceof b) == false) goto L8;
        L15:
            return "Events";
        L8:
            if ((r2 instanceof c) == true) goto L15;
            if ((r2 instanceof d) == false) goto L14;
            return "Reminders";
        L14:
            throw new NotImplementedError(null, 1, null);
        }
    }

    static {
        a = a.a;
    }

    Long getId();

    Uri toUri();
}
