package com.larus.uaigc.createpage.component.template;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.creative.utils.ImageTemplateChooseViewModel;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.k1;
import com.larus.im.bean.message.Image;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.CreationPublishExtra;
import com.larus.platform.api.creation.OptionItem;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.TplDetail;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.api.creation.VideoUserContent;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateImage;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.e0;
import com.larus.platform.service.m3;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.applet.IAICreationAppletHostService;
import com.larus.uaigc.createpage.CreationHostUiPolicy;
import com.larus.uaigc.createpage.v;
import com.larus.uaigc.impl.databinding.LarusFragmentCreationPageBinding;
import com.larus.uaigc.service.ICreationAvatarService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;
import org.json.JSONObject;
import tx9.a1;
import tx9.c0;
import tx9.u3;
import tx9.x2;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000û\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\b*\u0001\u0017\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0002\u0099\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\rH\u0002J\b\u0010+\u001a\u00020\rH\u0002J\b\u0010\\\u001a\u00020]H\u0016J\b\u0010^\u001a\u00020]H\u0016J\b\u0010_\u001a\u00020]H\u0016J\b\u0010`\u001a\u00020aH\u0002J\u0010\u0010c\u001a\u00020]2\u0006\u0010d\u001a\u00020eH\u0016J\b\u0010f\u001a\u00020]H\u0002J\b\u0010g\u001a\u00020]H\u0016J\u0010\u0010h\u001a\u00020]2\u0006\u0010i\u001a\u00020UH\u0002J\u001e\u0010j\u001a\u0004\u0018\u00010a2\u0006\u0010k\u001a\u00020l2\n\b\u0001\u0010m\u001a\u0004\u0018\u00010aH\u0002JD\u0010n\u001a\u00020]2\u0006\u0010k\u001a\u00020l2\u0006\u0010o\u001a\u00020U2\b\u0010p\u001a\u0004\u0018\u00010a2\b\u0010q\u001a\u0004\u0018\u00010a2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010s2\n\b\u0001\u0010m\u001a\u0004\u0018\u00010aH\u0002J\u0010\u0010t\u001a\u00020\r2\u0006\u0010k\u001a\u00020lH\u0002J8\u0010u\u001a\u00020]2\u0006\u0010k\u001a\u00020l2\u0006\u0010o\u001a\u00020U2\b\u0010p\u001a\u0004\u0018\u00010a2\b\u0010q\u001a\u0004\u0018\u00010a2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010sH\u0002J\b\u0010v\u001a\u00020]H\u0016J\u0010\u0010w\u001a\u00020]2\u0006\u0010x\u001a\u00020aH\u0002J\b\u0010y\u001a\u00020aH\u0002J(\u0010z\u001a\u00020\r2\u0006\u0010k\u001a\u00020l2\u0006\u0010i\u001a\u00020U2\u0006\u0010{\u001a\u00020\r2\u0006\u0010|\u001a\u00020\rH\u0002J\f\u0010}\u001a\u00020~*\u00020~H\u0002J\f\u0010\u007f\u001a\u00020~*\u00020~H\u0002J\r\u0010\u0080\u0001\u001a\u00020~*\u00020~H\u0002J\u0012\u0010\u0081\u0001\u001a\u00020]2\u0007\u0010\u0082\u0001\u001a\u00020\u0015H\u0002J\u0011\u0010\u0083\u0001\u001a\u00020]2\u0006\u0010i\u001a\u00020UH\u0002J\t\u0010\u0084\u0001\u001a\u00020]H\u0002J\u0011\u0010\u0085\u0001\u001a\u00020]2\u0006\u0010i\u001a\u00020UH\u0002J\u0011\u0010\u0086\u0001\u001a\u00020]2\u0006\u0010i\u001a\u00020UH\u0002JA\u0010\u0087\u0001\u001a\u00020\r2\u0006\u0010i\u001a\u00020U2\u0006\u0010k\u001a\u00020l2\u0006\u0010o\u001a\u00020U2\b\u0010p\u001a\u0004\u0018\u00010a2\b\u0010q\u001a\u0004\u0018\u00010a2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010sH\u0002J\t\u0010\u008c\u0001\u001a\u00020]H\u0002J\u001f\u0010\u008d\u0001\u001a\u00020]2\b\u0010k\u001a\u0004\u0018\u00010l2\n\b\u0003\u0010m\u001a\u0004\u0018\u00010aH\u0002J\t\u0010\u008e\u0001\u001a\u00020]H\u0002J \u0010\u008f\u0001\u001a\u0011\u0012\u0004\u0012\u00020a\u0012\u0006\u0012\u0004\u0018\u00010a0\u0090\u00012\u0006\u0010k\u001a\u00020lH\u0002J\u0010\u0010\u0091\u0001\u001a\t\u0012\u0004\u0012\u00020a0\u0092\u0001H\u0002J\b\u0010 \u001a\u00020]H\u0016J\t\u0010\u0093\u0001\u001a\u00020]H\u0016J\t\u0010\u0094\u0001\u001a\u00020\rH\u0016J\t\u0010\u0095\u0001\u001a\u00020\rH\u0016J\u000b\u0010\u0096\u0001\u001a\u0004\u0018\u00010aH\u0016J\u000b\u0010\u0097\u0001\u001a\u0004\u0018\u00010aH\u0016J\t\u0010\u0098\u0001\u001a\u00020]H\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010$\u001a\u0004\u0018\u00010%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001d\u0010,\u001a\u0004\u0018\u00010-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u000b\u001a\u0004\b.\u0010/R\u001d\u00101\u001a\u0004\u0018\u0001028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u000b\u001a\u0004\b3\u00104R\u001d\u00106\u001a\u0004\u0018\u0001078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u000b\u001a\u0004\b8\u00109R\u001d\u0010;\u001a\u0004\u0018\u00010<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u000b\u001a\u0004\b=\u0010>R\u001d\u0010@\u001a\u0004\u0018\u00010A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u000b\u001a\u0004\bB\u0010CR\u001d\u0010E\u001a\u0004\u0018\u00010F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\u000b\u001a\u0004\bG\u0010HR\u001d\u0010J\u001a\u0004\u0018\u00010K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\u000b\u001a\u0004\bL\u0010MR\u001d\u0010O\u001a\u0004\u0018\u00010P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\u000b\u001a\u0004\bQ\u0010RR\u0012\u0010T\u001a\u0004\u0018\u00010UX\u0082\u000e¢\u0006\u0004\n\u0002\u0010VR\u001d\u0010W\u001a\u0004\u0018\u00010X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\u000b\u001a\u0004\bY\u0010ZR\u0010\u0010b\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0088\u0001\u001a\t\u0018\u00010\u0089\u0001R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u009a\u0001"}, d2 = {"Lcom/larus/uaigc/createpage/component/template/TemplateFeedComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/uaigc/bean/createpage/component/templatefeed/ITemplateFeedAbility;", "<init>", "()V", "argumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "_disableShowTitle", "", "templatePrefetchHelper", "Lcom/larus/bmhome/instruction/ITemplatePrefetchHelper;", "creationDoSameAbility", "Lcom/larus/platform/model/creation/ICreationDoSameAbility;", "leaveStartTime", "", "currentTabItemInfo", "Lcom/larus/platform/api/creation/TabItemInfo;", "appBackGroundListener", "com/larus/uaigc/createpage/component/template/TemplateFeedComponent$appBackGroundListener$1", "Lcom/larus/uaigc/createpage/component/template/TemplateFeedComponent$appBackGroundListener$1;", "enableTemplateFeed", "getEnableTemplateFeed", "()Z", "disableShowTitle", "getDisableShowTitle", "_hideInstructionPanelFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "hideInstructionPanelFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getHideInstructionPanelFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "safeVContext", "Lcom/larus/ui/arch/context/external/VContext;", "getSafeVContext", "()Lcom/larus/ui/arch/context/external/VContext;", "hostUiPolicy", "Lcom/larus/uaigc/createpage/CreationHostUiPolicy;", "shouldDisableShowTitle", "shouldUseTemplateFeedKmp", "creationInputAbility", "Lcom/larus/uaigc/bean/createpage/component/input/CreationIInputAbility;", "getCreationInputAbility", "()Lcom/larus/uaigc/bean/createpage/component/input/CreationIInputAbility;", "creationInputAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "hitPointData", "Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "getHitPointData", "()Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "hitPointData$delegate", "imageSelectorAbility", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/imageselector/IImageSelectorAbility;", "getImageSelectorAbility", "()Lcom/larus/uaigc/bean/createpage/component/mediacontainer/imageselector/IImageSelectorAbility;", "imageSelectorAbility$delegate", "multiAttachmentSelectorAbility", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMultiAttachmentSelectorAbility;", "getMultiAttachmentSelectorAbility", "()Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMultiAttachmentSelectorAbility;", "multiAttachmentSelectorAbility$delegate", "digitalAvatarAbility", "Lcom/larus/uaigc/bean/createpage/component/digitalavatar/IDigitalAvatarAbility;", "getDigitalAvatarAbility", "()Lcom/larus/uaigc/bean/createpage/component/digitalavatar/IDigitalAvatarAbility;", "digitalAvatarAbility$delegate", "creationEditorAbility", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "getCreationEditorAbility", "()Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "creationEditorAbility$delegate", "lastInputStatus", "", "Ljava/lang/Integer;", "creationFragmentAbility", "Lcom/larus/uaigc/createpage/CreationFragmentAbility;", "getCreationFragmentAbility", "()Lcom/larus/uaigc/createpage/CreationFragmentAbility;", "creationFragmentAbility$delegate", "onAttach", "", "onDestroy", "onCreate", "getCurrentPageName", "", "templatePageType", "onViewCreated", "view", "Landroid/view/View;", "initTemplatePageType", "onResume", "showDigitalAvatarFeedV2", "instructionType", "getDoSamePrompt", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "quickMenuItemType", "imageVideoMixDoSame", "position", "enterFrom", "aiCreationRecommendFrom", "localImagePath", "Landroid/net/Uri;", "isPrivate", "imageDoSame", "onStop", "reportLeaveAIGeneratePage", "leaveMethod", "getTabType", "openCreationDetailInApplet", "showUsageCount", "ignoreTplInfo", "markHostSourceIfNeeded", "Landroid/os/Bundle;", "markDisableInitialAutoRefreshForPendingPublish", "markPendingPublishCreationIfNeeded", "onTemplateTabSelected", "tabItemInfo", "showImageVideoMixTemplateFeed", "clearImageVideoMixSkillStyle", "showImageTemplateFeedV2", "showVideoTemplateFeedV2", "videoDoSame", "creationDataCacheOpenAlbum", "Lcom/larus/uaigc/createpage/component/template/TemplateFeedComponent$CreationDataCacheOpenAlbum;", "aiBeautifyPickPhotoHelper", "Lcom/larus/bmhome/instruction/helper/IAiBeautifyPickPhotoHelper;", "openSystemAlbum", "setSendMessageMap", "clearSelectedTemplateInExtMap", "getTrackExtMapOfSelectedTemplate", "", "getTrackExtKeysOfSelectedTemplate", "", "onRefImageSelected", "interceptQuit", "interceptSendFinish", "getTemplatePageName", "getTemplatePageType", "initFeedUIState", "CreationDataCacheOpenAlbum", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class TemplateFeedComponent extends BaseContentWidget implements uy9.a {
    public static final /* synthetic */ int I = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public Integer D;
    public final Lazy E;
    public String F;
    public a G;
    public com.larus.bmhome.instruction.helper.f H;
    public final Lazy m;
    public boolean n;
    public final com.larus.bmhome.instruction.m o;
    public sq9.t p;
    public long q;
    public TabItemInfo r;
    public final b s;
    public final StateFlowImpl t;
    public final b1 u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public final class a {
        public final int a;
        public final UserCreation b;
        public final int c;
        public final String d;
        public final String e;

        public a(int r2, UserCreation r3, int r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r3, "userCreation");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class b implements f09.a.b {
        public final /* synthetic */ TemplateFeedComponent a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppForeground() {
        }

        public final void onAppBackground() {
            TemplateFeedComponent r0 = this.a;
            int r1 = TemplateFeedComponent.I;
            r0.d4("leave_app");
        }

        public b(TemplateFeedComponent r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.template.TemplateFeedComponent$onResume$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.template.TemplateFeedComponent$onResume$1", f = "TemplateFeedComponent.kt", i = {}, l = {376}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ TemplateFeedComponent this$0;

        public AnonymousClass1(TemplateFeedComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public static View INVOKEVIRTUAL_com_larus_uaigc_createpage_component_template_TemplateFeedComponent$onResume$1_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
            View r4 = r3.getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L7;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r0 = ThreadMethodProxy.currentThread();
            if (r0 == com.larus.home.impl.utils.c.a) goto L7;
            com.larus.home.impl.utils.c.a(r0, "getDecorView");
        L7:
            return r4;
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L11:
            TemplateFeedComponent r8 = this.this$0;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L70
            if (((Boolean) r8.u.getValue()).booleanValue() == false) goto L29;
            int r4 = ContextCompat.getColor(r8.getContext(), v19.c.b(2130970529, r8.getContext(), 2131102529));     // Catch: Throwable -> L70
            Intrinsics.checkNotNullParameter(r8, "<this>");     // Catch: Throwable -> L70
            FragmentActivity r5 = com.larus.ui.arch.component.internal.attach.a.b(r8, r8).getActivity();     // Catch: Throwable -> L70
            if (r5 == null) goto L22;
            Window r6 = r5.getWindow();     // Catch: Throwable -> L70
            if (r6 == null) goto L22;
            View r9 = INVOKEVIRTUAL_com_larus_uaigc_createpage_component_template_TemplateFeedComponent$onResume$1_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r6);     // Catch: Throwable -> L70
            if (r9 == null) goto L22;
            r9.setBackgroundColor(r4);     // Catch: Throwable -> L70
        L22:
            v r10 = (v) r8.E.getValue();     // Catch: Throwable -> L70
            if (r10 == null) goto L67;
            LarusFragmentCreationPageBinding r11 = r10.e();     // Catch: Throwable -> L70
            if (r11 == null) goto L67;
            FrameLayout r12 = r11.g;     // Catch: Throwable -> L70
            if (r12 == null) goto L67;
            r12.setBackgroundColor(r4);     // Catch: Throwable -> L70
            Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L70
        L68:
            Result.constructor-impl(r13);     // Catch: Throwable -> L70
        L73:
            return Unit.INSTANCE;
        L67:
            r13 = null;
            goto L68
        L29:
            ny9.s r14 = r8.z3();     // Catch: Throwable -> L70
            if (r14 == null) goto L37;
            Integer r15 = r14.l();     // Catch: Throwable -> L70
            if (r15 == null) goto L37;
            if (r15.intValue() != 28) goto L37;
        L38:
            if (r2 == true) goto L53;
            int r16 = ContextCompat.getColor(r8.getContext(), v19.c.b(2130970531, r8.getContext(), 2131102535));     // Catch: Throwable -> L70
            Intrinsics.checkNotNullParameter(r8, "<this>");     // Catch: Throwable -> L70
            FragmentActivity r17 = com.larus.ui.arch.component.internal.attach.a.b(r8, r8).getActivity();     // Catch: Throwable -> L70
            if (r17 == null) goto L46;
            Window r18 = r17.getWindow();     // Catch: Throwable -> L70
            if (r18 == null) goto L46;
            View r19 = INVOKEVIRTUAL_com_larus_uaigc_createpage_component_template_TemplateFeedComponent$onResume$1_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r18);     // Catch: Throwable -> L70
            if (r19 == null) goto L46;
            r19.setBackgroundColor(r16);     // Catch: Throwable -> L70
        L46:
            v r20 = (v) r8.E.getValue();     // Catch: Throwable -> L70
            if (r20 == null) goto L67;
            LarusFragmentCreationPageBinding r21 = r20.e();     // Catch: Throwable -> L70
            if (r21 == null) goto L67;
            FrameLayout r22 = r21.g;     // Catch: Throwable -> L70
            if (r22 == null) goto L67;
            r22.setBackgroundColor(r16);     // Catch: Throwable -> L70
            r13 = Unit.INSTANCE;     // Catch: Throwable -> L70
            goto L68
        L53:
            int r23 = ContextCompat.getColor(r8.getContext(), v19.c.b(2130970529, r8.getContext(), 2131102529));     // Catch: Throwable -> L70
            Intrinsics.checkNotNullParameter(r8, "<this>");     // Catch: Throwable -> L70
            FragmentActivity r24 = com.larus.ui.arch.component.internal.attach.a.b(r8, r8).getActivity();     // Catch: Throwable -> L70
            if (r24 == null) goto L60;
            Window r25 = r24.getWindow();     // Catch: Throwable -> L70
            if (r25 == null) goto L60;
            View r26 = INVOKEVIRTUAL_com_larus_uaigc_createpage_component_template_TemplateFeedComponent$onResume$1_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r25);     // Catch: Throwable -> L70
            if (r26 == null) goto L60;
            r26.setBackgroundColor(r23);     // Catch: Throwable -> L70
        L60:
            v r27 = (v) r8.E.getValue();     // Catch: Throwable -> L70
            if (r27 == null) goto L67;
            LarusFragmentCreationPageBinding r28 = r27.e();     // Catch: Throwable -> L70
            if (r28 == null) goto L67;
            FrameLayout r29 = r28.g;     // Catch: Throwable -> L70
            if (r29 == null) goto L67;
            r29.setBackgroundColor(r23);     // Catch: Throwable -> L70
            r13 = Unit.INSTANCE;     // Catch: Throwable -> L70
        L37:
            r2 = false;
        L70:
            th = move-exception;
            Result.Companion r30 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L73
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            this.label = 1;
            if (DelayKt.delay(50, this) != r0) goto L11;
            return r0;
        }
    }

    public final t1a.b G3() {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L9
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity() == null) goto L6;
        t1a.b r2 = s1a.d.a(this);     // Catch: Throwable -> L9
    L7:
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r3) == true) goto L16;
        r0 = r3;
    L16:
        return (t1a.b) r0;
    L6:
        r2 = null;
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // uy9.a
    public final void HQ() {
    }

    @Override // uy9.a
    public final void Rq() {
    }

    public final ICoreInputAbility B3() {
        return (ICoreInputAbility) this.w.getValue();
    }

    public final ys8.a C3() {
        return (ys8.a) this.C.getValue();
    }

    public final ny9.u E3() {
        return (ny9.u) this.y.getValue();
    }

    public final CreationHostUiPolicy H3() {
        int r0 = CreationHostUiPolicy.f;
        ny9.s r1 = z3();
        if (r1 == null) goto L5;
        Bundle r2 = r1.a;
    L7:
        return CreationHostUiPolicy.a.a(r2);
    L5:
        r2 = null;
        goto L7
    }

    @Override // uy9.a
    public final String PG() {
        if (this.F != null) goto L6;
        V3();
    L6:
        return this.F;
    }

    @Override // uy9.a
    public final void aL() {
        if (((Boolean) this.t.getValue()).booleanValue() == false) goto L17;
        ny9.u r1 = E3();
        if (r1 == null) goto L7;
        String r2 = r1.q();
    L8:
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        if (r2.length() != 0) goto L13;
        boolean r8 = true;
    L14:
        if (r8 == false) goto L16;
        r2 = "image_generate";
    L16:
        a1.c(null, null, null, null, null, r2, null, null, "add_reference_image", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1153, -1, 7);
        goto L17
    L13:
        r8 = false;
        goto L14
    L7:
        r2 = null;
    L17:
        this.t.setValue(Boolean.FALSE);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new TemplateFeedComponent$onRefImageSelected$2(this, null), 2, null);
    }

    public final void c4() {
        com.larus.bmhome.instruction.helper.f r1 = this.H;
        if (r1 == null) goto L5;
        com.larus.bmhome.instruction.helper.f.a.a(r1, null, 7);
    L5:
        c0.H(null, "use_template", "use_template", null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, 33554425);
    }

    @Override // uy9.a
    public final void hb() {
        this.t.setValue(Boolean.TRUE);
    }

    public final boolean i4() {
        z2 r0 = z2.a;
        if (r0.X3() == true) goto L7;
        return false;
    L7:
        if (H3().a == true) goto L9;
        return true;
    L9:
        return r0.enableAICreationAppletKmpFeed();
    }

    @Override // uy9.a
    public final boolean jT() {
        if (((Boolean) this.u.getValue()).booleanValue() == true) goto L39;
        this.t.setValue(Boolean.TRUE);
        va8.o r0 = (va8.o) this.x.getValue();
        if (r0 == null) goto L7;
        r0.ra();
    L7:
        ny9.s r1 = z3();
        if (r1 != null) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == false) goto L17;
        ICoreInputAbility r3 = B3();
        if (r3 == null) goto L20;
        r3.qp(false);
    L20:
        sy9.a r4 = (sy9.a) this.z.getValue();
        if (r4 == null) goto L23;
        r4.YO();
    L23:
        p3();
        ys8.a r5 = C3();
        if (r5 == null) goto L26;
        r5.pV();
    L26:
        ICoreInputAbility r6 = B3();
        if (r6 == null) goto L29;
        Integer r7 = Integer.valueOf(r6.Rp());
    L31:
        if (Intrinsics.areEqual(this.D, r7) == true) goto L38;
        Integer r8 = this.D;
        if (r8 == null) goto L38;
        int r9 = r8.intValue();
        ICoreInputAbility r10 = B3();
        if (r10 == null) goto L37;
        r10.g2(r9, true);
    L37:
        this.D = null;
    L38:
        return true;
    L29:
        r7 = null;
        goto L31
    L17:
        ICoreInputAbility r11 = B3();
        if (r11 == null) goto L20;
        r11.p80(true);
        goto L20
    L10:
        if (r1.C() != true) goto L12;
        r2 = true;
        goto L13
    L39:
        return false;
    }

    public final void m3() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r0 == null) goto L6;
        new ViewModelProvider(r0).get(ImageTemplateChooseViewModel.class).onImageTemplateChoose(new com.larus.bmhome.creative.utils.b(null, null, true, null, null, true, 27));
        return;
    }

    public final void onDestroy() {
        sq9.t r0 = this.p;
        if (r0 == null) goto L5;
        r0.onDestroy();
    L5:
        ny9.s r1 = z3();
        if (r1 == null) goto L8;
        final Integer r2 = r1.l();
    L9:
        if (r2 != null) goto L12;
    L13:
        if (r2 != null) goto L16;
    L18:
        if (r2 != null) goto L21;
    L23:
        if (r2 != null) goto L26;
    L28:
        if (r2 != null) goto L31;
    L33:
        int r3 = -1;
    L35:
        if (r3 <= 0) goto L37;
        final com.larus.bmhome.instruction.m r4 = IAIChatUgcAIGCService.a.w0();
        e0.a.e(r3, H3().a, new com.larus.uaigc.createpage.component.template.b(r4, r2));
    L37:
        AppHost.a.a().c(this.s);
        return;
    L31:
        if (r2.intValue() != 18) goto L33;
        r3 = 5;
        goto L35
    L26:
        if (r2.intValue() != 28) goto L28;
        r3 = 7;
        goto L35
    L21:
        if (r2.intValue() != 11) goto L23;
        r3 = 3;
        goto L35
    L16:
        if (r2.intValue() != 16) goto L18;
    L34:
        r3 = 2;
        goto L35
    L12:
        if (r2.intValue() == 4) goto L34;
    L8:
        r2 = null;
        goto L9
    }

    public final void onStop() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        AppHost.Companion r1 = AppHost.a;
        List r2 = CollectionsKt.reversed(r1.a().g());
        boolean r4 = true;
        if (r2.size() > 1) goto L5;
    L7:
        r4 = false;
    L9:
        if (Intrinsics.areEqual(r1.a().getCurrentActivity(), r0) == false) goto L11;
        return;
    L11:
        if (r4 == false) goto L13;
        d4("enter_new_page");
        return;
    L13:
        d4("leave_page");
        return;
    L5:
        if (Intrinsics.areEqual(ListProtector.get(r2, 1), r0) == false) goto L7;
        goto L7
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, uy9.a.class);
        IAIChatUgcAIGCService.Companion r1 = IAIChatUgcAIGCService.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.larus.bmhome.instruction.helper.f r2 = r1.H0(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        r2.b(new c(this));
        this.H = r2;
        m3 r3 = m3.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.p = r3.q(com.larus.ui.arch.component.internal.attach.a.b(this, this));
    }

    public final ny9.s z3() {
        return (ny9.s) this.m.getValue();
    }

    public TemplateFeedComponent() {
        this.m = LazyKt.lazy(new com.larus.uaigc.createpage.component.template.a(this));
        this.o = IAIChatUgcAIGCService.a.w0();
        this.s = new b(this);
        StateFlowImpl r0 = j1.a(Boolean.FALSE);
        this.t = r0;
        this.u = kotlinx.coroutines.flow.e.b(r0);
        this.v = LazyKt.lazy(new h(this));
        this.w = LazyKt.lazy(new i(this));
        this.x = LazyKt.lazy(new j(this));
        this.y = LazyKt.lazy(new k(this));
        this.z = LazyKt.lazy(new l(this));
        this.A = LazyKt.lazy(new m(this));
        this.B = LazyKt.lazy(new n(this));
        this.C = LazyKt.lazy(new o(this));
        this.E = LazyKt.lazy(new p(this));
    }

    @Override // uy9.a
    public final boolean JS() {
        ny9.u r0 = E3();
        if (r0 == null) goto L5;
        String r1 = r0.getEnterMethod();
    L7:
        if (Intrinsics.areEqual(r1, "5tab_create_pannel") == true) goto L9;
        return false;
    L9:
        if (((Boolean) this.u.getValue()).booleanValue() == true) goto L34;
        this.t.setValue(Boolean.TRUE);
        va8.o r2 = (va8.o) this.x.getValue();
        if (r2 == null) goto L13;
        r2.ra();
    L13:
        ICoreInputAbility r3 = B3();
        if (r3 == null) goto L16;
        r3.p80(true);
    L16:
        sy9.a r4 = (sy9.a) this.z.getValue();
        if (r4 == null) goto L19;
        r4.YO();
    L19:
        p3();
        ys8.a r5 = C3();
        if (r5 == null) goto L22;
        r5.pV();
    L22:
        ICoreInputAbility r6 = B3();
        if (r6 == null) goto L25;
        Integer r7 = Integer.valueOf(r6.Rp());
    L27:
        if (Intrinsics.areEqual(this.D, r7) == true) goto L34;
        Integer r8 = this.D;
        if (r8 == null) goto L34;
        int r9 = r8.intValue();
        ICoreInputAbility r10 = B3();
        if (r10 == null) goto L33;
        r10.g2(r9, true);
    L33:
        this.D = null;
        goto L34
    L25:
        r7 = null;
    L34:
        return true;
    L5:
        r1 = null;
        goto L7
    }

    public final void V3() {
        ny9.s r0 = z3();
        if (r0 == null) goto L5;
        Integer r1 = r0.l();
    L6:
        if (r1 != null) goto L9;
    L10:
        if (r1 != null) goto L13;
    L15:
        if (r1 != null) goto L18;
    L20:
        if (r1 != null) goto L23;
    L25:
        if (r1 != null) goto L28;
        return;
    L28:
        if (r1.intValue() != 28) goto L34;
        this.F = "mix";
        return;
    L34:
        return;
    L23:
        if (r1.intValue() != 18) goto L25;
        this.F = "video";
        return;
    L18:
        if (r1.intValue() != 11) goto L20;
        this.F = "avatar";
        return;
    L13:
        if (r1.intValue() != 16) goto L15;
    L30:
        this.F = "image";
        return;
    L9:
        if (r1.intValue() == 4) goto L30;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean h4() {
        H3();
        return z2.a.f1().j();
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        ny9.s r0 = z3();
        Integer r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.v();
    L6:
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L18;
        com.larus.bmhome.instruction.m r4 = this.o;
        Intrinsics.checkNotNullParameter(this, "<this>");
        LifecycleCoroutineScope r5 = LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        ny9.s r6 = z3();
        if (r6 == null) goto L16;
        r1 = r6.l();
    L16:
        r4.a(r5, r1);
        return;
    L18:
        return;
    L8:
        if (r2.length() == 0) goto L11;
        r3 = false;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public final void onResume() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        this.q = SystemClock.elapsedRealtime();
    }

    public final void p3() {
        ny9.s r0 = z3();
        if (r0 == null) goto L16;
        Bundle r1 = r0.a;
        if (r1 == null) goto L16;
        ny9.s r2 = z3();
        if (r2 == null) goto L10;
        ICoreInputAbility.SendMessageTrackExtMap r3 = r2.n();
        if (r3 == null) goto L10;
    L11:
        Map r4 = MapsKt.toMutableMap(r3.a);
        Iterator r5 = CollectionsKt.listOf(new String[]{"from_template_id", "from_template_type", "template_rec_req_id", "from_template_source", "recommend_from"}).iterator();
    L13:
        if (r5.hasNext() == false) goto L15;
        r4.remove((String) r5.next());
        goto L13
    L15:
        Intrinsics.checkNotNullParameter(r4, "extMap");
        r1.putParcelable("actionbar_instruction_send_message_track_ext_map", new ICoreInputAbility.SendMessageTrackExtMap(r4));
    L10:
        r3 = new ICoreInputAbility.SendMessageTrackExtMap(0);
    L16:
        ny9.s r6 = z3();
        if (r6 == null) goto L28;
        Bundle r7 = r6.a;
        if (r7 == null) goto L29;
        ny9.s r8 = z3();
        if (r8 == null) goto L24;
        ICoreInputAbility.MessageExtMap r9 = r8.m();
        if (r9 == null) goto L24;
    L25:
        Map r10 = MapsKt.toMutableMap(r9.a);
        r10.remove("creation_template");
        Intrinsics.checkNotNullParameter(r10, "extMap");
        r7.putParcelable("actionbar_instruction_message_ext_map", new ICoreInputAbility.MessageExtMap(r10));
        return;
    L24:
        r9 = new ICoreInputAbility.MessageExtMap(MapsKt.emptyMap());
        goto L25
    L29:
        return;
    }

    @Override // uy9.a
    public final boolean Ah() {
        return this.n;
    }

    @Override // uy9.a
    public final b1 gT() {
        return this.u;
    }

    public static boolean W3(UserCreation r3) {
        CreationPublishExtra r0 = r3.p;
        if (r0 == null) goto L5;
        boolean r1 = Intrinsics.areEqual(r0.b, Boolean.FALSE);
    L6:
        if (r1 == false) goto L15;
        AuthorInfo r4 = r3.g;
        if (r4 == null) goto L10;
        String r5 = r4.b;
    L12:
        if (Intrinsics.areEqual(r5, AccountService.a.getUserId()) == true) goto L16;
        return true;
    L16:
        return false;
    L10:
        r5 = null;
        goto L12
    L15:
        return false;
    L5:
        r1 = false;
        goto L6
    }

    public final void X3(Bundle r4) {
        boolean r1 = false;
        if (cy9.e.b(r4) == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L15;
        ny9.s r2 = z3();
        if (r2 == null) goto L10;
        Bundle r3 = r2.a;
    L12:
        if (cy9.e.b(r3) == null) goto L14;
        r1 = true;
    L14:
        if (r1 == true) goto L15;
        return;
    L10:
        r3 = null;
    L15:
        r4.putBoolean("key_disable_initial_auto_refresh_once", true);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void Z3(Bundle r3) {
        if (H3().a == false) goto L6;
        r3.putBoolean("from_ai_creation_applet", true);
        return;
    }

    public final void a4(Bundle r3) {
        UserCreation r0 = cy9.e.a;
        ny9.s r1 = z3();
        if (r1 == null) goto L5;
        Bundle r2 = r1.a;
    L6:
        Intrinsics.checkNotNullParameter(r3, "target");
        UserCreation r4 = cy9.e.b(r2);
        if (r4 != null) goto L9;
        boolean r5 = false;
    L10:
        if (r5 == false) goto L13;
        r3.putString("feed_landing_tab", "0");
        return;
    L13:
        return;
    L9:
        Intrinsics.checkNotNullParameter(r3, "bundle");
        Intrinsics.checkNotNullParameter(r4, "userCreation");
        r3.putParcelable("ai_creation_applet_pending_user_creation", r4);
        r5 = true;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final void d4(String r13) {
        if (this.q > 0) goto L5;
        return;
    L5:
        long r0 = SystemClock.elapsedRealtime() - this.q;
        this.q = 0;
        ny9.s r2 = z3();
        if (r2 == null) goto L11;
        Bundle r3 = r2.a;
        if (r3 == null) goto L11;
        String r4 = r3.getString("enter_method");
        if (r4 == null) goto L11;
    L12:
        String r5 = r4;
        ny9.s r6 = z3();
        if (r6 == null) goto L15;
        Integer r7 = r6.l();
    L16:
        if (r7 != null) goto L19;
    L20:
        if (r7 != null) goto L23;
    L25:
        if (r7 != null) goto L28;
    L30:
        if (r7 != null) goto L33;
    L35:
        if (r7 != null) goto L38;
    L40:
        String r8 = "";
    L42:
        String r9 = r8;
        TabItemInfo r10 = this.r;
        if (r10 == null) goto L45;
        String r11 = r10.getName();
    L46:
        TabItemInfo r12 = this.r;
        if (r12 == null) goto L49;
        String r14 = r12.getId();
    L50:
        x2.e(r5, r13, "action_bar_template", r9, r11, r14, "template_page", this.F, Long.valueOf(r0));
        return;
    L49:
        r14 = null;
        goto L50
    L45:
        r11 = null;
        goto L46
    L38:
        if (r7.intValue() != 28) goto L40;
        r8 = "7";
        goto L42
    L33:
        if (r7.intValue() != 18) goto L35;
        r8 = "5";
        goto L42
    L28:
        if (r7.intValue() != 11) goto L30;
        r8 = "3";
        goto L42
    L23:
        if (r7.intValue() != 16) goto L25;
    L41:
        r8 = "2";
        goto L42
    L19:
        if (r7.intValue() == 4) goto L41;
    L15:
        r7 = null;
    L11:
        r4 = "chat_action_bar";
        goto L12
    }

    public final void onViewCreated(View r83) {
        Intrinsics.checkNotNullParameter(r83, "view");
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r2 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r2 == null) goto L13;
        Window r3 = r2.getWindow();
        if (r3 == null) goto L13;
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r5 = ThreadMethodProxy.currentThread();
        if (r5 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r5, "getDecorView");
    L11:
        if (r4 == null) goto L13;
        r4.setBackgroundColor(ContextCompat.getColor(getContext(), v19.c.b(2130970529, getContext(), 2131102529)));
    L13:
        ny9.s r6 = z3();
        if (r6 == null) goto L16;
        Integer r7 = r6.l();
    L18:
        if (r7 != null) goto L21;
    L22:
        if (r7 != null) goto L25;
    L26:
        if (r7 != null) goto L29;
    L30:
        if (r7 != null) goto L33;
    L35:
        if (r7 != null) goto L38;
    L70:
        if (this.F != null) goto L72;
        V3();
    L72:
        ny9.s r8 = z3();
        if (r8 == null) goto L75;
        Integer r9 = r8.l();
    L76:
        String r25 = "chat_action_bar";
        if (r9 != null) goto L79;
        String r26 = "enter_method";
        Object r27 = "action_bar_template_id";
    L81:
        if (r9 != null) goto L84;
    L86:
        if (r9 != null) goto L89;
    L158:
        String r31 = r26;
        Object r12 = r27;
        if (r9 != null) goto L162;
        Object r14 = "enter_from";
        Object r0 = r12;
        Object r13 = "arg_chat_type";
    L237:
        if (r9 != null) goto L239;
        String r32 = r31;
    L327:
        String r10 = null;
        TemplateFeedComponent r11 = this;
        String r15 = r32;
    L386:
        ny9.s r1 = z3();
        if (r1 == null) goto L394;
        Bundle r16 = r1.a;
        if (r16 == null) goto L394;
        String r17 = r16.getString(r15);
        if (r17 == null) goto L394;
        String r34 = r17;
    L395:
        String r18 = r11.F;
        ny9.s r19 = z3();
        if (r19 == null) goto L402;
        com.larus.bmhome.actionbar.model.r r20 = r19.k();
        if (r20 == null) goto L402;
        Integer r21 = r20.a;
        if (r21 == null) goto L402;
        String r61 = r21.toString();
    L403:
        ny9.s r22 = z3();
        if (r22 == null) goto L408;
        com.larus.bmhome.actionbar.model.r r23 = r22.k();
        if (r23 == null) goto L408;
        String r62 = r23.g;
    L409:
        a1.c(null, null, null, null, null, "template_page", null, null, r34, null, null, null, null, null, null, null, "chat", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r61, r62, r18, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1049729, -212993, 7);
        ys8.a r24 = C3();
        if (r24 == null) goto L412;
        r24.setEnableResetTemplateCacheAfterDetach(false);
    L412:
        AppHost.a.a().j(r11.s);
        return;
    L408:
        r62 = r10;
    L402:
        r61 = r10;
    L394:
        r34 = r25;
        goto L395
    L239:
        r26 = r31;
        Object r28 = r14;
        if (r9.intValue() != 28) goto L313;
        int r29 = r9.intValue();
        ny9.s r110 = z3();
        if (r110 == null) goto L244;
        ChatParam r111 = r110.c();
    L245:
        ny9.s r112 = z3();
        if (r112 == null) goto L248;
        String r113 = r112.v();
    L249:
        String r210 = r113;
        Object r211 = r0;
        IFlowSdkDepend r30 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r30 == null) goto L252;
        r30.w();
        Fragment r33 = k1.a.m(new t(this, r29, r111), Boolean.valueOf(i4()));
    L253:
        if (r33 != null) goto L255;
        String r114 = r25;
        String r35 = r26;
    L311:
        r32 = r35;
        r25 = r114;
        goto L327
    L255:
        z2 r115 = z2.a;
        boolean r116 = r115.f1().j();
        final Fragment r36 = r33;
        Pair[] r37 = new Pair[22];
        if (r111 == null) goto L258;
        String r38 = r111.b;
    L259:
        if (r38 != null) goto L261;
        r38 = "";
    L261:
        r37[0] = TuplesKt.to("argBotId", r38);
        r37[1] = TuplesKt.to("key_current_page_name", "template_page");
        r37[2] = TuplesKt.to("key_is_multi_tab", Boolean.valueOf(r116));
        ny9.s r39 = z3();
        if (r39 == null) goto L264;
        String r40 = r39.w();
    L265:
        r37[3] = TuplesKt.to("key_multi_tab_title_name", r40);
        r37[4] = TuplesKt.to("key_show_user_info", Boolean.valueOf(r115.R2()));
        ny9.s r41 = z3();
        if (r41 == null) goto L268;
        String r42 = r41.h();
    L269:
        r37[5] = TuplesKt.to("feed_landing_tab", r42);
        r37[6] = TuplesKt.to("key_creation_recommend_type", 7);
        r37[7] = TuplesKt.to("key_creation_use_cache", Boolean.TRUE);
        r37[8] = TuplesKt.to("recommend_from", "action_bar_template");
        if (r111 == null) goto L272;
        String r43 = r111.e;
    L273:
        if (r43 != null) goto L275;
        r43 = "";
    L275:
        r37[9] = TuplesKt.to(r13, r43);
        r37[10] = TuplesKt.to(r211, Integer.valueOf(r29));
        r37[11] = TuplesKt.to(r28, "template_detail");
        if (r111 == null) goto L278;
        String r44 = r111.a;
    L279:
        if (r44 != null) goto L281;
        r44 = "";
    L281:
        r37[12] = TuplesKt.to("argConversationId", r44);
        r37[13] = TuplesKt.to("key_creation_scene", r210);
        r37[14] = TuplesKt.to("previous_page", "chat");
        r114 = r25;
        r35 = r26;
        r37[15] = TuplesKt.to(r35, r114);
        ny9.s r45 = z3();
        if (r45 == null) goto L287;
        Bundle r46 = r45.a;
        if (r46 == null) goto L287;
        String r47 = r46.getString(r35);
        if (r47 == null) goto L287;
    L288:
        r37[16] = TuplesKt.to(r35, r47);
        r37[17] = TuplesKt.to("recommend_from", "action_bar_template");
        ny9.s r48 = z3();
        if (r48 == null) goto L293;
        Bundle r49 = r48.a;
        if (r49 == null) goto L293;
        String r50 = "open_new_chat_page_on_send";
        boolean r51 = r49.getBoolean(r50);
    L294:
        r37[18] = TuplesKt.to(r50, Boolean.valueOf(r51));
        r37[19] = TuplesKt.to("template_page_type", this.F);
        ny9.s r52 = z3();
        if (r52 == null) goto L297;
        String r53 = r52.t();
    L298:
        r37[20] = TuplesKt.to("related_recommendation", r53);
        ny9.s r54 = z3();
        if (r54 == null) goto L301;
        String r55 = r54.s();
    L302:
        r37[21] = TuplesKt.to("related_creation_id", r55);
        Bundle r56 = BundleKt.bundleOf(r37);
        Z3(r56);
        a4(r56);
        X3(r56);
        r36.setArguments(r56);
        View r57 = F2().findViewById(2131388328);
        ConstraintLayout.LayoutParams r58 = new ConstraintLayout.LayoutParams(-1, 0);
        H3().a(r58, 2131388347);
        r58.bottomToTop = 2131365537;
        r57.setLayoutParams(r58);
        View r59 = F2().findViewById(2131388772);
        ConstraintLayout.LayoutParams r60 = new ConstraintLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(v19.c.b(2130971490, getContext(), 2131167350)));
        r60.topToBottom = 2131388347;
        r59.setLayoutParams(r60);
        this.n = h4();
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r63 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r63 == null) goto L307;
        FragmentManager r64 = r63.getSupportFragmentManager();
        if (r64 == null) goto L307;
        FragmentTransaction r65 = r64.beginTransaction();
        Y2(r65, r36);
        r65.commitAllowingStateLoss();
    L307:
        if (r116 == true) goto L311;
        View r66 = F2().findViewById(2131388772);
        if (r66 == null) goto L311;
        e1.d(r66, new g(r36));
        goto L311
    L301:
        r55 = null;
        goto L302
    L297:
        r53 = null;
    L293:
        r50 = r15;
        r51 = false;
    L287:
        r47 = r114;
        goto L288
    L278:
        r44 = null;
        goto L279
    L272:
        r43 = null;
        goto L273
    L268:
        r42 = null;
        goto L269
    L264:
        r40 = null;
        goto L265
    L258:
        r38 = null;
        goto L259
    L252:
        r33 = null;
        goto L253
    L248:
        r113 = null;
        goto L249
    L244:
        r111 = null;
    L313:
        r32 = r26;
        goto L327
    L162:
        if (r9.intValue() != 18) goto L236;
        int r67 = r9.intValue();
        ny9.s r68 = z3();
        if (r68 == null) goto L166;
        ChatParam r69 = r68.c();
    L167:
        ny9.s r117 = z3();
        if (r117 == null) goto L170;
        String r118 = r117.v();
    L171:
        String r212 = r118;
        IFlowSdkDepend r119 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r119 == null) goto L174;
        r119.w();
        Fragment r120 = k1.a.m(new u(this, r67), Boolean.valueOf(i4()));
    L175:
        if (r120 != null) goto L177;
        r32 = r31;
        goto L327
    L177:
        z2 r121 = z2.a;
        boolean r122 = r121.f1().j();
        final Fragment r213 = r120;
        Pair[] r123 = new Pair[21];
        if (r69 == null) goto L180;
        String r70 = r69.b;
    L181:
        if (r70 != null) goto L183;
        r70 = "";
    L183:
        r123[0] = TuplesKt.to("argBotId", r70);
        r123[1] = TuplesKt.to("key_current_page_name", "template_page");
        r123[2] = TuplesKt.to("key_is_multi_tab", Boolean.valueOf(r122));
        ny9.s r71 = z3();
        if (r71 == null) goto L186;
        String r72 = r71.w();
    L187:
        r123[3] = TuplesKt.to("key_multi_tab_title_name", r72);
        ny9.s r73 = z3();
        if (r73 == null) goto L192;
        Bundle r74 = r73.a;
        if (r74 == null) goto L192;
        boolean r75 = r74.getBoolean("open_new_chat_page_on_send");
    L193:
        r123[4] = TuplesKt.to("open_new_chat_page_on_send", Boolean.valueOf(r75));
        r123[5] = TuplesKt.to("key_show_user_info", Boolean.valueOf(r121.R2()));
        ny9.s r76 = z3();
        if (r76 == null) goto L196;
        String r77 = r76.h();
    L197:
        r123[6] = TuplesKt.to("feed_landing_tab", r77);
        r123[7] = TuplesKt.to("key_creation_recommend_type", 5);
        r123[8] = TuplesKt.to("key_creation_use_cache", Boolean.TRUE);
        r123[9] = TuplesKt.to("recommend_from", "action_bar_template");
        if (r69 == null) goto L200;
        String r78 = r69.e;
    L201:
        if (r78 != null) goto L203;
        r78 = "";
    L203:
        r123[10] = TuplesKt.to("arg_chat_type", r78);
        r123[11] = TuplesKt.to(r12, Integer.valueOf(r67));
        r123[12] = TuplesKt.to("enter_from", "template_detail");
        if (r69 == null) goto L206;
        String r79 = r69.a;
    L207:
        if (r79 != null) goto L209;
        r79 = "";
    L209:
        r123[13] = TuplesKt.to("argConversationId", r79);
        r123[14] = TuplesKt.to("key_creation_scene", r212);
        r123[15] = TuplesKt.to("previous_page", "chat");
        ny9.s r80 = z3();
        if (r80 == null) goto L216;
        Bundle r81 = r80.a;
        if (r81 == null) goto L216;
        String r82 = r31;
        String r84 = r81.getString(r82);
        if (r84 == null) goto L217;
    L218:
        r123[16] = TuplesKt.to(r82, r84);
        r123[17] = TuplesKt.to("recommend_from", "action_bar_template");
        ny9.s r85 = z3();
        if (r85 == null) goto L221;
        String r86 = r85.t();
    L222:
        r123[18] = TuplesKt.to("related_recommendation", r86);
        ny9.s r87 = z3();
        if (r87 == null) goto L225;
        String r88 = r87.s();
    L226:
        r123[19] = TuplesKt.to("related_creation_id", r88);
        r123[20] = TuplesKt.to("template_page_type", this.F);
        Bundle r89 = BundleKt.bundleOf(r123);
        Z3(r89);
        a4(r89);
        X3(r89);
        r213.setArguments(r89);
        View r90 = F2().findViewById(2131388328);
        ConstraintLayout.LayoutParams r91 = new ConstraintLayout.LayoutParams(-1, 0);
        H3().a(r91, 2131388347);
        r91.bottomToTop = 2131365537;
        r90.setLayoutParams(r91);
        this.n = h4();
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r92 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r92 == null) goto L231;
        FragmentManager r93 = r92.getSupportFragmentManager();
        if (r93 == null) goto L231;
        FragmentTransaction r94 = r93.beginTransaction();
        Y2(r94, r213);
        r94.commitAllowingStateLoss();
    L231:
        if (r122 == true) goto L235;
        View r95 = F2().findViewById(2131388772);
        if (r95 == null) goto L235;
        e1.d(r95, new f(r213));
    L235:
        r32 = r82;
        goto L327
    L225:
        r88 = null;
        goto L226
    L221:
        r86 = null;
    L217:
        r84 = r25;
    L216:
        r82 = r31;
        goto L217
    L206:
        r79 = null;
        goto L207
    L200:
        r78 = null;
        goto L201
    L196:
        r77 = null;
    L192:
        r75 = false;
        goto L193
    L186:
        r72 = null;
        goto L187
    L180:
        r70 = null;
        goto L181
    L174:
        r120 = null;
        goto L175
    L170:
        r118 = null;
        goto L171
    L166:
        r69 = null;
        goto L167
    L236:
        r13 = "arg_chat_type";
        r14 = "enter_from";
        r0 = r12;
        goto L237
    L89:
        if (r9.intValue() != 11) goto L158;
        int r96 = r9.intValue();
        ny9.s r124 = z3();
        if (r124 == null) goto L93;
        ChatParam r125 = r124.c();
    L94:
        ny9.s r126 = z3();
        if (r126 == null) goto L97;
        String r127 = r126.v();
    L98:
        String r214 = r127;
        IFlowSdkDepend r128 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r128 == null) goto L101;
        r128.w();
        final Fragment r97 = k1.a.m(new r(this, r96, r125), Boolean.valueOf(i4()));
    L102:
        if (r97 == null) goto L313;
        Pair[] r129 = new Pair[20];
        if (r125 == null) goto L107;
        String r130 = r125.b;
    L108:
        if (r130 != null) goto L110;
        r130 = "";
    L110:
        r129[0] = TuplesKt.to("argBotId", r130);
        r129[1] = TuplesKt.to("key_current_page_name", "template_page");
        r129[2] = TuplesKt.to("key_is_multi_tab", Boolean.FALSE);
        ny9.s r98 = z3();
        if (r98 == null) goto L113;
        String r99 = r98.w();
    L114:
        r129[3] = TuplesKt.to("key_multi_tab_title_name", r99);
        ny9.s r100 = z3();
        if (r100 == null) goto L119;
        Bundle r101 = r100.a;
        if (r101 == null) goto L119;
        boolean r102 = r101.getBoolean("open_new_chat_page_on_send");
    L120:
        r129[4] = TuplesKt.to("open_new_chat_page_on_send", Boolean.valueOf(r102));
        r129[5] = TuplesKt.to("key_creation_recommend_type", 3);
        r129[6] = TuplesKt.to("key_creation_use_cache", Boolean.TRUE);
        r129[7] = TuplesKt.to("key_show_user_info", Boolean.valueOf(z2.a.H()));
        r129[8] = TuplesKt.to("recommend_from", "action_bar_template");
        if (r125 == null) goto L123;
        String r103 = r125.e;
    L124:
        if (r103 != null) goto L126;
        r103 = "";
    L126:
        r129[9] = TuplesKt.to("arg_chat_type", r103);
        Integer r104 = Integer.valueOf(r96);
        r129[10] = TuplesKt.to(r27, r104);
        r129[11] = TuplesKt.to("enter_from", "template_detail");
        if (r125 == null) goto L129;
        String r105 = r125.a;
    L130:
        if (r105 != null) goto L132;
        r105 = "";
    L132:
        r129[12] = TuplesKt.to("argConversationId", r105);
        r129[13] = TuplesKt.to("key_creation_scene", r214);
        r129[14] = TuplesKt.to("key_template_list_bottom_padding", Integer.valueOf(i5.s0()));
        r129[15] = TuplesKt.to("key_is_chat_double_page", Boolean.valueOf(IAIChatUgcAIGCService.a.s0(s1a.a.getActivity(this))));
        ny9.s r106 = z3();
        if (r106 == null) goto L135;
        String r107 = r106.t();
    L136:
        r129[16] = TuplesKt.to("related_recommendation", r107);
        r129[17] = TuplesKt.to("template_page_type", this.F);
        ny9.s r108 = z3();
        if (r108 == null) goto L143;
        Bundle r109 = r108.a;
        if (r109 == null) goto L143;
        String r131 = r26;
        String r132 = r109.getString(r131);
        if (r132 == null) goto L144;
    L145:
        r129[18] = TuplesKt.to(r131, r132);
        ny9.s r133 = z3();
        if (r133 == null) goto L148;
        String r134 = r133.s();
    L149:
        r129[19] = TuplesKt.to("related_creation_id", r134);
        Bundle r135 = BundleKt.bundleOf(r129);
        Z3(r135);
        a4(r135);
        X3(r135);
        r97.setArguments(r135);
        View r136 = F2().findViewById(2131388328);
        ConstraintLayout.LayoutParams r137 = new ConstraintLayout.LayoutParams(-1, 0);
        H3().a(r137, 2131388347);
        r137.bottomToTop = 2131365537;
        r136.setLayoutParams(r137);
        this.n = h4();
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r138 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r138 == null) goto L154;
        FragmentManager r139 = r138.getSupportFragmentManager();
        if (r139 == null) goto L154;
        FragmentTransaction r140 = r139.beginTransaction();
        Y2(r140, r97);
        r140.commitAllowingStateLoss();
    L154:
        View r141 = F2().findViewById(2131388772);
        if (r141 == null) goto L157;
        e1.d(r141, new d(r97));
    L157:
        r32 = r131;
        goto L327
    L148:
        r134 = null;
    L144:
        r132 = r25;
    L143:
        r131 = r26;
        goto L144
    L135:
        r107 = null;
        goto L136
    L129:
        r105 = null;
        goto L130
    L123:
        r103 = null;
    L119:
        r102 = false;
        goto L120
    L113:
        r99 = null;
        goto L114
    L107:
        r130 = null;
        goto L108
    L101:
        r97 = null;
        goto L102
    L97:
        r127 = null;
        goto L98
    L93:
        r125 = null;
        goto L94
    L84:
        if (r9.intValue() != 16) goto L86;
    L314:
        r32 = r26;
        Object r142 = r27;
        int r143 = r9.intValue();
        ny9.s r215 = z3();
        if (r215 == null) goto L317;
        ChatParam r144 = r215.c();
    L318:
        ny9.s r216 = z3();
        if (r216 == null) goto L321;
        String r310 = r216.v();
    L322:
        IFlowSdkDepend r145 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r145 == null) goto L325;
        r145.w();
        Fragment r146 = k1.a.m(new s(this, r143), Boolean.valueOf(i4()));
    L326:
        if (r146 == null) goto L327;
        z2 r147 = z2.a;
        boolean r148 = r147.f1().j();
        final Fragment r217 = r146;
        Pair[] r149 = new Pair[21];
        if (r144 == null) goto L331;
        String r150 = r144.b;
    L332:
        if (r150 != null) goto L334;
        r150 = "";
    L334:
        r149[0] = TuplesKt.to("argBotId", r150);
        r149[1] = TuplesKt.to("key_current_page_name", "template_page");
        r149[2] = TuplesKt.to("key_is_multi_tab", Boolean.valueOf(r148));
        ny9.s r151 = z3();
        if (r151 == null) goto L337;
        String r152 = r151.w();
    L338:
        r149[3] = TuplesKt.to("key_multi_tab_title_name", r152);
        r149[4] = TuplesKt.to("key_show_user_info", Boolean.valueOf(r147.R2()));
        ny9.s r153 = z3();
        if (r153 == null) goto L341;
        String r154 = r153.h();
    L342:
        r149[5] = TuplesKt.to("feed_landing_tab", r154);
        r149[6] = TuplesKt.to("key_creation_recommend_type", 2);
        r149[7] = TuplesKt.to("key_creation_use_cache", Boolean.TRUE);
        r149[8] = TuplesKt.to("recommend_from", "action_bar_template");
        if (r144 == null) goto L345;
        String r155 = r144.e;
    L346:
        if (r155 != null) goto L348;
        r155 = "";
    L348:
        r149[9] = TuplesKt.to("arg_chat_type", r155);
        r149[10] = TuplesKt.to(r142, Integer.valueOf(r143));
        ny9.s r156 = z3();
        if (r156 == null) goto L353;
        Bundle r157 = r156.a;
        if (r157 == null) goto L353;
        String r158 = "open_new_chat_page_on_send";
        boolean r159 = r157.getBoolean(r158);
    L354:
        r149[11] = TuplesKt.to(r158, Boolean.valueOf(r159));
        r149[12] = TuplesKt.to("enter_from", "template_detail");
        if (r144 == null) goto L357;
        String r160 = r144.a;
    L358:
        if (r160 != null) goto L360;
        r160 = "";
    L360:
        r149[13] = TuplesKt.to("argConversationId", r160);
        r149[14] = TuplesKt.to("key_creation_scene", r310);
        r149[15] = TuplesKt.to("previous_page", "chat");
        ny9.s r161 = z3();
        if (r161 == null) goto L367;
        Bundle r162 = r161.a;
        if (r162 == null) goto L367;
        r15 = r32;
        String r163 = r162.getString(r15);
        if (r163 == null) goto L368;
    L369:
        r149[16] = TuplesKt.to(r15, r163);
        r149[17] = TuplesKt.to("recommend_from", "action_bar_template");
        r11 = this;
        r149[18] = TuplesKt.to("template_page_type", r11.F);
        ny9.s r164 = z3();
        if (r164 == null) goto L372;
        String r165 = r164.t();
    L373:
        r149[19] = TuplesKt.to("related_recommendation", r165);
        ny9.s r166 = z3();
        if (r166 == null) goto L376;
        String r167 = r166.s();
    L377:
        r149[20] = TuplesKt.to("related_creation_id", r167);
        Bundle r168 = BundleKt.bundleOf(r149);
        r11.Z3(r168);
        r11.a4(r168);
        r11.X3(r168);
        r217.setArguments(r168);
        View r169 = F2().findViewById(2131388328);
        ConstraintLayout.LayoutParams r170 = new ConstraintLayout.LayoutParams(-1, 0);
        r10 = null;
        H3().a(r170, null);
        r170.bottomToTop = 2131365537;
        r169.setLayoutParams(r170);
        r11.n = h4();
        Intrinsics.checkNotNullParameter(r11, "<this>");
        FragmentActivity r171 = com.larus.ui.arch.component.internal.attach.a.b(r11, r11).getActivity();
        if (r171 == null) goto L382;
        FragmentManager r172 = r171.getSupportFragmentManager();
        if (r172 == null) goto L382;
        FragmentTransaction r173 = r172.beginTransaction();
        Y2(r173, r217);
        r173.commitAllowingStateLoss();
    L382:
        if (r148 == true) goto L386;
        View r174 = F2().findViewById(2131388772);
        if (r174 == null) goto L386;
        e1.d(r174, new e(r217));
        goto L386
    L376:
        r167 = null;
        goto L377
    L372:
        r165 = null;
    L368:
        r163 = r25;
    L367:
        r15 = r32;
        goto L368
    L357:
        r160 = null;
    L353:
        r158 = "open_new_chat_page_on_send";
        r159 = false;
        goto L354
    L345:
        r155 = null;
        goto L346
    L341:
        r154 = null;
        goto L342
    L337:
        r152 = null;
        goto L338
    L331:
        r150 = null;
        goto L332
    L325:
        r146 = null;
        goto L326
    L321:
        r310 = null;
        goto L322
    L317:
        r144 = null;
        goto L318
    L79:
        r26 = "enter_method";
        r27 = "action_bar_template_id";
        if (r9.intValue() == 4) goto L314;
    L75:
        r9 = null;
        goto L76
    L38:
        if (r7.intValue() != 11) goto L70;
        this.t.setValue(Boolean.TRUE);
        goto L70
    L33:
        if (r7.intValue() != 28) goto L35;
    L40:
        StateFlowImpl r175 = this.t;
        ny9.s r176 = z3();
        if (r176 == null) goto L43;
        String r177 = r176.o();
    L45:
        if (o0.d(r177) == true) goto L65;
        ny9.s r178 = z3();
        if (r178 == null) goto L49;
        String r179 = r178.p();
    L51:
        if (o0.d(r179) == true) goto L65;
        ny9.s r180 = z3();
        if (r180 == null) goto L55;
        Image r181 = r180.r();
    L56:
        if (r181 != null) goto L65;
        ny9.s r182 = z3();
        if (r182 != null) goto L60;
    L62:
        boolean r183 = false;
    L63:
        if (r183 == true) goto L65;
        boolean r184 = true;
    L66:
        r175.setValue(Boolean.valueOf(r184));
        py9.a r185 = (py9.a) this.v.getValue();
        if (r185 == null) goto L70;
        r185.Tf(new q(this));
        goto L70
    L60:
        if (r182.D() != true) goto L62;
        r183 = true;
        goto L63
    L55:
        r181 = null;
        goto L56
    L49:
        r179 = null;
    L65:
        r184 = false;
        goto L66
    L43:
        r177 = null;
        goto L45
    L29:
        if (r7.intValue() == 18) goto L40;
    L25:
        if (r7.intValue() == 16) goto L40;
    L21:
        if (r7.intValue() == 4) goto L40;
    L16:
        r7 = null;
        goto L18
    }

    public static String D3(UserCreation r1, @DoSameQuickMenuType String r2) {
        if (Intrinsics.areEqual(r2, DoSameQuickMenuType.REPLACE_PIC) == false) goto L12;
        CreationDynamicInfo r3 = r1.h;
        if (r3 == null) goto L13;
        TplInfo r4 = r3.e;
        if (r4 == null) goto L13;
        TplDetail r5 = r4.c;
        if (r5 == null) goto L13;
        return r5.i;
    L13:
        return null;
    L12:
        if (Intrinsics.areEqual(r2, DoSameQuickMenuType.USE_PICTURE) == true) goto L13;
        return r1.k();
    }

    public static void Y2(FragmentTransaction r3, Fragment r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r3, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131388328) == false) goto L5;
        return;
    L5:
        r3.replace(2131388328, r4);
    }

    public final void e4(UserCreation r14, @DoSameQuickMenuType String r15) {
        if (r14 == null) goto L50;
        ny9.s r0 = z3();
        String r8 = null;
        if (r0 == null) goto L29;
        Bundle r1 = r0.a;
        if (r1 == null) goto L29;
        ny9.s r9 = z3();
        if (r9 == null) goto L11;
        ICoreInputAbility.SendMessageTrackExtMap r10 = r9.n();
        if (r10 == null) goto L11;
    L12:
        Map r11 = MapsKt.toMutableMap(r10.a);
        Pair[] r12 = new Pair[13];
        r12[0] = TuplesKt.to("from_template_id", r14.a);
        r12[1] = TuplesKt.to("from_template_type", zp9.d.d(r14));
        UserCreationTrackParams r13 = r14.n;
        if (r13 == null) goto L15;
        String r16 = r13.a;
    L16:
        r12[2] = TuplesKt.to("template_rec_req_id", r16);
        r12[3] = TuplesKt.to("from_template_source", zp9.d.b(r14));
        UserCreationTrackParams r17 = r14.n;
        if (r17 == null) goto L19;
        String r18 = r17.d;
    L20:
        r12[4] = TuplesKt.to("ai_generate_tab_id", r18);
        UserCreationTrackParams r19 = r14.n;
        if (r19 == null) goto L23;
        String r110 = r19.e;
    L24:
        r12[5] = TuplesKt.to("ai_generate_tab_name", r110);
        UserCreationTrackParams r111 = r14.n;
        if (r111 == null) goto L27;
        String r112 = r111.f;
    L28:
        r12[6] = TuplesKt.to("ai_generate_tab_type", r112);
        r12[7] = TuplesKt.to("recommend_from", "action_bar_template");
        r12[8] = TuplesKt.to("ai_creation_recommend_from", "action_bar_template");
        r12[9] = TuplesKt.to("template_rec_extra", r14.i);
        r12[10] = TuplesKt.to("from_template_sub_type", zp9.d.c(r14));
        r12[11] = TuplesKt.to("is_has_caption", String.valueOf(Boolean.valueOf(r14.z())));
        r12[12] = TuplesKt.to("is_image_reference_public", String.valueOf(Boolean.valueOf(r14.D())));
        r11.putAll(MapsKt.mapOf(r12));
        Intrinsics.checkNotNullParameter(r11, "extMap");
        r1.putParcelable("actionbar_instruction_send_message_track_ext_map", new ICoreInputAbility.SendMessageTrackExtMap(r11));
        goto L29
    L27:
        r112 = null;
        goto L28
    L23:
        r110 = null;
        goto L24
    L19:
        r18 = null;
        goto L20
    L15:
        r16 = null;
    L11:
        r10 = new ICoreInputAbility.SendMessageTrackExtMap(0);
    L29:
        ny9.s r2 = z3();
        if (r2 == null) goto L51;
        Bundle r3 = r2.a;
        if (r3 == null) goto L52;
        ny9.s r20 = z3();
        if (r20 == null) goto L37;
        ICoreInputAbility.MessageExtMap r21 = r20.m();
        if (r21 == null) goto L37;
    L38:
        Map r22 = MapsKt.toMutableMap(r21.a);
        JSONObject r113 = new JSONObject();
        String r114 = r14.a;
        if (r114 != null) goto L41;
        r114 = "";
    L41:
        r113.put("id", r114);
        r113.put("recommend_from", "action_bar_template");
        UserCreationTrackParams r4 = r14.n;
        if (r4 == null) goto L44;
        String r5 = r4.a;
    L45:
        r113.put("template_rec_req_id", r5);
        r113.put("template_rec_extra", r14.i);
        r113.put("from_template_id", r14.a);
        boolean r6 = ICreationAvatarService.a.v();
        r113.put("tpl_tag_type", r14.q(r6));
        if (r15 == null) goto L48;
        r8 = sq9.q.a(r15, r14, r6, false);
    L48:
        r113.put("tpl_button_type", r8);
        Unit r115 = Unit.INSTANCE;
        r22.put("creation_template", r113.toString());
        Intrinsics.checkNotNullParameter(r22, "extMap");
        r3.putParcelable("actionbar_instruction_message_ext_map", new ICoreInputAbility.MessageExtMap(r22));
        return;
    L44:
        r5 = null;
    L37:
        r21 = new ICoreInputAbility.MessageExtMap(MapsKt.emptyMap());
        goto L38
    L52:
        return;
    L51:
        return;
    }

    public static final boolean h3(TemplateFeedComponent r31, UserCreation r32, int r33, boolean r34, boolean r35) {
        ny9.s r1 = r31.z3();
        Boolean r2 = null;
        if (r1 == null) goto L5;
        Bundle r3 = r1.a;
    L6:
        int r4 = CreationHostUiPolicy.f;
        if (CreationHostUiPolicy.a.a(r3).a == false) goto L51;
        ny9.s r5 = r31.z3();
        if (r5 == null) goto L12;
        ChatParam r6 = r5.c();
    L13:
        AuthorInfo r7 = r32.g;
        if (r7 == null) goto L16;
        String r8 = r7.b;
    L17:
        boolean r9 = !Intrinsics.areEqual(r8, AccountService.a.getUserId());
        if (r6 == null) goto L20;
        String r10 = r6.b;
    L22:
        if (r10 != null) goto L24;
        String r11 = "";
    L25:
        if (r6 == null) goto L27;
        String r12 = r6.a;
    L28:
        if (r12 != null) goto L30;
        String r13 = "";
    L31:
        Integer r14 = Integer.valueOf(r33);
        if (r6 == null) goto L34;
        String r15 = r6.e;
    L35:
        if (r15 != null) goto L38;
        r15 = "";
    L38:
        if (r3 == null) goto L41;
        String r16 = r3.getString("enter_method");
        if (r16 == null) goto L41;
    L42:
        String r17 = r16;
        if (r3 == null) goto L45;
        r2 = Boolean.valueOf(r3.getBoolean("key_is_chat_double_page", false));
    L45:
        zp9.g r18 = new zp9.g("template_page", "action_bar_template", r11, r13, r14, r15, "template_detail", "chat", r17, "action_bar_template", r2, null, r31.F, null, null, null, null, null, null, null, null, null, 4188160);
        Bundle r19 = new Bundle();
        r19.putString("creation", GsonProtectorUtils.toJson(new Gson(), r32));
        r19.putString("track_params", GsonProtectorUtils.toJson(new Gson(), r18));
        r19.putBoolean("is_show_profile", r9);
        r19.putBoolean("show_usage_count", r34);
        r19.putBoolean("can_show_inspiration_list", r9);
        r19.putBoolean("ignore_tpl_info", r35);
        if (r3 == null) goto L48;
        boolean r20 = r3.getBoolean("open_new_chat_page_on_send");
    L49:
        r19.putBoolean("open_new_chat_page_on_send", r20);
        r19.putInt("creation_dosame_landing_type", z2.a.getCreationDosameLandingType());
        r19.putBoolean("is_send_from_detail", true);
        int r0 = com.larus.uaigc.applet.a.a;
        Context r21 = r31.getContext();
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r19, "payload");
        return IAICreationAppletHostService.a.r(r21, r19, false);
    L48:
        r20 = false;
    L41:
        r16 = "chat_action_bar";
        goto L42
    L34:
        r15 = null;
        goto L35
    L30:
        r13 = r12;
        goto L31
    L27:
        r12 = null;
        goto L28
    L24:
        r11 = r10;
        goto L25
    L20:
        r10 = null;
        goto L22
    L16:
        r8 = null;
        goto L17
    L12:
        r6 = null;
        goto L13
    L51:
        return false;
    L5:
        r3 = null;
        goto L6
    }

    public final void Q3(UserCreation r59, int r60, String r61, String r62, Uri r63) {
        ny9.s r1 = z3();
        Integer r10 = null;
        if (r1 == null) goto L5;
        Integer r22 = r1.l();
    L6:
        ny9.s r2 = z3();
        if (r2 == null) goto L9;
        ChatParam r11 = r2.c();
    L11:
        if (r63 == null) goto L13;
    L22:
        ICoreInputAbility r3 = B3();
        if (r3 == null) goto L25;
        Integer r4 = Integer.valueOf(r3.Rp());
    L26:
        this.D = r4;
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r5 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r5 == null) goto L36;
        ImageTemplateChooseViewModel r14 = new ViewModelProvider(r5).get(ImageTemplateChooseViewModel.class);
        if (r11 == null) goto L31;
        String r6 = r11.a;
    L32:
        if (r6 != null) goto L34;
        String r7 = "";
    L35:
        r14.onImageTemplateChoose(new com.larus.bmhome.creative.utils.b(null, r7, true, r59, r63, false, 33));
        goto L36
    L34:
        r7 = r6;
        goto L35
    L31:
        r6 = null;
    L36:
        this.t.setValue(Boolean.FALSE);
        ny9.u r8 = E3();
        if (r8 == null) goto L39;
        r8.s(r59);
    L39:
        ny9.u r9 = E3();
        if (r9 == null) goto L47;
        if (r62 != null) goto L43;
        String r12 = "";
    L44:
        Intrinsics.checkNotNullParameter(r12, "aiRecommendFrom");
        Bundle r13 = r9.c;
        if (r13 == null) goto L47;
        r13.putString("ai_creation_recommend_from", r12);
        goto L47
    L43:
        r12 = r62;
    L47:
        e4(r59, null);
        if (r11 == null) goto L50;
        String r15 = r11.b;
    L51:
        if (r15 != null) goto L54;
        r15 = "";
    L54:
        if (r61 != null) goto L56;
        String r16 = null;
    L63:
        String r17 = String.valueOf(r59.a);
        if (r11 == null) goto L66;
        String r18 = r11.e;
    L67:
        if (r18 != null) goto L69;
        String r19 = "";
    L70:
        String r110 = zp9.d.c(r59);
        AuthorInfo r20 = r59.g;
        if (r20 == null) goto L73;
        String r111 = r20.b;
    L74:
        String r112 = zp9.d.b(r59);
        int r21 = r60 + 1;
        UserCreationTrackParams r23 = r59.n;
        if (r23 == null) goto L77;
        Integer r24 = r23.b;
    L78:
        if (r23 == null) goto L80;
        String r25 = r23.a;
    L81:
        if (r23 == null) goto L83;
        String r26 = r23.d;
    L84:
        if (r23 == null) goto L86;
        String r27 = r23.e;
    L87:
        if (r23 == null) goto L89;
        String r28 = r23.f;
    L90:
        String r29 = r59.i;
        String r32 = zp9.d.c(r59);
        boolean r30 = r59.z();
        boolean r31 = r59.D();
        UserCreationRefContent r33 = r59.o;
        if (r33 == null) goto L95;
        List<ImageInfo> r34 = r33.a();
        if (r34 == null) goto L95;
        r10 = Integer.valueOf(r34.size());
    L95:
        Integer r35 = r10;
        ny9.s r36 = z3();
        if (r36 == null) goto L101;
        Bundle r37 = r36.a;
        if (r37 == null) goto L101;
        String r38 = r37.getString("enter_method");
        if (r38 == null) goto L101;
    L102:
        String r39 = zp9.d.a(r59, false);
        String r113 = r15;
        String r114 = r16;
        u3.l(r113, r17, r114, r19, "pic", r110, r112, r111, Integer.valueOf(r21), r24, r25, r22, r26, r28, r27, "action_bar_template", "template_page", null, null, null, r29, r32, Boolean.valueOf(r31), r35, Boolean.valueOf(r30), r38, null, zp9.d.e(r59), r39, Boolean.valueOf(ICreationAvatarService.a.v()), null, null, null, null, null, 272105856, 31);
        String r40 = r59.a;
        if (r40 == null) goto L107;
        Long r41 = StringsKt.toLongOrNull(r40);
        if (r41 == null) goto L107;
        long r42 = r41.longValue();
    L108:
        com.larus.uaigc.template.p.a(r42);
        a1.c(null, null, null, null, null, "image_generate", null, null, "use_template", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1153, -1, 7);
        return;
    L107:
        r42 = 0;
    L101:
        r38 = "chat_action_bar";
        goto L102
    L89:
        r28 = null;
        goto L90
    L86:
        r27 = null;
        goto L87
    L83:
        r26 = null;
        goto L84
    L80:
        r25 = null;
        goto L81
    L77:
        r24 = null;
        goto L78
    L73:
        r111 = null;
        goto L74
    L69:
        r19 = r18;
        goto L70
    L66:
        r18 = null;
        goto L67
    L56:
        if (r61.length() != 0) goto L58;
        boolean r43 = true;
    L59:
        if (r43 == false) goto L61;
        r16 = "template_list";
        goto L63
    L61:
        r16 = r61;
        goto L63
    L58:
        r43 = false;
        goto L59
    L50:
        r15 = null;
        goto L51
    L25:
        r4 = null;
        goto L26
    L13:
        if (r59.b != 5) goto L22;
        if (z2.a.getCreationMakeSameConfig().a() == false) goto L22;
        if (r22 == null) goto L19;
        int r44 = r22.intValue();
    L20:
        this.G = new a(r44, r59, r60, r61, r62);
        c4();
        return;
    L19:
        r44 = 0;
        goto L20
    L9:
        r11 = null;
        goto L11
    L5:
        r22 = null;
        goto L6
    }

    public final boolean j4(int r75, UserCreation r76, int r77, String r78, String r79, Uri r80) {
        ny9.s r1 = z3();
        if (r1 == null) goto L5;
        ChatParam r13 = r1.c();
    L6:
        ny9.s r2 = z3();
        if (r2 == null) goto L10;
        r2.v();
    L10:
        if (r76.b() == false) goto L13;
        return false;
    L13:
        if (r80 != null) goto L24;
        int r3 = r76.b;
        if (r3 == 7) goto L21;
        if (r3 == 9) goto L21;
        if (r3 != 11) goto L24;
    L21:
        if (z2.a.getCreationMakeSameConfig().b() == false) goto L24;
        this.G = new a(r75, r76, r77, r78, r79);
        c4();
        return true;
    L24:
        this.G = null;
        ICoreInputAbility r4 = B3();
        if (r4 == null) goto L27;
        Integer r5 = Integer.valueOf(r4.Rp());
    L28:
        this.D = r5;
        ys8.a r11 = C3();
        long r17 = 0;
        if (r11 == null) goto L89;
        String r6 = r76.a;
        if (r6 == null) goto L35;
        Long r7 = StringsKt.toLongOrNull(r6);
        if (r7 == null) goto L35;
        long r8 = r7.longValue();
    L36:
        UserCreationContent r9 = r76.e;
        if (r9 == null) goto L41;
        VideoUserContent r10 = r9.e;
        if (r10 == null) goto L41;
        String r12 = r10.d;
    L42:
        if (r9 == null) goto L50;
        VideoUserContent r14 = r9.e;
        if (r14 == null) goto L50;
        ImageInfo r15 = r14.b;
        if (r15 == null) goto L50;
        com.larus.platform.api.Image r16 = r15.b;
        if (r16 == null) goto L50;
        TemplateInfo$TemplateImage r18 = io8.a.a(r16);
    L51:
        UserCreationContent r19 = r76.e;
        if (r19 == null) goto L60;
        VideoUserContent r20 = r19.e;
        if (r20 == null) goto L60;
        ImageInfo r21 = r20.b;
        if (r21 == null) goto L60;
        com.larus.platform.api.Image r22 = r21.a;
        if (r22 == null) goto L60;
        TemplateInfo$TemplateImage r23 = io8.a.a(r22);
    L61:
        UserCreationContent r24 = r76.e;
        if (r24 == null) goto L70;
        VideoUserContent r25 = r24.e;
        if (r25 == null) goto L70;
        ImageInfo r26 = r25.b;
        if (r26 == null) goto L70;
        com.larus.platform.api.Image r27 = r26.c;
        if (r27 == null) goto L70;
        TemplateInfo$TemplateImage r28 = io8.a.a(r27);
    L71:
        UserCreationContent r29 = r76.e;
        if (r29 == null) goto L80;
        VideoUserContent r30 = r29.e;
        if (r30 == null) goto L80;
        OptionItem r31 = r30.e;
        if (r31 == null) goto L80;
        Long r32 = r31.a;
        if (r32 == null) goto L80;
        long r33 = r32.longValue();
    L81:
        String r34 = r76.a;
        if (r34 == null) goto L86;
        Long r35 = StringsKt.toLongOrNull(r34);
        if (r35 == null) goto L86;
        long r110 = r35.longValue();
    L87:
        r11.Gk(new TemplateInfo$TemplateInfo(r8, r12, r18, r23, r28, r33, 0, r110, r76, 130), r80);
    L86:
        r110 = 0;
    L80:
        r33 = -1;
    L70:
        r28 = null;
    L60:
        r23 = null;
    L50:
        r18 = null;
    L41:
        r12 = null;
    L35:
        r8 = 0;
    L89:
        this.t.setValue(Boolean.FALSE);
        ny9.u r36 = E3();
        if (r36 == null) goto L92;
        r36.s(r76);
    L92:
        ny9.u r37 = E3();
        if (r37 == null) goto L100;
        if (r79 != null) goto L96;
        String r38 = "";
    L97:
        Intrinsics.checkNotNullParameter(r38, "aiRecommendFrom");
        Bundle r39 = r37.c;
        if (r39 == null) goto L100;
        r39.putString("ai_creation_recommend_from", r38);
        goto L100
    L96:
        r38 = r79;
    L100:
        e4(r76, null);
        ChatParam r111 = r13;
        if (r111 == null) goto L103;
        String r40 = r111.b;
    L104:
        if (r40 != null) goto L106;
        String r210 = "";
    L107:
        if (r78 != null) goto L109;
        String r211 = null;
    L117:
        String r212 = String.valueOf(r76.a);
        if (r111 == null) goto L120;
        String r112 = r111.e;
    L121:
        if (r112 != null) goto L123;
        String r213 = "";
    L124:
        String r310 = zp9.d.d(r76);
        String r311 = zp9.d.c(r76);
        AuthorInfo r41 = r76.g;
        if (r41 == null) goto L127;
        String r312 = r41.b;
    L128:
        String r313 = zp9.d.b(r76);
        int r42 = r77 + 1;
        UserCreationTrackParams r43 = r76.n;
        if (r43 == null) goto L131;
        Integer r314 = r43.b;
    L132:
        if (r43 == null) goto L134;
        String r315 = r43.a;
    L135:
        if (r43 == null) goto L137;
        String r316 = r43.d;
    L138:
        if (r43 == null) goto L140;
        String r44 = r43.e;
    L141:
        if (r43 == null) goto L143;
        String r317 = r43.f;
    L144:
        String r45 = r76.i;
        String r47 = zp9.d.c(r76);
        boolean r46 = r76.z();
        boolean r48 = r76.D();
        UserCreationRefContent r49 = r76.o;
        if (r49 == null) goto L149;
        List<ImageInfo> r50 = r49.a();
        if (r50 == null) goto L149;
        Integer r410 = Integer.valueOf(r50.size());
    L150:
        ny9.s r51 = z3();
        if (r51 == null) goto L156;
        Bundle r52 = r51.a;
        if (r52 == null) goto L156;
        String r53 = r52.getString("enter_method");
        if (r53 == null) goto L156;
    L157:
        String r54 = zp9.d.a(r76, false);
        u3.l(r210, r212, r211, r213, r310, r311, r313, r312, Integer.valueOf(r42), r314, r315, Integer.valueOf(r75), r316, r317, r44, "action_bar_template", null, null, null, null, r45, r47, Boolean.valueOf(r48), r410, Boolean.valueOf(r46), r53, null, zp9.d.e(r76), r54, Boolean.valueOf(ICreationAvatarService.a.v()), null, null, null, null, null, 272368000, 31);
        String r55 = r76.a;
        if (r55 == null) goto L162;
        Long r56 = StringsKt.toLongOrNull(r55);
        if (r56 == null) goto L162;
        r17 = r56.longValue();
    L162:
        com.larus.uaigc.template.p.a(r17);
        a1.c(null, null, null, null, null, "video_generate", null, null, "use_template", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1153, -1, 7);
        return true;
    L156:
        r53 = "chat_action_bar";
    L149:
        r410 = null;
        goto L150
    L143:
        r317 = null;
        goto L144
    L140:
        r44 = null;
        goto L141
    L137:
        r316 = null;
        goto L138
    L134:
        r315 = null;
        goto L135
    L131:
        r314 = null;
        goto L132
    L127:
        r312 = null;
        goto L128
    L123:
        r213 = r112;
        goto L124
    L120:
        r112 = null;
        goto L121
    L109:
        if (r78.length() != 0) goto L111;
        boolean r113 = true;
    L112:
        if (r113 == false) goto L114;
        String r57 = "template_list";
    L115:
        r211 = r57;
        goto L117
    L114:
        r57 = r78;
        goto L115
    L111:
        r113 = false;
        goto L112
    L106:
        r210 = r40;
        goto L107
    L103:
        r40 = null;
        goto L104
    L27:
        r5 = null;
        goto L28
    L5:
        r13 = null;
        goto L6
    }
}
