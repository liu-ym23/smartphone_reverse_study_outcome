package com.obric.memorydata.middleware.api.log;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.news.common.service.manager.IService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\"\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fH&J$\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J$\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/middleware/api/log/IRunLog;", "Lcom/bytedance/news/common/service/manager/IService;", "debugLocalTest", "", LocationMonitorConst.TAG, "", "message", "data", "", "debug", "info", "printLogcat", "", "warn", "trace", "", "error", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IRunLog extends IService {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ void a(IRunLog r2, String r3, String r4, Object r5, int r6, Object r7) {
            IRunLog r8 = (IRunLog) ZeusTransformUtils.wrapperContextForParams(r2, IRunLog.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 4) == 0) goto L7;
            r5 = null;
        L7:
            r8.debugLocalTest(r3, r4, r5);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: debugLocalTest");
        }

        public static /* synthetic */ void a(IRunLog r2, String r3, String r4, Throwable r5, int r6, Object r7) {
            IRunLog r8 = (IRunLog) ZeusTransformUtils.wrapperContextForParams(r2, IRunLog.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 4) == 0) goto L7;
            r5 = null;
        L7:
            r8.warn(r3, r4, r5);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: warn");
        }

        public static /* synthetic */ void a(IRunLog r2, String r3, String r4, boolean r5, int r6, Object r7) {
            IRunLog r8 = (IRunLog) ZeusTransformUtils.wrapperContextForParams(r2, IRunLog.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 4) == 0) goto L7;
            r5 = false;
        L7:
            r8.info(r3, r4, r5);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: info");
        }

        public static /* synthetic */ void b(IRunLog r2, String r3, String r4, Throwable r5, int r6, Object r7) {
            IRunLog r8 = (IRunLog) ZeusTransformUtils.wrapperContextForParams(r2, IRunLog.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 4) == 0) goto L7;
            r5 = null;
        L7:
            r8.error(r3, r4, r5);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
        }
    }

    void debug(String r1, String r2);

    void debugLocalTest(String r1, String r2, Object r3);

    void error(String r1, String r2, Throwable r3);

    void info(String r1, String r2, boolean r3);

    void warn(String r1, String r2, Throwable r3);
}
