package com.larus.bot.impl.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v19.c6;
import zp9.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010*\u001a\u00020\u00152\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0012H\u0016J\u0016\u0010\u001a\u001a\u00020\u00152\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J\u0012\u0010-\u001a\u00020\u001c2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016R\u0014\u0010\t\u001a\u00020\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R.\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u00138V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%¨\u00060"}, d2 = {"Lcom/larus/bot/impl/common/view/AbsCommonTagListView;", "Landroid/widget/HorizontalScrollView;", "Lcom/larus/platform/api/creation/ITabListLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "container", "Landroid/widget/LinearLayout;", "getContainer", "()Landroid/widget/LinearLayout;", "clickListener", "Lcom/larus/common_ui/utils/OnDebounceClickListener;", "getClickListener", "()Lcom/larus/common_ui/utils/OnDebounceClickListener;", "performClick", "Lkotlin/Function2;", "", "", "", "getPerformClick", "()Lkotlin/jvm/functions/Function2;", "setPerformClick", "(Lkotlin/jvm/functions/Function2;)V", "canScroll", "Lkotlin/Function0;", "", "getCanScroll", "()Lkotlin/jvm/functions/Function0;", "setCanScroll", "(Lkotlin/jvm/functions/Function0;)V", "innerCurrent", "getInnerCurrent", "()I", "setInnerCurrent", "(I)V", "value", "current", "getCurrent", "setCurrent", "onItemClick", "click", "scroll", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCommonTagListView extends HorizontalScrollView implements u {
    public final LinearLayout a;
    public final a b;
    public Function2<? super Integer, ? super String, Unit> c;
    public Function0<Boolean> d;
    public int e;

    public static final class a extends c6 {
        public final /* synthetic */ AbsCommonTagListView c;

        public a(AbsCommonTagListView r1) {
            this.c = r1;
        }

        public final void a(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            Object r4 = r3.getTag();
            if ((r4 instanceof Integer) == false) goto L5;
            Integer r5 = (Integer) r4;
        L6:
            if (r5 == null) goto L11;
            AbsCommonTagListView r0 = this.c;
            int r6 = r5.intValue();
            r0.setCurrent(r6);
            Function2<Integer, String, Unit> r1 = r0.getPerformClick();
            if (r1 == null) goto L12;
            r1.invoke(Integer.valueOf(r6), "");
            return;
        L12:
            return;
        L11:
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public final Function0<Boolean> getCanScroll() {
        return this.d;
    }

    public final c6 getClickListener() {
        return this.b;
    }

    public final LinearLayout getContainer() {
        return this.a;
    }

    public int getCurrent() {
        return this.e;
    }

    public final int getInnerCurrent() {
        return this.e;
    }

    public final Function2<Integer, String, Unit> getPerformClick() {
        return this.c;
    }

    public AbsCommonTagListView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void a(Function2<? super Integer, ? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "click");
        this.c = r2;
    }

    public final void c(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "scroll");
        this.d = r2;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r3) {
        Function0<Boolean> r0 = this.d;
        if (r0 == null) goto L5;
        boolean r1 = ((Boolean) r0.invoke()).booleanValue();
    L6:
        if (r1 == true) goto L8;
    L10:
        return false;
    L8:
        if (super.onTouchEvent(r3) == false) goto L10;
        return true;
    L5:
        r1 = true;
        goto L6
    }

    public final void setCanScroll(Function0<Boolean> r1) {
        this.d = r1;
    }

    public void setCurrent(int r2) {
        if (this.e != r2) goto L5;
        return;
    L5:
        this.e = r2;
        b(getCurrent(), true);
    }

    public final void setInnerCurrent(int r1) {
        this.e = r1;
    }

    public final void setPerformClick(Function2<? super Integer, ? super String, Unit> r1) {
        this.c = r1;
    }

    public AbsCommonTagListView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new LinearLayout(r2);
        this.b = new a(this);
        this.e = -1;
    }
}
