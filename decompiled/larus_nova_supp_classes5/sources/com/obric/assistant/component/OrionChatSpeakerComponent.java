package com.obric.assistant.component;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.reference.a;
import com.larus.common_ui.widget.input.AudioVisualizerOpt;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import va8.m;
import va8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000É\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001M\u0018\u0000 s2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001sB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010O\u001a\u00020PH\u0016J\b\u0010Q\u001a\u00020PH\u0016J\b\u0010R\u001a\u00020FH\u0016J\b\u0010S\u001a\u00020FH\u0016J\b\u0010T\u001a\u00020FH\u0016J\b\u0010U\u001a\u00020FH\u0016J\b\u0010V\u001a\u00020FH\u0016J\u0014\u0010W\u001a\u0004\u0018\u00010X2\b\u0010Y\u001a\u0004\u0018\u00010XH\u0016J\u0010\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020[H\u0016J\b\u0010]\u001a\u00020[H\u0016J\b\u0010^\u001a\u00020\u0003H\u0016J\u0012\u0010_\u001a\u00020P2\b\u0010`\u001a\u0004\u0018\u00010>H\u0016J\u001a\u0010b\u001a\u00020P2\b\u0010`\u001a\u0004\u0018\u00010>2\u0006\u0010\\\u001a\u00020[H\u0016J\u0010\u0010c\u001a\u00020P2\u0006\u0010d\u001a\u00020[H\u0016J\u001e\u0010e\u001a\u00020P2\u0006\u0010f\u001a\u00020g2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020P0iH\u0002J\b\u0010j\u001a\u00020[H\u0002J\b\u0010k\u001a\u00020[H\u0002J#\u0010l\u001a\u0004\u0018\u00010[2\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020o0nH\u0016¢\u0006\u0002\u0010pJ\u001e\u0010q\u001a\u00020P2\u0014\u0010m\u001a\u0010\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020o\u0018\u00010nH\u0016J\b\u0010r\u001a\u00020[H\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u000b\u001a\u0004\b1\u00102R\u001d\u00104\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u000b\u001a\u0004\b6\u00107R\u0016\u00109\u001a\u0004\u0018\u00010:8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010=\u001a\u0004\u0018\u00010>8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0016\u0010A\u001a\u0004\u0018\u00010B8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u000e\u0010E\u001a\u00020FX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0004\n\u0002\u0010NR\u000e\u0010a\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006t"}, d2 = {"Lcom/obric/assistant/component/OrionChatSpeakerComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/ability/audio/IChatSpeakerExtraAbility;", "Lcom/obric/assistant/ability/audio/ChatSpeakerResCallback;", "<init>", "()V", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "Lkotlin/Lazy;", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "obricSpecialInputAbility", "Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "getObricSpecialInputAbility", "()Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "obricSpecialInputAbility$delegate", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "chatWindowAbility", "Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "getChatWindowAbility", "()Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "chatWindowAbility$delegate", "refMessageAbility", "Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "getRefMessageAbility", "()Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "refMessageAbility$delegate", "clickTalkAbility", "Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "getClickTalkAbility", "()Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "clickTalkAbility$delegate", "intercomAbility", "Lcom/obric/assistant/ability/IObricIntercomAbility;", "getIntercomAbility", "()Lcom/obric/assistant/ability/IObricIntercomAbility;", "intercomAbility$delegate", "chatInputUiCoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUiCoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUiCoreAbility$delegate", "inputUiContract", "Lcom/larus/bmhome/ability/ChatInputUiContract;", "getInputUiContract", "()Lcom/larus/bmhome/ability/ChatInputUiContract;", "voiceVisualizerContainer", "Landroid/view/ViewGroup;", "getVoiceVisualizerContainer", "()Landroid/view/ViewGroup;", "canvasInputText", "Landroid/widget/TextView;", "getCanvasInputText", "()Landroid/widget/TextView;", "cancelColor", "", "colors", "", "darkColors", "positions", "", "textWatcher", "com/obric/assistant/component/OrionChatSpeakerComponent$textWatcher$1", "Lcom/obric/assistant/component/OrionChatSpeakerComponent$textWatcher$1;", "onParentViewCreated", "", "onDestroy", "getShadowRes", "getNormalRes", "getCancelRes", "getTipsColor", "getTipsCancelColor", "getNormalTips", "", "tips", "isHideTips", "", "toCancel", "enableShowAudioAnim", "getResCallback", "initVisualizer", "visualizerContainer", "isGradientApplied", "onSwitchStatus", "onVisibilityChanged", "isVisible", "delayUpdateAudioVisualizerGradient", "audioVisualizerOpt", "Landroid/view/View;", "gradientFunc", "Lkotlin/Function0;", "isInstructionOpen", "isInstructionEditorShorterThanShadow", "shouldCancel", "xy", "Lkotlin/Pair;", "", "(Lkotlin/Pair;)Ljava/lang/Boolean;", "updateTouchPosition", "isWindowEnable", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OrionChatSpeakerComponent extends ComponentFeature implements maa.f, maa.b {
    public static final /* synthetic */ int x = 0;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final int r;
    public final int[] s;
    public final int[] t;
    public final float[] u;
    public final l v;
    public boolean w;

    public static final class b implements Function0<o> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(o.class));
        }
    }

    public static final class c implements Function0<laa.d> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.d.class));
        }
    }

    public static final class d implements Function0<com.larus.bmhome.instruction.g> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
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

    public static final class e implements Function0<laa.j> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.j.class));
        }
    }

    public static final class f implements Function0<m> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(m.class));
        }
    }

    public static final class g implements Function0<g1> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(g1.class));
        }
    }

    public static final class h implements Function0<laa.m> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.m.class));
        }
    }

    public static final class i implements Function0<a> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(a.class));
        }
    }

    public static final class j implements Function0<maa.e> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(maa.e.class));
        }
    }

    public static final class k implements Function0<laa.f> {
        public final /* synthetic */ AttachReceiver a;

        public k(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.f.class));
        }
    }

    static {
    }

    public final maa.b nc() {
        return this;
    }

    public final void B2() {
        o r0 = (o) this.q.getValue();
        TextView r1 = null;
        if (r0 == null) goto L5;
        com.larus.bmhome.chat.component.bottom.core.a r2 = r0.Uv();
    L6:
        if (r2 == null) goto L8;
        ViewGroup r3 = r2.K();
    L9:
        if (r3 == null) goto L12;
        r3.setBackgroundResource(2131232046);
    L12:
        if (Intrinsics.areEqual(s1a.a.getActivity(this).getClass().getSimpleName(), "CreationCanvasActivity") == false) goto L22;
        o r4 = (o) this.q.getValue();
        if (r4 == null) goto L16;
        com.larus.bmhome.chat.component.bottom.core.a r5 = r4.Uv();
    L17:
        if (r5 == null) goto L19;
        r1 = r5.b();
    L19:
        if (r1 == null) goto L23;
        r1.addTextChangedListener(this.v);
        return;
    L23:
        return;
    L16:
        r5 = null;
        goto L17
    L22:
        return;
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public final laa.d F2() {
        return (laa.d) this.h.getValue();
    }

    public final boolean z0() {
        com.larus.bmhome.instruction.g r0 = (com.larus.bmhome.instruction.g) this.i.getValue();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.z0() != true) goto L7;
        return true;
    }

    public OrionChatSpeakerComponent() {
        this.h = LazyKt.lazy(new c(this));
        this.i = LazyKt.lazy(new d(this));
        this.j = LazyKt.lazy(new e(this));
        this.k = LazyKt.lazy(new f(this));
        this.l = LazyKt.lazy(new g(this));
        this.m = LazyKt.lazy(new h(this));
        this.n = LazyKt.lazy(new i(this));
        this.o = LazyKt.lazy(new j(this));
        this.p = LazyKt.lazy(new k(this));
        this.q = LazyKt.lazy(new b(this));
        this.r = -42663;
        this.s = new int[]{-13146369, -35979, -19867};
        this.t = new int[]{-8282369, -25956, -15222};
        this.u = new float[]{0.38f, 0.74f, 1.0f};
        this.v = new l(this);
    }

    public final boolean B0() {
        return !iC();
    }

    public final int T0() {
        boolean r0 = z0();
        g1 r1 = (g1) this.l.getValue();
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        laa.d r4 = F2();
        if (r4 != null) goto L11;
    L13:
        if (r2 == false) goto L19;
        if (r0 == true) goto L18;
        if (r3 == true) goto L18;
        return 2131232046;
    L18:
        return 2131232047;
    L19:
        if (r0 == true) goto L23;
        if (r3 == true) goto L23;
        return 2131232048;
    L23:
        return 2131232049;
    L11:
        if (r4.aF() != true) goto L13;
        r2 = true;
        goto L13
    L5:
        if (r1.isVisible() != true) goto L7;
        r3 = true;
        goto L8
    }

    public final int Z1() {
        laa.d r0 = F2();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        boolean r3 = z0();
        g1 r4 = (g1) this.l.getValue();
        if (r4 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        laa.d r6 = F2();
        if (r6 != null) goto L17;
    L19:
        boolean r7 = false;
    L20:
        if (r3 == false) goto L44;
        com.larus.bmhome.instruction.g r8 = (com.larus.bmhome.instruction.g) this.i.getValue();
        if (r8 == null) goto L41;
        ViewGroup r9 = r8.jy();
        if (r9 == null) goto L41;
        Integer r10 = Integer.valueOf(r9.getHeight());
        if (r10.intValue() <= 0) goto L29;
        boolean r11 = true;
    L30:
        if (r11 == true) goto L33;
        r10 = null;
    L33:
        if (r10 == null) goto L35;
        int r12 = r10.intValue();
    L36:
        if (r12 <= 0) goto L41;
        if (r12 >= v19.i5.i()) goto L41;
        boolean r13 = true;
    L42:
        if (r13 == false) goto L44;
        boolean r14 = true;
    L45:
        a r15 = (a) this.n.getValue();
        if (r15 != null) goto L48;
    L50:
        boolean r16 = false;
    L51:
        if (r3 == true) goto L54;
        if (r16 == true) goto L54;
        if (r5 == true) goto L54;
    L55:
        if (r2 == false) goto L61;
        if (r1 == false) goto L63;
        if (r14 == true) goto L60;
        return 2131232155;
    L60:
        return 2131232159;
    L63:
        return 2131232087;
    L61:
        if (r7 == false) goto L64;
        if (r1 == false) goto L63;
    L64:
        if (r7 == false) goto L68;
        if (r14 == true) goto L67;
        return 2131232156;
    L67:
        return 2131232158;
    L68:
        boolean r17 = v19.h.a;
        if (v19.h.b(getContext()) == false) goto L71;
        return 2131239705;
    L71:
        return 2131239703;
    L54:
        r1 = true;
        goto L55
    L48:
        if (r15.Qj() != true) goto L50;
        r16 = true;
        goto L51
    L35:
        r12 = r9.getMeasuredHeight();
        goto L36
    L29:
        r11 = false;
    L41:
        r13 = false;
    L44:
        r14 = false;
        goto L45
    L17:
        if (r6.Da() != true) goto L19;
        r7 = true;
        goto L20
    L11:
        if (r4.isVisible() != true) goto L13;
        r5 = true;
        goto L14
    L5:
        if (r0.aF() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final int g1() {
        laa.d r0 = F2();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        boolean r3 = z0();
        g1 r4 = (g1) this.l.getValue();
        if (r4 != null) goto L11;
    L13:
        if (r2 == false) goto L18;
        if (r3 == true) goto L18;
        if (r1 == true) goto L18;
        return ColorProtector.parseColor("#B2FFFFFF");
    L18:
        return ContextCompat.getColor(getContext(), 2131103684);
    L11:
        if (r4.isVisible() != true) goto L13;
        r1 = true;
        goto L13
    L5:
        if (r0.aF() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final boolean iC() {
        IAssistantChatWindow r0 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isWindowMode() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final int k0() {
        boolean r0 = z0();
        g1 r1 = (g1) this.l.getValue();
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        laa.d r4 = F2();
        if (r4 != null) goto L11;
    L13:
        if (r2 == false) goto L19;
        if (r0 == true) goto L18;
        if (r3 == true) goto L18;
        return 2131232050;
    L18:
        return 2131232051;
    L19:
        if (r0 == true) goto L23;
        if (r3 == true) goto L23;
        return 2131232052;
    L23:
        return 2131232053;
    L11:
        if (r4.aF() != true) goto L13;
        r2 = true;
        goto L13
    L5:
        if (r1.isVisible() != true) goto L7;
        r3 = true;
        goto L8
    }

    public final void onDestroy() {
        if (Intrinsics.areEqual(s1a.a.getActivity(this).getClass().getSimpleName(), "CreationCanvasActivity") == false) goto L13;
        o r0 = (o) this.q.getValue();
        TextView r1 = null;
        if (r0 == null) goto L7;
        com.larus.bmhome.chat.component.bottom.core.a r2 = r0.Uv();
    L8:
        if (r2 == null) goto L10;
        r1 = r2.b();
    L10:
        if (r1 == null) goto L14;
        r1.removeTextChangedListener(this.v);
        return;
    L14:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final int v0() {
        laa.d r0 = F2();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        boolean r3 = z0();
        g1 r4 = (g1) this.l.getValue();
        if (r4 != null) goto L11;
    L13:
        if (r2 == false) goto L20;
        if (r3 == true) goto L18;
        if (r1 == true) goto L18;
        String r5 = "#B2FFFFFF";
    L25:
        return ColorProtector.parseColor(r5);
    L18:
        r5 = "#FFFF3B30";
        goto L25
    L20:
        boolean r6 = v19.h.a;
        if (v19.h.b(getContext()) == false) goto L24;
        return ContextCompat.getColor(getContext(), 2131103684);
    L24:
        return ColorProtector.parseColor("#7f060015");
    L11:
        if (r4.isVisible() != true) goto L13;
        r1 = true;
        goto L13
    L5:
        if (r0.aF() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final Boolean I4(Pair<Float, Float> r2) {
        Intrinsics.checkNotNullParameter(r2, "xy");
        laa.f r0 = (laa.f) this.p.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.I4(r2);
    }

    public final void J0(ViewGroup r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getChildCount() != 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        return;
    L9:
        AudioVisualizerOpt r4 = r3.getChildAt(0);
        if ((r4 instanceof AudioVisualizerOpt) == false) goto L12;
        AudioVisualizerOpt r5 = r4;
    L13:
        if (r5 == null) goto L17;
        r5.setCustomWaveGroupCount(5);
        return;
    L17:
        return;
    L12:
        r5 = null;
        goto L13
    L6:
        r0 = false;
        goto L7
    }

    public final boolean X0(boolean r3) {
        if (iC() == false) goto L6;
        return true;
    L6:
        if (r3 == true) goto L15;
        laa.j r4 = (laa.j) this.j.getValue();
        if (r4 != null) goto L10;
    L12:
        boolean r5 = false;
    L13:
        if (r5 == false) goto L15;
        return true;
    L10:
        if (r4.Re() != true) goto L12;
        r5 = true;
    L15:
        return false;
    }

    public final String Z(String r3) {
        if (Intrinsics.areEqual(ObricInteractDelegate.b.isAiKeyLongPress(), Boolean.TRUE) == true) goto L8;
        if (r3 == null) goto L7;
        return r3;
    L7:
        return getContext().getString(2131906286);
    L8:
        return getContext().getString(2131912177);
    }

    public final void ga(Pair<Float, Float> r2) {
        if (s1a.a.d(this) == false) goto L8;
        laa.f r0 = (laa.f) this.p.getValue();
        if (r0 == null) goto L9;
        r0.ga(r2);
        return;
    L9:
        return;
    }

    public final void l(boolean r2) {
        laa.m r0 = (laa.m) this.m.getValue();
        if (r0 == null) goto L6;
        r0.v00(r2);
        return;
    }

    public final void r0(ViewGroup r5, boolean r6) {
        laa.m r0 = (laa.m) this.m.getValue();
        if (r0 == null) goto L5;
        r0.N60(r6);
    L5:
        if (r5 != null) goto L7;
        return;
    L7:
        if (r5.getChildCount() != 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return;
    L12:
        AudioVisualizerOpt r7 = r5.getChildAt(0);
        if ((r7 instanceof AudioVisualizerOpt) == false) goto L15;
        AudioVisualizerOpt r8 = r7;
    L16:
        if (r8 == null) goto L27;
        if (r6 == false) goto L19;
        r8.getPaint().setShader(null);
        r8.getPaint().setColor(this.r);
        return;
    L19:
        y4 r9 = new y4(r8, r8, this);
        if (r8.getWidth() <= 0) goto L23;
        r9.invoke();
        return;
    L23:
        if (this.w == true) goto L30;
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        View.OnAttachStateChangeListener r3 = new a5(r2, this);
        r2.element = new z4(r8, r9, r3, this);
        r8.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) r2.element);
        r8.addOnAttachStateChangeListener(r3);
        this.w = true;
        return;
    L30:
        return;
    L27:
        return;
    L15:
        r8 = null;
        goto L16
    L9:
        r1 = false;
        goto L10
    }
}
