package com.larus.canvas.feature.component.resultdisplay.image.widget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.canvas.feature.component.base.HttpUrl;
import com.larus.canvas.feature.component.base.ImageRes;
import com.larus.canvas.feature.component.base.ImageResId;
import com.larus.canvas.feature.component.base.LocalFilePath;
import com.larus.canvas.feature.component.logic.loading.CanvasProgressState;
import com.larus.canvas.feature.component.resultdisplay.image.v;
import com.larus.canvas.feature.component.resultdisplay.image.y;
import com.larus.canvas.impl.databinding.LarusCanvasPageImageAboveLayerBinding;
import com.larus.common_ui.view.b0;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.BÇ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\f\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f0\u0011\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f0\u0011\u0012\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000f0\f\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f0\u0011\u0012\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u001f\u001a\u00020\u000f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0!J\u000e\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u001bJ\u0010\u0010$\u001a\u0004\u0018\u00010\r2\u0006\u0010%\u001a\u00020&J\b\u0010'\u001a\u00020&H\u0016J\u0018\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020&H\u0016J\u0018\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u00022\u0006\u0010%\u001a\u00020&H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\r0\r0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/larus/canvas/feature/component/resultdisplay/image/widget/ImagePagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/canvas/feature/component/resultdisplay/image/widget/ImagePagerAdapter$PageVH;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "canvasProgressStateGetter", "Lkotlin/Function0;", "Lcom/larus/canvas/feature/component/logic/loading/CanvasProgressState;", "imeStatusFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "onItemClick", "Lkotlin/Function2;", "Lcom/larus/canvas/feature/component/resultdisplay/image/PageItemData;", "Landroid/view/View;", "", "onItemLongClick", "Lkotlin/Function1;", "onListSubmit", "onClickRegenerate", "onClickCompare", "", "onClickSave", "onImageLoaded", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "saveAction", "Lcom/larus/canvas/feature/component/resultdisplay/image/ImageSaveActionUiState;", "differ", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "submitList", "list", "", "updateSaveAction", "action", "getItem", "position", "", "getItemCount", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "PageVH", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImagePagerAdapter extends RecyclerView.Adapter<PageVH> {
    public final CoroutineScope a;
    public final Function0<CanvasProgressState> b;
    public final z0<Boolean> c;
    public final Function2<y, View, Unit> d;
    public final Function1<y, Unit> e;
    public final Function0<Unit> f;
    public final Function1<y, Unit> g;
    public final Function2<y, String, Unit> h;
    public final Function1<y, Unit> i;
    public final Function2<y, Boolean, Unit> j;
    public v k;
    public final AsyncListDiffer<y> l;

    @Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u0000 P2\u00020\u0001:\u0001PB\u0093\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0011\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020=J\u0010\u0010>\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u000eH\u0002J\b\u0010?\u001a\u00020\u000fH\u0002J\u0010\u0010@\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u000eH\u0002J\u0018\u0010A\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020=H\u0002J\u0018\u0010B\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020=H\u0003J\u0018\u0010C\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020=H\u0002J\u0018\u0010D\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020\u000bH\u0002J\u0012\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010;\u001a\u00020\u000eH\u0002J\u001e\u0010I\u001a\u0010\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020K\u0018\u00010J2\u0006\u0010;\u001a\u00020\u000eH\u0002J\u001b\u0010L\u001a\u0004\u0018\u00010K2\n\u0010M\u001a\u00020N\"\u00020KH\u0002¢\u0006\u0002\u0010OR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010&\u001a\r\u0012\t\u0012\u00070(¢\u0006\u0002\b)0'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b*\u0010+R\u0010\u0010.\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010-\u001a\u0004\b7\u00108¨\u0006Q"}, d2 = {"Lcom/larus/canvas/feature/component/resultdisplay/image/widget/ImagePagerAdapter$PageVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "canvasProgressStateGetter", "Lkotlin/Function0;", "Lcom/larus/canvas/feature/component/logic/loading/CanvasProgressState;", "imeStatusFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "onClickRegenerate", "Lkotlin/Function1;", "Lcom/larus/canvas/feature/component/resultdisplay/image/PageItemData;", "", "onClickCompare", "Lkotlin/Function2;", "", "onClickSave", "onImageLoaded", "<init>", "(Landroid/view/View;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "imageRoot", "Lcom/larus/canvas/feature/component/resultdisplay/image/widget/RatioFrameLayout;", "getImageRoot", "()Lcom/larus/canvas/feature/component/resultdisplay/image/widget/RatioFrameLayout;", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "bottomImageView", "compareBtn", "Landroid/widget/ImageView;", "regenerateBtn", "saveContainer", "saveIcon", "saveLoading", "Landroid/widget/ProgressBar;", "hasLoadCompareBtn", "aboveLayerStubManager", "Lcom/larus/common_ui/view/ViewStubManager;", "Lcom/larus/canvas/impl/databinding/LarusCanvasPageImageAboveLayerBinding;", "Lkotlin/jvm/internal/EnhancedNullability;", "getAboveLayerStubManager", "()Lcom/larus/common_ui/view/ViewStubManager;", "aboveLayerStubManager$delegate", "Lkotlin/Lazy;", "preData", "isLoadImageFailed", "()Z", "setLoadImageFailed", "(Z)V", "observeImeStatusJob", "Lkotlinx/coroutines/Job;", "loadingProgressController", "Lcom/larus/canvas/feature/component/resultdisplay/image/widget/LoadingProgressController;", "getLoadingProgressController", "()Lcom/larus/canvas/feature/component/resultdisplay/image/widget/LoadingProgressController;", "loadingProgressController$delegate", "bindData", "data", "saveAction", "Lcom/larus/canvas/feature/component/resultdisplay/image/ImageSaveActionUiState;", "handleWillBeRemove", "hideAboveLayer", "loadCompareImage", "observeImeStatus", "refreshBtn", "refreshSaveAction", "refreshCompareButtonPlacement", "hasStartSaveAction", "hasEndAction", "buildContainerResizeOptions", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "calculateDisplaySize", "Lkotlin/Pair;", "", "firstValidSize", "sizes", "", "([I)Ljava/lang/Integer;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PageVH extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int u = 0;
        public final CoroutineScope a;
        public final z0<Boolean> b;
        public final Function1<y, Unit> c;
        public final Function2<y, String, Unit> d;
        public final Function1<y, Unit> e;
        public final Function2<y, Boolean, Unit> f;
        public final RatioFrameLayout g;
        public final SimpleDraweeView h;
        public final SimpleDraweeView i;
        public final ImageView j;
        public final ImageView k;
        public final View l;
        public final ImageView m;
        public final ProgressBar n;
        public boolean o;
        public final Lazy p;
        public y q;
        public boolean r;
        public Job s;
        public final Lazy t;

        public static final class a {
        }

        static {
        }

        public final b0<LarusCanvasPageImageAboveLayerBinding> U3() {
            return (b0) this.p.getValue();
        }

        public final s V3() {
            return (s) this.t.getValue();
        }

        public final void W3() {
            LarusCanvasPageImageAboveLayerBinding r0 = (LarusCanvasPageImageAboveLayerBinding) U3().c;
            if (r0 == null) goto L7;
            ConstraintLayout r1 = r0.a;
            if (r1 == null) goto L7;
            r1.setBackground(null);
        L7:
            U3().a();
        }

        public final ResizeOptions T3(y r13) {
            if (z2.a.getCreationPreviewPerformanceOptConfig().l == true) goto L5;
            return null;
        L5:
            Resources r0 = ((RecyclerView.ViewHolder) this).itemView.getResources();
            DisplayMetrics r1 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics());
            boolean r5 = false;
            int[] r3 = {this.g.getWidth(), this.g.getMeasuredWidth(), ((RecyclerView.ViewHolder) this).itemView.getWidth(), ((RecyclerView.ViewHolder) this).itemView.getMeasuredWidth(), r1.widthPixels};
            int r4 = 0;
        L6:
            if (r4 >= 5) goto L14;
            int r10 = r3[r4];
            if (r10 <= 0) goto L10;
            boolean r11 = true;
        L11:
            if (r11 == true) goto L12;
            r4 = r4 + 1;
            goto L6
        L12:
            Integer r6 = Integer.valueOf(r10);
        L15:
            int[] r7 = {this.g.getHeight(), this.g.getMeasuredHeight(), ((RecyclerView.ViewHolder) this).itemView.getHeight(), ((RecyclerView.ViewHolder) this).itemView.getMeasuredHeight(), r1.heightPixels};
            int r2 = 0;
        L16:
            if (r2 >= 5) goto L24;
            int r8 = r7[r2];
            if (r8 <= 0) goto L20;
            boolean r9 = true;
        L21:
            if (r9 == true) goto L22;
            r2 = r2 + 1;
            goto L16
        L22:
            Integer r12 = Integer.valueOf(r8);
        L25:
            Integer r14 = Integer.valueOf(r13.d);
            if (r14.intValue() <= 0) goto L28;
            boolean r15 = true;
        L29:
            if (r15 == true) goto L32;
            r14 = null;
        L32:
            Integer r16 = Integer.valueOf(r13.e);
            if (r16.intValue() <= 0) goto L35;
            r5 = true;
        L35:
            if (r5 == true) goto L38;
            r16 = null;
        L38:
            if (r14 == null) goto L54;
            if (r16 == null) goto L54;
            double r17 = r14.doubleValue() / ((double) r16.intValue());
            if (r17 >= 0.4d) goto L45;
            r14 = Integer.valueOf(MathKt.roundToInt(r16.doubleValue() * 0.4d));
        L47:
            if (r6 == null) goto L50;
            if (r12 == null) goto L50;
            float r18 = Math.min(r6.intValue() / r14.floatValue(), r12.intValue() / r16.floatValue());
            Pair r19 = TuplesKt.to(Integer.valueOf(RangesKt.coerceAtLeast(MathKt.roundToInt(r14.floatValue() * r18), 1)), Integer.valueOf(RangesKt.coerceAtLeast(MathKt.roundToInt(r16.floatValue() * r18), 1)));
        L60:
            if (r19 != null) goto L63;
            return null;
        L63:
            return new ResizeOptions(((Number) r19.getFirst()).intValue(), ((Number) r19.getSecond()).intValue());
        L50:
            if (r6 == null) goto L52;
            int r20 = r6.intValue();
            r19 = TuplesKt.to(Integer.valueOf(r20), Integer.valueOf(RangesKt.coerceAtLeast(MathKt.roundToInt((r20 * r16.intValue()) / r14.floatValue()), 1)));
            goto L60
        L52:
            if (r12 == null) goto L59;
            int r21 = r12.intValue();
            r19 = TuplesKt.to(Integer.valueOf(RangesKt.coerceAtLeast(MathKt.roundToInt((r21 * r14.intValue()) / r16.floatValue()), 1)), Integer.valueOf(r21));
        L59:
            r19 = null;
            goto L60
        L45:
            if (r17 <= 3.0d) goto L47;
            r16 = Integer.valueOf(MathKt.roundToInt(r14.doubleValue() / 3.0d));
        L54:
            if (r6 == null) goto L59;
            int r110 = r6.intValue();
            Integer r22 = Integer.valueOf(r110);
            if (r12 == null) goto L58;
            r110 = r12.intValue();
        L58:
            r19 = TuplesKt.to(r22, Integer.valueOf(r110));
            goto L60
        L28:
            r15 = false;
            goto L29
        L20:
            r9 = false;
            goto L21
        L24:
            r12 = null;
            goto L25
        L10:
            r11 = false;
            goto L11
        L14:
            r6 = null;
            goto L15
        }

        public final void X3(final y r19, final v r20) {
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            boolean r3 = r20.b(r19);
            boolean r5 = r20.b(r19);
            boolean r6 = r20.a(r19);
            View r7 = this.l;
            if (r5 == false) goto L5;
            int r8 = 0;
        L6:
            r7.setVisibility(r8);
            this.l.setEnabled(r6);
            this.l.setClickable(r6);
            ImageView r9 = this.m;
            if (r6 == false) goto L9;
        L12:
            float r10 = 1.0f;
        L13:
            r9.setAlpha(r10);
            ImageView r11 = this.m;
            if ((!r19.j.c) == false) goto L16;
            int r12 = 0;
        L17:
            r11.setVisibility(r12);
            ProgressBar r13 = this.n;
            if (r19.j.c == false) goto L20;
            int r14 = 0;
        L21:
            r13.setVisibility(r14);
            this.l.setOnClickListener(new m(r20, r19, this));
            boolean r15 = r19.i;
            int r16 = ((RecyclerView.ViewHolder) this).itemView.getResources().getDimensionPixelSize(v19.c.b(2130971546, null, 2131167462));
            int r17 = ((RecyclerView.ViewHolder) this).itemView.getResources().getDimensionPixelSize(v19.c.b(2130971368, null, 2131167106));
            ImageView r18 = this.j;
            ViewGroup.LayoutParams r110 = r18.getLayoutParams();
            if (r110 == null) goto L63;
            FrameLayout.LayoutParams r111 = (FrameLayout.LayoutParams) r110;
            if (r3 == false) goto L26;
            int r112 = 8388693;
        L27:
            r111.gravity = r112;
            if (r3 == false) goto L30;
            int r113 = 0;
        L31:
            r111.setMarginStart(r113);
            if (r3 == false) goto L36;
            if (r15 == false) goto L35;
            int r114 = r17 + (r16 * 2);
        L37:
            r111.setMarginEnd(r114);
            r111.bottomMargin = r16;
            r18.setLayoutParams(r111);
            Job r4 = this.s;
            if (r4 == null) goto L40;
            Job.DefaultImpls.cancel$default(r4, null, 1, null);
        L40:
            this.s = BuildersKt.launch$default(this.a, null, null, new ImagePagerAdapter$PageVH$observeImeStatus$1(this, r19, r20, null), 3, null);
            if (this.o == true) goto L58;
            this.o = true;
            if (r19.h == false) goto L46;
            this.i.setVisibility(0);
            this.h.setAlpha(1.0f);
            this.i.setAlpha(0.0f);
        L47:
            ImageRes r2 = r19.k;
            if ((r2 instanceof ImageResId) == false) goto L51;
            ((ImageResId) r2).setActualImageResource(this.i);
            goto L58
        L51:
            if ((r2 instanceof HttpUrl) == false) goto L54;
            final ResizeOptions r21 = T3(r19);
            HttpUrl.loadImage$default((HttpUrl) r19.k, this.i, "canvas_pager_image", null, new h(this, r21), 4, null);
            goto L58
        L54:
            if ((r2 instanceof LocalFilePath) == false) goto L56;
            LocalFilePath.loadImage$default((LocalFilePath) r2, this.i, null, new i(this, r19), 2, null);
            goto L58
        L56:
            if (r2 != null) goto L61;
            this.i.setImageBitmap(null);
            goto L58
        L61:
            throw new NoWhenBranchMatchedException();
        L46:
            this.i.setVisibility(8);
        L58:
            final Ref.LongRef r22 = new Ref.LongRef();
            final Ref.ObjectRef r23 = new Ref.ObjectRef();
            this.j.setOnTouchListener(new d(r23, r22, this, r19));
            this.k.setOnClickListener(new e(this, r19));
            return;
        L35:
            r114 = r16;
            goto L37
        L36:
            r114 = 0;
            goto L37
        L30:
            r113 = r16;
            goto L31
        L26:
            r112 = 8388691;
            goto L27
        L63:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        L20:
            r14 = 8;
            goto L21
        L16:
            r12 = 8;
            goto L17
        L9:
            if (r19.j.c == true) goto L12;
            r10 = 0.35f;
            goto L13
        L5:
            r8 = 8;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PageVH(final View r2, CoroutineScope r3, final Function0<CanvasProgressState> r4, z0<Boolean> r5, Function1<? super y, Unit> r6, Function2<? super y, ? super String, Unit> r7, Function1<? super y, Unit> r8, Function2<? super y, ? super Boolean, Unit> r9) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "scope");
            Intrinsics.checkNotNullParameter(r4, "canvasProgressStateGetter");
            Intrinsics.checkNotNullParameter(r5, "imeStatusFlow");
            Intrinsics.checkNotNullParameter(r6, "onClickRegenerate");
            Intrinsics.checkNotNullParameter(r7, "onClickCompare");
            Intrinsics.checkNotNullParameter(r8, "onClickSave");
            Intrinsics.checkNotNullParameter(r9, "onImageLoaded");
            super(r2);
            this.a = r3;
            this.b = r5;
            this.c = r6;
            this.d = r7;
            this.e = r8;
            this.f = r9;
            this.g = (RatioFrameLayout) r2.findViewById(2131375054);
            this.h = r2.findViewById(2131375091);
            this.i = r2.findViewById(2131364469);
            this.j = (ImageView) r2.findViewById(2131377728);
            this.k = (ImageView) r2.findViewById(2131384552);
            this.l = r2.findViewById(2131377730);
            this.m = (ImageView) r2.findViewById(2131377731);
            this.n = (ProgressBar) r2.findViewById(2131377732);
            LazyThreadSafetyMode r10 = LazyThreadSafetyMode.NONE;
            this.p = LazyKt.lazy(r10, new f(r2));
            this.t = LazyKt.lazy(r10, new g(r2, this, r4));
        }
    }

    public final int getItemCount() {
        return this.l.getCurrentList().size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r20, int r21) {
        final PageVH r1 = (PageVH) r20;
        Intrinsics.checkNotNullParameter(r1, "holder");
        final y r2 = (y) CollectionsKt.getOrNull(this.l.getCurrentList(), r21);
        if (r2 == null) goto L91;
        ((RecyclerView.ViewHolder) r1).itemView.setAlpha(1.0f);
        final v r3 = this.k;
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "saveAction");
        e1.o(r1.j);
        e1.o(r1.k);
        e1.o(r1.l);
        e1.o(r1.i);
        boolean r4 = false;
        r1.o = false;
        ImageRes r5 = r2.c;
        y r6 = r1.q;
        if (r6 == null) goto L7;
        ImageRes r7 = r6.c;
    L9:
        if (Intrinsics.areEqual(r5, r7) == true) goto L11;
    L14:
        boolean r8 = true;
    L16:
        if (r2.f == 1) goto L18;
    L20:
        boolean r9 = false;
    L21:
        if (r9 == false) goto L23;
        ImageLoaderKt.b(r1.h);
        r1.h.setImageBitmap(null);
    L23:
        if (r8 == false) goto L47;
        r1.r = false;
        ImageRes r10 = r2.c;
        if ((r10 instanceof ImageResId) == false) goto L28;
        ((ImageResId) r10).setActualImageResource(r1.h);
        goto L47
    L28:
        if ((r10 instanceof HttpUrl) == false) goto L41;
        final ResizeOptions r11 = r1.T3(r2);
        ImageDecodeOptions r12 = ImageDecodeOptions.newBuilder().setBitmapConfig(Bitmap.Config.RGB_565).build();
        ImageRes r13 = r2.b;
        if ((r13 instanceof HttpUrl) == false) goto L32;
        HttpUrl r14 = (HttpUrl) r13;
    L33:
        if (r14 == null) goto L38;
        ImageRequestBuilder r15 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r14.url)).setImageDecodeOptions(r12);
        if (r11 == null) goto L37;
        r15.setResizeOptions(r11);
    L37:
        final ImageRequest r16 = r15.build();
    L39:
        HttpUrl.loadImage$default((HttpUrl) r2.c, r1.h, "canvas_pager_image", null, new k(r1, r16, r11, r3), 4, null);
        goto L47
    L38:
        r16 = null;
        goto L39
    L32:
        r14 = null;
        goto L33
    L41:
        if ((r10 instanceof LocalFilePath) == false) goto L43;
        LocalFilePath.loadImage$default((LocalFilePath) r10, r1.h, null, new l(r1, r2), 2, null);
        goto L47
    L43:
        if (r10 != null) goto L46;
        r1.h.setImageBitmap(null);
        goto L47
    L46:
        throw new NoWhenBranchMatchedException();
    L47:
        int r17 = r2.f;
        if (r17 != 0) goto L52;
        r1.U3().b();
        LarusCanvasPageImageAboveLayerBinding r18 = (LarusCanvasPageImageAboveLayerBinding) r1.U3().c;
        if (r18 == null) goto L59;
        r18.a.setBackground(ContextCompat.getDrawable(((RecyclerView.ViewHolder) r1).itemView.getContext(), v19.c.b(2130970610, ((RecyclerView.ViewHolder) r1).itemView.getContext(), 2131238814)));
        e1.x(r18.b);
        e1.o(r18.c);
    L59:
        y r19 = r1.q;
        if (r19 == null) goto L62;
        String r22 = r19.a;
    L64:
        if (Intrinsics.areEqual(r22, r2.a) == false) goto L75;
        y r23 = r1.q;
        if (r23 != null) goto L68;
    L70:
        boolean r24 = false;
    L71:
        if (r24 == false) goto L75;
        if (r2.f != 4) goto L75;
        BuildersKt.launch$default(r1.a, null, null, new ImagePagerAdapter$PageVH$bindData$5(r1, r3, null), 3, null);
    L80:
        y r25 = r1.q;
        if (r25 != null) goto L83;
    L85:
        if (r4 == false) goto L87;
    L89:
        r1.q = r2;
        FLogger.a.d("ImagePagerViewHolder", "bindData, " + r2);
        e1.d(r1.g, new a(this, r2, r1));
        r1.g.setOnLongClickListener(new b(this, r2));
        return;
    L87:
        if (r2.l == false) goto L89;
        ((RecyclerView.ViewHolder) r1).itemView.animate().alpha(0.0f).setDuration(50).start();
        goto L89
    L83:
        if (r25.l != true) goto L85;
        r4 = true;
        goto L85
    L68:
        if (r23.f != 2) goto L70;
        r24 = true;
    L75:
        s r26 = r1.V3();
        if (r2.f != 2) goto L78;
        boolean r27 = true;
    L79:
        r26.a(r27, r2.a, r2.g);
        r1.g.a(r2.d, r2.e);
        r1.X3(r2, r3);
        goto L80
    L78:
        r27 = false;
        goto L79
    L62:
        r22 = null;
        goto L64
    L52:
        if (r17 != 1) goto L58;
        if (r8 == true) goto L55;
        if (r9 == false) goto L58;
    L55:
        r1.U3().b();
        LarusCanvasPageImageAboveLayerBinding r28 = (LarusCanvasPageImageAboveLayerBinding) r1.U3().c;
        if (r28 == null) goto L59;
        r28.a.setBackground(ContextCompat.getDrawable(((RecyclerView.ViewHolder) r1).itemView.getContext(), 2131238818));
        e1.o(r28.b);
        e1.o(r28.c);
    L58:
        r1.W3();
        goto L59
    L18:
        if (r2.c != null) goto L20;
        r9 = true;
        goto L21
    L11:
        if (r1.r == true) goto L14;
        r8 = false;
        goto L16
    L7:
        r7 = null;
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "parent");
        View r3 = LayoutInflater.from(r12.getContext()).inflate(2131561860, r12, false);
        Intrinsics.checkNotNull(r3);
        return new PageVH(r3, this.a, this.b, this.c, this.g, this.h, this.i, this.j);
    }

    public ImagePagerAdapter(LifecycleCoroutineScope r2, Function0 r3, StateFlowImpl r4, com.larus.canvas.feature.component.resultdisplay.image.j r5, com.larus.canvas.feature.component.resultdisplay.image.k r6, com.larus.canvas.feature.component.resultdisplay.image.l r7, com.larus.canvas.feature.component.resultdisplay.image.m r8, com.larus.canvas.feature.component.resultdisplay.image.b r9, com.larus.canvas.feature.component.resultdisplay.image.c r10, com.larus.canvas.feature.component.resultdisplay.image.d r11) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "canvasProgressStateGetter");
        Intrinsics.checkNotNullParameter(r4, "imeStatusFlow");
        Intrinsics.checkNotNullParameter(r5, "onItemClick");
        Intrinsics.checkNotNullParameter(r6, "onItemLongClick");
        Intrinsics.checkNotNullParameter(r7, "onListSubmit");
        Intrinsics.checkNotNullParameter(r8, "onClickRegenerate");
        Intrinsics.checkNotNullParameter(r9, "onClickCompare");
        Intrinsics.checkNotNullParameter(r10, "onClickSave");
        Intrinsics.checkNotNullParameter(r11, "onImageLoaded");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = new v(0);
        this.l = new AsyncListDiffer(this, new ImagePagerAdapter$differ$1());
    }
}
