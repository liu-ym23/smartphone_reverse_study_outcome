package com.obric.memorydata.recommend.c;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\tJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/recommend/oauto/OAutoStateObserver;", "", "<init>", "()V", "TAG", "", "HAS_ONGOING_TASK", "IN_CALL_USER", "isRunningTask", "", "isCallUser", "oAutoProviderUri", "Landroid/net/Uri;", "oAutoListener", "com/obric/memorydata/recommend/oauto/OAutoStateObserver$oAutoListener$1", "Lcom/obric/memorydata/recommend/oauto/OAutoStateObserver$oAutoListener$1;", "isOAutoRunningAndNotCallUser", "reset", "", CommonConsts.APM_INNER_EVENT_COST_START, "stop", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12500a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f12501b;
    private static boolean c;
    private static final Uri d = null;
    private static final C0666a e = null;

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.c.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/recommend/oauto/OAutoStateObserver$oAutoListener$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0666a extends ContentObserver {
        C0666a(Handler r1) {
            super(r1);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r7) {
            Bundle r6 = ZeusProviderTransform.call(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "com.obric.autoaction.AgentStateProvider", "get_current_state", null, null, "com.obric.memorydata.plugin");
            if (r6 != null) goto L7;
            a r8 = a.f12500a;
            a.a(false);
            IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            boolean r3 = false;
            int r4 = 4;
            Object r5 = null;
            String r1 = "OAutoStateObserver";
            String r2 = "获取OAuto 状态失败";
        L5:
            IRunLog.a.a(r0, r1, r2, r3, r4, r5);
            return;
        L7:
            a r9 = a.f12500a;
            a.a(r6.getBoolean("has_ongoing_task", false));
            if (a.e() == true) goto L10;
            r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            r3 = false;
            r4 = 4;
            r5 = null;
            r1 = "OAutoStateObserver";
            r2 = "OAuto 未运行";
            goto L5
        L10:
            a r10 = a.f12500a;
            a.b(r6.getBoolean("in_call_user", false));
            r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            r2 = "OAuto 运行中，是否是用户接管状态：" + a.f();
            r3 = false;
            r4 = 4;
            r5 = null;
            r1 = "OAutoStateObserver";
            goto L5
        }
    }

    static {
        f12500a = new a();
        d = Uri.parse("content://com.obric.autoaction.AgentStateProvider");
        e = new C0666a(new Handler(Looper.getMainLooper()));
    }

    private a() {
    }

    public static final /* synthetic */ void a(boolean r0) {
        f12501b = r0;
    }

    public static final /* synthetic */ void b(boolean r0) {
        c = r0;
    }

    public static final /* synthetic */ boolean e() {
        return f12501b;
    }

    public static final /* synthetic */ boolean f() {
        return c;
    }

    public final boolean a() {
        if (f12501b == true) goto L5;
    L7:
        return false;
    L5:
        if (c == true) goto L7;
        return true;
    }

    public final void b() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OAutoStateObserver", "reset OAuto state", false, 4, null);
        f12501b = false;
        c = false;
    }

    public final void c() {
        ZeusProviderTransform.registerContentObserver(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), d, true, (ContentObserver) ZeusTransformUtils.preCheckCast(e, ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        RunLog.INSTANCE.error("OAutoStateObserver", "start OAutoStateObserver error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final void d() {
        ZeusProviderTransform.unregisterContentObserver(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), (ContentObserver) ZeusTransformUtils.preCheckCast(e, ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }
}
