package com.bytedance.android.live.profile.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;
import androidx.core.widget.NestedScrollView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.ProfileTabsComponent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0006\u0013B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\"\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/profile/customview/ProfileNestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "", "getMaxScrollHeight", "getScrolledHeight", "", "a", "Z", "isMyLiveScroll", "()Z", "setMyLiveScroll", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProfileNestedScrollView extends NestedScrollView {
    public boolean a;
    public List<b> b;
    public View c;
    public View d;
    public OverScroller e;
    public Method f;
    public boolean g;

    public static final class a {
    }

    public interface b {
        void a(int r1, int r2, int r3);
    }

    static {
    }

    public ProfileNestedScrollView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProfileNestedScrollView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int getMaxScrollHeight() {
        if (this.c != null) goto L6;
        this.c = getChildAt(0);
    L6:
        if (this.d != null) goto L8;
        this.d = findViewById(2131380852);
    L8:
        View r0 = this.c;
        if (r0 != null) goto L12;
        ALogger.e("ProfileNestedScrollView", "getMaxScrollHeight, directChild is null");
        return 0;
    L12:
        View r3 = this.d;
        if (r3 != null) goto L16;
        ALogger.e("ProfileNestedScrollView", "getMaxScrollHeight, myLiveChild is null");
        return 0;
    L16:
        int r1 = r0.getHeight() - r3.getHeight();
        int r2 = com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.a.i;
        int r4 = r1 - UtilityKotlinExtentionsKt.i(52);
        int r5 = ProfileTabsComponent.m;
        return r4 + UtilityKotlinExtentionsKt.i(16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int getScrolledHeight() {
        return getScrollY();
    }

    public static String e(MotionEvent r1) {
        int r2 = r1.getActionMasked();
        if (r2 != 0) goto L5;
        return "MotionEvent.ACTION_DOWN";
    L5:
        if (r2 != 1) goto L7;
        return "MotionEvent.ACTION_UP";
    L7:
        if (r2 != 2) goto L9;
        return "MotionEvent.ACTION_MOVE";
    L9:
        if (r2 == 3) goto L11;
        return "";
    L11:
        return "MotionEvent.ACTION_CANCEL";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onInterceptTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "ev");
        if (this.a == false) goto L5;
        int r0 = r8.getActionMasked();
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L10;
    L12:
        ALogger.i("ProfileNestedScrollView", "onInterceptTouchEvent, eventType = " + e(r8) + ", stop block scroll, reset ignoreCurrentSequence = false");
        this.g = false;
    L19:
        if (this.g == false) goto L23;
        ALogger.i("ProfileNestedScrollView", "onInterceptTouchEvent, eventType = " + e(r8) + ", ignoreCurrentSequence");
        return false;
    L23:
        if (r8.getActionMasked() == 0) goto L58;
    L53:
        boolean r1 = super.onInterceptTouchEvent(r8);
        if (r8.getActionMasked() != 0) goto L56;
        ALogger.e("ProfileNestedScrollView", "onInterceptTouchEvent, eventType = " + e(r8) + ", result = " + r1);
    L57:
        return r1;
    L56:
        ALogger.i("ProfileNestedScrollView", "onInterceptTouchEvent, eventType = " + e(r8) + ", result = " + r1);
        goto L57
    L58:
    L51:
        th = move-exception;
        ALogger.e("ProfileNestedScrollView", "setParentScrollerFinish error, " + th.getMessage());
        goto L53
    L25:
        if (this.e != null) goto L39;
        Field r2 = NestedScrollView.class.getDeclaredField("mScroller");     // Catch: Throwable -> L51
        if (r2 == null) goto L29;
        r2.setAccessible(true);     // Catch: Throwable -> L51
    L29:
        Object r5 = null;
        if (r2 == null) goto L32;
        Object r3 = r2.get(this);     // Catch: Throwable -> L51
    L34:
        if ((r3 instanceof OverScroller) == false) goto L37;
        r5 = r3;
    L37:
        this.e = (OverScroller) r5;     // Catch: Throwable -> L51
        goto L39
    L32:
        r3 = null;
    L39:
        if (this.f != null) goto L43;
        Method r4 = NestedScrollView.class.getDeclaredMethod("abortAnimatedScroll", new Class[0]);     // Catch: Throwable -> L51
        this.f = r4;     // Catch: Throwable -> L51
        if (r4 == null) goto L43;
        r4.setAccessible(true);     // Catch: Throwable -> L51
    L43:
        OverScroller r6 = this.e;     // Catch: Throwable -> L51
        if (r6 != null) goto L46;
    L47:
        ALogger.i("ProfileNestedScrollView", "setParentScrollerFinish set mScroller finish");     // Catch: Throwable -> L51
        Method r7 = this.f;     // Catch: Throwable -> L51
        if (r7 == null) goto L53;
        r7.invoke(this, new Object[0]);     // Catch: Throwable -> L51
        goto L53
    L46:
        if (r6.isFinished() == true) goto L53;
    L10:
        if (r0 == 3) goto L12;
    L14:
        if (getScrollY() < getMaxScrollHeight()) goto L16;
        ALogger.i("ProfileNestedScrollView", "onInterceptTouchEvent, eventType = " + e(r8) + ", block scroll, set ignoreCurrentSequence = true");
        boolean r9 = true;
    L17:
        this.g = r9;
        goto L19
    L16:
        r9 = false;
        goto L17
    L5:
        return super.onInterceptTouchEvent(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "ev");
        boolean r2 = false;
        if (this.a == false) goto L34;
        int r0 = r8.getActionMasked();
        boolean r3 = true;
        if (r0 == 0) goto L17;
        if (r0 != 1) goto L13;
    L15:
        ALogger.i("ProfileNestedScrollView", "onTouchEvent, eventType = " + e(r8) + ", stop block scroll, reset ignoreCurrentSequence = false");
        this.g = false;
    L22:
        if (this.g == false) goto L36;
        ALogger.i("ProfileNestedScrollView", "onTouchEvent, eventType = " + e(r8) + ", ignoreCurrentSequence");
        return false;
    L36:
        r2 = super.onTouchEvent(r8);     // Catch: Exception -> L27
    L30:
        if (r8.getActionMasked() != 0) goto L32;
        ALogger.e("ProfileNestedScrollView", "onTouchEvent, eventType = " + e(r8) + ", result = " + r2);
    L33:
        return r2;
    L32:
        ALogger.i("ProfileNestedScrollView", "onTouchEvent, eventType = " + e(r8) + ", result = " + r2);
    L27:
        e = move-exception;
        SafetyGuard.a(null, e, null);
        goto L30
    L13:
        if (r0 == 3) goto L15;
    L17:
        if (getScrollY() < getMaxScrollHeight()) goto L19;
        ALogger.i("ProfileNestedScrollView", "onTouchEvent, eventType = " + e(r8) + ", block scroll, set ignoreCurrentSequence = true");
    L20:
        this.g = r3;
        goto L22
    L19:
        r3 = false;
        goto L20
    L34:
        return super.onTouchEvent(r8);
    L6:
        e = move-exception;
        SafetyGuard.a(null, e, null);
        return false;
    }

    public final void setMyLiveScroll(boolean r1) {
        this.a = r1;
    }

    public ProfileNestedScrollView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ ProfileNestedScrollView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onScrollChanged(int r2, int r3, int r4, int r5) {
        super.onScrollChanged(r2, r3, r4, r5);
        List<b> r6 = this.b;
        if (r6 == null) goto L8;
        Iterator r7 = ((ArrayList) r6).iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        ((b) r7.next()).a(r3, getScrollY(), getMaxScrollHeight());
        goto L6
    L10:
        return;
    }

    public final boolean onStartNestedScroll(View r2, View r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, "target");
        if (this.a == true) goto L7;
        return super.onStartNestedScroll(r2, r3, r4, r5);
    L7:
        if ((r4 & 2) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNestedPreScroll(View r5, int r6, int r7, int[] r8, int r9) {
        Intrinsics.checkNotNullParameter(r5, "target");
        Intrinsics.checkNotNullParameter(r8, "consumed");
        if (this.a == true) goto L6;
        super.onNestedPreScroll(r5, r6, r7, r8, r9);
        return;
    L6:
        int r10 = getScrollY();
        int r12 = getMaxScrollHeight();
        ALogger.i("ProfileNestedScrollView", "onNestedPreScroll, scrolled = " + r10 + ", maxScrollHeight = " + r12);
        if (r7 <= 0) goto L10;
        if (r10 >= r12) goto L13;
        int r13 = Math.min(r7, r12 - r10);
        ALogger.i("ProfileNestedScrollView", "onNestedPreScroll, up, dy = " + r7 + ", canScroll = " + r13);
        smoothScrollBy(0, r13);
        r8[1] = r13;
        return;
    L13:
        return;
    L10:
        if (r10 >= r12) goto L15;
        int r14 = Math.min(Math.abs(r7), r10);
        ALogger.i("ProfileNestedScrollView", "onNestedPreScroll, down, dy = " + r7 + ", canScroll = " + r14);
        int r15 = -r14;
        smoothScrollBy(0, r15);
        r8[1] = r15;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNestedScroll(View r2, int r3, int r4, int r5, int r6, int r7, int[] r8) {
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r8, "consumed");
        if (this.a == true) goto L6;
        super.onNestedScroll(r2, r3, r4, r5, r6, r7, r8);
        return;
    L6:
        ALogger.i("ProfileNestedScrollView", "onNestedScroll, dyConsumed = " + r4 + ", dyUnconsumed = " + r6);
        if (r6 >= 0) goto L12;
        int r9 = getScrollY();
        if (r9 <= 0) goto L13;
        int r10 = Math.min(Math.abs(r6), r9);
        ALogger.i("ProfileNestedScrollView", "onNestedScroll, down, dyUnconsumed = " + r6 + ", canScroll = " + r10);
        int r12 = -r10;
        smoothScrollBy(0, r12);
        r8[1] = r12;
        return;
    L13:
        return;
    }
}
