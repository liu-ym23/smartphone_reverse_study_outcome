package com.larus.bmhome.chat.layout;

import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.p0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.databinding.LarusItemConversationBinding;
import com.larus.common_ui.widget.AvatarTagView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ShowTagInfo;
import com.larus.im.bean.bot.TagIconInfo;
import com.larus.im.bean.message.Message;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.List;
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
import wh8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.ConversationListItem$setupAvatarTag$1", f = "ConversationListItem.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, s = {})
public final class ConversationListItem$setupAvatarTag$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $item;
    int label;
    final /* synthetic */ ConversationListItem this$0;

    public ConversationListItem$setupAvatarTag$1(a r1, ConversationListItem r2, Continuation<? super ConversationListItem$setupAvatarTag$1> r3) {
        this.$item = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ConversationListItem$setupAvatarTag$1(this.$item, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L16:
        BotModel r12 = (BotModel) r11;
        LarusItemConversationBinding r2 = null;
        if (r12 == null) goto L19;
        List r3 = r12.getTagList();
    L21:
        if (r3 == null) goto L31;
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("[setupAvatarTag] msgId=");
        Message r6 = this.$item.c;
        if (r6 == null) goto L25;
        String r7 = r6.getMessageId();
    L26:
        r5.append(r7);
        r5.append(", botId:");
        BotModel r8 = this.$item.b;
        if (r8 == null) goto L29;
        String r9 = r8.getBotId();
    L30:
        r5.append(r9);
        r5.append(", tagList:");
        r5.append(r12.getTagList());
        r4.i("ConversationListItem", r5.toString());
        goto L31
    L29:
        r9 = null;
        goto L30
    L25:
        r7 = null;
    L31:
        p0 r10 = AudioServiceDelegate.a.getAudioConfig();
        if (r12 == null) goto L34;
        List r13 = r12.getTagList();
    L35:
        ShowTagInfo r14 = r10.f(r12, r13);
        if (r14 == null) goto L61;
        FLogger r15 = FLogger.a;
        StringBuilder r16 = new StringBuilder("[setupAvatarTag] match, msgId=");
        Message r17 = this.$item.c;
        if (r17 == null) goto L40;
        String r18 = r17.getMessageId();
    L41:
        r16.append(r18);
        r16.append(", botId:");
        BotModel r19 = this.$item.b;
        if (r19 == null) goto L44;
        String r20 = r19.getBotId();
    L45:
        r16.append(r20);
        r15.i("ConversationListItem", r16.toString());
        LarusItemConversationBinding r21 = this.this$0.a;
        if (r21 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r21 = null;
    L48:
        AvatarTagView r22 = r21.g;
        TagIconInfo r23 = r14.getIconInfo();
        if (r23 == null) goto L51;
        String r24 = r23.getLightUrl();
    L52:
        TagIconInfo r110 = r14.getIconInfo();
        if (r110 == null) goto L55;
        String r111 = r110.getDarkUrl();
    L56:
        AvatarTagView.a(r22, r24, r111);
        LarusItemConversationBinding r112 = this.this$0.a;
        if (r112 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L60:
        e1.x(r2.g);
    L67:
        return Unit.INSTANCE;
    L59:
        r2 = r112;
        goto L60
    L55:
        r111 = null;
        goto L56
    L51:
        r24 = null;
        goto L52
    L44:
        r20 = null;
        goto L45
    L40:
        r18 = null;
        goto L41
    L61:
        LarusItemConversationBinding r113 = this.this$0.a;
        if (r113 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L65:
        e1.o(r2.g);
        goto L67
    L64:
        r2 = r113;
        goto L65
    L34:
        r13 = null;
        goto L35
    L19:
        r3 = null;
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        IBotRepoService r25 = RepoDispatcherDelegate.b.b();
        BotModel r114 = this.$item.b;
        if (r114 == null) goto L12;
        String r115 = r114.getBotId();
        if (r115 == null) goto L12;
    L13:
        this.label = 1;
        r11 = IBotRepoService.b.a(r25, r115, false, null, false, this, 30);
        if (r11 != r0) goto L16;
        return r0;
    L12:
        r115 = "";
        goto L13
    }
}
