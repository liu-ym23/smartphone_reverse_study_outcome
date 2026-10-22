package com.larus.uaigc.chat.markdown.helper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.uaigc.utils.DataConverterKt;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.helper.LocalCreationChatItemClickHelper$buildImageEditParams$1$1", f = "LocalCreationChatItemClickHelper.kt", i = {}, l = {653}, m = "invokeSuspend", n = {}, s = {})
final class LocalCreationChatItemClickHelper$buildImageEditParams$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ Map<String, Object> $commonParams;
    final /* synthetic */ Context $context;
    final /* synthetic */ kc8.q $createBlockConfig;
    final /* synthetic */ Message $curMessage;
    final /* synthetic */ com.larus.uaigc.chat.markdown.image.component.a $imageEditorDependency;
    final /* synthetic */ ic8.f $params;
    int label;

    public static final class a implements zs8.a {
        public final /* synthetic */ String a;
        public final /* synthetic */ BotModel b;

        public final String Y1() {
            return null;
        }

        public final String a() {
            return null;
        }

        public final String b() {
            return "chat";
        }

        public final String c() {
            return null;
        }

        public final String d() {
            return null;
        }

        public final String e() {
            return null;
        }

        public final String f() {
            return null;
        }

        public final String g() {
            return null;
        }

        public final String getClickFrom() {
            return "ai_generate_feed_image";
        }

        public final String getEnterMethod() {
            return "click_image_edit_button";
        }

        public final String getTemplateType() {
            return null;
        }

        public final String h() {
            return null;
        }

        public final String i() {
            return null;
        }

        public final String j() {
            return null;
        }

        public final String k() {
            return null;
        }

        public final boolean l() {
            return false;
        }

        public final String m() {
            return null;
        }

        public final String n() {
            return null;
        }

        public final String o() {
            return null;
        }

        public final String p() {
            return null;
        }

        public final String getChatType() {
            BotModel r0 = this.b;
            if (r0 != null) goto L7;
            return null;
        L7:
            return DataConverterKt.b(r0);
        }

        public final String getBotId() {
            return this.a;
        }

        public a(String r1, BotModel r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public LocalCreationChatItemClickHelper$buildImageEditParams$1$1(kc8.q r1, String r2, Context r3, Message r4, Map<String, ? extends Object> r5, com.larus.uaigc.chat.markdown.image.component.a r6, ic8.f r7, Continuation<? super LocalCreationChatItemClickHelper$buildImageEditParams$1$1> r8) {
        this.$createBlockConfig = r1;
        this.$botId = r2;
        this.$context = r3;
        this.$curMessage = r4;
        this.$commonParams = r5;
        this.$imageEditorDependency = r6;
        this.$params = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new LocalCreationChatItemClickHelper$buildImageEditParams$1$1(this.$createBlockConfig, this.$botId, this.$context, this.$curMessage, this.$commonParams, this.$imageEditorDependency, this.$params, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r64) {
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r64);
        Object r1 = r64;
    L20:
        BotModel r2 = (BotModel) r1;
    L21:
        Activity r12 = AppHost.a.a().getCurrentActivity();
        com.larus.bmhome.actionbar.model.z0 r3 = null;
        if (r12 == null) goto L57;
        com.larus.uaigc.chat.markdown.image.component.a r4 = this.$imageEditorDependency;
        kc8.q r5 = this.$createBlockConfig;
        String r6 = this.$botId;
        ic8.f r7 = this.$params;
        if (r4 == null) goto L57;
        com.larus.bmhome.actionbar.model.z0 r13 = r4.P();
        if (r13 == null) goto L57;
        boolean r15 = r4.O();
        if (r5 == null) goto L34;
        kc8.a0 r9 = r5.d;
        if (r9 == null) goto L34;
        wc9.e r10 = r9.h();
        if (r10 == null) goto L34;
        String r11 = r10.a;
    L35:
        ICreationWorkflowService.Companion r14 = ICreationWorkflowService.a;
        com.larus.bmhome.actionbar.model.r r16 = r13.q;
        if (r16 == null) goto L43;
        Integer r17 = r16.a;
        if (r17 == null) goto L43;
        if (r17.intValue() != 28) goto L43;
        boolean r18 = true;
    L44:
        ChatParam r19 = LocalCreationChatItemClickHelper.a(r11, r6, r15);
        String r20 = r7.a;
        Bundle r34 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("image_second_edit_scene", "generated_img_edit")});
        if (r5 == null) goto L51;
        Fragment r21 = r5.a;
        if (r21 == null) goto L51;
        t1a.b r22 = s1a.a.g(r21);
        if (r22 == null) goto L51;
        ChatPageContext r55 = (ChatPageContext) r22.a(ChatPageContext.class);
    L52:
        a r23 = new a(r6, r2);
        if (r5 == null) goto L55;
        Fragment r57 = r5.a;
    L56:
        r14.f0(new ny9.b(r18, r12, r13, r19, r15, false, null, null, r20, null, null, null, null, Boxing.boxInt(4), null, null, null, null, null, false, false, r23, null, r34, false, null, null, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, r55, null, r57, null, null, false, -10494240, 241663));
        goto L57
    L55:
        r57 = null;
    L51:
        r55 = null;
    L43:
        r18 = false;
    L34:
        r11 = null;
    L57:
        LocalCreationChatItemClickHelper r24 = LocalCreationChatItemClickHelper.a;
        Context r25 = this.$context;
        String r110 = this.$botId;
        Message r111 = this.$curMessage;
        Map<String, Object> r112 = this.$commonParams;
        com.larus.uaigc.chat.markdown.image.component.a r26 = this.$imageEditorDependency;
        if (r26 == null) goto L60;
        r3 = r26.P();
    L60:
        LocalCreationChatItemClickHelper.l(r25, 2131906324, "edit_entrance", r110, r111, r112, r3);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r64);
        kc8.q r27 = this.$createBlockConfig;
        if (r27 == null) goto L14;
        kc8.a0 r28 = r27.d;
        if (r28 == null) goto L14;
        r2 = r28.j0();
        if (r2 != null) goto L21;
    L14:
        IBotRepoService r29 = RepoDispatcherDelegate.b.b();
        String r30 = this.$botId;
        if (r30 != null) goto L17;
        r30 = "";
    L17:
        this.label = 1;
        r1 = IBotRepoService.b.a(r29, r30, false, null, false, this, 30);
        if (r1 != r8) goto L20;
        return r8;
    }
}
