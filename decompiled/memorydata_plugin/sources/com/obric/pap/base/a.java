package com.obric.pap.base;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0016J \u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H&J\u001e\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u001e\u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0016J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u001e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u001e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u001e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/pap/base/HostLogger;", "", "isLoggable", "", "priority", "", LocationMonitorConst.TAG, "", "log", "", Params.CONTENT, "Lkotlin/Function0;", "logD", "logE", "logI", "logV", "logW", "PythonBase_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface a {

    /* JADX INFO: renamed from: com.obric.pap.base.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class C0796a {
        public static void a(a r2, int r3, String r4, Function0<String> r5) {
            a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r7, Params.CONTENT);
            boolean r0 = r6.isLoggable(r3, r4);     // Catch: AbstractMethodError -> L5
        L6:
            if (r0 == false) goto L11;
            r6.log(r3, r4, (String) ZeusTransformUtils.preCheckCast(r7.invoke(), String.class, "com.obric.memorydata.plugin"));
            return;
        L11:
            return;
        L5:
            r0 = true;
            goto L6
        }

        public static void a(a r2, String r3, String r4) {
            a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r4, Params.CONTENT);
            r5.log(2, r3, r4);
        }

        public static void a(a r2, String r3, Function0<String> r4) {
            a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Function0<String> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r6, Params.CONTENT);
            r5.log(2, r3, r6);
        }

        public static void b(a r2, String r3, String r4) {
            a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r4, Params.CONTENT);
            r5.log(3, r3, r4);
        }

        public static void b(a r2, String r3, Function0<String> r4) {
            a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Function0<String> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r6, Params.CONTENT);
            r5.log(3, r3, r6);
        }

        public static void c(a r2, String r3, String r4) {
            a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r4, Params.CONTENT);
            r5.log(4, r3, r4);
        }

        public static void c(a r2, String r3, Function0<String> r4) {
            a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Function0<String> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r6, Params.CONTENT);
            r5.log(4, r3, r6);
        }

        public static void d(a r2, String r3, String r4) {
            a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r4, Params.CONTENT);
            r5.log(5, r3, r4);
        }

        public static void d(a r2, String r3, Function0<String> r4) {
            a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Function0<String> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r6, Params.CONTENT);
            r5.log(5, r3, r6);
        }

        public static void e(a r2, String r3, String r4) {
            a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r4, Params.CONTENT);
            r5.log(6, r3, r4);
        }

        public static void e(a r2, String r3, Function0<String> r4) {
            a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Function0<String> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r6, Params.CONTENT);
            r5.log(6, r3, r6);
        }
    }

    boolean isLoggable(int r1, String r2);

    void log(int r1, String r2, String r3);

    void log(int r1, String r2, Function0<String> r3);

    void logE(String r1, String r2);

    void logI(String r1, String r2);

    void logI(String r1, Function0<String> r2);

    void logW(String r1, String r2);
}
