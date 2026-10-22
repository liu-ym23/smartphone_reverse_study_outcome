package com.obric.memorydata.screencapture.service;

import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.screencapture.ScreenEventReaction;
import com.obric.memorydata.sdk.screencapture.TaskOptions;
import com.obric.memorydata.sdk.screencapture.c;
import com.obric.memorydata.sdk.screencapture.d;
import com.obric.memorydata.utils.ak;
import com.obric.memorydata.utils.j;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/screencapture/service/ScreenCaptureService;", "Landroid/app/Service;", "<init>", "()V", "TAG", "", "onBind", "Landroid/os/IBinder;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "getCallPackage", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenCaptureService extends PluginService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12809a;

    @Metadata(d1 = {"\u0000M\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J \u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u001aH\u0016¨\u0006\u001b"}, d2 = {"com/obric/memorydata/screencapture/service/ScreenCaptureService$onBind$1", "Lcom/obric/memorydata/sdk/service/IScreenCaptureService$Stub;", "onTransact", "", "code", "", "data", "Landroid/os/Parcel;", "reply", "flags", "register", "", "screenEventReaction", "Lcom/obric/memorydata/sdk/screencapture/ScreenEventReaction;", LocationMonitorConst.TIMEOUT, "", "callback", "Lcom/obric/memorydata/sdk/screencapture/IEventReactionCallback;", "unregister", "ruleId", "", "getScreenEventReactionCount", "captureCurrent", "options", "Lcom/obric/memorydata/sdk/screencapture/TaskOptions;", "targetPackage", "Lcom/obric/memorydata/sdk/screencapture/ICaptureCurrentCallback;", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends com.obric.memorydata.sdk.service.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScreenCaptureService f12810a;

        a(ScreenCaptureService r3) {
            this.f12810a = (ScreenCaptureService) ZeusTransformUtils.wrapperContextForParams(r3, ScreenCaptureService.class, "com.obric.memorydata.plugin");
        }

        private static final Unit b(ScreenEventReaction r2, long r3, d r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.memorydata.plugin");
            com.obric.memorydata.screencapture.d.f12797a.a().a(r2, r3, r6);
            return Unit.INSTANCE;
        }

        private static final Unit b(String r1) {
            com.obric.memorydata.screencapture.d.f12797a.a().a(r1);
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit lambda$48VVQ1zyLXCc84nER98nIY2Gpyo(String r0) {
            return b(r0);
        }

        public static /* synthetic */ Unit lambda$hFIBUcJzocLhGzTWpMWymUUYXFs(ScreenEventReaction r0, long r1, d r3) {
            return b(r0, r1, r3);
        }

        @Override // com.obric.memorydata.sdk.service.b
        public int a() {
            String r1 = ScreenCaptureService.b(this.f12810a);
            return com.obric.memorydata.screencapture.d.f12797a.a().b(r1);
        }

        @Override // com.obric.memorydata.sdk.service.b
        public void a(final ScreenEventReaction r3, final long r4, d r6) {
            final d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "screenEventReaction");
            Intrinsics.checkNotNullParameter(r7, "callback");
            r3.setSourcePackage(ScreenCaptureService.b(this.f12810a));
            j.a(new $$Lambda$ScreenCaptureService$a$hFIBUcJzocLhGzTWpMWymUUYXFs(r3, r4, r7));
        }

        @Override // com.obric.memorydata.sdk.service.b
        public void a(TaskOptions r20, String r21, c r22) {
            c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r22, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r20, "options");
            Intrinsics.checkNotNullParameter(r21, "targetPackage");
            Intrinsics.checkNotNullParameter(r4, "callback");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ScreenCaptureService.a(this.f12810a), "captureCurrent start pkg=" + r21, false, 4, null);
            i.a(j.a(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ScreenCaptureService$onBind$1$captureCurrent$1(r20, r21, this.f12810a, r4, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        }

        @Override // com.obric.memorydata.sdk.service.b
        public void a(final String r1) {
            Intrinsics.checkNotNullParameter(r1, "ruleId");
            j.a(new $$Lambda$ScreenCaptureService$a$48VVQ1zyLXCc84nER98nIY2Gpyo(r1));
        }

        @Override // com.obric.memorydata.sdk.service.b.a, android.os.Binder
        public boolean onTransact(int r7, Parcel r8, Parcel r9, int r10) {
            Intrinsics.checkNotNullParameter(r8, "data");
            if (ak.f13164a.a() == false) goto L7;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ScreenCaptureService.a(this.f12810a), "refuse unknown app call", null, 4, null);
            return false;
        L7:
            return super.onTransact(r7, r8, r9, r10);
        }
    }

    public ScreenCaptureService() {
        this.f12809a = "ScreenCaptureService";
    }

    private final String a() {
        int r3 = Binder.getCallingUid();
        String[] r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackagesForUid(r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(ArraysKt.getOrNull(r4, 0), String.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ String a(ScreenCaptureService r2) {
        return ((ScreenCaptureService) ZeusTransformUtils.wrapperContextForParams(r2, ScreenCaptureService.class, "com.obric.memorydata.plugin")).f12809a;
    }

    public static final /* synthetic */ String b(ScreenCaptureService r2) {
        return ((ScreenCaptureService) ZeusTransformUtils.wrapperContextForParams(r2, ScreenCaptureService.class, "com.obric.memorydata.plugin")).a();
    }

    public IBinder onBind(Intent r2) {
        return (IBinder) ZeusTransformUtils.preCheckCast(new a(this), IBinder.class, "com.obric.memorydata.plugin");
    }
}
