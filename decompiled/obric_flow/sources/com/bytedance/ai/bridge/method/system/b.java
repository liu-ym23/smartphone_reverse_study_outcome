package com.bytedance.ai.bridge.method.system;

import android.app.Activity;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.OnPermissionGrantCallback;
import com.lynx.tasm.behavior.ui.utils.e;
import com.obric.feature.miniapp.widget.depend.ObricLauncherHostSystemActionServiceImpl;
import k5.d;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements OnPermissionGrantCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f2007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f2008b;

    public b(Activity r5, f r10) {
        this.f2007a = r5;
        this.f2008b = r10;
    }

    @Override // com.bytedance.ai.bridge.service.OnPermissionGrantCallback
    public final void onAllGranted() {
        Activity r5 = this.f2007a;
        f r10 = this.f2008b;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L7
        boolean r12 = f8.b.i(r5);     // Catch: Throwable -> L7
        ObricLauncherHostSystemActionServiceImpl r13 = d.g;     // Catch: Throwable -> L7
        if (r13 != null) goto L9;
        r10.a("HostSystemActionDepend is null");     // Catch: Throwable -> L7
        return;
    L9:
        r13.getLocation(r5, new a(r10, r12));     // Catch: Throwable -> L7
        Object r14 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L12:
        Throwable r15 = Result.m127exceptionOrNullimpl(r14);
        if (r15 == null) goto L17;
        r10.a("get location err:" + r15.getMessage());
        return;
    L17:
        return;
    L7:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // com.bytedance.ai.bridge.service.OnPermissionGrantCallback
    public final void onNotGranted() {
        Intrinsics.checkNotNullParameter(AbsGetLocationMethodIDL.GetLocationResultModel.class, "<this>");
        BaseModel r5 = e.c(AbsGetLocationMethodIDL.GetLocationResultModel.class);
        AbsGetLocationMethodIDL.GetLocationResultModel r10 = (AbsGetLocationMethodIDL.GetLocationResultModel) r5;
        r10.setEnable(Boolean.FALSE);
        r10.setLongitude(null);
        r10.setLatitude(null);
        Unit r11 = Unit.INSTANCE;
        f r12 = this.f2008b;
        r12.c("no location permission", (ResultModel) r5);
    }
}
