package com.larus.uaigc.music.applet;

import android.R;
import android.app.Application;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002 N\u0018\u0000 \u008b\u00012\u00060\u0001j\u0002`\u00022\u00020\u00032\u00020\u0004:\u0002\u008b\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010P\u001a\u00020\u000eH\u0016J\u0010\u0010Q\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020\u001aH\u0016J\b\u0010S\u001a\u00020\u000eH\u0016J\u0016\u0010T\u001a\u00020\u000e2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010V\u001a\u00020\u000eH\u0002J\u0010\u0010W\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020\u001aH\u0002J\b\u0010X\u001a\u00020\u000eH\u0002J\u0010\u0010Y\u001a\u00020\u000e2\u0006\u0010Z\u001a\u00020[H\u0002J\u0010\u0010\\\u001a\u00020\u000e2\u0006\u0010]\u001a\u00020\bH\u0002J\b\u0010^\u001a\u00020\u000eH\u0002J\b\u0010_\u001a\u00020\u000eH\u0002J\b\u0010`\u001a\u00020\u000eH\u0002J\b\u0010a\u001a\u00020\bH\u0002J\b\u0010b\u001a\u00020\u000eH\u0002J\b\u0010c\u001a\u00020\u000eH\u0002J\b\u0010d\u001a\u00020\u000eH\u0002J\"\u0010e\u001a\u00020\u000e2\u000e\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010g\u001a\u0004\u0018\u00010\u0015H\u0016J\n\u0010h\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010i\u001a\u00020\u000e2\u0006\u0010j\u001a\u00020\u001cH\u0002J\u0018\u0010k\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010l\u001a\u00020\u001cH\u0002J\u0013\u0010m\u001a\b\u0012\u0004\u0012\u00020o0nH\u0002¢\u0006\u0002\u0010pJ\b\u0010q\u001a\u00020\u000eH\u0002J\b\u0010r\u001a\u00020\u000eH\u0002J\b\u0010s\u001a\u00020\u000eH\u0002J\b\u0010t\u001a\u00020\u000eH\u0002J\b\u0010u\u001a\u00020\u000eH\u0002J\b\u0010v\u001a\u00020\u000eH\u0002J\n\u0010w\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010x\u001a\u00020\u000eH\u0002J\u0010\u0010y\u001a\u00020\u000e2\u0006\u0010z\u001a\u00020{H\u0002J,\u0010|\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010}2\u0014\u0010~\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010}H\u0002J\u0012\u0010\u007f\u001a\u00030\u0080\u00012\u0007\u0010\u0081\u0001\u001a\u00020\u001cH\u0002J\u0012\u0010\u0082\u0001\u001a\u00020\u000e2\u0007\u0010\u0083\u0001\u001a\u00020{H\u0002J\f\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0002J\t\u0010\u0086\u0001\u001a\u00020\u000eH\u0002J\t\u0010\u0087\u0001\u001a\u00020\u000eH\u0002J\u0012\u0010\u0088\u0001\u001a\u00020\u000e2\u0007\u0010\u0089\u0001\u001a\u00020\u001cH\u0002J\u0014\u0010\u008a\u0001\u001a\u00020\u000e2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u001cH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u001d\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b*\u0010+R\u001d\u0010-\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010'\u001a\u0004\b/\u00100R\u001d\u00102\u001a\u0004\u0018\u0001038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010'\u001a\u0004\b4\u00105R\u001d\u00107\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010'\u001a\u0004\b9\u0010:R\u001d\u0010<\u001a\u0004\u0018\u00010=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010'\u001a\u0004\b>\u0010?R\u001d\u0010A\u001a\u0004\u0018\u00010B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010'\u001a\u0004\bC\u0010DR\u001d\u0010F\u001a\u0004\u0018\u00010G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010'\u001a\u0004\bH\u0010IR\u001a\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0LX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u00020NX\u0082\u0004¢\u0006\u0004\n\u0002\u0010O¨\u0006\u008c\u0001"}, d2 = {"Lcom/larus/uaigc/music/applet/MusicTemplateAppletInputComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/uaigc/bean/instruction/IMusicLyricsEditAbility;", "Lcom/larus/uaigc/music/applet/MusicTemplateAppletInputReadyAbility;", "<init>", "()V", "sending", "", "rootContainer", "Landroid/view/ViewGroup;", "inputReady", "pendingInputReadyAction", "Lkotlin/Function0;", "", "fullScreenEditView", "Lcom/larus/uaigc/music/applet/MusicFullScreenEditFrameLayout;", "fullScreenSelectedItems", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionItem;", "fullScreenMusicCreateManager", "Lcom/larus/bmhome/music/instructions/IMusicCreateManager;", "restoreInputAfterFullScreenEdit", "coreFullScreenEditOpen", "restoreInputAfterCoreFullScreenEdit", "templateMaskView", "Landroid/view/View;", "registeredLocalConversationId", "", "restoreInputAfterCoreFullScreenEditRunnable", "Ljava/lang/Runnable;", "appletLifecycleCallback", "com/larus/uaigc/music/applet/MusicTemplateAppletInputComponent$appletLifecycleCallback$1", "Lcom/larus/uaigc/music/applet/MusicTemplateAppletInputComponent$appletLifecycleCallback$1;", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "coreInputManager", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "getCoreInputManager", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "coreInputManager$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "speakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "speakerAbility$delegate", "editorAbility", "Lcom/larus/uaigc/music/applet/MusicAppletInstructionEditorAbility;", "getEditorAbility", "()Lcom/larus/uaigc/music/applet/MusicAppletInstructionEditorAbility;", "editorAbility$delegate", "instructionPanelAbility", "Lcom/larus/uaigc/music/applet/MusicTemplateAppletInstructionPanelAbility;", "getInstructionPanelAbility", "()Lcom/larus/uaigc/music/applet/MusicTemplateAppletInstructionPanelAbility;", "instructionPanelAbility$delegate", "argumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "argumentData$delegate", "chatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "getChatPageContext", "()Lcom/larus/bmhome/chat/bean/ChatPageContext;", "chatPageContext$delegate", "inputFocusChangeListener", "Lkotlin/Function1;", "conversationReplaceListener", "com/larus/uaigc/music/applet/MusicTemplateAppletInputComponent$conversationReplaceListener$1", "Lcom/larus/uaigc/music/applet/MusicTemplateAppletInputComponent$conversationReplaceListener$1;", "onAttach", "onViewCreated", "view", "onDestroy", "runWhenInputReady", "action", "dispatchPendingInputReadyAction", "initRootLayout", "configInput", "observeImeChange", "parent", "Lcom/larus/bmhome/view/ChatConstraintLayout;", "onCoreFullScreenInputStatusChanged", "open", "completeCoreFullScreenInputRestore", "restoreInputFocusAfterCoreFullScreenEdit", "updateTemplateMask", "isInputPanelExpanded", "addTemplateMask", "removeTemplateMask", "collapseMusicInputPanel", "showLyricsFullScreenEditor", "selectedItems", "musicCreateManager", "resolveFullScreenEditContainer", "onFullScreenEditConfirmed", "text", "onFullScreenAiGenerate", "prompt", "buildLyricsInputFilters", "", "Landroid/text/InputFilter;", "()[Landroid/text/InputFilter;", "removeFullScreenEditView", "restoreInputFocusAfterFullScreenEdit", "showExpandedInputPanel", "openMusicInstructionEditorIfNeeded", "configFullInputBoxMobParams", "applyActionBarInputHintIfInputEmpty", "resolveActionBarInputHint", "configVisibleInputStatus", "onSend", "params", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "mergeMessageExt", "", "inputMessageExt", "onVoiceAsrResult", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/ASRWithExtResult;", "asrResult", "sendToTargetConversation", "sendParams", "resolveSendConversation", "Lcom/larus/im/bean/conversation/Conversation;", "observeLocalConversationReplacement", "unregisterLocalConversationReplacement", "syncReplacedConversationId", "conversationId", "onSendAccepted", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MusicTemplateAppletInputComponent extends BaseContentWidget implements wy9.d, t1 {
    public static final /* synthetic */ int K = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final u0 I;
    public final c J;
    public boolean m;
    public ChatConstraintLayout n;
    public boolean o;
    public Function0<Unit> p;
    public MusicFullScreenEditFrameLayout q;
    public List<com.larus.bmhome.actionbar.model.u> r;
    public com.larus.bmhome.music.instructions.a s;
    public boolean t;
    public boolean u;
    public boolean v;
    public View w;
    public String x;
    public final o1 y;
    public final b z;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.uaigc.music.applet.MusicTemplateAppletInputComponent$a$a, reason: collision with other inner class name */
        public static final class C0046a implements ChatConstraintLayout.b {
            public static final C0046a a = null;

            static {
                a = new C0046a();
            }

            public C0046a() {
            }

            public final void a() {
            }

            public final void b() {
            }

            public final void onUpdate(int r1) {
            }
        }
    }

    public static final class b implements ir8.c.a {
        public final /* synthetic */ MusicTemplateAppletInputComponent a;

        public final void a() {
            Intrinsics.checkNotNullParameter("db_2c90E66", "appId");
            if (Intrinsics.areEqual("db_2c90E66", "db_2c90E66") == false) goto L9;
            MusicTemplateAppletInputComponent r0 = this.a;
            r0.t = false;
            MusicFullScreenEditFrameLayout r1 = r0.q;
            if (r1 == null) goto L7;
            r1.c(true);
        L7:
            this.a.m3();
            return;
        }

        public b(MusicTemplateAppletInputComponent r1) {
            this.a = r1;
        }
    }

    public static final class c implements com.larus.im.service.d0<wc9.e> {
        public final /* synthetic */ MusicTemplateAppletInputComponent a;

        public c(MusicTemplateAppletInputComponent r1) {
            this.a = r1;
        }

        public final void c(Object r2) {
            Intrinsics.checkNotNullParameter((wc9.e) r2, SlashMentionConfig.MENTION_CONTENT_CONVERSATION);
        }

        public final void a(wc9.e r3, wc9.e r4) {
            Intrinsics.checkNotNullParameter(r4, "new");
            String r0 = this.a.x;
            if (r0 == null) goto L28;
            if (r3 == null) goto L7;
            String r5 = r3.a;
        L9:
            if (Intrinsics.areEqual(r5, r0) == false) goto L29;
            MusicTemplateAppletInputComponent r6 = this.a;
            String r7 = r4.a;
            r6.getClass();
            if (r7.length() != 0) goto L14;
            boolean r1 = true;
        L15:
            if (r1 == true) goto L30;
            Intrinsics.checkNotNullParameter(r6, "<this>");
            Bundle r2 = com.larus.ui.arch.component.internal.attach.a.b(r6, r6).getArguments();
            if (r2 == null) goto L20;
            r2.putString("argConversationId", r7);
            r2.putString("conversation_id", r7);
        L20:
            ny9.s r8 = r6.z3();
            if (r8 == null) goto L26;
            ChatParam r9 = r8.c();
            if (r9 == null) goto L27;
            r9.a = r7;
            return;
        L27:
            return;
        L26:
            return;
        L30:
            return;
        L14:
            r1 = false;
            goto L15
        L29:
            return;
        L7:
            r5 = null;
            goto L9
        }
    }

    static {
    }

    public final void onDestroy() {
        this.o = false;
        this.p = null;
        CopyOnWriteArraySet r2 = ir8.c.a;
        ir8.c.c(this.z);
        String r3 = this.x;
        if (r3 == null) goto L6;
        com.larus.im.d.c().unRegisterConversationChangeListener(r3, this.J);
        this.x = null;
    L6:
        va8.o r4 = B3();
        if (r4 == null) goto L9;
        r4.oR(this.I);
    L9:
        ICoreInputAbility r5 = C3();
        if (r5 == null) goto L12;
        r5.tr(new l1());
    L12:
        ICoreInputAbility r6 = C3();
        if (r6 == null) goto L15;
        r6.r7(new m1());
    L15:
        z8 r7 = D3();
        if (r7 == null) goto L18;
        r7.j9();
    L18:
        ChatConstraintLayout r8 = this.n;
        if ((r8 instanceof ChatConstraintLayout) == true) goto L22;
        r8 = null;
    L22:
        if (r8 == null) goto L24;
        r8.setOnBottomInsetUpdateListener(a.C0046a.a);
    L24:
        ChatConstraintLayout r9 = this.n;
        if (r9 == null) goto L27;
        r9.removeCallbacks(this.y);
    L27:
        H3();
        MusicFullScreenEditFrameLayout r10 = this.q;
        if (r10 == null) goto L37;
        ViewParent r11 = r10.getParent();
        if ((r11 instanceof ViewGroup) == false) goto L33;
        ViewGroup r12 = (ViewGroup) r11;
    L34:
        if (r12 == null) goto L36;
        r12.removeView(r10);
    L36:
        this.q = null;
        this.t = false;
        goto L37
    L33:
        r12 = null;
    L37:
        this.n = null;
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.f(com.larus.ui.arch.component.internal.attach.a.b(this, this), t1.class);
    }

    public final va8.o B3() {
        return (va8.o) this.C.getValue();
    }

    public final ICoreInputAbility C3() {
        return (ICoreInputAbility) this.A.getValue();
    }

    public final z8 D3() {
        return (z8) this.B.getValue();
    }

    public final boolean E3() {
        ChatConstraintLayout r0 = this.n;
        if (r0 == null) goto L9;
        View r1 = r0.findViewById(2131365537);
        if (r1 == null) goto L9;
        if (r1.getVisibility() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public final void H3() {
        View r0 = this.w;
        if (r0 == null) goto L10;
        ViewParent r2 = r0.getParent();
        if ((r2 instanceof ViewGroup) == false) goto L7;
        ViewGroup r3 = (ViewGroup) r2;
    L8:
        if (r3 == null) goto L10;
        r3.removeView(r0);
        goto L10
    L7:
        r3 = null;
    L10:
        this.w = null;
    }

    public final ViewGroup Q3() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r1 == null) goto L5;
        ViewParent r2 = r1.getParent();
    L7:
        if ((r2 instanceof ViewGroup) == false) goto L9;
        ViewGroup r3 = (ViewGroup) r2;
    L11:
        if ((r3 instanceof FragmentContainerView) == false) goto L16;
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r0 != null) goto L15;
        return null;
    L15:
        return (ViewGroup) r0.findViewById(R.id.content);
    L16:
        if (r3 == null) goto L18;
        return r3;
    L18:
        return this.n;
    L9:
        r3 = null;
        goto L11
    L5:
        r2 = null;
        goto L7
    }

    public final void V3() {
        if (this.t == true) goto L5;
        return;
    L5:
        va8.o r0 = B3();
        if (r0 == null) goto L8;
        r0.E40();
    L8:
        ICoreInputAbility r1 = C3();
        if (r1 == null) goto L12;
        ICoreInputAbility.b.e(r1, "music_full_screen_edit_close", null, false, 6);
        return;
    }

    public final void W3() {
        ChatConstraintLayout r0 = this.n;
        if (r0 == null) goto L7;
        View r1 = r0.findViewById(2131387244);
        if (r1 == null) goto L7;
        com.larus.utils.e1.o(r1);
    L7:
        ChatConstraintLayout r2 = this.n;
        if (r2 == null) goto L12;
        View r3 = r2.findViewById(2131365537);
        if (r3 == null) goto L12;
        com.larus.utils.e1.x(r3);
    L12:
        u1 r4 = (u1) this.F.getValue();
        if (r4 == null) goto L15;
        r4.yD();
    L15:
        Y2();
    }

    public final void Y2() {
        ChatConstraintLayout r0 = this.n;
        if (r0 == null) goto L15;
        ViewGroup r1 = (ViewGroup) r0.findViewById(2131388323);
        if (r1 == null) goto L16;
        View r2 = this.w;
        if (r2 == null) goto L10;
        ViewParent r3 = r2.getParent();
    L11:
        if (r3 != r1) goto L13;
        return;
    L13:
        H3();
        View r4 = new View(getContext());
        r4.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r4.setBackgroundColor(0);
        com.larus.utils.e1.d(r4, new v0(this));
        this.w = r4;
        r1.addView(r4);
        return;
    L10:
        r3 = null;
        goto L11
    L16:
        return;
    }

    public final void p3() {
        kr8.n r0 = kr8.n.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        kr8.o r1 = kr8.n.a(com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments(), null, null, null, null, null, 62);
        z8 r2 = D3();
        if (r2 == null) goto L6;
        r2.g9(MapsKt.mapOf(new Pair[]{TuplesKt.to("current_page", "template_page"), TuplesKt.to("app_enter_method", r1.b), TuplesKt.to("from_entrance", r1.e), TuplesKt.to("app_key", r1.c)}));
        return;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, wy9.d.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, t1.class);
        CopyOnWriteArraySet r0 = ir8.c.a;
        b r1 = this.z;
        Intrinsics.checkNotNullParameter(r1, "callback");
        ir8.c.a.add(r1);
    }

    public final ny9.s z3() {
        return (ny9.s) this.G.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.uaigc.music.applet.o1] */
    /* JADX WARN: Type inference failed for: r0v18, types: [com.larus.uaigc.music.applet.u0] */
    public MusicTemplateAppletInputComponent() {
        this.y = new o1(this);
        this.z = new b(this);
        this.A = LazyKt.lazy(new p1(this));
        this.B = LazyKt.lazy(new q1(this));
        this.C = LazyKt.lazy(new r1(this));
        this.D = LazyKt.lazy(new p0(this));
        this.E = LazyKt.lazy(new q0(this));
        this.F = LazyKt.lazy(new r0(this));
        this.G = LazyKt.lazy(new s0(this));
        this.H = LazyKt.lazy(new t0(this));
        this.I = new u0(this);
        this.J = new c(this);
    }

    public final void X3() {
        if (E3() == false) goto L5;
        Y2();
        return;
    L5:
        H3();
    }

    public final void h3() {
        va8.o r0 = B3();
        boolean r1 = false;
        if (r0 == null) goto L12;
        String r2 = r0.u7();
        if (r2 == null) goto L12;
        if (r2.length() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 != true) goto L12;
        r1 = true;
        goto L12
    L9:
        r3 = false;
    L12:
        if (r1 == false) goto L14;
        return;
    L14:
        f r4 = (f) this.E.getValue();
        String r5 = null;
        if (r4 == null) goto L21;
        String r6 = r4.O3(r4.S4());
        if (r6 == null) goto L21;
        if ((!StringsKt.isBlank(r6)) == false) goto L21;
    L22:
        if (r4 == null) goto L32;
        com.larus.bmhome.actionbar.model.r r7 = r4.getCurrentInstructionConf();
        if (r7 == null) goto L32;
        com.larus.bmhome.actionbar.model.h1 r8 = r7.c;
        if (r8 == null) goto L32;
        String r9 = r8.a;
        if (r9 == null) goto L32;
        if ((!StringsKt.isBlank(r9)) == false) goto L32;
    L33:
        ny9.s r10 = z3();
        if (r10 == null) goto L36;
        com.larus.bmhome.actionbar.model.z0 r11 = r10.f();
    L37:
        if (r11 == null) goto L47;
        com.larus.bmhome.actionbar.model.r r12 = r11.q;
        if (r12 == null) goto L47;
        com.larus.bmhome.actionbar.model.h1 r13 = r12.c;
        if (r13 == null) goto L47;
        String r14 = r13.a;
        if (r14 == null) goto L47;
        if ((!StringsKt.isBlank(r14)) == false) goto L47;
    L48:
        if (r11 == null) goto L66;
        com.larus.bmhome.actionbar.model.r r15 = r11.q;
        if (r15 == null) goto L66;
        com.larus.bmhome.actionbar.model.y r16 = r15.i;
        if (r16 == null) goto L66;
        ArrayList r17 = r16.a;
        if (r17 == null) goto L66;
        com.larus.bmhome.actionbar.model.z0 r18 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.firstOrNull(r17);
        if (r18 == null) goto L66;
        com.larus.bmhome.actionbar.model.r r19 = r18.q;
        if (r19 == null) goto L66;
        com.larus.bmhome.actionbar.model.h1 r20 = r19.c;
        if (r20 == null) goto L66;
        String r21 = r20.a;
        if (r21 == null) goto L66;
        if ((true ^ StringsKt.isBlank(r21)) == false) goto L66;
        r5 = r21;
    L66:
        if (r6 != null) goto L72;
        if (r9 != null) goto L71;
        if (r14 != null) goto L70;
        r6 = r5;
        goto L72
    L70:
        r6 = r14;
        goto L72
    L71:
        r6 = r9;
    L72:
        if (r6 != null) goto L74;
        return;
    L74:
        ICoreInputAbility r22 = C3();
        if (r22 == null) goto L78;
        r22.M5(r6);
        return;
    L78:
        return;
    L47:
        r14 = null;
        goto L48
    L36:
        r11 = null;
    L32:
        r9 = null;
    L21:
        r6 = null;
        goto L22
    }

    public final void m3() {
        va8.o r0 = B3();
        if (r0 == null) goto L5;
        r0.c3();
    L5:
        u1 r1 = (u1) this.F.getValue();
        if (r1 == null) goto L8;
        r1.Ub();
    L8:
        ChatConstraintLayout r2 = this.n;
        if (r2 == null) goto L13;
        View r3 = r2.findViewById(2131365537);
        if (r3 == null) goto L13;
        com.larus.utils.e1.o(r3);
    L13:
        ChatConstraintLayout r4 = this.n;
        if (r4 == null) goto L18;
        View r5 = r4.findViewById(2131387244);
        if (r5 == null) goto L18;
        com.larus.utils.e1.x(r5);
    L18:
        H3();
    }

    public final void G3(ICoreInputAbility.OnSendParams r83) {
        String r2 = r83.getContent();
        if (StringsKt.isBlank(StringsKt.trim(r2).toString()) == false) goto L6;
        FLogger.a.i("MusicTemplateAppletInput", "ignore blank input");
        return;
    L6:
        f r3 = (f) this.E.getValue();
        if (r3 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L16;
        FLogger.a.i("MusicTemplateAppletInput", "ignore illegal music input");
        return;
    L16:
        if (this.m == false) goto L19;
        FLogger.a.i("MusicTemplateAppletInput", "ignore duplicate music template applet send");
        return;
    L19:
        this.m = true;
        f r5 = (f) this.E.getValue();
        if (r5 != null) goto L23;
        FLogger.a.e("MusicTemplateAppletInput", "send music template applet message failed, editorAbility is null");
        t19.s r0 = t19.s.a;
        Application r6 = AppHost.a.getApplication();
        r0.getClass();
        t19.s.s(r6, 2131908214);
        this.m = false;
        return;
    L23:
        ny9.s r7 = z3();
        if (r7 == null) goto L26;
        com.larus.bmhome.actionbar.model.z0 r8 = r7.f();
    L27:
        if (r8 == null) goto L29;
        String r17 = r8.b;
    L30:
        if (r17 != null) goto L32;
    L35:
        boolean r9 = true;
    L36:
        if (r9 == false) goto L40;
        FLogger.a.e("MusicTemplateAppletInput", "send music template applet message failed, actionBarKey is empty");
        t19.s r1 = t19.s.a;
        Application r10 = AppHost.a.getApplication();
        r1.getClass();
        t19.s.s(r10, 2131908214);
        this.m = false;
        return;
    L40:
        if (r83.getLocalIntercepted() == false) goto L43;
        FLogger.a.i("MusicTemplateAppletInput", "send music template applet message intercepted, reason:" + r83.getLocalInterceptInfo());
        this.m = false;
        return;
    L43:
        String r32 = r5.y6(r2);
        String r11 = r5.Is(r2);
        if (r11 != null) goto L46;
        r11 = "";
    L46:
        String r19 = r11;
        com.larus.bmhome.instruction.j r16 = IAIChatUgcAIGCService.a.e0();
        if (r8 == null) goto L49;
        Long r22 = r8.a;
    L50:
        Map r18 = com.larus.bmhome.instruction.j.a.c(r16, r17, "1", r19, true, null, r22, 16);
        String r23 = r5.c0();
        Map r12 = r83.messageExt;
        ny9.s r13 = z3();
        if (r13 == null) goto L55;
        ICoreInputAbility.MessageExtMap r14 = r13.m();
        if (r14 == null) goto L55;
        Map r15 = r14.a;
    L56:
        if (r15 != null) goto L58;
    L61:
        boolean r20 = true;
    L62:
        if (r20 == false) goto L64;
    L63:
        Map r39 = r12;
        ChatPageContext r21 = r83.chatPageContext;
        if (r21 != null) goto L70;
        r21 = (ChatPageContext) this.H.getValue();
    L70:
        ICoreInputAbility.OnSendParams r24 = ICoreInputAbility.OnSendParams.copy$default(r83, r32, null, null, null, null, r18, null, null, 1, false, null, false, false, false, null, r23, null, null, false, "chat_action_bar", r39, null, null, null, null, null, null, null, null, r21, null, null, null, -538476834, 1, null);
        ICoreInputAbility r25 = C3();
        if (r25 != null) goto L73;
        FLogger.a.e("MusicTemplateAppletInput", "send music template applet message failed, coreInputAbility is null");
        t19.s r26 = t19.s.a;
        Application r27 = AppHost.a.getApplication();
        r26.getClass();
        t19.s.s(r27, 2131908214);
        this.m = false;
        return;
    L73:
        ny9.s r28 = z3();
        if (r28 == null) goto L79;
        ChatParam r29 = r28.c();
        if (r29 == null) goto L79;
        String r30 = r29.a;
        if (r30 == null) goto L79;
    L82:
        String r42 = r30;
    L84:
        if (r42 != null) goto L86;
    L89:
        boolean r31 = true;
    L90:
        if (r31 == false) goto L92;
        FLogger.a.i("MusicTemplateAppletInput", "send music template applet message without explicit conversation");
        wc9.e r110 = null;
    L93:
        if (r110 != null) goto L135;
        FLogger.a.e("MusicTemplateAppletInput", "send music template applet message failed, target conversation is empty");
        t19.s r33 = t19.s.a;
        Application r34 = AppHost.a.getApplication();
        r33.getClass();
        t19.s.s(r34, 2131908214);
        this.m = false;
        return;
    L135:
        r25.JJ(r110);     // Catch: Throwable -> L121 Exception -> L123
        r25.E0(r24);     // Catch: Throwable -> L121 Exception -> L123
        r25.JJ(null);
        String r111 = r110.a;
        kr8.n r35 = kr8.n.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        kr8.o r36 = kr8.n.a(com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments(), null, null, null, null, null, 62);
        monitor-enter(r35);
        Intrinsics.checkNotNullParameter(r36, "context");     // Catch: Throwable -> L118
        if (r111 != null) goto L101;
    L106:
        monitor-exit(r35);
        ICoreInputAbility r37 = C3();
        if (r37 == null) goto L110;
        r37.qp(false);
    L110:
        ICoreInputAbility r38 = C3();
        if (r38 == null) goto L113;
        r38.p80(true);
    L113:
        this.m = false;
        MutableSharedFlow<w1> r40 = b0.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r41 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r41 == null) goto L116;
        String r43 = r41.getString("source_creation_session_id");
    L117:
        b0.c.tryEmit(new v1(r111, r43));
        return;
    L116:
        r43 = null;
        goto L117
    L101:
        if ((!StringsKt.isBlank(r111)) == false) goto L103;
        String r44 = r111;
    L104:
        if (r44 == null) goto L106;
        kr8.n.b.put(r44, r36);     // Catch: Throwable -> L118
        goto L106
    L103:
        r44 = null;
    L118:
        th = move-exception;
        throw th;
    L123:
        e = move-exception;
        wc9.e r45 = null;
        FLogger.a.e("MusicTemplateAppletInput", "send music template applet message failed", e);     // Catch: Throwable -> L128
        t19.s r46 = t19.s.a;     // Catch: Throwable -> L128
        Application r47 = AppHost.a.getApplication();     // Catch: Throwable -> L128
        r46.getClass();     // Catch: Throwable -> L128
        t19.s.s(r47, 2131908214);     // Catch: Throwable -> L128
        this.m = false;     // Catch: Throwable -> L128
        r25.JJ(null);
        return;
    L128:
        th = th;
    L129:
        r25.JJ(r45);
        throw th;
    L121:
        th = th;
        r45 = null;
        goto L129
    L92:
        r110 = new wc9.e(r42, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, 0, null, null, 0, -2, 63);
        goto L93
    L86:
        if (r42.length() == 0) goto L89;
        r31 = false;
    L79:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r48 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r48 == null) goto L83;
        r30 = r48.getString("argConversationId");
        goto L82
    L83:
        r42 = null;
        goto L84
    L64:
        if (r12 != null) goto L66;
        r12 = MapsKt.emptyMap();
    L66:
        r12 = MapsKt.toMutableMap(r12);
        r12.putAll(r15);
        goto L63
    L58:
        if (r15.isEmpty() == true) goto L61;
        r20 = false;
    L55:
        r15 = null;
        goto L56
    L49:
        r22 = null;
        goto L50
    L32:
        if (r17.length() == 0) goto L35;
        r9 = false;
        goto L36
    L29:
        r17 = null;
        goto L30
    L26:
        r8 = null;
        goto L27
    L9:
        if (r3.x(r2) != true) goto L11;
        r4 = true;
        goto L12
    }

    @Override // com.larus.uaigc.music.applet.t1
    public final void kK(final g0 r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        if (this.o == false) goto L7;
        ChatConstraintLayout r0 = this.n;
        if (r0 == null) goto L9;
        r0.post(new w0(r3));
        return;
    L9:
        return;
    L7:
        this.p = r3;
    }

    public final void onViewCreated(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        if ((r6 instanceof ChatConstraintLayout) == false) goto L5;
        ChatConstraintLayout r7 = (ChatConstraintLayout) r6;
    L7:
        if (r7 == null) goto L10;
        this.n = r7;
        r7.setDisableBottomPadding(true);
        r7.setDisableTopPadding(true);
        r7.k6(getContext());
        com.larus.utils.e1.d(r7, new n1(this));
        r7.setOnBottomInsetUpdateListener(new s1(this));
    L10:
        z8 r8 = D3();
        boolean r2 = false;
        if (r8 == null) goto L13;
        r8.z9(false);
    L13:
        z8 r9 = D3();
        if (r9 == null) goto L16;
        r9.s9();
    L16:
        ViewGroup r10 = Q3();
        if (r10 == null) goto L21;
        ICoreInputAbility r3 = C3();
        if (r3 == null) goto L21;
        r3.m1(r10);
    L21:
        ICoreInputAbility r11 = C3();
        if (r11 == null) goto L24;
        r11.r7(new MusicTemplateAppletInputComponent$configInput$2(this));
    L24:
        z8 r12 = D3();
        if (r12 == null) goto L27;
        r12.w8();
    L27:
        z8 r13 = D3();
        if (r13 == null) goto L30;
        r13.c9();
    L30:
        z8 r14 = D3();
        if (r14 == null) goto L33;
        r14.f9(true);
    L33:
        z8 r15 = D3();
        if (r15 == null) goto L36;
        r15.w9(false);
    L36:
        p3();
        ICoreInputAbility r16 = C3();
        if (r16 == null) goto L39;
        r16.s20(8);
    L39:
        va8.o r17 = B3();
        if (r17 == null) goto L42;
        r17.Jv();
    L42:
        z8 r18 = D3();
        if (r18 == null) goto L45;
        r18.R8();
    L45:
        g9.a r19 = new g9.a(new x0());
        g9.a r4 = new g9.a(new y0(this));
        z8 r5 = D3();
        if (r5 == null) goto L48;
        r5.y9(1, r19);
    L48:
        z8 r20 = D3();
        if (r20 == null) goto L51;
        r20.y9(3, r4);
    L51:
        ICoreInputAbility r21 = C3();
        if (r21 == null) goto L54;
        r21.tr(new o0(this));
    L54:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r22 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.D.getValue();
        if (r22 == null) goto L57;
        r22.b3(new z0(this));
    L57:
        va8.o r23 = B3();
        if (r23 == null) goto L60;
        r23.GM(this.I);
    L60:
        ICoreInputAbility r24 = C3();
        if (r24 == null) goto L63;
        r24.g2(1, true);
    L63:
        h3();
        ny9.s r25 = z3();
        if (r25 == null) goto L69;
        ChatParam r26 = r25.c();
        if (r26 == null) goto L69;
        String r27 = r26.a;
        if (r27 == null) goto L69;
    L73:
        if (r27 != null) goto L75;
    L76:
        r2 = true;
    L77:
        if (r2 == false) goto L79;
    L82:
        this.o = true;
        final Function0<Unit> r28 = this.p;
        if (r28 == null) goto L90;
        this.p = null;
        ChatConstraintLayout r0 = this.n;
        if (r0 == null) goto L89;
        r0.post(new k1(r28));
        return;
    L89:
        return;
    L90:
        return;
    L79:
        if (com.larus.im.j.f(r27) == false) goto L82;
        this.x = r27;
        com.larus.im.d.c().registerConversationChangeListener(r27, this.J);
        goto L82
    L75:
        if (r27.length() != 0) goto L77;
    L69:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r29 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r29 == null) goto L72;
        r27 = r29.getString("argConversationId");
        goto L73
    L72:
        r27 = null;
        goto L73
    L5:
        r7 = null;
        goto L7
    }

    @Override // wy9.d
    public final void AA(List r13, com.larus.bmhome.music.instructions.g r14) {
        MusicFullScreenEditFrameLayout r0 = this.q;
        ViewGroup.MarginLayoutParams r1 = null;
        if (r0 == null) goto L5;
        ViewParent r2 = r0.getParent();
    L6:
        if (r2 == null) goto L8;
        return;
    L8:
        ViewGroup r3 = Q3();
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r4 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r3 != null) goto L13;
        if (r4 != null) goto L13;
        FLogger.a.e("MusicTemplateAppletInput", "show music full screen edit failed, target container and activity are null");
        return;
    L13:
        this.r = r13;
        this.s = r14;
        int r5 = 0;
        if (E3() == false) goto L23;
        va8.o r15 = B3();
        if (r15 != null) goto L18;
    L20:
        boolean r16 = false;
    L21:
        if (r16 == false) goto L23;
        boolean r17 = true;
    L24:
        this.t = r17;
        kr8.n r18 = kr8.n.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        kr8.o r19 = kr8.n.a(com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments(), null, null, null, null, null, 62);
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter("template_page", "currentPage");
        JSONObject r6 = kr8.n.k(r19, "template_page");
        r6.put("from_entrance", r19.e);
        kr8.n.g("create_lyrics_click", r6);
        va8.o r110 = B3();
        if (r110 == null) goto L27;
        r110.vI(false);
    L27:
        u1 r111 = (u1) this.F.getValue();
        if (r111 == null) goto L30;
        r111.Ub();
    L30:
        ViewGroup.LayoutParams r112 = new ViewGroup.LayoutParams(-1, -1);
        final MusicFullScreenEditFrameLayout r7 = new MusicFullScreenEditFrameLayout(getContext(), null, 6, 0);
        final int r8 = z2.a.getMusicCreateConfig().a;
        InputFilter[] r113 = {new com.larus.bmhome.music.utils.a(r8, new j1(this, r8))};
        Function1<? super String, Unit> r9 = new b1(this);
        Function1<? super String, Unit> r10 = new c1(this, r7);
        Function0<Unit> r11 = new d1(this);
        Function0<Unit> r12 = new e1(this, r7);
        Intrinsics.checkNotNullParameter(r9, "onUpdateInputText");
        Intrinsics.checkNotNullParameter(r10, "onAiGenerate");
        Intrinsics.checkNotNullParameter(r11, "onClosing");
        Intrinsics.checkNotNullParameter(r12, "onDismiss");
        r7.d = r9;
        r7.e = r10;
        r7.f = r11;
        r7.g = r12;
        r7.a.l.setFilters(r113);
        r7.setLayoutParams(r112);
        r7.setOnClickListener(new f1());
        com.larus.utils.e1.d(r7.a.f, new q(r7));
        com.larus.utils.e1.d(r7.a.b, new r(r7));
        r7.setInputText("");
        FragmentActivity r114 = r7.getContext();
        if ((r114 instanceof FragmentActivity) == false) goto L33;
        FragmentActivity r115 = r114;
    L34:
        if (r115 == null) goto L36;
        int r116 = com.larus.utils.u.b(r115);
    L37:
        FragmentActivity r20 = r7.getContext();
        if ((r20 instanceof FragmentActivity) == false) goto L40;
        FragmentActivity r21 = r20;
    L41:
        if (r21 == null) goto L59;
        int r22 = com.larus.utils.u.c(r21);
        if (r22 != 0) goto L45;
    L47:
        if (r116 == 0) goto L59;
        ViewGroup.LayoutParams r23 = r7.a.d.getLayoutParams();
        if ((r23 instanceof ViewGroup.MarginLayoutParams) == false) goto L51;
        r1 = (ViewGroup.MarginLayoutParams) r23;
    L51:
        if (r1 == null) goto L53;
        r5 = r1.bottomMargin;
    L53:
        if (r5 == r116) goto L59;
        ConstraintLayout r24 = r7.a.d;
        ViewGroup.LayoutParams r25 = r24.getLayoutParams();
        if (r25 == null) goto L58;
        ViewGroup.MarginLayoutParams r26 = (ViewGroup.MarginLayoutParams) r25;
        r26.bottomMargin = r116;
        r24.setLayoutParams(r26);
        goto L59
    L58:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L45:
        if (r7.a.g.getPaddingTop() == r22) goto L47;
        FrameLayout r27 = r7.a.g;
        r27.setPadding(r27.getPaddingLeft(), r22, r27.getPaddingRight(), r27.getPaddingBottom());
    L59:
        this.q = r7;
        if (r3 == null) goto L62;
        r3.addView(r7, r112);
        return;
    L62:
        if (r4 == null) goto L66;
        r4.addContentView(r7, r112);
        return;
    L66:
        return;
    L40:
        r21 = null;
        goto L41
    L36:
        r116 = 0;
        goto L37
    L33:
        r115 = null;
        goto L34
    L18:
        if (r15.w() != true) goto L20;
        r16 = true;
    L23:
        r17 = false;
        goto L24
    L5:
        r2 = null;
        goto L6
    }
}
