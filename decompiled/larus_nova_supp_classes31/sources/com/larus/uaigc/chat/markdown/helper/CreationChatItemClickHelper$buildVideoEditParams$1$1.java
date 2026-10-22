package com.larus.uaigc.chat.markdown.helper;

import android.app.Activity;
import android.content.Context;
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
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.helper.CreationChatItemClickHelper$buildVideoEditParams$1$1", f = "CreationChatItemClickHelper.kt", i = {0, 0, 0}, l = {781}, m = "invokeSuspend", n = {"activity", "item", "openNewChatPage"}, s = {"L$3", "L$4", "Z$0"})
final class CreationChatItemClickHelper$buildVideoEditParams$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ Map<String, Object> $commonParams;
    final /* synthetic */ Context $context;
    final /* synthetic */ kc8.q $createBlockConfig;
    final /* synthetic */ Message $curMessage;
    final /* synthetic */ ic8.f $params;
    final /* synthetic */ com.larus.uaigc.chat.markdown.image.component.k $videoEditorDependency;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
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
            return "";
        }

        public final String getEnterMethod() {
            return "ai_edit_picture_detail";
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

    public CreationChatItemClickHelper$buildVideoEditParams$1$1(Context r1, String r2, Message r3, Map<String, ? extends Object> r4, com.larus.uaigc.chat.markdown.image.component.k r5, kc8.q r6, ic8.f r7, Continuation<? super CreationChatItemClickHelper$buildVideoEditParams$1$1> r8) {
        this.$context = r1;
        this.$botId = r2;
        this.$curMessage = r3;
        this.$commonParams = r4;
        this.$videoEditorDependency = r5;
        this.$createBlockConfig = r6;
        this.$params = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new CreationChatItemClickHelper$buildVideoEditParams$1$1(this.$context, this.$botId, this.$curMessage, this.$commonParams, this.$videoEditorDependency, this.$createBlockConfig, this.$params, r11);
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
        com.larus.bmhome.actionbar.model.z0 r9 = null;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        boolean r1 = this.Z$0;
        com.larus.bmhome.actionbar.model.z0 r2 = (com.larus.bmhome.actionbar.model.z0) this.L$4;
        Activity r3 = (Activity) this.L$3;
        ic8.f r4 = (ic8.f) this.L$2;
        String r5 = (String) this.L$1;
        kc8.q r6 = (kc8.q) this.L$0;
        ResultKt.throwOnFailure(r64);
        boolean r15 = r1;
        Object r7 = r64;
    L30:
        BotModel r10 = (BotModel) r7;
        com.larus.bmhome.actionbar.model.z0 r14 = r2;
        Activity r12 = r3;
        ic8.f r13 = r4;
        kc8.q r11 = r6;
    L31:
        if (r11 == null) goto L37;
        kc8.a0 r16 = r11.d;
        if (r16 == null) goto L37;
        wc9.e r17 = r16.h();
        if (r17 == null) goto L37;
        String r18 = r17.a;
    L38:
        ICreationWorkflowService.Companion r19 = ICreationWorkflowService.a;
        ChatParam r20 = CreationChatItemClickHelper.a(CreationChatItemClickHelper.a, r18, r5, r15);
        String r21 = r13.a;
        if (r11 == null) goto L45;
        Fragment r22 = r11.a;
        if (r22 == null) goto L45;
        t1a.b r23 = s1a.a.g(r22);
        if (r23 == null) goto L45;
        ChatPageContext r55 = (ChatPageContext) r23.a(ChatPageContext.class);
    L46:
        a r24 = new a(r5, r10);
        if (r11 == null) goto L49;
        Fragment r57 = r11.a;
    L50:
        r19.f0(new ny9.b(false, r12, r14, r20, r15, false, null, null, r21, null, null, null, null, null, null, null, null, null, null, false, false, r24, null, null, false, null, null, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, r55, null, r57, null, null, false, -2097440, 241663));
    L51:
        CreationChatItemClickHelper r25 = CreationChatItemClickHelper.a;
        Context r110 = this.$context;
        String r111 = this.$botId;
        Message r112 = this.$curMessage;
        Map<String, Object> r113 = this.$commonParams;
        com.larus.uaigc.chat.markdown.image.component.k r26 = this.$videoEditorDependency;
        if (r26 == null) goto L54;
        r9 = r26.P();
    L54:
        r25.getClass();
        CreationChatItemClickHelper.u(r110, 2131906331, "single_function", r111, r112, r113, r9);
        return Unit.INSTANCE;
    L49:
        r57 = null;
    L45:
        r55 = null;
    L37:
        r18 = null;
        goto L38
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r64);
        Activity r114 = AppHost.a.a().getCurrentActivity();
        if (r114 == null) goto L51;
        com.larus.uaigc.chat.markdown.image.component.k r27 = this.$videoEditorDependency;
        r11 = this.$createBlockConfig;
        String r115 = this.$botId;
        r13 = this.$params;
        if (r27 == null) goto L51;
        r14 = r27.P();
        if (r14 == null) goto L51;
        r15 = r27.O();
        if (r11 == null) goto L22;
        kc8.a0 r28 = r11.d;
        if (r28 == null) goto L22;
        r10 = r28.j0();
        if (r10 == null) goto L22;
        r5 = r115;
        r12 = r114;
    L22:
        IBotRepoService r29 = RepoDispatcherDelegate.b.b();
        if (r115 != null) goto L25;
        String r30 = "";
    L26:
        this.L$0 = r11;
        this.L$1 = r115;
        this.L$2 = r13;
        this.L$3 = r114;
        this.L$4 = r14;
        this.Z$0 = r15;
        this.label = 1;
        r7 = IBotRepoService.b.a(r29, r30, false, null, false, this, 30);
        if (r7 != r8) goto L29;
        return r8;
    L29:
        r3 = r114;
        r6 = r11;
        r5 = r115;
        r4 = r13;
        r2 = r14;
        goto L30
    L25:
        r30 = r115;
        goto L26
    }
}
