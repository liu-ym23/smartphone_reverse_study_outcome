package com.larus.bot.impl.feature.edit.feature.bgimage;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.im.bean.bot.BgImage;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroid/os/Bundle;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.BotBgImageEditViewModel$bindObservers$1", f = "BotBgImageEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BotBgImageEditViewModel$bindObservers$1 extends SuspendLambda implements Function2<Bundle, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BotBgImageEditViewModel this$0;

    public BotBgImageEditViewModel$bindObservers$1(BotBgImageEditViewModel r1, Continuation<? super BotBgImageEditViewModel$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        BotBgImageEditViewModel$bindObservers$1 r0 = new BotBgImageEditViewModel$bindObservers$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(Bundle r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Bundle) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L36;
        ResultKt.throwOnFailure(r12);
        Bundle r13 = (Bundle) this.L$0;
        BotBgImageEditViewModel r0 = this.this$0;
        String r6 = null;
        b.f r10 = new b.f(false, null, null, null, null, null, null, null);
        int r1 = BotBgImageEditViewModel.j;
        r0.v(r10);
        BotBgImageEditViewModel r2 = this.this$0;
        r2.getClass();
        r2.v(b.a.a);
        String r3 = r13.getString("original_user_image_uri_local");
        String r4 = r13.getString("original_avatar_image_uri");
        String r5 = r13.getString("original_background_image_uri");
        Serializable r7 = r13.getSerializable("avatar_info");
        if ((r7 instanceof BotAvatarIconData) == false) goto L7;
        BotAvatarIconData r8 = (BotAvatarIconData) r7;
    L8:
        Serializable r14 = r13.getSerializable("bg_image");
        if ((r14 instanceof BgImage) == false) goto L11;
        BgImage r15 = (BgImage) r14;
    L12:
        r2.j(r3);
        r2.f(r4);
        r2.p(r5);
        String r9 = "";
        if (r8 == null) goto L21;
        String r11 = r8.getIconUrl();
        if (r11 != null) goto L17;
        r11 = "";
    L17:
        String r16 = r8.getIconUri();
        if (r16 != null) goto L20;
        r16 = "";
    L20:
        r2.k(r11, r16);
        r2.m(r8.getPrompt());
    L21:
        if (r15 == null) goto L23;
        r2.n(r15);
    L23:
        boolean r17 = r2.r(r2.a().getBgImage());
        if (r17 == false) goto L32;
        BgImage r18 = r2.a().getBgImage();
        if (r18 == null) goto L28;
        r6 = r18.bgImgUrl;
    L28:
        if (r6 == null) goto L31;
        r9 = r6;
    L31:
        Uri r19 = UriProtector.parse(r9);
    L33:
        r2.t(r19, true, !r17, false);
        r2.c(false);
        return Unit.INSTANCE;
    L32:
        r19 = UriProtector.parse(r2.a().getIconUrl());
        goto L33
    L11:
        r15 = null;
        goto L12
    L7:
        r8 = null;
        goto L8
    L36:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
