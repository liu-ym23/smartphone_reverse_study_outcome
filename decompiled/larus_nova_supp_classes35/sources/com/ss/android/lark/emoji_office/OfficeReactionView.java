package com.ss.android.lark.emoji_office;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import q2c.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 :2\u00020\u0001:\u0002:;B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010'\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$H\u0007J\u0010\u0010(\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010&J\u0016\u0010*\u001a\u00020\u00002\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0+H\u0007J\b\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0007H\u0002J\u0018\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H\u0014J0\u00103\u001a\u00020-2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0007H\u0014R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR'\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000b0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0013\u0010\u000eR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0016\u0010\u000eR\u001b\u0010\u0018\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001d\u0010\u001aR!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b!\u0010\u000eR\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/ss/android/lark/emoji_office/OfficeReactionView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "itemViewPool", BuildConfig.FLAVOR, "Lcom/ss/android/lark/emoji_office/OfficeReactionItemView;", "getItemViewPool", "()Ljava/util/List;", "itemViewPool$delegate", "Lkotlin/Lazy;", "lineViews", "Landroid/view/View;", "getLineViews", "lineViews$delegate", "lineWidths", "getLineWidths", "lineWidths$delegate", "itemHeight", "getItemHeight", "()I", "itemHeight$delegate", "itemSpacing", "getItemSpacing", "itemSpacing$delegate", "dataList", "Lcom/ss/android/lark/reaction/widget/flowlayout/bean/ReactionFlowLayoutViewModel;", "getDataList", "dataList$delegate", "align", "Lcom/ss/android/lark/emoji_office/OfficeReactionView$Align;", "onReactionClickListener", "Lcom/ss/android/lark/emoji_office/OnReactionClickListener;", "setAlign", "setOnReactionClickListener", "listener", "setup", BuildConfig.FLAVOR, "buildViews", BuildConfig.FLAVOR, "ensureItemViews", "requiredCount", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", BuildConfig.FLAVOR, "l", "t", "r", "b", "Companion", "Align", "lark-emoji-office_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeReactionView extends ViewGroup {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Align g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/emoji_office/OfficeReactionView$Align;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "lark-emoji-office_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Align extends Enum<Align> {
        public static final Align LEFT = null;
        public static final Align RIGHT = null;
        public static final /* synthetic */ Align[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Align> getEntries() {
            return b;
        }

        static {
            Align r0 = new Align("LEFT", 0);
            LEFT = r0;
            Align r1 = new Align("RIGHT", 1);
            RIGHT = r1;
            Align[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Align[] values() {
            return (Align[]) a.clone();
        }

        public static Align valueOf(String r1) {
            return (Align) r27.a.a(Align.class, r1);
        }

        public Align(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public OfficeReactionView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OfficeReactionView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final List<c> getDataList() {
        return (List) this.f.getValue();
    }

    private final int getItemHeight() {
        return ((Number) this.d.getValue()).intValue();
    }

    private final int getItemSpacing() {
        return ((Number) this.e.getValue()).intValue();
    }

    private final List<OfficeReactionItemView> getItemViewPool() {
        return (List) this.a.getValue();
    }

    private final List<List<View>> getLineViews() {
        return (List) this.b.getValue();
    }

    private final List<Integer> getLineWidths() {
        return (List) this.c.getValue();
    }

    @Override // android.view.View
    public final void onMeasure(int r11, int r12) {
        getLineViews().clear();
        getLineWidths().clear();
        int r0 = View.MeasureSpec.getSize(r11);
        if (View.MeasureSpec.getMode(r11) != 0) goto L5;
        r0 = Integer.MAX_VALUE;
    L5:
        ArrayList r1 = new ArrayList();
        int r2 = getChildCount();
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L6:
        if (r4 >= r2) goto L20;
        View r7 = getChildAt(r4);
        measureChild(r7, r11, r12);
        int r8 = r7.getMeasuredWidth();
        if (((getItemSpacing() + r5) + r8) <= r0) goto L16;
        if ((!r1.isEmpty()) == false) goto L16;
        getLineViews().add(r1);
        getLineWidths().add(Integer.valueOf(r5));
        if (r6 <= 0) goto L14;
        r6 = r6 + getItemSpacing();
    L14:
        r6 = r6 + getItemHeight();
        r1 = new ArrayList();
        r5 = 0;
    L16:
        if ((!r1.isEmpty()) == false) goto L18;
        r5 = r5 + getItemSpacing();
    L18:
        r5 = r5 + r8;
        r1.add(r7);
        r4 = r4 + 1;
        goto L6
    L20:
        if ((!r1.isEmpty()) == false) goto L25;
        getLineViews().add(r1);
        getLineWidths().add(Integer.valueOf(r5));
        if (r6 <= 0) goto L24;
        r6 = r6 + getItemSpacing();
    L24:
        r6 = r6 + getItemHeight();
    L25:
        Integer r9 = (Integer) CollectionsKt.maxOrNull(getLineWidths());
        if (r9 == null) goto L28;
        r3 = r9.intValue();
    L28:
        setMeasuredDimension(ViewGroup.resolveSize(r3, r11), ViewGroup.resolveSize(r6, r12));
    }

    public OfficeReactionView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(OfficeReactionView$itemViewPool$2.INSTANCE);
        this.b = LazyKt.lazy(OfficeReactionView$lineViews$2.INSTANCE);
        this.c = LazyKt.lazy(OfficeReactionView$lineWidths$2.INSTANCE);
        this.d = LazyKt.lazy(OfficeReactionView$itemHeight$2.INSTANCE);
        this.e = LazyKt.lazy(OfficeReactionView$itemSpacing$2.INSTANCE);
        this.f = LazyKt.lazy(OfficeReactionView$dataList$2.INSTANCE);
        this.g = Align.LEFT;
    }

    public /* synthetic */ OfficeReactionView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        int r11 = getPaddingTop();
        int r12 = getLineViews().size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L13;
        List r14 = (List) ListProtector.get(getLineViews(), r13);
        int r0 = ((Number) ListProtector.get(getLineWidths(), r13)).intValue();
        if (this.g != Align.RIGHT) goto L7;
        int r1 = getWidth() - r0;
    L8:
        Iterator r15 = r14.iterator();
    L10:
        if (r15.hasNext() == false) goto L12;
        View r2 = (View) r15.next();
        int r3 = r2.getMeasuredWidth();
        r2.layout(r1, r11, r1 + r3, getItemHeight() + r11);
        r1 = r1 + (r3 + getItemSpacing());
        goto L10
    L12:
        r11 = r11 + (getItemHeight() + getItemSpacing());
        r13 = r13 + 1;
        goto L3
    L7:
        r1 = 0;
        goto L8
    }
}
