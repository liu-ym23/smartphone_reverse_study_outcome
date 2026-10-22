package com.larus.dora.impl.feedback;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.widget.CircleProgressBar;
import com.larus.common_ui.widget.MaxWidthRecyclerView;
import com.larus.common_ui.widget.NestedScrollEditText;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.dora.impl.databinding.DoragFeedbackFragmentBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 I2\u00020\u0001:\u0002IJB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010(\u001a\u00020\u001bH\u0016J$\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u00101\u001a\u0002022\u0006\u00103\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00104\u001a\u000202H\u0002J\b\u00105\u001a\u000202H\u0002J\b\u00106\u001a\u000202H\u0002J\b\u00107\u001a\u000202H\u0002J\b\u00108\u001a\u000202H\u0002J\u001e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010>J\u001e\u0010?\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010>J\b\u0010@\u001a\u000202H\u0002J\u0010\u0010A\u001a\u0002022\u0006\u0010B\u001a\u00020*H\u0002J\b\u0010C\u001a\u000202H\u0002J\b\u0010D\u001a\u000202H\u0002J\b\u0010E\u001a\u000202H\u0002J\u0010\u0010F\u001a\u0002022\u0006\u0010G\u001a\u00020%H\u0002J\b\u0010H\u001a\u000202H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00060\u0017R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0012\u001a\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/larus/dora/impl/feedback/DoraGFeedbackFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "_binding", "Lcom/larus/dora/impl/databinding/DoragFeedbackFragmentBinding;", "binding", "getBinding", "()Lcom/larus/dora/impl/databinding/DoragFeedbackFragmentBinding;", "MAX_IMAGE_CNT", "", "MAX_CHAR_COUNT", "COMPRESS_PROGRESS_PERCENT", "viewModel", "Lcom/larus/dora/impl/feedback/DoraGFeedbackViewModel;", "getViewModel", "()Lcom/larus/dora/impl/feedback/DoraGFeedbackViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "selectedImageUris", "", "Landroid/net/Uri;", "imageAdapter", "Lcom/larus/dora/impl/feedback/DoraGFeedbackFragment$ImagePreviewAdapter;", "pickImageLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "feedbackTypes", "", "Lcom/larus/dora/impl/feedback/FeedbackType;", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "submitLoadingVisible", "", "privacyConsentDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "getCurrentPageName", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initViewModel", "initViews", "showSubmitLoading", "dismissSubmitLoading", "initPickers", "getFileSizeFromUri", "", "context", "Landroid/content/Context;", "uri", "(Landroid/content/Context;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoDurationFromUri", "setupListeners", "scrollToView", "targetView", "showFeedbackTypePopup", "updateConditionalSectionsVisibility", "submitFeedback", "showPrivacyConsentDialog", "submitAfterConfirm", "onDestroyView", "Companion", "ImagePreviewAdapter", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGFeedbackFragment extends DoraBaseFragment {
    public static final /* synthetic */ int r = 0;
    public DoragFeedbackFragmentBinding f;
    public final int g;
    public final int h;
    public final int i;
    public final Lazy j;
    public final List<Uri> k;
    public ImagePreviewAdapter l;
    public ActivityResultLauncher<String[]> m;
    public final List<FeedbackType> n;
    public final Lazy o;
    public boolean p;
    public CommonDialog q;

    @Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002<=B7\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0018\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0016J&\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\bH\u0016J\u0010\u0010$\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J(\u0010%\u001a\u00020\t2\u000e\u0010\u001c\u001a\n0&R\u00060\u0000R\u00020'2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0015H\u0002J*\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\bH\u0002J\"\u0010/\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\bH\u0002J\"\u00100\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\bH\u0002J \u00101\u001a\u00020\b2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\bH\u0002J\u0018\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020+2\u0006\u0010.\u001a\u00020\bH\u0002J(\u00108\u001a\u00020\t2\u000e\u0010\u001c\u001a\n0&R\u00060\u0000R\u00020'2\u0006\u0010)\u001a\u00020\u00152\u0006\u00109\u001a\u00020\bH\u0002J\u0016\u0010:\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u00109\u001a\u00020\bJ\u0006\u0010;\u001a\u00020\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006>"}, d2 = {"Lcom/larus/dora/impl/feedback/DoraGFeedbackFragment$ImagePreviewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "imageUris", "", "Landroid/net/Uri;", "onRemoveClick", "Lkotlin/Function1;", "", "", "onAddClick", "Lkotlin/Function0;", "<init>", "(Lcom/larus/dora/impl/feedback/DoraGFeedbackFragment;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "PAYLOAD_PROGRESS", "", "VIEW_TYPE_IMAGE", "VIEW_TYPE_ADD_ICON", "failedPreviewKeys", "", "canAddMoreImages", "", "getCanAddMoreImages", "()Z", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "bindPreview", "Lcom/larus/dora/impl/feedback/DoraGFeedbackFragment$ImagePreviewAdapter$ImageViewHolder;", "Lcom/larus/dora/impl/feedback/DoraGFeedbackFragment;", "uri", "isVideo", "loadPreviewBitmap", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "targetSize", "loadImagePreviewBitmap", "loadVideoPreviewBitmap", "calculateInSampleSize", "options", "Landroid/graphics/BitmapFactory$Options;", "reqWidth", "reqHeight", "scaleDownBitmap", "bitmap", "updateProgressUI", "progress", "updateUploadProgress", "clearCache", "ImageViewHolder", "AddIconViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ImagePreviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public final List<Uri> a;
        public final Function1<Integer, Unit> b;
        public final Function0<Unit> c;
        public final String d;
        public final int e;
        public final Set<String> f;
        public final /* synthetic */ DoraGFeedbackFragment g;

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/dora/impl/feedback/DoraGFeedbackFragment$ImagePreviewAdapter$AddIconViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/dora/impl/feedback/DoraGFeedbackFragment$ImagePreviewAdapter;Landroid/view/View;)V", "container", "kotlin.jvm.PlatformType", "getContainer", "()Landroid/view/View;", "ivAlbumIcon", "Landroid/widget/ImageView;", "getIvAlbumIcon", "()Landroid/widget/ImageView;", "tvImageCount", "Landroid/widget/TextView;", "getTvImageCount", "()Landroid/widget/TextView;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class AddIconViewHolder extends RecyclerView.ViewHolder {
            public final View a;
            public final ImageView b;
            public final TextView c;

            public AddIconViewHolder(View r2) {
                Intrinsics.checkNotNullParameter(r2, "itemView");
                super(r2);
                this.a = r2.findViewById(2131377410);
                this.b = (ImageView) r2.findViewById(2131375977);
                this.c = (TextView) r2.findViewById(2131390766);
            }
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0019\u0010\r\u001a\n \b*\u0004\u0018\u00010\u000e0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\n \b*\u0004\u0018\u00010\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\nR\u0019\u0010\u0016\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\nR\u0019\u0010\u0018\u001a\n \b*\u0004\u0018\u00010\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/larus/dora/impl/feedback/DoraGFeedbackFragment$ImagePreviewAdapter$ImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/dora/impl/feedback/DoraGFeedbackFragment$ImagePreviewAdapter;Landroid/view/View;)V", "ivPreview", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIvPreview", "()Landroid/widget/ImageView;", "ivRemove", "getIvRemove", "circleProgressBar", "Lcom/larus/common_ui/widget/CircleProgressBar;", "getCircleProgressBar", "()Lcom/larus/common_ui/widget/CircleProgressBar;", "overlay", "getOverlay", "()Landroid/view/View;", "ivRetryUpload", "getIvRetryUpload", "ivIsVideo", "getIvIsVideo", "videoGradientOverlay", "getVideoGradientOverlay", "boundPreviewUri", "Landroid/net/Uri;", "getBoundPreviewUri", "()Landroid/net/Uri;", "setBoundPreviewUri", "(Landroid/net/Uri;)V", "previewJob", "Lkotlinx/coroutines/Job;", "getPreviewJob", "()Lkotlinx/coroutines/Job;", "setPreviewJob", "(Lkotlinx/coroutines/Job;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class ImageViewHolder extends RecyclerView.ViewHolder {
            public static final /* synthetic */ int i = 0;
            public final ImageView a;
            public final CircleProgressBar b;
            public final View c;
            public final ImageView d;
            public final ImageView e;
            public final View f;
            public Uri g;
            public Job h;

            public ImageViewHolder(final ImagePreviewAdapter r5, View r6) {
                Intrinsics.checkNotNullParameter(r6, "itemView");
                super(r6);
                this.a = (ImageView) r6.findViewById(2131376309);
                ImageView r0 = (ImageView) r6.findViewById(2131376549);
                CircleProgressBar r1 = (CircleProgressBar) r6.findViewById(2131365724);
                this.b = r1;
                this.c = r6.findViewById(2131391930);
                ImageView r2 = (ImageView) r6.findViewById(2131376556);
                this.d = r2;
                this.e = (ImageView) r6.findViewById(2131376330);
                this.f = r6.findViewById(2131392306);
                final DoraGFeedbackFragment r7 = r5.g;
                r0.setOnClickListener(new f0(this, r7, r5));
                final DoraGFeedbackFragment r8 = r5.g;
                r2.setOnClickListener(new g0(this, r8));
                r1.setProgress(0);
            }
        }

        public final int getItemCount() {
            int r0 = this.a.size();
            if (this.a.size() >= this.g.g) goto L5;
            int r1 = 1;
        L7:
            return r0 + r1;
        L5:
            r1 = 0;
            goto L7
        }

        public final int getItemViewType(int r2) {
            if (r2 >= this.a.size()) goto L6;
            return 0;
        L6:
            return this.e;
        }

        public final void onViewRecycled(RecyclerView.ViewHolder r4) {
            Intrinsics.checkNotNullParameter(r4, "holder");
            super.onViewRecycled(r4);
            if ((r4 instanceof ImageViewHolder) == false) goto L9;
            ImageViewHolder r5 = (ImageViewHolder) r4;
            Job r0 = r5.h;
            if (r0 == null) goto L7;
            Job.DefaultImpls.cancel$default(r0, null, 1, null);
        L7:
            r5.h = null;
            r5.g = null;
            r5.a.setImageDrawable(null);
            return;
        }

        public final void A2(int r4, int r5) {
            if (r4 >= 0) goto L4;
        L6:
            boolean r0 = false;
        L7:
            if (r0 == false) goto L10;
            Integer r1 = Integer.valueOf(r4);
            Integer r6 = Integer.valueOf(r5);
            DoraGFeedbackFragment r2 = this.g;
            int r3 = DoraGFeedbackFragment.r;
            r2.X90().getImageUploadProgress().put(r1, r6);
            notifyItemChanged(r4, this.d);
            return;
        L10:
            return;
        L4:
            if (r4 >= this.a.size()) goto L6;
            r0 = true;
            goto L7
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r23, int r24) {
            Intrinsics.checkNotNullParameter(r23, "holder");
            int r1 = r23.getItemViewType();
            if (r1 != 0) goto L33;
            ImageViewHolder r12 = (ImageViewHolder) r23;
            Uri r2 = (Uri) ListProtector.get(this.a, r24);
            String r0 = ((RecyclerView.ViewHolder) r12).itemView.getContext().getContentResolver().getType(r2);
            if (r0 != null) goto L7;
        L9:
            boolean r15 = false;
        L10:
            Job r3 = r12.h;
            if (r3 == null) goto L13;
            Job.DefaultImpls.cancel$default(r3, null, 1, null);
        L13:
            r12.g = r2;
            String r5 = r2.toString();
            DoraGFeedbackFragment r4 = this.g;
            int r6 = DoraGFeedbackFragment.r;
            Bitmap r7 = r4.X90().getThumbnailCache().get(r5);
            if (r7 == null) goto L16;
            r12.a.setImageBitmap(r7);
        L23:
            ImageView r8 = r12.e;
            if (r15 == false) goto L26;
            int r9 = 0;
        L27:
            r8.setVisibility(r9);
            Integer r10 = this.g.X90().getImageUploadProgress().get(Integer.valueOf(r24));
            if (r10 == null) goto L30;
            int r14 = r10.intValue();
        L31:
            z2(r12, r15, r14);
            return;
        L30:
            r14 = 0;
            goto L31
        L26:
            r9 = 8;
            goto L27
        L16:
            if (r15 == false) goto L18;
            r12.a.setImageResource(2131240252);
        L20:
            if (this.f.contains(r5) == true) goto L23;
            Context r11 = ((RecyclerView.ViewHolder) r12).itemView.getContext().getApplicationContext();
            int r13 = ((RecyclerView.ViewHolder) r12).itemView.getResources().getDimensionPixelSize(2131166265);
            Ref.ObjectRef r16 = new Ref.ObjectRef();
            Job r17 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.g.getViewLifecycleOwner()), null, CoroutineStart.LAZY, new DoraGFeedbackFragment$ImagePreviewAdapter$bindPreview$2(r2, r12, r16, this.g, r5, this, r15, r11, r13, null), 1, null);
            r16.element = r17;
            r12.h = r17;
            r17.start();
            goto L23
        L18:
            r12.a.setImageDrawable(null);
            goto L20
        L7:
            if (StringsKt.startsWith$default(r0, "video/", false, 2, null) != true) goto L9;
            r15 = true;
            goto L10
        L33:
            if (r1 != this.e) goto L37;
            AddIconViewHolder r18 = (AddIconViewHolder) r23;
            r18.b.setImageResource(2131242396);
            int r20 = ContextCompat.getColor(((RecyclerView.ViewHolder) r18).itemView.getContext(), 2131103683);
            r18.b.setColorFilter(r20, PorterDuff.Mode.SRC_IN);
            TextView r21 = r18.c;
            StringBuilder r22 = new StringBuilder();
            r22.append(this.a.size());
            r22.append('/');
            r22.append(this.g.g);
            r21.setText(r22.toString());
            r18.a.setOnClickListener(new e0(this));
            return;
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            if (r4 != 0) goto L6;
            View r5 = LayoutInflater.from(r3.getContext()).inflate(2131561613, r3, false);
            Intrinsics.checkNotNull(r5);
            return new ImageViewHolder(this, r5);
        L6:
            if (r4 != this.e) goto L10;
            View r6 = LayoutInflater.from(r3.getContext()).inflate(2131560136, r3, false);
            Intrinsics.checkNotNull(r6);
            return new AddIconViewHolder(r6);
        L10:
            throw new IllegalArgumentException("Invalid view type");
        }

        public final Bitmap y2(Bitmap r4, int r5) {
            int r0 = r4.getWidth();
            int r1 = r4.getHeight();
            if (r0 > r5) goto L6;
            if (r1 > r5) goto L6;
            return r4;
        L6:
            float r6 = r5;
            float r2 = r0;
            float r3 = r1;
            float r7 = Math.min(r6 / r2, r6 / r3);
            Bitmap r8 = Bitmap.createScaledBitmap(r4, RangesKt.coerceAtLeast((int) (r2 * r7), 1), RangesKt.coerceAtLeast((int) (r3 * r7), 1), true);
            if (Intrinsics.areEqual(r8, r4) == false) goto L9;
        L11:
            return r8;
        L9:
            if (r4.isRecycled() == true) goto L11;
            r4.recycle();
            goto L11
        }

        public static void z2(ImageViewHolder r3, boolean r4, int r5) {
            int r0 = 0;
            if (r5 >= 0) goto L5;
        L7:
            boolean r1 = false;
        L9:
            if (r1 == false) goto L26;
            if (r3.c.getVisibility() == 0) goto L14;
            r3.c.setVisibility(0);
        L14:
            if (r3.b.getVisibility() == 0) goto L17;
            r3.b.setVisibility(0);
        L17:
            if (r3.d.getVisibility() == 8) goto L20;
            r3.d.setVisibility(8);
        L20:
            if (r3.f.getVisibility() == 8) goto L23;
            r3.f.setVisibility(8);
        L23:
            if (r3.b.getProgress() == r5) goto L55;
            r3.b.setProgress(r5);
            return;
        L55:
            return;
        L26:
            if (r5 != (-1)) goto L40;
            if (r3.b.getVisibility() == 8) goto L31;
            r3.b.setVisibility(8);
        L31:
            if (r3.c.getVisibility() == 0) goto L34;
            r3.c.setVisibility(0);
        L34:
            if (r3.d.getVisibility() == 0) goto L37;
            r3.d.setVisibility(0);
        L37:
            if (r3.f.getVisibility() == 8) goto L57;
            r3.f.setVisibility(8);
            return;
        L57:
            return;
        L40:
            if (r3.c.getVisibility() == 8) goto L43;
            r3.c.setVisibility(8);
        L43:
            if (r3.b.getVisibility() == 8) goto L46;
            r3.b.setVisibility(8);
        L46:
            if (r3.d.getVisibility() == 8) goto L48;
            r3.d.setVisibility(8);
        L48:
            if (r4 == true) goto L52;
            r0 = 8;
        L52:
            if (r3.f.getVisibility() == r0) goto L59;
            r3.f.setVisibility(r0);
            return;
        L59:
            return;
        L5:
            if (r5 >= 100) goto L7;
            r1 = true;
            goto L9
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7, List<Object> r8) {
            Intrinsics.checkNotNullParameter(r6, "holder");
            Intrinsics.checkNotNullParameter(r8, "payloads");
            boolean r1 = true;
            if ((!r8.isEmpty()) == true) goto L5;
        L20:
            super.onBindViewHolder(r6, r7, r8);
            return;
        L5:
            if ((r6 instanceof ImageViewHolder) == false) goto L20;
            if (Intrinsics.areEqual(ListProtector.get(r8, 0), this.d) == false) goto L20;
            Uri r9 = (Uri) ListProtector.get(this.a, r7);
            DoraGFeedbackFragment r2 = this.g;
            int r3 = DoraGFeedbackFragment.r;
            Integer r10 = r2.X90().getImageUploadProgress().get(Integer.valueOf(r7));
            if (r10 == null) goto L11;
            int r11 = r10.intValue();
        L12:
            String r12 = r6.itemView.getContext().getContentResolver().getType(r9);
            if (r12 != null) goto L15;
        L17:
            r1 = false;
        L18:
            z2((ImageViewHolder) r6, r1, r11);
            return;
        L15:
            if (StringsKt.startsWith$default(r12, "video/", false, 2, null) != true) goto L17;
        L11:
            r11 = 0;
            goto L12
        }

        public ImagePreviewAdapter(DoraGFeedbackFragment r2, List r3, q r4, r r5) {
            Intrinsics.checkNotNullParameter(r3, "imageUris");
            Intrinsics.checkNotNullParameter(r4, "onRemoveClick");
            Intrinsics.checkNotNullParameter(r5, "onAddClick");
            this.g = r2;
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = "PAYLOAD_PROGRESS";
            this.e = 1;
            this.f = new LinkedHashSet();
        }
    }

    public static final class a {
    }

    public static final class b implements com.larus.common_ui.dialog.p0 {
        public final /* synthetic */ DoraGFeedbackFragment a;
        public final /* synthetic */ boolean b;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            DoragFeedbackFragmentBinding r0 = this.a.f;
            Intrinsics.checkNotNull(r0);
            r0.c.setChecked(true);
            if (this.b == false) goto L5;
            this.a.X90().markFeedbackSubmitStart();
        L5:
            g49.d.d("DoraSuggestionFragment", "Feedback consent confirmed and persisted");
            CommonDialog r1 = this.a.q;
            if (r1 != null) goto L17;
        L13:
            DoraGFeedbackFragment r2 = this.a;
            r2.q = null;
            if (this.b == false) goto L19;
            r2.X90().submitFeedback();
            return;
        L19:
            return;
        L17:
            r1.dismissAllowingStateLoss();     // Catch: Exception -> L9
        L9:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L13;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L13
        }

        public b(DoraGFeedbackFragment r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements com.larus.common_ui.dialog.u {
        public c() {
        }

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
            g49.d.d("DoraSuggestionFragment", "Feedback consent dialog cancelled");
        }
    }

    static {
    }

    public final String k() {
        return "DoraSuggestionFragment";
    }

    public final void W90() {
        if (this.p == true) goto L5;
        return;
    L5:
        this.p = false;
        com.larus.common_ui.dialog.l0 r0 = (com.larus.common_ui.dialog.l0) this.o.getValue();
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r0);
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r2 == null) goto L19;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L8:
        if (Looper.myLooper() == r1.getLooper()) goto L10;
        r1.post(DialogLancet.createDismissRunnable(r0));
    }

    public final DoraGFeedbackViewModel X90() {
        return (DoraGFeedbackViewModel) this.j.getValue();
    }

    public DoraGFeedbackFragment() {
        this.g = 4;
        this.h = 300;
        this.i = 50;
        this.j = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraGFeedbackViewModel.class), new DoraGFeedbackFragment$special$$inlined$activityViewModels$default$1(this), new DoraGFeedbackFragment$special$$inlined$activityViewModels$default$2(this));
        this.k = new ArrayList();
        this.n = CollectionsKt.listOf(new FeedbackType[]{FeedbackType.QUICK_FEEDBACK, FeedbackType.DOUBAO_CONVERSATION_PROBLEM, FeedbackType.GLASSES_APP_FAULT, FeedbackType.PRODUCT_SUGGESTION});
        this.o = LazyKt.lazy(new n(this));
    }

    public final void aa0() {
        FeedbackType r0 = (FeedbackType) X90().getFeedbackTypeFlow().getValue();
        DoragFeedbackFragmentBinding r1 = this.f;
        Intrinsics.checkNotNull(r1);
        int r2 = 8;
        r1.e.setVisibility(8);
        DoragFeedbackFragmentBinding r3 = this.f;
        Intrinsics.checkNotNull(r3);
        r3.p.setVisibility(8);
        DoragFeedbackFragmentBinding r4 = this.f;
        Intrinsics.checkNotNull(r4);
        r4.r.setVisibility(8);
        DoragFeedbackFragmentBinding r5 = this.f;
        Intrinsics.checkNotNull(r5);
        LinearLayout r6 = r5.g;
        if (r0 != FeedbackType.QUICK_FEEDBACK) goto L5;
        r2 = 0;
    L5:
        r6.setVisibility(r2);
        if (r0 != FeedbackType.DOUBAO_CONVERSATION_PROBLEM) goto L9;
        DoragFeedbackFragmentBinding r7 = this.f;
        Intrinsics.checkNotNull(r7);
        r7.p.setVisibility(0);
        DoragFeedbackFragmentBinding r8 = this.f;
        Intrinsics.checkNotNull(r8);
        r8.e.setVisibility(0);
        DoragFeedbackFragmentBinding r9 = this.f;
        Intrinsics.checkNotNull(r9);
        r9.r.setVisibility(0);
        DoragFeedbackFragmentBinding r10 = this.f;
        Intrinsics.checkNotNull(r10);
        r10.e.setAlpha(0.0f);
        DoragFeedbackFragmentBinding r11 = this.f;
        Intrinsics.checkNotNull(r11);
        r11.e.animate().alpha(1.0f).setDuration(200).start();
        return;
    }

    public final void onDestroyView() {
        W90();
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        ImagePreviewAdapter r0 = null;
        this.f = null;
        ImagePreviewAdapter r1 = this.l;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("imageAdapter");
    L6:
        r0.g.X90().getThumbnailCache().evictAll();
        r0.f.clear();
        return;
    L5:
        r0 = r1;
        goto L6
    }

    public final void Y90(final View r9) {
        DoragFeedbackFragmentBinding r0 = this.f;
        if (r0 != null) goto L6;
        return;
    L6:
        if (isAdded() == true) goto L8;
        return;
    L8:
        if (r9.isAttachedToWindow() == false) goto L26;
        final ScrollView r1 = r0.k;
        if (r1.isAttachedToWindow() == true) goto L14;
        return;
    L14:
        if (r9.isShown() == true) goto L16;
    L23:
        r9.post(new t(this, r9));
        return;
    L16:
        if (r9.getHeight() == 0) goto L23;
        View r3 = r1.getChildAt(0);
        if (r3 != null) goto L21;
        return;
    L21:
        int[] r5 = new int[2];
        r9.getLocationInWindow(r5);
        int r6 = r5[1];
        int[] r7 = new int[2];
        r3.getLocationInWindow(r7);
        int r8 = r6 - r7[1];
        getResources().getDimensionPixelSize(2131166236);
        Resources r4 = getResources();
        final int r10 = RangesKt.coerceAtLeast(r8 - (((WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).heightPixels - r0.n.getHeight()) / 2) - r9.getHeight()), 0);
        r1.post(new u(this, r1, r10));
        return;
    }

    public final void Z90(boolean r5) {
        CommonDialog r0 = this.q;
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.isVisible() != true) goto L7;
    L8:
        if (r2 == false) goto L10;
        return;
    L10:
        CommonDialog.a r1 = new CommonDialog.a();
        int r3 = com.larus.utils.j0.a;
        r1.i(com.larus.utils.j0.d(2131902888));
        r1.g(com.larus.utils.j0.d(2131902887));
        CommonDialog.a.f(r1, new b(this, r5), com.larus.utils.j0.d(2131900458), false, 12);
        com.larus.common_ui.dialog.f0 r6 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(requireContext(), 2131103681)), null, 5);
        Intrinsics.checkNotNullParameter(r6, "commonDialogTextStyleConfig");
        r1.D = r6;
        CommonDialog.a.e(r1, new c(), com.larus.utils.j0.d(2131900456), 4);
        CommonDialog r7 = r1.a();
        this.q = r7;
        g49.d.d("DoraSuggestionFragment", "Showing feedback consent dialog");
        FragmentManager r4 = getChildFragmentManager();
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r7, "DoraGFeedbackPrivacyConsentDialog", r8);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r7, r8) == true) goto L19;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L14:
        r7.show(r4, "DoraGFeedbackPrivacyConsentDialog");
        return;
    L19:
        return;
    L7:
        r2 = false;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r11v51, types: [android.widget.EditText, com.larus.common_ui.widget.NestedScrollEditText] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.larus.dora.impl.feedback.q] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.dora.impl.feedback.r] */
    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r11, r12);
        X90().setImageSubmitCallback(new h0(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGFeedbackFragment$initViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        DoragFeedbackFragmentBinding r13 = this.f;
        Intrinsics.checkNotNull(r13);
        NovaTitleBarEx r0 = r13.n;
        int r14 = com.larus.utils.j0.a;
        NovaTitleBarEx.Y5(r0, com.larus.utils.j0.d(2131902729), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131240517, false, null, null, new p(this), 14);
        DoragFeedbackFragmentBinding r15 = this.f;
        Intrinsics.checkNotNull(r15);
        r15.f.setHint(StringsKt.replace$default(com.larus.utils.j0.d(2131902723), "\\n", "\n", false, 4, null));
        this.l = new ImagePreviewAdapter(this, this.k, new q(this), new r(this));
        DoragFeedbackFragmentBinding r16 = this.f;
        Intrinsics.checkNotNull(r16);
        RecyclerView r17 = r16.i;
        r17.setLayoutManager(new LinearLayoutManager(r17.getContext(), 0, false));
        ImagePreviewAdapter r1 = this.l;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("imageAdapter");
        r1 = null;
    L5:
        r17.setAdapter(r1);
        DoragFeedbackFragmentBinding r18 = this.f;
        Intrinsics.checkNotNull(r18);
        r18.m.setText(((FeedbackType) X90().getFeedbackTypeFlow().getValue()).getStr());
        String r110 = com.larus.utils.j0.d(2131902706);
        SpannableString r2 = new SpannableString(com.larus.utils.j0.d(2131902705) + r110 + com.larus.utils.j0.d(2131902707));
        int r3 = StringsKt.indexOf$default(r2, r110, 0, false, 6, null);
        if (r3 < 0) goto L8;
        int r4 = ContextCompat.getColor(requireContext(), 2131103681);
        r2.setSpan(new ForegroundColorSpan(r4), r3, r110.length() + r3, 33);
        r2.setSpan(new StyleSpan(1), r3, r110.length() + r3, 33);
        r2.setSpan(new i0(this, r4), r3, r110.length() + r3, 33);
    L8:
        DoragFeedbackFragmentBinding r111 = this.f;
        Intrinsics.checkNotNull(r111);
        r111.q.setText(r2);
        DoragFeedbackFragmentBinding r112 = this.f;
        Intrinsics.checkNotNull(r112);
        r112.q.setMovementMethod(LinkMovementMethod.getInstance());
        DoragFeedbackFragmentBinding r113 = this.f;
        Intrinsics.checkNotNull(r113);
        r113.q.setHighlightColor(0);
        DoragFeedbackFragmentBinding r114 = this.f;
        Intrinsics.checkNotNull(r114);
        r114.c.setChecked(X90().isFeedbackConsentGranted());
        DoragFeedbackFragmentBinding r115 = this.f;
        Intrinsics.checkNotNull(r115);
        r115.f.setText((CharSequence) X90().getFeedbackContentFlow().getValue());
        DoragFeedbackFragmentBinding r116 = this.f;
        Intrinsics.checkNotNull(r116);
        r116.o.setText(String.valueOf(((String) X90().getFeedbackContentFlow().getValue()).length()));
        Iterator<T> r117 = X90().getFeedbackImageGroup().a().iterator();
    L10:
        if (r117.hasNext() == false) goto L12;
        g r5 = (g) r117.next();
        ((ArrayList) this.k).add(r5.a);
        goto L10
    L12:
        aa0();
        Lifecycle.State r118 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGFeedbackFragment$initViews$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r118, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGFeedbackFragment$initViews$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r118, null, this), 3, null);
        this.m = registerForActivityResult(new ActivityResultContracts.OpenDocument(), new o(this));
        DoragFeedbackFragmentBinding r119 = this.f;
        Intrinsics.checkNotNull(r119);
        e1.d(r119.b, new v(this));
        DoragFeedbackFragmentBinding r120 = this.f;
        Intrinsics.checkNotNull(r120);
        r120.c.setOnCheckedChangeListener(new w(this));
        DoragFeedbackFragmentBinding r121 = this.f;
        Intrinsics.checkNotNull(r121);
        r121.g.setOnClickListener(new x(this));
        DoragFeedbackFragmentBinding r122 = this.f;
        Intrinsics.checkNotNull(r122);
        r122.a.setOnClickListener(new y());
        DoragFeedbackFragmentBinding r123 = this.f;
        Intrinsics.checkNotNull(r123);
        r123.f.addTextChangedListener(new l0(this));
        DoragFeedbackFragmentBinding r124 = this.f;
        Intrinsics.checkNotNull(r124);
        r124.d.addTextChangedListener(new m0(this));
        DoragFeedbackFragmentBinding r125 = this.f;
        Intrinsics.checkNotNull(r125);
        e1.d(r125.h, new z(this));
        DoragFeedbackFragmentBinding r126 = this.f;
        Intrinsics.checkNotNull(r126);
        final ?? r127 = r126.d;
        r127.setOnFocusChangeListener(new a0(this));
        r127.setOnClickListener(new b0(r127, this));
        DoragFeedbackFragmentBinding r128 = this.f;
        Intrinsics.checkNotNull(r128);
        e1.d(r128.r, new c0(this));
        DoragFeedbackFragmentBinding r129 = this.f;
        Intrinsics.checkNotNull(r129);
        r129.l.setOnClickListener(new d0(this));
    }

    public final View onCreateView(LayoutInflater r23, ViewGroup r24, Bundle r25) {
        Intrinsics.checkNotNullParameter(r23, "inflater");
        ConstraintLayout r0 = r23.inflate(2131560168, r24, false);
        int r1 = 2131364631;
        DoraTextView r5 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131364631);
        if (r5 == null) goto L47;
        r1 = 2131365299;
        AppCompatCheckBox r6 = ViewBindings.findChildViewById(r0, 2131365299);
        if (r6 == null) goto L47;
        r1 = 2131365310;
        NestedScrollEditText r7 = (NestedScrollEditText) ViewBindings.findChildViewById(r0, 2131365310);
        if (r7 == null) goto L47;
        r1 = 2131369447;
        RoundFrameLayout r8 = (RoundFrameLayout) ViewBindings.findChildViewById(r0, 2131369447);
        if (r8 == null) goto L47;
        r1 = 2131371784;
        NestedScrollEditText r9 = (NestedScrollEditText) ViewBindings.findChildViewById(r0, 2131371784);
        if (r9 == null) goto L47;
        r1 = 2131372276;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131372276);
        if (r10 == null) goto L47;
        r1 = 2131372312;
        RoundFrameLayout r11 = (RoundFrameLayout) ViewBindings.findChildViewById(r0, 2131372312);
        if (r11 == null) goto L47;
        r1 = 2131375355;
        if (((RoundFrameLayout) ViewBindings.findChildViewById(r0, 2131375355)) == null) goto L47;
        r1 = 2131375994;
        if (((ImageView) ViewBindings.findChildViewById(r0, 2131375994)) == null) goto L47;
        r1 = 2131384964;
        MaxWidthRecyclerView r12 = (MaxWidthRecyclerView) ViewBindings.findChildViewById(r0, 2131384964);
        if (r12 == null) goto L47;
        r1 = 2131385233;
        View r13 = ViewBindings.findChildViewById(r0, 2131385233);
        if (r13 == null) goto L47;
        r1 = 2131385238;
        ScrollView r14 = (ScrollView) ViewBindings.findChildViewById(r0, 2131385238);
        if (r14 == null) goto L47;
        r1 = 2131385243;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131385243);
        if (r15 == null) goto L47;
        r1 = 2131387109;
        DoraTextView r16 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131387109);
        if (r16 == null) goto L47;
        r1 = 2131388772;
        NovaTitleBarEx r17 = ViewBindings.findChildViewById(r0, 2131388772);
        if (r17 == null) goto L47;
        r1 = 2131390297;
        DoraTextView r18 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131390297);
        if (r18 == null) goto L47;
        r1 = 2131390403;
        LinearLayout r110 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131390403);
        if (r110 == null) goto L47;
        r1 = 2131390536;
        if (((DoraTextView) ViewBindings.findChildViewById(r0, 2131390536)) == null) goto L47;
        r1 = 2131390609;
        DoraTextView r20 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131390609);
        if (r20 == null) goto L47;
        r1 = 2131390758;
        DoraTextView r21 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131390758);
        if (r21 == null) goto L47;
        r1 = 2131390927;
        if (((DoraTextView) ViewBindings.findChildViewById(r0, 2131390927)) == null) goto L47;
        ConstraintLayout r2 = r0;
        DoragFeedbackFragmentBinding r3 = new DoragFeedbackFragmentBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r110, r20, r21);
        this.f = r3;
        Intrinsics.checkNotNull(r3);
        return r2;
    L47:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
