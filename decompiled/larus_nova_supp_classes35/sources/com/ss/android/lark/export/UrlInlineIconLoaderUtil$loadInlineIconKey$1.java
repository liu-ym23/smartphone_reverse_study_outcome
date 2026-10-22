package com.ss.android.lark.export;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.EncryptImage;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.export.UrlInlineIconLoaderUtil$loadInlineIconKey$1", f = "UrlInlineIconLoaderUtil.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
final class UrlInlineIconLoaderUtil$loadInlineIconKey$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e.a $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ Drawable $defaultDrawable;
    final /* synthetic */ String $iconKey;
    int label;

    public UrlInlineIconLoaderUtil$loadInlineIconKey$1(Context r1, String r2, Drawable r3, e.a r4, Continuation<? super UrlInlineIconLoaderUtil$loadInlineIconKey$1> r5) {
        this.$context = r1;
        this.$iconKey = r2;
        this.$defaultDrawable = r3;
        this.$callback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new UrlInlineIconLoaderUtil$loadInlineIconKey$1(this.$context, this.$iconKey, this.$defaultDrawable, this.$callback, r8);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L22:
        e.a r2 = this.$callback;
        r2.a((Drawable) r7);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        int r8 = e.a;
        Context r9 = this.$context;
        String r3 = this.$iconKey;
        Drawable r4 = this.$defaultDrawable;
        this.label = 1;
        j r5 = new j(IntrinsicsKt.intercepted(this), 1);
        r5.C();
        if (r4 != null) goto L11;
        r4 = UDIconUtils.getIconDrawable(r9, 2131235936);
    L11:
        if (r3 != null) goto L13;
    L16:
        r5.resumeWith(Result.constructor-impl(r4));
    L17:
        r7 = r5.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        DebugProbesKt.probeCoroutineSuspended(this);
    L20:
        if (r7 != r0) goto L22;
        return r0;
    L13:
        if (TextUtils.isEmpty(r3) == true) goto L16;
        ImageLoader.with(r9).load(new EncryptImage(r3)).placeholder(r4).asDrawable().into(new g(r9, r4, r5));
        goto L17
    }
}
