package com.obric.assistant.interaction.impl.essentialtask.task.migration;

import android.util.Log;
import com.larus.utils.logger.FLogger;
import com.obric.datatransfer.logger.TransferLogger;
import com.obric.datatransfer.logger.a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/TransferLoggerDependAdapter;", "Lcom/obric/datatransfer/logger/ITransferLoggerDepend;", "<init>", "()V", "log", "", "level", "Lcom/obric/datatransfer/logger/TransferLogger$Level;", "tag", "", "message", "tr", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransferLoggerDependAdapter implements a {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[TransferLogger.Level.values().length];
            r0[TransferLogger.Level.VERBOSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[TransferLogger.Level.DEBUG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[TransferLogger.Level.INFO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[TransferLogger.Level.WARN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[TransferLogger.Level.ERROR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public TransferLoggerDependAdapter() {
    }

    public static /* synthetic */ String a(String r0, Throwable r1) {
        return log$lambda$0(r0, r1);
    }

    private static final String log$lambda$0(String r1, Throwable r2) {
        return r1 + '\n' + Log.getStackTraceString(r2);
    }

    @Override // com.obric.datatransfer.logger.a
    public void log(TransferLogger.Level r3, String r4, String r5, Throwable r6) {
        Intrinsics.checkNotNullParameter(r3, "level");
        Intrinsics.checkNotNullParameter(r4, "tag");
        Intrinsics.checkNotNullParameter(r5, "message");
        int r0 = WhenMappings.$EnumSwitchMapping$0[r3.ordinal()];
        if (r0 != 1) goto L5;
        if (r6 != null) goto L24;
        FLogger.a.v(r4, r5);
    L25:
        if (r6 == null) goto L28;
        r3.getLevelValue();
        Log.getStackTraceString(r6);
        return;
    L28:
        return;
    L24:
        FLogger.a.v(r4, a(r5, r6));
        goto L25
    L5:
        if (r0 != 2) goto L7;
        if (r6 != null) goto L21;
        FLogger.a.d(r4, r5);
        goto L25
    L21:
        FLogger.a.d(r4, a(r5, r6));
        goto L25
    L7:
        if (r0 != 3) goto L9;
        if (r6 != null) goto L18;
        FLogger.a.i(r4, r5);
        goto L25
    L18:
        FLogger.a.i(r4, a(r5, r6));
        goto L25
    L9:
        if (r0 != 4) goto L11;
        FLogger.a.w(r4, r5, r6);
        goto L25
    L11:
        if (r0 != 5) goto L14;
        FLogger.a.e(r4, r5, r6);
        goto L25
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
