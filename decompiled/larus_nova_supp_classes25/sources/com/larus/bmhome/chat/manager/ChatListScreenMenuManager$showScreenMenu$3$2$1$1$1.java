package com.larus.bmhome.chat.manager;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService;
import com.larus.bmhome.chat.nestedmenu.NestedMenuPopupStrategy;
import com.larus.bmhome.chat.nestedmenu.NestedMenuScene;
import com.larus.bmhome.view.screenmenu.ScreenMenuLayout;
import com.larus.bmhome.view.screenmenu.x0;
import com.larus.im.bean.bot.AnswerAction;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.manager.ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1", f = "ChatListScreenMenuManager.kt", i = {0}, l = {DoraCallStateCode.ENV_OBSERVE_AUTO_TIMER_ENTER_PAUSE}, m = "invokeSuspend", n = {"$this$bindFork"}, s = {"L$0"})
public final class ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ wh8.a $conversationData;
    final /* synthetic */ Fragment $hostFragment;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ t0 $mobConfig;
    final /* synthetic */ View $primaryMenu;
    final /* synthetic */ x0 $screenMenu;
    final /* synthetic */ View $this_menuView;
    final /* synthetic */ View $v;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a implements Function1<View, Unit> {
        public final /* synthetic */ wc9.e a;
        public final /* synthetic */ Fragment b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CoroutineScope d;
        public final /* synthetic */ t0 e;
        public final /* synthetic */ wh8.a f;
        public final /* synthetic */ View g;
        public final /* synthetic */ x0 h;
        public final /* synthetic */ LifecycleOwner i;
        public final /* synthetic */ Deferred<z0> j;

        public a(wc9.e r1, Fragment r2, String r3, CoroutineScope r4, t0 r5, wh8.a r6, View r7, x0 r8, LifecycleOwner r9, Deferred<z0> r10) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
        }

        public final Object invoke(Object r39) {
            View r14 = (View) r39;
            Intrinsics.checkNotNullParameter(r14, "sourceView");
            if (z2.a.J3() == true) goto L5;
        L68:
            FLogger.a.w("ChatListScreenMenuManager", "conversation fork blocked: settings or conversation disabled");
            t19.s r0 = t19.s.a;
            Context r2 = r14.getContext();
            r0.getClass();
            t19.s.b(r2, 2131905626, false);
        L70:
            return Unit.INSTANCE;
        L5:
            if (ic8.n.o(this.a) == true) goto L68;
            FLogger.a.i("ChatListScreenMenuManager", "side nav fork clicked");
            Fragment r9 = this.b;
            if (r9 == null) goto L70;
            wc9.e r13 = this.a;
            if (r13 == null) goto L70;
            String r12 = this.c;
            if (r12 == null) goto L70;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L21
            String r3 = r13.r;     // Catch: Throwable -> L21
            if (r3 != null) goto L19;
            r3 = "";
        L19:
            Object r4 = Result.constructor-impl(new JSONObject(r3));     // Catch: Throwable -> L21
        L23:
            JSONObject r5 = new JSONObject();
            if (Result.isFailure-impl(r4) == false) goto L26;
            r4 = r5;
        L26:
            JSONObject r6 = (JSONObject) r4;
            List r7 = CollectionsKt.listOf(new String[]{"reply_mode", "agent_task_param"});
            ArrayList r8 = new ArrayList();
            Iterator r10 = r7.iterator();
        L27:
            Pair r11 = null;
            if (r10.hasNext() == false) goto L37;
            String r15 = (String) r10.next();
            String r16 = r6.optString(r15);
            Intrinsics.checkNotNull(r16);
            if ((!StringsKt.isBlank(r16)) == true) goto L33;
            r16 = null;
        L33:
            if (r16 == null) goto L35;
            r11 = TuplesKt.to(r15, r16);
        L35:
            if (r11 == null) goto L27;
            r8.add(r11);
            goto L27
        L37:
            Map r19 = MapsKt.toMap(r8);
            Pair[] r17 = new Pair[7];
            r17[0] = TuplesKt.to("click_from", "new_chat_setting_panel");
            t0 r18 = this.e;
            if (r18 == null) goto L40;
            String r20 = r18.b;
        L41:
            if (r20 != null) goto L43;
            r20 = "";
        L43:
            r17[1] = TuplesKt.to("current_page", r20);
            t0 r21 = this.e;
            if (r21 == null) goto L46;
            r11 = r21.c;
        L46:
            if (r11 != null) goto L48;
            r11 = "";
        L48:
            r17[2] = TuplesKt.to("previous_page", r11);
            r17[3] = TuplesKt.to("conversation_id", r13.a);
            r17[4] = TuplesKt.to("message_id", "");
            r17[5] = TuplesKt.to("bot_id", r12);
            int r22 = ChatListScreenMenuManager.a;
            r17[6] = TuplesKt.to("chat_type", ChatListScreenMenuManager.g(this.f));
            Map r23 = MapsKt.mapOf(r17);
            NestedMenuPopupStrategy r26 = NestedMenuPopupStrategy.ALIGN_TOP;
            di8.o0 r24 = new di8.o0(true, true, r19, true, r23, 0, i5.R(), false, null, r26, x.a, y.a, this.g, new ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$1$forkUiConfig$1(this.h), true, false, new z(this.h), null, null, 27293574);
            b0 r110 = new b0(this.h, r14, this.e, r9, r13, r12);
            c0 r111 = new c0(r14);
            View r112 = r9.getView();
            if (this.h.h() == false) goto L70;
            if (r14.isAttachedToWindow() == false) goto L70;
            if (r112 != null) goto L54;
        L56:
            boolean r25 = false;
        L57:
            if (r25 == false) goto L70;
            ScreenMenuLayout r27 = this.h.a;
            if (r27 == null) goto L63;
            r27.setMenuMask(true);
        L63:
            if (IMainBotNestedMenuService.a.a(IMainBotNestedMenuService.a, NestedMenuScene.SETTINGS, "fork_conv", r112, r14, r14, null, di8.o0.a(r24, false, null, false, r14.getContext().getString(2131908573), false, 33554295), null, r111, r110, 256) == true) goto L67;
            ScreenMenuLayout r28 = this.h.a;
            if (r28 == null) goto L70;
            r28.setMenuMask(false);
            goto L70
        L67:
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.i), null, null, new ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$1$1(this.h, r14, r112, r24, r111, r110, r13, this.j, this.i, r12, null), 3, null);
            goto L70
        L54:
            if (r112.isAttachedToWindow() != true) goto L56;
            r25 = true;
            goto L57
        L40:
            r20 = null;
        L21:
            th = move-exception;
            Result.Companion r29 = Result.Companion;
            r4 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L23
        }
    }

    public ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1(wh8.a r1, View r2, View r3, Fragment r4, wc9.e r5, View r6, LifecycleOwner r7, t0 r8, x0 r9, Continuation<? super ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1> r10) {
        this.$conversationData = r1;
        this.$primaryMenu = r2;
        this.$v = r3;
        this.$hostFragment = r4;
        this.$conversation = r5;
        this.$this_menuView = r6;
        this.$lifecycleOwner = r7;
        this.$mobConfig = r8;
        this.$screenMenu = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1 r11 = new ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1(this.$conversationData, this.$primaryMenu, this.$v, this.$hostFragment, this.$conversation, this.$this_menuView, this.$lifecycleOwner, this.$mobConfig, this.$screenMenu, r14);
        r11.L$0 = r13;
        return r11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    public final Object invokeSuspend(Object r19) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = this.label;
        Deferred r5 = null;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r19);     // Catch: Exception -> L8 CancellationException -> L10
        Object r6 = r19;
        r2 = r3;
    L23:
        BotModel r7 = (BotModel) r6;     // Catch: Exception -> L8 CancellationException -> L10
        ?? r4 = r2;
    L19:
        ?? r11 = r4;
        if (this.$primaryMenu.isAttachedToWindow() == false) goto L81;
        if (this.$v.isAttachedToWindow() == false) goto L81;
        Fragment r1 = this.$hostFragment;
        if (r1 == null) goto L37;
        View r8 = r1.getView();
        if (r8 == null) goto L37;
        if (r8.isAttachedToWindow() != true) goto L37;
        boolean r9 = true;
    L38:
        if (r9 == false) goto L81;
        if (r7 == null) goto L62;
        List r10 = r7.getMenuActions();
        if (r10 == null) goto L62;
        Iterator r12 = r10.iterator();
    L45:
        if (r12.hasNext() == false) goto L60;
        Object r13 = r12.next();
        AnswerAction r14 = (AnswerAction) r13;
        if (Intrinsics.areEqual(r14.getKey(), "fork_conv") == false) goto L57;
        String r15 = r14.getName();
        if (r15 != null) goto L51;
    L54:
        boolean r16 = true;
    L55:
        if (r16 == true) goto L57;
        boolean r17 = true;
    L58:
        if (r17 == false) goto L45;
    L61:
        AnswerAction r18 = (AnswerAction) r13;
    L63:
        if (r18 == null) goto L79;
        if (ic8.n.o(this.$conversation) == true) goto L79;
        View r20 = this.$this_menuView.findViewById(2131372783);
        ((TextView) this.$this_menuView.findViewById(2131390935)).setText(r18.getName());
        Intrinsics.checkNotNull(r20);
        e1.x(r20);
        FLogger.a.i("ChatListScreenMenuManager", "side nav fork entry enabled");
        Fragment r21 = this.$hostFragment;
        wc9.e r22 = this.$conversation;
        if (r7 == null) goto L73;
        String r23 = r7.getBotId();
        if (r23 == null) goto L73;
        if ((!StringsKt.isBlank(r23)) == false) goto L73;
        String r110 = r23;
    L74:
        if (r21 == null) goto L77;
        if (r110 == null) goto L77;
        r5 = BuildersKt.async$default(LifecycleOwnerKt.getLifecycleScope(this.$lifecycleOwner), Dispatchers.getIO(), null, new ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$actionBarItemDeferred$1(r110, null), 2, null);
    L77:
        this.$this_menuView.setOnForkClick(new a(r22, r21, r110, r11, this.$mobConfig, this.$conversationData, this.$primaryMenu, this.$screenMenu, this.$lifecycleOwner, r5));
    L73:
        r110 = null;
    L79:
        return Unit.INSTANCE;
    L51:
        if (StringsKt.isBlank(r15) == true) goto L54;
        r16 = false;
    L57:
        r17 = false;
        goto L58
    L60:
        r13 = null;
    L62:
        r18 = null;
    L37:
        r9 = false;
    L81:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r19);
        CoroutineScope r24 = (CoroutineScope) this.L$0;
        wh8.a r25 = this.$conversationData;
        if (r25 == null) goto L20;
        r7 = r25.b;
        r4 = r24;
        if (r7 != null) goto L19;
    L20:
        ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$forkBotModel$1 r26 = new ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$forkBotModel$1(this.$conversation, null);     // Catch: Exception -> L8 CancellationException -> L10
        this.L$0 = r24;     // Catch: Exception -> L8 CancellationException -> L10
        this.label = 1;     // Catch: Exception -> L8 CancellationException -> L10
        r6 = TimeoutKt.c(5000, r26, this);     // Catch: Exception -> L8 CancellationException -> L10
        r2 = r24;
        if (r6 != r0) goto L23;
        return r0;
    L10:
        e = move-exception;
        throw e;
    L8:
        e = move-exception;
        FLogger.a.e("ChatListScreenMenuManager", "side nav fork bot lookup failed", e);
        r7 = null;
        r4 = r2;
        goto L19
    }
}
