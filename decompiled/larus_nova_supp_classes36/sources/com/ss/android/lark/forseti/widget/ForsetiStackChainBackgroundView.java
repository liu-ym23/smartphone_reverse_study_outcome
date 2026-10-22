package com.ss.android.lark.forseti.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.ss.android.lark.base.embedded.LKSplitController;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.utils.ContextsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0014J\b\u0010\u0019\u001a\u00020\u0016H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/forseti/widget/ForsetiStackChainBackgroundView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "defaultAttrInt", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "chainHelper", "Lcom/ss/android/lark/forseti/widget/StackChainHelper;", "isCMode", "", "Ljava/lang/Boolean;", "style", "Lcom/ss/android/lark/forseti/widget/ForsetiStackChainViewGroup$Style;", "getStyle", "()Lcom/ss/android/lark/forseti/widget/ForsetiStackChainViewGroup$Style;", "setStyle", "(Lcom/ss/android/lark/forseti/widget/ForsetiStackChainViewGroup$Style;)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "checkToInvisible", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForsetiStackChainBackgroundView extends View {
    public final e a;
    public Boolean b;
    public ForsetiStackChainViewGroup.Style c;

    public ForsetiStackChainBackgroundView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ForsetiStackChainBackgroundView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final ForsetiStackChainViewGroup.Style getStyle() {
        return this.c;
    }

    public final void setStyle(ForsetiStackChainViewGroup.Style r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    @Override // android.view.View
    public final void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        int r6 = View.MeasureSpec.getSize(r4);
        int r7 = View.MeasureSpec.getSize(r5);
        e r0 = this.a;
        r0.getClass();
        if (Math.min(r6, r7) < r0.c) goto L8;
        int r8 = r0.b;
        if (r6 < ((r0.a * 2) + r8)) goto L8;
    L9:
        int r1 = 0;
        if (r6 <= r8) goto L12;
        boolean r9 = true;
    L13:
        boolean r10 = !r9;
        if (Intrinsics.areEqual(this.b, Boolean.valueOf(r10)) == true) goto L38;
        this.b = Boolean.valueOf(r10);
        Activity r11 = ContextsKt.findActivity(getContext());
        if (r11 == null) goto L39;
        Boolean r12 = this.b;
        if (r12 == null) goto L21;
        boolean r13 = r12.booleanValue();
    L22:
        if (r13 == false) goto L26;
        ForsetiStackChainViewGroup.Style r14 = this.c;
        if (r14 == ForsetiStackChainViewGroup.Style.HALF_STACK) goto L26;
        if (r14 != ForsetiStackChainViewGroup.Style.STACK) goto L32;
        LKSplitController r15 = LKSplitController.b;
        if (LKSplitController.a.a().e() == false) goto L32;
        boolean r16 = com.ss.android.lark.base.embedded.b.c(r11);
    L34:
        if ((!r16) == false) goto L36;
        r1 = 4;
    L36:
        setVisibility(r1);
        return;
    L32:
        r16 = false;
    L26:
        r16 = true;
        goto L34
    L21:
        r13 = true;
        goto L22
    L39:
        return;
    L38:
        return;
    L12:
        r9 = false;
    L8:
        r8 = r6;
        goto L9
    }

    public ForsetiStackChainBackgroundView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new e(r2);
        this.c = ForsetiStackChainViewGroup.Style.UNINITIALIZED;
    }

    public /* synthetic */ ForsetiStackChainBackgroundView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
