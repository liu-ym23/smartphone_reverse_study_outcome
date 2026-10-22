package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.loc.o;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001=B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ'\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020!H\u0002J\u0018\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020'H\u0016J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010,\u001a\u0004\u0018\u00010\u00192\u0006\u0010%\u001a\u00020\bH\u0016J\b\u0010-\u001a\u00020!H\u0014J\b\u0010.\u001a\u00020!H\u0014J(\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\bH\u0014J\b\u00104\u001a\u00020!H\u0002J\"\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\b2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020)H\u0002J\b\u0010:\u001a\u00020!H\u0002J$\u0010$\u001a\u00020!*\u00020\u00192\u0006\u0010&\u001a\u00020'2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\bH\u0002R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/obric/oui/picker/reels/views/OReelPickerMulti;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/picker/reels/OReelPicker;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultHeightPx", "defaultWidthPx", "observedReferenceViews", "Ljava/util/LinkedHashSet;", "Landroid/view/View;", "Lkotlin/collections/LinkedHashSet;", "percentConfig", "Lcom/obric/oui/picker/reels/views/ReelPickerPercentConfig;", "reelsContainer", "Landroid/widget/LinearLayout;", "reelsCount", "referenceLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "wheelViews", "", "Lcom/obric/oui/picker/reels/views/WheelView;", "addWheelView", "width", "weight", "", "minHeight", "(Ljava/lang/Integer;FI)Lcom/obric/oui/picker/reels/views/WheelView;", "applyPercentBasedLayout", "", "asView", "clearReferenceViewObservers", "configure", "col", "reel", "Lcom/obric/oui/picker/reels/OReelPicker$Reel;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "getReelView", "onAttachedToWindow", "onDetachedFromWindow", "onSizeChanged", "w", o.g, "oldw", "oldh", "refreshReferenceViewObservers", "resolveDimensionPx", "explicitSize", "dimensionSpec", "Lcom/obric/oui/picker/reels/views/PercentDimensionSpec;", "useWidth", "updateWheelMinimumHeight", "colIndex", "maxColIndex", "Builder", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OReelPickerMulti extends ConstraintLayout implements com.obric.oui.picker.reels.a {
    private int defaultHeightPx;
    private int defaultWidthPx;
    private final LinkedHashSet<View> observedReferenceViews;
    private c percentConfig;
    private final LinearLayout reelsContainer;
    private int reelsCount;
    private final View.OnLayoutChangeListener referenceLayoutChangeListener;
    private final List<WheelView> wheelViews;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\nH\u0016J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\"\u0010\u001f\u001a\u00020 *\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0#2\u0006\u0010$\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/oui/picker/reels/views/OReelPickerMulti$Builder;", "Lcom/obric/oui/picker/reels/OReelPicker$Builder;", "()V", "mHeight", "", "mHeightPercentSpec", "Lcom/obric/oui/picker/reels/views/PercentDimensionSpec;", "mPaddingVerticalDp", "mReels", "", "Lcom/obric/oui/picker/reels/OReelPicker$Reel;", "mWidth", "mWidthPercentSpec", "addReel", "reel", "build", "Lcom/obric/oui/picker/reels/OReelPicker;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "setHeight", "height", "setHeightPercentOfParent", "percent", "", "setWidth", "width", "setWidthPercentOfParent", "validatePercent", "setReels", "", "Lcom/obric/oui/picker/reels/views/OReelPickerMulti;", "reels", "", "reelMinHeight", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements com.obric.oui.picker.reels.a.InterfaceC0762a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<com.obric.oui.picker.reels.a.b> f14292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f14293b;
        private int c;
        private int d;
        private com.obric.oui.picker.reels.views.b e;
        private com.obric.oui.picker.reels.views.b f;

        public a() {
            this.f14292a = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            this.f14293b = -1;
            this.c = -1;
            this.d = 16;
        }

        private final void a(OReelPickerMulti r4, List<com.obric.oui.picker.reels.a.b> r5, int r6) {
            List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            OReelPickerMulti.access$setReelsCount$p(r4, r3.size());
            OReelPickerMulti.access$getWheelViews$p(r4).clear();
            OReelPickerMulti.access$getReelsContainer$p(r4).removeAllViews();
            Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            com.obric.oui.picker.reels.a.b r1 = (com.obric.oui.picker.reels.a.b) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.oui.picker.reels.a.b.class, "com.obric.memorydata.plugin");
            OReelPickerMulti.access$addWheelView(r4, r1.e(), r1.d(), r6);
            goto L4
        L6:
            int r8 = 0;
            Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L8:
            if (r9.hasNext() == false) goto L13;
            Object r10 = r9.next();
            int r2 = r8 + 1;
            if (r8 >= 0) goto L12;
            CollectionsKt.throwIndexOverflow();
        L12:
            r4.configure(r8, (com.obric.oui.picker.reels.a.b) ZeusTransformUtils.preCheckCast(r10, com.obric.oui.picker.reels.a.b.class, "com.obric.memorydata.plugin"));
            r8 = r2;
            goto L8
        }

        private final float c(float r2) {
            boolean r0 = false;
            if (0.0f <= r2) goto L5;
        L7:
            if (r0 == false) goto L10;
            return r2;
        L10:
            throw new IllegalArgumentException("percent should be between 0f and 1f".toString());
        L5:
            if (r2 > 1.0f) goto L7;
            r0 = true;
            goto L7
        }

        public com.obric.oui.picker.reels.a.InterfaceC0762a a(com.obric.oui.picker.reels.a.b r2) {
            Intrinsics.checkNotNullParameter(r2, "reel");
            this.f14292a.add(r2);
            return (com.obric.oui.picker.reels.a.InterfaceC0762a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.picker.reels.a.InterfaceC0762a.class, "com.obric.memorydata.plugin");
        }

        public com.obric.oui.picker.reels.a a(Context r5, AttributeSet r6, int r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "context");
            if (this.f14293b != (-1)) goto L6;
            this.f14293b = h.a(r8, 328);
        L6:
            if (this.c != (-1)) goto L8;
            this.c = h.a(r8, 240);
        L8:
            OReelPickerMulti r0 = new OReelPickerMulti(r8, r9, r7);
            OReelPickerMulti.access$setDefaultWidthPx$p(r0, this.f14293b);
            OReelPickerMulti.access$setDefaultHeightPx$p(r0, this.c);
            OReelPickerMulti.access$setPercentConfig$p(r0, new c(this.e, this.f));
            c r10 = OReelPickerMulti.access$getPercentConfig$p(r0);
            boolean r11 = false;
            if (r10 == null) goto L15;
            if (r10.c() != true) goto L15;
            r11 = true;
        L15:
            if (r11 == false) goto L17;
            LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams(-1, -1);
        L18:
            r0.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r12, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
            a(r0, this.f14292a, this.c - (h.a(r8, this.d) * 2));
            return (com.obric.oui.picker.reels.a) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.picker.reels.a.class, "com.obric.memorydata.plugin");
        L17:
            r12 = new LinearLayout.LayoutParams(this.f14293b, this.c);
            goto L18
        }

        public final a a(float r2) {
            this.e = new com.obric.oui.picker.reels.views.b(c(r2));
            return this;
        }

        public final a a(int r1) {
            this.f14293b = r1;
            this.e = null;
            return this;
        }

        public final a b(float r2) {
            this.f = new com.obric.oui.picker.reels.views.b(c(r2));
            return this;
        }

        public final a b(int r1) {
            this.c = r1;
            this.f = null;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/oui/picker/reels/views/OReelPickerMulti$configure$4", "Lcom/obric/oui/picker/reels/views/OnWheelChangedListener;", "onChanged", "", "oldIndex", "", "newIndex", "onStopped", "curIndex", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements com.obric.oui.picker.reels.views.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.oui.picker.reels.a.b f14294a;

        b(com.obric.oui.picker.reels.a.b r1) {
            this.f14294a = r1;
        }

        @Override // com.obric.oui.picker.reels.views.a
        public void a(int r2) {
            com.obric.oui.picker.reels.a.c r0 = this.f14294a.i();
            if (r0 == null) goto L7;
            r0.onReelChanged(this.f14294a.a(), r2);
            return;
        }

        @Override // com.obric.oui.picker.reels.views.a
        public void a(int r1, int r2) {
            com.obric.oui.picker.reels.a.c r3 = this.f14294a.i();
            if (r3 == null) goto L7;
            r3.onReelChanged(this.f14294a.a(), r2);
            return;
        }
    }

    public OReelPickerMulti(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OReelPickerMulti(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OReelPickerMulti(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        LinearLayout r8 = new LinearLayout(r6);
        r8.setId(ConstraintLayout.generateViewId());
        r8.setOrientation(0);
        r8.setGravity(17);
        r8.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ConstraintLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        this.reelsContainer = r8;
        this.wheelViews = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.observedReferenceViews = new LinkedHashSet();
        this.referenceLayoutChangeListener = new $$Lambda$OReelPickerMulti$TZ4JAb96GQ8jyJgWbK6wAilp7wA(this);
        addView((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ OReelPickerMulti(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    public static final /* synthetic */ WheelView access$addWheelView(OReelPickerMulti r0, Integer r1, float r2, int r3) {
        return r0.addWheelView(r1, r2, r3);
    }

    public static final /* synthetic */ c access$getPercentConfig$p(OReelPickerMulti r0) {
        return r0.percentConfig;
    }

    public static final /* synthetic */ LinearLayout access$getReelsContainer$p(OReelPickerMulti r0) {
        return r0.reelsContainer;
    }

    public static final /* synthetic */ List access$getWheelViews$p(OReelPickerMulti r0) {
        return r0.wheelViews;
    }

    public static final /* synthetic */ void access$setDefaultHeightPx$p(OReelPickerMulti r0, int r1) {
        r0.defaultHeightPx = r1;
    }

    public static final /* synthetic */ void access$setDefaultWidthPx$p(OReelPickerMulti r0, int r1) {
        r0.defaultWidthPx = r1;
    }

    public static final /* synthetic */ void access$setPercentConfig$p(OReelPickerMulti r0, c r1) {
        r0.percentConfig = r1;
    }

    public static final /* synthetic */ void access$setReelsCount$p(OReelPickerMulti r0, int r1) {
        r0.reelsCount = r1;
    }

    private final WheelView addWheelView(Integer r10, float r11, int r12) {
        if (r10 == null) goto L5;
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(r10.intValue(), -1);
    L6:
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        WheelView r14 = new WheelView(r3, null, 0, 6, null);
        r14.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r13, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r14.setMinimumHeight(r12);
        r14.setCyclic(false);
        this.reelsContainer.addView((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin"));
        this.wheelViews.add(r14);
        return r14;
    L5:
        r13 = new LinearLayout.LayoutParams(0, -1, r11);
        goto L6
    }

    private final void applyPercentBasedLayout() {
        c r0 = this.percentConfig;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.c() == true) goto L8;
        return;
    L8:
        int r1 = resolveDimensionPx(this.defaultWidthPx, r0.a(), true);
        int r2 = resolveDimensionPx(this.defaultHeightPx, r0.b(), false);
        ViewGroup.LayoutParams r3 = getLayoutParams();
        if (r3 != null) goto L13;
        r3 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
    L11:
        setLayoutParams(r3);
    L17:
        View r4 = (View) ZeusTransformUtils.preCheckCast(this.reelsContainer, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r6 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ConstraintLayout.LayoutParams r7 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r7.width = r1;
        r7.height = r2;
        r4.setLayoutParams(r6);
        updateWheelMinimumHeight();
        return;
    L13:
        if (r3.width == (-1)) goto L15;
    L16:
        r3.width = -1;
        r3.height = -1;
        goto L11
    L15:
        if (r3.height == (-1)) goto L17;
        goto L16
    }

    private final void clearReferenceViewObservers() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.observedReferenceViews, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((View) ZeusTransformUtils.preCheckCast(r0.next(), View.class, "com.obric.memorydata.plugin")).removeOnLayoutChangeListener(this.referenceLayoutChangeListener);
        goto L4
    L6:
        this.observedReferenceViews.clear();
    }

    private final void configure(WheelView r1, com.obric.oui.picker.reels.a.b r2, int r3, int r4) {
        r1.setItemCount(5);
        CharSequence r0 = r2.c();
        if (r0 == null) goto L6;
        r1.setTagText(r0);
    L6:
        Integer r5 = r2.g();
        if (r5 == null) goto L10;
        r1.setTagGap(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue()));
    L10:
        Integer r6 = r2.f();
        if (r6 == null) goto L14;
        r1.setMinimumWidth(((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).intValue());
    L14:
        r1.setOnWheelChangedListener((com.obric.oui.picker.reels.views.a) ZeusTransformUtils.preCheckCast(new b(r2), com.obric.oui.picker.reels.views.a.class, "com.obric.memorydata.plugin"));
        r1.a(r2.b(), RangesKt.coerceIn(r2.h(), 0, RangesKt.coerceAtLeast(r2.b().size() - 1, 0)));
    }

    public static /* synthetic */ void lambda$TZ4JAb96GQ8jyJgWbK6wAilp7wA(OReelPickerMulti r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        m1332referenceLayoutChangeListener$lambda1(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: referenceLayoutChangeListener$lambda-1, reason: not valid java name */
    private static final void m1332referenceLayoutChangeListener$lambda1(OReelPickerMulti r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.applyPercentBasedLayout();
    }

    private final void refreshReferenceViewObservers() {
        LinkedHashSet r0 = new LinkedHashSet();
        c r1 = this.percentConfig;
        if (r1 == null) goto L12;
        com.obric.oui.picker.reels.views.b r2 = r1.a();
        if (r2 == null) goto L12;
        View r3 = r2.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
        if (r3 == null) goto L12;
        r0.add(r3);
    L12:
        c r4 = this.percentConfig;
        if (r4 == null) goto L22;
        com.obric.oui.picker.reels.views.b r5 = r4.b();
        if (r5 == null) goto L22;
        View r6 = r5.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
        if (r6 == null) goto L22;
        r0.add(r6);
    L22:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(SetsKt.minus((Set) ZeusTransformUtils.preCheckCast(this.observedReferenceViews, Set.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L24:
        if (r7.hasNext() == false) goto L26;
        ((View) ZeusTransformUtils.preCheckCast(r7.next(), View.class, "com.obric.memorydata.plugin")).removeOnLayoutChangeListener(this.referenceLayoutChangeListener);
        goto L24
    L26:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(SetsKt.minus((Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(this.observedReferenceViews, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L28:
        if (r8.hasNext() == false) goto L30;
        ((View) ZeusTransformUtils.preCheckCast(r8.next(), View.class, "com.obric.memorydata.plugin")).addOnLayoutChangeListener(this.referenceLayoutChangeListener);
        goto L28
    L30:
        this.observedReferenceViews.clear();
        this.observedReferenceViews.addAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"));
    }

    private final int resolveDimensionPx(int r4, com.obric.oui.picker.reels.views.b r5, boolean r6) {
        int r7 = RangesKt.coerceAtLeast(r4, 0);
        if (r5 != null) goto L5;
        View r3 = null;
    L6:
        if (r3 != null) goto L8;
        int r8 = 0;
    L11:
        if (r5 == null) goto L20;
        if (r8 <= 0) goto L20;
        int r9 = RangesKt.coerceAtLeast((int) (r8 * r5.a()), 0);
        if (r9 > 0) goto L17;
        return r9;
    L17:
        if ((r9 % 2) != 0) goto L19;
        return r9;
    L19:
        return r9 + 1;
    L20:
        return r7;
    L8:
        if (r6 == false) goto L10;
        r8 = r3.getWidth();
        goto L11
    L10:
        r8 = r3.getHeight();
        goto L11
    L5:
        r3 = r5.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
        goto L6
    }

    private final void updateWheelMinimumHeight() {
        ViewGroup.LayoutParams r0 = this.reelsContainer.getLayoutParams();
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        Integer r2 = Integer.valueOf(this.reelsContainer.getHeight());
        boolean r5 = true;
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L9;
        boolean r3 = true;
    L10:
        Integer r6 = null;
        if (r3 == true) goto L14;
        r2 = null;
    L14:
        if (r2 != null) goto L24;
        Integer r4 = Integer.valueOf(r1);
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue() > 0) goto L19;
        r5 = false;
    L19:
        if (r5 == false) goto L21;
        r6 = r4;
    L21:
        if (r6 != null) goto L23;
        int r7 = this.defaultHeightPx;
    L25:
        int r8 = RangesKt.coerceAtLeast((r7 - this.reelsContainer.getPaddingTop()) - this.reelsContainer.getPaddingBottom(), 0);
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(this.wheelViews, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L27:
        if (r9.hasNext() == false) goto L31;
        WheelView r10 = (WheelView) ZeusTransformUtils.preCheckCast(r9.next(), WheelView.class, "com.obric.memorydata.plugin");
        if (r10.getMinimumHeight() == r8) goto L27;
        r10.setMinimumHeight(r8);
        goto L27
    L31:
        return;
    L23:
        r7 = r6.intValue();
        goto L25
    L24:
        r7 = r2.intValue();
        goto L25
    L9:
        r3 = false;
        goto L10
    L5:
        r1 = r0.height;
        goto L6
    }

    @Override // com.obric.oui.picker.reels.a
    public View asView() {
        return (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
    }

    public void configure(int r3, com.obric.oui.picker.reels.a.b r4) {
        Intrinsics.checkNotNullParameter(r4, "reel");
        WheelView r0 = getReelView(r3);
        if (r0 == null) goto L7;
        configure(r0, r4, r3, this.reelsCount - 1);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        if (getAlpha() >= 1.0f) goto L7;
        return true;
    L7:
        return super.dispatchTouchEvent(r3);
    }

    @Override // com.obric.oui.picker.reels.a
    public WheelView getReelView(int r2) {
        return (WheelView) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(this.wheelViews, r2), WheelView.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.reelsContainer, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r2 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r3.startToStart = 0;
        r3.endToEnd = 0;
        r3.topToTop = 0;
        r3.bottomToBottom = 0;
        r0.setLayoutParams(r2);
        refreshReferenceViewObservers();
        applyPercentBasedLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        clearReferenceViewObservers();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        updateWheelMinimumHeight();
    }
}
