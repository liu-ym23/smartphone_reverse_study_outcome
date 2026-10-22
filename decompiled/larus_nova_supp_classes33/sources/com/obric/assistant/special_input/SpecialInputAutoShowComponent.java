package com.obric.assistant.special_input;

import androidx.collection.LruCache;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IKeyguardState;
import com.obric.assistant.interaction.base.interact.IObserveToken;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\b\u0007*\u0001D\u0018\u0000 I2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001IB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020:H\u0016J\b\u0010<\u001a\u00020:H\u0016J\b\u0010=\u001a\u00020:H\u0016J&\u0010>\u001a\u0002022\u0006\u0010?\u001a\u0002022\u0006\u0010@\u001a\u0002022\u0006\u0010A\u001a\u000202H\u0096@¢\u0006\u0002\u0010BJ\b\u0010H\u001a\u00020:H\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b,\u0010-R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020205X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010C\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u000b\u001a\u0004\bE\u0010F¨\u0006J"}, d2 = {"Lcom/obric/assistant/special_input/SpecialInputAutoShowComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/interaction/base/interact/IObserveToken;", "Lcom/obric/assistant/special_input/ability/ISpecialInputAutoShowAbility;", "<init>", "()V", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "Lkotlin/Lazy;", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "bottomMenuAbility", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "getBottomMenuAbility", "()Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "bottomMenuAbility$delegate", "chatBottomSpeakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getChatBottomSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "chatBottomSpeakerAbility$delegate", "obricChatListAbility", "Lcom/obric/assistant/ability/IObricChatListAbility;", "getObricChatListAbility", "()Lcom/obric/assistant/ability/IObricChatListAbility;", "obricChatListAbility$delegate", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "isSpeaking", "", "isPaused", "logedReplyPanelMessageIds", "Landroidx/collection/LruCache;", "", "keyguardState", "Lcom/obric/assistant/interaction/api/IKeyguardState;", "onCreate", "", "onDestroy", "onResume", "onPause", "canAutoShowInputPanel", "allowOnUIPaused", "allowIgnoreInputState", "allowIgnoreSpeakingState", "(ZZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "chatSpeakerStateListener", "com/obric/assistant/special_input/SpecialInputAutoShowComponent$chatSpeakerStateListener$2$1", "getChatSpeakerStateListener", "()Lcom/obric/assistant/special_input/SpecialInputAutoShowComponent$chatSpeakerStateListener$2$1;", "chatSpeakerStateListener$delegate", "monitorAutoShowReplyPanel", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpecialInputAutoShowComponent extends ComponentFeature implements IObserveToken, fga.a {
    public static final /* synthetic */ int v = 0;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final CoroutineScope p;
    public volatile boolean q;
    public volatile boolean r;
    public final LruCache<String, Boolean> s;
    public final IKeyguardState t;
    public final Lazy u;

    public static final class a {
    }

    public static final class b implements com.larus.bmhome.chat.component.bottom.core.speaker.h {
        public final /* synthetic */ SpecialInputAutoShowComponent a;

        public b(SpecialInputAutoShowComponent r1) {
            this.a = r1;
        }

        public final void a(com.larus.bmhome.chat.component.bottom.core.speaker.g r3) {
            Intrinsics.checkNotNullParameter(r3, "state");
            this.a.q = Intrinsics.areEqual(r3, com.larus.bmhome.chat.component.bottom.core.speaker.g.c.a);
            FLogger.a.i("SpecialInputAutoShowComponent", "ChatSpeakerStateListener.onStateChanged: isSpeaking = " + this.a.q);
        }
    }

    public static final class c implements Function0<com.larus.bmhome.chat.component.cvs.y> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.cvs.y.class));
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

    public static final class e implements Function0<va8.o> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.o.class));
        }
    }

    public static final class f implements Function0<com.larus.bmhome.chat.component.bottom.attachment.g1> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.attachment.g1.class));
        }
    }

    public static final class g implements Function0<com.larus.bmhome.instruction.g> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.g.class));
        }
    }

    public static final class h implements Function0<com.larus.bmhome.chat.component.bottom.bottommenu.f1> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.bottommenu.f1.class));
        }
    }

    public static final class i implements Function0<com.larus.bmhome.chat.component.bottom.core.speaker.l> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.core.speaker.l.class));
        }
    }

    public static final class j implements Function0<laa.c> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.c.class));
        }
    }

    static {
    }

    public final void onCreate() {
        FLogger r0 = FLogger.a;
        r0.i("SpecialInputAutoShowComponent", "chatConversationAbility = " + ((com.larus.bmhome.chat.component.cvs.y) this.h.getValue()));
        com.larus.bmhome.chat.component.bottom.core.speaker.l r1 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.n.getValue();
        if (r1 == null) goto L6;
        r1.e8((b) this.u.getValue());
    L6:
        if (((laa.c) this.o.getValue()) != null) goto L8;
        r0.e("SpecialInputAutoShowComponent", "obricChatListAbility is null");
        return;
    L8:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1(this, null), 3, null);
    }

    public final void onDestroy() {
        com.larus.bmhome.chat.component.bottom.core.speaker.l r0 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.n.getValue();
        if (r0 == null) goto L6;
        r0.B9((b) this.u.getValue());
        return;
    }

    public final void onPause() {
        FLogger.a.i("SpecialInputAutoShowComponent", "onPause");
        this.r = true;
    }

    public final void onResume() {
        FLogger.a.i("SpecialInputAutoShowComponent", "onResume");
        this.r = false;
    }

    public SpecialInputAutoShowComponent() {
        this.h = LazyKt.lazy(new c(this));
        this.i = LazyKt.lazy(new d(this));
        this.j = LazyKt.lazy(new e(this));
        this.k = LazyKt.lazy(new f(this));
        this.l = LazyKt.lazy(new g(this));
        this.m = LazyKt.lazy(new h(this));
        this.n = LazyKt.lazy(new i(this));
        this.o = LazyKt.lazy(new j(this));
        this.p = CoroutineScopeKt.MainScope();
        this.r = true;
        this.s = new LruCache(10);
        this.t = (IKeyguardState) ServiceManager.get().getService(IKeyguardState.class);
        this.u = LazyKt.lazy(new u0(this));
    }

    @Override // fga.a
    public final Object w80(boolean r13, boolean r14, boolean r15, Continuation<? super Boolean> r16) {
        FLogger.a.i("SpecialInputAutoShowComponent", "canAutoShowInputPanel: allowOnUIPaused = " + r13 + ", allowIgnoreInputState = " + r14);
        return BuildersKt.async$default(this.p, null, null, new SpecialInputAutoShowComponent$canAutoShowInputPanel$2(this, r13, r15, r14, null), 3, null).await(r16);
    }
}
