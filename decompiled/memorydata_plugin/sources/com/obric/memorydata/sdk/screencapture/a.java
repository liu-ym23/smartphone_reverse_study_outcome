package com.obric.memorydata.sdk.screencapture;

import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001BE\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0007R \u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/CaptureCurrentResultDispatcher;", "", CozeCloudExt.API_KEY_HTTP_POST_METHOD, "Lkotlin/Function1;", "Lkotlin/Function0;", "", "callback", "Lcom/obric/memorydata/sdk/screencapture/ScreenData;", "onComplete", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "dispatch", "data", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1<Function0<Unit>, Unit> f12844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<ScreenData, Unit> f12845b;
    private final Function0<Unit> c;

    public a(Function1<? super Function0<Unit>, Unit> r3, Function1<? super ScreenData, Unit> r4, Function0<Unit> r5) {
        Function1<Function0<Unit>, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function1<ScreenData, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Function0<Unit> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, CozeCloudExt.API_KEY_HTTP_POST_METHOD);
        Intrinsics.checkNotNullParameter(r7, "callback");
        Intrinsics.checkNotNullParameter(r8, "onComplete");
        this.f12844a = r6;
        this.f12845b = r7;
        this.c = r8;
    }

    private static final Unit a(a r1, ScreenData r2) {
        r1.f12845b.invoke(r2);     // Catch: Throwable -> L5
        r1.c.invoke();
        return Unit.INSTANCE;
    L5:
        th = move-exception;
        r1.c.invoke();
        throw th;
    }

    public static /* synthetic */ Unit lambda$pn5FofwaAhEXhPZuYQO4h0CGS1I(a r0, ScreenData r1) {
        return a(r0, r1);
    }

    public final void a(final ScreenData r3) {
        this.f12844a.invoke(new $$Lambda$a$pn5FofwaAhEXhPZuYQO4h0CGS1I(this, r3));
    }
}
