package com.obric.memorydata.memory.ui.feedback;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fR\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackOdpReporter;", "", "<init>", "()V", "service", "Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackOdpReportService;", "getService", "()Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackOdpReportService;", "service$delegate", "Lkotlin/Lazy;", "reportIfEnabled", "", "feedbackContent", "", "reportDataProvider", "Lkotlin/Function0;", "Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackOdpReportData;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f10956a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f10957b = null;

    static {
        f10956a = new k();
        f10957b = LazyKt.lazy($$Lambda$k$lyDKrtuQ6f_JwNy92U_1n_oX2fw.INSTANCE);
    }

    private k() {
    }

    private final j a() {
        return (j) ZeusTransformUtils.preCheckCast(f10957b.getValue(), j.class, "com.obric.memorydata.plugin");
    }

    private static final j b() {
        return new j(null, null, null, 7, null);
    }

    public static /* synthetic */ j lambda$lyDKrtuQ6f_JwNy92U_1n_oX2fw() {
        return b();
    }

    public final void a(String r3, Function0<h> r4) {
        Function0<h> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "feedbackContent");
        a().a(r3, r5);
    }
}
