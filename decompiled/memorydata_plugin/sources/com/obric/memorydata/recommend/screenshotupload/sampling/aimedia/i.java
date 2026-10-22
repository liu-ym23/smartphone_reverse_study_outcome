package com.obric.memorydata.recommend.screenshotupload.sampling.aimedia;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007J\n\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0002¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaRuntimeAvailability;", "", "<init>", "()V", "hasAIMediaEventsService", "", "serviceResolver", "Lkotlin/Function0;", "resolveAIMediaEventsServiceBinder", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f12574a = null;

    static {
        f12574a = new i();
    }

    private i() {
    }

    private final Object a() {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        i r6 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r7 = Result.m1421constructorimpl(ZeusTransformUtils.forName("android.os.ServiceManager", "com.obric.memorydata.plugin").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"aimedia.events"}));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r7) == false) goto L11;
        return null;
    L11:
        return r7;
    L5:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static /* synthetic */ boolean a(i r1, Function0 r2, int r3, Object r4) {
        Function0<? extends Object> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = $$Lambda$i$7ipwcSwgdXYRLyoi3BwsSZzT4U.INSTANCE;
    L6:
        return r1.a(r5);
    }

    private static final Object b() {
        return f12574a.a();
    }

    /* JADX INFO: renamed from: lambda$7ipwcSwgdXYRLyoi3Bws-SZzT4U, reason: not valid java name */
    public static /* synthetic */ Object m1122lambda$7ipwcSwgdXYRLyoi3BwsSZzT4U() {
        return b();
    }

    public final boolean a(Function0<? extends Object> r2) {
        Function0 r1 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "serviceResolver");
        if (r1.invoke() == null) goto L5;
        return true;
    L5:
        return false;
    }
}
