package com.larus.bmhome.chat.component.share;

import android.content.ClipData;
import android.content.Context;
import androidx.fragment.app.Fragment;
import ce8.c;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.holder.helper.MessageCopyHelper;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.chat.trace.e;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.StateFlowImpl;
import org.json.JSONObject;
import tx9.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.share.ChatShareBottomComponent$handleCopyText$1", f = "ChatShareBottomComponent.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2}, l = {812, 817, 838}, m = "invokeSuspend", n = {"context", "botModel", "sb", "userPrefix", "validCount", "message", "context", "botModel", "sb", "userPrefix", "validCount", "message", "validCount"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$7", "L$0"})
final class ChatShareBottomComponent$handleCopyText$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Message> $selectedMessageList;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    final /* synthetic */ ChatShareBottomComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.share.ChatShareBottomComponent$handleCopyText$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.share.ChatShareBottomComponent$handleCopyText$1$2", f = "ChatShareBottomComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ StringBuilder $sb;
        int label;

        public AnonymousClass2(StringBuilder r1, Context r2, Continuation<? super AnonymousClass2> r3) {
            this.$sb = r1;
            this.$context = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.$sb, this.$context, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r4);
            ClipData r5 = ClipData.newPlainText(ChatDraftItem.TYPE_TEXT, this.$sb.toString());
            IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r0 == null) goto L7;
            r0.d0();
            com.larus.home.impl.sdk.i1 r1 = com.larus.home.impl.sdk.i1.a;
            Context r2 = this.$context;
            Intrinsics.checkNotNull(r5);
            r1.i(r2, r5, "bpea-share-message-copy");
        L7:
            t19.s r6 = t19.s.a;
            Context r3 = this.$context;
            r6.getClass();
            t19.s.o(r3, 2131910467, false);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatShareBottomComponent$handleCopyText$1(ChatShareBottomComponent r1, List<Message> r2, Continuation<? super ChatShareBottomComponent$handleCopyText$1> r3) {
        this.this$0 = r1;
        this.$selectedMessageList = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatShareBottomComponent$handleCopyText$1(this.this$0, this.$selectedMessageList, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:107:0x02c8 -> B:146:0x0450). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:133:0x03d5 -> B:134:0x03da). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r90) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        char r3 = 65306;
        String r10 = "ChatShareBottomComponent";
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L14;
        if (r2 != 3) goto L13;
        Ref.IntRef r1 = (Ref.IntRef) this.L$0;
        ResultKt.throwOnFailure(r90);     // Catch: SecurityException -> L10
    L158:
        FLogger.a.d(r10, "copy " + r1.element + " messages");     // Catch: SecurityException -> L10
    L164:
        return Unit.INSTANCE;
    L10:
        e = e;
    L162:
        FLogger.a.e(r10, "do copy failed", e);
        goto L164
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        Message r4 = (Message) this.L$7;
        Iterator r12 = (Iterator) this.L$6;
        ChatShareBottomComponent r13 = (ChatShareBottomComponent) this.L$5;
        Ref.IntRef r14 = (Ref.IntRef) this.L$4;
        String r15 = (String) this.L$3;
        StringBuilder r8 = (StringBuilder) this.L$2;
        BotModel r9 = (BotModel) this.L$1;
        Context r5 = (Context) this.L$0;
        ResultKt.throwOnFailure(r90);
        ChatShareBottomComponent$handleCopyText$1 r6 = this;
        Object r7 = r90;
    L134:
        String r11 = (String) r7;
        if (r11.length() != 0) goto L137;
        boolean r16 = true;
    L138:
        if (r16 == false) goto L141;
    L145:
        Object r17 = r0;
        r1 = r14;
        ChatShareBottomComponent r18 = r13;
        Iterator r19 = r12;
        String r110 = r10;
        String r111 = r15;
        ChatShareBottomComponent$handleCopyText$1 r112 = r6;
        BotModel r87 = r9;
        StringBuilder r20 = r8;
        BotModel r21 = r87;
    L146:
        r3 = 65306;
    L78:
        if (r19.hasNext() == false) goto L148;
        Message r22 = (Message) r19.next();
        if (r22.getContentType() != 800) goto L104;
        if (Intrinsics.areEqual(r22.getBizContentType(), "deep_search_card") == false) goto L104;
        int r23 = ChatShareBottomComponent.R;
        r18.getClass();
        int r24 = ic8.p.a;
        ic8.p r25 = ic8.p.a.a(r22.getContent());
        if (r25 == null) goto L104;
        String r113 = r25.c();
        if (r113 != null) goto L89;
    L92:
        boolean r114 = true;
    L93:
        if (r114 == true) goto L104;
        String r115 = r25.a();
        if (r115 != null) goto L97;
    L100:
        boolean r116 = true;
    L101:
        if (r116 == true) goto L104;
        r20.append(r21.getName() + r3);
        r20.append('\n');
        r20.append(r25.c());
        r20.append('\n');
        r20.append(r25.a());
        r20.append('\n');
        goto L104
    L97:
        if (r115.length() == 0) goto L100;
        r116 = false;
        goto L101
    L89:
        if (r113.length() == 0) goto L92;
        r114 = false;
    L104:
        if (d.N(r22) == false) goto L106;
    L108:
        int r26 = ChatShareBottomComponent.R;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r18, "<this>");     // Catch: Throwable -> L111
        Fragment r27 = com.larus.ui.arch.component.internal.attach.a.b(r18, r18);     // Catch: Throwable -> L111
    L112:
        if (r27 != null) goto L114;
    L116:
        boolean r28 = false;
    L117:
        if (r28 == false) goto L119;
        MessageCopyHelper r29 = MessageCopyHelper.a;
        BotModel r30 = r18.E3();
        if (r30 != null) goto L126;
        BotInfoCache r117 = BotInfoCache.INSTANCE;
        String r118 = r22.getConversationId();
        if (r118 != null) goto L125;
        r118 = "";
    L125:
        r30 = new BotModel(r117.getBotId(r118), null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
    L126:
        r112.L$0 = r5;
        r112.L$1 = r21;
        r112.L$2 = r20;
        r112.L$3 = r111;
        r112.L$4 = r1;
        r112.L$5 = r18;
        r112.L$6 = r19;
        r112.L$7 = r22;
        r112.label = 1;
        Object r31 = com.larus.bmhome.chat.layout.holder.helper.s0.a.b(r29, r5, r22, r30, r112);
        if (r31 != r17) goto L129;
        return r17;
    L129:
        String r32 = r111;
        r10 = r110;
        r12 = r19;
        r13 = r18;
        r14 = r1;
        r0 = r17;
        r4 = r22;
        StringBuilder r88 = r20;
        r9 = r21;
        r8 = r88;
    L130:
        MessageCopyHelper r33 = MessageCopyHelper.a;
        r112.L$0 = r5;
        r112.L$1 = r9;
        r112.L$2 = r8;
        r112.L$3 = r32;
        r112.L$4 = r14;
        r112.L$5 = r13;
        r112.L$6 = r12;
        r112.L$7 = r4;
        r112.label = 2;
        r7 = r33.b((List) r31, r112);
        if (r7 != r0) goto L133;
        return r0;
    L133:
        ChatShareBottomComponent$handleCopyText$1 r89 = r112;
        r15 = r32;
        r6 = r89;
        goto L134
    L119:
        return Unit.INSTANCE;
    L114:
        if (r27.isDetached() == true) goto L116;
        r28 = true;
    L111:
        r27 = null;
        goto L112
    L106:
        if (d.k(r22) == true) goto L108;
    L148:
        if (r20.length() != 0) goto L150;
        boolean r34 = true;
    L151:
        if (r34 == false) goto L167;
        FLogger.a.d(r110, "copy messages empty, skip");
        return Unit.INSTANCE;
    L167:
        MainCoroutineDispatcher r35 = Dispatchers.getMain();     // Catch: SecurityException -> L160
        AnonymousClass2 r36 = new AnonymousClass2(r20, r5, null);     // Catch: SecurityException -> L160
        r112.L$0 = r1;     // Catch: SecurityException -> L160
        r112.L$1 = null;     // Catch: SecurityException -> L160
        r112.L$2 = null;     // Catch: SecurityException -> L160
        r112.L$3 = null;     // Catch: SecurityException -> L160
        r112.L$4 = null;     // Catch: SecurityException -> L160
        r112.L$5 = null;     // Catch: SecurityException -> L160
        r112.L$6 = null;     // Catch: SecurityException -> L160
        r112.L$7 = null;     // Catch: SecurityException -> L160
        r112.label = 3;     // Catch: SecurityException -> L160
        if (BuildersKt.withContext(r35, r36, r112) != r17) goto L157;
        return r17;
    L157:
        r10 = r110;
    L160:
        e = e;
        r10 = r110;
        goto L162
    L150:
        r34 = false;
        goto L151
    L141:
        if (d.G0(r4) == false) goto L143;
        r8.append(r15 + 65306);
        r8.append('\n');
        r8.append(r11);
        r8.append('\n');
    L144:
        r14.element++;
        r8.append("\n");
        goto L145
    L143:
        r8.append(r9.getName() + 65306);
        r8.append('\n');
        r8.append(r11);
        r8.append('\n');
        goto L144
    L137:
        r16 = false;
        goto L138
    L15:
        r4 = (Message) this.L$7;
        Iterator r37 = (Iterator) this.L$6;
        ChatShareBottomComponent r38 = (ChatShareBottomComponent) this.L$5;
        Ref.IntRef r39 = (Ref.IntRef) this.L$4;
        String r119 = (String) this.L$3;
        StringBuilder r120 = (StringBuilder) this.L$2;
        BotModel r121 = (BotModel) this.L$1;
        Context r122 = (Context) this.L$0;
        ResultKt.throwOnFailure(r90);
        r32 = r119;
        r12 = r37;
        r5 = r122;
        r112 = this;
        r31 = r90;
        r13 = r38;
        r8 = r120;
        r14 = r39;
        r9 = r121;
        goto L130
    L16:
        ResultKt.throwOnFailure(r90);
        Context r40 = this.this$0.getContext();
        ChatShareBottomComponent r41 = this.this$0;
        int r42 = ChatShareBottomComponent.R;
        com.larus.bmhome.chat.component.cvs.y r43 = r41.u0();
        if (r43 == null) goto L166;
        BotModel r44 = r43.j0();
        if (r44 == null) goto L166;
        ChatShareBottomComponent r45 = this.this$0;
        r45.getClass();
        Intrinsics.checkNotNullParameter(r45, "<this>");     // Catch: Throwable -> L24
        Fragment r46 = com.larus.ui.arch.component.internal.attach.a.b(r45, r45);     // Catch: Throwable -> L24
    L25:
        if (r46 != null) goto L27;
    L29:
        boolean r47 = false;
    L30:
        if (r47 == false) goto L32;
        new CustomMarkdownTextView(r40, null, 6, 0);
        ChatControlTrace r48 = ChatControlTrace.b;
        List<Message> r49 = this.$selectedMessageList;
        long r123 = this.this$0.f1().n;
        r48.getClass();
        Intrinsics.checkNotNullParameter("share_panel", "clickFrom");
        Intrinsics.checkNotNullParameter(r49, "msgList");
        com.larus.bmhome.chat.trace.a r50 = (com.larus.bmhome.chat.trace.a) ChatControlTrace.C.get(Long.valueOf(r123));
        if (r50 == null) goto L75;
        StateFlowImpl r124 = c.a;
        JSONObject r51 = ChatControlTrace.v("share_panel", null, r50, null);
        r51.put("message_type", ChatDraftItem.TYPE_TEXT);
        c.c(r51);
        if (r49.size() <= 1) goto L38;
        boolean r125 = true;
    L39:
        List<Message> r52 = r49;
        String r210 = CollectionsKt.joinToString$default(r52, ",", null, null, 0, null, new e(), 30, null);
        Iterator<T> r126 = r52.iterator();
    L41:
        if (r126.hasNext() == false) goto L45;
        Object r127 = r126.next();
        if (d.G0((Message) r127) == false) goto L41;
    L46:
        Message r128 = (Message) r127;
        Iterator<T> r129 = r52.iterator();
    L48:
        if (r129.hasNext() == false) goto L52;
        Object r130 = r129.next();
        if ((!d.G0((Message) r130)) == false) goto L48;
    L53:
        Message r131 = (Message) r130;
        if (r128 == null) goto L57;
        if (r131 == null) goto L57;
        String r132 = "user_and_bot";
    L60:
        String r310 = r132;
        by7.e r57 = ChatControlTrace.b.ob(r123);
        String r211 = ChatControlTrace.P;
        String r311 = ChatControlTrace.M;
        String r312 = ChatControlTrace.L;
        Iterator<T> r53 = r52.iterator();
    L62:
        if (r53.hasNext() == false) goto L69;
        Object r133 = r53.next();
        if (com.larus.im.bean.message.a.r((Message) r133) == null) goto L66;
        boolean r134 = true;
    L67:
        if (r134 == false) goto L62;
    L70:
        Message r135 = (Message) r133;
        if (r135 == null) goto L73;
        String r54 = com.larus.im.bean.message.a.r(r135);
    L74:
        j0.a(null, null, null, null, null, r210, null, r211, null, null, null, null, null, null, null, Boolean.valueOf(r125), r310, null, "main_text", Boolean.FALSE, null, r312, r311, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r54, null, r51, r57, null, -1811943553, 4980732);
    L76:
        StringBuilder r55 = new StringBuilder();
        String r56 = r40.getString(2131910908);
        Ref.IntRef r136 = new Ref.IntRef();
        List<Message> r137 = this.$selectedMessageList;
        r18 = this.this$0;
        r19 = r137.iterator();
        r112 = this;
        r17 = r0;
        r1 = r136;
        r110 = "ChatShareBottomComponent";
        r111 = r56;
        r20 = r55;
        r21 = r44;
        r5 = r40;
        goto L78
    L73:
        r54 = null;
        goto L74
    L66:
        r134 = false;
        goto L67
    L69:
        r133 = null;
    L57:
        if (r128 == null) goto L59;
        r132 = "user";
        goto L60
    L59:
        r132 = "bot";
        goto L60
    L52:
        r130 = null;
        goto L53
    L45:
        r127 = null;
        goto L46
    L38:
        r125 = false;
        goto L39
    L75:
        FLogger.a.d("ChatControlTrace", "onMultiCopy chatKey not found");
        goto L76
    L32:
        return Unit.INSTANCE;
    L27:
        if (r46.isDetached() == true) goto L29;
        r47 = true;
    L24:
        r46 = null;
    L166:
        return Unit.INSTANCE;
    }
}
