package g18;

import android.content.Context;
import com.larksuite.component.universe_design.util.CalendarDate;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final d18.e a(Context r5, CalendarDate r6, CalendarDate r7, int r8) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "startCalendar");
        Intrinsics.checkNotNullParameter(r7, "endCalendar");
        int r1 = r6.getYear();
        int r2 = r7.getYear();
        if (r1 > r8) goto L6;
        if (r8 > r2) goto L6;
        boolean r4 = true;
    L7:
        if (r4 == true) goto L10;
        return null;
    L10:
        int r9 = h18.b.a;
        Intrinsics.checkNotNullParameter(r5, "context");
        String[] r10 = r5.getResources().getStringArray(2130903126);
        if (r8 == r1) goto L17;
        if (r8 != r2) goto L16;
        return new d18.e(1, r7.getMonth(), r10);
    L16:
        return new d18.e(1, 12, r10);
    L17:
        return new d18.e(r6.getMonth(), 12, r10);
    L6:
        r4 = false;
        goto L7
    }
}
