package com.bytedance.ies.experiment;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.ies.abmock.a.c;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.ies.abmock.a.a(a = "ttk_abmock_fetch_data_optimized_experiment_3")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0083D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0002X\u0083D¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/experiment/ABFetchDataOptimizedExperiment;", "", "()V", IslandSession.REOPEN_VALUE_CLOSE, "", "open", EventBody.KEY_VALUE, "getValue", "()Z", "value$delegate", "Lkotlin/Lazy;", "isOpenFetchOptimizedRequest", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2749a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c
    private static final boolean f2750b = false;
    private static final Lazy c = null;

    static {
        f2749a = new a();
        f2750b = true;
        c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(ABFetchDataOptimizedExperiment$value$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    private a() {
    }
}
