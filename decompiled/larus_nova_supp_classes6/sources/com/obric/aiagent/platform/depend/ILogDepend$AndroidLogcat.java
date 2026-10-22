package com.obric.aiagent.platform.depend;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/aiagent/platform/depend/ILogDepend$AndroidLogcat;", "Lcom/obric/aiagent/platform/depend/ILogDepend;", "<init>", "()V", "v", "", "tag", "", "msg", "d", "i", "w", "tr", "", "e", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ILogDepend$AndroidLogcat implements ILogDepend {
    public static final ILogDepend$AndroidLogcat d = null;

    static {
        d = new ILogDepend$AndroidLogcat();
    }

    private ILogDepend$AndroidLogcat() {
    }

    public final String getDirPath() {
        return "";
    }

    public final boolean isDebug() {
        return false;
    }

    public final void d(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        IAppContext.Companion r3 = IAppContext.a;
        if (r3.isDebugChannel() == true) goto L6;
        r3.isTestChannel();
        return;
    }

    public final void e(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        IAppContext.Companion r3 = IAppContext.a;
        if (r3.isDebugChannel() == true) goto L6;
        r3.isTestChannel();
        return;
    }

    public final void i(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        IAppContext.Companion r3 = IAppContext.a;
        if (r3.isDebugChannel() == true) goto L6;
        r3.isTestChannel();
        return;
    }

    public final void w(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        IAppContext.Companion r3 = IAppContext.a;
        if (r3.isDebugChannel() == true) goto L6;
        r3.isTestChannel();
        return;
    }

    public final void e(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        IAppContext.Companion r4 = IAppContext.a;
        if (r4.isDebugChannel() == true) goto L6;
        r4.isTestChannel();
        return;
    }

    public final void w(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        IAppContext.Companion r4 = IAppContext.a;
        if (r4.isDebugChannel() == true) goto L6;
        r4.isTestChannel();
        return;
    }
}
