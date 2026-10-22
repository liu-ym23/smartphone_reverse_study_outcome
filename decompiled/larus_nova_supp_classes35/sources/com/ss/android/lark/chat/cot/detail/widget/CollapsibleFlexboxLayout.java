package com.ss.android.lark.chat.cot.detail.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.flexbox.FlexboxLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0016\u0018\u0000 X2\u00020\u0001:\u0002XYB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010<\u001a\u00020#2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0014J0\u0010?\u001a\u00020#2\u0006\u0010@\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0014J\u0006\u0010E\u001a\u00020#J(\u0010F\u001a\u00020#2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010H\u001a\u00020\u00072\b\u0010I\u001a\u0004\u0018\u00010;H\u0002J\u001e\u0010J\u001a\u00020;2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010H\u001a\u00020\u0007H\u0002J\u001e\u0010K\u001a\u00020#2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010H\u001a\u00020\u0007H\u0002J\u001c\u0010L\u001a\u00020#2\u0012\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0*H\u0002J\u001e\u0010N\u001a\u00020\u00072\f\u0010K\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010H\u001a\u00020\u0007H\u0002J\u001e\u0010O\u001a\u00020\u00072\f\u0010K\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010H\u001a\u00020\u0007H\u0002J\u001c\u0010P\u001a\u00020\u00072\u0012\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0*H\u0002J&\u0010Q\u001a\u00020\u00102\f\u0010R\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010S\u001a\u00020+2\u0006\u0010H\u001a\u00020\u0007H\u0002J\u001e\u0010T\u001a\u00020#2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010H\u001a\u00020\u0007H\u0002J\b\u0010U\u001a\u00020#H\u0002J\b\u0010V\u001a\u00020#H\u0002J\u000e\u0010W\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002R$\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\u001a\u0010\u001b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000fR7\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'RR\u0010(\u001a:\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020+0*¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020-\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b4\u00105R\u000e\u00108\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/ss/android/lark/chat/cot/detail/widget/CollapsibleFlexboxLayout;", "Lcom/google/android/flexbox/FlexboxLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "collapsedMaxLines", "getCollapsedMaxLines", "()I", "setCollapsedMaxLines", "(I)V", BuildConfig.FLAVOR, "isExpanded", "()Z", "setExpanded", "(Z)V", "showCollapseButtonWhenExpanded", "getShowCollapseButtonWhenExpanded", "setShowCollapseButtonWhenExpanded", "itemHorizontalSpacing", "getItemHorizontalSpacing", "setItemHorizontalSpacing", "itemVerticalSpacing", "getItemVerticalSpacing", "setItemVerticalSpacing", "onFoldButtonClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", IPortraitService.NAME, "isExpand", BuildConfig.FLAVOR, "getOnFoldButtonClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnFoldButtonClickListener", "(Lkotlin/jvm/functions/Function1;)V", "foldButtonConfigProvider", "Lkotlin/Function2;", BuildConfig.FLAVOR, "Landroid/view/View;", "hiddenChildren", "Lcom/ss/android/lark/chat/cot/detail/widget/FoldButtonConfig;", "getFoldButtonConfigProvider", "()Lkotlin/jvm/functions/Function2;", "setFoldButtonConfigProvider", "(Lkotlin/jvm/functions/Function2;)V", "foldButton", "Lcom/ss/android/lark/chat/cot/detail/widget/MultiIconFoldButton;", "getFoldButton", "()Lcom/ss/android/lark/chat/cot/detail/widget/MultiIconFoldButton;", "foldButton$delegate", "Lkotlin/Lazy;", "lastMeasureWidth", "lastShouldShowFoldButton", "lastCollapsedLayoutResult", "Lcom/ss/android/lark/chat/cot/detail/widget/CollapsibleFlexboxLayout$CollapsedLayoutResult;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "left", "top", "right", "bottom", "removeFoldButton", "layoutCollapsedChildren", "normalChildren", "availableWidth", "measuredResult", "buildCollapsedLayout", "layoutChildren", "layoutLines", "lines", "calculateContentHeight", "calculateLineCount", "calculateLinesHeight", "canAppendToLine", "line", "child", "updateFoldButton", "showFoldButton", "clearLayoutCache", "getNormalChildren", "Companion", "CollapsedLayoutResult", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CollapsibleFlexboxLayout extends FlexboxLayout {
    public boolean A;
    public a B;
    public int r;
    public boolean s;
    public boolean t;
    public int u;
    public int v;
    public Function1<? super Boolean, Unit> w;
    public Function2<? super List<? extends View>, ? super Boolean, com.ss.android.lark.chat.cot.detail.widget.b> x;
    public final Lazy y;
    public int z;

    public static final class a {
        public final List<List<View>> a;
        public final List<View> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "CollapsedLayoutResult(lines=" + this.a + ", hiddenChildren=" + this.b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends List<? extends View>> r2, List<? extends View> r3) {
            Intrinsics.checkNotNullParameter(r2, "lines");
            Intrinsics.checkNotNullParameter(r3, "hiddenChildren");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
    }

    static {
    }

    public CollapsibleFlexboxLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CollapsibleFlexboxLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final MultiIconFoldButton getFoldButton() {
        return (MultiIconFoldButton) this.y.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<View> getNormalChildren() {
        return SequencesKt.toList(SequencesKt.filter(ViewGroupKt.getChildren(this), new AnonymousClass1(this)));
    }

    public final int getCollapsedMaxLines() {
        return this.r;
    }

    public final Function2<List<? extends View>, Boolean, com.ss.android.lark.chat.cot.detail.widget.b> getFoldButtonConfigProvider() {
        return this.x;
    }

    public final int getItemHorizontalSpacing() {
        return this.u;
    }

    public final int getItemVerticalSpacing() {
        return this.v;
    }

    public final Function1<Boolean, Unit> getOnFoldButtonClickListener() {
        return this.w;
    }

    public final boolean getShowCollapseButtonWhenExpanded() {
        return this.t;
    }

    public static final /* synthetic */ MultiIconFoldButton v(CollapsibleFlexboxLayout r0) {
        return r0.getFoldButton();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCollapsedMaxLines(int r2) {
        this.r = Math.max(1, r2);
        this.z = -1;
        this.A = false;
        this.B = null;
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setExpanded(boolean r1) {
        this.s = r1;
        this.z = -1;
        this.A = false;
        this.B = null;
        requestLayout();
    }

    public final void setFoldButtonConfigProvider(Function2<? super List<? extends View>, ? super Boolean, com.ss.android.lark.chat.cot.detail.widget.b> r1) {
        this.x = r1;
    }

    public final void setItemHorizontalSpacing(int r1) {
        this.u = r1;
    }

    public final void setItemVerticalSpacing(int r1) {
        this.v = r1;
    }

    public final void setOnFoldButtonClickListener(Function1<? super Boolean, Unit> r1) {
        this.w = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setShowCollapseButtonWhenExpanded(boolean r1) {
        this.t = r1;
        requestLayout();
    }

    public final void A(List<? extends View> r3, int r4) {
        Function2<? super List<? extends View>, ? super Boolean, com.ss.android.lark.chat.cot.detail.widget.b> r0 = this.x;
        if (r0 == null) goto L6;
        com.ss.android.lark.chat.cot.detail.widget.b r5 = (com.ss.android.lark.chat.cot.detail.widget.b) r0.invoke(r3, Boolean.valueOf(this.s));
        if (r5 == null) goto L6;
    L7:
        getFoldButton().setText(r5.a);
        getFoldButton().setIcons(r5.b);
        getFoldButton().measure(View.MeasureSpec.makeMeasureSpec(r4, PluginList.LEVEL_NOT_SET), View.MeasureSpec.makeMeasureSpec(0, 0));
        return;
    L6:
        com.ss.android.lark.chat.cot.detail.widget.b r6 = com.ss.android.lark.chat.cot.detail.widget.b.c;
        r5 = com.ss.android.lark.chat.cot.detail.widget.b.c;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r11, int r12) {
        int r0 = View.MeasureSpec.getSize(r11);
        int r1 = RangesKt.coerceAtLeast((r0 - getPaddingLeft()) - getPaddingRight(), 0);
        List<View> r3 = getNormalChildren();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        View r5 = (View) r4.next();
        r5.setVisibility(0);
        measureChild(r5, r11, r12);
        goto L4
    L7:
        if (y(r3, r1) <= this.r) goto L9;
        boolean r6 = true;
    L10:
        this.z = r1;
        this.A = r6;
        this.B = null;
        if (r6 == true) goto L14;
        getFoldButton().setVisibility(8);
        setMeasuredDimension(ViewGroup.resolveSize(r0, r11), ViewGroup.resolveSize(x(r3, r1), r12));
        return;
    L14:
        getFoldButton().setVisibility(0);
        A(CollectionsKt.emptyList(), r1);
        getFoldButton().measure(View.MeasureSpec.makeMeasureSpec(r1, PluginList.LEVEL_NOT_SET), View.MeasureSpec.makeMeasureSpec(0, 0));
        if (this.s == true) goto L17;
        a r2 = w(r3, r1);
        this.B = r2;
        List<List<View>> r7 = r2.a;
        if (r7.isEmpty() == false) goto L23;
        int r8 = getPaddingTop() + getPaddingBottom();
    L46:
        setMeasuredDimension(ViewGroup.resolveSize(r0, r11), ViewGroup.resolveSize(r8, r12));
        return;
    L23:
        int r9 = getPaddingTop() + getPaddingBottom();
        Iterator<T> r10 = r7.iterator();
        int r13 = 0;
    L25:
        if (r10.hasNext() == false) goto L45;
        Object r14 = r10.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();
    L29:
        List r16 = (List) r14;
        if (r13 <= 0) goto L32;
        r9 = r9 + this.v;
    L32:
        Iterator r17 = r16.iterator();
        if (r17.hasNext() == true) goto L35;
        Integer r18 = null;
    L41:
        if (r18 == null) goto L43;
        int r19 = r18.intValue();
    L44:
        r9 = r9 + r19;
        r13 = r15;
        goto L25
    L43:
        r19 = 0;
        goto L44
    L35:
        r18 = Integer.valueOf(((View) r17.next()).getMeasuredHeight());
    L37:
        if (r17.hasNext() == false) goto L41;
        Integer r20 = Integer.valueOf(((View) r17.next()).getMeasuredHeight());
        if (r18.compareTo(r20) >= 0) goto L37;
        r18 = r20;
        goto L37
    L45:
        r8 = r9;
        goto L46
    L17:
        if (this.t == false) goto L19;
        r3 = CollectionsKt.plus(r3, getFoldButton());
    L19:
        r8 = x(r3, r1);
        goto L46
    L9:
        r6 = false;
        goto L10
    }

    public final a w(List<? extends View> r13, int r14) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r13.iterator();
        boolean r5 = false;
        int r6 = 0;
    L4:
        if (r3.hasNext() == false) goto L21;
        View r7 = (View) r3.next();
        if (r5 == true) goto L7;
        int r9 = Math.min(r7.getMeasuredWidth(), r14);
        if (r6 > 0) goto L11;
    L13:
        boolean r10 = false;
    L14:
        if (r10 == false) goto L19;
        r0.add(r2);
        if (r0.size() >= this.r) goto L17;
        r2 = new ArrayList();
        r6 = 0;
        goto L19
    L17:
        r1.add(r7);
        r5 = true;
    L19:
        r2.add(r7);
        r6 = r6 + (r9 + this.u);
        goto L4
    L11:
        if ((r6 + r9) <= r14) goto L13;
        r10 = true;
        goto L14
    L7:
        r1.add(r7);
        goto L4
    L21:
        if ((!r2.isEmpty()) == true) goto L23;
    L25:
        Iterator r4 = r0.iterator();
        int r8 = 0;
    L27:
        if (r4.hasNext() == false) goto L30;
        r8 = r8 + ((List) r4.next()).size();
        goto L27
    L30:
        if (r8 >= r13.size()) goto L32;
        r1.clear();
        r1.addAll(CollectionsKt.drop(r13, r8));
    L32:
        A(r1, r14);
        if (r0.isEmpty() == false) goto L36;
        r0.add(CollectionsKt.mutableListOf(new View[]{getFoldButton()}));
        return new a(r0, r1);
    L36:
        List r15 = (List) CollectionsKt.last(r0);
    L38:
        if ((!r15.isEmpty()) == false) goto L59;
        MultiIconFoldButton r11 = getFoldButton();
        Iterator r12 = r15.iterator();
        int r16 = 0;
        int r17 = 0;
    L41:
        if (r12.hasNext() == false) goto L50;
        Object r18 = r12.next();
        int r19 = r16 + 1;
        if (r16 >= 0) goto L45;
        CollectionsKt.throwIndexOverflow();
    L45:
        View r20 = (View) r18;
        if (r16 <= 0) goto L48;
        r17 = r17 + this.u;
    L48:
        r17 = r17 + Math.min(r20.getMeasuredWidth(), r14);
        r16 = r19;
        goto L41
    L50:
        if (r15.isEmpty() == false) goto L52;
        int r21 = 0;
    L54:
        if (((r17 + r21) + Math.min(r11.getMeasuredWidth(), r14)) > r14) goto L56;
        boolean r22 = true;
    L57:
        if (r22 == true) goto L59;
        ListProtector.add(r1, 0, ListProtector.remove(r15, CollectionsKt.getLastIndex(r15)));
        A(r1, r14);
        goto L38
    L56:
        r22 = false;
        goto L57
    L52:
        r21 = this.u;
    L59:
        r15.add(getFoldButton());
        return new a(r0, r1);
    L23:
        if (r0.size() >= this.r) goto L25;
        r0.add(r2);
        goto L25
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int x(List<? extends View> r9, int r10) {
        if (r9.isEmpty() == true) goto L5;
        int r0 = getPaddingTop() + getPaddingBottom();
        Iterator<T> r11 = r9.iterator();
        int r1 = 0;
        int r2 = 0;
        boolean r3 = false;
        int r4 = 0;
    L8:
        if (r11.hasNext() == false) goto L18;
        View r5 = (View) r11.next();
        int r6 = Math.min(r5.getMeasuredWidth(), r10);
        int r7 = r5.getMeasuredHeight();
        if (r4 <= 0) goto L17;
        if ((r4 + r6) <= r10) goto L17;
        if (r3 == false) goto L15;
        int r8 = this.v;
    L16:
        r0 = r0 + (r2 + r8);
        int r12 = r6 + this.u;
        r3 = true;
        r2 = r7;
        r4 = r12;
        goto L8
    L15:
        r8 = 0;
    L17:
        r4 = r4 + (r6 + this.u);
        r2 = Math.max(r2, r7);
        goto L8
    L18:
        if (r3 == false) goto L21;
        r1 = this.v;
    L21:
        return r0 + (r2 + r1);
    L5:
        return getPaddingTop() + getPaddingBottom();
    }

    public final int y(List<? extends View> r5, int r6) {
        int r1 = 0;
        if (r5.isEmpty() == false) goto L5;
        return 0;
    L5:
        Iterator<T> r7 = r5.iterator();
        int r0 = 1;
    L7:
        if (r7.hasNext() == false) goto L14;
        int r2 = Math.min(((View) r7.next()).getMeasuredWidth(), r6);
        if (r1 <= 0) goto L13;
        if ((r1 + r2) <= r6) goto L13;
        r0 = r0 + 1;
        r1 = r2 + this.u;
    L13:
        r1 = r1 + (r2 + this.u);
        goto L7
    L14:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z(List<? extends View> r10, int r11) {
        int r0 = getPaddingLeft();
        int r1 = getPaddingTop();
        Iterator<T> r12 = r10.iterator();
        int r3 = 0;
    L4:
        if (r12.hasNext() == false) goto L11;
        View r4 = (View) r12.next();
        int r5 = Math.min(r4.getMeasuredWidth(), r11);
        int r6 = r4.getMeasuredHeight();
        if (r0 <= getPaddingLeft()) goto L10;
        if ((r0 + r5) <= (getPaddingLeft() + r11)) goto L10;
        r0 = getPaddingLeft();
        r1 = r1 + (r3 + this.v);
        r3 = 0;
    L10:
        r4.layout(r0, r1, r0 + r5, r1 + r6);
        r0 = r0 + (r5 + this.u);
        r3 = Math.max(r3, r6);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollapsibleFlexboxLayout(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.r = 3;
        this.t = true;
        this.u = UIUtils.dp2px(r2, 6.0f);
        this.v = UIUtils.dp2px(r2, 6.0f);
        this.y = LazyKt.lazy(new CollapsibleFlexboxLayout$foldButton$2(r2, this));
        this.z = -1;
        setClipChildren(true);
        getFoldButton().setVisibility(8);
        addView(getFoldButton());
    }

    public /* synthetic */ CollapsibleFlexboxLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        int r12 = RangesKt.coerceAtLeast((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 0);
        List<View> r13 = getNormalChildren();
        Iterator<T> r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        ((View) r14.next()).setVisibility(0);
        goto L4
    L6:
        boolean r15 = true;
        if (r12 != this.z) goto L10;
        boolean r16 = this.A;
    L14:
        if (r16 == true) goto L17;
        getFoldButton().setVisibility(8);
        z(r13, r12);
        return;
    L17:
        getFoldButton().setVisibility(0);
        if (this.s == true) goto L20;
        a r17 = this.B;
        if (r17 != null) goto L26;
    L31:
        r17 = null;
    L32:
        if (r17 != null) goto L34;
        r17 = w(r13, r12);
    L34:
        getFoldButton().setVisibility(0);
        Iterator<T> r18 = r17.b.iterator();
    L36:
        if (r18.hasNext() == false) goto L38;
        ((View) r18.next()).setVisibility(8);
        goto L36
    L38:
        List<List<View>> r19 = r17.a;
        int r20 = getPaddingTop();
        Iterator<T> r21 = r19.iterator();
    L40:
        if (r21.hasNext() == false) goto L69;
        List r110 = (List) r21.next();
        int r111 = getPaddingLeft();
        List r112 = r110;
        Iterator r0 = r112.iterator();
        if (r0.hasNext() == true) goto L44;
        Integer r2 = null;
    L50:
        if (r2 == null) goto L52;
        int r1 = r2.intValue();
    L53:
        Iterator r113 = r112.iterator();
    L55:
        if (r113.hasNext() == false) goto L57;
        View r3 = (View) r113.next();
        int r4 = Math.min(r3.getMeasuredWidth(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        r3.layout(r111, r20, r111 + r4, r3.getMeasuredHeight() + r20);
        r111 = r111 + (r4 + this.u);
        goto L55
    L57:
        r20 = r20 + (r1 + this.v);
        goto L40
    L52:
        r1 = 0;
        goto L53
    L44:
        r2 = Integer.valueOf(((View) r0.next()).getMeasuredHeight());
    L46:
        if (r0.hasNext() == false) goto L50;
        Integer r5 = Integer.valueOf(((View) r0.next()).getMeasuredHeight());
        if (r2.compareTo(r5) >= 0) goto L46;
        r2 = r5;
        goto L46
    L69:
        return;
    L26:
        if (r12 == this.z) goto L29;
        r15 = false;
    L29:
        if (r15 == false) goto L31;
    L20:
        if (this.t == false) goto L22;
        A(CollectionsKt.emptyList(), r12);
        getFoldButton().setVisibility(0);
        z(CollectionsKt.plus(r13, getFoldButton()), r12);
        return;
    L22:
        getFoldButton().setVisibility(8);
        z(r13, r12);
        return;
    L10:
        if (y(r13, r12) <= this.r) goto L12;
        r16 = true;
        goto L14
    L12:
        r16 = false;
        goto L14
    }
}
