package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.utils.ConvertUtils;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.monitor.AppletMonitorableEvent$EventOrigin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements z2.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsCreateWidgetMethodIDL.CreateWidgetParamModel f1950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppletRuntime f1951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1952c;
    public final /* synthetic */ PageInfo d;

    public e(AbsCreateWidgetMethodIDL.CreateWidgetParamModel r5, AppletRuntime r10, String r11, PageInfo r12) {
        this.f1950a = r5;
        this.f1951b = r10;
        this.f1952c = r11;
        this.d = r12;
    }

    @Override // z2.g
    public final void b(z2.f r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        AppletMonitorableEvent$EventOrigin r10 = AppletMonitorableEvent$EventOrigin.f2386c;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r5.f23385c = r10;
        String r11 = ConvertUtils.toJavaOnlyMap(this.f1950a.getContext()).getString("msgId", null);
        if (r11 == null) goto L5;
        r5.c("message_id", r11);
    L5:
        r5.f = this.f1951b.f2197h.i();
        r5.g = this.f1952c;
        r5.e(this.d.buildMonitorEvent());
    }
}
