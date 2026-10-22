package com.obric.memorydata.markdown;

import android.app.Application;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.business.markdown.api.depend.c;
import com.larus.business.markdown.api.depend.f;
import com.larus.business.markdown.api.depend.h;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\b\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/markdown/MarkdownInitTask;", "", "<init>", "()V", "TAG", "", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "ensureInit", "", "getService", "Lcom/larus/business/markdown/api/MarkdownService;", CommonConsts.APM_INNER_EVENT_COST_INIT, "openBrowser", "url", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9973a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f9974b = null;

    /* JADX INFO: renamed from: com.obric.memorydata.markdown.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/markdown/MarkdownInitTask$init$1$markdownConfigImpl$1", "Lcom/larus/business/markdown/api/depend/IMarkdownConfig;", "getMarkdownSettings", "Lcom/larus/business/markdown/api/depend/IMarkdownSettings;", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0484a implements c {
        C0484a() {
        }

        @Override // com.larus.business.markdown.api.depend.c
        public h a() {
            return null;
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\r"}, d2 = {"com/obric/memorydata/markdown/MarkdownInitTask$init$2", "Lcom/larus/business/markdown/api/depend/IMarkdownLogger;", "d", "", LocationMonitorConst.TAG, "", NotificationCompat.CATEGORY_MESSAGE, "e", "tr", "", "i", BaseSwitches.V, "w", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements f {
        b() {
        }

        @Override // com.larus.business.markdown.api.depend.f
        public void d(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            if (r2 == null) goto L6;
            RunLog.INSTANCE.debug("MarkdownService", r2);
            return;
        }

        @Override // com.larus.business.markdown.api.depend.f
        public void e(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            if (r8 == null) goto L6;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MarkdownService", r8, null, 4, null);
            return;
        }

        @Override // com.larus.business.markdown.api.depend.f
        public void e(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            if (r2 == null) goto L6;
            RunLog.INSTANCE.debug("MarkdownService", r2);
            return;
        }

        @Override // com.larus.business.markdown.api.depend.f
        public void i(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            if (r8 == null) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MarkdownService", r8, false, 4, null);
            return;
        }

        @Override // com.larus.business.markdown.api.depend.f
        public void v(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            if (r2 == null) goto L6;
            RunLog.INSTANCE.debug("MarkdownService", r2);
            return;
        }

        @Override // com.larus.business.markdown.api.depend.f
        public void w(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            if (r8 == null) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MarkdownService", r8, null, 4, null);
            return;
        }

        @Override // com.larus.business.markdown.api.depend.f
        public void w(String r7, String r8, Throwable r9) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            if (r8 == null) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MarkdownService", r8, null, 4, null);
            return;
        }

        @Override // com.larus.business.markdown.api.depend.f
        public void w(String r7, Throwable r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            if (r8 == null) goto L6;
            String r6 = r8.toString();
            if (r6 == null) goto L6;
        L7:
            IRunLog.a.a(r0, "MarkdownService", r6, null, 4, null);
            return;
        L6:
            r6 = "";
            goto L7
        }
    }

    static {
        f9973a = new a();
        f9974b = new AtomicBoolean(false);
    }

    private a() {
    }

    private final void c() {
        long r0 = System.currentTimeMillis();
        com.larus.business.markdown.api.a r6 = com.larus.business.markdown.api.a.f5138a.d();
        if (r6 == null) goto L5;
        r6.init((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.preCheckCast(new C0484a(), c.class, "com.obric.memorydata.plugin"));
    L5:
        com.larus.business.markdown.api.a.f5138a.a((f) ZeusTransformUtils.preCheckCast(new b(), f.class, "com.obric.memorydata.plugin"));
        RunLog.INSTANCE.debug("MarkdownService", "init cost: " + (System.currentTimeMillis() - r0) + "ms");
    }

    public final void a() {
        if (f9974b.compareAndSet(false, true) == false) goto L6;
        c();
        return;
    }

    public final com.larus.business.markdown.api.a b() {
        a();
        return com.larus.business.markdown.api.a.f5138a.d();
    }
}
