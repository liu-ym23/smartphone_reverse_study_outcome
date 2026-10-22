package com.obric.assistant.block.lark.knowledge_authorized;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OLarkKnowledgeBlock;
import com.larus.im.bean.message.block.OLarkKnowledgeButton;
import com.larus.im.bean.message.block.OLarkKnowledgeSubtitle;
import com.larus.im.observer.MessageListState;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricImBlockKnowledgeAuthorizationBinding;
import com.obric.assistant.t1;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kc8.g;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LarkKnowledgeAuthorizedBlockHolder extends jc8.b<com.obric.assistant.block.lark.knowledge_authorized.a> {
    public static final /* synthetic */ int k = 0;
    public ObricImBlockKnowledgeAuthorizationBinding d;
    public final CoroutineScope e;
    public final AtomicBoolean f;
    public Message g;
    public Job h;
    public Job i;
    public final Lazy j;

    public static final class a {
    }

    public static final class b implements nf9.b {
        public final /* synthetic */ LarkKnowledgeAuthorizedBlockHolder a;

        public final void a(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void c(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        public final void d(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void e(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        public final void f(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void onMessageListReplaced(String r2, List<Message> r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "oldMsgList");
            Intrinsics.checkNotNullParameter(r4, "newMsgList");
        }

        public b(LarkKnowledgeAuthorizedBlockHolder r1) {
            this.a = r1;
        }

        public final void b(String r4, MessageListState r5, List<Message> r6) {
            Intrinsics.checkNotNullParameter(r4, "cid");
            Intrinsics.checkNotNullParameter(r5, "state");
            Intrinsics.checkNotNullParameter(r6, "msgList");
            Message r0 = this.a.g;
            if (r0 == null) goto L5;
            String r1 = r0.getConversationId();
        L7:
            if (Intrinsics.areEqual(r4, r1) == false) goto L10;
            FLogger.a.i("KnowledgeAuthorizedBlockHolder", "onMessageListChanged: cid=" + r4 + ", state=" + r5 + ", msgList.size=" + r6.size());
            this.a.k();
            return;
        L10:
            return;
        L5:
            r1 = null;
            goto L7
        }
    }

    static {
    }

    public final String c() {
        return "LarkKnowledgeAuthorizedBlockHolder";
    }

    public final void i() {
        FLogger.a.i("KnowledgeAuthorizedBlockHolder", "onViewRecycled");
        Job r0 = this.h;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        Job r1 = this.i;
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        m();
    }

    public final void k() {
        Message r0 = this.g;
        if (r0 != null) goto L6;
        FLogger.a.i("KnowledgeAuthorizedBlockHolder", "checkLastMessage: blockMessage is null");
        return;
    L6:
        Job r1 = this.h;
        if (r1 == null) goto L9;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L9:
        this.h = BuildersKt.launch$default(this.e, null, null, new LarkKnowledgeAuthorizedBlockHolder$checkLastMessageAndDisableBlock$1(this, r0, null), 3, null);
    }

    public final void l() {
        ObricImBlockKnowledgeAuthorizationBinding r0 = this.d;
        if (r0 == null) goto L7;
        TextView r1 = r0.b;
        if (r1 == null) goto L7;
        r1.setClickable(false);
    L7:
        ObricImBlockKnowledgeAuthorizationBinding r2 = this.d;
        if (r2 == null) goto L12;
        TextView r3 = r2.b;
        if (r3 == null) goto L12;
        r3.setFocusable(false);
    L12:
        ObricImBlockKnowledgeAuthorizationBinding r4 = this.d;
        if (r4 == null) goto L17;
        TextView r5 = r4.b;
        if (r5 == null) goto L17;
        r5.setEnabled(false);
    L17:
        ObricImBlockKnowledgeAuthorizationBinding r6 = this.d;
        if (r6 == null) goto L22;
        TextView r7 = r6.b;
        if (r7 == null) goto L22;
        r7.setOnClickListener(null);
    L22:
        ObricImBlockKnowledgeAuthorizationBinding r8 = this.d;
        if (r8 == null) goto L28;
        RelativeLayout r9 = r8.a;
        if (r9 == null) goto L29;
        r9.setAlpha(0.6f);
        return;
    L29:
        return;
    }

    public final void m() {
        if (this.f.compareAndSet(true, false) == false) goto L6;
        FLogger.a.i("KnowledgeAuthorizedBlockHolder", "unregisterOnGlobalMessageObserver");
        com.larus.im.d.e().unregisterOnGlobalMessageObserver((b) this.j.getValue());
        return;
    }

    public LarkKnowledgeAuthorizedBlockHolder() {
        this.e = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.f = new AtomicBoolean(false);
        this.j = LazyKt.lazy(new com.obric.assistant.block.lark.knowledge_authorized.b(this));
    }

    public final jc8.d f(jc8.a r2) {
        Intrinsics.checkNotNullParameter((com.obric.assistant.block.lark.knowledge_authorized.a) r2, "blockModel");
        return new jc8.d(0, 0, 0, 0);
    }

    public final void g(jc8.a r12) {
        com.obric.assistant.block.lark.knowledge_authorized.a r13 = (com.obric.assistant.block.lark.knowledge_authorized.a) r12;
        Intrinsics.checkNotNullParameter(r13, "blockModel");
        BlockContent r0 = ((jc8.a) r13).a.getContent();
        String r1 = null;
        if (r0 == null) goto L5;
        OLarkKnowledgeBlock r2 = r0.getOLarkKnowledgeBlock();
    L6:
        FLogger r3 = FLogger.a;
        r3.i("KnowledgeAuthorizedBlockHolder", "onBindBlockView: larkKnowledgeBlock = " + r2);
        if (r2 != null) goto L9;
        r3.w("KnowledgeAuthorizedBlockHolder", "onBindBlockView: larkKnowledgeBlock is null");
        return;
    L9:
        ObricImBlockKnowledgeAuthorizationBinding r4 = this.d;
        if (r4 != null) goto L12;
        r3.w("KnowledgeAuthorizedBlockHolder", "onBindBlockView: binding is null");
        return;
    L12:
        this.g = g.a(r13.i);
        ObricImBlockKnowledgeAuthorizationBinding r5 = this.d;
        if (r5 == null) goto L17;
        ImageView r6 = r5.k;
        if (r6 == null) goto L17;
        r6.setImageResource(2131244446);
    L17:
        ObricImBlockKnowledgeAuthorizationBinding r7 = this.d;
        if (r7 == null) goto L22;
        ImageView r8 = r7.c;
        if (r8 == null) goto L22;
        r8.setImageResource(2131244455);
    L22:
        ObricImBlockKnowledgeAuthorizationBinding r9 = this.d;
        if (r9 == null) goto L27;
        ImageView r10 = r9.l;
        if (r10 == null) goto L27;
        r10.setImageResource(2131244444);
    L27:
        ObricImBlockKnowledgeAuthorizationBinding r11 = this.d;
        String r14 = NameKeys.UnloadStrategy_No_Strategy;
        if (r11 == null) goto L35;
        TextView r15 = r11.m;
        if (r15 == null) goto L35;
        String r16 = r2.title;
        if (r16 != null) goto L34;
        r16 = NameKeys.UnloadStrategy_No_Strategy;
    L34:
        r15.setText(r16);
    L35:
        ObricImBlockKnowledgeAuthorizationBinding r17 = this.d;
        if (r17 == null) goto L43;
        TextView r18 = r17.i;
        if (r18 == null) goto L43;
        String r19 = r2.hint;
        if (r19 != null) goto L42;
        r19 = NameKeys.UnloadStrategy_No_Strategy;
    L42:
        r18.setText(r19);
    L43:
        List r20 = r2.subtitles;
        if (r20 != null) goto L46;
        r20 = CollectionsKt.emptyList();
    L46:
        ObricImBlockKnowledgeAuthorizationBinding r21 = this.d;
        if (r21 == null) goto L57;
        TextView r22 = r21.g;
        if (r22 == null) goto L57;
        OLarkKnowledgeSubtitle r23 = (OLarkKnowledgeSubtitle) CollectionsKt.getOrNull(r20, 0);
        if (r23 == null) goto L53;
        String r24 = r23.subtitle;
    L54:
        if (r24 != null) goto L56;
        r24 = NameKeys.UnloadStrategy_No_Strategy;
    L56:
        r22.setText(r24);
        goto L57
    L53:
        r24 = null;
    L57:
        ObricImBlockKnowledgeAuthorizationBinding r25 = this.d;
        if (r25 == null) goto L68;
        TextView r26 = r25.h;
        if (r26 == null) goto L68;
        OLarkKnowledgeSubtitle r110 = (OLarkKnowledgeSubtitle) CollectionsKt.getOrNull(r20, 1);
        if (r110 == null) goto L64;
        String r111 = r110.subtitle;
    L65:
        if (r111 != null) goto L67;
        r111 = NameKeys.UnloadStrategy_No_Strategy;
    L67:
        r26.setText(r111);
        goto L68
    L64:
        r111 = null;
    L68:
        ObricImBlockKnowledgeAuthorizationBinding r27 = this.d;
        if (r27 == null) goto L79;
        TextView r28 = r27.e;
        if (r28 == null) goto L79;
        OLarkKnowledgeSubtitle r112 = (OLarkKnowledgeSubtitle) CollectionsKt.getOrNull(r20, 0);
        if (r112 == null) goto L75;
        String r113 = r112.subContent;
    L76:
        if (r113 != null) goto L78;
        r113 = NameKeys.UnloadStrategy_No_Strategy;
    L78:
        r28.setText(r113);
        goto L79
    L75:
        r113 = null;
    L79:
        ObricImBlockKnowledgeAuthorizationBinding r29 = this.d;
        if (r29 == null) goto L90;
        TextView r30 = r29.f;
        if (r30 == null) goto L90;
        OLarkKnowledgeSubtitle r31 = (OLarkKnowledgeSubtitle) CollectionsKt.getOrNull(r20, 1);
        if (r31 == null) goto L86;
        String r32 = r31.subContent;
    L87:
        if (r32 != null) goto L89;
        r32 = NameKeys.UnloadStrategy_No_Strategy;
    L89:
        r30.setText(r32);
        goto L90
    L86:
        r32 = null;
    L90:
        ObricImBlockKnowledgeAuthorizationBinding r33 = this.d;
        if (r33 == null) goto L95;
        ConstraintLayout r34 = r33.n;
        if (r34 == null) goto L95;
        r34.setClickable(false);
    L95:
        ObricImBlockKnowledgeAuthorizationBinding r35 = this.d;
        if (r35 == null) goto L100;
        LinearLayout r36 = r35.j;
        if (r36 == null) goto L100;
        r36.setClickable(false);
    L100:
        ObricImBlockKnowledgeAuthorizationBinding r37 = this.d;
        if (r37 == null) goto L106;
        LinearLayout r38 = r37.d;
        if (r38 == null) goto L106;
        r38.setClickable(false);
    L106:
        if (t1.a.isLarkKnowledgeAuthorizationEnable() == false) goto L116;
        TextView r114 = r4.b;
        List r39 = r2.buttons;
        if (r39 == null) goto L112;
        OLarkKnowledgeButton r40 = (OLarkKnowledgeButton) CollectionsKt.firstOrNull(r39);
        if (r40 == null) goto L112;
        r1 = r40.textSelected;
    L112:
        if (r1 == null) goto L115;
        r14 = r1;
    L115:
        r114.setText(r14);
        l();
        return;
    L116:
        boolean r41 = Intrinsics.areEqual(r2.enabled, Boolean.TRUE);
        r3.i("KnowledgeAuthorizedBlockHolder", "onBindBlockView: isBlockEnabled = " + r41 + " , curBlockMessage = " + this.g);
        o(r13, r2);
        if (r41 == false) goto L135;
        Map r115 = g.a(r13.i).getExt();
        if (r115 == null) goto L121;
        String r116 = (String) r115.get("o_task_type");
    L123:
        if (Intrinsics.areEqual(r116, "complex_task") == false) goto L125;
        return;
    L125:
        if (this.f.compareAndSet(false, true) == false) goto L127;
        r3.i("KnowledgeAuthorizedBlockHolder", "registerOnGlobalMessageObserver");
        com.larus.im.d.e().registerOnGlobalMessageObserver((b) this.j.getValue());
    L127:
        k();
        Job r117 = this.i;
        if (r117 == null) goto L130;
        Job.DefaultImpls.cancel$default(r117, null, 1, null);
    L130:
        this.i = BuildersKt.launch$default(this.e, null, null, new LarkKnowledgeAuthorizedBlockHolder$startTimeoutCheck$1(this, null), 3, null);
        return;
    L121:
        r116 = null;
        goto L123
    L135:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final View h(ViewGroup r19) {
        Intrinsics.checkNotNullParameter(r19, "viewGroup");
        FLogger.a.i("KnowledgeAuthorizedBlockHolder", "onCreatedBlockView: viewGroup = " + r19);
        View r0 = LayoutInflater.from(r19.getContext()).inflate(2131564021, r19, false);
        int r1 = 2131363582;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r0, 2131363582);
        if (r5 == null) goto L35;
        r1 = 2131371851;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r0, 2131371851);
        if (r6 == null) goto L35;
        r1 = 2131373138;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131373138);
        if (r7 == null) goto L35;
        r1 = 2131374368;
        if (((ImageView) ViewBindings.findChildViewById(r0, 2131374368)) == null) goto L35;
        r1 = 2131374369;
        if (((ImageView) ViewBindings.findChildViewById(r0, 2131374369)) == null) goto L35;
        r1 = 2131374374;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r0, 2131374374);
        if (r8 == null) goto L35;
        r1 = 2131374375;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r0, 2131374375);
        if (r9 == null) goto L35;
        r1 = 2131374376;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r0, 2131374376);
        if (r10 == null) goto L35;
        r1 = 2131374377;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r0, 2131374377);
        if (r11 == null) goto L35;
        r1 = 2131374379;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r0, 2131374379);
        if (r12 == null) goto L35;
        r1 = 2131380098;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131380098);
        if (r13 == null) goto L35;
        r1 = 2131387016;
        ImageView r14 = (ImageView) ViewBindings.findChildViewById(r0, 2131387016);
        if (r14 == null) goto L35;
        r1 = 2131388191;
        ImageView r15 = (ImageView) ViewBindings.findChildViewById(r0, 2131388191);
        if (r15 == null) goto L35;
        r1 = 2131388772;
        TextView r16 = (TextView) ViewBindings.findChildViewById(r0, 2131388772);
        if (r16 == null) goto L35;
        r1 = 2131389245;
        ConstraintLayout r17 = ViewBindings.findChildViewById(r0, 2131389245);
        if (r17 == null) goto L35;
        RelativeLayout r2 = (RelativeLayout) r0;
        this.d = new ObricImBlockKnowledgeAuthorizationBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
        return r2;
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public final void o(final com.obric.assistant.block.lark.knowledge_authorized.a r6, final OLarkKnowledgeBlock r7) {
        ObricImBlockKnowledgeAuthorizationBinding r0 = this.d;
        if (r0 != null) goto L7;
        FLogger.a.w("KnowledgeAuthorizedBlockHolder", "updateViewHolder: binding is null");
        return;
    L7:
        if (Intrinsics.areEqual(r7.type, "lark_knowledge_authorized") == true) goto L10;
        FLogger.a.i("KnowledgeAuthorizedBlockHolder", "updateViewHolder: unknown knowledge authorized type");
        return;
    L10:
        List r1 = r7.buttons;
        if (r1 == null) goto L24;
        OLarkKnowledgeButton r2 = (OLarkKnowledgeButton) CollectionsKt.firstOrNull(r1);
        if (r2 == null) goto L24;
        TextView r3 = r0.b;
        if (Intrinsics.areEqual(r2.isSelected, Boolean.TRUE) == false) goto L19;
        String r4 = r2.textSelected;
        if (r4 == null) goto L21;
    L22:
        r3.setText(r4);
    L21:
        r4 = NameKeys.UnloadStrategy_No_Strategy;
        goto L22
    L19:
        r4 = r2.textNormal;
        if (r4 != null) goto L22;
    L24:
        if (Intrinsics.areEqual(r7.enabled, Boolean.FALSE) == false) goto L26;
        l();
        return;
    L26:
        r0.a.setAlpha(1.0f);
        r0.b.setClickable(true);
        r0.b.setFocusable(true);
        e1.d(r0.b, new c(r7, this, r6));
    }

    public static final Object j(LarkKnowledgeAuthorizedBlockHolder r9, String r10, Continuation r11) {
        r9.getClass();
        if ((r11 instanceof LarkKnowledgeAuthorizedBlockHolder$getLastMessage$1) == false) goto L7;
        LarkKnowledgeAuthorizedBlockHolder$getLastMessage$1 r0 = (LarkKnowledgeAuthorizedBlockHolder$getLastMessage$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L123:
        Message r4 = (Message) r12;
        if (r4 == null) goto L126;
        FLogger.a.i("KnowledgeAuthorizedBlockHolder", "getLastMessage from repo " + r4.getMessageId());
        return r4;
    L126:
        FLogger.a.i("KnowledgeAuthorizedBlockHolder", "getLastMessage: cvsId = " + r10 + ", not found");
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        kc8.b r13 = jc8.c.a(r9, kc8.b.class);
        if (r13 == null) goto L64;
        y r14 = r13.a;
        if (r14 == null) goto L64;
        Fragment r15 = r14.a;
        if (r15 == null) goto L64;
        t1a.b r16 = s1a.a.g(r15);
        if (r16 == null) goto L64;
        u7 r17 = r16.getAbility(u7.class);
        if (r17 == null) goto L64;
        List r18 = r17.zj();
        if (r18 == null) goto L64;
        Iterator r19 = r18.iterator();
    L28:
        if (r19.hasNext() == false) goto L62;
        Object r6 = r19.next();
        Message r7 = (Message) r6;
        if (com.larus.bmhome.chat.bean.d.i0(r7) == false) goto L35;
        if (com.larus.bmhome.chat.bean.d.w(r7) == true) goto L35;
    L54:
        boolean r8 = false;
    L55:
        if (r8 == true) goto L57;
    L59:
        boolean r20 = false;
    L60:
        if (r20 == false) goto L28;
    L63:
        Message r21 = (Message) r6;
    L65:
        if (r21 == null) goto L67;
        FLogger.a.i("KnowledgeAuthorizedBlockHolder", "getLastMessage from last message list " + r21.getMessageId());
        return r21;
    L67:
        kc8.b r22 = jc8.c.a(r9, kc8.b.class);
        if (r22 == null) goto L117;
        y r23 = r22.a;
        if (r23 == null) goto L117;
        Fragment r24 = r23.a;
        if (r24 == null) goto L117;
        t1a.b r25 = s1a.a.g(r24);
        if (r25 == null) goto L117;
        u7 r26 = r25.getAbility(u7.class);
        if (r26 == null) goto L117;
        MessageAdapter r27 = r26.MF();
        if (r27 == null) goto L117;
        Iterator r28 = r27.getCurrentList().iterator();
    L81:
        if (r28.hasNext() == false) goto L115;
        Object r110 = r28.next();
        Message r29 = (Message) r110;
        if (com.larus.bmhome.chat.bean.d.i0(r29) == false) goto L88;
        if (com.larus.bmhome.chat.bean.d.w(r29) == true) goto L88;
    L107:
        boolean r30 = false;
    L108:
        if (r30 == true) goto L110;
    L112:
        boolean r31 = false;
    L113:
        if (r31 == false) goto L81;
    L116:
        Message r111 = (Message) r110;
    L118:
        if (r111 == null) goto L120;
        FLogger.a.i("KnowledgeAuthorizedBlockHolder", "getLastMessage from adapter list " + r111.getMessageId());
        return r111;
    L120:
        IChatRepoService r32 = zh8.a.a;
        r0.L$0 = r10;
        r0.label = 1;
        r12 = r32.D1(r10, r0);
        if (r12 != r2) goto L123;
        return r2;
    L110:
        if (b0.f(r29) == true) goto L112;
        r31 = true;
    L88:
        if (com.larus.bmhome.chat.bean.d.T(r29) == true) goto L107;
        if (com.larus.bmhome.chat.bean.d.p0(r29) == true) goto L107;
        if (com.larus.bmhome.chat.bean.d.C0(r29) == true) goto L95;
    L97:
        MessageStatus r33 = r29.getMessageStatus();
        if (r33 != null) goto L100;
    L102:
        boolean r34 = false;
    L103:
        if (r34 == false) goto L105;
    L106:
        r30 = true;
        goto L108
    L105:
        if (b0.f(r29) == false) goto L107;
    L100:
        if (r33.isVisible() != true) goto L102;
        r34 = true;
        goto L103
    L95:
        if (r29.getRegenVisible() == true) goto L97;
    L115:
        r110 = null;
    L117:
        r111 = null;
        goto L118
    L57:
        if (b0.f(r7) == true) goto L59;
        r20 = true;
    L35:
        if (com.larus.bmhome.chat.bean.d.T(r7) == true) goto L54;
        if (com.larus.bmhome.chat.bean.d.p0(r7) == true) goto L54;
        if (com.larus.bmhome.chat.bean.d.C0(r7) == true) goto L42;
    L44:
        MessageStatus r35 = r7.getMessageStatus();
        if (r35 != null) goto L47;
    L49:
        boolean r36 = false;
    L50:
        if (r36 == false) goto L52;
    L53:
        r8 = true;
        goto L55
    L52:
        if (b0.f(r7) == false) goto L54;
    L47:
        if (r35.isVisible() != true) goto L49;
        r36 = true;
        goto L50
    L42:
        if (r7.getRegenVisible() == true) goto L44;
    L62:
        r6 = null;
    L64:
        r21 = null;
    L7:
        r0 = new LarkKnowledgeAuthorizedBlockHolder$getLastMessage$1(r9, r11);
        goto L8
    }
}
