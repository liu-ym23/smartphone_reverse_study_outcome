package com.larus.drive.biz.impl.utils;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.biz.impl.utils.DriveAskDoubaoChatLauncher$openAskDoubaoChat$2", f = "DriveAskDoubaoChatLauncher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DriveAskDoubaoChatLauncher$openAskDoubaoChat$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ DriveFileItem $file;
    final /* synthetic */ boolean $forceTaskMode;
    final /* synthetic */ String $localBotId;
    int label;

    public DriveAskDoubaoChatLauncher$openAskDoubaoChat$2(Context r1, String r2, String r3, DriveFileItem r4, boolean r5, Continuation<? super DriveAskDoubaoChatLauncher$openAskDoubaoChat$2> r6) {
        this.$context = r1;
        this.$conversationId = r2;
        this.$localBotId = r3;
        this.$file = r4;
        this.$forceTaskMode = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new DriveAskDoubaoChatLauncher$openAskDoubaoChat$2(this.$context, this.$conversationId, this.$localBotId, this.$file, this.$forceTaskMode, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r11);
        com.bytedance.router.i r12 = SmartRouter.buildRoute(this.$context, "//flow/chat_page");
        int r0 = 3;
        Pair[] r1 = new Pair[3];
        r1[0] = TuplesKt.to("argConversationId", this.$conversationId);
        r1[1] = TuplesKt.to("argBotId", this.$localBotId);
        DriveAskDoubaoChatLauncher r2 = DriveAskDoubaoChatLauncher.a;
        DriveFileItem r3 = this.$file;
        JSONArray r5 = new JSONArray();
        JSONObject r6 = new JSONObject();
        r6.put("file_name", r3.a);
        r6.put("file_uri", r3.b);
        r6.put("file_url", r3.e);
        JSONObject r7 = new JSONObject();
        r7.put("url", r3.e);
        Unit r8 = Unit.INSTANCE;
        r6.put("image_ori", r7);
        JSONObject r9 = new JSONObject();
        r9.put("url", r3.e);
        r6.put("image_thumb", r9);
        r6.put("file_size", r3.e());
        DriveFileType r10 = r3.j;
        int r13 = DriveAskDoubaoChatLauncher.a.a[r10.ordinal()];
        if (r13 == 1) goto L10;
        if (r13 == 2) goto L9;
        if (r13 == 3) goto L11;
        r0 = 0;
    L11:
        r6.put("file_type", r0);
        r6.put("ccm_type", r3.d);
        r5.put(r6);
        JSONObject r4 = new JSONObject();
        r4.put("text", AppHost.a.getApplication().getString(2131905294));
        r4.put("txt_scene", "drive");
        r4.put("file_list", r5);
        r1[2] = TuplesKt.to("send_drive_file_info", r4.toString());
        Bundle r14 = com.larus.utils.f.c(r1);
        if (this.$forceTaskMode == false) goto L14;
        com.larus.bmhome.chat.mode.a.a(r14);
    L14:
        r12.c.putExtras(r14);
        r12.d();
        return Unit.INSTANCE;
    L9:
        r0 = 2;
        goto L11
    L10:
        r0 = 1;
        goto L11
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
