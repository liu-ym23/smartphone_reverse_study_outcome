package com.larus.dora.obric.device_management.setting.g.feedback;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common_ui.widget.CircleProgressBar;
import com.larus.common_ui.widget.NestedScrollEditText;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.feedback.DoraGFeedbackViewModel;
import com.larus.dora.impl.feedback.FeedbackType;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
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
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 \u0085\u00012\u00020\u0001:\u0004\u0084\u0001\u0085\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00103\u001a\u00020\u0016H\u0016J\u0012\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u0016J$\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u001a\u0010=\u001a\u0002052\u0006\u0010>\u001a\u00020%2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u0010?\u001a\u000205H\u0016J\b\u0010@\u001a\u00020%H\u0002J\b\u0010A\u001a\u00020%H\u0002J\b\u0010B\u001a\u00020%H\u0002J\b\u0010C\u001a\u00020\u001cH\u0002J\b\u0010D\u001a\u00020%H\u0002J\b\u0010E\u001a\u00020%H\u0002J\b\u0010F\u001a\u00020%H\u0002J\b\u0010G\u001a\u00020%H\u0002J\b\u0010H\u001a\u00020%H\u0002J\b\u0010I\u001a\u00020%H\u0002J\b\u0010J\u001a\u00020 H\u0002J\b\u0010K\u001a\u00020%H\u0002J\b\u0010L\u001a\u000205H\u0002J\b\u0010M\u001a\u000205H\u0002J\b\u0010N\u001a\u000205H\u0002J\b\u0010O\u001a\u000205H\u0002J\b\u0010P\u001a\u000205H\u0002J\b\u0010Q\u001a\u000205H\u0002J\u001e\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010WJ\u001e\u0010X\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010WJ\u0010\u0010Y\u001a\u0002052\u0006\u0010Z\u001a\u00020\u001cH\u0002J\b\u0010[\u001a\u000205H\u0002J\b\u0010\\\u001a\u000205H\u0002J\u0010\u0010]\u001a\u0002052\u0006\u0010^\u001a\u00020%H\u0002J\b\u0010_\u001a\u000205H\u0002J\u0018\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020cH\u0002J(\u0010e\u001a\u00020a2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020c2\u0006\u0010f\u001a\u00020c2\u0006\u0010g\u001a\u00020cH\u0002J\u0010\u0010h\u001a\u0002052\u0006\u0010i\u001a\u00020jH\u0002J\f\u0010k\u001a\u000205*\u00020\u001cH\u0002J\f\u0010l\u001a\u000205*\u00020\u001cH\u0002J\f\u0010m\u001a\u000205*\u00020 H\u0002J\f\u0010n\u001a\u000205*\u00020oH\u0002J\f\u0010p\u001a\u000205*\u00020 H\u0002J\f\u0010q\u001a\u000205*\u00020 H\u0002J\f\u0010r\u001a\u000205*\u00020sH\u0002J\f\u0010t\u001a\u000205*\u00020+H\u0002J\b\u0010u\u001a\u00020cH\u0002J\b\u0010v\u001a\u00020cH\u0002J\b\u0010w\u001a\u00020cH\u0002J\b\u0010x\u001a\u00020cH\u0002J\b\u0010y\u001a\u00020cH\u0002J\b\u0010z\u001a\u00020cH\u0002J\b\u0010{\u001a\u00020cH\u0002J\b\u0010|\u001a\u00020cH\u0002J\b\u0010}\u001a\u00020cH\u0002J\b\u0010~\u001a\u00020cH\u0002J\u0011\u0010\u007f\u001a\u00020%2\u0007\u0010\u0080\u0001\u001a\u00020cH\u0002J\r\u0010\u0081\u0001\u001a\u00020c*\u00020cH\u0002J\u000e\u0010\u0082\u0001\u001a\u00020c*\u00030\u0083\u0001H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00060\u0012R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\t\u001a\u0004\b0\u00101¨\u0006\u0086\u0001"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/feedback/DoraObricGFeedbackFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/impl/feedback/DoraGFeedbackViewModel;", "getViewModel", "()Lcom/larus/dora/impl/feedback/DoraGFeedbackViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "selectedImageUris", "", "Landroid/net/Uri;", "feedbackTypes", "", "Lcom/larus/dora/impl/feedback/FeedbackType;", "defaultFeedbackType", "imageAdapter", "Lcom/larus/dora/obric/device_management/setting/g/feedback/DoraObricGFeedbackFragment$ObricFeedbackImageAdapter;", "pickImageLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "scrollView", "Landroidx/core/widget/NestedScrollView;", "scrollContainer", "Landroid/widget/LinearLayout;", "feedbackTypeCard", "Lcom/obric/oui/lisitem/OCardListItem;", "feedbackContentInput", "Lcom/larus/common_ui/widget/NestedScrollEditText;", "charCountText", "Lcom/obric/oui/text/OTextView;", "imageTitleText", "imageRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "conversationTitle", "Landroid/view/View;", "conversationInputContainer", "conversationInput", "howConversationLinkText", "scrollPadding", "submitButton", "Lcom/obric/oui/button/OButton;", "feedbackTypePopover", "Lcom/obric/oui/popover/v2/OPopover;", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "getCurrentPageName", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "buildContentView", "buildTitleBar", "buildBody", "buildFeedbackTypeCard", "buildRequiredTitle", "buildDescriptionInput", "buildImageTitle", "buildImageRecyclerView", "buildConversationTitle", "buildConversationInput", "buildHowConversationLink", "buildBottomButtonContainer", "initViewModel", "initImageAdapter", "initInputs", "initPickers", "setupListeners", "observeSubmitState", "getFileSizeFromUri", "", "context", "Landroid/content/Context;", "uri", "(Landroid/content/Context;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoDurationFromUri", "showFeedbackTypePopover", "anchor", "updateConditionalSectionsVisibility", "clearInputFocus", "scrollToView", "targetView", "updateImageTitle", "roundedDrawable", "Landroid/graphics/drawable/GradientDrawable;", "color", "", "radiusDp", "roundedStrokeDrawable", "strokeColor", "strokeWidthDp", "setFeedbackTypeText", "text", "", "applyFeedbackTypeCardStyle", "resetCardContainerMargins", "applyFeedbackValueTextStyle", "applyDropIconStyle", "Landroid/widget/ImageView;", "applySectionTitleStyle", "applyCountTextStyle", "applyTitleBarTextStyle", "Landroid/widget/TextView;", "applyBottomButtonStyle", "resolveBackgroundColor", "resolveCardColor", "resolveImageStrokeColor", "resolveButtonPrimaryColor", "resolveButtonDisabledColor", "resolveAddImageButtonBackgroundColor", "resolveButtonTextColor", "resolveDestructiveTextColor", "resolvePrimaryTextColor", "resolveSecondaryTextColor", "buildSpacer", "heightDp", "dp", "sp", "", "ObricFeedbackImageAdapter", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGFeedbackFragment extends DoraBaseFragment {
    public static final /* synthetic */ int A = 0;
    public final Lazy f;
    public final List<Uri> g;
    public final List<FeedbackType> h;
    public final FeedbackType i;
    public b j;
    public ActivityResultLauncher<String[]> k;
    public NestedScrollView l;
    public LinearLayout m;
    public OCardListItem n;
    public NestedScrollEditText o;
    public OTextView p;
    public OTextView q;
    public RecyclerView r;
    public View s;
    public View t;
    public NestedScrollEditText u;
    public OTextView v;
    public View w;
    public OButton x;
    public com.obric.oui.popover.v2.c y;
    public final Lazy z;

    public static final class a {
    }

    public final class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public final List<Uri> a;
        public final Function1<Integer, Unit> b;
        public final Function0<Unit> c;
        public final Set<String> d;
        public final /* synthetic */ DoraObricGFeedbackFragment e;

        public final class a extends RecyclerView.ViewHolder {
            public final FrameLayout a;

            public a(FrameLayout r2) {
                Intrinsics.checkNotNullParameter(r2, "container");
                super(r2);
                this.a = r2;
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.feedback.DoraObricGFeedbackFragment$b$b, reason: collision with other inner class name */
        public final class C0106b extends RecyclerView.ViewHolder {
            public final ImageView a;
            public final View b;
            public final View c;
            public final CircleProgressBar d;
            public final ImageView e;
            public final ImageView f;
            public final FrameLayout g;
            public Uri h;
            public Job i;

            public C0106b(final b r17, FrameLayout r18) {
                Intrinsics.checkNotNullParameter(r18, "container");
                super(r18);
                ImageView r3 = new ImageView(r18.getContext());
                r3.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.a = r3;
                View r4 = new View(r18.getContext());
                r4.setBackgroundColor(ContextCompat.getColor(r18.getContext(), 2131106517));
                this.b = r4;
                View r5 = new View(r18.getContext());
                r5.setBackground(ContextCompat.getDrawable(r18.getContext(), 2131256458));
                this.c = r5;
                CircleProgressBar r6 = new CircleProgressBar(r18.getContext(), null, 6, 0);
                this.d = r6;
                ImageView r7 = new ImageView(r18.getContext());
                r7.setImageResource(2131243253);
                r7.setVisibility(8);
                this.e = r7;
                ImageView r9 = new ImageView(r18.getContext());
                r9.setImageResource(2131240595);
                ImageView r11 = new ImageView(r18.getContext());
                r11.setImageResource(2131235959);
                r11.setVisibility(8);
                this.f = r11;
                FrameLayout r8 = new FrameLayout(r18.getContext());
                DoraObricGFeedbackFragment r12 = r17.e;
                int r13 = DoraObricGFeedbackFragment.A;
                int r14 = r12.ba0();
                int r10 = v19.c.a(2130972086, r12.requireContext(), 2131103159);
                GradientDrawable r15 = r12.ea0(r14, 10);
                r15.setStroke(r12.X90(1), r10);
                r8.setBackground(r15);
                r8.setClipToOutline(true);
                this.g = r8;
                r8.addView(r3, new FrameLayout.LayoutParams(-1, -1));
                r8.addView(r4, new FrameLayout.LayoutParams(-1, -1));
                r8.addView(r5, new FrameLayout.LayoutParams(-1, -1));
                r8.addView(r6, new FrameLayout.LayoutParams(r17.e.X90(24), r17.e.X90(24), 17));
                r8.addView(r7, new FrameLayout.LayoutParams(r17.e.X90(20), r17.e.X90(20), 17));
                FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(r17.e.X90(16), r17.e.X90(16), 8388691);
                DoraObricGFeedbackFragment r20 = r17.e;
                r16.setMarginStart(r20.X90(4));
                r16.bottomMargin = r20.X90(4);
                Unit r21 = Unit.INSTANCE;
                r8.addView(r11, r16);
                r18.addView(r8, new FrameLayout.LayoutParams(r17.e.X90(52), r17.e.X90(52), 8388627));
                FrameLayout.LayoutParams r22 = new FrameLayout.LayoutParams(r17.e.X90(32), r17.e.X90(32), 8388659);
                DoraObricGFeedbackFragment r23 = r17.e;
                r22.setMarginStart(r23.X90(36));
                r22.topMargin = r23.X90(-12);
                r18.addView(r9, r22);
                final DoraObricGFeedbackFragment r2 = r17.e;
                r9.setOnClickListener(new s(this, r2, r17));
                final DoraObricGFeedbackFragment r1 = r17.e;
                r7.setOnClickListener(new t(this, r1));
                r6.setProgress(0);
            }
        }

        public final int getItemCount() {
            int r0 = this.a.size();
            if (this.a.size() >= 4) goto L5;
            int r1 = 1;
        L7:
            return r0 + r1;
        L5:
            r1 = 0;
            goto L7
        }

        public final int getItemViewType(int r2) {
            if (r2 >= this.a.size()) goto L5;
            return 0;
        L5:
            return 1;
        }

        public final void onViewRecycled(RecyclerView.ViewHolder r4) {
            Intrinsics.checkNotNullParameter(r4, "holder");
            super.onViewRecycled(r4);
            if ((r4 instanceof C0106b) == false) goto L9;
            C0106b r5 = (C0106b) r4;
            Job r0 = r5.i;
            if (r0 == null) goto L7;
            Job.DefaultImpls.cancel$default(r0, null, 1, null);
        L7:
            r5.i = null;
            r5.h = null;
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
            DoraObricGFeedbackFragment r2 = this.e;
            int r3 = DoraObricGFeedbackFragment.A;
            r2.Y90().getImageUploadProgress().put(r1, r6);
            notifyItemChanged(r4, "PAYLOAD_PROGRESS");
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
            if (r1 == 0) goto L7;
            if (r1 != 1) goto L37;
            ((a) r23).a.setOnClickListener(new r(this));
            return;
        L37:
            return;
        L7:
            C0106b r12 = (C0106b) r23;
            Uri r2 = (Uri) ListProtector.get(this.a, r24);
            String r0 = ((RecyclerView.ViewHolder) r12).itemView.getContext().getContentResolver().getType(r2);
            if (r0 != null) goto L10;
        L12:
            boolean r15 = false;
        L13:
            Job r3 = r12.i;
            if (r3 == null) goto L16;
            Job.DefaultImpls.cancel$default(r3, null, 1, null);
        L16:
            r12.h = r2;
            String r5 = r2.toString();
            DoraObricGFeedbackFragment r4 = this.e;
            int r6 = DoraObricGFeedbackFragment.A;
            Bitmap r7 = r4.Y90().getThumbnailCache().get(r5);
            if (r7 == null) goto L19;
            r12.a.setImageBitmap(r7);
        L26:
            ImageView r8 = r12.f;
            if (r15 == false) goto L29;
            int r9 = 0;
        L30:
            r8.setVisibility(r9);
            Integer r10 = this.e.Y90().getImageUploadProgress().get(Integer.valueOf(r24));
            if (r10 == null) goto L33;
            int r14 = r10.intValue();
        L34:
            z2(r12, r15, r14);
            return;
        L33:
            r14 = 0;
            goto L34
        L29:
            r9 = 8;
            goto L30
        L19:
            if (r15 == false) goto L21;
            r12.a.setImageResource(2131240252);
        L23:
            if (this.d.contains(r5) == true) goto L26;
            Context r11 = ((RecyclerView.ViewHolder) r12).itemView.getContext().getApplicationContext();
            int r13 = this.e.X90(52);
            Ref.ObjectRef r16 = new Ref.ObjectRef();
            Job r17 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.e.getViewLifecycleOwner()), null, CoroutineStart.LAZY, new DoraObricGFeedbackFragment$ObricFeedbackImageAdapter$bindPreview$2(r2, r12, r16, this.e, r5, this, r15, r11, r13, null), 1, null);
            r16.element = r17;
            r12.i = r17;
            r17.start();
            goto L26
        L21:
            r12.a.setImageDrawable(null);
            goto L23
        L10:
            if (StringsKt.startsWith$default(r0, "video/", false, 2, null) != true) goto L12;
            r15 = true;
            goto L13
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r8, int r9) {
            Intrinsics.checkNotNullParameter(r8, "parent");
            if (r9 != 0) goto L5;
            Context r10 = r8.getContext();
            FrameLayout r2 = new FrameLayout(r10);
            DoraObricGFeedbackFragment r3 = this.e;
            r2.setBackground(new ColorDrawable(ContextCompat.getColor(r10, R.color.transparent)));
            r2.setClipChildren(false);
            r2.setClipToPadding(false);
            int r1 = DoraObricGFeedbackFragment.A;
            RecyclerView.LayoutParams r11 = new RecyclerView.LayoutParams(r3.X90(60), r3.X90(60));
            r11.setMarginEnd(r3.X90(3));
            r2.setLayoutParams(r11);
            return new C0106b(this, r2);
        L5:
            if (r9 != 1) goto L8;
            Context r12 = r8.getContext();
            FrameLayout r4 = new FrameLayout(r12);
            DoraObricGFeedbackFragment r5 = this.e;
            r4.setBackground(new ColorDrawable(ContextCompat.getColor(r12, R.color.transparent)));
            r4.setClickable(true);
            r4.setFocusable(true);
            int r6 = DoraObricGFeedbackFragment.A;
            RecyclerView.LayoutParams r7 = new RecyclerView.LayoutParams(r5.X90(60), r5.X90(60));
            r7.setMarginEnd(r5.X90(11));
            r4.setLayoutParams(r7);
            FrameLayout r0 = new FrameLayout(r12);
            r0.setBackground(r5.ea0(v19.c.a(2130972086, r5.requireContext(), 2131103159), 10));
            ImageView r13 = new ImageView(r12);
            r13.setScaleType(ImageView.ScaleType.FIT_CENTER);
            r13.setImageResource(2131242587);
            r13.setColorFilter(r5.aa0());
            r0.addView(r13, new FrameLayout.LayoutParams(r5.X90(44), r5.X90(44), 17));
            r4.addView(r0, new FrameLayout.LayoutParams(r5.X90(52), r5.X90(52), 8388627));
            return new a(r4);
        L8:
            throw new IllegalArgumentException("Invalid feedback image view type: " + r9);
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

        public static void z2(C0106b r3, boolean r4, int r5) {
            int r0 = 0;
            if (r5 >= 0) goto L5;
        L7:
            boolean r1 = false;
        L9:
            if (r1 == false) goto L14;
            r3.b.setVisibility(0);
            r3.d.setVisibility(0);
            r3.e.setVisibility(8);
            r3.c.setVisibility(8);
            if (r3.d.getProgress() == r5) goto L22;
            r3.d.setProgress(r5);
            return;
        L22:
            return;
        L14:
            if (r5 != (-1)) goto L16;
            r3.d.setVisibility(8);
            r3.b.setVisibility(0);
            r3.e.setVisibility(0);
            r3.c.setVisibility(8);
            return;
        L16:
            r3.b.setVisibility(8);
            r3.d.setVisibility(8);
            r3.e.setVisibility(8);
            View r6 = r3.c;
            if (r4 == true) goto L20;
            r0 = 8;
        L20:
            r6.setVisibility(r0);
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
        L19:
            super.onBindViewHolder(r6, r7, r8);
            return;
        L5:
            if ((r6 instanceof C0106b) == false) goto L19;
            int r0 = 0;
            if (Intrinsics.areEqual(ListProtector.get(r8, 0), "PAYLOAD_PROGRESS") == false) goto L19;
            String r9 = r6.itemView.getContext().getContentResolver().getType((Uri) ListProtector.get(this.a, r7));
            if (r9 != null) goto L11;
        L13:
            r1 = false;
        L14:
            C0106b r10 = (C0106b) r6;
            DoraObricGFeedbackFragment r11 = this.e;
            int r2 = DoraObricGFeedbackFragment.A;
            Integer r12 = r11.Y90().getImageUploadProgress().get(Integer.valueOf(r7));
            if (r12 == null) goto L17;
            r0 = r12.intValue();
        L17:
            z2(r10, r1, r0);
            return;
        L11:
            if (StringsKt.startsWith$default(r9, "video/", false, 2, null) != true) goto L13;
            goto L13
        }

        public b(DoraObricGFeedbackFragment r2, List r3, com.larus.dora.obric.device_management.setting.g.feedback.a r4, i r5) {
            Intrinsics.checkNotNullParameter(r3, "imageUris");
            Intrinsics.checkNotNullParameter(r4, "onRemoveClick");
            Intrinsics.checkNotNullParameter(r5, "onAddClick");
            this.e = r2;
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = new LinkedHashSet();
        }
    }

    static {
    }

    public final String k() {
        return "DoraSuggestionFragment";
    }

    public final DoraGFeedbackViewModel Y90() {
        return (DoraGFeedbackViewModel) this.f.getValue();
    }

    public final void ja0() {
        TextView r0 = this.q;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("imageTitleText");
        r0 = null;
    L7:
        r0.setText(getString(2131903504) + 65288 + ((ArrayList) this.g).size() + "/4）");
    }

    public final void onDestroyView() {
        com.obric.oui.popover.v2.c r0 = this.y;
        if (r0 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    L5:
        this.y = null;
        b r1 = this.j;
        if (r1 == null) goto L8;
        r1.e.Y90().getThumbnailCache().evictAll();
        r1.d.clear();
    L8:
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public DoraObricGFeedbackFragment() {
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraGFeedbackViewModel.class), new DoraObricGFeedbackFragment$special$$inlined$activityViewModels$default$1(this), new DoraObricGFeedbackFragment$special$$inlined$activityViewModels$default$2(this));
        this.g = new ArrayList();
        this.h = CollectionsKt.listOf(new FeedbackType[]{FeedbackType.GLASSES_APP_FAULT, FeedbackType.DOUBAO_CONVERSATION_PROBLEM, FeedbackType.PRODUCT_SUGGESTION});
        this.i = FeedbackType.NONE;
        this.z = LazyKt.lazy(new d(this));
    }

    public final int Z90() {
        return v19.c.a(2130970531, requireContext(), 2131102535);
    }

    public final int aa0() {
        return v19.c.a(2130972123, requireContext(), 2131103203);
    }

    public final int ba0() {
        return v19.c.a(2130970532, requireContext(), 2131102539);
    }

    public final int ca0() {
        return v19.c.a(2130972079, requireContext(), 2131103136);
    }

    public final int da0() {
        return v19.c.a(2130972081, requireContext(), 2131103143);
    }

    public final void ia0() {
        int r2 = 0;
        if (Y90().getFeedbackTypeFlow().getValue() != FeedbackType.DOUBAO_CONVERSATION_PROBLEM) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r2 = 8;
    L9:
        View r1 = this.s;
        View r3 = null;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("conversationTitle");
        r1 = null;
    L12:
        r1.setVisibility(r2);
        View r4 = this.t;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("conversationInputContainer");
        r4 = null;
    L15:
        r4.setVisibility(r2);
        TextView r5 = this.v;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("howConversationLinkText");
        r5 = null;
    L18:
        r5.setVisibility(r2);
        if (r0 == false) goto L29;
        View r6 = this.t;
        if (r6 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("conversationInputContainer");
        r6 = null;
    L23:
        r6.setAlpha(0.0f);
        View r7 = this.t;
        if (r7 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("conversationInputContainer");
    L27:
        r3.animate().alpha(1.0f).setDuration(200).start();
        return;
    L26:
        r3 = r7;
        goto L27
    L29:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void W90(OTextView r4) {
        r4.setTextColor(da0());
        r4.setTextSize(2, 12.0f);
        r4.setIncludeFontPadding(false);
        TextViewCompat.setLineHeight(r4, ha0(16.0f));
        r4.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
    }

    public final int X90(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void fa0(final View r9) {
        if (r9.isShown() == true) goto L5;
    L31:
        r9.post(new e(this, r9));
        return;
    L5:
        if (r9.getHeight() == 0) goto L31;
        FrameLayout r0 = this.l;
        FrameLayout r2 = null;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("scrollView");
        r0 = null;
    L10:
        boolean r3 = false;
        View r1 = r0.getChildAt(0);
        if (r1 != null) goto L13;
        return;
    L13:
        int[] r5 = new int[2];
        r9.getLocationInWindow(r5);
        int[] r6 = new int[2];
        r1.getLocationInWindow(r6);
        int r7 = r5[1] - r6[1];
        FrameLayout r8 = this.l;
        if (r8 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("scrollView");
        r8 = null;
    L16:
        Integer r10 = Integer.valueOf(r8.getHeight());
        if (r10.intValue() <= 0) goto L19;
        r3 = true;
    L19:
        if (r3 == true) goto L22;
        r10 = null;
    L22:
        if (r10 == null) goto L24;
        int r4 = r10.intValue();
    L25:
        final int r11 = r7 - ((r4 / 2) - r9.getHeight());
        FrameLayout r12 = this.l;
        if (r12 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("scrollView");
    L29:
        r2.post(new f(this, r11));
        return;
    L28:
        r2 = r12;
        goto L29
    L24:
        Resources r13 = getResources();
        r4 = WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics()).heightPixels;
        goto L25
    }

    public final void ga0(CharSequence r3) {
        OCardListItem r0 = this.n;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.k(r3, X90(168));
        OCardListItem r4 = this.n;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("feedbackTypeCard");
        r4 = null;
    L8:
        OTextView r5 = r4.getEndDetail();
        if (r5 == null) goto L12;
        r5.setTextColor(da0());
        r5.setTextSize(2, 14.0f);
        TextViewCompat.setLineHeight(r5, ha0(18.0f));
        r5.setSingleLine(true);
        r5.setIncludeFontPadding(false);
        r5.setGravity(8388629);
        return;
    }

    public final int ha0(float r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).scaledDensity) + 0.5f);
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        FeedbackType r3 = (FeedbackType) Y90().getFeedbackTypeFlow().getValue();
        if (r3 != this.i) goto L5;
        return;
    L5:
        if (this.h.contains(r3) == true) goto L9;
        Y90().getFeedbackTypeFlow().setValue(this.i);
        pk4.j.d("DoraGFeedbackViewModel", "OUI feedback page reset unsupported feedback type");
        return;
    }

    public final GradientDrawable ea0(int r3, int r4) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        r0.setColor(r3);
        r0.setCornerRadius(X90(r4));
        return r0;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.larus.dora.obric.device_management.setting.g.feedback.a] */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.dora.obric.device_management.setting.g.feedback.i] */
    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        Y90().setImageSubmitCallback(new u(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGFeedbackFragment$initViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        this.k = registerForActivityResult(new ActivityResultContracts.OpenDocument(), new j(this));
        ((ArrayList) this.g).clear();
        Iterator<T> r12 = Y90().getFeedbackImageGroup().a().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        com.larus.dora.impl.feedback.g r0 = (com.larus.dora.impl.feedback.g) r12.next();
        ((ArrayList) this.g).add(r0.a);
        goto L4
    L6:
        this.j = new b(this, this.g, new com.larus.dora.obric.device_management.setting.g.feedback.a(this), new i(this));
        RecyclerView r13 = this.r;
        if (r13 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("imageRecyclerView");
        r13 = null;
    L9:
        b r1 = this.j;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("imageAdapter");
        r1 = null;
    L12:
        r13.setAdapter(r1);
        ja0();
        ga0(((FeedbackType) Y90().getFeedbackTypeFlow().getValue()).getStr());
        AppCompatEditText r14 = this.o;
        if (r14 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("feedbackContentInput");
        r14 = null;
    L15:
        r14.setText((CharSequence) Y90().getFeedbackContentFlow().getValue());
        TextView r15 = this.p;
        if (r15 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("charCountText");
        r15 = null;
    L18:
        r15.setText(String.valueOf(((String) Y90().getFeedbackContentFlow().getValue()).length()));
        AppCompatEditText r16 = this.u;
        if (r16 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("conversationInput");
        r16 = null;
    L21:
        r16.setText((CharSequence) Y90().getConversationLinkFlow().getValue());
        ia0();
        View r17 = this.x;
        if (r17 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("submitButton");
        r17 = null;
    L24:
        e1.d(r17, new k(this));
        View r18 = getView();
        if (r18 == null) goto L27;
        r18.setOnClickListener(new l());
    L27:
        LinearLayout r110 = this.m;
        if (r110 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("scrollContainer");
        r110 = null;
    L30:
        r110.setOnClickListener(new m(this));
        AppCompatEditText r111 = this.o;
        if (r111 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("feedbackContentInput");
        r111 = null;
    L33:
        r111.addTextChangedListener(new x(this));
        AppCompatEditText r112 = this.u;
        if (r112 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("conversationInput");
        r112 = null;
    L36:
        r112.addTextChangedListener(new y(this));
        AppCompatEditText r113 = this.u;
        if (r113 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("conversationInput");
        r113 = null;
    L39:
        r113.setOnFocusChangeListener(new n(this));
        AppCompatEditText r114 = this.u;
        if (r114 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("conversationInput");
        r114 = null;
    L42:
        r114.setOnClickListener(new o(this));
        AppCompatEditText r115 = this.o;
        if (r115 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("feedbackContentInput");
        r115 = null;
    L45:
        r115.setOnFocusChangeListener(new p(this));
        View r116 = this.v;
        if (r116 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("howConversationLinkText");
        r116 = null;
    L48:
        e1.d(r116, new q(this));
        Lifecycle.State r117 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGFeedbackFragment$observeSubmitState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r117, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGFeedbackFragment$observeSubmitState$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r117, null, this), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10, types: [android.view.View, android.widget.EditText, android.widget.TextView, com.larus.common_ui.widget.NestedScrollEditText] */
    /* JADX WARN: Type inference failed for: r7v27, types: [android.view.View, android.widget.EditText, android.widget.TextView, com.larus.common_ui.widget.NestedScrollEditText] */
    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r110) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        Context r1 = requireContext();
        OFloatingTitleBar r2 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        r2.setClipChildren(false);
        r2.setClipToPadding(false);
        r2.setBackgroundColor(Z90());
        int r3 = j0.a;
        r2.setCenterTitle(j0.d(2131902729));
        r2.setCenterTitleColor(ca0());
        TextView r4 = (TextView) r2.findViewById(2131365427);
        if (r4 == null) goto L5;
        r4.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r4, ha0(22.0f));
        r4.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 600, false));
    L5:
        r2.R(false);
        OFloatingTitleBar.k(r2, null, 6).setOnClickListener(new com.larus.dora.obric.device_management.setting.g.feedback.b(this));
        Context r5 = requireContext();
        FrameLayout r11 = new FrameLayout(r5);
        r11.setClipChildren(false);
        r11.setClipToPadding(false);
        NestedScrollView r12 = new NestedScrollView(r5);
        r12.setClipChildren(true);
        r12.setClipToPadding(false);
        r12.setOverScrollMode(2);
        r12.setFillViewport(true);
        this.l = r12;
        LinearLayout r13 = new LinearLayout(r5);
        r13.setOrientation(1);
        r13.setClipChildren(false);
        r13.setClipToPadding(false);
        r13.setPadding(X90(12), X90(16), X90(12), X90(128));
        final OCardListItem r8 = new OCardListItem(requireContext(), null, 6, 0);
        this.n = r8;
        r8.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r8.setCardType(0);
        OCardListItem.h(r8, 0);
        r8.setShowCardBg(true);
        r8.p(false);
        r8.setTitle(j0.d(2131902733));
        r8.s(true);
        r8.q(false);
        r8.setDefaultCustomEndView(3);
        r8.m(true);
        ga0(((FeedbackType) Y90().getFeedbackTypeFlow().getValue()).getStr());
        r8.setTailIcon(2131245082);
        r8.r(true);
        r8.setOnContentClickListener(new c(this, r8));
        ViewGroup.LayoutParams r9 = r8.getCardContainer().getLayoutParams();
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r9;
    L9:
        if (r10 == null) goto L11;
        r10.setMarginStart(0);
        r10.setMarginEnd(0);
        r10.leftMargin = 0;
        r10.rightMargin = 0;
        r8.getCardContainer().setLayoutParams(r10);
    L11:
        r8.getCardContainer().setPadding(X90(8), X90(8), X90(8), X90(8));
        r8.getContentContainer().setPadding(0, 0, X90(4), 0);
        r8.getTitleContainer().setGravity(16);
        r8.getTitleContainer().setPadding(X90(12), X90(5), X90(8), X90(5));
        OTextView r6 = r8.getTitleView();
        r6.setGravity(8388611);
        r6.setMaxLines(1);
        r6.setTextColor(ca0());
        r6.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r6, ha0(22.0f));
        r6.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        ImageView r7 = r8.getTailIconView();
        r7.setImageTintList(ContextCompat.getColorStateList(r7.getContext(), 2131104363));
        r7.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ViewGroup.LayoutParams r14 = r7.getLayoutParams();
        if (r14 == null) goto L14;
        r14.width = X90(20);
        r14.height = X90(20);
    L15:
        r7.setLayoutParams(r14);
        r8.o(false);
        r8.getCardContainer().setBackground(ea0(ba0(), 20));
        r8.getContentContainer().setBackground(ea0(ba0(), 12));
        r13.addView(r8);
        View r15 = new View(requireContext());
        r15.setLayoutParams(new LinearLayout.LayoutParams(-1, X90(16)));
        r13.addView(r15);
        Context r16 = requireContext();
        LinearLayout r20 = new LinearLayout(r16);
        r20.setOrientation(0);
        r20.setGravity(16);
        r20.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r20.setPadding(X90(8), X90(8), X90(8), X90(8));
        OTextView r21 = new OTextView(r16, null, 0, 14);
        r21.setText(j0.d(2131902714));
        W90(r21);
        r20.addView(r21);
        OTextView r22 = new OTextView(r16, null, 0, 14);
        r22.setText(getString(2131903505));
        W90(r22);
        LinearLayout.LayoutParams r23 = new LinearLayout.LayoutParams(-2, -2);
        r23.setMarginStart(X90(2));
        Unit r111 = Unit.INSTANCE;
        r20.addView(r22, r23);
        r13.addView(r20);
        Context r24 = requireContext();
        LinearLayout r25 = new LinearLayout(r24);
        r25.setOrientation(1);
        r25.setBackground(ea0(ba0(), 20));
        r25.setPadding(X90(8), X90(8), X90(8), X90(8));
        LinearLayout.LayoutParams r26 = new LinearLayout.LayoutParams(-1, -2);
        r26.topMargin = X90(8);
        r25.setLayoutParams(r26);
        ?? r27 = new NestedScrollEditText(r24, null, 6, 0);
        r27.setBackground(null);
        r27.setGravity(8388659);
        r27.setOverScrollMode(0);
        r27.setTextColor(ca0());
        r27.setHintTextColor(da0());
        r27.setHint(j0.d(2131902715));
        r27.setTextSize(2, 16.0f);
        r27.setIncludeFontPadding(false);
        TextViewCompat.setLineHeight(r27, ha0(22.0f));
        this.o = r27;
        r25.addView(r27, new LinearLayout.LayoutParams(-1, X90(112)));
        LinearLayout r28 = new LinearLayout(r24);
        r28.setGravity(8388629);
        OTextView r112 = new OTextView(r24, null, 0, 14);
        r112.setText("0");
        r112.setTextColor(da0());
        r112.setTextSize(2, 10.0f);
        r112.setIncludeFontPadding(false);
        TextViewCompat.setLineHeight(r112, ha0(14.0f));
        this.p = r112;
        r28.addView(r112);
        OTextView r30 = new OTextView(r24, null, 0, 14);
        r30.setText("/300");
        r30.setTextColor(da0());
        r30.setTextSize(2, 10.0f);
        r30.setIncludeFontPadding(false);
        TextViewCompat.setLineHeight(r30, ha0(14.0f));
        r28.addView(r30);
        LinearLayout.LayoutParams r31 = new LinearLayout.LayoutParams(-1, -2);
        r31.topMargin = X90(4);
        r25.addView(r28, r31);
        r13.addView(r25);
        View r32 = new View(requireContext());
        r32.setLayoutParams(new LinearLayout.LayoutParams(-1, X90(16)));
        r13.addView(r32);
        OTextView r33 = new OTextView(requireContext(), null, 0, 14);
        r33.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        W90(r33);
        r33.setPadding(X90(8), X90(8), X90(8), X90(8));
        this.q = r33;
        ja0();
        View r34 = this.q;
        if (r34 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("imageTitleText");
        r34 = null;
    L18:
        r13.addView(r34);
        Context r35 = requireContext();
        FrameLayout r36 = new FrameLayout(r35);
        r36.setBackground(ea0(ba0(), 16));
        r36.setClipChildren(false);
        r36.setClipToPadding(false);
        r36.setPadding(X90(12), X90(12), X90(12), X90(12));
        LinearLayout.LayoutParams r37 = new LinearLayout.LayoutParams(-1, -2);
        r37.topMargin = X90(8);
        r36.setLayoutParams(r37);
        RecyclerView r38 = new RecyclerView(r35);
        r38.setClipChildren(false);
        r38.setClipToPadding(false);
        r38.setOverScrollMode(2);
        r38.setLayoutManager(new LinearLayoutManager(r35, 0, false));
        this.r = r38;
        r36.addView(r38, new FrameLayout.LayoutParams(-1, X90(60)));
        r13.addView(r36);
        Context r40 = requireContext();
        LinearLayout r41 = new LinearLayout(r40);
        r41.setOrientation(0);
        r41.setGravity(16);
        r41.setVisibility(8);
        r41.setPadding(X90(8), 0, X90(8), 0);
        LinearLayout.LayoutParams r42 = new LinearLayout.LayoutParams(-1, -2);
        r42.topMargin = X90(16);
        r41.setLayoutParams(r42);
        OTextView r43 = new OTextView(r40, null, 0, 14);
        r43.setText(j0.d(2131902709));
        W90(r43);
        r41.addView(r43);
        r13.addView(r41);
        this.s = r41;
        Context r44 = requireContext();
        FrameLayout r45 = new FrameLayout(r44);
        r45.setBackground(ea0(ba0(), 20));
        r45.setPadding(X90(8), X90(8), X90(8), X90(8));
        r45.setVisibility(8);
        LinearLayout.LayoutParams r46 = new LinearLayout.LayoutParams(-1, -2);
        r46.topMargin = X90(8);
        r45.setLayoutParams(r46);
        ?? r47 = new NestedScrollEditText(r44, null, 6, 0);
        r47.setBackground(null);
        r47.setGravity(8388627);
        r47.setOverScrollMode(2);
        r47.setPadding(0, 0, 0, 0);
        r47.setMinHeight(X90(40));
        r47.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(300)});
        r47.setSingleLine(true);
        r47.setMaxLines(1);
        r47.setHorizontallyScrolling(true);
        r47.setTextColor(ca0());
        r47.setHintTextColor(da0());
        r47.setHint(j0.d(2131902712));
        r47.setTextSize(2, 16.0f);
        r47.setIncludeFontPadding(true);
        TextViewCompat.setLineHeight(r47, ha0(22.0f));
        this.u = r47;
        r45.addView(r47, new FrameLayout.LayoutParams(-1, X90(40)));
        r13.addView(r45);
        this.t = r45;
        OTextView r48 = new OTextView(requireContext(), null, 0, 14);
        r48.setText(j0.d(2131902710));
        r48.setTextColor(aa0());
        r48.setTextSize(2, 12.0f);
        r48.setIncludeFontPadding(false);
        TextViewCompat.setLineHeight(r48, ha0(16.0f));
        r48.setVisibility(8);
        LinearLayout.LayoutParams r50 = new LinearLayout.LayoutParams(-2, -2);
        r50.setMarginStart(X90(8));
        r50.topMargin = X90(8);
        r48.setLayoutParams(r50);
        r13.addView(r48);
        this.v = r48;
        View r51 = new View(r5);
        r51.setVisibility(8);
        r51.setBackgroundColor(Z90());
        r51.setLayoutParams(new LinearLayout.LayoutParams(-1, X90(500)));
        r13.addView(r51);
        this.w = r51;
        this.m = r13;
        NestedScrollView r52 = this.l;
        if (r52 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("scrollView");
        r52 = null;
    L21:
        LinearLayout r53 = this.m;
        if (r53 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("scrollContainer");
        r53 = null;
    L24:
        r52.addView(r53, new ViewGroup.LayoutParams(-1, -2));
        View r54 = this.l;
        if (r54 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("scrollView");
        r54 = null;
    L27:
        r11.addView(r54, new FrameLayout.LayoutParams(-1, -1));
        Context r55 = requireContext();
        LinearLayout r56 = new LinearLayout(r55);
        r56.setOrientation(1);
        r56.setPadding(X90(24), X90(16), X90(24), X90(34));
        r56.setBackground(new ColorDrawable(Z90()));
        OButton r57 = new OButton(r55, null, 0, 28);
        r57.setText(j0.d(2131902725));
        r57.setGravity(17);
        r57.setMinHeight(X90(48));
        r57.setMinimumHeight(X90(48));
        r57.setAllCaps(false);
        r57.setIncludeFontPadding(false);
        r57.setTextColor(v19.c.a(2130972312, requireContext(), 2131103298));
        r57.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r57, ha0(22.0f));
        r57.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
        r57.setBackground(ea0(v19.c.a(2130972124, requireContext(), 2131103204), 24));
        this.x = r57;
        r56.addView(r57, new LinearLayout.LayoutParams(-1, X90(48)));
        r11.addView(r56, new FrameLayout.LayoutParams(-1, -2, 80));
        return com.larus.dora.obric.utils.c.c(r1, r2, r11, Z90(), null);
    L14:
        r14 = null;
        goto L15
    L8:
        r10 = null;
        goto L9
    }
}
