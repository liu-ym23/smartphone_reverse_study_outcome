package com.larus.uaigc.createpage.component.input;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.larus.bmhome.chat.component.bottom.core.h9;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.bmhome.community.ICreationPageService;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.home.impl.sdk.l1;
import com.larus.im.bean.message.Image;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.CustomInputInitData;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import com.larus.platform.model.video.VideoPortraitConfig;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.applet.IAICreationAppletHostService;
import com.larus.uaigc.createpage.CreationHalfChatFragment;
import com.larus.uaigc.createpage.CreationHostUiPolicy;
import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.larus.uaigc.createpage.processor.CreatePageSendMessageProcessor;
import com.larus.uaigc.service.CreationDoSameNotifyInfo;
import com.larus.uaigc.service.ICreationNotifyService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.spi.chat.ObricChatUIDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.log.TraceLevel;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;
import tx9.s3;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00ad\u00012\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0002\u00ad\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010V\u001a\u00020WH\u0016J\b\u0010X\u001a\u00020WH\u0016J\b\u0010Y\u001a\u00020WH\u0014J\u0010\u0010[\u001a\u00020W2\u0006\u0010\\\u001a\u00020NH\u0016J\b\u0010]\u001a\u00020(H\u0014J\b\u0010^\u001a\u00020WH\u0002J\b\u0010_\u001a\u00020(H\u0002J\n\u0010`\u001a\u0004\u0018\u00010aH\u0002J\b\u0010b\u001a\u00020(H\u0002J\b\u0010c\u001a\u00020(H\u0002J\b\u0010d\u001a\u00020(H\u0002J\u0010\u0010e\u001a\u00020W2\u0006\u0010f\u001a\u00020KH\u0016J\b\u0010g\u001a\u00020hH\u0002J\b\u0010i\u001a\u00020(H\u0002J\u0010\u0010j\u001a\u00020W2\u0006\u0010f\u001a\u00020KH\u0002J\b\u0010k\u001a\u00020WH\u0016J\"\u0010l\u001a\u00020W2\u0006\u0010f\u001a\u00020K2\u0006\u0010m\u001a\u00020n2\b\b\u0002\u0010o\u001a\u00020hH\u0002J\u0018\u0010p\u001a\u00020W2\u0006\u0010f\u001a\u00020K2\u0006\u0010o\u001a\u00020hH\u0002J\b\u0010q\u001a\u00020(H\u0002J\b\u0010r\u001a\u00020WH\u0002J\b\u0010s\u001a\u00020WH\u0002J\b\u0010t\u001a\u00020(H\u0002J\b\u0010u\u001a\u00020(H\u0002J\b\u0010v\u001a\u00020WH\u0016J\b\u0010w\u001a\u00020WH\u0016J\b\u0010x\u001a\u00020WH\u0016J\b\u0010y\u001a\u00020WH\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010z\u001a\u00020W2\u0006\u0010{\u001a\u00020IH\u0016J\u0010\u0010|\u001a\u00020W2\u0006\u0010}\u001a\u00020KH\u0016J\b\u0010~\u001a\u00020WH\u0016J\b\u0010\u007f\u001a\u00020WH\u0002J\t\u0010\u0080\u0001\u001a\u00020WH\u0016J\t\u0010\u0081\u0001\u001a\u00020WH\u0002J\t\u0010\u0082\u0001\u001a\u00020WH\u0002J\t\u0010\u0083\u0001\u001a\u00020WH\u0002J\u0013\u0010\u0084\u0001\u001a\u00020W2\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0002J\t\u0010\u0087\u0001\u001a\u00020WH\u0002J\t\u0010\u0088\u0001\u001a\u00020WH\u0002J\t\u0010\u0089\u0001\u001a\u00020(H\u0002J\t\u0010\u008a\u0001\u001a\u00020WH\u0002J\n\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0016J\t\u0010\u008d\u0001\u001a\u00020(H\u0016J\t\u0010\u008e\u0001\u001a\u00020WH\u0002J\t\u0010\u008f\u0001\u001a\u00020WH\u0002J\t\u0010\u0090\u0001\u001a\u00020WH\u0002J,\u0010\u0091\u0001\u001a\u0011\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020K\u0018\u00010\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020K2\t\b\u0002\u0010\u0094\u0001\u001a\u00020(H\u0002J\t\u0010\u0095\u0001\u001a\u00020WH\u0002J\t\u0010\u0096\u0001\u001a\u00020WH\u0002J\t\u0010\u0097\u0001\u001a\u00020(H\u0002J!\u0010\u0098\u0001\u001a\u00020K2\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00012\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001H\u0002J\u0013\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009a\u0001*\u0005\u0018\u00010\u009a\u0001H\u0002J\u0014\u0010\u009e\u0001\u001a\u00020W2\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010KH\u0002J\u0015\u0010 \u0001\u001a\u00020W2\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001H\u0002J\u0015\u0010¡\u0001\u001a\u00020(2\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u0002J\u0013\u0010¢\u0001\u001a\u00020W2\b\u0010£\u0001\u001a\u00030¤\u0001H\u0014J\u001f\u0010¥\u0001\u001a\u000f\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020K0\u0092\u00012\u0007\u0010¦\u0001\u001a\u00020KH\u0016J\t\u0010§\u0001\u001a\u00020(H\u0002J\t\u0010¨\u0001\u001a\u00020(H\u0014J\t\u0010©\u0001\u001a\u00020(H\u0002J\u000e\u0010ª\u0001\u001a\u00020(*\u00030«\u0001H\u0002J\u000e\u0010¬\u0001\u001a\u00020(*\u00030«\u0001H\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b\u001f\u0010 R\u001d\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b$\u0010%R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010)\u001a\u0004\u0018\u00010*8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u000b\u001a\u0004\b+\u0010,R\u001d\u0010.\u001a\u0004\u0018\u00010/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u000b\u001a\u0004\b0\u00101R\u001d\u00103\u001a\u0004\u0018\u0001048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u000b\u001a\u0004\b5\u00106R\u001d\u00108\u001a\u0004\u0018\u0001098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u000b\u001a\u0004\b:\u0010;R\u001d\u0010=\u001a\u0004\u0018\u00010>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u000b\u001a\u0004\b?\u0010@R\u001b\u0010B\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\u000b\u001a\u0004\bD\u0010ER\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020I0HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010M\u001a\u0004\u0018\u00010NX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u000e\u0010S\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010UX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006®\u0001"}, d2 = {"Lcom/larus/uaigc/createpage/component/input/CreationInputComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/uaigc/bean/createpage/component/input/CreationIInputAbility;", "<init>", "()V", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "currentChatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "multiAttachmentSelectorAbility", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMultiAttachmentSelectorAbility;", "getMultiAttachmentSelectorAbility", "()Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMultiAttachmentSelectorAbility;", "multiAttachmentSelectorAbility$delegate", "coreInputManager", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "getCoreInputManager", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "coreInputManager$delegate", "instructionEditorAbility", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "getInstructionEditorAbility", "()Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "instructionEditorAbility$delegate", "mediaSelectorContainerAbility", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMediaSelectorContainerAbility;", "getMediaSelectorContainerAbility", "()Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMediaSelectorContainerAbility;", "mediaSelectorContainerAbility$delegate", "isLeavingPage", "", "argumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "argumentData$delegate", "hitPointData", "Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "getHitPointData", "()Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "hitPointData$delegate", "digitalAvatarAbility", "Lcom/larus/uaigc/bean/createpage/component/digitalavatar/IDigitalAvatarAbility;", "getDigitalAvatarAbility", "()Lcom/larus/uaigc/bean/createpage/component/digitalavatar/IDigitalAvatarAbility;", "digitalAvatarAbility$delegate", "templateFeedAbility", "Lcom/larus/uaigc/bean/createpage/component/templatefeed/ITemplateFeedAbility;", "getTemplateFeedAbility", "()Lcom/larus/uaigc/bean/createpage/component/templatefeed/ITemplateFeedAbility;", "templateFeedAbility$delegate", "imageSelectorAbility", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/imageselector/IImageSelectorAbility;", "getImageSelectorAbility", "()Lcom/larus/uaigc/bean/createpage/component/mediacontainer/imageselector/IImageSelectorAbility;", "imageSelectorAbility$delegate", "sendMessageProcessor", "Lcom/larus/uaigc/createpage/processor/CreatePageSendMessageProcessor;", "getSendMessageProcessor", "()Lcom/larus/uaigc/createpage/processor/CreatePageSendMessageProcessor;", "sendMessageProcessor$delegate", "bottomInsetUpdateListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larus/bmhome/view/ChatConstraintLayout$OnBottomInsetUpdateListener;", "curInputContent", "", "isPaste", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "isCurrentShowUpdateDialog", "pendingAutoShowImeRunnable", "Ljava/lang/Runnable;", "onAttach", "", "onCreate", "attachmentComponent", "creationUpdatePrompt", "onViewCreated", "view", "isInterceptActionSendClick", "tryShowUpdateDialog", "isHalfInstructionFragment", "getCreationHalfHost", "Lcom/larus/uaigc/bean/createpage/ICreationHalfHost;", "isEmbeddedHalfInstructionFragment", "shouldSkipAutoShowIme", "shouldUseCompactForsetiImeFix", "showImeWhenInit", "from", "autoShowImeRetryCount", "", "shouldRetryAutoShowImeWhenPassedImageInit", "showImeIfPageCanReceiveInput", "cancelPendingAutoShowIme", "postAutoShowIme", "delayMillis", "", "remainingRetryCount", "verifyAutoShowImeAfterWindowSettled", "isInputReadyForIme", "showCompactForsetiImeIfPageCanReceiveInput", "hideEmbeddedHalfActionBar", "shouldUseHalfInstructionDismissArea", "shouldShowHalfCreationBackground", "dismissInput", "onResume", "afterViewBind", "onFragmentViewDestroyed", "addBottomInsetUpdateListener", "listener", "directSend", "text", "onSendFinish", "clearImeStateBeforeLeaving", "prepareForLeavingPage", "clearImeStateAfterSend", "clearImeStateImmediately", "hideCurrentActivityIme", "finishNativeHostBelowCreationHostIfNeeded", "hostUiPolicy", "Lcom/larus/uaigc/createpage/CreationHostUiPolicy;", "pushHostDetailDoSameNotify", "openAppletDetailDoSameResultChat", "shouldRouteHostDetailDoSamePushToChatPage", "routeAppletDetailDoSameResultChat", "getCreatePageSendMessageProcessor", "Lcom/larus/uaigc/bean/createpage/ICreatePageSendMessageProcessor;", "shouldShowImeWhenInit", "bindObservers", "observeBottomInsetUpdate", "initInputContent", "buildInstructionParamMap", "", "userInput", "forceMediaData", "onCopyClick", "onCopyAndSendClick", "imageAndVideoMixSkillIntercept", "resolveCreationSendType", "attachmentInfo", "Lcom/larus/bmhome/view/AttachmentInfo;", "customMultiAttachment", "Lcom/larus/bmhome/chat/CustomMultiAttachmentInfo;", "withAiCreationFlag", "markResourceUploadHandoffToSend", "fileIdentifier", "markMultiAttachmentUploadHandoffToSend", "shouldKeepPipelineAttachmentForSend", "onSend", "onSendParams", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "getMessageExtOnSend", "inputContent", "checkInstructionValid", "shouldUseCreationSendMessageFlow", "shouldBlockMultiAttachmentPreprocessing", "interceptActionSendWhenSpeak", "Lcom/larus/bmhome/chat/component/bottom/core/InputView$Operator;", "interceptActionSend", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public class CreationInputComponent extends BaseContentWidget implements py9.a {
    public static final long[] F = null;
    public String A;
    public boolean B;
    public View C;
    public boolean D;
    public Runnable E;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public boolean s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final CopyOnWriteArrayList<ChatConstraintLayout.b> z;

    public static final class a {
    }

    public static final class b implements Animation.AnimationListener {
        public final /* synthetic */ CreationInputComponent a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        public b(CreationInputComponent r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r3) {
            CreationInputComponent r4 = this.a;     // Catch: IllegalStateException -> L11
            long[] r0 = CreationInputComponent.F;     // Catch: IllegalStateException -> L11
            ny9.i r5 = r4.G3();     // Catch: IllegalStateException -> L11
            if (r5 == null) goto L7;
            View r6 = r5.getContentView();     // Catch: IllegalStateException -> L11
            if (r6 == null) goto L7;
            r6.setVisibility(8);     // Catch: IllegalStateException -> L11
        L7:
            ny9.i r7 = this.a.G3();     // Catch: IllegalStateException -> L11
            if (r7 == null) goto L15;
            r7.YV();     // Catch: IllegalStateException -> L11
            return;
        L15:
            return;
        L11:
            FLogger.a.e("CommonSlideDialogFragment", "fallback by dismiss failed");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r2) {
            CreationInputComponent r3 = this.a;
            long[] r0 = CreationInputComponent.F;
            if (r3.q4() == false) goto L10;
            View r4 = s1a.a.c(this.a).getView();
            if (r4 == null) goto L11;
            View r5 = r4.findViewById(2131374177);
            if (r5 == null) goto L12;
            e1.o(r5);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class c implements ICoreInputAbility.e {
        public final /* synthetic */ CreationInputComponent a;

        public c(CreationInputComponent r1) {
            this.a = r1;
        }

        public final void h(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
        }

        public final void i(String r5) {
            Intrinsics.checkNotNullParameter(r5, "content");
            boolean r1 = true;
            if ((!StringsKt.isBlank(r5)) == true) goto L5;
        L9:
            CreationInputComponent r0 = this.a;
            if ((r5.length() - this.a.A.length()) >= 20) goto L13;
            r1 = false;
        L13:
            r0.B = r1;
            this.a.A = r5;
            return;
        L5:
            if (StringsKt.isBlank(this.a.A) == false) goto L9;
            ICoreInputAbility r2 = this.a.D3();
            if (r2 == null) goto L9;
            r2.g2(3, true);
            goto L9
        }

        public final void j(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
        }
    }

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.input.CreationInputComponent$onResume$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.input.CreationInputComponent$onResume$2", f = "CreationInputComponent.kt", i = {}, l = {761}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass2(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            DigitalAvatarInfoManager r5 = DigitalAvatarInfoManager.a;
            this.label = 1;
            if (DigitalAvatarInfoManager.d(r5, this) != r0) goto L12;
            return r0;
        }
    }

    public final void A2() {
        this.s = true;
        z3();
        this.z.clear();
    }

    @Override // py9.a
    public final void mV() {
        this.s = true;
        z3();
    }

    static {
        F = new long[]{120, 360, 720};
    }

    public final ny9.s C3() {
        return (ny9.s) this.t.getValue();
    }

    public final ICoreInputAbility D3() {
        return (ICoreInputAbility) this.m.getValue();
    }

    public final z8 E3() {
        return (z8) this.p.getValue();
    }

    public final ny9.u H3() {
        return (ny9.u) this.u.getValue();
    }

    @Override // py9.a
    public final void NM() {
        Runnable r0 = this.E;
        if (r0 == null) goto L7;
        View r1 = this.C;
        if (r1 == null) goto L7;
        r1.removeCallbacks(r0);
    L7:
        this.E = null;
    }

    public final ys8.a Q3() {
        return (ys8.a) this.q.getValue();
    }

    public final CreatePageSendMessageProcessor V3() {
        return (CreatePageSendMessageProcessor) this.y.getValue();
    }

    public final void W3() {
        Activity r0 = AppHost.a.a().getCurrentActivity();
        InputMethodManager r1 = null;
        if (r0 == null) goto L39;
    L15:
        View r2 = r0.getCurrentFocus();
        if (r2 == null) goto L18;
        r2.clearFocus();
    L18:
        if (r2 == null) goto L21;
        IBinder r3 = r2.getWindowToken();
        if (r3 == null) goto L21;
    L33:
        Object r4 = r0.getSystemService("input_method");
        if ((r4 instanceof InputMethodManager) == false) goto L36;
        r1 = (InputMethodManager) r4;
    L36:
        if (r1 == null) goto L41;
        r1.hideSoftInputFromWindow(r3, 0);
        return;
    L41:
        return;
    L21:
        Window r5 = r0.getWindow();
        if (r5 == null) goto L30;
        View r6 = r5.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L28;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r7 = ThreadMethodProxy.currentThread();
        if (r7 == com.larus.home.impl.utils.c.a) goto L28;
        com.larus.home.impl.utils.c.a(r7, "getDecorView");
    L28:
        if (r6 == null) goto L30;
        r3 = r6.getWindowToken();
    L31:
        if (r3 != null) goto L33;
        return;
    L30:
        r3 = null;
        goto L31
    L39:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L6
        Object r9 = Result.constructor-impl(s1a.a.getActivity(this));     // Catch: Throwable -> L6
    L9:
        if (Result.isFailure-impl(r9) == false) goto L11;
        r9 = null;
    L11:
        r0 = (FragmentActivity) r9;
        if (r0 != null) goto L15;
        return;
    L6:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public void Y2() {
        k1a.b.b(this, new e(this));
    }

    public final boolean Z3() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        return com.larus.ui.arch.component.internal.attach.a.b(this, this) instanceof CreationHalfChatFragment;
    }

    public final boolean c4() {
        View r0 = this.C;
        if (r0 == null) goto L17;
        EditText r1 = (EditText) r0.findViewById(2131375415);
        if (r1 != null) goto L8;
        return false;
    L8:
        if (r1.isAttachedToWindow() == true) goto L10;
        return false;
    L10:
        if (r1.getWindowToken() != null) goto L12;
        return false;
    L12:
        if (r1.getWidth() > 0) goto L14;
        return false;
    L14:
        if (r1.getHeight() <= 0) goto L21;
        return true;
    L21:
        return false;
    L17:
        return false;
    }

    public boolean d4() {
        PollingConfigService r1 = PollingConfigService.a;
        boolean r8 = false;
        String r10 = null;
        if (Intrinsics.areEqual(r1.f("avatar_cre_i_dg"), "1") == false) goto L29;
        ys8.a r3 = Q3();
        if (r3 != null) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L29;
        FLogger.a.i("CreationInputComponent", "hit avatar_cre_i_dg action");
        t19.s r11 = t19.s.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Context r12 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getContext();
        z2 r2 = z2.a;
        FlowDowngradeToastConfig r5 = r2.getFlowDowngradeToastConfig();
        if (r5 == null) goto L14;
        String r6 = r5.getTrafficDegradationFeatureDisableCn();
    L15:
        if (r6 != null) goto L17;
    L18:
        r8 = true;
    L19:
        if (r8 == false) goto L22;
        String r7 = AppHost.a.getApplication().getString(2131910602);
    L21:
        String r13 = r7;
        Intrinsics.checkNotNull(r13);
        t19.s.j(r11, r12, r13, null, false, 28);
        s3.a("avatar_cre_i_dg");
        return true;
    L22:
        FlowDowngradeToastConfig r9 = r2.getFlowDowngradeToastConfig();
        if (r9 == null) goto L25;
        r10 = r9.getTrafficDegradationFeatureDisableCn();
    L25:
        r7 = String.valueOf(r10);
        goto L21
    L17:
        if (r6.length() != 0) goto L19;
    L14:
        r6 = null;
        goto L15
    L7:
        if (r3.pE() != true) goto L9;
        r4 = true;
    L29:
        if (Intrinsics.areEqual(r1.f("avatar_cre_v_dg"), "1") == false) goto L55;
        ys8.a r14 = Q3();
        if (r14 != null) goto L33;
    L35:
        boolean r15 = false;
    L36:
        if (r15 == false) goto L55;
        FLogger.a.i("CreationInputComponent", "hit avatar_cre_v_dg action");
        t19.s r16 = t19.s.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Context r17 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getContext();
        z2 r18 = z2.a;
        FlowDowngradeToastConfig r19 = r18.getFlowDowngradeToastConfig();
        if (r19 == null) goto L40;
        String r20 = r19.getTrafficDegradationFeatureDisableCn();
    L41:
        if (r20 != null) goto L43;
    L44:
        r8 = true;
    L45:
        if (r8 == false) goto L48;
        String r21 = AppHost.a.getApplication().getString(2131910602);
    L47:
        String r110 = r21;
        Intrinsics.checkNotNull(r110);
        t19.s.j(r16, r17, r110, null, false, 28);
        s3.a("avatar_cre_v_dg");
        return true;
    L48:
        FlowDowngradeToastConfig r22 = r18.getFlowDowngradeToastConfig();
        if (r22 == null) goto L51;
        r10 = r22.getTrafficDegradationFeatureDisableCn();
    L51:
        r21 = String.valueOf(r10);
        goto L47
    L43:
        if (r20.length() != 0) goto L45;
    L40:
        r20 = null;
        goto L41
    L33:
        if (r14.lv() != true) goto L35;
        r15 = true;
    L55:
        if (Intrinsics.areEqual(r1.f("cre_v_dg"), "1") == false) goto L80;
        ys8.a r23 = Q3();
        if (r23 != null) goto L59;
    L61:
        boolean r24 = false;
    L62:
        if (r24 == false) goto L80;
        FLogger.a.i("CreationInputComponent", "hit cre_v_dg action");
        t19.s r111 = t19.s.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Context r112 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getContext();
        z2 r25 = z2.a;
        FlowDowngradeToastConfig r26 = r25.getFlowDowngradeToastConfig();
        if (r26 == null) goto L66;
        String r27 = r26.getTrafficDegradationFeatureDisableCn();
    L67:
        if (r27 != null) goto L69;
    L70:
        r8 = true;
    L71:
        if (r8 == false) goto L74;
        String r28 = AppHost.a.getApplication().getString(2131910602);
    L73:
        String r113 = r28;
        Intrinsics.checkNotNull(r113);
        t19.s.j(r111, r112, r113, null, false, 28);
        s3.a("cre_v_dg");
        return true;
    L74:
        FlowDowngradeToastConfig r29 = r25.getFlowDowngradeToastConfig();
        if (r29 == null) goto L77;
        r10 = r29.getTrafficDegradationFeatureDisableCn();
    L77:
        r28 = String.valueOf(r10);
        goto L73
    L69:
        if (r27.length() != 0) goto L71;
    L66:
        r27 = null;
        goto L67
    L59:
        if (r23.Pz() != true) goto L61;
        r24 = true;
    L80:
        return false;
    }

    public final boolean i4() {
        int r0 = com.larus.uaigc.createpage.component.input.a.a;
        com.larus.uaigc.helper.f.a.getClass();
        boolean r1 = com.larus.uaigc.helper.f.a();
        boolean r2 = p4();
        ry9.h r3 = (ry9.h) this.o.getValue();
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        boolean r5 = Intrinsics.areEqual(com.larus.uaigc.helper.f.c().d(), Boolean.TRUE);
        ry9.h r6 = (ry9.h) this.o.getValue();
        if (r6 != null) goto L11;
    L13:
        boolean r7 = false;
    L14:
        if (r4 == false) goto L24;
        if (r1 == false) goto L18;
        if (r2 == false) goto L18;
        boolean r8 = true;
    L19:
        if (r8 == true) goto L25;
        if (r5 == false) goto L22;
        if (r7 == true) goto L22;
        return false;
    L22:
        return true;
    L25:
        return false;
    L18:
        r8 = false;
        goto L19
    L24:
        return false;
    L11:
        if (r6.Wb() != true) goto L13;
        r7 = true;
        goto L14
    L5:
        if (r3.jb() != true) goto L7;
        r4 = true;
        goto L8
    }

    public final boolean k4() {
        if (this.s == true) goto L18;
        Intrinsics.checkNotNullParameter(this, "<this>");
        CreationHalfChatFragment r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if ((r0 instanceof CreationHalfChatFragment) == false) goto L7;
        CreationHalfChatFragment r1 = r0;
    L9:
        if (r1 != null) goto L11;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == true) goto L19;
        return false;
    L19:
        return true;
    L11:
        if (r1.n != true) goto L13;
        r2 = true;
        goto L14
    L7:
        r1 = null;
        goto L9
    L18:
        return true;
    }

    public final boolean l4() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        CreationHalfChatFragment r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if ((r0 instanceof CreationHalfChatFragment) == false) goto L5;
        CreationHalfChatFragment r1 = r0;
    L7:
        if (r1 != null) goto L9;
        return false;
    L9:
        if (r1.aa0() != true) goto L13;
        return true;
    L13:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    @Override // py9.a
    public final boolean n70() {
        if (this.D == false) goto L5;
        return false;
    L5:
        ny9.s r0 = C3();
        if (r0 == null) goto L13;
        Bundle r1 = r0.a;
        if (r1 == null) goto L10;
        boolean r2 = r1.getBoolean("no_ime_when_init", false);
    L11:
        if (r2 != true) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L16;
        return false;
    L16:
        ny9.s r4 = C3();
        String r5 = null;
        if (r4 == null) goto L19;
        Integer r6 = r4.l();
    L20:
        ny9.s r7 = C3();
        if (r7 == null) goto L23;
        String r8 = r7.o();
    L25:
        if (o0.d(r8) == true) goto L67;
        ny9.s r9 = C3();
        if (r9 == null) goto L29;
        String r10 = r9.p();
    L31:
        if (o0.d(r10) == true) goto L67;
        ny9.s r11 = C3();
        if (r11 == null) goto L35;
        Image r12 = r11.r();
    L36:
        if (r12 != null) goto L67;
        ny9.s r13 = C3();
        if (r13 != null) goto L40;
    L42:
        boolean r14 = false;
    L43:
        if (r14 == true) goto L67;
        uy9.a r15 = (uy9.a) this.w.getValue();
        if (r15 == null) goto L48;
        r15.HQ();
        boolean r16 = true;
    L49:
        if (r16 == true) goto L66;
        ny9.s r17 = C3();
        if (r17 == null) goto L58;
        Bundle r18 = r17.a;
        if (r18 == null) goto L56;
        r5 = r18.getString("default_open_page");
    L56:
        if (Intrinsics.areEqual(r5, "image_template") != true) goto L58;
        boolean r19 = true;
    L59:
        if (r19 == true) goto L66;
        if (CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{4, 16, 18, 24}), r6) == true) goto L64;
        return true;
    L64:
        return z2.a.getAIBeautifyConfig().a;
    L58:
        r19 = false;
    L66:
        return false;
    L48:
        r16 = false;
        goto L49
    L40:
        if (r13.D() != true) goto L42;
        r14 = true;
        goto L43
    L35:
        r12 = null;
        goto L36
    L29:
        r10 = null;
    L67:
        return true;
    L23:
        r8 = null;
        goto L25
    L19:
        r6 = null;
        goto L20
    L10:
        r2 = false;
    L13:
        r3 = false;
        goto L14
    }

    public boolean p4() {
        int r0 = CreationHostUiPolicy.f;
        ny9.s r1 = C3();
        if (r1 == null) goto L5;
        Bundle r2 = r1.a;
    L7:
        if (CreationHostUiPolicy.a.a(r2).a == true) goto L12;
        ICreationPageService.a.getClass();
        if (ICreationPageService.a.a() == true) goto L12;
        return false;
    L12:
        return true;
    L5:
        r2 = null;
        goto L7
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, py9.a.class);
    }

    public CreationInputComponent() {
        this.m = LazyKt.lazy(new f(this));
        this.n = LazyKt.lazy(new i(this));
        this.o = LazyKt.lazy(new j(this));
        this.p = LazyKt.lazy(new k(this));
        this.q = LazyKt.lazy(new l(this));
        this.r = LazyKt.lazy(new n(this));
        this.t = LazyKt.lazy(new o(this));
        this.u = LazyKt.lazy(new p(this));
        this.v = LazyKt.lazy(new q(this));
        this.w = LazyKt.lazy(new r(this));
        this.x = LazyKt.lazy(new g(this));
        this.y = LazyKt.lazy(new h(this));
        this.z = new CopyOnWriteArrayList();
        this.A = "";
    }

    public final ChatPageContext B3() {
        return s1a.d.a(this).a(ChatPageContext.class);
    }

    @Override // py9.a
    public final CreatePageSendMessageProcessor Ck() {
        return V3();
    }

    public final ny9.i G3() {
        Object r0 = getContext();
        if ((r0 instanceof ny9.i) == false) goto L5;
        ny9.i r1 = (ny9.i) r0;
    L6:
        if (r1 != null) goto L11;
        Intrinsics.checkNotNullParameter(this, "<this>");
        ny9.i r2 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if ((r2 instanceof ny9.i) == true) goto L13;
        return null;
    L13:
        return r2;
    L11:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    @Override // py9.a
    public final void Gj() {
        NM();
        Animation r0 = AnimationUtils.loadAnimation(getContext(), 2130772402);
        r0.setAnimationListener(new b(this));
        ny9.i r1 = G3();
        if (r1 == null) goto L5;
        Intent r2 = new Intent();
        r2.putExtra("ai_creation", true);
        r2.putExtra("end_modify", true);
        Unit r3 = Unit.INSTANCE;
        r1.Dc(0, r2);
    L5:
        if (r1 == null) goto L7;
        View r4 = r1.getContentView();
    L8:
        if (r4 != null) goto L11;
        if (r1 == null) goto L13;
        r1.YV();
        return;
    L13:
        return;
    L11:
        r4.startAnimation(r0);
        return;
    L7:
        r4 = null;
        goto L8
    }

    @Override // py9.a
    public final void Oe() {
        p3();
        uy9.a r0 = (uy9.a) this.w.getValue();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        return;
    L10:
        int r3 = CreationHostUiPolicy.f;
        ny9.s r4 = C3();
        String r5 = null;
        if (r4 == null) goto L13;
        Bundle r6 = r4.a;
    L14:
        CreationHostUiPolicy r7 = CreationHostUiPolicy.a.a(r6);
        boolean r8 = r7.d;
        boolean r9 = r7.a;
        if (r9 == false) goto L27;
        ny9.s r10 = C3();
        if (r10 == null) goto L24;
        Bundle r11 = r10.a;
        if (r11 == null) goto L21;
        boolean r12 = r11.getBoolean("is_send_from_detail");
    L22:
        if (r12 != true) goto L24;
        boolean r13 = true;
    L25:
        if (r13 == false) goto L27;
        boolean r14 = true;
    L28:
        ny9.s r15 = C3();
        if (r15 == null) goto L31;
        Integer r16 = r15.d();
    L32:
        if (r14 == false) goto L38;
        if (r16 == null) goto L38;
        if (r16.intValue() != 1) goto L38;
        boolean r17 = true;
    L39:
        if (r9 == false) goto L41;
        this.s = true;
        z3();
    L41:
        if (r9 == false) goto L44;
        if (r17 == true) goto L44;
        int r18 = com.larus.uaigc.applet.a.a;
        IAICreationAppletHostService.a.d();
    L44:
        if (r9 == false) goto L49;
        if (r7.e == false) goto L49;
        int r19 = com.larus.uaigc.applet.a.a;
        IAICreationAppletHostService.a.q();
    L49:
        if (r14 == false) goto L93;
        if (r16 == null) goto L93;
        if (r16.intValue() != 1) goto L93;
        FLogger.a.i("CreationInputComponent", "onSendFinish keep AI creation host detail");
        List r20 = AppHost.a.a().g();
        ListIterator r21 = r20.listIterator(r20.size());
    L56:
        if (r21.hasPrevious() == false) goto L67;
        Object r22 = r21.previous();
        Activity r23 = (Activity) r22;
        cy9.a.a.getClass();
        if (cy9.a.d(r23) == true) goto L60;
    L64:
        boolean r24 = false;
    L65:
        if (r24 == false) goto L56;
    L68:
        FragmentActivity r25 = (Activity) r22;
        if (r25 != null) goto L71;
        r25 = s1a.a.getActivity(this);
    L71:
        FragmentActivity r26 = r25;
        ICreationNotifyService.Companion r27 = ICreationNotifyService.a;
        r27.y();
        ny9.s r28 = C3();
        if (r28 == null) goto L74;
        CreationDoSameNotifyInfo r29 = r28.e();
    L75:
        ny9.u r30 = H3();
        if (r30 == null) goto L84;
        String r31 = r30.getEnterMethod();
        if (o0.d(r31) == true) goto L81;
        r31 = null;
    L81:
        if (r31 == null) goto L84;
        String r32 = r31;
    L88:
        r27.K(r29, r26, r26, r32, new v(this));
        ny9.i r33 = G3();
        if (r33 == null) goto L91;
        r33.YV();
        return;
    L91:
        s1a.a.getActivity(this).finish();
        return;
    L84:
        ny9.s r34 = C3();
        if (r34 == null) goto L87;
        r5 = r34.i();
    L87:
        r32 = r5;
        goto L88
    L74:
        r29 = null;
        goto L75
    L60:
        if (r23.isFinishing() == true) goto L64;
        if (r23.isDestroyed() == true) goto L64;
        r24 = true;
        goto L65
    L67:
        r22 = null;
    L93:
        if (r14 == false) goto L103;
        if (r16 == null) goto L103;
        if (r16.intValue() != 2) goto L103;
        FLogger.a.i("CreationInputComponent", "onSendFinish back to AI creation host previous page");
        int r35 = com.larus.uaigc.applet.a.a;
        IAICreationAppletHostService.a.h(1);
        ny9.i r36 = G3();
        if (r36 == null) goto L101;
        r36.YV();
        return;
    L101:
        s1a.a.getActivity(this).finish();
        return;
    L103:
        ny9.s r37 = C3();
        if (r37 != null) goto L106;
    L108:
        boolean r38 = false;
    L109:
        if (r38 == true) goto L111;
        if (r8 == true) goto L111;
    L112:
        if (r1 == true) goto L129;
        if (r14 == true) goto L129;
        if (r9 == false) goto L123;
        FLogger.a.i("CreationInputComponent", "onSendFinish close AI creation host fallback");
        int r39 = com.larus.uaigc.applet.a.a;
        if (IAICreationAppletHostService.a.i(true) == true) goto L147;
        ny9.i r40 = G3();
        if (r40 == null) goto L121;
        r40.YV();
        return;
    L121:
        s1a.a.getActivity(this).finish();
        return;
    L147:
        return;
    L123:
        ny9.i r41 = G3();
        if (r41 == null) goto L126;
        r41.YV();
        return;
    L126:
        s1a.a.getActivity(this).finish();
        return;
    L129:
        if (V3().g == false) goto L134;
        FLogger.a.i("CreationInputComponent", "onSendFinish skip close AI creation host, already scheduled by native route");
        ny9.i r42 = G3();
        if (r42 == null) goto L150;
        r42.YV();
        return;
    L150:
        return;
    L134:
        FLogger.a.i("CreationInputComponent", "onSendFinish close AI creation host, chatRoute=" + r1 + ", detailDoSame=" + r14);
        ny9.i r43 = G3();
        int r44 = com.larus.uaigc.applet.a.a;
        boolean r45 = IAICreationAppletHostService.a.i(true);
        if (r43 == null) goto L137;
        r43.YV();
        return;
    L137:
        if (r45 == true) goto L152;
        s1a.a.getActivity(this).finish();
        return;
    L152:
        return;
    L111:
        r1 = true;
        goto L112
    L106:
        if (r37.j() != true) goto L108;
        r38 = true;
    L38:
        r17 = false;
        goto L39
    L31:
        r16 = null;
        goto L32
    L21:
        r12 = false;
    L24:
        r13 = false;
    L27:
        r14 = false;
        goto L28
    L13:
        r6 = null;
        goto L14
    L5:
        if (r0.JS() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void P2() {
        if (n70() == false) goto L6;
        Bl("instructionPageAutoShow");
        return;
    }

    public final boolean a4() {
        if (G3() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final int h3() {
        if (a4() == true) goto L5;
    L7:
        int r0 = CreationHostUiPolicy.f;
        ny9.s r1 = C3();
        if (r1 == null) goto L10;
        Bundle r2 = r1.a;
    L12:
        if (CreationHostUiPolicy.a.a(r2).a == false) goto L14;
    L15:
        return 3;
    L14:
        if (j4() == true) goto L15;
        return 0;
    L10:
        r2 = null;
        goto L12
    L5:
        if (l4() == true) goto L7;
        return 0;
    }

    public final boolean j4() {
        ny9.s r0 = C3();
        Image r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.o();
    L7:
        if (o0.d(r2) == true) goto L28;
        ny9.s r3 = C3();
        if (r3 == null) goto L11;
        String r4 = r3.p();
    L13:
        if (o0.d(r4) == true) goto L29;
        ny9.s r5 = C3();
        if (r5 == null) goto L17;
        r1 = r5.r();
    L17:
        if (r1 != null) goto L30;
        ny9.s r6 = C3();
        if (r6 != null) goto L21;
    L23:
        boolean r7 = false;
    L24:
        if (r7 == true) goto L31;
        return false;
    L31:
        return true;
    L21:
        if (r6.D() != true) goto L23;
        r7 = true;
        goto L24
    L30:
        return true;
    L29:
        return true;
    L11:
        r4 = null;
        goto L13
    L28:
        return true;
    L5:
        r2 = null;
        goto L7
    }

    @Override // py9.a
    public final ICoreInputAbility mJ() {
        return D3();
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        Y2();
    }

    public final void onResume() {
        boolean r1 = true;
        if (a4() == true) goto L5;
    L23:
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L30;
        r0.H();
        VideoPortraitConfig r2 = l1.a.a();
        if (r2 == null) goto L30;
        if (r2.getEnableAvatarCreation() != true) goto L30;
    L31:
        if (r1 == false) goto L34;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass2(null), 3, null);
        return;
    L34:
        return;
    L30:
        r1 = false;
        goto L31
    L5:
        if (Z3() == false) goto L7;
        h4("instructionPageAutoShow", 100, h3());
    L10:
        ChatConstraintLayout r3 = this.C;
        if ((r3 instanceof ChatConstraintLayout) == false) goto L13;
        ChatConstraintLayout r4 = r3;
    L14:
        if (r4 != null) goto L16;
        return;
    L16:
        FLogger.a.i("CreationInputComponent", "adapt half onResume");
        i0.a.getClass();
        i0.d(false);
        FragmentActivity r5 = getContext();
        if ((r5 instanceof FragmentActivity) == false) goto L19;
        FragmentActivity r6 = r5;
    L20:
        if (r6 == null) goto L22;
        com.larus.utils.u.b(r6);
    L22:
        r4.S5();
        i0.d(true);
        goto L23
    L19:
        r6 = null;
        goto L20
    L13:
        r4 = null;
        goto L14
    L7:
        View r7 = this.C;
        if (r7 == null) goto L10;
        r7.postDelayed(new m(this), 100);
        goto L10
    }

    public final void p3() {
        z3();
        long[] r0 = F;
        int r1 = 0;
    L4:
        if (r1 >= 3) goto L6;
        long r2 = r0[r1];
        SoftReference r4 = com.larus.utils.y.a;
        Runnable r5 = new com.larus.uaigc.createpage.component.input.b(this);
        Intrinsics.checkNotNullParameter(r5, "action");
        com.larus.utils.y.d(r5, r2);
        r1 = r1 + 1;
        goto L4
    }

    public final boolean q4() {
        ny9.s r0 = C3();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
    L12:
        return false;
    L10:
        if (a4() == false) goto L12;
        return true;
    L5:
        if (r0.C() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void z3() {
        NM();
        View r0 = this.C;
        if (r0 == null) goto L7;
        EditText r1 = (EditText) r0.findViewById(2131375415);
        if (r1 == null) goto L7;
        r1.clearFocus();
    L7:
        ICoreInputAbility r2 = D3();
        if (r2 == null) goto L10;
        r2.qp(true);
    L10:
        W3();
    }

    @Override // py9.a
    public final void Bl(String r4) {
        Intrinsics.checkNotNullParameter(r4, "from");
        int r0 = h3();
        if (l4() == false) goto L5;
        h4(r4, 100, r0);
        return;
    L5:
        if (r0 <= 0) goto L7;
        h4(r4, 0, r0);
        return;
    L7:
        v4(r4);
    }

    @Override // py9.a
    public final Map<String, String> Jw(String r9) {
        Intrinsics.checkNotNullParameter(r9, "inputContent");
        ny9.s r0 = C3();
        if (r0 == null) goto L10;
        ICoreInputAbility.MessageExtMap r1 = r0.m();
        if (r1 == null) goto L10;
        Map r2 = r1.a;
        if (r2 == null) goto L10;
        Map<String, String> r3 = MapsKt.toMutableMap(r2);
        if (r3 == null) goto L10;
    L11:
        boolean r4 = false;
        if (r3.get("creation_template") == null) goto L14;
        boolean r5 = true;
    L15:
        ys8.a r6 = Q3();
        ArrayList r7 = null;
        if (r6 == null) goto L18;
        String r8 = r6.zQ();
    L19:
        if (r8 != null) goto L22;
        r8 = "";
    L22:
        if (r8.length() != 0) goto L24;
        boolean r10 = true;
    L25:
        if (r10 == false) goto L30;
        ny9.s r11 = C3();
        if (r11 == null) goto L29;
        r8 = r11.q();
        goto L30
    L29:
        r8 = null;
    L30:
        boolean r12 = this.B;
        if (Intrinsics.areEqual(r9, null) == false) goto L33;
        String r13 = "guidance_window";
    L46:
        r3.put("original_content_source", r13);
        sy9.a r14 = (sy9.a) this.x.getValue();
        if (r14 == null) goto L51;
        String r15 = r14.dU();
        if (r15 == null) goto L51;
        String r16 = r3.put("image_second_edit_scene", r15);
    L51:
        ys8.a r17 = Q3();
        if (r17 == null) goto L60;
        ArrayList r18 = r17.mr();
        if (r18 == null) goto L60;
        if ((!r18.isEmpty()) == false) goto L58;
        r7 = r18;
    L58:
        if (r7 == null) goto L60;
        r3.put("white_tee_index_list", r7.toString());
    L60:
        return r3;
    L33:
        if (r8 != null) goto L35;
    L36:
        r4 = true;
    L37:
        if (r4 == false) goto L43;
        if (r5 == true) goto L43;
        if (r12 == false) goto L41;
        r13 = "paste";
        goto L46
    L41:
        r13 = "original";
    L43:
        if (Intrinsics.areEqual(r9, r8) == false) goto L45;
        r13 = "use_template";
        goto L46
    L45:
        r13 = "change_template";
        goto L46
    L35:
        if (r8.length() != 0) goto L37;
    L24:
        r10 = false;
        goto L25
    L18:
        r8 = null;
        goto L19
    L14:
        r5 = false;
    L10:
        r3 = new LinkedHashMap();
        goto L11
    }

    @Override // py9.a
    public final void Tf(ChatConstraintLayout.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.z.contains(r2) == true) goto L6;
        this.z.add(r2);
        return;
    }

    public final boolean X3(g9.c r8) {
        ys8.a r0 = Q3();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L80;
        h9 r2 = r8.h();
        r2.e(true);
        ry9.g r3 = (ry9.g) this.r.getValue();
        ConstraintLayout.LayoutParams r4 = null;
        if (r3 == null) goto L14;
        i1<ry9.j> r5 = r3.D20();
        if (r5 == null) goto L14;
        ry9.j r6 = (ry9.j) r5.getValue();
    L16:
        if (Intrinsics.areEqual(r6, ry9.j.f.b) == true) goto L35;
        ys8.a r7 = Q3();
        if (r7 != null) goto L20;
    L22:
        boolean r9 = false;
    L23:
        if (r9 == false) goto L35;
        ys8.a r10 = Q3();
        if (r10 != null) goto L27;
    L29:
        boolean r11 = false;
    L30:
        if (r11 == true) goto L35;
        if (i4() == true) goto L35;
        r2.a(1.0f);
    L36:
        r2.b(true);
        h9 r12 = r8.i();
        if (StringsKt.isBlank(this.A) == true) goto L47;
        ICoreInputAbility r13 = D3();
        if (r13 != null) goto L41;
    L43:
        boolean r14 = false;
    L44:
        if (r14 == true) goto L47;
        boolean r15 = false;
    L48:
        r12.e(r15);
        r12.b(true);
        r12.a(1.0f);
        ICoreInputAbility r16 = D3();
        if (r16 != null) goto L51;
    L53:
        boolean r17 = false;
    L54:
        if (r17 == true) goto L64;
        View r18 = r8.j().a;
        if (r18 == null) goto L59;
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
    L61:
        if ((r19 instanceof ConstraintLayout.LayoutParams) == false) goto L64;
        r4 = (ConstraintLayout.LayoutParams) r19;
        goto L64
    L59:
        r19 = null;
    L64:
        if (r15 == true) goto L66;
    L73:
        if (r4 != null) goto L75;
    L79:
        r8.e().e(false);
        r8.d().e(false);
        r8.g().e(false);
        r8.f().e(false);
        r8.k().d(4);
        r8.j().e(true);
        return true;
    L75:
        if (r4.getMarginEnd() == i5.c0()) goto L79;
        FLogger.a.i("CreationInputComponent", "checkInstructionValid,scene:interceptActionSend,target size dp_44,inputText marginEnd:" + r4.getMarginEnd());
        r4.setMarginEnd(i5.c0());
        View r20 = r8.j().a;
        if (r20 == null) goto L79;
        r20.setLayoutParams(r4);
        goto L79
    L66:
        if (StringsKt.isBlank(this.A) == false) goto L73;
        if (r4 == null) goto L79;
        if (r4.getMarginEnd() == i5.u0()) goto L79;
        FLogger.a.i("CreationInputComponent", "checkInstructionValid,scene:interceptActionSend,target size dp_88,inputText marginEnd:" + r4.getMarginEnd());
        r4.setMarginEnd(i5.u0());
        View r21 = r8.j().a;
        if (r21 == null) goto L79;
        r21.setLayoutParams(r4);
        goto L79
    L51:
        if (r16.Q2() != true) goto L53;
        r17 = true;
        goto L54
    L41:
        if (r13.l6() != true) goto L43;
        r14 = true;
    L47:
        r15 = true;
        goto L48
    L27:
        if (r10.i3() != true) goto L29;
        r11 = true;
        goto L30
    L20:
        if (r7.w4() != true) goto L22;
        r9 = true;
    L35:
        r2.a(0.3f);
    L14:
        r6 = null;
        goto L16
    L80:
        return false;
    L5:
        if (r0.qo() != true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // py9.a
    public final void Yi(String r40) {
        Intrinsics.checkNotNullParameter(r40, "text");
        ys8.a r1 = Q3();
        if (r1 == null) goto L5;
        r1.M70();
    L5:
        ys8.a r2 = Q3();
        if (r2 == null) goto L8;
        r2.h60();
    L8:
        va8.o r3 = (va8.o) this.n.getValue();
        if (r3 == null) goto L13;
        CharSequence r4 = r3.getHint();
        if (r4 == null) goto L13;
        String r5 = r4.toString();
    L14:
        if (r5 != null) goto L16;
        r5 = "";
    L16:
        e4(new ICoreInputAbility.OnSendParams(r40, r5, null, null, null, null, null, null, 0, false, null, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, B3(), null, null, null, -536871200, 1, null));
        return;
    L13:
        r5 = null;
        goto L14
    }

    public void e4(ICoreInputAbility.OnSendParams r8) {
        Intrinsics.checkNotNullParameter(r8, "onSendParams");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationInputComponent$onSend$1(this, r8, null), 3, null);
    }

    public final void onViewCreated(View r12) {
        Intrinsics.checkNotNullParameter(r12, "view");
        if ((r12 instanceof ChatConstraintLayout) == false) goto L5;
        ChatConstraintLayout r0 = (ChatConstraintLayout) r12;
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        this.C = r12;
        boolean r13 = Z3();
        boolean r2 = true;
        r0.setDisableBottomPadding(true);
        if (a4() == false) goto L11;
    L12:
        r0.setDisableBottomPadding(false);
    L13:
        ny9.s r3 = C3();
        if (r3 != null) goto L16;
    L18:
        boolean r4 = false;
    L19:
        if (r4 == true) goto L21;
    L24:
        boolean r5 = true;
    L25:
        r0.setSubtractNavigationPaddingFromIme(r5);
        r0.setDisableTopPadding(true);
        r0.k6(getContext());
        if (r13 == false) goto L34;
        z8 r14 = E3();
        if (r14 == null) goto L30;
        r14.w9(false);
    L30:
        View r15 = this.C;
        if (r15 == null) goto L34;
        r15.post(new u(this));
    L34:
        if (q4() == false) goto L63;
        e1.d(r0, new x(this));
        int r16 = CreationHostUiPolicy.f;
        ny9.s r17 = C3();
        if (r17 == null) goto L38;
        Bundle r18 = r17.a;
    L39:
        CreationHostUiPolicy r19 = CreationHostUiPolicy.a.a(r18);
        if (q4() == true) goto L42;
    L50:
        boolean r110 = false;
    L52:
        if (r110 == false) goto L58;
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r111 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r111 == null) goto L64;
        View r112 = r111.findViewById(2131374177);
        if (r112 == null) goto L64;
        e1.x(r112);
    L64:
        ChatConstraintLayout r113 = F2();
        if ((r113 instanceof ChatConstraintLayout) == false) goto L67;
        ChatConstraintLayout r114 = r113;
    L68:
        if (r114 == null) goto L70;
        r114.setOnBottomInsetUpdateListener(new h0(this));
    L70:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationInputComponent$tryShowUpdateDialog$1(this, null), 3, null);
        z8 r115 = E3();
        if (r115 == null) goto L73;
        r115.z9(true);
    L73:
        z8 r116 = E3();
        if (r116 == null) goto L76;
        r116.R8();
    L76:
        z8 r117 = E3();
        if (r117 == null) goto L79;
        r117.s9();
    L79:
        z8 r118 = E3();
        if (r118 == null) goto L82;
        r118.f9(true);
    L82:
        z8 r119 = E3();
        if (r119 == null) goto L86;
        r119.w8();
    L86:
        if (z2.a.enableAddAlbumCreationInput() == false) goto L100;
        z8 r120 = E3();
        if (r120 == null) goto L100;
        List r6 = CollectionsKt.listOf(new Integer[]{16, 24, 11, 18});
        ny9.s r7 = C3();
        if (r7 == null) goto L92;
        Integer r8 = r7.l();
    L94:
        if (CollectionsKt.contains(r6, r8) == false) goto L96;
    L98:
        boolean r9 = false;
    L99:
        r120.l9(new z8.b(r9, new b0(this)));
        goto L100
    L96:
        if (a4() == true) goto L98;
        r9 = true;
        goto L99
    L92:
        r8 = null;
    L100:
        z8 r121 = E3();
        if (r121 == null) goto L104;
        r121.c9();
    L104:
        if (a4() == false) goto L108;
        z8 r122 = E3();
        if (r122 == null) goto L108;
        r122.r9();
    L108:
        ICoreInputAbility r123 = D3();
        if (r123 == null) goto L111;
        r123.tr(new c0(this));
    L111:
        z8 r124 = E3();
        if (r124 == null) goto L114;
        r124.y9(1, new g9.a(new d0(this)));
    L114:
        z8 r125 = E3();
        if (r125 == null) goto L117;
        r125.y9(2, new g9.a(new e0(this)));
    L117:
        z8 r126 = E3();
        if (r126 == null) goto L120;
        r126.y9(3, new g9.a(new f0(this)));
    L120:
        z8 r127 = E3();
        if (r127 == null) goto L123;
        r127.r8(true, new z8.e(new g0(this), new com.larus.uaigc.createpage.component.input.c(this)));
    L123:
        ICoreInputAbility r128 = D3();
        if (r128 == null) goto L126;
        r128.YT(new c(this));
    L126:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r129 = s1a.d.a(this).getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r129 == null) goto L129;
        com.larus.bmhome.chat.component.bottom.core.speaker.l.a.b(r129, new d(this));
    L129:
        ny9.s r130 = C3();
        if (r130 != null) goto L132;
    L134:
        boolean r131 = false;
    L135:
        if (r131 == false) goto L141;
        ny9.s r132 = C3();
        if (r132 == null) goto L144;
        CustomInputInitData r133 = r132.g();
        if (r133 == null) goto L144;
        String r134 = r133.b();
    L145:
        if (r134 == null) goto L148;
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new CreationInputComponent$initInputContent$1$1(this, r134, null));
    L148:
        if (n70() == false) goto L150;
        Bl("instructionPageAutoShow");
    L150:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationInputComponent$bindObservers$1(this, null), 3, null);
        ny9.s r135 = C3();
        if (r135 != null) goto L153;
    L155:
        r2 = false;
    L156:
        if (r2 == false) goto L159;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationInputComponent$bindObservers$2(this, null), 3, null);
        return;
    L159:
        return;
    L153:
        if (r135.C() != true) goto L155;
    L144:
        r134 = null;
        goto L145
    L141:
        ny9.s r136 = C3();
        if (r136 == null) goto L144;
        r134 = r136.q();
        goto L145
    L132:
        if (r130.z() != true) goto L134;
        r131 = true;
        goto L135
    L67:
        r114 = null;
        goto L68
    L58:
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r137 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r137 == null) goto L64;
        View r138 = r137.findViewById(2131374177);
        if (r138 == null) goto L64;
        e1.o(r138);
        goto L64
    L42:
        if (r19.a == false) goto L44;
    L47:
        boolean r139 = true;
    L48:
        if (r139 == true) goto L50;
        r110 = true;
        goto L52
    L44:
        if (r19.d == true) goto L47;
        r139 = false;
        goto L48
    L38:
        r18 = null;
        goto L39
    L63:
        e1.d(r0, new a0(this));
        goto L64
    L21:
        if (a4() == true) goto L24;
        r5 = false;
        goto L25
    L16:
        if (r3.a() != true) goto L18;
        r4 = true;
        goto L19
    L11:
        if (ObricChatUIDelegate.b.m() == false) goto L13;
    L5:
        r0 = null;
        goto L6
    }

    public final void v4(String r5) {
        if (k4() == false) goto L5;
        return;
    L5:
        ICoreInputAbility r0 = D3();
        if (r0 == null) goto L9;
        ICoreInputAbility.b.e(r0, r5, null, false, 6);
        return;
    }

    public final Map<String, String> m3(String r11, boolean r12) {
        ys8.a r0 = Q3();
        Long r1 = null;
        if (r0 == null) goto L5;
        String r5 = r0.y60(r11, r12);
    L6:
        FLogger.a.d("CreationInputComponent", "ActionBarInstructionParam: " + r5);
        ny9.s r13 = C3();
        int r2 = 0;
        if (r13 != null) goto L9;
    L11:
        boolean r14 = false;
    L12:
        String r3 = "";
        if (r14 == false) goto L25;
        String r15 = StringsKt.trim(r11).toString();
        ny9.s r16 = C3();
        if (r16 == null) goto L19;
        CustomInputInitData r17 = r16.g();
        if (r17 == null) goto L19;
        String r18 = r17.b();
    L20:
        if (r18 != null) goto L23;
        r18 = "";
    L23:
        if (Intrinsics.areEqual(r15, StringsKt.trim(r18).toString()) == false) goto L33;
    L34:
        boolean r6 = false;
    L35:
        com.larus.bmhome.instruction.j r4 = IAIChatUgcAIGCService.a.e0();
        ny9.s r19 = C3();
        if (r19 == null) goto L40;
        z0 r110 = r19.f();
        if (r110 == null) goto L40;
        String r111 = r110.b;
    L41:
        if (r111 == null) goto L44;
        r3 = r111;
    L44:
        ny9.s r112 = C3();
        if (r112 == null) goto L51;
        com.larus.bmhome.actionbar.model.r r113 = r112.k();
        if (r113 == null) goto L51;
        Integer r114 = r113.a;
        if (r114 == null) goto L51;
        r2 = r114.intValue();
    L51:
        String r7 = String.valueOf(r2);
        ny9.s r115 = C3();
        if (r115 == null) goto L57;
        z0 r116 = r115.f();
        if (r116 == null) goto L57;
        r1 = r116.a;
    L57:
        return com.larus.bmhome.instruction.j.a.c(r4, r3, r7, r5, r6, null, r1, 16);
    L40:
        r111 = null;
    L33:
        r6 = true;
    L19:
        r18 = null;
        goto L20
    L25:
        String r117 = StringsKt.trim(r11).toString();
        ny9.s r118 = C3();
        if (r118 == null) goto L28;
        String r119 = r118.q();
    L29:
        if (r119 != null) goto L32;
        r119 = "";
    L32:
        if (Intrinsics.areEqual(r117, StringsKt.trim(r119).toString()) == true) goto L34;
    L28:
        r119 = null;
        goto L29
    L9:
        if (r13.z() != true) goto L11;
        r14 = true;
        goto L12
    L5:
        r5 = null;
        goto L6
    }

    public final void h4(final String r2, long r3, final int r5) {
        NM();
        Runnable r0 = new s(this, r5, r2);
        this.E = r0;
        View r4 = this.C;
        if (r4 != null) goto L5;
        r0.run();
        return;
    L5:
        r4.postDelayed(r0, r3);
    }
}
