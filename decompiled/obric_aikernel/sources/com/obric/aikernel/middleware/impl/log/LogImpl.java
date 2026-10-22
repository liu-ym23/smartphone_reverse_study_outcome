package com.obric.aikernel.middleware.impl.log;

import androidx.core.app.NotificationCompat;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.ILog;
import com.ss.android.agilelogger.ALog;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.h;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.m1;

/* JADX INFO: loaded from: classes2.dex */
public final class LogImpl implements ILog {
    public static final LogImpl INSTANCE = null;
    private static final boolean NEED_PREFIX = true;
    private static final String TAG_PREFIX = "AIK_Server_";
    private static final l0 interceptScope = null;
    private static ILog interceptor;

    @SourceDebugExtension({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n*L\n1#1,110:1\n*E\n"})
    public static final class a extends AbstractCoroutineContextElement implements h0 {
        public a(h0.a r10) {
            super(r10);
        }

        @Override // kotlinx.coroutines.h0
        public void V(CoroutineContext r10, Throwable r11) {
            LogImpl.INSTANCE.e("LogInterceptScope", ExceptionsKt.stackTraceToString(r11));
        }
    }

    static {
        INSTANCE = new LogImpl();
        ExecutorService r10 = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(r10, "newSingleThreadExecutor()");
        interceptScope = m0.a(m1.b(r10).plus(new k0("LogInterceptScope")).plus(new a(h0.f10523d)));
    }

    private LogImpl() {
    }

    @JvmStatic
    public static final LogImpl getInst() {
        return INSTANCE;
    }

    private final String logTag(String r10) {
        return TAG_PREFIX + r10;
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public void aeeLog(int r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "tag");
        Intrinsics.checkNotNullParameter(r12, "content");
        ILog.a.a(this, r10, r11, r12);
        ILog r13 = interceptor;
        if (r13 == null) goto L6;
        h.d(interceptScope, null, null, new LogImpl$aeeLog$1$1(r13, r10, r11, r12, null), 3, null);
        return;
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public void d(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        ALog.d(logTag(r10), r11);
        ILog r12 = interceptor;
        if (r12 == null) goto L6;
        h.d(interceptScope, null, null, new LogImpl$d$1$1(r12, r10, r11, null), 3, null);
        return;
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public void e(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        ALog.e(logTag(r10), r11);
        ILog r12 = interceptor;
        if (r12 == null) goto L6;
        h.d(interceptScope, null, null, new LogImpl$e$1$1(r12, r10, r11, null), 3, null);
        return;
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public void e(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(r12, "t");
        ALog.e(logTag(r10), r11, r12);
        ILog r13 = interceptor;
        if (r13 == null) goto L6;
        h.d(interceptScope, null, null, new LogImpl$e$2$1(r13, r10, r11, r12, null), 3, null);
        return;
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public List<String> getALogFiles(long r10, long r11) {
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public ILog getLogInterceptor() {
        return interceptor;
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public void i(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        ALog.i(logTag(r10), r11);
        ILog r12 = interceptor;
        if (r12 == null) goto L6;
        h.d(interceptScope, null, null, new LogImpl$i$1$1(r12, r10, r11, null), 3, null);
        return;
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public boolean isDebug() {
        return AppContext.INSTANCE.isDebug();
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public void setLogInterceptor(ILog r10) {
        Intrinsics.checkNotNullParameter(r10, "interceptor");
        interceptor = r10;
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public void v(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        ALog.v(logTag(r10), r11);
        ILog r12 = interceptor;
        if (r12 == null) goto L6;
        h.d(interceptScope, null, null, new LogImpl$v$1$1(r12, r10, r11, null), 3, null);
        return;
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public void w(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        ALog.w(logTag(r10), r11);
        ILog r12 = interceptor;
        if (r12 == null) goto L6;
        h.d(interceptScope, null, null, new LogImpl$w$1$1(r12, r10, r11, null), 3, null);
        return;
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public void w(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(r12, "t");
        ALog.w(logTag(r10), r11, r12);
        ILog r13 = interceptor;
        if (r13 == null) goto L6;
        h.d(interceptScope, null, null, new LogImpl$w$2$1(r13, r10, r11, r12, null), 3, null);
        return;
    }
}
