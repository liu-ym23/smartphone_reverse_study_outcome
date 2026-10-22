package com.obric.assistant.component.task;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.task.TaskStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0017\u0018\u00002\u00020\u0001:\u0001UB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010E\u001a\u00020/H\u0002J\b\u0010F\u001a\u00020/H\u0002J\b\u0010G\u001a\u00020/H\u0002J\u0014\u0010H\u001a\u00020/2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020807J\b\u0010J\u001a\u00020/H\u0002J\u0016\u0010K\u001a\u00020/2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020807H\u0002J\u000e\u0010L\u001a\u00020/2\u0006\u0010M\u001a\u000205J\u0006\u0010N\u001a\u000205J\u0010\u0010R\u001a\u00020/2\u0006\u0010S\u001a\u00020?H\u0016J\b\u0010T\u001a\u00020/H\u0003R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\r\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\r\u001a\u0004\b&\u0010\u0019R\u001b\u0010(\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\r\u001a\u0004\b)\u0010\u0019R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010-\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020807X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010@\u001a\u00020?2\u0006\u0010>\u001a\u00020?@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010O\u001a\u00020?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010B\"\u0004\bQ\u0010D¨\u0006V"}, d2 = {"Lcom/obric/assistant/component/task/TaskPanelView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "rootContainer", "Landroid/view/View;", "getRootContainer", "()Landroid/view/View;", "rootContainer$delegate", "Lkotlin/Lazy;", "collapsedLayout", "getCollapsedLayout", "collapsedLayout$delegate", "expandedRecyclerView", "Lcom/obric/assistant/component/task/TaskPanelRecyclerView;", "getExpandedRecyclerView", "()Lcom/obric/assistant/component/task/TaskPanelRecyclerView;", "expandedRecyclerView$delegate", "ivCollapsedIcon", "Landroid/widget/ImageView;", "getIvCollapsedIcon", "()Landroid/widget/ImageView;", "ivCollapsedIcon$delegate", "tvCollapsedTitle", "Landroid/widget/TextView;", "getTvCollapsedTitle", "()Landroid/widget/TextView;", "tvCollapsedTitle$delegate", "pbCollapsedLoading", "Landroid/widget/ProgressBar;", "getPbCollapsedLoading", "()Landroid/widget/ProgressBar;", "pbCollapsedLoading$delegate", "ivCollapsedDone", "getIvCollapsedDone", "ivCollapsedDone$delegate", "ivExpandArrow", "getIvExpandArrow", "ivExpandArrow$delegate", "adapter", "Lcom/obric/assistant/component/task/TaskAdapter;", "onPanelClickListener", "Lkotlin/Function0;", "", "getOnPanelClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnPanelClickListener", "(Lkotlin/jvm/functions/Function0;)V", "currentState", "Lcom/obric/assistant/component/task/TaskPanelView$State;", "currentTasks", "", "Lcom/obric/assistant/task/TaskEntry;", "currentDisplayedTask", "bottomFadeView", "fadingViewHeight", "", "fadingThreshold", "value", "", "panelCornerRadius", "getPanelCornerRadius", "()F", "setPanelCornerRadius", "(F)V", "handleCollapsedLayoutClick", "setupRecyclerView", "createBottomFadeView", "updateData", "tasks", "updateFadeViewOffset", "updateCollapsedUI", "setMode", "state", "getCurrentState", "zeroThreshold", "getZeroThreshold", "setZeroThreshold", "setAlpha", "alpha", "setupPressEffects", "State", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskPanelView extends FrameLayout {
    public static final /* synthetic */ int s = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final TaskAdapter i;
    public Function0<Unit> j;
    public State k;
    public List<com.obric.assistant.task.b> l;
    public com.obric.assistant.task.b m;
    public View n;
    public final int o;
    public final int p;
    public float q;
    public float r;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/component/task/TaskPanelView$State;", "", "<init>", "(Ljava/lang/String;I)V", "COLLAPSED", "EXPANDED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        public static final State COLLAPSED = null;
        public static final State EXPANDED = null;
        public static final /* synthetic */ State[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<State> getEntries() {
            return b;
        }

        static {
            State r0 = new State("COLLAPSED", 0);
            COLLAPSED = r0;
            State r1 = new State("EXPANDED", 1);
            EXPANDED = r1;
            State[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a extends ViewOutlineProvider {
        public final /* synthetic */ TaskPanelView a;

        public a(TaskPanelView r1) {
            this.a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r8, Outline r9) {
            Intrinsics.checkNotNullParameter(r8, "view");
            Intrinsics.checkNotNullParameter(r9, "outline");
            r9.setRoundRect(0, 0, r8.getWidth(), r8.getHeight(), this.a.getPanelCornerRadius());
        }
    }

    private final View getCollapsedLayout() {
        return (View) this.b.getValue();
    }

    private final TaskPanelRecyclerView getExpandedRecyclerView() {
        return (TaskPanelRecyclerView) this.c.getValue();
    }

    private final ImageView getIvCollapsedDone() {
        return (ImageView) this.g.getValue();
    }

    private final ImageView getIvCollapsedIcon() {
        return (ImageView) this.d.getValue();
    }

    private final ImageView getIvExpandArrow() {
        return (ImageView) this.h.getValue();
    }

    private final ProgressBar getPbCollapsedLoading() {
        return (ProgressBar) this.f.getValue();
    }

    private final View getRootContainer() {
        return (View) this.a.getValue();
    }

    private final TextView getTvCollapsedTitle() {
        return (TextView) this.e.getValue();
    }

    public final void c() {
        View r2 = null;
        if (this.k == State.EXPANDED) goto L10;
        View r0 = this.n;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFadeView");
    L8:
        r2.setVisibility(8);
        return;
    L7:
        r2 = r0;
        goto L8
    L10:
        int r1 = getExpandedRecyclerView().computeVerticalScrollRange();
        float r3 = (r1 - getExpandedRecyclerView().computeVerticalScrollOffset()) - getExpandedRecyclerView().computeVerticalScrollExtent();
        float r4 = this.o;
        float r5 = this.p;
        float r6 = 0.0f;
        if (r3 <= 0.0f) goto L24;
        View r7 = this.n;
        if (r7 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFadeView");
        r7 = null;
    L15:
        r7.setVisibility(0);
        if (r3 >= r5) goto L19;
        r6 = r4 - ((r3 / r5) * r4);
    L19:
        View r8 = this.n;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFadeView");
    L23:
        r2.setTranslationY(r6);
        return;
    L22:
        r2 = r8;
        goto L23
    L24:
        View r9 = this.n;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFadeView");
        r9 = null;
    L27:
        r9.setVisibility(4);
        View r10 = this.n;
        if (r10 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFadeView");
    L31:
        r2.setTranslationY(r4);
        return;
    L30:
        r2 = r10;
        goto L31
    }

    public final State getCurrentState() {
        return this.k;
    }

    public final Function0<Unit> getOnPanelClickListener() {
        return this.j;
    }

    public final float getPanelCornerRadius() {
        return this.q;
    }

    public final float getZeroThreshold() {
        return this.r;
    }

    public TaskPanelView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void b(List<com.obric.assistant.task.b> r12) {
        Intrinsics.checkNotNullParameter(r12, "tasks");
        this.l = r12;
        TaskAdapter r0 = this.i;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r12, "newTasks");
        r0.a = r12;
        r0.notifyDataSetChanged();
        getPbCollapsedLoading().setVisibility(8);
        getIvCollapsedDone().setVisibility(8);
        getIvExpandArrow().setVisibility(8);
        getIvCollapsedIcon().setVisibility(0);
        Object r1 = null;
        this.m = null;
        if ((!r12.isEmpty()) == true) goto L5;
        return;
    L5:
        if (r12.size() != 1) goto L21;
        com.obric.assistant.task.b r13 = (com.obric.assistant.task.b) CollectionsKt.first(r12);
        this.m = r13;
        getTvCollapsedTitle().setText(r13.b);
        if (r13.e == null) goto L9;
        getIvCollapsedIcon().setImageDrawable(r13.e);
    L9:
        TaskStatus r2 = r13.g;
        if (r2 != TaskStatus.COMPLETED) goto L17;
        if (r13.p == false) goto L14;
        int r14 = 2131244513;
    L15:
        getIvCollapsedDone().setImageDrawable(ContextCompat.getDrawable(getContext(), r14));
        getIvCollapsedDone().setVisibility(0);
        return;
    L14:
        r14 = 2131244512;
        goto L15
    L17:
        if (r2 == TaskStatus.PROGRESS) goto L19;
        return;
    L19:
        if (r13.i == true) goto L57;
        getPbCollapsedLoading().setVisibility(0);
        getPbCollapsedLoading().setProgress(r13.h);
        return;
    L57:
        return;
    L21:
        ArrayList r5 = new ArrayList();
        Iterator<T> r3 = r12.iterator();
    L23:
        if (r3.hasNext() == false) goto L27;
        Object r6 = r3.next();
        if (((com.obric.assistant.task.b) r6).k == false) goto L23;
        r5.add(r6);
        goto L23
    L27:
        Iterator r4 = r5.iterator();
        if (r4.hasNext() == false) goto L39;
        r1 = r4.next();
        if (r4.hasNext() == false) goto L39;
        long r7 = ((com.obric.assistant.task.b) r1).q;
    L34:
        Object r8 = r4.next();
        long r9 = ((com.obric.assistant.task.b) r8).q;
        if (r7 >= r9) goto L38;
        r1 = r8;
        r7 = r9;
    L38:
        if (r4.hasNext() == true) goto L34;
    L39:
        com.obric.assistant.task.b r10 = (com.obric.assistant.task.b) r1;
        if (r10 == null) goto L44;
        this.m = r10;
        getTvCollapsedTitle().setText(r10.b);
        if (r10.e == null) goto L45;
        getIvCollapsedIcon().setImageDrawable(r10.e);
    L45:
        getIvExpandArrow().setVisibility(0);
        return;
    L44:
        getTvCollapsedTitle().setText(AppHost.a.getApplication().getString(2131912620, new Object[]{Integer.valueOf(r12.size())}));
        getIvCollapsedIcon().setVisibility(8);
        goto L45
    }

    @Override // android.view.View
    public void setAlpha(float r5) {
        float r0 = 0.0f;
        float r6 = RangesKt.coerceIn(r5, 0.0f, 1.0f);
        float r2 = this.r;
        if (r6 <= r2) goto L6;
        r0 = (r6 - r2) / (1.0f - r2);
    L6:
        super.setAlpha(r0);
    }

    public final void setMode(State r6) {
        Intrinsics.checkNotNullParameter(r6, "state");
        this.k = r6;
        View r1 = null;
        boolean r3 = false;
        if (r6 != State.EXPANDED) goto L16;
        getCollapsedLayout().setVisibility(8);
        getExpandedRecyclerView().setVisibility(0);
        View r7 = this.n;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFadeView");
        r7 = null;
    L8:
        if (r7.getVisibility() != 8) goto L10;
        r3 = true;
    L10:
        if (r3 == false) goto L21;
        View r8 = this.n;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFadeView");
    L15:
        r1.setVisibility(4);
        goto L21
    L14:
        r1 = r8;
    L21:
        c();
        return;
    L16:
        getCollapsedLayout().setVisibility(0);
        getExpandedRecyclerView().setVisibility(8);
        View r9 = this.n;
        if (r9 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFadeView");
    L20:
        r1.setVisibility(8);
        goto L21
    L19:
        r1 = r9;
        goto L20
    }

    public final void setOnPanelClickListener(Function0<Unit> r1) {
        this.j = r1;
    }

    public final void setPanelCornerRadius(float r3) {
        this.q = r3;
        Drawable r0 = getBackground();
        if ((r0 instanceof GradientDrawable) == false) goto L5;
        GradientDrawable r1 = (GradientDrawable) r0;
    L6:
        if (r1 == null) goto L8;
        r1.setCornerRadius(r3);
    L8:
        invalidateOutline();
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setZeroThreshold(float r1) {
        this.r = r1;
    }

    public TaskPanelView(Context r12, AttributeSet r13) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13);
        this.a = LazyKt.lazy(new s(this));
        this.b = LazyKt.lazy(new y(this));
        this.c = LazyKt.lazy(new z(this));
        this.d = LazyKt.lazy(new a0(this));
        this.e = LazyKt.lazy(new b0(this));
        this.f = LazyKt.lazy(new c0(this));
        this.g = LazyKt.lazy(new d0(this));
        this.h = LazyKt.lazy(new e0(this));
        TaskAdapter r1 = new TaskAdapter();
        r1.c = new f0(this);
        this.i = r1;
        this.k = State.COLLAPSED;
        this.l = CollectionsKt.emptyList();
        int r2 = c7.b(59);
        this.o = r2;
        this.p = c7.b(12);
        this.q = j19.c.c(100);
        boolean r5 = true;
        LayoutInflater.from(r12).inflate(2131564033, this, true);
        View r3 = new View(getContext());
        int r6 = -1;
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-1, r2);
        r4.gravity = 80;
        r3.setLayoutParams(r4);
        Drawable r7 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, ContextCompat.getColor(r3.getContext(), 2131103885)});
        r3.setClickable(false);
        r3.setBackground(r7);
        r3.setVisibility(8);
        this.n = r3;
        addView(r3);
        TaskPanelRecyclerView r8 = getExpandedRecyclerView();
        final Context r9 = getContext();
        r8.setLayoutManager(new TaskPanelView$setupRecyclerView$1(this, r9));
        getExpandedRecyclerView().setAdapter(r1);
        getExpandedRecyclerView().addOnScrollListener(new TaskPanelView$setupRecyclerView$2(this));
        getIvExpandArrow().setOnClickListener(new t(this));
        getCollapsedLayout().setOnClickListener(new x(this));
        getRootContainer().setClickable(true);
        Drawable r0 = ContextCompat.getDrawable(r12, 2131244583);
        final GradientDrawable r10 = null;
        if (r0 == null) goto L5;
        Drawable r11 = r0.mutate();
    L7:
        if ((r11 instanceof GradientDrawable) == false) goto L9;
        Drawable r14 = (GradientDrawable) r11;
    L10:
        setElevation(c7.b(6));
        setBackground(r14);
        setClipToOutline(true);
        setOutlineProvider(new a(this));
        final SpringAnimation r15 = new SpringAnimation(this, DynamicAnimation.SCALE_X);
        final SpringAnimation r16 = new SpringAnimation(this, DynamicAnimation.SCALE_Y);
        Drawable r17 = getIvExpandArrow().getBackground();
        if (r17 == null) goto L13;
        Drawable r18 = r17.mutate();
    L15:
        if ((r18 instanceof GradientDrawable) == false) goto L17;
        r10 = (GradientDrawable) r18;
    L17:
        if (r10 == null) goto L21;
        ColorStateList r19 = r10.getColor();
        if (r19 == null) goto L21;
        int r20 = r19.getDefaultColor();
    L22:
        final int r21 = r20;
        if ((getResources().getConfiguration().uiMode & 48) == 32) goto L26;
        r5 = false;
    L26:
        if (r5 == true) goto L29;
        r6 = -16777216;
    L29:
        if (r5 == false) goto L31;
        float r22 = 0.15f;
    L32:
        final int r23 = ColorUtils.blendARGB(r21, r6, r22);
        getIvExpandArrow().setOnTouchListener(new u(r10, r23, r21, this, r15, r16));
        getCollapsedLayout().setOnTouchListener(new v(this, r15, r16));
        this.r = 0.5f;
        return;
    L31:
        r22 = 0.1f;
    L21:
        r20 = ColorProtector.parseColor("#F7F7F7");
        goto L22
    L13:
        r18 = null;
        goto L15
    L9:
        r14 = null;
        goto L10
    L5:
        r11 = null;
        goto L7
    }

    public static final void a(TaskPanelView r2, SpringAnimation r3, SpringAnimation r4, boolean r5) {
        if (r2.k == State.COLLAPSED) goto L5;
        return;
    L5:
        r2.setPivotX(r2.getWidth() / 2.0f);
        r2.setPivotY(r2.getHeight() / 2.0f);
        if (r5 == false) goto L8;
        SpringForce r6 = new SpringForce(0.9f);
        r6.setDampingRatio(1.0f);
        r6.setStiffness(80.0f);
        r3.setSpring(r6);
        SpringForce r7 = new SpringForce(0.9f);
        r7.setDampingRatio(1.0f);
        r7.setStiffness(80.0f);
        r4.setSpring(r7);
    L9:
        r3.start();
        r4.start();
        return;
    L8:
        SpringForce r8 = new SpringForce(1.0f);
        r8.setDampingRatio(0.7f);
        r8.setStiffness(438.0f);
        r3.setSpring(r8);
        SpringForce r9 = new SpringForce(1.0f);
        r9.setDampingRatio(0.7f);
        r9.setStiffness(438.0f);
        r4.setSpring(r9);
        goto L9
    }
}
