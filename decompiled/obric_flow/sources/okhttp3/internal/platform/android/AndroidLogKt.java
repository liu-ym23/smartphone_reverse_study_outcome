package okhttp3.internal.platform.android;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"androidLevel", "", "Ljava/util/logging/LogRecord;", "getAndroidLevel", "(Ljava/util/logging/LogRecord;)I", "okhttp"}, k = 2, mv = {1, 4, 0})
public final class AndroidLogKt {
    public static final /* synthetic */ int access$getAndroidLevel$p(LogRecord r5) {
        return getAndroidLevel(r5);
    }

    private static final int getAndroidLevel(LogRecord r5) {
        int r10 = r5.getLevel().intValue();
        Level r11 = Level.INFO;
        if (r10 <= r11.intValue()) goto L6;
        return 5;
    L6:
        if (r5.getLevel().intValue() != r11.intValue()) goto L8;
        return 4;
    L8:
        return 3;
    }
}
