package com.larus.aweme.impl.main_bot;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/aweme/impl/main_bot/ViewPager2FixLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "pagingTouchSlop", "touchSlop", "initialX", "", "initialY", "parentViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getParentViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "parentViewPager$delegate", "Lkotlin/Lazy;", "viewPagerEnableScroll", "", "onInterceptTouchEvent", "e", "Landroid/view/MotionEvent;", "handleInterceptTouchEvent", "", "reset", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ViewPager2FixLayout extends FrameLayout {
    public static final /* synthetic */ int g = 0;
    public final int a;
    public final int b;
    public float c;
    public float d;
    public final Lazy e;
    public boolean f;

    public static final class a {
    }

    static {
    }

    private final ViewPager2 getParentViewPager() {
        return (ViewPager2) this.e.getValue();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r12, "e");
        ViewPager2 r0 = getParentViewPager();
        if (r0 == null) goto L40;
        int r1 = r12.getAction() & r12.getActionMasked();
        if (r1 != 1) goto L8;
    L38:
        FLogger.a.d("ViewPager2FixLayout", "action up or cancel reset status");
        this.f = false;
        goto L40
    L8:
        if (r1 == 3) goto L38;
        if (r1 == 0) goto L14;
        if (this.f == false) goto L14;
        FLogger.a.d("ViewPager2FixLayout", "viewPagerEnableScroll is true,fast return");
    L14:
        if (r12.getAction() != 0) goto L17;
        this.c = r12.getX();
        this.d = r12.getY();
        this.f = false;
        FLogger.a.d("ViewPager2FixLayout", "actionDown allowInterceptTouchEvent，view pager don't intercept move event，but can consume at onTouch");
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L40
    L17:
        if (r12.getAction() != 2) goto L40;
        float r2 = r12.getX() - this.c;
        float r5 = r12.getY() - this.d;
        if (r0.getOrientation() != 0) goto L21;
        boolean r3 = true;
    L22:
        float r4 = Math.abs(r2);
        float r6 = Math.abs(r5);
        if (r3 == false) goto L32;
        if (r6 >= this.b) goto L40;
        if (r4 <= this.a) goto L40;
        if ((((double) r4) * 0.5d) <= r6) goto L40;
        FLogger.a.d("ViewPager2FixLayout", "DisallowInterceptTouchEvent,ViewPager can consume move event");
        this.f = true;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L40
    L32:
        if (r4 >= this.b) goto L40;
        if (r6 <= this.a) goto L40;
        if ((((double) r6) * 0.5d) <= r4) goto L40;
        FLogger.a.d("ViewPager2FixLayout", "DisallowInterceptTouchEvent,ViewPager can consume move event");
        this.f = true;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L40
    L21:
        r3 = false;
    L40:
        return super.onInterceptTouchEvent(r12);
    }

    public ViewPager2FixLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = ViewConfiguration.get(r2).getScaledPagingTouchSlop();
        this.b = ViewConfiguration.get(r2).getScaledTouchSlop();
        this.e = LazyKt.lazy(new f(this));
    }
}
