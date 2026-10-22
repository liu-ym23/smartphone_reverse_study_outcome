package com.larus.uaigc.creation.detail.image;

import android.R;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.bigimg.AwemeImageFilter;
import com.larus.bmhome.bigimg.ImageAuthException;
import com.larus.bmhome.bigimg.aibeautify.CommonAiBeautifyLayout;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.bigimg.u1;
import com.larus.bmhome.bigimg.widget.BottomCreationEditView;
import com.larus.bmhome.bigimg.widget.LeftCreationEditView;
import com.larus.bmhome.bigimg.widget.NumericIndicator;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.search.SourceFrom;
import com.larus.bmhome.common_ui.image.ImageAdapter;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.tipoff.TipOffDialogParams;
import com.larus.bmhome.view.CreationOperateContainerView;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.fragment.helper.EditPanelType;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.home.impl.sdk.b1;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.PublisherTrackParams;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.e0;
import com.larus.platform.service.i2;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import com.larus.uaigc.creation.ChatCreationPagerFragment;
import com.larus.uaigc.impl.databinding.LarusBigImageDetailLayoutBinding;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import hq9.v1;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;
import tx9.e2;
import tx9.o0;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 £\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004¢\u0001£\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010H\u001a\u00020I2\f\u00102\u001a\b\u0012\u0004\u0012\u00020100J\b\u0010J\u001a\u00020IH\u0002J\b\u0010K\u001a\u00020IH\u0002J\b\u0010L\u001a\u00020IH\u0002J\u001a\u0010M\u001a\u00020I2\u0006\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\b\u0010R\u001a\u00020IH\u0002J\b\u0010S\u001a\u00020IH\u0002J\b\u0010T\u001a\u00020#H\u0002J\u0010\u0010U\u001a\u0004\u0018\u00010VH\u0082@¢\u0006\u0002\u0010WJ\b\u0010X\u001a\u00020IH\u0002J\b\u0010Y\u001a\u00020IH\u0002J\b\u0010Z\u001a\u000209H\u0016J\u0018\u0010[\u001a\u00020I2\u0006\u0010\\\u001a\u00020.2\u0006\u0010]\u001a\u000209H\u0016J\b\u0010^\u001a\u00020#H\u0016J\b\u0010_\u001a\u00020`H\u0016J\u0012\u0010a\u001a\u00020I2\b\u0010b\u001a\u0004\u0018\u00010OH\u0002J\u0010\u0010c\u001a\u00020I2\u0006\u0010\\\u001a\u00020.H\u0002J\u0016\u0010d\u001a\u00020I2\u0006\u0010e\u001a\u00020#H\u0082@¢\u0006\u0002\u0010fJ\u0018\u0010g\u001a\u0002092\b\u0010h\u001a\u0004\u0018\u000109H\u0082@¢\u0006\u0002\u0010iJ\u001a\u0010j\u001a\u0004\u0018\u00010k2\b\u0010h\u001a\u0004\u0018\u000109H\u0082@¢\u0006\u0002\u0010iJ\b\u0010l\u001a\u00020IH\u0002J\b\u0010m\u001a\u00020IH\u0016J\b\u0010n\u001a\u00020.H\u0002J\b\u0010o\u001a\u00020IH\u0016J\b\u0010p\u001a\u00020IH\u0002J\u0012\u0010q\u001a\u00020I2\b\u0010h\u001a\u0004\u0018\u000109H\u0002J\b\u0010r\u001a\u000209H\u0002J\u0006\u0010s\u001a\u000209J\u0006\u0010t\u001a\u000209J\u000e\u0010u\u001a\u00020IH\u0082@¢\u0006\u0002\u0010WJ$\u0010v\u001a\u00020I2\b\u0010h\u001a\u0004\u0018\u0001092\b\u0010]\u001a\u0004\u0018\u0001092\u0006\u0010w\u001a\u00020#H\u0002J\u000f\u0010x\u001a\u0004\u0018\u00010.H\u0016¢\u0006\u0002\u00107J\b\u0010y\u001a\u00020IH\u0016J\b\u0010z\u001a\u00020IH\u0002J\b\u0010{\u001a\u00020#H\u0002J\b\u0010|\u001a\u00020#H\u0002J\b\u0010}\u001a\u00020IH\u0002J\u0010\u0010~\u001a\u00020I2\u0006\u0010\u007f\u001a\u000209H\u0002J\u001e\u0010\u0080\u0001\u001a\u00020I2\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u000209H\u0002J\u0013\u0010\u0084\u0001\u001a\u00020I2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\u0013\u0010\u0085\u0001\u001a\u00020I2\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0016J\t\u0010\u0088\u0001\u001a\u00020IH\u0016J\u0012\u0010\u0089\u0001\u001a\u00020I2\u0007\u0010\u008a\u0001\u001a\u000209H\u0002J\u0012\u0010\u008b\u0001\u001a\u00020I2\u0007\u0010\u008c\u0001\u001a\u000209H\u0002J\u001d\u0010\u008d\u0001\u001a\u00020I2\u0006\u0010\u007f\u001a\u0002092\n\b\u0002\u0010h\u001a\u0004\u0018\u000109H\u0002J\u001d\u0010\u008e\u0001\u001a\u00020I2\u0006\u0010\u007f\u001a\u0002092\n\b\u0002\u0010h\u001a\u0004\u0018\u000109H\u0002J\u0017\u0010\u008f\u0001\u001a\u00030\u0090\u00012\u000b\b\u0002\u0010\u0091\u0001\u001a\u0004\u0018\u000109H\u0002J\u0011\u0010\u0092\u0001\u001a\u0004\u0018\u000109*\u0004\u0018\u000109H\u0002J\u0011\u0010\u0093\u0001\u001a\u00020I2\u0006\u0010N\u001a\u00020OH\u0002JH\u0010\u0094\u0001\u001a\u00020I2\u0014\u0010\u0095\u0001\u001a\u000f\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020I0\u0096\u00012\u0017\u0010\u0097\u0001\u001a\u0012\u0012\u0007\u0012\u0005\u0018\u00010\u0082\u0001\u0012\u0004\u0012\u00020I0\u0096\u00012\u000e\u0010\u0098\u0001\u001a\t\u0012\u0004\u0012\u00020I0\u0099\u0001H\u0002J\t\u0010\u009a\u0001\u001a\u00020IH\u0002J\t\u0010\u009b\u0001\u001a\u00020IH\u0002J\t\u0010\u009c\u0001\u001a\u00020IH\u0016J\t\u0010\u009d\u0001\u001a\u000209H\u0002J\t\u0010\u009e\u0001\u001a\u00020IH\u0016J\u0012\u0010\u009f\u0001\u001a\u00020I2\u0007\u0010 \u0001\u001a\u00020.H\u0016J\t\u0010¡\u0001\u001a\u00020IH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010*R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R*\u00102\u001a\b\u0012\u0004\u0012\u000201002\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0016\u00105\u001a\u0004\u0018\u00010.8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u00108\u001a\u0002098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0016\u0010<\u001a\u0004\u0018\u0001098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010;R\u0016\u0010>\u001a\u0004\u0018\u0001098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010;R\u0014\u0010@\u001a\u00020#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010AR\u001b\u0010D\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010,\u001a\u0004\bD\u0010AR\u001b\u0010F\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010,\u001a\u0004\bF\u0010A¨\u0006¤\u0001"}, d2 = {"Lcom/larus/uaigc/creation/detail/image/BigImageDetailFragment;", "Lcom/larus/uaigc/creation/detail/image/AbsBigImageDetailFragment;", "Lcom/larus/common_ui/fragment/helper/IContainerFunctionInterface;", "Lcom/larus/uaigc/creation/detail/ability/ICreationPublishAbility;", "Lcom/larus/platform/api/creation/ICreationListener;", "<init>", "()V", "download", "Lcom/larus/bmhome/bigimg/download/CommonDownLoadLayout;", "backIcon", "Landroid/widget/ImageView;", "aiBeautify", "Lcom/larus/bmhome/bigimg/aibeautify/CommonAiBeautifyLayout;", "sourceLayout", "Landroid/view/ViewGroup;", "sourceIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "sourceText", "Landroid/widget/TextView;", "indicator", "titleBar", "addButton", "Landroid/widget/Button;", "privacyContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "publishContainer", "privacyText", "bottomToolsContainer", "bottomCreationEditView", "Lcom/larus/bmhome/bigimg/widget/BottomCreationEditView;", "creationContainerView", "Lcom/larus/bmhome/view/CreationOperateContainerView;", "startTime", "", "loaded", "", "filtered", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "awemeImageFilter", "Lcom/larus/bmhome/bigimg/AwemeImageFilter;", "getAwemeImageFilter", "()Lcom/larus/bmhome/bigimg/AwemeImageFilter;", "awemeImageFilter$delegate", "Lkotlin/Lazy;", "latestCreationPrivateStatus", "", "value", "Lcom/larus/uaigc/bean/chat/ImageDetailFragmentProp;", "Lcom/larus/bmhome/creation/bean/ImageContent;", "property", "getProperty", "()Lcom/larus/uaigc/bean/chat/ImageDetailFragmentProp;", "creationType", "getCreationType", "()Ljava/lang/Integer;", "creationKey", "", "getCreationKey", "()Ljava/lang/String;", "creationTaskId", "getCreationTaskId", "creationIndex", "getCreationIndex", "isBlockContent", "()Z", "canPublish", "getCanPublish", "isShowBottomCreateView", "isShowBottomCreateView$delegate", "isShowLeftCreateView", "isShowLeftCreateView$delegate", "initFragment", "", "dismissExtraView", "showExtraView", "showOrDismissExtraView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "prefetchToCreationBitmapCache", "initView", "isByPublisher", "getPublisherCreation", "Lcom/larus/platform/api/creation/PublisherCreation;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initButtonClickListener", "publishCreation", "curCreationKey", "updateCurrentCreationButtonStatus", "status", "creationId", "showEditPanel", "editPanelType", "Lcom/larus/common_ui/fragment/helper/EditPanelType;", "openPrivacyDialog", "containerView", "refreshButtonStatus", "setCreationPrivacy", "private", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestCreationId", "messageId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestUserCreation", "Lcom/larus/platform/api/creation/UserCreationFromIM;", "deleteCreation", "onResume", "getCreateCreationSource", "onScroll", "reportImageEditFunctionShow", "reportPicClickAddCreation", "getSubType", "getItemName", "getCurrentStatus", "addCreation", "reportPicAddCreation", "success", "getExtraViewLayout", "onDestroyView", "initIconListeners", "shouldShowCreationDialogOnShare", "shouldShowCreationDialogOnDownload", "onDownloadAction", "saveBitmapWithCheckWatermark", "imageUrl", "onCheckImageAuthDeny", "error", "", "methodTag", "onCreate", "onPublishSuccess", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "onDestroy", "onDoShareAction", "source", "showCreationShare", "enterFrom", "shareImage", "saveImage", "transToSharePanelEventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "currentPage", "validTrackValue", "onOpenImageSourceAction", "tryCheckImageAuthWithWatermark", "onGranted", "Lkotlin/Function1;", "onDeny", "defaultAction", "Lkotlin/Function0;", "updateIconStatus", "updateImageSource", "dismissFragment", "getCreationTypeString", "onShareClick", "onDoCreationAction", "action", "onSelected", "ImageShareCallback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class BigImageDetailFragment extends AbsBigImageDetailFragment implements g19.a, oz9.a, zp9.r {
    public static final /* synthetic */ int I = 0;
    public boolean A;
    public boolean B;
    public final CoroutineScope C;
    public final Lazy D;
    public int E;
    public iy9.a<zo8.b> F;
    public final Lazy G;
    public final Lazy H;
    public CommonDownLoadLayout o;
    public ImageView p;
    public CommonAiBeautifyLayout q;
    public ViewGroup r;
    public SimpleDraweeView s;
    public TextView t;
    public ViewGroup u;
    public ConstraintLayout v;
    public ViewGroup w;
    public ConstraintLayout x;
    public BottomCreationEditView y;
    public CreationOperateContainerView z;

    public static final class a {
    }

    public static final class b implements com.larus.bmhome.share.panel.d {
        public final String a;

        public final boolean d(String r1, String r2, Boolean r3) {
            return true;
        }

        public final void f() {
        }

        public final void onDismiss() {
        }

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "messageId");
            this.a = r2;
        }

        public final void e(Function0<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
        }

        public final boolean b(Context r22, DialogFragment r23, View r24, jr9.a r25) {
            Intrinsics.checkNotNullParameter(r25, "shareItemConfig");
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L34
            if (Intrinsics.areEqual(r25.b(), "report") == false) goto L30;
            IAIChatService.Companion r1 = IAIChatService.a;     // Catch: Throwable -> L34
            String r5 = this.a;     // Catch: Throwable -> L32
            Intrinsics.checkNotNullParameter(r5, "entityId");     // Catch: Throwable -> L32
            TipOffDialogParams r15 = new TipOffDialogParams(2, r5, null, null, "", "", 0, null, null, null, null, null, null, null, null);     // Catch: Throwable -> L32
            r15.g = 0;     // Catch: Throwable -> L32
            Fragment r2 = r1.g8(r15);     // Catch: Throwable -> L32
            if (r23 == null) goto L20;
            FragmentManager r3 = r23.getParentFragmentManager();     // Catch: Throwable -> L32
            if (r3 == null) goto L20;
            if ((r2 instanceof Fragment) == false) goto L14;
            Fragment r4 = r2;
        L15:
            LandscapeRestrictionOperation r6 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L32
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, null, r6);     // Catch: Throwable -> L32
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r4, r6) == true) goto L20;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L41 Throwable -> L32
        L19:
            r2.show(r3, null);     // Catch: Throwable -> L32
            goto L20
        L14:
            r4 = null;
        L20:
            if (r23 == null) goto L49;
            r23.dismiss();     // Catch: Exception -> L23 Throwable -> L32
        L51:
            return true;
        L23:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Throwable -> L32
            Throwable r7 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L32
            if (r7 == null) goto L50;
            com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L32
            return true;
        L50:
            return true;
        L49:
            return true;
        L30:
            Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L32
        L37:
            Throwable r9 = Result.exceptionOrNull-impl(r8);
            if (r9 == null) goto L40;
            FLogger.a.e("BigImagePhotoViewer", "save image error state ", r9);
        L40:
            return false;
        L32:
            th = th;
        L36:
            Result.Companion r10 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
        L34:
            th = th;
            goto L36
        }
    }

    static {
    }

    public final void Oh() {
    }

    public final boolean dc() {
        return true;
    }

    public final void o1() {
    }

    public BigImageDetailFragment() {
        this.C = CoroutineScopeKt.MainScope();
        this.D = LazyKt.lazy(new c());
        this.E = 2;
        this.F = new iy9.a(null, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, false, 0, false, null, 134217727);
        this.G = LazyKt.lazy(new n(this));
        this.H = LazyKt.lazy(new s(this));
    }

    public final String Y90() {
        zo8.b r0 = (zo8.b) CollectionsKt.firstOrNull(this.F.a);
        if (r0 == null) goto L5;
        String r1 = qz9.a.a(r0);
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String Z90() {
        zo8.b r0 = (zo8.b) CollectionsKt.firstOrNull(this.F.a);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    public final Integer aa0() {
        ChatCreationPagerFragment r1 = getParentFragment();
        PublisherCreation r3 = null;
        if ((r1 instanceof ChatCreationPagerFragment) == false) goto L5;
        ChatCreationPagerFragment r2 = r1;
    L6:
        if (r2 == null) goto L22;
        String r4 = Y90();
        String r5 = this.F.C;
        Intrinsics.checkNotNullParameter(r4, "creationKey");
        Intrinsics.checkNotNullParameter(r5, "creationId");
        Map<String, UserCreationFromIM> r6 = r2.k;
        if (r6 == null) goto L17;
        UserCreationFromIM r7 = r6.get(r4);
        if (r7 == null) goto L17;
        if (Intrinsics.areEqual(r7.getCreationId(), r5) == true) goto L15;
        r7 = null;
    L15:
        if (r7 == null) goto L17;
        r3 = PublisherCreation.copy$default(zp9.x.a(r7), null, null, null, r2.p.k, null, null, null, null, null, false, null, null, null, null, 16375, null);
    L17:
        if (r3 == null) goto L22;
        Integer r8 = r3.getCreationType();
        if (r8 == null) goto L22;
        return r8;
    L22:
        return this.F.q;
    L5:
        r2 = null;
        goto L6
    }

    public final String ca0() {
        int r0 = this.F.B;
        if (r0 != 1) goto L5;
        return "-1";
    L5:
        if (r0 != 2) goto L7;
        return "0";
    L7:
        if (r0 == 3) goto L9;
        return "";
    L9:
        return "1";
    }

    public final void d70() {
        ia0("detail_click");
    }

    public final String da0() {
        int r0 = this.F.B;
        if (r0 != 1) goto L5;
        return "go_public";
    L5:
        if (r0 != 2) goto L7;
        return "go_public";
    L7:
        if (r0 == 3) goto L9;
        return "";
    L9:
        return "already_public";
    }

    public final boolean ga0() {
        boolean r0 = z2.a.getCreationPublishConfig().b();
        FLogger.a.i("BigImagePhotoViewer", "isByPublisher enableEnterPublisher:" + r0);
        return r0;
    }

    public final void ja0() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L5;
        r0.D0();
        b1.a.c("office_task_generate_image_download");
    L5:
        z2 r1 = z2.a;
        v1 r2 = r1.getCreationShareSettings().a();
        if (r2 != null) goto L8;
    L10:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L40;
        v1 r4 = r1.getCreationShareSettings().a();
        if (r4 != null) goto L16;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == false) goto L26;
        Integer r6 = aa0();
        if (r6 != null) goto L24;
    L36:
        boolean r7 = true;
    L38:
        if (r7 == false) goto L40;
        boolean r8 = true;
    L41:
        FragmentActivity r9 = null;
        if (r8 == false) goto L44;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new BigImageDetailFragment$showCreationShare$1(this, "download", null), 3, null);
        return;
    L44:
        com.larus.platform.service.o r10 = com.larus.platform.service.o.a;
        JSONObject r11 = this.F.o;
        if (r11 == null) goto L75;
        Integer r12 = aa0();
        if (r12 != null) goto L50;
    L52:
        int r13 = 0;
    L53:
        r11.put("is_image_edit", r13);
        r11.put("click_from", "click_download");
        r11.put("click_method", "detail_click");
        Integer r14 = aa0();
        if (r14 != null) goto L57;
    L59:
        int r15 = 0;
    L60:
        r11.put("is_replica_gen", r15);
        r11.put("is_ai_creation", 1);
        ImageAdapter r16 = this.d;
        if (r16 == null) goto L67;
        List r17 = r16.b;
        if (r17 == null) goto L67;
        n1 r18 = (n1) ListProtector.get(r17, 0);
        if (r18 == null) goto L67;
        String r19 = r18.e;
    L68:
        if (r19 != null) goto L70;
    L73:
        int r20 = 1;
    L74:
        r11.put("has_original_image", 1 ^ r20);
        r11.put("download_method", "click_icon");
        r11.put("is_search_card", 0);
        r11.put("creation_id", this.F.C);
        Unit r21 = Unit.INSTANCE;
    L76:
        r10.reportEvent("picture_download", r11);
        ImageAdapter r22 = this.d;
        if (r22 == null) goto L97;
        Uri r23 = r22.z2(0);
        if (r23 == null) goto L99;
        final String r24 = r23.toString();
        IFlowSdkDepend r25 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r25 == null) goto L85;
        r25.D0();
        b1.a.d(r24);
    L85:
        if (Build.VERSION.SDK_INT <= 29) goto L87;
    L94:
        pa0(new p(this), new q(this), new r(r24, this));
        return;
    L87:
        if (ContextCompat.checkSelfPermission(requireContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L94;
        Context r26 = getContext();
        if ((r26 instanceof FragmentActivity) == false) goto L91;
        r9 = (FragmentActivity) r26;
    L91:
        if (r9 != null) goto L93;
        return;
    L93:
        i2.b.a(r9, CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE"), new i(this, r24));
        return;
    L99:
        return;
    L97:
        return;
    L70:
        if (StringsKt.isBlank(r19) == true) goto L73;
        r20 = 0;
    L67:
        r19 = null;
        goto L68
    L57:
        if (r14.intValue() != 3) goto L59;
        r15 = 1;
        goto L60
    L50:
        if (r12.intValue() != 4) goto L52;
        r13 = 1;
        goto L53
    L75:
        r11 = null;
        goto L76
    L24:
        if (r6.intValue() != 3) goto L36;
    L37:
        r7 = false;
        goto L38
    L26:
        Integer r27 = aa0();
        if (r27 != null) goto L30;
    L31:
        Integer r28 = aa0();
        if (r28 == null) goto L36;
        if (r28.intValue() == 2) goto L37;
    L30:
        if (r27.intValue() == 3) goto L37;
    L16:
        if (r4.f() != true) goto L18;
        r5 = true;
    L40:
        r8 = false;
        goto L41
    L8:
        if (r2.b() != true) goto L10;
        r3 = true;
        goto L12
    }

    public final void la0() {
        int r0 = this.F.B;
        if (r0 != 1) goto L5;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new BigImageDetailFragment$publishCreation$1(this, null), 3, null);
        return;
    L5:
        if (r0 != 2) goto L11;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new BigImageDetailFragment$publishCreation$2(this, null), 3, null);
        return;
    }

    public final boolean na0() {
        z2 r0 = z2.a;
        v1 r1 = r0.getCreationShareSettings().a();
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L37;
        v1 r3 = r0.getCreationShareSettings().a();
        if (r3 != null) goto L12;
    L14:
        boolean r4 = false;
    L16:
        if (r4 == false) goto L23;
        Integer r5 = aa0();
        if (r5 != null) goto L21;
    L22:
        boolean r6 = true;
    L35:
        if (r6 == false) goto L37;
        return true;
    L21:
        if (r5.intValue() != 3) goto L22;
    L34:
        r6 = false;
        goto L35
    L23:
        Integer r7 = aa0();
        if (r7 != null) goto L27;
    L28:
        Integer r8 = aa0();
        if (r8 == null) goto L22;
        if (r8.intValue() == 2) goto L34;
    L27:
        if (r7.intValue() == 3) goto L34;
    L12:
        if (r3.f() != true) goto L14;
        r4 = true;
    L37:
        return false;
    L5:
        if (r1.e() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void oa0() {
        View r0 = this.j;
        if (r0 == null) goto L5;
        ViewExtKt.d(r0);
    L5:
        ChatCreationPagerFragment r1 = getParentFragment();
        if ((r1 instanceof ChatCreationPagerFragment) == false) goto L8;
        ChatCreationPagerFragment r2 = r1;
    L9:
        if (r2 == null) goto L33;
        LarusBigImageDetailLayoutBinding r3 = r2.i;
        if (r3 == null) goto L17;
        NumericIndicator r4 = r3.d;
        if (r4 == null) goto L17;
        if (r4.getVisibility() != 4) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == false) goto L24;
        LarusBigImageDetailLayoutBinding r6 = r2.i;
        if (r6 == null) goto L24;
        NumericIndicator r7 = r6.d;
        if (r7 == null) goto L24;
        ViewExtKt.d(r7);
    L24:
        r2.ha0();
        if (r2.ra0() == false) goto L31;
        LarusBigImageDetailLayoutBinding r8 = r2.i;
        if (r8 == null) goto L34;
        LeftCreationEditView r9 = r8.b;
        if (r9 == null) goto L35;
        ViewExtKt.d(r9);
        return;
    L35:
        return;
    L34:
        return;
    L31:
        r2.la0();
        return;
    L17:
        r5 = false;
        goto L18
    L33:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final void qa0() {
        ChatCreationPagerFragment r1 = null;
        if (this.A == true) goto L5;
    L21:
        CommonDownLoadLayout r0 = this.o;
        if (r0 == null) goto L24;
        r0.setLayoutEnable(false);
    L24:
        CommonAiBeautifyLayout r2 = this.q;
        if (r2 == null) goto L27;
        r2.setLayoutEnable(false);
    L27:
        BottomCreationEditView r3 = this.y;
        if (r3 == null) goto L30;
        r3.setLayoutEnable(false);
    L30:
        Fragment r4 = getParentFragment();
        if ((r4 instanceof ChatCreationPagerFragment) == false) goto L33;
        r1 = (ChatCreationPagerFragment) r4;
    L33:
        if (r1 == null) goto L38;
        r1.Z90(false);
        return;
    L38:
        return;
    L5:
        if (this.B == true) goto L21;
        CommonDownLoadLayout r5 = this.o;
        if (r5 == null) goto L10;
        r5.setLayoutEnable(true);
    L10:
        CommonAiBeautifyLayout r6 = this.q;
        if (r6 == null) goto L13;
        r6.setLayoutEnable(true);
    L13:
        BottomCreationEditView r7 = this.y;
        if (r7 == null) goto L16;
        r7.setLayoutEnable(true);
    L16:
        Fragment r8 = getParentFragment();
        if ((r8 instanceof ChatCreationPagerFragment) == false) goto L19;
        r1 = (ChatCreationPagerFragment) r8;
    L19:
        if (r1 == null) goto L36;
        r1.Z90(true);
        return;
    }

    public final void u() {
        if (((Boolean) this.H.getValue()).booleanValue() == false) goto L20;
        ic8.d r0 = this.F.r;
        if (r0.a == false) goto L7;
        r0.c.invoke(null);
    L7:
        ic8.d r1 = this.F.t;
        if (r1.a == false) goto L10;
        r1.c.invoke(null);
    L10:
        ic8.d r2 = this.F.u;
        if (r2.a == false) goto L13;
        r2.c.invoke(null);
    L13:
        ic8.d r3 = this.F.v;
        if (r3.a == false) goto L16;
        r3.c.invoke(null);
    L16:
        ic8.d r4 = this.F.s;
        if (r4.a == false) goto L21;
        r4.c.invoke(null);
        return;
    L21:
        return;
    }

    @Override // com.larus.uaigc.creation.detail.image.AbsBigImageDetailFragment
    public final Integer T90() {
        return 2131562747;
    }

    @Override // oz9.a
    public final String YE() {
        return Y90();
    }

    public final String ba0() {
        Integer r0 = aa0();
        if (r0 != null) goto L6;
    L7:
        if (r0 != null) goto L10;
    L12:
        if (r0 != null) goto L15;
    L17:
        return "replica";
    L15:
        if (r0.intValue() != 4) goto L17;
        return "image_edit";
    L10:
        if (r0.intValue() != 5) goto L12;
    L18:
        return "pic";
    L6:
        if (r0.intValue() == 2) goto L18;
        goto L7
    }

    public final void onDestroy() {
        super.onDestroy();
        e0.a.c1(this);
    }

    @Override // com.larus.uaigc.creation.detail.image.AbsBigImageDetailFragment
    public final void onDestroyView() {
        super.onDestroyView();
        CoroutineScopeKt.cancel$default(this.C, null, 1, null);
    }

    @Override // com.larus.uaigc.creation.detail.image.AbsBigImageDetailFragment
    public final void onResume() {
        super.onResume();
        FrameLayout r0 = this.i;
        if (r0 == null) goto L5;
        r0.postDelayed(new y(this), 500);
    L5:
        CommonAiBeautifyLayout r1 = this.q;
        boolean r2 = false;
        if (r1 == null) goto L14;
        if (r1.getVisibility() != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 != true) goto L14;
        r2 = true;
        goto L14
    L10:
        r3 = false;
    L14:
        if (r2 == false) goto L16;
    L19:
        this.F.r.c.invoke(null);
    L21:
        if (this.F.s.a == true) goto L23;
        return;
    L23:
        if (((Boolean) this.G.getValue()).booleanValue() == false) goto L27;
        this.F.s.c.invoke(null);
        return;
    L27:
        return;
    L16:
        if (this.F.r.a == false) goto L21;
        if (((Boolean) this.G.getValue()).booleanValue() == false) goto L21;
        goto L19
    }

    public final EditPanelType SQ() {
        return EditPanelType.IMAGE;
    }

    public final void VT() {
        oa0();
    }

    public static String ra0(String r2) {
        if (r2 == null) goto L11;
        boolean r1 = true;
        if ((!StringsKt.isBlank(r2)) == true) goto L6;
    L8:
        r1 = false;
    L9:
        if (r1 == false) goto L11;
        return r2;
    L6:
        if (Intrinsics.areEqual(r2, "null") == true) goto L8;
    L11:
        return null;
    }

    public final void FU(int r11) {
        Integer r2 = null;
        if (r11 != 1) goto L5;
        Function1 r12 = this.F.s.b;
        ImageAdapter r3 = this.d;
        if (r3 == null) goto L102;
        Uri r4 = r3.A2(this.l);
        if (r4 == null) goto L102;
        String r5 = r4.toString();
    L103:
        if (r5 != null) goto L105;
        String r6 = "";
    L106:
        n1 r1 = (n1) CollectionsKt.firstOrNull(this.F.f);
        if (r1 == null) goto L111;
        Long r7 = r1.f;
        if (r7 == null) goto L111;
        Integer r8 = Integer.valueOf((int) r7.longValue());
    L112:
        n1 r9 = (n1) CollectionsKt.firstOrNull(this.F.f);
        if (r9 == null) goto L117;
        Long r10 = r9.g;
        if (r10 == null) goto L117;
        r2 = Integer.valueOf((int) r10.longValue());
    L117:
        r12.invoke(new ic8.f(r6, null, null, r8, r2, 38));
        return;
    L111:
        r8 = null;
        goto L112
    L105:
        r6 = r5;
    L102:
        r5 = null;
        goto L103
    L5:
        if (r11 != 2) goto L7;
        Function1 r13 = this.F.r.b;
        ImageAdapter r14 = this.d;
        if (r14 == null) goto L81;
        Uri r15 = r14.A2(this.l);
        if (r15 == null) goto L81;
        String r16 = r15.toString();
    L82:
        if (r16 != null) goto L84;
        String r17 = "";
    L85:
        n1 r18 = (n1) CollectionsKt.firstOrNull(this.F.f);
        if (r18 == null) goto L90;
        Long r19 = r18.f;
        if (r19 == null) goto L90;
        Integer r20 = Integer.valueOf((int) r19.longValue());
    L91:
        n1 r21 = (n1) CollectionsKt.firstOrNull(this.F.f);
        if (r21 == null) goto L96;
        Long r22 = r21.g;
        if (r22 == null) goto L96;
        r2 = Integer.valueOf((int) r22.longValue());
    L96:
        r13.invoke(new ic8.f(r17, null, null, r20, r2, 38));
        return;
    L90:
        r20 = null;
        goto L91
    L84:
        r17 = r16;
    L81:
        r16 = null;
        goto L82
    L7:
        if (r11 != 3) goto L9;
        Function1 r110 = this.F.t.b;
        ImageAdapter r23 = this.d;
        if (r23 == null) goto L60;
        Uri r24 = r23.A2(this.l);
        if (r24 == null) goto L60;
        String r25 = r24.toString();
    L61:
        if (r25 != null) goto L63;
        String r26 = "";
    L64:
        n1 r27 = (n1) CollectionsKt.firstOrNull(this.F.f);
        if (r27 == null) goto L69;
        Long r28 = r27.f;
        if (r28 == null) goto L69;
        Integer r29 = Integer.valueOf((int) r28.longValue());
    L70:
        n1 r30 = (n1) CollectionsKt.firstOrNull(this.F.f);
        if (r30 == null) goto L75;
        Long r31 = r30.g;
        if (r31 == null) goto L75;
        r2 = Integer.valueOf((int) r31.longValue());
    L75:
        r110.invoke(new ic8.f(r26, null, null, r29, r2, 38));
        return;
    L69:
        r29 = null;
        goto L70
    L63:
        r26 = r25;
    L60:
        r25 = null;
        goto L61
    L9:
        if (r11 != 4) goto L11;
        Function1 r111 = this.F.v.b;
        ImageAdapter r32 = this.d;
        if (r32 == null) goto L39;
        Uri r33 = r32.A2(this.l);
        if (r33 == null) goto L39;
        String r34 = r33.toString();
    L40:
        if (r34 != null) goto L42;
        String r35 = "";
    L43:
        n1 r36 = (n1) CollectionsKt.firstOrNull(this.F.f);
        if (r36 == null) goto L48;
        Long r37 = r36.f;
        if (r37 == null) goto L48;
        Integer r38 = Integer.valueOf((int) r37.longValue());
    L49:
        n1 r39 = (n1) CollectionsKt.firstOrNull(this.F.f);
        if (r39 == null) goto L54;
        Long r40 = r39.g;
        if (r40 == null) goto L54;
        r2 = Integer.valueOf((int) r40.longValue());
    L54:
        r111.invoke(new ic8.f(r35, null, null, r38, r2, 38));
        return;
    L48:
        r38 = null;
        goto L49
    L42:
        r35 = r34;
    L39:
        r34 = null;
        goto L40
    L11:
        if (r11 != 5) goto L123;
        Function1 r112 = this.F.u.b;
        ImageAdapter r41 = this.d;
        if (r41 == null) goto L18;
        Uri r42 = r41.A2(this.l);
        if (r42 == null) goto L18;
        String r43 = r42.toString();
    L19:
        if (r43 != null) goto L21;
        String r44 = "";
    L22:
        n1 r45 = (n1) CollectionsKt.firstOrNull(this.F.f);
        if (r45 == null) goto L27;
        Long r46 = r45.f;
        if (r46 == null) goto L27;
        Integer r47 = Integer.valueOf((int) r46.longValue());
    L28:
        n1 r48 = (n1) CollectionsKt.firstOrNull(this.F.f);
        if (r48 == null) goto L33;
        Long r49 = r48.g;
        if (r49 == null) goto L33;
        r2 = Integer.valueOf((int) r49.longValue());
    L33:
        r112.invoke(new ic8.f(r44, null, null, r47, r2, 38));
        return;
    L27:
        r47 = null;
        goto L28
    L21:
        r44 = r43;
    L18:
        r43 = null;
        goto L19
    }

    @Override // zp9.r
    public final void X0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "creationId");
    }

    @Override // zp9.r
    public final void bZ(UserCreation r4) {
        Intrinsics.checkNotNullParameter(r4, "userCreation");
        String r0 = r4.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r0, this.F.C) == false) goto L9;
        FLogger.a.d("BigImagePhotoViewer", "onPublishSuccess, creationId: " + r4.a);
        ma0(3);
        return;
    }

    public final Object fa0(Continuation<? super PublisherCreation> r41) {
        if ((r41 instanceof BigImageDetailFragment$getPublisherCreation$1) == false) goto L7;
        BigImageDetailFragment$getPublisherCreation$1 r2 = (BigImageDetailFragment$getPublisherCreation$1) r41;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        boolean r6 = true;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L17:
        UserCreationFromIM r7 = (UserCreationFromIM) r1;
        Long r8 = null;
        if (r7 == null) goto L20;
        PublisherCreation r9 = zp9.x.a(r7);
    L21:
        if (r9 != null) goto L23;
        r9 = new PublisherCreation(this.F.C, null, null, null, null, null, null, null, null, false, null, null, null, null, 16382, null);
    L23:
        PublisherCreation r23 = r9;
        Integer r10 = r23.getCreationType();
        FLogger.a.i("BigImagePhotoViewer", "originCreationType:" + r10 + ' ');
        ImageAdapter r11 = this.d;
        if (r11 == null) goto L28;
        Uri r12 = r11.A2(this.l);
        if (r12 == null) goto L28;
        String r29 = r12.toString();
    L29:
        iy9.a<zo8.b> r13 = this.F;
        String r14 = r13.k;
        String r15 = r13.D;
        if (r15 == null) goto L32;
        Integer r31 = StringsKt.toIntOrNull(r15);
    L33:
        if (r10 != null) goto L35;
        r10 = aa0();
    L35:
        Integer r25 = r10;
        Integer r16 = this.F.q;
        String r17 = r23.getTaskId();
        if (r17 != null) goto L39;
        r17 = "";
    L39:
        if (r17.length() == 0) goto L42;
        r6 = false;
    L42:
        if (r6 == false) goto L44;
        r17 = Z90();
    L44:
        String r32 = r17;
        zo8.b r18 = (zo8.b) CollectionsKt.firstOrNull(this.F.a);
        if (r18 == null) goto L49;
        String r19 = r18.g;
        if (r19 == null) goto L49;
        Long r35 = StringsKt.toLongOrNull(r19);
    L50:
        zo8.b r20 = (zo8.b) CollectionsKt.firstOrNull(this.F.a);
        if (r20 == null) goto L56;
        String r21 = r20.h;
        if (r21 == null) goto L56;
        r8 = StringsKt.toLongOrNull(r21);
    L56:
        return PublisherCreation.copy$default(r23, null, r25, r16, r14, null, r29, null, r31, r32, false, null, r35, r8, null, 9809, null);
    L49:
        r35 = null;
        goto L50
    L32:
        r31 = null;
    L28:
        r29 = null;
        goto L29
    L20:
        r9 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        String r22 = this.F.k;
        r2.label = 1;
        r1 = ea0(r22, r2);
        if (r1 != r4) goto L17;
        return r4;
    L7:
        r2 = new BigImageDetailFragment$getPublisherCreation$1(this, r41);
        goto L8
    }

    public final void ia0(String r11) {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L5;
        r0.D0();
        b1.a.c("office_task_generate_image_share");
    L5:
        iy9.a<zo8.b> r1 = this.F;
        if (r1.z == false) goto L14;
        t19.s r12 = t19.s.a;
        Context r2 = getContext();
        Context r3 = getContext();
        if (r3 == null) goto L11;
        String r4 = r3.getString(2131909395);
        if (r4 == null) goto L11;
    L12:
        r12.getClass();
        t19.s.t(r2, r4);
        return;
    L11:
        r4 = "";
        goto L12
    L14:
        ShareServiceDelegate r5 = ShareServiceDelegate.b;
        JSONObject r6 = r1.o;
        if (r6 == null) goto L31;
        r6.put("click_method", r11);
        Integer r13 = aa0();
        int r7 = 1;
        if (r13 != null) goto L20;
    L22:
        int r14 = 0;
    L23:
        r6.put("is_replica_gen", r14);
        Integer r15 = aa0();
        if (r15 != null) goto L27;
    L29:
        r7 = 0;
    L30:
        r6.put("is_image_edit", r7);
        r6.put("share_content", "picture");
    L32:
        r5.w(r6);
        if (this.A == true) goto L35;
        return;
    L35:
        if (this.B == false) goto L38;
        return;
    L38:
        if (na0() == false) goto L40;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new BigImageDetailFragment$showCreationShare$1(this, "share", null), 3, null);
        return;
    L40:
        ImageAdapter r16 = this.d;
        if (r16 == null) goto L49;
        Uri r17 = r16.z2(0);
        if (r17 == null) goto L51;
        final String r18 = r17.toString();
        pa0(new v(this), new w(this), new x(r18, this));
        return;
    L51:
        return;
    L49:
        return;
    L27:
        if (r15.intValue() != 4) goto L29;
    L20:
        if (r13.intValue() != 3) goto L22;
        r14 = 1;
        goto L23
    L31:
        r6 = null;
        goto L32
    }

    public final void ka0(View r46) {
        final View r1 = r46;
        ArrayList r3 = new ArrayList();
        r3.add(new l0(2131899197, 2131899197, null, null, null, 2131103136, null, 2131240225, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127));
        Context r4 = getContext();
        if (r4 != null) goto L5;
        return;
    L5:
        View r2 = CreateMenu.f(new CreateMenu(r4), r3, 0, false, null, null, null, null, new j(this, r1), 510);
        com.larus.bmhome.view.screenmenu.d r12 = com.larus.bmhome.view.screenmenu.d.a;
        if (r1 != null) goto L11;
        FrameLayout r5 = this.i;
        if (r5 == null) goto L10;
        View r13 = r5;
    L12:
        Balloon r6 = com.larus.bmhome.view.screenmenu.d.a(r12, r13, r2, false, null, null, null, null, 124);
        ViewGroup.LayoutParams r7 = r2.getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
    L16:
        if (r8 == null) goto L19;
        r8.setMarginEnd((-i5.T()) + i5.h());
    L19:
        if (r1 != null) goto L24;
        r1 = this.i;
        if (r1 != null) goto L24;
        return;
    L24:
        r6.v(r1, i5.Q(), i5.E());
        return;
    L15:
        r8 = null;
        goto L16
    L10:
        return;
    L11:
        r13 = r1;
        goto L12
    }

    public final void ma0(int r5) {
        int r1 = 0;
        if (com.larus.bmhome.utils.u.h() == true) goto L5;
    L9:
        boolean r0 = false;
    L10:
        CreationOperateContainerView r2 = this.z;
        if (r2 == null) goto L16;
        if (r0 == false) goto L14;
        int r3 = r5;
    L15:
        r2.r1(r3);
        goto L16
    L14:
        r3 = 0;
    L16:
        BottomCreationEditView r4 = this.y;
        if (r4 == null) goto L21;
        if (r0 == false) goto L20;
        r1 = r5;
    L20:
        r4.r1(r1);
    L21:
        this.F.B = r5;
        return;
    L5:
        if (AccountService.a.isLogin().booleanValue() == false) goto L9;
        if (this.F.x == true) goto L9;
        r0 = true;
        goto L10
    }

    @Override // com.larus.uaigc.creation.detail.image.AbsBigImageDetailFragment
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        if (z2.a.getCreationPublishConfig().b() == false) goto L5;
        e0.a.e1(this);
    L5:
        this.E = this.F.B;
    }

    @Override // zp9.r
    public final void yE(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object U90(BigImageDetailFragment r43, Continuation r44) {
        r43.getClass();
        if ((r44 instanceof BigImageDetailFragment$addCreation$1) == false) goto L7;
        BigImageDetailFragment$addCreation$1 r2 = (BigImageDetailFragment$addCreation$1) r44;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        Continuation r15 = null;
        String r7 = "recommend_from";
        Continuation r6 = "";
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L19;
        if (r4 == 2) goto L18;
        if (r4 == 3) goto L17;
        if (r4 != 4) goto L16;
        int r5 = r2.I$0;
        zp9.a r8 = (zp9.a) r2.L$0;
        ResultKt.throwOnFailure(r1);
        r6 = "";
        r7 = "recommend_from";
        Object r22 = "template_rec_req_id";
        r15 = r15;
        boolean r9 = true;
    L83:
        String r10 = r43.F.k;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new BigImageDetailFragment$reportPicAddCreation$1(r10, false, r6, r15), 3, null);
        int r11 = r5;
        zp9.a r13 = r8;
    L126:
        if (r13 != null) goto L128;
    L130:
        r9 = false;
    L131:
        if (r9 == false) goto L137;
        if (r13 == null) goto L136;
        UserCreation r14 = r13.b;
        if (r14 == null) goto L136;
        Continuation r26 = r14.a;
    L138:
        String r27 = r43.Z90();
        String r16 = r43.F.k;
        String r29 = r43.ba0();
        if (r11 != 2) goto L141;
        String r17 = "0";
    L142:
        String r31 = r17;
        uo8.k r18 = r43.F.c;
        if (r18 == null) goto L147;
        Map r19 = r18.a;
        if (r19 == null) goto L147;
        Object r110 = r19.get(r7);
    L148:
        String r32 = String.valueOf(r110);
        uo8.k r20 = r43.F.c;
        if (r20 == null) goto L153;
        Map r21 = r20.a;
        if (r21 == null) goto L153;
        Object r111 = r21.get("from_template_id");
    L154:
        String r33 = String.valueOf(r111);
        uo8.k r23 = r43.F.c;
        if (r23 == null) goto L159;
        Map r24 = r23.a;
        if (r24 == null) goto L159;
        Object r112 = r24.get("template_rec_extra");
    L160:
        String r35 = String.valueOf(r112);
        uo8.k r0 = r43.F.c;
        if (r0 == null) goto L165;
        Map r25 = r0.a;
        if (r25 == null) goto L165;
        Object r113 = r25.get(r22);
    L166:
        e2.a.b(new o0("picture_detail", "chat", r26, r27, r16, r29, "-1", r31, r32, r33, String.valueOf(r113), r35, null, null, null, null, null, null, 516097), r15, 3);
        return Unit.INSTANCE;
    L165:
        r113 = r15;
    L159:
        r112 = r15;
    L153:
        r111 = r15;
    L147:
        r110 = r15;
        goto L148
    L141:
        r17 = "1";
    L136:
        r26 = r15;
        goto L138
    L137:
        r26 = r6;
        goto L138
    L128:
        if (r13.a != r9) goto L130;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        int r28 = r2.I$1;
        r11 = r2.I$0;
        ResultKt.throwOnFailure(r1);
        int r30 = r28;
        r22 = "template_rec_req_id";
        Object r34 = r1;
        r9 = true;
    L72:
        r13 = (zp9.a) r34;
        if (r13 != null) goto L75;
    L77:
        boolean r36 = false;
    L78:
        if (r36 == true) goto L84;
        MainCoroutineDispatcher r37 = Dispatchers.getMain();
        BigImageDetailFragment$addCreation$3 r38 = new BigImageDetailFragment$addCreation$3(r43, r13, r15);
        r2.L$0 = r13;
        r2.I$0 = r11;
        r2.label = 4;
        if (BuildersKt.withContext(r37, r38, r2) == r12) goto L172;
        r8 = r13;
        r5 = r11;
        goto L83
    L172:
        return r12;
    L84:
        String r39 = r43.F.k;
        if (r13 == null) goto L89;
        UserCreation r40 = r13.b;
        if (r40 == null) goto L89;
        String r114 = r40.a;
    L90:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new BigImageDetailFragment$reportPicAddCreation$1(r39, r9, r114, r15), 3, null);
        t19.s r41 = t19.s.a;
        Context r42 = r43.getContext();
        Context r45 = r43.getContext();
        if (r45 == null) goto L96;
        Resources r46 = r45.getResources();
        if (r46 == null) goto L96;
        String r47 = r46.getString(2131900634);
        String r48 = r47;
        if (r47 == null) goto L96;
    L97:
        r41.getClass();
        t19.s.p(r42, r48);
        r43.E = r30;
        iy9.a<zo8.b> r49 = r43.F;
        if (r13 == null) goto L103;
        UserCreation r50 = r13.b;
        if (r50 == null) goto L103;
        String r51 = r50.a;
        String r52 = r51;
        if (r51 == null) goto L103;
    L104:
        r49.getClass();
        Intrinsics.checkNotNullParameter(r52, "<set-?>");
        r49.C = r52;
        ChatCreationPagerFragment r53 = r43.getParentFragment();
        if ((r53 instanceof ChatCreationPagerFragment) == false) goto L107;
        ChatCreationPagerFragment r115 = r53;
    L108:
        if (r115 == 0) goto L126;
        String r54 = r43.Y90();
        if (r13 == null) goto L115;
        UserCreation r55 = r13.b;
        if (r55 == null) goto L115;
        Object r56 = r55.a;
        if (r56 == null) goto L115;
    L116:
        Intrinsics.checkNotNullParameter(r54, "creationKey");
        Intrinsics.checkNotNullParameter(r56, "creationId");
        Map<String, UserCreationFromIM> r57 = r115.k;
        if (r57 == null) goto L122;
        UserCreationFromIM r58 = r57.get(r54);
        if (r58 == null) goto L122;
        UserCreationFromIM r210 = r58;
    L123:
        String r211 = r56;
        UserCreationFromIM r59 = UserCreationFromIM.copy$default(r210, r211, null, Integer.valueOf(r11), null, null, null, null, 122, null);
        Map<String, UserCreationFromIM> r60 = r115.k;
        if (r60 == null) goto L126;
        r60.put(r54, r59);
    L122:
        r210 = new UserCreationFromIM(null, null, null, null, null, null, null, 127, null);
    L115:
        r56 = r6;
        goto L116
    L107:
        r115 = r15;
    L103:
        r52 = r6;
    L96:
        r48 = r6;
    L89:
        r114 = r15;
        goto L90
    L75:
        if (r13.a != r9) goto L77;
        r36 = true;
        goto L78
    L18:
        int r61 = r2.I$1;
        int r62 = r2.I$0;
        PublisherCreation r63 = (PublisherCreation) r2.L$0;
        ResultKt.throwOnFailure(r1);
        int r64 = r61;
        PublisherCreation r65 = r63;
        int r66 = r62;
    L42:
        String r67 = r43.F.k;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new BigImageDetailFragment$reportPicClickAddCreation$1(r67, r43, r15), 3, null);
        e0 r68 = e0.a;
        String r69 = r43.F.k;
        if (r69 != null) goto L45;
        r69 = "";
    L45:
        Integer r116 = r43.aa0();
        if (r116 != null) goto L49;
    L51:
        Integer r117 = r43.aa0();
        if (r117 != null) goto L55;
    L57:
        int r118 = 2;
    L58:
        String r119 = r43.F.D;
        String r120 = r43.Z90();
        zo8.b r121 = (zo8.b) CollectionsKt.firstOrNull(r43.F.a);
        if (r121 == null) goto L61;
        boolean r122 = r121.f;
    L62:
        if (r122 == false) goto L64;
        int r123 = 4;
    L65:
        if (r65 == null) goto L67;
        Continuation r212 = r65.getMaterialId();
    L68:
        r2.L$0 = r15;
        r2.I$0 = r66;
        r2.I$1 = r64;
        r2.label = 3;
        int r213 = r66;
        int r124 = r64;
        r22 = "template_rec_req_id";
        r9 = true;
        r34 = r68.l(r69, r118, r119, r213, r120, r123, r212, r2);
        if (r34 == r12) goto L171;
        r30 = r124;
        r11 = r213;
        goto L72
    L171:
        return r12;
    L67:
        r212 = r15;
        goto L68
    L64:
        r123 = 1;
        goto L65
    L61:
        r122 = false;
        goto L62
    L55:
        if (r117.intValue() != 4) goto L57;
        r118 = 4;
        goto L58
    L49:
        if (r116.intValue() != 3) goto L51;
        r118 = 3;
        goto L58
    L19:
        ResultKt.throwOnFailure(r1);
    L23:
        PublisherCreation r70 = (PublisherCreation) r1;
        if (r43.ga0() == false) goto L38;
        new u1();
        uo8.k r71 = r43.F.c;
        if (r71 == null) goto L30;
        Map r72 = r71.a;
        if (r72 == null) goto L30;
        Object r73 = r72.get("recommend_from");
    L31:
        String r74 = String.valueOf(r73);
        uo8.k r75 = r43.F.c;
        if (r75 == null) goto L36;
        Map r76 = r75.a;
        if (r76 == null) goto L36;
        Object r77 = r76.get("template_rec_req_id");
    L37:
        u1.a(r70, new PublisherTrackParams("picture_detail", r74, String.valueOf(r77)));
        FLogger.a.i("BigImagePhotoViewer", "addCreation gotoPublisher");
        String r78 = r43.F.k;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new BigImageDetailFragment$reportPicClickAddCreation$1(r78, r43, r15), 3, null);
        return Unit.INSTANCE;
    L36:
        r77 = r15;
    L30:
        r73 = r15;
        goto L31
    L38:
        MainCoroutineDispatcher r79 = Dispatchers.getMain();
        BigImageDetailFragment$addCreation$2 r80 = new BigImageDetailFragment$addCreation$2(r43, 3, r15);
        r2.L$0 = r70;
        r2.I$0 = 1;
        r2.I$1 = 3;
        r2.label = 2;
        if (BuildersKt.withContext(r79, r80, r2) == r12) goto L170;
        r65 = r70;
        r64 = 3;
        r66 = 1;
        goto L42
    L170:
        return r12;
    L20:
        ResultKt.throwOnFailure(r1);
        r2.label = 1;
        r1 = r43.fa0(r2);
        if (r1 != r12) goto L23;
        return r12;
    L7:
        r2 = new BigImageDetailFragment$addCreation$1(r43, r44);
        goto L8
    }

    public static final com.larus.bmhome.share.panel.h X90(BigImageDetailFragment r77, String r78) {
        JSONObject r10 = r77.F.o;
        Integer r1 = r77.aa0();
        if (r1 != null) goto L6;
    L8:
        boolean r12 = false;
    L9:
        String r9 = r77.F.k;
        Integer r13 = r77.aa0();
        String r27 = AccountService.a.getUserId();
        uo8.k r2 = r77.F.c;
        String r3 = null;
        if (r2 == null) goto L14;
        Map r4 = r2.a;
        if (r4 == null) goto L14;
        Object r5 = r4.get("message");
    L16:
        if ((r5 instanceof Message) == false) goto L18;
        Message r41 = (Message) r5;
    L19:
        String r0 = r77.F.C;
        if (r10 == null) goto L22;
        String r6 = r10.optString("template_rec_req_id");
    L23:
        String r17 = ra0(r6);
        if (r10 == null) goto L26;
        String r7 = r10.optString("template_rec_extra");
    L27:
        String r18 = ra0(r7);
        if (r10 == null) goto L30;
        String r8 = r10.optString("from_template_id");
    L31:
        String r19 = ra0(r8);
        if (r10 == null) goto L35;
        r3 = r10.optString("recommend_from");
    L35:
        return new com.larus.bmhome.share.panel.h(null, null, null, r78, null, null, r9, r10, null, r12, r13, null, null, null, r17, r18, r19, ra0(r3), null, null, null, null, null, null, r27, null, null, null, null, null, null, null, null, null, null, null, null, null, r41, null, null, r0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -68098449, -4353, 1023);
    L30:
        r8 = null;
        goto L31
    L26:
        r7 = null;
        goto L27
    L22:
        r6 = null;
        goto L23
    L18:
        r41 = null;
    L14:
        r5 = null;
        goto L16
    L6:
        if (r1.intValue() != 3) goto L8;
        r12 = true;
        goto L9
    }

    @Override // oz9.a
    public final void C80(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "creationId");
        iy9.a<zo8.b> r0 = this.F;
        r0.B = r2;
        this.E = r2;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.C = r3;
        ma0(this.F.B);
    }

    public final Object ea0(String r6, Continuation<? super UserCreationFromIM> r7) {
        if ((r7 instanceof BigImageDetailFragment$getLatestUserCreation$1) == false) goto L7;
        BigImageDetailFragment$getLatestUserCreation$1 r0 = (BigImageDetailFragment$getLatestUserCreation$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r4 = "";
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L30:
        String r9 = (String) r8;
        if (r9 == null) goto L34;
        r4 = r9;
    L34:
        Map<String, UserCreationFromIM> r10 = DataConverterKt.d(r4);
        LinkedHashMap r11 = (LinkedHashMap) r10;
        return r11.get(Y90());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        if (r6 != null) goto L17;
    L20:
        boolean r12 = true;
    L21:
        if (r12 == false) goto L24;
        return null;
    L24:
        IChatRepoService r13 = RepoDispatcherDelegate.b.e();
        if (r6 != null) goto L27;
        r6 = "";
    L27:
        r0.label = 1;
        r8 = r13.w1(r6, r0);
        if (r8 != r2) goto L30;
        return r2;
    L17:
        if (r6.length() == 0) goto L20;
        r12 = false;
    L7:
        r0 = new BigImageDetailFragment$getLatestUserCreation$1(this, r7);
        goto L8
    }

    public final void ha0(Throwable r3, String r4) {
        if ((r3 instanceof ImageAuthException) == true) goto L10;
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder();
        r1.append(r4);
        r1.append(" onDeny called, error msg: ");
        if (r3 == null) goto L7;
        String r5 = r3.getMessage();
    L8:
        r1.append(r5);
        r0.e("BigImagePhotoViewer", r1.toString());
        return;
    L7:
        r5 = null;
        goto L8
    L10:
        int r6 = ((ImageAuthException) r3).getCode();
        if (r6 != (-3)) goto L13;
        t19.s r7 = t19.s.a;
        Application r8 = AppHost.a.getApplication();
        r7.getClass();
        t19.s.b(r8, 2131908080, false);
        return;
    L13:
        if (r6 != (-2)) goto L15;
    L17:
        this.B = true;
        qa0();
        t19.s r9 = t19.s.a;
        Application r10 = AppHost.a.getApplication();
        r9.getClass();
        t19.s.b(r10, 2131906509, false);
        return;
    L15:
        if (r6 == (-1)) goto L17;
    }

    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super.onViewCreated(r14, r15);
        iy9.a<zo8.b> r16 = this.F;
        if (r16.b != r16.i) goto L5;
        FLogger.a.i("BigImagePhotoViewer", "onViewCreate duration" + (System.currentTimeMillis() - this.F.y));
    L5:
        FrameLayout r17 = this.i;
        ChatCreationPagerFragment r18 = null;
        if (r17 == null) goto L8;
        CommonDownLoadLayout r19 = (CommonDownLoadLayout) r17.findViewById(2131370179);
    L9:
        this.o = r19;
        FrameLayout r110 = this.i;
        if (r110 == null) goto L12;
        ImageView r111 = (ImageView) r110.findViewById(2131363762);
    L13:
        this.p = r111;
        FrameLayout r112 = this.i;
        if (r112 == null) goto L16;
        CommonAiBeautifyLayout r113 = (CommonAiBeautifyLayout) r112.findViewById(2131362380);
    L17:
        this.q = r113;
        boolean r0 = true;
        if (this.F.r.a == false) goto L29;
        Integer r114 = aa0();
        if (r114 == null) goto L25;
        if (r114.intValue() == 1) goto L29;
    L25:
        if (((Boolean) this.H.getValue()).booleanValue() == true) goto L29;
        CommonAiBeautifyLayout r115 = this.q;
        if (r115 == null) goto L32;
        e1.x(r115);
    L32:
        ImageView r116 = this.p;
        if (r116 == null) goto L35;
        r116.setVisibility(8);
    L35:
        FrameLayout r117 = this.i;
        if (r117 == null) goto L38;
        ViewGroup r118 = (ViewGroup) r117.findViewById(2131387007);
    L39:
        this.r = r118;
        FrameLayout r119 = this.i;
        if (r119 == null) goto L44;
        ImageView r120 = (ImageView) r119.findViewById(2131387009);
        if (r120 == null) goto L44;
        r120.setImageResource(com.larus.bmhome.bigimg.f.a());
    L44:
        FrameLayout r121 = this.i;
        if (r121 == null) goto L47;
        SimpleDraweeView r122 = (SimpleDraweeView) r121.findViewById(2131387008);
    L48:
        this.s = r122;
        FrameLayout r123 = this.i;
        if (r123 == null) goto L51;
        TextView r124 = (TextView) r123.findViewById(2131387011);
    L52:
        this.t = r124;
        FrameLayout r125 = this.i;
        if (r125 == null) goto L55;
        TextView r126 = (TextView) r125.findViewById(2131375226);
    L57:
        if (this.F.h == false) goto L60;
        if (r126 == null) goto L60;
        StringBuilder r1 = new StringBuilder();
        r1.append(this.F.i + 1);
        r1.append('/');
        r1.append(this.F.j);
        r126.setText(r1.toString());
    L60:
        com.larus.bmhome.bigimg.l r127 = this.F.w;
        boolean r2 = false;
        if (r127 == null) goto L118;
        String r3 = r127.g;
        if (r3 != null) goto L65;
    L68:
        boolean r4 = true;
    L69:
        if (r4 == false) goto L79;
        String r5 = r127.f;
        if (r5 != null) goto L73;
    L76:
        boolean r6 = true;
    L77:
        if (r6 == false) goto L79;
    L73:
        if (r5.length() == 0) goto L76;
        r6 = false;
    L79:
        ViewGroup r7 = this.r;
        if (r7 == null) goto L82;
        e1.x(r7);
    L82:
        String r8 = r127.f;
        if (r8 != null) goto L85;
    L88:
        boolean r9 = true;
    L89:
        if (r9 == false) goto L93;
        TextView r10 = this.t;
        if (r10 == null) goto L99;
        e1.q(r10);
    L99:
        String r11 = r127.g;
        if (r11 != null) goto L102;
    L105:
        if (r0 == false) goto L109;
        SimpleDraweeView r128 = this.s;
        if (r128 == null) goto L121;
        e1.q(r128);
    L121:
        FrameLayout r129 = this.i;
        if (r129 == null) goto L124;
        ViewGroup r130 = (ViewGroup) r129.findViewById(2131388775);
    L125:
        this.u = r130;
        if (r130 == null) goto L128;
        r130.setBackgroundResource(R.color.transparent);
    L128:
        FrameLayout r131 = this.i;
        if (r131 == null) goto L131;
        Button r132 = (Button) r131.findViewById(2131362233);
    L131:
        RecyclerView r133 = this.h;
        if (r133 == null) goto L138;
        ViewGroup.LayoutParams r12 = r133.getLayoutParams();
        if (r12 == null) goto L137;
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r12;
        i0.a.getClass();
        r13.bottomMargin = ((((i0.e() + i5.h()) + i5.c0()) + i5.h()) - i0.g()) / 2;
        r133.setLayoutParams(r13);
        goto L138
    L137:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L138:
        FrameLayout r134 = this.i;
        if (r134 == null) goto L141;
        ConstraintLayout r135 = (ConstraintLayout) r134.findViewById(2131383028);
    L142:
        this.v = r135;
        FrameLayout r136 = this.i;
        if (r136 == null) goto L145;
        ViewGroup r137 = (ViewGroup) r136.findViewById(2131383424);
    L146:
        this.w = r137;
        FrameLayout r138 = this.i;
        if (r138 == null) goto L149;
        CreationOperateContainerView r139 = (CreationOperateContainerView) r138.findViewById(2131368277);
    L150:
        this.z = r139;
        if (r139 == null) goto L153;
        r139.setByPublisher(ga0());
    L153:
        zo8.b r140 = (zo8.b) CollectionsKt.firstOrNull(this.F.a);
        if (r140 == null) goto L156;
        r2 = r140.e;
    L156:
        if (r2 == true) goto L160;
        CreationOperateContainerView r141 = this.z;
        if (r141 == null) goto L160;
        e1.o(r141);
    L160:
        FrameLayout r142 = this.i;
        if (r142 == null) goto L163;
        TextView r143 = (TextView) r142.findViewById(2131383046);
    L163:
        FrameLayout r144 = this.i;
        if (r144 == null) goto L166;
        ConstraintLayout r145 = (ConstraintLayout) r144.findViewById(2131364437);
    L167:
        this.x = r145;
        if (r145 == null) goto L170;
        i0.a.getClass();
        int r20 = i0.e() + i5.h();
        int r21 = r145.getPaddingStart();
        int r22 = r145.getPaddingTop();
        int r23 = r145.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r145.getClass().getSimpleName() + ",source:,start:" + r21 + ",top:" + r22 + ",end:" + r23 + ",bottom:" + r20);
        r145.setPaddingRelative(r21, r22, r23, r20);
    L170:
        FrameLayout r146 = this.i;
        if (r146 == null) goto L173;
        BottomCreationEditView r147 = (BottomCreationEditView) r146.findViewById(2131364544);
    L174:
        this.y = r147;
        if (r147 == null) goto L178;
        i0.a.getClass();
        int r24 = i0.e() + i5.h();
        int r25 = r147.getPaddingStart();
        int r26 = r147.getPaddingTop();
        int r27 = r147.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:BottomCreationEditView,source:,start:" + r25 + ",top:" + r26 + ",end:" + r27 + ",bottom:" + r24);
        r147.setPaddingRelative(r25, r26, r27, r24);
    L178:
        if (na0() == false) goto L181;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new BigImageDetailFragment$prefetchToCreationBitmapCache$1(this, null), 3, null);
    L181:
        if (((Boolean) this.G.getValue()).booleanValue() == false) goto L195;
        ConstraintLayout r148 = this.x;
        if (r148 == null) goto L185;
        e1.o(r148);
    L185:
        BottomCreationEditView r149 = this.y;
        if (r149 == null) goto L188;
        e1.x(r149);
    L188:
        BottomCreationEditView r28 = this.y;
        if (r28 == null) goto L201;
        CoroutineScope r29 = this.C;
        ImageAdapter r150 = this.d;
        if (r150 == null) goto L193;
        Uri r151 = r150.z2(this.l);
    L194:
        String r30 = String.valueOf(r151);
        iy9.a<zo8.b> r152 = this.F;
        r28.T5(r29, r30, r152.B, new a0(this), r152.s.a, r152.r.a);
        goto L201
    L193:
        r151 = null;
    L201:
        ViewGroup r153 = this.u;
        if (r153 == null) goto L204;
        i0.a.getClass();
        int r31 = i0.g();
        int r32 = r153.getPaddingStart();
        int r33 = r153.getPaddingEnd();
        int r34 = r153.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + r153.getClass().getSimpleName() + ",source:,start:" + r32 + ",top:" + r31 + ",end:" + r33 + ",bottom:" + r34);
        r153.setPaddingRelative(r32, r31, r33, r34);
    L204:
        e1.d(this.v, new t(this));
        e1.d(this.w, new u(this));
        ma0(this.F.B);
        ImageAdapter r154 = this.d;
        if (r154 == null) goto L211;
        Uri r155 = r154.z2(this.l);
        if (r155 == null) goto L211;
        CommonDownLoadLayout r35 = this.o;
        if (r35 == null) goto L211;
        r35.S5(this.C, new com.larus.bmhome.bigimg.download.d.a(r155.toString()));
    L211:
        CommonDownLoadLayout r156 = this.o;
        if (r156 == null) goto L215;
        e1.d(r156, new z(this));
    L215:
        if (AppHost.a.isPlugin() == false) goto L221;
        Fragment r157 = getParentFragment();
        if ((r157 instanceof ChatCreationPagerFragment) == false) goto L219;
        r18 = (ChatCreationPagerFragment) r157;
    L219:
        if (r18 == null) goto L221;
        r18.X90();
    L221:
        ViewGroup r158 = this.r;
        if (r158 == null) goto L224;
        e1.d(r158, new d(this));
    L224:
        ImageView r159 = this.p;
        if (r159 == null) goto L227;
        e1.d(r159, new e(this));
    L227:
        CommonAiBeautifyLayout r160 = this.q;
        if (r160 == null) goto L231;
        e1.d(r160, new f(this));
        return;
    L231:
        return;
    L195:
        BottomCreationEditView r161 = this.y;
        if (r161 == null) goto L198;
        e1.o(r161);
    L198:
        ConstraintLayout r162 = this.x;
        if (r162 == null) goto L201;
        e1.x(r162);
        goto L201
    L173:
        r147 = null;
        goto L174
    L166:
        r145 = null;
        goto L167
    L149:
        r139 = null;
        goto L150
    L145:
        r137 = null;
        goto L146
    L141:
        r135 = null;
        goto L142
    L124:
        r130 = null;
        goto L125
    L109:
        SimpleDraweeView r36 = this.s;
        if (r36 == null) goto L112;
        e1.x(r36);
    L112:
        SimpleDraweeView r37 = this.s;
        if (r37 == null) goto L121;
        int r38 = oi8.j.a;
        String r163 = r127.g;
        if (r163 != null) goto L117;
        r163 = "";
    L117:
        oi8.j.b(r37, r163, "chat.image_viewer_source_icon", Integer.valueOf(i5.q()), Integer.valueOf(i5.q()), null, null, null, false, 992);
        goto L121
    L102:
        if (r11.length() == 0) goto L105;
        r0 = false;
        goto L105
    L93:
        TextView r39 = this.t;
        if (r39 == null) goto L96;
        e1.x(r39);
    L96:
        TextView r40 = this.t;
        if (r40 == null) goto L99;
        r40.setText(r127.f);
        goto L99
    L85:
        if (r8.length() == 0) goto L88;
        r9 = false;
        goto L89
    L65:
        if (r3.length() == 0) goto L68;
        r4 = false;
    L118:
        ViewGroup r164 = this.r;
        if (r164 == null) goto L121;
        e1.q(r164);
        goto L121
    L55:
        r126 = null;
        goto L57
    L51:
        r124 = null;
        goto L52
    L47:
        r122 = null;
        goto L48
    L38:
        r118 = null;
    L29:
        CommonAiBeautifyLayout r165 = this.q;
        if (r165 == null) goto L32;
        e1.o(r165);
        goto L32
    L16:
        r113 = null;
        goto L17
    L12:
        r111 = null;
        goto L13
    L8:
        r19 = null;
        goto L9
    }

    public static final Object V90(BigImageDetailFragment r5, String r6, Continuation r7) {
        r5.getClass();
        if ((r7 instanceof BigImageDetailFragment$getLatestCreationId$1) == false) goto L7;
        BigImageDetailFragment$getLatestCreationId$1 r0 = (BigImageDetailFragment$getLatestCreationId$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L30:
        String r9 = (String) r8;
    L32:
        if (r9 != null) goto L34;
        r9 = "";
    L34:
        Map<String, UserCreationFromIM> r10 = DataConverterKt.d(r9);
        LinkedHashMap r11 = (LinkedHashMap) r10;
        UserCreationFromIM r12 = (UserCreationFromIM) r11.get(r5.Y90());
        if (r12 == null) goto L40;
        String r13 = r12.getCreationId();
        if (r13 == null) goto L40;
        return r13;
    L40:
        return "";
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        if (r6 != null) goto L17;
    L20:
        boolean r14 = true;
    L21:
        if (r14 == true) goto L40;
        IChatRepoService r15 = RepoDispatcherDelegate.b.e();
        if (r15 == null) goto L31;
        if (r6 != null) goto L27;
        r6 = "";
    L27:
        r0.label = 1;
        r8 = r15.w1(r6, r0);
        if (r8 != r2) goto L30;
        return r2;
    L31:
        r9 = null;
        goto L32
    L17:
        if (r6.length() == 0) goto L20;
        r14 = false;
    L7:
        r0 = new BigImageDetailFragment$getLatestCreationId$1(r5, r7);
        goto L8
    }

    public static final Object W90(BigImageDetailFragment r36, boolean r37, Continuation r38) {
        r36.getClass();
        if ((r38 instanceof BigImageDetailFragment$setCreationPrivacy$1) == false) goto L7;
        BigImageDetailFragment$setCreationPrivacy$1 r3 = (BigImageDetailFragment$setCreationPrivacy$1) r38;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        ChatCreationPagerFragment r7 = null;
        boolean r8 = true;
        String r11 = "";
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L19;
        if (r6 == 2) goto L18;
        if (r6 == 3) goto L17;
        if (r6 != 4) goto L16;
        ResultKt.throwOnFailure(r2);
    L140:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        int r1 = r3.I$2;
        int r9 = r3.I$1;
        int r10 = r3.I$0;
        ResultKt.throwOnFailure(r2);
    L91:
        Pair r12 = (Pair) r2;
        if (r12 == null) goto L94;
        Boolean r13 = (Boolean) r12.getFirst();
    L96:
        if (Intrinsics.areEqual(r13, Boxing.boxBoolean(true)) == true) goto L100;
        MainCoroutineDispatcher r14 = Dispatchers.getMain();
        BigImageDetailFragment$setCreationPrivacy$3 r15 = new BigImageDetailFragment$setCreationPrivacy$3(r36, r10, null);
        r3.label = 4;
        if (BuildersKt.withContext(r14, r15, r3) != r5) goto L140;
        return r5;
    L100:
        if (r9 != 2) goto L106;
        Context r16 = r36.getContext();
        if (r16 == null) goto L111;
        Resources r17 = r16.getResources();
        if (r17 == null) goto L111;
        String r18 = r17.getString(2131900633);
    L112:
        t19.s r19 = t19.s.a;
        Context r20 = r36.getContext();
        if (r18 == null) goto L116;
        r11 = r18;
    L116:
        r19.getClass();
        t19.s.p(r20, r11);
        if (r9 != 2) goto L119;
        e0.a.X0(r36.F.C);
    L119:
        r36.E = r1;
        Fragment r21 = r36.getParentFragment();
        if ((r21 instanceof ChatCreationPagerFragment) == false) goto L122;
        r7 = (ChatCreationPagerFragment) r21;
    L122:
        if (r7 == null) goto L140;
        String r110 = r36.F.C;
        String r0 = r36.Y90();
        Intrinsics.checkNotNullParameter(r110, "creationId");
        Intrinsics.checkNotNullParameter(r0, "creationKey");
        Map<String, UserCreationFromIM> r22 = r7.k;
        if (r22 != null) goto L126;
    L128:
        r8 = false;
    L129:
        if (r8 == false) goto L140;
        Map<String, UserCreationFromIM> r23 = r7.k;
        if (r23 == null) goto L135;
        UserCreationFromIM r24 = r23.get(r0);
        if (r24 == null) goto L135;
    L136:
        UserCreationFromIM r25 = UserCreationFromIM.copy$default(r24, r110, null, Integer.valueOf(r9), null, null, null, null, 122, null);
        Map<String, UserCreationFromIM> r26 = r7.k;
        if (r26 == null) goto L140;
        UserCreationFromIM r27 = r26.put(r0, r25);
    L135:
        r24 = new UserCreationFromIM(null, null, null, null, null, null, null, 127, null);
        goto L136
    L126:
        if (r22.containsKey(r0) != true) goto L128;
    L111:
        r18 = null;
        goto L112
    L106:
        Context r28 = r36.getContext();
        if (r28 == null) goto L111;
        Resources r29 = r28.getResources();
        if (r29 == null) goto L111;
        r18 = r29.getString(2131900634);
        goto L112
    L94:
        r13 = null;
        goto L96
    L18:
        r1 = r3.I$2;
        r9 = r3.I$1;
        int r111 = r3.I$0;
        boolean r112 = r3.Z$0;
        ResultKt.throwOnFailure(r2);
    L53:
        String r30 = r36.F.C;
        String r210 = r36.Z90();
        String r31 = r36.F.k;
        String r211 = r36.ba0();
        if (r112 == false) goto L56;
        String r212 = "1";
    L57:
        if (r112 == false) goto L59;
        String r213 = "0";
    L60:
        uo8.k r113 = r36.F.c;
        if (r113 == null) goto L65;
        Map r114 = r113.a;
        if (r114 == null) goto L65;
        Object r115 = r114.get("recommend_from");
    L66:
        String r214 = String.valueOf(r115);
        uo8.k r116 = r36.F.c;
        if (r116 == null) goto L71;
        Map r117 = r116.a;
        if (r117 == null) goto L71;
        Object r118 = r117.get("from_template_id");
    L72:
        String r215 = String.valueOf(r118);
        uo8.k r119 = r36.F.c;
        if (r119 == null) goto L77;
        Map r120 = r119.a;
        if (r120 == null) goto L77;
        Object r121 = r120.get("template_rec_extra");
    L78:
        String r216 = String.valueOf(r121);
        uo8.k r122 = r36.F.c;
        if (r122 == null) goto L83;
        Map r123 = r122.a;
        if (r123 == null) goto L83;
        Object r124 = r123.get("template_rec_req_id");
    L84:
        e2.a.b(new o0("picture_detail", "chat", r30, r210, r31, r211, r212, r213, r214, r215, String.valueOf(r124), r216, null, null, null, null, null, null, 516097), null, 3);
        e0 r32 = e0.a;
        String r33 = r36.F.C;
        if (r33 != null) goto L87;
        r33 = "";
    L87:
        r3.I$0 = r111;
        r3.I$1 = r9;
        r3.I$2 = r1;
        r3.label = 3;
        r2 = r32.h(r33, r9, r3);
        if (r2 == r5) goto L144;
        r10 = r111;
        goto L91
    L144:
        return r5;
    L83:
        r124 = null;
    L77:
        r121 = null;
    L71:
        r118 = null;
    L65:
        r115 = null;
        goto L66
    L59:
        r213 = "1";
        goto L60
    L56:
        r212 = "0";
        goto L57
    L19:
        u1 r34 = (u1) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L27:
        PublisherCreation r35 = (PublisherCreation) r2;
        uo8.k r39 = r36.F.c;
        if (r39 == null) goto L32;
        Map r40 = r39.a;
        if (r40 == null) goto L32;
        Object r41 = r40.get("recommend_from");
    L33:
        String r42 = String.valueOf(r41);
        uo8.k r43 = r36.F.c;
        if (r43 == null) goto L38;
        Map r44 = r43.a;
        if (r44 == null) goto L38;
        Object r45 = r44.get("template_rec_req_id");
    L39:
        PublisherTrackParams r46 = new PublisherTrackParams("picture_detail", r42, String.valueOf(r45));
        r34.getClass();
        u1.a(r35, r46);
        FLogger.a.i("BigImagePhotoViewer", "setCreationPrivacy gotoPublisher");
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new BigImageDetailFragment$reportPicClickAddCreation$1(r36.F.k, r36, null), 3, null);
        return Unit.INSTANCE;
    L38:
        r45 = null;
    L32:
        r41 = null;
        goto L33
    L20:
        ResultKt.throwOnFailure(r2);
        if (r37 == false) goto L23;
    L40:
        if (r37 == false) goto L42;
        int r47 = 3;
    L43:
        if (r37 == false) goto L45;
        r9 = 2;
    L46:
        if (r37 == false) goto L48;
        int r125 = 2;
    L49:
        MainCoroutineDispatcher r126 = Dispatchers.getMain();
        BigImageDetailFragment$setCreationPrivacy$2 r48 = new BigImageDetailFragment$setCreationPrivacy$2(r36, r125, null);
        r3.Z$0 = r37;
        r3.I$0 = r47;
        r3.I$1 = r9;
        r3.I$2 = r125;
        r3.label = 2;
        if (BuildersKt.withContext(r126, r48, r3) == r5) goto L143;
        r112 = r37;
        r1 = r125;
        r111 = r47;
        goto L53
    L143:
        return r5;
    L48:
        r125 = 3;
        goto L49
    L45:
        r9 = 1;
        goto L46
    L42:
        r47 = 2;
        goto L43
    L23:
        if (r36.ga0() == false) goto L40;
        r34 = new u1();
        r3.L$0 = r34;
        r3.label = 1;
        r2 = r36.fa0(r3);
        if (r2 != r5) goto L27;
        return r5;
    L7:
        r3 = new BigImageDetailFragment$setCreationPrivacy$1(r36, r38);
        goto L8
    }

    public final void pa0(final Function1<? super String, Unit> r8, final Function1<? super Throwable, Unit> r9, Function0<Unit> r10) {
        com.larus.bmhome.bigimg.l r0 = this.F.w;
        if (r0 == null) goto L10;
        Integer r1 = r0.h;
        int r2 = SourceFrom.DouYin.value;
        if (r1 == null) goto L10;
        if (r1.intValue() != r2) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L14;
        r10.invoke();
        return;
    L14:
        AwemeImageFilter r4 = (AwemeImageFilter) this.D.getValue();
        String r11 = null;
        if (r0 == null) goto L17;
        String r5 = r0.a;
    L18:
        if (r0 == null) goto L20;
        String r6 = r0.c;
    L21:
        if (r0 == null) goto L23;
        r11 = r0.e;
    L23:
        r4.a(r5, r6, r11, new g(r8), new h(r9));
        return;
    L20:
        r6 = null;
        goto L21
    L17:
        r5 = null;
    L10:
        r3 = false;
        goto L11
    }

    @Override // zp9.r
    public final void i20(UserCreation r1, long r2, long r4, String r6) {
        zp9.r.a.a(r1, r6);
    }
}
