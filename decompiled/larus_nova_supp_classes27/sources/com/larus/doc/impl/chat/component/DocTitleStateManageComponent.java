package com.larus.doc.impl.chat.component;

import android.text.TextUtils;
import android.view.View;
import com.google.gson.Gson;
import com.larus.doc.impl.DocFragment;
import com.larus.doc.impl.chat.data.PageTaskInfo;
import com.larus.doc.sdk.api.IDocSdkBaseService;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.z;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import n39.l;
import va8.d0;
import va8.e0;
import va8.p;
import va8.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001/B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u001fH\u0016J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&H\u0016J\u0016\u0010(\u001a\u00020\u001d2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002J\u0010\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u0013H\u0016J\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u0013H\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/larus/doc/impl/chat/component/DocTitleStateManageComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/bmhome/ability/IDocTitleStateAbility;", "Lcom/larus/bmhome/chat/event/OnChatChangedListener;", "<init>", "()V", "chatListCoreAbility", "Lcom/larus/bmhome/ability/IChatListCoreAbility;", "getChatListCoreAbility", "()Lcom/larus/bmhome/ability/IChatListCoreAbility;", "chatListCoreAbility$delegate", "Lkotlin/Lazy;", "sceneAbility", "Lcom/larus/bmhome/ability/IChatSceneAbility;", "getSceneAbility", "()Lcom/larus/bmhome/ability/IChatSceneAbility;", "sceneAbility$delegate", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/larus/bmhome/ability/IDocTitleStateListener;", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "queryId", "", "isLocalConversationWhenSendMessage", "", "setTitleToThinkingState", "", "onViewCreated", "view", "Landroid/view/View;", "onFragmentViewDestroyed", "onSendMessage", "msg", "Lcom/larus/im/bean/message/Message;", "onUpdateMessage", "isBlockListFinish", "blockList", "", "Lcom/larus/im/bean/message/block/Block;", "addTitleStateListener", "listener", "removeTitleStateListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocTitleStateManageComponent extends BaseContentWidget implements d0, te8.c {
    public final Lazy m;
    public final Lazy n;
    public final CopyOnWriteArraySet<e0> o;
    public int p;
    public String q;
    public boolean r;

    public static final class a {
    }

    public static final class b implements Function0<p> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(p.class));
        }
    }

    public static final class c implements Function0<r> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(r.class));
        }
    }

    static {
    }

    public final void A2() {
        p r0 = (p) this.m.getValue();
        if (r0 == null) goto L6;
        r0.aI(this);
        return;
    }

    public final void Z4() {
        Iterator<T> r0 = this.o.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e0) r0.next()).onThinkingState();
        goto L4
    }

    public DocTitleStateManageComponent() {
        this.m = LazyKt.lazy(new b(this));
        this.n = LazyKt.lazy(new c(this));
        this.o = new CopyOnWriteArraySet();
        this.p = 2131365588;
    }

    public final int U2() {
        return this.p;
    }

    public final void A(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void F1(Message r6) {
        Intrinsics.checkNotNullParameter(r6, "msg");
        Intrinsics.checkNotNullParameter(r6, "msg");
        this.q = r6.getMessageId();
        String r0 = r6.getConversationId();
        if (r0 == null) goto L5;
        boolean r1 = StringsKt.contains$default(r0, "-doc_detail", false, 2, null);
    L6:
        this.r = r1;
        FLogger r2 = FLogger.a;
        r2.i("DocTitleStateManageComponent", "onSendMessage, id=" + this.q);
        if (r6.getMessageStatusLocal() != 12) goto L12;
        r2.i("DocTitleStateManageComponent", "onSendMessage, send failed");
        Iterator<T> r7 = this.o.iterator();
    L10:
        if (r7.hasNext() == false) goto L14;
        ((e0) r7.next()).onTitleStateReset(false);
        goto L10
    L14:
        return;
    L12:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void N0(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void Q(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "answer");
    }

    public final void UZ(e0 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.o.remove(r2);
    }

    public final void We(DocFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.o.contains(r2) == true) goto L6;
        this.o.add(r2);
        return;
    }

    public final void X2(int r1) {
        this.p = r1;
    }

    public final void onViewCreated(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r2, "view");
        p r3 = (p) this.m.getValue();
        if (r3 == null) goto L6;
        r3.hy(this);
        return;
    }

    public final void p(Message r11) {
        Intrinsics.checkNotNullParameter(r11, "msg");
        Intrinsics.checkNotNullParameter(r11, "msg");
        if (com.larus.bmhome.chat.bean.d.G0(r11) == false) goto L6;
        return;
    L6:
        if (o0.d(r11.getReplyId()) == true) goto L8;
    L10:
        boolean r0 = false;
    L11:
        if (r0 == true) goto L13;
    L17:
        boolean r3 = false;
    L19:
        if (this.r == false) goto L22;
        if (r0 == false) goto L22;
        boolean r1 = true;
    L23:
        if (r3 == true) goto L25;
        if (r1 == true) goto L25;
        return;
    L25:
        List r2 = com.larus.im.bean.message.a.m(r11);
        Intrinsics.checkNotNullParameter(r11, "<this>");
        List r4 = vd9.r.a(r11);
        ArrayList r5 = new ArrayList();
        Iterator r6 = r4.iterator();
    L27:
        if (r6.hasNext() == false) goto L41;
        Object r7 = r6.next();
        Block r8 = (Block) r7;
        ArrayList r9 = (ArrayList) r2;
        if (r9.isEmpty() == true) goto L37;
        Iterator r10 = r9.iterator();
    L33:
        if (r10.hasNext() == false) goto L37;
        if (Intrinsics.areEqual(((Block) r10.next()).getBlockId(), r8.getBlockId()) == false) goto L33;
        boolean r12 = false;
    L38:
        if (r12 == false) goto L27;
        r5.add(r7);
    L37:
        r12 = true;
        goto L38
    L41:
        if ((!((ArrayList) r2).isEmpty()) == false) goto L47;
        if (r5.isEmpty() == false) goto L47;
        FLogger.a.i("DocTitleStateManageComponent", "onUpdateMessage, blockList isEmpty, ");
        return;
    L47:
        if (r5.isEmpty() == true) goto L55;
        Iterator r13 = r5.iterator();
    L51:
        if (r13.hasNext() == false) goto L55;
        if ((!((Block) r13.next()).isFinish()) == false) goto L51;
        boolean r14 = false;
    L56:
        if (r14 == false) goto L62;
        FLogger.a.i("DocTitleStateManageComponent", "onUpdateMessage, notStreaming, blockList is finish");
        Iterator<e0> r15 = this.o.iterator();
    L59:
        if (r15.hasNext() == false) goto L61;
        r15.next().onTitleStateReset(false);
        goto L59
    L61:
        return;
    L62:
        IDocSdkBaseService r16 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        String r17 = null;
        if (r16 == null) goto L67;
        l r18 = r16.getPartialRewriteService();
        if (r18 == null) goto L67;
        Pair<String, String> r20 = r18.getSelectedText();
    L68:
        if (r20 == null) goto L70;
        String r21 = (String) r20.getFirst();
    L72:
        if (TextUtils.isEmpty(r21) == true) goto L103;
        Gson r22 = z.a;
        Map r23 = r11.getExt();
        if (r23 == null) goto L76;
        String r24 = (String) r23.get("page_task_info");
    L77:
        PageTaskInfo r25 = (PageTaskInfo) z.a(r24, PageTaskInfo.class);
        r r26 = (r) this.n.getValue();
        if (r26 == null) goto L80;
        String r27 = r26.WE();
    L82:
        if (Intrinsics.areEqual(r27, "doc_ai_edit") == false) goto L94;
        if (com.larus.im.bean.message.a.b0(r11) == false) goto L94;
        if (r25 == null) goto L88;
        r17 = r25.getActionType();
    L88:
        if (Intrinsics.areEqual(r17, "edit") == false) goto L94;
        Iterator<e0> r110 = this.o.iterator();
    L91:
        if (r110.hasNext() == false) goto L134;
        r110.next().onTitleStateReset(true);
        goto L91
    L134:
        return;
    L94:
        if (com.larus.bmhome.chat.bean.d.G0(r11) == false) goto L96;
        return;
    L96:
        if (((ArrayList) com.larus.im.bean.message.a.R(r11)).isEmpty() == false) goto L130;
        if (r25 == null) goto L131;
        Iterator<e0> r111 = this.o.iterator();
    L100:
        if (r111.hasNext() == false) goto L135;
        r111.next().onTitleStateReset(false);
        goto L100
    L135:
        return;
    L131:
        return;
    L130:
        return;
    L80:
        r27 = null;
        goto L82
    L76:
        r24 = null;
        goto L77
    L103:
        if (com.larus.bmhome.chat.bean.d.G0(r11) == true) goto L132;
        Map r112 = r11.getExt();
        if (r112 == null) goto L108;
        r17 = (String) r112.get("office_tool_never_used");
    L108:
        if (Intrinsics.areEqual(r17, "1") == false) goto L133;
        Iterator<e0> r113 = this.o.iterator();
    L111:
        if (r113.hasNext() == false) goto L136;
        r113.next().onTitleStateReset(false);
        goto L111
    L136:
        return;
    L133:
        return;
    L132:
        return;
    L70:
        r21 = null;
    L67:
        r20 = null;
    L55:
        r14 = true;
    L22:
        r1 = false;
        goto L23
    L13:
        if (o0.d(this.q) == false) goto L17;
        if (Intrinsics.areEqual(r11.getReplyId(), this.q) == false) goto L17;
        r3 = true;
        goto L19
    L8:
        if (Intrinsics.areEqual(r11.getReplyId(), "0") == true) goto L10;
        r0 = true;
        goto L11
    }

    public final void v(List<Message> r2) {
        Intrinsics.checkNotNullParameter(r2, "messages");
    }

    public final void v1(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "answer");
    }

    public final void y0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
    }
}
