package com.larus.photopicker.v2.impl;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import com.larus.photopicker.v2.impl.data.model.LazyLoadConfig;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentBottomPhotoPickerV2Binding;
import com.larus.photopicker.v2.impl.model.MediaGalleryUIConfig;
import com.larus.photopicker.v2.impl.model.MediaNonUISettings;
import com.larus.photopicker.v2.impl.ui.MyBottomSheetBehavior;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaMobViewModel;
import com.larus.platform.model.MediaPickerUIMode;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ¤\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002¤\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010f\u001a\u00020\n2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J$\u0010i\u001a\u00020F2\u0006\u0010j\u001a\u00020k2\b\u0010l\u001a\u0004\u0018\u00010m2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\u0010\u0010n\u001a\u00020F2\u0006\u0010o\u001a\u00020pH\u0002J\u001a\u0010q\u001a\u00020\n2\u0006\u0010r\u001a\u00020F2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\b\u0010s\u001a\u00020\nH\u0002J\b\u0010t\u001a\u00020\nH\u0002J\b\u0010u\u001a\u00020\nH\u0002J\b\u0010v\u001a\u00020\nH\u0002J\u0010\u0010w\u001a\u00020\n2\u0006\u0010x\u001a\u00020LH\u0002J\u0010\u0010y\u001a\u00020\n2\u0006\u0010z\u001a\u00020{H\u0002J\b\u0010|\u001a\u00020\nH\u0016J\b\u0010}\u001a\u00020\nH\u0016J\b\u0010~\u001a\u00020\nH\u0016J\b\u0010\u007f\u001a\u000201H\u0016J\t\u0010\u0080\u0001\u001a\u000201H\u0016J\u001b\u0010\u0081\u0001\u001a\u00020\n2\u0007\u0010\u0082\u0001\u001a\u00020L2\u0007\u0010\u0083\u0001\u001a\u000201H\u0016J\u001e\u0010\u0084\u0001\u001a\u00020\n2\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0013H\u0016J\u001d\u0010\u0084\u0001\u001a\u00020\n2\u0007\u0010\u0088\u0001\u001a\u00020\u00012\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0013H\u0016J\u0014\u0010\u0089\u0001\u001a\u0004\u0018\u00010A2\u0007\u0010\u0088\u0001\u001a\u00020\u0001H\u0002J\t\u0010\u008a\u0001\u001a\u00020\nH\u0002J\t\u0010\u008b\u0001\u001a\u00020\u0001H\u0016J\t\u0010\u008c\u0001\u001a\u00020\nH\u0016J\t\u0010\u008d\u0001\u001a\u00020\nH\u0016J\t\u0010\u008e\u0001\u001a\u00020\nH\u0016J\t\u0010\u008f\u0001\u001a\u00020\nH\u0016J\u0012\u0010\u0090\u0001\u001a\u00020\n2\u0007\u0010\u0091\u0001\u001a\u00020\u0013H\u0016J\u000b\u0010\u0092\u0001\u001a\u0004\u0018\u00010FH\u0016J\t\u0010\u0093\u0001\u001a\u000201H\u0016J1\u0010\u0094\u0001\u001a\u00020\n2&\u0010\u0095\u0001\u001a!\u0012\u0015\u0012\u0013\u0018\u00010F¢\u0006\f\bG\u0012\b\bH\u0012\u0004\b\b(I\u0012\u0006\u0012\u0004\u0018\u00010F0\bH\u0016J\u0015\u0010\u0096\u0001\u001a\u00020\n2\n\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u0001H\u0016J\u0012\u0010\u0099\u0001\u001a\u00020\n2\u0007\u0010\u009a\u0001\u001a\u000201H\u0016J\u0012\u0010\u009b\u0001\u001a\u00020\n2\u0007\u0010\u009c\u0001\u001a\u00020LH\u0016J\u001a\u0010\u009d\u0001\u001a\u0002012\u000f\u0010\u009e\u0001\u001a\n\u0012\u0005\u0012\u00030 \u00010\u009f\u0001H\u0016J\t\u0010¡\u0001\u001a\u000201H\u0016J\f\u0010¢\u0001\u001a\u0005\u0018\u00010£\u0001H\u0002R(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR\"\u0010'\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00102\"\u0004\b7\u00104R\u000e\u00108\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010E\u001a#\u0012\u0015\u0012\u0013\u0018\u00010F¢\u0006\f\bG\u0012\b\bH\u0012\u0004\b\b(I\u0012\u0006\u0012\u0004\u0018\u00010F\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010K\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0004\n\u0002\u0010MR\u001c\u0010N\u001a\u0004\u0018\u00010OX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u000e\u0010T\u001a\u00020UX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010V\u001a\u00020W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\bX\u0010YR\u001b\u0010\\\u001a\u00020]8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010[\u001a\u0004\b^\u0010_R\u000e\u0010a\u001a\u00020bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010c\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010[\u001a\u0004\bd\u00102¨\u0006¥\u0001"}, d2 = {"Lcom/larus/photopicker/v2/impl/BottomPhotoPickerFragmentV3;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/platform/api/IBottomPhotoPickerPage;", "Lcom/larus/photopicker/v2/api/IPhotoPickerPage;", "Lcom/larus/photopicker/v2/impl/BottomPhotoPickerViewModelOwner;", "<init>", "()V", "resultCallback", "Lkotlin/Function1;", "Lcom/larus/platform/AlbumMultiSelectItem;", "", "getResultCallback", "()Lkotlin/jvm/functions/Function1;", "setResultCallback", "(Lkotlin/jvm/functions/Function1;)V", "multiResultCallback", "getMultiResultCallback", "setMultiResultCallback", "displayType", "", "getDisplayType", "()Ljava/lang/String;", "setDisplayType", "(Ljava/lang/String;)V", "guideCallback", "Lkotlin/Function0;", "getGuideCallback", "()Lkotlin/jvm/functions/Function0;", "setGuideCallback", "(Lkotlin/jvm/functions/Function0;)V", "traceInfo", "Lcom/larus/platform/model/album/AlbumTraceInfo;", "getTraceInfo", "()Lcom/larus/platform/model/album/AlbumTraceInfo;", "setTraceInfo", "(Lcom/larus/platform/model/album/AlbumTraceInfo;)V", "dismissCallback", "getDismissCallback", "setDismissCallback", "backCallback", "getBackCallback", "setBackCallback", "onPageSlideCallback", "Lcom/larus/platform/api/IBottomPhotoPickerPageSlideCallback;", "getOnPageSlideCallback", "()Lcom/larus/platform/api/IBottomPhotoPickerPageSlideCallback;", "setOnPageSlideCallback", "(Lcom/larus/platform/api/IBottomPhotoPickerPageSlideCallback;)V", "isImmerseStyle", "", "()Z", "setImmerseStyle", "(Z)V", "enableEmbeddedTouchIntercept", "getEnableEmbeddedTouchIntercept", "setEnableEmbeddedTouchIntercept", "uiConfig", "Lcom/larus/photopicker/v2/impl/model/MediaGalleryUIConfig;", "lazyLoadConfig", "Lcom/larus/photopicker/v2/impl/data/model/LazyLoadConfig;", "binding", "Lcom/larus/photopicker/v2/impl/databinding/LarusFragmentBottomPhotoPickerV2Binding;", "rootLayout", "Lcom/larus/photopicker/v2/impl/BottomPhotoPickerFragmentV3RootLayout;", "hostContainer", "Landroid/widget/FrameLayout;", "bottomSheetBehavior", "Lcom/larus/photopicker/v2/impl/ui/MyBottomSheetBehavior;", "bottomSheet", "bottomSheetCreatedCallback", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "sheet", "bottomOverlayView", "pendingPeekHeight", "", "Ljava/lang/Integer;", "quickAlbumInputConnection", "Lcom/larus/bmhome/injectinput/QuickAlbumInputConnection;", "getQuickAlbumInputConnection$impl_mainlandRelease", "()Lcom/larus/bmhome/injectinput/QuickAlbumInputConnection;", "setQuickAlbumInputConnection$impl_mainlandRelease", "(Lcom/larus/bmhome/injectinput/QuickAlbumInputConnection;)V", "nonUiSettings", "Lcom/larus/photopicker/v2/impl/model/MediaNonUISettings;", "viewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/BottomSheetViewModel;", "getViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/BottomSheetViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mobViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/MediaMobViewModel;", "getMobViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/MediaMobViewModel;", "mobViewModel$delegate", "updateThrottler", "Lcom/larus/photopicker/v2/impl/utils/UpdateThrottler;", "peekHeightFallbackFix", "getPeekHeightFallbackFix", "peekHeightFallbackFix$delegate", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "createBottomSheetRoot", "context", "Landroid/content/Context;", "onViewCreated", "view", "initBackPressed", "initBottomSheet", "initGalleryFragment", "initObservers", "handleBottomSheetStateChanged", "newState", "handleBottomSheetSlide", "slideOffset", "", "onDestroyView", "onDestroy", "closePageAfterSend", "isCurrentInBottom", "isTotalShow", "updatePeekHeight", "height", "isAnimEnd", "showPageFragment", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "parentFragment", "ensureHostContainer", "scheduleRemoveHostContainer", "getPageFragment", "showPageViews", "hidePageViews", "resetPageViews", "dismissPageAllowingStateLoss", "updateDisplayType", "type", "getPhotoPickerBottomSheet", "useBottomOverlayViewAdapterPad", "setOnBottomSheetCreatedCallBack", "callback", "removePhotoSelectedByUri", "uri", "Landroid/net/Uri;", "updateForceSinglePick", "forceSinglePick", "updateMaxSelectCount", "maxSelectCount", "appendInputAttachments", "attachments", "", "Lcom/larus/platform/model/preview/AttachmentSnapshot;", "isInjectInputAlbumShowing", "getAlbumActivity", "Landroidx/fragment/app/FragmentActivity;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class BottomPhotoPickerFragmentV3 extends Fragment implements com.larus.platform.api.a0, lp9.c, c0 {
    public static final /* synthetic */ int C = 0;
    public final wp9.g A;
    public final Lazy B;
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
    public b0 p;
    public FrameLayout q;
    public MyBottomSheetBehavior r;
    public FrameLayout s;
    public Function1<? super View, ? extends View> t;
    public View u;
    public Integer v;
    public op8.k w;
    public MediaNonUISettings x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(Function1 r2) {
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
        return true;
    }

    @Override // com.larus.platform.api.a0
    public final void n60() {
    }

    @Override // com.larus.platform.api.a0
    public final Fragment od() {
        return this;
    }

    @Override // com.larus.platform.api.a0
    public final boolean H10() {
        MyBottomSheetBehavior r0 = this.r;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getState() != 4) goto L9;
        return true;
    L9:
        return false;
    }

    public final BottomSheetViewModel S90() {
        return (BottomSheetViewModel) this.y.getValue();
    }

    @Override // com.larus.platform.api.a0
    public final void Ua() {
        e0.d("BottomPhotoPickerFragmentV3", "hidePageViews");
        MyBottomSheetBehavior r0 = this.r;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L13;
        MyBottomSheetBehavior r2 = this.r;
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
        e0.d("BottomPhotoPickerFragmentV3", "dismissPageAllowingStateLoss");
        if (isAdded() == true) goto L14;
        FrameLayout r0 = this.q;
        if (r0 == null) goto L17;
        r0.post(new w(r0));
        this.q = null;
        return;
    L17:
        return;
    L14:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L6
        Object r2 = Result.constructor-impl(Integer.valueOf(getParentFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss()));     // Catch: Throwable -> L6
    L8:
        Result.box-impl(r2);
        return;
    L6:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // com.larus.platform.api.a0
    public final boolean au() {
        MyBottomSheetBehavior r0 = this.r;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getState() != 3) goto L9;
        return true;
    L9:
        return false;
    }

    public final void onDestroy() {
        e0.d("BottomPhotoPickerFragmentV3", "onDestroy");
        super.onDestroy();
        Function0<Unit> r0 = this.i;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    public final void onDestroyView() {
        b0 r0 = this.p;
        if (r0 == null) goto L5;
        r0.b = null;
    L5:
        this.p = null;
        this.s = null;
        FrameLayout r1 = this.q;
        if (r1 == null) goto L9;
        r1.post(new w(r1));
        this.q = null;
    L9:
        super.onDestroyView();
    }

    @Override // com.larus.platform.api.a0
    public final void uH() {
        e0.d("BottomPhotoPickerFragmentV3", "showPageViews");
        MyBottomSheetBehavior r0 = this.r;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L13;
        MyBottomSheetBehavior r2 = this.r;
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
        e0.d("BottomPhotoPickerFragmentV3", "closePageAfterSend");
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

    public BottomPhotoPickerFragmentV3() {
        this.f = "album_display";
        this.m = MediaGalleryUIConfig.G.a();
        this.n = LazyLoadConfig.e;
        this.x = MediaNonUISettings.f;
        final Function0<Fragment> r0 = new BottomPhotoPickerFragmentV3$special$$inlined$viewModels$default$1(this);
        this.y = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BottomSheetViewModel.class), new BottomPhotoPickerFragmentV3$special$$inlined$viewModels$default$2(r0), new BottomPhotoPickerFragmentV3$special$$inlined$viewModels$default$3(r0, this));
        final Function0<Fragment> r1 = new BottomPhotoPickerFragmentV3$special$$inlined$viewModels$default$4(this);
        this.z = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaMobViewModel.class), new BottomPhotoPickerFragmentV3$special$$inlined$viewModels$default$5(r1), new BottomPhotoPickerFragmentV3$special$$inlined$viewModels$default$6(r1, this));
        this.A = new wp9.g();
        this.B = LazyKt.lazy(new v());
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

    @Override // com.larus.platform.api.a0
    public final View Yz() {
        return this.s;
    }

    @Override // com.larus.platform.api.a0
    public final void BA(boolean r3) {
        int r0 = e0.a;
        e0.d("BottomPhotoPickerFragmentV3", "updateForceSinglePick: " + r3);
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
    public final void Ci(Fragment r7) {
        Intrinsics.checkNotNullParameter(r7, "parentFragment");
        FragmentManager r0 = r7.getChildFragmentManager();
        e0.d("BottomPhotoPickerFragmentV3", "showPageFragment: bottom_album_fragment");
        if (r0.findFragmentByTag("bottom_album_fragment") == null) goto L5;
        return;
    L5:
        if (r0.isStateSaved() == true) goto L28;
        View r8 = r7.getView();
        FrameLayout r3 = null;
        if ((r8 instanceof ViewGroup) == false) goto L10;
        ViewGroup r9 = (ViewGroup) r8;
    L11:
        if (r9 == null) goto L19;
        View r4 = r9.findViewWithTag("bottom_photo_picker_fragment_v3_host");
        if ((r4 instanceof FrameLayout) == false) goto L16;
        r3 = (FrameLayout) r4;
    L16:
        if (r3 == null) goto L18;
        this.q = r3;
        goto L19
    L18:
        r3 = new FrameLayout(r9.getContext());
        r3.setId(View.generateViewId());
        r3.setTag("bottom_photo_picker_fragment_v3_host");
        r3.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r9.addView(r3);
        this.q = r3;
    L19:
        if (r3 != null) goto L21;
        return;
    L21:
        FragmentTransaction r10 = r0.beginTransaction();
        int r1 = r3.getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r10, this, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "bottom_album_fragment", r1) == true) goto L25;
        r10 = r10.add(r1, this, "bottom_album_fragment");
    L25:
        r10.commitAllowingStateLoss();
        return;
    L10:
        r9 = null;
        goto L11
    }

    @Override // com.larus.platform.api.a0
    public final void Lb(Function1<? super View, ? extends View> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.t = r2;
    }

    @Override // com.larus.platform.api.a0
    public final void Nu(int r3) {
        int r0 = e0.a;
        e0.d("BottomPhotoPickerFragmentV3", "updateMaxSelectCount: " + r3);
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
        e0.d("BottomPhotoPickerFragmentV3", "updateDisplayType: " + r3);
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

    public final void onCreate(Bundle r4) {
        op8.k r0 = this.w;
        if (r0 == null) goto L5;
        s1a.a.g(this).n(r0, op8.k.class);
    L5:
        super.onCreate(r4);
        Bundle r5 = getArguments();
        if (r5 == null) goto L10;
        MediaGalleryUIConfig r6 = (MediaGalleryUIConfig) r5.getParcelable("ui_config");
        if (r6 == null) goto L10;
        this.m = MediaGalleryUIConfig.a(r6, 0, false, this.f, -33);
        FLogger.a.i("BottomPhotoPickerFragmentV3", "onCreate uiConfig=" + this.m);
    L10:
        Bundle r7 = getArguments();
        if (r7 == null) goto L15;
        LazyLoadConfig r8 = (LazyLoadConfig) r7.getParcelable("lazy_load_config");
        if (r8 == null) goto L15;
        this.n = r8;
    L15:
        Bundle r9 = getArguments();
        if (r9 == null) goto L21;
        MediaNonUISettings r10 = (MediaNonUISettings) r9.getParcelable("non_ui_settings");
        if (r10 == null) goto L22;
        this.x = r10;
        return;
    L22:
        return;
    }

    @Override // com.larus.platform.api.a0
    public final void tZ(Uri r4) {
        int r0 = e0.a;
        e0.d("BottomPhotoPickerFragmentV3", "removePhotoSelectedByUri: " + r4);
        if (isAdded() == true) goto L5;
        return;
    L5:
        MediaGalleryFragment r1 = getChildFragmentManager().findFragmentByTag("bottom_photo_picker_fragment");
        if ((r1 instanceof MediaGalleryFragment) == false) goto L8;
        MediaGalleryFragment r2 = r1;
    L9:
        if (r2 == null) goto L12;
        int r3 = MediaGalleryFragment.n;
        r2.Y90().removeSelectionByUri(r4, null);
        return;
    L12:
        return;
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.larus.platform.api.a0
    public final void Bs(FragmentManager r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        int r4 = e0.a;
        e0.d("BottomPhotoPickerFragmentV3", "showPageFragment with FragmentManager is unsupported: ".concat(r3));
    }

    @Override // com.larus.platform.api.a0
    public final void k6(int r4, boolean r5) {
        if (r4 > 300) goto L5;
        return;
    L5:
        MyBottomSheetBehavior r0 = this.r;
        if (r0 != null) goto L11;
        FLogger.a.i("BottomPhotoPickerFragmentV3", "updatePeekHeight, behavior is null height:" + r4 + ", isAnimEnd:" + r5 + " peekHeightFallbackFix=" + ((Boolean) this.B.getValue()).booleanValue());
        if (((Boolean) this.B.getValue()).booleanValue() == false) goto L13;
        this.v = Integer.valueOf(r4);
        return;
    L13:
        return;
    L11:
        this.v = null;
        r0.setPeekHeight(r4);
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        e0.d("BottomPhotoPickerFragmentV3", "onViewCreated");
        kq9.e r8 = this.h;
        if (r8 == null) goto L5;
        kq9.e r0 = lp9.d.a;
        Intrinsics.checkNotNullParameter(r8, "traceInfo");
        lp9.d.a = r8;
    L5:
        ((MediaMobViewModel) this.z.getValue()).loadDataStart();
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new BottomPhotoPickerFragmentV3$initBackPressed$1(this));
        final FrameLayout r9 = this.s;
        LarusFragmentBottomPhotoPickerV2Binding r1 = null;
        if (r9 == null) goto L28;
        this.r = new MyBottomSheetBehavior();
        ViewGroup.LayoutParams r2 = r9.getLayoutParams();
        if ((r2 instanceof CoordinatorLayout.LayoutParams) == false) goto L11;
        CoordinatorLayout.LayoutParams r3 = (CoordinatorLayout.LayoutParams) r2;
    L12:
        if (r3 == null) goto L14;
        ((ViewGroup.MarginLayoutParams) r3).height = -1;
        r3.setBehavior(this.r);
        r9.setLayoutParams(r3);
    L14:
        r9.postDelayed(new x(this, r9), 300);
        MyBottomSheetBehavior r10 = this.r;
        if (r10 == null) goto L28;
        if (this.m.e != MediaPickerUIMode.NORMAL) goto L19;
        int r4 = 3;
    L20:
        r10.setState(r4);
        MediaGalleryUIConfig r5 = this.m;
        if (r5.e != MediaPickerUIMode.INVISIBLE_BOTTOM_SHEET) goto L23;
        int r11 = 0;
    L24:
        r10.setPeekHeight(r11);
        S90().getBottomSheetOnStateChanged().setValue(Integer.valueOf(r10.getState()));
        Integer r12 = this.v;
        if (r12 == null) goto L27;
        int r13 = r12.intValue();
        FLogger.a.i("BottomPhotoPickerFragmentV3", "onViewCreated pendingPeekHeight=" + r13);
        r10.setPeekHeight(r13);
        this.v = null;
    L27:
        r10.setBottomSheetCallback(new a0(this));
        goto L28
    L23:
        r11 = r5.h;
        goto L24
    L19:
        r4 = 4;
        goto L20
    L11:
        r3 = null;
    L28:
        FragmentTransaction r14 = getChildFragmentManager().beginTransaction();
        LarusFragmentBottomPhotoPickerV2Binding r15 = this.o;
        if (r15 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L32:
        int r16 = r1.b.getId();
        int r17 = MediaGalleryFragment.n;
        MediaGalleryFragment r18 = MediaGalleryFragment.b.a(this.m, this.n, this.x);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r14, r18, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "bottom_photo_picker_fragment", r16) == true) goto L36;
        r14 = r14.replace(r16, r18, "bottom_photo_picker_fragment");
    L36:
        r14.commitAllowingStateLoss();
        S90().getDisallowIntercept().observe(getViewLifecycleOwner(), new b(new n(this)));
        S90().getCloseBottomSheet().observe(getViewLifecycleOwner(), new b(new o(this)));
        S90().getSelectedResult().observe(getViewLifecycleOwner(), new b(new p(this)));
        S90().getSelectionMultiConfirmed().observe(getViewLifecycleOwner(), new b(new q(this)));
        S90().getGuideClickCallback().observe(getViewLifecycleOwner(), new b(new s(this)));
        S90().getOnBackPressedNeedHandle().observe(getViewLifecycleOwner(), new b(new t(this)));
        S90().getClickPermission().observe(getViewLifecycleOwner(), new b(new u(this)));
        return;
    L31:
        r1 = r15;
        goto L32
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        this.o = LarusFragmentBottomPhotoPickerV2Binding.a(r4, r5);
        Context r7 = requireContext();
        b0 r8 = new b0(r7);
        r8.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r8.d = this.l;
        CoordinatorLayout r9 = new CoordinatorLayout(r7);
        r9.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        FrameLayout r1 = new FrameLayout(r7);
        CoordinatorLayout.LayoutParams r10 = new CoordinatorLayout.LayoutParams(-1, -1);
        r10.gravity = 80;
        r1.setLayoutParams(r10);
        LarusFragmentBottomPhotoPickerV2Binding r11 = this.o;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L5:
        r1.addView(r11.a, new FrameLayout.LayoutParams(-1, -1));
        r8.addView(r8.e, new FrameLayout.LayoutParams(-1, -1));
        r9.addView(r1);
        r8.addView(r9);
        r8.a = r1;
        this.p = r8;
        this.s = r1;
        return r8;
    }
}
