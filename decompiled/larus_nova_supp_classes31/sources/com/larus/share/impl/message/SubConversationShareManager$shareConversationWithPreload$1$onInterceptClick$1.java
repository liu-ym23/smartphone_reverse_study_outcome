package com.larus.share.impl.message;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.DialogFragment;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.share.network.PreloadMessageShareHelper;
import com.larus.bmhome.share.network.SaveMessageShareInfo;
import com.larus.bmhome.share.network.f;
import com.larus.bmhome.share.panel.b;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.network.bean.BizResponse;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import jr9.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import t19.s;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.impl.message.SubConversationShareManager$shareConversationWithPreload$1$onInterceptClick$1", f = "SubConversationShareManager.kt", i = {}, l = {190}, m = "invokeSuspend", n = {}, s = {})
public final class SubConversationShareManager$shareConversationWithPreload$1$onInterceptClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $botModel;
    final /* synthetic */ Context $context;
    final /* synthetic */ e $conversation;
    final /* synthetic */ l0 $loadingDialog;
    final /* synthetic */ PreloadMessageShareHelper $preloadHelper;
    final /* synthetic */ f $request;
    final /* synthetic */ a $shareItemConfig;
    final /* synthetic */ DialogFragment $sharePanelDialog;
    int label;

    public SubConversationShareManager$shareConversationWithPreload$1$onInterceptClick$1(PreloadMessageShareHelper r1, f r2, Context r3, BotModel r4, e r5, a r6, l0 r7, DialogFragment r8, Continuation<? super SubConversationShareManager$shareConversationWithPreload$1$onInterceptClick$1> r9) {
        this.$preloadHelper = r1;
        this.$request = r2;
        this.$context = r3;
        this.$botModel = r4;
        this.$conversation = r5;
        this.$shareItemConfig = r6;
        this.$loadingDialog = r7;
        this.$sharePanelDialog = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new SubConversationShareManager$shareConversationWithPreload$1$onInterceptClick$1(this.$preloadHelper, this.$request, this.$context, this.$botModel, this.$conversation, this.$shareItemConfig, this.$loadingDialog, this.$sharePanelDialog, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r35) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r35);
        Object r4 = r35;
    L11:
        BizResponse r5 = (BizResponse) r4;
        Activity r6 = null;
        if (r5.isSuccess() == false) goto L46;
        SaveMessageShareInfo r7 = (SaveMessageShareInfo) r5.getData();
        if (r7 == null) goto L16;
        String r8 = r7.getShareUrl();
    L18:
        if (o0.d(r8) == false) goto L46;
        SaveMessageShareInfo r9 = (SaveMessageShareInfo) r5.getData();
        if (r9 == null) goto L22;
        String r10 = r9.getShareUrl();
    L23:
        ShareServiceDelegate r11 = ShareServiceDelegate.b;
        String r14 = r11.p(this.$context, this.$botModel);
        Context r12 = this.$context;
        if (r12 == null) goto L26;
        String r15 = r12.getString(2131909359);
    L27:
        BotModel r13 = this.$botModel;
        if (r13 == null) goto L32;
        BotIconImage r16 = r13.getIconImage();
        if (r16 == null) goto L32;
        String r17 = r16.getOriginUrl();
    L33:
        e r18 = this.$conversation;
        if (r18 == null) goto L36;
        String r19 = r18.c;
    L37:
        SaveMessageShareInfo r20 = (SaveMessageShareInfo) r5.getData();
        if (r20 == null) goto L44;
        String r110 = r20.getShareUrl();
        if (r110 == null) goto L44;
        List r21 = StringsKt.split$default(r110, new String[]{"/"}, false, 0, 6, null);
        if (r21 == null) goto L44;
        String r111 = (String) CollectionsKt.lastOrNull(r21);
    L45:
        IShareService.a.d(r11, this.$context, this.$shareItemConfig.b(), this.$shareItemConfig.c(), new b(null, null, r10, r17, null, null, null, r14, r15, r19, r111, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67106931), null, 48);
    L47:
        Context r22 = this.$context;
        if ((r22 instanceof Activity) == false) goto L50;
        r6 = (Activity) r22;
    L50:
        if (r6 != null) goto L52;
    L54:
        r3 = false;
    L55:
        if (r3 == false) goto L58;
        int r23 = SubConversationShareManager.a;
        SubConversationShareManager.b(this.$loadingDialog, this.$sharePanelDialog);
    L58:
        return Unit.INSTANCE;
    L52:
        if (r6.isDestroyed() == true) goto L54;
    L44:
        r111 = null;
        goto L45
    L36:
        r19 = null;
    L32:
        r17 = null;
        goto L33
    L26:
        r15 = null;
        goto L27
    L22:
        r10 = null;
        goto L23
    L16:
        r8 = null;
    L46:
        s.a.g(this.$context, 2131900870, false);
        goto L47
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r35);
        PreloadMessageShareHelper r24 = this.$preloadHelper;
        f r25 = this.$request;
        this.label = 1;
        r4 = r24.b(r25, this);
        if (r4 != r1) goto L11;
        return r1;
    }
}
