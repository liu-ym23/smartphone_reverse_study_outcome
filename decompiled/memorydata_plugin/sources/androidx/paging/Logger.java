package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0003"}, d2 = {"Landroidx/paging/Logger;", "", "isLoggable", "", "level", "", "log", "", "message", "", "tr", "", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Logger {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void log$default(Logger r6, int r7, String r8, Throwable r9, int r10, Object r11) {
            Logger.log$default((Logger) ZeusTransformUtils.wrapperContextForParams(r6, Logger.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11);
        }
    }

    static /* synthetic */ void log$default(Logger r2, int r3, String r4, Throwable r5, int r6, Object r7) {
        Logger r8 = (Logger) ZeusTransformUtils.wrapperContextForParams(r2, Logger.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        if ((r6 & 4) == 0) goto L7;
        r5 = null;
    L7:
        r8.log(r3, r4, r5);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
    }

    boolean isLoggable(int r1);

    void log(int r1, String r2, Throwable r3);
}
