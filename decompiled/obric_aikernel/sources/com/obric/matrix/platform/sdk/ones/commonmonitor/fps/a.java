package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.Looper;
import android.util.Printer;
import java.lang.reflect.Field;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5855a = null;

    static {
        f5855a = new a();
    }

    private a() {
    }

    public final Printer a() {
        Field r10 = Class.forName("android.os.Looper").getDeclaredField("mLogging");     // Catch: Exception -> L7
        r10.setAccessible(true);     // Catch: Exception -> L7
        Object r11 = r10.get(Looper.getMainLooper());     // Catch: Exception -> L7
        if (r11 == null) goto L6;
        return (Printer) r11;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type android.util.Printer");     // Catch: Exception -> L7
    L7:
        return null;
    }

    public final JSONObject b(d r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        JSONObject r11 = new JSONObject();
        r11.put("drop_rate", r10.e());
        r11.put("drop_3", r10.c());
        r11.put("drop_7", r10.d());
        r11.put("drop_25", r10.b());
        return r11;
    }
}
