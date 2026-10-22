package com.obric.aikernel.middleware.impl.alog;

import com.obric.aikernel.middleware.api.alog.IALogManager;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.ss.android.agilelogger.ALog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import m6.c;
import n6.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ALogManager implements IALogManager {
    public static final ALogManager INSTANCE = null;
    private static final Lazy logPath$delegate = null;

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<String> f4555a;

        a() {
        }

        @Override // m6.c
        public List<String> b(long r10, long r11, JSONObject r12) {
            Intrinsics.checkNotNullParameter(r12, "params");
            List<String> r13 = ALogManager.INSTANCE.getALogFiles(r10, r11);
            this.f4555a = r13;
            return r13;
        }

        @Override // m6.e
        public b c() {
            List<String> r10 = this.f4555a;
            if (r10 != null) goto L5;
        L8:
            boolean r11 = true;
        L9:
            boolean r12 = !r11;
            if (r11 == false) goto L12;
            String r13 = "log file not get";
        L13:
            b r14 = b.a(r12, r13, null);
            Intrinsics.checkNotNullExpressionValue(r14, "build(\n                 …\", null\n                )");
            return r14;
        L12:
            r13 = "";
            goto L13
        L5:
            if (r10.isEmpty() == true) goto L8;
            r11 = false;
            goto L9
        }
    }

    static {
        INSTANCE = new ALogManager();
        logPath$delegate = LazyKt.lazy(ALogManager$logPath$2.INSTANCE);
    }

    private ALogManager() {
    }

    @JvmStatic
    public static final ALogManager getInst() {
        return INSTANCE;
    }

    private final void getLogFiles(File r10, List<String> r11) {
        File[] r12 = r10.listFiles();
        if (r12 == null) goto L13;
        int r13 = 0;
        int r14 = r12.length;
    L5:
        if (r13 >= r14) goto L18;
        File r15 = r12[r13];
        if (r15.isFile() == false) goto L10;
        String r16 = r15.getPath();
        Intrinsics.checkNotNullExpressionValue(r16, "it.path");
        r11.add(r16);
    L12:
        r13 = r13 + 1;
        goto L5
    L10:
        if (r15.isDirectory() == false) goto L12;
        ALogManager r17 = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r15, "it");
        r17.getLogFiles(r15, r11);
        goto L12
    L18:
        return;
    }

    private final String getLogPath() {
        return (String) logPath$delegate.getValue();
    }

    private final void implementLogReCatch() {
        k6.a.v(new a());
    }

    private final void interceptAlog(com.ss.android.agilelogger.a.b r10) {
        AppContext r11 = AppContext.INSTANCE;
        r10.c(!r11.isDebug());
        r10.b(!r11.isDebug());
        r10.h(true);
        r10.g(true);
        r10.e(getLogPath());
    }

    @Override // com.obric.aikernel.middleware.api.alog.IALogManager
    public List<String> getALogFiles(long r10, long r11) {
        if (r10 >= r11) goto L10;
        ALog.asyncFlush();
        Thread.sleep(1000);     // Catch: InterruptedException -> L7
    L9:
        List<String> r12 = ALog.getALogFiles(r10, r11);
    L11:
        if (r12 == null) goto L13;
        return r12;
    L13:
        return CollectionsKt.emptyList();
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L10:
        r12 = null;
        goto L11
    }

    @Override // com.obric.aikernel.middleware.api.alog.IALogManager
    public List<String> getLogFiles() {
        ALog.asyncFlush();
        Thread.sleep(1000);     // Catch: InterruptedException -> L5
    L7:
        ArrayList r10 = new ArrayList();
        getLogFiles(new File(getLogPath()), r10);
        return r10;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // com.obric.aikernel.middleware.api.alog.IALogManager
    public void init() {
        AppContext r10 = AppContext.INSTANCE;
        com.ss.android.agilelogger.a.b r11 = new com.ss.android.agilelogger.a.b(r10.getContext()).f(IALogManager.ALOG_MAX_DIR_SIZE).i(2097152).d(2);
        ALogManager r12 = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r11, "this");
        r12.interceptAlog(r11);
        if (r10.isDebug() == false) goto L5;
    L8:
        boolean r13 = true;
    L9:
        ALog.setDebug(r13);
        ALog.init(r11.a());
        com.obric.aikernel.api.b.f4431a.h().c();
        return;
    L5:
        if (r10.isLocalTest() == true) goto L8;
        r13 = false;
        goto L9
    }

    @Override // com.obric.aikernel.middleware.api.alog.IALogManager
    public void setAlogConsumer() {
        implementLogReCatch();
    }
}
