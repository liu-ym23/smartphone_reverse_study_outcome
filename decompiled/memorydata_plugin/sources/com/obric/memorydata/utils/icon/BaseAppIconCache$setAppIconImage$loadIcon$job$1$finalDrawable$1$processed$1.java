package com.obric.memorydata.utils.icon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.DrawableStyleUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/drawable/Drawable;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.utils.icon.BaseAppIconCache$setAppIconImage$loadIcon$job$1$finalDrawable$1$processed$1", f = "BaseAppIconCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BaseAppIconCache$setAppIconImage$loadIcon$job$1$finalDrawable$1$processed$1 extends SuspendLambda implements Function2<al, Continuation<? super Drawable>, Object> {
    final /* synthetic */ Drawable $appIcon;
    final /* synthetic */ Context $context;
    final /* synthetic */ int $targetSize;
    int label;

    BaseAppIconCache$setAppIconImage$loadIcon$job$1$finalDrawable$1$processed$1(Context r3, Drawable r4, int r5, Continuation<? super BaseAppIconCache$setAppIconImage$loadIcon$job$1$finalDrawable$1$processed$1> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$context = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.$appIcon = r4;
        this.$targetSize = r5;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new BaseAppIconCache$setAppIconImage$loadIcon$job$1$finalDrawable$1$processed$1(this.$context, this.$appIcon, this.$targetSize, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Drawable> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Drawable> r4) {
        return ((BaseAppIconCache$setAppIconImage$loadIcon$job$1$finalDrawable$1$processed$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), BaseAppIconCache$setAppIconImage$loadIcon$job$1$finalDrawable$1$processed$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r11);
        DrawableStyleUtils r1 = DrawableStyleUtils.f13143a;
        Resources r2 = ZeusTransformUtils.getResources(this.$context, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "getResources(...)");
        return DrawableStyleUtils.a(r1, r2, this.$appIcon, this.$targetSize, MathKt.roundToInt(TypedValue.applyDimension(1, (float) 0.6d, Resources.getSystem().getDisplayMetrics())), ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_line_2, TypedValues.Custom.S_COLOR, "oui_line_2")), null, 32, null);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
