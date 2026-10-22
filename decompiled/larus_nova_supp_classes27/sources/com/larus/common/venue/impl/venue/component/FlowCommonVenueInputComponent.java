package com.larus.common.venue.impl.venue.component;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.router.SmartRouter;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.o0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.larus.bmhome.chat.component.bottom.core.h9;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.bmhome.chat.component.fastsend.e0;
import com.larus.bmhome.chat.d4;
import com.larus.bmhome.chat.j4;
import com.larus.btm.api.IBTMService;
import com.larus.common.apphost.AppHost;
import com.larus.common.venue.api.AssistantBizScene;
import com.larus.common.venue.impl.venue.api.JumpSomewherePocket;
import com.larus.common.venue.impl.venue.api.Pocket;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.model.action.SuggestedActionScene;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\b\u0018\u0000 \u0085\u00012\u00020\u00012\u00020\u0002:\u0002\u0085\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010V\u001a\u00020WH\u0016J\u0010\u0010X\u001a\u00020W2\u0006\u0010Y\u001a\u00020UH\u0017J$\u0010Z\u001a\u001e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020]0[j\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020]`^H\u0002J\f\u0010_\u001a\u00020G*\u00020`H\u0002J\f\u0010a\u001a\u00020G*\u00020`H\u0002J\f\u0010b\u001a\u00020W*\u00020`H\u0002J\b\u0010c\u001a\u00020WH\u0016J\b\u0010d\u001a\u00020WH\u0002J\b\u0010e\u001a\u00020WH\u0002J\b\u0010f\u001a\u00020WH\u0016J\b\u0010g\u001a\u00020WH\u0016J\b\u0010h\u001a\u00020WH\u0016J\b\u0010i\u001a\u00020GH\u0016J\u0010\u0010j\u001a\u00020W2\u0006\u0010k\u001a\u00020GH\u0016J\b\u0010l\u001a\u00020mH\u0016J0\u0010n\u001a\u00020W2\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020\\2\u0006\u0010t\u001a\u00020\\2\u0006\u0010u\u001a\u00020GH\u0002J\u0012\u0010v\u001a\u00020W2\b\b\u0002\u0010s\u001a\u00020\\H\u0002J.\u0010w\u001a\u00020W2\u0012\u0010x\u001a\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\\0y2\b\b\u0002\u0010t\u001a\u00020\\2\u0006\u0010u\u001a\u00020GH\u0002J*\u0010z\u001a\u00020W2\u0006\u0010{\u001a\u00020r2\b\b\u0002\u0010s\u001a\u00020\\2\u0006\u0010t\u001a\u00020\\2\u0006\u0010u\u001a\u00020GH\u0002J*\u0010|\u001a\u00020W2\b\u0010q\u001a\u0004\u0018\u00010r2\u0006\u0010s\u001a\u00020\\2\u0006\u0010t\u001a\u00020\\2\u0006\u0010u\u001a\u00020GH\u0016J.\u0010}\u001a\u0010\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\\\u0018\u00010~2\u0016\u0010\u007f\u001a\u0012\u0012\u0004\u0012\u00020\\\u0012\u0006\u0012\u0004\u0018\u00010]\u0018\u00010~H\u0002J#\u0010\u0080\u0001\u001a\u0004\u0018\u00010\\2\u0016\u0010\u007f\u001a\u0012\u0012\u0004\u0012\u00020\\\u0012\u0006\u0012\u0004\u0018\u00010]\u0018\u00010~H\u0002J$\u0010\u0081\u0001\u001a\u0004\u0018\u00010\\2\u0017\u0010\u0082\u0001\u001a\u0012\u0012\u0004\u0012\u00020\\\u0012\u0006\u0012\u0004\u0018\u00010]\u0018\u00010~H\u0002J\t\u0010\u0083\u0001\u001a\u00020WH\u0016J\t\u0010\u0084\u0001\u001a\u00020WH\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u001d\u0010$\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\n\u001a\u0004\b&\u0010'R\u001d\u0010)\u001a\u0004\u0018\u00010*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b+\u0010,R\u0016\u0010.\u001a\u0004\u0018\u00010/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u001d\u00102\u001a\u0004\u0018\u0001038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\n\u001a\u0004\b4\u00105R\u001d\u00107\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\n\u001a\u0004\b9\u0010:R\u001d\u0010<\u001a\u0004\u0018\u00010=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\n\u001a\u0004\b>\u0010?R\u001d\u0010A\u001a\u0004\u0018\u00010B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\n\u001a\u0004\bC\u0010DR\u000e\u0010F\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010J\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\n\u001a\u0004\bL\u0010MR\u001d\u0010O\u001a\u0004\u0018\u00010P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\n\u001a\u0004\bQ\u0010RR\u0010\u0010T\u001a\u0004\u0018\u00010UX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0086\u0001"}, d2 = {"Lcom/larus/common/venue/impl/venue/component/FlowCommonVenueInputComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/common/venue/impl/venue/ability/FlowCommonVenueInputAbility;", "<init>", "()V", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "flowCommonVenueLynxAbility", "Lcom/larus/common/venue/impl/venue/ability/FlowCommonVenueLynxAbility;", "getFlowCommonVenueLynxAbility", "()Lcom/larus/common/venue/impl/venue/ability/FlowCommonVenueLynxAbility;", "flowCommonVenueLynxAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "speakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "speakerAbility$delegate", "chatCameraAbility", "Lcom/larus/bmhome/camera/IChatCameraAbility;", "getChatCameraAbility", "()Lcom/larus/bmhome/camera/IChatCameraAbility;", "chatCameraAbility$delegate", "multimodalInputAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "getMultimodalInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "multimodalInputAbility$delegate", "bottomMenuAbility", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "getBottomMenuAbility", "()Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "suggestedActionAbility", "Lcom/larus/bmhome/chat/action/ISuggestedActionAbility;", "getSuggestedActionAbility", "()Lcom/larus/bmhome/chat/action/ISuggestedActionAbility;", "suggestedActionAbility$delegate", "fastSendImageAbility", "Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "getFastSendImageAbility", "()Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "fastSendImageAbility$delegate", "argumentData", "Lcom/larus/common/venue/impl/venue/launcher/FlowCommonVenueArgumentData;", "getArgumentData", "()Lcom/larus/common/venue/impl/venue/launcher/FlowCommonVenueArgumentData;", "argumentData$delegate", "inputVisibleStatus", "", "viewCreatedTimeMs", "", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "coreInputManager", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "getCoreInputManager", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "coreInputManager$delegate", "rootView", "Landroid/view/View;", "onAttach", "", "onViewCreated", "view", "buildCommonVenueCameraEventExt", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "interceptActionSendWhenSpeak", "Lcom/larus/bmhome/chat/component/bottom/core/InputView$Operator;", "interceptActionSend", "renderActionEntranceVisibility", "onResume", "toChatPage", "backToChatPage", "handleSendMessagePageEnd", "recoveryInputContainerVisibleStatus", "forceShowInputContainer", "isInputVisibleStatus", "setInputContainerVisible", "visible", "getBottomInset", "", "handleUploadInputPocketSendMessage", "pocket", "Lcom/larus/common/venue/impl/venue/api/Pocket;", "onSendParams", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "scene", "asrResult", "fromAsr", "handleTraceBeforeSendMessage", "appendCommonVenueMessageExt", "newExtMap", "", "sendMessage", "params", "handleSendMessageAndGoChatPage", "getMessageExtFromPocketDict", "", "originData", "getChatLiteOption", "dictToJson", "dict", "onStop", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowCommonVenueInputComponent extends BaseContentWidget implements v09.a {
    public static final /* synthetic */ int B = 0;
    public View A;
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

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SuggestedActionScene.values().length];
            r0[SuggestedActionScene.AttachmentAreaSingleImg.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[SuggestedActionScene.AttachmentAreaMultiImg.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements Function0<bc8.a> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(bc8.a.class));
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

    public static final class e implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
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

    public static final class f implements Function0<va8.o> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
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

    public static final class g implements Function0<com.larus.bmhome.chat.component.cvs.y> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
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

    public static final class h implements Function0<v09.b> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(v09.b.class));
        }
    }

    public static final class i implements Function0<com.larus.bmhome.instruction.g> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
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

    public static final class j implements Function0<com.larus.bmhome.chat.component.bottom.core.speaker.l> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
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

    public static final class k implements Function0<zb8.e> {
        public final /* synthetic */ AttachReceiver a;

        public k(AttachReceiver r1) {
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

    public static final class l implements Function0<com.larus.bmhome.chat.component.bottom.multimodal.g> {
        public final /* synthetic */ AttachReceiver a;

        public l(AttachReceiver r1) {
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

    public static final class m implements Function0<g1> {
        public final /* synthetic */ AttachReceiver a;

        public m(AttachReceiver r1) {
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

    public static final class n implements Function0<x09.a> {
        public final /* synthetic */ AttachReceiver a;

        public n(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(x09.a.class));
        }
    }

    static {
    }

    public final v09.b B3() {
        return (v09.b) this.p.getValue();
    }

    public final void H3() {
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

    @Override // v09.a
    public final int K7() {
        View r0 = this.A;
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

    public final HashMap<String, Object> Y2() {
        HashMap<String, Object> r0 = new HashMap();
        r0.put("chat_key", Long.valueOf(System.currentTimeMillis()));
        x09.a r1 = h3();
        if (r1 == null) goto L6;
        String r2 = r1.a();
        if (r2 == null) goto L6;
    L7:
        r0.put("action_bar_key", r2);
        v09.b r3 = B3();
        if (r3 == null) goto L17;
        String r4 = r3.nd();
        if (r4 == null) goto L17;
        if ((!StringsKt.isBlank(r4)) == true) goto L15;
        r4 = null;
    L15:
        if (r4 == null) goto L17;
        JSONObject r5 = new JSONObject();
        r5.put("common_venue_type", r4);
        Unit r6 = Unit.INSTANCE;
        r0.put("extra_params", r5);
    L17:
        return r0;
    L6:
        r2 = "";
        goto L7
    }

    public final x09.a h3() {
        return (x09.a) this.x.getValue();
    }

    @Override // v09.a
    public final void h6() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L15
        FragmentActivity r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();     // Catch: Throwable -> L15
        if (r1 != null) goto L5;
        H3();     // Catch: Throwable -> L15
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
        H3();     // Catch: Throwable -> L15
        goto L13
    L8:
        if (r2.s1() == false) goto L10;
        r3 = true;
    L15:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void onDestroy() {
        IBTMService r0 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r0.f(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        return;
    }

    public final void onResume() {
        com.larus.bmhome.chat.component.bottom.core.speaker.l r0 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.r.getValue();
        if (r0 == null) goto L5;
        r0.b3(new com.larus.common.venue.impl.venue.component.b(this));
    L5:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r1 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.r.getValue();
        if (r1 == null) goto L9;
        r1.KH(new com.larus.common.venue.impl.venue.component.c(this));
        return;
    }

    public final void onStop() {
        AudioServiceDelegate r0 = AudioServiceDelegate.a;
        o0.a.a(r0.h0(), null, null, null, null, null, null, null, 112);
        r0.h0().b();
        r0.h0().f();
    }

    public final ICoreInputAbility p3() {
        return (ICoreInputAbility) this.m.getValue();
    }

    @Override // v09.a
    public final void u9() {
        View r0 = this.A;
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
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, v09.a.class);
    }

    public final z8 z3() {
        return (z8) this.z.getValue();
    }

    public FlowCommonVenueInputComponent() {
        this.m = LazyKt.lazy(new e(this));
        this.n = LazyKt.lazy(new f(this));
        this.o = LazyKt.lazy(new g(this));
        this.p = LazyKt.lazy(new h(this));
        this.q = LazyKt.lazy(new i(this));
        this.r = LazyKt.lazy(new j(this));
        this.s = LazyKt.lazy(new k(this));
        this.t = LazyKt.lazy(new l(this));
        this.u = LazyKt.lazy(new m(this));
        this.v = LazyKt.lazy(new c(this));
        this.w = LazyKt.lazy(new d(this));
        this.x = LazyKt.lazy(new n(this));
        this.y = LazyKt.lazy(new com.larus.common.venue.impl.venue.component.k());
        this.z = LazyKt.lazy(new com.larus.common.venue.impl.venue.component.l(this));
    }

    public final f1 m3() {
        return s1a.d.a(this).getAbility(f1.class);
    }

    public final void C3(String r8) {
        com.larus.bmhome.chat.component.cvs.y r0 = (com.larus.bmhome.chat.component.cvs.y) this.o.getValue();
        if (r0 == null) goto L47;
        wc9.e r1 = r0.h();
        if (r1 == null) goto L48;
        String r2 = r1.a;
        IAIChatRenderTraceService.Companion r3 = IAIChatRenderTraceService.a;
        Map r4 = r3.d(r2);
        v09.b r5 = B3();
        String r6 = "";
        if (r5 == null) goto L14;
        ClickPocketInfo r7 = r5.Ka();
        if (r7 == null) goto L14;
        Pocket r9 = r7.getPocket();
        if (r9 == null) goto L14;
        String r10 = r9.getPocketId();
        if (r10 == null) goto L14;
    L15:
        if (r4 == null) goto L18;
        Map r11 = MapsKt.toMutableMap(r4);
        if (r11 == null) goto L18;
    L19:
        r11.put("common_venue_guide_card_id", r10);
        if ((!StringsKt.isBlank(r10)) == false) goto L22;
        r11.put("is_common_venue_guide", "1");
    L22:
        v09.b r12 = B3();
        if (r12 == null) goto L28;
        String r13 = r12.nd();
        if (r13 == null) goto L28;
        r6 = r13;
    L28:
        r11.put("common_venue_type", r6);
        x09.a r14 = h3();
        String r15 = null;
        if (r14 == null) goto L31;
        String r16 = r14.a();
    L32:
        r11.put("action_bar_key", r16);
        x09.a r17 = h3();
        if (r17 == null) goto L35;
        String r18 = r17.c();
    L36:
        r11.put(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, r18);
        x09.a r20 = h3();
        if (r20 == null) goto L40;
        r15 = r20.a();
    L40:
        if (com.larus.utils.o0.d(r15) == false) goto L43;
        r11.put("must_override_action_bar_key", "1");
    L43:
        if (com.larus.utils.o0.d(r8) == false) goto L45;
        r11.put("must_override_scene", "1");
    L45:
        r11.put("scene", r8);
        r3.c(r2, r11);
        return;
    L35:
        r18 = null;
        goto L36
    L31:
        r16 = null;
    L18:
        r11 = new LinkedHashMap();
    L14:
        r10 = "";
        goto L15
    L48:
        return;
    }

    public final boolean D3(g9.c r7) {
        E3(r7);
        v09.b r0 = B3();
        String r1 = null;
        if (r0 == null) goto L5;
        ClickPocketInfo r2 = r0.Ka();
    L7:
        if (r2 == null) goto L71;
        v09.b r3 = B3();
        if (r3 == null) goto L13;
        ClickPocketInfo r4 = r3.Ka();
        if (r4 == null) goto L13;
        Pocket r5 = r4.getPocket();
    L14:
        if (r5 == null) goto L72;
        v09.b r6 = B3();
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
        v09.b r12 = B3();
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
        v09.b r17 = B3();
        if (r17 == null) goto L52;
        ClickPocketInfo r18 = r17.Ka();
        if (r18 == null) goto L52;
        Pocket r20 = r18.getPocket();
        if (r20 == null) goto L52;
        JumpSomewherePocket r21 = r20.getJumpSomewherePocket();
        if (r21 == null) goto L52;
        String r22 = r21.getJumpSchemaUrl();
    L54:
        if (com.larus.utils.o0.d(r22) == false) goto L55;
        return false;
    L52:
        r22 = null;
    L55:
        h9 r23 = r7.h();
        r23.a(1.0f);
        r23.b(true);
        r23.e(true);
        va8.o r24 = (va8.o) this.n.getValue();
        if (r24 == null) goto L59;
        r1 = r24.u7();
    L59:
        if (com.larus.utils.o0.d(r1) == false) goto L68;
        ICoreInputAbility r25 = p3();
        if (r25 != null) goto L63;
    L65:
        boolean r26 = false;
    L66:
        if (r26 == true) goto L68;
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
        if (r25.l6() != true) goto L65;
        r26 = true;
    L68:
        h9 r27 = r7.i();
        r27.a(1.0f);
        r27.b(true);
        r27.e(true);
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

    public final void E3(g9.c r6) {
        boolean r1 = false;
        r6.c().e(false);
        r6.b().c(v19.c.b(2130971931, getContext(), 2131242482));
        h9 r7 = r6.a();
        va8.o r0 = (va8.o) this.n.getValue();
        if (r0 == null) goto L5;
        String r2 = r0.u7();
    L7:
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L21;
        ICoreInputAbility r4 = p3();
        if (r4 != null) goto L17;
    L19:
        boolean r5 = false;
    L20:
        if (r5 == true) goto L21;
    L22:
        r7.e(r1);
        return;
    L17:
        if (r4.J8() != true) goto L19;
        r5 = true;
    L21:
        r1 = true;
        goto L22
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r2 = null;
        goto L7
    }

    @Override // v09.a
    public final void T9(boolean r2) {
        if (r2 == false) goto L9;
        View r3 = this.A;
        if (r3 == null) goto L15;
        View r4 = r3.findViewById(2131375324);
        if (r4 == null) goto L16;
        e1.x(r4);
        return;
    L16:
        return;
    L15:
        return;
    L9:
        View r5 = this.A;
        if (r5 == null) goto L18;
        View r6 = r5.findViewById(2131375324);
        if (r6 == null) goto L19;
        e1.o(r6);
        return;
    L19:
        return;
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [com.larus.common.venue.impl.venue.component.g] */
    /* JADX WARN: Type inference failed for: r3v9, types: [com.larus.common.venue.impl.venue.component.f] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.larus.common.venue.impl.venue.component.d] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.common.venue.impl.venue.component.e] */
    public final void onViewCreated(View r11) {
        Intrinsics.checkNotNullParameter(r11, "view");
        this.A = r11;
        if (r11 == null) goto L7;
        View r1 = r11.findViewById(2131375324);
        if (r1 == null) goto L7;
        r1.setBackgroundColor(0);
    L7:
        View r2 = this.A;
        if (r2 == null) goto L12;
        View r3 = r2.findViewById(2131375364);
        if (r3 == null) goto L12;
        r3.setBackgroundColor(0);
    L12:
        ICoreInputAbility r4 = p3();
        if (r4 == null) goto L15;
        r4.tr(new com.larus.common.venue.impl.venue.component.a(this));
    L15:
        f1 r5 = m3();
        if (r5 == null) goto L18;
        r5.HN();
    L18:
        f1 r6 = m3();
        if (r6 == null) goto L21;
        r6.TA();
    L21:
        com.larus.bmhome.chat.component.bottom.multimodal.g r7 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.t.getValue();
        if (r7 == null) goto L24;
        r7.Xc(Boolean.FALSE);
    L24:
        com.larus.bmhome.chat.component.bottom.multimodal.g r8 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.t.getValue();
        if (r8 == null) goto L27;
        r8.bh(true);
    L27:
        com.larus.bmhome.chat.component.bottom.multimodal.g r9 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.t.getValue();
        if (r9 == null) goto L30;
        r9.M6();
    L30:
        x09.a r10 = h3();
        if (r10 == null) goto L33;
        Integer r12 = r10.b();
    L34:
        AssistantBizScene r13 = AssistantBizScene.EcomPrePurchase;
        int r14 = r13.getValue();
        if (r12 != null) goto L38;
    L40:
        int r15 = AssistantBizScene.Travel.getValue();
        if (r12 != null) goto L44;
    L46:
        final String r16 = "ecom_page";
    L47:
        f1 r17 = m3();
        if (r17 == null) goto L50;
        r17.B50(new com.larus.common.venue.impl.venue.component.d(this, r16));
    L50:
        f1 r18 = m3();
        if (r18 == null) goto L53;
        r18.g20();
    L53:
        z8 r20 = z3();
        if (r20 == null) goto L56;
        r20.z9(false);
    L56:
        z8 r21 = z3();
        if (r21 == null) goto L59;
        r21.R8();
    L59:
        z8 r22 = z3();
        if (r22 == null) goto L62;
        r22.s9();
    L62:
        z8 r23 = z3();
        if (r23 == null) goto L65;
        r23.f9(true);
    L65:
        z8 r24 = z3();
        if (r24 == null) goto L68;
        r24.X8();
    L68:
        z8 r25 = z3();
        if (r25 == null) goto L71;
        r25.n9(true);
    L71:
        z8 r26 = z3();
        if (r26 == null) goto L74;
        r26.S8(true);
    L74:
        z8 r27 = z3();
        if (r27 == null) goto L77;
        r27.W8(new z8.c(new com.larus.common.venue.impl.venue.component.e(this, r16), 2));
    L77:
        g1 r28 = (g1) this.u.getValue();
        if (r28 == null) goto L80;
        r28.yj();
    L80:
        int r30 = r13.getValue();
        if (r12 != null) goto L84;
    L88:
        bc8.a r31 = (bc8.a) this.v.getValue();
        if (r31 == null) goto L91;
        r31.Gh(new com.larus.common.venue.impl.venue.component.g(this));
    L91:
        e0 r32 = (e0) this.w.getValue();
        if (r32 == null) goto L94;
        r32.qD();
    L94:
        va8.o r33 = (va8.o) this.n.getValue();
        if (r33 == null) goto L97;
        r33.C40(ContextCompat.getColor(r11.getContext(), 2131103138));
    L97:
        z8 r34 = z3();
        if (r34 == null) goto L100;
        r34.y9(1, new g9.a(new com.larus.common.venue.impl.venue.component.h(this)));
    L100:
        z8 r35 = z3();
        if (r35 == null) goto L103;
        r35.y9(2, new g9.a(new com.larus.common.venue.impl.venue.component.i(this)));
    L103:
        z8 r36 = z3();
        if (r36 == null) goto L106;
        r36.y9(3, new g9.a(new com.larus.common.venue.impl.venue.component.j(this)));
    L106:
        View r110 = r11.findViewById(2131362044);
        if (r110 == null) goto L113;
        ViewGroup.LayoutParams r37 = r110.getLayoutParams();
        if (r37 == null) goto L112;
        r37.height = 0;
        r110.setLayoutParams(r37);
        goto L113
    L112:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L113:
        zb8.e r111 = (zb8.e) this.s.getValue();
        if (r111 == null) goto L116;
        r111.y80();
    L116:
        ICoreInputAbility r112 = p3();
        if (r112 == null) goto L122;
        g9.c r113 = r112.q20();
        if (r113 == null) goto L122;
        E3(r113);
    L122:
        if (Intrinsics.areEqual(r16, "ecom_page") == false) goto L126;
        IBTMService r114 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r114 == null) goto L126;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r114.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), "a35794.b106421");
    L126:
        System.currentTimeMillis();
        return;
    L84:
        if (r12.intValue() != r30) goto L88;
        g1 r38 = (g1) this.u.getValue();
        if (r38 == null) goto L88;
        r38.nJ(new com.larus.common.venue.impl.venue.component.f());
        goto L88
    L44:
        if (r12.intValue() != r15) goto L46;
        r16 = "travel_page";
        goto L47
    L38:
        if (r12.intValue() != r14) goto L40;
    L33:
        r12 = null;
        goto L34
    }

    @Override // v09.a
    public final void C7(ICoreInputAbility.OnSendParams r12, String r13, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "scene");
        Intrinsics.checkNotNullParameter(r14, "asrResult");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new FlowCommonVenueInputComponent$handleSendMessageAndGoChatPage$1(r12, this, r13, r14, r15, null), 2, null);
    }

    public final void G3(ICoreInputAbility.OnSendParams r310, String r40, String r41, boolean r42) {
        C3(r40);
        LinkedHashMap r1 = new LinkedHashMap();
        Map r2 = r310.messageExt;
        if (r2 == null) goto L7;
        boolean r4 = true;
        if ((!r2.isEmpty()) != true) goto L7;
    L8:
        if (r4 == false) goto L10;
        r1.putAll(r2);
    L10:
        r1.putAll(new LinkedHashMap());
        ICoreInputAbility.OnSendParams r3 = ICoreInputAbility.OnSendParams.copy$default(r310, null, null, null, null, null, null, null, null, 0, false, null, false, false, false, null, null, null, null, false, null, r1, null, null, null, null, null, null, null, null, null, null, null, null, -1048577, 1, null);
        ICoreInputAbility r5 = p3();
        if (r5 == null) goto L13;
        r5.E0(r3);
    L13:
        v09.b r6 = B3();
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
