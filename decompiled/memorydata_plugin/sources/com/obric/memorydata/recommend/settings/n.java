package com.obric.memorydata.recommend.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0003R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/recommend/settings/ScreenObservationCellularMutation;", "", "initialEnabled", "", "persist", "Lkotlin/Function1;", "", "rescheduleUpload", "changePublisher", "Lcom/obric/memorydata/recommend/settings/RecorderSettingsChangePublisher;", "<init>", "(ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/obric/memorydata/recommend/settings/RecorderSettingsChangePublisher;)V", "_enabled", "Lkotlinx/coroutines/flow/MutableStateFlow;", "enabled", "Lkotlinx/coroutines/flow/StateFlow;", "getEnabled", "()Lkotlinx/coroutines/flow/StateFlow;", "save", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1<Boolean, Unit> f12614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<Boolean, Unit> f12615b;
    private final m c;
    private final ae<Boolean> d;
    private final ar<Boolean> e;

    public n(boolean r3, Function1<? super Boolean, Unit> r4, Function1<? super Boolean, Unit> r5, m r6) {
        Function1<Boolean, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Function1<Boolean, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        m r9 = (m) ZeusTransformUtils.wrapperContextForParams(r6, m.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "persist");
        Intrinsics.checkNotNullParameter(r8, "rescheduleUpload");
        Intrinsics.checkNotNullParameter(r9, "changePublisher");
        this.f12614a = r7;
        this.f12615b = r8;
        this.c = r9;
        ae<Boolean> r10 = at.a(Boolean.valueOf(r3));
        this.d = r10;
        this.e = kotlinx.coroutines.flow.k.a(r10);
    }

    public final ar<Boolean> a() {
        return this.e;
    }

    public final void a(boolean r3) {
        this.f12614a.invoke(Boolean.valueOf(r3));
        this.d.b(Boolean.valueOf(r3));
        this.f12615b.invoke(Boolean.valueOf(r3));
        this.c.publish("content://com.obric.memorydata.memory.ailabprovider/recorder_settings/cellular");
    }
}
