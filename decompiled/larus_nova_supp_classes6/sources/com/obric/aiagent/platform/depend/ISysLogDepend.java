package com.obric.aiagent.platform.depend;

import com.obric.aiagent.platform.IAIAgentPlatform;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r9a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u00022\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/aiagent/platform/depend/ISysLogDepend;", "Lcom/obric/aiagent/platform/depend/ILogDepend;", "Companion", "Empty", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public interface ISysLogDepend extends ILogDepend {
    public static final Companion c = null;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J%\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\t\u0010\f\u001a\u00020\u0007H\u0096\u0001J\u001b\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J3\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00072 \u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013H\u0096\u0001J\u001b\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J%\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001¨\u0006\u0017"}, d2 = {"Lcom/obric/aiagent/platform/depend/ISysLogDepend$Companion;", "Lcom/obric/aiagent/platform/depend/ISysLogDepend;", "<init>", "()V", "d", "", "tag", "", "msg", "e", "tr", "", "getDirPath", "i", "isDebug", "", "uploadAllLog", "scene", "callback", "Lkotlin/Function3;", "", "v", "w", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Companion implements ISysLogDepend {
        public static final /* synthetic */ Companion e = null;
        public final /* synthetic */ ISysLogDepend d;

        static {
            e = new Companion();
        }

        public final void d(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            this.d.d(r2, r3);
        }

        public final void e(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            this.d.e(r2, r3);
        }

        public final void e(String r2, String r3, Throwable r4) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            this.d.e(r2, r3, r4);
        }

        public final String getDirPath() {
            return this.d.getDirPath();
        }

        public final void i(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            this.d.i(r2, r3);
        }

        public final boolean isDebug() {
            return this.d.isDebug();
        }

        public final void w(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            this.d.w(r2, r3);
        }

        public final void w(String r2, String r3, Throwable r4) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            this.d.w(r2, r3, r4);
        }

        private Companion() {
            IAIAgentPlatform r0 = a.a();
            if (r0 == null) goto L5;
            r0.d();
        L5:
            ISysLogDepend r1 = (ISysLogDepend) ServiceManager.get().getService(ISysLogDepend.class, false, false);
            if (r1 != null) goto L8;
            r1 = Empty.d;
        L8:
            this.d = r1;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/aiagent/platform/depend/ISysLogDepend$Empty;", "Lcom/obric/aiagent/platform/depend/ILogDepend;", "Lcom/obric/aiagent/platform/depend/ISysLogDepend;", "<init>", "()V", "v", "", "tag", "", "msg", "d", "i", "w", "tr", "", "e", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Empty implements ILogDepend, ISysLogDepend {
        public static final Empty d = null;

        static {
            d = new Empty();
        }

        private Empty() {
        }

        public final void d(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "tag");
        }

        public final void e(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "tag");
        }

        public final void e(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, "tag");
        }

        public final String getDirPath() {
            return "";
        }

        public final void i(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "tag");
        }

        public final boolean isDebug() {
            return false;
        }

        public final void w(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "tag");
        }

        public final void w(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, "tag");
        }
    }

    static {
        c = Companion.e;
    }
}
