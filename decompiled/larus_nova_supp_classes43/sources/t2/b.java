package t2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final Bundle a(Fragment r10) {
        Bundle r0 = r10.getArguments();
        if (r0 != null) goto L5;
        r0 = new Bundle();
        r10.setArguments(r0);
    L5:
        Bundle r1 = r0.getBundle("__applet_app_ext_bundle__");
        if (r1 != null) goto L9;
        Bundle r11 = new Bundle();
        r0.putBundle("__applet_app_ext_bundle__", r11);
        return r11;
    L9:
        return r1;
    }

    public static final Long b(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Bundle r11 = r10.getArguments();
        if (r11 == null) goto L10;
        Bundle r12 = r11.getBundle("__applet_app_ext_bundle__");
        if (r12 != null) goto L7;
        return null;
    L7:
        if (r12.containsKey("trace_id") == true) goto L9;
        return null;
    L9:
        return Long.valueOf(r12.getLong("trace_id"));
    L10:
        return null;
    }

    public static final String c(Fragment r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Bundle r10 = r1.getArguments();
        if (r10 == null) goto L7;
        Bundle r11 = r10.getBundle("__applet_app_ext_bundle__");
        if (r11 == null) goto L7;
        return r11.getString(com.bytedance.android.ec.core.event.a.KEY_URL);
    L7:
        return null;
    }

    public static final void d(Fragment r1, String r10) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        a(r1).putString(com.bytedance.android.ec.core.event.a.KEY_URL, r10);
    }
}
