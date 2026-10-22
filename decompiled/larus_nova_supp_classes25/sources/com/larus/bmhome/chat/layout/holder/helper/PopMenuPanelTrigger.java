package com.larus.bmhome.chat.layout.holder.helper;

import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.audio.ttsV2.TtsGuideDelegate;
import com.larus.bmhome.auth.ConversationMode;
import com.larus.bmhome.chat.api.SelectionRangeType;
import com.larus.bmhome.chat.bean.ChatMsgDeleteScene;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.floating.collect.CollectFrom;
import com.larus.bmhome.chat.component.bottom.reference.entity.RefEntranceType;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.list.u7$a;
import com.larus.bmhome.chat.component.push.a$a;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility$ActionType;
import com.larus.bmhome.chat.layout.holder.menu.item.DownloadFileMenuHandler;
import com.larus.bmhome.chat.layout.holder.menu.item.MenuActionType;
import com.larus.bmhome.chat.layout.holder.menu.item.SaveImageMenuHandler;
import com.larus.bmhome.chat.layout.holder.menu.item.SaveVideoMenuHandler;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService;
import com.larus.bmhome.chat.nestedmenu.NestedMenuPopupStrategy;
import com.larus.bmhome.chat.nestedmenu.NestedMenuScene;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.praise.IAiChatPraiseTriggerService;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.im.FlowRuntime;
import com.larus.im.bean.bot.AnswerAction;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.OpenPushReminderScene;
import com.larus.platform.api.s3;
import com.larus.platform.model.MarkDownSelectorSettings;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i3;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatService;
import com.larus.podcast.IFlowPodcastService;
import com.larus.podcast.api.PodcastClickSource;
import com.larus.security.api.ReportDialogHelper;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class PopMenuPanelTrigger implements sr9.e0 {
    public static final /* synthetic */ int r = 0;
    public final Fragment a;
    public final RecyclerView b;
    public final com.larus.bmhome.chat.api.q0 c;
    public final CustomMarkdownTextView d;
    public final st8.a e;
    public final com.larus.bmhome.chat.api.q0.a f;
    public final Message g;
    public final Function0<Message> h;
    public final boolean i;
    public final lw8.l j;
    public final LongClickSource k;
    public boolean l;
    public boolean m;
    public final Lazy n;
    public final Lazy o;
    public final f2a.d p;
    public CommonMenu q;

    public static final class a {
    }

    public static final class b implements com.larus.bmhome.chat.api.d0 {
        public final /* synthetic */ PopMenuPanelTrigger a;

        public b(PopMenuPanelTrigger r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.chat.api.d0
        public final void a(final View r4, int r5, int r6) {
            if (Intrinsics.areEqual(r4, this.a.d) == true) goto L5;
            return;
        L5:
            if ((r4 instanceof CustomMarkdownTextView) == true) goto L8;
            return;
        L8:
            if (r6 == 2) goto L10;
            return;
        L10:
            if (((MarkDownSelectorSettings) this.a.n.getValue()).getDoubleClickShiftStrategy() <= 0) goto L12;
            boolean r7 = true;
        L13:
            if (r7 == false) goto L18;
            final PopMenuPanelTrigger r8 = this.a;
            ((CustomMarkdownTextView) r4).postDelayed(new j2(r8, r4), 100);
            return;
        L18:
            return;
        L12:
            r7 = false;
            goto L13
        }

        @Override // com.larus.bmhome.chat.api.d0
        public final void b(SelectionRangeType r1, int r2, int r3, boolean r4, boolean r5, Rect r6, String r7) {
            com.larus.bmhome.chat.api.d0.a.a(r1, r7);
        }
    }

    public static final class c implements ef8.a {
        public c() {
        }

        @Override // ef8.a
        public final boolean a(int r1) {
            return true;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.layout.holder.helper.PopMenuPanelTrigger$invoke$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.helper.PopMenuPanelTrigger$invoke$1", f = "PopMenuPanelTrigger.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BotModel $currentBot;
        int label;
        final /* synthetic */ PopMenuPanelTrigger this$0;

        public AnonymousClass1(PopMenuPanelTrigger r1, BotModel r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$currentBot = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$currentBot, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L46;
            ResultKt.throwOnFailure(r9);
            String r10 = this.this$0.g.getConversationId();
            String r0 = "";
            if (r10 != null) goto L7;
            String r2 = "";
        L8:
            BotModel r11 = this.$currentBot;
            String r1 = null;
            if (r11 == null) goto L11;
            String r12 = r11.getBotId();
        L12:
            if (r12 != null) goto L14;
        L17:
            boolean r13 = true;
        L18:
            if (r13 == true) goto L44;
            com.larus.bmhome.chat.api.q0.a r14 = this.this$0.f;
            if (r14 == null) goto L28;
            u7 r15 = r14.u3();
            if (r15 == null) goto L28;
            String r3 = this.this$0.g.getMessageId();
            if (r3 == null) goto L27;
            r0 = r3;
        L27:
            u7$a.b(r15, r0, null, null, 14);
        L28:
            ChatControlTrace r16 = ChatControlTrace.b;
            if (com.larus.bmhome.chat.bean.d.G0(this.this$0.g) == false) goto L32;
            String r4 = "long_press_user";
        L35:
            long r5 = this.this$0.c();
            PopMenuPanelTrigger r6 = this.this$0;
            Message r7 = r6.g;
            String r17 = r16.jb(r6.d);
            com.larus.bmhome.chat.mode.e r8 = s1a.a.g(this.this$0.a).getAbility(com.larus.bmhome.chat.mode.e.class);
            if (r8 == null) goto L42;
            kotlinx.coroutines.flow.i1 r18 = r8.Si();
            if (r18 == null) goto L42;
            ConversationMode r19 = (ConversationMode) r18.getValue();
            if (r19 == null) goto L42;
            r1 = r19.a();
        L42:
            ChatControlTrace.P(r4, r2, r5, r7, r17, r1);
            goto L44
        L32:
            if (this.this$0.l == false) goto L34;
            r4 = "long_press_answer_more";
            goto L35
        L34:
            r4 = "long_press_answer";
        L44:
            return Unit.INSTANCE;
        L14:
            if (StringsKt.isBlank(r12) == true) goto L17;
            r13 = false;
            goto L18
        L11:
            r12 = null;
            goto L12
        L7:
            r2 = r10;
            goto L8
        L46:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.layout.holder.helper.PopMenuPanelTrigger$invoke$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.helper.PopMenuPanelTrigger$invoke$2", f = "PopMenuPanelTrigger.kt", i = {0, 1, 2, 2, 3}, l = {556, 565, 577, 586}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch", "clipboardMarkdownText", "$this$launch"}, s = {"L$0", "L$0", "L$0", "L$1", "L$0"})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BotModel $currentBot;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ PopMenuPanelTrigger this$0;

        public AnonymousClass2(PopMenuPanelTrigger r1, BotModel r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$currentBot = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, this.$currentBot, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public static final void a(PopMenuPanelTrigger r5) {
            if (com.larus.bmhome.chat.bean.d.v0(r5.g) == false) goto L6;
            t19.s r0 = t19.s.a;
            Context r6 = r5.a.getContext();
            r0.getClass();
            t19.s.o(r6, 2131910467, false);
            return;
        L6:
            com.larus.bmhome.chat.api.q0.a r1 = r5.f;
            if (r1 == null) goto L16;
            ld8.n r2 = r1.K9();
            if (r2 == null) goto L16;
            CollectFrom r3 = CollectFrom.COPY;
            String r4 = r5.d().getMessageId();
            if (r4 != null) goto L13;
            r4 = "";
        L13:
            boolean r7 = r2.Ho(r3, r4);
            boolean r8 = true;
            if (r7 != true) goto L16;
        L17:
            if (r8 == true) goto L20;
            t19.s r9 = t19.s.a;
            Context r10 = r5.a.getContext();
            r9.getClass();
            t19.s.o(r10, 2131910467, false);
            return;
        L20:
            return;
        L16:
            r8 = false;
            goto L17
        }

        public final Object invokeSuspend(Object r23) {
            Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            BotModel r8 = null;
            if (r0 == 0) goto L14;
            if (r0 == 1) goto L13;
            if (r0 == 2) goto L12;
            if (r0 == 3) goto L11;
            if (r0 == 4) goto L12;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            String r1 = (String) this.L$1;
            CoroutineScope r2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r23);
            String r3 = r1;
            CoroutineScope r4 = r2;
            Object r5 = r23;
        L36:
            MessageCopyHelper r6 = MessageCopyHelper.a;
            Context r9 = this.this$0.a.requireContext();
            this.L$0 = r4;
            this.L$1 = null;
            this.label = 4;
            if (r6.h(r9, (List) r5, r3, null, this) != r7) goto L46;
            return r7;
        L46:
            ChatControlTrace r10 = ChatControlTrace.b;
            PopMenuPanelTrigger r11 = this.this$0;
            int r12 = PopMenuPanelTrigger.r;
            Message r13 = r11.d();
            PopMenuPanelTrigger r14 = this.this$0;
            by7.e r15 = r14.a;
            if ((r15 instanceof by7.e) == false) goto L49;
            by7.e r16 = r15;
        L50:
            IAIChatControlTraceService.a.d(r10, "long_press_answer", r13, r16, r14.c(), CollectionsKt.listOf(this.this$0.j), this.this$0.d, null, null, ChatDraftItem.TYPE_TEXT, null, 704);
            com.larus.bmhome.chat.api.q0.a r17 = this.this$0.f;
            if (r17 == null) goto L55;
            com.larus.bmhome.chat.component.cvs.y r18 = r17.u0();
            if (r18 == null) goto L55;
            wc9.e r19 = r18.h();
        L56:
            if (r19 == null) goto L58;
            String r20 = r19.a;
        L60:
            if (Intrinsics.areEqual(r20, this.this$0.g.getConversationId()) == true) goto L62;
        L76:
            a(this.this$0);
        L78:
            return Unit.INSTANCE;
        L62:
            if (ic8.n.v(r19) == true) goto L66;
            if (ic8.n.D(r19) == false) goto L76;
        L66:
            if (com.larus.bmhome.chat.bean.d.G0(this.this$0.g) == true) goto L76;
            com.larus.bmhome.chat.api.q0.a r21 = this.this$0.f;
            if (r21 == null) goto L75;
            com.larus.bmhome.chat.component.push.a r22 = r21.a9();
            if (r22 == null) goto L75;
            OpenPushReminderScene r110 = OpenPushReminderScene.CopyMsgFromMainBot;
            com.larus.bmhome.chat.component.cvs.y r24 = this.this$0.f.u0();
            if (r24 == null) goto L74;
            r8 = r24.j0();
        L74:
            final PopMenuPanelTrigger r25 = this.this$0;
            a$a.a(r22, r110, r19, r8, null, new k2(r25), 8);
        L75:
            a(this.this$0);
            goto L78
        L58:
            r20 = null;
        L55:
            r19 = null;
            goto L56
        L49:
            r16 = null;
        L12:
            CoroutineScope r26 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r23);
            goto L46
        L13:
            r4 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r23);
            Object r27 = r23;
        L19:
            String r28 = CollectionsKt.joinToString$default((Iterable) r27, null, null, null, 0, null, null, 63, null);
            if ((true ^ StringsKt.isBlank(r28)) == true) goto L23;
        L22:
            r28 = null;
        L23:
            PopMenuPanelTrigger r29 = this.this$0;
            int r30 = PopMenuPanelTrigger.r;
            if (com.larus.bmhome.chat.bean.d.G0(r29.d()) == false) goto L26;
        L39:
            CustomMarkdownTextView r31 = this.this$0.d;
            if (r31 == null) goto L46;
            CharSequence r32 = r31.getText();
            if (r32 == null) goto L46;
            PopMenuPanelTrigger r33 = this.this$0;
            MessageCopyHelper r34 = MessageCopyHelper.a;
            Context r35 = r33.a.requireContext();
            this.L$0 = r4;
            this.label = 2;
            r34.getClass();
            MessageCopyHelper.n(r35, r32, r28, "bpea-message-copy");
            if (Unit.INSTANCE != r7) goto L46;
            return r7;
        L26:
            if (com.larus.im.bean.message.a.d0(this.this$0.d()) == true) goto L39;
            if (((Boolean) this.this$0.o.getValue()).booleanValue() == false) goto L31;
            MainCoroutineDispatcher r36 = Dispatchers.getMain();
        L32:
            PopMenuPanelTrigger$invoke$2$markdownContentList$1 r37 = new PopMenuPanelTrigger$invoke$2$markdownContentList$1(this.this$0, this.$currentBot, null);
            this.L$0 = r4;
            this.L$1 = r28;
            this.label = 3;
            r5 = BuildersKt.withContext(r36, r37, this);
            if (r5 != r7) goto L35;
            return r7;
        L35:
            r3 = r28;
            goto L36
        L31:
            r36 = Dispatchers.getIO();
            goto L32
        L14:
            ResultKt.throwOnFailure(r23);
            r4 = (CoroutineScope) this.L$0;
            if (com.larus.platform.service.z2.a.enableMessageMention() == false) goto L22;
            MessageCopyHelper r38 = MessageCopyHelper.a;
            PopMenuPanelTrigger r39 = this.this$0;
            int r111 = PopMenuPanelTrigger.r;
            Message r40 = r39.d();
            TargetDataSource r112 = TargetDataSource.Content;
            this.L$0 = r4;
            this.label = 1;
            r27 = r38.a(r40, "\n\n", r112, this);
            if (r27 != r7) goto L19;
            return r7;
        }
    }

    static {
    }

    public final long c() {
        ChatMessageList r0 = this.b;
        if ((r0 instanceof ChatMessageList) == false) goto L5;
        ChatMessageList r1 = r0;
    L6:
        if (r1 == null) goto L10;
        Long r2 = r1.getChatUniqueKey();
        if (r2 == null) goto L10;
        return r2.longValue();
    L10:
        return 0;
    L5:
        r1 = null;
        goto L6
    }

    public final Message d() {
        return (Message) this.h.invoke();
    }

    public final void j() {
        FragmentActivity r0 = this.a.getContext();
        if (r0 != null) goto L8;
        r0 = this.a.getActivity();
        if (r0 != null) goto L8;
        return;
    L8:
        com.larus.bmhome.chat.api.q0.a r1 = this.f;
        String r2 = null;
        if (r1 == null) goto L13;
        com.larus.bmhome.chat.component.cvs.y r3 = r1.u0();
        if (r3 == null) goto L13;
        BotModel r4 = r3.j0();
    L14:
        Message r5 = d();
        de8.c r6 = (de8.c) s1a.a.g(this.a).a(de8.c.class);
        if (r6 == null) goto L17;
        Bundle r7 = r6.a;
    L19:
        if (r7 != null) goto L21;
    L23:
        boolean r8 = false;
    L24:
        if (r8 == false) goto L34;
        String r9 = r7.getString("preview_collection_id");
        if (r9 != null) goto L28;
    L31:
        boolean r10 = true;
    L32:
        if (r10 == true) goto L34;
        boolean r11 = true;
    L35:
        if (r11 == false) goto L77;
        IAIChatService r12 = (IAIChatService) ServiceManager.get().getService(IAIChatService.class);
        if (r12 == null) goto L73;
        Fragment r13 = this.a;
        com.larus.bmhome.chat.api.q0.a r14 = this.f;
        if (r14 == null) goto L41;
        com.larus.bmhome.chat.component.cvs.y r15 = r14.u0();
    L42:
        if (r15 == null) goto L53;
        wc9.e r16 = r15.h();
        if (r16 == null) goto L53;
        String r17 = r16.a;
        if (r17 == null) goto L53;
        if ((!StringsKt.isBlank(r17)) == true) goto L51;
        r17 = null;
    L51:
        if (r17 == null) goto L53;
        r2 = r17;
    L59:
        if (r2 != null) goto L61;
    L64:
        boolean r18 = true;
    L65:
        if (r18 == false) goto L67;
    L69:
        Message r52 = r5;
        boolean r19 = true;
        Message r20 = r52;
    L71:
        if (r12.e8(r0, r13, r20, this.k) != r19) goto L74;
        boolean r21 = true;
    L75:
        if (r21 == false) goto L78;
        return;
    L78:
        CoroutineScope r22 = (CoroutineScope) this.c.y7().invoke();
        if (r22 != null) goto L81;
        return;
    L81:
        RepoDispatcher.a.getClass();
        com.larus.bmhome.chat.model.repo.x1 r23 = RepoDispatcher.d.d.d;
        if (r23 != null) goto L84;
        return;
    L84:
        TtsGuideDelegate.b.a("long_press_play");
        BuildersKt.launch$default(r22, RepoDispatcher.b, null, new PopMenuPanelTrigger$startTts$1(r4, r23, this, r52, null), 2, null);
        return;
    L74:
        r21 = false;
        goto L75
    L67:
        if (Intrinsics.areEqual(r2, r5.getConversationId()) == true) goto L69;
        r52 = r5;
        r19 = true;
        r20 = Message.copy$default(r5, r2, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -2, 31, null);
        goto L71
    L61:
        if (StringsKt.isBlank(r2) == true) goto L64;
        r18 = false;
    L53:
        if (r15 == null) goto L59;
        String r24 = r15.Y1();
        if (r24 == null) goto L59;
        if ((!StringsKt.isBlank(r24)) == false) goto L59;
        r2 = r24;
        goto L59
    L41:
        r15 = null;
        goto L42
    L73:
        r52 = r5;
        goto L74
    L77:
        r52 = r5;
        goto L78
    L28:
        if (StringsKt.isBlank(r9) == true) goto L31;
        r10 = false;
    L34:
        r11 = false;
        goto L35
    L21:
        if (r7.getBoolean("preview_collection_readonly") != true) goto L23;
        r8 = true;
        goto L24
    L17:
        r7 = null;
    L13:
        r4 = null;
        goto L14
    }

    public final void k() {
        CoroutineScope r1 = (CoroutineScope) this.c.y7().invoke();
        if (r1 != null) goto L5;
        l();
        return;
    L5:
        RepoDispatcher.a.getClass();
        BuildersKt.launch$default(r1, RepoDispatcher.b, null, new PopMenuPanelTrigger$stopTts$1(this, null), 2, null);
    }

    public final void l() {
        i(d(), this.f, "0", "other_close");
        RepoDispatcher.a.getClass();
        RepoDispatcher.d.d.d.i6("long_press_play", true);
        com.larus.bmhome.chat.api.q0.a r0 = this.f;
        if (r0 == null) goto L8;
        xa8.d r1 = r0.Z8();
        if (r1 == null) goto L9;
        r1.ZM("long_press_play");
        return;
    L9:
        return;
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static final void g(PopMenuPanelTrigger r7) {
        IAiChatPraiseTriggerService r0 = (IAiChatPraiseTriggerService) ServiceManager.get().getService(IAiChatPraiseTriggerService.class);
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        String r3 = "";
        if (r2 == false) goto L19;
        t19.s r4 = t19.s.a;
        Context r8 = r7.a.getContext();
        r4.getClass();
        t19.s.o(r8, 2131910469, false);
        FlowCommonAppCompatActivity r9 = AppHost.a.a().getCurrentActivity();
        if ((r9 instanceof FlowCommonAppCompatActivity) == false) goto L13;
        FlowCommonAppCompatActivity r10 = r9;
    L14:
        if (r10 == null) goto L16;
        r3 = r10.k();
    L16:
        IAiChatPraiseTriggerService r11 = (IAiChatPraiseTriggerService) ServiceManager.get().getService(IAiChatPraiseTriggerService.class);
        if (r11 == null) goto L34;
        IAiChatPraiseTriggerService.a.a(r11, r3, null, 12);
        return;
    L34:
        return;
    L13:
        r10 = null;
        goto L14
    L19:
        com.larus.bmhome.chat.api.q0.a r5 = r7.f;
        if (r5 == null) goto L30;
        ld8.n r6 = r5.K9();
        if (r6 == null) goto L30;
        CollectFrom r12 = CollectFrom.LIKE;
        String r13 = r7.g.getMessageId();
        if (r13 == null) goto L28;
        r3 = r13;
    L28:
        if (r6.Ho(r12, r3) != true) goto L30;
    L31:
        if (r1 == true) goto L36;
        t19.s r14 = t19.s.a;
        Context r15 = r7.a.getContext();
        r14.getClass();
        t19.s.o(r15, 2131910469, false);
        return;
    L36:
        return;
    L30:
        r1 = false;
        goto L31
    L5:
        if (r0.a() != true) goto L7;
        r2 = true;
        goto L8
    }

    public static final void h(final PopMenuPanelTrigger r9) {
        com.larus.bmhome.chat.api.q0.a r0 = r9.f;
        BotModel r1 = null;
        if (r0 == null) goto L7;
        com.larus.bmhome.chat.component.cvs.y r2 = r0.u0();
        if (r2 == null) goto L7;
        wc9.e r3 = r2.h();
    L8:
        if (r3 == null) goto L10;
        String r4 = r3.a;
    L12:
        if (Intrinsics.areEqual(r4, r9.g.getConversationId()) == true) goto L14;
    L32:
        g(r9);
        return;
    L14:
        if (ic8.n.v(r3) == true) goto L18;
        if (ic8.n.D(r3) == false) goto L32;
    L18:
        if (com.larus.bmhome.chat.bean.d.G0(r9.g) == true) goto L32;
        com.larus.bmhome.chat.api.q0.a r5 = r9.f;
        if (r5 == null) goto L31;
        com.larus.bmhome.chat.component.push.a r6 = r5.a9();
        if (r6 == null) goto L31;
        OpenPushReminderScene r7 = OpenPushReminderScene.LikeMsgForMainBot;
        com.larus.bmhome.chat.component.cvs.y r8 = r9.f.u0();
        if (r8 == null) goto L26;
        wc9.e r10 = r8.h();
    L27:
        com.larus.bmhome.chat.component.cvs.y r11 = r9.f.u0();
        if (r11 == null) goto L30;
        r1 = r11.j0();
    L30:
        a$a.a(r6, r7, r10, r1, null, new z1(r9), 8);
        return;
    L26:
        r10 = null;
    L31:
        g(r9);
        return;
    L10:
        r4 = null;
    L7:
        r3 = null;
        goto L8
    }

    public final List<Message> e(Message r8) {
        com.larus.bmhome.chat.api.q0.a r0 = this.f;
        if (r0 == null) goto L51;
        IChatMessageShareAbility r1 = r0.J9();
        if (r1 == null) goto L51;
        List r2 = r1.Us(r8, this.c.getCurrentList());
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        Object r5 = r4.next();
        if (r1.yk((Message) r5) == false) goto L9;
        r3.add(r5);
        goto L9
    L13:
        boolean r6 = false;
        if (r3.isEmpty() == true) goto L46;
        Iterator r7 = r3.iterator();
    L18:
        if (r7.hasNext() == false) goto L46;
        Message r9 = (Message) r7.next();
        if (r9 == r8) goto L43;
        String r10 = r9.getMessageId();
        if (r10 != null) goto L24;
    L27:
        boolean r11 = true;
    L28:
        if (r11 == false) goto L30;
    L31:
        String r12 = r9.getLocalMessageId();
        if (r12 != null) goto L34;
    L37:
        boolean r13 = true;
    L38:
        if (r13 == false) goto L40;
    L42:
        boolean r14 = false;
    L44:
        if (r14 == false) goto L18;
        r6 = true;
        goto L46
    L40:
        if (Intrinsics.areEqual(r9.getLocalMessageId(), r8.getLocalMessageId()) == false) goto L42;
    L34:
        if (r12.length() == 0) goto L37;
        r13 = false;
        goto L38
    L30:
        if (Intrinsics.areEqual(r9.getMessageId(), r8.getMessageId()) == true) goto L43;
    L24:
        if (r10.length() == 0) goto L27;
        r11 = false;
    L43:
        r14 = true;
    L46:
        if (r6 == false) goto L49;
        return r3;
    L49:
        return CollectionsKt.listOf(r8);
    L51:
        return CollectionsKt.listOf(r8);
    }

    public final void f(ot8.a r44) {
        Intrinsics.checkNotNullParameter(r44, "item");
        if ((r44 instanceof com.larus.bmhome.view.screenmenu.l0) == false) goto L5;
        com.larus.bmhome.view.screenmenu.l0 r2 = (com.larus.bmhome.view.screenmenu.l0) r44;
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        com.larus.bmhome.chat.api.q0.a r0 = this.f;
        if (r0 == null) goto L13;
        com.larus.bmhome.chat.component.cvs.y r1 = r0.u0();
        if (r1 == null) goto L13;
        BotModel r3 = r1.j0();
    L14:
        com.larus.bmhome.chat.api.q0.a r4 = this.f;
        if (r4 == null) goto L19;
        com.larus.bmhome.chat.component.cvs.y r5 = r4.u0();
        if (r5 == null) goto L19;
        wc9.e r11 = r5.h();
    L20:
        IObricChatUIService r6 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        int r12 = 0;
        if (r6 == null) goto L25;
        Fragment r7 = this.a;
        Message r8 = this.g;
        if (r6.k(r7, r2, r8, com.larus.bmhome.chat.bean.d.x(r8).getCallAsrId(), c()) != true) goto L25;
        boolean r9 = true;
    L27:
        if (r9 == false) goto L29;
        FLogger.a.i("PopMenuPanelTrigger", r2.getId() + " is handled by IObricChatUIService");
    L547:
        if (r2.getId() != MenuActionType.MORE.getType()) goto L549;
        return;
    L549:
        if (r2.getId() == 2131909358) goto L560;
        com.larus.bmhome.view.screenmenu.d r10 = com.larus.bmhome.view.screenmenu.d.a;
        com.larus.bmhome.view.screenmenu.d.b(this.b);
        WeakReference<ef8.o> r13 = ef8.o.v;
        ef8.o.a.a();
        CommonMenu r14 = this.q;
        if (r14 == null) goto L561;
        com.larus.bmhome.view.screenmenu.d.b(r14);
        Unit r15 = Unit.INSTANCE;
        return;
    L561:
        return;
    L560:
        return;
    L29:
        int r16 = r2.getId();
        if (r16 != 2131907410) goto L50;
        IFlowSdkDepend r17 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r17 == null) goto L34;
        r17.a0();
        com.larus.home.impl.sdk.g r18 = com.larus.home.impl.sdk.g.a;
    L34:
        AudioServiceDelegate r19 = AudioServiceDelegate.a;
        if (r19.F().b() == false) goto L38;
        f2a.c r20 = this.p.b("[TTS][DORA_IS_WAKE_UP] Dora is wake up, return");
        r20.a(CollectionsKt.listOf("TtsPlay"));
        f2a.c.c(r20, null, 15);
        t19.s r21 = t19.s.a;
        AppHost.Companion r22 = AppHost.a;
        Application r23 = r22.getApplication();
        String r24 = r22.getApplication().getString(2131901654);
        r21.getClass();
        t19.s.t(r23, r24);
        return;
    L38:
        PlayStateEnum r25 = r19.r0().l();
        if (r25 == null) goto L41;
        r12 = r25.getState();
    L41:
        RepoDispatcher.a.getClass();
        String r26 = RepoDispatcher.i().e().c().o6();
        if (r12 == PlayStateEnum.PLAY_STATE_PLAYING.getState()) goto L46;
        if (r12 == PlayStateEnum.PLAY_STATE_PREPARE.getState()) goto L46;
    L48:
        FLogger.a.i("PopMenuPanelTrigger", "popup startTts");
        j();
    L46:
        if (Intrinsics.areEqual(r26, d().getMessageId()) == false) goto L48;
        FLogger.a.i("PopMenuPanelTrigger", "popup stopTts");
        k();
        goto L547
    L50:
        if (r16 != 2131901131) goto L60;
        if (i3.a.a() == false) goto L54;
        s3.a.b();
        Unit r27 = Unit.INSTANCE;
        goto L547
    L54:
        LifecycleOwner r28 = (LifecycleOwner) this.a.getViewLifecycleOwnerLiveData().getValue();
        if (r28 == null) goto L547;
        LifecycleCoroutineScope r110 = LifecycleOwnerKt.getLifecycleScope(r28);
        if (r110 == null) goto L547;
        BuildersKt.launch$default(r110, null, null, new AnonymousClass1(this, r3, null), 3, null);
        goto L547
    L60:
        if (r16 != 2131909358) goto L167;
        if (com.larus.platform.service.z2.a.J3() == true) goto L64;
        return;
    L64:
        if (ic8.n.o(r11) == true) goto L556;
        CommonMenu r29 = this.q;
        if ((r29 instanceof CommonMenu) == true) goto L70;
        r29 = null;
    L70:
        if (r29 == null) goto L73;
        final LinearLayoutCompat r30 = r29.e(r2.getId());
        if (r30 == null) goto L73;
    L81:
        com.larus.bmhome.instruction.g r31 = s1a.a.g(this.a).getAbility(com.larus.bmhome.instruction.g.class);
        if (r31 == null) goto L84;
        com.larus.bmhome.actionbar.model.z0 r210 = com.larus.bmhome.instruction.g.a.d(r31, ActiveSwitchType.DEEPTHINK);
    L85:
        if (r210 != null) goto L87;
        t19.s r32 = t19.s.a;
        Context r33 = r30.getContext();
        r32.getClass();
        t19.s.b(r33, 2131905626, false);
        goto L547
    L87:
        final LinearLayoutCompat r34 = this.q;
        if ((r34 instanceof CommonMenu) == true) goto L91;
        r34 = null;
    L91:
        if (r34 == null) goto L101;
        Integer r111 = Integer.valueOf(r34.getWidth());
        if (r111.intValue() <= 0) goto L95;
        boolean r112 = true;
    L96:
        if (r112 == true) goto L99;
        r111 = null;
    L99:
        if (r111 == null) goto L101;
    L110:
        int r113 = r111.intValue();
    L112:
        Map r114 = MapsKt.emptyMap();
        Map r115 = MapsKt.emptyMap();
        i5.r0();
        i5.B();
        int r35 = i5.y0(v19.c.b(2130971356, null, 2131167081));
        NestedMenuPopupStrategy r116 = NestedMenuPopupStrategy.ALIGN_TOP;
        Intrinsics.checkNotNullParameter(r114, "conversationForkSourceExt");
        Intrinsics.checkNotNullParameter(r115, "conversationForkTrackingParams");
        Intrinsics.checkNotNullParameter(r116, "popupStrategy");
        int r211 = RangesKt.coerceAtMost(r113 + i5.c(), r35);
        if (r34 == null) goto L115;
        r34.setMaskView(true);
        Unit r36 = Unit.INSTANCE;
    L115:
        IMainBotNestedMenuService.Companion r117 = IMainBotNestedMenuService.a;
        NestedMenuScene r118 = NestedMenuScene.ACTION_BAR;
        View r37 = this.a.requireView();
        if (r34 == null) goto L118;
        LinearLayoutCompat r119 = r34;
    L119:
        Map r120 = this.g.getExt();
        if (r120 != null) goto L122;
        r120 = MapsKt.emptyMap();
    L122:
        Map r212 = r120;
        Pair[] r121 = new Pair[7];
        r121[0] = TuplesKt.to("click_from", "long_press_panel");
        r121[1] = TuplesKt.to("current_page", "chat");
        by7.e r38 = this.a;
        if ((r38 instanceof by7.e) == false) goto L125;
        by7.e r39 = r38;
    L127:
        if (r39 == null) goto L133;
        HashMap r40 = by7.h.a(r39).getParams();
        if (r40 == null) goto L133;
        Object r41 = r40.get("previous_page");
        if (r41 == null) goto L133;
        String r42 = r41.toString();
    L134:
        if (r42 != null) goto L136;
        r42 = "";
    L136:
        r121[2] = TuplesKt.to("previous_page", r42);
        String r43 = this.g.getConversationId();
        if (r43 != null) goto L139;
        r43 = "";
    L139:
        r121[3] = TuplesKt.to("conversation_id", r43);
        String r45 = this.g.getMessageId();
        if (r45 != null) goto L142;
        r45 = "";
    L142:
        r121[4] = TuplesKt.to("message_id", r45);
        if (r3 == null) goto L145;
        String r46 = r3.getBotId();
    L146:
        if (r46 != null) goto L148;
        String r47 = "";
    L149:
        r121[5] = TuplesKt.to("bot_id", r47);
        ChatControlTrace r48 = ChatControlTrace.b;
        if (r11 == null) goto L152;
        Integer r49 = r11.b();
    L153:
        if (r3 == null) goto L155;
        Integer r50 = r3.getBotType();
    L156:
        if (r3 == null) goto L160;
        BotCreatorInfo r51 = r3.getBotCreatorInfo();
        if (r51 == null) goto L160;
        String r52 = r51.getId();
    L161:
        r121[6] = TuplesKt.to("chat_type", r48.g(r49, r50, Intrinsics.areEqual(r52, AccountService.a.getUserId())));
        if (IMainBotNestedMenuService.a.a(r117, r118, "fork_conv", r37, r30, r119, r210, new di8.o0(true, true, r212, false, MapsKt.mapOf(r121), r211, r211, false, null, r116, null, null, r34, new b2(this), false, true, new c2(r34), null, null, 26440614), null, new d2(r30), new e2(r34, this), 384) == true) goto L547;
        if (r34 == null) goto L547;
        r34.setMaskView(false);
        Unit r53 = Unit.INSTANCE;
    L160:
        r52 = null;
        goto L161
    L155:
        r50 = null;
        goto L156
    L152:
        r49 = null;
        goto L153
    L148:
        r47 = r46;
        goto L149
    L145:
        r46 = null;
    L133:
        r42 = null;
        goto L134
    L125:
        r39 = null;
        goto L127
    L118:
        r119 = r30;
        goto L119
    L95:
        r112 = false;
    L101:
        if (r34 == null) goto L108;
        r111 = Integer.valueOf(r34.getMeasuredWidth());
        if (r111.intValue() <= 0) goto L105;
        boolean r122 = true;
    L106:
        if (r122 == false) goto L108;
    L109:
        if (r111 != null) goto L110;
        r113 = r30.getWidth();
        goto L112
    L105:
        r122 = false;
    L108:
        r111 = null;
        goto L109
    L84:
        r210 = null;
    L73:
        r30 = this.q;
        if (r30 != null) goto L81;
        LinearLayoutCompat r54 = this.e;
        if ((r54 instanceof View) == false) goto L78;
        r30 = (View) r54;
    L79:
        if (r30 != null) goto L81;
        r30 = this.b;
        goto L81
    L78:
        r30 = null;
        goto L79
    L556:
        return;
    L167:
        if (r16 != 2131907404) goto L185;
        IFlowSdkDepend r55 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r55 == null) goto L177;
        r55.P();
        Fragment r56 = ChatServiceImpl.a.f();
        if (r56 == null) goto L177;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r57 = s1a.a.g(r56).getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r57 == null) goto L177;
        if (r57.Lo() != true) goto L177;
        boolean r123 = true;
    L178:
        if (r123 == false) goto L181;
        t19.s r58 = t19.s.a;
        Application r59 = FlowRuntime.a().getApplication();
        r58.getClass();
        t19.s.s(r59, 2131911054);
        goto L547
    L181:
        if (i3.a.a() == false) goto L183;
        s3.a.b();
        goto L547
    L183:
        this.c.K7().invoke(this.c, this.g, 1, Boolean.TRUE);
    L177:
        r123 = false;
        goto L178
    L185:
        if (r16 != 2131907401) goto L191;
        LifecycleOwner r60 = (LifecycleOwner) this.a.getViewLifecycleOwnerLiveData().getValue();
        if (r60 == null) goto L547;
        LifecycleCoroutineScope r61 = LifecycleOwnerKt.getLifecycleScope(r60);
        if (r61 == null) goto L547;
        BuildersKt.launch$default(r61, null, null, new AnonymousClass2(this, r3, null), 3, null);
        goto L547
    L191:
        String r62 = "long_press_answer";
        if (r16 != 2131907407) goto L197;
        CustomMarkdownTextView r63 = this.d;
        if (r63 == null) goto L547;
        FLogger.a.i("PopMenuPanelTrigger", "[selector_view]performLongPressClick");
        b(r63, "long_press_answer", 0, false);
        goto L547
    L197:
        if (r16 == 2131907405) goto L532;
        if (r16 == 2131908738) goto L532;
        if (r16 == 2131907403) goto L519;
        if (r16 == 2131908746) goto L519;
        if (r16 != 2131907402) goto L210;
        com.bytedance.router.i r64 = SmartRouter.buildRoute(AppHost.a.getApplication().getApplicationContext(), "//flow/chat_debug");
        r64.g(BundleKt.bundleOf(new Pair[]{TuplesKt.to("argument_key_message_id", this.g.getMessageId()), TuplesKt.to("argument_key_local_message_id", this.g.getLocalMessageId())}));
        r64.d();
        goto L547
    L210:
        if (r16 != 2131900233) goto L217;
        Fragment r65 = this.a;
        if (r65 == null) goto L547;
        FragmentActivity r66 = r65.getActivity();
        if (r66 == null) goto L547;
        ReportDialogHelper.d(ReportDialogHelper.a, r66, CollectionsKt.listOf(this.g), null, e(this.g), new g2(this), 4);
        Unit r67 = Unit.INSTANCE;
        goto L547
    L217:
        if (r16 != 2131907182) goto L240;
        IFlowSdkDepend r68 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r68 == null) goto L227;
        r68.P();
        Fragment r69 = ChatServiceImpl.a.f();
        if (r69 == null) goto L227;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r70 = s1a.a.g(r69).getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r70 == null) goto L227;
        if (r70.Lo() != true) goto L227;
        boolean r71 = true;
    L228:
        if (r71 == false) goto L231;
        t19.s r72 = t19.s.a;
        Application r73 = FlowRuntime.a().getApplication();
        r72.getClass();
        t19.s.s(r73, 2131911054);
        return;
    L231:
        com.larus.bmhome.chat.api.q0.a r74 = this.f;
        if (r74 == null) goto L547;
        IChatMessageShareAbility r75 = r74.J9();
        if (r75 == null) goto L547;
        IChatMessageShareAbility$ActionType r76 = IChatMessageShareAbility$ActionType.DELETE;
        Message r77 = this.g;
        List r78 = this.c.getCurrentList();
        Pair[] r79 = new Pair[2];
        if (this.l == false) goto L238;
        r62 = "long_press_answer_more";
    L238:
        r79[0] = TuplesKt.to("EXT_KEY_CLICK_FROM", r62);
        r79[1] = TuplesKt.to("EXT_KEY_SCENE", ChatMsgDeleteScene.longPressMenu);
        r75.yt(r76, r77, r78, MapsKt.mutableMapOf(r79));
        Unit r80 = Unit.INSTANCE;
    L227:
        r71 = false;
        goto L228
    L240:
        if (r16 != 2131908739) goto L255;
        com.larus.bmhome.chat.api.q0.a r81 = this.f;
        if (r81 == null) goto L547;
        u7 r82 = r81.u3();
        if (r82 == null) goto L547;
        com.larus.bmhome.chat.component.cvs.y r83 = this.f.u0();
        if (r83 == null) goto L248;
        wc9.e r84 = r83.h();
    L249:
        Message r85 = this.g;
        by7.e r86 = com.larus.utils.e1.k(this.b);
        if ((r86 instanceof by7.e) == false) goto L252;
        by7.e r87 = r86;
    L253:
        u7$a.c(r82, r84, r85, "long_press_answer", r87, this.i, null, c(), null, 160);
        Unit r88 = Unit.INSTANCE;
        goto L547
    L252:
        r87 = null;
        goto L253
    L248:
        r84 = null;
        goto L249
    L255:
        if (r16 != 2131380340) goto L297;
        Object r89 = r2.c();
        if ((r89 instanceof AnswerAction) == false) goto L259;
        AnswerAction r90 = (AnswerAction) r89;
    L260:
        if (r90 != null) goto L262;
        return;
    L262:
        String r91 = r90.getUrl();
        if (r91 != null) goto L265;
    L268:
        boolean r92 = true;
    L269:
        if (r92 == false) goto L271;
        return;
    L271:
        Uri r93 = UriProtector.parse(r91);
        Result.Companion r94 = Result.Companion;     // Catch: Throwable -> L293
        String r95 = r93.getAuthority();     // Catch: Throwable -> L293
        if (r95 != null) goto L275;
    L291:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L293
    L295:
        ChatControlTrace.b.Wa(r90.getKey(), "long_press_answer", c());
        goto L547
    L275:
        if (r95.hashCode() != (-2103590931)) goto L291;
        if (r95.equals("half_webview") == false) goto L291;
        String r96 = UriProtector.getQueryParameter(r93, "url");     // Catch: Throwable -> L293
        if (r96 != null) goto L282;
    L285:
        boolean r97 = true;
    L286:
        if (r97 == true) goto L291;
        Uri.Builder r99 = UriProtector.parse(r96).buildUpon();     // Catch: Throwable -> L293
        BotInfoCache r100 = BotInfoCache.INSTANCE;     // Catch: Throwable -> L293
        String r101 = this.g.getConversationId();     // Catch: Throwable -> L293
        if (r101 != null) goto L290;
        r101 = "";
    L290:
        com.larus.platform.service.q.a.d(this.b, BundleKt.bundleOf(new Pair[]{TuplesKt.to("link_url", r99.appendQueryParameter("bot_id", r100.getBotId(r101)).appendQueryParameter("conversation_id", this.g.getConversationId()).appendQueryParameter("msg_id", this.g.getMessageId()).appendQueryParameter("action_key", r90.getKey()).appendQueryParameter("section_id", this.g.getSectionId()).build().toString())}));     // Catch: Throwable -> L293
        goto L291
    L282:
        if (r96.length() == 0) goto L285;
        r97 = false;
    L293:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L295
    L265:
        if (StringsKt.isBlank(r91) == true) goto L268;
        r92 = false;
        goto L269
    L259:
        r90 = null;
        goto L260
    L297:
        if (r16 != 2131900868) goto L299;
    L498:
        IFlowSdkDepend r103 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r103 == null) goto L507;
        r103.P();
        Fragment r104 = ChatServiceImpl.a.f();
        if (r104 == null) goto L507;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r105 = s1a.a.g(r104).getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r105 == null) goto L507;
        if (r105.Lo() != true) goto L507;
        boolean r124 = true;
    L508:
        if (r124 == false) goto L511;
        t19.s r106 = t19.s.a;
        Application r107 = FlowRuntime.a().getApplication();
        r106.getClass();
        t19.s.s(r107, 2131911054);
        Unit r108 = Unit.INSTANCE;
        goto L547
    L511:
        if (ic8.n.C(r11) == false) goto L513;
        t19.s r109 = t19.s.a;
        Context r125 = this.a.getContext();
        r109.getClass();
        t19.s.s(r125, 2131900761);
        Unit r126 = Unit.INSTANCE;
        goto L547
    L513:
        com.larus.bmhome.chat.api.q0.a r127 = this.f;
        if (r127 == null) goto L547;
        IChatMessageShareAbility r128 = r127.J9();
        if (r128 == null) goto L547;
        r128.yt(IChatMessageShareAbility$ActionType.SHARE, this.g, this.c.getCurrentList(), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("EXT_KEY_CLICK_FROM", "long_press_answer")}));
        Unit r129 = Unit.INSTANCE;
    L507:
        r124 = false;
        goto L508
    L299:
        if (r16 == 2131907411) goto L498;
        if (r16 != 2131907406) goto L353;
        IFlowSdkDepend r130 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r130 == null) goto L312;
        r130.P();
        Fragment r131 = ChatServiceImpl.a.f();
        if (r131 == null) goto L312;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r132 = s1a.a.g(r131).getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r132 == null) goto L312;
        if (r132.Lo() != true) goto L312;
        boolean r133 = true;
    L313:
        if (r133 == false) goto L316;
        t19.s r134 = t19.s.a;
        Application r135 = FlowRuntime.a().getApplication();
        r134.getClass();
        t19.s.s(r135, 2131911054);
        return;
    L316:
        com.larus.bmhome.chat.api.q0.a r136 = this.f;
        if (r136 == null) goto L325;
        com.larus.bmhome.chat.component.bottom.reference.a r137 = r136.N9();
        if (r137 == null) goto L325;
        Message r138 = this.g;
        if (r3 == null) goto L323;
        Integer r213 = r3.getBotType();
    L324:
        com.larus.bmhome.chat.component.bottom.reference.a.C0053a.a(r137, r138, r213, null, true, RefEntranceType.LongPressAnswerMore, 4);
        Unit r139 = Unit.INSTANCE;
        goto L325
    L323:
        r213 = null;
    L325:
        ChatControlTrace r140 = ChatControlTrace.b;
        JSONObject r141 = IAIChatControlTraceService.a.c(r140, this.g);
        if (r141 != null) goto L328;
        r141 = new JSONObject();
    L328:
        JSONObject r214 = r141;
        String r310 = r140.tb(this.g);
        if (r3 == null) goto L331;
        String r142 = r3.getBotId();
    L332:
        if (r11 == null) goto L334;
        String r143 = r11.c();
    L335:
        by7.e r215 = by7.h.g(this.b);
        if (r11 == null) goto L338;
        Integer r144 = r11.b();
    L339:
        if (r3 == null) goto L341;
        Integer r145 = r3.getBotType();
    L342:
        if (r3 == null) goto L346;
        BotCreatorInfo r146 = r3.getBotCreatorInfo();
        if (r146 == null) goto L346;
        String r147 = r146.getId();
    L347:
        String r216 = r140.g(r144, r145, Intrinsics.areEqual(r147, AccountService.a.getUserId()));
        String r217 = this.g.getMessageId();
        boolean r148 = com.larus.bmhome.chat.bean.d.z0(this.g);
        if (this.l == false) goto L350;
        String r218 = "long_press_answer_more";
    L351:
        tx9.c0.g(r142, r143, r217, r214, r215, null, r216, Integer.valueOf(r148 ? 1 : 0), r218, ChatControlTrace.a0(this.g.getUserType()), null, r140.jb(this.d), r310, Boolean.valueOf(com.larus.bmhome.chat.bean.d.f0(this.g)), null, null, null, 462944);
        goto L547
    L350:
        r218 = "long_press_answer";
    L346:
        r147 = null;
        goto L347
    L341:
        r145 = null;
        goto L342
    L338:
        r144 = null;
        goto L339
    L334:
        r143 = null;
        goto L335
    L331:
        r142 = null;
    L312:
        r133 = false;
        goto L313
    L353:
        if (r16 != 2131900900) goto L360;
        FLogger.a.i("PopMenuPanelTrigger", "click action collect");
        com.larus.bmhome.chat.api.q0.a r149 = this.f;
        if (r149 == null) goto L547;
        IChatMessageShareAbility r150 = r149.J9();
        if (r150 == null) goto L547;
        r150.yt(IChatMessageShareAbility$ActionType.COLLECT, this.g, this.c.getCurrentList(), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("EXT_KEY_CLICK_FROM", "long_press_answer")}));
        Unit r151 = Unit.INSTANCE;
        goto L547
    L360:
        if (r16 != 2131380355) goto L391;
        FLogger.a.i("PopMenuPanelTrigger", "click action single collect");
        final FragmentActivity r152 = this.a.getContext();
        if (r152 != null) goto L367;
        r152 = this.a.getActivity();
        if (r152 != null) goto L367;
        return;
    L367:
        com.larus.bmhome.chat.api.q0.a r153 = this.f;
        if (r153 == null) goto L372;
        u7 r154 = r153.u3();
        if (r154 == null) goto L372;
        List r155 = r154.zj();
    L373:
        if (r155 == null) goto L381;
        com.larus.bmhome.chat.api.q0.a r156 = this.f;
        if (r156 == null) goto L379;
        IChatMessageShareAbility r157 = r156.J9();
        if (r157 == null) goto L379;
        List r158 = r157.Us(this.g, r155);
    L380:
        if (r158 == null) goto L381;
    L382:
        List r159 = r158;
        ChatControlTrace r160 = ChatControlTrace.b;
        JSONObject r161 = IAIChatControlTraceService.a.c(r160, this.g);
        if (r161 != null) goto L385;
        r161 = new JSONObject();
    L385:
        JSONObject r162 = r161;
        r162.put("message_id_list", CollectionsKt.joinToString$default(r159, ",", null, null, 0, null, new h2(), 30, null));
        r162.put("agent_id", r160.tb(this.g));
        r162.put("trigger_message_id", this.g.getMessageId());
        com.larus.bmhome.chat.api.q0.a r163 = this.f;
        if (r163 == null) goto L547;
        com.larus.bmhome.chat.component.collection.o r164 = r163.i2();
        if (r164 == null) goto L547;
        r164.i50("long_press_answer", null, r159, 5, r162, new i2(r152, this));
        Unit r165 = Unit.INSTANCE;
    L379:
        r158 = null;
    L381:
        r158 = CollectionsKt.mutableListOf(new Message[]{this.g});
    L372:
        r155 = null;
        goto L373
    L391:
        if (r16 != 2131910857) goto L398;
        FLogger.a.i("PopMenuPanelTrigger", "PopMenuPanelTrigger cancelMessageCollect, msgId=" + this.g.getMessageId());
        com.larus.bmhome.chat.api.q0.a r166 = this.f;
        if (r166 == null) goto L547;
        com.larus.bmhome.chat.component.collection.o r167 = r166.i2();
        if (r167 == null) goto L547;
        com.larus.bmhome.chat.component.collection.o$a.a(r167, "long_press_answer", this.g);
        Unit r168 = Unit.INSTANCE;
        goto L547
    L398:
        if (r16 != 2131899580) goto L401;
        int r169 = r.a;
        r.a(this.a, this.g, this.f, null, null);
        goto L547
    L401:
        if (r16 != MenuActionType.MORE.getType()) goto L431;
        final CommonMenu r170 = this.q;
        if (r170 != null) goto L405;
        return;
    L405:
        Object r171 = r2.c();
        if (TypeIntrinsics.isMutableList(r171) == false) goto L408;
        List r172 = (List) r171;
    L409:
        if (r172 != null) goto L412;
        this.m = true;
        com.larus.bmhome.view.screenmenu.d r173 = com.larus.bmhome.view.screenmenu.d.a;
        com.larus.bmhome.view.screenmenu.d.b(r170);
        return;
    L412:
        FragmentActivity r174 = this.a.getContext();
        if (r174 != null) goto L418;
        r174 = this.a.getActivity();
        if (r174 != null) goto L418;
        return;
    L418:
        this.l = true;
        this.m = false;
        ChatControlTrace r175 = ChatControlTrace.b;
        Message r176 = this.g;
        Fragment r177 = this.a;
        long r178 = c();
        r175.getClass();
        ChatControlTrace.R(r176, r177, r178);
        CommonMenu r179 = new CommonMenu(r174);
        com.larus.bmhome.view.screenmenu.g.a(r179);
        r179.getLayoutParams().width += i5.c();
        r179.g(r172, this);
        r179.measure(0, 0);
        FragmentActivity r180 = this.a.getActivity();
        if (r180 == null) goto L430;
        Window r181 = r180.getWindow();
        if (r181 == null) goto L557;
        View r182 = a(r181);
        if (r182 == null) goto L558;
        int[] r183 = new int[2];
        r170.getLocationOnScreen(r183);
        int[] r184 = new int[2];
        r182.getLocationOnScreen(r184);
        int r185 = r183[1] + r170.getHeight();
        int r186 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost((r184[1] + r182.getHeight()) - r185, r179.getMeasuredHeight() / 2), 0);
        int r187 = (((r183[0] + (r170.getWidth() / 2)) - r184[0]) - (r182.getWidth() / 2)) - i5.e0();
        int r188 = (r185 - r184[1]) + r186;
        r170.setMaskView(true);
        Unit r189 = Unit.INSTANCE;
        com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r170, r179.i(), false, null, null, null, new x1(this, r170), 60).v(r182, r187, r188);
        Message r190 = this.g;
        by7.e r191 = by7.h.g(this.b);
        if (r11 == null) goto L428;
        String r192 = ic8.n.f(r11);
    L429:
        IAIChatControlTraceService.a.g(r175, r172, r190, r3, r191, r192);
        goto L547
    L428:
        r192 = null;
        goto L429
    L558:
        return;
    L557:
        return;
    L430:
        return;
    L408:
        r172 = null;
        goto L409
    L431:
        MenuActionType r193 = MenuActionType.EXPORT_FILE;
        if (r16 != r193.getType()) goto L434;
    L481:
        View r194 = this.e;
        if ((r194 instanceof View) == false) goto L484;
        View r195 = r194;
    L485:
        if (r195 == null) goto L547;
        ef8.b r196 = new ef8.b(this.g, this.f, this.c, null, new PopMenuPanelTrigger$invoke$11$menuContext$1(r195), null, null, new c(), null, null, null, 3816);
        int r197 = r2.getId();
        if (r197 != r193.getType()) goto L490;
        new com.larus.bmhome.chat.layout.holder.menu.item.s().b(r2, r195, r196);
        goto L547
    L490:
        if (r197 != MenuActionType.DOWNLOAD_FILE.getType()) goto L493;
        new DownloadFileMenuHandler().b(r2, r195, r196);
        goto L547
    L493:
        if (r197 != MenuActionType.SAVE_IMAGE.getType()) goto L496;
        new SaveImageMenuHandler().b(r2, r195, r196);
        goto L547
    L496:
        if (r197 != MenuActionType.SAVE_VIDEO.getType()) goto L547;
        new SaveVideoMenuHandler().b(r2, r195, r196);
        goto L547
    L484:
        r195 = null;
        goto L485
    L434:
        if (r16 == MenuActionType.DOWNLOAD_FILE.getType()) goto L481;
        if (r16 == MenuActionType.SAVE_IMAGE.getType()) goto L481;
        if (r16 == MenuActionType.SAVE_VIDEO.getType()) goto L481;
        if (r16 != 2131899667) goto L456;
        View r198 = this.e;
        if ((r198 instanceof View) == false) goto L445;
        View r199 = r198;
    L446:
        if (r199 != null) goto L448;
        return;
    L448:
        IFlowPodcastService r200 = (IFlowPodcastService) ServiceManager.get().getService(IFlowPodcastService.class);
        if (r200 == null) goto L547;
        Context r201 = r199.getContext();
        com.larus.bmhome.chat.api.q0.a r202 = this.f;
        if (r202 == null) goto L453;
        CoroutineScope r203 = r202.F9();
    L454:
        r200.b(new vr9.a(r201, r203, this.g.getMessageId(), this.g.getConversationId(), PodcastClickSource.MessagePanelLongPress), new y1(this), null);
        Unit r204 = Unit.INSTANCE;
        goto L547
    L453:
        r203 = null;
        goto L454
    L445:
        r199 = null;
        goto L446
    L456:
        if (r16 != 2131894369) goto L469;
        FragmentActivity r205 = this.a.getContext();
        if (r205 != null) goto L463;
        r205 = this.a.getActivity();
        if (r205 != null) goto L463;
        return;
    L463:
        com.larus.platform.api.e r1100 = new com.larus.platform.api.e("agent_trace", this.g.getConversationId(), this.g.getMessageId(), this.g.getLocalMessageId(), com.larus.im.bean.message.a.x(this.g), this.g.getSectionId());
        IFlowSdkDepend r206 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r206 == null) goto L547;
        FlowAppletServiceImpl r207 = r206.g0();
        if (r207 == null) goto L547;
        r207.o(r205, "agent_trace", r1100);
        goto L547
    L469:
        if (r16 != 2131894378) goto L547;
        FragmentActivity r208 = this.a.getContext();
        if (r208 != null) goto L476;
        r208 = this.a.getActivity();
        if (r208 != null) goto L476;
        return;
    L476:
        com.larus.platform.api.e r209 = new com.larus.platform.api.e(this.g.getConversationId(), this.g.getMessageId(), this.g.getLocalMessageId(), com.larus.im.bean.message.a.x(this.g));
        IFlowSdkDepend r219 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r219 == null) goto L547;
        FlowAppletServiceImpl r220 = r219.g0();
        if (r220 == null) goto L547;
        r220.o(r208, "copy_logid", r209);
    L519:
        if (com.larus.bmhome.chat.bean.d.h0(this.g) == false) goto L525;
        com.larus.bmhome.chat.api.q0.a r221 = this.f;
        if (r221 == null) goto L547;
        u7 r222 = r221.u3();
        if (r222 == null) goto L547;
        r222.Y70(this.g, 8);
        Unit r223 = Unit.INSTANCE;
        goto L547
    L525:
        com.larus.bmhome.chat.api.q0.a r224 = this.f;
        if (r224 == null) goto L530;
        u7 r225 = r224.u3();
        if (r225 == null) goto L530;
        r225.Mf(this.g, 8);
        Unit r226 = Unit.INSTANCE;
    L530:
        ChatControlTrace.b.Qa("long_press_answer", this.g, this.a, c());
        Unit r227 = Unit.INSTANCE;
    L532:
        if (com.larus.bmhome.chat.bean.d.q0(this.g) == false) goto L538;
        com.larus.bmhome.chat.api.q0.a r228 = this.f;
        if (r228 == null) goto L547;
        u7 r229 = r228.u3();
        if (r229 == null) goto L547;
        r229.fh(this.g, 8);
        Unit r230 = Unit.INSTANCE;
        goto L547
    L538:
        ChatControlTrace.b.Ha("long_press_answer", this.g, this.a, c());
        final boolean r231 = com.larus.platform.service.z1.a.d();
        com.larus.bmhome.chat.api.q0.a r232 = this.f;
        if (r232 == null) goto L543;
        u7 r233 = r232.u3();
        if (r233 == null) goto L543;
        r233.OD(this.g, 8, new f2(r231, this));
        Unit r234 = Unit.INSTANCE;
    L543:
        if (r231 == true) goto L545;
        h(this);
    L545:
        Unit r235 = Unit.INSTANCE;
    L25:
        r9 = false;
    L19:
        r11 = null;
    L13:
        r3 = null;
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
        f((ot8.a) r1);
        return Unit.INSTANCE;
    }

    public final void l0(CommonMenu r2) {
        Intrinsics.checkNotNullParameter(r2, "menu");
        this.q = r2;
    }

    public final void b(CustomMarkdownTextView r11, String r12, int r13, boolean r14) {
        MarkDownSelectHelper r0 = MarkDownSelectHelper.a;
        com.larus.bmhome.chat.api.q0 r1 = this.c;
        Message r3 = d();
        int r2 = od8.h0.a;
        Message r4 = this.g;
        if (r4 == null) goto L5;
        Integer r5 = ic8.j.b(r4);
    L6:
        com.larus.bmhome.chat.api.z.a.b(r0, r1, r11, r3, !od8.h0.a(r5), r12, r13, r14, new b(this), 32);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void i(Message r71, com.larus.bmhome.chat.api.q0.a r72, String r73, String r74) {
        if (r72 == null) goto L8;
        com.larus.bmhome.chat.component.cvs.y r1 = r72.u0();
        if (r1 == null) goto L8;
        BotModel r2 = r1.j0();
        if (r2 == null) goto L8;
    L9:
        ry8.b r3 = (ry8.b) this.c.N7().invoke();
        if (r3 == null) goto L14;
        Boolean r4 = r3.L9();
        if (r4 == null) goto L14;
        boolean r5 = r4.booleanValue();
    L15:
        com.larus.bmhome.chat.api.q0.a r6 = this.f;
        String r7 = null;
        if (r6 == null) goto L20;
        com.larus.bmhome.chat.component.cvs.y r8 = r6.u0();
        if (r8 == null) goto L20;
        wc9.e r9 = r8.h();
    L21:
        String r10 = r2.getBotId();
        String r11 = r71.getConversationId();
        if (r11 == null) goto L24;
        Long r12 = StringsKt.toLongOrNull(r11);
    L26:
        if (com.larus.bmhome.chat.bean.d.z0(r71) == false) goto L28;
        long r13 = 1;
    L29:
        String r14 = r71.getMessageId();
        ChatControlTrace r15 = ChatControlTrace.b;
        if (r9 == null) goto L32;
        Integer r16 = r9.v;
    L33:
        Integer r17 = r2.getBotType();
        BotCreatorInfo r18 = r2.getBotCreatorInfo();
        if (r18 == null) goto L36;
        r7 = r18.getId();
    L36:
        String r19 = r15.g(r16, r17, Intrinsics.areEqual(r7, AccountService.a.getUserId()));
        if (r5 == false) goto L39;
        String r20 = "1";
    L40:
        String r110 = r20;
        boolean r21 = com.larus.bmhome.chat.bean.d.Q0(r71);
        String r111 = r15.jb(this.d);
        boolean r22 = com.larus.bmhome.chat.bean.d.f0(r71);
        boolean r23 = com.larus.bmhome.chat.bean.d.K0(r71);
        tx9.c0.G(r10, r19, "long_press_answer", r12, Long.valueOf(r13), r14, r73, r110, Boolean.valueOf(r21), r74, r111, Boolean.valueOf(r22), Boolean.valueOf(r23), by7.h.g(this.b), 262752);
        return;
    L39:
        r20 = "0";
        goto L40
    L32:
        r16 = null;
        goto L33
    L28:
        r13 = 0;
        goto L29
    L24:
        r12 = null;
    L20:
        r9 = null;
    L14:
        r5 = false;
    L8:
        r2 = new BotModel("-1", "unknown", null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -132, Integer.MAX_VALUE, null);
        goto L9
    }

    public PopMenuPanelTrigger(Fragment r2, RecyclerView r3, com.larus.bmhome.chat.api.q0 r4, CustomMarkdownTextView r5, st8.a r6, com.larus.bmhome.chat.api.q0.a r7, Message r8, Function0<Message> r9, boolean r10, lw8.l r11, LongClickSource r12) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "hostView");
        Intrinsics.checkNotNullParameter(r4, "adapter");
        Intrinsics.checkNotNullParameter(r8, "data");
        Intrinsics.checkNotNullParameter(r9, "childMsgGetter");
        Intrinsics.checkNotNullParameter(r12, "longClickSource");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.n = LazyKt.lazy(new w1());
        this.o = LazyKt.lazy(new a2());
        this.p = new f2a.d("Chat", "PopMenuPanelTrigger");
    }
}
