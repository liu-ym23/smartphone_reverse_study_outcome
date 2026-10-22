package com.bytedance.android.live.effect.sticker.ui.aigc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010#\u001a\u00020\b¢\u0006\u0004\b$\u0010%J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\u0007\u001a\u00020\u0003J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nR\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001b\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001e\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u001a¨\u0006&"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/aigc/HorizontalScrollItemSelector;", "Landroid/widget/HorizontalScrollView;", "", "", "list", "", "setKeywordList", "getCurrentSelectKeyword", "", "getCurrentSelectItemIndex", "Lcom/bytedance/android/live/effect/sticker/ui/aigc/c;", "listener", "setItemSelectListener", "Landroid/widget/LinearLayout$LayoutParams;", "a", "Lkotlin/Lazy;", "getContainerLinearLayoutLayoutParams", "()Landroid/widget/LinearLayout$LayoutParams;", "containerLinearLayoutLayoutParams", "Landroid/widget/LinearLayout;", "b", "getContainerLinearLayout", "()Landroid/widget/LinearLayout;", "containerLinearLayout", "f", "getFirstItemLeftMargin", "()I", "firstItemLeftMargin", "g", "getNormalItemLeftMargin", "normalItemLeftMargin", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HorizontalScrollItemSelector extends HorizontalScrollView {
    public final Lazy a;
    public final Lazy b;
    public final List<String> c;
    public int d;
    public c e;
    public final Lazy f;
    public final Lazy g;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AigcKeywordItemView a;
        public final /* synthetic */ HorizontalScrollItemSelector b;

        public a(AigcKeywordItemView r1, HorizontalScrollItemSelector r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            HorizontalScrollItemSelector r4 = this.b;
            int r0 = r4.d;
            if (r0 >= 0) goto L5;
        L17:
            HorizontalScrollItemSelector r5 = this.b;
            AigcKeywordItemView r1 = this.a;
            r5.getClass();
            r1.setSelectStatus(true);
            r5.d = r1.getPosition();
            c r6 = r5.e;
            if (r6 == null) goto L24;
            r6.a();
            return;
        L24:
            return;
        L5:
            if (r0 >= ((ArrayList) r4.c).size()) goto L17;
            if (this.b.d == this.a.getPosition()) goto L21;
            Object r7 = HorizontalScrollItemSelector.a(this.b).getChildAt(this.b.d);
            if ((r7 instanceof AigcKeywordItemView) == true) goto L11;
            r7 = null;
        L11:
            AigcKeywordItemView r8 = (AigcKeywordItemView) r7;
            if (r8 == null) goto L14;
            r8.setSelectStatus(false);
        L14:
            HorizontalScrollItemSelector r9 = this.b;
            AigcKeywordItemView r2 = this.a;
            r9.getClass();
            r2.setSelectStatus(true);
            r9.d = r2.getPosition();
            c r11 = r9.e;
            if (r11 == null) goto L22;
            r11.a();
            return;
        L22:
            return;
        }
    }

    public HorizontalScrollItemSelector(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HorizontalScrollItemSelector(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final LinearLayout getContainerLinearLayout() {
        return (LinearLayout) this.b.getValue();
    }

    private final LinearLayout.LayoutParams getContainerLinearLayoutLayoutParams() {
        return (LinearLayout.LayoutParams) this.a.getValue();
    }

    private final int getFirstItemLeftMargin() {
        return ((Number) this.f.getValue()).intValue();
    }

    private final int getNormalItemLeftMargin() {
        return ((Number) this.g.getValue()).intValue();
    }

    public final void b() {
        ((ArrayList) this.c).clear();
        this.d = -1;
        scrollTo(0, 0);
        getContainerLinearLayout().removeAllViews();
    }

    public final String getCurrentSelectKeyword() {
        int r0 = this.d;
        if (r0 >= 0) goto L5;
        return "";
    L5:
        if (r0 <= ((ArrayList) this.c).size()) goto L8;
        return "";
    L8:
        return (String) ListProtector.get(this.c, this.d);
    }

    public final void c() {
        Object r0 = getContainerLinearLayout().getChildAt(this.d);
        if ((r0 instanceof AigcKeywordItemView) == true) goto L5;
        r0 = null;
    L5:
        AigcKeywordItemView r1 = (AigcKeywordItemView) r0;
        if (r1 == null) goto L8;
        r1.setSelectStatus(false);
    L8:
        this.d = -1;
    }

    public final int getCurrentSelectItemIndex() {
        return this.d;
    }

    public static final /* synthetic */ LinearLayout a(HorizontalScrollItemSelector r0) {
        return r0.getContainerLinearLayout();
    }

    public final void setItemSelectListener(c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.e = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.view.View, android.view.ViewGroup, com.bytedance.android.live.effect.sticker.ui.aigc.AigcKeywordItemView] */
    public final void setKeywordList(List<String> r8) {
        Intrinsics.checkNotNullParameter(r8, "list");
        b();
        ArrayList r0 = (ArrayList) this.c;
        r0.addAll(r8);
        Iterator r9 = ((ArrayList) this.c).iterator();
        int r1 = 0;
    L4:
        if (r9.hasNext() == false) goto L10;
        String r2 = (String) r9.next();
        ?? r3 = new AigcKeywordItemView(getContext(), null, 6, 0);
        r3.setText(r2);
        r3.setPosition(r1);
        r3.setOnClickListener(new a(r3, this));
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-2, -2);
        if (r1 != 0) goto L8;
        int r5 = getFirstItemLeftMargin();
    L9:
        r4.leftMargin = r5;
        getContainerLinearLayout().addView(r3, r4);
        r1 = r1 + 1;
        goto L4
    L8:
        r5 = getNormalItemLeftMargin();
        goto L9
    }

    public HorizontalScrollItemSelector(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(HorizontalScrollItemSelector$containerLinearLayoutLayoutParams$2.INSTANCE);
        this.b = LazyKt.lazy(new HorizontalScrollItemSelector$containerLinearLayout$2(r2));
        this.c = new ArrayList();
        this.d = -1;
        this.f = LazyKt.lazy(HorizontalScrollItemSelector$firstItemLeftMargin$2.INSTANCE);
        this.g = LazyKt.lazy(HorizontalScrollItemSelector$normalItemLeftMargin$2.INSTANCE);
        setBackground(null);
        setOverScrollMode(2);
        addView(getContainerLinearLayout(), getContainerLinearLayoutLayoutParams());
    }

    public /* synthetic */ HorizontalScrollItemSelector(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
