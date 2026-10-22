package e1;

import android.annotation.SuppressLint;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f7100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f7101b;

    @SuppressLint({"NewApi"})
    public static boolean a() {
        if (f7101b != null) goto L26;
        return Trace.isEnabled();
    L26:
    L12:
        e = move-exception;
        if ((e instanceof InvocationTargetException) == false) goto L21;
        Throwable r8 = e.getCause();
        if ((r8 instanceof RuntimeException) == false) goto L20;
        throw ((RuntimeException) r8);
    L20:
        throw new RuntimeException(r8);
    L21:
        Log.v("Trace", "Unable to call isTagEnabled via reflection", e);
        return false;
    L8:
        if (f7101b != null) goto L10;
        f7100a = Trace.class.getField("TRACE_TAG_APP").getLong(null);     // Catch: Exception -> L12
        f7101b = Trace.class.getMethod("isTagEnabled", new Class[]{Long.TYPE});     // Catch: Exception -> L12
    L10:
        return ((Boolean) f7101b.invoke(null, new Object[]{Long.valueOf(f7100a)})).booleanValue();
    }
}
