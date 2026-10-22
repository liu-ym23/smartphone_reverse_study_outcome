package com.larus.dora.impl.onboarding.othersmart.streamlined;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.dora.impl.databinding.LarusDoraHSimplifiedWakeupBinding;
import com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment;
import com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel;
import com.larus.dora.impl.settings.SimplifiedTopic;
import com.larus.dora.impl.view.DoraSimplifiedGradientTextView;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u0000 \u0097\u00012\u00020\u0001:\b\u0094\u0001\u0095\u0001\u0096\u0001\u0097\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00100\u001a\u00020.H\u0002J\b\u00101\u001a\u00020.H\u0002J\b\u00102\u001a\u00020.H\u0002J\b\u00103\u001a\u00020.H\u0002J\b\u00104\u001a\u00020.H\u0002J\u0018\u00105\u001a\u00020.2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000207H\u0002J\u0010\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020\u001aH\u0002J\u0018\u0010;\u001a\u00020.2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u000207H\u0002J\u0010\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020\u001aH\u0002J\b\u0010A\u001a\u00020.H\u0002J\n\u0010B\u001a\u0004\u0018\u00010\u0013H\u0002J\n\u0010C\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010D\u001a\u0004\u0018\u00010\u00132\u0006\u0010E\u001a\u00020\u0016H\u0002J\u0012\u0010F\u001a\u0004\u0018\u00010\u00132\u0006\u0010G\u001a\u00020\u0016H\u0002J\b\u0010H\u001a\u00020.H\u0002J\u001c\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0012\u0010K\u001a\u0002072\b\u0010L\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010M\u001a\u0002072\u0006\u00108\u001a\u000207H\u0002J\u0010\u0010N\u001a\u00020.2\u0006\u0010O\u001a\u000207H\u0002J\u0018\u0010P\u001a\u00020.2\u0006\u0010Q\u001a\u0002072\u0006\u0010R\u001a\u000207H\u0002J8\u0010S\u001a\u00020.2\u0006\u0010Q\u001a\u0002072\u0006\u0010R\u001a\u0002072\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020U2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZH\u0002J\b\u0010[\u001a\u00020.H\u0002J\b\u0010\\\u001a\u00020.H\u0002J\u0010\u0010]\u001a\u00020.2\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010`\u001a\u00020.2\u0006\u0010^\u001a\u00020_H\u0002J\u0012\u0010a\u001a\u0004\u0018\u00010b2\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010c\u001a\u00020.2\u0006\u0010d\u001a\u00020\u0016H\u0002J\u0010\u0010e\u001a\u00020.2\u0006\u0010d\u001a\u00020\u0016H\u0002J\u0012\u0010f\u001a\u0004\u0018\u00010b2\u0006\u0010^\u001a\u00020_H\u0002J\u0018\u0010g\u001a\u00020.2\u0006\u0010d\u001a\u00020\u00162\u0006\u0010h\u001a\u00020\u001aH\u0002J\b\u0010i\u001a\u00020\u0016H\u0002J\u0010\u0010j\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\u0016H\u0002J\u0010\u0010k\u001a\u00020U2\u0006\u0010l\u001a\u00020&H\u0002J\u001a\u0010m\u001a\u0004\u0018\u00010X2\u0006\u0010Q\u001a\u0002072\u0006\u0010R\u001a\u000207H\u0002J\u0018\u0010n\u001a\u00020.2\u0006\u0010o\u001a\u00020\u00162\u0006\u0010p\u001a\u00020\u0016H\u0002J \u0010q\u001a\u00020.2\u0006\u0010T\u001a\u00020U2\u0006\u0010o\u001a\u00020\u00162\u0006\u0010p\u001a\u00020\u0016H\u0002J\u0018\u0010r\u001a\u00020.2\u0006\u0010s\u001a\u00020U2\u0006\u0010t\u001a\u00020UH\u0002J \u0010u\u001a\u00020.2\u0006\u0010T\u001a\u00020U2\u0006\u0010s\u001a\u00020U2\u0006\u0010t\u001a\u00020UH\u0002J0\u0010v\u001a\u00020\u00162\u0006\u0010w\u001a\u00020&2\u0006\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020&2\u0006\u0010)\u001a\u00020&2\u0006\u0010{\u001a\u00020\u0016H\u0002J(\u0010|\u001a\u00020U2\u0006\u0010)\u001a\u00020&2\u0006\u0010w\u001a\u00020&2\u0006\u0010}\u001a\u00020\u00162\u0006\u0010z\u001a\u00020&H\u0002J\b\u0010~\u001a\u00020.H\u0002J\b\u0010\u007f\u001a\u00020.H\u0002J!\u0010\u0080\u0001\u001a\u00020\u00162\u0006\u0010)\u001a\u00020&2\u0006\u0010w\u001a\u00020&2\u0006\u0010z\u001a\u00020&H\u0002J\u0012\u0010\u0081\u0001\u001a\u00020.2\u0007\u0010\u0082\u0001\u001a\u00020\u0016H\u0002J\u0012\u0010\u0083\u0001\u001a\u00020.2\u0007\u0010\u0084\u0001\u001a\u00020\u0016H\u0002J\t\u0010\u0085\u0001\u001a\u00020.H\u0002J#\u0010\u0086\u0001\u001a\u00020.2\u0007\u0010\u0087\u0001\u001a\u00020\u00162\u0007\u0010\u0088\u0001\u001a\u00020\u00162\u0006\u0010T\u001a\u00020UH\u0002J\u001a\u0010\u0089\u0001\u001a\u00020\u00162\u0006\u0010/\u001a\u00020y2\u0007\u0010\u0082\u0001\u001a\u00020\u0016H\u0002J\u001a\u0010\u008a\u0001\u001a\u00020\u00162\u0006\u0010/\u001a\u00020y2\u0007\u0010\u0082\u0001\u001a\u00020\u0016H\u0002J\u0012\u0010\u008b\u0001\u001a\u00020.2\u0007\u0010\u008c\u0001\u001a\u00020\u001aH\u0002J\t\u0010\u008d\u0001\u001a\u00020.H\u0002J\t\u0010\u008e\u0001\u001a\u00020.H\u0016J\t\u0010\u008f\u0001\u001a\u00020.H\u0016J\t\u0010\u0090\u0001\u001a\u00020.H\u0016J\t\u0010\u0091\u0001\u001a\u00020.H\u0016J\t\u0010\u0092\u0001\u001a\u000207H\u0016J\t\u0010\u0093\u0001\u001a\u000207H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0098\u0001"}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedWakeupFragment;", "Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingBaseFragment;", "<init>", "()V", "simplifiedModel", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedOnboardingViewModel;", "getSimplifiedModel", "()Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedOnboardingViewModel;", "simplifiedModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedWakeupAdapter;", "_binding", "Lcom/larus/dora/impl/databinding/LarusDoraHSimplifiedWakeupBinding;", "binding", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusDoraHSimplifiedWakeupBinding;", "sourceTopics", "", "Lcom/larus/dora/impl/settings/SimplifiedTopic;", "stableTopics", "currentSelectedIndex", "", "currentSelectedAdapterPosition", "currentAnchorAdapterPosition", "isAnimatingSelection", "", "isUserDraggingList", "isProgrammaticSnap", "pendingManualSelectedAdapterPosition", "Ljava/lang/Integer;", "listAnimator", "Landroid/animation/ValueAnimator;", "capsuleWidthAnimator", "arrowTranslationAnimator", "hasConsumedInitialConnectedState", "keepVoiceCallbackOnNextPause", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupTopContainer", "setupRecyclerView", "setupRecyclerViewScrollListener", "setupObservers", "setupListeners", "reportWakeupTopicClick", "actionType", "", "topicKey", "navigateToInterruptPage", "useSharedElement", "addInterruptFragmentOverlay", "fragment", "Landroidx/fragment/app/Fragment;", "fragmentTag", "renderTopics", "resetAnimatedState", "advanceSelection", "getCurrentTopic", "getNextTopic", "getTopicAtOffset", "offset", "getTopicAtAdapterPosition", "position", "ensureStableTopicWindow", "buildStableTopicWindow", "topics", "getTopicText", "topic", "getTopicTextByKey", "resetSelectedSuffixText", "topicText", "startTopicTransitionAnimation", "currentText", "nextText", "renderTopicTransitionProgress", "progress", "", "listShift", "metrics", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedWakeupFragment$TopicTransitionMetrics;", "direction", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedWakeupFragment$ScrollDirection;", "finishTopicTransition", "onManualScrollStart", "onManualScrollIdle", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "syncCapsuleWithManualScroll", "buildDraggingVisualScrollState", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedWakeupFragment$ManualScrollState;", "finishManualScroll", "selectedAdapterPosition", "commitManualSelection", "buildManualScrollState", "finishSelectionAtAdapterPosition", "resetRecyclerPosition", "resolveRecyclerAnchorOffset", "resolveTopicIndexForAdapterPosition", "calculateListShift", "firstItemView", "buildTransitionMetrics", "startSelectedContainerWidthAnimation", "startWidth", "endWidth", "updateSelectedContainerForProgress", "startArrowTranslationAnimation", "startArrowLeft", "endArrowLeft", "updateArrowForProgress", "calculateSelectedContainerTargetWidth", "prefixTextView", "suffixTextView", "Landroid/widget/TextView;", "arrowView", "suffixMaxWidth", "calculateArrowLeft", "suffixWidth", "updateSelectedContainerWidth", "updateSelectedSuffixTextMaxWidth", "resolveSelectedSuffixMaxWidth", "applySelectedSuffixTextMaxWidth", "maxWidth", "updateSelectedSuffixContainerFixedHeight", "targetHeight", "restoreSelectedSuffixContainerWrapContentHeight", "updateSelectedSuffixContainerAnimatedHeight", "startHeight", "endHeight", "measureTextViewWidthWithinMaxWidth", "measureTextViewHeightWithinMaxWidth", "cancelAllAnimators", "resetVisualState", "resetClickDebounceState", "onDestroyView", "onSkipButtonClicked", "onResume", "onPause", "getCurrentPageName", "getCurrentCardName", "ManualScrollState", "ScrollDirection", "TopicTransitionMetrics", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraHStreamlinedWakeupFragment extends DoraExternalOnboardingBaseFragment {
    public static final /* synthetic */ int F = 0;
    public ValueAnimator A;
    public ValueAnimator B;
    public ValueAnimator C;
    public boolean D;
    public boolean E;
    public final Lazy o;
    public final DoraHStreamlinedWakeupAdapter p;
    public LarusDoraHSimplifiedWakeupBinding q;
    public List<SimplifiedTopic> r;
    public List<SimplifiedTopic> s;
    public int t;
    public int u;
    public int v;
    public boolean w;
    public boolean x;
    public boolean y;
    public Integer z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedWakeupFragment$ScrollDirection;", "", "<init>", "(Ljava/lang/String;I)V", "FORWARD", "BACKWARD", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ScrollDirection extends Enum<ScrollDirection> {
        public static final ScrollDirection BACKWARD = null;
        public static final ScrollDirection FORWARD = null;
        public static final /* synthetic */ ScrollDirection[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ScrollDirection> getEntries() {
            return b;
        }

        static {
            ScrollDirection r0 = new ScrollDirection("FORWARD", 0);
            FORWARD = r0;
            ScrollDirection r1 = new ScrollDirection("BACKWARD", 1);
            BACKWARD = r1;
            ScrollDirection[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static ScrollDirection[] values() {
            return (ScrollDirection[]) a.clone();
        }

        public static ScrollDirection valueOf(String r1) {
            return (ScrollDirection) r27.a.a(ScrollDirection.class, r1);
        }

        public ScrollDirection(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final int b;
        public final float c;
        public final float d;
        public final int e;
        public final int f;
        public final ScrollDirection g;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Float.compare(this.c, r6.c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.d, r6.d) == 0) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            return (((((((((((this.a * 31) + this.b) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + this.e) * 31) + this.f) * 31) + this.g.hashCode();
        }

        public final String toString() {
            return "ManualScrollState(firstVisiblePosition=" + this.a + ", firstViewTop=" + this.b + ", listShift=" + this.c + ", progress=" + this.d + ", fromSelectedAdapterPosition=" + this.e + ", toSelectedAdapterPosition=" + this.f + ", direction=" + this.g + ')';
        }

        public b(int r2, int r3, float r4, float r5, int r6, int r7, ScrollDirection r8) {
            Intrinsics.checkNotNullParameter(r8, "direction");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    public static final class c {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final float e;
        public final float f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Float.compare(this.e, r6.e) == 0) goto L24;
            return false;
        L24:
            if (Float.compare(this.f, r6.f) == 0) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return (((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.f);
        }

        public final String toString() {
            return "TopicTransitionMetrics(currentTextHeight=" + this.a + ", nextTextHeight=" + this.b + ", startWidth=" + this.c + ", endWidth=" + this.d + ", startArrowLeft=" + this.e + ", endArrowLeft=" + this.f + ')';
        }

        public c(int r1, int r2, int r3, int r4, float r5, float r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ScrollDirection.values().length];
            r0[ScrollDirection.FORWARD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ScrollDirection.BACKWARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final String V90() {
        return "new_voice_wakeup_card";
    }

    public final String k() {
        return "dora_h_streamlined_wakeup";
    }

    public final void onDestroyView() {
        ka0(false);
        this.D = false;
        super.onDestroyView();
        this.q = null;
    }

    public final DoraHStreamlinedOnboardingViewModel ma0() {
        return (DoraHStreamlinedOnboardingViewModel) this.o.getValue();
    }

    public final void sa0() {
        LarusDoraHSimplifiedWakeupBinding r0 = this.q;
        if (r0 != null) goto L5;
        return;
    L5:
        int r2 = 0;
        if (this.r.isEmpty() == false) goto L10;
        this.s = CollectionsKt.emptyList();
        this.u = 0;
        this.v = 0;
        AppCompatTextView r1 = r0.h;
        int r3 = com.larus.utils.j0.a;
        r1.setText(com.larus.utils.j0.d(2131903800));
        r0.j.setText("");
        r0.k.setVisibility(4);
        this.p.y2(CollectionsKt.emptyList());
        return;
    L10:
        if ((!this.s.isEmpty()) == true) goto L28;
        List<SimplifiedTopic> r4 = this.r;
        if (r4.isEmpty() == false) goto L15;
        List<SimplifiedTopic> r5 = CollectionsKt.emptyList();
    L19:
        this.s = r5;
        if (this.r.isEmpty() == true) goto L23;
        r2 = this.t + (this.r.size() * 20);
    L23:
        this.u = r2;
        if (this.r.size() <= 1) goto L26;
        int r6 = this.u + 1;
    L27:
        this.v = r6;
        goto L28
    L26:
        r6 = this.u;
        goto L27
    L15:
        List r7 = CollectionsKt.createListBuilder(r4.size() * 40);
        int r8 = 0;
    L16:
        if (r8 >= 40) goto L18;
        r7.addAll(r4);
        r8 = r8 + 1;
        goto L16
    L18:
        r5 = CollectionsKt.build(r7);
    L28:
        SimplifiedTopic r9 = na0(this.u);
        if (r9 != null) goto L31;
        return;
    L31:
        AppCompatTextView r10 = r0.h;
        int r11 = com.larus.utils.j0.a;
        r10.setText(com.larus.utils.j0.d(2131903800));
        this.p.y2(this.s);
        r0.e.setTranslationY(0.0f);
        if (this.x == false) goto L34;
    L41:
        ta0(oa0(r9));
        return;
    L34:
        if (this.y == true) goto L41;
        LinearLayoutManager r12 = r0.e.getLayoutManager();
        if ((r12 instanceof LinearLayoutManager) == false) goto L38;
        LinearLayoutManager r13 = r12;
    L39:
        if (r13 == null) goto L41;
        r13.scrollToPositionWithOffset(this.v, -c7.b(12));
        goto L41
    L38:
        r13 = null;
        goto L39
    }

    public DoraHStreamlinedWakeupFragment() {
        this.o = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraHStreamlinedOnboardingViewModel.class), new DoraHStreamlinedWakeupFragment$special$$inlined$activityViewModels$default$1(this), new DoraHStreamlinedWakeupFragment$special$$inlined$activityViewModels$default$2(this));
        this.p = new DoraHStreamlinedWakeupAdapter();
        this.r = CollectionsKt.emptyList();
        this.s = CollectionsKt.emptyList();
    }

    @Override // com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void aa0() {
        ma0().skipToInterrupt(false);
    }

    public final void onPause() {
        super.onPause();
        if (this.E == false) goto L5;
        this.E = false;
    L6:
        ma0().stopTicker();
        this.x = false;
        this.y = false;
        this.z = null;
        ka0(false);
        return;
    L5:
        ma0().unregisterVoiceCallback();
        goto L6
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void onResume() {
        super.onResume();
        sa0();
        LarusDoraHSimplifiedWakeupBinding r0 = this.q;
        if (r0 == null) goto L7;
        LinearLayout r1 = r0.g;
        if (r1 == null) goto L7;
        r1.setTag(123400002, 0L);
    L7:
        TextView r2 = this.h;
        if (r2 == null) goto L10;
        r2.setTag(123400002, 0L);
    L10:
        ma0().registerVoiceCallback();
        ma0().startTicker();
    }

    public static float ia0(View r3) {
        RecyclerView.LayoutParams r0 = r3.getLayoutParams();
        if ((r0 instanceof RecyclerView.LayoutParams) == false) goto L5;
        RecyclerView.LayoutParams r1 = r0;
    L6:
        int r2 = 0;
        if (r1 == null) goto L9;
        int r4 = ((ViewGroup.MarginLayoutParams) r1).topMargin;
    L10:
        if (r1 == null) goto L13;
        r2 = ((ViewGroup.MarginLayoutParams) r1).bottomMargin;
    L13:
        return (r3.getHeight() + r4) + r2;
    L9:
        r4 = 0;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public static String oa0(SimplifiedTopic r1) {
        int r0 = com.larus.utils.j0.a;
        if (r1 == null) goto L6;
        String r2 = r1.getTitleKey();
        if (r2 == null) goto L6;
    L8:
        return com.larus.utils.j0.e(r2);
    L6:
        r2 = "";
        goto L8
    }

    public final b fa0(RecyclerView r12) {
        boolean r2 = true;
        if (this.s.size() > 1) goto L5;
        return null;
    L5:
        LinearLayoutManager r0 = r12.getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == false) goto L8;
        LinearLayoutManager r1 = r0;
    L9:
        if (r1 != null) goto L11;
        return null;
    L11:
        int r4 = r1.findFirstVisibleItemPosition();
        if (r4 != (-1)) goto L14;
        return null;
    L14:
        View r3 = r1.findViewByPosition(r4);
        if (r3 != null) goto L17;
        return null;
    L17:
        float r6 = ia0(r3);
        if (r6 > 0.0f) goto L20;
        return null;
    L20:
        float r13 = r12.getPaddingTop();
        if (r4 < this.v) goto L25;
        r2 = false;
    L25:
        if (r2 == false) goto L27;
        float r14 = RangesKt.coerceIn(((r3.getTop() - r13) / r6) + 1.0f, 0.0f, 1.0f);
    L28:
        float r7 = r14;
        if (r2 == false) goto L31;
        int r8 = r4;
    L32:
        if (r2 == false) goto L34;
        int r15 = r8 - 1;
    L35:
        int r9 = r15;
        int r5 = r3.getTop();
        if (r2 == false) goto L38;
        ScrollDirection r10 = ScrollDirection.BACKWARD;
    L40:
        return new b(r4, r5, r6, r7, r8, r9, r10);
    L38:
        r10 = ScrollDirection.FORWARD;
        goto L40
    L34:
        r15 = r8 + 1;
        goto L35
    L31:
        r8 = r4 - 1;
        goto L32
    L27:
        r14 = RangesKt.coerceIn((r13 - r3.getTop()) / r6, 0.0f, 1.0f);
        goto L28
    L8:
        r1 = null;
        goto L9
    }

    public final void ka0(boolean r3) {
        ValueAnimator r0 = this.A;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.A = null;
        ValueAnimator r1 = this.B;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.B = null;
        ValueAnimator r2 = this.C;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        this.C = null;
        this.w = false;
        LarusDoraHSimplifiedWakeupBinding r4 = this.q;
        if (r4 == null) goto L16;
        RecyclerView r5 = r4.e;
        if (r5 == null) goto L16;
        r5.setTranslationY(0.0f);
    L16:
        if (r3 == false) goto L21;
        SimplifiedTopic r6 = na0(this.u);
        if (r6 == null) goto L22;
        ta0(oa0(r6));
        return;
    L22:
        return;
    }

    public final SimplifiedTopic na0(int r2) {
        return (SimplifiedTopic) CollectionsKt.getOrNull(this.s, r2);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.widget.TextView, com.larus.dora.impl.view.DoraTextView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void ta0(String r6) {
        LarusDoraHSimplifiedWakeupBinding r0 = this.q;
        if (r0 != null) goto L5;
        return;
    L5:
        ?? r1 = r0.j;
        AppCompatTextView r2 = r0.k;
        ImageView r3 = r0.f;
        r1.setText(r6);
        r1.setTranslationY(0.0f);
        r1.setAlpha(1.0f);
        r2.setText("");
        r2.setTranslationY(0.0f);
        r2.setAlpha(0.0f);
        r2.setVisibility(4);
        ValueAnimator r4 = this.C;
        if (r4 == null) goto L8;
        r4.cancel();
    L8:
        r3.setTranslationX(0.0f);
        int r7 = ua0(r0.g, r0.h, r3);
        if (r7 <= 0) goto L21;
        LarusDoraHSimplifiedWakeupBinding r5 = this.q;
        if (r5 == null) goto L16;
        AppCompatTextView r8 = r5.j;
        if (r8 == null) goto L16;
        r8.setMaxWidth(r7);
    L16:
        LarusDoraHSimplifiedWakeupBinding r9 = this.q;
        if (r9 == null) goto L21;
        AppCompatTextView r10 = r9.k;
        if (r10 == null) goto L21;
        r10.setMaxWidth(r7);
    L21:
        int r11 = Math.max(pa0(r1, r7), r0.i.getMinimumHeight());
        LarusDoraHSimplifiedWakeupBinding r12 = this.q;
        if (r12 == null) goto L27;
        FrameLayout r13 = r12.i;
        if (r13 == null) goto L27;
        int r14 = Math.max(r11, r13.getMinimumHeight());
        ViewGroup.LayoutParams r15 = r13.getLayoutParams();
        r15.height = r14;
        r13.setLayoutParams(r15);
    L27:
        LarusDoraHSimplifiedWakeupBinding r16 = this.q;
        if (r16 == null) goto L34;
        LinearLayout r17 = r16.g;
        if (r17 == null) goto L35;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        r18.width = -2;
        r17.setLayoutParams(r18);
        return;
    L35:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int pa0(DoraTextView r2, int r3) {
        if (r3 <= 0) goto L5;
        int r4 = View.MeasureSpec.makeMeasureSpec(r3, Integer.MIN_VALUE);
    L6:
        r2.measure(r4, View.MeasureSpec.makeMeasureSpec(0, 0));
        return r2.getMeasuredHeight();
    L5:
        r4 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int qa0(DoraTextView r2, int r3) {
        if (r3 <= 0) goto L5;
        int r4 = View.MeasureSpec.makeMeasureSpec(r3, Integer.MIN_VALUE);
    L6:
        r2.measure(r4, View.MeasureSpec.makeMeasureSpec(0, 0));
        return r2.getMeasuredWidth();
    L5:
        r4 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L6
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [android.widget.TextView, com.larus.dora.impl.view.DoraTextView] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.widget.TextView, com.larus.dora.impl.view.DoraTextView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final c ga0(String r18, String r110) {
        LarusDoraHSimplifiedWakeupBinding r1 = this.q;
        if (r1 != null) goto L6;
        return null;
    L6:
        LinearLayout r2 = r1.g;
        DoraSimplifiedGradientTextView r3 = r1.h;
        ?? r4 = r1.j;
        ?? r5 = r1.k;
        ImageView r6 = r1.f;
        int r7 = ua0(r2, r3, r6);
        if (r7 <= 0) goto L19;
        LarusDoraHSimplifiedWakeupBinding r8 = this.q;
        if (r8 == null) goto L14;
        AppCompatTextView r9 = r8.j;
        if (r9 == null) goto L14;
        r9.setMaxWidth(r7);
    L14:
        LarusDoraHSimplifiedWakeupBinding r10 = this.q;
        if (r10 == null) goto L19;
        AppCompatTextView r11 = r10.k;
        if (r11 == null) goto L19;
        r11.setMaxWidth(r7);
    L19:
        r4.setText(r18);
        r5.setText(r110);
        int r12 = Math.max(pa0(r4, r7), r1.i.getMinimumHeight());
        int r13 = Math.max(pa0(r5, r7), r1.i.getMinimumHeight());
        int r14 = qa0(r4, r7);
        int r15 = qa0(r5, r7);
        int r16 = ja0(r3, r4, r6, r2, r7);
        int r17 = ja0(r3, r5, r6, r2, r7);
        float r111 = ha0(r2, r3, r14, r6);
        float r112 = ha0(r2, r3, r15, r6);
        LarusDoraHSimplifiedWakeupBinding r20 = this.q;
        if (r20 == null) goto L26;
        FrameLayout r21 = r20.i;
        if (r21 == null) goto L26;
        int r22 = Math.max(r12, r21.getMinimumHeight());
        ViewGroup.LayoutParams r23 = r21.getLayoutParams();
        r23.height = r22;
        r21.setLayoutParams(r23);
    L26:
        return new c(r12, r13, r16, r17, r111, r112);
    }

    public final void la0(int r6, boolean r7) {
        LarusDoraHSimplifiedWakeupBinding r0 = this.q;
        if (r0 != null) goto L5;
        return;
    L5:
        int r2 = 0;
        int r8 = RangesKt.coerceIn(r6, 0, CollectionsKt.getLastIndex(this.s));
        this.u = r8;
        if (this.r.isEmpty() == true) goto L9;
        int r1 = this.r.size();
        int r3 = r8 % r1;
        r2 = r3 + (r1 & (((r3 ^ r1) & ((-r3) | r3)) >> 31));
    L9:
        this.t = r2;
        if (this.r.size() <= 1) goto L12;
        int r4 = RangesKt.coerceAtMost(r8 + 1, CollectionsKt.getLastIndex(this.s));
    L13:
        this.v = r4;
        r0.e.setTranslationY(0.0f);
        if (r7 == false) goto L21;
        this.p.y2(this.s);
        LinearLayoutManager r9 = r0.e.getLayoutManager();
        if ((r9 instanceof LinearLayoutManager) == false) goto L18;
        LinearLayoutManager r10 = r9;
    L19:
        if (r10 == null) goto L21;
        r10.scrollToPositionWithOffset(this.v, -c7.b(12));
        goto L21
    L18:
        r10 = null;
    L21:
        ta0(oa0(na0(r8)));
        return;
    L12:
        r4 = r8;
        goto L13
    }

    @Override // com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void onViewCreated(View r22, Bundle r23) {
        Intrinsics.checkNotNullParameter(r22, "view");
        super.onViewCreated(r22, r23);
        LarusDoraHSimplifiedWakeupBinding r1 = this.q;
        if (r1 == null) goto L7;
        LinearLayout r2 = r1.g;
        if (r2 == null) goto L7;
        ViewCompat.setTransitionName(r2, "dora_h_simplified_interrupt_card");
    L7:
        LarusDoraHSimplifiedWakeupBinding r3 = this.q;
        if (r3 == null) goto L12;
        RecyclerView r4 = r3.e;
        if (r4 == null) goto L12;
        r4.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
    L12:
        LarusDoraHSimplifiedWakeupBinding r5 = this.q;
        if (r5 == null) goto L17;
        RecyclerView r6 = r5.e;
        if (r6 == null) goto L17;
        r6.setAdapter(this.p);
    L17:
        LarusDoraHSimplifiedWakeupBinding r7 = this.q;
        if (r7 == null) goto L22;
        RecyclerView r8 = r7.e;
        if (r8 == null) goto L22;
        r8.setItemAnimator(null);
    L22:
        LarusDoraHSimplifiedWakeupBinding r9 = this.q;
        if (r9 == null) goto L27;
        RecyclerView r10 = r9.e;
        if (r10 == null) goto L27;
        r10.addOnScrollListener(new DoraHStreamlinedWakeupFragment$setupRecyclerViewScrollListener$1(this));
    L27:
        Lifecycle.State r11 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraHStreamlinedWakeupFragment$setupObservers$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r11, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraHStreamlinedWakeupFragment$setupObservers$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r11, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraHStreamlinedWakeupFragment$setupObservers$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r11, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraHStreamlinedWakeupFragment$setupObservers$$inlined$launchAndRepeatWithViewLifecycle$default$4(this, r11, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraHStreamlinedWakeupFragment$setupObservers$$inlined$launchAndRepeatWithViewLifecycle$default$5(this, r11, null, this), 3, null);
        LarusDoraHSimplifiedWakeupBinding r12 = this.q;
        if (r12 == null) goto L32;
        LinearLayout r13 = r12.g;
        if (r13 == null) goto L32;
        e1.d(r13, new a0(this));
    L32:
        TextView r14 = this.h;
        if (r14 == null) goto L35;
        e1.x(r14);
        int r15 = com.larus.utils.j0.a;
        r14.setText(com.larus.utils.j0.d(2131902338));
        e1.d(r14, new b0(this));
    L35:
        ma0().fetchAvatarUrl();
        DoraExternalOnboardingViewModel.enterOnboardingMode$default(ca0(), false, 1, null);
        DoraExternalOnboardingViewModel.enterVoiceOnlyMode$default(ca0(), false, 1, null);
        ma0().stopTTS("InitWakeFragment");
        DoraHStreamlinedOnboardingViewModel r16 = ma0();
        int r17 = com.larus.utils.j0.a;
        r16.playTTS(com.larus.utils.j0.d(2131903798));
    }

    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r110) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        ConstraintLayout r0 = r17.inflate(2131562208, r18, false);
        int r1 = 2131369852;
        CircleSimpleDraweeView r5 = (CircleSimpleDraweeView) ViewBindings.findChildViewById(r0, 2131369852);
        if (r5 == null) goto L41;
        ConstraintLayout r2 = r0;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131369926);
        if (r6 == null) goto L38;
        View r7 = ViewBindings.findChildViewById(r0, 2131369927);
        if (r7 == null) goto L37;
        RecyclerView r8 = ViewBindings.findChildViewById(r0, 2131369928);
        if (r8 == null) goto L36;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r0, 2131369932);
        if (r9 == null) goto L35;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131369933);
        if (r10 == null) goto L34;
        DoraSimplifiedGradientTextView r11 = (DoraSimplifiedGradientTextView) ViewBindings.findChildViewById(r0, 2131369934);
        if (r11 == null) goto L33;
        FrameLayout r12 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131369935);
        if (r12 == null) goto L32;
        DoraTextView r13 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369936);
        if (r13 == null) goto L31;
        DoraTextView r14 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369937);
        if (r14 == null) goto L30;
        FrameLayout r15 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131369941);
        if (r15 != null) goto L25;
        r1 = 2131369941;
        goto L41
    L25:
        if (((DoraTextView) ViewBindings.findChildViewById(r0, 2131369947)) == null) goto L28;
        this.q = new LarusDoraHSimplifiedWakeupBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
        return r2;
    L28:
        r1 = 2131369947;
        goto L41
    L30:
        r1 = 2131369937;
        goto L41
    L31:
        r1 = 2131369936;
        goto L41
    L32:
        r1 = 2131369935;
        goto L41
    L33:
        r1 = 2131369934;
        goto L41
    L34:
        r1 = 2131369933;
        goto L41
    L35:
        r1 = 2131369932;
        goto L41
    L36:
        r1 = 2131369928;
        goto L41
    L37:
        r1 = 2131369927;
        goto L41
    L38:
        r1 = 2131369926;
    L41:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int ua0(View r8, DoraSimplifiedGradientTextView r9, View r10) {
        Object r0 = r8.getParent();
        ViewGroup.MarginLayoutParams r2 = null;
        if ((r0 instanceof View) == false) goto L5;
        View r1 = (View) r0;
    L7:
        if (r1 == null) goto L9;
        int r3 = r1.getWidth();
    L15:
        if (r3 > 0) goto L17;
        return 0;
    L17:
        ViewGroup.LayoutParams r4 = r8.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
    L21:
        Integer r6 = Integer.valueOf(r9.getMeasuredWidth());
        boolean r7 = true;
        if (r6.intValue() <= 0) goto L24;
        boolean r11 = true;
    L25:
        if (r11 == true) goto L28;
        r6 = null;
    L28:
        if (r6 == null) goto L30;
        int r12 = r6.intValue();
    L31:
        Integer r13 = Integer.valueOf(r10.getMeasuredWidth());
        if (r13.intValue() > 0) goto L35;
        r7 = false;
    L35:
        if (r7 == true) goto L38;
        r13 = null;
    L38:
        if (r13 == null) goto L40;
        int r14 = r13.intValue();
    L41:
        ViewGroup.LayoutParams r15 = r10.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L44;
        r2 = (ViewGroup.MarginLayoutParams) r15;
    L44:
        if (r2 == null) goto L46;
        int r16 = r2.getMarginStart();
    L47:
        if (r5 == null) goto L49;
        int r17 = r5.getMarginStart();
    L50:
        if (r5 == null) goto L52;
        int r18 = r5.getMarginEnd();
    L54:
        return RangesKt.coerceAtLeast(r3 - ((((((r17 + r18) + r8.getPaddingStart()) + r8.getPaddingEnd()) + r12) + r14) + r16), 0);
    L52:
        r18 = 0;
        goto L54
    L49:
        r17 = 0;
        goto L50
    L46:
        r16 = 0;
        goto L47
    L40:
        r14 = r10.getWidth();
        goto L41
    L30:
        r12 = r9.getWidth();
        goto L31
    L24:
        r11 = false;
        goto L25
    L20:
        r5 = null;
        goto L21
    L9:
        LarusDoraHSimplifiedWakeupBinding r20 = this.q;
        if (r20 == null) goto L14;
        ConstraintLayout r21 = r20.a;
        if (r21 == null) goto L14;
        r3 = r21.getWidth();
    L14:
        r3 = 0;
        goto L15
    L5:
        r1 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static float ha0(View r4, DoraSimplifiedGradientTextView r5, int r6, View r7) {
        Integer r0 = Integer.valueOf(r5.getMeasuredWidth());
        int r2 = 0;
        if (r0.intValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        ViewGroup.MarginLayoutParams r3 = null;
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L12;
        int r8 = r0.intValue();
    L13:
        ViewGroup.LayoutParams r9 = r7.getLayoutParams();
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        r3 = (ViewGroup.MarginLayoutParams) r9;
    L16:
        if (r3 == null) goto L19;
        r2 = r3.getMarginStart();
    L19:
        return ((r4.getPaddingStart() + r8) + r6) + r2;
    L12:
        r8 = r5.getWidth();
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int ja0(DoraSimplifiedGradientTextView r5, DoraTextView r6, View r7, View r8, int r9) {
        Integer r0 = Integer.valueOf(r5.getMeasuredWidth());
        boolean r2 = true;
        int r3 = 0;
        if (r0.intValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        ViewGroup.MarginLayoutParams r4 = null;
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L12;
        int r10 = r0.intValue();
    L13:
        int r11 = qa0(r6, r9);
        Integer r12 = Integer.valueOf(r7.getMeasuredWidth());
        if (r12.intValue() > 0) goto L17;
        r2 = false;
    L17:
        if (r2 == true) goto L20;
        r12 = null;
    L20:
        if (r12 == null) goto L22;
        int r13 = r12.intValue();
    L23:
        ViewGroup.LayoutParams r14 = r7.getLayoutParams();
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        r4 = (ViewGroup.MarginLayoutParams) r14;
    L26:
        if (r4 == null) goto L29;
        r3 = r4.getMarginStart();
    L29:
        return (((r10 + r11) + r13) + r3) + (r8.getPaddingStart() + r8.getPaddingEnd());
    L22:
        r13 = r7.getWidth();
        goto L23
    L12:
        r10 = r5.getWidth();
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void ra0(String r3, String r4, float r5, float r6, c r7, ScrollDirection r8) {
        LarusDoraHSimplifiedWakeupBinding r0 = this.q;
        if (r0 == null) goto L41;
        AppCompatTextView r1 = r0.j;
        if (r1 == null) goto L44;
        if (r0 == null) goto L42;
        AppCompatTextView r2 = r0.k;
        if (r2 == null) goto L45;
        r1.setText(r3);
        r2.setText(r4);
        r2.setVisibility(0);
        int r9 = d.a[r8.ordinal()];
        if (r9 != 1) goto L14;
        r1.setTranslationY((-r6) * r5);
        r2.setTranslationY(r6 * (1.0f - r5));
    L19:
        r1.setAlpha(1.0f - r5);
        r2.setAlpha(r5);
        int r10 = r7.a;
        int r11 = r7.b;
        LarusDoraHSimplifiedWakeupBinding r12 = this.q;
        if (r12 == null) goto L25;
        FrameLayout r13 = r12.i;
        if (r13 == null) goto L25;
        int r14 = (int) (r10 + ((r11 - r10) * r5));
        ViewGroup.LayoutParams r15 = r13.getLayoutParams();
        r15.height = RangesKt.coerceAtLeast(r14, r13.getMinimumHeight());
        r13.setLayoutParams(r15);
    L25:
        int r16 = r7.c;
        int r17 = r7.d;
        LarusDoraHSimplifiedWakeupBinding r18 = this.q;
        if (r18 == null) goto L34;
        LinearLayout r20 = r18.g;
        if (r20 == null) goto L34;
        if (r16 <= 0) goto L34;
        if (r17 <= 0) goto L34;
        int r21 = (int) (r16 + ((r17 - r16) * r5));
        ViewGroup.LayoutParams r22 = r20.getLayoutParams();
        r22.width = r21;
        r20.setLayoutParams(r22);
    L34:
        float r23 = r7.e;
        float r24 = r7.f;
        LarusDoraHSimplifiedWakeupBinding r25 = this.q;
        if (r25 == null) goto L43;
        ImageView r26 = r25.f;
        if (r26 == null) goto L46;
        r26.setTranslationX((r23 + ((r24 - r23) * r5)) - r26.getLeft());
        return;
    L46:
        return;
    L43:
        return;
    L14:
        if (r9 != 2) goto L17;
        r1.setTranslationY(r6 * r5);
        r2.setTranslationY((-r6) * (1.0f - r5));
        goto L19
    L17:
        throw new NoWhenBranchMatchedException();
    L45:
        return;
    L42:
        return;
    L44:
        return;
    }
}
