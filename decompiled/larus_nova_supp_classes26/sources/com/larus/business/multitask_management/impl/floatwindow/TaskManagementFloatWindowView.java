package com.larus.business.multitask_management.impl.floatwindow;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.ixigua.lib.track.TrackParams;
import com.larus.business.multitask_management.impl.component.OngoingTaskListAdapter;
import com.larus.business.multitask_management.impl.view.FadeEdgeRecyclerView;
import com.larus.common.apphost.AppHost;
import com.larus.multitask_management.api.data.TaskType;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import kl9.u;
import kl9.x;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Job;
import org.json.JSONException;
import org.json.JSONObject;
import v19.c7;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 v2\u00020\u00012\u00020\u0002:\u0004vwxyB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010<\u001a\u00020=H\u0002J\u0006\u0010>\u001a\u00020=J\u0006\u0010?\u001a\u00020=J\b\u0010@\u001a\u00020\bH\u0002J\b\u0010A\u001a\u00020\bH\u0002J\b\u0010B\u001a\u00020=H\u0002J\r\u0010C\u001a\u00020=H\u0000¢\u0006\u0002\bDJ\u0015\u0010E\u001a\u00020=2\u0006\u0010F\u001a\u00020'H\u0000¢\u0006\u0002\bGJ\u0018\u0010H\u001a\u00020=2\u0006\u0010I\u001a\u00020\u001c2\u0006\u0010J\u001a\u00020\u001eH\u0016J\u0018\u0010K\u001a\u00020=2\u0006\u0010I\u001a\u00020\u001c2\u0006\u0010J\u001a\u00020\u001eH\u0002J\u0010\u0010L\u001a\u00020=2\u0006\u0010I\u001a\u00020\u001cH\u0002J\u0018\u0010M\u001a\u00020=2\u0006\u0010I\u001a\u00020\u001c2\u0006\u0010J\u001a\u00020\u001eH\u0002J\b\u0010N\u001a\u00020=H\u0002J\b\u0010O\u001a\u00020=H\u0002J\b\u0010P\u001a\u00020=H\u0002J\u0010\u0010Q\u001a\u00020=2\u0006\u0010I\u001a\u00020\u001cH\u0002J\n\u0010R\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010S\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cH\u0002J \u0010T\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020\u001c2\u0006\u0010W\u001a\u00020\u001cH\u0002J(\u0010X\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020\u001c2\u0006\u0010W\u001a\u00020\u001c2\u0006\u0010Y\u001a\u00020\u001cH\u0002J\u0018\u0010Z\u001a\u00020=2\u0006\u0010[\u001a\u00020\u00132\u0006\u0010\\\u001a\u00020\bH\u0002J\u0018\u0010]\u001a\u00020=2\u0006\u0010[\u001a\u00020\u00132\u0006\u0010^\u001a\u00020\u001cH\u0002J\u001a\u0010_\u001a\u00020=2\b\u0010[\u001a\u0004\u0018\u00010\u00132\u0006\u0010`\u001a\u00020\bH\u0002J\u0012\u0010a\u001a\u00020=2\b\u0010b\u001a\u0004\u0018\u00010cH\u0002J\b\u0010d\u001a\u00020=H\u0002J \u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020f2\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020\bH\u0002J\u0014\u0010k\u001a\u0004\u0018\u0001062\b\u0010b\u001a\u0004\u0018\u00010cH\u0002J\u0014\u0010l\u001a\u0004\u0018\u00010i2\b\u0010b\u001a\u0004\u0018\u00010cH\u0002J\b\u0010m\u001a\u00020=H\u0002J\u0012\u0010n\u001a\u0004\u0018\u00010o2\u0006\u0010p\u001a\u00020\bH\u0002J\u0010\u0010q\u001a\u00020\u001e2\u0006\u0010p\u001a\u00020\bH\u0002J\u0010\u0010r\u001a\u00020s2\u0006\u0010g\u001a\u00020fH\u0002J\u0010\u0010t\u001a\u00020f2\u0006\u0010u\u001a\u00020fH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\"\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006z"}, d2 = {"Lcom/larus/business/multitask_management/impl/floatwindow/TaskManagementFloatWindowView;", "Landroid/widget/FrameLayout;", "Lcom/larus/common_ui/floatwindow/view/FullScreenFloatWindowExpandListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/business/multitask_management/impl/databinding/LarusMtmFullscreenFloatWindowBinding;", "taskList", "Landroidx/recyclerview/widget/RecyclerView;", "dragHandleContainer", "dragHandleBlurBg", "Landroid/widget/ImageView;", "dragHandleBlurBgMask", "Landroid/view/View;", "dragHandleOverlay", "dragHandleIcon", "adapter", "Lcom/larus/business/multitask_management/impl/component/OngoingTaskListAdapter;", "job", "Lkotlinx/coroutines/Job;", "blurLoadJob", "currentExpandProgress", "", "wasExpanded", "", "lastExpandProgress", "pendingExpandProgress", "Ljava/lang/Float;", "pendingIsDragging", "expandProgressPosted", "lastItemProgress", "lastDragHandleRadius", "latestHostInfo", "Lcom/larus/common_ui/floatwindow/manager/FloatWindowHostInfo;", "headerSpacingDecoration", "Lcom/larus/business/multitask_management/impl/floatwindow/TaskManagementFloatWindowView$HeaderSpacingDecoration;", "widthPx", "paddingPx", "xExtendHotDistance", "maxDragTranslationPx", "blurFadeEndPx", "overlayFadeStartPx", "overlayFadeEndPx", "iconFadeEndPx", "cornerStartPx", "cornerEndPx", "cornerRangePx", "appliedBlurKey", "", "loadingBlurKey", "blurRequestId", "", "dragHandleOutlineProvider", "Lcom/larus/business/multitask_management/impl/floatwindow/TaskManagementFloatWindowView$RoundRectOutlineProvider;", "setupTaskList", "", "onAdded", "onRemoved", "calculateHeaderHeight", "calculateHeaderSpacing", "setupDragHandle", "updateWidth", "updateWidth$impl_mainlandRelease", "onFloatWindowHostChanged", "host", "onFloatWindowHostChanged$impl_mainlandRelease", "onExpandProgress", "progress", "isDragging", "applyExpandProgress", "updateItemPositions", "updateDragHandleVisibility", "showDragHandleAfterCollapse", "updateDragHandlePosition", "updateHeaderLayout", "updateDragHandleVisuals", "findFirstTaskItemView", "calculateDragDistance", "alphaForRange", "distancePx", "startPx", "endPx", "lerpCornerRadius", "rangePx", "setVisibilityIfChanged", "view", "visibility", "setAlphaIfChanged", "alpha", "updateCornerRadius", "radius", "updateDragHandleBlur", "task", "Lcom/larus/multitask_management/api/data/TaskBasicInfo;", "cancelPendingBlurLoad", "buildDragHandleBlurBitmap", "Landroid/graphics/Bitmap;", "bitmap", "config", "Lcom/larus/business/multitask_management/impl/floatwindow/TaskManagementFloatWindowView$DragHandleBlurConfig;", "targetSize", "resolveTaskIconUrl", "resolveDragHandleBlurConfig", "performCompletelyShowCheck", "getTaskExposureKey", "", "index", "reportTaskCompletelyShow", "createBlurDrawable", "Landroid/graphics/drawable/Drawable;", "scaleBitmap", "original", "Companion", "RoundRectOutlineProvider", "DragHandleBlurConfig", "HeaderSpacingDecoration", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskManagementFloatWindowView extends FrameLayout implements com.larus.common_ui.floatwindow.view.i {
    public static final /* synthetic */ int G = 0;
    public final float A;
    public final float B;
    public final float C;
    public String D;
    public String E;
    public long F;
    public final FadeEdgeRecyclerView a;
    public final FrameLayout b;
    public final ImageView c;
    public final View d;
    public final View e;
    public final ImageView f;
    public OngoingTaskListAdapter g;
    public Job h;
    public Job i;
    public float j;
    public boolean k;
    public float l;
    public Float m;
    public boolean n;
    public boolean o;
    public float p;
    public int q;
    public e19.b r;
    public c s;
    public int t;
    public final int u;
    public float v;
    public final float w;
    public final float x;
    public final float y;
    public final float z;

    public static final class a {
        public static int a(Integer r2) {
            if (r2 != null) goto L5;
        L13:
            int r3 = m0.a;
            int r4 = m0.b(AppHost.a.getApplication());
        L15:
            return RangesKt.coerceAtLeast(Math.min(r4 - c7.b(92), c7.b(400)), 0);
        L5:
            if (r2.intValue() <= 0) goto L7;
            boolean r1 = true;
        L8:
            if (r1 == true) goto L11;
            r2 = null;
        L11:
            if (r2 == null) goto L13;
            r4 = r2.intValue();
            goto L15
        L7:
            r1 = false;
            goto L8
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final int c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return ((r3 + r1) * 31) + this.c;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "DragHandleBlurConfig(iconUrl=" + this.a + ", backgroundTint=" + this.b + ", insetPx=" + this.c + ')';
        }

        public b(String r1, String r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c extends RecyclerView.ItemDecoration {
        public int a;

        public c(int r1) {
            this.a = r1;
        }

        public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
            Intrinsics.checkNotNullParameter(r2, "outRect");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "state");
            int r6 = r4.getChildAdapterPosition(r3);
            if (r6 != 0) goto L5;
            r2.top = this.a;
            return;
        L5:
            if (r6 == 1) goto L7;
            r2.top = c7.b(8);
            return;
        L7:
            r2.top = 0;
        }
    }

    public static final class d extends ViewOutlineProvider {
        public int a;

        public d(int r1) {
            this.a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r8, Outline r9) {
            Intrinsics.checkNotNullParameter(r8, "view");
            Intrinsics.checkNotNullParameter(r9, "outline");
            r9.setRoundRect(0, 0, r8.getWidth(), r8.getHeight(), this.a);
        }
    }

    static {
    }

    public TaskManagementFloatWindowView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TaskManagementFloatWindowView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final int c() {
        e19.b r0 = this.r;
        if (r0 == null) goto L15;
        Rect r1 = r0.c;
        if (r1 == null) goto L15;
        Integer r2 = Integer.valueOf(r1.height());
        if (r2.intValue() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L15;
        int r4 = r2.intValue();
    L17:
        return (int) (r4 / 3.25f);
    L9:
        r3 = false;
    L15:
        int r5 = m0.a;
        r4 = m0.a(getContext());
        goto L17
    }

    public final void d() {
        this.F++;
        Job r0 = this.i;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.i = null;
        this.E = null;
    }

    public final void l() {
        e19.b r0 = this.r;
        if (r0 == null) goto L12;
        Rect r1 = r0.c;
        if (r1 == null) goto L12;
        Integer r2 = Integer.valueOf(r1.width());
        if (r2.intValue() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
    L13:
        this.t = a.a(r2);
        this.v = 0.0f;
        RecyclerView r4 = this.a;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L22;
        r5.width = this.t + this.u;
        r4.setLayoutParams(r5);
        FrameLayout r6 = this.b;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L20;
        r7.width = this.t;
        r6.setLayoutParams(r7);
        a(this.j, false);
        return;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L9:
        r3 = false;
    L12:
        r2 = null;
        goto L13
    }

    public final void i() {
        int r0 = c();
        ViewGroup.LayoutParams r1 = this.b.getLayoutParams();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;
        r2.topMargin = r0;
        r2.gravity = 8388611;
        this.b.setLayoutParams(r2);
    }

    public final void e(e19.b r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        this.r = r3;
        l();
        c r4 = this.s;
        if (r4 == null) goto L12;
        ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == false) goto L7;
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
    L8:
        if (r1 == null) goto L10;
        int r2 = r1.topMargin;
    L11:
        r4.a = c() - r2;
        goto L12
    L10:
        r2 = 0;
        goto L11
    L7:
        r1 = null;
    L12:
        this.a.invalidateItemDecorations();
        i();
    }

    public final boolean f(int r12) {
        OngoingTaskListAdapter r0 = this.g;
        int r1 = 0;
        if (r0 == null) goto L40;
        u r2 = r0.A2(r12);
        if (r2 == null) goto L40;
        String r3 = r2.a;
        String r4 = r2.t;
        String r5 = r2.v;
        String r6 = r2.u;
        TaskType r7 = r2.f;
        if (r7 == null) goto L9;
        Integer r8 = Integer.valueOf(r7.getValue());
    L10:
        String r9 = String.valueOf(r8);
        x r10 = r2.i;
        String r11 = "";
        if (r10 == null) goto L14;
        String r13 = r10.a;
        if (r13 == null) goto L14;
    L15:
        String r14 = r2.c;
        if (r14 == null) goto L19;
        r11 = r14;
    L19:
        OngoingTaskListAdapter r15 = this.g;
        if (r15 == null) goto L22;
        r1 = r12 - (r15.b ? 1 : 0);
    L22:
        Integer r16 = Integer.valueOf(r1 + 1);
        JSONObject r17 = new JSONObject();
        Intrinsics.checkNotNullParameter(r17, "params");
        r17.put("current_page", "multi_task_manage");     // Catch: JSONException -> L36
        if (r3 == null) goto L26;
        r17.put("task_id", r3);     // Catch: JSONException -> L36
    L26:
        if (r4 == null) goto L28;
        r17.put("task_key", r4);     // Catch: JSONException -> L36
    L28:
        if (r5 == null) goto L30;
        r17.put("source_id", r5);     // Catch: JSONException -> L36
    L30:
        if (r6 == null) goto L32;
        r17.put("source_type", r6);     // Catch: JSONException -> L36
    L32:
        r17.put("task_title", r13);     // Catch: JSONException -> L36
        r17.put("task_type", r9);     // Catch: JSONException -> L36
        r17.put("reference_id", r11);     // Catch: JSONException -> L36
        if (r16 == null) goto L38;
        r17.put("index", r16.toString());     // Catch: JSONException -> L36
    L38:
        TrackParams r18 = new TrackParams().merge(r17);
        by7.a r19 = new by7.a("task_float_window_show");
        r19.a.merge(r18);
        r19.b();
        return true;
    L36:
        e = move-exception;
        FLogger.a.e("multitask-MultiTaskManagementEventHelper", "error in multitask-MultiTaskManagementEventHelper mobTaskFloatWindowShow " + e.getLocalizedMessage());
    L14:
        r13 = "";
        goto L15
    L9:
        r8 = null;
    L40:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23 */
    public final void j(float r7) {
        Object r0 = getParent();
        View r2 = null;
        if ((r0 instanceof View) == false) goto L5;
        View r1 = (View) r0;
    L6:
        if (r1 == null) goto L8;
        Float r3 = Float.valueOf(r1.getTranslationX());
    L10:
        if (r7 > 0.0f) goto L13;
        if (r3 == null) goto L13;
        this.v = Math.max(this.v, r3.floatValue());
    L13:
        if (r3 == null) goto L17;
        float r4 = this.v;
        if (r4 <= 0.0f) goto L17;
        float r8 = RangesKt.coerceAtLeast(r4 - r3.floatValue(), 0.0f);
    L18:
        float r5 = b(r8, 0.0f, this.w);
        g(this.c, r5);
        g(this.d, r5);
        g(this.e, b(r8, this.x, this.y));
        g(this.f, b(r8, 0.0f, this.z));
        float r6 = this.A;
        float r9 = this.B;
        float r10 = this.C;
        if (r10 <= 0.0f) goto L22;
        r9 = ((r9 - r6) * RangesKt.coerceIn(r8 / r10, 0.0f, 1.0f)) + r6;
    L22:
        int r11 = (int) r9;
        if (r11 == this.q) goto L35;
        this.q = r11;
        h(this.b, r11);
        OngoingTaskListAdapter r12 = this.g;
        if (r12 == null) goto L27;
        ?? r13 = r12.b;
    L28:
        RecyclerView.LayoutManager r14 = this.a.getLayoutManager();
        if (r14 == null) goto L33;
        View r15 = r14.findViewByPosition(r13);
        if (r15 == null) goto L33;
        r2 = r15.findViewById(2131380406);
    L33:
        h(r2, r11);
        return;
    L27:
        r13 = 0;
        goto L28
    L35:
        return;
    L17:
        r8 = r7 * (this.t + this.u);
        goto L18
    L8:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3, types: [int] */
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
    public final void k(float r7) {
        OngoingTaskListAdapter r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getItemCount() != 0) goto L7;
        return;
    L7:
        int r1 = 0;
        if (r7 != this.p) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        return;
    L13:
        this.p = r7;
        OngoingTaskListAdapter r3 = this.g;
        if (r3 == null) goto L16;
        r3.g = r7;
    L16:
        if (r3 == null) goto L18;
        ?? r4 = r3.b;
    L19:
        int r5 = this.a.getChildCount();
    L20:
        if (r1 >= r5) goto L36;
        RecyclerView r6 = this.a;
        RecyclerView.ViewHolder r8 = r6.getChildViewHolder(r6.getChildAt(r1));
        if ((r8 instanceof OngoingTaskListAdapter.TaskViewHolder) == false) goto L29;
        OngoingTaskListAdapter.TaskViewHolder r9 = (OngoingTaskListAdapter.TaskViewHolder) r8;
        ?? r10 = r9.getAdapterPosition() - r4;
        if (r10 < 0) goto L29;
        OngoingTaskListAdapter r11 = this.g;
        if (r11 == null) goto L29;
        r11.y2(((RecyclerView.ViewHolder) r9).itemView, r10, r7);
    L29:
        r1 = r1 + 1;
        goto L20
    L36:
        return;
    L18:
        r4 = 0;
        goto L19
    L10:
        r2 = false;
        goto L11
    }

    public static void g(View r1, float r2) {
        if (r1.getAlpha() != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        r1.setAlpha(r2);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void h(View r2, int r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        ViewOutlineProvider r0 = r2.getOutlineProvider();
        if ((r0 instanceof d) == false) goto L7;
        d r1 = (d) r0;
    L8:
        if (r1 != null) goto L10;
        r2.setOutlineProvider(new d(r3));
        r2.setClipToOutline(true);
        r2.invalidateOutline();
        return;
    L10:
        if (r1.a == r3) goto L14;
        r1.a = r3;
        r2.invalidateOutline();
        return;
    L14:
        return;
    L7:
        r1 = null;
        goto L8
    }

    public final void a(float r1, boolean r2) {
        this.m = Float.valueOf(r1);
        this.n = r2;
        if (this.o == false) goto L5;
        return;
    L5:
        this.o = true;
        postOnAnimation(new com.larus.business.multitask_management.impl.floatwindow.b(this));
    }

    /* JADX WARN: Type inference failed for: r11v1, types: [android.view.View, android.view.ViewGroup, androidx.recyclerview.widget.RecyclerView, com.larus.business.multitask_management.impl.view.FadeEdgeRecyclerView] */
    public TaskManagementFloatWindowView(Context r26, AttributeSet r27, int r28) {
        Intrinsics.checkNotNullParameter(r26, "context");
        super(r26, r27, r28);
        View r1 = LayoutInflater.from(r26).inflate(2131562965, this, false);
        addView(r1);
        int r2 = 2131380377;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r1, 2131380377);
        if (r3 == null) goto L43;
        r2 = 2131380378;
        View r4 = ViewBindings.findChildViewById(r1, 2131380378);
        if (r4 == null) goto L43;
        r2 = 2131380379;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131380379);
        if (r9 == null) goto L43;
        r2 = 2131380380;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r1, 2131380380);
        if (r5 == null) goto L43;
        r2 = 2131380381;
        View r6 = ViewBindings.findChildViewById(r1, 2131380381);
        if (r6 == null) goto L43;
        FrameLayout r7 = (FrameLayout) r1;
        r2 = 2131380404;
        ?? r11 = (FadeEdgeRecyclerView) ViewBindings.findChildViewById(r1, 2131380404);
        if (r11 == 0) goto L43;
        this.a = r11;
        this.b = r9;
        this.c = r3;
        this.d = r4;
        this.e = r6;
        this.f = r5;
        this.p = Float.NaN;
        this.q = Integer.MIN_VALUE;
        ViewGroup.MarginLayoutParams r10 = null;
        this.t = a.a(null);
        this.u = r26.getResources().getDimensionPixelSize(v19.c.b(2130971163, null, 2131166696));
        int r15 = r26.getResources().getDimensionPixelSize(v19.c.b(2130971299, null, 2131166968));
        this.w = r26.getResources().getDimensionPixelSize(v19.c.b(2130971208, r26, 2131166786));
        this.x = r26.getResources().getDimensionPixelSize(v19.c.b(2130971208, r26, 2131166786));
        this.y = r26.getResources().getDimensionPixelSize(v19.c.b(2130971536, r26, 2131167441));
        this.z = r26.getResources().getDimensionPixelSize(v19.c.b(2130971536, r26, 2131167441));
        this.A = c7.b(12);
        this.B = c7.b(16);
        this.C = r26.getResources().getDimensionPixelSize(v19.c.b(2130971536, r26, 2131167441));
        d r14 = new d(c7.b(12));
        ViewGroup.LayoutParams r0 = r11.getLayoutParams();
        if (r0 == null) goto L41;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L19;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r0;
    L20:
        if (r8 == null) goto L22;
        r8.setMarginStart(r15);
    L22:
        r11.setLayoutParams(r0);
        r11.setLayoutManager(new LinearLayoutManager(getContext()));
        r11.setItemAnimator(null);
        int r12 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        final int r13 = r12 * r12;
        final Ref.FloatRef r16 = new Ref.FloatRef();
        final Ref.FloatRef r17 = new Ref.FloatRef();
        final Ref.BooleanRef r18 = new Ref.BooleanRef();
        final Ref.IntRef r19 = new Ref.IntRef();
        r19.element = -1;
        r11.setOnTouchListener(new i(this, r19, r16, r17, r18, r13));
        OngoingTaskListAdapter r20 = new OngoingTaskListAdapter(CollectionsKt.emptyList(), true, false, Integer.MAX_VALUE, false, new j(this));
        this.g = r20;
        r11.setAdapter(r20);
        ViewGroup.LayoutParams r21 = r11.getLayoutParams();
        if ((r21 instanceof FrameLayout.LayoutParams) == false) goto L25;
        FrameLayout.LayoutParams r22 = (FrameLayout.LayoutParams) r21;
    L26:
        if (r22 == null) goto L28;
        int r23 = r22.topMargin;
    L29:
        c r24 = new c(c() - r23);
        this.s = r24;
        r11.addItemDecoration(r24);
        y6.d(r11, new k(this), new l(this), null, new m(this), 9);
        r14.a = c7.b(12);
        r9.setOutlineProvider(r14);
        r9.setClipToOutline(true);
        ViewGroup.LayoutParams r25 = r9.getLayoutParams();
        if (r25 == null) goto L39;
        if ((r25 instanceof ViewGroup.MarginLayoutParams) == false) goto L34;
        r10 = (ViewGroup.MarginLayoutParams) r25;
    L34:
        if (r10 == null) goto L36;
        r10.setMarginStart(r15);
    L36:
        r9.setLayoutParams(r25);
        int r29 = j0.a;
        r9.setContentDescription(j0.d(2131899761));
        e1.d(r9, new n());
        l();
        post(new f(this));
        i();
        e1.d(this, new g(this));
        setImportantForAccessibility(2);
        setClickable(false);
        return;
    L39:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L28:
        r23 = 0;
        goto L29
    L25:
        r22 = null;
        goto L26
    L19:
        r8 = null;
        goto L20
    L41:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }

    public static float b(float r2, float r3, float r4) {
        if (r4 > r3) goto L6;
        return 0.0f;
    L6:
        return 1.0f - RangesKt.coerceIn((r2 - r3) / (r4 - r3), 0.0f, 1.0f);
    }

    public /* synthetic */ TaskManagementFloatWindowView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
