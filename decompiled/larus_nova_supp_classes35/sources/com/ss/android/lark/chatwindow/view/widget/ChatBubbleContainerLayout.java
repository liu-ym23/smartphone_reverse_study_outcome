package com.ss.android.lark.chatwindow.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chatwindow/view/widget/ChatBubbleContainerLayout;", "Lcom/ss/android/lark/chatwindow/view/widget/MeasureDetectLKUIRoundLinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onMeasure", BuildConfig.FLAVOR, "widthMeasureSpec", BuildConfig.FLAVOR, "heightMeasureSpec", "generateLayoutParams", "Lcom/ss/android/lark/chatwindow/view/widget/ChatBubbleContainerLayout$LayoutParams;", "generateDefaultLayoutParams", "LayoutParams", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatBubbleContainerLayout extends MeasureDetectLKUIRoundLinearLayout {

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\u000bB!\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0006\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0006\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0012¢\u0006\u0004\b\u0006\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0014B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chatwindow/view/widget/ChatBubbleContainerLayout$LayoutParams;", "Landroid/widget/LinearLayout$LayoutParams;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "width", BuildConfig.FLAVOR, "height", "(II)V", "weight", BuildConfig.FLAVOR, "(IIF)V", "p", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", "Landroid/view/ViewGroup$MarginLayoutParams;", "(Landroid/view/ViewGroup$MarginLayoutParams;)V", "(Landroid/widget/LinearLayout$LayoutParams;)V", "(Lcom/ss/android/lark/chatwindow/view/widget/ChatBubbleContainerLayout$LayoutParams;)V", "fitParentWidth", BuildConfig.FLAVOR, "getFitParentWidth", "()Z", "setFitParentWidth", "(Z)V", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LayoutParams extends LinearLayout.LayoutParams {
        public final boolean a;

        public LayoutParams(LinearLayout.LayoutParams r2) {
            Intrinsics.checkNotNullParameter(r2, "p");
            super(r2);
        }

        public LayoutParams(Context r4, AttributeSet r5) {
            Intrinsics.checkNotNullParameter(r4, "context");
            super(r4, r5);
            TypedArray r6 = r4.obtainStyledAttributes(r5, new int[]{2130970070});
            this.a = r6.getBoolean(0, false);
            r6.recycle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(super/*android.widget.LinearLayout*/.generateDefaultLayoutParams());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: generateDefaultLayoutParams, reason: collision with other method in class */
    public final LinearLayout.LayoutParams m748generateDefaultLayoutParams() {
        return new LayoutParams(super/*android.widget.LinearLayout*/.generateDefaultLayoutParams());
    }

    public ChatBubbleContainerLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new LayoutParams(getContext(), r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: generateLayoutParams, reason: collision with other method in class */
    public final LinearLayout.LayoutParams m749generateLayoutParams(AttributeSet r3) {
        return new LayoutParams(getContext(), r3);
    }

    public ChatBubbleContainerLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.chatwindow.view.widget.MeasureDetectLKUIRoundLinearLayout
    public final void onMeasure(int r5, int r6) {
        super.onMeasure(r5, r6);
        int r7 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        Iterator r8 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r8.hasNext() == false) goto L19;
        View r0 = (View) r8.next();
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof LayoutParams) == false) goto L8;
        LayoutParams r2 = (LayoutParams) r1;
    L10:
        if (r2 == null) goto L14;
        boolean r3 = true;
        if (r2.a != true) goto L14;
    L15:
        if (r3 == false) goto L4;
        if (r0.getMeasuredWidth() >= r7) goto L4;
        r0.measure(View.MeasureSpec.makeMeasureSpec(r7, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    L14:
        r3 = false;
        goto L15
    L8:
        r2 = null;
        goto L10
    }
}
