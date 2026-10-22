package okhttp3.internal.platform.android;

import ai.j0;
import android.util.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes3.dex */
@SuppressSignatureCheck
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0002\b\u0012J\u0006\u0010\u0013\u001a\u00020\fJ\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lokhttp3/internal/platform/android/AndroidLog;", "", "()V", "MAX_LOG_LENGTH", "", "configuredLoggers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/logging/Logger;", "knownLoggers", "", "", "androidLog", "", "loggerName", "logLevel", "message", "t", "", "androidLog$okhttp", "enable", "enableLogging", "logger", "tag", "loggerTag", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class AndroidLog {
    public static final AndroidLog INSTANCE = null;
    private static final int MAX_LOG_LENGTH = 4000;
    private static final CopyOnWriteArraySet<Logger> configuredLoggers = null;
    private static final Map<String, String> knownLoggers = null;

    static {
        INSTANCE = new AndroidLog();
        configuredLoggers = new CopyOnWriteArraySet();
        LinkedHashMap r5 = new LinkedHashMap();
        Package r10 = OkHttpClient.class.getPackage();
        if (r10 == null) goto L5;
        String r11 = r10.getName();
    L6:
        if (r11 == null) goto L8;
        r5.put(r11, "OkHttp");
    L8:
        r5.put(OkHttpClient.class.getName(), "okhttp.OkHttpClient");
        r5.put(Http2.class.getName(), "okhttp.Http2");
        r5.put(TaskRunner.class.getName(), "okhttp.TaskRunner");
        r5.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        knownLoggers = MapsKt.toMap(r5);
        return;
    L5:
        r11 = null;
        goto L6
    }

    private AndroidLog() {
    }

    private final void enableLogging(String r5, String r10) {
        Logger r11 = Logger.getLogger(r5);
        if (configuredLoggers.add(r11) == false) goto L13;
        r11.setUseParentHandlers(false);
        if (Log.isLoggable(r10, 3) == false) goto L8;
        Level r12 = Level.FINE;
    L11:
        r11.setLevel(r12);
        r11.addHandler(AndroidLogHandler.INSTANCE);
        return;
    L8:
        if (Log.isLoggable(r10, 4) == false) goto L10;
        r12 = Level.INFO;
        goto L11
    L10:
        r12 = Level.WARNING;
        goto L11
    }

    private final String loggerTag(String r5) {
        String r10 = knownLoggers.get(r5);
        if (r10 == null) goto L6;
        return r10;
    L6:
        return StringsKt.b0(r5);
    }

    public final void androidLog$okhttp(String r5, int r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r5, "loggerName");
        Intrinsics.checkNotNullParameter(r11, "message");
        String r13 = loggerTag(r5);
        if (Log.isLoggable(r13, r10) == false) goto L16;
        if (r12 == null) goto L6;
        StringBuilder r14 = j0.w(r11, "\n");
        r14.append(Log.getStackTraceString(r12));
        r11 = r14.toString();
    L6:
        int r15 = r11.length();
        int r16 = 0;
    L7:
        if (r16 >= r15) goto L20;
        int r17 = StringsKt.q(r11, '\n', r16, 4);
        if (r17 != (-1)) goto L12;
        r17 = r15;
    L12:
        int r18 = Math.min(r17, r16 + MAX_LOG_LENGTH);
        Log.println(r10, r13, r11.substring(r16, r18));
        if (r18 >= r17) goto L14;
        r16 = r18;
        goto L12
    L14:
        r16 = r18 + 1;
        goto L7
    L20:
        return;
    }

    public final void enable() {
        Iterator<Map.Entry<String, String>> r5 = knownLoggers.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry<String, String> r10 = r5.next();
        enableLogging(r10.getKey(), r10.getValue());
        goto L4
    }
}
