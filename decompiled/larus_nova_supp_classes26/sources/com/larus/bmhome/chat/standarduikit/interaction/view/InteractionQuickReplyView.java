package com.larus.bmhome.chat.standarduikit.interaction.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.ShadowLayout;
import com.larus.mainbot.impl.databinding.LarusInteractionQuickReplyViewBinding;
import com.larus.utils.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0002'(B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0014J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0014J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J-\u0010\u001a\u001a\u00020\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u001fJ8\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0004H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/interaction/view/InteractionQuickReplyView;", "Landroid/widget/LinearLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/interaction/view/InteractionQuickReplyViewInput;", "Lcom/larus/bmhome/chat/standarduikit/interaction/view/InteractionQuickReplyViewOutput;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusInteractionQuickReplyViewBinding;", "exposeFired", "", "bindData", "", "input", "output", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "bindContent", "bindEnvironmentIcon", "bindButtons", "buttons", "", "Lcom/larus/bmhome/chat/standarduikit/interaction/view/InteractionQuickReplyViewInput$Button;", "loadingIndex", "(Ljava/util/List;Ljava/lang/Integer;Lcom/larus/bmhome/chat/standarduikit/interaction/view/InteractionQuickReplyViewOutput;)V", "createButton", "Landroid/view/View;", "button", "isLoading", "otherLoading", "horizontal", "index", "Companion", "ButtonViews", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InteractionQuickReplyView extends LinearLayout {
    public static final /* synthetic */ int c = 0;
    public final LarusInteractionQuickReplyViewBinding a;
    public boolean b;

    public static final class a {
        public final FrameLayout a;
        public final TextView b;
        public final FrameLayout c;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "ButtonViews(root=" + this.a + ", label=" + this.b + ", loadingContainer=" + this.c + ')';
        }

        public a(FrameLayout r2, TextView r3, FrameLayout r4) {
            Intrinsics.checkNotNullParameter(r2, "root");
            Intrinsics.checkNotNullParameter(r3, "label");
            Intrinsics.checkNotNullParameter(r4, "loadingContainer");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b = false;
    }

    public InteractionQuickReplyView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public InteractionQuickReplyView(Context r21, AttributeSet r22) {
        Intrinsics.checkNotNullParameter(r21, "context");
        super(r21, r22);
        ShadowLayout r1 = LayoutInflater.from(r21).inflate(2131562471, this, false);
        addView(r1);
        int r2 = 2131365012;
        View r5 = ViewBindings.findChildViewById(r1, 2131365012);
        if (r5 == null) goto L39;
        r2 = 2131365020;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131365020);
        if (r6 == null) goto L39;
        r2 = 2131365143;
        if (((LinearLayout) ViewBindings.findChildViewById(r1, 2131365143)) == null) goto L39;
        r2 = 2131367812;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131367812);
        if (r7 == null) goto L39;
        r2 = 2131367850;
        ScrollView r8 = (ScrollView) ViewBindings.findChildViewById(r1, 2131367850);
        if (r8 == null) goto L39;
        r2 = 2131368868;
        AppCompatTextView r9 = ViewBindings.findChildViewById(r1, 2131368868);
        if (r9 == null) goto L39;
        r2 = 2131371725;
        SimpleDraweeView r10 = ViewBindings.findChildViewById(r1, 2131371725);
        if (r10 == null) goto L39;
        r2 = 2131371726;
        FrameLayout r11 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131371726);
        if (r11 == null) goto L39;
        r2 = 2131371727;
        AppCompatTextView r12 = ViewBindings.findChildViewById(r1, 2131371727);
        if (r12 == null) goto L39;
        r2 = 2131371728;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131371728);
        if (r13 == null) goto L39;
        r2 = 2131371729;
        Space r14 = (Space) ViewBindings.findChildViewById(r1, 2131371729);
        if (r14 == null) goto L39;
        r2 = 2131373072;
        Space r15 = (Space) ViewBindings.findChildViewById(r1, 2131373072);
        if (r15 == null) goto L39;
        r2 = 2131373074;
        AppCompatTextView r16 = ViewBindings.findChildViewById(r1, 2131373074);
        if (r16 == null) goto L39;
        r2 = 2131373076;
        LinearLayout r17 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131373076);
        if (r17 == null) goto L39;
        r2 = 2131385225;
        if (((LinearLayout) ViewBindings.findChildViewById(r1, 2131385225)) == null) goto L39;
        ShadowLayout r4 = r1;
        r2 = 2131388853;
        Space r18 = (Space) ViewBindings.findChildViewById(r1, 2131388853);
        if (r18 == null) goto L39;
        r2 = 2131388924;
        AppCompatTextView r19 = ViewBindings.findChildViewById(r1, 2131388924);
        if (r19 == null) goto L39;
        this.a = new LarusInteractionQuickReplyViewBinding(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
        return;
    L39:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        int r0 = View.MeasureSpec.getMode(r5);
        int r6 = View.MeasureSpec.getSize(r5);
        int r1 = MathKt.roundToInt(i.c(getContext()) * 0.6f);
        if (r0 == 0) goto L6;
        r1 = Math.min(r1, r6);
    L6:
        super.onMeasure(r4, View.MeasureSpec.makeMeasureSpec(r1, Integer.MIN_VALUE));
    }
}
