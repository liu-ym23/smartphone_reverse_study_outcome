package com.larus.canvas.feature.component.logic;

import android.net.Uri;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.canvas.feature.component.base.ImageResId;
import com.larus.canvas.feature.component.base.TextRes;
import com.larus.canvas.feature.component.logic.exit.CanvasExitAnchorManager;
import com.larus.canvas.feature.host.CanvasHostUiPolicy;
import com.larus.canvas.service.bean.AIBeautify;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u0089\u00012\u00020\u0001:\u0002\u0089\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020@H\u0016J\b\u0010B\u001a\u00020@H\u0016J\b\u0010C\u001a\u00020@H\u0016J\b\u0010D\u001a\u00020@H\u0002J\b\u0010E\u001a\u00020@H\u0002J\u0010\u0010F\u001a\u00020@2\u0006\u0010G\u001a\u00020HH\u0002J\b\u0010I\u001a\u00020@H\u0003J\b\u0010J\u001a\u00020KH\u0002J\u0010\u0010L\u001a\u00020@2\u0006\u0010M\u001a\u00020NH\u0002J\u0012\u0010O\u001a\u00020@2\b\b\u0002\u0010P\u001a\u00020KH\u0002J\b\u0010Q\u001a\u00020KH\u0002J\b\u0010R\u001a\u00020@H\u0002J\b\u0010S\u001a\u00020@H\u0002J\u0010\u0010T\u001a\u00020@2\u0006\u0010M\u001a\u00020UH\u0002J\u0010\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020YH\u0002J\u0018\u0010Z\u001a\u00020@2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u000203H\u0002J\u0014\u0010^\u001a\u0004\u0018\u00010W2\b\u0010_\u001a\u0004\u0018\u00010`H\u0002J\u0016\u0010a\u001a\b\u0012\u0004\u0012\u00020c0b2\u0006\u0010d\u001a\u00020KH\u0002Jå\u0001\u0010e\u001a\u00020@2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010h\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010j\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010l\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010m\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010n\u001a\u0004\u0018\u00010o2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010o2\n\b\u0002\u0010q\u001a\u0004\u0018\u00010o2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010o2\n\b\u0002\u0010s\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010t\u001a\u0004\u0018\u00010o2\n\b\u0002\u0010u\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010v\u001a\u0004\u0018\u00010o2\n\b\u0002\u0010w\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010x\u001a\u0004\u0018\u00010WH\u0002¢\u0006\u0002\u0010yJ\b\u0010z\u001a\u00020@H\u0002J\b\u0010{\u001a\u00020|H\u0002J\u0012\u0010}\u001a\u00020@2\b\u0010~\u001a\u0004\u0018\u00010cH\u0002J\u0011\u0010\u007f\u001a\u00020@2\u0007\u0010M\u001a\u00030\u0080\u0001H\u0002J\t\u0010\u0081\u0001\u001a\u00020@H\u0002J\u0016\u0010\u0082\u0001\u001a\u00020@2\u000b\b\u0002\u0010\u0083\u0001\u001a\u0004\u0018\u00010WH\u0002J\t\u0010\u0084\u0001\u001a\u00020@H\u0002J\t\u0010\u0085\u0001\u001a\u00020KH\u0002J\u0011\u0010\u0086\u0001\u001a\n\u0012\u0005\u0012\u00030\u0088\u00010\u0087\u0001H\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b%\u0010&R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\t\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\t\u001a\u0004\b/\u00100R#\u00102\u001a\n 4*\u0004\u0018\u000103038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\t\u001a\u0004\b5\u00106R\u001b\u00108\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\t\u001a\u0004\b:\u0010;R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008a\u0001"}, d2 = {"Lcom/larus/canvas/feature/component/logic/GenImageUIActionReceiverComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "<init>", "()V", "canvasTitleAbility", "Lcom/larus/canvas/feature/component/title/ITitleAbility;", "getCanvasTitleAbility", "()Lcom/larus/canvas/feature/component/title/ITitleAbility;", "canvasTitleAbility$delegate", "Lkotlin/Lazy;", "imagePagerAbility", "Lcom/larus/canvas/feature/component/resultdisplay/image/IImagePagerAbility;", "getImagePagerAbility", "()Lcom/larus/canvas/feature/component/resultdisplay/image/IImagePagerAbility;", "imagePagerAbility$delegate", "genImagePlannerAbility", "Lcom/larus/canvas/feature/component/logic/IGenImagePlannerAbility;", "getGenImagePlannerAbility", "()Lcom/larus/canvas/feature/component/logic/IGenImagePlannerAbility;", "genImagePlannerAbility$delegate", "canvasInputAbility", "Lcom/larus/canvas/feature/ability/CanvasInputAbility;", "getCanvasInputAbility", "()Lcom/larus/canvas/feature/ability/CanvasInputAbility;", "canvasInputAbility$delegate", "canvasContainerAbility", "Lcom/larus/canvas/feature/ability/CanvasContainerAbility;", "getCanvasContainerAbility", "()Lcom/larus/canvas/feature/ability/CanvasContainerAbility;", "canvasContainerAbility$delegate", "imageDownloadAbility", "Lcom/larus/canvas/feature/component/logic/ImageOperatorAbility;", "getImageDownloadAbility", "()Lcom/larus/canvas/feature/component/logic/ImageOperatorAbility;", "imageDownloadAbility$delegate", "canvasGenImageTraceAbility", "Lcom/larus/canvas/feature/component/logic/trace/CanvasGenImageTraceAbility;", "getCanvasGenImageTraceAbility", "()Lcom/larus/canvas/feature/component/logic/trace/CanvasGenImageTraceAbility;", "canvasGenImageTraceAbility$delegate", "argumentData", "Lcom/larus/canvas/feature/data/CanvasArgumentData;", "getArgumentData", "()Lcom/larus/canvas/feature/data/CanvasArgumentData;", "argumentData$delegate", "hostUiPolicy", "Lcom/larus/canvas/feature/host/CanvasHostUiPolicy;", "getHostUiPolicy", "()Lcom/larus/canvas/feature/host/CanvasHostUiPolicy;", "hostUiPolicy$delegate", "inputTouchInterceptView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getInputTouchInterceptView", "()Landroid/view/View;", "inputTouchInterceptView$delegate", "canvasGalleryContext", "Lcom/larus/canvas/feature/component/logic/provider/CanvasGalleryContext;", "getCanvasGalleryContext", "()Lcom/larus/canvas/feature/component/logic/provider/CanvasGalleryContext;", "canvasGalleryContext$delegate", "pickPhotoHelper", "Lcom/larus/bmhome/instruction/helper/IAiBeautifyPickPhotoHelper;", "onAttach", "", "afterViewBind", "onStop", "onDestroy", "notifyCanvasExit", "initPickPhotoHelper", "onAlbumSelected", "uri", "Landroid/net/Uri;", "bindObservers", "shouldHandleCanvasBackPressed", "", "handleContainerUIAction", "action", "Lcom/larus/canvas/feature/ability/CanvasContainerUIAction;", "handleExitRequest", "fromTitleLeftButton", "shouldConfirmUnsavedGeneratedImages", "showUnsavedGeneratedImagesDialog", "showQuitConfirmPopUpMenu", "handleImagePagerUIAction", "Lcom/larus/canvas/feature/component/resultdisplay/image/ImagePagerUIAction;", "getOriginalImagePath", "", "originalImage", "Lcom/larus/canvas/feature/component/logic/bean/OriginalImageItem;", "showCanvasGalleryDialog", "pageItemData", "Lcom/larus/canvas/feature/component/resultdisplay/image/PageItemData;", "startView", "getImageEditFunctionId", "targetTaskItem", "Lcom/larus/canvas/feature/component/logic/bean/GenImageTaskItem;", "getTopProvider", "Lcom/larus/gallery/api/IGalleryComponentProvider;", "Lcom/larus/canvas/feature/component/logic/bean/CanvasGalleryDataItem;", "enablePreview", "reportEnterPictureDetail", "botId", "aiCreateShowMode", "creationTaskId", "conversationId", "chatType", "currentPage", "enterFrom", "enterMethod", "index", "", "isCreation", "isDeepThinking", "isImageEdit", "imageEditFunctionId", "isReplicaGen", "messageId", "position", "slideStatus", "userType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "dismissPreviewDialog", "createSidebarCallback", "Lcom/larus/canvas/feature/component/logic/provider/ICanvasGallerySidebarCallback;", "skipToVideoCreationPage", "data", "handleTitleUIAction", "Lcom/larus/canvas/feature/component/title/TitleUIAction;", "exitCanvas", "handleSaveClick", "localId", "handleQuitFlow", "isCanvasGenerating", "buildQuitConfirmPopUpMenuItems", "", "Lcom/larus/canvas/feature/component/title/widget/DropdownItemData;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GenImageUIActionReceiverComponent extends BaseContentWidget {
    public static final /* synthetic */ int y = 0;
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
    public com.larus.bmhome.instruction.helper.f x;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CanvasHostUiPolicy.ExitBehavior.values().length];
            r0[CanvasHostUiPolicy.ExitBehavior.HOST_BACK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[CanvasHostUiPolicy.ExitBehavior.HOST_CLOSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[CanvasHostUiPolicy.ExitBehavior.NATIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public final List<ly8.g> Y2() {
        return CollectionsKt.listOf(new ly8.g[]{new ly8.g("edit_again", new ImageResId(2131241721), new TextRes.StringResId(2131900598), ContextCompat.getColor(getContext(), 2131103681)), new ly8.g("quit", new ImageResId(2131240868), new TextRes.StringResId(2131900599), ContextCompat.getColor(getContext(), 2131101300))});
    }

    public final n2 B3() {
        return (n2) this.o.getValue();
    }

    public final com.larus.canvas.feature.component.resultdisplay.image.r D3() {
        return (com.larus.canvas.feature.component.resultdisplay.image.r) this.n.getValue();
    }

    public final void P2() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GenImageUIActionReceiverComponent$bindObservers$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GenImageUIActionReceiverComponent$bindObservers$2(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GenImageUIActionReceiverComponent$bindObservers$3(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GenImageUIActionReceiverComponent$bindObservers$4(this, null), 3, null);
        F2().setOnClickListener(new x1(this));
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.larus.utils.v.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), new y1(this));
    }

    public final void h3() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r0 == null) goto L10;
        FragmentManager r1 = r0.getSupportFragmentManager();
        if (r1 == null) goto L11;
        Fragment r2 = r1.findFragmentByTag("CanvasGalleryDialog");
        if (r2 == null) goto L12;
        r1.beginTransaction().remove(r2).commitAllowingStateLoss();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void m3() {
        com.larus.canvas.feature.component.logic.trace.a r0 = (com.larus.canvas.feature.component.logic.trace.a) this.s.getValue();
        if (r0 == null) goto L5;
        r0.OV();
    L5:
        CanvasHostUiPolicy r1 = (CanvasHostUiPolicy) this.u.getValue();
        if (r1.a == true) goto L9;
        CanvasHostUiPolicy.ExitBehavior r2 = CanvasHostUiPolicy.ExitBehavior.NATIVE;
    L12:
        int r3 = b.a[r2.ordinal()];
        boolean r4 = true;
        if (r3 != 1) goto L15;
        ICreationWorkflowService.a.H(new w1(this));
    L33:
        com.larus.canvas.feature.component.logic.trace.a r5 = (com.larus.canvas.feature.component.logic.trace.a) this.s.getValue();
        if (r5 == null) goto L37;
        r5.xx("leave");
        return;
    L37:
        return;
    L15:
        if (r3 == 2) goto L30;
        if (r3 != 3) goto L28;
        my8.q r6 = p3();
        if (r6 != null) goto L21;
    L23:
        r4 = false;
    L24:
        if (r4 == false) goto L26;
        AppHost.a.a().k();
        goto L33
    L26:
        s1a.a.getActivity(this).finish();
        goto L33
    L21:
        if (((Boolean) r6.f.getValue()).booleanValue() != true) goto L23;
    L28:
        throw new NoWhenBranchMatchedException();
    L30:
        if (ICreationWorkflowService.a.L() == true) goto L33;
        s1a.a.getActivity(this).finish();
        goto L33
    L9:
        if (r1.b == false) goto L11;
        r2 = CanvasHostUiPolicy.ExitBehavior.HOST_CLOSE;
        goto L12
    L11:
        r2 = CanvasHostUiPolicy.ExitBehavior.HOST_BACK;
        goto L12
    }

    public final my8.q p3() {
        return (my8.q) this.t.getValue();
    }

    public final void y2() {
        IAIChatUgcAIGCService.Companion r0 = IAIChatUgcAIGCService.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.larus.bmhome.instruction.helper.f r1 = r0.H0(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        r1.b(new v1(this));
        this.x = r1;
    }

    public final com.larus.canvas.feature.component.logic.provider.j z3() {
        return (com.larus.canvas.feature.component.logic.provider.j) this.w.getValue();
    }

    public GenImageUIActionReceiverComponent() {
        this.m = LazyKt.lazy(new t1(this));
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        this.n = LazyKt.lazy(r0, new a2(this));
        this.o = LazyKt.lazy(new b2(this));
        this.p = LazyKt.lazy(new c2(this));
        this.q = LazyKt.lazy(new d2(this));
        this.r = LazyKt.lazy(new e2(this));
        this.s = LazyKt.lazy(new f2(this));
        this.t = LazyKt.lazy(r0, new g2(this));
        this.u = LazyKt.lazy(r0, new h2(this));
        this.v = LazyKt.lazy(new u1(this));
        this.w = LazyKt.lazy(new z1(this));
    }

    public final void onStop() {
        n2 r0 = B3();
        String r1 = null;
        if (r0 == null) goto L9;
        kotlinx.coroutines.flow.b1 r2 = r0.tx();
        if (r2 == null) goto L9;
        Pair r3 = (Pair) r2.getValue();
        if (r3 == null) goto L9;
        ky8.h r4 = (ky8.h) r3.getSecond();
    L11:
        if ((r4 instanceof ky8.f) == false) goto L13;
        ky8.f r5 = (ky8.f) r4;
    L14:
        Lazy r6 = CanvasExitAnchorManager.a;
        if (r5 == null) goto L17;
        String r7 = r5.j();
    L18:
        n2 r8 = B3();
        if (r8 == null) goto L23;
        Pair<String, String> r9 = r8.j50();
        if (r9 == null) goto L23;
        r1 = (String) r9.getSecond();
    L23:
        n2 r10 = B3();
        if (r10 == null) goto L26;
        boolean r11 = r10.M20();
    L27:
        CanvasExitAnchorManager.a(r7, r1, r11);
        return;
    L26:
        r11 = false;
        goto L27
    L17:
        r7 = null;
        goto L18
    L13:
        r5 = null;
    L9:
        r4 = null;
        goto L11
    }

    public final void onDestroy() {
        h3();
    }

    public static String E3(ky8.k r3) {
        ky8.j r0 = r3.b;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.e;
    L6:
        String r4 = "";
        if (com.larus.utils.o0.d(r2) == false) goto L18;
        ky8.j r5 = r3.b;
        if (r5 == null) goto L11;
        r1 = r5.e;
    L11:
        if (r1 != null) goto L13;
        r1 = "";
    L13:
        String r6 = UriProtector.parse(com.larus.canvas.feature.component.logic.helper.a.a(r1)).getPath();
        if (r6 == null) goto L17;
        r4 = r6;
    L17:
        String r7 = Uri.fromFile(new PolarisFileWrapper(r4)).toString();
        Intrinsics.checkNotNull(r7);
        return r7;
    L18:
        ky8.j r8 = r3.b;
        if (r8 == null) goto L26;
        String r9 = r8.b;
        if (r9 != null) goto L24;
        return "";
    L24:
        return r9;
    L26:
        return "";
    L5:
        r2 = null;
        goto L6
    }

    public final String C3(ky8.f r5) {
        if (r5 == null) goto L5;
        AIBeautify r1 = r5.c();
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        AIBeautify r2 = r5.c();
        boolean r3 = false;
        if (r2 == null) goto L11;
        boolean r4 = Intrinsics.areEqual(r2.isExpand, Boolean.TRUE);
    L12:
        if (r4 == false) goto L15;
        return "2";
    L15:
        AIBeautify r6 = r5.c();
        if (r6 == null) goto L18;
        boolean r7 = Intrinsics.areEqual(r6.isErase, Boolean.TRUE);
    L19:
        if (r7 == false) goto L22;
        return "3";
    L22:
        AIBeautify r8 = r5.c();
        if (r8 == null) goto L25;
        r3 = Intrinsics.areEqual(r8.isQualityImprove, Boolean.TRUE);
    L25:
        if (r3 == false) goto L28;
        return "1";
    L28:
        return null;
    L18:
        r7 = false;
        goto L19
    L11:
        r4 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r7v5 */
    public final void G3(boolean r7) {
        my8.q r0 = p3();
        boolean r1 = true;
        int r2 = 0;
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        ?? r4 = 0;
        String r5 = null;
        r5 = null;
        String r6 = null;
        r6 = null;
        r4 = 0;
        r4 = 0;
        r4 = 0;
        r4 = 0;
        if (r3 == true) goto L43;
        if (r7 == false) goto L23;
        com.larus.canvas.feature.component.title.k r8 = (com.larus.canvas.feature.component.title.k) this.m.getValue();
        if (r8 == null) goto L14;
        r8.yS(new com.larus.canvas.feature.component.title.m.a(Y2()));
    L14:
        n2 r9 = B3();
        if (r9 == null) goto L19;
        Long r10 = r9.XF();
        if (r10 == null) goto L19;
        r5 = r10.toString();
    L19:
        n2 r11 = B3();
        if (r11 == null) goto L22;
        r2 = r11.re();
    L22:
        com.larus.canvas.feature.component.logic.helper.d.a(r5, Integer.valueOf(r2));
        return;
    L23:
        com.larus.canvas.feature.component.title.k r12 = (com.larus.canvas.feature.component.title.k) this.m.getValue();
        if (r12 != null) goto L26;
    L28:
        r1 = false;
    L29:
        if (r1 == true) goto L39;
        n2 r13 = B3();
        if (r13 == null) goto L35;
        Long r14 = r13.XF();
        if (r14 == null) goto L35;
        r6 = r14.toString();
    L35:
        n2 r15 = B3();
        if (r15 == null) goto L38;
        r2 = r15.re();
    L38:
        com.larus.canvas.feature.component.logic.helper.d.a(r6, Integer.valueOf(r2));
    L39:
        com.larus.canvas.feature.component.title.k r16 = (com.larus.canvas.feature.component.title.k) this.m.getValue();
        if (r16 == null) goto L129;
        r16.yS(new com.larus.canvas.feature.component.title.m.a(Y2()));
        return;
    L129:
        return;
    L26:
        if (r12.WC() != true) goto L28;
    L43:
        n2 r17 = B3();
        if (r17 == null) goto L48;
        Long r18 = r17.XF();
        if (r18 == null) goto L48;
        String r19 = r18.toString();
    L49:
        n2 r20 = B3();
        if (r20 == null) goto L52;
        int r21 = r20.re();
    L53:
        com.larus.canvas.feature.component.logic.helper.d.a(r19, Integer.valueOf(r21));
        n2 r22 = B3();
        if (r22 == null) goto L75;
        kotlinx.coroutines.flow.i1<ky8.g> r23 = r22.bt();
        if (r23 == null) goto L75;
        ky8.g r24 = (ky8.g) r23.getValue();
        if (r24 == null) goto L75;
        Map<String, ky8.h> r25 = r24.a;
        if (r25 == null) goto L75;
        Collection<ky8.h> r26 = r25.values();
        if (r26 == null) goto L75;
        ArrayList r27 = new ArrayList();
        Iterator r28 = r26.iterator();
    L65:
        if (r28.hasNext() == false) goto L69;
        Object r29 = r28.next();
        if ((r29 instanceof ky8.f) == false) goto L65;
        r27.add(r29);
        goto L65
    L69:
        r4 = new ArrayList();
        Iterator r30 = r27.iterator();
    L71:
        if (r30.hasNext() == false) goto L75;
        Object r31 = r30.next();
        if (((ky8.f) r31).l() == false) goto L71;
        r4.add(r31);
    L75:
        if (r4 != 0) goto L78;
        r4 = CollectionsKt.emptyList();
    L78:
        if ((!((Collection) r4).isEmpty()) == false) goto L96;
        Iterable r32 = (Iterable) r4;
        if ((r32 instanceof Collection) == true) goto L82;
    L84:
        Iterator r33 = r32.iterator();
    L86:
        if (r33.hasNext() == false) goto L93;
        if (((ky8.f) r33.next()).g != 2) goto L90;
        boolean r34 = true;
    L91:
        if (r34 == false) goto L86;
        boolean r35 = false;
    L94:
        if (r35 == false) goto L96;
    L97:
        if (r1 == false) goto L108;
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentManager r36 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getChildFragmentManager();
        if (r36.isStateSaved() == false) goto L101;
        return;
    L101:
        if (r36.findFragmentByTag("CanvasUnsavedExitDialog") != null) goto L132;
        CommonDialog.a r37 = new CommonDialog.a();
        int r38 = com.larus.utils.j0.a;
        r37.i(com.larus.utils.j0.e("larus_canvas_unsaved_exit_dialog_title"));
        CommonDialog.a.e(r37, new k2(), getContext().getString(2131900600), 4);
        CommonDialog.a.f(r37, new l2(this), com.larus.utils.j0.e("larus_canvas_unsaved_exit_dialog_confirm"), false, 12);
        r37.z = false;
        CommonDialog r39 = r37.c();
        LandscapeRestrictionOperation r40 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r39, "CanvasUnsavedExitDialog", r40);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r36, r39, r40) == true) goto L133;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L110
    L107:
        r39.show(r36, "CanvasUnsavedExitDialog");
        return;
    L133:
        return;
    L132:
        return;
    L108:
        m3();
        return;
    L90:
        r34 = false;
    L93:
        r35 = true;
        goto L94
    L82:
        if (((Collection) r32).isEmpty() == false) goto L84;
    L96:
        r1 = false;
        goto L97
    L52:
        r21 = 0;
    L48:
        r19 = null;
        goto L49
    L5:
        if (((Boolean) r0.b.getValue()).booleanValue() != true) goto L7;
        r3 = true;
        goto L8
    }

    public final void H3(String r10) {
        o2 r0 = (o2) this.r.getValue();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        return;
    L10:
        String r3 = null;
        if (r10 == null) goto L17;
        n2 r4 = B3();
        if (r4 == null) goto L15;
        ky8.f r5 = r4.O30(r10);
    L16:
        if (r5 == null) goto L17;
    L29:
        IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r6 == null) goto L38;
        r6.D0();
        com.larus.home.impl.sdk.b1 r7 = com.larus.home.impl.sdk.b1.a;
        r7.c("photoshop_page_download");
        if (r5 == null) goto L34;
        String r8 = r5.g();
    L35:
        if (r8 != null) goto L37;
        r8 = "";
    L37:
        r7.d(r8);
        goto L38
    L34:
        r8 = null;
    L38:
        o2 r9 = (o2) this.r.getValue();
        if (r9 == null) goto L41;
        r9.RI(r10);
    L41:
        n2 r11 = B3();
        if (r11 == null) goto L73;
        kotlinx.coroutines.flow.i1<ky8.g> r12 = r11.bt();
        if (r12 == null) goto L73;
        ky8.g r13 = (ky8.g) r12.getValue();
        if (r13 == null) goto L73;
        Map<String, ky8.h> r14 = r13.a;
        if (r14 == null) goto L73;
        Collection<ky8.h> r15 = r14.values();
        if (r15 == null) goto L73;
        Iterator<T> r16 = r15.iterator();
        int r17 = 0;
    L53:
        if (r16.hasNext() == false) goto L71;
        Object r18 = r16.next();
        if (r17 >= 0) goto L57;
        CollectionsKt.throwIndexOverflow();
    L57:
        ky8.h r19 = (ky8.h) r18;
        if ((r19 instanceof ky8.f) == false) goto L60;
        ky8.f r20 = (ky8.f) r19;
    L61:
        if (r20 == null) goto L63;
        String r21 = r20.a;
    L64:
        if (r5 == null) goto L66;
        String r22 = r5.a;
    L68:
        if (Intrinsics.areEqual(r21, r22) == true) goto L72;
        r17 = r17 + 1;
    L72:
        Integer r110 = Integer.valueOf(r17);
    L74:
        com.larus.platform.service.o r23 = com.larus.platform.service.o.a;
        JSONObject r24 = new JSONObject();
        my8.q r25 = p3();
        if (r25 == null) goto L77;
        String r26 = r25.b();
    L78:
        r24.putOpt("bot_id", r26);
        r24.putOpt("ai_create_show_mode", "pure");
        if (r5 == null) goto L81;
        String r27 = r5.j();
    L82:
        r24.putOpt("creation_task_id", r27);
        r24.putOpt("click_from", "click_download");
        r24.putOpt("click_method", "click_canvas_upper_download");
        if (r5 == null) goto L85;
        Long r28 = r5.d();
    L86:
        r24.putOpt(MusicAppletPage.KEY_CONVERSATION_ID, r28);
        r24.putOpt("enter_picture_method", "image_generate_canvas");
        r24.putOpt("has_original_image", 1);
        r24.putOpt("is_deep_thinking", 0);
        if (r5 == null) goto L89;
        AIBeautify r29 = r5.c();
    L90:
        if (r29 == null) goto L92;
        int r30 = 1;
    L93:
        r24.putOpt("is_image_edit", Integer.valueOf(r30));
        r24.putOpt("is_replica_gen", 0);
        if (r5 == null) goto L96;
        String r31 = r5.e();
    L97:
        r24.putOpt(MusicAppletPage.KEY_MESSAGE_ID, r31);
        r24.putOpt("image_edit_function_id", C3(r5));
        if (r110 != null) goto L100;
    L106:
        n2 r111 = B3();
        if (r111 == null) goto L113;
        kotlinx.coroutines.flow.b1 r112 = r111.tx();
        if (r112 == null) goto L113;
        Pair r113 = (Pair) r112.getValue();
        if (r113 == null) goto L113;
        r110 = (Integer) r113.getFirst();
    L114:
        r24.putOpt("position", r110);
        r24.putOpt("user_type", "bot");
        r24.putOpt("is_search_card", 0);
        if (r5 == null) goto L119;
        UserCreationFromIM r114 = r5.f();
        if (r114 == null) goto L119;
        r3 = r114.getCreationId();
    L119:
        r24.putOpt("creation_id", r3);
        Unit r115 = Unit.INSTANCE;
        r23.reportEvent("picture_download", r24);
        return;
    L113:
        r110 = null;
        goto L114
    L100:
        if (r110.intValue() < 0) goto L102;
        r1 = true;
    L102:
        if (r1 == true) goto L105;
        r110 = null;
    L105:
        if (r110 != null) goto L114;
    L96:
        r31 = null;
        goto L97
    L92:
        r30 = 0;
        goto L93
    L89:
        r29 = null;
        goto L90
    L85:
        r28 = null;
        goto L86
    L81:
        r27 = null;
        goto L82
    L77:
        r26 = null;
        goto L78
    L66:
        r22 = null;
        goto L68
    L63:
        r21 = null;
        goto L64
    L60:
        r20 = null;
        goto L61
    L71:
        r17 = -1;
    L73:
        r110 = null;
        goto L74
    L15:
        r5 = null;
    L17:
        n2 r32 = B3();
        if (r32 == null) goto L24;
        kotlinx.coroutines.flow.b1 r33 = r32.tx();
        if (r33 == null) goto L24;
        Pair r34 = (Pair) r33.getValue();
        if (r34 == null) goto L24;
        ky8.h r35 = (ky8.h) r34.getSecond();
    L26:
        if ((r35 instanceof ky8.f) == false) goto L28;
        r5 = (ky8.f) r35;
        goto L29
    L28:
        r5 = null;
    L24:
        r35 = null;
        goto L26
    L5:
        if (r0.yp(r10) != true) goto L7;
        r2 = true;
        goto L8
    }
}
