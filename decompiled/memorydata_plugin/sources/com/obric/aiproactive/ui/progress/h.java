package com.obric.aiproactive.ui.progress;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aiproactive.ui.widget.GradientTextView;
import com.obric.memorydata.plugin.R;
import com.obric.oui.lisitem.OListItemGeneral;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.progress.ODownloadProgressView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B9\u0012\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0019\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u0016J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u0016J\u0016\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\nJ\u0010\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005J\u0014\u0010 \u001a\u00020\u00062\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011J\u0014\u0010\"\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0011J\u0014\u0010#\u001a\u00020\u00062\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011J\u0018\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020)H\u0016J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0002H\u0016J\b\u0010.\u001a\u00020)H\u0016J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\tH\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/obric/aiproactive/ui/progress/AgentRunStepAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/aiproactive/ui/progress/AgentRunStepAdapter$StepHolder;", "onMobileItemClick", "Lkotlin/Function1;", "Lcom/obric/aiproactive/ui/progress/MobileUseRowBinding;", "", "onUserExpansionChanged", "Lkotlin/Function2;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "items", "", "Lcom/obric/aiproactive/ui/progress/AgentRunUiStep;", "recommendationMarkdown", "", "canonicalArtifacts", "", "Lcom/obric/aiproactive/api/AiProactiveArtifact;", "expandedStepIds", "", "awaitingRestoredStepSnapshot", "availableMobileBinding", "restoreExpandedStepIds", "stepIds", "setStepExpanded", "stepId", "expanded", "setAvailableMobileBinding", "binding", LocationMonitorConst.SUBMIT, "steps", "submitRecommendations", "submitCanonicalArtifacts", "artifacts", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "onViewRecycled", "getItemCount", "toggle", "StepHolder", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1<z, Unit> f6814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2<String, Boolean, Unit> f6815b;
    private final List<n> c;
    private List<String> d;
    private Map<String, com.obric.aiproactive.api.j> e;
    private Set<String> f;
    private boolean g;
    private z h;

    @Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 J2\u00020\u0001:\u0001JB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005Jt\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020#0\"2\b\u0010$\u001a\u0004\u0018\u00010%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00170'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170)J\u0006\u0010*\u001a\u00020\u0017J\u0018\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u0015H\u0002J\b\u00100\u001a\u00020\u0017H\u0002J\u0010\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u001bH\u0002J\b\u00103\u001a\u00020\u0017H\u0002J6\u00104\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00170'H\u0002J0\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u00020\u0015H\u0002J<\u0010<\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u0002082\u0006\u0010=\u001a\u00020%2\u0006\u00109\u001a\u00020\u001b2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00170'H\u0002J\b\u0010>\u001a\u00020\u0017H\u0002J\b\u0010?\u001a\u00020\u0017H\u0002J\u0010\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u001bH\u0002J\b\u0010B\u001a\u00020\u0017H\u0002J\f\u0010C\u001a\u00020\u0015*\u00020\u0015H\u0002J\u0010\u0010D\u001a\u00020\u00172\u0006\u0010E\u001a\u00020FH\u0002J\u001c\u0010G\u001a\u00020\u0017*\u00020\u00072\u0006\u0010H\u001a\u00020\u00152\u0006\u0010I\u001a\u00020\u0015H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/obric/aiproactive/ui/progress/AgentRunStepAdapter$StepHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "marker", "Landroid/widget/ImageView;", "progressMarker", "Lcom/obric/oui/progress/ODownloadProgressView;", "markerContainer", "connectorTop", "connectorBottom", "header", "Lcom/obric/oui/lisitem/OListItemGeneral;", "mobileChildContainer", "Landroid/widget/LinearLayout;", "headerRoot", "headerTextContainer", "artifactReferences", "defaultActivityChildTopMargin", "", "bind", "", "step", "Lcom/obric/aiproactive/ui/progress/AgentRunUiStep;", "isFirst", "", "isLast", "expanded", "recommendationMarkdown", "", "", "canonicalArtifacts", "", "Lcom/obric/aiproactive/api/AiProactiveArtifact;", "availableMobileBinding", "Lcom/obric/aiproactive/ui/progress/MobileUseRowBinding;", "onMobileItemClick", "Lkotlin/Function1;", "onToggle", "Lkotlin/Function0;", "recycle", "bindTitleChevron", "hasExpandableDetails", "titleChevron", "Landroid/graphics/drawable/Drawable;", "iconRes", "removeDefaultHeaderEndInsets", "alignActivitySecondaryListBelowTitle", "showing", "restoreActivitySecondaryListTopMargin", "bindActivityChildren", "bindActivityChildContent", "child", "item", "Lcom/obric/aiproactive/ui/progress/AgentRunActivityUiItem;", "navigationEnabled", "markerLabel", "markerColumnWidth", "bindActivityChildInteraction", "binding", "clearActivityChildren", "clearContainerInteractionVisuals", "spaceSecondaryTextBelowTitle", "showingSecondaryText", "alignMarkerToTitleRow", "dp", "bindStateMarker", "state", "Lcom/obric/aiproactive/ui/progress/AgentRunUiState;", "bindSolidStatusIcon", "drawableRes", "colorRes", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0315a f6816a = null;
        private final View A;
        private final LinearLayout B;
        private final int C;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ImageView f6817b;
        private final ODownloadProgressView t;
        private final View u;
        private final View v;
        private final View w;
        private final OListItemGeneral x;
        private final LinearLayout y;
        private final View z;

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.progress.h$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/ui/progress/AgentRunStepAdapter$StepHolder$Companion;", "", "<init>", "()V", "PENDING_MARKER_ALPHA", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0315a {
            private C0315a() {
            }

            public /* synthetic */ C0315a(DefaultConstructorMarker r1) {
                this();
            }
        }

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f6818a = null;

            static {
                int[] r0 = new int[AgentRunUiState.values().length];
                r0[AgentRunUiState.COMPLETED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r0[AgentRunUiState.RUNNING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r0[AgentRunUiState.PENDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r0[AgentRunUiState.CANCELLED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r0[AgentRunUiState.FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r0[AgentRunUiState.UNKNOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                f6818a = r0;
            }
        }

        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "core-ktx_release", "androidx/core/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class c implements View.OnLayoutChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f6819a;

            public c(a r1) {
                this.f6819a = r1;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                r1.removeOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(this, View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
                ViewParent r10 = a.a(this.f6819a).getParent();
                ViewGroup.MarginLayoutParams r11 = null;
                if (ZeusTransformUtils.instanceOf(r10, ViewGroup.class) == false) goto L5;
                ViewGroup r12 = (ViewGroup) ZeusTransformUtils.preCheckCast(r10, ViewGroup.class, "com.obric.memorydata.plugin");
            L6:
                if (r12 == null) goto L18;
                Rect r13 = new Rect();
                r1.getDrawingRect(r13);
                r12.offsetDescendantRectToMyCoords(r1, r13);
                int r14 = r13.bottom + ZeusTransformUtils.getResources(this.f6819a.c, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.ai_proactive_agent_secondary_list_parent_gap, "dimen", "ai_proactive_agent_secondary_list_parent_gap"));
                ViewGroup.LayoutParams r15 = a.a(this.f6819a).getLayoutParams();
                if (ZeusTransformUtils.instanceOf(r15, ViewGroup.MarginLayoutParams.class) == false) goto L11;
                r11 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r15, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
            L11:
                if (r11 == null) goto L19;
                int r16 = r14 - a.b(this.f6819a).getBottom();
                if (r11.topMargin == r16) goto L17;
                r11.topMargin = r16;
                a.a(this.f6819a).setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r11, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
                return;
            L17:
                return;
            L19:
                return;
            L18:
                return;
            L5:
                r12 = null;
                goto L6
            }
        }

        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "core-ktx_release", "androidx/core/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class d implements View.OnLayoutChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f6820a;

            public d(a r1) {
                this.f6820a = r1;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                r1.removeOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(this, View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
                View r10 = this.f6820a.c;
                ConstraintLayout.LayoutParams r11 = null;
                if (ZeusTransformUtils.instanceOf(r10, ViewGroup.class) == false) goto L5;
                ViewGroup r12 = (ViewGroup) ZeusTransformUtils.preCheckCast(r10, ViewGroup.class, "com.obric.memorydata.plugin");
            L6:
                if (r12 == null) goto L28;
                Rect r13 = new Rect();
                r1.getDrawingRect(r13);
                r12.offsetDescendantRectToMyCoords(r1, r13);
                Integer r14 = Integer.valueOf(a.c(this.f6820a).getHeight());
                if (((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L11;
                boolean r15 = true;
            L12:
                if (r15 == true) goto L15;
                r14 = null;
            L15:
                if (r14 == null) goto L17;
                int r16 = r14.intValue();
            L18:
                int r17 = RangesKt.coerceAtLeast(r13.centerY() - (r16 / 2), 0);
                ViewGroup.LayoutParams r18 = a.c(this.f6820a).getLayoutParams();
                if (ZeusTransformUtils.instanceOf(r18, ConstraintLayout.LayoutParams.class) == false) goto L21;
                r11 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r18, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
            L21:
                if (r11 != null) goto L24;
                return;
            L24:
                if (r11.topMargin == r17) goto L27;
                r11.topMargin = r17;
                a.c(this.f6820a).setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r11, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
                return;
            L27:
                return;
            L17:
                r16 = a.c(this.f6820a).getLayoutParams().height;
                goto L18
            L11:
                r15 = false;
                goto L12
            L28:
                return;
            L5:
                r12 = null;
                goto L6
            }
        }

        static {
            f6816a = new C0315a(null);
        }

        public a(View r8) {
            Intrinsics.checkNotNullParameter(r8, "view");
            super(r8);
            View r0 = r8.findViewById(ZeusTransformUtils.mapRes(R.id.iv_step_marker, OaidModel.KEY_ID, "iv_step_marker"));
            Intrinsics.checkNotNullExpressionValue(r0, "findViewById(...)");
            this.f6817b = (ImageView) ZeusTransformUtils.preCheckCast(r0, ImageView.class, "com.obric.memorydata.plugin");
            View r1 = r8.findViewById(ZeusTransformUtils.mapRes(R.id.progress_step_marker, OaidModel.KEY_ID, "progress_step_marker"));
            Intrinsics.checkNotNullExpressionValue(r1, "findViewById(...)");
            this.t = (ODownloadProgressView) ZeusTransformUtils.preCheckCast(r1, ODownloadProgressView.class, "com.obric.memorydata.plugin");
            View r2 = r8.findViewById(ZeusTransformUtils.mapRes(R.id.step_marker_container, OaidModel.KEY_ID, "step_marker_container"));
            Intrinsics.checkNotNullExpressionValue(r2, "findViewById(...)");
            this.u = r2;
            View r3 = r8.findViewById(ZeusTransformUtils.mapRes(R.id.step_connector_top, OaidModel.KEY_ID, "step_connector_top"));
            Intrinsics.checkNotNullExpressionValue(r3, "findViewById(...)");
            this.v = r3;
            View r4 = r8.findViewById(ZeusTransformUtils.mapRes(R.id.step_connector_bottom, OaidModel.KEY_ID, "step_connector_bottom"));
            Intrinsics.checkNotNullExpressionValue(r4, "findViewById(...)");
            this.w = r4;
            View r5 = r8.findViewById(ZeusTransformUtils.mapRes(R.id.step_header, OaidModel.KEY_ID, "step_header"));
            Intrinsics.checkNotNullExpressionValue(r5, "findViewById(...)");
            OListItemGeneral r6 = (OListItemGeneral) ZeusTransformUtils.preCheckCast(r5, OListItemGeneral.class, "com.obric.memorydata.plugin");
            this.x = r6;
            View r7 = r8.findViewById(ZeusTransformUtils.mapRes(R.id.mobile_child_container, OaidModel.KEY_ID, "mobile_child_container"));
            Intrinsics.checkNotNullExpressionValue(r7, "findViewById(...)");
            LinearLayout r9 = (LinearLayout) ZeusTransformUtils.preCheckCast(r7, LinearLayout.class, "com.obric.memorydata.plugin");
            this.y = r9;
            View r10 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.ll_root, OaidModel.KEY_ID, "ll_root"));
            Intrinsics.checkNotNullExpressionValue(r10, "findViewById(...)");
            this.z = r10;
            View r11 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.ll_content_container, OaidModel.KEY_ID, "ll_content_container"));
            Intrinsics.checkNotNullExpressionValue(r11, "findViewById(...)");
            this.A = r11;
            View r12 = r8.findViewById(ZeusTransformUtils.mapRes(R.id.artifact_reference_container, OaidModel.KEY_ID, "artifact_reference_container"));
            Intrinsics.checkNotNullExpressionValue(r12, "findViewById(...)");
            this.B = (LinearLayout) ZeusTransformUtils.preCheckCast(r12, LinearLayout.class, "com.obric.memorydata.plugin");
            ViewGroup.LayoutParams r13 = r9.getLayoutParams();
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            this.C = ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r13, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).topMargin;
            b();
        }

        public static final /* synthetic */ LinearLayout a(a r0) {
            return r0.y;
        }

        private final void a(final View r3, com.obric.aiproactive.ui.progress.a r4, final z r5, boolean r6, Function1<? super z, Unit> r7) {
            final Function1 r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
            final String r8 = i.a(r4.g());
            if (r6 == false) goto L5;
            View.OnClickListener r1 = new $$Lambda$h$a$rFhAO1cJABh6imWJav63at9p6iI(r2, r5);
        L8:
            r3.setOnClickListener(r1);
            boolean r9 = false;
            if (r6 == true) goto L13;
            if (r8 != null) goto L13;
            boolean r10 = false;
        L14:
            r3.setClickable(r10);
            if (r6 == true) goto L17;
            if (r8 != null) goto L17;
        L18:
            r3.setFocusable(r9);
            StringBuilder r11 = new StringBuilder().append(i.a(r4, r6));
            if (r8 == null) goto L21;
            String r12 = "，可打开网页";
        L22:
            r3.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(r11.append(r12).toString(), CharSequence.class, "com.obric.memorydata.plugin"));
            return;
        L21:
            r12 = "";
        L17:
            r9 = true;
        L13:
            r10 = true;
            goto L14
        L5:
            if (r8 == null) goto L7;
            r1 = new $$Lambda$h$a$D5DslirHbZEJm3KFwm09SErrs0(r3, r8);
            goto L8
        L7:
            r1 = null;
            goto L8
        }

        private final void a(View r9, com.obric.aiproactive.ui.progress.a r10, boolean r11, String r12, int r13) {
            TextView r0 = (TextView) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.mobile_child_ordinal, OaidModel.KEY_ID, "mobile_child_ordinal")), TextView.class, "com.obric.memorydata.plugin");
            GradientTextView r14 = (GradientTextView) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.mobile_child_title, OaidModel.KEY_ID, "mobile_child_title")), GradientTextView.class, "com.obric.memorydata.plugin");
            r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"));
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();
            r1.width = r13;
            r0.setLayoutParams(r1);
            Context r15 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            if (r10.e() == false) goto L5;
        L8:
            int r2 = ZeusTransformUtils.mapRes(R.color.ai_proactive_agent_mobile_current, TypedValues.Custom.S_COLOR, "ai_proactive_agent_mobile_current");
        L9:
            r0.setTextColor(ContextCompat.getColor(r15, r2));
            ViewGroup.LayoutParams r16 = r14.getLayoutParams();
            if (ZeusTransformUtils.instanceOf(r16, ConstraintLayout.LayoutParams.class) == false) goto L12;
            ConstraintLayout.LayoutParams r17 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r16, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        L14:
            if (r17 != null) goto L16;
        L20:
            r14.setText((CharSequence) ZeusTransformUtils.preCheckCast(i.a(r10.c(), r11), CharSequence.class, "com.obric.memorydata.plugin"));
            r14.setMaxLines(3);
            r14.setEllipsize(TextUtils.TruncateAt.END);
            if (r10.e() == false) goto L23;
            r14.setSweepColors(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.ai_proactive_agent_mobile_current, TypedValues.Custom.S_COLOR, "ai_proactive_agent_mobile_current")), ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.ai_proactive_agent_mobile_current_highlight, TypedValues.Custom.S_COLOR, "ai_proactive_agent_mobile_current_highlight")));
            r14.setSweepEnabled(true);
            return;
        L23:
            r14.setSweepEnabled(false);
            Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10.g(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L26;
            int r18 = ZeusTransformUtils.mapRes(R.color.ai_proactive_agent_mobile_current, TypedValues.Custom.S_COLOR, "ai_proactive_agent_mobile_current");
        L27:
            r14.setTextColor(ContextCompat.getColor(r8, r18));
            return;
        L26:
            r18 = ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_text_secondary, TypedValues.Custom.S_COLOR, "ai_proactive_demo_text_secondary");
            goto L27
        L16:
            if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L18;
            int r19 = 0;
        L19:
            r17.setMarginStart(r19);
            r14.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r17, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
            goto L20
        L18:
            r19 = ZeusTransformUtils.getResources(this.c, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.ai_proactive_agent_secondary_list_marker_gap, "dimen", "ai_proactive_agent_secondary_list_marker_gap"));
            goto L19
        L12:
            r17 = null;
            goto L14
        L5:
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10.g(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
            r2 = ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_text_tertiary, TypedValues.Custom.S_COLOR, "ai_proactive_demo_text_tertiary");
            goto L9
        }

        private static final void a(View r0, String r1, View r2) {
            com.obric.aiproactive.ui.util.j.f6886a.a(r0, r1);
        }

        private final void a(ImageView r2, int r3, int r4) {
            r2.setImageResource(r3);
            ImageViewCompat.setImageTintList(r2, ColorStateList.valueOf(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4)));
        }

        private final void a(AgentRunUiState r9) {
            this.f6817b.setRotation(0.0f);
            this.f6817b.setAlpha(1.0f);
            this.f6817b.setVisibility(0);
            this.t.setCurrentState(10);
            this.t.setVisibility(8);
            ImageViewCompat.setImageTintList(this.f6817b, null);
            switch(b.f6818a[r9.ordinal()]) {
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            a(this.f6817b, ZeusTransformUtils.mapRes(R.drawable.oui_icon_oic_arrowtriangle_2_right_circle_fill, "drawable", "oui_icon_oic_arrowtriangle_2_right_circle_fill"), ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_text_tertiary, TypedValues.Custom.S_COLOR, "ai_proactive_demo_text_tertiary"));
            this.f6817b.setAlpha(0.45f);
            View r8 = this.u;
            Class<CharSequence> r10 = CharSequence.class;
            String r0 = "状态未知";
        L12:
            r8.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(r0, r10, "com.obric.memorydata.plugin"));
            return;
        L7:
            a(this.f6817b, ZeusTransformUtils.mapRes(R.drawable.oui_icon_oic_xmark_circle_fill, "drawable", "oui_icon_oic_xmark_circle_fill"), ZeusTransformUtils.mapRes(R.color.ai_proactive_agent_step_error, TypedValues.Custom.S_COLOR, "ai_proactive_agent_step_error"));
            r8 = this.u;
            r10 = CharSequence.class;
            r0 = "执行失败";
            goto L12
        L8:
            a(this.f6817b, ZeusTransformUtils.mapRes(R.drawable.oui_icon_oic_minus_circle_fill, "drawable", "oui_icon_oic_minus_circle_fill"), ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_text_tertiary, TypedValues.Custom.S_COLOR, "ai_proactive_demo_text_tertiary"));
            r8 = this.u;
            r10 = CharSequence.class;
            r0 = "已停止";
            goto L12
        L9:
            a(this.f6817b, ZeusTransformUtils.mapRes(R.drawable.oui_icon_oic_arrowtriangle_2_right_circle_fill, "drawable", "oui_icon_oic_arrowtriangle_2_right_circle_fill"), ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_text_tertiary, TypedValues.Custom.S_COLOR, "ai_proactive_demo_text_tertiary"));
            this.f6817b.setAlpha(0.45f);
            r8 = this.u;
            r10 = CharSequence.class;
            r0 = "等待中";
            goto L12
        L10:
            this.f6817b.setVisibility(8);
            this.t.setVisibility(0);
            this.t.setCurrentState(0);
            r8 = this.u;
            r10 = CharSequence.class;
            r0 = "进行中";
            goto L12
        L11:
            a(this.f6817b, ZeusTransformUtils.mapRes(R.drawable.oui_icon_oic_checkmark_circle_fill, "drawable", "oui_icon_oic_checkmark_circle_fill"), ZeusTransformUtils.mapRes(R.color.ai_proactive_agent_step_success, TypedValues.Custom.S_COLOR, "ai_proactive_agent_step_success"));
            r8 = this.u;
            r10 = CharSequence.class;
            r0 = "已完成";
            goto L12
        L5:
            throw new NoWhenBranchMatchedException();
        }

        private final void a(n r19, boolean r20, z r21, Function1<? super z, Unit> r22) {
            Function1<? super z, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r22, Function1.class, "com.obric.memorydata.plugin");
            d();
            if (r20 == true) goto L5;
        L32:
            this.y.setVisibility(8);
            return;
        L5:
            if (r19.k().isEmpty() == true) goto L32;
            this.y.setVisibility(0);
            Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r19.k(), Iterable.class, "com.obric.memorydata.plugin");
            Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r2 = r0.iterator();
        L9:
            if (r2.hasNext() == false) goto L11;
            r1.add(TuplesKt.to((com.obric.aiproactive.ui.progress.a) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.aiproactive.ui.progress.a.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.item_agent_run_mobile_child, "layout", "item_agent_run_mobile_child"), (ViewGroup) ZeusTransformUtils.preCheckCast(this.y, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin")));
            goto L9
        L11:
            List r3 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
            TextPaint r4 = ((TextView) ZeusTransformUtils.preCheckCast(((View) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r3), Pair.class, "com.obric.memorydata.plugin")).getSecond(), View.class, "com.obric.memorydata.plugin")).findViewById(ZeusTransformUtils.mapRes(R.id.mobile_child_ordinal, OaidModel.KEY_ID, "mobile_child_ordinal")), TextView.class, "com.obric.memorydata.plugin")).getPaint();
            Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r19.k(), Iterable.class, "com.obric.memorydata.plugin");
            Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r7 = r5.iterator();
        L13:
            if (r7.hasNext() == false) goto L15;
            r6.add(i.a(r19.l(), ((com.obric.aiproactive.ui.progress.a) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.aiproactive.ui.progress.a.class, "com.obric.memorydata.plugin")).b()));
            goto L13
        L15:
            List r10 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
            int r11 = i.a(r10, (Function1) ZeusTransformUtils.preCheckCast(new AgentRunStepAdapter$StepHolder$bindActivityChildren$markerColumnWidth$1(r4), Function1.class, "com.obric.memorydata.plugin"));
            Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
            int r9 = 0;
        L17:
            if (r12.hasNext() == false) goto L31;
            Object r13 = r12.next();
            int r14 = r9 + 1;
            if (r9 >= 0) goto L21;
            CollectionsKt.throwIndexOverflow();
        L21:
            Pair r15 = (Pair) ZeusTransformUtils.preCheckCast(r13, Pair.class, "com.obric.memorydata.plugin");
            com.obric.aiproactive.ui.progress.a r16 = (com.obric.aiproactive.ui.progress.a) ZeusTransformUtils.preCheckCast(r15.component1(), com.obric.aiproactive.ui.progress.a.class, "com.obric.memorydata.plugin");
            View r17 = (View) ZeusTransformUtils.preCheckCast(r15.component2(), View.class, "com.obric.memorydata.plugin");
            z r18 = new z(r19.h(), r19.i(), r16.a(), r19.j());
            if (r16.e() == false) goto L29;
            if (Intrinsics.areEqual(r16.f(), "open_mobile_use_player") == false) goto L29;
            if (Intrinsics.areEqual(r21, r18) == false) goto L29;
            boolean r110 = true;
        L30:
            Intrinsics.checkNotNull(r17);
            a(r17, r16, r110, (String) ZeusTransformUtils.preCheckCast(r10.get(r9), String.class, "com.obric.memorydata.plugin"), r11);
            a(r17, r16, r18, r110, r8);
            this.y.addView(r17);
            r9 = r14;
        L29:
            r110 = false;
            goto L30
        }

        private static final void a(Function0 r1, View r2) {
            ((Function0) ZeusTransformUtils.wrapperContextForParams(r1, Function0.class, "com.obric.memorydata.plugin")).invoke();
        }

        private static final void a(Function1 r1, z r2, View r3) {
            ((Function1) ZeusTransformUtils.wrapperContextForParams(r1, Function1.class, "com.obric.memorydata.plugin")).invoke(r2);
        }

        private final void a(boolean r7) {
            if (r7 == true) goto L5;
            c();
            return;
        L5:
            View r8 = (View) ZeusTransformUtils.preCheckCast(this.x.getMTvTitle(), View.class, "com.obric.memorydata.plugin");
            if (ViewCompat.isLaidOut(r8) == true) goto L8;
        L23:
            r8.addOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(new c(this), View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
            return;
        L8:
            if (r8.isLayoutRequested() == true) goto L23;
            ViewParent r0 = a(this).getParent();
            ViewGroup.MarginLayoutParams r3 = null;
            if (ZeusTransformUtils.instanceOf(r0, ViewGroup.class) == false) goto L12;
            ViewGroup r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.memorydata.plugin");
        L13:
            if (r1 == null) goto L27;
            Rect r2 = new Rect();
            r8.getDrawingRect(r2);
            r1.offsetDescendantRectToMyCoords(r8, r2);
            int r9 = r2.bottom + ZeusTransformUtils.getResources(this.c, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.ai_proactive_agent_secondary_list_parent_gap, "dimen", "ai_proactive_agent_secondary_list_parent_gap"));
            ViewGroup.LayoutParams r4 = a(this).getLayoutParams();
            if (ZeusTransformUtils.instanceOf(r4, ViewGroup.MarginLayoutParams.class) == false) goto L18;
            r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        L18:
            if (r3 == null) goto L28;
            int r10 = r9 - b(this).getBottom();
            if (r3.topMargin == r10) goto L25;
            r3.topMargin = r10;
            a(this).setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
            return;
        L25:
            return;
        L28:
            return;
        L27:
            return;
        L12:
            r1 = null;
            goto L13
        }

        private final void a(boolean r3, boolean r4) {
            if (r3 == true) goto L5;
            Drawable r5 = null;
        L10:
            TextView r6 = this.x.getMTvTitle();
            r6.setCompoundDrawablesRelative(null, null, r5, null);
            if (r5 != null) goto L13;
            int r2 = 0;
        L14:
            r6.setCompoundDrawablePadding(r2);
            return;
        L13:
            r2 = d(4);
            goto L14
        L5:
            if (r4 == false) goto L7;
            int r7 = R.drawable.oui_icon_oic_chevron_down;
            String r1 = "oui_icon_oic_chevron_down";
        L8:
            r5 = c(ZeusTransformUtils.mapRes(r7, "drawable", r1));
            goto L10
        L7:
            r7 = R.drawable.oui_icon_oic_chevron_right;
            r1 = "oui_icon_oic_chevron_right";
            goto L8
        }

        public static final /* synthetic */ OListItemGeneral b(a r0) {
            return r0.x;
        }

        private final void b() {
            Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new View[]{this.z, this.A}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            View r0 = (View) ZeusTransformUtils.preCheckCast(r6.next(), View.class, "com.obric.memorydata.plugin");
            r0.setPaddingRelative(r0.getPaddingStart(), r0.getPaddingTop(), 0, r0.getPaddingBottom());
            goto L4
        }

        private final Drawable c(int r4) {
            Drawable r5 = ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
            if (r5 == null) goto L7;
            Drawable r6 = r5.mutate();
            if (r6 == null) goto L7;
            int r0 = d(16);
            r6.setBounds(0, 0, r0, r0);
            DrawableCompat.setTint(r6, ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_text_tertiary, TypedValues.Custom.S_COLOR, "ai_proactive_demo_text_tertiary")));
            return r6;
        L7:
            return null;
        }

        public static final /* synthetic */ View c(a r0) {
            return r0.u;
        }

        private final void c() {
            ViewGroup.LayoutParams r0 = this.y.getLayoutParams();
            if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L5;
            ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        L6:
            if (r1 != null) goto L8;
            return;
        L8:
            int r2 = r1.topMargin;
            int r3 = this.C;
            if (r2 != r3) goto L11;
            return;
        L11:
            r1.topMargin = r3;
            this.y.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
            return;
        L5:
            r1 = null;
            goto L6
        }

        private final void c(boolean r4) {
            ViewGroup.LayoutParams r0 = this.x.getMTvSubtitle().getLayoutParams();
            if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L5;
            ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        L6:
            if (r1 != null) goto L8;
            return;
        L8:
            if (r4 == false) goto L10;
            int r5 = d(8);
        L11:
            r1.topMargin = r5;
            this.x.getMTvSubtitle().setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
            return;
        L10:
            r5 = 0;
            goto L11
        L5:
            r1 = null;
            goto L6
        }

        private final int d(int r2) {
            return (int) (r2 * ZeusTransformUtils.getResources(this.c, "com.obric.memorydata.plugin").getDisplayMetrics().density);
        }

        private final void d() {
            int r0 = this.y.getChildCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L8;
            GradientTextView r3 = (GradientTextView) ZeusTransformUtils.preCheckCast(this.y.getChildAt(r2).findViewById(ZeusTransformUtils.mapRes(R.id.mobile_child_title, OaidModel.KEY_ID, "mobile_child_title")), GradientTextView.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L7;
            r3.setSweepEnabled(false);
        L7:
            r2 = r2 + 1;
            goto L3
        L8:
            this.y.removeAllViews();
            this.y.setVisibility(8);
        }

        private final void e() {
            OListItemGeneral r4 = this.x;
            Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new View[]{this.c, r4, r4.getMClContent()}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            View r0 = (View) ZeusTransformUtils.preCheckCast(r5.next(), View.class, "com.obric.memorydata.plugin");
            r0.setBackground(null);
            r0.setForeground(null);
            r0.setStateListAnimator(null);
            r0.setElevation(0.0f);
            r0.setTranslationZ(0.0f);
            r0.setPressed(false);
            goto L4
        }

        private final void f() {
            View r0 = (View) ZeusTransformUtils.preCheckCast(this.x.getMTvTitle(), View.class, "com.obric.memorydata.plugin");
            if (ViewCompat.isLaidOut(r0) == true) goto L5;
        L30:
            r0.addOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(new d(this), View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
            return;
        L5:
            if (r0.isLayoutRequested() == true) goto L30;
            View r1 = this.c;
            ConstraintLayout.LayoutParams r4 = null;
            if (ZeusTransformUtils.instanceOf(r1, ViewGroup.class) == false) goto L9;
            ViewGroup r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(r1, ViewGroup.class, "com.obric.memorydata.plugin");
        L10:
            if (r2 == null) goto L34;
            Rect r3 = new Rect();
            r0.getDrawingRect(r3);
            r2.offsetDescendantRectToMyCoords(r0, r3);
            Integer r5 = Integer.valueOf(c(this).getHeight());
            if (((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L15;
            boolean r6 = true;
        L16:
            if (r6 == true) goto L19;
            r5 = null;
        L19:
            if (r5 == null) goto L21;
            int r7 = r5.intValue();
        L22:
            int r8 = RangesKt.coerceAtLeast(r3.centerY() - (r7 / 2), 0);
            ViewGroup.LayoutParams r9 = c(this).getLayoutParams();
            if (ZeusTransformUtils.instanceOf(r9, ConstraintLayout.LayoutParams.class) == false) goto L25;
            r4 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r9, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        L25:
            if (r4 != null) goto L28;
            return;
        L28:
            if (r4.topMargin == r8) goto L32;
            r4.topMargin = r8;
            c(this).setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
            return;
        L32:
            return;
        L21:
            r7 = c(this).getLayoutParams().height;
            goto L22
        L15:
            r6 = false;
            goto L16
        L34:
            return;
        L9:
            r2 = null;
            goto L10
        }

        /* JADX INFO: renamed from: lambda$D5DslirH-bZEJm3KFwm09SErrs0, reason: not valid java name */
        public static /* synthetic */ void m339lambda$D5DslirHbZEJm3KFwm09SErrs0(View r0, String r1, View r2) {
            a(r0, r1, r2);
        }

        /* JADX INFO: renamed from: lambda$Ib-oe_W7FVj9w0qX3CT-0eSrd3A, reason: not valid java name */
        public static /* synthetic */ void m340lambda$Iboe_W7FVj9w0qX3CT0eSrd3A(Function0 r0, View r1) {
            a(r0, r1);
        }

        public static /* synthetic */ void lambda$rFhAO1cJABh6imWJav63at9p6iI(Function1 r0, z r1, View r2) {
            a(r0, r1, r2);
        }

        public final void a() {
            this.f6817b.setRotation(0.0f);
            this.f6817b.setAlpha(1.0f);
            this.f6817b.setVisibility(0);
            this.t.setCurrentState(10);
            this.t.setVisibility(8);
            com.obric.aiproactive.ui.util.j.f6886a.a(this.x.getMTvSubtitle());
            OListItemGeneral r3 = this.x;
            Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new View[]{this.c, r3, r3.getMClContent(), this.x.getMTvTitle()}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            View r4 = (View) ZeusTransformUtils.preCheckCast(r0.next(), View.class, "com.obric.memorydata.plugin");
            r4.setOnClickListener(null);
            r4.setClickable(false);
            r4.setFocusable(false);
            goto L4
        L6:
            this.x.getMTvSubtitle().setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"));
            this.x.getMTvSubtitle().setVisibility(8);
            this.B.removeAllViews();
            this.B.setVisibility(8);
            this.x.getMTvTitle().setCompoundDrawablesRelative(null, null, null, null);
            c();
            d();
            this.c.setContentDescription(null);
            this.x.setContentDescription(null);
        }

        public final void a(n r18, boolean r19, boolean r20, boolean r21, List<String> r22, Map<String, com.obric.aiproactive.api.j> r23, z r24, Function1<? super z, Unit> r25, Function0<Unit> r26) {
            List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
            Map<String, com.obric.aiproactive.api.j> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.memorydata.plugin");
            Function1<? super z, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r25, Function1.class, "com.obric.memorydata.plugin");
            final Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r26, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r18, "step");
            Intrinsics.checkNotNullParameter(r3, "recommendationMarkdown");
            Intrinsics.checkNotNullParameter(r5, "canonicalArtifacts");
            Intrinsics.checkNotNullParameter(r6, "onMobileItemClick");
            Intrinsics.checkNotNullParameter(r7, "onToggle");
            a();
            e();
            View r8 = this.v;
            int r9 = 4;
            if (r19 == false) goto L5;
            int r11 = 4;
        L6:
            r8.setVisibility(r11);
            View r10 = this.w;
            if (r20 == true) goto L10;
            r9 = 0;
        L10:
            r10.setVisibility(r9);
            a(r18.d());
            j r4 = i.a(r18, r21, r3);
            Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r18.e(), Iterable.class, "com.obric.memorydata.plugin");
            Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r14 = r12.iterator();
        L12:
            if (r14.hasNext() == false) goto L14;
            CollectionsKt.addAll(r13, (Iterable) ZeusTransformUtils.preCheckCast(((k) ZeusTransformUtils.preCheckCast(r14.next(), k.class, "com.obric.memorydata.plugin")).c(), Iterable.class, "com.obric.memorydata.plugin"));
            goto L12
        L14:
            Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
            Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r17 = r15.iterator();
        L16:
            if (r17.hasNext() == false) goto L20;
            com.obric.aiproactive.api.d r110 = ((l) ZeusTransformUtils.preCheckCast(r17.next(), l.class, "com.obric.memorydata.plugin")).d();
            if (r110 == null) goto L16;
            r16.add(r110);
            goto L16
        L20:
            Iterable r27 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
            HashSet r28 = new HashSet();
            ArrayList r111 = new ArrayList();
            Iterator r29 = r27.iterator();
        L22:
            if (r29.hasNext() == false) goto L26;
            Object r112 = r29.next();
            if (r28.add(((com.obric.aiproactive.api.d) ZeusTransformUtils.preCheckCast(r112, com.obric.aiproactive.api.d.class, "com.obric.memorydata.plugin")).a()) == false) goto L22;
            r111.add(r112);
            goto L22
        L26:
            List<com.obric.aiproactive.api.d> r30 = (List) ZeusTransformUtils.preCheckCast(r111, List.class, "com.obric.memorydata.plugin");
            if (r21 == true) goto L29;
        L31:
            boolean r113 = false;
        L32:
            this.x.setTitleString((CharSequence) ZeusTransformUtils.preCheckCast(r18.b(), CharSequence.class, "com.obric.memorydata.plugin"));
            this.x.setSubTitleString((CharSequence) ZeusTransformUtils.preCheckCast(r4.b(), CharSequence.class, "com.obric.memorydata.plugin"));
            boolean r114 = !StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4.b(), CharSequence.class, "com.obric.memorydata.plugin"));
            TextView r115 = this.x.getMTvTitle();
            r115.setTextAppearance(ZeusTransformUtils.mapRes(R.style.Title_1_Medium, "style", "Title_1_Medium"));
            r115.setSingleLine(r114);
            if (r114 == false) goto L35;
            int r116 = 1;
        L36:
            r115.setMaxLines(r116);
            if (r114 == false) goto L39;
            TextUtils.TruncateAt r117 = TextUtils.TruncateAt.END;
        L40:
            r115.setEllipsize(r117);
            TextView r118 = this.x.getMTvSubtitle();
            r118.setTextAppearance(ZeusTransformUtils.mapRes(R.style.Body_1_Regular, "style", "Body_1_Regular"));
            if (r4.c() == false) goto L43;
            int r31 = Integer.MAX_VALUE;
        L44:
            r118.setMaxLines(r31);
            if (r4.d() == false) goto L47;
            TextUtils.TruncateAt r32 = TextUtils.TruncateAt.END;
        L48:
            r118.setEllipsize(r32);
            if (r114 == false) goto L51;
            int r119 = 0;
        L52:
            r118.setVisibility(r119);
            c(r114);
            if (r4.c() == false) goto L55;
            com.obric.aiproactive.ui.util.j.f6886a.d(this.x.getMTvSubtitle(), r4.b());
        L56:
            this.x.setShowBackground(false);
            this.x.setShowDivider(false);
            this.x.getMTrailingElement().removeAllViews();
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4.a(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L59;
        L64:
            boolean r120 = true;
        L65:
            if (r21 == true) goto L67;
        L69:
            this.B.removeAllViews();
            this.B.setVisibility(8);
        L70:
            this.x.getMTrailingElement().setVisibility(8);
            a(r18, r21, r24, r6);
            a(r120, r21);
            a(r113);
            f();
            boolean r33 = i.a(r120);
            if (r33 == false) goto L73;
            View.OnClickListener r34 = new $$Lambda$h$a$Iboe_W7FVj9w0qX3CT0eSrd3A(r7);
        L74:
            OListItemGeneral r35 = this.x;
            Iterator r36 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new View[]{r35, r35.getMClContent(), this.x.getMTvTitle()}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L76:
            if (r36.hasNext() == false) goto L78;
            View r37 = (View) ZeusTransformUtils.preCheckCast(r36.next(), View.class, "com.obric.memorydata.plugin");
            r37.setOnClickListener(r34);
            r37.setClickable(r33);
            goto L76
        L78:
            this.c.setClickable(false);
            this.c.setFocusable(false);
            this.x.setFocusable(r33);
            this.x.getMClContent().setFocusable(false);
            this.x.getMTvTitle().setFocusable(false);
            this.c.setContentDescription(null);
            this.x.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(i.a(r18, r120, r21), CharSequence.class, "com.obric.memorydata.plugin"));
            return;
        L73:
            r34 = null;
            goto L74
        L67:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r30, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L69;
            com.obric.aiproactive.ui.artifact.a.f6542a.a(this.B, r30, r5);
            goto L70
        L59:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r30, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L64;
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r18.k(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L64;
            r120 = false;
            goto L65
        L55:
            this.x.getMTvSubtitle().setText((CharSequence) ZeusTransformUtils.preCheckCast(r4.b(), CharSequence.class, "com.obric.memorydata.plugin"));
            com.obric.aiproactive.ui.util.j.f6886a.a(this.x.getMTvSubtitle());
            goto L56
        L51:
            r119 = 8;
            goto L52
        L47:
            r32 = null;
            goto L48
        L43:
            r31 = 2;
            goto L44
        L39:
            r117 = null;
            goto L40
        L35:
            r116 = 2;
            goto L36
        L29:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r18.k(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L31;
            r113 = true;
            goto L32
        L5:
            r11 = 0;
            goto L6
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public h(Function1<? super z, Unit> r3, Function2<? super String, ? super Boolean, Unit> r4) {
        Function1<z, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function2<String, Boolean, Unit> r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "onMobileItemClick");
        Intrinsics.checkNotNullParameter(r6, "onUserExpansionChanged");
        this.f6814a = r5;
        this.f6815b = r6;
        this.c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.d = CollectionsKt.emptyList();
        this.e = MapsKt.emptyMap();
        this.f = SetsKt.emptySet();
    }

    public /* synthetic */ h(Function1 r2, Function2 r3, int r4, DefaultConstructorMarker r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Function2 r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = $$Lambda$h$WhkyUjSnCLWWS40kiRuq50nI6E.INSTANCE;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r7 = $$Lambda$h$OEGedF5Dllno9JKihzz65Yu9Z3o.INSTANCE;
    L8:
        this(r6, r7);
    }

    private static final Unit a(h r0, n r1) {
        r0.a(r1.a());
        return Unit.INSTANCE;
    }

    private final void a(String r6) {
        Iterator<n> r0 = this.c.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(((n) ZeusTransformUtils.preCheckCast(r0.next(), n.class, "com.obric.memorydata.plugin")).a(), r6) == true) goto L10;
        r1 = r1 + 1;
    L10:
        if (r1 >= 0) goto L12;
        return;
    L12:
        Set<String> r2 = i.a(this.f, r6);
        this.f = r2;
        this.f6815b.invoke(r6, Boolean.valueOf(r2.contains(r6)));
        e(r1);
        return;
    L9:
        r1 = -1;
        goto L10
    }

    private static final Unit b(z r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    private static final Unit b(String r0, boolean r1) {
        Intrinsics.checkNotNullParameter(r0, "<unused var>");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$9DlazdT9glgONtWXMne4jykZt_8(h r0, n r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$OEGedF5Dllno9JKihzz65Yu9Z3o(String r0, boolean r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$WhkyUj-SnCLWWS40kiRuq50nI6E, reason: not valid java name */
    public static /* synthetic */ Unit m338lambda$WhkyUjSnCLWWS40kiRuq50nI6E(z r0) {
        return b(r0);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.v a(ViewGroup r1, int r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(b(r1, r2), RecyclerView.v.class, "com.obric.memorydata.plugin");
    }

    public final Set<String> a() {
        return this.f;
    }

    public void a(a r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        r3.a();
        super.b((RecyclerView.v) ZeusTransformUtils.preCheckCast(r3, RecyclerView.v.class, "com.obric.memorydata.plugin"));
    }

    public void a(a r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "holder");
        final n r2 = (n) ZeusTransformUtils.preCheckCast(this.c.get(r13), n.class, "com.obric.memorydata.plugin");
        if (r13 != 0) goto L5;
        boolean r3 = true;
    L7:
        if (r13 != CollectionsKt.getLastIndex(this.c)) goto L9;
        boolean r4 = true;
    L10:
        boolean r5 = this.f.contains(r2.a());
        if (Intrinsics.areEqual(r2.a(), "phase-result") == false) goto L13;
        List<String> r14 = this.d;
    L14:
        r12.a(r2, r3, r4, r5, r14, this.e, this.h, this.f6814a, new $$Lambda$h$9DlazdT9glgONtWXMne4jykZt_8(this, r2));
        return;
    L13:
        r14 = CollectionsKt.emptyList();
        goto L14
    L9:
        r4 = false;
        goto L10
    L5:
        r3 = false;
        goto L7
    }

    public final void a(z r2) {
        if (Intrinsics.areEqual(this.h, r2) == false) goto L5;
        return;
    L5:
        this.h = r2;
        h();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"), r4);
    }

    public final void a(String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "stepId");
        Iterator<n> r0 = this.c.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(((n) ZeusTransformUtils.preCheckCast(r0.next(), n.class, "com.obric.memorydata.plugin")).a(), r6) == true) goto L10;
        r1 = r1 + 1;
    L10:
        if (r1 >= 0) goto L12;
        return;
    L12:
        if (this.f.contains(r6) == r7) goto L22;
        if (r7 == false) goto L16;
        Set<String> r8 = SetsKt.plus(this.f, r6);
    L17:
        this.f = r8;
        e(r1);
        return;
    L16:
        r8 = SetsKt.minus(this.f, r6);
        goto L17
    L22:
        return;
    L9:
        r1 = -1;
        goto L10
    }

    public final void a(List<n> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "steps");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L5;
    L6:
        Set<String> r0 = this.f;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r3.add(((n) ZeusTransformUtils.preCheckCast(r4.next(), n.class, "com.obric.memorydata.plugin")).a());
        goto L8
    L10:
        this.f = i.a(r0, (Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.memorydata.plugin"));
        this.g = false;
    L11:
        this.c.clear();
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(this.c, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin"));
        h();
        return;
    L5:
        if (this.g == true) goto L11;
        goto L6
    }

    public final void a(Set<String> r3) {
        Set<String> r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "stepIds");
        this.f = r4;
        this.g = !((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty();
    }

    public a b(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        View r7 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.item_agent_run_step, "layout", "item_agent_run_step"), r5, false, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r7, "inflate(...)");
        return new a(r7);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void b(RecyclerView.v r3) {
        a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"));
    }

    public final void b(List<String> r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "items");
        if (Intrinsics.areEqual(this.d, r7) == false) goto L5;
        return;
    L5:
        this.d = r7;
        Iterator<n> r8 = this.c.iterator();
        boolean r0 = false;
        int r2 = 0;
    L7:
        if (r8.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(((n) ZeusTransformUtils.preCheckCast(r8.next(), n.class, "com.obric.memorydata.plugin")).a(), "phase-result") == true) goto L13;
        r2 = r2 + 1;
    L13:
        Integer r9 = Integer.valueOf(r2);
        if (((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L16;
        r0 = true;
    L16:
        if (r0 == true) goto L19;
        r9 = null;
    L19:
        if (r9 == null) goto L24;
        e(((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L24:
        return;
    L12:
        r2 = -1;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(List<com.obric.aiproactive.api.j> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "artifacts");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Map<String, com.obric.aiproactive.api.j> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r7, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L7;
        Object r2 = r8.next();
        r0.put(((com.obric.aiproactive.api.j) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.api.j.class, "com.obric.memorydata.plugin")).a(), r2);
        goto L4
    L7:
        if (Intrinsics.areEqual(this.e, r0) == false) goto L9;
        return;
    L9:
        this.e = r0;
        h();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int d() {
        return this.c.size();
    }
}
