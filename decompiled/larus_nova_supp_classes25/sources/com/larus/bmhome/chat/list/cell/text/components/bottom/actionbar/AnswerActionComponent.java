package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.utils.w2;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.bmhome.view.actionbar.AdaptiveMessageActionBar;
import com.larus.bmhome.view.actionbar.MessageActionBarAlign;
import com.larus.bmhome.view.actionbar.NonPriorityMessageActionBar;
import com.larus.bmhome.view.actionbar.PriorityMessageActionBar;
import com.larus.bmhome.view.actionbar.api.ChatUIBlockConfig;
import com.larus.im.bean.bot.AnswerAction;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.RegenStatus;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.TaskCardBlock;
import com.larus.im.bean.message.block.TaskCardStyle;
import com.larus.platform.IFlowMessageService;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import tx9.n3;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class AnswerActionComponent extends bd8.b implements z1, a2 {
    public static final Lazy<Set<String>> G = null;
    public static final Lazy<Set<String>> H = null;
    public static final Lazy<Set<String>> I = null;
    public static final Lazy<List<AnswerAction>> J = null;
    public static final Lazy<AnswerAction> K = null;
    public static final Lazy<List<AnswerAction>> L = null;
    public static final Lazy<Set<Integer>> M = null;
    public long A;
    public boolean B;
    public final Lazy C;
    public AnswerActionComponent$setupTtsObserver$observer$1 D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy l;
    public boolean m;
    public final Lazy n;
    public Message o;
    public FrameLayout p;
    public final Lazy q;
    public Job r;
    public final Lazy s;
    public final Lazy t;
    public final ISettingRepoService u;
    public final Lazy v;
    public final Lazy w;
    public rs8.h x;
    public final Lazy y;
    public ec8.b z;

    public static final class a {
        public a() {
        }
    }

    static {
        new a();
        G = LazyKt.lazy(new l0());
        H = LazyKt.lazy(new m0());
        I = LazyKt.lazy(new n0());
        J = LazyKt.lazy(new o0());
        K = LazyKt.lazy(new q0());
        L = LazyKt.lazy(new r0());
        M = LazyKt.lazy(new s0());
    }

    @Override // bd8.b
    public final void B() {
        AnswerActionComponent$setupTtsObserver$observer$1 r0 = this.D;
        if (r0 == null) goto L5;
        AudioServiceDelegate.a.r0().k(r0);
    L5:
        this.D = null;
    }

    @Override // bd8.b
    public final void C() {
        FrameLayout r0 = this.p;
        if (r0 == null) goto L5;
        com.larus.utils.e1.o(r0);
    L5:
        com.larus.bmhome.chat.layout.item.i r1 = this.d;
        if (r1 == null) goto L8;
        r1.setMinimumWidth(0);
    L8:
        ec8.b r2 = this.z;
        if (r2 == null) goto L12;
        Intrinsics.checkNotNullParameter(AnswerActionComponent.class, "clazz");
        r2.b.remove(AnswerActionComponent.class);
        return;
    }

    public final de8.c M() {
        return (de8.c) this.t.getValue();
    }

    public final com.larus.bmhome.chat.component.cvs.y N() {
        return (com.larus.bmhome.chat.component.cvs.y) this.l.getValue();
    }

    @Override // com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.a2
    public final va8.p h() {
        return (va8.p) this.F.getValue();
    }

    @Override // com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.a2
    public final u7 k() {
        return (u7) this.E.getValue();
    }

    @Override // com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.a2
    public final ChatParam l() {
        return (ChatParam) this.s.getValue();
    }

    @Override // com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.a2
    public final com.larus.bmhome.chat.component.regen.a n() {
        return (com.larus.bmhome.chat.component.regen.a) this.v.getValue();
    }

    @Override // bd8.b
    public final void z() {
        final Message r0 = this.o;
        if (r0 != null) goto L5;
        return;
    L5:
        if (g(r0) == false) goto L44;
        PlayStateEnum r1 = AudioServiceDelegate.a.r0().l();
        Context r3 = getContext();
        if (r3 == null) goto L41;
        com.larus.bmhome.chat.api.q0 r4 = this.e;
        Boolean r12 = null;
        if (r4 == null) goto L11;
        com.larus.bmhome.chat.api.q0.a r5 = r4.getProvider();
    L12:
        MessageActionBarAlign r6 = MessageActionBarAlign.KEEP;
        AnswerActionComponent$tryResumeTtsAnswerActionStatus$1$1$creator$1 r7 = new AnswerActionComponent$tryResumeTtsAnswerActionStatus$1$1$creator$1(this);
        BotModel r8 = dg8.t.d(N());
        Fragment r2 = this.c;
        if (r2 == null) goto L15;
        t1a.b r9 = s1a.a.g(r2);
    L16:
        Fragment r10 = this.c;
        de8.c r11 = M();
        if (r11 == null) goto L19;
        Bundle r13 = r11.b;
    L20:
        if (r13 == null) goto L24;
        boolean r14 = true;
        if (r13.getBoolean("human_merge_forward_float_chat") != true) goto L24;
    L25:
        rs8.g r15 = new d2(r3, r4, r5, r6, r7, r8, r9, r10, r14).b(r1, new e0(r0));
        View r16 = this.x;
        if (r16 == null) goto L41;
        if ((r16 instanceof View) == false) goto L30;
        View r17 = r16;
    L31:
        if (r17 == null) goto L41;
        if (r17.isAttachedToWindow() == false) goto L40;
        FLogger.a.d("TtsActionCreator", "update action when view reattach, state: " + r1 + ", action: " + r15 + '.');
        rs8.h r18 = this.x;
        if (r18 == null) goto L41;
        com.larus.bmhome.chat.layout.item.i r19 = this.d;
        if (r19 == null) goto L39;
        r12 = Boolean.valueOf(r19.getUseSubscribedColor());
    L39:
        r18.update(r15, r12);
        goto L41
    L40:
        r17.addOnAttachStateChangeListener(new n1(r17, r1, r15, this));
        goto L41
    L30:
        r17 = null;
    L24:
        r14 = false;
        goto L25
    L19:
        r13 = null;
        goto L20
    L15:
        r9 = null;
        goto L16
    L11:
        r5 = null;
    L41:
        P(r0);
        return;
    }

    @Override // com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.a2
    public final long b() {
        de8.c r0 = M();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.n;
    }

    @Override // com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.a2
    public final Context d() {
        return getContext();
    }

    @Override // com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.a2
    public final de8.c q() {
        return M();
    }

    @Override // com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.a2
    public final Fragment e() {
        return this.c;
    }

    @Override // com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.a2
    public final com.larus.bmhome.chat.api.q0 f() {
        return this.e;
    }

    @Override // com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.a2
    public final com.larus.bmhome.chat.layout.item.i p() {
        return this.d;
    }

    public AnswerActionComponent(int r2) {
        super(true, r2);
        this.l = LazyKt.lazy(new a1(this));
        this.n = LazyKt.lazy(new g1(this));
        this.q = LazyKt.lazy(new h1());
        this.s = LazyKt.lazy(new i1(this));
        this.t = LazyKt.lazy(new j1(this));
        this.u = zh8.a.c;
        this.v = LazyKt.lazy(new k1(this));
        this.w = LazyKt.lazy(new l1(this));
        this.y = LazyKt.lazy(new f0(this));
        this.C = LazyKt.lazy(new g0());
        this.E = LazyKt.lazy(new h0(this));
        this.F = LazyKt.lazy(new f1(this));
    }

    @Override // bd8.b
    public final boolean G(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        if (com.larus.bmhome.chat.bean.d.v(r2) == true) goto L10;
        de8.c r3 = M();
        if (r3 == null) goto L7;
        Integer r4 = r3.m();
    L8:
        if (r4 != null) goto L10;
        return true;
    L7:
        r4 = null;
    L10:
        return false;
    }

    public final boolean L(BotModel r3) {
        if (((Boolean) this.q.getValue()).booleanValue() == false) goto L13;
        List r4 = r3.getAnswerActionExposurePriority();
        if (r4 != null) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if ((!r4.isEmpty()) != true) goto L9;
        r5 = true;
        goto L10
    L13:
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.AnswerActionComponent$setupTtsObserver$observer$1, n68.a] */
    public final void P(final Message r3) {
        if (g(r3) == true) goto L5;
        return;
    L5:
        AnswerActionComponent$setupTtsObserver$observer$1 r0 = this.D;
        if (r0 == null) goto L8;
        AudioServiceDelegate.a.r0().k(r0);
    L8:
        ?? r1 = new AnswerActionComponent$setupTtsObserver$observer$1(this, r3);
        this.D = r1;
        AudioServiceDelegate.a.r0().m(r1);
    }

    @Override // com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.a2
    public final boolean g(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        if (((Boolean) this.C.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        BotModel r0 = dg8.t.d(N());
        if (r0 != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == true) goto L13;
        return false;
    L13:
        if (com.larus.bmhome.chat.bean.d.Q0(r4) == false) goto L17;
        if (com.larus.bmhome.chat.bean.d.d(r4) == true) goto L17;
        return false;
    L17:
        if (com.larus.bmhome.chat.bean.d.z0(r4) == false) goto L19;
        return false;
    L19:
        if (com.larus.bmhome.chat.bean.d.N(r4) == false) goto L21;
    L26:
        com.larus.bmhome.chat.component.regen.a r2 = (com.larus.bmhome.chat.component.regen.a) this.v.getValue();
        if (r2 != null) goto L29;
    L31:
        boolean r3 = false;
    L32:
        if (r3 == true) goto L34;
        return false;
    L34:
        if (com.larus.im.bean.message.a.i0(r4) == true) goto L42;
        return true;
    L42:
        return false;
    L29:
        if (r2.tL(r4) != true) goto L31;
        r3 = true;
        goto L32
    L21:
        if (com.larus.bmhome.chat.bean.d.k(r4) == true) goto L26;
        if (com.larus.bmhome.chat.bean.d.x0(r4) == true) goto L26;
        if (com.larus.bmhome.chat.bean.d.a0(r4) == true) goto L26;
        return false;
    L8:
        if (ve8.c.c(r0) != true) goto L10;
        r1 = true;
        goto L11
    }

    public static void K(List r4, Message r5) {
        Lazy<AnswerAction> r0 = K;
        if (r4.contains((AnswerAction) r0.getValue()) == false) goto L5;
        return;
    L5:
        boolean r2 = false;
        if (com.larus.bmhome.chat.bean.d.b0(r5) == false) goto L34;
        Map r6 = r5.getBusinessExt();
        if (r6 == null) goto L12;
        String r1 = (String) r6.get("real_selected_index");
        if (r1 == null) goto L12;
        Integer r3 = StringsKt.toIntOrNull(r1);
    L14:
        if (r3 != null) goto L31;
        if (r6 == null) goto L21;
        String r7 = (String) r6.get("sub_group_full_single_text");
        if (r7 == null) goto L21;
        if (Boolean.parseBoolean(r7) != true) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == false) goto L31;
        String r9 = (String) r6.get("all_sub_group_received");
        if (r9 != null) goto L26;
    L28:
        boolean r10 = false;
    L29:
        if (r10 == false) goto L31;
        boolean r11 = true;
    L32:
        if (r11 == false) goto L34;
        r2 = true;
        goto L34
    L26:
        if (Boolean.parseBoolean(r9) != true) goto L28;
        r10 = true;
    L21:
        r8 = false;
    L31:
        r11 = false;
    L12:
        r3 = null;
    L34:
        if (r2 == false) goto L37;
        r4.add((AnswerAction) r0.getValue());
        return;
    }

    public final void O(Object r4, Function0<Unit> r5) {
        com.larus.bmhome.chat.api.q0 r0 = this.e;
        Set r1 = null;
        if (r0 == null) goto L7;
        ChatMessageList r2 = r0.B7();
        if (r2 == null) goto L7;
        Object r3 = r2.getTag(2131384073);
    L9:
        if (TypeIntrinsics.isMutableSet(r3) == false) goto L11;
        r1 = (Set) r3;
    L11:
        if (r1 != null) goto L13;
    L15:
        boolean r6 = false;
    L16:
        if (r6 == false) goto L19;
        r5.invoke();
        r1.add(r4);
        return;
    L19:
        return;
    L13:
        if (r1.contains(r4) == true) goto L15;
        r6 = true;
    L7:
        r3 = null;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r2v37, types: [com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.e1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v12, types: [com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.j0] */
    /* JADX WARN: Type inference failed for: r7v39, types: [com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.i0] */
    @Override // com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.z1
    public final void o(final Message r32, BotModel r33) {
        Intrinsics.checkNotNullParameter(r32, "msg");
        Intrinsics.checkNotNullParameter(r33, "bot");
        BotModel r2 = dg8.t.d(N());
        if (r2 == null) goto L5;
        List r0 = r2.getStreamingAnswerActions();
    L6:
        com.larus.bmhome.chat.api.q0 r3 = this.e;
        if (r3 == null) goto L15;
        ChatMessageList r4 = r3.B7();
        if (r4 == null) goto L15;
        Fragment r5 = com.larus.utils.e1.k(r4);
        if (r5 == null) goto L15;
        t1a.b r6 = s1a.a.g(r5);
        if (r6 == null) goto L15;
        ss8.g r7 = (ss8.g) r6.getAbility(ss8.g.class);
    L17:
        if (r7 != null) goto L19;
    L21:
        boolean r8 = false;
    L23:
        if (r8 == false) goto L26;
        Pair r9 = TuplesKt.to(Boolean.TRUE, "UIBlock_HIDE_MESSAGE_BOTTOM_ACTIONS");
    L149:
        boolean r10 = ((Boolean) r9.component1()).booleanValue();
        String r11 = (String) r9.component2();
        if (r10 == false) goto L155;
        FLogger.a.d("ActionbarComponent", "setupActionBar hide actionbar, reason=" + r11 + ", msgId=" + r32.getMessageId());
        FrameLayout r1 = this.p;
        if (r1 == null) goto L545;
        com.larus.utils.e1.o(r1);
        return;
    L545:
        return;
    L155:
        FrameLayout r12 = this.p;
        if (r12 == null) goto L158;
        com.larus.utils.e1.x(r12);
    L158:
        boolean r13 = dg8.t.i(r0, r32);
        if (r13 == true) goto L187;
        if (r2 == null) goto L162;
        List r14 = r2.getAnswerActions();
    L163:
        if (r14 == null) goto L184;
        List r15 = r14;
        if ((r15 instanceof Collection) == true) goto L167;
    L169:
        Iterator r16 = r15.iterator();
    L171:
        if (r16.hasNext() == false) goto L181;
        AnswerAction r17 = (AnswerAction) r16.next();
        if (Intrinsics.areEqual(r17.getKey(), "like") == false) goto L175;
    L178:
        boolean r18 = true;
    L179:
        if (r18 == false) goto L171;
        boolean r19 = true;
    L182:
        if (r19 != true) goto L184;
        boolean r20 = true;
    L185:
        if (r20 == false) goto L187;
        boolean r21 = true;
    L188:
        Context r22 = getContext();
        if (r22 == null) goto L218;
        boolean r110 = L(r33);
        FLogger.a.i("ActionbarComponent", "tryCreateActionBar usePriorityActionBar=" + r110 + ", useAdaptiveActionBar=" + r21);
        if (r110 == true) goto L194;
        if (r21 == true) goto L198;
        rs8.h r111 = this.x;
        if ((r111 instanceof NonPriorityMessageActionBar) == true) goto L203;
    L206:
        boolean r112 = true;
    L207:
        if (r112 == false) goto L218;
        FrameLayout.LayoutParams r113 = new FrameLayout.LayoutParams(-1, -2);
        if (r110 == false) goto L212;
        PriorityMessageActionBar r23 = new PriorityMessageActionBar(r22, null, 6, 0);
        r23.setPadding(c7.b(7), c7.b(11), c7.b(7), c7.b(11));
    L215:
        this.x = r23;
        FrameLayout r24 = this.p;
        if (r24 == null) goto L218;
        r24.removeAllViews();
        r24.addView(r23, r113);
        goto L218
    L212:
        if (r21 == false) goto L214;
        r23 = new AdaptiveMessageActionBar(r22, null, 6, 0);
        goto L215
    L214:
        r23 = new NonPriorityMessageActionBar(r22, null, 6, 0);
        goto L215
    L203:
        if ((r111 instanceof AdaptiveMessageActionBar) == true) goto L206;
    L205:
        r112 = false;
        goto L207
    L198:
        if ((this.x instanceof AdaptiveMessageActionBar) == true) goto L205;
    L194:
        if ((this.x instanceof PriorityMessageActionBar) == true) goto L205;
    L218:
        com.larus.bmhome.chat.component.regen.a r25 = (com.larus.bmhome.chat.component.regen.a) this.v.getValue();
        if (r25 == null) goto L223;
        int r26 = 1;
        if (r25.tL(r32) != true) goto L224;
        boolean r27 = true;
    L225:
        boolean r114 = !r13;
        boolean r115 = !dg8.t.g(this.e, r32, r0);
        if (dg8.t.f(this.e, r32) == true) goto L513;
    L245:
        boolean r28 = true;
    L246:
        if (r114 == false) goto L250;
        if (r115 == false) goto L250;
        if (r28 == false) goto L250;
        boolean r29 = true;
    L251:
        ?? r30 = new i0(this);
        if (r29 == true) goto L254;
    L290:
        rs8.h r116 = this.x;
        if (r116 != null) goto L293;
        return;
    L293:
        com.larus.bmhome.chat.layout.item.i r117 = this.d;
        if (r117 != null) goto L296;
        return;
    L296:
        com.larus.bmhome.chat.api.q0 r31 = this.e;
        Context r118 = r117.getContext();
        ?? r34 = new j0(this);
        com.larus.bmhome.chat.api.q0 r35 = this.e;
        if (r35 == null) goto L299;
        com.larus.bmhome.chat.api.q0.a r210 = r35.getProvider();
    L300:
        z r119 = new z(r31, r117, r118, r34, r210);
        this.m = false;
        if (r13 == false) goto L328;
        final ArrayList r36 = new ArrayList();
        final ?? r37 = new e1(this);
        Intrinsics.checkNotNullParameter(r37, "onClickMob");
        r36.add(new rs8.j(null, 2131380357, "", ContextCompat.getDrawable(r119.c, 2131242263), null, 0.0f, MessageActionBarAlign.END, false, false, 2131242263, null, null, new i(r37), 3504));
        va8.y r38 = (va8.y) this.n.getValue();
        if (r38 != null) goto L305;
    L307:
        boolean r39 = false;
    L308:
        if (r39 == true) goto L322;
        this.A = System.currentTimeMillis();
        va8.y r40 = (va8.y) this.n.getValue();
        if (r40 == null) goto L313;
        r40.L00(r32.getMessageId());
    L313:
        String r120 = r32.getMessageId();
        String r211 = r32.getSectionId();
        String r212 = r32.getSenderId();
        String r213 = r32.getConversationId();
        LruCache r41 = ko8.a.a;
        String r42 = r32.getConversationId();
        if (r42 != null) goto L316;
        r42 = "";
    L316:
        wc9.e r43 = (wc9.e) r41.get(r42);
        if (r43 == null) goto L319;
        String r214 = ic8.n.f(r43);
    L320:
        n3.a("stop", "chat", "receive_message", r120, r211, r212, r213, r214, ve8.c.b(false), 1536);
        goto L322
    L319:
        r214 = null;
    L322:
        if (this.B == false) goto L326;
        FrameLayout r44 = this.p;
        if (r44 == null) goto L327;
        r44.setVisibility(0);
    L327:
        com.larus.bmhome.chat.layout.item.i r121 = r117;
    L482:
        FrameLayout r45 = this.p;
        if (r45 == null) goto L485;
        r45.setVisibility(0);
    L485:
        List r46 = r33.getAnswerActionExposurePriority();
        if (r46 != null) goto L488;
        r46 = CollectionsKt.emptyList();
    L488:
        r116.setUpPriorityList(r46);
        boolean r47 = this.m;
        com.larus.bmhome.chat.layout.item.i r48 = this.d;
        if (r48 == null) goto L491;
        Boolean r122 = Boolean.valueOf(r48.getUseSubscribedColor());
    L492:
        r116.q5(r47, r36, r122, this.c);
        Integer r49 = r116.y3();
        if (r49 == null) goto L495;
        r121.setMinimumWidth(Math.max(r121.getMinimumWidth(), RangesKt.coerceAtMost(r49.intValue(), r121.getMaxWidth())));
    L495:
        Function0 r50 = new k0(this, r32, r36);
        Job r51 = this.r;
        if (r51 == null) goto L498;
        Continuation r52 = null;
        Job.DefaultImpls.cancel$default(r51, null, 1, null);
    L499:
        Fragment r53 = this.c;
        if (r53 == null) goto L504;
        LifecycleCoroutineScope r54 = LifecycleOwnerKt.getLifecycleScope(r53);
        if (r54 == null) goto L504;
        Continuation r123 = BuildersKt.launch$default(r54, null, null, new AnswerActionComponent$debounceReport$1(r50, r52), 3, null);
    L505:
        this.r = r123;
        return;
    L504:
        r123 = r52;
        goto L505
    L498:
        r52 = null;
        goto L499
    L491:
        r122 = null;
        goto L492
    L326:
        this.B = true;
        goto L327
    L305:
        if (r38.Du(r32.getMessageId()) != true) goto L307;
        r39 = true;
        goto L308
    L328:
        ArrayList r124 = new ArrayList();
        this.B = false;
        if (r2 == null) goto L336;
        List r55 = r2.getAnswerActions();
        if (r55 == null) goto L336;
        List r56 = CollectionsKt.sortedWith(r55, new m1());
        if (r56 == null) goto L336;
        List r57 = CollectionsKt.toMutableList(r56);
        if (r57 == null) goto L336;
    L337:
        List r58 = r57;
        de8.c r59 = M();
        if (r59 == null) goto L340;
        Bundle r60 = r59.b;
    L341:
        if (r60 != null) goto L343;
    L345:
        final boolean r61 = false;
    L346:
        Regex r62 = com.larus.bmhome.chat.bean.d.a;
        Intrinsics.checkNotNullParameter(r32, "<this>");
        Map r63 = r32.getExt();
        if (r63 == null) goto L377;
        String r64 = (String) r63.get("message_actions");
        if (r64 == null) goto L377;
        zd9.h r65 = zd9.h.a;     // Catch: Exception -> L374
        if (StringsKt.isBlank(r64) == false) goto L509;
        r121 = r117;
    L366:
        Object r66 = null;
    L367:
        ic8.d0 r67 = (ic8.d0) r66;     // Catch: Exception -> L372
        if (r67 == null) goto L378;
        Intrinsics.checkNotNullParameter(r67, "<this>");
        if (r67.a() == null) goto L378;
        boolean r68 = true;
    L379:
        if (r68 == false) goto L381;
        CollectionsKt.removeAll(r58, new y0());
        r58.add(new AnswerAction(null, "deep_search", null, null, -1, null, null, 109, null));
    L381:
        Intrinsics.checkNotNullParameter(r32, "<this>");
        TaskCardBlock r69 = com.larus.im.bean.message.a.N(r32);
        if (r69 == null) goto L389;
        Integer r70 = r69.style;
        int r71 = TaskCardStyle.TITLE.getValue();
        if (r70 == null) goto L389;
        if (r70.intValue() != r71) goto L389;
        boolean r72 = true;
    L390:
        if (r72 == false) goto L393;
        CollectionsKt.removeAll(r58, new t0());
    L396:
        if (com.larus.bmhome.chat.bean.d.b0(r32) == false) goto L411;
        Intrinsics.checkNotNullParameter(r32, "<this>");
        if (com.larus.bmhome.chat.bean.d.x(r32).isCrowdTest() == true) goto L401;
    L403:
        boolean r73 = false;
    L404:
        if (r73 == false) goto L407;
        K(r58, r32);
    L409:
        CollectionsKt.removeAll(r58, new b1());
        goto L411
    L407:
        if (com.larus.bmhome.chat.bean.d.y0(r32) == false) goto L409;
        CollectionsKt.removeAll(r58, new z0());
        K(r58, r32);
        goto L409
    L401:
        if (r32.isNewBlockType() == false) goto L403;
        r73 = true;
    L411:
        if (com.larus.im.bean.message.a.i0(r32) == false) goto L413;
        CollectionsKt.removeAll(r58, new v0());
    L413:
        RegenStatus.a r74 = RegenStatus.Companion;
        int r75 = r32.getRegenStatus();
        r74.getClass();
        if (ArraysKt.contains(new Integer[]{1, 2}, Integer.valueOf(r75)) == false) goto L416;
    L419:
        boolean r76 = true;
    L420:
        if (r76 == false) goto L423;
        CollectionsKt.removeAll(r58, new x0());
    L423:
        IFlowSdkDepend r77 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r77 == null) goto L428;
        r77.getCollectService();
        if (com.larus.home.impl.sdk.j1.a.e() != true) goto L428;
        final boolean r78 = true;
    L429:
        CollectionsKt.removeAll(r58, new w0(r32, r78, r61));
        Iterator r79 = r58.iterator();
    L431:
        if (r79.hasNext() == false) goto L451;
        AnswerAction r80 = (AnswerAction) r79.next();
        String r125 = r80.getKey();
        w1 r81 = (w1) this.y.getValue();
        rs8.h r82 = this.x;
        va8.p r83 = (va8.p) this.w.getValue();
        List r84 = r81.b(r119, r80, r124, r32, r33, r82);
        List r85 = r84;
        r124.addAll(r85);
        if (Intrinsics.areEqual(r125, "regenerate") == false) goto L431;
        if (L(r33) == false) goto L431;
        if ((!r85.isEmpty()) == false) goto L431;
        List r86 = r84;
        ArrayList r87 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r86, 10));
        Iterator r88 = r86.iterator();
    L440:
        if (r88.hasNext() == false) goto L443;
        r87.add(((rs8.g) r88.next()).a());
        goto L440
    L443:
        if (r87.contains("regenerate") == true) goto L431;
        w1 r89 = (w1) this.y.getValue();
        r89.getClass();
        Intrinsics.checkNotNullParameter(r119, "creator");
        Intrinsics.checkNotNullParameter(r32, "message");
        final com.larus.bmhome.chat.component.regen.a r90 = r89.a.n();
        if (r90 != null) goto L447;
        rs8.j r91 = null;
    L448:
        if (r91 == null) goto L450;
        r124.add(r91);
    L450:
        this.m = true;
        goto L431
    L447:
        r91 = r119.e(r32, MessageActionBarAlign.END, new AnswerActionGenerator$generateReplaceRegenAnswerAction$1(r89.a), new p1(r90, r32));
        goto L448
    L451:
        com.larus.bmhome.chat.layout.item.i r92 = this.d;
        if (r92 == null) goto L481;
        Resources r93 = r92.getContext().getResources();
        if (r124.isEmpty() == true) goto L461;
        ListIterator r94 = r124.listIterator(r124.size());
        int r95 = 0;
    L457:
        if (r94.hasPrevious() == false) goto L462;
        if (((rs8.g) r94.previous()).b() != MessageActionBarAlign.START) goto L457;
        r95 = r95 + 1;
    L462:
        if (r95 <= 3) goto L464;
        Context r96 = r92.getContext();
        int r97 = 2131167165;
        int r99 = 2130971398;
    L465:
        int r100 = r93.getDimensionPixelSize(v19.c.b(r99, r96, r97));
        Iterator r101 = r124.iterator();
    L467:
        if (r101.hasNext() == false) goto L471;
        Object r126 = r101.next();
        if ((((rs8.g) r126) instanceof rs8.o) == false) goto L467;
    L473:
        if (((rs8.g) r126) == null) goto L475;
        boolean r102 = true;
    L476:
        if (r102 == false) goto L480;
        com.larus.bmhome.chat.layout.item.i r103 = this.d;
        if (r103 == null) goto L480;
        r100 = r103.getMaxWidth();
    L480:
        r92.setMinimumWidth(r100);
        goto L481
    L475:
        r102 = false;
        goto L476
    L471:
        r126 = null;
        goto L473
    L464:
        r96 = r92.getContext();
        r97 = 2131167007;
        r99 = 2130971319;
        goto L465
    L461:
        r95 = 0;
    L481:
        r36 = r124;
    L428:
        r78 = false;
        goto L429
    L416:
        if (ArraysKt.contains(new Integer[]{2, 3}, Integer.valueOf(r32.getRegenStatus())) == true) goto L419;
        r76 = false;
        goto L420
    L393:
        if (com.larus.im.bean.message.a.B0(r32) == false) goto L396;
        CollectionsKt.removeAll(r58, new u0());
    L389:
        r72 = false;
    L378:
        r68 = false;
    L372:
        e = e;
    L376:
        FLogger.a.e("deep_search", r64, e);
        goto L378
    L509:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L356
        r65.getClass();     // Catch: Throwable -> L356
        r66 = Result.constructor-impl(zd9.h.b.fromJson(r64, new ic8.h0().getType()));     // Catch: Throwable -> L356
    L358:
        Throwable r105 = Result.exceptionOrNull-impl(r66);     // Catch: Exception -> L374
        if (r105 == null) goto L363;
        com.larus.im.internal.delegate.c0 r127 = com.larus.im.internal.delegate.c0.b;     // Catch: Exception -> L374
        r121 = r117;
        StringBuilder r128 = new StringBuilder("fromJson failed, stack: ");     // Catch: Exception -> L372
        Intrinsics.checkNotNullParameter(r105, "<this>");     // Catch: Exception -> L372
        r128.append(ExceptionsKt.stackTraceToString(r105));     // Catch: Exception -> L372
        r127.e("GsonHolder", r128.toString());     // Catch: Exception -> L372
    L365:
        if (Result.isFailure-impl(r66) == false) goto L367;
    L363:
        r121 = r117;
        goto L365
    L356:
        th = move-exception;
        Result.Companion r106 = Result.Companion;     // Catch: Exception -> L374
        r66 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L374
    L374:
        e = e;
        r121 = r117;
    L377:
        r121 = r117;
        goto L378
    L343:
        if (r60.getBoolean("human_merge_forward_float_chat") != true) goto L345;
        r61 = true;
        goto L346
    L340:
        r60 = null;
    L336:
        r57 = (List) L.getValue();
        goto L337
    L299:
        r210 = null;
        goto L300
    L254:
        if (com.larus.bmhome.chat.bean.d.P0(r32) == false) goto L258;
        r30.invoke();
        FLogger.a.d("ActionbarComponent", "setupActionBar hide actionbar, reason=template, msgId=" + r32.getMessageId());
        return;
    L258:
        if (com.larus.bmhome.chat.bean.d.r0(r32) == false) goto L261;
        r30.invoke();
        FLogger.a.d("ActionbarComponent", "setupActionBar hide actionbar, reason=islocalMessageId, msgId=" + r32.getMessageId());
        return;
    L261:
        com.larus.bmhome.chat.component.cvs.y r107 = N();
        if (r107 != null) goto L264;
    L266:
        boolean r108 = false;
    L267:
        if (r108 == false) goto L270;
        r30.invoke();
        FLogger.a.d("ActionbarComponent", "setupActionBar hide actionbar, reason=isOnlyReadModel, msgId=" + r32.getMessageId());
        return;
    L270:
        if (r27 == true) goto L274;
        r30.invoke();
        FLogger.a.d("ActionbarComponent", "setupActionBar hide actionbar, reason=noAction, msgId=" + r32.getMessageId());
        return;
    L274:
        if (com.larus.bmhome.chat.bean.d.Q0(r32) == false) goto L280;
        if (com.larus.bmhome.chat.bean.d.d(r32) == true) goto L280;
        r30.invoke();
        FLogger.a.d("ActionbarComponent", "setupActionBar hide actionbar, reason=isTyping, msgId=" + r32.getMessageId());
        return;
    L280:
        if (r32.getMessageStatusLocal() != 21) goto L282;
    L286:
        boolean r109 = false;
    L287:
        if (r109 == false) goto L290;
        r30.invoke();
        FLogger.a.d("ActionbarComponent", "setupActionBar hide actionbar, reason=isMsgStatusNotReceived, msgId=" + r32.getMessageId());
        return;
    L282:
        if (r32.getMessageStatusLocal() == 23) goto L286;
        if (com.larus.bmhome.chat.bean.d.d(r32) == true) goto L286;
        r109 = true;
        goto L287
    L264:
        if (dg8.t.h(r107) != true) goto L266;
        r108 = true;
    L250:
        r29 = false;
        goto L251
    L513:
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L237
        int r130 = r32.getContentType();     // Catch: Throwable -> L237
        if (r130 != r26) goto L230;
    L232:
        String r131 = com.larus.bmhome.chat.bean.d.r(r32);     // Catch: Throwable -> L237
        if (r131 == null) goto L236;
        if (r131.length() == 0) goto L236;
    L241:
        boolean r132 = false;
    L242:
        if (r132 == true) goto L245;
        r28 = false;
    L236:
        r132 = true;
        goto L242
    L230:
        if (r130 == 9999) goto L232;
    L237:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        Throwable r134 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r134 == null) goto L241;
        FLogger.a.i("ActionbarComponent", r134.toString());
    L224:
        r27 = false;
        goto L225
    L223:
        r26 = 1;
        goto L224
    L175:
        if (Intrinsics.areEqual(r17.getKey(), "dislike") == true) goto L178;
        r18 = false;
    L181:
        r19 = false;
        goto L182
    L167:
        if (r15.isEmpty() == false) goto L169;
    L184:
        r20 = false;
        goto L185
    L162:
        r14 = null;
    L187:
        r21 = false;
        goto L188
    L26:
        if (dg8.t.a(r32) == false) goto L29;
        r9 = TuplesKt.to(Boolean.TRUE, "cannotLongClickAndShowAnswerBar");
        goto L149
    L29:
        if (((Set) M.getValue()).contains(Integer.valueOf(r32.getContentType())) == false) goto L32;
        r9 = TuplesKt.to(Boolean.TRUE, "contentTypeInDisableSet(contentType=" + r32.getContentType() + ')');
        goto L149
    L32:
        if (com.larus.bmhome.chat.bean.d.d(r32) == true) goto L36;
        if (com.larus.bmhome.chat.bean.d.Q0(r32) == false) goto L36;
    L37:
        r9 = TuplesKt.to(Boolean.TRUE, "isTyping(isTyping=" + com.larus.bmhome.chat.bean.d.Q0(r32) + ", isDeepThinkingTyping=" + com.larus.bmhome.chat.bean.d.f0(r32) + ')');
    L36:
        if (com.larus.bmhome.chat.bean.d.f0(r32) == true) goto L37;
        IFlowMessageService r135 = (IFlowMessageService) ServiceManager.get().getService(IFlowMessageService.class);
        if (r135 != null) goto L41;
    L43:
        boolean r136 = false;
    L44:
        if (r136 == false) goto L47;
        r9 = TuplesKt.to(Boolean.TRUE, "isMessageReAnswerInModify");
        goto L149
    L47:
        if (com.larus.bmhome.chat.bean.d.x0(r32) == false) goto L74;
        com.larus.bmhome.chat.helper.n0 r137 = com.larus.bmhome.chat.helper.n0.a;
        String r138 = r32.getMessageId();
        r137.getClass();
        int r139 = w2.a(r138);
        List r140 = r32.getSubList();
        if (r140 == null) goto L51;
        Message r141 = (Message) CollectionsKt.getOrNull(r140, r139);
    L52:
        if (r141 != null) goto L54;
    L59:
        boolean r142 = true;
    L60:
        if (r142 == false) goto L74;
        Boolean r143 = Boolean.TRUE;
        StringBuilder r144 = new StringBuilder("multiContentSubMessageNotReady(subMessageNull=");
        if (r141 != null) goto L64;
        boolean r145 = true;
    L65:
        r144.append(r145);
        r144.append(", status=");
        if (r141 == null) goto L68;
        Integer r146 = Integer.valueOf(r141.getMessageStatusLocal());
    L69:
        r144.append(r146);
        r144.append(", subTyping=");
        if (r141 == null) goto L72;
        Boolean r147 = Boolean.valueOf(com.larus.bmhome.chat.bean.d.Q0(r141));
    L73:
        r144.append(r147);
        r144.append(')');
        r9 = TuplesKt.to(r143, r144.toString());
        goto L149
    L72:
        r147 = null;
        goto L73
    L68:
        r146 = null;
        goto L69
    L64:
        r145 = false;
        goto L65
    L54:
        if (r141.getMessageStatusLocal() != 21) goto L59;
        if (com.larus.bmhome.chat.bean.d.Q0(r141) == true) goto L59;
        r142 = false;
        goto L60
    L51:
        r141 = null;
    L74:
        Intrinsics.checkNotNullParameter(r32, "<this>");
        if (Intrinsics.areEqual(tz9.a.a(r32), "two_piece") == false) goto L78;
        r9 = TuplesKt.to(Boolean.TRUE, "isTwoPieceMessage");
        goto L149
    L78:
        if (com.larus.im.bean.message.a.g0(r32) == false) goto L80;
        r9 = TuplesKt.to(Boolean.TRUE, "isDocType");
        goto L149
    L80:
        Intrinsics.checkNotNullParameter(r32, "<this>");
        if (com.larus.im.bean.message.a.b0(r32) == false) goto L99;
        Intrinsics.checkNotNullParameter(r32, "<this>");
        List r148 = vd9.r.a(r32);
        if ((r148 instanceof Collection) == true) goto L85;
    L87:
        Iterator r149 = r148.iterator();
    L89:
        if (r149.hasNext() == false) goto L96;
        if (((Block) r149.next()).getBlockType() != BlockType.BLOCK_TYPE_AUDIO_RECORD.getValue()) goto L93;
        boolean r150 = true;
    L94:
        if (r150 == false) goto L89;
        boolean r151 = true;
    L97:
        if (r151 == false) goto L99;
        boolean r152 = true;
    L100:
        if (r152 == false) goto L103;
        r9 = TuplesKt.to(Boolean.TRUE, "isAudioRecordType");
        goto L149
    L103:
        if (com.larus.im.bean.message.a.W(r32) == false) goto L106;
        r9 = TuplesKt.to(Boolean.TRUE, "isAudioRecordDocType");
        goto L149
    L106:
        if (com.larus.im.bean.message.a.X(r32) == false) goto L109;
        r9 = TuplesKt.to(Boolean.TRUE, "isAuthIdentityTouristLogin");
        goto L149
    L109:
        if (com.larus.im.bean.message.a.d0(r32) == false) goto L112;
        r9 = TuplesKt.to(Boolean.TRUE, "isCommerceCreditInsufficient");
        goto L149
    L112:
        if (com.larus.bmhome.chat.bean.d.v(r32) == false) goto L115;
        r9 = TuplesKt.to(Boolean.TRUE, "disableActionView");
        goto L149
    L115:
        if (com.larus.bmhome.chat.bean.d.V(r32) == false) goto L117;
        r9 = TuplesKt.to(Boolean.TRUE, "isAwemeVideoLocalPrompt");
        goto L149
    L117:
        hc8.c r153 = hc8.c.a;
        if (r153.j(r32) == true) goto L144;
        Map r154 = r32.getExt();
        if (r154 == null) goto L122;
        String r155 = (String) r154.get("need_auth_identity");
    L124:
        if (Intrinsics.areEqual(r155, "1") == true) goto L144;
        de8.c r156 = M();
        if (r156 == null) goto L129;
        Integer r157 = r156.m();
    L130:
        if (r157 == null) goto L133;
        r9 = TuplesKt.to(Boolean.TRUE, "immerseBackColorNotNull");
        goto L149
    L133:
        if (z2.a.canShowAnswerActionBar() == true) goto L138;
        if (dg8.t.b(r0) == true) goto L138;
        r9 = TuplesKt.to(Boolean.TRUE, "settingsForbiddenAndNotUserBreak");
    L138:
        if (com.larus.bmhome.chat.bean.d.a1(r32) == false) goto L141;
        r9 = TuplesKt.to(Boolean.TRUE, "onlyHaveLoadingBlock");
        goto L149
    L141:
        if (com.larus.im.bean.message.a.k0(r32) == false) goto L143;
        r9 = TuplesKt.to(Boolean.TRUE, "isMusicBlock");
        goto L149
    L143:
        r9 = TuplesKt.to(Boolean.FALSE, null);
        goto L149
    L129:
        r157 = null;
        goto L130
    L122:
        r155 = null;
    L144:
        Boolean r158 = Boolean.TRUE;
        StringBuilder r159 = new StringBuilder("needPluginOrRealNameAuth(showPluginAuth=");
        r159.append(r153.j(r32));
        r159.append(", needRealName=");
        Map r160 = r32.getExt();
        if (r160 == null) goto L147;
        String r161 = (String) r160.get("need_auth_identity");
    L148:
        r159.append(Intrinsics.areEqual(r161, "1"));
        r159.append(')');
        r9 = TuplesKt.to(r158, r159.toString());
        goto L149
    L147:
        r161 = null;
        goto L148
    L93:
        r150 = false;
    L96:
        r151 = false;
        goto L97
    L85:
        if (r148.isEmpty() == false) goto L87;
    L99:
        r152 = false;
        goto L100
    L41:
        if (r135.f(r32.getLocalMessageId()) != true) goto L43;
        r136 = true;
        goto L44
    L19:
        if (r7.bc(ChatUIBlockConfig.HIDE_MESSAGE_BOTTOM_ACTIONS) != true) goto L21;
        r8 = true;
    L15:
        r7 = null;
        goto L17
    L5:
        r0 = null;
        goto L6
    }

    @Override // bd8.b
    public final void w(Message r72, int r73, ec8.b r74) {
        Intrinsics.checkNotNullParameter(r72, "message");
        Intrinsics.checkNotNullParameter(r72, "message");
        if (r72.getContentType() != 71) goto L5;
        Message r1 = Message.copy$default(r72, null, null, null, 0, 0, null, r72.getContentType(), false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -65, 31, null);
    L6:
        this.o = r1;
        this.z = r74;
        com.larus.bmhome.chat.component.cvs.y r2 = N();
        if (r2 == null) goto L12;
        BotModel r3 = r2.j0();
        if (r3 == null) goto L12;
    L16:
        o(r72, r3);
        P(r72);
        if (r74 == null) goto L20;
        r74.b(this, z1.class);
        return;
    L20:
        return;
    L12:
        String r4 = r72.getSenderId();
        if (r4 != null) goto L15;
        r4 = "unknown";
    L15:
        r3 = new BotModel(r4, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
        goto L16
    L5:
        r1 = r72;
        goto L6
    }

    public static final rs8.g J(AnswerActionComponent r10, final Message r11, PlayStateEnum r12, MessageActionBarAlign r13, BotModel r14) {
        Context r1 = r10.getContext();
        Bundle r0 = null;
        if (r1 == null) goto L22;
        com.larus.bmhome.chat.api.q0 r2 = r10.e;
        if (r2 == null) goto L7;
        com.larus.bmhome.chat.api.q0.a r3 = r2.getProvider();
    L8:
        AnswerActionComponent$buildTtsAction$1$creator$1 r5 = new AnswerActionComponent$buildTtsAction$1$creator$1(r10);
        Fragment r4 = r10.c;
        if (r4 == null) goto L11;
        t1a.b r7 = s1a.a.g(r4);
    L12:
        Fragment r8 = r10.c;
        de8.c r15 = r10.M();
        if (r15 == null) goto L15;
        r0 = r15.b;
    L15:
        if (r0 != null) goto L17;
    L19:
        boolean r9 = false;
    L21:
        return new d2(r1, r2, r3, r13, r5, r14, r7, r8, r9).b(r12, new p0(r11));
    L17:
        if (r0.getBoolean("human_merge_forward_float_chat") != true) goto L19;
        r9 = true;
        goto L21
    L11:
        r7 = null;
        goto L12
    L7:
        r3 = null;
        goto L8
    L22:
        return null;
    }

    @Override // bd8.b
    public final List<View> x(int r2, Context r3, BaseMessageListCell<?> r4, com.larus.bmhome.chat.layout.item.i r5, com.larus.bmhome.chat.api.q0 r6, Fragment r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.x(r2, r3, r4, r5, r6, r7);
        FrameLayout r8 = new FrameLayout(r3);
        this.p = r8;
        if (r5 == null) goto L6;
        r5.addView(r8, r2, new LinearLayout.LayoutParams(-1, -2));
    L6:
        return CollectionsKt.listOf(r8);
    }
}
