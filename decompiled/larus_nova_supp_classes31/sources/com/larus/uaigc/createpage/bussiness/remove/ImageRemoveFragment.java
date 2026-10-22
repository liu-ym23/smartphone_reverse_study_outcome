package com.larus.uaigc.createpage.bussiness.remove;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.community.ICreationPageService;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common.apphost.AppHost;
import com.larus.platform.kmp.chat.TemplateInfo$DefaultTab;
import com.larus.uaigc.api.ReviewUgcImageApi;
import com.larus.uaigc.applet.IAICreationAppletHostService;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.bean.createpage.component.sendmessage.CreationSendUiEvent;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.larus.uaigc.createpage.bussiness.remove.widget.GesturePaletteView;
import com.larus.uaigc.createpage.bussiness.remove.widget.PaintSizeControllerView;
import com.larus.uaigc.createpage.bussiness.remove.widget.PaletteControllerView;
import com.larus.uaigc.createpage.bussiness.remove.widget.PenSizeIllustrationView;
import com.larus.uaigc.createpage.utils.BitmapHelperKt;
import com.larus.uaigc.impl.databinding.LarusFragmentImageRemoveBinding;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.utils.FragmentExtKt$addOnBackPressed$callback$1;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.w0;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import v19.c7;
import v19.f7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0090\u00012\u00020\u0001:\u0006\u008e\u0001\u008f\u0001\u0090\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0016J&\u00105\u001a\u0004\u0018\u0001002\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u001a\u0010:\u001a\u0002022\u0006\u0010;\u001a\u0002002\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0010\u0010<\u001a\u0002022\u0006\u0010=\u001a\u000200H\u0002J\b\u0010>\u001a\u000202H\u0002J\b\u0010?\u001a\u000202H\u0002J\b\u0010@\u001a\u000202H\u0016J\b\u0010A\u001a\u000202H\u0002J\u000f\u0010B\u001a\u0004\u0018\u000102H\u0003¢\u0006\u0002\u0010CJ\n\u0010D\u001a\u0004\u0018\u00010\u001cH\u0002J\u0016\u0010E\u001a\u0002022\u0006\u0010F\u001a\u00020GH\u0082@¢\u0006\u0002\u0010HJ\b\u0010I\u001a\u000202H\u0002J\u0010\u0010J\u001a\u0002022\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010K\u001a\u0002022\u0006\u0010L\u001a\u00020\bH\u0002J\b\u0010M\u001a\u000202H\u0002J\u0010\u0010N\u001a\u0002022\u0006\u0010O\u001a\u00020PH\u0002J\u000f\u0010Q\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0002\u0010CJ\b\u0010R\u001a\u000202H\u0002J\b\u0010S\u001a\u000202H\u0002J\b\u0010T\u001a\u00020\rH\u0002J\u000f\u0010U\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0002\u0010CJ\n\u0010V\u001a\u0004\u0018\u00010\u001cH\u0002J\u000f\u0010W\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0002\u0010CJ\u000f\u0010X\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0002\u0010CJ\n\u0010Y\u001a\u0004\u0018\u00010\u001cH\u0002J \u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020[2\u0006\u0010]\u001a\u00020\r2\u0006\u0010^\u001a\u00020\rH\u0002J\u0018\u0010_\u001a\u0004\u0018\u00010`2\u0006\u0010a\u001a\u00020[H\u0082@¢\u0006\u0002\u0010bJ\u0018\u0010c\u001a\u00020\u00172\b\u0010d\u001a\u0004\u0018\u000104H\u0082@¢\u0006\u0002\u0010eJ\u0010\u0010f\u001a\u00020\u00172\u0006\u0010g\u001a\u000204H\u0002J\u0016\u0010h\u001a\u00020\u00172\u0006\u0010g\u001a\u000204H\u0082@¢\u0006\u0002\u0010eJ\b\u0010i\u001a\u00020jH\u0002J\u0018\u0010k\u001a\u0004\u0018\u00010l*\u00020m2\b\u0010n\u001a\u0004\u0018\u00010\bH\u0002J\n\u0010o\u001a\u0004\u0018\u00010pH\u0002J\u0010\u0010q\u001a\u00020\u00172\u0006\u0010r\u001a\u00020sH\u0002J\u0016\u0010t\u001a\u00020\u00172\u0006\u0010u\u001a\u00020-H\u0082@¢\u0006\u0002\u0010vJ$\u0010w\u001a\u0004\u0018\u00010-2\b\u0010x\u001a\u0004\u0018\u00010y2\b\u0010d\u001a\u0004\u0018\u000104H\u0082@¢\u0006\u0002\u0010zJ\u0018\u0010{\u001a\u0004\u0018\u00010-2\u0006\u0010|\u001a\u00020-H\u0082@¢\u0006\u0002\u0010vJ\u001b\u0010}\u001a\u0004\u0018\u00010~2\b\u0010\u007f\u001a\u0004\u0018\u00010\bH\u0082@¢\u0006\u0003\u0010\u0080\u0001J\u000b\u0010\u0081\u0001\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u0082\u0001\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0002\u0010CJ\u0011\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0003\u0010\u0084\u0001J\u0010\u0010\u0085\u0001\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0002\u0010CJ\u0010\u0010\u0086\u0001\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0002\u0010CJF\u0010\u0087\u0001\u001a\u0002022\u0007\u0010\u0088\u0001\u001a\u00020\b2\u0015\u0010\u0089\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u008b\u0001\u0012\u0004\u0012\u0002020\u008a\u00012\u0014\u0010\u008c\u0001\u001a\u000f\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u0002020\u008a\u0001H\u0082@¢\u0006\u0003\u0010\u008d\u0001R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@BX\u0083\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0003\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0091\u0001"}, d2 = {"Lcom/larus/uaigc/createpage/bussiness/remove/ImageRemoveFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusFragmentImageRemoveBinding;", "pickLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "pickSDKLauncher", "Landroid/content/Intent;", "value", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "curPageStatus", "getCurPageStatus$annotations", "setCurPageStatus", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "curUploaderIdentifier", "mediaAttachment", "Lcom/larus/bmhome/actionbar/model/MediaAttachment;", "localImageUri", "ignoreImageSizeCheck", "", "initialPenSize", "creationId", "isImageReviewUnPass", "dismissPenSizeRingJob", "Lkotlinx/coroutines/Job;", "isOpenNewChatPage", "callback", "Lcom/larus/uaigc/bean/remove/IImageRemoveCallback;", "getCallback", "()Lcom/larus/uaigc/bean/remove/IImageRemoveCallback;", "setCallback", "(Lcom/larus/uaigc/bean/remove/IImageRemoveCallback;)V", "hostBackCallback", "Landroidx/activity/OnBackPressedCallback;", "hostUiPolicy", "Lcom/larus/uaigc/createpage/bussiness/remove/ImageRemoveFragment$ImageRemoveHostUiPolicy;", "getHostUiPolicy", "()Lcom/larus/uaigc/createpage/bussiness/remove/ImageRemoveFragment$ImageRemoveHostUiPolicy;", "hostUiPolicy$delegate", "Lkotlin/Lazy;", "creationSendMessageConfig", "Lcom/larus/uaigc/bean/createpage/CreationSendMessageConfig;", "coveredAppletPageViews", "", "Landroid/view/View;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "isolateAppletPageLayerOnAndroid10", "currentPageView", "restoreCoveredAppletPageViews", "hideInputOnEnter", "onDestroyView", "initLauncher", "initUploadingView", "()Lkotlin/Unit;", "doUpload", "handleUploadSuccess", "result", "Lcom/larus/platform/model/upload/ResourceUploadResult;", "(Lcom/larus/platform/model/upload/ResourceUploadResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleImageReviewRejected", "handleUploadAccepted", "requireSelectedImageUrlInBackground", "tosKey", "openSystemAlbum", "onAlbumSelected", "uri", "Landroid/net/Uri;", "initTitle", "initBackPressedCallback", "navigateBackOrCloseHost", "resolveHostBackIcon", "initControlPanel", "initPalette", "initFinishBtn", "adaptHostBottomMargin", "doFinish", "scaleBitmap", "Landroid/graphics/Bitmap;", "originBitmap", "newWidth", "newHeight", "saveBitmapToStableCreationCache", "Ljava/io/File;", "bitmap", "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toChatPage", "data", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openChatBelowHostAfterMessagePrepared", "params", "tryDispatchCreationSendResultToCurrentChatBelowHost", "buildHostReturnUiEvent", "Lcom/larus/uaigc/bean/createpage/component/sendmessage/CreationSendUiEvent;", "findTargetChatFragment", "Lcom/larus/bmhome/chat/fragment/IChatFragment;", "Landroidx/fragment/app/FragmentManager;", "targetCvsId", "findNativeHostActivityBelowHost", "Landroidx/fragment/app/FragmentActivity;", "isValidNativeHostActivity", "activity", "Landroid/app/Activity;", "sendCreationMessage", "sendConfig", "(Lcom/larus/uaigc/bean/createpage/CreationSendMessageConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildCreationSendMessageConfig", "imageEditDataWithMask", "Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;", "(Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureCreationSendConversation", "config", "findSendConversation", "Lcom/larus/im/bean/conversation/Conversation;", "conversationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findCurrentChatBelowHostConversationId", "showNormal", "showEmpty", "()Ljava/lang/Boolean;", "showUploading", "showUploadFailed", "submitImageResourceAccess", "localPath", "onFailed", "Lkotlin/Function1;", "Lcom/larus/platform/model/upload/ResourceUploadError;", "onSuccess", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PageStatus", "ImageRemoveHostUiPolicy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImageRemoveFragment extends Fragment {
    public static final /* synthetic */ int v = 0;
    public LarusFragmentImageRemoveBinding d;
    public ActivityResultLauncher<String> e;
    public ActivityResultLauncher<Intent> f;
    public final StateFlowImpl g;
    public String h;
    public MediaAttachment i;
    public String j;
    public boolean k;
    public int l;
    public String m;
    public boolean n;
    public Job o;
    public boolean p;
    public xy9.a q;
    public FragmentExtKt$addOnBackPressed$callback$1 r;
    public final Lazy s;
    public CreationSendMessageConfig t;
    public final List<View> u;

    public static final class ImageRemoveHostUiPolicy {
        public static final /* synthetic */ int c = 0;
        public final boolean a;
        public final boolean b;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/uaigc/createpage/bussiness/remove/ImageRemoveFragment$ImageRemoveHostUiPolicy$ExitBehavior;", "", "<init>", "(Ljava/lang/String;I)V", "NATIVE_FINISH", "HOST_BACK", "HOST_CLOSE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        public static final enum ExitBehavior extends Enum<ExitBehavior> {
            public static final ExitBehavior HOST_BACK = null;
            public static final ExitBehavior HOST_CLOSE = null;
            public static final ExitBehavior NATIVE_FINISH = null;
            public static final /* synthetic */ ExitBehavior[] a = null;
            public static final /* synthetic */ EnumEntries b = null;

            public static EnumEntries<ExitBehavior> getEntries() {
                return b;
            }

            static {
                ExitBehavior r0 = new ExitBehavior("NATIVE_FINISH", 0);
                NATIVE_FINISH = r0;
                ExitBehavior r1 = new ExitBehavior("HOST_BACK", 1);
                HOST_BACK = r1;
                ExitBehavior r3 = new ExitBehavior("HOST_CLOSE", 2);
                HOST_CLOSE = r3;
                ExitBehavior[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
            }

            public static ExitBehavior[] values() {
                return (ExitBehavior[]) a.clone();
            }

            public static ExitBehavior valueOf(String r1) {
                return (ExitBehavior) r27.a.a(ExitBehavior.class, r1);
            }

            public ExitBehavior(String r1, int r2) {
                super(r1, r2);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/uaigc/createpage/bussiness/remove/ImageRemoveFragment$ImageRemoveHostUiPolicy$TitleLeadingAction;", "", "<init>", "(Ljava/lang/String;I)V", "CANCEL", "BACK", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        public static final enum TitleLeadingAction extends Enum<TitleLeadingAction> {
            public static final TitleLeadingAction BACK = null;
            public static final TitleLeadingAction CANCEL = null;
            public static final /* synthetic */ TitleLeadingAction[] a = null;
            public static final /* synthetic */ EnumEntries b = null;

            public static EnumEntries<TitleLeadingAction> getEntries() {
                return b;
            }

            static {
                TitleLeadingAction r0 = new TitleLeadingAction("CANCEL", 0);
                CANCEL = r0;
                TitleLeadingAction r1 = new TitleLeadingAction("BACK", 1);
                BACK = r1;
                TitleLeadingAction[] r3 = {r0, r1};
                a = r3;
                b = EnumEntriesKt.enumEntries(r3);
            }

            public static TitleLeadingAction[] values() {
                return (TitleLeadingAction[]) a.clone();
            }

            public static TitleLeadingAction valueOf(String r1) {
                return (TitleLeadingAction) r27.a.a(TitleLeadingAction.class, r1);
            }

            public TitleLeadingAction(String r1, int r2) {
                super(r1, r2);
            }
        }

        public static final class a {
        }

        static {
        }

        public ImageRemoveHostUiPolicy(boolean r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/uaigc/createpage/bussiness/remove/ImageRemoveFragment$PageStatus;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PageStatus {
        public static final a Companion = null;
        public static final int EMPTY = 2;
        public static final int NORMAL = 1;
        public static final int UPLOADING = 3;
        public static final int UPLOAD_FAILED = 4;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ImageRemoveHostUiPolicy.TitleLeadingAction.values().length];
            r0[ImageRemoveHostUiPolicy.TitleLeadingAction.BACK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[ImageRemoveHostUiPolicy.TitleLeadingAction.CANCEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            a = r0;
            int[] r1 = new int[ImageRemoveHostUiPolicy.ExitBehavior.values().length];
            r1[ImageRemoveHostUiPolicy.ExitBehavior.HOST_BACK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r1[ImageRemoveHostUiPolicy.ExitBehavior.HOST_CLOSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r1[ImageRemoveHostUiPolicy.ExitBehavior.NATIVE_FINISH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    static {
    }

    public final ImageRemoveHostUiPolicy aa0() {
        return (ImageRemoveHostUiPolicy) this.s.getValue();
    }

    public final void ba0() {
        t19.s r0 = t19.s.a;
        Context r1 = getContext();
        r0.getClass();
        t19.s.s(r1, 2131908918);
        LarusFragmentImageRemoveBinding r2 = this.d;
        if (r2 == null) goto L7;
        GesturePaletteView r3 = r2.h;
        if (r3 == null) goto L7;
        r3.setImageBitmap(null);
    L7:
        ga0();
        this.n = true;
    }

    public final Boolean ga0() {
        final LarusFragmentImageRemoveBinding r0 = this.d;
        if (r0 == null) goto L5;
        this.g.setValue(2);
        e1.o(r0.f);
        return Boolean.valueOf(r0.k.post(new e(this, r0)));
    L5:
        return null;
    }

    public final Unit ha0() {
        LarusFragmentImageRemoveBinding r0 = this.d;
        if (r0 == null) goto L12;
        this.g.setValue(1);
        t19.s r4 = t19.s.a;
        Context r5 = getContext();
        Context r2 = getContext();
        if (r2 == null) goto L7;
        String r3 = r2.getString(2131906337);
    L8:
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        t19.s.j(r4, r5, r3, 2000, false, 24);
        e1.o(r0.c);
        e1.o(r0.f);
        e1.x(r0.i);
        r0.i.animate().cancel();
        r0.i.setAlpha(1.0f);
        PenSizeIllustrationView r6 = r0.i;
        PaintSizeControllerView r7 = r0.b.a.b;
        r6.setSize((r7.a.d.getProgress() + r7.c) / 2);
        r0.i.invalidate();
        this.o = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ImageRemoveFragment$showNormal$1$1(r0, null), 3, null);
        return Unit.INSTANCE;
    L7:
        r3 = null;
        goto L8
    L12:
        return null;
    }

    public final Unit ia0() {
        LarusFragmentImageRemoveBinding r0 = this.d;
        if (r0 == null) goto L13;
        this.g.setValue(4);
        e1.o(r0.c);
        e1.x(r0.f);
        if (r0.h.getViewBitmap() == null) goto L11;
        e1.x(r0.e);
        View r1 = r0.e;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L10;
        RectF r3 = r0.h.getCurBitmapRect();
        r2.width = (int) (((double) r3.width()) + 0.5d);
        r2.height = (int) (((double) r3.height()) + 0.5d);
        r1.setLayoutParams(r2);
    L12:
        e1.o(r0.g);
        e1.x(r0.j);
        return Unit.INSTANCE;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L11:
        e1.o(r0.e);
        goto L12
    L13:
        return null;
    }

    public final Unit ja0() {
        LarusFragmentImageRemoveBinding r0 = this.d;
        if (r0 == null) goto L13;
        this.g.setValue(3);
        e1.o(r0.c);
        e1.x(r0.g);
        e1.o(r0.j);
        e1.x(r0.f);
        if (r0.h.getViewBitmap() == null) goto L11;
        e1.x(r0.e);
        View r1 = r0.e;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L10;
        RectF r3 = r0.h.getCurBitmapRect();
        r2.width = (int) (((double) r3.width()) + 0.5d);
        r2.height = (int) (((double) r3.height()) + 0.5d);
        r1.setLayoutParams(r2);
    L15:
        return Unit.INSTANCE;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L11:
        e1.o(r0.e);
        goto L15
    L13:
        return null;
    }

    public final void onDestroyView() {
        Iterator r0 = ((ArrayList) this.u).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        View r1 = (View) r0.next();
        if (r1.getParent() == null) goto L4;
        r1.setVisibility(0);
        goto L4
    L8:
        ((ArrayList) this.u).clear();
        super.onDestroyView();
        FragmentExtKt$addOnBackPressed$callback$1 r2 = this.r;
        if (r2 == null) goto L11;
        r2.remove();
    L11:
        this.r = null;
        this.d = null;
        ICreationResourceAccessService.a.a(ICreationResourceAccessService.a, this.h);
    }

    public ImageRemoveFragment() {
        this.g = j1.a(2);
        this.h = "";
        this.l = c7.b(40);
        this.s = LazyKt.lazy(new d(this));
        this.u = new ArrayList();
    }

    public final FragmentActivity X90() {
        Activity r0 = getActivity();
        if (r0 != null) goto L5;
        return null;
    L5:
        List r2 = AppHost.a.a().g();
        ListIterator r3 = r2.listIterator(r2.size());
    L7:
        if (r3.hasPrevious() == false) goto L14;
        if (((Activity) r3.previous()) != r0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L7;
        int r5 = r3.nextIndex();
    L15:
        if (r5 <= 0) goto L36;
        Iterator r6 = CollectionsKt.asReversed(r2.subList(0, r5)).iterator();
    L18:
        if (r6.hasNext() == false) goto L29;
        Object r7 = r6.next();
        Activity r8 = (Activity) r7;
        cy9.a.a.getClass();
        if (cy9.a.d(r8) == false) goto L22;
    L26:
        boolean r9 = false;
    L27:
        if (r9 == false) goto L18;
    L30:
        FragmentActivity r10 = (Activity) r7;
        if (r10 == null) goto L36;
        if ((r10 instanceof FragmentActivity) == true) goto L35;
        return null;
    L35:
        return r10;
    L22:
        if (r8.isFinishing() == true) goto L26;
        if (r8.isDestroyed() == true) goto L26;
        r9 = true;
        goto L27
    L29:
        r7 = null;
    L36:
        ListIterator r11 = r2.listIterator(r2.size());
    L38:
        if (r11.hasPrevious() == false) goto L54;
        Object r12 = r11.previous();
        Activity r13 = (Activity) r12;
        if (r13.getTaskId() == r0.getTaskId()) goto L51;
        cy9.a.a.getClass();
        if (cy9.a.d(r13) == false) goto L44;
    L48:
        boolean r14 = false;
    L49:
        if (r14 == false) goto L51;
        boolean r15 = true;
    L52:
        if (r15 == false) goto L38;
    L56:
        if ((r12 instanceof FragmentActivity) == true) goto L58;
        return null;
    L58:
        return (FragmentActivity) r12;
    L44:
        if (r13.isFinishing() == true) goto L48;
        if (r13.isDestroyed() == true) goto L48;
        r14 = true;
    L51:
        r15 = false;
        goto L52
    L54:
        r12 = null;
        goto L56
    L11:
        r4 = false;
        goto L12
    L14:
        r5 = -1;
        goto L15
    }

    public final void da0() {
        ImageRemoveHostUiPolicy r0 = aa0();
        if (r0.a == true) goto L6;
        ImageRemoveHostUiPolicy.ExitBehavior r1 = ImageRemoveHostUiPolicy.ExitBehavior.NATIVE_FINISH;
    L9:
        int r2 = b.b[r1.ordinal()];
        if (r2 != 1) goto L12;
        ICreationWorkflowService.a.H(new g(this));
        return;
    L12:
        if (r2 == 2) goto L21;
        if (r2 != 3) goto L19;
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L27;
        r3.finish();
        return;
    L27:
        return;
    L19:
        throw new NoWhenBranchMatchedException();
    L21:
        if (ICreationWorkflowService.a.L() == true) goto L29;
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L30;
        r4.finish();
        return;
    L30:
        return;
    L29:
        return;
    L6:
        if (r0.b == false) goto L8;
        r1 = ImageRemoveHostUiPolicy.ExitBehavior.HOST_BACK;
        goto L9
    L8:
        r1 = ImageRemoveHostUiPolicy.ExitBehavior.HOST_CLOSE;
        goto L9
    }

    public final void ca0(mr9.l r20) {
        ha0();
        String r4 = r20.a;
        mr9.d r2 = r20.d;
        long r6 = 0;
        if (r2 == null) goto L5;
        long r8 = r2.b;
    L6:
        Long r3 = Long.valueOf(r8);
        mr9.d r9 = r20.d;
        if (r9 == null) goto L9;
        r6 = r9.a;
    L9:
        this.i = new MediaAttachment(null, r4, new ImageUploadInfo(r3, Long.valueOf(r6)), null, null, null, null, null, null, null, null, null, 4088, null);
        String r1 = r20.a;
        if (r1 != null) goto L12;
        r1 = "";
    L12:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ImageRemoveFragment$requireSelectedImageUrlInBackground$1(r1, this, null), 3, null);
        return;
    L5:
        r8 = 0;
        goto L6
    }

    public final void ea0(Uri r6) {
        LarusFragmentImageRemoveBinding r0 = this.d;
        if (r0 == null) goto L27;
        File r2 = null;
        if (this.n == false) goto L22;
        ImageRemoveFragment r1 = new ImageRemoveFragment();
        Bundle r3 = getArguments();
        if (r3 == null) goto L9;
        r3.putString("input_image_uri", r6.toString());
        r3.putString("media_attachment", "");
        r3.putInt("initial_pen_size", ((int) r0.i.getSize()) * 2);
    L10:
        r1.setArguments(r3);
        FragmentActivity r7 = getActivity();
        if (r7 == null) goto L28;
        FragmentManager r8 = r7.getSupportFragmentManager();
        if (r8 == null) goto L29;
        FragmentTransaction r9 = r8.beginTransaction();
        if (r9 != null) goto L17;
        return;
    L17:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r9, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L20;
        r9 = r9.replace(2131373275, r1);
    L20:
        if (r9 == null) goto L31;
        r9.commitNowAllowingStateLoss();
        return;
    L31:
        return;
    L29:
        return;
    L28:
        return;
    L9:
        r3 = null;
        goto L10
    L22:
        String r10 = r6.toString();
        this.j = r10;
        this.i = null;
        GesturePaletteView r4 = r0.h;
        Uri r11 = UriProtector.parse(r10);
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L25;
        r2 = r5.getCacheDir();
    L25:
        r4.q(r11, Uri.fromFile(new PolarisFileWrapper(r2, "ugc_image_edit_cache.jpeg")));
        return;
    }

    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        Bundle r8 = getArguments();
        if (r8 == null) goto L5;
        r8.setClassLoader(CreationSendMessageConfig.class.getClassLoader());
    L5:
        Bundle r9 = getArguments();
        Object r0 = null;
        if (r9 == null) goto L8;
        Serializable r10 = r9.getSerializable("media_attachment");
    L10:
        if ((r10 instanceof MediaAttachment) == false) goto L12;
        MediaAttachment r11 = (MediaAttachment) r10;
    L13:
        this.i = r11;
        Bundle r12 = getArguments();
        if (r12 == null) goto L16;
        String r13 = r12.getString("input_image_uri");
    L17:
        this.j = r13;
        Bundle r14 = getArguments();
        boolean r1 = false;
        if (r14 == null) goto L20;
        this.k = r14.getBoolean("ignore_image_size_check", false);
    L20:
        Bundle r15 = getArguments();
        if (r15 == null) goto L23;
        String r16 = r15.getString("actionbar_creation_id");
    L24:
        this.m = r16;
        Bundle r17 = getArguments();
        if (r17 == null) goto L27;
        boolean r18 = r17.getBoolean("open_new_chat_page", false);
    L28:
        this.p = r18;
        Bundle r19 = getArguments();
        if (r19 == null) goto L31;
        int r20 = r19.getInt("initial_pen_size");
    L32:
        this.l = r20;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L43
        Bundle r22 = getArguments();     // Catch: Throwable -> L43
        if (r22 == null) goto L36;
        Serializable r23 = r22.getSerializable("creation_send_message_config");     // Catch: Throwable -> L43
    L38:
        if ((r23 instanceof CreationSendMessageConfig) == false) goto L40;
        CreationSendMessageConfig r24 = (CreationSendMessageConfig) r23;     // Catch: Throwable -> L43
    L41:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L43
    L45:
        Throwable r2 = Result.exceptionOrNull-impl(r25);
        if (r2 == null) goto L49;
        FLogger.a.e("ImageRemoveFragment", "read creation send config failed", r2);
    L49:
        if (Result.isFailure-impl(r25) == true) goto L52;
        r0 = r25;
    L52:
        this.t = (CreationSendMessageConfig) r0;
        FLogger r26 = FLogger.a;
        StringBuilder r3 = new StringBuilder("onCreate hasCreationSendConfig=");
        if (this.t == null) goto L55;
        r1 = true;
    L55:
        r3.append(r1);
        r3.append(", useHost=");
        r3.append(aa0().a);
        r26.i("ImageRemoveFragment", r3.toString());
        return;
    L40:
        r24 = null;
        goto L41
    L36:
        r23 = null;
    L43:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L45
    L31:
        r20 = this.l;
        goto L32
    L27:
        r18 = false;
        goto L28
    L23:
        r16 = null;
        goto L24
    L16:
        r13 = null;
        goto L17
    L12:
        r11 = null;
        goto L13
    L8:
        r10 = null;
        goto L10
    }

    public static xe8.a Z90(FragmentManager r6, String r7) {
        Iterator r8 = r6.getFragments().iterator();
    L3:
        xe8.a r1 = null;
        if (r8.hasNext() == false) goto L29;
        Fragment r0 = (Fragment) r8.next();
        if ((r0 instanceof xe8.a) == false) goto L8;
        xe8.a r2 = (xe8.a) r0;
    L9:
        if (r2 == null) goto L26;
        boolean r3 = true;
        if (r7 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == false) goto L19;
    L22:
        if (r3 == false) goto L24;
        r1 = r2;
    L24:
        if (r1 == null) goto L26;
        return r1;
    L19:
        if (Intrinsics.areEqual(r2.getConversationId(), r7) == true) goto L22;
        r3 = false;
        goto L22
    L13:
        if (r7.length() == 0) goto L16;
        r5 = false;
    L26:
        xe8.a r4 = Z90(r0.getChildFragmentManager(), r7);
        if (r4 == null) goto L3;
        return r4;
    L8:
        r2 = null;
        goto L9
    L29:
        return null;
    }

    public final Object W90(CreationSendMessageConfig r39, Continuation<? super CreationSendMessageConfig> r40) {
        if ((r40 instanceof ImageRemoveFragment$ensureCreationSendConversation$1) == false) goto L7;
        ImageRemoveFragment$ensureCreationSendConversation$1 r2 = (ImageRemoveFragment$ensureCreationSendConversation$1) r40;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        boolean r6 = false;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        String r7 = (String) r2.L$1;
        CreationSendMessageConfig r8 = (CreationSendMessageConfig) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L99:
        wc9.e r9 = (wc9.e) r1;
        CreationSendMessageConfig r10 = r8;
        String r11 = r7;
    L100:
        wc9.e r12 = r9;
        if (r11 != null) goto L112;
        if (r12 == null) goto L111;
        r11 = r12.a;
        if (r11 == null) goto L111;
        if (r11.length() <= 0) goto L108;
        boolean r13 = true;
    L109:
        if (r13 == false) goto L111;
    L108:
        r13 = false;
    L111:
        String r14 = null;
    L113:
        if (r12 == null) goto L124;
        if (r14 != null) goto L116;
    L119:
        boolean r15 = true;
    L120:
        if (r15 == true) goto L124;
        return CreationSendMessageConfig.copy$default(r10, r14, null, r12, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217722, null);
    L116:
        if (r14.length() == 0) goto L119;
        r15 = false;
    L124:
        FLogger r16 = FLogger.a;
        StringBuilder r17 = new StringBuilder("ensureCreationSendConversation failed, conversationNull:");
        if (r12 != null) goto L127;
        boolean r18 = true;
    L128:
        r17.append(r18);
        r17.append(", cvsIdEmpty:");
        if (r14 != null) goto L131;
    L132:
        r6 = true;
    L133:
        r17.append(r6);
        r16.e("ImageRemoveFragment", r17.toString());
        return null;
    L131:
        if (r14.length() != 0) goto L133;
    L127:
        r18 = false;
    L112:
        r14 = r11;
        goto L113
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        if (aa0().a == false) goto L31;
        FragmentActivity r19 = X90();
        if (r19 == null) goto L31;
        FragmentManager r20 = r19.getSupportFragmentManager();
        if (r20 == null) goto L31;
        xe8.a r21 = Z90(r20, null);
        if (r21 == null) goto L31;
        r11 = r21.getConversationId();
        if (r11 == null) goto L31;
        if (r11.length() <= 0) goto L28;
        boolean r22 = true;
    L29:
        if (r22 == false) goto L31;
    L33:
        if (aa0().a == false) goto L55;
        if (r11 != null) goto L76;
        r11 = r39.getCvsId();
        if (r11 != null) goto L38;
    L43:
        r11 = null;
    L44:
        if (r11 != null) goto L76;
        wc9.e r23 = r39.getConversation();
        if (r23 == null) goto L75;
        r11 = r23.a;
        if (r11 == null) goto L75;
        if (r11.length() <= 0) goto L52;
        boolean r24 = true;
    L53:
        if (r24 == false) goto L75;
    L52:
        r24 = false;
    L75:
        r11 = null;
        goto L76
    L38:
        if (r11.length() <= 0) goto L40;
        boolean r25 = true;
    L41:
        if (r25 == false) goto L43;
    L40:
        r25 = false;
    L76:
        r9 = r39.getConversation();
        if (r9 == null) goto L95;
        if (r11 != null) goto L80;
    L83:
        boolean r26 = true;
    L84:
        if (r26 == false) goto L86;
    L89:
        boolean r27 = true;
    L90:
        if (r27 == true) goto L93;
        r9 = null;
    L93:
        if (r9 == null) goto L95;
        r10 = r39;
        goto L100
    L86:
        if (Intrinsics.areEqual(r9.a, r11) == true) goto L89;
        r27 = false;
        goto L90
    L80:
        if (r11.length() == 0) goto L83;
        r26 = false;
    L95:
        r2.L$0 = r39;
        r2.L$1 = r11;
        r2.label = 1;
        Object r28 = Y90(r11, r2);
        if (r28 != r4) goto L98;
        return r4;
    L98:
        r7 = r11;
        r1 = r28;
        r8 = r39;
        goto L99
    L55:
        r11 = r39.getCvsId();
        if (r11 != null) goto L58;
    L65:
        wc9.e r29 = r39.getConversation();
        if (r29 == null) goto L75;
        r11 = r29.a;
        if (r11 == null) goto L75;
        if (r11.length() <= 0) goto L72;
        boolean r30 = true;
    L73:
        if (r30 == false) goto L75;
    L72:
        r30 = false;
        goto L73
    L58:
        if (r11.length() <= 0) goto L60;
        boolean r31 = true;
    L61:
        if (r31 == true) goto L64;
        r11 = null;
    L64:
        if (r11 != null) goto L76;
    L60:
        r31 = false;
        goto L61
    L28:
        r22 = false;
    L31:
        r11 = null;
    L7:
        r2 = new ImageRemoveFragment$ensureCreationSendConversation$1(this, r40);
        goto L8
    }

    public final Object Y90(String r53, Continuation<? super wc9.e> r54) {
        if ((r54 instanceof ImageRemoveFragment$findSendConversation$1) == false) goto L7;
        ImageRemoveFragment$findSendConversation$1 r1 = (ImageRemoveFragment$findSendConversation$1) r54;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ResultKt.throwOnFailure(r0);
    L49:
        wc9.e r4 = (wc9.e) r0;
        if (r4 != null) goto L56;
        AuthModelDelegate r5 = AuthModelDelegate.b;
        wc9.e r6 = (wc9.e) r5.y().getValue();
        if (r6 != null) goto L55;
        return (wc9.e) r5.u().getValue();
    L55:
        return r6;
    L56:
        return r4;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r7 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
        String r12 = r7;
    L38:
        wc9.e r8 = (wc9.e) r0;
        if (r8 == null) goto L42;
        return r8;
    L42:
        if (aa0().a == false) goto L45;
        return null;
    L45:
        return new wc9.e(r12, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, 0, null, null, 0, -2, 63);
    L17:
        String r10 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
        r12 = r10;
    L32:
        wc9.e r11 = (wc9.e) r0;
        if (r11 == null) goto L35;
        return r11;
    L35:
        IConversationRepoService r13 = RepoDispatcherDelegate.b.f();
        r1.L$0 = r12;
        r1.label = 2;
        r0 = IConversationRepoService.a.c(r13, r12, true, null, r1, 4);
        if (r0 != r9) goto L38;
        return r9;
    L18:
        ResultKt.throwOnFailure(r0);
        if (r53 != null) goto L21;
    L46:
        IConversationRepoService r14 = RepoDispatcherDelegate.b.f();
        r1.label = 3;
        r0 = r14.f(r1);
        if (r0 != r9) goto L49;
        return r9;
    L21:
        if (r53.length() <= 0) goto L23;
        boolean r15 = true;
    L24:
        if (r15 == false) goto L26;
        String r16 = r53;
    L27:
        if (r16 == null) goto L46;
        IConversationRepoService r17 = RepoDispatcherDelegate.b.f();
        r1.L$0 = r16;
        r1.label = 1;
        Object r18 = IConversationRepoService.a.c(r17, r16, false, null, r1, 4);
        if (r18 != r9) goto L31;
        return r9;
    L31:
        r12 = r16;
        r0 = r18;
        goto L32
    L26:
        r16 = null;
        goto L27
    L23:
        r15 = false;
    L7:
        r1 = new ImageRemoveFragment$findSendConversation$1(this, r54);
        goto L8
    }

    public final Object fa0(CreationSendMessageConfig r5, Continuation<? super Boolean> r6) {
        if ((r6 instanceof ImageRemoveFragment$sendCreationMessage$1) == false) goto L7;
        ImageRemoveFragment$sendCreationMessage$1 r0 = (ImageRemoveFragment$sendCreationMessage$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L21
    L19:
        Object r8 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) r7).booleanValue()));     // Catch: Throwable -> L21
    L23:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L26;
        FLogger.a.e("ImageRemoveFragment", "sendCreationMessage failed", r9);
    L26:
        Boolean r10 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r8) == true) goto L29;
        return r8;
    L29:
        return r10;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r7);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L21
        ICreationWorkflowService.Companion r12 = ICreationWorkflowService.a;     // Catch: Throwable -> L21
        r0.label = 1;     // Catch: Throwable -> L21
        r7 = r12.W(r5, r0);     // Catch: Throwable -> L21
        if (r7 != r2) goto L19;
        return r2;
    L21:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new ImageRemoveFragment$sendCreationMessage$1(this, r6);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.uaigc.createpage.bussiness.remove.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v4, types: [com.larus.uaigc.createpage.bussiness.remove.a] */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.larus.uaigc.createpage.bussiness.remove.i] */
    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        ViewGroup r0 = null;
        int r1 = 0;
        if (aa0().a == false) goto L22;
        View r12 = getView();
        if (r12 == null) goto L8;
        r12.clearFocus();
    L8:
        Context r13 = getContext();
        if (r13 == null) goto L11;
        Object r14 = r13.getSystemService("input_method");
    L13:
        if ((r14 instanceof InputMethodManager) == false) goto L15;
        InputMethodManager r15 = (InputMethodManager) r14;
    L16:
        if (r15 == null) goto L22;
        View r2 = getView();
        if (r2 == null) goto L20;
        IBinder r3 = r2.getWindowToken();
    L21:
        r15.hideSoftInputFromWindow(r3, 0);
        goto L22
    L20:
        r3 = null;
        goto L21
    L15:
        r15 = null;
        goto L16
    L11:
        r14 = null;
    L22:
        this.e = registerForActivityResult(new ActivityResultContracts.GetContent(), new j(this));
        this.f = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new k(this));
        LarusFragmentImageRemoveBinding r16 = this.d;
        boolean r4 = true;
        if (r16 == null) goto L48;
        NovaTitleBarEx.Y5(r16.l, r16.k.getContext().getString(2131906338), null, null, 6);
        if (aa0().a == false) goto L46;
        NovaTitleBarEx r5 = r16.l;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L45;
        ConstraintLayout.LayoutParams r7 = (ConstraintLayout.LayoutParams) r6;
        i0.a.getClass();
        ((ViewGroup.MarginLayoutParams) r7).topMargin = i0.g();
        r5.setLayoutParams(r7);
        if (aa0().b == false) goto L31;
        ImageRemoveHostUiPolicy.TitleLeadingAction r8 = ImageRemoveHostUiPolicy.TitleLeadingAction.BACK;
    L32:
        int r9 = b.a[r8.ordinal()];
        if (r9 != 1) goto L35;
        View r17 = r16.l.Z5(2131240810, true, ImageView.ScaleType.CENTER_INSIDE, r16.k.getContext().getString(2131898805), new l(this));
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if (r18 == null) goto L43;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        r19.width = c7.b(36);
        r19.height = c7.b(36);
        r19.setMarginStart(c7.b(12));
        r17.setLayoutParams(r19);
    L47:
        r16.l.getBinding().h.setTypeface(Typeface.defaultFromStyle(0));
        Unit r110 = Unit.INSTANCE;
        goto L48
    L43:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L35:
        if (r9 != 2) goto L38;
        r16.l.c6(r16.k.getContext().getString(2131900590), null, new m(this));
        goto L47
    L38:
        throw new NoWhenBranchMatchedException();
    L31:
        r8 = ImageRemoveHostUiPolicy.TitleLeadingAction.CANCEL;
        goto L32
    L45:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L46:
        r16.l.c6(r16.k.getContext().getString(2131900590), null, new n(this));
    L48:
        ImageRemoveHostUiPolicy r111 = aa0();
        if (this.r == null) goto L51;
        boolean r20 = true;
    L53:
        if (r111.a == true) goto L55;
    L58:
        r4 = false;
    L59:
        if (r4 == false) goto L62;
        this.r = com.larus.utils.v.a(this, new c(this));
    L62:
        LarusFragmentImageRemoveBinding r112 = this.d;
        if (r112 == null) goto L65;
        w0.e(r112.c, c7.b(8));
        e1.d(r112.c, new o(this));
        e1.d(r112.j, new p(this));
        r112.f.setOnTouchListener(new q());
        Unit r113 = Unit.INSTANCE;
    L65:
        final LarusFragmentImageRemoveBinding r114 = this.d;
        if (r114 == null) goto L68;
        r114.b.setConfig(new PaletteControllerView.b(new PaintSizeControllerView.b(c7.b(24), c7.b(70), new u(r114, this)), new com.larus.uaigc.createpage.bussiness.remove.a(r114), new i(r114)));
        Unit r115 = Unit.INSTANCE;
    L68:
        LarusFragmentImageRemoveBinding r116 = this.d;
        if (r116 == null) goto L71;
        e1.d(r116.d, new f(this));
        Unit r117 = Unit.INSTANCE;
    L71:
        final LarusFragmentImageRemoveBinding r118 = this.d;
        if (r118 == null) goto L91;
        if (aa0().a == false) goto L89;
        ConstraintLayout.LayoutParams r21 = r118.d.getLayoutParams();
        if ((r21 instanceof ConstraintLayout.LayoutParams) == false) goto L79;
        ConstraintLayout.LayoutParams r22 = r21;
    L80:
        if (r22 == null) goto L82;
        final int r23 = ((ViewGroup.MarginLayoutParams) r22).bottomMargin;
    L83:
        final int r24 = c7.b(16);
        TextView r25 = r118.d;
        ?? r26 = new com.larus.uaigc.createpage.bussiness.remove.b(r118, r23, r24);
        Intrinsics.checkNotNullParameter(r25, "<this>");
        Intrinsics.checkNotNullParameter(r26, "callback");
        WindowInsetsCompat r119 = ViewCompat.getRootWindowInsets(r25);
        if (r119 == null) goto L88;
        Insets r120 = r119.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r120 == null) goto L88;
        r26.invoke(r120);
    L88:
        ViewCompat.setOnApplyWindowInsetsListener(r25, new f7(r26));
        goto L89
    L82:
        r23 = 0;
        goto L83
    L79:
        r22 = null;
    L89:
        Unit r121 = Unit.INSTANCE;
    L91:
        if (Build.VERSION.SDK_INT != 29) goto L114;
        int r122 = com.larus.uaigc.applet.a.a;
        if (IAICreationAppletHostService.a.t(getArguments()) == false) goto L115;
        ViewParent r123 = r10.getParent();
        if ((r123 instanceof ViewGroup) == false) goto L98;
        r0 = (ViewGroup) r123;
    L98:
        if (r0 == null) goto L116;
        ((ArrayList) this.u).clear();
        int r124 = r0.getChildCount();
    L101:
        if (r1 >= r124) goto L108;
        View r27 = r0.getChildAt(r1);
        if (r27 == r10) goto L107;
        if (r27.getVisibility() != 0) goto L107;
        List<View> r28 = this.u;
        Intrinsics.checkNotNull(r27);
        ((ArrayList) r28).add(r27);
        r27.setVisibility(4);
    L107:
        r1 = r1 + 1;
        goto L101
    L108:
        r10.bringToFront();
        r0.invalidate();
        FLogger.a.i("ImageRemoveFragment", "isolate applet page layer, coveredViews=" + ((ArrayList) this.u).size());
        return;
    L116:
        return;
    L115:
        return;
    L114:
        return;
    L55:
        if (r111.b == false) goto L58;
        if (r20 == true) goto L58;
    L51:
        r20 = false;
        goto L53
    }

    public static final Object S90(ImageRemoveFragment r5, mr9.l r6, Continuation r7) {
        r5.getClass();
        if ((r7 instanceof ImageRemoveFragment$handleUploadSuccess$1) == false) goto L7;
        ImageRemoveFragment$handleUploadSuccess$1 r0 = (ImageRemoveFragment$handleUploadSuccess$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (mr9.l) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L20:
        dm9.a.b r9 = (dm9.a) r8;
        boolean r10 = r9 instanceof dm9.a.b;
        if (r10 == false) goto L35;
        dm9.a.b r11 = r9;
        if (r11.a.isSuccess() == false) goto L35;
        ReviewUgcImageApi.c r12 = (ReviewUgcImageApi.c) r11.a.getData();
        if (r12 == null) goto L32;
        Integer r13 = r12.a();
        if (r13 == null) goto L32;
        if (r13.intValue() != 3) goto L32;
    L33:
        if (r4 == false) goto L35;
        r5.ba0();
    L41:
        return Unit.INSTANCE;
    L32:
        r4 = false;
    L35:
        if (r10 == false) goto L37;
    L39:
        r5.ca0(r6);
        goto L41
    L37:
        if (NetworkUtils.isNetworkAvailable(r5.getContext()) == true) goto L39;
        r5.ia0();
        t19.s r14 = t19.s.a;
        Context r15 = r5.getContext();
        r14.getClass();
        t19.s.s(r15, 2131908080);
        goto L41
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L17;
        r5.ca0(r6);
        return Unit.INSTANCE;
    L17:
        ReviewUgcImageApi.Companion r16 = ReviewUgcImageApi.a;
        ImageRemoveFragment$handleUploadSuccess$checkResult$1 r17 = new ImageRemoveFragment$handleUploadSuccess$checkResult$1(r6, null);
        r0.L$0 = r6;
        r0.label = 1;
        r16.getClass();
        r8 = ReviewUgcImageApi.Companion.a(r17, r0);
        if (r8 != r2) goto L20;
        return r2;
    L7:
        r0 = new ImageRemoveFragment$handleUploadSuccess$1(r5, r7);
        goto L8
    }

    public static final Object T90(ImageRemoveFragment r4, Bitmap r5, Continuation r6) {
        r4.getClass();
        if ((r6 instanceof ImageRemoveFragment$saveBitmapToStableCreationCache$1) == false) goto L7;
        ImageRemoveFragment$saveBitmapToStableCreationCache$1 r0 = (ImageRemoveFragment$saveBitmapToStableCreationCache$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        File r9 = (File) r0.L$0;
        ResultKt.throwOnFailure(r7);
        File r10 = r9;
    L19:
        if (((Boolean) r7).booleanValue() == true) goto L24;
        return null;
    L24:
        return r10;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        File r11 = ICreationWorkflowService.a.T("jpeg");
        String r3 = r11.getAbsolutePath();
        r0.L$0 = r11;
        r0.label = 1;
        Object r12 = BitmapHelperKt.e(r5, r3, 100, r0);
        if (r12 == r8) goto L23;
        r10 = r11;
        r7 = r12;
        goto L19
    L23:
        return r8;
    L7:
        r0 = new ImageRemoveFragment$saveBitmapToStableCreationCache$1(r4, r6);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static final Object U90(ImageRemoveFragment r34, Bundle r35, Continuation r36) {
        Bundle r1 = r35;
        r34.getClass();
        if ((r36 instanceof ImageRemoveFragment$toChatPage$1) == false) goto L7;
        ImageRemoveFragment$toChatPage$1 r3 = (ImageRemoveFragment$toChatPage$1) r36;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        boolean r7 = false;
        String r14 = null;
        if (r6 == 0) goto L18;
        if (r6 == 1) goto L17;
        if (r6 == 2) goto L16;
        if (r6 != 3) goto L15;
        int r8 = r3.I$0;
        Bundle r9 = (Bundle) r3.L$0;
        ResultKt.throwOnFailure(r2);
        ?? r10 = r8;
    L90:
        if (((Boolean) r2).booleanValue() == true) goto L140;
        Bundle r11 = r9;
    L93:
        ImageRemoveHostUiPolicy r12 = r34.aa0();
        CreationSendMessageConfig r13 = r34.t;
        if (r10 == 0) goto L96;
        boolean r15 = true;
    L98:
        if (r12.a == false) goto L102;
        if (r13 == null) goto L102;
        if (r15 == false) goto L102;
        boolean r16 = true;
    L103:
        if (r16 == false) goto L136;
        Context r17 = r34.getContext();
        if (r17 == null) goto L128;
        Bundle r18 = new Bundle(r11);
        CreationSendMessageConfig r19 = r34.t;
        if (r19 == null) goto L111;
        String r20 = r19.getBotId();
        if (r20 == null) goto L111;
    L119:
        r18.putString("argBotId", r20);
        CreationSendMessageConfig r21 = r34.t;
        if (r21 == null) goto L122;
        r14 = r21.getCvsId();
    L122:
        r18.putString("argConversationId", r14);
        r18.putInt("default_tab", TemplateInfo$DefaultTab.CHAT.ordinal());
        ICreationWorkflowService.Companion r22 = ICreationWorkflowService.a;
        Bundle r23 = r34.getArguments();
        if (r23 != null) goto L125;
    L127:
        r7 = r22.U(r17, r7, r18, true);
        goto L128
    L125:
        if (r23.getBoolean("is_from_chat_double_page") != true) goto L127;
        r7 = true;
    L111:
        r20 = r18.getString("argBotId");
        if (r20 != null) goto L119;
        e0 r24 = (e0) AuthModelDelegate.b.e().getValue();
        if (r24 == null) goto L118;
        LaunchInfo r25 = r24.a;
        if (r25 == null) goto L118;
        r20 = r25.W();
    L118:
        r20 = null;
    L128:
        if (r7 == true) goto L141;
        FLogger.a.e("ImageRemoveFragment", "toChatPage dispatch applet result failed, close applet after message prepared");
        int r26 = com.larus.uaigc.applet.a.a;
        if (IAICreationAppletHostService.a.i(true) == true) goto L142;
        FragmentActivity r0 = r34.getActivity();
        if (r0 == null) goto L142;
        r0.finish();
    L142:
        return Boxing.boxBoolean(true);
    L141:
        return Boxing.boxBoolean(true);
    L136:
        com.bytedance.router.i r27 = SmartRouter.buildRoute(r34.getContext(), "//flow/chat_page");
        r27.c.putExtras(r11);
        r27.d = 2130772401;
        r27.e = 2130772399;
        r27.d();
        return Boxing.boxBoolean(false);
    L102:
        r16 = false;
        goto L103
    L96:
        r15 = false;
        goto L98
    L140:
        return Boxing.boxBoolean(true);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        CreationSendMessageConfig r28 = (CreationSendMessageConfig) r3.L$1;
        Bundle r29 = (Bundle) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L35:
        boolean r30 = ((Boolean) r2).booleanValue();
        CreationSendMessageConfig r31 = r28;
        r10 = r30;
    L37:
        if (r31 == null) goto L40;
        if (r10 != 0) goto L40;
        FLogger.a.e("ImageRemoveFragment", "toChatPage sendCreationMessage failed");
        return Boxing.boxBoolean(false);
    L40:
        ImageRemoveHostUiPolicy r32 = r34.aa0();
        CreationSendMessageConfig r110 = r34.t;
        if (r32.a == false) goto L45;
        if (r110 == null) goto L45;
        if (r10 != 0) goto L45;
        boolean r33 = true;
    L46:
        if (r33 == false) goto L48;
        FLogger.a.e("ImageRemoveFragment", "toChatPage skip applet close because creation message was not sent");
        return Boxing.boxBoolean(false);
    L48:
        e0 r37 = (e0) AuthModelDelegate.b.e().getValue();
        if (r37 == null) goto L53;
        LaunchInfo r38 = r37.a;
        if (r38 == null) goto L53;
        String r39 = r38.W();
    L54:
        r11 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argBotId", r39)});
        Bundle r111 = r34.getArguments();
        if (r111 == null) goto L57;
        r11.putAll(r111);
    L57:
        if (r29 == null) goto L59;
        r11.putAll(r29);
    L59:
        if (r10 == 0) goto L75;
        r11.remove("image_edit_data.with_mask");
        r11.remove("creation_send_message_config");
        r11.remove("media_attachment");
        r11.remove("open_new_chat_page");
        r11.remove("ignore_image_size_check");
        r11.remove("actionbar_instruction_prompt");
        CreationSendMessageConfig r40 = r34.t;
        if (r40 == null) goto L63;
        String r41 = r40.getCvsId();
    L64:
        r11.putString("argConversationId", r41);
        CreationSendMessageConfig r42 = r34.t;
        if (r42 == null) goto L67;
        String r112 = r42.getCvsId();
    L68:
        CreationSendMessageConfig r43 = r34.t;
        if (r43 != null) goto L71;
    L73:
        boolean r210 = false;
    L74:
        r11.putSerializable("creation_send_ui_event", new CreationSendUiEvent(r112, null, false, true, true, true, true, false, false, true, true, true, true, r210, true, 390, null));
        goto L75
    L71:
        if (r43.getClearInputContent() != true) goto L73;
        r210 = true;
        goto L74
    L67:
        r112 = null;
        goto L68
    L63:
        r41 = null;
    L75:
        ImageRemoveHostUiPolicy r44 = r34.aa0();
        CreationSendMessageConfig r113 = r34.t;
        if (r44.a == false) goto L80;
        if (r113 == null) goto L80;
        if (r10 == 0) goto L80;
        boolean r45 = true;
    L81:
        if (r45 == false) goto L93;
        r3.L$0 = r11;
        r3.L$1 = null;
        r3.I$0 = r10;
        r3.label = 3;
        if (r34.aa0().a == true) goto L85;
        Object r46 = Boxing.boxBoolean(false);
    L86:
        if (r46 == r5) goto L145;
        Object r310 = r46;
        r9 = r11;
        r2 = r310;
        r10 = r10;
        goto L90
    L145:
        return r5;
    L85:
        r46 = BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new ImageRemoveFragment$tryDispatchCreationSendResultToCurrentChatBelowHost$2(r11, r34, null), r3);
    L80:
        r45 = false;
    L53:
        r39 = null;
    L45:
        r33 = false;
        goto L46
    L17:
        r1 = (Bundle) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L29:
        r31 = (CreationSendMessageConfig) r2;
        if (r31 == null) goto L36;
        r3.L$0 = r1;
        r3.L$1 = r31;
        r3.label = 2;
        Object r47 = r34.fa0(r31, r3);
        if (r47 == r5) goto L144;
        r29 = r1;
        r28 = r31;
        r2 = r47;
        goto L35
    L144:
        return r5;
    L36:
        r29 = r1;
        r10 = 0;
        goto L37
    L18:
        ResultKt.throwOnFailure(r2);
        if (r1 == null) goto L21;
        Serializable r48 = r1.getSerializable("image_edit_data.with_mask");
    L23:
        if ((r48 instanceof ImageEditDataWithMask) == false) goto L25;
        ImageEditDataWithMask r49 = (ImageEditDataWithMask) r48;
    L26:
        r3.L$0 = r1;
        r3.label = 1;
        r2 = r34.V90(r49, r1, r3);
        if (r2 != r5) goto L29;
        return r5;
    L25:
        r49 = null;
        goto L26
    L21:
        r48 = null;
    L7:
        r3 = new ImageRemoveFragment$toChatPage$1(r34, r36);
        goto L8
    }

    public final Object V90(ImageEditDataWithMask r39, Bundle r40, Continuation<? super CreationSendMessageConfig> r41) {
        if ((r41 instanceof ImageRemoveFragment$buildCreationSendMessageConfig$1) == false) goto L7;
        ImageRemoveFragment$buildCreationSendMessageConfig$1 r3 = (ImageRemoveFragment$buildCreationSendMessageConfig$1) r41;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L16;
        if (r6 != 1) goto L15;
        ImageRemoveFragment r0 = (ImageRemoveFragment) r3.L$2;
        Bundle r7 = (Bundle) r3.L$1;
        ImageEditDataWithMask r8 = (ImageEditDataWithMask) r3.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L76
        ImageEditDataWithMask r21 = r8;
    L34:
        CreationSendMessageConfig r9 = (CreationSendMessageConfig) r2;     // Catch: Throwable -> L76
        if (r9 != null) goto L37;
        return null;
    L37:
        r0.t = r9;     // Catch: Throwable -> L76
        if (r7 == null) goto L40;
        ICoreInputAbility.MessageExtMap r10 = (ICoreInputAbility.MessageExtMap) r7.getParcelable("actionbar_instruction_message_ext_map");     // Catch: Throwable -> L76
    L42:
        if ((r10 instanceof ICoreInputAbility.MessageExtMap) == true) goto L45;
        r10 = null;
    L45:
        if (r10 == null) goto L47;
        Map r11 = r10.a;     // Catch: Throwable -> L76
    L48:
        if (r11 == null) goto L54;
        Map<String, String> r12 = r9.getActionBarInstructionMap();     // Catch: Throwable -> L76
        if (r12 != null) goto L52;
        r12 = MapsKt.emptyMap();     // Catch: Throwable -> L76
    L52:
        Map<String, String> r13 = MapsKt.plus(r12, r11);     // Catch: Throwable -> L76
        if (r13 == null) goto L54;
    L55:
        if (r7 == null) goto L58;
        String r14 = r7.getString("creation_send_trace_id");     // Catch: Throwable -> L76
        if (r14 == null) goto L58;
    L59:
        String r27 = r14;
        Bundle r15 = r0.getArguments();     // Catch: Throwable -> L76
        if (r15 == null) goto L64;
        Bundle r16 = r15.getBundle("instruction_hit_point_params");     // Catch: Throwable -> L76
        if (r16 == null) goto L64;
        ny9.u r17 = new ny9.u(new ny9.s(r16));     // Catch: Throwable -> L76
    L65:
        if (r13 != null) goto L67;
        r13 = MapsKt.emptyMap();     // Catch: Throwable -> L76
    L67:
        zd9.h.a.getClass();     // Catch: Throwable -> L76
        String r18 = zd9.h.c(r21);     // Catch: Throwable -> L76
        if (r18 != null) goto L70;
        r18 = "";
    L70:
        Map r19 = MapsKt.plus(r13, MapsKt.mapOf(TuplesKt.to("image_edit_media_data", r18)));     // Catch: Throwable -> L76
        ny9.u r20 = r9.getHitPointData();     // Catch: Throwable -> L76
        if (r20 != null) goto L73;
        ny9.u r23 = r17;
    L74:
        CreationSendMessageConfig r22 = CreationSendMessageConfig.copy$default(r9, null, null, null, null, null, null, null, null, Boxing.boxInt(16), r19, null, null, r21, null, r23, null, null, null, r27, null, null, false, null, null, false, false, null, 133931263, null);     // Catch: Throwable -> L76
        r0.t = r22;     // Catch: Throwable -> L76
        Object r1 = Result.constructor-impl(r22);     // Catch: Throwable -> L76
    L78:
        Throwable r24 = Result.exceptionOrNull-impl(r1);
        if (r24 == null) goto L82;
        FLogger.a.e("ImageRemoveFragment", "buildCreationSendMessageConfig failed", r24);
    L82:
        if (Result.isFailure-impl(r1) == false) goto L85;
        return null;
    L85:
        return r1;
    L73:
        r23 = r20;
    L64:
        r17 = null;
    L58:
        r14 = r9.getCreationSendTraceId();     // Catch: Throwable -> L76
    L54:
        r13 = r9.getActionBarInstructionMap();     // Catch: Throwable -> L76
        goto L55
    L47:
        r11 = null;
        goto L48
    L40:
        r10 = null;
        goto L42
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r2);
        CreationSendMessageConfig r25 = this.t;
        if (r25 != null) goto L19;
        return null;
    L19:
        if (r39 != null) goto L22;
        return null;
    L22:
        if (aa0().a == true) goto L27;
        ICreationPageService.a.getClass();
        if (ICreationPageService.a.a() == true) goto L27;
        boolean r26 = false;
    L28:
        if (r26 == true) goto L30;
        return null;
    L30:
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L76
        r3.L$0 = r39;     // Catch: Throwable -> L76
        r3.L$1 = r40;     // Catch: Throwable -> L76
        r3.L$2 = this;     // Catch: Throwable -> L76
        r3.label = 1;     // Catch: Throwable -> L76
        r2 = W90(r25, r3);     // Catch: Throwable -> L76
        if (r2 != r5) goto L33;
        return r5;
    L33:
        r21 = r39;
        r0 = this;
        r7 = r40;
    L27:
        r26 = true;
    L76:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r3 = new ImageRemoveFragment$buildCreationSendMessageConfig$1(this, r41);
        goto L8
    }

    public final View onCreateView(LayoutInflater r19, ViewGroup r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r19, "inflater");
        ConstraintLayout r1 = r19.inflate(2131562399, r20, false);
        int r2 = 2131365416;
        if (((ImageView) ViewBindings.findChildViewById(r1, 2131365416)) == null) goto L46;
        r2 = 2131365424;
        if (((TextView) ViewBindings.findChildViewById(r1, 2131365424)) == null) goto L46;
        r2 = 2131367932;
        PaletteControllerView r6 = (PaletteControllerView) ViewBindings.findChildViewById(r1, 2131367932);
        if (r6 == null) goto L46;
        r2 = 2131371571;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131371571);
        if (r7 == null) goto L46;
        r2 = 2131372569;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r1, 2131372569);
        if (r8 == null) goto L46;
        r2 = 2131373895;
        View r9 = ViewBindings.findChildViewById(r1, 2131373895);
        if (r9 == null) goto L46;
        r2 = 2131377402;
        FrameLayout r10 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131377402);
        if (r10 == null) goto L46;
        r2 = 2131378977;
        ProgressBar r11 = (ProgressBar) ViewBindings.findChildViewById(r1, 2131378977);
        if (r11 == null) goto L46;
        r2 = 2131381846;
        GesturePaletteView r3 = (GesturePaletteView) ViewBindings.findChildViewById(r1, 2131381846);
        if (r3 == null) goto L46;
        r2 = 2131382097;
        PenSizeIllustrationView r13 = (PenSizeIllustrationView) ViewBindings.findChildViewById(r1, 2131382097);
        if (r13 == null) goto L46;
        r2 = 2131384469;
        LinearLayout r14 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131384469);
        if (r14 == null) goto L46;
        ConstraintLayout r4 = r1;
        NovaTitleBarEx r16 = ViewBindings.findChildViewById(r1, 2131388772);
        if (r16 == null) goto L44;
        final LarusFragmentImageRemoveBinding r5 = new LarusFragmentImageRemoveBinding(r4, r6, r7, r8, r9, r10, r11, r3, r13, r14, r4, r16);
        this.d = r5;
        String r12 = this.j;
        if (r12 == null) goto L29;
        ja0();
        ea0(UriProtector.parse(r12));
        Unit r15 = Unit.INSTANCE;
    L42:
        r3.setTransformImageListener(new ImageRemoveFragment$initPalette$1$3(this, r5));
        r3.setPenPxSize(this.l);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ImageRemoveFragment$initPalette$1$4(r5, this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ImageRemoveFragment$initPalette$1$5(r5, null), 3, null);
        return r4;
    L29:
        MediaAttachment r17 = this.i;
        if (r17 == null) goto L39;
        String r18 = r17.getLocalFilePath();
        if (r18 != null) goto L34;
        r18 = "";
    L34:
        Uri r22 = UriProtector.parse(r18);
        FragmentActivity r23 = getActivity();
        if (r23 == null) goto L37;
        File r24 = r23.getCacheDir();
    L38:
        r3.q(r22, Uri.fromFile(new PolarisFileWrapper(r24, "ugc_image_edit_cache.jpeg")));
        Unit r25 = Unit.INSTANCE;
    L40:
        if (r25 != null) goto L42;
        ga0();
        goto L42
    L37:
        r24 = null;
        goto L38
    L39:
        r25 = null;
        goto L40
    L44:
        r2 = 2131388772;
    L46:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }
}
