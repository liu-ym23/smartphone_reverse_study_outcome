package com.obric.assistant.interaction.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import c29.a;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.utils.i;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import iea.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001<B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010!\u001a\u00020\"2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0#2\b\b\u0002\u0010$\u001a\u00020%J\"\u0010&\u001a\u00020\"2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0#2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020%0(J\b\u0010)\u001a\u00020\"H\u0002J0\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0014J\u0018\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0014J\u001a\u00108\u001a\u00020\"2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020705J\u0010\u0010:\u001a\u0002072\u0006\u0010;\u001a\u000206H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00104\u001a\u0010\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000207\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/obric/assistant/interaction/impl/view/ObricFlowTagLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "horSpace", "verSpace", "textHorPadding", "textVerPadding", "textSizePx", "", "textViewRadius", "textViewStrokeWidth", "textColor", "textSelectedColor", "textViewStrokeColor", "textViewStrokeSelectColor", "textViewBcgNormalColor", "textViewBcgPressColor", "textViewBcgSelectedColor", "textViewMinHeight", "tags", "", "Lcom/obric/assistant/interaction/impl/view/ObricFlowTagLayout$TagBean;", "value", "curSelectedTagBean", "getCurSelectedTagBean", "()Lcom/obric/assistant/interaction/impl/view/ObricFlowTagLayout$TagBean;", "addTags", "", "", "enableClick", "", "addTagsInformSelected", "isSelected", "Landroidx/lifecycle/MutableLiveData;", "updateSelectedStatus", "onLayout", "changed", "left", "top", "right", "bottom", "nextChildIndex", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "providerTagView", "Lkotlin/Function1;", "", "Landroid/widget/TextView;", "setTagViewProvide", "provider", "buildTextView", "text", "TagBean", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricFlowTagLayout extends FrameLayout {
    private TagBean curSelectedTagBean;
    private final int horSpace;
    private final List<Integer> nextChildIndex;
    private Function1<? super String, ? extends TextView> providerTagView;
    private final List<TagBean> tags;
    private final int textColor;
    private final int textHorPadding;
    private final int textSelectedColor;
    private final float textSizePx;
    private final int textVerPadding;
    private final int textViewBcgNormalColor;
    private final int textViewBcgPressColor;
    private final int textViewBcgSelectedColor;
    private final int textViewMinHeight;
    private final int textViewRadius;
    private final int textViewStrokeColor;
    private final int textViewStrokeSelectColor;
    private final int textViewStrokeWidth;
    private final int verSpace;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/interaction/impl/view/ObricFlowTagLayout$TagBean;", "", "txt", "", "tag", "", "extra", "<init>", "(Ljava/lang/String;ILjava/lang/Object;)V", "getTxt", "()Ljava/lang/String;", "getTag", "()I", "getExtra", "()Ljava/lang/Object;", "component1", "component2", "component3", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TagBean {
        private final Object extra;
        private final int tag;
        private final String txt;

        public static /* synthetic */ TagBean copy$default(TagBean r0, String r1, int r2, Object r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.txt;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.tag;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.extra;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final String component1() {
            return this.txt;
        }

        public final int component2() {
            return this.tag;
        }

        public final Object component3() {
            return this.extra;
        }

        public final TagBean copy(String r2, int r3, Object r4) {
            Intrinsics.checkNotNullParameter(r2, "txt");
            return new TagBean(r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof TagBean) == true) goto L8;
            return false;
        L8:
            TagBean r6 = (TagBean) r5;
            if (Intrinsics.areEqual(this.txt, r6.txt) == true) goto L12;
            return false;
        L12:
            if (this.tag == r6.tag) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.txt.hashCode() * 31) + this.tag) * 31;
            Object r1 = this.extra;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "TagBean(txt=" + this.txt + ", tag=" + this.tag + ", extra=" + this.extra + ')';
        }

        public final Object getExtra() {
            return this.extra;
        }

        public final int getTag() {
            return this.tag;
        }

        public final String getTxt() {
            return this.txt;
        }

        public TagBean(String r2, int r3, Object r4) {
            Intrinsics.checkNotNullParameter(r2, "txt");
            this.txt = r2;
            this.tag = r3;
            this.extra = r4;
        }

        public /* synthetic */ TagBean(String r1, int r2, Object r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 4) == 0) goto L5;
            r3 = null;
        L5:
            this(r1, r2, r3);
        }
    }

    public ObricFlowTagLayout(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public ObricFlowTagLayout(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public static /* synthetic */ void a(ObricFlowTagLayout r0, TagBean r1, MutableLiveData r2, View r3) {
        addTagsInformSelected$lambda$3$lambda$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ void b(ObricFlowTagLayout r0, TagBean r1, View r2) {
        addTags$lambda$1$lambda$0(r0, r1, r2);
    }

    private final void updateSelectedStatus() {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        RoundTextView r3 = getChildAt(r2);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.larus.common_ui.widget.roundlayout.RoundTextView");
        RoundTextView r4 = r3;
        if (r4.getTag() != this.curSelectedTagBean) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L10;
        r4.setTextColor(this.textSelectedColor);
        a r6 = r4.getDelegate();
        r6.i(this.textViewStrokeWidth);
        r6.g(this.textViewStrokeSelectColor);
        r6.a(this.textViewBcgSelectedColor);
    L11:
        r2 = r2 + 1;
        goto L3
    L10:
        r4.setTextColor(this.textColor);
        a r7 = r4.getDelegate();
        r7.i(this.textViewStrokeWidth);
        r7.g(this.textViewStrokeColor);
        r7.a(this.textViewBcgNormalColor);
        goto L11
    L7:
        r5 = false;
        goto L8
    }

    public final TagBean getCurSelectedTagBean() {
        return this.curSelectedTagBean;
    }

    private final TextView buildTextView(String r4) {
        Function1<? super String, ? extends TextView> r0 = this.providerTagView;
        if (r0 == null) goto L7;
        TextView r1 = (TextView) r0.invoke(r4);
        if (r1 == null) goto L7;
        return r1;
    L7:
        RoundTextView r2 = new RoundTextView(getContext());
        r2.setMinHeight(this.textViewMinHeight);
        r2.setTextColor(this.textColor);
        r2.setTextSize(0, this.textSizePx);
        int r3 = this.textHorPadding;
        int r5 = this.textVerPadding;
        r2.setPadding(r3, r5, r3, r5);
        r2.setText(r4);
        r2.setGravity(8388627);
        a r6 = r2.getDelegate();
        r6.j(this.textColor);
        r6.e(this.textViewRadius);
        r6.i(this.textViewStrokeWidth);
        r6.g(this.textViewStrokeColor);
        r6.h(this.textViewStrokeColor);
        r6.a(this.textViewBcgNormalColor);
        r6.b(this.textViewBcgPressColor);
        return r2;
    }

    public final void setTagViewProvide(Function1<? super String, ? extends TextView> r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        this.providerTagView = r2;
    }

    public final void addTags(List<TagBean> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "tags");
        this.tags.clear();
        this.tags.addAll(r4);
        removeAllViews();
        Iterator<T> r6 = this.tags.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        final TagBean r0 = (TagBean) r6.next();
        TextView r1 = buildTextView(r0.getTxt());
        r1.setTag(r0);
        if (r5 == false) goto L8;
        r1.setOnClickListener(new b(this, r0));
    L8:
        addView(r1, new FrameLayout.LayoutParams(-2, -2));
        goto L4
    }

    public final void addTagsInformSelected(List<TagBean> r4, final MutableLiveData<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r4, "tags");
        Intrinsics.checkNotNullParameter(r5, "isSelected");
        this.tags.clear();
        this.tags.addAll(r4);
        removeAllViews();
        Iterator<T> r6 = this.tags.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        final TagBean r0 = (TagBean) r6.next();
        TextView r1 = buildTextView(r0.getTxt());
        r1.setTag(r0);
        r1.setOnClickListener(new iea.a(this, r0, r5));
        addView(r1, new FrameLayout.LayoutParams(-2, -2));
        goto L4
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r11, int r12) {
        super.onMeasure(r11, r12);
        this.nextChildIndex.clear();
        int r13 = View.MeasureSpec.getSize(r11);
        int r14 = getChildCount();
        int r2 = 0;
        float r3 = 0.0f;
    L3:
        boolean r4 = true;
        if (r2 >= r14) goto L34;
        View r5 = getChildAt(r2);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.widget.TextView");
        TextView r6 = (TextView) r5;
        r6.setMaxWidth(r13);
        r6.measure(View.MeasureSpec.makeMeasureSpec(r13, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r7 = r6.getMeasuredWidth();
        if (r7 < r13) goto L15;
        int r8 = r2 - 1;
        if (r8 >= 0) goto L10;
    L14:
        this.nextChildIndex.add(Integer.valueOf(r2));
        r3 = 0.0f;
    L32:
        r2 = r2 + 1;
        goto L3
    L10:
        if (this.nextChildIndex.isEmpty() == false) goto L12;
    L13:
        this.nextChildIndex.add(Integer.valueOf(r8));
        goto L14
    L12:
        if (((Number) CollectionsKt.last(this.nextChildIndex)).intValue() == r8) goto L14;
    L15:
        int r9 = this.horSpace;
        float r10 = r7;
        if (((r9 + r3) + r10) <= r13) goto L26;
        int r15 = r2 - 1;
        if (r15 >= 0) goto L20;
    L24:
        r3 = r10;
        goto L32
    L20:
        if (this.nextChildIndex.isEmpty() == false) goto L22;
    L23:
        this.nextChildIndex.add(Integer.valueOf(r15));
        goto L24
    L22:
        if (((Number) CollectionsKt.last(this.nextChildIndex)).intValue() == r15) goto L24;
    L26:
        if (r3 == 0.0f) goto L29;
        r4 = false;
    L29:
        if (r4 == true) goto L24;
        r3 = r3 + (r9 + r7);
        goto L32
    L34:
        if ((!this.tags.isEmpty()) == false) goto L40;
        int r16 = CollectionsKt.getLastIndex(this.tags);
        if (this.nextChildIndex.isEmpty() == false) goto L38;
    L39:
        this.nextChildIndex.add(Integer.valueOf(r16));
        goto L40
    L38:
        if (((Number) CollectionsKt.last(this.nextChildIndex)).intValue() != r16) goto L39;
    L40:
        Iterator<T> r17 = this.nextChildIndex.iterator();
        int r0 = 0;
        int r18 = 0;
    L42:
        if (r17.hasNext() == false) goto L51;
        Object r19 = r17.next();
        int r20 = r18 + 1;
        if (r18 >= 0) goto L46;
        CollectionsKt.throwIndexOverflow();
    L46:
        View r21 = getChildAt(((Number) r19).intValue());
        if (r4 == false) goto L49;
        r0 = r21.getMeasuredHeight();
    L50:
        r18 = r20;
        r4 = false;
        goto L42
    L49:
        r0 = r0 + (this.verSpace + r21.getMeasuredHeight());
        goto L50
    L51:
        setMeasuredDimension(r13, r0);
    }

    public ObricFlowTagLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.horSpace = r2.getResources().getDimensionPixelSize(c.b(2130971139, r2, 2131166648));
        this.verSpace = r2.getResources().getDimensionPixelSize(c.b(2130971546, r2, 2131167462));
        this.textHorPadding = r2.getResources().getDimensionPixelSize(c.b(2130971186, r2, 2131166742));
        this.textVerPadding = r2.getResources().getDimensionPixelSize(c.b(2130971558, r2, 2131167486));
        this.textViewRadius = r2.getResources().getDimensionPixelSize(c.b(2130971163, r2, 2131166696));
        this.textViewStrokeWidth = r2.getResources().getDimensionPixelSize(c.b(2130971138, r2, 2131166647));
        this.textViewMinHeight = r2.getResources().getDimensionPixelSize(c.b(2130971435, r2, 2131167240));
        this.textSizePx = r2.getResources().getDimensionPixelSize(c.b(2130971208, r2, 2131166786));
        this.textViewBcgNormalColor = ContextCompat.getColor(r2, c.b(2130970535, r2, 2131102548));
        this.textViewBcgPressColor = ContextCompat.getColor(r2, c.b(2130972118, r2, 2131103188));
        this.textViewBcgSelectedColor = ContextCompat.getColor(r2, c.b(2130972127, r2, 2131103215));
        this.textViewStrokeColor = ContextCompat.getColor(r2, c.b(2130972087, r2, 2131103162));
        this.textViewStrokeSelectColor = ContextCompat.getColor(r2, c.b(2130972128, r2, 2131103218));
        this.textColor = ContextCompat.getColor(r2, c.b(2130972079, r2, 2131103136));
        this.textSelectedColor = ContextCompat.getColor(r2, c.b(2130972123, r2, 2131103203));
        this.tags = new ArrayList();
        this.nextChildIndex = new ArrayList();
    }

    private static final void addTags$lambda$1$lambda$0(ObricFlowTagLayout r0, TagBean r1, View r2) {
        r0.curSelectedTagBean = r1;
        r0.updateSelectedStatus();
    }

    private static final void addTagsInformSelected$lambda$3$lambda$2(ObricFlowTagLayout r0, TagBean r1, MutableLiveData r2, View r3) {
        r0.curSelectedTagBean = r1;
        r0.updateSelectedStatus();
        r2.postValue(Boolean.TRUE);
    }

    public /* synthetic */ ObricFlowTagLayout(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static /* synthetic */ void addTags$default(ObricFlowTagLayout r0, List r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.addTags(r1, r2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        int r9 = getChildCount();
        int r10 = 0;
        if (i.h(getContext()) == false) goto L11;
        int r11 = r7 - r5;
        int r12 = r11;
        int r13 = 0;
    L5:
        if (r10 >= r9) goto L18;
        View r0 = getChildAt(r10);
        r0.layout(r12 - r0.getMeasuredWidth(), r13, r12, r0.getMeasuredHeight() + r13);
        if (this.nextChildIndex.contains(Integer.valueOf(r10)) == false) goto L9;
        r13 = r13 + (this.verSpace + r0.getMeasuredHeight());
        r12 = r11;
    L10:
        r10 = r10 + 1;
        goto L5
    L9:
        r12 = (r12 - this.horSpace) - r0.getMeasuredWidth();
        goto L10
    L18:
        return;
    L11:
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
    L12:
        if (r14 >= r9) goto L25;
        View r1 = getChildAt(r14);
        r1.layout(r15, r16, r1.getMeasuredWidth() + r15, r1.getMeasuredHeight() + r16);
        if (this.nextChildIndex.contains(Integer.valueOf(r14)) == false) goto L16;
        r16 = r16 + (this.verSpace + r1.getMeasuredHeight());
        r15 = 0;
    L17:
        r14 = r14 + 1;
        goto L12
    L16:
        r15 = r15 + (this.horSpace + r1.getMeasuredWidth());
        goto L17
    }
}
