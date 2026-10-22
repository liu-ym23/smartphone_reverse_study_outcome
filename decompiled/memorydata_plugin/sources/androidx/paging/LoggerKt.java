package androidx.paging;

import com.bytedance.security.dbcipher.utils.CipherConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H\u0086\bø\u0001\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {CipherConst.LEVEL_DEBUG, "", "LOGGER", "Landroidx/paging/Logger;", "getLOGGER", "()Landroidx/paging/Logger;", "setLOGGER", "(Landroidx/paging/Logger;)V", "LOG_TAG", "", "VERBOSE", "log", "", "level", "tr", "", "block", "Lkotlin/Function0;", "paging-common"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LoggerKt {
    public static final int DEBUG = 3;
    private static Logger LOGGER = null;
    public static final String LOG_TAG = "Paging";
    public static final int VERBOSE = 2;

    static {
    }

    public static final Logger getLOGGER() {
        return LOGGER;
    }

    public static final void log(int r5, Throwable r6, Function0<String> r7) {
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "block");
        Logger r0 = getLOGGER();
        boolean r2 = true;
        if (r0 != null) goto L5;
    L7:
        r2 = false;
    L8:
        if (r2 == false) goto L11;
        r0.log(r5, (String) ZeusTransformUtils.preCheckCast(r8.invoke(), String.class, "com.obric.memorydata.plugin"), r6);
        return;
    L11:
        return;
    L5:
        if (r0.isLoggable(r5) != true) goto L7;
        goto L7
    }

    public static /* synthetic */ void log$default(int r3, Throwable r4, Function0 r5, int r6, Object r7) {
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L5;
        r4 = null;
    L5:
        Intrinsics.checkNotNullParameter(r8, "block");
        Logger r9 = getLOGGER();
        boolean r10 = true;
        if (r9 != null) goto L8;
    L10:
        r10 = false;
    L11:
        if (r10 == false) goto L14;
        r9.log(r3, (String) ZeusTransformUtils.preCheckCast(r8.invoke(), String.class, "com.obric.memorydata.plugin"), r4);
        return;
    L14:
        return;
    L8:
        if (r9.isLoggable(r3) != true) goto L10;
        goto L10
    }

    public static final void setLOGGER(Logger r2) {
        LOGGER = (Logger) ZeusTransformUtils.wrapperContextForParams(r2, Logger.class, "com.obric.memorydata.plugin");
    }
}
