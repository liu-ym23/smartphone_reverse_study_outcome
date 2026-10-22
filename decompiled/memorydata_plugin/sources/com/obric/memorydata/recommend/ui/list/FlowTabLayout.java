package com.obric.memorydata.recommend.ui.list;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 T2\u00020\u0001:\u0002TUB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010'J\u000e\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\u0007J\u0006\u0010.\u001a\u00020\u0007J\u0018\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u001cH\u0002J\u0012\u00107\u001a\u00020*2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0007H\u0014J\u0018\u0010;\u001a\u00020*2\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0007H\u0002J\u0018\u0010<\u001a\u00020*2\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0007H\u0002J0\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0007H\u0014J\b\u0010C\u001a\u00020*H\u0002J\b\u0010D\u001a\u00020*H\u0002J\b\u0010E\u001a\u00020*H\u0002J\u000e\u0010F\u001a\u00020*2\u0006\u0010-\u001a\u00020\u0007J\u0006\u0010G\u001a\u00020*J\u0006\u0010H\u001a\u00020*J\u0006\u0010I\u001a\u00020\u0007J\u0010\u0010J\u001a\u0004\u0018\u0001042\u0006\u0010-\u001a\u00020\u0007J$\u0010K\u001a\u00020*2\b\u0010L\u001a\u0004\u0018\u0001042\u0006\u00100\u001a\u00020\u00072\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\u0010\u0010O\u001a\u00020*2\u0006\u00100\u001a\u00020\u0007H\u0016J\u0012\u0010P\u001a\u00020N2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010Q\u001a\u00020NH\u0014J\u0012\u0010P\u001a\u00020N2\b\u0010R\u001a\u0004\u0018\u00010NH\u0014J\u0012\u0010S\u001a\u00020\u001c2\b\u0010R\u001a\u0004\u0018\u00010NH\u0014R$\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u001c@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040303X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\u000703X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020\u000703X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/FlowTabLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", EventBody.KEY_VALUE, "horizontalSpacing", "getHorizontalSpacing", "()I", "setHorizontalSpacing", "(I)V", "verticalSpacing", "getVerticalSpacing", "setVerticalSpacing", "orientation", "getOrientation", "setOrientation", "horizontalGravity", "getHorizontalGravity", "setHorizontalGravity", "verticalGravity", "getVerticalGravity", "setVerticalGravity", "", "singleLine", "getSingleLine", "()Z", "setSingleLine", "(Z)V", "maxLines", "getMaxLines", "setMaxLines", "selectedIndex", "onTabSelectedListener", "Lcom/obric/memorydata/recommend/ui/list/FlowTabLayout$OnTabSelectedListener;", "listenersSetup", "setOnTabSelectedListener", "", "listener", "setSelectedTab", "position", "getSelectedTabPosition", "updateTabStateQuietly", "index", "isSelected", "lineViews", "", "Landroid/view/View;", "lineHeights", "lineWidths", "initAttributes", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "measureHorizontal", "measureVertical", "onLayout", "changed", "l", "t", "r", "b", "layoutHorizontal", "layoutVertical", "setupTabClickListeners", "selectTab", "selectFirstTab", "selectLastTab", "getTabCount", "getTabAt", "addView", "child", TrackerImpl.PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "removeViewAt", "generateLayoutParams", "generateDefaultLayoutParams", "p", "checkLayoutParams", "Companion", "OnTabSelectedListener", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FlowTabLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12647a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12648b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private int h;
    private int i;
    private b j;
    private boolean k;
    private final List<List<View>> l;
    private final List<Integer> m;
    private final List<Integer> n;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/FlowTabLayout$Companion;", "", "<init>", "()V", "TAG", "", "HORIZONTAL", "", "VERTICAL", "HORIZONTAL_GRAVITY_START", "HORIZONTAL_GRAVITY_CENTER", "HORIZONTAL_GRAVITY_END", "VERTICAL_GRAVITY_TOP", "VERTICAL_GRAVITY_CENTER", "VERTICAL_GRAVITY_BOTTOM", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/FlowTabLayout$OnTabSelectedListener;", "", "onTabSelected", "", "position", "", "view", "Landroid/view/View;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface b {
        void a(int r1, View r2);
    }

    static {
        f12647a = new a(null);
    }

    public FlowTabLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public FlowTabLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public FlowTabLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.f = 1;
        this.h = Integer.MAX_VALUE;
        this.l = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.m = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.n = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        a(r7);
    }

    public /* synthetic */ FlowTabLayout(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final void a() {
        int r1 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r2 = getPaddingTop();
        int r3 = this.f;
        int r5 = 2;
        int r7 = 1;
        if (r3 == 1) goto L11;
        if (r3 != 2) goto L17;
        int r4 = CollectionsKt.sumOfInt((Iterable) ZeusTransformUtils.preCheckCast(this.m, Iterable.class, "com.obric.memorydata.plugin"));
        if (this.m.size() <= 1) goto L9;
        int r8 = (this.m.size() - 1) * this.c;
    L10:
        int r9 = ((getHeight() - getPaddingTop()) - getPaddingBottom()) - (r4 + r8);
    L16:
        r2 = r2 + r9;
        goto L17
    L9:
        r8 = 0;
    L17:
        int r6 = ((Collection) ZeusTransformUtils.preCheckCast(this.l, Collection.class, "com.obric.memorydata.plugin")).size();
        int r10 = 0;
    L18:
        if (r10 >= r6) goto L43;
        List r11 = (List) ZeusTransformUtils.preCheckCast(this.l.get(r10), List.class, "com.obric.memorydata.plugin");
        int r12 = ((Number) ZeusTransformUtils.preCheckCast(this.m.get(r10), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r13 = ((Number) ZeusTransformUtils.preCheckCast(this.n.get(r10), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r14 = getPaddingLeft();
        int r15 = this.e;
        if (r15 == r7) goto L24;
        if (r15 == r5) goto L23;
        RunLog.INSTANCE.debug("FlowTabLayout", "Line " + r10 + " START: startLeft=" + r14);
    L26:
        int r16 = ((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).size();
        int r17 = 0;
    L27:
        if (r17 >= r16) goto L39;
        View r18 = (View) ZeusTransformUtils.preCheckCast(r11.get(r17), View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r19, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        int r110 = r18.getMeasuredWidth();
        int r111 = r18.getMeasuredHeight();
        int r21 = r20.leftMargin + r14;
        int r22 = r20.topMargin + r2;
        int r112 = r1;
        int r23 = this.f;
        int r113 = r6;
        if (r23 != 1) goto L31;
        r22 = r22 + ((((r12 - r111) - r20.topMargin) - r20.bottomMargin) / 2);
    L35:
        r18.layout(r21, r22, r21 + r110, r22 + r111);
        r14 = r14 + ((r110 + r20.leftMargin) + r20.rightMargin);
        if (r17 >= (r11.size() - 1)) goto L38;
        r14 = r14 + this.f12648b;
    L38:
        r17 = r17 + 1;
        r1 = r112;
        r6 = r113;
        goto L27
    L31:
        if (r23 != 2) goto L35;
        r22 = r22 + (((r12 - r111) - r20.topMargin) - r20.bottomMargin);
        goto L35
    L39:
        int r114 = r1;
        int r115 = r6;
        r2 = r2 + r12;
        if (r10 >= (this.l.size() - 1)) goto L42;
        r2 = r2 + this.c;
    L42:
        r10 = r10 + 1;
        r7 = 1;
        r1 = r114;
        r6 = r115;
        r5 = 2;
        goto L18
    L23:
        int r116 = r1 - r13;
    L25:
        r14 = r14 + r116;
        goto L26
    L24:
        r116 = (r1 - r13) / r5;
        goto L25
    L43:
        return;
    L11:
        int r24 = CollectionsKt.sumOfInt((Iterable) ZeusTransformUtils.preCheckCast(this.m, Iterable.class, "com.obric.memorydata.plugin"));
        if (this.m.size() <= 1) goto L14;
        int r25 = (this.m.size() - 1) * this.c;
    L15:
        r9 = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - (r24 + r25)) / 2;
        goto L16
    L14:
        r25 = 0;
        goto L15
    }

    private final void a(int r24, int r25) {
        int r7 = View.MeasureSpec.getMode(r24);
        int r8 = View.MeasureSpec.getSize(r24);
        int r9 = View.MeasureSpec.getMode(r25);
        int r10 = View.MeasureSpec.getSize(r25);
        this.l.clear();
        this.m.clear();
        this.n.clear();
        List<View> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r12 = (r8 - getPaddingLeft()) - getPaddingRight();
        int r13 = getChildCount();
        List<View> r15 = r0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r16 = 0;
        int r17 = 0;
    L3:
        if (r5 >= r13) goto L43;
        View r1 = getChildAt(r5);
        Intrinsics.checkNotNull(r1);
        if (r1.getVisibility() != 8) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L42;
        int r21 = r3;
        int r22 = r4;
        measureChildWithMargins(r1, r24, 0, r25, 0);
        ViewGroup.LayoutParams r6 = r1.getLayoutParams();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        int r14 = (r1.getMeasuredWidth() + r11.leftMargin) + r11.rightMargin;
        int r18 = (r1.getMeasuredHeight() + r11.topMargin) + r11.bottomMargin;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L13;
        int r19 = this.f12648b;
    L15:
        if (this.g == true) goto L23;
        int r20 = r22;
        if (((r20 + r14) + r19) > r12) goto L19;
    L24:
        boolean r23 = false;
    L25:
        if (r23 == false) goto L31;
        this.l.add(r15);
        this.m.add(Integer.valueOf(r17));
        this.n.add(Integer.valueOf(r20));
        int r26 = Math.max(r21, r20);
        if (this.l.size() <= 1) goto L29;
        int r27 = this.c;
    L30:
        r16 = r16 + (r17 + r27);
        r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r4 = 0;
        r3 = r26;
        int r28 = 0;
    L33:
        if (this.l.size() >= this.h) goto L35;
    L37:
        r15.add(r1);
        if (r15.size() <= 1) goto L40;
        int r29 = this.f12648b;
    L41:
        r4 = r4 + (r14 + r29);
        r17 = Math.max(r28, r18);
        goto L42
    L40:
        r29 = 0;
        goto L41
    L35:
        if (r15.isEmpty() == false) goto L37;
        r17 = r28;
    L45:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L51;
        this.l.add(r15);
        this.m.add(Integer.valueOf(r17));
        this.n.add(Integer.valueOf(r4));
        r3 = Math.max(r3, r4);
        if (this.l.size() <= 1) goto L49;
        int r110 = this.c;
    L50:
        r16 = r16 + (r17 + r110);
        goto L51
    L49:
        r110 = 0;
    L51:
        int r30 = r3 + (getPaddingLeft() + getPaddingRight());
        int r111 = r16 + (getPaddingTop() + getPaddingBottom());
        if (r7 == 1073741824) goto L55;
        r8 = r30;
    L55:
        if (r9 == 1073741824) goto L58;
        r10 = r111;
    L58:
        setMeasuredDimension(r8, r10);
        return;
    L29:
        r27 = 0;
        goto L30
    L31:
        r4 = r20;
        r3 = r21;
        r28 = r17;
        goto L33
    L19:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L24;
        if (this.l.size() >= this.h) goto L24;
        r23 = true;
        goto L25
    L23:
        r20 = r22;
        goto L24
    L13:
        r19 = 0;
    L42:
        r5 = r5 + 1;
        goto L3
    L7:
        r2 = false;
        goto L8
    L43:
        r3 = r3;
        goto L45
    }

    private final void a(int r2, boolean r3) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        if (r2 >= getChildCount()) goto L10;
        View r1 = getChildAt(r2);
        if (r1.isSelected() == r3) goto L11;
        r1.setSelected(r3);
        r1.invalidate();
        return;
    L11:
        return;
    }

    private final void a(AttributeSet r5) {
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L10;
        TypedArray r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r6, R.styleable.FlowTabLayout);
        Intrinsics.checkNotNullExpressionValue(r7, "obtainStyledAttributes(...)");
        setHorizontalSpacing(r7.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.FlowTabLayout_horizontalSpacing, "styleable", "FlowTabLayout_horizontalSpacing"), 0));     // Catch: Throwable -> L7
        setVerticalSpacing(r7.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.FlowTabLayout_verticalSpacing, "styleable", "FlowTabLayout_verticalSpacing"), 0));     // Catch: Throwable -> L7
        setOrientation(r7.getInt(ZeusTransformUtils.mapRes(R.styleable.FlowTabLayout_flowOrientation, "styleable", "FlowTabLayout_flowOrientation"), 0));     // Catch: Throwable -> L7
        setHorizontalGravity(r7.getInt(ZeusTransformUtils.mapRes(R.styleable.FlowTabLayout_horizontalGravity, "styleable", "FlowTabLayout_horizontalGravity"), 0));     // Catch: Throwable -> L7
        setVerticalGravity(r7.getInt(ZeusTransformUtils.mapRes(R.styleable.FlowTabLayout_verticalGravity, "styleable", "FlowTabLayout_verticalGravity"), 1));     // Catch: Throwable -> L7
        r7.recycle();
        return;
    L7:
        th = move-exception;
        r7.recycle();
        throw th;
    }

    private static final void a(FlowTabLayout r0, int r1, View r2) {
        r0.setSelectedTab(r1);
    }

    private final void b() {
        int r1 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r2 = getPaddingLeft();
        int r3 = this.e;
        int r5 = 2;
        int r7 = 1;
        if (r3 == 1) goto L11;
        if (r3 != 2) goto L17;
        int r4 = CollectionsKt.sumOfInt((Iterable) ZeusTransformUtils.preCheckCast(this.n, Iterable.class, "com.obric.memorydata.plugin"));
        if (this.n.size() <= 1) goto L9;
        int r8 = (this.n.size() - 1) * this.f12648b;
    L10:
        int r9 = ((getWidth() - getPaddingLeft()) - getPaddingRight()) - (r4 + r8);
    L16:
        r2 = r2 + r9;
        goto L17
    L9:
        r8 = 0;
    L17:
        int r6 = ((Collection) ZeusTransformUtils.preCheckCast(this.l, Collection.class, "com.obric.memorydata.plugin")).size();
        int r10 = 0;
    L18:
        if (r10 >= r6) goto L43;
        List r11 = (List) ZeusTransformUtils.preCheckCast(this.l.get(r10), List.class, "com.obric.memorydata.plugin");
        int r12 = ((Number) ZeusTransformUtils.preCheckCast(this.m.get(r10), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r13 = ((Number) ZeusTransformUtils.preCheckCast(this.n.get(r10), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r14 = getPaddingTop();
        int r15 = this.f;
        if (r15 == r7) goto L24;
        if (r15 != r5) goto L26;
        int r16 = r1 - r12;
    L25:
        r14 = r14 + r16;
    L26:
        int r17 = ((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).size();
        int r18 = 0;
    L27:
        if (r18 >= r17) goto L39;
        View r19 = (View) ZeusTransformUtils.preCheckCast(r11.get(r18), View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r110 = r19.getLayoutParams();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r110, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        int r111 = r19.getMeasuredWidth();
        int r112 = r19.getMeasuredHeight();
        int r21 = r20.leftMargin + r2;
        int r22 = r20.topMargin + r14;
        int r113 = r1;
        int r23 = this.e;
        int r114 = r6;
        if (r23 == 1) goto L34;
        int r24 = 2;
        if (r23 != 2) goto L35;
        r21 = r21 + (((r13 - r111) - r20.leftMargin) - r20.rightMargin);
        r24 = 2;
    L35:
        r19.layout(r21, r22, r111 + r21, r22 + r112);
        r14 = r14 + ((r112 + r20.topMargin) + r20.bottomMargin);
        if (r18 >= (r11.size() - 1)) goto L38;
        r14 = r14 + this.c;
    L38:
        r18 = r18 + 1;
        r5 = r24;
        r1 = r113;
        r6 = r114;
        goto L27
    L34:
        r24 = 2;
        r21 = r21 + ((((r13 - r111) - r20.leftMargin) - r20.rightMargin) / 2);
        goto L35
    L39:
        int r115 = r1;
        int r116 = r6;
        int r25 = r5;
        r2 = r2 + r13;
        if (r10 >= (this.l.size() - 1)) goto L42;
        r2 = r2 + this.f12648b;
    L42:
        r10 = r10 + 1;
        r5 = r25;
        r7 = 1;
        r1 = r115;
        r6 = r116;
        goto L18
    L24:
        r16 = (r1 - r12) / r5;
        goto L25
    L43:
        return;
    L11:
        int r26 = CollectionsKt.sumOfInt((Iterable) ZeusTransformUtils.preCheckCast(this.n, Iterable.class, "com.obric.memorydata.plugin"));
        if (this.n.size() <= 1) goto L14;
        int r27 = (this.n.size() - 1) * this.f12648b;
    L15:
        r9 = (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (r26 + r27)) / 2;
        goto L16
    L14:
        r27 = 0;
        goto L15
    }

    private final void b(int r24, int r25) {
        int r7 = View.MeasureSpec.getMode(r24);
        int r8 = View.MeasureSpec.getSize(r24);
        int r9 = View.MeasureSpec.getMode(r25);
        int r10 = View.MeasureSpec.getSize(r25);
        this.l.clear();
        this.m.clear();
        this.n.clear();
        List<View> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r12 = (r10 - getPaddingTop()) - getPaddingBottom();
        int r13 = getChildCount();
        List<View> r15 = r0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r16 = 0;
        int r17 = 0;
    L3:
        if (r5 >= r13) goto L43;
        View r1 = getChildAt(r5);
        Intrinsics.checkNotNull(r1);
        if (r1.getVisibility() != 8) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L42;
        int r21 = r3;
        int r22 = r4;
        measureChildWithMargins(r1, r24, 0, r25, 0);
        ViewGroup.LayoutParams r6 = r1.getLayoutParams();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        int r14 = (r1.getMeasuredWidth() + r11.leftMargin) + r11.rightMargin;
        int r18 = (r1.getMeasuredHeight() + r11.topMargin) + r11.bottomMargin;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L13;
        int r19 = this.c;
    L15:
        if (this.g == true) goto L23;
        int r20 = r22;
        if (((r20 + r18) + r19) > r12) goto L19;
    L24:
        boolean r23 = false;
    L25:
        if (r23 == false) goto L31;
        this.l.add(r15);
        this.m.add(Integer.valueOf(r20));
        this.n.add(Integer.valueOf(r17));
        if (this.l.size() <= 1) goto L29;
        int r26 = this.f12648b;
    L30:
        r16 = r16 + (r17 + r26);
        int r27 = Math.max(r21, r20);
        r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r4 = 0;
        r3 = r27;
        int r28 = 0;
    L33:
        if (this.l.size() >= this.h) goto L35;
    L37:
        r15.add(r1);
        if (r15.size() <= 1) goto L40;
        int r29 = this.c;
    L41:
        r4 = r4 + (r18 + r29);
        r17 = Math.max(r28, r14);
        goto L42
    L40:
        r29 = 0;
        goto L41
    L35:
        if (r15.isEmpty() == false) goto L37;
        r17 = r28;
    L45:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L51;
        this.l.add(r15);
        this.m.add(Integer.valueOf(r4));
        this.n.add(Integer.valueOf(r17));
        if (this.l.size() <= 1) goto L49;
        int r110 = this.f12648b;
    L50:
        r16 = r16 + (r17 + r110);
        r3 = Math.max(r3, r4);
        goto L51
    L49:
        r110 = 0;
    L51:
        int r111 = r16 + (getPaddingLeft() + getPaddingRight());
        int r30 = r3 + (getPaddingTop() + getPaddingBottom());
        if (r7 == 1073741824) goto L55;
        r8 = r111;
    L55:
        if (r9 == 1073741824) goto L58;
        r10 = r30;
    L58:
        setMeasuredDimension(r8, r10);
        return;
    L29:
        r26 = 0;
        goto L30
    L31:
        r4 = r20;
        r3 = r21;
        r28 = r17;
        goto L33
    L19:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L24;
        if (this.l.size() >= this.h) goto L24;
        r23 = true;
        goto L25
    L23:
        r20 = r22;
        goto L24
    L13:
        r19 = 0;
    L42:
        r5 = r5 + 1;
        goto L3
    L7:
        r2 = false;
        goto L8
    L43:
        r3 = r3;
        goto L45
    }

    private final void c() {
        int r0 = getChildCount();
        final int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        View r3 = getChildAt(r2);
        r3.setOnClickListener(new $$Lambda$FlowTabLayout$1TqKfOYGuDC_Qaz0qALH4HwdTM(this, r2));
        boolean r4 = true;
        r3.setClickable(true);
        if (r2 == this.i) goto L8;
        r4 = false;
    L8:
        r3.setSelected(r4);
        r2 = r2 + 1;
        goto L3
    }

    /* JADX INFO: renamed from: lambda$1TqKfOYGuDC_Qaz0qALH4-HwdTM, reason: not valid java name */
    public static /* synthetic */ void m1143lambda$1TqKfOYGuDC_Qaz0qALH4HwdTM(FlowTabLayout r0, int r1, View r2) {
        a(r0, r1, r2);
    }

    public final void a(int r1) {
        setSelectedTab(r1);
    }

    @Override // android.view.ViewGroup
    public void addView(View r1, int r2, ViewGroup.LayoutParams r3) {
        super.addView(r1, r2, r3);
        this.k = false;
        if (getChildCount() != 1) goto L6;
        this.i = 0;
        return;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return ZeusTransformUtils.instanceOf(r1, ViewGroup.MarginLayoutParams.class);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        return (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        return (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams(r2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
    }

    public final int getHorizontalGravity() {
        return this.e;
    }

    public final int getHorizontalSpacing() {
        return this.f12648b;
    }

    public final int getMaxLines() {
        return this.h;
    }

    public final int getOrientation() {
        return this.d;
    }

    public final int getSelectedTabPosition() {
        return this.i;
    }

    public final boolean getSingleLine() {
        return this.g;
    }

    public final int getTabCount() {
        return getChildCount();
    }

    public final int getVerticalGravity() {
        return this.f;
    }

    public final int getVerticalSpacing() {
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        if (this.d != 0) goto L5;
        a();
    L7:
        if (this.k == true) goto L10;
        c();
        this.k = true;
        return;
    L10:
        return;
    L5:
        b();
        goto L7
    }

    @Override // android.view.View
    public void onMeasure(int r2, int r3) {
        if (this.d != 0) goto L5;
        a(r2, r3);
        return;
    L5:
        b(r2, r3);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int r4) {
        if (r4 == this.i) goto L5;
    L9:
        int r0 = this.i;
        if (r4 >= r0) goto L13;
        int r1 = r0 - 1;
    L12:
        this.i = r1;
    L13:
        super.removeViewAt(r4);
        this.k = false;
        return;
    L5:
        if (getChildCount() <= 1) goto L9;
        if (r4 <= 0) goto L8;
        r1 = r4 - 1;
        goto L12
    L8:
        r1 = 0;
        goto L12
    }

    public final void setHorizontalGravity(int r1) {
        this.e = r1;
        requestLayout();
    }

    public final void setHorizontalSpacing(int r1) {
        this.f12648b = r1;
        requestLayout();
    }

    public final void setMaxLines(int r2) {
        this.h = Math.max(1, r2);
        requestLayout();
    }

    public final void setOnTabSelectedListener(b r3) {
        this.j = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }

    public final void setOrientation(int r1) {
        this.d = r1;
        requestLayout();
    }

    public final void setSelectedTab(int r3) {
        if (r3 >= 0) goto L4;
        return;
    L4:
        if (r3 >= getChildCount()) goto L12;
        int r0 = this.i;
        if (r3 == r0) goto L13;
        this.i = r3;
        a(r0, false);
        a(this.i, true);
        b r4 = this.j;
        if (r4 == null) goto L14;
        int r1 = this.i;
        View r2 = getChildAt(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "getChildAt(...)");
        r4.a(r1, r2);
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void setSingleLine(boolean r1) {
        this.g = r1;
        requestLayout();
    }

    public final void setVerticalGravity(int r1) {
        this.f = r1;
        requestLayout();
    }

    public final void setVerticalSpacing(int r1) {
        this.c = r1;
        requestLayout();
    }
}
