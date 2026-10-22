package com.larus.photopicker.v2.impl;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.home.impl.sdk.SdkWatermarkServiceImpl;
import com.larus.photopicker.v2.impl.data.model.LazyLoadConfig;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentBottomPhotoPickerV2Binding;
import com.larus.photopicker.v2.impl.model.MediaGalleryUIConfig;
import com.larus.photopicker.v2.impl.model.MediaNonUISettings;
import com.larus.photopicker.v2.impl.ui.MotionEventPassBottomSheetDialog;
import com.larus.photopicker.v2.impl.ui.MyBottomSheetBehavior;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaMobViewModel;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.MediaPickerUIMode;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ¨\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002¨\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010k\u001a\u00020\n2\b\u0010l\u001a\u0004\u0018\u00010mH\u0016J\u0012\u0010n\u001a\u00020o2\b\u0010l\u001a\u0004\u0018\u00010mH\u0016J&\u0010p\u001a\u0004\u0018\u00010G2\u0006\u0010q\u001a\u00020r2\b\u0010s\u001a\u0004\u0018\u00010t2\b\u0010l\u001a\u0004\u0018\u00010mH\u0016J\b\u0010u\u001a\u00020\nH\u0016J\b\u0010v\u001a\u00020\nH\u0016J\u001a\u0010w\u001a\u00020\n2\u0006\u0010x\u001a\u00020G2\b\u0010l\u001a\u0004\u0018\u00010mH\u0016J\b\u0010y\u001a\u00020\nH\u0002J\u0010\u0010z\u001a\u00020\n2\u0006\u0010{\u001a\u00020|H\u0016J\b\u0010}\u001a\u00020\nH\u0016J\b\u0010~\u001a\u00020\nH\u0016J\b\u0010\u007f\u001a\u000206H\u0016J\t\u0010\u0080\u0001\u001a\u000201H\u0016J\t\u0010\u0081\u0001\u001a\u000201H\u0016J\u001b\u0010\u0082\u0001\u001a\u00020\n2\u0007\u0010\u0083\u0001\u001a\u0002062\u0007\u0010\u0084\u0001\u001a\u000201H\u0016J\u001e\u0010\u0085\u0001\u001a\u00020\n2\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0013H\u0016J\u001e\u0010\u0085\u0001\u001a\u00020\n2\b\u0010\u0089\u0001\u001a\u00030\u008a\u00012\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\u008b\u0001\u001a\u00030\u008a\u0001H\u0016J\t\u0010\u008c\u0001\u001a\u00020\nH\u0016J\t\u0010\u008d\u0001\u001a\u00020\nH\u0016J\t\u0010\u008e\u0001\u001a\u00020\nH\u0016J\t\u0010\u008f\u0001\u001a\u00020\nH\u0016J\u0012\u0010\u0090\u0001\u001a\u00020\n2\u0007\u0010\u0091\u0001\u001a\u00020\u0013H\u0016J\u000b\u0010\u0092\u0001\u001a\u0004\u0018\u00010GH\u0016J1\u0010\u0093\u0001\u001a\u00020\n2&\u0010\u0094\u0001\u001a!\u0012\u0015\u0012\u0013\u0018\u00010G¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0006\u0012\u0004\u0018\u00010G0\bH\u0016J\u0012\u0010\u0095\u0001\u001a\u00020\n2\u0007\u0010\u0096\u0001\u001a\u000201H\u0016J\u0012\u0010\u0097\u0001\u001a\u00020\n2\u0007\u0010\u0098\u0001\u001a\u000206H\u0016J\u001a\u0010\u0099\u0001\u001a\u0002012\u000f\u0010\u009a\u0001\u001a\n\u0012\u0005\u0012\u00030\u009c\u00010\u009b\u0001H\u0016J\f\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001H\u0002J\u0015\u0010\u009f\u0001\u001a\u00020\n2\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001H\u0016J\t\u0010¢\u0001\u001a\u00020\nH\u0016J\t\u0010£\u0001\u001a\u000201H\u0016J\t\u0010¤\u0001\u001a\u00020\nH\u0002J\u0013\u0010¥\u0001\u001a\u0002062\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0002J\f\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001H\u0002R(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR\"\u0010'\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00102\"\u0004\b=\u00104R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010H\u001a#\u0012\u0015\u0012\u0013\u0018\u00010G¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0006\u0012\u0004\u0018\u00010G\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010L\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0004\n\u0002\u0010MR\u001b\u0010N\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bP\u0010QR\u001b\u0010T\u001a\u00020U8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010S\u001a\u0004\bV\u0010WR\u000e\u0010Y\u001a\u00020ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010^\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010S\u001a\u0004\b_\u00102R\u001c\u0010a\u001a\u0004\u0018\u00010bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u000e\u0010g\u001a\u00020hX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006©\u0001"}, d2 = {"Lcom/larus/photopicker/v2/impl/BottomPhotoPickerFragmentV2;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/larus/platform/api/IBottomPhotoPickerPage;", "Lcom/larus/photopicker/v2/api/IPhotoPickerPage;", "Lcom/larus/photopicker/v2/impl/BottomPhotoPickerViewModelOwner;", "<init>", "()V", "resultCallback", "Lkotlin/Function1;", "Lcom/larus/platform/AlbumMultiSelectItem;", "", "getResultCallback", "()Lkotlin/jvm/functions/Function1;", "setResultCallback", "(Lkotlin/jvm/functions/Function1;)V", "multiResultCallback", "getMultiResultCallback", "setMultiResultCallback", "displayType", "", "getDisplayType", "()Ljava/lang/String;", "setDisplayType", "(Ljava/lang/String;)V", "guideCallback", "Lkotlin/Function0;", "getGuideCallback", "()Lkotlin/jvm/functions/Function0;", "setGuideCallback", "(Lkotlin/jvm/functions/Function0;)V", "traceInfo", "Lcom/larus/platform/model/album/AlbumTraceInfo;", "getTraceInfo", "()Lcom/larus/platform/model/album/AlbumTraceInfo;", "setTraceInfo", "(Lcom/larus/platform/model/album/AlbumTraceInfo;)V", "dismissCallback", "getDismissCallback", "setDismissCallback", "backCallback", "getBackCallback", "setBackCallback", "onPageSlideCallback", "Lcom/larus/platform/api/IBottomPhotoPickerPageSlideCallback;", "getOnPageSlideCallback", "()Lcom/larus/platform/api/IBottomPhotoPickerPageSlideCallback;", "setOnPageSlideCallback", "(Lcom/larus/platform/api/IBottomPhotoPickerPageSlideCallback;)V", "isImmerseStyle", "", "()Z", "setImmerseStyle", "(Z)V", "containerWidth", "", "getContainerWidth", "()I", "setContainerWidth", "(I)V", "enableEmbeddedTouchIntercept", "getEnableEmbeddedTouchIntercept", "setEnableEmbeddedTouchIntercept", "uiConfig", "Lcom/larus/photopicker/v2/impl/model/MediaGalleryUIConfig;", "lazyLoadConfig", "Lcom/larus/photopicker/v2/impl/data/model/LazyLoadConfig;", "binding", "Lcom/larus/photopicker/v2/impl/databinding/LarusFragmentBottomPhotoPickerV2Binding;", "bottomSheetBehavior", "Lcom/larus/photopicker/v2/impl/ui/MyBottomSheetBehavior;", "bottomSheet", "Landroid/view/View;", "bottomSheetCreatedCallback", "Lkotlin/ParameterName;", "name", "sheet", "pendingPeekHeight", "Ljava/lang/Integer;", "viewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/BottomSheetViewModel;", "getViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/BottomSheetViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mobViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/MediaMobViewModel;", "getMobViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/MediaMobViewModel;", "mobViewModel$delegate", "updateThrottler", "Lcom/larus/photopicker/v2/impl/utils/UpdateThrottler;", "mediaStateManager", "Lcom/larus/photopicker/v2/impl/strategy/GenericStateManager;", "Lcom/larus/photopicker/v2/impl/strategy/MediaBottomSheetState;", "peekHeightFallbackFix", "getPeekHeightFallbackFix", "peekHeightFallbackFix$delegate", "quickAlbumInputConnection", "Lcom/larus/bmhome/injectinput/QuickAlbumInputConnection;", "getQuickAlbumInputConnection$impl_mainlandRelease", "()Lcom/larus/bmhome/injectinput/QuickAlbumInputConnection;", "setQuickAlbumInputConnection$impl_mainlandRelease", "(Lcom/larus/bmhome/injectinput/QuickAlbumInputConnection;)V", "nonUiSettings", "Lcom/larus/photopicker/v2/impl/model/MediaNonUISettings;", "hostTopInset", "dimOverlayView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onStop", "onViewCreated", "view", "initBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "closePageAfterSend", "getTheme", "isCurrentInBottom", "isTotalShow", "updatePeekHeight", "height", "isAnimEnd", "showPageFragment", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "parentFragment", "Landroidx/fragment/app/Fragment;", "getPageFragment", "showPageViews", "hidePageViews", "resetPageViews", "dismissPageAllowingStateLoss", "updateDisplayType", "type", "getPhotoPickerBottomSheet", "setOnBottomSheetCreatedCallBack", "callback", "updateForceSinglePick", "forceSinglePick", "updateMaxSelectCount", "maxSelectCount", "appendInputAttachments", "attachments", "", "Lcom/larus/platform/model/preview/AttachmentSnapshot;", "getAlbumActivity", "Landroidx/fragment/app/FragmentActivity;", "removePhotoSelectedByUri", "uri", "Landroid/net/Uri;", "clearAllPhotoSelected", "isInjectInputAlbumShowing", "applyDialogHostTopInset", "resolveHostTopInset", "findHostDialogWindow", "Landroid/view/Window;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class BottomPhotoPickerFragmentV2 extends BottomSheetDialogFragment implements com.larus.platform.api.a0, lp9.c, c0 {
    public static final /* synthetic */ int C = 0;
    public int A;
    public View B;
    public Function1<? super xp9.i, Unit> d;
    public Function1<? super xp9.i, Unit> e;
    public String f;
    public Function0<Unit> g;
    public kq9.e h;
    public Function0<Unit> i;
    public Function0<Unit> j;
    public com.larus.platform.api.b0 k;
    public boolean l;
    public MediaGalleryUIConfig m;
    public LazyLoadConfig n;
    public LarusFragmentBottomPhotoPickerV2Binding o;
    public MyBottomSheetBehavior p;
    public View q;
    public Function1<? super View, ? extends View> r;
    public Integer s;
    public final Lazy t;
    public final Lazy u;
    public final wp9.g v;
    public final up9.x<up9.y> w;
    public final Lazy x;
    public op8.k y;
    public MediaNonUISettings z;

    public static final class a {
        public static BottomPhotoPickerFragmentV2 a(MediaGalleryUIConfig r3, LazyLoadConfig r4, MediaNonUISettings r5) {
            Intrinsics.checkNotNullParameter(r3, "uiConfig");
            Intrinsics.checkNotNullParameter(r4, "lazyLoadConfig");
            Intrinsics.checkNotNullParameter(r5, "nonUiSettings");
            BottomPhotoPickerFragmentV2 r0 = new BottomPhotoPickerFragmentV2();
            Bundle r1 = new Bundle();
            r1.putParcelable("ui_config", r3);
            r1.putParcelable("lazy_load_config", r4);
            r1.putParcelable("non_ui_settings", r5);
            r0.setArguments(r1);
            return r0;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MediaPickerUIMode.values().length];
            r0[MediaPickerUIMode.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MediaPickerUIMode.COLLAPSED_BOTTOM_SHEET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MediaPickerUIMode.INVISIBLE_BOTTOM_SHEET.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ BottomPhotoPickerFragmentV2 a;
        public final /* synthetic */ FrameLayout b;

        public c(BottomPhotoPickerFragmentV2 r1, FrameLayout r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onSlide(View r6, float r7) {
            Intrinsics.checkNotNullParameter(r6, "bottomSheet");
            BottomPhotoPickerFragmentV2 r8 = this.a;
            boolean r3 = false;
            if (r8.A <= 0) goto L15;
            if (r8.l == false) goto L15;
            float r9 = RangesKt.coerceIn(r7, 0.0f, 1.0f);
            View r0 = this.a.B;
            if (r0 == null) goto L9;
            r0.setAlpha(r9);
        L9:
            Dialog r1 = this.a.getDialog();
            if (r1 == null) goto L15;
            Window r2 = r1.getWindow();
            if (r2 == null) goto L15;
            r2.setStatusBarColor(Color.argb((int) (255 * r9), 0, 0, 0));
        L15:
            if (this.a.v.a() == false) goto L17;
        L26:
            this.a.V90().calculateBottomSheetSlide(r7);
            ((up9.y) this.a.w.a()).e(this.a, r7);
            return;
        L17:
            if (r7 != 0.0f) goto L19;
            boolean r4 = true;
        L20:
            if (r4 == true) goto L26;
            if (r7 != 1.0f) goto L24;
            r3 = true;
        L24:
            if (r3 == true) goto L26;
            return;
        L19:
            r4 = false;
            goto L20
        }

        public final void onStateChanged(View r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "bottomSheet");
            FLogger.a.i("BottomPhotoPickerFragmentV2", "bottomSheetCallback onStateChanged: " + r4);
            BottomPhotoPickerFragmentV2 r5 = this.a;
            int r0 = BottomPhotoPickerFragmentV2.C;
            r5.V90().getBottomSheetOnStateChanged().setValue(Integer.valueOf(r4));
            ((up9.y) this.a.w.a()).b(this.a, this.b, r4);
            if (r4 != 3) goto L20;
            com.larus.platform.api.b0 r6 = this.a.k;
            if (r6 == null) goto L7;
            r6.onPageShow();
        L7:
            BottomPhotoPickerFragmentV2 r7 = this.a;
            if (r7.A <= 0) goto L20;
            if (r7.l == false) goto L20;
            View r8 = r7.B;
            if (r8 == null) goto L14;
            r8.setAlpha(1.0f);
        L14:
            Dialog r9 = this.a.getDialog();
            if (r9 == null) goto L20;
            Window r10 = r9.getWindow();
            if (r10 == null) goto L20;
            r10.setStatusBarColor(-16777216);
        L20:
            if (r4 != 4) goto L33;
            BottomPhotoPickerFragmentV2 r11 = this.a;
            if (r11.l == false) goto L33;
            if (r11.A <= 0) goto L33;
            View r12 = r11.B;
            if (r12 == null) goto L28;
            r12.setAlpha(0.0f);
        L28:
            Dialog r13 = this.a.getDialog();
            if (r13 == null) goto L33;
            Window r14 = r13.getWindow();
            if (r14 == null) goto L33;
            r14.setStatusBarColor(0);
        L33:
            com.larus.platform.api.b0 r15 = this.a.k;
            if (r15 == null) goto L37;
            r15.a(r4);
            return;
        }
    }

    public static final class d implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public d(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    @Override // com.larus.platform.api.a0
    public final boolean gC() {
        return false;
    }

    public final int getTheme() {
        return 2131954338;
    }

    @Override // com.larus.platform.api.a0
    public final Fragment od() {
        return this;
    }

    @Override // com.larus.platform.api.a0
    public final boolean H10() {
        MyBottomSheetBehavior r0 = this.p;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getState() != 4) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.platform.api.a0
    public final void Ua() {
        e0.d("BottomPhotoPickerFragmentV2", "hidePageViews");
        MyBottomSheetBehavior r0 = this.p;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L13;
        MyBottomSheetBehavior r2 = this.p;
        if (r2 == null) goto L14;
        r2.setState(4);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r0.getState() != 4) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.larus.platform.api.a0
    public final void Uw() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("attachdialog V2 dismissPageAllowingStateLoss isAdded=");
        r1.append(isAdded());
        r1.append(" dialog=");
        Dialog r2 = getDialog();
        FragmentActivity r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.getClass().getSimpleName();
    L6:
        r1.append(r4);
        r1.append(" windowFocus=");
        Dialog r5 = getDialog();
        if (r5 == null) goto L13;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L13;
        View r7 = S90(r6);
        if (r7 == null) goto L13;
        Boolean r8 = Boolean.valueOf(r7.hasWindowFocus());
    L14:
        r1.append(r8);
        r0.i("BottomPhotoPickerFragmentV2", r1.toString());
        e0.d("BottomPhotoPickerFragmentV2", "dismissPageAllowingStateLoss");
        if (isAdded() == false) goto L23;
        dismissAllowingStateLoss();     // Catch: Exception -> L18
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r9 = DialogFragmentLancet.sLastShowStack;
        if (r9 == null) goto L23;
        com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L23:
        if ((getActivity() instanceof PhotoPickerActivityV2) == false) goto L25;
        r3 = getActivity();
    L25:
        if (r3 == null) goto L30;
        r3.finish();
        return;
    L30:
        return;
    L13:
        r8 = null;
        goto L14
    L5:
        r4 = null;
        goto L6
    }

    public final BottomSheetViewModel V90() {
        return (BottomSheetViewModel) this.t.getValue();
    }

    @Override // com.larus.platform.api.a0
    public final boolean au() {
        MyBottomSheetBehavior r0 = this.p;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getState() != 3) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.platform.api.a0
    public final void n60() {
        e0.d("BottomPhotoPickerFragmentV2", "clearAllPhotoSelected");
        if (isAdded() == true) goto L5;
        return;
    L5:
        MediaGalleryFragment r0 = getChildFragmentManager().findFragmentByTag("bottom_photo_picker_fragment");
        if ((r0 instanceof MediaGalleryFragment) == false) goto L8;
        MediaGalleryFragment r1 = r0;
    L9:
        if (r1 == null) goto L12;
        r1.Y90().clearSelection();
        return;
    L12:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void onDestroy() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("attachdialog V2 onDestroy dialog=");
        Dialog r2 = getDialog();
        Boolean r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.getClass().getSimpleName();
    L6:
        r1.append(r4);
        r1.append(" windowFocus=");
        Dialog r5 = getDialog();
        if (r5 == null) goto L13;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L13;
        View r7 = S90(r6);
        if (r7 == null) goto L13;
        r3 = Boolean.valueOf(r7.hasWindowFocus());
    L13:
        r1.append(r3);
        r1.append(" isAdded=");
        r1.append(isAdded());
        r0.i("BottomPhotoPickerFragmentV2", r1.toString());
        e0.d("BottomPhotoPickerFragmentV2", "onDestroy");
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        Function0<Unit> r8 = this.i;
        if (r8 == null) goto L17;
        r8.invoke();
        return;
    L17:
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.larus.platform.api.a0
    public final void uH() {
        e0.d("BottomPhotoPickerFragmentV2", "showPageViews");
        MyBottomSheetBehavior r0 = this.p;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L13;
        MyBottomSheetBehavior r2 = this.p;
        if (r2 == null) goto L14;
        r2.setState(3);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r0.getState() != 3) goto L7;
        r1 = true;
        goto L8
    }

    public final void zK() {
        e0.d("BottomPhotoPickerFragmentV2", "closePageAfterSend");
        if (this.m.p == false) goto L7;
        Function1<? super xp9.i, Unit> r0 = this.e;
        if (r0 == null) goto L10;
        r0.invoke(new xp9.i(CollectionsKt.emptyList(), true, null, true, false, false, true, false, 180));
    L10:
        Ua();
        return;
    L7:
        Function1<? super xp9.i, Unit> r1 = this.d;
        if (r1 == null) goto L10;
        r1.invoke(new xp9.i(CollectionsKt.emptyList(), true, CollectionsKt.emptyList(), true, false, false, false, false, 240));
        goto L10
    }

    public BottomPhotoPickerFragmentV2() {
        this.f = "album_display";
        this.m = MediaGalleryUIConfig.G.a();
        this.n = LazyLoadConfig.e;
        final Function0<Fragment> r0 = new BottomPhotoPickerFragmentV2$special$$inlined$viewModels$default$1(this);
        this.t = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BottomSheetViewModel.class), new BottomPhotoPickerFragmentV2$special$$inlined$viewModels$default$2(r0), new BottomPhotoPickerFragmentV2$special$$inlined$viewModels$default$3(r0, this));
        final Function0<Fragment> r1 = new BottomPhotoPickerFragmentV2$special$$inlined$viewModels$default$4(this);
        this.u = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaMobViewModel.class), new BottomPhotoPickerFragmentV2$special$$inlined$viewModels$default$5(r1), new BottomPhotoPickerFragmentV2$special$$inlined$viewModels$default$6(r1, this));
        this.v = new wp9.g();
        this.w = new up9.x();
        this.x = LazyKt.lazy(new m());
        this.z = MediaNonUISettings.f;
    }

    @Override // com.larus.platform.api.a0
    public final boolean S0() {
        if (isAdded() == true) goto L5;
        return false;
    L5:
        op8.h r0 = getChildFragmentManager().findFragmentByTag("bottom_photo_picker_fragment");
        if ((r0 instanceof op8.h) == true) goto L8;
        return false;
    L8:
        return r0.S0();
    }

    public final Window U90() {
        Fragment r0 = getParentFragment();
    L4:
        if (r0 == null) goto L12;
        if ((r0 instanceof DialogFragment) == true) goto L7;
        r0 = r0.getParentFragment();
        goto L4
    L7:
        Dialog r1 = ((DialogFragment) r0).getDialog();
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getWindow();
    L12:
        return null;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();     // Catch: Exception -> L93
        Dialog r1 = getDialog();
        if (r1 == null) goto L9;
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r2 == null) goto L9;
        r2.m0();
        SdkWatermarkServiceImpl.a.d(r1);
    L9:
        ((up9.y) this.w.a()).l(this);
        FLogger r3 = FLogger.a;
        r3.i("BottomPhotoPickerFragmentV2", "attachdialog onStart====" + this.l + "====hostTopInset:" + this.A);
        StringBuilder r4 = new StringBuilder("attachdialog V2 onStart dialog=");
        Dialog r5 = getDialog();
        final ViewGroup r6 = null;
        if (r5 == null) goto L12;
        String r7 = r5.getClass().getSimpleName();
    L13:
        r4.append(r7);
        r4.append(" windowFocus=");
        Dialog r8 = getDialog();
        if (r8 == null) goto L20;
        Window r9 = r8.getWindow();
        if (r9 == null) goto L20;
        View r10 = S90(r9);
        if (r10 == null) goto L20;
        Boolean r11 = Boolean.valueOf(r10.hasWindowFocus());
    L21:
        r4.append(r11);
        r4.append(" focusable=");
        Dialog r12 = getDialog();
        boolean r13 = true;
        if (r12 == null) goto L30;
        Window r14 = r12.getWindow();
        if (r14 == null) goto L30;
        WindowManager.LayoutParams r15 = r14.getAttributes();
        if (r15 == null) goto L30;
        if ((r15.flags & 8) != 0) goto L30;
        boolean r16 = true;
    L31:
        r4.append(r16);
        r4.append(" touchable=");
        Dialog r17 = getDialog();
        if (r17 == null) goto L40;
        Window r18 = r17.getWindow();
        if (r18 == null) goto L40;
        WindowManager.LayoutParams r19 = r18.getAttributes();
        if (r19 == null) goto L40;
        if ((r19.flags & 16) != 0) goto L40;
    L41:
        r4.append(r13);
        r4.append(" activityFocus=");
        FragmentActivity r20 = getActivity();
        if (r20 == null) goto L46;
        View r21 = r20.getCurrentFocus();
        if (r21 == null) goto L46;
        String r22 = r21.getClass().getSimpleName();
    L47:
        r4.append(r22);
        r3.i("BottomPhotoPickerFragmentV2", r4.toString());
        boolean r23 = this.l;
        if (r23 == false) goto L90;
        if (r23 == false) goto L90;
        final Window r24 = U90();
        if (r24 == null) goto L90;
        Dialog r25 = getDialog();
        if (r25 == null) goto L90;
        final Window r26 = r25.getWindow();
        if (r26 == null) goto L90;
        Object r27 = getDialog();
        if ((r27 instanceof MotionEventPassBottomSheetDialog) == false) goto L62;
        MotionEventPassBottomSheetDialog r28 = (MotionEventPassBottomSheetDialog) r27;
    L63:
        if (r28 == null) goto L65;
        r28.e = r24;
    L65:
        r26.clearFlags(2);
        r26.setBackgroundDrawableResource(R.color.transparent);
        S90(r26).setBackgroundColor(0);
        Dialog r29 = getDialog();
        if (r29 == null) goto L68;
        r6 = (ViewGroup) r29.findViewById(2131367728);
    L68:
        if (r6 == null) goto L70;
        r6.setBackgroundColor(0);
    L70:
        if (r6 == null) goto L72;
        r6.setClipToPadding(false);
    L72:
        Dialog r30 = getDialog();
        if (r30 == null) goto L81;
        View r31 = r30.findViewById(2131367947);
        if (r31 == null) goto L81;
        ViewGroup.LayoutParams r32 = r31.getLayoutParams();
        if (r32 == null) goto L80;
        ViewGroup.MarginLayoutParams r33 = (ViewGroup.MarginLayoutParams) r32;
        r33.topMargin = this.A;
        r31.setLayoutParams(r33);
        goto L81
    L80:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L81:
        if (r6 == null) goto L83;
        int r34 = r6.getPaddingTop();
    L85:
        if (r6 == null) goto L90;
        Context r35 = r6.getContext();
        if (r35 == null) goto L90;
        View r36 = new View(r35);
        FrameLayout.LayoutParams r37 = new FrameLayout.LayoutParams(-1, -1);
        r37.topMargin = -r34;
        r36.setLayoutParams(r37);
        r36.setBackgroundColor(-16777216);
        r36.setAlpha(0.0f);
        r36.setClickable(false);
        r36.setFocusable(false);
        this.B = r36;
        r6.addView(r36, 0);
        r6.setOnTouchListener(new com.larus.photopicker.v2.impl.c(r6, this, r26, r24));
        r3.i("BottomPhotoPickerFragmentV2", "attachdialog BottomPhotoPickerFragmentV2 applyDialogHostTopInset motionEventPassBottomSheetDialog=" + r28 + "====hostFragment:" + U90());
        goto L90
    L83:
        r34 = 0;
        goto L85
    L62:
        r28 = null;
    L90:
        Dialog r0 = getDialog();
        if (r0 == null) goto L111;
        r0.setOnKeyListener(new com.larus.photopicker.v2.impl.a(this));
        return;
    L111:
        return;
    L46:
        r22 = null;
    L40:
        r13 = false;
    L30:
        r16 = false;
    L20:
        r11 = null;
        goto L21
    L12:
        r7 = null;
    L93:
        e = move-exception;
        FLogger.a.e("BottomPhotoPickerFragmentV2", "onStart: Exception, dismissing. " + e.getMessage());
        dismissAllowingStateLoss();     // Catch: Exception -> L97
        return;
    L97:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Exception -> L102
        Throwable r38 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L102
        if (r38 == null) goto L113;
        com.bytedance.crash.d.d(r38, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L102
        return;
    L113:
        return;
    L102:
        e = move-exception;
        FLogger.a.e("BottomPhotoPickerFragmentV2", "dismissAllowingStateLoss also failed: " + e.getMessage());
    }

    public final void onStop() {
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L7;
        r1.m0();
        SdkWatermarkServiceImpl.a.e(r0);
    L7:
        super/*androidx.fragment.app.DialogFragment*/.onStop();
    }

    @Override // com.larus.platform.api.a0
    public final View Yz() {
        return this.q;
    }

    public static View S90(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    @Override // com.larus.platform.api.a0
    public final void BA(boolean r3) {
        int r0 = e0.a;
        e0.d("BottomPhotoPickerFragmentV2", "updateForceSinglePick: " + r3);
        if (isAdded() == true) goto L5;
        return;
    L5:
        MediaGalleryFragment r1 = getChildFragmentManager().findFragmentByTag("bottom_photo_picker_fragment");
        if ((r1 instanceof MediaGalleryFragment) == false) goto L8;
        MediaGalleryFragment r2 = r1;
    L9:
        if (r2 == null) goto L12;
        r2.da0(r3);
        return;
    L12:
        return;
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.larus.platform.api.a0
    public final void Ci(Fragment r12) {
        Intrinsics.checkNotNullParameter(r12, "parentFragment");
        FragmentManager r0 = r12.getChildFragmentManager();
        e0.d("BottomPhotoPickerFragmentV2", "showPageFragment: bottom_album_fragment");
        Fragment r3 = r0.findFragmentByTag("bottom_album_fragment");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        z2.a.w3();     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L8:
        if (this.l == false) goto L28;
        Fragment r5 = r12;
    L10:
        if (r5 == null) goto L14;
        if ((r5 instanceof DialogFragment) == true) goto L14;
        r5 = r5.getParentFragment();
    L14:
        int r6 = 0;
        if (r5 == null) goto L27;
        View r7 = r12.getView();
        if (r7 == null) goto L27;
        int[] r8 = new int[2];
        r7.getLocationOnScreen(r8);
        int r9 = r8[1];
        FragmentActivity r10 = getActivity();
        if (r10 == null) goto L25;
        int r11 = r10.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r11 <= 0) goto L25;
        int r13 = r10.getResources().getDimensionPixelSize(r11);
    L26:
        r6 = RangesKt.coerceAtLeast(r9 - r13, 0);
    L25:
        r13 = 0;
    L27:
        this.A = r6;
    L28:
        FLogger.a.i("BottomPhotoPickerFragmentV2", "attachdialog V2 showPageFragment tag=bottom_album_fragment parent=" + r12.getClass().getSimpleName() + " embedded=" + this.l + " hostTopInset=" + this.A + " hostWindow=" + U90());
        if (r3 == null) goto L32;
        return;
    L32:
        if (r0.isStateSaved() == false) goto L34;
        return;
    L34:
        T90(this, r0, "bottom_album_fragment");
        return;
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // com.larus.platform.api.a0
    public final void Lb(Function1<? super View, ? extends View> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.r = r2;
    }

    @Override // com.larus.platform.api.a0
    public final void Nu(int r3) {
        int r0 = e0.a;
        e0.d("BottomPhotoPickerFragmentV2", "updateMaxSelectCount: " + r3);
        if (isAdded() == true) goto L5;
        return;
    L5:
        MediaGalleryFragment r1 = getChildFragmentManager().findFragmentByTag("bottom_photo_picker_fragment");
        if ((r1 instanceof MediaGalleryFragment) == false) goto L8;
        MediaGalleryFragment r2 = r1;
    L9:
        if (r2 == null) goto L12;
        r2.Y90().updateMaxSelectCount(r3);
        return;
    L12:
        return;
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.larus.platform.api.a0
    public final boolean RU(List<AttachmentSnapshot> r4) {
        Intrinsics.checkNotNullParameter(r4, "attachments");
        if (isAdded() == true) goto L5;
        return false;
    L5:
        MediaGalleryFragment r0 = getChildFragmentManager().findFragmentByTag("bottom_photo_picker_fragment");
        if ((r0 instanceof MediaGalleryFragment) == false) goto L8;
        MediaGalleryFragment r1 = r0;
    L9:
        if (r1 != null) goto L11;
        return false;
    L11:
        if (r1.U90(r4) != true) goto L15;
        return true;
    L15:
        return false;
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.larus.platform.api.a0
    public final void cP(String r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        int r0 = e0.a;
        e0.d("BottomPhotoPickerFragmentV2", "updateDisplayType: " + r3);
        if (isAdded() == true) goto L5;
        return;
    L5:
        MediaGalleryFragment r1 = getChildFragmentManager().findFragmentByTag("bottom_photo_picker_fragment");
        if ((r1 instanceof MediaGalleryFragment) == false) goto L8;
        MediaGalleryFragment r2 = r1;
    L9:
        if (r2 == null) goto L12;
        r2.ca0(r3);
        return;
    L12:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final void onConfigurationChanged(Configuration r4) {
        Intrinsics.checkNotNullParameter(r4, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r4);
        ((up9.y) this.w.a()).o(getActivity(), r4, this.j);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.photopicker.v2.impl.b, java.lang.Object] */
    public final void onCreate(Bundle r4) {
        op8.k r0 = this.y;
        if (r0 == null) goto L5;
        s1a.a.g(this).n(r0, op8.k.class);
    L5:
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r4);
        Bundle r5 = getArguments();
        if (r5 == null) goto L10;
        MediaGalleryUIConfig r6 = (MediaGalleryUIConfig) r5.getParcelable("ui_config");
        if (r6 == null) goto L10;
        this.m = MediaGalleryUIConfig.a(r6, 0, false, this.f, -33);
        FLogger.a.i("BottomPhotoPickerFragmentV2", "onCreate uiConfig=" + this.m);
    L10:
        Bundle r7 = getArguments();
        if (r7 == null) goto L15;
        LazyLoadConfig r8 = (LazyLoadConfig) r7.getParcelable("lazy_load_config");
        if (r8 == null) goto L15;
        this.n = r8;
    L15:
        Bundle r9 = getArguments();
        if (r9 == null) goto L20;
        MediaNonUISettings r10 = (MediaNonUISettings) r9.getParcelable("non_ui_settings");
        if (r10 == null) goto L20;
        this.z = r10;
    L20:
        up9.x<up9.y> r11 = this.w;
        ?? r1 = new com.larus.photopicker.v2.impl.b(this);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r1, "initialStateFactory");
        r11.a = (S) r1.invoke();
    }

    public final Dialog onCreateDialog(Bundle r5) {
        Dialog r0 = ((up9.y) this.w.a()).k(requireContext());
        if (r0 != null) goto L6;
        r0 = super.onCreateDialog(r5);
    L6:
        if (this.m.q == false) goto L13;
        Window r6 = r0.getWindow();
        if (r6 == null) goto L10;
        r6.setSoftInputMode(50);
    L10:
        Window r7 = r0.getWindow();
        if (r7 == null) goto L13;
        r7.setLayout(-1, -1);
    L13:
        FLogger r8 = FLogger.a;
        StringBuilder r1 = new StringBuilder("attachdialog V2 onCreateDialog class=");
        r1.append(r0.getClass().getSimpleName());
        r1.append(" flags=");
        Window r2 = r0.getWindow();
        Integer r3 = null;
        if (r2 == null) goto L18;
        WindowManager.LayoutParams r4 = r2.getAttributes();
        if (r4 == null) goto L18;
        Integer r9 = Integer.valueOf(r4.flags);
    L19:
        r1.append(r9);
        r1.append(" softInputMode=");
        Window r10 = r0.getWindow();
        if (r10 == null) goto L24;
        WindowManager.LayoutParams r11 = r10.getAttributes();
        if (r11 == null) goto L24;
        r3 = Integer.valueOf(r11.softInputMode);
    L24:
        r1.append(r3);
        r8.i("BottomPhotoPickerFragmentV2", r1.toString());
        return r0;
    L18:
        r9 = null;
        goto L19
    }

    @Override // com.larus.platform.api.a0
    public final void tZ(Uri r3) {
        int r0 = e0.a;
        e0.d("BottomPhotoPickerFragmentV2", "removePhotoSelectedByUri: " + r3);
        if (isAdded() == true) goto L5;
        return;
    L5:
        MediaGalleryFragment r1 = getChildFragmentManager().findFragmentByTag("bottom_photo_picker_fragment");
        if ((r1 instanceof MediaGalleryFragment) == false) goto L8;
        MediaGalleryFragment r2 = r1;
    L9:
        if (r2 == null) goto L12;
        r2.Y90().removeSelectionByUri(r3, new com.larus.photopicker.v2.impl.d(this));
        return;
    L12:
        return;
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.larus.platform.api.a0
    public final void Bs(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        int r0 = e0.a;
        e0.d("BottomPhotoPickerFragmentV2", "showPageFragment: ".concat(r4));
        if (r3.findFragmentByTag(r4) == null) goto L6;
        return;
    L6:
        if (r3.isStateSaved() == false) goto L8;
        return;
    L8:
        T90(this, r3, r4);
    }

    @Override // com.larus.platform.api.a0
    public final void k6(int r4, boolean r5) {
        if (r4 > 300) goto L5;
        return;
    L5:
        MyBottomSheetBehavior r0 = this.p;
        if (r0 != null) goto L11;
        FLogger.a.i("BottomPhotoPickerFragmentV2", "updatePeekHeight, behavior is null height:" + r4 + ", isAnimEnd:" + r5 + " peekHeightFallbackFix=" + ((Boolean) this.x.getValue()).booleanValue());
        if (((Boolean) this.x.getValue()).booleanValue() == false) goto L13;
        this.s = Integer.valueOf(r4);
        return;
    L13:
        return;
    L11:
        this.s = null;
        r0.setPeekHeight(r4);
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        e0.d("BottomPhotoPickerFragmentV2", "onViewCreated");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new BottomPhotoPickerFragmentV2$initBackPressed$1$1(this));     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L10;
        int r3 = e0.a;
        e0.c("BottomPhotoPickerFragmentV2", "initBackPressed failed " + r2.getMessage());
    L10:
        kq9.e r4 = this.h;
        if (r4 == null) goto L13;
        kq9.e r5 = lp9.d.a;
        Intrinsics.checkNotNullParameter(r4, "traceInfo");
        lp9.d.a = r4;
    L13:
        ((MediaMobViewModel) this.u.getValue()).loadDataStart();
        ViewParent r9 = r7.getParent();
        LarusFragmentBottomPhotoPickerV2Binding r6 = null;
        if ((r9 instanceof FrameLayout) == false) goto L16;
        FrameLayout r10 = (FrameLayout) r9;
    L17:
        if (r10 == null) goto L19;
        this.q = r10;
        this.p = new MyBottomSheetBehavior();
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams r12 = (CoordinatorLayout.LayoutParams) r11;
        ((ViewGroup.MarginLayoutParams) r12).height = -1;
        r12.setBehavior(this.p);
        r10.setLayoutParams(r12);
        ((up9.y) this.w.a()).a(r10);
    L19:
        MyBottomSheetBehavior r13 = this.p;
        if (r13 == null) goto L25;
        ((up9.y) this.w.a()).d(r13, this.m.h, V90());
        Integer r14 = this.s;
        if (r14 == null) goto L24;
        int r15 = r14.intValue();
        FLogger.a.i("BottomPhotoPickerFragmentV2", "onViewCreated pendingPeekHeight=" + r15);
        r13.setPeekHeight(r15);
        this.s = null;
    L24:
        r13.setBottomSheetCallback(new c(this, r10));
    L25:
        FragmentTransaction r16 = getChildFragmentManager().beginTransaction();
        LarusFragmentBottomPhotoPickerV2Binding r17 = this.o;
        if (r17 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L29:
        int r18 = r6.b.getId();
        int r19 = MediaGalleryFragment.n;
        MediaGalleryFragment r20 = MediaGalleryFragment.b.a(this.m, this.n, this.z);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r16, r20, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "bottom_photo_picker_fragment", r18) == true) goto L33;
        r16 = r16.replace(r18, r20, "bottom_photo_picker_fragment");
    L33:
        r16.commitAllowingStateLoss();
        V90().getDisallowIntercept().observe(getViewLifecycleOwner(), new d(new e(this)));
        V90().getCloseBottomSheet().observe(getViewLifecycleOwner(), new d(new f(this)));
        V90().getSelectedResult().observe(getViewLifecycleOwner(), new d(new g(this)));
        V90().getSelectionMultiConfirmed().observe(getViewLifecycleOwner(), new d(new h(this)));
        V90().getGuideClickCallback().observe(getViewLifecycleOwner(), new d(new i(this)));
        V90().getNavigationBarColor().observe(getViewLifecycleOwner(), new d(new j(this)));
        V90().getOnBackPressedNeedHandle().observe(getViewLifecycleOwner(), new d(new k(this)));
        V90().getClickPermission().observe(getViewLifecycleOwner(), new d(new l(this)));
        return;
    L28:
        r6 = r17;
        goto L29
    L16:
        r10 = null;
    L5:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static void T90(BottomPhotoPickerFragmentV2 r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        BottomPhotoPickerFragmentV2 r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusFragmentBottomPhotoPickerV2Binding r4 = LarusFragmentBottomPhotoPickerV2Binding.a(r1, r2);
        this.o = r4;
        return r4.a;
    }
}
