package com.larus.bmhome.chat.cell.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.utils.z1;
import ed8.d;
import ei9.c;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import t1a.b;
import v19.i5;
import va8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\tJ\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0014J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u0015H\u0002J\u0012\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0013H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/bmhome/chat/cell/view/MessageNoBoxContainerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isShareMode", "", "lastDispatchedContainerWidth", "", "fragmentReference", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "contentView", "Lcom/larus/bmhome/chat/cell/view/CustomStubView;", "forkRelationContainer", "setupContainerView", "", "cellView", "Landroid/view/View;", "setShareMode", "shareMode", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "prepareChildMeasureIfContainerWidthChanged", "getChatFragment", "findContainerWidthChangeAwareView", "Lcom/larus/bmhome/chat/cell/view/ContainerWidthChangeAware;", "parentView", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onDetachedFromWindow", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MessageNoBoxContainerView extends ConstraintLayout {
    public boolean a;
    public int b;
    public WeakReference<Fragment> c;
    public final CustomStubView d;

    /* JADX WARN: Multi-variable type inference failed */
    private final Fragment getChatFragment() {
        WeakReference<Fragment> r0 = this.c;
        if (r0 == null) goto L7;
        Fragment r1 = r0.get();
        if (r1 == null) goto L7;
        return r1;
    L7:
        b r2 = c.a(this);
        if (r2 == null) goto L14;
        m r3 = r2.getAbility(m.class);
        if (r3 == null) goto L14;
        Fragment r4 = r3.getChatFragment();
        if (r4 == null) goto L14;
        this.c = new WeakReference(r4);
        return r4;
    L14:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        WeakReference<Fragment> r0 = this.c;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        this.c = null;
    }

    public MessageNoBoxContainerView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static d R5(View r4) {
        if ((r4 instanceof d) == false) goto L7;
        return (d) r4;
    L7:
        if ((r4 instanceof ViewGroup) == true) goto L9;
        return null;
    L9:
        ViewGroup r5 = (ViewGroup) r4;
        int r0 = r5.getChildCount();
        int r2 = 0;
    L10:
        if (r2 >= r0) goto L15;
        d r3 = R5(r5.getChildAt(r2));
        if (r3 != null) goto L13;
        r2 = r2 + 1;
        goto L10
    L13:
        return r3;
    L15:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.a == false) goto L7;
        return true;
    L7:
        return super/*android.view.ViewGroup*/.onInterceptTouchEvent(r2);
    }

    public final void setShareMode(boolean r1) {
        this.a = r1;
    }

    public final void setupContainerView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "cellView");
        CustomStubView.a(this.d, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MessageNoBoxContainerView(Context r6, AttributeSet r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7);
        this.b = -1;
        CustomStubView r0 = new CustomStubView(r6);
        r0.setId(2131367862);
        this.d = r0;
        CustomStubView r2 = new CustomStubView(r6);
        r2.setId(2131379984);
        r2.setVisibility(8);
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        ConstraintLayout.LayoutParams r8 = new ConstraintLayout.LayoutParams(0, -2);
        r8.startToStart = 0;
        r8.endToEnd = 0;
        r8.topToTop = 0;
        r8.horizontalBias = 0.0f;
        Unit r4 = Unit.INSTANCE;
        addView(r0, r8);
        ConstraintLayout.LayoutParams r9 = new ConstraintLayout.LayoutParams(0, -2);
        r9.startToStart = 0;
        r9.endToEnd = 0;
        r9.topToBottom = 2131367862;
        r9.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) r9).topMargin = i5.q();
        addView(r2, r9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r3, int r4) {
        Fragment r0 = getChatFragment();
        Lazy r1 = z1.a;
        if (z1.a(r0) == false) goto L22;
        Integer r2 = Integer.valueOf(z1.e(r0));
        if (r2.intValue() <= 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == true) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L14;
        int r6 = r2.intValue();
    L15:
        if (r6 <= 0) goto L22;
        if (r6 == this.b) goto L22;
        this.b = r6;
        d r7 = R5(this);
        if (r7 == null) goto L22;
        r7.a(r6);
        goto L22
    L14:
        r6 = View.MeasureSpec.getSize(r3);
        goto L15
    L8:
        r5 = false;
    L22:
        super.onMeasure(r3, r4);
    }
}
