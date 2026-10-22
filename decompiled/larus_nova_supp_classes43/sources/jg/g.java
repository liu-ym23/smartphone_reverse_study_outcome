package jg;

import android.view.View;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public static final boolean a(String r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.length() <= 0) goto L6;
        return true;
    }

    public static String c(String r10) {
        Intrinsics.checkNotNullParameter("", "default");
        if (r10 == null) goto L5;
        return r10;
    L5:
        return "";
    }

    public static final JSONObject e(String r1) {
    L6:
        e = move-exception;
        ECExceptionMonitor.f(e, "json_format_error");
        return null;
    L3:
        if (a(r1) == false) goto L12;
        return new JSONObject(r1);
    L12:
        return null;
    }

    public static final JSONObject f(String r1) {
    L6:
        e = move-exception;
        ECExceptionMonitor.f(e, "json_format_error");
        return null;
    L3:
        if (a(r1) == false) goto L12;
        return new JSONObject(r1);
    L12:
        return null;
    }

    public static final long b(Long r0, long r1) {
        if (r0 != null) goto L4;
        return r1;
    L4:
        return r0.longValue();
    }

    public static final void d(View r1, boolean r10) {
        Intrinsics.checkNotNullParameter(r1, "$this$setVisible");
        if (r10 == false) goto L5;
        int r11 = 0;
    L6:
        r1.setVisibility(r11);
        return;
    L5:
        r11 = 8;
        goto L6
    }
}
