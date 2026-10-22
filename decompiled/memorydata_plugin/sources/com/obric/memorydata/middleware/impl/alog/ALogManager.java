package com.obric.memorydata.middleware.impl.alog;

import android.content.Context;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.alog.c;
import com.bytedance.android.alog.e;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.middleware.api.DataInterceptor;
import com.obric.memorydata.middleware.api.alog.IALogManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.settings.AppSettingsManager;
import com.ss.android.agilelogger.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0007J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/middleware/impl/alog/ALogManager;", "Lcom/obric/memorydata/middleware/api/alog/IALogManager;", "<init>", "()V", "getInst", "TAG", "", "ALOG_MAX_DIR_SIZE", "", "ALOG_PER_FILE_SZIE", "upload", "", "startTimeSec", "", "endTimeSec", MemoryInfoSectionEditActivity.KIND_SCENE, "uploadId", CommonConsts.APM_INNER_EVENT_COST_INIT, "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ALogManager implements IALogManager {
    private static final int ALOG_MAX_DIR_SIZE = 62914560;
    private static final int ALOG_PER_FILE_SZIE = 3145728;
    public static final ALogManager INSTANCE = null;
    private static final String TAG = "ALogInitTask";

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/obric/memorydata/middleware/impl/alog/ALogManager$init$1", "Lcom/bytedance/android/alog/IMessageInterceptor;", "intercept", "Lcom/bytedance/android/alog/MsgInfo;", "msgInfo", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements c {
        a() {
        }

        @Override // com.bytedance.android.alog.c
        public e a(e r6) {
            if (r6 != null) goto L5;
            return null;
        L5:
            int r0 = r6.f1010a + 2;
            DataInterceptor r1 = DataInterceptor.INSTANCE;
            String r2 = r6.f1011b;
            Intrinsics.checkNotNullExpressionValue(r2, LocationMonitorConst.TAG);
            String r3 = r6.c;
            Intrinsics.checkNotNullExpressionValue(r3, NotificationCompat.CATEGORY_MESSAGE);
            if (r1.interceptLog(r2, r0, r3) == false) goto L9;
            return null;
        L9:
            if (AppContext.INSTANCE.isDebug() == false) goto L11;
        L14:
            boolean r5 = true;
        L15:
            if (r5 == false) goto L17;
        L27:
            return r6;
        L17:
            if (AppSettingsManager.INSTANCE.hasInited() == false) goto L27;
            if (AppSettingsManager.INSTANCE.getDataUploadSettings().getForcePrintLogcat() == false) goto L27;
            if (r0 != 5) goto L23;
            Log.w(r6.f1011b, r6.c);
            goto L27
        L23:
            if (r0 == 6) goto L25;
            Log.d(r6.f1011b, r6.c);
            goto L27
        L25:
            Log.e(r6.f1011b, r6.c);
            goto L27
        L11:
            if (AppContext.INSTANCE.isAllLogEnabled() == true) goto L14;
            r5 = false;
            goto L15
        }
    }

    static {
        INSTANCE = new ALogManager();
    }

    private ALogManager() {
    }

    @JvmStatic
    public static final ALogManager getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.middleware.api.alog.IALogManager
    public void init() {
        com.ss.android.agilelogger.a.a((com.ss.android.agilelogger.c) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.impl.log.a.f11750a, com.ss.android.agilelogger.c.class, "com.obric.memorydata.plugin"));
        b.a r3 = new b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).a(ALOG_MAX_DIR_SIZE).b(ALOG_PER_FILE_SZIE).a(1.0f);
        boolean r0 = true;
        com.ss.android.agilelogger.a.a(r3.a(true).a());
        if (AppContext.INSTANCE.isLocalTest() == false) goto L5;
    L8:
        com.ss.android.agilelogger.a.a(r0);
        com.ss.android.agilelogger.a.a((c) ZeusTransformUtils.preCheckCast(new a(), c.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        if (AppContext.INSTANCE.isAllLogEnabled() == true) goto L8;
        r0 = false;
        goto L8
    }

    @Override // com.obric.memorydata.middleware.api.alog.IALogManager
    public void upload(long r8, long r10, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, MemoryInfoSectionEditActivity.KIND_SCENE);
        Intrinsics.checkNotNullParameter(r13, "uploadId");
        com.obric.memorydata.middleware.impl.alog.a.f11681a.a(r8, r10, r12, r13);
    }
}
