package com.obric.memorydata.middleware.impl.alog;

import android.app.Application;
import com.bytedance.apm.net.DefaultHttpServiceImpl;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.services.apm.api.IHttpService;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.logging.e;
import com.obric.memorydata.middleware.api.logging.g;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.api.logging.w;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\f\u001a\u00020\u0005H\u0002J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/middleware/impl/alog/ALogUploader;", "", "<init>", "()V", "upload", "", "startTimeSec", "", "endTimeSec", MemoryInfoSectionEditActivity.KIND_SCENE, "", "uploadId", "ensureHttpService", "buildParams", "Lorg/json/JSONObject;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11681a = null;

    static {
        f11681a = new a();
    }

    private a() {
    }

    private static final Unit a(long r1, long r3, String r5, g r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$mainTrace");
        r6.a("start_sec", Long.valueOf(r1));
        r6.a("end_sec", Long.valueOf(r3));
        r6.a(MemoryInfoSectionEditActivity.KIND_SCENE, r5);
        return Unit.INSTANCE;
    }

    private static final Unit a(List r2, g r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "$this$mainTrace");
        r3.a("file_count", Integer.valueOf(r4.size()));
        return Unit.INSTANCE;
    }

    private final void a() {
        monitor-enter(ServiceManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (ServiceManager.getService(IHttpService.class) != null) goto L7;
        ServiceManager.registerService(IHttpService.class, new DefaultHttpServiceImpl());     // Catch: Throwable -> L10
    L7:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(ServiceManager.class);
    }

    private static final void a(long r12, long r14, final e r16, String r17, String r18) {
        com.ss.android.agilelogger.a.d();
        final List<String> r3 = com.ss.android.agilelogger.a.a(r12, r14);
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        ((o) ZeusTransformUtils.preCheckCast(w.f11638a, o.class, "com.obric.memorydata.plugin")).a("alog_files_empty", "时间范围内没有 ALog 文件", r16, new g().a());
        return;
    L12:
        String r4 = AppContext.INSTANCE.getServerDeviceId();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L15;
    L19:
        ((o) ZeusTransformUtils.preCheckCast(w.f11638a, o.class, "com.obric.memorydata.plugin")).a("alog_identity_not_ready", "ALog 上传缺少设备注册信息", r16, new g().a());
        return;
    L15:
        if (Intrinsics.areEqual(r4, "0") == true) goto L19;
        a r5 = f11681a;
        r5.a();
        JSONObject r6 = r5.b(r12, r14, r17, r18);
        com.bytedance.apm.a.a.a.a(String.valueOf(AppContext.INSTANCE.getAid()), r4, Application.getProcessName(), r3, r17, r6, new $$Lambda$a$eJoyOTsgMeAOZYBfFvkd4uhckL0(r16, r3));
        return;
    L5:
        if (r1.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    private static final void a(e r8, List r9, boolean r10, int r11, Exception r12, JSONObject r13) {
        final List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        if (r10 == false) goto L5;
        o.a((o) ZeusTransformUtils.preCheckCast(w.f11638a, o.class, "com.obric.memorydata.plugin"), "ALog 上传成功", "alog_upload_success", r8, new $$Lambda$a$oo8gkTsfk08LrGC_37EimeZ9js(r14), null, 16, null);
        return;
    L5:
        ((o) ZeusTransformUtils.preCheckCast(w.f11638a, o.class, "com.obric.memorydata.plugin")).a("alog_upload_failed", "ALog 上传失败 file_count=" + r14.size() + " sdk_code=" + r11, r8, new g().a());
    }

    private final JSONObject b(long r3, long r5, String r7, String r8) {
        JSONObject r2 = new JSONObject();
        r2.put("aid", AppContext.INSTANCE.getAid());
        r2.put("device_id", AppContext.INSTANCE.getServerDeviceId());
        r2.put("os", LocationInfoConst.SYSTEM);
        r2.put("app_version", AppContext.INSTANCE.getVersionName());
        r2.put("version_code", AppContext.INSTANCE.getVersionCode());
        r2.put("update_version_code", AppContext.INSTANCE.getUpdateVersionCode());
        r2.put("channel", AppContext.INSTANCE.getChannel());
        r2.put("alog_upload_id", r8);
        r2.put("alog_start_time_sec", r3);
        r2.put("alog_end_time_sec", r5);
        r2.put("alog_scene", r7);
        return r2;
    }

    /* JADX INFO: renamed from: lambda$6bCs-_oToG8AKVykdqENZcC8o_M, reason: not valid java name */
    public static /* synthetic */ Unit m1013lambda$6bCs_oToG8AKVykdqENZcC8o_M(long r0, long r2, String r4, g r5) {
        return a(r0, r2, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$XatqjiC41-T3ss5r8SeUEyCudDU, reason: not valid java name */
    public static /* synthetic */ void m1014lambda$XatqjiC41T3ss5r8SeUEyCudDU(long r0, long r2, e r4, String r5, String r6) {
        a(r0, r2, r4, r5, r6);
    }

    public static /* synthetic */ void lambda$eJoyOTsgMeAOZYBfFvkd4uhckL0(e r0, List r1, boolean r2, int r3, Exception r4, JSONObject r5) {
        a(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$o-o8gkTsfk08LrGC_37EimeZ9js, reason: not valid java name */
    public static /* synthetic */ Unit m1015lambda$oo8gkTsfk08LrGC_37EimeZ9js(List r0, g r1) {
        return a(r0, r1);
    }

    public final void a(final long r18, final long r20, final String r22, final String r23) {
        Intrinsics.checkNotNullParameter(r22, MemoryInfoSectionEditActivity.KIND_SCENE);
        Intrinsics.checkNotNullParameter(r23, "uploadId");
        final e r0 = new e(null, r23, "alog_upload", 1, null);
        if (com.ss.android.agilelogger.a.a() == true) goto L6;
        ((o) ZeusTransformUtils.preCheckCast(w.f11638a, o.class, "com.obric.memorydata.plugin")).a("alog_not_initialized", "ALog 尚未初始化", r0, new g().a());
        return;
    L6:
        o.a((o) ZeusTransformUtils.preCheckCast(w.f11638a, o.class, "com.obric.memorydata.plugin"), "触发 ALog 上传", "alog_upload", r0, new $$Lambda$a$6bCs_oToG8AKVykdqENZcC8o_M(r18, r20, r22), null, 16, null);
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$a$XatqjiC41T3ss5r8SeUEyCudDU(r18, r20, r0, r22, r23));
    }
}
