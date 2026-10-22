package com.obric.memorydata.utils.icon;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/drawable/Drawable;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.utils.icon.BaseAppIconCache$setAppIconImage$loadIcon$job$1$finalDrawable$appIcon$1", f = "BaseAppIconCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BaseAppIconCache$setAppIconImage$loadIcon$job$1$finalDrawable$appIcon$1 extends SuspendLambda implements Function2<al, Continuation<? super Drawable>, Object> {
    final /* synthetic */ String $cacheKeyOverride;
    final /* synthetic */ Context $context;
    final /* synthetic */ Function1<String, Drawable> $customIconLoader;
    final /* synthetic */ Integer $customIconRes;
    final /* synthetic */ String $packageName;
    final /* synthetic */ Drawable $targetDefaultIcon;
    int label;

    BaseAppIconCache$setAppIconImage$loadIcon$job$1$finalDrawable$appIcon$1(Context r3, String r4, Function1<? super String, ? extends Drawable> r5, String r6, Integer r7, Drawable r8, Continuation<? super BaseAppIconCache$setAppIconImage$loadIcon$job$1$finalDrawable$appIcon$1> r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Function1<String, Drawable> r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.$context = ZeusTransformUtils.wrapperContext(r10, "com.obric.memorydata.plugin");
        this.$packageName = r4;
        this.$customIconLoader = r11;
        this.$cacheKeyOverride = r6;
        this.$customIconRes = r7;
        this.$targetDefaultIcon = r8;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new BaseAppIconCache$setAppIconImage$loadIcon$job$1$finalDrawable$appIcon$1(this.$context, this.$packageName, this.$customIconLoader, this.$cacheKeyOverride, this.$customIconRes, this.$targetDefaultIcon, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Drawable> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Drawable> r4) {
        return ((BaseAppIconCache$setAppIconImage$loadIcon$job$1$finalDrawable$appIcon$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), BaseAppIconCache$setAppIconImage$loadIcon$job$1$finalDrawable$appIcon$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L9;
        ResultKt.throwOnFailure(r11);
        Drawable r12 = b.a(b.f13229a, this.$context, this.$packageName, false, this.$customIconLoader, this.$cacheKeyOverride, this.$customIconRes, 4, null);
        if (r12 == null) goto L7;
        return r12;
    L7:
        return this.$targetDefaultIcon;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
