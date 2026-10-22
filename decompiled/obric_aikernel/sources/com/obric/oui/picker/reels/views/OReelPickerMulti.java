package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u0003¢\u0006\u0004\b\"\u0010#J!\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ$\u0010\u000f\u001a\u00020\u000e*\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006$"}, d2 = {"Lcom/obric/oui/picker/reels/views/OReelPickerMulti;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "", "width", "", "weight", "Lcom/obric/oui/picker/reels/views/WheelView;", "addWheelView", "(Ljava/lang/Integer;F)Lcom/obric/oui/picker/reels/views/WheelView;", "Lx9/a;", "reel", "colIndex", "maxColIndex", "", "configure", "onAttachedToWindow", "Landroid/view/View;", "asView", "col", "getReelView", "", "wheelViews", "Ljava/util/List;", "reelsCount", "I", "Landroid/widget/LinearLayout;", "reelsContainer", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OReelPickerMulti extends ConstraintLayout {
    private final LinearLayout reelsContainer;
    private int reelsCount;
    private final List<WheelView> wheelViews;

    @JvmOverloads
    public OReelPickerMulti(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OReelPickerMulti(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OReelPickerMulti(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        LinearLayout r13 = new LinearLayout(r10);
        r13.setId(ViewGroup.generateViewId());
        r13.setOrientation(0);
        r13.setGravity(17);
        r13.setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        Unit r14 = Unit.INSTANCE;
        this.reelsContainer = r13;
        this.wheelViews = new ArrayList();
        addView(r13);
    }

    public /* synthetic */ OReelPickerMulti(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ WheelView access$addWheelView(OReelPickerMulti r10, Integer r11, float r12) {
        return r10.addWheelView(r11, r12);
    }

    public static final /* synthetic */ LinearLayout access$getReelsContainer$p(OReelPickerMulti r10) {
        return r10.reelsContainer;
    }

    public static final /* synthetic */ int access$getReelsCount$p(OReelPickerMulti r10) {
        return r10.reelsCount;
    }

    public static final /* synthetic */ List access$getWheelViews$p(OReelPickerMulti r10) {
        return r10.wheelViews;
    }

    public static final /* synthetic */ void access$setReelsCount$p(OReelPickerMulti r10, int r11) {
        r10.reelsCount = r11;
    }

    private final WheelView addWheelView(Integer r10, float r11) {
        if (r10 == null) goto L5;
        LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams(r10.intValue(), -1);
    L6:
        Context r13 = getContext();
        Intrinsics.checkNotNullExpressionValue(r13, "context");
        WheelView r14 = new WheelView(r13, null, 2, null);
        r14.setLayoutParams(r12);
        r14.setCyclic(false);
        this.reelsContainer.addView(r14);
        this.wheelViews.add(r14);
        return r14;
    L5:
        r12 = new LinearLayout.LayoutParams(-2, -1);
        goto L6
    }

    private final void configure(WheelView r10, x9.a r11, int r12, int r13) {
        r10.setItemCount(5);
        throw null;
    }

    public View asView() {
        return this;
    }

    public void configure(int r10, x9.a r11) {
        Intrinsics.checkNotNullParameter(r11, "reel");
        WheelView r12 = getReelView(r10);
        if (r12 == null) goto L6;
        configure(r12, r11, r10, this.reelsCount - 1);
        return;
    }

    public WheelView getReelView(int r10) {
        return (WheelView) CollectionsKt.getOrNull(this.wheelViews, r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        LinearLayout r10 = this.reelsContainer;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        Objects.requireNonNull(r11, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) r11;
        r12.startToStart = 0;
        r12.endToEnd = 0;
        r12.topToTop = 0;
        r12.bottomToBottom = 0;
        r10.setLayoutParams(r12);
    }
}
