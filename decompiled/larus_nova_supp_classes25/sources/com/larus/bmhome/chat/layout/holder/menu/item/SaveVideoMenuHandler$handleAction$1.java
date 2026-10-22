package com.larus.bmhome.chat.layout.holder.menu.item;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.rc.GetVideoModelResultItem;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.rc.VideoUrlResult;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.video.save_share.VideoGenerateSaver;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UserType;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.uaigc.service.ICreationMetadataService;
import com.larus.uaigc.utils.DataConverterKt;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.menu.item.SaveVideoMenuHandler$handleAction$1", f = "SaveMenuItem.kt", i = {0, 0, 0, 0}, l = {160}, m = "invokeSuspend", n = {"position", "metadataMap", "newVideoInfo", "isAIGC"}, s = {"L$0", "L$1", "L$2", "I$0"})
public final class SaveVideoMenuHandler$handleAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $creationTaskId;
    final /* synthetic */ com.larus.common_ui.dialog.l0 $loadingDialog;
    final /* synthetic */ ef8.b $menuContext;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ AiGenVideoContentData $videoInfo;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public SaveVideoMenuHandler$handleAction$1(ef8.b r1, String r2, AiGenVideoContentData r3, Context r4, CoroutineScope r5, com.larus.common_ui.dialog.l0 r6, Continuation<? super SaveVideoMenuHandler$handleAction$1> r7) {
        this.$menuContext = r1;
        this.$creationTaskId = r2;
        this.$videoInfo = r3;
        this.$context = r4;
        this.$scope = r5;
        this.$loadingDialog = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new SaveVideoMenuHandler$handleAction$1(this.$menuContext, this.$creationTaskId, this.$videoInfo, this.$context, this.$scope, this.$loadingDialog, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_bmhome_chat_layout_holder_menu_item_SaveVideoMenuHandler$handleAction$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(com.larus.common_ui.dialog.l0 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final Object invokeSuspend(Object r32) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r8 = false;
        String r10 = null;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        int r1 = this.I$0;
        Ref.ObjectRef r2 = (Ref.ObjectRef) this.L$2;
        Map r3 = (Map) this.L$1;
        Integer r4 = (Integer) this.L$0;
        ResultKt.throwOnFailure(r32);
        int r14 = r1;
        Object r5 = r32;
    L37:
        GetVideoModelResultItem r6 = (GetVideoModelResultItem) r5;
        AiGenVideoContentData r15 = this.$videoInfo;
        if (r6 == null) goto L42;
        VideoUrlResult r9 = r6.getVideoUrlResult();
        if (r9 == null) goto L42;
        String r23 = r9.getVideoUrl();
    L43:
        r2.element = AiGenVideoContentData.copy$default(r15, null, null, null, null, null, null, null, r23, null, null, null, null, null, 8063, null);
        Ref.ObjectRef r13 = r2;
    L46:
        if (r14 == 0) goto L53;
        IFlowSdkDepend r11 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r11 == null) goto L53;
        r11.D0();
        com.larus.home.impl.sdk.b1 r12 = com.larus.home.impl.sdk.b1.a;
        r12.c("chat_long_press_download");
        String r16 = ((AiGenVideoContentData) r13.element).getDownloadUrl();
        if (r16 != null) goto L52;
        r16 = "";
    L52:
        r12.d(r16);
    L53:
        VideoGenerateSaver r17 = VideoGenerateSaver.a;
        Context r18 = this.$context;
        nr9.g r19 = ff8.a.a((AiGenVideoContentData) r13.element);
        BotModel r20 = this.$menuContext.a();
        if (r20 == null) goto L56;
        String r110 = r20.getBotId();
    L57:
        Message r21 = this.$menuContext.a;
        if (r21 == null) goto L60;
        String r111 = r21.getMessageId();
    L61:
        ChatControlTrace r22 = ChatControlTrace.b;
        r22.getClass();
        String r112 = r22.bb(ChatControlTrace.y);
        String r24 = this.$creationTaskId;
        String r25 = tz9.a.a(this.$menuContext.a);
        JSONObject r26 = this.$menuContext.l;
        if (r26 == null) goto L64;
        JSONObject r27 = new JSONObject(r26.toString());
        Intrinsics.checkNotNullParameter(r27, "<this>");
        r27.put("_mixed_richmedia_download_suppress", 1);
        Unit r28 = Unit.INSTANCE;
        JSONObject r29 = r27;
    L65:
        c4 r30 = new c4(r110, r111, r112, null, null, null, null, r24, r4, r25, null, null, r29, null, 11384);
        CoroutineScope r31 = this.$scope;
        Integer r113 = this.$videoInfo.getTaskType();
        if (r113 == null) goto L68;
        String r114 = DataConverterKt.h(r113.intValue());
    L69:
        if (r114 != null) goto L71;
    L74:
        boolean r115 = true;
    L76:
        if (r115 == true) goto L78;
        r10 = r114;
    L78:
        if (r10 != null) goto L82;
        r10 = ap8.a.b(this.$menuContext.a);
        if (r10 != null) goto L82;
        r10 = "";
    L82:
        if (r14 == 0) goto L84;
        r8 = true;
    L84:
        final com.larus.common_ui.dialog.l0 r33 = this.$loadingDialog;
        final Context r34 = this.$context;
        final ef8.b r116 = this.$menuContext;
        final String r117 = this.$creationTaskId;
        final Integer r210 = r4;
        com.larus.bmhome.video.save_share.a.a.a(r17, r18, r19, r30, "overview_long_press", r31, false, false, null, r3, r10, r8, new t0(r33, r34, r116, r117, r210), 224);
        return Unit.INSTANCE;
    L71:
        if (r114.length() == 0) goto L74;
        r115 = false;
        goto L76
    L68:
        r114 = null;
        goto L69
    L64:
        r29 = null;
        goto L65
    L60:
        r111 = null;
        goto L61
    L56:
        r110 = null;
    L42:
        r23 = null;
        goto L43
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r32);
        JSONObject r35 = this.$menuContext.l;
        if (r35 == null) goto L11;
        Integer r118 = Boxing.boxInt(r35.optInt("position"));
    L12:
        ICreationMetadataService.Companion r36 = ICreationMetadataService.a;
        UserCreationFromIM r37 = r36.I(this.$menuContext.a, this.$creationTaskId, String.valueOf(r118));
        Map r119 = r36.s(r37, null);
        r13 = new Ref.ObjectRef();
        r13.element = this.$videoInfo;
        if (this.$menuContext.a.getUserType() == UserType.HUMAN.value) goto L16;
        if (r37 == null) goto L16;
        r14 = 1;
    L17:
        String r38 = this.$videoInfo.getDownloadUrl();
        if (r38 != null) goto L20;
    L23:
        boolean r39 = true;
    L24:
        if (r39 == false) goto L44;
        String r40 = this.$videoInfo.getLocalUrl();
        if (r40 != null) goto L28;
    L31:
        boolean r41 = true;
    L32:
        if (r41 == false) goto L44;
        ResourceCenter r42 = ResourceCenter.a;
        String r43 = this.$videoInfo.getVid();
        this.L$0 = r118;
        this.L$1 = r119;
        this.L$2 = r13;
        this.I$0 = r14;
        this.label = 1;
        r5 = ResourceCenter.i(r42, null, r43, true, this, 1);
        if (r5 != r7) goto L36;
        return r7;
    L36:
        r4 = r118;
        r3 = r119;
        r2 = r13;
        goto L37
    L28:
        if (r40.length() == 0) goto L31;
        r41 = false;
    L44:
        r4 = r118;
        r3 = r119;
        goto L46
    L20:
        if (r38.length() == 0) goto L23;
        r39 = false;
    L16:
        r14 = 0;
        goto L17
    L11:
        r118 = null;
        goto L12
    }
}
