package com.obric.aikernel.service.res;

import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aikernel.RequestTracker;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.traker.ITrackerApi;
import com.obric.aikernel.middleware.api.traker.TrackerApi;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.update.PackageUpdater;
import com.obric.aikernel.res.update.UpdateResult;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class UpdateListener implements PackageResourceManager.PresmConfig.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1<com.obric.aikernel.res.update.a, Unit> f5514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<String> f5515b;

    /* JADX WARN: Multi-variable type inference failed */
    public UpdateListener(Function1<? super com.obric.aikernel.res.update.a, Unit> r10, Function0<String> r11) {
        Intrinsics.checkNotNullParameter(r11, "hostPackageNameProvider");
        this.f5514a = r10;
        this.f5515b = r11;
    }

    public /* synthetic */ UpdateListener(Function1 r10, Function0 r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = AnonymousClass1.INSTANCE;
    L8:
        this(r10, r11);
    }

    @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.e
    public void a(com.obric.aikernel.res.update.a r10) {
        Intrinsics.checkNotNullParameter(r10, "result");
        Function1<com.obric.aikernel.res.update.a, Unit> r11 = this.f5514a;
        if (r11 == null) goto L6;
        r11.invoke(r10);
        return;
    }

    @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.e
    public void b(UpdateResult r10) {
        Intrinsics.checkNotNullParameter(r10, "result");
        o r11 = p.c(r10.getCaller(), this.f5515b.invoke());
        JSONObject r12 = new JSONObject();
        r12.put("biz", r10.getBiz());
        boolean r13 = r10.getSuccess();
        if (r13 != true) goto L5;
        String r14 = NetConst.NOT_ENCRYPT_VERISON_CODE;
    L7:
        r12.put("status", r14);
        r12.put("caller", r11.a());
        r12.put(ITrackerApi.CALLER_PKG, r11.a());
        r12.put("trigger_scene", r11.b());
        JSONObject r15 = new JSONObject();
        long r16 = r10.getFinishTimestamp() - r10.getStartTimestamp();
        if (r16 <= 0) goto L10;
        r15.put("duration", r16);
    L10:
        r15.put("thermal", n7.a.f11264a.a().getValue().intValue());
        TrackerApi.INSTANCE.onEvent("package_update_event", RequestTracker.f4406c.b(r12, r15, null));
        return;
    L5:
        if (r13 == true) goto L13;
        r14 = String.valueOf(r10.getStage());
        goto L7
    L13:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.e
    public void c(PackageUpdater.b r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "constriction");
        Intrinsics.checkNotNullParameter(r11, "bizStat");
        Intrinsics.checkNotNullParameter(r12, WsConstants.KEY_CONNECTION_TYPE);
        o r13 = p.c(r10.b(), this.f5515b.invoke());
        TrackerApi r14 = TrackerApi.INSTANCE;
        JSONObject r15 = new JSONObject();
        r15.put("caller", r13.a());
        r15.put(ITrackerApi.CALLER_PKG, r13.a());
        r15.put("trigger_scene", r13.b());
        r15.put("bizStat", r11);
        r15.put(WsConstants.KEY_CONNECTION_TYPE, r12);
        r15.put("onlyDownload", r10.d());
        r15.put("prior", r10.f());
        r15.put("force", r10.c());
        r15.put("background", r10.a());
        Unit r16 = Unit.INSTANCE;
        r14.onEvent("request_update", r15);
    }

    @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.e
    public void d(com.obric.aikernel.res.update.h r10) {
        Intrinsics.checkNotNullParameter(r10, "result");
        TrackerApi.INSTANCE.onEvent("model_download_event", p.a(r10, AppContext.INSTANCE.getBuildInfo()));
    }
}
