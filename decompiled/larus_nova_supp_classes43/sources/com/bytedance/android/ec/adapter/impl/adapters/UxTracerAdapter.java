package com.bytedance.android.ec.adapter.impl.adapters;

import com.bytedance.android.ec.adapter.api.i;
import com.bytedance.android.livesdkapi.service.ILiveUxTracer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class UxTracerAdapter implements i {
    public static final Lazy a = null;
    public static final UxTracerAdapter b = null;

    public UxTracerAdapter() {
    }

    @Override // com.bytedance.android.ec.adapter.api.i
    public final void b() {
        Intrinsics.checkNotNullParameter("enter_room_api_duration", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
    }

    @Override // com.bytedance.android.ec.adapter.api.i
    public final void getSingleTimeStamp(String r10) {
        Intrinsics.checkNotNullParameter(r10, "scene");
    }

    static {
        b = new UxTracerAdapter();
        a = LazyKt.lazy(UxTracerAdapter$liveTracer$2.INSTANCE);
    }

    @Override // com.bytedance.android.ec.adapter.api.i
    public final long a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        Intrinsics.checkNotNullParameter("start", "milestone");
        return ((ILiveUxTracer) a.getValue()).getTimeStamp(r10, "start");
    }

    @Override // com.bytedance.android.ec.adapter.api.i
    public final Object getArgument(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return ((ILiveUxTracer) a.getValue()).getArgument(r10);
    }

    @Override // com.bytedance.android.ec.adapter.api.i
    public final void setBeforeReportCallback(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        ((ILiveUxTracer) a.getValue()).setBeforeReportCallback(r10);
    }
}
