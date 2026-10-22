package com.ss.android.lark.export;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.export.entity.preview.ColorIcon;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.UDIcon;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.export.UrlInlineIconLoaderUtil$loadColorIcon$1", f = "UrlInlineIconLoaderUtil.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
final class UrlInlineIconLoaderUtil$loadColorIcon$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e.a $callback;
    final /* synthetic */ ColorIcon $colorIcon;
    final /* synthetic */ Context $context;
    final /* synthetic */ Drawable $defaultDrawable;
    int label;

    public UrlInlineIconLoaderUtil$loadColorIcon$1(Context r1, ColorIcon r2, Drawable r3, e.a r4, Continuation<? super UrlInlineIconLoaderUtil$loadColorIcon$1> r5) {
        this.$context = r1;
        this.$colorIcon = r2;
        this.$defaultDrawable = r3;
        this.$callback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new UrlInlineIconLoaderUtil$loadColorIcon$1(this.$context, this.$colorIcon, this.$defaultDrawable, this.$callback, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L63:
        e.a r3 = this.$callback;
        r3.a((Drawable) r9);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        int r10 = e.a;
        Context r11 = this.$context;
        ColorIcon r4 = this.$colorIcon;
        Drawable r5 = this.$defaultDrawable;
        this.label = 1;
        j r6 = new j(IntrinsicsKt.intercepted(this), 1);
        r6.C();
        if (r5 != null) goto L11;
        r5 = UDIconUtils.getIconDrawable(r11, 2131235936);
    L11:
        if (r4 != null) goto L13;
        r6.resumeWith(Result.constructor-impl(r5));
    L58:
        r9 = r6.B();
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L61;
        DebugProbesKt.probeCoroutineSuspended(this);
    L61:
        if (r9 != r0) goto L63;
        return r0;
    L13:
        UDIcon r7 = r4.getUdIcon();
        if (r7 == null) goto L36;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        String r8 = r7.getUnicode();
        if (r8 != null) goto L18;
    L21:
        boolean r12 = true;
    L22:
        if (r12 == false) goto L33;
        String r13 = r7.getKey();
        if (r13 != null) goto L26;
    L29:
        boolean r14 = true;
    L30:
        if (r14 == false) goto L33;
        boolean r15 = false;
    L34:
        if (r15 != true) goto L36;
    L37:
        if (r2 == true) goto L39;
    L45:
        IRequestCreator r16 = ImageLoader.with(r11);
        ImageSet r17 = r4.getImageSet();
        String r18 = BuildConfig.FLAVOR;
        if (r17 == null) goto L52;
        String r19 = r4.getImageSet().getKey();
        if (r19 == null) goto L51;
        r18 = r19;
    L51:
        IRequestCreator r20 = r16.load(new EncryptImage(r18));
    L57:
        r20.placeholder(r5).asDrawable().into(new f(r4, r5, r6));
        goto L58
    L52:
        String r21 = r4.getFaviconUrl();
        if (r21 == null) goto L56;
        r18 = r21;
    L56:
        r20 = r16.load(r18);
        goto L57
    L39:
        if (r6.isActive() == false) goto L45;
        Result.Companion r22 = Result.Companion;
        Drawable r23 = e.b(r11, r4.getUdIcon());
        if (r23 == null) goto L44;
        r5 = r23;
    L44:
        r6.resumeWith(Result.constructor-impl(r5));
        goto L58
    L26:
        if (r13.length() == 0) goto L29;
        r14 = false;
    L33:
        r15 = true;
        goto L34
    L18:
        if (r8.length() == 0) goto L21;
        r12 = false;
    L36:
        r2 = false;
        goto L37
    }
}
