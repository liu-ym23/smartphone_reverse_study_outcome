package com.bytedance.android.live.room.navi.userinfo.flipper.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.v;
import i91.c;
import i91.d;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0006RB'\b\u0007\u0012\u0006\u0010L\u001a\u00020K\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010M\u0012\b\b\u0002\u0010O\u001a\u00020\u0005¢\u0006\u0004\bP\u0010QJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\"\u0010\f\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00158\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010*\u001a\u00020%8TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R!\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020+8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b-\u0010.R\"\u00103\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0007\u001a\u0004\b1\u0010\t\"\u0004\b2\u0010\u000bR$\u00105\u001a\u0004\u0018\u0001048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010<\u001a\u0004\u0018\u00010;8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010ARN\u0010E\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020C\u0018\u00010B2\u0018\u0010D\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020C\u0018\u00010B8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006S"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo/flipper/core/BaseTabFlipper;", "Landroid/widget/FrameLayout;", "", "Landroid/view/View;", "getCurDisplayView", "", "a", "I", "getCurShowPos", "()I", "setCurShowPos", "(I)V", "curShowPos", "", "b", "Z", "getFlipping", "()Z", "setFlipping", "(Z)V", "flipping", "Ljava/lang/ref/WeakReference;", "d", "Ljava/lang/ref/WeakReference;", "getDisplayView", "()Ljava/lang/ref/WeakReference;", "setDisplayView", "(Ljava/lang/ref/WeakReference;)V", "displayView", "Lio/reactivex/disposables/Disposable;", "e", "Lio/reactivex/disposables/Disposable;", "getNextTabDisposable", "()Lio/reactivex/disposables/Disposable;", "setNextTabDisposable", "(Lio/reactivex/disposables/Disposable;)V", "nextTabDisposable", "Li91/c;", "f", "Lkotlin/Lazy;", "getAnimController", "()Li91/c;", "animController", "Lj91/b;", "g", "getDataObserver", "()Lj91/b;", "dataObserver", "h", "getExpectAdapterCount", "setExpectAdapterCount", "expectAdapterCount", "Li91/a;", "nextTabExecutor", "Li91/a;", "getNextTabExecutor", "()Li91/a;", "setNextTabExecutor", "(Li91/a;)V", "Li91/a$a;", "executorCallback", "Li91/a$a;", "getExecutorCallback", "()Li91/a$a;", "setExecutorCallback", "(Li91/a$a;)V", "Li91/b;", "Li91/d;", "value", "adapter", "Li91/b;", "getAdapter", "()Li91/b;", "setAdapter", "(Li91/b;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LayoutParams", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseTabFlipper extends FrameLayout {
    public int a;
    public boolean b;
    public final b<d> c;
    public WeakReference<View> d;
    public Disposable e;
    public final Lazy f;
    public final Lazy g;
    public int h;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo/flipper/core/BaseTabFlipper$LayoutParams;", "Landroid/widget/FrameLayout$LayoutParams;", "Landroid/content/Context;", "c", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LayoutParams extends FrameLayout.LayoutParams {
        public d a;
        public Object b;

        public LayoutParams() {
            super(-2, -2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            super(r2);
        }

        public LayoutParams(Context r2, AttributeSet r3) {
            Intrinsics.checkNotNullParameter(r2, "c");
            super(r2, r3);
        }
    }

    public static final class a {
    }

    static {
    }

    public BaseTabFlipper(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BaseTabFlipper(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void b() {
        Disposable r2 = this.e;
        if (r2 != null) goto L5;
    L10:
        this.e = null;
        Unit r0 = Unit.INSTANCE;
        return;
    L5:
        if ((true ^ r2.isDisposed()) == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L10;
        r2.dispose();
        goto L10
    }

    public final boolean d() {
        return false;
    }

    public i91.b<? extends Object, ? extends d> getAdapter() {
        return null;
    }

    public c getAnimController() {
        return (c) this.f.getValue();
    }

    public final j91.b<Object> getDataObserver() {
        return (j91.b) this.g.getValue();
    }

    public final i91.a.InterfaceC0252a getExecutorCallback() {
        return null;
    }

    public final i91.a getNextTabExecutor() {
        return null;
    }

    public final void setExecutorCallback(i91.a.InterfaceC0252a r1) {
    }

    public final void setNextTabExecutor(i91.a r1) {
    }

    public void c() {
        WeakReference<View> r0 = this.d;
        if (r0 == null) goto L5;
        View r1 = r0.get();
    L6:
        getAdapter();
        this.h = 0;
        if (r1 == null) goto L15;
        LayoutParams r2 = com.bytedance.android.live.room.navi.userinfo.flipper.core.a.a(r1);
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.b != null) goto L13;
        return;
    L13:
        b();
        this.d = null;
        this.a = -1;
        a();
        e();
        return;
    L15:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public View getCurDisplayView() {
        WeakReference<View> r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    public final void a() {
        Iterator r0 = UtilityKotlinExtentionsKt.g(this).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        ((View) r0.next()).clearAnimation();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("BaseTabFlipper", e);
        if (v.a() == false) goto L4;
        throw e;
    }

    public final void e() {
        Iterator r0 = UtilityKotlinExtentionsKt.g(this).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        View r1 = (View) r0.next();
        f(r1);
        r1.clearAnimation();
        goto L4
    L6:
        removeAllViews();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
        a();
    }

    public final int getCurShowPos() {
        return this.a;
    }

    public final WeakReference<View> getDisplayView() {
        return this.d;
    }

    public final int getExpectAdapterCount() {
        return this.h;
    }

    public final boolean getFlipping() {
        return this.b;
    }

    public final Disposable getNextTabDisposable() {
        return this.e;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof LayoutParams;
    }

    public final void f(View r9) {
        LayoutParams r10 = com.bytedance.android.live.room.navi.userinfo.flipper.core.a.a(r9);
        if (r10 == null) goto L32;
        d r12 = r10.a;
        if (r12 == null) goto L38;
        b<d> r0 = this.c;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r12, "instance");
        int r1 = r12.b();
        ViewGroup.LayoutParams r2 = r12.a().getLayoutParams();
        if ((r2 instanceof LayoutParams) == true) goto L9;
        r2 = null;
    L9:
        LayoutParams r3 = (LayoutParams) r2;
        if (r3 == null) goto L12;
        r3.a = null;
        r3.b = null;
    L12:
        int r4 = 0;
        if (r0.b <= 0) goto L26;
        int r5 = 0;
    L15:
        if (r5 >= 8) goto L23;
        Pair r7 = r0.a[r5];
        if (r7 == null) goto L19;
        d r8 = (d) r7.getSecond();
    L20:
        if (r8 == r12) goto L21;
        r5 = r5 + 1;
        goto L15
    L21:
        boolean r6 = true;
    L24:
        if (r6 == true) goto L26;
    L27:
        if (r4 >= 8) goto L41;
        Object[] r13 = r0.a;
        if (r13[r4] == null) goto L30;
        r4 = r4 + 1;
        goto L27
    L30:
        r13[r4] = new Pair(Integer.valueOf(r1), r12);
        r0.b++;
        return;
    L41:
        return;
    L19:
        r8 = null;
        goto L20
    L23:
        r6 = false;
    L26:
        if (r0.b == 0) goto L27;
        return;
    L38:
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        if ((r2 instanceof LayoutParams) == false) goto L6;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r2);
    L6:
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r2);
    L9:
        return new ViewGroup.LayoutParams(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdapter(i91.b<? extends Object, ? extends d> r7) {
        if ((!Intrinsics.areEqual(null, r7)) == false) goto L19;
        removeAllViews();
        b<d> r1 = this.c;
        r1.getClass();
        int r4 = 0;
    L6:
        if (r4 >= 8) goto L8;
        r1.a[r4] = 0;
        r4 = r4 + 1;
        goto L6
    L8:
        r1.b = 0;
        b();
        this.d = null;
        this.a = -1;
        this.h = 0;
        if (r7 != null) goto L11;
        return;
    L11:
        this.h = r7.getItemSize();
        if (this.b == false) goto L16;
        this.a = -1;
        this.b = true;
        if (d() == true) goto L20;
        getAdapter();
        return;
    L20:
        return;
    L16:
        getAdapter();
        return;
    }

    public final void setCurShowPos(int r1) {
        this.a = r1;
    }

    public final void setDisplayView(WeakReference<View> r1) {
        this.d = r1;
    }

    public final void setExpectAdapterCount(int r1) {
        this.h = r1;
    }

    public final void setFlipping(boolean r1) {
        this.b = r1;
    }

    public final void setNextTabDisposable(Disposable r1) {
        this.e = r1;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new LayoutParams(getContext(), r3);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    public BaseTabFlipper(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.a = -1;
        this.b = true;
        this.c = new b();
        this.f = LazyKt.lazy(BaseTabFlipper$animController$2.INSTANCE);
        this.g = LazyKt.lazy(new BaseTabFlipper$dataObserver$2(this));
        this.b = r4.obtainStyledAttributes(r5, new int[]{2130970078}).getBoolean(0, true);
    }

    public /* synthetic */ BaseTabFlipper(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
