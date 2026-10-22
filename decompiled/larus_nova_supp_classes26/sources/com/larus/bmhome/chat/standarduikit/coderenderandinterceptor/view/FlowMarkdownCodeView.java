package com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.bmhome.chat.layout.widget.ShimmerLinearLayout;
import com.larus.bmhome.chat.markdown.code.ClickableMarkdownCodeView;
import com.larus.im.bean.message.Message;
import com.larus.mainbot.impl.databinding.LarusFlowMarkdownCodeViewHeaderBinding;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import qj8.g;
import qj8.l;
import qj8.m;
import ri8.c;
import ri8.d;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 =2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0001=B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J_\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00122\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0!2\b\u0010\"\u001a\u0004\u0018\u00010\u001d2\u0006\u0010#\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010&J\u0018\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0002JF\u0010*\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010+\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u00122\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0!2\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010-\u001a\u00020\u0018H\u0002J\b\u0010.\u001a\u00020\u0012H\u0002J\b\u0010/\u001a\u00020\nH\u0002J\u0018\u00100\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J5\u00101\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0002\u00105J\u0010\u00106\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0003H\u0002J\u0006\u00107\u001a\u00020\u0018J\u001a\u00108\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u00109\u001a\u00020\u0012H\u0002J\u001a\u0010:\u001a\u00020;2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0006\u0010<\u001a\u00020\nH\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/coderenderandinterceptor/view/FlowMarkdownCodeView;", "Landroid/widget/LinearLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/coderenderandinterceptor/view/FlowMarkdownCodeViewInput;", "Lcom/larus/bmhome/chat/standarduikit/coderenderandinterceptor/view/FlowMarkdownCodeViewOutput;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "markdownCodeView", "Lcom/larus/bmhome/chat/markdown/code/ClickableMarkdownCodeView;", "headerBinding", "Lcom/larus/mainbot/impl/databinding/LarusFlowMarkdownCodeViewHeaderBinding;", "isFold", "", "userClicked", "mobCardPosition", "runnable", "Ljava/lang/Runnable;", "bindData", "", "input", "output", "bindContentData", "code", "", "realLanguage", "isFinish", "extraMap", "", "title", "enableDynamicCodeFence", "addedLines", "deletedLines", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;)V", "setArrow", "isUserFold", "setArrowRotation", "bindHeaderData", "icon", "extra", "refreshCodeViewVisibility", "needShowCodeArea", "getTitleWidth", "mobShowCardHeader", "mobShowCard", "timeCost", "", "isSuccess", "(Lcom/larus/bmhome/chat/standarduikit/coderenderandinterceptor/view/FlowMarkdownCodeViewInput;Ljava/lang/Long;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/standarduikit/coderenderandinterceptor/view/FlowMarkdownCodeViewOutput;)V", "getCodeWidgetOrder", "onRecycle", "getCardId", "isHeader", "sizeThatFits", "Landroid/util/Size;", "preferredMaxWidth", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowMarkdownCodeView extends LinearLayout {
    public static final /* synthetic */ int g = 0;
    public final ClickableMarkdownCodeView a;
    public LarusFlowMarkdownCodeViewHeaderBinding b;
    public boolean c;
    public boolean d;
    public int e;
    public g f;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ FlowMarkdownCodeView a;
        public final /* synthetic */ boolean b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationCancel(r2);
            FlowMarkdownCodeView.a(this.a, this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2);
            FlowMarkdownCodeView.a(this.a, this.b);
        }

        public b(FlowMarkdownCodeView r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public FlowMarkdownCodeView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FlowMarkdownCodeView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final int getTitleWidth() {
        LarusFlowMarkdownCodeViewHeaderBinding r0 = this.b;
        if (r0 == null) goto L9;
        ShimmerLinearLayout r1 = r0.a;
        if (r1 == null) goto L9;
        if (r1.getVisibility() != 8) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        return 0;
    L12:
        LarusFlowMarkdownCodeViewHeaderBinding r3 = this.b;
        if (r3 == null) goto L18;
        TextView r4 = r3.e;
        if (r4 != null) goto L17;
        return 0;
    L17:
        return r4.getMeasuredWidth();
    L18:
        return 0;
    L9:
        r2 = false;
        goto L10
    }

    public final boolean d() {
        ClickableMarkdownCodeView r0 = this.a;
        if (r0 != null) goto L5;
    L13:
        boolean r1 = false;
    L14:
        if (r1 == true) goto L16;
    L18:
        return false;
    L16:
        if (this.c == true) goto L18;
        return true;
    L5:
        if (Intrinsics.areEqual(r0.j, "STDOUT") == false) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 != true) goto L13;
        r1 = true;
        goto L14
    L8:
        if (r0.i.length() <= 0) goto L10;
        r2 = true;
        goto L11
    }

    public final void e() {
        if (d() == false) goto L16;
        LarusFlowMarkdownCodeViewHeaderBinding r0 = this.b;
        if (r0 == null) goto L13;
        ShimmerLinearLayout r1 = r0.b;
        if (r1 == null) goto L13;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        if (r3 == null) goto L12;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        r4.bottomMargin = i5.h();
        r1.setLayoutParams(r4);
        goto L13
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        ClickableMarkdownCodeView r2 = this.a;
        if (r2 == null) goto L29;
        r2.setVisibility(0);
        return;
    L29:
        return;
    L16:
        LarusFlowMarkdownCodeViewHeaderBinding r5 = this.b;
        if (r5 == null) goto L25;
        ShimmerLinearLayout r6 = r5.b;
        if (r6 == null) goto L25;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L24;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        r8.bottomMargin = 0;
        r6.setLayoutParams(r8);
        goto L25
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L25:
        ClickableMarkdownCodeView r9 = this.a;
        if (r9 == null) goto L31;
        r9.setVisibility(8);
        return;
    }

    private final void setArrowRotation(boolean r2) {
        LarusFlowMarkdownCodeViewHeaderBinding r0 = this.b;
        if (r0 == null) goto L11;
        AppCompatImageView r1 = r0.c;
        if (r1 == null) goto L12;
        if (r2 == false) goto L8;
        float r3 = 270.0f;
    L9:
        r1.setRotation(r3);
        return;
    L8:
        r3 = 360.0f;
        goto L9
    L12:
        return;
    }

    public final int c(m r9) {
        int r0 = this.e;
        if (r0 < 0) goto L5;
        return r0;
    L5:
        c r1 = c.a;
        Intrinsics.checkNotNullParameter(this, "view");
        ViewParent r2 = getParent();
        if ((r2 instanceof ViewGroup) == false) goto L8;
        ViewGroup r3 = (ViewGroup) r2;
    L9:
        int r4 = 0;
        if (r3 != null) goto L13;
    L43:
        this.e = r4;
        if (r4 != 0) goto L47;
        this.e = r9.e;
    L47:
        return this.e;
    L13:
        if ((r3 instanceof FrameLayout) == false) goto L43;
        IntRange r5 = RangesKt.until(0, ((FrameLayout) r3).getChildCount());
        ArrayList r6 = new ArrayList();
        IntIterator r7 = r5.iterator();
    L17:
        if (r7.hasNext() == false) goto L34;
        View r8 = r3.getChildAt(r7.nextInt());
        if ((r8 instanceof FlowMarkdownCodeView) == false) goto L21;
        FlowMarkdownCodeView r10 = (FlowMarkdownCodeView) r8;
    L22:
        if (r10 == null) goto L31;
        ViewGroup.LayoutParams r11 = ((FlowMarkdownCodeView) r8).getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
    L27:
        if (r12 == null) goto L29;
        int r13 = r12.topMargin;
    L30:
        Pair r14 = new Pair(r8, Integer.valueOf(r13));
    L32:
        if (r14 == null) goto L17;
        r6.add(r14);
        goto L17
    L29:
        r13 = 0;
        goto L30
    L26:
        r12 = null;
        goto L27
    L31:
        r14 = null;
        goto L32
    L21:
        r10 = null;
        goto L22
    L34:
        Iterator r15 = CollectionsKt.sortedWith(r6, new d()).iterator();
    L36:
        if (r15.hasNext() == false) goto L41;
        if (Intrinsics.areEqual(((Pair) r15.next()).getFirst(), this) == true) goto L42;
        r4 = r4 + 1;
    L42:
        r4 = r4 + 1;
        goto L43
    L41:
        r4 = -1;
        goto L42
    L8:
        r3 = null;
        goto L9
    }

    public static final /* synthetic */ void a(FlowMarkdownCodeView r0, boolean r1) {
        r0.setArrowRotation(r1);
    }

    public static String b(m r3, boolean r4) {
        String r1 = null;
        if (r4 == false) goto L9;
        StringBuilder r5 = new StringBuilder();
        Message r2 = r3.b;
        if (r2 == null) goto L7;
        r1 = r2.getMessageId();
    L7:
        r5.append(r1);
        r5.append('_');
        r5.append(r3.e);
        r5.append("_code_header");
        return r5.toString();
    L9:
        StringBuilder r6 = new StringBuilder();
        Message r7 = r3.b;
        if (r7 == null) goto L12;
        r1 = r7.getMessageId();
    L12:
        r6.append(r1);
        r6.append('_');
        r6.append(r3.e);
        r6.append("_code");
        return r6.toString();
    }

    public final void f(boolean r4, boolean r5) {
        if (r4 == false) goto L8;
        float r6 = 360.0f;
        float r0 = 270.0f;
        if (r5 == true) goto L7;
        r6 = 270.0f;
        r0 = 360.0f;
    L7:
        ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{r6, r0});
        r7.setDuration(150);
        r7.addUpdateListener(new l(this));
        r7.addListener(new b(this, r5));
        r7.start();
        return;
    L8:
        setArrowRotation(r5);
    }

    public final Size g(m r5, int r6) {
        int r0 = View.MeasureSpec.makeMeasureSpec(r6, 1073741824);
        int r1 = 0;
        int r2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        ClickableMarkdownCodeView r3 = this.a;
        if (r3 == null) goto L5;
        r3.measure(r0, r2);
    L5:
        String r7 = r5.m;
        if (r7 != null) goto L8;
    L11:
        boolean r8 = true;
    L12:
        if (r8 == false) goto L14;
        r6 = getTitleWidth();
    L14:
        ClickableMarkdownCodeView r4 = this.a;
        if (r4 == null) goto L18;
        r1 = r4.getMeasuredHeight();
    L18:
        return new Size(r6, r1);
    L8:
        if (r7.length() == 0) goto L11;
        r8 = false;
        goto L12
    }

    public FlowMarkdownCodeView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.e = -1;
        setOrientation(1);
        ClickableMarkdownCodeView r7 = new ClickableMarkdownCodeView(r4, null, 6, 0);
        this.a = r7;
        addView(r7, -1, -2);
        r7.setVisibility(8);
    }

    public /* synthetic */ FlowMarkdownCodeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
