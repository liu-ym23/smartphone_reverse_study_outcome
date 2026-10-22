package com.larus.bmhome.view.actionbar.custom.router;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.bot.utils.PinBotShortcutLinkProcessor;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.trace.z;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.y0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.router.PinBotShortcutRouterProcessor$handleRoute$1", f = "PinBotShortcutRouterProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PinBotShortcutRouterProcessor$handleRoute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BaseContentWidget $component;
    final /* synthetic */ String $schemaUrl;
    int label;

    public PinBotShortcutRouterProcessor$handleRoute$1(String r1, BaseContentWidget r2, Continuation<? super PinBotShortcutRouterProcessor$handleRoute$1> r3) {
        this.$schemaUrl = r1;
        this.$component = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PinBotShortcutRouterProcessor$handleRoute$1(this.$schemaUrl, this.$component, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L34;
        ResultKt.throwOnFailure(r7);
        Uri r8 = UriProtector.parse(this.$schemaUrl);
        String r1 = y0.f(r8, "bot_id");
        boolean r2 = true;
        if (r1 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L31;
        y r4 = s1a.d.a(this.$component).getAbility(y.class);
        String r5 = null;
        if (r4 == null) goto L15;
        String r6 = r4.getBotId();
    L16:
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        Uri.Builder r9 = r8.buildUpon();
        BaseContentWidget r10 = this.$component;
        r9.appendQueryParameter("bot_id", r6);
        ICoreInputAbility r0 = s1a.d.a(r10).getAbility(ICoreInputAbility.class);
        if (r0 != null) goto L21;
    L23:
        r2 = false;
    L24:
        if (r2 == false) goto L26;
        String r11 = "1";
    L27:
        r9.appendQueryParameter("shortcut_if_can_upload_image", r11);
        z r12 = s1a.d.a(r10).getAbility(z.class);
        if (r12 == null) goto L30;
        r5 = r12.k();
    L30:
        r9.appendQueryParameter("current_page", r5);
        r8 = r9.build();
        goto L31
    L26:
        r11 = TriggerSendLoading.NO_LOADING;
        goto L27
    L21:
        if (r0.Qd(false) != true) goto L23;
    L15:
        r6 = null;
    L31:
        PinBotShortcutLinkProcessor r13 = PinBotShortcutLinkProcessor.a;
        Intrinsics.checkNotNull(r8);
        r13.getClass();
        PinBotShortcutLinkProcessor.e(r8);
        return Unit.INSTANCE;
    L7:
        if (r1.length() == 0) goto L10;
        r3 = false;
        goto L11
    L34:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
