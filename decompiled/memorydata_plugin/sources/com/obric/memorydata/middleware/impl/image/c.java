package com.obric.memorydata.middleware.impl.image;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.da;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JP\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH\u0086@¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/middleware/impl/image/ImageXBatchUpload;", "", "<init>", "()V", "upload", "", "Lcom/obric/memorydata/middleware/impl/image/ImageXFileUploadResult;", "paths", "", "", "timeoutMs", "", "uploadSingle", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "([Ljava/lang/String;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f11721a = null;

    static {
        f11721a = new c();
    }

    private c() {
    }

    public static /* synthetic */ Object a(c r7, String[] r8, long r9, Function2 r11, Continuation r12, int r13, Object r14) {
        Function2<? super String, ? super Continuation<? super d>, ? extends Object> r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r11, Function2.class, "com.obric.memorydata.plugin");
        Continuation<? super List<d>> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if ((r13 & 2) == 0) goto L6;
        r9 = TimeUnit.MINUTES.toMillis(5);
    L6:
        return r7.a(r8, r9, r5, r6);
    }

    public final Object a(String[] r9, long r10, Function2<? super String, ? super Continuation<? super d>, ? extends Object> r12, Continuation<? super List<d>> r13) {
        Function2 r14 = (Function2) ZeusTransformUtils.wrapperContextForParams(r12, Function2.class, "com.obric.memorydata.plugin");
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, ImageXBatchUpload$upload$1.class) == false) goto L7;
        ImageXBatchUpload$upload$1 r0 = (ImageXBatchUpload$upload$1) ZeusTransformUtils.preCheckCast(r15, ImageXBatchUpload$upload$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        d[] r11 = (d[]) ZeusTransformUtils.preCheckCast(r0.L$0, d[].class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
    L18:
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r11.length), Collection.class, "com.obric.memorydata.plugin");
        int r18 = 0;
        int r19 = r11.length;
    L19:
        if (r18 >= r19) goto L25;
        d r110 = r11[r18];
        if (r110 != null) goto L23;
        r110 = new d(null, null, "UPLOAD_TIMEOUT", 3, null);
    L23:
        r17.add(r110);
        r18 = r18 + 1;
        goto L19
    L25:
        return (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        d[] r20 = new d[r9.length];
        Function2 r21 = (Function2) ZeusTransformUtils.preCheckCast(new ImageXBatchUpload$upload$2(r9, r14, r20, null), Function2.class, "com.obric.memorydata.plugin");
        r0.L$0 = r20;
        r0.label = 1;
        if (da.b(r10, r21, r0) != r16) goto L17;
        return r16;
    L17:
        r11 = r20;
    L7:
        r0 = new ImageXBatchUpload$upload$1(this, r15);
        goto L8
    }
}
