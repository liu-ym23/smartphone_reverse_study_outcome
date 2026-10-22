package com.larus.uaigc.worldcup.component;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.larus.bmhome.chat.component.bottom.core.h9;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.fastsend.e0;
import com.larus.bmhome.chat.d4;
import com.larus.bmhome.chat.j4;
import com.larus.common.apphost.AppHost;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.uaigc.lynx.pocket.ClickPocketInfo;
import com.larus.uaigc.lynx.pocket.JumpSomewherePocket;
import com.larus.uaigc.lynx.pocket.Pocket;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u0000 \u0087\u00012\u00020\u00012\u00020\u0002:\u0002\u0087\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010^\u001a\u00020_H\u0016J\u0010\u0010`\u001a\u00020_2\u0006\u0010a\u001a\u00020]H\u0017J\f\u0010b\u001a\u00020O*\u00020cH\u0002J\f\u0010d\u001a\u00020O*\u00020cH\u0002J\b\u0010e\u001a\u00020_H\u0016J\b\u0010f\u001a\u00020_H\u0002J\b\u0010g\u001a\u00020_H\u0002J\b\u0010h\u001a\u00020_H\u0016J\b\u0010i\u001a\u00020_H\u0016J\b\u0010j\u001a\u00020_H\u0016J\b\u0010k\u001a\u00020OH\u0016J\u0010\u0010l\u001a\u00020_2\u0006\u0010m\u001a\u00020OH\u0016J\b\u0010n\u001a\u00020oH\u0016J0\u0010p\u001a\u00020_2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020v2\u0006\u0010x\u001a\u00020OH\u0002J\u0012\u0010y\u001a\u00020_2\b\b\u0002\u0010u\u001a\u00020vH\u0002JH\u0010z\u001a\u00020_2\u0012\u0010{\u001a\u000e\u0012\u0004\u0012\u00020v\u0012\u0004\u0012\u00020v0|2\b\b\u0002\u0010w\u001a\u00020v2\u0006\u0010x\u001a\u00020O2\u0018\b\u0002\u0010}\u001a\u0012\u0012\u0004\u0012\u00020v\u0012\u0006\u0012\u0004\u0018\u00010\u007f\u0018\u00010~H\u0002JF\u0010\u0080\u0001\u001a\u00020_2\u0007\u0010\u0081\u0001\u001a\u00020t2\b\b\u0002\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020v2\u0006\u0010x\u001a\u00020O2\u0018\b\u0002\u0010}\u001a\u0012\u0012\u0004\u0012\u00020v\u0012\u0006\u0012\u0004\u0018\u00010\u007f\u0018\u00010~H\u0002J+\u0010\u0082\u0001\u001a\u00020_2\b\u0010s\u001a\u0004\u0018\u00010t2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020v2\u0006\u0010x\u001a\u00020OH\u0016J0\u0010\u0083\u0001\u001a\u0010\u0012\u0004\u0012\u00020v\u0012\u0004\u0012\u00020v\u0018\u00010~2\u0017\u0010\u0084\u0001\u001a\u0012\u0012\u0004\u0012\u00020v\u0012\u0006\u0012\u0004\u0018\u00010\u007f\u0018\u00010~H\u0002J$\u0010\u0085\u0001\u001a\u0004\u0018\u00010v2\u0017\u0010\u0086\u0001\u001a\u0012\u0012\u0004\u0012\u00020v\u0012\u0006\u0012\u0004\u0018\u00010\u007f\u0018\u00010~H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u001d\u0010$\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\n\u001a\u0004\b&\u0010'R\u001d\u0010)\u001a\u0004\u0018\u00010*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b+\u0010,R\u0016\u0010.\u001a\u0004\u0018\u00010/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u001d\u00102\u001a\u0004\u0018\u0001038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\n\u001a\u0004\b4\u00105R\u001d\u00107\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\n\u001a\u0004\b9\u0010:R\u001d\u0010<\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\n\u001a\u0004\b=\u0010\"R\u001d\u0010?\u001a\u0004\u0018\u00010@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\n\u001a\u0004\bA\u0010BR\u001d\u0010D\u001a\u0004\u0018\u00010E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\n\u001a\u0004\bF\u0010GR\u001d\u0010I\u001a\u0004\u0018\u00010J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\n\u001a\u0004\bK\u0010LR\u000e\u0010N\u001a\u00020OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010R\u001a\u00020S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\n\u001a\u0004\bT\u0010UR\u001d\u0010W\u001a\u0004\u0018\u00010X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\n\u001a\u0004\bY\u0010ZR\u0010\u0010\\\u001a\u0004\u0018\u00010]X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0088\u0001"}, d2 = {"Lcom/larus/uaigc/worldcup/component/WorldCupInputComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/uaigc/spring/ability/MainVenueInputAbility;", "<init>", "()V", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "lynxAbility", "Lcom/larus/uaigc/spring/ability/MainVenueLynxAbility;", "getLynxAbility", "()Lcom/larus/uaigc/spring/ability/MainVenueLynxAbility;", "lynxAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "speakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "speakerAbility$delegate", "chatCameraAbility", "Lcom/larus/bmhome/camera/IChatCameraAbility;", "getChatCameraAbility", "()Lcom/larus/bmhome/camera/IChatCameraAbility;", "chatCameraAbility$delegate", "multimodalInputAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "getMultimodalInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "multimodalInputAbility$delegate", "bottomMenuAbility", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "getBottomMenuAbility", "()Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "springMainVenueShuffleTimesAbility", "Lcom/larus/uaigc/spring/ability/SpringMainVenueShuffleTimesAbility;", "getSpringMainVenueShuffleTimesAbility", "()Lcom/larus/uaigc/spring/ability/SpringMainVenueShuffleTimesAbility;", "springMainVenueShuffleTimesAbility$delegate", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "chatBottomSpeakerAbility", "getChatBottomSpeakerAbility", "chatBottomSpeakerAbility$delegate", "fastSendImageAbility", "Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "getFastSendImageAbility", "()Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "fastSendImageAbility$delegate", "reportAbility", "Lcom/larus/uaigc/worldcup/ability/WorldCupReportAbility;", "getReportAbility", "()Lcom/larus/uaigc/worldcup/ability/WorldCupReportAbility;", "reportAbility$delegate", "argumentData", "Lcom/larus/uaigc/worldcup/component/WorldCupArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/worldcup/component/WorldCupArgumentData;", "argumentData$delegate", "inputVisibleStatus", "", "viewCreatedTimeMs", "", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "coreInputManager", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "getCoreInputManager", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "coreInputManager$delegate", "rootView", "Landroid/view/View;", "onAttach", "", "onViewCreated", "view", "interceptActionSendWhenSpeak", "Lcom/larus/bmhome/chat/component/bottom/core/InputView$Operator;", "interceptActionSend", "onResume", "toChatPage", "backToChatPage", "handleSendMessagePageEnd", "recoveryInputContainerVisibleStatus", "forceShowInputContainer", "isInputVisibleStatus", "setInputContainerVisible", "visible", "getBottomInset", "", "handleUploadInputPocketSendMessage", "pocket", "Lcom/larus/uaigc/lynx/pocket/Pocket;", "onSendParams", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "scene", "", "asrResult", "fromAsr", "handleTraceBeforeSendMessage", "appendMainVenueMessageExt", "newExtMap", "", "extra", "", "", "sendMessage", "params", "handleSendMessageAndGoChatPage", "getMessageExtFromPocketDict", "originData", "dictToJson", "dict", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class WorldCupInputComponent extends BaseContentWidget implements zz9.a {
    public static final /* synthetic */ int F = 0;
    public boolean A;
    public long B;
    public final Lazy C;
    public final Lazy D;
    public View E;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements Function0<g1> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
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

    public static final class c implements Function0<com.larus.bmhome.chat.component.bottom.core.speaker.l> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
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

    public static final class d implements Function0<e0> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(e0.class));
        }
    }

    public static final class e implements Function0<c0a.a> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(c0a.a.class));
        }
    }

    public static final class f implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
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

    public static final class g implements Function0<va8.o> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
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

    public static final class h implements Function0<y> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(y.class));
        }
    }

    public static final class i implements Function0<zz9.b> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(zz9.b.class));
        }
    }

    public static final class j implements Function0<com.larus.bmhome.instruction.g> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
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

    public static final class k implements Function0<com.larus.bmhome.chat.component.bottom.core.speaker.l> {
        public final /* synthetic */ AttachReceiver a;

        public k(AttachReceiver r1) {
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

    public static final class l implements Function0<zb8.e> {
        public final /* synthetic */ AttachReceiver a;

        public l(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(zb8.e.class));
        }
    }

    public static final class m implements Function0<com.larus.bmhome.chat.component.bottom.multimodal.g> {
        public final /* synthetic */ AttachReceiver a;

        public m(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.multimodal.g.class));
        }
    }

    public static final class n implements Function0<zz9.e> {
        public final /* synthetic */ AttachReceiver a;

        public n(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(zz9.e.class));
        }
    }

    public static final class o implements Function0<com.larus.uaigc.worldcup.component.a> {
        public final /* synthetic */ AttachReceiver a;

        public o(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(com.larus.uaigc.worldcup.component.a.class));
        }
    }

    static {
    }

    public final void onResume() {
    }

    public final void B3() {
        com.larus.bmhome.chat.api.e0 r0 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L7;
        LaunchInfo r1 = r0.a;
        if (r1 == null) goto L7;
        String r2 = r1.W();
    L8:
        Bundle r3 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argBotId", r2)});
        com.bytedance.router.i r4 = SmartRouter.buildRoute(getContext(), "//flow/chat_page");
        r4.c.putExtras(r3);
        r4.d = 2130772401;
        r4.e = 2130772399;
        r4.d();
        return;
    L7:
        r2 = null;
        goto L8
    }

    @Override // zz9.a
    public final int K7() {
        View r0 = this.E;
        if (r0 == null) goto L5;
        View r1 = r0.findViewById(2131375324);
    L7:
        if (r1 == null) goto L10;
        r1.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return (int) c7.d(Integer.valueOf(r1.getMeasuredHeight()));
    L10:
        return 0;
    L5:
        r1 = null;
        goto L7
    }

    @Override // zz9.a
    public final void WR() {
        if (this.A == false) goto L9;
        View r0 = this.E;
        if (r0 == null) goto L15;
        View r1 = r0.findViewById(2131375324);
        if (r1 == null) goto L16;
        e1.x(r1);
        return;
    L16:
        return;
    L15:
        return;
    L9:
        View r2 = this.E;
        if (r2 == null) goto L18;
        View r3 = r2.findViewById(2131375324);
        if (r3 == null) goto L19;
        e1.o(r3);
        return;
    L19:
        return;
    }

    public final z8 h3() {
        return (z8) this.D.getValue();
    }

    @Override // zz9.a
    public final void h6() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L15
        FragmentActivity r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();     // Catch: Throwable -> L15
        if (r1 != null) goto L5;
        B3();     // Catch: Throwable -> L15
    L13:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
        return;
    L5:
        j4 r2 = AppHost.a.a().a(r1, null);     // Catch: Throwable -> L15
        boolean r3 = r2 instanceof d4;     // Catch: Throwable -> L15
        if ((r2 instanceof j4) == true) goto L8;
    L10:
        if (r3 == false) goto L12;
        FragmentActivity r4 = s1a.a.getActivity(this);     // Catch: Throwable -> L15
        Intent r5 = new Intent();     // Catch: Throwable -> L15
        r5.putExtra("is_need_scroll_last", true);     // Catch: Throwable -> L15
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r4.setResult(-1, r5);     // Catch: Throwable -> L15
        s1a.a.getActivity(this).finish();     // Catch: Throwable -> L15
        goto L13
    L12:
        B3();     // Catch: Throwable -> L15
        goto L13
    L8:
        if (r2.s1() == false) goto L10;
        r3 = true;
    L15:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final zz9.b m3() {
        return (zz9.b) this.p.getValue();
    }

    @Override // zz9.a
    public final void u9() {
        View r0 = this.E;
        if (r0 == null) goto L8;
        View r1 = r0.findViewById(2131375324);
        if (r1 == null) goto L9;
        e1.x(r1);
        return;
    L9:
        return;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, zz9.a.class);
    }

    public WorldCupInputComponent() {
        this.m = LazyKt.lazy(new f(this));
        this.n = LazyKt.lazy(new g(this));
        this.o = LazyKt.lazy(new h(this));
        this.p = LazyKt.lazy(new i(this));
        this.q = LazyKt.lazy(new j(this));
        this.r = LazyKt.lazy(new k(this));
        this.s = LazyKt.lazy(new l(this));
        this.t = LazyKt.lazy(new m(this));
        this.u = LazyKt.lazy(new n(this));
        this.v = LazyKt.lazy(new b(this));
        this.w = LazyKt.lazy(new c(this));
        this.x = LazyKt.lazy(new d(this));
        this.y = LazyKt.lazy(new e(this));
        this.z = LazyKt.lazy(new o(this));
        this.C = LazyKt.lazy(new com.larus.uaigc.worldcup.component.b());
        this.D = LazyKt.lazy(new com.larus.uaigc.worldcup.component.c(this));
    }

    public final f1 Y2() {
        return s1a.d.a(this).getAbility(f1.class);
    }

    @Override // zz9.a
    public final void T9(boolean r3) {
        if (r3 == false) goto L9;
        View r1 = this.E;
        if (r1 == null) goto L14;
        View r0 = r1.findViewById(2131375324);
        if (r0 == null) goto L14;
        e1.x(r0);
    L14:
        this.A = r3;
        return;
    L9:
        View r2 = this.E;
        if (r2 == null) goto L14;
        View r4 = r2.findViewById(2131375324);
        if (r4 == null) goto L14;
        e1.o(r4);
        goto L14
    }

    public final void onViewCreated(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        this.E = r6;
        if (r6 == null) goto L7;
        View r1 = r6.findViewById(2131375324);
        if (r1 == null) goto L7;
        r1.setBackgroundColor(0);
    L7:
        View r2 = this.E;
        if (r2 == null) goto L12;
        View r3 = r2.findViewById(2131375364);
        if (r3 == null) goto L12;
        r3.setBackgroundColor(0);
    L12:
        ICoreInputAbility r4 = (ICoreInputAbility) this.m.getValue();
        if (r4 == null) goto L15;
        r4.tr(new com.larus.uaigc.worldcup.component.d(this));
    L15:
        f1 r5 = Y2();
        if (r5 == null) goto L18;
        r5.HN();
    L18:
        f1 r7 = Y2();
        if (r7 == null) goto L21;
        r7.TA();
    L21:
        com.larus.bmhome.chat.component.bottom.multimodal.g r8 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.t.getValue();
        if (r8 == null) goto L24;
        r8.bh(true);
    L24:
        com.larus.bmhome.chat.component.bottom.multimodal.g r9 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.t.getValue();
        if (r9 == null) goto L27;
        r9.M6();
    L27:
        f1 r10 = Y2();
        if (r10 == null) goto L30;
        r10.sx();
    L30:
        f1 r11 = Y2();
        if (r11 == null) goto L33;
        r11.g20();
    L33:
        z8 r12 = h3();
        if (r12 == null) goto L36;
        r12.z9(false);
    L36:
        z8 r13 = h3();
        if (r13 == null) goto L39;
        r13.R8();
    L39:
        z8 r14 = h3();
        if (r14 == null) goto L42;
        r14.s9();
    L42:
        z8 r15 = h3();
        if (r15 == null) goto L45;
        r15.f9(true);
    L45:
        z8 r16 = h3();
        if (r16 == null) goto L48;
        r16.X8();
    L48:
        z8 r17 = h3();
        if (r17 == null) goto L51;
        r17.n9(true);
    L51:
        g1 r18 = (g1) this.v.getValue();
        if (r18 == null) goto L54;
        r18.yj();
    L54:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r19 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.w.getValue();
        if (r19 == null) goto L57;
        r19.TO();
    L57:
        e0 r20 = (e0) this.x.getValue();
        if (r20 == null) goto L60;
        r20.qD();
    L60:
        z8 r21 = h3();
        if (r21 == null) goto L63;
        r21.y9(1, new g9.a(new com.larus.uaigc.worldcup.component.e(this)));
    L63:
        z8 r22 = h3();
        if (r22 == null) goto L66;
        r22.y9(2, new g9.a(new com.larus.uaigc.worldcup.component.f(this)));
    L66:
        z8 r23 = h3();
        if (r23 == null) goto L69;
        r23.y9(3, new g9.a(new com.larus.uaigc.worldcup.component.g(this)));
    L69:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r24 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.r.getValue();
        if (r24 == null) goto L72;
        r24.hideBackground();
    L72:
        View r25 = r6.findViewById(2131362044);
        if (r25 == null) goto L79;
        ViewGroup.LayoutParams r26 = r25.getLayoutParams();
        if (r26 == null) goto L78;
        r26.height = 0;
        r25.setLayoutParams(r26);
        goto L79
    L78:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L79:
        zb8.e r27 = (zb8.e) this.s.getValue();
        if (r27 == null) goto L82;
        r27.y80();
    L82:
        this.B = System.currentTimeMillis();
    }

    public final boolean p3(g9.c r7) {
        zz9.b r0 = m3();
        String r1 = null;
        if (r0 == null) goto L5;
        ClickPocketInfo r2 = r0.Ka();
    L7:
        if (r2 == null) goto L71;
        zz9.b r3 = m3();
        if (r3 == null) goto L13;
        ClickPocketInfo r4 = r3.Ka();
        if (r4 == null) goto L13;
        Pocket r5 = r4.getPocket();
    L14:
        if (r5 == null) goto L72;
        zz9.b r6 = m3();
        if (r6 == null) goto L27;
        ClickPocketInfo r8 = r6.Ka();
        if (r8 == null) goto L27;
        Pocket r9 = r8.getPocket();
        if (r9 == null) goto L27;
        Integer r10 = r9.getPocketType();
        if (r10 == null) goto L27;
        if (r10.intValue() != 1) goto L27;
        boolean r11 = true;
    L28:
        if (r11 == true) goto L73;
        zz9.b r12 = m3();
        if (r12 == null) goto L41;
        ClickPocketInfo r13 = r12.Ka();
        if (r13 == null) goto L41;
        Pocket r14 = r13.getPocket();
        if (r14 == null) goto L41;
        Integer r15 = r14.getPocketType();
        if (r15 == null) goto L41;
        if (r15.intValue() != 4) goto L41;
        boolean r16 = true;
    L42:
        if (r16 == false) goto L55;
        zz9.b r17 = m3();
        if (r17 == null) goto L52;
        ClickPocketInfo r18 = r17.Ka();
        if (r18 == null) goto L52;
        Pocket r19 = r18.getPocket();
        if (r19 == null) goto L52;
        JumpSomewherePocket r20 = r19.getJumpSomewherePocket();
        if (r20 == null) goto L52;
        String r21 = r20.getJumpSchemaUrl();
    L54:
        if (o0.d(r21) == false) goto L55;
        return false;
    L52:
        r21 = null;
    L55:
        h9 r22 = r7.h();
        r22.a(1.0f);
        r22.b(true);
        r22.e(true);
        va8.o r23 = (va8.o) this.n.getValue();
        if (r23 == null) goto L59;
        r1 = r23.u7();
    L59:
        if (o0.d(r1) == false) goto L68;
        ICoreInputAbility r24 = (ICoreInputAbility) this.m.getValue();
        if (r24 != null) goto L63;
    L65:
        boolean r25 = false;
    L66:
        if (r25 == true) goto L68;
        r7.i().e(false);
    L69:
        r7.e().e(false);
        r7.d().e(false);
        r7.g().e(false);
        r7.f().e(false);
        r7.k().d(4);
        r7.j().e(true);
        return true;
    L63:
        if (r24.l6() != true) goto L65;
        r25 = true;
    L68:
        h9 r26 = r7.i();
        r26.a(1.0f);
        r26.b(true);
        r26.e(true);
    L41:
        r16 = false;
        goto L42
    L73:
        return false;
    L27:
        r11 = false;
        goto L28
    L72:
        return false;
    L13:
        r5 = null;
        goto L14
    L71:
        return false;
    L5:
        r2 = null;
        goto L7
    }

    @Override // zz9.a
    public final void C7(ICoreInputAbility.OnSendParams r12, String r13, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "scene");
        Intrinsics.checkNotNullParameter(r14, "asrResult");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new WorldCupInputComponent$handleSendMessageAndGoChatPage$1(r12, this, r13, r14, r15, null), 2, null);
    }

    public final void z3(ICoreInputAbility.OnSendParams r45, String r46, String r47, boolean r48, Map<String, ? extends Object> r49) {
        y r0 = (y) this.o.getValue();
        Object r3 = null;
        if (r0 == null) goto L34;
        wc9.e r1 = r0.h();
        if (r1 == null) goto L34;
        String r2 = r1.a;
        IAIChatRenderTraceService.Companion r4 = IAIChatRenderTraceService.a;
        Map<String, String> r5 = r4.d(r2);
        zz9.b r6 = m3();
        if (r6 == null) goto L14;
        ClickPocketInfo r7 = r6.Ka();
        if (r7 == null) goto L14;
        Pocket r8 = r7.getPocket();
        if (r8 == null) goto L14;
        String r9 = r8.getPocketId();
        if (r9 == null) goto L14;
    L15:
        if (r5 == null) goto L18;
        Map<String, String> r10 = MapsKt.toMutableMap(r5);
        if (r10 == null) goto L18;
    L19:
        r10.put("spring_guide_card_id", r9);
        com.larus.uaigc.worldcup.component.a r11 = (com.larus.uaigc.worldcup.component.a) this.z.getValue();
        if (r11 == null) goto L22;
        String r12 = r11.a();
    L23:
        r10.put("action_bar_key", r12);
        r10.put("enter_method", "world_cup_2026");
        r10.put("prompt_from", "world_cup_2026");
        com.larus.uaigc.worldcup.component.a r13 = (com.larus.uaigc.worldcup.component.a) this.z.getValue();
        if (r13 == null) goto L26;
        String r14 = r13.a();
    L28:
        if (o0.d(r14) == false) goto L31;
        r10.put("must_override_action_bar_key", "1");
    L31:
        if (o0.d(r46) == false) goto L33;
        r10.put("must_override_scene", "1");
    L33:
        r4.c(r2, r10);
        goto L34
    L26:
        r14 = null;
        goto L28
    L22:
        r12 = null;
    L18:
        r10 = new LinkedHashMap();
    L14:
        r9 = "";
    L34:
        LinkedHashMap r15 = new LinkedHashMap();
        Map r16 = r45.messageExt;
        if (r16 != null) goto L37;
    L39:
        boolean r17 = false;
    L40:
        if (r17 == false) goto L42;
        r15.putAll(r16);
    L42:
        LinkedHashMap r18 = new LinkedHashMap();
        if (o0.d((String) r15.get("pocket_map")) == false) goto L45;
        com.larus.uaigc.lynx.j.a.getClass();
        r18.put("chat_lite_option", com.larus.uaigc.lynx.j.a());
    L45:
        long r19 = System.currentTimeMillis() - this.B;
        FLogger r20 = FLogger.a;
        r20.i("WorldCupInputComponent", "entry to send msg cost = " + r19 + " extra = " + r49);
        r18.put("pocket_entry_to_send_msg_cost", String.valueOf(r19));
        if (e0a.a.a(r49) == false) goto L51;
        boolean r21 = e0a.b.a();
        r20.i("WorldCupInputComponent", "isInLotteryState state:" + r21);
        if (r21 == true) goto L50;
        r18.put("chat_round_first_raf", "1");
        r18.put("user_input_emoji_scene", "world_cup");
        e0a.b.a.storeBoolean("lottery_state_".concat(com.larus.platform.service.o.a.getDeviceId()), true);
    L50:
        String r22 = (String) r18.put("chat_raf_option", "1");
    L52:
        if (r48 == false) goto L54;
        String r23 = r47;
    L59:
        if (o0.d(r23) == true) goto L79;
    L71:
        r15.putAll(r18);
        ICoreInputAbility.OnSendParams r24 = ICoreInputAbility.OnSendParams.copy$default(r45, null, null, null, null, null, null, null, null, 0, false, null, false, false, false, null, null, null, null, false, null, r15, null, null, null, null, null, null, null, null, null, null, null, null, -1048577, 1, null);
        ICoreInputAbility r25 = (ICoreInputAbility) this.m.getValue();
        if (r25 == null) goto L74;
        r25.E0(r24);
    L74:
        zz9.b r26 = m3();
        if (r26 == null) goto L77;
        r26.K9();
    L77:
        h6();
        return;
    L79:
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L62
        Object r28 = Result.constructor-impl(((Gson) this.C.getValue()).toJson(MapsKt.mapOf(TuplesKt.to("user_input_content", r23))));     // Catch: Throwable -> L62
    L65:
        if (Result.isFailure-impl(r28) == true) goto L68;
        r3 = r28;
    L68:
        String r29 = (String) r3;
        if (r29 == null) goto L71;
        String r30 = (String) r18.put("pocket_custom_ext", r29);
    L62:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L65
    L54:
        va8.o r32 = (va8.o) this.n.getValue();
        if (r32 == null) goto L57;
        r23 = r32.u7();
        goto L59
    L57:
        r23 = null;
        goto L59
    L51:
        String r33 = (String) r18.put("chat_raf_option", "0");
        goto L52
    L37:
        if ((!r16.isEmpty()) != true) goto L39;
        r17 = true;
        goto L40
    }
}
