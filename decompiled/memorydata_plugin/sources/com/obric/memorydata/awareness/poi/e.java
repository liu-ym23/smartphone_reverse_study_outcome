package com.obric.memorydata.awareness.poi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/awareness/poi/PoiRequestManager;", "", "<init>", "()V", "poiRequestMap", "", "Lcom/obric/memorydata/awareness/poi/PoiLocation;", "Lcom/obric/memorydata/awareness/poi/PoiRequest;", "requestPoi", "Lcom/obric/memorydata/awareness/poi/PoiResp;", "latitude", "", "longitude", "radius", "", "(DDILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<b, c> f8787a;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8788a = null;

        static {
            int[] r0 = new int[PoiRequestState.values().length];
            r0[PoiRequestState.Requesting.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[PoiRequestState.Success.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[PoiRequestState.None.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[PoiRequestState.Error.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f8788a = r0;
        }
    }

    public e() {
        this.f8787a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    public final Object a(double r15, double r17, int r19, Continuation<? super f> r20) {
        e r0 = this;
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, PoiRequestManager$requestPoi$1.class) == false) goto L7;
        PoiRequestManager$requestPoi$1 r3 = (PoiRequestManager$requestPoi$1) ZeusTransformUtils.preCheckCast(r1, PoiRequestManager$requestPoi$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        b r6 = (b) ZeusTransformUtils.preCheckCast(r3.L$1, b.class, "com.obric.memorydata.plugin");
        e r7 = (e) ZeusTransformUtils.preCheckCast(r3.L$0, e.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        b r8 = r6;
        r0 = r7;
        Object r9 = r2;
    L34:
        f r10 = (f) ZeusTransformUtils.preCheckCast(r9, f.class, "com.obric.memorydata.plugin");
        r0.f8787a.remove(r8);
        return r10;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        r8 = new b(r15, r17);
        c r11 = (c) ZeusTransformUtils.preCheckCast(r0.f8787a.get(r8), c.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L31;
        int r12 = a.f8788a[r11.a().ordinal()];
        if (r12 != 1) goto L19;
    L27:
        boolean r13 = true;
    L28:
        if (r13 == false) goto L31;
        return new f(false, CollectionsKt.emptyList());
    L19:
        if (r12 == 2) goto L27;
        if (r12 == 3) goto L27;
        if (r12 != 4) goto L26;
        r13 = false;
        goto L28
    L26:
        throw new NoWhenBranchMatchedException();
    L31:
        c r14 = new c(r15, r17, r19);
        r0.f8787a.put(r8, r14);
        r3.L$0 = r0;
        r3.L$1 = r8;
        r3.label = 1;
        r9 = r14.a(r3);
        if (r9 != r4) goto L34;
        return r4;
    L7:
        r3 = new PoiRequestManager$requestPoi$1(this, r1);
        goto L8
    }
}
