package com.larus.bmhome.chat.list.base;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.adapter.MessageModifyMode;
import com.larus.bmhome.chat.cache.MessageHeightCache;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell;
import com.larus.bmhome.chat.cell.view.AbstractMessageBoxContainerView;
import com.larus.bmhome.chat.cell.view.CustomStubView;
import com.larus.bmhome.chat.cell.view.MessageNoBoxContainerView;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.chat.component.trace.z;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.bmhome.chat.trace.ChatRenderTrace;
import com.larus.bmhome.chat.trace.appreciable.g;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.bmhome.utils.FirstFeedSceneEnum;
import com.larus.bmhome.utils.f2;
import com.larus.bmhome.utils.p2;
import com.larus.bmhome.utils.q2;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.bmhome.view.textview.impl.SelectorRestore;
import com.larus.common_ui.widget.concat_adapter.ConcatAdapter;
import com.larus.im.bean.message.Message;
import com.larus.list.arch.FlowListViewHolder;
import com.larus.platform.exp.h;
import com.larus.platform.model.chat.m0;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import ei9.f;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletableDeferred;
import lf8.c;
import org.json.JSONObject;
import wr8.d;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0016J\u001d\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020 H\u0016¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u001bH\u0016J\u0015\u0010#\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\u00050\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/larus/bmhome/chat/list/base/MessageCellHolder;", "STATE", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "Lcom/larus/list/arch/FlowListViewHolder;", "containerView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "targetCell", "Lcom/larus/bmhome/chat/cell/BaseMessageListCell;", "allSlotCells", "", "Lcom/larus/bmhome/chat/cell/slot/BaseMessageSlotCell;", "getAllSlotCells$impl_mainlandRelease", "()Ljava/util/Map;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "chatTraceComponent", "Lcom/larus/bmhome/chat/component/trace/IChatTraceComponentAbility;", "getChatTraceComponent", "()Lcom/larus/bmhome/chat/component/trace/IChatTraceComponentAbility;", "chatTraceComponent$delegate", "onCreated", "", "cellView", "bind", "state", "position", "", "(Lcom/larus/bmhome/chat/cell/BaseMessageCellState;I)V", "onViewRecycled", "bindFeedShowEvent", "(Lcom/larus/bmhome/chat/cell/BaseMessageCellState;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MessageCellHolder<STATE extends b> extends FlowListViewHolder<STATE> {
    public static final /* synthetic */ int i = 0;
    public final View d;
    public BaseMessageListCell<? extends b> e;
    public final Map<BaseMessageSlotCell<?>, View> f;
    public final Lazy g;
    public final Lazy h;

    public final void onViewRecycled() {
        super.onViewRecycled();
    }

    public MessageCellHolder(ConstraintLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "containerView");
        super(r2);
        this.d = r2;
        this.f = new LinkedHashMap();
        this.g = LazyKt.lazy(new lf8.b(this));
        this.h = LazyKt.lazy(new c(this));
    }

    public final void U3(View r6) {
        ((FlowListViewHolder) this).c = r6;
        BaseMessageListCell<? extends b> r0 = ((FlowListViewHolder) this).b;
        i r2 = null;
        if ((r0 instanceof BaseMessageListCell) == false) goto L5;
        BaseMessageListCell<? extends b> r1 = r0;
    L6:
        this.e = r1;
        if ((r6 instanceof i) == false) goto L10;
        r2 = (i) r6;
    L10:
        if (r2 == null) goto L12;
        int r3 = r2.getBoxType();
    L13:
        BaseMessageListCell<? extends b> r4 = this.e;
        if (r4 == null) goto L34;
        List r5 = r4.f(r3);
        if (r5 != null) goto L18;
        return;
    L18:
        if ((!r5.isEmpty()) == false) goto L41;
        Iterator r7 = r5.iterator();
    L21:
        if (r7.hasNext() == false) goto L42;
        BaseMessageSlotCell<?> r8 = (BaseMessageSlotCell) r7.next();
        r8.b = ((FlowListViewHolder) this).a;
        BaseMessageListCell<? extends b> r9 = this.e;
        if (r9 == null) goto L25;
        ComponentFeature r10 = r9.e();
        Intrinsics.checkNotNullParameter(r10, "value");
        ((BaseCellComponentFeature) r8).a = r10;
    L25:
        r8.c = ((RecyclerView.ViewHolder) this).itemView;
        CustomStubView r11 = this.d.findViewById(r8.f());
        if (r11 == null) goto L21;
        View r12 = r8.onCreateView(this.d.getContext(), -1);
        this.f.put(r8, r12);
        if ((r11 instanceof CustomStubView) == false) goto L31;
        CustomStubView.a(r11, r12);
    L33:
        r8.h(r12);
        goto L21
    L31:
        if ((r11 instanceof ViewGroup) == false) goto L33;
        ((ViewGroup) r11).addView(r12);
        goto L33
    L42:
        return;
    L41:
        return;
    L34:
        return;
    L12:
        r3 = -1;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final void T3(f r11, int r12) {
        b r13 = (b) r11;
        Intrinsics.checkNotNullParameter(r13, "state");
        super.T3(r13, r12);
        Message r0 = r13.getMessage();
        ((RecyclerView.ViewHolder) this).itemView.setTag(2131365552, r0.getMessageId());
        if (f2.a != FirstFeedSceneEnum.CHAT_DETAIL) goto L5;
        f2.a(((RecyclerView.ViewHolder) this).itemView, "MessageCellHolder");
    L9:
        if (com.larus.bmhome.utils.i.e(r13.getMessage().getConversationId(), null) == false) goto L14;
        boolean r1 = q2.a;
        View r2 = ((RecyclerView.ViewHolder) this).itemView;
        Intrinsics.checkNotNullParameter(r2, "view");
        if (q2.b == true) goto L14;
        FLogger.a.i("MainBotPageShowMobHelper", "bindFirstMainBotShowView - first");
        r2.getViewTreeObserver().addOnPreDrawListener(new p2(r2));
    L14:
        z r3 = (z) this.h.getValue();
        if (r3 == null) goto L17;
        r3.rp(((RecyclerView.ViewHolder) this).itemView);
    L17:
        CompletableDeferred r4 = d.a;
        d.b.c("bind holder");
        com.larus.bmhome.chat.trace.appreciable.f.a.getClass();
        Intrinsics.checkNotNullParameter(r0, "msg");
        boolean r5 = false;
        if (com.larus.bmhome.chat.bean.d.H0(r0) == false) goto L38;
        Map r6 = com.larus.bmhome.chat.trace.appreciable.f.h;
        if (r6.containsKey(r0.getLocalMessageId()) == false) goto L38;
        g r7 = (g) ((LinkedHashMap) r6).get(r0.getLocalMessageId());
        o r8 = o.a;
        JSONObject r9 = new JSONObject();
        r9.put("msg_local_status", r0.getMessageStatusLocal());
        r9.put("msg_server_status", r0.getMessageStatus());
        if (r7 == null) goto L24;
        String r10 = r7.a;
    L25:
        r9.put("task_id", r10);
        r9.put("local_msg_id", r0.getLocalMessageId());
        if (r7 == null) goto L28;
        String r14 = r7.b;
    L29:
        r9.put("audio_path", r14);
        if (r7 == null) goto L32;
        Long r15 = Long.valueOf(r7.c);
    L33:
        r9.put("audio_duration", r15);
        if (r7 == null) goto L36;
        String r16 = r7.d;
    L37:
        r9.put("vid", r16);
        r9.put("is_social", false);
        r9.put("recode_size", r6.size());
        Unit r17 = Unit.INSTANCE;
        r8.reportEvent("audio_msg_on_screen", r9);
        TypeIntrinsics.asMutableMap(r6).remove(r0.getLocalMessageId());
        goto L38
    L36:
        r16 = null;
        goto L37
    L32:
        r15 = null;
        goto L33
    L28:
        r14 = null;
        goto L29
    L24:
        r10 = null;
    L38:
        RecyclerView r18 = ((FlowListViewHolder) this).a;
        if (r18 == null) goto L140;
        ConcatAdapter r19 = r18.getAdapter();
        if (r19 == null) goto L140;
        if ((r19 instanceof ConcatAdapter) == false) goto L55;
        Iterator r20 = r19.getAdapters().iterator();
    L46:
        if (r20.hasNext() == false) goto L50;
        Object r21 = r20.next();
        if ((((RecyclerView.Adapter) r21) instanceof MessageAdapter) == false) goto L46;
    L52:
        if ((r21 instanceof MessageAdapter) == false) goto L57;
        MessageAdapter r22 = (MessageAdapter) r21;
    L59:
        if (r22 == null) goto L95;
        Message r23 = r13.getMessage();
        Intrinsics.checkNotNullParameter(r23, "data");
        if (h.a == false) goto L63;
        boolean r24 = ((Boolean) r22.r.getValue()).booleanValue();
    L64:
        ICoreInputAbility r25 = r22.p.v0();
        if (r25 == null) goto L67;
        MessageModifyMode r26 = r25.FF();
    L69:
        if (r26 != MessageModifyMode.MODIFY_TO_REGENERATE) goto L73;
        if (r24 == true) goto L73;
    L94:
        boolean r27 = true;
    L96:
        View r28 = ((RecyclerView.ViewHolder) this).itemView;
        if (r27 == false) goto L99;
        float r29 = 0.3f;
    L100:
        r28.setAlpha(r29);
        Object r30 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r30 instanceof MessageNoBoxContainerView) == false) goto L103;
        MessageNoBoxContainerView r31 = (MessageNoBoxContainerView) r30;
    L104:
        if (r31 == null) goto L115;
        if (r22 == null) goto L114;
        IChatMessageShareAbility r32 = r22.p.J9();
        if (r32 != null) goto L109;
    L111:
        boolean r33 = false;
    L112:
        if (r33 != true) goto L114;
        r5 = true;
        goto L114
    L109:
        if (r32.H1() != true) goto L111;
        r33 = true;
    L114:
        r31.setShareMode(r5);
    L115:
        Lazy r34 = nd8.b.a;
        if (((m0) r34.getValue()).b() == false) goto L140;
        AbstractMessageBoxContainerView r35 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r35 instanceof AbstractMessageBoxContainerView) == false) goto L120;
        AbstractMessageBoxContainerView r36 = r35;
    L121:
        if (r36 == null) goto L140;
        View r37 = r36.getBoxView();
        if (r37 == null) goto L140;
        if ((r37 instanceof i) == false) goto L127;
        i r38 = (i) r37;
    L128:
        if (r38 == null) goto L130;
        CustomMarkdownTextView r39 = i.h(r37, CustomMarkdownTextView.class);
    L131:
        if (r39 == null) goto L133;
        r39.setTag(2131365552, r0.getMessageId());
    L133:
        if (r39 == null) goto L140;
        if (r22 != null) goto L136;
    L138:
        SelectorRestore r40 = null;
    L139:
        r39.setTag(2131373650, r40);
        goto L140
    L136:
        if (((m0) r34.getValue()).b() == false) goto L138;
        r40 = r22.H;
        goto L139
    L130:
        r39 = null;
        goto L131
    L127:
        r38 = null;
        goto L128
    L120:
        r36 = null;
        goto L121
    L103:
        r31 = null;
        goto L104
    L99:
        r29 = 1.0f;
    L73:
        if (r22.s0() == false) goto L81;
        String r41 = r22.B;
        Intrinsics.checkNotNullParameter(r23, "<this>");
        if (r41 != null) goto L77;
        boolean r42 = false;
    L78:
        if (r42 == true) goto L81;
    L77:
        r42 = Intrinsics.areEqual(r23.getLocalMessageId(), r41);
    L81:
        if (b0.e(r23) == true) goto L95;
        if (b0.g(r23) == true) goto L95;
        IChatMessageShareAbility r43 = r22.p.J9();
        if (r43 != null) goto L88;
    L90:
        boolean r44 = false;
    L91:
        if (r44 == false) goto L95;
        if (r43.n8(r23) == true) goto L95;
    L88:
        if (r43.H1() != true) goto L90;
        r44 = true;
        goto L91
    L67:
        r26 = null;
        goto L69
    L63:
        r24 = z2.a.messageModifyConfig().b;
    L95:
        r27 = false;
    L57:
        r22 = null;
        goto L59
    L50:
        r21 = null;
        goto L52
    L55:
        if ((r19 instanceof MessageAdapter) == false) goto L57;
        r22 = (MessageAdapter) r19;
    L140:
        ChatRenderTrace.b.getClass();
        ChatRenderTrace.p(r0);
        com.larus.bmhome.chat.trace.appreciable.f r45 = com.larus.bmhome.chat.trace.appreciable.f.a;
        de8.c r46 = (de8.c) this.g.getValue();
        if (r46 == null) goto L143;
        long r47 = r46.l();
    L144:
        r45.getClass();
        com.larus.bmhome.chat.trace.appreciable.f.c(r0, r47);
        AbstractMessageBoxContainerView r48 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r48 instanceof AbstractMessageBoxContainerView) == false) goto L147;
        AbstractMessageBoxContainerView r49 = r48;
    L148:
        if (r49 == null) goto L150;
        r49.S5(r13);
    L150:
        Iterator r50 = ((LinkedHashMap) this.f).entrySet().iterator();
    L152:
        if (r50.hasNext() == false) goto L159;
        Map.Entry r51 = (Map.Entry) r50.next();
        Object r52 = r51.getKey();
        if ((r52 instanceof BaseMessageSlotCell) == false) goto L156;
        BaseMessageSlotCell r53 = (BaseMessageSlotCell) r52;
    L157:
        if (r53 == null) goto L152;
        r53.onBindView((View) r51.getValue(), ((BaseMessageSlotCell) r51.getKey()).k(r13), r12);
        goto L152
    L156:
        r53 = null;
        goto L157
    L159:
        View r110 = ((RecyclerView.ViewHolder) this).itemView;
        if (r110.isLaidOut() == true) goto L162;
    L169:
        r110.addOnLayoutChangeListener(new lf8.d(r0));
        return;
    L162:
        if (r110.isLayoutRequested() == true) goto L169;
        if (o0.d(r0.getMessageId()) == false) goto L179;
        MessageHeightCache r111 = MessageHeightCache.INSTANCE;
        String r54 = r0.getMessageId();
        if (r54 != null) goto L168;
        r54 = "";
    L168:
        r111.put(r54, Integer.valueOf(r110.getHeight()));
        return;
    L179:
        return;
    L147:
        r49 = null;
        goto L148
    L143:
        r47 = -1;
        goto L144
    L5:
        FirstFeedSceneEnum r55 = f2.a;
        FirstFeedSceneEnum r56 = FirstFeedSceneEnum.CHAT_DETAIL_NEW_CONVERSATION;
        if (r55 != r56) goto L9;
        f2.a(((RecyclerView.ViewHolder) this).itemView, r56.getScene());
        goto L9
    }
}
