package com.obric.assistant.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.SessionAuthenticationServiceDelegate;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0002KLB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010'\u001a\u00020(H\u0016J \u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020/H\u0002J\u0012\u00101\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0012\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u000207H\u0002J\u0012\u00108\u001a\u0004\u0018\u0001032\u0006\u00109\u001a\u000207H\u0002J\u0018\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010=\u001a\u00020(H\u0016J\u0010\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0?H\u0016J\u0010\u0010@\u001a\u00020-2\u0006\u0010A\u001a\u00020+H\u0016J\b\u0010B\u001a\u00020-H\u0016J\u0016\u0010C\u001a\u00020-2\u0006\u0010A\u001a\u00020+H\u0096@¢\u0006\u0002\u0010DJ\u000e\u0010E\u001a\b\u0012\u0002\b\u0003\u0018\u00010FH\u0002J\u0010\u0010G\u001a\u00020/2\u0006\u0010A\u001a\u00020+H\u0002J\u0010\u0010H\u001a\u00020+2\u0006\u0010I\u001a\u00020/H\u0002J\u0018\u0010J\u001a\u0004\u0018\u00010&2\u0006\u0010A\u001a\u00020+H\u0082@¢\u0006\u0002\u0010DR\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u0016\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/obric/assistant/component/ObricChatListComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/ability/IObricChatListAbility;", "<init>", "()V", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "Lkotlin/Lazy;", "chatListComponentAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getChatListComponentAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "chatListComponentAbility$delegate", "chatBottomFloatingAbility", "Lcom/larus/bmhome/chat/component/bottom/floating/IChatBottomFloatingAbility;", "getChatBottomFloatingAbility", "()Lcom/larus/bmhome/chat/component/bottom/floating/IChatBottomFloatingAbility;", "chatBottomFloatingAbility$delegate", "chatListAbility", "Lcom/larus/bmhome/ability/IChatListCoreAbility;", "getChatListAbility", "()Lcom/larus/bmhome/ability/IChatListCoreAbility;", "chatListAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "messageList", "Landroidx/recyclerview/widget/RecyclerView;", "getMessageList", "()Landroidx/recyclerview/widget/RecyclerView;", "messageList$delegate", "latestVisibleMessageStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/im/bean/message/Message;", "onParentViewCreated", "", "scrollToMessageAlignBottom", "targetMsgId", "", "highlight", "", "marginBottom", "", "getWindowInputHeight", "getVisibleHeight", "view", "Landroid/view/View;", "getTargetHighlightViews", "Lcom/larus/bmhome/chat/layout/item/BaseMessageBox;", "targetView", "Landroid/view/ViewGroup;", "getBlockContainer", "box", "playHighlightAnimation", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "scrollToBottom", "getLatestVisibleMessageState", "Lkotlinx/coroutines/flow/StateFlow;", "isMsgInChatList", "msgId", "isNeedCutMessageNow", "canShowOnLockedScreen", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMessageListAdapter", "Lcom/larus/bmhome/chat/adapter/IMessageListAdapter;", "findMessagePositionInList", "getMessageIdAtPosition", "position", "findMessage", "Companion", "HighlightOverlayView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatListComponent extends ComponentFeature implements laa.c {
    public static final /* synthetic */ int o = 0;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final StateFlowImpl n;

    public static final class a {
    }

    public static final class b extends View {
        public final float a;
        public final float b;
        public final Paint c;
        public final Paint d;
        public final Rect e;
        public final RectF f;
        public boolean g;

        public b(Context r4) {
            Intrinsics.checkNotNullParameter(r4, "context");
            super(r4);
            this.a = c7.c(Float.valueOf(16.0f));
            this.b = c7.c(Float.valueOf(8.0f));
            this.c = new Paint(1);
            Paint r5 = new Paint(1);
            r5.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            this.d = r5;
            this.e = new Rect();
            this.f = new RectF();
            setLayerType(1, null);
        }

        @Override // android.view.View
        public final void onDraw(Canvas r10) {
            Intrinsics.checkNotNullParameter(r10, "canvas");
            int r0 = r10.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
            float r4 = getWidth();
            float r5 = getHeight();
            float r7 = this.a;
            r10.drawRoundRect(0.0f, 0.0f, r4, r5, r7, r7, this.c);
            if (this.g == false) goto L5;
            RectF r1 = this.f;
            float r2 = this.b;
            r10.drawRoundRect(r1, r2, r2, this.d);
        L5:
            r10.restoreToCount(r0);
        }

        @Override // android.view.View
        public final void onSizeChanged(int r9, int r10, int r11, int r12) {
            super.onSizeChanged(r9, r10, r11, r12);
            if (r9 <= 0) goto L8;
            if (r10 <= 0) goto L9;
            this.c.setShader(new LinearGradient(0.0f, r10, r9, 0.0f, new int[]{523724543, 531130111, 536834933, 536851045}, null, Shader.TileMode.CLAMP));
            return;
        L9:
            return;
        }
    }

    public static final class c<T> implements com.larus.bmhome.social.page.datasource.diff.c {
        public final /* synthetic */ ObricChatListComponent a;

        public c(ObricChatListComponent r1) {
            this.a = r1;
        }

        public final void onChanged(List<? extends ic8.v> r8) {
            Intrinsics.checkNotNullParameter(r8, "list");
            StateFlowImpl r0 = this.a.n;
            Iterator<T> r9 = r8.iterator();
        L3:
            Message r2 = null;
            if (r9.hasNext() == false) goto L32;
            T r1 = r9.next();
            Message r3 = ((ic8.v) r1).a();
            boolean r5 = false;
            if (com.larus.bmhome.chat.bean.d.i0(r3) == false) goto L11;
            if (com.larus.bmhome.chat.bean.d.w(r3) == true) goto L11;
        L30:
            if (r5 == false) goto L3;
        L33:
            ic8.v r4 = (ic8.v) r1;
            if (r4 == null) goto L36;
            r2 = r4.a();
        L36:
            r0.setValue(r2);
            return;
        L11:
            if (com.larus.bmhome.chat.bean.d.T(r3) == true) goto L30;
            if (com.larus.bmhome.chat.bean.d.p0(r3) == true) goto L30;
            if (com.larus.bmhome.chat.bean.d.C0(r3) == true) goto L18;
        L20:
            MessageStatus r6 = r3.getMessageStatus();
            if (r6 != null) goto L23;
        L25:
            boolean r7 = false;
        L26:
            if (r7 == false) goto L28;
        L29:
            r5 = true;
            goto L30
        L28:
            if (com.larus.bmhome.social.userchat.model.b0.f(r3) == false) goto L30;
        L23:
            if (r6.isVisible() != true) goto L25;
            r7 = true;
            goto L26
        L18:
            if (r3.getRegenVisible() == true) goto L20;
        L32:
            r1 = null;
            goto L33
        }
    }

    public static final class d implements Function0<va8.m> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    public static final class e implements Function0<u7> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(u7.class));
        }
    }

    public static final class f implements Function0<ld8.n> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ld8.n.class));
        }
    }

    public static final class g implements Function0<va8.p> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
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

    static {
    }

    public final RecyclerView N2() {
        return (RecyclerView) this.m.getValue();
    }

    public final com.larus.bmhome.chat.adapter.i<?> P2() {
        u7 r0 = (va8.p) this.k.getValue();
        if ((r0 instanceof u7) == false) goto L5;
        u7 r1 = r0;
    L6:
        if (r1 == null) goto L8;
        MessageAdapter r2 = r1.MF();
    L10:
        if ((r2 instanceof com.larus.bmhome.chat.adapter.i) == true) goto L12;
        return null;
    L12:
        return r2;
    L8:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public ObricChatListComponent() {
        this.h = LazyKt.lazy(new d(this));
        this.i = LazyKt.lazy(new e(this));
        this.j = LazyKt.lazy(new f(this));
        this.k = LazyKt.lazy(new g(this));
        this.l = LazyKt.lazy(new com.obric.assistant.component.g(this));
        this.m = LazyKt.lazy(new h(this));
        this.n = kotlinx.coroutines.flow.j1.a(null);
    }

    public final void B2() {
        com.larus.bmhome.chat.adapter.i<?> r0 = P2();
        if (r0 == null) goto L6;
        r0.p1(new c(this));
        return;
    }

    public final void kc() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricChatListComponent$scrollToBottom$1(this, null), 3, null);
    }

    public final StateFlowImpl q90() {
        return this.n;
    }

    public final boolean BL(String r5) {
        Intrinsics.checkNotNullParameter(r5, "msgId");
        com.larus.bmhome.chat.adapter.i<?> r0 = P2();
        Object r1 = null;
        if (r0 == null) goto L13;
        List r2 = r0.getMessageList();
        if (r2 == null) goto L13;
        Iterator r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(((ic8.v) r4).a().getMessageId(), r5) == false) goto L8;
        r1 = r4;
    L12:
        r1 = (ic8.v) r1;
    L13:
        if (r1 == null) goto L15;
        return true;
    L15:
        return false;
    }

    public final int L2(String r5) {
        com.larus.bmhome.chat.adapter.i<?> r0 = P2();
        if (r0 == null) goto L13;
        List r1 = r0.getMessageList();
        if (r1 == null) goto L16;
        Iterator r2 = r1.iterator();
        int r3 = 0;
    L8:
        if (r2.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((ic8.v) r2.next()).a().getMessageId(), r5) == true) goto L17;
        r3 = r3 + 1;
        goto L8
    L17:
        return r3;
    L18:
        return -1;
    L16:
        return -1;
    L13:
        return -1;
    }

    public final void vC(String r12) {
        Intrinsics.checkNotNullParameter(r12, "targetMsgId");
        FLogger.a.i("ObricChatListComponent", "scrollToMessageAlignBottom: targetMsgId[" + r12 + "], highlight[true], marginBottom[0]");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricChatListComponent$scrollToMessageAlignBottom$1(this, r12, 0, true, null), 3, null);
    }

    public final Object Dp(String r11, Continuation<? super Boolean> r12) {
        if ((r12 instanceof ObricChatListComponent$canShowOnLockedScreen$1) == false) goto L7;
        ObricChatListComponent$canShowOnLockedScreen$1 r0 = (ObricChatListComponent$canShowOnLockedScreen$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r7 = true;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        Message r14 = (Message) r0.L$1;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L41:
        Message r15 = (Message) r13;
        if (r15 != null) goto L45;
        FLogger.a.w("ObricChatListComponent", "canShowOnLockedScreen: replyId[" + r14.getReplyId() + "] not found");
        return Boxing.boxBoolean(false);
    L45:
        long r5 = IKeyguardStateKt.getKeyguardState().getKeyguardLockTime();
        if (r15.getCreateTime() < r5) goto L57;
        if (com.larus.bmhome.chat.bean.d.G0(r15) == false) goto L55;
        Map r16 = r15.getExt();
        if (r16 == null) goto L52;
        String r17 = (String) r16.get("keyguard_lock_time");
    L53:
        r7 = Intrinsics.areEqual(r17, String.valueOf(r5));
        goto L55
    L52:
        r17 = null;
    L55:
        return Boxing.boxBoolean(r7);
    L57:
        return Boxing.boxBoolean(false);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L28:
        r15 = (Message) r13;
        if (r15 != null) goto L31;
        FLogger.a.i("ObricChatListComponent", "canShowOnLockedScreen: msgId[" + r11 + "] not found");
        return Boxing.boxBoolean(false);
    L31:
        if (com.larus.utils.o0.d(r15.getReplyId()) == false) goto L45;
        if (Intrinsics.areEqual(r15.getReplyId(), "0") == true) goto L45;
        String r6 = r15.getReplyId();
        if (r6 != null) goto L37;
        r6 = "";
    L37:
        r0.L$0 = r11;
        r0.L$1 = r15;
        r0.label = 2;
        Object r18 = F2(r6, r0);
        if (r18 != r2) goto L40;
        return r2;
    L40:
        r13 = r18;
        r14 = r15;
        goto L41
    L16:
        ResultKt.throwOnFailure(r13);
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == true) goto L19;
    L21:
        boolean r19 = false;
    L22:
        if (r19 == true) goto L25;
        FLogger.a.i("ObricChatListComponent", "canShowOnLockedScreen: not need cut message");
        return Boxing.boxBoolean(true);
    L25:
        r0.L$0 = r11;
        r0.label = 1;
        r13 = F2(r11, r0);
        if (r13 != r2) goto L28;
        return r2;
    L19:
        if (((Boolean) SessionAuthenticationServiceDelegate.b.o().getValue()).booleanValue() == true) goto L21;
        r19 = true;
    L7:
        r0 = new ObricChatListComponent$canShowOnLockedScreen$1(this, r12);
        goto L8
    }

    public final Object F2(String r5, Continuation<? super Message> r6) {
        MessageAdapter r0 = P2();
        if (r0 == null) goto L16;
        List r1 = r0.z2();
        if (r1 == null) goto L16;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((ic8.v) r3).a().getMessageId(), r5) == false) goto L8;
    L13:
        ic8.v r4 = (ic8.v) r3;
        if (r4 == null) goto L16;
        Message r7 = r4.a();
    L17:
        if (r7 == null) goto L19;
        return r7;
    L19:
        IChatRepoService r8 = (IChatRepoService) ServiceManager.get().getService(IChatRepoService.class);
        if (r8 != null) goto L22;
        return null;
    L22:
        return r8.E1(r5, r6);
    L12:
        r3 = null;
    L16:
        r7 = null;
        goto L17
    }
}
