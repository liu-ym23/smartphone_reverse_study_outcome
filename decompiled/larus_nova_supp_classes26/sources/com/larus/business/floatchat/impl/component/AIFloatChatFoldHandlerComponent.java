package com.larus.business.floatchat.impl.component;

import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.bmhome.floatchat.component.FoldHandlerVM;
import com.larus.bmhome.floatchat.component.FoldHandlerVMState;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.im.bean.message.Message;
import com.larus.im.observer.MessageListState;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0013*\u0002[^\u0018\u0000 \u0089\u00012\u00020\u00012\u00020\u0002:\u0002\u0089\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020AH\u0016J\b\u0010g\u001a\u00020eH\u0016J\u0010\u0010h\u001a\u00020e2\u0006\u0010i\u001a\u00020jH\u0002J\u0010\u0010k\u001a\u00020e2\u0006\u0010i\u001a\u00020jH\u0002J\b\u0010l\u001a\u00020eH\u0002J\b\u0010m\u001a\u00020SH\u0016J\u0010\u0010n\u001a\u00020e2\u0006\u0010o\u001a\u00020UH\u0016J\u0010\u0010p\u001a\u00020e2\u0006\u0010o\u001a\u00020UH\u0016J\b\u0010q\u001a\u00020LH\u0016J\u0010\u0010r\u001a\u00020e2\u0006\u0010s\u001a\u000204H\u0016J\u0010\u0010t\u001a\u00020e2\u0006\u0010s\u001a\u000204H\u0016J\u0012\u0010u\u001a\u00020e2\b\u0010v\u001a\u0004\u0018\u00010wH\u0016J\u0010\u0010x\u001a\u00020e2\u0006\u0010y\u001a\u00020SH\u0016J\b\u0010z\u001a\u00020SH\u0016J\u0012\u0010{\u001a\u00020e2\b\u0010|\u001a\u0004\u0018\u00010UH\u0016J\u0010\u0010}\u001a\u00020e2\u0006\u0010~\u001a\u00020SH\u0016J\b\u0010\u007f\u001a\u00020eH\u0016J\t\u0010\u0080\u0001\u001a\u00020eH\u0002J\u0012\u0010\u0081\u0001\u001a\u00020e2\u0007\u0010\u0082\u0001\u001a\u00020SH\u0002J\t\u0010\u0083\u0001\u001a\u00020LH\u0002J\u0012\u0010\u0084\u0001\u001a\u00020e2\u0007\u0010\u0082\u0001\u001a\u00020SH\u0002J\t\u0010\u0085\u0001\u001a\u00020eH\u0003J\u001b\u0010\u0086\u0001\u001a\u00020e2\u0007\u0010\u0087\u0001\u001a\u00020L2\u0007\u0010\u0088\u0001\u001a\u00020LH\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u001d\u0010$\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\n\u001a\u0004\b&\u0010'R\u001d\u0010)\u001a\u0004\u0018\u00010\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\n\u001a\u0004\b*\u0010+R\u001d\u0010-\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\n\u001a\u0004\b/\u00100R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020403X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u00105\u001a\u0004\u0018\u0001068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\n\u001a\u0004\b7\u00108R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b<\u0010=R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010K\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\n\u001a\u0004\bM\u0010NR\u000e\u0010P\u001a\u00020QX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020SX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010UX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020SX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010UX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020SX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020SX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u00020[X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\\R\u0010\u0010]\u001a\u00020^X\u0082\u0004¢\u0006\u0004\n\u0002\u0010_R\u001a\u0010`\u001a\u00020LX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010N\"\u0004\bb\u0010c¨\u0006\u008a\u0001"}, d2 = {"Lcom/larus/business/floatchat/impl/component/AIFloatChatFoldHandlerComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/bmhome/ability/IFloatChatFoldCoreAbility;", "<init>", "()V", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "coreInputManager", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "getCoreInputManager", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "coreInputManager$delegate", "chatListCoreAbility", "Lcom/larus/bmhome/ability/IChatListCoreAbility;", "getChatListCoreAbility", "()Lcom/larus/bmhome/ability/IChatListCoreAbility;", "chatListCoreAbility$delegate", "floatChatTitleAbility", "Lcom/larus/bmhome/floatchat/ability/IFloatChatTitleAbility;", "getFloatChatTitleAbility", "()Lcom/larus/bmhome/floatchat/ability/IFloatChatTitleAbility;", "floatChatTitleAbility$delegate", "chatInputCoreAbility", "Lcom/larus/bmhome/ability/IChatInputCoreAbility;", "getChatInputCoreAbility", "()Lcom/larus/bmhome/ability/IChatInputCoreAbility;", "chatInputCoreAbility$delegate", "actionBarSceneAbility", "Lcom/larus/bmhome/ability/IChatSceneAbility;", "getActionBarSceneAbility", "()Lcom/larus/bmhome/ability/IChatSceneAbility;", "actionBarSceneAbility$delegate", "chatBottomFloatingCoreAbility", "Lcom/larus/bmhome/audio/IChatBottomFloatingApiAbility;", "getChatBottomFloatingCoreAbility", "()Lcom/larus/bmhome/audio/IChatBottomFloatingApiAbility;", "chatBottomFloatingCoreAbility$delegate", "chatFoldCoreAbility", "getChatFoldCoreAbility", "()Lcom/larus/bmhome/ability/IFloatChatFoldCoreAbility;", "chatFoldCoreAbility$delegate", "conversationCoreAbility", "Lcom/larus/bmhome/ability/IConversationCoreAbility;", "getConversationCoreAbility", "()Lcom/larus/bmhome/ability/IConversationCoreAbility;", "conversationCoreAbility$delegate", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/larus/bmhome/ability/FloatChatFoldStatusChangeListener;", "chatParamCoreData", "Lcom/larus/bmhome/data/ChatParamCoreData;", "getChatParamCoreData", "()Lcom/larus/bmhome/data/ChatParamCoreData;", "chatParamCoreData$delegate", "foldHandlerVM", "Lcom/larus/bmhome/floatchat/component/FoldHandlerVM;", "getFoldHandlerVM", "()Lcom/larus/bmhome/floatchat/component/FoldHandlerVM;", "foldHandlerVM$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "root", "Landroid/view/View;", "messageListParent", "topHandleContainer", "titleContainer", "topHandle", "topShadow", "actionBarContainer", "actionBar", "messageList", "Landroidx/recyclerview/widget/RecyclerView;", "minPageHeight", "", "getMinPageHeight", "()I", "minPageHeight$delegate", "startTouchY", "", "shouldFold", "", "queryId", "", "hasExpand", "conversationId", "isLocalConversation", "canExpandChatPanel", "conversationChangeListener", "com/larus/business/floatchat/impl/component/AIFloatChatFoldHandlerComponent$conversationChangeListener$1", "Lcom/larus/business/floatchat/impl/component/AIFloatChatFoldHandlerComponent$conversationChangeListener$1;", "messageChangedObserver", "com/larus/business/floatchat/impl/component/AIFloatChatFoldHandlerComponent$messageChangedObserver$1", "Lcom/larus/business/floatchat/impl/component/AIFloatChatFoldHandlerComponent$messageChangedObserver$1;", "contentViewId", "getContentViewId", "setContentViewId", "(I)V", "onViewCreated", "", "view", "onFragmentViewDestroyed", "onSendMessage", "msg", "Lcom/larus/im/bean/message/Message;", "onUpdateMessage", "observe", "isExpand", "fold", "from", "expand", "getShowPercent", "addFoldStatusChangeListener", "listener", "removeFoldStatusChangeListener", "setChatRootBg", "bg", "Landroid/graphics/drawable/Drawable;", "notifySpeakerVisible", "visible", "canShowActionBar", "setConversationId", "convId", "setCanExpandChatPanel", "canExpand", "expandToFullScreen", "jumpToChatPage", "foldFloatChat", "needAnim", "getHalfScreenHeight", "expandScreen", "topHandleSetTouchListener", "dealExpandOrFold", "curHeight", "lastHeight", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIFloatChatFoldHandlerComponent extends BaseContentWidget implements va8.g0 {
    public static final /* synthetic */ int S = 0;
    public View A;
    public View B;
    public View C;
    public View D;
    public View E;
    public View F;
    public RecyclerView G;
    public final Lazy H;
    public float I;
    public boolean J;
    public String K;
    public boolean L;
    public String M;
    public boolean N;
    public boolean O;
    public final b P;
    public final c Q;
    public int R;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final CopyOnWriteArraySet<va8.d> v;
    public final Lazy w;
    public final com.larus.ui.arch.vm.internal.l x;
    public View y;
    public View z;

    public static final class a {
    }

    public static final class b implements com.larus.im.service.d0<wc9.e> {
        public final /* synthetic */ AIFloatChatFoldHandlerComponent a;

        public b(AIFloatChatFoldHandlerComponent r1) {
            this.a = r1;
        }

        public final void c(Object r2) {
            Intrinsics.checkNotNullParameter((wc9.e) r2, "conversation");
        }

        public final void a(wc9.e r5, wc9.e r6) {
            Intrinsics.checkNotNullParameter(r6, "new");
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("On replace conversation targetId: ");
            String r2 = null;
            if (r5 == null) goto L5;
            String r3 = r5.a;
        L6:
            r1.append(r3);
            r1.append(", newId: ");
            r1.append(r6.a);
            r0.i("AIFloatChatFoldHandlerComponent", r1.toString());
            String r4 = this.a.M;
            if (r4 == null) goto L11;
            Lazy r7 = ic8.n.a;
            Intrinsics.checkNotNullParameter(r4, "<this>");
            boolean r8 = true;
            if (com.larus.im.j.f(r4) != true) goto L11;
        L12:
            if (r8 == false) goto L27;
            String r9 = this.a.M;
            if (r5 == null) goto L17;
            r2 = r5.a;
        L17:
            if (Intrinsics.areEqual(r9, r2) == false) goto L28;
            AIFloatChatFoldHandlerComponent r10 = this.a;
            r10.M = r6.a;
            if (r5 == null) goto L23;
            String r11 = r5.a;
            if (r11 == null) goto L23;
            com.larus.im.d.e().unregisterOnMessageChangedObserver(r11, r10.Q);
        L23:
            AIFloatChatFoldHandlerComponent r12 = this.a;
            String r13 = r12.M;
            if (r13 == null) goto L29;
            com.larus.im.d.e().registerOnMessageChangedObserver(r13, r12.Q);
            return;
        L29:
            return;
        L28:
            return;
        L27:
            return;
        L11:
            r8 = false;
            goto L12
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class c implements nf9.b {
        public final /* synthetic */ AIFloatChatFoldHandlerComponent a;

        public final void b(String r2, MessageListState r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "state");
            Intrinsics.checkNotNullParameter(r4, "msgList");
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

        public c(AIFloatChatFoldHandlerComponent r1) {
            this.a = r1;
        }

        public final void a(String r4, Message r5) {
            Intrinsics.checkNotNullParameter(r4, "cid");
            Intrinsics.checkNotNullParameter(r5, "msg");
            AIFloatChatFoldHandlerComponent r6 = this.a;
            int r0 = AIFloatChatFoldHandlerComponent.S;
            r6.getClass();
            FLogger.a.i("AIFloatChatFoldHandlerComponent", "onSendMessage, msgId = " + r5.getMessageId() + ", msgLocalStatus = " + r5.getMessageStatusLocal());
            r6.K = r5.getMessageId();
            r6.L = false;
        }

        public final void c(String r5, Message r6, Map<String, String> r7) {
            Intrinsics.checkNotNullParameter(r5, "cid");
            Intrinsics.checkNotNullParameter(r6, "msg");
            AIFloatChatFoldHandlerComponent r8 = this.a;
            int r9 = AIFloatChatFoldHandlerComponent.S;
            r8.getClass();
            if (com.larus.bmhome.chat.bean.d.G0(r6) == true) goto L33;
            FLogger r10 = FLogger.a;
            StringBuilder r0 = new StringBuilder("onUpdateMessage, queryId=");
            r0.append(r8.K);
            r0.append(", replyId=");
            r0.append(r6.getReplyId());
            r0.append(", office_tool_never_user=");
            Map r1 = r6.getExt();
            String r3 = null;
            if (r1 == null) goto L8;
            String r2 = (String) r1.get("office_tool_never_used");
        L9:
            r0.append(r2);
            r0.append(", hasExpand=");
            r0.append(r8.L);
            r0.append(", canExpand=");
            r0.append(r8.O);
            r10.i("AIFloatChatFoldHandlerComponent", r0.toString());
            if (com.larus.utils.o0.d(r8.K) == false) goto L14;
            if (Intrinsics.areEqual(r6.getReplyId(), r8.K) == false) goto L14;
        L15:
            Map r11 = r6.getExt();
            if (r11 == null) goto L19;
            r3 = (String) r11.get("office_tool_never_used");
        L19:
            if (Intrinsics.areEqual(r3, "1") == true) goto L21;
            return;
        L21:
            if (r8.L == true) goto L30;
            r8.N = false;
            if (r8.O == false) goto L31;
            r8.L = true;
            va8.g0 r12 = (va8.g0) r8.t.getValue();
            if (r12 == null) goto L32;
            r12.expand("onReceiveSlidesCommonMsg");
            return;
        L32:
            return;
        L31:
            return;
        L30:
            return;
        L14:
            if (r8.N == true) goto L15;
            return;
        L8:
            r2 = null;
            goto L9
        }
    }

    public static final class d implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ICoreInputAbility.class));
        }
    }

    public static final class e implements Function0<va8.p> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.p.class));
        }
    }

    public static final class f implements Function0<np8.a> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(np8.a.class));
        }
    }

    public static final class g implements Function0<va8.n> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.n.class));
        }
    }

    public static final class h implements Function0<va8.r> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.r.class));
        }
    }

    public static final class i implements Function0<va8.g0> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.g0.class));
        }
    }

    public static final class j implements Function0<va8.a0> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.a0.class));
        }
    }

    public static final class k implements Function0<fp8.b> {
        public final /* synthetic */ AttachReceiver a;

        public k(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(fp8.b.class));
        }
    }

    public static final class l implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public l(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class m implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public m(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class n implements Function0<ViewModelProvider.Factory> {
        public static final n a = null;

        static {
            a = new n();
        }

        public n() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    static {
    }

    public final void BW() {
    }

    public final void CI() {
    }

    public final boolean E2() {
        return false;
    }

    public final void Pb() {
    }

    public final boolean Pu() {
        return false;
    }

    public final void A2() {
        String r0 = this.M;
        if (r0 == null) goto L6;
        com.larus.im.d.c().unRegisterConversationChangeListener(r0, this.P);
        com.larus.im.d.e().unregisterOnMessageChangedObserver(r0, this.Q);
        return;
    }

    public final void eA() {
        View r0 = this.D;
        if (r0 == null) goto L5;
        e1.o(r0);
    L5:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        ConstraintLayout.LayoutParams r2 = null;
        if ((r1 instanceof FragmentActivity) == true) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L33;
        final View r4 = this.y;
        if (r4 == null) goto L34;
        View r3 = this.C;
        if (r3 == null) goto L15;
        e1.o(r3);
    L15:
        final int r5 = r4.getLayoutParams().height;
        int r6 = com.larus.utils.u.c(r1) + r5;
        View r7 = this.A;
        if (r7 == null) goto L20;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if (r8 == null) goto L20;
        final int r9 = r8.height;
    L21:
        View r10 = this.B;
        if (r10 == null) goto L24;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
    L26:
        if ((r11 instanceof ConstraintLayout.LayoutParams) == false) goto L28;
        r2 = (ConstraintLayout.LayoutParams) r11;
    L28:
        if (r2 == null) goto L30;
        final int r12 = ((ViewGroup.MarginLayoutParams) r2).topMargin;
    L31:
        FLogger.a.i("AIFloatChatFoldHandlerComponent", "Current height: " + r5 + ", target height: " + r6);
        ValueAnimator r13 = ValueAnimator.ofInt(new int[]{r5, r6}).setDuration(300);
        final int r14 = r9;
        final int r15 = r12;
        r13.addUpdateListener(new a0(r4, r5, this, r14, r15));
        Intrinsics.checkNotNull(r13);
        d2a.g.c(r13, new b0(this, r9, r12));
        r13.setInterpolator(new LinearInterpolator());
        r13.start();
        return;
    L30:
        r12 = i5.r0();
        goto L31
    L24:
        r11 = null;
    L20:
        r9 = i5.g0();
        goto L21
    L34:
        return;
    }

    public final FoldHandlerVM m3() {
        return (FoldHandlerVM) this.x.getValue();
    }

    public final int p3() {
        fp8.b r0 = (fp8.b) this.w.getValue();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.c;
    L6:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r3 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r3 == null) goto L9;
        int r4 = com.larus.utils.u.c(r3);
    L10:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r5 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r5 == null) goto L13;
        r1 = com.larus.utils.u.b(r5);
    L13:
        int r6 = com.larus.utils.m0.a;
        return ((int) (((double) (((com.larus.utils.m0.a(getContext()) - r2) - r4) - r1)) * 0.75d)) + c7.b(16);
    L9:
        r4 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public AIFloatChatFoldHandlerComponent() {
        this.m = LazyKt.lazy(new d(this));
        this.n = LazyKt.lazy(new v(this));
        this.o = LazyKt.lazy(new e(this));
        this.p = LazyKt.lazy(new f(this));
        this.q = LazyKt.lazy(new g(this));
        this.r = LazyKt.lazy(new h(this));
        this.s = LazyKt.lazy(new w(this));
        this.t = LazyKt.lazy(new i(this));
        this.u = LazyKt.lazy(new j(this));
        this.v = new CopyOnWriteArraySet();
        this.w = LazyKt.lazy(new k(this));
        this.x = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(FoldHandlerVM.class), Reflection.getOrCreateKotlinClass(FoldHandlerVMState.class), new l(this), new m(this), n.a);
        this.H = LazyKt.lazy(new x(this));
        this.O = true;
        this.P = new b(this);
        this.Q = new c(this);
        this.R = 2131365588;
    }

    public final int Gt() {
        int r0 = ((FoldHandlerVMState) m3().getState()).getStatus();
        if (r0 != 1) goto L5;
        return 50;
    L5:
        if (r0 != 2) goto L7;
        return 90;
    L7:
        if (r0 == 3) goto L9;
        return 0;
    L9:
        return 100;
    }

    public final boolean YC() {
        if (((FoldHandlerVMState) m3().getState()).getStatus() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int U2() {
        return this.R;
    }

    public static final void h3(AIFloatChatFoldHandlerComponent r3) {
        View r0 = r3.z;
        if (r0 == null) goto L5;
        e1.o(r0);
    L5:
        View r1 = r3.A;
        if (r1 == null) goto L8;
        e1.o(r1);
    L8:
        View r2 = r3.D;
        if (r2 == null) goto L11;
        e1.o(r2);
    L11:
        np8.a r4 = (np8.a) r3.p.getValue();
        if (r4 == null) goto L14;
        r4.La();
    L14:
        xa8.a r5 = (xa8.a) r3.s.getValue();
        if (r5 == null) goto L17;
        r5.H9(true);
    L17:
        View r6 = r3.y;
        FrameLayout.LayoutParams r7 = null;
        if (r6 == null) goto L20;
        ViewGroup.LayoutParams r8 = r6.getLayoutParams();
    L22:
        if ((r8 instanceof FrameLayout.LayoutParams) == false) goto L24;
        r7 = (FrameLayout.LayoutParams) r8;
    L24:
        if (r7 == null) goto L26;
        r7.height = -2;
    L26:
        View r9 = r3.y;
        if (r9 == null) goto L29;
        r9.setLayoutParams(r7);
    L29:
        View r10 = r3.y;
        if (r10 == null) goto L33;
        r10.setBackground(new ColorDrawable(0));
        return;
    L33:
        return;
    L20:
        r8 = null;
        goto L22
    }

    public final void Dj(va8.d r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        FLogger.a.i("AIFloatChatFoldHandlerComponent", "addFoldStatusChangeListener listener:" + r4 + ", current:" + this.v.size());
        if (this.v.contains(r4) == true) goto L6;
        this.v.add(r4);
        return;
    }

    public final void Iq(boolean r1) {
        this.O = r1;
    }

    public final void PJ(boolean r3) {
        if (((FoldHandlerVMState) m3().getState()).getStatus() == 0) goto L6;
        return;
    L6:
        if (r3 == false) goto L15;
        View r4 = this.y;
        if (r4 == null) goto L12;
        View r5 = r4.findViewById(2131375324);
        if (r5 == null) goto L12;
        r5.setBackground(new ColorDrawable(0));
    L12:
        View r6 = this.y;
        if (r6 == null) goto L19;
        r6.setBackground(new ColorDrawable(0));
        return;
    L19:
        return;
    L15:
        View r7 = this.y;
        if (r7 == null) goto L21;
        r7.setBackground(new ColorDrawable(0));
        return;
    }

    public final void X2(int r1) {
        this.R = r1;
    }

    public final void Zh(va8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.v.contains(r2) == false) goto L6;
        this.v.remove(r2);
        return;
    }

    public final void expand(String r3) {
        Intrinsics.checkNotNullParameter(r3, "from");
        if (YC() == true) goto L6;
        m3().toHalfScreen(true, r3);
        return;
    }

    public final void gA(Drawable r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        View r0 = this.y;
        if (r0 == null) goto L7;
        r0.setBackground(r3);
    L7:
        View r1 = this.y;
        if (r1 == null) goto L21;
        View r2 = r1.findViewById(2131364488);
        if (r2 == null) goto L22;
        Drawable.ConstantState r4 = r3.getConstantState();
        if (r4 == null) goto L19;
        Drawable r5 = r4.newDrawable();
        if (r5 == null) goto L19;
        Drawable r6 = r5.mutate();
        if (r6 == null) goto L19;
        r3 = r6;
    L19:
        r2.setBackground(r3);
        return;
    L22:
        return;
    }

    public final void km(String r4) {
        Intrinsics.checkNotNullParameter(r4, "from");
        FLogger.a.i("AIFloatChatFoldHandlerComponent", "out fold " + r4);
        m3().foldFloatChat(false, r4);
    }

    public final void onViewCreated(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        this.y = r10;
        this.z = r10.findViewById(2131379994);
        this.A = r10.findViewById(2131389157);
        this.C = r10.findViewById(2131389156);
        this.D = r10.findViewById(2131389223);
        this.B = r10.findViewById(2131388843);
        View r11 = r10.findViewById(2131362044);
        this.E = r11;
        if (r11 == null) goto L5;
        e1.o(r11);
    L5:
        View r12 = this.E;
        RecyclerView r0 = null;
        if (r12 == null) goto L8;
        View r13 = r12.findViewById(2131362041);
    L9:
        this.F = r13;
        View r14 = this.z;
        if (r14 == null) goto L12;
        e1.o(r14);
    L12:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r1 == null) goto L15;
        String r2 = r1.getString("argConversationId", "");
    L16:
        this.M = r2;
        if (r2 == null) goto L19;
        Lazy r3 = ic8.n.a;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        this.N = com.larus.im.j.f(r2);
        com.larus.im.d.c().registerConversationChangeListener(r2, this.P);
        com.larus.im.d.e().registerOnMessageChangedObserver(r2, this.Q);
    L19:
        z8 r15 = (z8) this.n.getValue();
        if (r15 == null) goto L22;
        r15.w9(false);
    L22:
        ComponentViewModel.onEach$default(m3(), AIFloatChatFoldHandlerComponent$observe$1.INSTANCE, AIFloatChatFoldHandlerComponent$observe$2.INSTANCE, null, new AIFloatChatFoldHandlerComponent$observe$3(this, null), 4, null);
        ChatConstraintLayout r16 = this.y;
        if ((r16 instanceof ChatConstraintLayout) == false) goto L25;
        ChatConstraintLayout r17 = r16;
    L26:
        if (r17 == null) goto L28;
        r17.setOnImePaddingUpdate(new z(this));
    L28:
        View r18 = this.A;
        if (r18 == null) goto L31;
        r18.setOnTouchListener(new c0(this));
    L31:
        va8.p r19 = (va8.p) this.o.getValue();
        if (r19 == null) goto L34;
        r0 = r19.Ly();
    L34:
        this.G = r0;
        va8.p r110 = (va8.p) this.o.getValue();
        if (r110 == null) goto L38;
        r110.rW(new u(this));
        return;
    L38:
        return;
    L25:
        r17 = null;
        goto L26
    L15:
        r2 = null;
        goto L16
    L8:
        r13 = null;
        goto L9
    }

    public final void setConversationId(String r3) {
        this.M = r3;
        if (r3 == null) goto L6;
        Lazy r0 = ic8.n.a;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        this.N = com.larus.im.j.f(r3);
        com.larus.im.d.e().registerOnMessageChangedObserver(r3, this.Q);
        return;
    }

    public static final void Y2(final AIFloatChatFoldHandlerComponent r5, boolean r6) {
        final int r0 = r5.p3();
        if (r6 == false) goto L9;
        int[] r7 = new int[2];
        View r2 = r5.y;
        if (r2 == null) goto L7;
        int r3 = r2.getHeight();
    L8:
        r7[0] = r3;
        r7[1] = r0;
        ValueAnimator r8 = ValueAnimator.ofInt(r7).setDuration(150);
        r8.addUpdateListener(new y(r5, r0));
        r8.setInterpolator(new LinearInterpolator());
        r8.start();
    L21:
        View r9 = r5.z;
        if (r9 == null) goto L24;
        e1.x(r9);
    L24:
        View r10 = r5.A;
        if (r10 == null) goto L27;
        e1.x(r10);
    L27:
        View r11 = r5.D;
        if (r11 == null) goto L30;
        e1.x(r11);
    L30:
        View r12 = r5.E;
        if (r12 == null) goto L33;
        e1.o(r12);
    L33:
        View r13 = r5.F;
        if (r13 == null) goto L36;
        e1.o(r13);
    L36:
        View r14 = r5.y;
        if (r14 == null) goto L39;
        r14.setBackground(ContextCompat.getDrawable(r5.getContext(), v19.c.b(2130970668, r5.getContext(), 2131239072)));
    L39:
        np8.a r15 = (np8.a) r5.p.getValue();
        if (r15 == null) goto L42;
        r15.n3();
    L42:
        xa8.a r16 = (xa8.a) r5.s.getValue();
        if (r16 == null) goto L46;
        r16.H9(false);
        return;
    L46:
        return;
    L7:
        r3 = r0;
        goto L8
    L9:
        View r17 = r5.y;
        FrameLayout.LayoutParams r4 = null;
        if (r17 == null) goto L12;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
    L14:
        if ((r18 instanceof FrameLayout.LayoutParams) == false) goto L16;
        r4 = (FrameLayout.LayoutParams) r18;
    L16:
        if (r4 == null) goto L18;
        r4.height = r0;
    L18:
        View r19 = r5.y;
        if (r19 == null) goto L21;
        r19.setLayoutParams(r4);
        goto L21
    L12:
        r18 = null;
        goto L14
    }
}
