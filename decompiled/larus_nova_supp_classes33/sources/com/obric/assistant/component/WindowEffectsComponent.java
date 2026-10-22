package com.obric.assistant.component;

import android.os.Handler;
import android.os.Looper;
import com.larus.im.bean.message.Message;
import com.larus.im.observer.MessageListState;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.IWindowEffectsKt;
import com.obric.assistant.interaction.api.WeakUpState;
import com.obric.assistant.interaction.base.interact.IObserveToken;
import com.obric.assistant.interaction.base.model.AssistantActivityExpandState;
import com.obric.assistant.spi.window.WindowOpenSource;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0002+8\u0018\u0000 >2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002>?B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u001e\u001a\u00020\u0018H\u0016J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0018H\u0016J\b\u0010#\u001a\u00020\u0018H\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\b\u0010%\u001a\u00020\u0018H\u0016J\b\u0010&\u001a\u00020\u0018H\u0016J\u0018\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\bH\u0016J\u0012\u0010-\u001a\u00020\u00182\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\u0010\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u00020\nH\u0002J\u001e\u00102\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020\b2\n\b\u0002\u00103\u001a\u0004\u0018\u000104H\u0002J\u0010\u00105\u001a\u00020\u00182\u0006\u00103\u001a\u000204H\u0002J\b\u00106\u001a\u00020\u0018H\u0002J\b\u0010<\u001a\u00020\u0018H\u0002J\b\u0010=\u001a\u00020\bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0004\n\u0002\u0010,R\u001b\u00107\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u000f\u001a\u0004\b9\u0010:¨\u0006@"}, d2 = {"Lcom/obric/assistant/component/WindowEffectsComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/interaction/base/interact/IObserveToken;", "Lcom/obric/assistant/ability/IObricWindowEffectAbility;", "Lcom/obric/assistant/spi/window/WindowLifecycleListener;", "<init>", "()V", "isShowingEffect", "", "latestSendingMessage", "Lcom/obric/assistant/component/WindowEffectsComponent$MessageInfo;", "curWaitingMessageInfo", "isWindowContext", "()Z", "isWindowContext$delegate", "Lkotlin/Lazy;", "assistantChatWindow", "Lcom/obric/assistant/interaction/api/IAssistantChatWindow;", "getAssistantChatWindow", "()Lcom/obric/assistant/interaction/api/IAssistantChatWindow;", "assistantChatWindow$delegate", "chatWindowStateCallback", "Lkotlin/Function1;", "Lcom/obric/assistant/interaction/base/model/AssistantActivityExpandState;", "", "handler", "Landroid/os/Handler;", "preShowEffectTimeout", "Ljava/lang/Runnable;", "waitResponseTimeoutRunnable", "onCreate", "onWindowOpened", "source", "Lcom/obric/assistant/spi/window/WindowOpenSource;", "onWindowStashed", "onStart", "onStop", "onParentViewCreated", "onDestroy", "preShowActivateEffect", "ignoreWindowState", "isAudioWeakUp", "chatSpeakerStateListener", "com/obric/assistant/component/WindowEffectsComponent$chatSpeakerStateListener$1", "Lcom/obric/assistant/component/WindowEffectsComponent$chatSpeakerStateListener$1;", "handleStateChange", "state", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/ChatSpeakerState;", "waitHideActivateEffect", "waitingMsg", "showActivateEffect", "weakUpState", "Lcom/obric/assistant/interaction/api/WeakUpState;", "playWindowRippleEffect", "hideActivateEffect", "onMessageChangedObserver", "com/obric/assistant/component/WindowEffectsComponent$onMessageChangedObserver$2$1", "getOnMessageChangedObserver", "()Lcom/obric/assistant/component/WindowEffectsComponent$onMessageChangedObserver$2$1;", "onMessageChangedObserver$delegate", "onSendFailedOrReplied", "isChatWindow", "Companion", "MessageInfo", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowEffectsComponent extends ComponentFeature implements IObserveToken, laa.l, wga.b {
    public static final /* synthetic */ int s = 0;
    public boolean h;
    public b i;
    public b j;
    public final Lazy k;
    public final Lazy l;
    public final n7 m;
    public final Handler n;
    public final o7 o;
    public final p7 p;
    public final d q;
    public final Lazy r;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public final int c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return ((r3 + r1) * 31) + this.c;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "MessageInfo(localMessageId=" + this.a + ", messageId=" + this.b + ", statusLocal=" + this.c + ')';
        }

        public b(String r1, String r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AssistantActivityExpandState.values().length];
            r0[AssistantActivityExpandState.CHAT_WINDOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AssistantActivityExpandState.INVISIBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class d implements com.larus.bmhome.chat.component.bottom.core.speaker.h {
        public final /* synthetic */ WindowEffectsComponent a;

        public d(WindowEffectsComponent r1) {
            this.a = r1;
        }

        public final void a(com.larus.bmhome.chat.component.bottom.core.speaker.g r3) {
            Intrinsics.checkNotNullParameter(r3, "state");
            WindowEffectsComponent r0 = this.a;
            int r1 = WindowEffectsComponent.s;
            r0.F2(r3);
        }
    }

    public static final class e implements nf9.b {
        public final /* synthetic */ WindowEffectsComponent a;

        public final void b(String r2, MessageListState r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "state");
            Intrinsics.checkNotNullParameter(r4, "msgList");
        }

        public final void d(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
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

        public e(WindowEffectsComponent r1) {
            this.a = r1;
        }

        public final void a(String r3, Message r4) {
            Intrinsics.checkNotNullParameter(r3, "cid");
            Intrinsics.checkNotNullParameter(r4, "msg");
            FLogger.a.i("WindowEffectsComponent", "onSendMessage: " + r4);
            g(true, r4);
        }

        public final void g(boolean r7, Message r8) {
            if (r7 == false) goto L42;
            b r9 = this.a.j;
            if (r9 != null) goto L7;
        L13:
            int r10 = r8.getMessageStatusLocal();
            if (r10 != 0) goto L16;
            this.a.i = new b(r8.getLocalMessageId(), r8.getMessageId(), r8.getMessageStatusLocal());
            goto L42
        L16:
            if (r10 != 10) goto L18;
            b r11 = new b(r8.getLocalMessageId(), r8.getMessageId(), r8.getMessageStatusLocal());
            WindowEffectsComponent r2 = this.a;
            r2.i = r11;
            boolean r3 = false;
            if (r2.aF() == true) goto L24;
        L28:
            b r4 = this.a.j;
            if (r4 != null) goto L31;
        L33:
            if (r3 == false) goto L42;
            if (r4 == null) goto L36;
            String r5 = r4.a;
        L38:
            if (Intrinsics.areEqual(r5, r8.getLocalMessageId()) == true) goto L42;
            FLogger.a.i("WindowEffectsComponent", "waiting msg is change to " + r11);
            this.a.j = r11;
            goto L42
        L36:
            r5 = null;
            goto L38
        L31:
            if (r4.c != 0) goto L33;
            r3 = true;
            goto L33
        L24:
            if (this.a.h == true) goto L28;
            FLogger.a.i("WindowEffectsComponent", "show effect for text send mode");
            WindowEffectsComponent r6 = this.a;
            r6.n.removeCallbacks(r6.o);
            if (this.a.N2() == true) goto L42;
            this.a.P2(false, null);
            this.a.U2(r11);
            goto L42
        L18:
            if (r10 != 11) goto L42;
            this.a.i = null;
            goto L42
        L7:
            if (Intrinsics.areEqual(r9.a, r8.getLocalMessageId()) == false) goto L13;
            WindowEffectsComponent r12 = this.a;
            b r13 = r12.j;
            if (r13 == null) goto L11;
            b r14 = new b(r13.a, r8.getMessageId(), r8.getMessageStatusLocal());
        L12:
            r12.j = r14;
            goto L13
        L11:
            r14 = null;
        L42:
            switch(r8.getMessageStatusLocal()) {
                case 12: goto L44;
                case 13: goto L44;
                case 14: goto L44;
                default: goto L43;
            };
        L43:
            WindowEffectsComponent r15 = this.a;
            b r16 = r15.j;
            if (r16 != null) goto L57;
            return;
        L57:
            if (com.larus.utils.o0.d(r16.b) == false) goto L64;
            if (com.larus.utils.o0.d(r8.getReplyId()) == false) goto L64;
            if (Intrinsics.areEqual(r16.b, r8.getReplyId()) == false) goto L64;
            FLogger.a.i("WindowEffectsComponent", "got response: " + r8);
            r15.j = null;
            r15.L2();
            return;
        L64:
            if (Intrinsics.areEqual(r16.a, r8.getLocalMessageId()) == false) goto L78;
            Map r17 = r8.getBusinessExt();
            if (r17 == null) goto L68;
            String r18 = (String) r17.get("send_loading");
        L70:
            if (Intrinsics.areEqual(r18, "0") == false) goto L79;
            FLogger.a.i("WindowEffectsComponent", "send msg is not send loading");
            r15.j = null;
            r15.L2();
            return;
        L79:
            return;
        L68:
            r18 = null;
            goto L70
        L78:
            return;
        L44:
            b r19 = this.a.i;
            if (r19 != null) goto L47;
        L49:
            b r20 = this.a.j;
            if (r20 != null) goto L52;
            return;
        L52:
            if (Intrinsics.areEqual(r20.a, r8.getLocalMessageId()) == false) goto L74;
            FLogger.a.i("WindowEffectsComponent", "send failed: " + r8);
            WindowEffectsComponent r21 = this.a;
            r21.j = null;
            r21.L2();
            return;
        L74:
            return;
        L47:
            if (Intrinsics.areEqual(r19.a, r8.getLocalMessageId()) == false) goto L49;
            this.a.i = null;
            goto L49
        }

        public final void c(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
            g(false, r2);
        }

        public final void e(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
            g(false, r2);
        }
    }

    static {
    }

    public final void onScreenRotationChanged(int r1, int r2) {
    }

    public final void onWindowDismissed() {
    }

    public final void onWindowPreDismissed() {
    }

    public final void onWindowPreOpenClear() {
    }

    public final void onWindowPreStashed() {
    }

    public final void B2() {
        FLogger r0 = FLogger.a;
        r0.i("WindowEffectsComponent", "onParentViewCreated");
        com.larus.bmhome.chat.component.bottom.core.speaker.m r1 = s1a.d.a(this).getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.m.class);
        if (r1 == null) goto L5;
        F2(r1.J5());
    L6:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r2 = s1a.d.a(this).getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r2 == null) goto L9;
        r2.e8(this.q);
        return;
    L9:
        r0.w("WindowEffectsComponent", "chatBottomSpeakerAbility is null");
        return;
    L5:
        r0.w("WindowEffectsComponent", "chatBottomSpeakerAbility is null");
        goto L6
    }

    public final void L2() {
        if (this.h == true) goto L5;
        return;
    L5:
        FLogger.a.i("WindowEffectsComponent", "hideActivateEffect");
        this.h = false;
        this.j = null;
        this.n.removeCallbacks(this.p);
        this.n.removeCallbacks(this.o);
        IWindowEffectsKt.getWindowEffects().stopActivateEffect();
    }

    public final boolean N2() {
        return ((Boolean) this.k.getValue()).booleanValue();
    }

    public final void onCreate() {
        FLogger r0 = FLogger.a;
        r0.i("WindowEffectsComponent", "onCreate: isWindowContext = " + N2());
        if (N2() == false) goto L7;
        IAssistantChatWindow r1 = (IAssistantChatWindow) this.l.getValue();
        if (r1 == null) goto L7;
        r1.addWindowLifecycleListener(this);
    L7:
        com.larus.im.d.e().registerOnGlobalMessageObserver((e) this.r.getValue());
        IAssistantInteractionServiceKt.getInteractionStateService().observeInteractionActivityExpandState(this, this.m);
        if (N2() == true) goto L13;
        WeakUpState r2 = IWindowEffectsKt.getWindowEffects().getValidWakeUpState();
        if (r2 == null) goto L14;
        r0.i("WindowEffectsComponent", "canPreShowActivateEffect");
        qw(true, r2.isAudioWeakUp());
        return;
    L14:
        return;
    }

    public final void onDestroy() {
        FLogger.a.i("WindowEffectsComponent", "onDestroy");
        if (N2() == false) goto L7;
        IAssistantChatWindow r0 = (IAssistantChatWindow) this.l.getValue();
        if (r0 == null) goto L7;
        r0.removeWindowLifecycleListener(this);
    L7:
        com.larus.im.d.e().unregisterOnGlobalMessageObserver((e) this.r.getValue());
        IAssistantInteractionServiceKt.getInteractionStateService().unObserveInteractionActivityExpandState(this);
        L2();
    }

    public final void onStart() {
        FLogger.a.i("WindowEffectsComponent", "onStart");
    }

    public final void onStop() {
        FLogger.a.i("WindowEffectsComponent", "onStop");
        L2();
    }

    public final void onWindowStashed() {
        FLogger.a.i("WindowEffectsComponent", "onWindowStashed");
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.assistant.component.n7] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.assistant.component.o7] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.obric.assistant.component.p7] */
    public WindowEffectsComponent() {
        this.k = LazyKt.lazy(new l7(this));
        this.l = LazyKt.lazy(new m7());
        this.m = new n7(this);
        this.n = new Handler(Looper.getMainLooper());
        this.o = new o7(this);
        this.p = new p7(this);
        this.q = new d(this);
        this.r = LazyKt.lazy(new q7(this));
    }

    public final boolean aF() {
        if (IAssistantInteractionServiceKt.getInteractionStateService().getInteractionActivityExpandState() != AssistantActivityExpandState.CHAT_WINDOW) goto L5;
        return true;
    L5:
        return false;
    }

    public final void F2(com.larus.bmhome.chat.component.bottom.core.speaker.g r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r3, com.larus.bmhome.chat.component.bottom.core.speaker.g.c.a) == false) goto L17;
        FLogger.a.i("WindowEffectsComponent", "handleStateChange Started");
        b r4 = this.i;
        if (r4 == null) goto L9;
        String r5 = r4.b;
    L11:
        if (com.larus.utils.o0.d(r5) == false) goto L13;
        this.i = null;
    L13:
        this.j = null;
        this.n.removeCallbacks(this.o);
        if (N2() == true) goto L35;
        P2(false, IWindowEffectsKt.getWindowEffects().getValidWakeUpState());
        return;
    L35:
        return;
    L9:
        r5 = null;
        goto L11
    L17:
        if (Intrinsics.areEqual(r3, com.larus.bmhome.chat.component.bottom.core.speaker.g.a.a) == false) goto L19;
    L31:
        FLogger.a.i("WindowEffectsComponent", "handleStateChange Canceled or Failed");
        if (this.j != null) goto L42;
        L2();
        return;
    L42:
        return;
    L19:
        if (Intrinsics.areEqual(r3, com.larus.bmhome.chat.component.bottom.core.speaker.g.b.a) == true) goto L31;
        if ((r3 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.e) == false) goto L37;
        FLogger.a.i("WindowEffectsComponent", "handleStateChange Success");
        if (aF() == false) goto L38;
        b r6 = this.i;
        if (r6 != null) goto L28;
        return;
    L28:
        if (r6.c == 0) goto L30;
        L2();
        return;
    L30:
        U2(r6);
        return;
    L38:
        return;
    }

    public final void U2(b r4) {
        FLogger r0 = FLogger.a;
        r0.i("WindowEffectsComponent", "waitHideActivateEffect");
        if (this.h == true) goto L6;
        r0.i("WindowEffectsComponent", "is not showing effect, will not wait");
        return;
    L6:
        this.j = r4;
        this.n.removeCallbacks(this.p);
        this.n.postDelayed(this.p, 20000);
    }

    public final void onWindowOpened(WindowOpenSource r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        FLogger r0 = FLogger.a;
        r0.i("WindowEffectsComponent", "onWindowOpened, source = " + r4);
        WeakUpState r5 = IWindowEffectsKt.getWindowEffects().getValidWakeUpState();
        if (r5 == null) goto L6;
        r0.i("WindowEffectsComponent", "canPreShowActivateEffect");
        qw(true, r5.isAudioWeakUp());
        return;
    }

    public final void onWindowPreOpened(WindowOpenSource r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    public final void P2(boolean r6, WeakUpState r7) {
        if (this.h == false) goto L6;
        FLogger.a.i("WindowEffectsComponent", "showActivateEffect: is showing effect, ignore");
        return;
    L6:
        FLogger r0 = FLogger.a;
        r0.i("WindowEffectsComponent", "showActivateEffect: ignoreWindowState = " + r6);
        if (r6 == false) goto L9;
    L12:
        this.n.removeCallbacks(this.p);
        boolean r8 = false;
        if (r7 != null) goto L15;
    L22:
        boolean r3 = false;
    L23:
        if (r7 != null) goto L25;
    L27:
        if (r8 == true) goto L29;
    L31:
        this.h = true;
        IWindowEffectsKt.getWindowEffects().startActivateEffect(r3);
        return;
    L29:
        if (r7.isUiRenderedByChildProcess() == false) goto L31;
        r0.i("WindowEffectsComponent", "showActivateEffect: child process renders current UI, ignore ripple");
        goto L31
    L25:
        if (r7.isAudioWeakUp() != true) goto L27;
        r8 = true;
        goto L27
    L15:
        if (r7.isAudioWeakUp() == true) goto L17;
    L19:
        boolean r4 = false;
    L20:
        if (r4 != true) goto L22;
        r3 = true;
        goto L23
    L17:
        if (r7.isUiRenderedByChildProcess() == true) goto L19;
        r4 = true;
        goto L20
    L9:
        if (aF() == true) goto L12;
        r0.i("WindowEffectsComponent", "is not chat window, cannot show effects");
    }

    public final void qw(boolean r7, boolean r8) {
        FLogger r0 = FLogger.a;
        r0.i("WindowEffectsComponent", "preShowActivateEffect: ignoreWindowState = " + r7 + ", isAudioWeakUp = " + r8);
        if (r7 == true) goto L9;
        if (aF() == true) goto L9;
        r0.i("WindowEffectsComponent", "preShowActivateEffect: is not chat window, cannot pre show effects");
        return;
    L9:
        if (this.h == false) goto L12;
        r0.i("WindowEffectsComponent", "preShowActivateEffect: is showing effect, ignore");
        return;
    L12:
        this.n.removeCallbacks(this.o);
        this.n.postDelayed(this.o, 2000);
        WeakUpState r1 = IWindowEffectsKt.getWindowEffects().getValidWakeUpState();
        if (r1 != null) goto L15;
    L23:
        r1 = new WeakUpState(r8, false, 2, null);
    L25:
        if (N2() == false) goto L31;
        if (r8 == true) goto L28;
        return;
    L28:
        if (r1.isUiRenderedByChildProcess() == false) goto L30;
        r0.i("WindowEffectsComponent", "playWindowRippleEffect: child process renders current UI, ignore");
        return;
    L30:
        r0.i("WindowEffectsComponent", "playWindowRippleEffect");
        IWindowEffectsKt.getWindowEffects().playRippleEffect();
        return;
    L31:
        P2(r7, r1);
        return;
    L15:
        if (r1.isAudioWeakUp() != r8) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == true) goto L21;
        r1 = null;
    L21:
        if (r1 == null) goto L23;
    L17:
        r5 = false;
        goto L18
    }
}
