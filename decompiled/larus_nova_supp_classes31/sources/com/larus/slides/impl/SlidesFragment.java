package com.larus.slides.impl;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.b1;
import com.larus.office.base.OfficeBaseFragment;
import com.larus.office.base.view.CotHeaderView;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.f3$a;
import com.larus.platform.service.e2;
import com.larus.share.service.ShareServiceDelegate;
import com.larus.slides.biz.impl.databinding.LarusLayoutSlidesDetailFragmentBinding;
import com.larus.slides.impl.view.SlidesLoadLayout;
import com.larus.slides.sdk.api.ISlidesSdkProxyService;
import com.larus.slides.sdk.api.orientation.FullscreenOption;
import com.larus.slides.sdk.api.orientation.OrientationMode;
import com.larus.slides.sdk.api.orientation.SetFullscreenModel;
import com.larus.slides.sdk.api.orientation.SetOrientationModel;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import tx9.a1;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Ý\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f*\u0001?\b&\u0018\u0000 \u009e\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0002\u009e\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\b\u0010E\u001a\u00020\fH\u0014J\u001a\u0010F\u001a\u00020\u00022\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010JH\u0014J\u0010\u0010K\u001a\u00020B2\u0006\u0010L\u001a\u00020MH\u0014J\b\u0010N\u001a\u00020BH\u0016J\b\u0010O\u001a\u00020DH\u0014J0\u0010P\u001a\u00020B2\b\u00103\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u00104\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010Q\u001a\u00020B2\u0006\u0010R\u001a\u00020S2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\b\u0010T\u001a\u00020BH\u0002J\u0010\u0010U\u001a\u00020B2\u0006\u0010V\u001a\u00020WH\u0016J\b\u0010X\u001a\u00020BH\u0002J\b\u0010Y\u001a\u00020BH\u0002J\u0006\u0010Z\u001a\u00020BJ\b\u0010[\u001a\u00020\u0017H\u0014J\b\u0010\\\u001a\u00020\fH\u0014J\b\u0010]\u001a\u00020\u0017H\u0014J\u001c\u0010^\u001a\u00020B2\b\u00103\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010_\u001a\u00020BH\u0002J\b\u0010`\u001a\u00020BH\u0002J\b\u0010a\u001a\u00020\nH\u0016J\b\u0010b\u001a\u00020BH\u0002J\n\u0010c\u001a\u0004\u0018\u00010JH\u0016J\u0012\u0010d\u001a\u00020B2\b\u0010e\u001a\u0004\u0018\u00010JH\u0016J\u0010\u0010f\u001a\u00020B2\u0006\u0010g\u001a\u00020\fH\u0002Jn\u0010h\u001a\u00020B2\b\u0010i\u001a\u0004\u0018\u00010j2\u0012\u0010k\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020B0l2\u0006\u0010m\u001a\u00020\f2\b\u0010n\u001a\u0004\u0018\u00010o2\u0010\b\u0002\u0010p\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010q2\u0010\b\u0002\u0010r\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010q2\u0010\b\u0002\u0010s\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010qH\u0002J\u001e\u0010t\u001a\u00020B2\u0014\u0010u\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020B\u0018\u00010lH\u0002J\b\u0010v\u001a\u00020BH\u0002J\u0010\u0010w\u001a\u00020B2\u0006\u0010x\u001a\u00020\nH\u0002J\u0018\u0010y\u001a\u00020B2\u0006\u0010z\u001a\u00020\n2\u0006\u0010g\u001a\u00020\fH\u0002J\b\u0010{\u001a\u00020BH\u0002J\b\u0010|\u001a\u00020BH\u0002J\u000e\u0010}\u001a\u00020B2\u0006\u0010z\u001a\u00020\nJ\b\u0010~\u001a\u00020BH\u0016J\b\u0010\u007f\u001a\u00020\fH\u0016J\t\u0010\u0080\u0001\u001a\u00020BH\u0016J\n\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0016J\t\u0010\u0083\u0001\u001a\u00020\u0017H\u0002J\t\u0010\u0086\u0001\u001a\u00020BH\u0002J\u0013\u0010\u0089\u0001\u001a\u00020B2\b\u0010\u008a\u0001\u001a\u00030\u0088\u0001H\u0016J\u0015\u0010\u008b\u0001\u001a\u00020B2\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0016J\t\u0010\u008f\u0001\u001a\u00020BH\u0002J\t\u0010\u0090\u0001\u001a\u00020BH\u0002J\u0015\u0010\u0091\u0001\u001a\u00020B2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0016J\u0012\u0010\u0094\u0001\u001a\u00020B2\u0007\u0010\u0095\u0001\u001a\u00020\nH\u0014J<\u0010\u0096\u0001\u001a\u00020B2\b\u00103\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\f2\b\u0010%\u001a\u0004\u0018\u00010\fH\u0014J\t\u0010\u0098\u0001\u001a\u00020BH\u0016J\u0007\u0010\u0099\u0001\u001a\u00020BJ\u000b\u0010\u009a\u0001\u001a\u0004\u0018\u00010\fH\u0002J\u000b\u0010\u009b\u0001\u001a\u0004\u0018\u00010\fH\u0002J\t\u0010\u009c\u0001\u001a\u00020\nH\u0002J\t\u0010\u009d\u0001\u001a\u00020\nH$R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u0004\u0018\u000107X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0004\n\u0002\u0010@R\u0012\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008e\u0001\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u009f\u0001"}, d2 = {"Lcom/larus/slides/impl/SlidesFragment;", "Lcom/larus/office/base/OfficeBaseFragment;", "Lcom/larus/slides/biz/impl/databinding/LarusLayoutSlidesDetailFragmentBinding;", "Lcom/larus/bmhome/ability/FloatChatFoldStatusChangeListener;", "Lcom/larus/slides/api/ISlidesCotInfoListener;", "Lcom/larus/slides/sdk/api/ISupportChangeScreenConfigPage;", "Lcom/larus/slides/sdk/api/IGetTrackInfo;", "<init>", "()V", "customHeaderShowing", "", "slidesToken", "", "getSlidesToken", "()Ljava/lang/String;", "setSlidesToken", "(Ljava/lang/String;)V", "chatId", "getChatId", "setChatId", "isGeneralAgent", "artifactVersionId", "resourceType", "", "conversationId", "slidesName", "firstInitChatFrag", "chatService", "Lcom/larus/slides/sdk/api/IChatService;", "titleBarService", "Lcom/larus/office/base/service/ITitleBarService;", "selectionChangeService", "Lcom/larus/slides/sdk/api/ISelectionChangeService;", "loadingService", "Lcom/larus/office/base/page/ILoadingService;", "enterMethod", "isSlidesDeleted", "botId", "hasReportPresentationBtnShow", "undoBtnEnabled", "hasReportUndoBtnShow", "redoBtnEnabled", "hasReportRedoBtnShow", "moreBtnEnabled", "hasReportMoreBtnShow", "renderStared", "isLandscapeMode", "()Z", "setLandscapeMode", "(Z)V", "cotRefArtifacts", "artifactMetaId", "boundMessageId", "hasReportedEnterPage", "docContainerFragment", "Landroidx/fragment/app/Fragment;", "getDocContainerFragment", "()Landroidx/fragment/app/Fragment;", "setDocContainerFragment", "(Landroidx/fragment/app/Fragment;)V", "deferredMsgId", "Lkotlinx/coroutines/CompletableDeferred;", "speakStateListener", "com/larus/slides/impl/SlidesFragment$speakStateListener$1", "Lcom/larus/slides/impl/SlidesFragment$speakStateListener$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getLogTag", "getViewBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onInitHostFragment", "context", "Landroid/content/Context;", "onFloatChatFragmentInited", "getParamsBundle", "updateArtifactInfo", "onViewCreated", "view", "Landroid/view/View;", "initParams", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "adaptChatSpeakerInPad", "initHeadView", "onBackPressed", "getFloatChatFragmentContainerId", "getLocalConvIdSuffix", "getResourceType", "refreshArtifactInfo", "attachServices", "detachServices", "autoLogEnterPage", "initTitleBarService", "onObtainTitleBar", "onReadyInitTitleBar", "titleBar", "adjustInputVisibleInLandscapeMode", "from", "setupTitleMenuItem", "menuData", "Lcom/larus/office/base/service/BizMenuData;", "onMenuClick", "Lkotlin/Function1;", "itemId", "itemView", "Landroid/widget/ImageView;", "onMobShow", "Lkotlin/Function0;", "onMobClick", "onItemClick", "showMoreMenu", "moreMenuItemClick", "initChatService", "updateEditPanelHeight", "isActive", "updateChatInputVisibility", "isVisible", "initSelectionChangeService", "initLoadingService", "setSlidesChatInputVisible", "onDestroy", "getCurrentPageName", "foldStatusChanged", "getTraceParams", "Lorg/json/JSONObject;", "getTrackingResourceType", "appBackgroundListener", "Lcom/larus/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;", "initAppBackgroundListener", "curCotInfo", "Lcom/larus/bmhome/chat/bean/HeadTitleInfoSimplify;", "onCotInfoUpdate", "cotInfo", "setFullscreenMode", "fullscreenModel", "Lcom/larus/slides/sdk/api/orientation/SetFullscreenModel;", "isHeaderViewLastVisible", "resetHeaderViewLastVisible", "interceptHeaderViewVisible", "setOrientationMode", "orientationModel", "Lcom/larus/slides/sdk/api/orientation/SetOrientationModel;", "adapterTitleBarOnOrientationMode", "isLandscape", "onArtifactInfoUpdated", "messageId", "onDestroyView", "hideKeyboard", "getArtifactCreateMethod", "getEnterMethod", "isSlidesOwner", "canEdit", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public abstract class SlidesFragment extends OfficeBaseFragment<LarusLayoutSlidesDetailFragmentBinding> implements vw9.b, ax9.e, ax9.b {
    public static final /* synthetic */ int O = 0;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public String F;
    public String G;
    public boolean H;
    public Fragment I;
    public final CompletableDeferred<String> J;
    public final b K;
    public t L;
    public ic8.t M;
    public boolean N;
    public boolean i;
    public String j;
    public String k;
    public String l;
    public String m;
    public int n;
    public String o;
    public String p;
    public v q;
    public e0 r;
    public x s;
    public w t;
    public String u;
    public boolean v;
    public String w;
    public boolean x;
    public boolean y;
    public boolean z;

    public static final class a {
    }

    public static final class b implements com.larus.bmhome.chat.component.bottom.core.speaker.h {
        public final /* synthetic */ SlidesFragment a;

        public b(SlidesFragment r1) {
            this.a = r1;
        }

        public final void a(com.larus.bmhome.chat.component.bottom.core.speaker.g r4) {
            Intrinsics.checkNotNullParameter(r4, "state");
            FLogger.a.i("onStateChanged", "onStateChanged state=" + r4);
            boolean r1 = true;
            if (Intrinsics.areEqual(r4, com.larus.bmhome.chat.component.bottom.core.speaker.g.c.a) == false) goto L19;
            SlidesFragment r5 = this.a;
            int r0 = SlidesFragment.O;
            LarusLayoutSlidesDetailFragmentBinding r6 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r5).e;
            if (r6 == null) goto L11;
            CotHeaderView r7 = r6.e;
            if (r7 == null) goto L11;
            if (r7.getVisibility() != 0) goto L11;
        L12:
            if (r1 == false) goto L54;
            LarusLayoutSlidesDetailFragmentBinding r8 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this.a).e;
            if (r8 == null) goto L55;
            CotHeaderView r9 = r8.e;
            if (r9 == null) goto L56;
            e1.q(r9);
            return;
        L56:
            return;
        L55:
            return;
        L54:
            return;
        L11:
            r1 = false;
            goto L12
        L19:
            if (Intrinsics.areEqual(r4, com.larus.bmhome.chat.component.bottom.core.speaker.g.b.a) == false) goto L25;
            SlidesFragment r10 = this.a;
            r10.N = false;
            LarusLayoutSlidesDetailFragmentBinding r11 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r10).e;
            if (r11 == null) goto L58;
            CotHeaderView r12 = r11.e;
            if (r12 == null) goto L59;
            e1.o(r12);
            return;
        L59:
            return;
        L58:
            return;
        L25:
            SlidesFragment r13 = this.a;
            int r2 = SlidesFragment.O;
            LarusLayoutSlidesDetailFragmentBinding r14 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r13).e;
            if (r14 == null) goto L32;
            CotHeaderView r15 = r14.e;
            if (r15 == null) goto L32;
            if (r15.getVisibility() != 4) goto L32;
            boolean r16 = true;
        L33:
            if (r16 == false) goto L61;
            Fragment r17 = ((OfficeBaseFragment) this.a).f;
            if (r17 != null) goto L37;
        L39:
            boolean r18 = false;
        L40:
            if (r18 == false) goto L62;
            Fragment r19 = ((OfficeBaseFragment) this.a).f;
            if (r19 == null) goto L50;
            t1a.b r20 = s1a.a.g(r19);
            if (r20 == null) goto L50;
            va8.g0 r21 = r20.getAbility(va8.g0.class);
            if (r21 == null) goto L50;
            if (r21.YC() != true) goto L50;
        L51:
            if (r1 == true) goto L63;
            SlidesFragment.ja0(this.a);
            return;
        L63:
            return;
        L50:
            r1 = false;
            goto L51
        L62:
            return;
        L37:
            if (r17.isAdded() != true) goto L39;
            r18 = true;
            goto L40
        L61:
            return;
        L32:
            r16 = false;
            goto L33
        }
    }

    /* JADX INFO: renamed from: com.larus.slides.impl.SlidesFragment$onCotInfoUpdate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.slides.impl.SlidesFragment$onCotInfoUpdate$1", f = "SlidesFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ic8.t $cotInfo;
        final /* synthetic */ Ref.ObjectRef<ic8.t> $result;
        int label;
        final /* synthetic */ SlidesFragment this$0;

        public AnonymousClass1(ic8.t r1, SlidesFragment r2, Ref.ObjectRef<ic8.t> r3, Continuation<? super AnonymousClass1> r4) {
            this.$cotInfo = r1;
            this.this$0 = r2;
            this.$result = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$cotInfo, this.this$0, this.$result, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L44;
            ResultKt.throwOnFailure(r5);
            ic8.t r6 = this.$cotInfo;
            int r0 = r6.f;
            boolean r2 = false;
            if (r0 != 3) goto L11;
            SlidesFragment r7 = this.this$0;
            r7.N = false;
            LarusLayoutSlidesDetailFragmentBinding r8 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r7).e;
            if (r8 == null) goto L36;
            CotHeaderView r9 = r8.e;
            if (r9 == null) goto L36;
            e1.o(r9);
        L36:
            SlidesFragment r10 = this.this$0;
            int r1 = SlidesFragment.O;
            LarusLayoutSlidesDetailFragmentBinding r11 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r10).e;
            if (r11 == null) goto L42;
            CotHeaderView r12 = r11.e;
            if (r12 == null) goto L42;
            r12.R5((ic8.t) this.$result.element);
        L42:
            return Unit.INSTANCE;
        L11:
            SlidesFragment r3 = this.this$0;
            if (r3.D == false) goto L14;
        L20:
            Fragment r13 = ((OfficeBaseFragment) r3).f;
            if (r13 == null) goto L29;
            t1a.b r14 = s1a.a.g(r13);
            if (r14 == null) goto L29;
            va8.g0 r15 = r14.getAbility(va8.g0.class);
            if (r15 == null) goto L29;
            if (r15.YC() != true) goto L29;
            r2 = true;
        L29:
            if (r2 == false) goto L35;
            LarusLayoutSlidesDetailFragmentBinding r16 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this.this$0).e;
            if (r16 == null) goto L36;
            CotHeaderView r17 = r16.e;
            if (r17 == null) goto L36;
            e1.q(r17);
            goto L36
        L35:
            SlidesFragment.ja0(this.this$0);
            goto L36
        L14:
            if (r0 != 2) goto L20;
            Ref.ObjectRef<ic8.t> r4 = this.$result;
            r4.element = ic8.t.a(r6);
            SlidesFragment r18 = this.this$0;
            r18.N = false;
            LarusLayoutSlidesDetailFragmentBinding r19 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r18).e;
            if (r19 == null) goto L36;
            CotHeaderView r20 = r19.e;
            if (r20 == null) goto L36;
            e1.o(r20);
            goto L36
        L44:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public final boolean S90() {
        return false;
    }

    public final int V90() {
        return 2131386895;
    }

    public final String W90() {
        return "-slides-detail";
    }

    public final int Y90() {
        return 9;
    }

    public abstract boolean canEdit();

    public final String getLogTag() {
        return "SlidesFragment";
    }

    @Override // ax9.e
    public final String ha() {
        return "";
    }

    public final String k() {
        return "aippt_new_detail";
    }

    public void ma0(boolean r1) {
    }

    public void sa0(String r1, String r2, String r3, String r4, String r5) {
    }

    public ViewGroup ta0() {
        return null;
    }

    public void ua0() {
    }

    private final void la0() {
        if (e2.a.isPad() == true) goto L5;
        return;
    L5:
        LarusLayoutSlidesDetailFragmentBinding r0 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r0 == null) goto L12;
        if (r0 == null) goto L13;
        CotHeaderView r1 = r0.e;
        if (r1 == null) goto L14;
        r1.setPadding(i5.h() + f3$a.b(), r1.getPaddingTop(), (i5.h() + f3$a.b()) + i5.Y(), r1.getPaddingBottom());
        return;
    L14:
        return;
    L13:
        return;
    }

    private final void na0() {
        this.r = new e0(this);
        ISlidesSdkProxyService r0 = (ISlidesSdkProxyService) ServiceManager.get().getService(ISlidesSdkProxyService.class);
        if (r0 == null) goto L5;
        r0.addTitleBarService(this.r);
    L5:
        this.q = new v(this);
        ISlidesSdkProxyService r1 = (ISlidesSdkProxyService) ServiceManager.get().getService(ISlidesSdkProxyService.class);
        if (r1 == null) goto L8;
        r1.e(this.q);
    L8:
        this.s = new x(this);
        ISlidesSdkProxyService r2 = (ISlidesSdkProxyService) ServiceManager.get().getService(ISlidesSdkProxyService.class);
        if (r2 == null) goto L11;
        r2.f(this.s);
    L11:
        FLogger r3 = FLogger.a;
        r3.d("SlidesFragment", "initLoadingService");
        this.t = new w(this);
        r3.d("SlidesFragment", "addLoadingService loadingService=" + this.t + " hashCode=" + hashCode());
        ISlidesSdkProxyService r4 = (ISlidesSdkProxyService) ServiceManager.get().getService(ISlidesSdkProxyService.class);
        if (r4 == null) goto L15;
        r4.addLoadingService(this.t);
        return;
    }

    private final int pa0() {
        int r0 = com.larus.office.base.utils.o.a;
        Integer r1 = com.larus.office.base.utils.o.b(Integer.valueOf(this.n), 9);
        if (r1 != null) goto L5;
        return 9;
    L5:
        return r1.intValue();
    }

    private final void qa0() {
        ic8.t r0 = this.M;
        if (r0 == null) goto L8;
        Map r1 = r0.e;
        if (r1 == null) goto L8;
        String r2 = (String) r1.get("cot_ref_artifacts");
    L8:
        if (this.E == true) goto L15;
        LarusLayoutSlidesDetailFragmentBinding r3 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r3 == null) goto L16;
        CotHeaderView r4 = r3.e;
        if (r4 == null) goto L17;
        e1.x(r4);
        return;
    L17:
        return;
    L16:
        return;
    }

    public final void ca0() {
        Fragment r0 = ((OfficeBaseFragment) this).f;
        if (r0 == null) goto L9;
        t1a.b r1 = s1a.a.g(r0);
        if (r1 == null) goto L9;
        va8.r r2 = r1.o(Reflection.getOrCreateKotlinClass(va8.r.class));
        if (r2 == null) goto L9;
        r2.JD("aippt_new_detail");
    L9:
        Fragment r3 = ((OfficeBaseFragment) this).f;
        if (r3 == null) goto L16;
        t1a.b r4 = s1a.a.g(r3);
        if (r4 == null) goto L16;
        va8.o r5 = r4.o(Reflection.getOrCreateKotlinClass(va8.o.class));
        if (r5 == null) goto L16;
        int r6 = com.larus.office.k.a;
        r5.S6(getString(2131897742));
    L16:
        Fragment r7 = ((OfficeBaseFragment) this).f;
        if (r7 == null) goto L23;
        t1a.b r8 = s1a.a.g(r7);
        if (r8 == null) goto L23;
        va8.o r9 = r8.o(Reflection.getOrCreateKotlinClass(va8.o.class));
        if (r9 == null) goto L23;
        int r10 = com.larus.office.k.a;
        r9.HH(getString(2131897742));
    L23:
        Fragment r11 = ((OfficeBaseFragment) this).f;
        if (r11 == null) goto L30;
        t1a.b r12 = s1a.a.g(r11);
        if (r12 == null) goto L30;
        vw9.a r13 = r12.o(Reflection.getOrCreateKotlinClass(vw9.a.class));
        if (r13 == null) goto L30;
        r13.MM(this);
    L30:
        Fragment r14 = ((OfficeBaseFragment) this).f;
        if (r14 == null) goto L38;
        t1a.b r15 = s1a.a.g(r14);
        if (r15 == null) goto L39;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r16 = r15.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r16 == null) goto L40;
        r16.e8(this.K);
        return;
    L40:
        return;
    L39:
        return;
    }

    public final void foldStatusChanged() {
        Fragment r0 = ((OfficeBaseFragment) this).f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isAdded() == false) goto L66;
        va8.g0 r1 = s1a.a.g(r0).getAbility(va8.g0.class);
        boolean r2 = true;
        if (r1 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        Integer r4 = null;
        Drawable r5 = null;
        r5 = null;
        r4 = null;
        if (r3 == false) goto L44;
        va8.g0 r6 = s1a.a.g(r0).getAbility(va8.g0.class);
        if (r6 == null) goto L22;
        Context r7 = r0.getContext();
        if (r7 == null) goto L21;
        Resources r8 = r7.getResources();
        if (r8 == null) goto L21;
        r5 = r8.getDrawable(2131240729);
    L21:
        r6.gA(r5);
    L22:
        LarusLayoutSlidesDetailFragmentBinding r9 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r9 == null) goto L27;
        View r10 = r9.b;
        if (r10 == null) goto L27;
        e1.x(r10);
    L27:
        ISlidesSdkProxyService r11 = (ISlidesSdkProxyService) ServiceManager.get().getService(ISlidesSdkProxyService.class);
        if (r11 == null) goto L30;
        r11.a();
    L30:
        FLogger.a.i("SlidesFragment", "foldStatusChanged loadingText invisible");
        LarusLayoutSlidesDetailFragmentBinding r12 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r12 == null) goto L37;
        CotHeaderView r13 = r12.e;
        if (r13 == null) goto L37;
        if (r13.getVisibility() != 0) goto L37;
    L38:
        if (r2 == false) goto L67;
        LarusLayoutSlidesDetailFragmentBinding r14 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r14 == null) goto L68;
        CotHeaderView r15 = r14.e;
        if (r15 == null) goto L69;
        e1.q(r15);
        return;
    L69:
        return;
    L68:
        return;
    L67:
        return;
    L37:
        r2 = false;
        goto L38
    L44:
        LarusLayoutSlidesDetailFragmentBinding r16 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r16 == null) goto L49;
        View r17 = r16.b;
        if (r17 == null) goto L49;
        e1.o(r17);
    L49:
        FLogger r18 = FLogger.a;
        StringBuilder r19 = new StringBuilder("foldStatusChanged loadingText visibility=");
        LarusLayoutSlidesDetailFragmentBinding r20 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r20 == null) goto L54;
        CotHeaderView r21 = r20.e;
        if (r21 == null) goto L54;
        r4 = Integer.valueOf(r21.getVisibility());
    L54:
        r19.append(r4);
        r18.i("SlidesFragment", r19.toString());
        LarusLayoutSlidesDetailFragmentBinding r22 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r22 == null) goto L61;
        CotHeaderView r23 = r22.e;
        if (r23 == null) goto L61;
        if (r23.getVisibility() != 4) goto L61;
    L62:
        if (r2 == false) goto L71;
        qa0();
        return;
    L71:
        return;
    L61:
        r2 = false;
        goto L62
    L9:
        if (r1.YC() != true) goto L11;
        r3 = true;
        goto L12
    }

    public final void onDestroy() {
        FLogger r0 = FLogger.a;
        r0.i("SlidesFragment", "[onDestroy]");
        Fragment r2 = ((OfficeBaseFragment) this).f;
        if (r2 != null) goto L5;
    L9:
        t r3 = this.L;
        if (r3 == null) goto L13;
        AppHost.a.a().c(r3);
    L13:
        if (this.v == true) goto L15;
        int r4 = ww9.a.b;
        ww9.a.c("click_back", Long.valueOf(System.currentTimeMillis() - ww9.a.a), t9());
    L15:
        Fragment r5 = ((OfficeBaseFragment) this).f;
        if (r5 == null) goto L22;
        t1a.b r6 = s1a.a.g(r5);
        if (r6 == null) goto L22;
        vw9.a r7 = r6.o(Reflection.getOrCreateKotlinClass(vw9.a.class));
        if (r7 == null) goto L22;
        r7.zd(this);
    L22:
        Fragment r8 = ((OfficeBaseFragment) this).f;
        if (r8 == null) goto L29;
        t1a.b r9 = s1a.a.g(r8);
        if (r9 == null) goto L29;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r10 = r9.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r10 == null) goto L29;
        r10.B9(this.K);
    L29:
        ISlidesSdkProxyService r11 = (ISlidesSdkProxyService) ServiceManager.get().getService(ISlidesSdkProxyService.class);
        if (r11 == null) goto L32;
        r11.d(this.q);
    L32:
        ISlidesSdkProxyService r12 = (ISlidesSdkProxyService) ServiceManager.get().getService(ISlidesSdkProxyService.class);
        if (r12 == null) goto L35;
        r12.j(this.r);
    L35:
        ISlidesSdkProxyService r13 = (ISlidesSdkProxyService) ServiceManager.get().getService(ISlidesSdkProxyService.class);
        if (r13 == null) goto L38;
        r13.i(this.s);
    L38:
        r0.d("SlidesFragment", "removeLoadingService loadingService=" + this.t + " hashCode=" + hashCode());
        ISlidesSdkProxyService r1 = (ISlidesSdkProxyService) ServiceManager.get().getService(ISlidesSdkProxyService.class);
        if (r1 == null) goto L42;
        r1.g(this.t);
    L42:
        if (this.x == true) goto L45;
        this.x = true;
        int r14 = ww9.a.b;
        ww9.a.b("play", null, t9());
    L45:
        if (this.C == true) goto L48;
        this.C = true;
        int r15 = ww9.a.b;
        ww9.a.b("more", null, t9());
    L48:
        if (this.H == true) goto L55;
        this.H = true;
        String r43 = getEnterMethod();
        JSONObject r16 = new JSONObject();
        r16.put("artifact_type", 9);
        r16.put("artifact_create_method", oa0());
        r16.put("resource_type", pa0());
        r16.put("artifact_meta_id", this.F);
        r16.put("resource_id", this.j);
        r16.put("presentation_id", this.j);
        Bundle r17 = getArguments();
        if (r17 == null) goto L54;
        String r18 = r17.getString("aippt_task_id");
        if (r18 == null) goto L54;
        r16.put("aippt_task_id", r18);
    L54:
        a1.c(null, null, null, null, null, "aippt_new_detail", null, null, r43, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r16, this, null, null, null, null, null, null, null, -1153, -25165825, 7);
    L55:
        super.onDestroy();
        return;
    L5:
        if (r2.isAdded() == false) goto L9;
        va8.g0 r19 = s1a.a.g(r2).getAbility(va8.g0.class);
        if (r19 == null) goto L9;
        r19.Zh(this);
        goto L9
    }

    public final void onDestroyView() {
        ISlidesSdkProxyService r0 = (ISlidesSdkProxyService) ServiceManager.get().getService(ISlidesSdkProxyService.class);
        if (r0 == null) goto L5;
        r0.a();
    L5:
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    @Override // ax9.b
    public final JSONObject t9() {
        JSONObject r0 = new JSONObject();
        r0.put("artifact_type", 9);
        Object r1 = by7.h.a(this).getParams().get("previous_page");
        if ((r1 instanceof String) == false) goto L5;
        String r2 = (String) r1;
    L6:
        r0.put("previous_page", r2);
        r0.put("current_page", "aippt_new_detail");
        r0.put("canvas_type", "aippt_new");
        r0.put("artifact_create_method", oa0());
        r0.put("resource_id", this.j);
        r0.put("presentation_id", this.j);
        r0.put("resource_type", pa0());
        r0.put("artifact_meta_id", this.F);
        r0.put("conversation_id", this.o);
        String r3 = this.G;
        if (r3 == null) goto L9;
        r0.put("message_id", r3);
    L9:
        String r4 = this.w;
        if (r4 == null) goto L12;
        r0.put("bot_id", r4);
    L12:
        String r5 = getEnterMethod();
        if (r5 == null) goto L15;
        r0.put("enter_method", r5);
    L15:
        Bundle r6 = getArguments();
        if (r6 == null) goto L20;
        String r7 = r6.getString("aippt_task_id");
        if (r7 == null) goto L20;
        r0.put("aippt_task_id", r7);
    L20:
        return r0;
    L5:
        r2 = null;
        goto L6
    }

    public SlidesFragment() {
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = 9;
        this.o = "";
        this.F = "";
        this.J = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.K = new b(this);
    }

    private final String getEnterMethod() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r1 = r0.getString("previous_page");
    L7:
        if (Intrinsics.areEqual(r1, "ai_space_list") == false) goto L10;
        return "ai_space_list";
    L10:
        return this.u;
    L5:
        r1 = null;
        goto L7
    }

    private final String oa0() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r1 = r0.getString("drive_override_current_page");
    L7:
        if (Intrinsics.areEqual(r1, "ai_space_detail") == true) goto L10;
        return "ai_space";
    L10:
        return null;
    L5:
        r1 = null;
        goto L7
    }

    public final Bundle X90() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        String r1 = r0.getString("previous_page");
        if (r1 == null) goto L6;
    L7:
        Bundle r2 = getArguments();
        String r3 = null;
        if (r2 == null) goto L10;
        String r4 = r2.getString("drive_override_current_page");
    L11:
        Pair[] r5 = new Pair[10];
        r5[0] = TuplesKt.to("slides_token", this.j);
        r5[1] = TuplesKt.to("artifact_version_id", this.m);
        r5[2] = TuplesKt.to("conversation_id", this.o);
        r5[3] = TuplesKt.to("artifact_meta_id", this.F);
        r5[4] = TuplesKt.to("argPreviousPage", r1);
        r5[5] = TuplesKt.to("token", this.j);
        r5[6] = TuplesKt.to("drive_override_current_page", r4);
        Bundle r6 = getArguments();
        if (r6 == null) goto L14;
        String r7 = r6.getString("resource_id");
    L15:
        r5[7] = TuplesKt.to("resource_id", r7);
        Bundle r8 = getArguments();
        if (r8 == null) goto L18;
        Integer r9 = Integer.valueOf(r8.getInt("resource_type", 0));
    L19:
        r5[8] = TuplesKt.to("resource_type", r9);
        Bundle r10 = getArguments();
        if (r10 == null) goto L22;
        r3 = r10.getString("key_source_url_for_params");
    L22:
        r5[9] = TuplesKt.to("key_source_url_for_params", r3);
        return BundleKt.bundleOf(r5);
    L18:
        r9 = null;
        goto L19
    L14:
        r7 = null;
        goto L15
    L10:
        r4 = null;
    L6:
        r1 = "";
        goto L7
    }

    public final boolean ra0() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L6;
        return true;
    L6:
        if (r0.containsKey("is_slides_owner") == true) goto L8;
        return true;
    L8:
        return r0.getBoolean("is_slides_owner");
    }

    public static final void fa0(SlidesFragment r2) {
        r2.va0(!r2.E, "adjustInputVisibleInLandscapeMode:onCustomHeaderVisibilityChanged");
    }

    public static final /* synthetic */ String ga0(SlidesFragment r0) {
        return r0.oa0();
    }

    public static final /* synthetic */ String ha0(SlidesFragment r0) {
        return r0.getEnterMethod();
    }

    public static final /* synthetic */ int ia0(SlidesFragment r0) {
        return r0.pa0();
    }

    public static final /* synthetic */ void ja0(SlidesFragment r0) {
        r0.qa0();
    }

    @Override // ax9.e
    public void K60(SetOrientationModel r8) {
        ISlidesSdkProxyService r0 = (ISlidesSdkProxyService) ServiceManager.get().getService(ISlidesSdkProxyService.class);
        if (r0 == null) goto L5;
        r0.a();
    L5:
        LarusLayoutSlidesDetailFragmentBinding r1 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r1 == null) goto L10;
        ConstraintLayout r2 = r1.j;
        if (r2 == null) goto L10;
        com.larus.bmhome.view.screenmenu.d r3 = com.larus.bmhome.view.screenmenu.d.a;
        com.larus.bmhome.view.screenmenu.d.b(r2);
    L10:
        if (r8 == null) goto L13;
        String r9 = r8.getOrientation();
        if (r9 == null) goto L13;
    L14:
        OrientationMode r4 = OrientationMode.LANDSCAPE;
        this.E = Intrinsics.areEqual(r9, r4.getMode());
        ConstraintLayout.LayoutParams r5 = null;
        if (Intrinsics.areEqual(r9, r4.getMode()) == true) goto L66;
        LarusLayoutSlidesDetailFragmentBinding r10 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r10 == null) goto L21;
        ConstraintLayout r11 = r10.j;
        if (r11 == null) goto L21;
        r11.setPadding(i5.r0(), 0, i5.r0(), 0);
    L21:
        LarusLayoutSlidesDetailFragmentBinding r12 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r12 == null) goto L26;
        NovaTitleBarEx r13 = r12.m;
        if (r13 == null) goto L26;
        r13.setPadding(0, 0, 0, 0);
    L26:
        LarusLayoutSlidesDetailFragmentBinding r14 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r14 == null) goto L36;
        NovaTitleBarEx r15 = r14.m;
        if (r15 == null) goto L36;
        if (r15.getVisibility() != 0) goto L33;
        boolean r16 = true;
    L34:
        if (r16 != true) goto L36;
        boolean r17 = true;
    L37:
        if (r17 == false) goto L39;
    L43:
        va0(false, "setOrientationMode");
    L45:
        if (this.N == false) goto L47;
        this.N = false;
        qa0();
    L47:
        Fragment r18 = ((OfficeBaseFragment) this).f;
        if (r18 == null) goto L54;
        t1a.b r19 = s1a.a.g(r18);
        if (r19 == null) goto L54;
        va8.n r20 = r19.getAbility(va8.n.class);
        if (r20 == null) goto L54;
        r20.hideKeyboard();
    L54:
        LarusLayoutSlidesDetailFragmentBinding r21 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r21 == null) goto L57;
        FrameLayout r22 = r21.c;
    L58:
        if (r22 == null) goto L60;
        ViewGroup.LayoutParams r6 = r22.getLayoutParams();
    L62:
        if ((r6 instanceof ConstraintLayout.LayoutParams) == false) goto L64;
        r5 = (ConstraintLayout.LayoutParams) r6;
    L64:
        if (r5 == null) goto L112;
        r5.topToTop = -1;
        r5.topToBottom = 2131386914;
        r22.setLayoutParams(r5);
        r22.requestLayout();
    L112:
        ma0(this.E);
        return;
    L60:
        r6 = null;
        goto L62
    L57:
        r22 = null;
        goto L58
    L39:
        if (this.i == true) goto L43;
        if (ra0() == false) goto L43;
        va0(true, "setOrientationMode");
        goto L45
    L33:
        r16 = false;
    L36:
        r17 = false;
        goto L37
    L66:
        LarusLayoutSlidesDetailFragmentBinding r23 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r23 == null) goto L71;
        ConstraintLayout r24 = r23.j;
        if (r24 == null) goto L71;
        r24.setPadding(i5.k0(), 0, i5.k0(), 0);
    L71:
        LarusLayoutSlidesDetailFragmentBinding r25 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r25 == null) goto L76;
        NovaTitleBarEx r26 = r25.m;
        if (r26 == null) goto L76;
        r26.setPadding(i5.g0(), 0, i5.g0(), 0);
    L76:
        va0(false, "setOrientationMode");
        LarusLayoutSlidesDetailFragmentBinding r27 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r27 == null) goto L86;
        CotHeaderView r28 = r27.e;
        if (r28 == null) goto L86;
        if (r28.getVisibility() != 0) goto L83;
        boolean r29 = true;
    L84:
        if (r29 != true) goto L86;
        boolean r30 = true;
    L87:
        if (r30 == false) goto L93;
        this.N = true;
        LarusLayoutSlidesDetailFragmentBinding r31 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r31 == null) goto L93;
        CotHeaderView r32 = r31.e;
        if (r32 == null) goto L93;
        e1.o(r32);
    L93:
        Fragment r33 = ((OfficeBaseFragment) this).f;
        if (r33 == null) goto L100;
        t1a.b r34 = s1a.a.g(r33);
        if (r34 == null) goto L100;
        va8.n r35 = r34.getAbility(va8.n.class);
        if (r35 == null) goto L100;
        r35.hideKeyboard();
    L100:
        LarusLayoutSlidesDetailFragmentBinding r36 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r36 == null) goto L103;
        FrameLayout r37 = r36.c;
    L104:
        if (r37 == null) goto L106;
        ConstraintLayout.LayoutParams r7 = r37.getLayoutParams();
    L108:
        if ((r7 instanceof ConstraintLayout.LayoutParams) == false) goto L110;
        r5 = r7;
    L110:
        if (r5 == null) goto L112;
        r5.topToBottom = -1;
        r5.topToTop = 0;
        r37.setLayoutParams(r5);
        r37.requestLayout();
        goto L112
    L106:
        r7 = null;
        goto L108
    L103:
        r37 = null;
        goto L104
    L83:
        r29 = false;
    L86:
        r30 = false;
    L13:
        r9 = OrientationMode.PORTRAIT.getMode();
        goto L14
    }

    public final void da0(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L91
        Bundle r1 = getArguments();     // Catch: Throwable -> L91
        String r2 = "";
        if (r1 == null) goto L8;
        String r3 = r1.getString("slides_token");     // Catch: Throwable -> L91
        if (r3 == null) goto L8;
    L9:
        this.j = r3;     // Catch: Throwable -> L91
        Bundle r4 = getArguments();     // Catch: Throwable -> L91
        if (r4 == null) goto L13;
        String r5 = r4.getString("artifact_version_id");     // Catch: Throwable -> L91
        if (r5 == null) goto L13;
    L14:
        this.m = r5;     // Catch: Throwable -> L91
        Bundle r6 = getArguments();     // Catch: Throwable -> L91
        if (r6 == null) goto L18;
        String r7 = r6.getString("chat_id");     // Catch: Throwable -> L91
        if (r7 == null) goto L18;
    L19:
        this.k = r7;     // Catch: Throwable -> L91
        Bundle r8 = getArguments();     // Catch: Throwable -> L91
        if (r8 == null) goto L23;
        String r10 = r8.getString("is_general_agent");     // Catch: Throwable -> L91
        if (r10 == null) goto L23;
    L24:
        this.l = r10;     // Catch: Throwable -> L91
        Bundle r11 = getArguments();     // Catch: Throwable -> L91
        if (r11 == null) goto L30;
        String r12 = r11.getString("conversation_id");     // Catch: Throwable -> L91
        if (r12 == null) goto L30;
        r2 = r12;
    L30:
        this.o = r2;     // Catch: Throwable -> L91
        Bundle r13 = getArguments();     // Catch: Throwable -> L91
        if (r13 == null) goto L33;
        String r14 = r13.getString("enter_method");     // Catch: Throwable -> L91
    L34:
        this.u = r14;     // Catch: Throwable -> L91
        Bundle r15 = getArguments();     // Catch: Throwable -> L91
        if (r15 == null) goto L37;
        String r16 = r15.getString("message_id");     // Catch: Throwable -> L91
    L38:
        this.G = r16;     // Catch: Throwable -> L91
        Bundle r17 = getArguments();     // Catch: Throwable -> L91
        if (r17 == null) goto L41;
        String r18 = r17.getString("bot_id");     // Catch: Throwable -> L91
    L42:
        this.w = r18;     // Catch: Throwable -> L91
        Bundle r19 = getArguments();     // Catch: Throwable -> L91
        if (r19 == null) goto L45;
        int r20 = r19.getInt("resource_type");     // Catch: Throwable -> L91
    L46:
        this.n = r20;     // Catch: Throwable -> L91
        if (com.larus.utils.o0.d(this.G) == false) goto L50;
        this.J.complete(this.G);     // Catch: Throwable -> L91
    L50:
        int r21 = 0;
        if (this.j.length() != 0) goto L53;
        boolean r22 = true;
    L55:
        if (r22 == false) goto L58;
        FLogger.a.i("SlidesFragment", "Invalid slides token");     // Catch: Throwable -> L91
        requireActivity().finish();     // Catch: Throwable -> L91
        return;
    L58:
        aa0(r9);     // Catch: Throwable -> L91
        FLogger.a.i("SlidesFragment", "onInitHostFragment setupServices");     // Catch: Throwable -> L91
        na0();     // Catch: Throwable -> L91
        ViewBinding r23 = ((OfficeBaseFragment) this).e;     // Catch: Throwable -> L91
        LarusLayoutSlidesDetailFragmentBinding r24 = (LarusLayoutSlidesDetailFragmentBinding) r23;     // Catch: Throwable -> L91
        if (r24 == null) goto L79;
        FrameLayout r25 = r24.l;     // Catch: Throwable -> L91
        if (r25 == null) goto L79;
        LarusLayoutSlidesDetailFragmentBinding r26 = (LarusLayoutSlidesDetailFragmentBinding) r23;     // Catch: Throwable -> L91
        if (r26 == null) goto L67;
        FrameLayout r27 = r26.l;     // Catch: Throwable -> L91
        if (r27 == null) goto L67;
        ViewGroup.LayoutParams r28 = r27.getLayoutParams();     // Catch: Throwable -> L91
    L69:
        if ((r28 instanceof ConstraintLayout.LayoutParams) == false) goto L71;
        ConstraintLayout.LayoutParams r29 = (ConstraintLayout.LayoutParams) r28;     // Catch: Throwable -> L91
    L72:
        if (r29 == null) goto L77;
        FragmentActivity r30 = getActivity();     // Catch: Throwable -> L91
        if (r30 == null) goto L76;
        r21 = com.larus.utils.u.c(r30);     // Catch: Throwable -> L91
    L76:
        ((ViewGroup.MarginLayoutParams) r29).topMargin = r21;     // Catch: Throwable -> L91
    L78:
        r25.setLayoutParams(r29);     // Catch: Throwable -> L91
        goto L79
    L77:
        r29 = null;
        goto L78
    L71:
        r29 = null;
    L67:
        r28 = null;
    L79:
        LarusLayoutSlidesDetailFragmentBinding r31 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;     // Catch: Throwable -> L91
        if (r31 == null) goto L84;
        ImageView r32 = r31.k;     // Catch: Throwable -> L91
        if (r32 == null) goto L84;
        e1.d(r32, new o(this));     // Catch: Throwable -> L91
    L84:
        LarusLayoutSlidesDetailFragmentBinding r33 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;     // Catch: Throwable -> L91
        if (r33 == null) goto L89;
        LinearLayout r34 = r33.i;     // Catch: Throwable -> L91
        if (r34 == null) goto L89;
        e1.d(r34, new p());     // Catch: Throwable -> L91
    L89:
        HashMap<String, Boolean> r35 = zw9.c.a;     // Catch: Throwable -> L91
        zw9.c.b(this.j);     // Catch: Throwable -> L91
        Result.constructor-impl(BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new SlidesFragment$onInitHostFragment$1$4(this, null), 2, null));     // Catch: Throwable -> L91
        return;
    L53:
        r22 = false;
        goto L55
    L45:
        r20 = 9;
        goto L46
    L41:
        r18 = null;
        goto L42
    L37:
        r16 = null;
        goto L38
    L33:
        r14 = null;
    L23:
        r10 = "";
    L18:
        r7 = "";
    L13:
        r5 = "";
    L8:
        r3 = "";
    L91:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // ax9.e
    public final void iT(String r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // ax9.e
    public final void jp(SetFullscreenModel r5) {
        int r0 = 0;
        if (r5 == null) goto L5;
        boolean r1 = Intrinsics.areEqual(r5.getEnable(), Boolean.TRUE);
    L6:
        ConstraintLayout.LayoutParams r2 = null;
        if (r1 == false) goto L28;
        FullscreenOption r6 = r5.getOption();
        if (r6 == null) goto L11;
        boolean r7 = Intrinsics.areEqual(r6.getHideStatusBar(), Boolean.TRUE);
    L12:
        if (r7 == false) goto L28;
        LarusLayoutSlidesDetailFragmentBinding r8 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r8 == null) goto L47;
        FrameLayout r3 = r8.l;
        if (r3 == null) goto L48;
        if (r8 == null) goto L20;
        if (r3 == null) goto L20;
        ViewGroup.LayoutParams r9 = r3.getLayoutParams();
    L22:
        if ((r9 instanceof ConstraintLayout.LayoutParams) == false) goto L24;
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) r9;
    L25:
        if (r10 == null) goto L27;
        ((ViewGroup.MarginLayoutParams) r10).topMargin = 0;
        r2 = r10;
    L27:
        r3.setLayoutParams(r2);
        return;
    L24:
        r10 = null;
    L20:
        r9 = null;
        goto L22
    L48:
        return;
    L47:
        return;
    L11:
        r7 = false;
    L28:
        LarusLayoutSlidesDetailFragmentBinding r11 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r11 == null) goto L50;
        FrameLayout r4 = r11.l;
        if (r4 == null) goto L51;
        if (r11 == null) goto L35;
        if (r4 == null) goto L35;
        ViewGroup.LayoutParams r12 = r4.getLayoutParams();
    L37:
        if ((r12 instanceof ConstraintLayout.LayoutParams) == false) goto L39;
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) r12;
    L40:
        if (r13 == null) goto L45;
        FragmentActivity r14 = getActivity();
        if (r14 == null) goto L44;
        r0 = com.larus.utils.u.c(r14);
    L44:
        ((ViewGroup.MarginLayoutParams) r13).topMargin = r0;
        r2 = r13;
    L45:
        r4.setLayoutParams(r2);
        return;
    L39:
        r13 = null;
    L35:
        r12 = null;
        goto L37
    L51:
        return;
    L50:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        la0();
    }

    @Override // vw9.b
    public final void onCotInfoUpdate(ic8.t r12) {
        Intrinsics.checkNotNullParameter(r12, "cotInfo");
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = r12;
        this.M = r12;
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("onCotInfoUpdate cotInfo: title=");
        ic8.t r3 = this.M;
        if (r3 == null) goto L5;
        String r4 = r3.b;
    L6:
        r2.append(r4);
        r2.append(" headerStatus=");
        ic8.t r5 = this.M;
        if (r5 == null) goto L9;
        Integer r6 = Integer.valueOf(r5.f);
    L10:
        r2.append(r6);
        r2.append(" curCotRefArtifacts=");
        ic8.t r7 = this.M;
        if (r7 == null) goto L16;
        Map r8 = r7.e;
        if (r8 == null) goto L16;
        String r9 = (String) r8.get("cot_ref_artifacts");
        if (r9 == null) goto L16;
    L17:
        r2.append(r9);
        r1.d("SlidesFragment", r2.toString());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new AnonymousClass1(r12, this, r0, null), 2, null);
        return;
    L16:
        r9 = "";
        goto L17
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public final void onCreate(Bundle r3) {
        super/*com.larus.trace.tracknode.TraceFragment*/.onCreate(r3);
        int r4 = ww9.a.b;
        ww9.a.a = System.currentTimeMillis();
        t r5 = new t(this);
        AppHost.a.a().j(r5);
        this.L = r5;
    }

    private final void va0(boolean r5, String r6) {
        if (r5 == true) goto L4;
    L8:
        boolean r0 = false;
    L9:
        if (r0 == false) goto L15;
        LarusLayoutSlidesDetailFragmentBinding r1 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r1 == null) goto L20;
        FrameLayout r2 = r1.f;
        if (r2 == null) goto L20;
        e1.x(r2);
    L20:
        ym9.c r3 = com.larus.office.base.service.m.a("default_doc_logic_key");
        if (r3 == null) goto L23;
        r3.onEditPanelActive(r0);
    L23:
        ym9.c r4 = com.larus.office.base.service.m.a("default_doc_logic_key");
        if (r4 == null) goto L26;
        r4.onEditPanelHeightChanged(200);
    L26:
        FLogger r7 = FLogger.a;
        r7.i("SlidesFragment", "updateEditPanelHeight, isActive:" + r0);
        r7.d("SlidesFragment", "updateChatInputVisibility,isLandscapeMode:" + this.E + ", isVisible:" + r5 + ", from:" + r6);
        return;
    L15:
        LarusLayoutSlidesDetailFragmentBinding r8 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r8 == null) goto L20;
        FrameLayout r9 = r8.f;
        if (r9 == null) goto L20;
        e1.o(r9);
        goto L20
    L4:
        if (this.E == true) goto L8;
        if (ra0() == false) goto L8;
        r0 = true;
        goto L9
    }

    public final void D8(String r3, String r4) {
        Fragment r0 = ((OfficeBaseFragment) this).f;
        if (r0 == null) goto L10;
        t1a.b r1 = s1a.a.g(r0);
        if (r1 == null) goto L11;
        va8.k0 r2 = r1.getAbility(va8.k0.class);
        if (r2 == null) goto L12;
        r2.D8(r3, r4);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final ViewBinding Z90(LayoutInflater r23, ViewGroup r24) {
        Intrinsics.checkNotNullParameter(r23, "inflater");
        ConstraintLayout r0 = r23.inflate(2131562890, r24, false);
        int r1 = 2131365538;
        View r4 = ViewBindings.findChildViewById(r0, 2131365538);
        if (r4 == null) goto L43;
        r1 = 2131369315;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131369315);
        if (r5 == null) goto L43;
        r1 = 2131373339;
        View r6 = ViewBindings.findChildViewById(r0, 2131373339);
        if (r6 == null) goto L43;
        r1 = 2131374318;
        CotHeaderView r7 = ViewBindings.findChildViewById(r0, 2131374318);
        if (r7 == null) goto L43;
        r1 = 2131386895;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131386895);
        if (r8 == null) goto L43;
        r1 = 2131386902;
        SlidesLoadLayout r9 = (SlidesLoadLayout) ViewBindings.findChildViewById(r0, 2131386902);
        if (r9 == null) goto L43;
        r1 = 2131386903;
        FrameLayout r10 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131386903);
        if (r10 == null) goto L43;
        r1 = 2131386910;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131386910);
        if (r11 == null) goto L43;
        r1 = 2131386911;
        ConstraintLayout r12 = ViewBindings.findChildViewById(r0, 2131386911);
        if (r12 == null) goto L43;
        r1 = 2131386912;
        ImageView r13 = (ImageView) ViewBindings.findChildViewById(r0, 2131386912);
        if (r13 == null) goto L43;
        r1 = 2131386913;
        if (((ImageView) ViewBindings.findChildViewById(r0, 2131386913)) == null) goto L43;
        r1 = 2131386914;
        FrameLayout r14 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131386914);
        if (r14 == null) goto L43;
        r1 = 2131386915;
        NovaTitleBarEx r15 = ViewBindings.findChildViewById(r0, 2131386915);
        if (r15 == null) goto L43;
        r1 = 2131386916;
        ImageView r16 = (ImageView) ViewBindings.findChildViewById(r0, 2131386916);
        if (r16 == null) goto L43;
        r1 = 2131386917;
        ImageView r17 = (ImageView) ViewBindings.findChildViewById(r0, 2131386917);
        if (r17 == null) goto L43;
        r1 = 2131386918;
        ImageView r18 = (ImageView) ViewBindings.findChildViewById(r0, 2131386918);
        if (r18 == null) goto L43;
        r1 = 2131386919;
        TextView r19 = (TextView) ViewBindings.findChildViewById(r0, 2131386919);
        if (r19 == null) goto L43;
        r1 = 2131386920;
        TextView r20 = (TextView) ViewBindings.findChildViewById(r0, 2131386920);
        if (r20 == null) goto L43;
        r1 = 2131386921;
        ImageView r21 = (ImageView) ViewBindings.findChildViewById(r0, 2131386921);
        if (r21 == null) goto L43;
        return new LarusLayoutSlidesDetailFragmentBinding(r0, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        Bundle r4 = getArguments();
        String r5 = "";
        if (r4 == null) goto L5;
        r4.getString("cot_ref_artifacts", "");
    L5:
        Bundle r6 = getArguments();
        if (r6 == null) goto L11;
        String r7 = r6.getString("artifact_meta_id", "");
        if (r7 == null) goto L11;
        r5 = r7;
    L11:
        this.F = r5;
        LarusLayoutSlidesDetailFragmentBinding r8 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r8 == null) goto L16;
        CotHeaderView r9 = r8.e;
        if (r9 == null) goto L16;
        e1.d(r9, new q(this));
    L16:
        la0();
        if (ra0() == true) goto L24;
        LarusLayoutSlidesDetailFragmentBinding r10 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r10 == null) goto L25;
        FrameLayout r11 = r10.f;
        if (r11 == null) goto L26;
        e1.o(r11);
        return;
    L26:
        return;
    L25:
        return;
    }

    public static final /* synthetic */ void ka0(SlidesFragment r0, boolean r1, String r2) {
        r0.va0(r1, r2);
    }

    public static Unit ea0(SlidesFragment r86, ConstraintLayout r87, Function1 r88, ot8.a r89) {
        Intrinsics.checkNotNullParameter(r89, "item");
        int r2 = r89.getId();
        String r79 = "";
        if (r2 != 2131899603) goto L27;
        HashMap<String, Boolean> r3 = zw9.c.a;
        FragmentActivity r4 = r86.getActivity();
        String r14 = r86.j;
        Object r5 = by7.h.a(r86).getParams().get("previous_page");
        if ((r5 instanceof String) == false) goto L7;
        String r41 = (String) r5;
    L8:
        Bundle r6 = r86.getArguments();
        if (r6 == null) goto L11;
        String r53 = r6.getString("aippt_task_id");
    L12:
        String r7 = r86.j;
        int r57 = r86.pa0();
        String r8 = r86.F;
        String r11 = r86.G;
        String r63 = r86.oa0();
        String r9 = r86.k;
        String r83 = "history_version";
        String r10 = r41;
        kw9.j r15 = new kw9.j(r14, new com.larus.bmhome.share.panel.h(null, null, r10, "aippt_new_detail", null, null, r11, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r8, 9, null, null, null, null, null, null, null, null, null, null, null, r53, r7, null, r7, Integer.valueOf(r57), "aippt_new", null, null, null, null, r63, null, null, null, r86.l, r9, null, null, false, null, null, null, null, -153, -567804001, 1017), 26);
        String r12 = r86.p;
        if (r12 != null) goto L15;
        String r13 = "";
    L16:
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r13, "title");
        if (r4 == null) goto L25;
        FLogger r16 = FLogger.a;
        r16.i("SlidesOpManager", "[showSharePanel]");
        if (Intrinsics.areEqual(zw9.c.b, Boolean.FALSE) == false) goto L24;
        r16.i("SlidesOpManager", "modify to public when first share");
        String r17 = r15.a;
        if (r17 == null) goto L24;
        zw9.c.c(r17, true, new zw9.a(), new zw9.b());
    L24:
        ShareServiceDelegate.b.c(new kw9.i(r4, new com.larus.bmhome.share.panel.b(null, null, zw9.c.c + r15.a, null, null, null, null, r13, null, null, null, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67108731), r15));
    L25:
        String r18 = "share";
    L26:
        String r19 = r18;
    L63:
        com.larus.bmhome.view.screenmenu.d r20 = com.larus.bmhome.view.screenmenu.d.a;
        com.larus.bmhome.view.screenmenu.d.b(r87);
        if (Intrinsics.areEqual(r19, r83) == false) goto L66;
        String r21 = "history";
    L67:
        if (r88 == null) goto L69;
        r88.invoke(r21);
    L69:
        int r1 = ww9.a.b;
        JSONObject r110 = r86.t9();
        Intrinsics.checkNotNullParameter(r110, "extParams");
        tx9.u0.h(false, null, null, null, null, null, "more", r19, null, r110, 1854);
        return Unit.INSTANCE;
    L66:
        r21 = r19;
        goto L67
    L15:
        r13 = r12;
        goto L16
    L11:
        r53 = null;
        goto L12
    L7:
        r41 = null;
        goto L8
    L27:
        r83 = "history_version";
        if (r2 != 2131909772) goto L60;
        IFlowSdkDepend r22 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r22 == null) goto L32;
        r22.D0();
        b1.a.c("office_ppt_detail_download");
    L32:
        HashMap<String, Boolean> r23 = zw9.c.a;
        String r24 = r86.j;
        Object r25 = by7.h.a(r86).getParams().get("previous_page");
        if ((r25 instanceof String) == false) goto L35;
        String r111 = (String) r25;
    L36:
        String r112 = r86.F;
        String r113 = r86.m;
        Bundle r26 = r86.getArguments();
        if (r26 == null) goto L39;
        String r114 = r26.getString("aippt_task_id");
    L40:
        String r115 = r86.j;
        Integer r116 = Integer.valueOf(r86.n);
        String r27 = r86.G;
        if (r27 != null) goto L43;
        String r117 = "";
    L44:
        String r28 = r86.o;
        if (r28 != null) goto L47;
        String r29 = "";
    L48:
        String r30 = r86.w;
        if (r30 != null) goto L51;
        String r210 = "";
    L52:
        Bundle r31 = r86.getArguments();
        if (r31 == null) goto L58;
        String r32 = r31.getString("section_id");
        if (r32 == null) goto L58;
        r79 = r32;
    L58:
        zw9.c.d(r86, new kw9.h(r24, "aippt_new_detail", r111, r112, r113, 9, r114, r115, r115, r116, false, "aippt_new", "self", r117, r29, r210, r79, r86.oa0(), r86.k, r86.l, 1024));
        r18 = "download";
        goto L26
    L51:
        r210 = r30;
        goto L52
    L47:
        r29 = r28;
        goto L48
    L43:
        r117 = r27;
        goto L44
    L39:
        r114 = null;
        goto L40
    L35:
        r111 = null;
        goto L36
    L60:
        if (r2 != 2131899561) goto L62;
        r19 = r83;
        goto L63
    L62:
        r19 = "";
        goto L63
    }

    public final void F8(String r12, String r13, String r14, String r15) {
        String r0 = "";
        if (r13 != null) goto L5;
        String r1 = "";
    L6:
        this.m = r1;
        if (r12 != null) goto L9;
        String r2 = "";
    L10:
        this.F = r2;
        if (r14 == null) goto L14;
        r0 = r14;
    L14:
        this.o = r0;
        this.G = r15;
        this.J.complete(r15);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new SlidesFragment$updateArtifactInfo$1(this, r14, r12, r13, r15, null), 2, null);
        return;
    L9:
        r2 = r12;
        goto L10
    L5:
        r1 = r13;
        goto L6
    }
}
