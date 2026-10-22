package com.larus.bmhome.chat.layout.holder.image.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.actionbar.model.p1;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.uaigc.api.m;
import com.larus.uaigc.api.n;
import com.larus.uaigc.api.p;
import com.larus.uaigc.api.q;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import com.larus.utils.y0;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
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
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.image.utils.AiCreationEditUtils$handleRedirectSchemaAction$1$1$1", f = "AiCreationEditUtils.kt", i = {}, l = {488}, m = "invokeSuspend", n = {}, s = {})
public final class AiCreationEditUtils$handleRedirectSchemaAction$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
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
    final /* synthetic */ Function4<ImageEditDataWithMask, String, String, ny9.u, Unit> $sendImageRemoveMessage;
    final /* synthetic */ Function1<xy9.b, Unit> $showDialogFragment;
    final /* synthetic */ String $upScreenText;
    final /* synthetic */ String $uri;
    final /* synthetic */ String $url;
    int label;

    public AiCreationEditUtils$handleRedirectSchemaAction$1$1$1(Context r4, Bitmap r5, String r6, String r7, q r8, String r9, Map<String, String> r10, r r11, String r12, String r13, String r14, wc9.e r15, List<u> r16, zs8.a r17, int r18, boolean r19, p1 r20, String r21, Function4<? super ImageEditDataWithMask, ? super String, ? super String, ? super ny9.u, Unit> r22, Function1<? super xy9.b, Unit> r23, Function0<Unit> r24, Continuation<? super AiCreationEditUtils$handleRedirectSchemaAction$1$1$1> r25) {
        this.$context = r4;
        this.$bitmap = r5;
        this.$url = r6;
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
        return new AiCreationEditUtils$handleRedirectSchemaAction$1$1$1(this.$context, this.$bitmap, this.$url, this.$uri, this.$result, this.$upScreenText, this.$instructionParamMap, this.$conf, this.$creationTaskId, this.$cvsId, this.$botId, this.$conversation, this.$instructionItemList, this.$hitPointData, this.$imageBeautifyId, this.$openNewChatPage, this.$msgTemplate, this.$instructionParams, this.$sendImageRemoveMessage, this.$showDialogFragment, this.$dismissCreationPage, r27);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r21);
        Object r3 = r21;
    L11:
        File r4 = (File) r3;
        String r5 = this.$url;
        String r6 = this.$uri;
        q r7 = this.$result;
        FragmentActivity r19 = null;
        if (r7 == null) goto L20;
        p r8 = r7.b();
        if (r8 == null) goto L20;
        n r9 = r8.a();
        if (r9 == null) goto L20;
        m r10 = r9.a();
        if (r10 == null) goto L20;
        Long r11 = r10.a();
    L21:
        q r12 = this.$result;
        if (r12 == null) goto L30;
        p r13 = r12.b();
        if (r13 == null) goto L30;
        n r14 = r13.a();
        if (r14 == null) goto L30;
        m r15 = r14.a();
        if (r15 == null) goto L30;
        Long r16 = r15.b();
    L31:
        MediaAttachment r17 = new MediaAttachment(r5, r6, new ImageUploadInfo(r16, r11), null, y0.k(Uri.fromFile(r4)), null, null, null, null, null, null, null, 4072, null);
        AiCreationEditUtils r18 = AiCreationEditUtils.a;
        String r20 = this.$upScreenText;
        Map<String, String> r22 = this.$instructionParamMap;
        r r23 = this.$conf;
        String r24 = this.$creationTaskId;
        String r25 = this.$cvsId;
        String r26 = this.$botId;
        wc9.e r110 = this.$conversation;
        r18.getClass();
        if (r110 == null) goto L46;
        String r111 = r110.a;
        if (r111 == null) goto L46;
        if (r111.length() <= 0) goto L38;
        boolean r112 = true;
    L39:
        if (r112 == true) goto L42;
        r111 = null;
    L42:
        if (r111 == null) goto L46;
        r25 = r111;
    L52:
        if (r25 != null) goto L54;
    L57:
        boolean r113 = true;
    L58:
        if (r113 == false) goto L60;
        FLogger.a.e("AiCreationEditUtils", "buildImageRemoveSendMessageConfig cvsId is empty");
        CreationSendMessageConfig r27 = null;
    L86:
        Bundle r28 = AiCreationEditUtils.e(this.$upScreenText, this.$instructionItemList, this.$hitPointData, r27);
        Context r29 = this.$context;
        int r30 = this.$imageBeautifyId;
        boolean r31 = this.$openNewChatPage;
        if (r30 == 3) goto L89;
        boolean r32 = false;
    L101:
        if (r32 == false) goto L105;
        return Unit.INSTANCE;
    L105:
        if (this.$openNewChatPage == false) goto L107;
        Context r33 = this.$context;
        p1 r34 = this.$msgTemplate;
        Bundle r35 = AiCreationEditUtils.e(this.$upScreenText, this.$instructionItemList, this.$hitPointData, r27);
        i r36 = SmartRouter.buildRoute(r33, r34.g);
        r36.c.putExtra("ignore_image_size_check", true);
        r36.c.putExtra("media_attachment", r17);
        r36.c.putExtra("open_new_chat_page", true);
        r36.c.putExtras(r35);
        r36.d = 2130772343;
        r36.e = 2130772399;
        r36.d();
    L109:
        return Unit.INSTANCE;
    L107:
        wc9.e r37 = this.$conversation;
        String r38 = this.$upScreenText;
        String r114 = this.$instructionParams;
        Function4<ImageEditDataWithMask, String, String, ny9.u, Unit> r115 = this.$sendImageRemoveMessage;
        Function1<xy9.b, Unit> r116 = this.$showDialogFragment;
        Function0<Unit> r39 = this.$dismissCreationPage;
        Bundle r40 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("media_attachment", r17), TuplesKt.to("ignore_image_size_check", Boolean.TRUE)});
        xy9.b r41 = ICreationWorkflowService.a.E();
        r41.K00(r40, new h(r41, r27, r37, r39, r115, r38, r114), 2131953344, 2131954386);
        r116.invoke(r41);
        goto L109
    L89:
        Bundle r42 = new Bundle(r28);
        r42.putBoolean("ignore_image_size_check", true);
        r42.putSerializable("media_attachment", r17);
        r42.putBoolean("open_new_chat_page", r31);
        ICreationWorkflowService.Companion r43 = ICreationWorkflowService.a;
        cy9.a r44 = cy9.a.a;
        Context r45 = r29;
    L91:
        if ((r45 instanceof ContextWrapper) == false) goto L97;
        if ((r45 instanceof FragmentActivity) == true) goto L94;
        r45 = ((ContextWrapper) r45).getBaseContext();
        goto L91
    L94:
        FragmentActivity r46 = (FragmentActivity) r45;
    L100:
        r44.getClass();
        r32 = r43.e0(r29, r42, !cy9.a.d(r46));
        goto L101
    L97:
        if ((r45 instanceof FragmentActivity) == false) goto L99;
        r19 = (FragmentActivity) r45;
    L99:
        r46 = r19;
        goto L100
    L60:
        if (r26 != null) goto L62;
    L69:
        e0 r47 = (e0) AuthModelDelegate.b.e().getValue();
        if (r47 == null) goto L74;
        LaunchInfo r48 = r47.a;
        if (r48 == null) goto L74;
        r26 = r48.W();
    L75:
        if (r26 != null) goto L77;
        r26 = "7234781073513644036";
    L77:
        CreationSendMessageConfig.Companion.getClass();
        CreationSendMessageConfig.a r117 = new CreationSendMessageConfig.a();
        r117.l(r25);
        r117.f(r26);
        r117.i(r20);
        r117.s("edit");
        r117.u("edit");
        r117.m("ai_edit_picture_detail");
        r117.r("chat");
        Integer r49 = r23.a;
        if (r49 == null) goto L80;
        int r50 = r49.intValue();
    L81:
        r117.d(Integer.valueOf(r50));
        r117.c(r22);
        String r51 = p0.a(r24);
        if (r51 == null) goto L84;
        Map r52 = MapsKt.mapOf(TuplesKt.to("creation_task_id", r51));
    L85:
        r117.t(r52);
        r117.b("image_edit");
        r27 = r117.a;
        goto L86
    L84:
        r52 = null;
        goto L85
    L80:
        r50 = 0;
    L74:
        r26 = null;
        goto L75
    L62:
        if (r26.length() <= 0) goto L64;
        boolean r118 = true;
    L65:
        if (r118 == true) goto L68;
        r26 = null;
    L68:
        if (r26 != null) goto L77;
    L64:
        r118 = false;
        goto L65
    L54:
        if (r25.length() == 0) goto L57;
        r113 = false;
        goto L58
    L38:
        r112 = false;
    L46:
        if (r25.length() <= 0) goto L48;
        boolean r119 = true;
    L49:
        if (r119 == true) goto L52;
        r25 = null;
        goto L52
    L48:
        r119 = false;
    L30:
        r16 = null;
    L20:
        r11 = null;
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r21);
        ICreationWorkflowService.Companion r53 = ICreationWorkflowService.a;
        Context r54 = this.$context;
        Bitmap r55 = this.$bitmap;
        this.label = 1;
        r3 = r53.m(r54, r55, "image_selector_default_image.jpeg", this);
        if (r3 != r1) goto L11;
        return r1;
    }
}
