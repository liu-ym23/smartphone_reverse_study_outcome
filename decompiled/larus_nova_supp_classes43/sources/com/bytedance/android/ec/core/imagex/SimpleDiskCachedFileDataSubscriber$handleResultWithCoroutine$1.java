package com.bytedance.android.ec.core.imagex;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.imagex.SimpleDiskCachedFileDataSubscriber$handleResultWithCoroutine$1", f = "ImageExtensions.kt", i = {0, 0, 0}, l = {1818}, m = "invokeSuspend", n = {"cacheKey", "loopCount", "startTimestamp"}, s = {"L$0", "I$0", "J$0"})
final class SimpleDiskCachedFileDataSubscriber$handleResultWithCoroutine$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DataSource $dataSource;
    int I$0;
    long J$0;
    Object L$0;
    int label;
    final /* synthetic */ u0 this$0;

    public SimpleDiskCachedFileDataSubscriber$handleResultWithCoroutine$1(u0 r1, DataSource r10, Continuation r11) {
        this.this$0 = r1;
        this.$dataSource = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        return new SimpleDiskCachedFileDataSubscriber$handleResultWithCoroutine$1(this.this$0, this.$dataSource, r11);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0057 -> B:16:0x005a). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        long r10 = this.J$0;
        int r11 = this.I$0;
        CacheKey r12 = (CacheKey) this.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L32
        SimpleDiskCachedFileDataSubscriber$handleResultWithCoroutine$1 r13 = this;
    L16:
        BinaryResource r15 = ImagePipelineFactory.getInstance().getMainFileCache().getResource(r12);     // Catch: Throwable -> L32
        if (r15 != null) goto L19;
        r15 = ImagePipelineFactory.getInstance().getSmallImageFileCache().getResource(r12);     // Catch: Throwable -> L32
    L19:
        r11 = r11 + 1;     // Catch: Throwable -> L32
        if ((System.currentTimeMillis() - r10) >= 3000) goto L22;
    L12:
        if (r15 != null) goto L22;
        long r16 = Math.min(((long) (r11 + 1)) * 10, 50);     // Catch: Throwable -> L32
        r13.L$0 = r12;     // Catch: Throwable -> L32
        r13.I$0 = r11;     // Catch: Throwable -> L32
        r13.J$0 = r10;     // Catch: Throwable -> L32
        r13.label = 1;     // Catch: Throwable -> L32
        if (DelayKt.delay(r16, r13) != r0) goto L16;
        return r0;
    L22:
        if ((r15 instanceof FileBinaryResource) == false) goto L29;
        File r17 = ((FileBinaryResource) r15).getFile();     // Catch: Throwable -> L32
        if (r17 != null) goto L26;
    L28:
        r13.this$0.a(null);     // Catch: Throwable -> L32
    L30:
        Result.constructor-impl(Boxing.boxBoolean(r13.$dataSource.close()));     // Catch: Throwable -> L32
    L35:
        return Unit.INSTANCE;
    L26:
        if (r17.exists() == false) goto L28;
        r13.this$0.a(r17);     // Catch: Throwable -> L32
        goto L30
    L29:
        r13.this$0.a(null);     // Catch: Throwable -> L32
        goto L30
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r14);
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L32
        DefaultCacheKeyFactory r19 = DefaultCacheKeyFactory.getInstance();     // Catch: Throwable -> L32
        u0 r20 = this.this$0;     // Catch: Throwable -> L32
        CacheKey r110 = r19.getEncodedCacheKey(r20.a, r20.b);     // Catch: Throwable -> L32
        r10 = System.currentTimeMillis();     // Catch: Throwable -> L32
        r11 = 0;
        r13 = this;
        r12 = r110;
        r15 = null;
    L32:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    }
}
