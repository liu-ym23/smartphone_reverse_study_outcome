package com.obric.sva.framework.log;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u008a\u0001\u0010\f\u001a\u00020\u00072\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0007J\b\u0010\u0012\u001a\u00020\u0007H\u0007J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0007J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0007J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0007J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0007J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0007R\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/sva/framework/log/AiagentLog;", "", "<init>", "()V", "debug", "Lkotlin/Function2;", "", "", "warn", "verbose", "error", "info", "init", "v", "d", "i", "w", "e", "reset", "tag", "msg", "api_release"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class AiagentLog {
    public static final AiagentLog INSTANCE = null;
    private static Function2<? super String, ? super String, Unit> debug;
    private static Function2<? super String, ? super String, Unit> error;
    private static Function2<? super String, ? super String, Unit> info;
    private static Function2<? super String, ? super String, Unit> verbose;
    private static Function2<? super String, ? super String, Unit> warn;

    static {
        INSTANCE = new AiagentLog();
    }

    private AiagentLog() {
    }

    @JvmStatic
    public static final void reset() {
        verbose = null;
        debug = null;
        info = null;
        warn = null;
        error = null;
    }

    @JvmStatic
    public static final void d(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        Function2<? super String, ? super String, Unit> r0 = debug;
        if (r0 == null) goto L6;
        r0.invoke("SVA-" + r3, r4);
        return;
    }

    @JvmStatic
    public static final void e(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        Function2<? super String, ? super String, Unit> r0 = error;
        if (r0 == null) goto L6;
        r0.invoke("SVA-" + r3, r4);
        return;
    }

    @JvmStatic
    public static final void i(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        Function2<? super String, ? super String, Unit> r0 = info;
        if (r0 == null) goto L6;
        r0.invoke("SVA-" + r3, r4);
        return;
    }

    @JvmStatic
    public static final void v(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        Function2<? super String, ? super String, Unit> r0 = verbose;
        if (r0 == null) goto L6;
        r0.invoke("SVA-" + r3, r4);
        return;
    }

    @JvmStatic
    public static final void w(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        Function2<? super String, ? super String, Unit> r0 = warn;
        if (r0 == null) goto L6;
        r0.invoke("SVA-" + r3, r4);
        return;
    }

    @JvmStatic
    public static final void init(Function2<? super String, ? super String, Unit> r1, Function2<? super String, ? super String, Unit> r2, Function2<? super String, ? super String, Unit> r3, Function2<? super String, ? super String, Unit> r4, Function2<? super String, ? super String, Unit> r5) {
        Intrinsics.checkNotNullParameter(r1, "v");
        Intrinsics.checkNotNullParameter(r2, "d");
        Intrinsics.checkNotNullParameter(r3, "i");
        Intrinsics.checkNotNullParameter(r4, "w");
        Intrinsics.checkNotNullParameter(r5, "e");
        verbose = r1;
        debug = r2;
        info = r3;
        warn = r4;
        error = r5;
    }
}
