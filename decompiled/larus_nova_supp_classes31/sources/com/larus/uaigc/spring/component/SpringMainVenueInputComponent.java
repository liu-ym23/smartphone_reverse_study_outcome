package com.larus.uaigc.spring.component;

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
import com.larus.bmhome.chat.d4;
import com.larus.bmhome.chat.j4;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.uaigc.lynx.Scatter;
import com.larus.uaigc.lynx.pocket.ClickPocketInfo;
import com.larus.uaigc.lynx.pocket.JumpSomewherePocket;
import com.larus.uaigc.lynx.pocket.Pocket;
import com.larus.uaigc.service.IZLotteryService;
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
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u0086\u00012\u00020\u00012\u00020\u0002:\u0002\u0086\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010^\u001a\u00020_H\u0016J\u0010\u0010`\u001a\u00020_2\u0006\u0010a\u001a\u00020]H\u0017J\f\u0010b\u001a\u00020O*\u00020cH\u0002J\f\u0010d\u001a\u00020O*\u00020cH\u0002J\b\u0010e\u001a\u00020_H\u0016J\b\u0010f\u001a\u00020_H\u0002J\b\u0010g\u001a\u00020_H\u0002J\b\u0010h\u001a\u00020_H\u0016J\b\u0010i\u001a\u00020_H\u0016J\b\u0010j\u001a\u00020_H\u0016J\b\u0010k\u001a\u00020OH\u0016J\u0010\u0010l\u001a\u00020_2\u0006\u0010m\u001a\u00020OH\u0016J\b\u0010n\u001a\u00020oH\u0016J0\u0010p\u001a\u00020_2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020v2\u0006\u0010x\u001a\u00020OH\u0002J\u0012\u0010y\u001a\u00020_2\b\b\u0002\u0010u\u001a\u00020vH\u0002J.\u0010z\u001a\u00020_2\u0012\u0010{\u001a\u000e\u0012\u0004\u0012\u00020v\u0012\u0004\u0012\u00020v0|2\b\b\u0002\u0010w\u001a\u00020v2\u0006\u0010x\u001a\u00020OH\u0002J*\u0010}\u001a\u00020_2\u0006\u0010~\u001a\u00020t2\b\b\u0002\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020v2\u0006\u0010x\u001a\u00020OH\u0002J*\u0010\u007f\u001a\u00020_2\b\u0010s\u001a\u0004\u0018\u00010t2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020v2\u0006\u0010x\u001a\u00020OH\u0016J3\u0010\u0080\u0001\u001a\u0011\u0012\u0004\u0012\u00020v\u0012\u0004\u0012\u00020v\u0018\u00010\u0081\u00012\u0019\u0010\u0082\u0001\u001a\u0014\u0012\u0004\u0012\u00020v\u0012\u0007\u0012\u0005\u0018\u00010\u0083\u0001\u0018\u00010\u0081\u0001H\u0002J&\u0010\u0084\u0001\u001a\u0004\u0018\u00010v2\u0019\u0010\u0085\u0001\u001a\u0014\u0012\u0004\u0012\u00020v\u0012\u0007\u0012\u0005\u0018\u00010\u0083\u0001\u0018\u00010\u0081\u0001H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u001d\u0010$\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\n\u001a\u0004\b&\u0010'R\u001d\u0010)\u001a\u0004\u0018\u00010*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b+\u0010,R\u0016\u0010.\u001a\u0004\u0018\u00010/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u001d\u00102\u001a\u0004\u0018\u0001038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\n\u001a\u0004\b4\u00105R\u001d\u00107\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\n\u001a\u0004\b9\u0010:R\u001d\u0010<\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\n\u001a\u0004\b=\u0010\"R\u001d\u0010?\u001a\u0004\u0018\u00010@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\n\u001a\u0004\bA\u0010BR\u001d\u0010D\u001a\u0004\u0018\u00010E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\n\u001a\u0004\bF\u0010GR\u001d\u0010I\u001a\u0004\u0018\u00010J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\n\u001a\u0004\bK\u0010LR\u000e\u0010N\u001a\u00020OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010R\u001a\u00020S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\n\u001a\u0004\bT\u0010UR\u001d\u0010W\u001a\u0004\u0018\u00010X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\n\u001a\u0004\bY\u0010ZR\u0010\u0010\\\u001a\u0004\u0018\u00010]X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0087\u0001"}, d2 = {"Lcom/larus/uaigc/spring/component/SpringMainVenueInputComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/uaigc/spring/ability/MainVenueInputAbility;", "<init>", "()V", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "mainVenueLynxAbility", "Lcom/larus/uaigc/spring/ability/MainVenueLynxAbility;", "getMainVenueLynxAbility", "()Lcom/larus/uaigc/spring/ability/MainVenueLynxAbility;", "mainVenueLynxAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "speakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "speakerAbility$delegate", "chatCameraAbility", "Lcom/larus/bmhome/camera/IChatCameraAbility;", "getChatCameraAbility", "()Lcom/larus/bmhome/camera/IChatCameraAbility;", "chatCameraAbility$delegate", "multimodalInputAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "getMultimodalInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "multimodalInputAbility$delegate", "bottomMenuAbility", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "getBottomMenuAbility", "()Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "springMainVenueShuffleTimesAbility", "Lcom/larus/uaigc/spring/ability/SpringMainVenueShuffleTimesAbility;", "getSpringMainVenueShuffleTimesAbility", "()Lcom/larus/uaigc/spring/ability/SpringMainVenueShuffleTimesAbility;", "springMainVenueShuffleTimesAbility$delegate", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "chatBottomSpeakerAbility", "getChatBottomSpeakerAbility", "chatBottomSpeakerAbility$delegate", "fastSendImageAbility", "Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "getFastSendImageAbility", "()Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "fastSendImageAbility$delegate", "reportAbility", "Lcom/larus/uaigc/spring/ability/SpringMainVenueReportAbility;", "getReportAbility", "()Lcom/larus/uaigc/spring/ability/SpringMainVenueReportAbility;", "reportAbility$delegate", "argumentData", "Lcom/larus/uaigc/spring/launcher/SpringMainVenueArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/spring/launcher/SpringMainVenueArgumentData;", "argumentData$delegate", "inputVisibleStatus", "", "viewCreatedTimeMs", "", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "coreInputManager", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "getCoreInputManager", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "coreInputManager$delegate", "rootView", "Landroid/view/View;", "onAttach", "", "onViewCreated", "view", "interceptActionSendWhenSpeak", "Lcom/larus/bmhome/chat/component/bottom/core/InputView$Operator;", "interceptActionSend", "onResume", "toChatPage", "backToChatPage", "handleSendMessagePageEnd", "recoveryInputContainerVisibleStatus", "forceShowInputContainer", "isInputVisibleStatus", "setInputContainerVisible", "visible", "getBottomInset", "", "handleUploadInputPocketSendMessage", "pocket", "Lcom/larus/uaigc/lynx/pocket/Pocket;", "onSendParams", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "scene", "", "asrResult", "fromAsr", "handleTraceBeforeSendMessage", "appendMainVenueMessageExt", "newExtMap", "", "sendMessage", "params", "handleSendMessageAndGoChatPage", "getMessageExtFromPocketDict", "", "originData", "", "dictToJson", "dict", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SpringMainVenueInputComponent extends BaseContentWidget implements zz9.a {
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

    public static final class d implements Function0<com.larus.bmhome.chat.component.fastsend.e0> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.fastsend.e0.class));
        }
    }

    public static final class e implements Function0<zz9.d> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(zz9.d.class));
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

    public static final class h implements Function0<com.larus.bmhome.chat.component.cvs.y> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
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

    public static final class o implements Function0<a0a.b> {
        public final /* synthetic */ AttachReceiver a;

        public o(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(a0a.b.class));
        }
    }

    static {
    }

    public final void E3() {
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

    public final a0a.b h3() {
        return (a0a.b) this.z.getValue();
    }

    @Override // zz9.a
    public final void h6() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L15
        FragmentActivity r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();     // Catch: Throwable -> L15
        if (r1 != null) goto L5;
        E3();     // Catch: Throwable -> L15
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
        E3();     // Catch: Throwable -> L15
        goto L13
    L8:
        if (r2.s1() == false) goto L10;
        r3 = true;
    L15:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void onResume() {
        com.larus.bmhome.chat.component.bottom.core.speaker.l r0 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.r.getValue();
        if (r0 == null) goto L5;
        r0.b3(new com.larus.uaigc.spring.component.a(this));
    L5:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r1 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.r.getValue();
        if (r1 == null) goto L9;
        r1.KH(new com.larus.uaigc.spring.component.b(this));
        return;
    }

    public final z8 p3() {
        return (z8) this.D.getValue();
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

    public final zz9.b z3() {
        return (zz9.b) this.p.getValue();
    }

    public SpringMainVenueInputComponent() {
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
        this.C = LazyKt.lazy(new com.larus.uaigc.spring.component.c());
        this.D = LazyKt.lazy(new com.larus.uaigc.spring.component.d(this));
    }

    public final f1 m3() {
        return s1a.d.a(this).getAbility(f1.class);
    }

    public final void B3(String r7) {
        com.larus.bmhome.chat.component.cvs.y r0 = (com.larus.bmhome.chat.component.cvs.y) this.o.getValue();
        if (r0 == null) goto L38;
        wc9.e r1 = r0.h();
        if (r1 == null) goto L39;
        String r2 = r1.a;
        IAIChatRenderTraceService.Companion r3 = IAIChatRenderTraceService.a;
        Map<String, String> r4 = r3.d(r2);
        zz9.b r5 = z3();
        if (r5 == null) goto L14;
        ClickPocketInfo r6 = r5.Ka();
        if (r6 == null) goto L14;
        Pocket r8 = r6.getPocket();
        if (r8 == null) goto L14;
        String r9 = r8.getPocketId();
        if (r9 == null) goto L14;
    L15:
        if (r4 == null) goto L18;
        Map<String, String> r10 = MapsKt.toMutableMap(r4);
        if (r10 == null) goto L18;
    L19:
        r10.put("spring_guide_card_id", r9);
        r10.put("is_spring_guide", "spring_guide_2026");
        a0a.b r11 = h3();
        String r12 = null;
        if (r11 == null) goto L22;
        String r13 = r11.a();
    L23:
        r10.put("action_bar_key", r13);
        a0a.b r14 = h3();
        if (r14 == null) goto L26;
        String r15 = r14.b();
    L27:
        r10.put("enter_method", r15);
        r10.put("scene", r7);
        a0a.b r16 = h3();
        if (r16 == null) goto L31;
        r12 = r16.a();
    L31:
        if (o0.d(r12) == false) goto L34;
        r10.put("must_override_action_bar_key", "1");
    L34:
        if (o0.d(r7) == false) goto L36;
        r10.put("must_override_scene", "1");
    L36:
        r3.c(r2, r10);
        return;
    L26:
        r15 = null;
        goto L27
    L22:
        r13 = null;
    L18:
        r10 = new LinkedHashMap();
    L14:
        r9 = "";
        goto L15
    L39:
        return;
    }

    public final boolean C3(g9.c r7) {
        zz9.b r0 = z3();
        String r1 = null;
        if (r0 == null) goto L5;
        ClickPocketInfo r2 = r0.Ka();
    L7:
        if (r2 == null) goto L71;
        zz9.b r3 = z3();
        if (r3 == null) goto L13;
        ClickPocketInfo r4 = r3.Ka();
        if (r4 == null) goto L13;
        Pocket r5 = r4.getPocket();
    L14:
        if (r5 == null) goto L72;
        zz9.b r6 = z3();
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
        zz9.b r12 = z3();
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
        zz9.b r17 = z3();
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
    public final void T9(boolean r5) {
        if (r5 == false) goto L23;
        View r1 = this.E;
        if (r1 == null) goto L9;
        View r0 = r1.findViewById(2131375324);
        if (r0 == null) goto L9;
        e1.x(r0);
    L9:
        zz9.d r2 = (zz9.d) this.y.getValue();
        if (r2 == null) goto L28;
        zz9.b r3 = z3();
        String r4 = null;
        if (r3 == null) goto L18;
        ClickPocketInfo r6 = r3.Ka();
        if (r6 == null) goto L18;
        Pocket r7 = r6.getPocket();
        if (r7 == null) goto L18;
        String r8 = r7.getPocketId();
    L19:
        a0a.b r9 = h3();
        if (r9 == null) goto L22;
        r4 = r9.a();
    L22:
        r2.EN(r8, r4);
    L18:
        r8 = null;
    L28:
        this.A = r5;
        return;
    L23:
        View r10 = this.E;
        if (r10 == null) goto L28;
        View r11 = r10.findViewById(2131375324);
        if (r11 == null) goto L28;
        e1.o(r11);
        goto L28
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
        r4.tr(new com.larus.uaigc.spring.component.e(this));
    L15:
        f1 r5 = m3();
        if (r5 == null) goto L18;
        r5.HN();
    L18:
        f1 r7 = m3();
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
        f1 r10 = m3();
        if (r10 == null) goto L30;
        r10.sx();
    L30:
        f1 r11 = m3();
        if (r11 == null) goto L33;
        r11.g20();
    L33:
        z8 r12 = p3();
        if (r12 == null) goto L36;
        r12.z9(false);
    L36:
        z8 r13 = p3();
        if (r13 == null) goto L39;
        r13.R8();
    L39:
        z8 r14 = p3();
        if (r14 == null) goto L42;
        r14.s9();
    L42:
        z8 r15 = p3();
        if (r15 == null) goto L45;
        r15.f9(true);
    L45:
        z8 r16 = p3();
        if (r16 == null) goto L48;
        r16.X8();
    L48:
        z8 r17 = p3();
        if (r17 == null) goto L52;
        r17.n9(true);
    L52:
        if (IZLotteryService.a.k() == false) goto L56;
        g1 r18 = (g1) this.v.getValue();
        if (r18 == null) goto L56;
        r18.p20();
    L56:
        g1 r19 = (g1) this.v.getValue();
        if (r19 == null) goto L59;
        r19.yj();
    L59:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r20 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.w.getValue();
        if (r20 == null) goto L62;
        r20.TO();
    L62:
        com.larus.bmhome.chat.component.fastsend.e0 r21 = (com.larus.bmhome.chat.component.fastsend.e0) this.x.getValue();
        if (r21 == null) goto L65;
        r21.qD();
    L65:
        z8 r22 = p3();
        if (r22 == null) goto L68;
        r22.y9(1, new g9.a(new com.larus.uaigc.spring.component.f(this)));
    L68:
        z8 r23 = p3();
        if (r23 == null) goto L71;
        r23.y9(2, new g9.a(new com.larus.uaigc.spring.component.g(this)));
    L71:
        z8 r24 = p3();
        if (r24 == null) goto L74;
        r24.y9(3, new g9.a(new com.larus.uaigc.spring.component.h(this)));
    L74:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r25 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.r.getValue();
        if (r25 == null) goto L77;
        r25.hideBackground();
    L77:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r26 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.r.getValue();
        if (r26 == null) goto L80;
        r26.zu();
    L80:
        View r27 = r6.findViewById(2131362044);
        if (r27 == null) goto L87;
        ViewGroup.LayoutParams r28 = r27.getLayoutParams();
        if (r28 == null) goto L86;
        r28.height = 0;
        r27.setLayoutParams(r28);
        goto L87
    L86:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L87:
        zb8.e r29 = (zb8.e) this.s.getValue();
        if (r29 == null) goto L90;
        r29.y80();
    L90:
        this.B = System.currentTimeMillis();
    }

    public final void Y2(Map<String, String> r28, String r29, boolean r30) {
        LinkedHashMap r3 = new LinkedHashMap();
        zz9.e r0 = (zz9.e) this.u.getValue();
        if (r0 == null) goto L5;
        r0.BD();
    L5:
        boolean r1 = z2.a.enableNonLotteryShuffle();
        IZLotteryService.Companion r4 = IZLotteryService.a;
        boolean r5 = r4.k();
        FLogger r6 = FLogger.a;
        String r8 = "SpringMainVenueComponent";
        r6.i("SpringMainVenueComponent", "[appendMainVenueMessageExt] enableNonLotteryShuffle = " + r1 + ", isInLotteryRound = " + r5);
        String r10 = "delay_request_interval_ms";
        if (r1 == false) goto L20;
        if (r5 == true) goto L20;
        zz9.e r2 = (zz9.e) this.u.getValue();
        if (r2 == null) goto L12;
        Map<String, zz9.c> r7 = r2.SH();
        if (r7 == null) goto L12;
    L13:
        zz9.c r9 = r7.get("delay_request_interval_ms");
        StringBuilder r11 = new StringBuilder("[appendMainVenueMessageExt] nonLotteryShuffleTime = ");
        if (r9 == null) goto L16;
        Integer r12 = Integer.valueOf(r9.a);
    L17:
        r11.append(r12);
        r6.i("SpringMainVenueComponent", r11.toString());
        if (r9 == null) goto L20;
        int r13 = r9.a;
        r4.l("delay_request_interval_ms");
    L21:
        hy9.g r14 = r4.n();
        Long r15 = PollingConfigService.a.c();
        zz9.e r16 = (zz9.e) this.u.getValue();
        if (r16 == null) goto L25;
        Map<String, zz9.c> r17 = r16.Ex();
        if (r17 == null) goto L25;
    L26:
        zz9.c r18 = r17.get("delay_request_interval_ms");
        if (r18 == null) goto L29;
        Integer r19 = Integer.valueOf(r18.b);
    L30:
        r6.i("SpringMainVenueComponent", "[appendMainVenueMessageExt] validDuration = " + r19 + ", curTime = " + r15);
        if (r19 != null) goto L33;
    L56:
        r13 = r13;
        LinkedHashMap r22 = r3;
        r8 = "SpringMainVenueComponent";
    L57:
        int r20 = r13;
    L58:
        com.larus.uaigc.lynx.j.a.getClass();
        Scatter r21 = com.larus.uaigc.lynx.j.e();
        if (r21 == null) goto L61;
        Integer r23 = r21.getLotteryFront();
    L62:
        if (r21 == null) goto L64;
        Integer r24 = r21.getLotteryRear();
    L65:
        r6.i(r8, "[appendMainVenueMessageExt] lotteryFront = " + r23 + ", lotteryRear = " + r24 + ", curTime = " + r15);
        if (r23 == null) goto L68;
        int r25 = r23.intValue();
    L69:
        hy9.g r26 = r4.c(r25);
        if (r23 != null) goto L72;
    L115:
        r20 = r20;
        IZLotteryService.Companion r27 = r4;
        String r31 = r8;
        FLogger r110 = r6;
    L116:
        int r32 = r20;
    L117:
        String r33 = String.valueOf(r32);
        LinkedHashMap r34 = r22;
        r34.put(r10, r33);
        if (o0.d((String) ((LinkedHashMap) r28).get("pocket_map")) == false) goto L120;
        r34.put("chat_lite_option", com.larus.uaigc.lynx.j.a());
    L120:
        long r35 = System.currentTimeMillis() - this.B;
        r110.i(r31, "entry to send msg cost = " + r35);
        r34.put("pocket_entry_to_send_msg_cost", String.valueOf(r35));
        if (r27.k() == true) goto L123;
        String r36 = (String) r34.put("chat_raf_option", "0");
    L127:
        if (r30 == false) goto L129;
        String r37 = r29;
    L134:
        if (o0.d(r37) == true) goto L148;
    L146:
        r28.putAll(r34);
        return;
    L148:
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L137
        Object r39 = Result.constructor-impl(((Gson) this.C.getValue()).toJson(MapsKt.mapOf(TuplesKt.to("user_input_content", r37))));     // Catch: Throwable -> L137
    L140:
        if (Result.isFailure-impl(r39) == false) goto L142;
        Object r40 = null;
    L143:
        String r41 = (String) r40;
        if (r41 == null) goto L146;
        String r42 = (String) r34.put("pocket_custom_ext", r41);
        goto L146
    L142:
        r40 = r39;
    L137:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        r39 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L140
    L129:
        va8.o r44 = (va8.o) this.n.getValue();
        if (r44 == null) goto L132;
        r37 = r44.u7();
        goto L134
    L132:
        r37 = null;
        goto L134
    L123:
        if (r27.t() == true) goto L125;
        r34.put("chat_round_first_raf", "1");
        r27.a();
    L125:
        String r45 = (String) r34.put("chat_raf_option", "1");
        goto L127
    L72:
        if (r23.intValue() < 0) goto L115;
        if (r24 == null) goto L115;
        if (r24.intValue() < 0) goto L115;
        if (r26 == null) goto L115;
        if (r26.d() == null) goto L115;
        if (r26.a() == null) goto L115;
        if (r15 == null) goto L115;
        zz9.e r46 = (zz9.e) this.u.getValue();
        if (r46 == null) goto L86;
        Map<String, zz9.c> r47 = r46.T20();
        if (r47 == null) goto L86;
    L87:
        zz9.c r48 = r47.get(r10);
        Long r111 = r26.a();
        if (r111 == null) goto L90;
        long r112 = r111.longValue();
    L91:
        Long r113 = r26.b();
        if (r113 == null) goto L94;
        long r49 = r113.longValue();
    L95:
        String r210 = r8;
        if ((r112 - ((long) r23.intValue())) <= 0) goto L98;
        long r50 = r112 - ((long) r23.intValue());
    L99:
        r110 = r6;
        if ((((long) r24.intValue()) + r112) >= r49) goto L102;
        long r51 = ((long) r24.intValue()) + r112;
    L103:
        if (r48 == null) goto L105;
        r32 = r48.a;
    L106:
        r31 = r210;
        r110.i(r31, "[appendMainVenueMessageExt] roundNum = " + r26.d() + ", beginShuffleTime = " + r32 + ", curTime = " + r15 + ", shuffleFrontMs = " + r50 + ", shuffleRearMs = " + r51 + ", beginMs = " + r112 + ", endMs = " + r49);
        if (r15.longValue() >= r50) goto L109;
    L114:
        r27 = r4;
        goto L116
    L109:
        if (r15.longValue() >= r51) goto L114;
        Integer r52 = r26.d();
        if (r52 == null) goto L113;
        r10 = r10;
        r27 = r4;
        r27.p(r52.intValue(), r10);
        goto L117
    L113:
        r10 = r10;
        r27 = r4;
        goto L117
    L105:
        r32 = 0;
        goto L106
    L102:
        r51 = r49;
        goto L103
    L98:
        r50 = r112;
        goto L99
    L94:
        r49 = 0;
        goto L95
    L90:
        r112 = 0;
    L86:
        r47 = MapsKt.emptyMap();
        goto L87
    L68:
        r25 = 0;
        goto L69
    L64:
        r24 = null;
        goto L65
    L61:
        r23 = null;
        goto L62
    L33:
        if (r19.intValue() <= 0) goto L56;
        if (r14 == null) goto L56;
        if (r14.c() == null) goto L56;
        if (r15 == null) goto L56;
        Long r114 = r14.c();
        if (r114 == null) goto L41;
        long r53 = r114.longValue();
    L42:
        Long r54 = r14.b();
        if (r54 == null) goto L45;
        long r55 = r54.longValue();
    L46:
        r22 = r3;
        if ((((long) r19.intValue()) + r53) >= r55) goto L49;
        long r56 = ((long) r19.intValue()) + r53;
    L50:
        r6.i(r8, "[appendMainVenueMessageExt] horseShuffleTime = " + r18.a + ", curTime = " + r15 + ", horseMs = " + r53 + ", endMs = " + r55 + ", shuffleEndMs = " + r56);
        if (r15.longValue() < r53) goto L57;
        if (r15.longValue() >= r56) goto L57;
        r10 = r10;
        r4.g(r10);
        r20 = r18.a;
        goto L58
    L49:
        r56 = r55;
        goto L50
    L45:
        r55 = 0;
        goto L46
    L41:
        r53 = 0;
        goto L42
    L29:
        r19 = null;
    L25:
        r17 = MapsKt.emptyMap();
        goto L26
    L16:
        r12 = null;
    L12:
        r7 = MapsKt.emptyMap();
    L20:
        r13 = 0;
        goto L21
    }

    @Override // zz9.a
    public final void C7(ICoreInputAbility.OnSendParams r12, String r13, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "scene");
        Intrinsics.checkNotNullParameter(r14, "asrResult");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new SpringMainVenueInputComponent$handleSendMessageAndGoChatPage$1(r12, this, r13, r14, r15, null), 2, null);
    }

    public final void D3(ICoreInputAbility.OnSendParams r39, String r40, String r41, boolean r42) {
        B3(r40);
        LinkedHashMap r1 = new LinkedHashMap();
        Map<? extends String, ? extends String> r2 = r39.messageExt;
        if (r2 == null) goto L7;
        boolean r4 = true;
        if ((!r2.isEmpty()) != true) goto L7;
    L8:
        if (r4 == false) goto L10;
        r1.putAll(r2);
    L10:
        Y2(r1, r41, r42);
        ICoreInputAbility.OnSendParams r3 = ICoreInputAbility.OnSendParams.copy$default(r39, null, null, null, null, null, null, null, null, 0, false, null, false, false, false, null, null, null, null, false, null, r1, null, null, null, null, null, null, null, null, null, null, null, null, -1048577, 1, null);
        ICoreInputAbility r5 = (ICoreInputAbility) this.m.getValue();
        if (r5 == null) goto L13;
        r5.E0(r3);
    L13:
        zz9.b r6 = z3();
        if (r6 == null) goto L16;
        r6.K9();
    L16:
        h6();
        return;
    L7:
        r4 = false;
        goto L8
    }
}
