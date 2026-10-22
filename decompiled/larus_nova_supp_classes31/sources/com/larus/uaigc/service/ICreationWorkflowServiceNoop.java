package com.larus.uaigc.service;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewStub;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.creative.loading.CreationQueuingTaskUIState;
import com.larus.bmhome.creative.loading.MessageLoadingUIState;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreation;
import com.larus.trace.CopyContentTypeString;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001e\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J \u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0016J \u0010\u0019\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0016J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\rH\u0016J\u0016\u0010\u001f\u001a\u00020\r2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050!H\u0016J\b\u0010\"\u001a\u00020\rH\u0016J\u0012\u0010#\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J4\u0010&\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00050+H\u0016J$\u0010,\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00050+H\u0016J(\u0010-\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\rH\u0016J\u0018\u00100\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u0002012\u0006\u00102\u001a\u000203H\u0016J6\u00104\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00105\u001a\u00020\r2\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u0005\u0018\u00010+H\u0016J\u0018\u00108\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u0002012\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020>H\u0016J*\u0010?\u001a\u0004\u0018\u00010@2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0096@¢\u0006\u0002\u0010EJ*\u0010F\u001a\u0004\u0018\u00010@2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0096@¢\u0006\u0002\u0010EJ\b\u0010G\u001a\u00020HH\u0016J(\u0010I\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010J\u001a\b\u0012\u0004\u0012\u00020L0K2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J \u0010O\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020QH\u0016J\u0010\u0010S\u001a\u00020@2\u0006\u0010T\u001a\u00020DH\u0016J\b\u0010U\u001a\u00020VH\u0016J\u0010\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZH\u0016J.\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020Z2\u0014\u0010`\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020c\u0018\u00010b0aH\u0016J\b\u0010d\u001a\u00020\u0005H\u0016J\u0016\u0010e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020fH\u0096@¢\u0006\u0002\u0010g¨\u0006h"}, d2 = {"Lcom/larus/uaigc/service/ICreationWorkflowServiceNoop;", "Lcom/larus/uaigc/service/ICreationWorkflowService;", "<init>", "()V", "openCreatePage", "", "config", "Lcom/larus/uaigc/bean/createpage/ICreatePageConfig;", "openCreatePageForResult", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "openAICreationAppletCreatePage", "", "openCanvasInAICreationApplet", "Lcom/larus/canvas/service/bean/ICanvasInitConfig;", "getCanvasInAICreationAppletIntent", "prewarmAICreationApplet", "shouldOpenAICreationAppletFromBottomTab", "openCreationDetailInApplet", "context", "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "asRoot", "openImageRemoveInApplet", "openProfileInApplet", "openNativeMineProfileFromAICreationApplet", "notifyAICreationAppletPublishSuccess", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "navigateBackInAICreationApplet", "onFallback", "Lkotlin/Function0;", "closeAICreationApplet", "isAICreationAppletActivity", "activity", "Landroid/app/Activity;", "routeNativeBelowAICreationApplet", "clearAICreationHomeMemory", "closeDelayMs", "", "routeAction", "Lkotlin/Function1;", "routeNativeBelowAICreationAppletAndMoveToBack", "openChatBelowAICreationAppletIfNeeded", "isChatDoublePage", "params", "sendRemoteImageAndTextMessage", "Lcom/larus/uaigc/bean/ImageEditSendMessageStrategyConfig;", "instructionType", "", "sendImageAndTextMessage", "needPreprocessImage", "uploadSuccessCallback", "Lcom/larus/uaigc/bean/UploadSuccessData;", "sendImageRemoveMessage", "imageEditDataWithMask", "Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;", "getAspectRatioSelectStrategy", "Lcom/larus/uaigc/bean/IAspectRatioSelectStrategy;", "getCreationIntent", "Lcom/larus/uaigc/bean/createpage/CreatePageConfig;", "saveBitmapToCleanableDir", "Ljava/io/File;", "bitmap", "Landroid/graphics/Bitmap;", "fileName", "", "(Landroid/content/Context;Landroid/graphics/Bitmap;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveBitMapToFile", "createImageRemoveDialogFragment", "Lcom/larus/uaigc/bean/remove/IImageRemoveDialogFragment;", "openBigImagesFragment", "properties", "Lcom/larus/uaigc/bean/chat/ImageDetailFragmentProp;", "Lcom/larus/bmhome/creation/bean/ICreationContentData;", "galleryContext", "Lcom/larus/uaigc/bean/chat/gallery/CreationGalleryContext;", "copyUri", "sourceUri", "Landroid/net/Uri;", "destinationUri", "buildSendImgCacheFile", "formatSuffix", "creationPagePerfMonitorHelper", "Lcom/larus/uaigc/bean/createpage/trace/ICreationPagePerfMonitorHelper;", "createCreationQueuingTaskViewModel", "Lcom/larus/bmhome/chat/component/loading/ICreationQueuingTaskViewModel;", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "createImageLoadingProgressComponent", "Lcom/larus/uaigc/bean/chat/loading/ILoadingProgress;", "sketchProgressLoadingViewStub", "Landroid/view/ViewStub;", "scope", "loadingProgressState", "Lkotlin/Lazy;", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/bmhome/creative/loading/MessageLoadingUIState;", "clearCreationActionbarDependencyCache", "sendCreationMessage", "Lcom/larus/uaigc/bean/createpage/CreationSendMessageConfig;", "(Lcom/larus/uaigc/bean/createpage/CreationSendMessageConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ICreationWorkflowServiceNoop implements ICreationWorkflowService {

    public static final class a implements zd8.a {
        public final StateFlowImpl a;
        public final MutableSharedFlow b;

        public final void B8(boolean r1, Message r2, String r3) {
        }

        public final void C8(List<Message> r2) {
            Intrinsics.checkNotNullParameter(r2, "lastMsgList");
        }

        public final void onClear() {
        }

        public a() {
            this.a = j1.a(new CreationQueuingTaskUIState(null, 1, null));
            this.b = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        }

        public final i1<CreationQueuingTaskUIState> D8() {
            return this.a;
        }

        public final d1<Message> R2() {
            return this.b;
        }
    }

    public static final class b implements ly9.a {
        public b() {
        }

        @Override // ly9.a
        public final void a(String r1, Message r2) {
        }
    }

    public static final class c implements xy9.b {
        public c() {
        }

        @Override // xy9.b
        public final void K00(Bundle r1, xy9.a r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r1, "bundle");
            Intrinsics.checkNotNullParameter(r2, "callback");
        }

        @Override // xy9.b
        public final void dismiss() {
        }

        @Override // xy9.b
        public final void show(FragmentManager r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "manager");
        }
    }

    public static final class d implements vy9.a {
        public d() {
        }

        @Override // vy9.a
        public final void a() {
            Intrinsics.checkNotNullParameter("1", CopyContentTypeString.CODE);
        }
    }

    public static final class e implements hy9.c {
        public e() {
        }

        @Override // hy9.c
        public final void a(List<com.larus.bmhome.actionbar.model.w> r2) {
            Intrinsics.checkNotNullParameter(r2, "optionList");
        }

        @Override // hy9.c
        public final Long b(double r1) {
            return null;
        }
    }

    public ICreationWorkflowServiceNoop() {
    }

    public final void A(ActivityResultLauncher<Intent> r2, ny9.c r3) {
        Intrinsics.checkNotNullParameter(r2, "activityResultLauncher");
        Intrinsics.checkNotNullParameter(r3, "config");
    }

    public final void G(hy9.f r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "config");
    }

    public final void J() {
    }

    public final boolean K(Context r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bundle");
        return false;
    }

    public final boolean L() {
        return false;
    }

    public final void M(FragmentActivity r2, Uri r3, Uri r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "sourceUri");
        Intrinsics.checkNotNullParameter(r4, "destinationUri");
    }

    public final boolean N(ny8.e r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return false;
    }

    public final boolean O(Context r1, Bundle r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "bundle");
        return false;
    }

    public final void Q(hy9.f r1, int r2, boolean r3, Function1<? super hy9.j, Unit> r4) {
        Intrinsics.checkNotNullParameter(r1, "config");
    }

    public final void R(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    public final boolean S(Context r2, Function1<? super Context, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "routeAction");
        return false;
    }

    public final boolean U(Context r1, boolean r2, Bundle r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "params");
        return false;
    }

    public final boolean V() {
        return false;
    }

    public final void X() {
    }

    public final boolean Z() {
        return false;
    }

    public final boolean a0(Context r1, long r2, Function1 r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r4, "routeAction");
        return false;
    }

    public final void b0(Context r1, iy9.a<? extends zo8.a> r2, jy9.x r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "properties");
    }

    public final boolean c0(ny9.b r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return false;
    }

    public final boolean d0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return false;
    }

    public final Object e(Context r1, Bitmap r2, String r3, Continuation<? super File> r4) {
        return null;
    }

    public final boolean e0(Context r1, Bundle r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "bundle");
        return false;
    }

    public final void f0(ny9.c r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
    }

    public final Object m(Context r1, Bitmap r2, String r3, Continuation<? super File> r4) {
        return null;
    }

    public final void x(hy9.f r2, ImageEditDataWithMask r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "imageEditDataWithMask");
    }

    public final xy9.b E() {
        return new c();
    }

    public final hy9.c F() {
        return new e();
    }

    public final vy9.a Y() {
        return new d();
    }

    public final boolean H(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onFallback");
        r2.invoke();
        return false;
    }

    public final zd8.a P(CoroutineScope r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModelScope");
        return new a();
    }

    public final File T(String r2) {
        Intrinsics.checkNotNullParameter(r2, "formatSuffix");
        return new PolarisFileWrapper("");
    }

    public final Object W(CreationSendMessageConfig r1, Continuation<? super Boolean> r2) {
        return Boxing.boxBoolean(false);
    }

    public final ly9.a I(ViewStub r2, CoroutineScope r3, Lazy<? extends i1<MessageLoadingUIState>> r4) {
        Intrinsics.checkNotNullParameter(r2, "sketchProgressLoadingViewStub");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "loadingProgressState");
        return new b();
    }
}
