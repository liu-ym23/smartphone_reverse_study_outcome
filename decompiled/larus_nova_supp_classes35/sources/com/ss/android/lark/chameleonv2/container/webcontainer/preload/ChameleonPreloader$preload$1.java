package com.ss.android.lark.chameleonv2.container.webcontainer.preload;

import com.ss.android.lark.chameleon.PreloadPolicy;
import com.ss.android.lark.officesdk.utils.di.j;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chameleonv2.container.webcontainer.preload.ChameleonPreloader$preload$1", f = "ChameleonPreloader.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
public final class ChameleonPreloader$preload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChameleonPreloader this$0;

    public ChameleonPreloader$preload$1(ChameleonPreloader r1, Continuation<? super ChameleonPreloader$preload$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChameleonPreloader$preload$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L7
    L34:
        boolean r8 = ((Boolean) r7).booleanValue();     // Catch: Throwable -> L7
    L37:
        j.e("CML_TAG_ChameleonPreloader", "preload end. success: " + r8);
        if (r8 == true) goto L40;
        ChameleonPreloader.a(this.this$0);
    L40:
        ChameleonPreloader r2 = this.this$0;
        if (r8 == false) goto L43;
        PreloadStatus r9 = PreloadStatus.PRELOAD_SUCCESS;
    L44:
        ChameleonPreloader.b(r2, r9);
        return Unit.INSTANCE;
    L43:
        r9 = PreloadStatus.PRELOAD_FAILED;
        goto L44
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r7);
        j.e("CML_TAG_ChameleonPreloader", "preload()... preloadStatus = " + this.this$0.c + ",   policy = " + this.this$0.d + ",   bizName = " + this.this$0.b.getBizName());
        if (this.this$0.c != PreloadStatus.INIT) goto L14;
        ChameleonPreloader r10 = this.this$0;
        int r3 = ChameleonPreloader.c.a[r10.d.ordinal()];
        if (r3 != 1) goto L18;
        a r4 = new PreloadBizHtmlStrategy(r10.a, r10.b);
    L22:
        a r11 = r4;
    L23:
        if (r11 != null) goto L26;
        ChameleonPreloader.b(this.this$0, PreloadStatus.NOT_PRELOAD);
        return Unit.INSTANCE;
    L26:
        ChameleonPreloader r5 = this.this$0;
        if (r5.d == PreloadPolicy.PRELOAD_BIZ_HTML) goto L30;
        ChameleonPreloader.b(r5, PreloadStatus.NOT_PRELOAD);
        return Unit.INSTANCE;
    L30:
        j.e("CML_TAG_ChameleonPreloader", "preload start.");
        ChameleonPreloader.b(this.this$0, PreloadStatus.PRELOADING);
        this.label = 1;     // Catch: Throwable -> L7
        r7 = r11.preload(this);     // Catch: Throwable -> L7
        if (r7 != r0) goto L34;
        return r0;
    L18:
        if (r3 == 2) goto L20;
        r11 = null;
        goto L23
    L20:
        r4 = new PreloadEmptyHtmlStrategy(r10.a);
        goto L22
    L14:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        j.c("CML_TAG_ChameleonPreloader", "preload error!", th);
        r8 = false;
        goto L37
    }
}
