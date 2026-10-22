package com.larus.bmhome.chat.layout.holder.image.utils;

import android.content.Context;
import android.graphics.Bitmap;
import com.larus.bmhome.actionbar.model.p1;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.uaigc.api.q;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.image.utils.AiCreationEditUtils$handleRedirectSchemaAction$1", f = "AiCreationEditUtils.kt", i = {}, l = {486}, m = "invokeSuspend", n = {}, s = {})
final class AiCreationEditUtils$handleRedirectSchemaAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ r $conf;
    final /* synthetic */ Context $context;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ String $creationTaskId;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ Function0<Unit> $dismissCreationPage;
    final /* synthetic */ zs8.a $hitPointData;
    final /* synthetic */ int $imageBeautifyId;
    final /* synthetic */ List<u> $instructionItemList;
    final /* synthetic */ Map<String, String> $instructionParamMap;
    final /* synthetic */ String $instructionParams;
    final /* synthetic */ p1 $msgTemplate;
    final /* synthetic */ boolean $openNewChatPage;
    final /* synthetic */ q $result;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ Function4<ImageEditDataWithMask, String, String, ny9.u, Unit> $sendImageRemoveMessage;
    final /* synthetic */ Function1<xy9.b, Unit> $showDialogFragment;
    final /* synthetic */ String $upScreenText;
    final /* synthetic */ String $uri;
    final /* synthetic */ String $url;
    int label;

    public AiCreationEditUtils$handleRedirectSchemaAction$1(String r4, CoroutineScope r5, Context r6, String r7, q r8, String r9, Map<String, String> r10, r r11, String r12, String r13, String r14, wc9.e r15, List<u> r16, zs8.a r17, int r18, boolean r19, p1 r20, String r21, Function4<? super ImageEditDataWithMask, ? super String, ? super String, ? super ny9.u, Unit> r22, Function1<? super xy9.b, Unit> r23, Function0<Unit> r24, Continuation<? super AiCreationEditUtils$handleRedirectSchemaAction$1> r25) {
        this.$url = r4;
        this.$scope = r5;
        this.$context = r6;
        this.$uri = r7;
        this.$result = r8;
        this.$upScreenText = r9;
        this.$instructionParamMap = r10;
        this.$conf = r11;
        this.$creationTaskId = r12;
        this.$cvsId = r13;
        this.$botId = r14;
        this.$conversation = r15;
        this.$instructionItemList = r16;
        this.$hitPointData = r17;
        this.$imageBeautifyId = r18;
        this.$openNewChatPage = r19;
        this.$msgTemplate = r20;
        this.$instructionParams = r21;
        this.$sendImageRemoveMessage = r22;
        this.$showDialogFragment = r23;
        this.$dismissCreationPage = r24;
        super(2, r25);
    }

    public final Continuation<Unit> create(Object r26, Continuation<?> r27) {
        return new AiCreationEditUtils$handleRedirectSchemaAction$1(this.$url, this.$scope, this.$context, this.$uri, this.$result, this.$upScreenText, this.$instructionParamMap, this.$conf, this.$creationTaskId, this.$cvsId, this.$botId, this.$conversation, this.$instructionItemList, this.$hitPointData, this.$imageBeautifyId, this.$openNewChatPage, this.$msgTemplate, this.$instructionParams, this.$sendImageRemoveMessage, this.$showDialogFragment, this.$dismissCreationPage, r27);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r28) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r28);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r28);
        AiCreationEditUtils r3 = AiCreationEditUtils.a;
        final String r4 = this.$url;
        final CoroutineScope r5 = this.$scope;
        final Context r6 = this.$context;
        final String r8 = this.$uri;
        final q r9 = this.$result;
        final String r10 = this.$upScreenText;
        final Map<String, String> r11 = this.$instructionParamMap;
        final r r12 = this.$conf;
        final String r13 = this.$creationTaskId;
        final String r14 = this.$cvsId;
        final String r15 = this.$botId;
        final wc9.e r7 = this.$conversation;
        final List<u> r16 = this.$instructionItemList;
        final zs8.a r17 = this.$hitPointData;
        final int r18 = this.$imageBeautifyId;
        final boolean r19 = this.$openNewChatPage;
        final p1 r20 = this.$msgTemplate;
        final String r21 = this.$instructionParams;
        final Function4<ImageEditDataWithMask, String, String, ny9.u, Unit> r22 = this.$sendImageRemoveMessage;
        final Function1<xy9.b, Unit> r23 = this.$showDialogFragment;
        final Function0<Unit> r24 = this.$dismissCreationPage;
        Function1<? super Bitmap, Unit> r25 = new g(r5, r6, r4, r8, r9, r10, r11, r12, r13, r14, r15, r7, r16, r17, r18, r19, r20, r21, r22, r23, r24);
        this.label = 1;
        if (r3.f(r4, r25, null, this) != r1) goto L12;
        return r1;
    }
}
