package com.bytedance.android.live.room.navi.userinfo_p.flipper.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder;
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
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0006UB'\b\u0007\u0012\u0006\u0010O\u001a\u00020N\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010P\u0012\b\b\u0002\u0010R\u001a\u00020\u0005¢\u0006\u0004\bS\u0010TJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\"\u0010\f\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00158\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010,\u001a\u0004\u0018\u00010%8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u00104\u001a\u0004\u0018\u00010-8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001b\u0010:\u001a\u0002058TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R!\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020;8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b<\u00107\u001a\u0004\b=\u0010>R\"\u0010C\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b@\u0010\u0007\u001a\u0004\bA\u0010\t\"\u0004\bB\u0010\u000bRN\u0010M\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020E\u0018\u00010D2\u0018\u0010F\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020E\u0018\u00010D8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L¨\u0006V"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/core/BaseTabFlipper;", "Landroid/widget/FrameLayout;", "", "Landroid/view/View;", "getCurDisplayView", "", "a", "I", "getCurShowPos", "()I", "setCurShowPos", "(I)V", "curShowPos", "", "b", "Z", "getFlipping", "()Z", "setFlipping", "(Z)V", "flipping", "Ljava/lang/ref/WeakReference;", "d", "Ljava/lang/ref/WeakReference;", "getDisplayView", "()Ljava/lang/ref/WeakReference;", "setDisplayView", "(Ljava/lang/ref/WeakReference;)V", "displayView", "Lw91/a;", "e", "Lw91/a;", "getNextTabExecutor", "()Lw91/a;", "setNextTabExecutor", "(Lw91/a;)V", "nextTabExecutor", "Lw91/a$a;", "f", "Lw91/a$a;", "getExecutorCallback", "()Lw91/a$a;", "setExecutorCallback", "(Lw91/a$a;)V", "executorCallback", "Lio/reactivex/disposables/Disposable;", "g", "Lio/reactivex/disposables/Disposable;", "getNextTabDisposable", "()Lio/reactivex/disposables/Disposable;", "setNextTabDisposable", "(Lio/reactivex/disposables/Disposable;)V", "nextTabDisposable", "Lw91/d;", "h", "Lkotlin/Lazy;", "getAnimController", "()Lw91/d;", "animController", "Lj91/b;", "i", "getDataObserver", "()Lj91/b;", "dataObserver", "j", "getExpectAdapterCount", "setExpectAdapterCount", "expectAdapterCount", "Lw91/b;", "Lw91/f;", "value", "k", "Lw91/b;", "getAdapter", "()Lw91/b;", "setAdapter", "(Lw91/b;)V", "adapter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LayoutParams", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseTabFlipper extends FrameLayout {
    public static final /* synthetic */ int l = 0;
    public int a;
    public boolean b;
    public final h<w91.f> c;
    public WeakReference<View> d;
    public w91.a e;
    public w91.a.InterfaceC0339a f;
    public Disposable g;
    public final Lazy h;
    public final Lazy i;
    public int j;
    public w91.b<? extends Object, ? extends w91.f> k;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/core/BaseTabFlipper$LayoutParams;", "Landroid/widget/FrameLayout$LayoutParams;", "Landroid/content/Context;", "c", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LayoutParams extends FrameLayout.LayoutParams {
        public w91.f a;
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

    public static final class b implements w91.a.InterfaceC0339a {
        public final /* synthetic */ w91.a a;
        public final /* synthetic */ BaseTabFlipper b;
        public final /* synthetic */ View c;

        @Override // w91.a.InterfaceC0339a
        public final void a() {
            this.a.d();
            w91.e r0 = e.b(this.c);
            if (Intrinsics.areEqual(this.b.getNextTabExecutor(), this.a) == false) goto L11;
            WeakReference<View> r1 = this.b.getDisplayView();
            if (r1 == null) goto L7;
            View r2 = r1.get();
        L9:
            if (Intrinsics.areEqual(r2, this.c) == false) goto L11;
            this.b.i();
            return;
        L7:
            r2 = null;
        L11:
            int r3 = BaseTabFlipper.l;
            ALogger.i("BaseTabFlipper", "don't execute next because the executor has changed." + r0);
            ALogger.i("BaseTabFlipper", "curPos:" + this.b.getCurShowPos() + "\tthe fipperData" + r0 + "\tisAutoFlip:" + this.b.getFlipping() + "\tisExecutingNext:" + this.b.g());
        }

        public b(w91.a r1, BaseTabFlipper r2, View r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
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

    public w91.d getAnimController() {
        return (w91.d) this.h.getValue();
    }

    public final j91.b<Object> getDataObserver() {
        return (j91.b) this.i.getValue();
    }

    public final void a() {
        w91.a r0 = this.e;
        if (r0 == null) goto L25;
        int r3 = r0.a();
        if (r3 <= 0) goto L11;
        if (r3 != 1) goto L20;
        w91.a.InterfaceC0339a r4 = this.f;
        if (r4 == null) goto L20;
        if (r0.c(r4) == true) goto L11;
    L20:
        w91.a.InterfaceC0339a r5 = this.f;
        if (r5 == null) goto L23;
        r0.e(r5);
    L24:
        if (r5 == null) goto L25;
        return;
    L23:
        r5 = null;
    L11:
        Disposable r6 = this.g;
        if (r6 != null) goto L14;
    L19:
        this.g = null;
        goto L20
    L14:
        if ((!r6.isDisposed()) == true) goto L17;
        r6 = null;
    L17:
        if (r6 == null) goto L19;
        r6.dispose();
    L25:
        Disposable r1 = this.g;
        if (r1 != null) goto L28;
    L33:
        this.g = null;
        Unit r2 = Unit.INSTANCE;
        return;
    L28:
        if ((true ^ r1.isDisposed()) == true) goto L31;
        r1 = null;
    L31:
        if (r1 == null) goto L33;
        r1.dispose();
        goto L33
    }

    public void d() {
        WeakReference<View> r0 = this.d;
        if (r0 == null) goto L5;
        View r1 = r0.get();
    L6:
        w91.b<? extends Object, ? extends w91.f> r2 = getAdapter();
        if ((r2 instanceof w91.b) == true) goto L9;
        r2 = null;
    L9:
        if (r2 == null) goto L11;
        int r3 = r2.getItemSize();
    L12:
        this.j = r3;
        if (r1 == null) goto L29;
        LayoutParams r4 = e.a(r1);
        if (r4 == null) goto L30;
        Object r5 = r4.b;
        if (r5 != 0) goto L20;
        return;
    L20:
        if (r2 == null) goto L22;
        int r6 = r2.getDataPosition(r5);
    L23:
        if (r6 >= 0) goto L31;
        c();
        if (r3 > 0) goto L27;
        this.d = null;
        this.a = -1;
        b();
        h();
        return;
    L27:
        i();
        return;
    L31:
        return;
    L22:
        r6 = -1;
        goto L23
    L30:
        return;
    L29:
        return;
    L11:
        r3 = 0;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final boolean g() {
        if (this.e == null) goto L9;
        Disposable r0 = this.g;
        if (r0 == null) goto L9;
        if (r0.isDisposed() == true) goto L9;
        return true;
    L9:
        return false;
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

    public final void i() {
        int r0 = this.a + 1;
        if (r0 < 0) goto L9;
        w91.b<? extends Object, ? extends w91.f> r3 = getAdapter();
        if (r3 == null) goto L7;
        int r4 = r3.getItemSize();
    L8:
        if (r0 >= r4) goto L9;
    L10:
        j(r0, true);
        return;
    L7:
        r4 = 0;
    L9:
        r0 = 0;
        goto L10
    }

    public final void b() {
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

    public final void c() {
        a();
        this.e = null;
    }

    public final void h() {
        Iterator r0 = UtilityKotlinExtentionsKt.g(this).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        View r1 = (View) r0.next();
        k(r1);
        r1.clearAnimation();
        goto L4
    L6:
        removeAllViews();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
        b();
    }

    public w91.b<? extends Object, ? extends w91.f> getAdapter() {
        return this.k;
    }

    public final int getCurShowPos() {
        return this.a;
    }

    public final WeakReference<View> getDisplayView() {
        return this.d;
    }

    public final w91.a.InterfaceC0339a getExecutorCallback() {
        return this.f;
    }

    public final int getExpectAdapterCount() {
        return this.j;
    }

    public final boolean getFlipping() {
        return this.b;
    }

    public final Disposable getNextTabDisposable() {
        return this.g;
    }

    public final w91.a getNextTabExecutor() {
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

    public final int f(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        Integer r1 = null;
        if ((r5 instanceof LayoutParams) == true) goto L5;
        r5 = null;
    L5:
        LayoutParams r6 = (LayoutParams) r5;
        if (r6 == null) goto L16;
        Object r7 = r6.b;
        if (r7 == 0) goto L16;
        w91.b<? extends Object, ? extends w91.f> r0 = getAdapter();
        if ((r0 instanceof w91.b) == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L14;
        r1 = Integer.valueOf(r0.getDataPosition(r7));
    L14:
        if (r1 == null) goto L16;
        return r1.intValue();
    L16:
        return -1;
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

    public final void k(View r9) {
        LayoutParams r10 = e.a(r9);
        if (r10 == null) goto L32;
        w91.f r12 = r10.a;
        if (r12 == null) goto L38;
        h<w91.f> r0 = this.c;
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
        w91.f r8 = (w91.f) r7.getSecond();
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

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdapter(w91.b<? extends Object, ? extends w91.f> r6) {
        if ((!Intrinsics.areEqual(this.k, r6)) == false) goto L19;
        w91.b<? extends Object, ? extends w91.f> r0 = this.k;
        if ((r0 instanceof w91.b) == true) goto L7;
        r0 = null;
    L7:
        if (r0 == null) goto L9;
        r0.c(null);
    L9:
        removeAllViews();
        h<w91.f> r1 = this.c;
        r1.getClass();
        int r3 = 0;
    L11:
        if (r3 >= 8) goto L13;
        r1.a[r3] = 0;
        r3 = r3 + 1;
        goto L11
    L13:
        r1.b = 0;
        c();
        this.d = null;
        this.a = -1;
        this.k = r6;
        this.j = 0;
        if (r6 != null) goto L16;
        return;
    L16:
        this.j = r6.getItemSize();
        r6.c(getDataObserver());
        return;
    }

    public final void setCurShowPos(int r1) {
        this.a = r1;
    }

    public final void setDisplayView(WeakReference<View> r1) {
        this.d = r1;
    }

    public final void setExecutorCallback(w91.a.InterfaceC0339a r1) {
        this.f = r1;
    }

    public final void setExpectAdapterCount(int r1) {
        this.j = r1;
    }

    public final void setFlipping(boolean r1) {
        this.b = r1;
    }

    public final void setNextTabDisposable(Disposable r1) {
        this.g = r1;
    }

    public final void setNextTabExecutor(w91.a r1) {
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

    public void e(w91.f r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "enterHolder");
        Intrinsics.checkNotNullParameter(r4, "enterView");
        ALogger.i("BaseTabFlipper", "start executeNextTabJob,the flipper data is:" + e.b(r4));
        c();
        if (this.b == false) goto L6;
        w91.a r5 = r3.g();
        b r0 = new b(r5, this, r4);
        r5.b(r0);
        Unit r6 = Unit.INSTANCE;
        this.f = r0;
        this.e = r5;
        this.g = r5.execute();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(int r17, boolean r18) {
        w91.b<? extends Object, ? extends w91.f> r1 = getAdapter();
        if (r1 != null) goto L5;
        return;
    L5:
        int r2 = r1.getItemSize();
        if (r2 > 0) goto L10;
        ALogger.d("BaseTabFlipper", "当前没有数据要展示");
        return;
    L10:
        if (r2 == this.j) goto L19;
        ALogger.e("BaseTabFlipper", "数据更新不符合预期");
        if (v.a() == false) goto L19;
        String r0 = getResources().getResourceName(getId());     // Catch: Resources.NotFoundException -> L16
    L18:
        throw new IllegalStateException("变更ITabAdapter的数据时要请调用notifyDataSetChange()。 Expected adapter item count: " + this.j + ", current item count: " + r2 + " FlipperLayout id: " + r0 + " FlipperLayout class: " + getClass() + " Problematic adapter: " + r1.getClass());
    L16:
        r0 = Integer.toHexString(getId());
    L19:
        this.a = r17;
        boolean r3 = false;
        if (r17 < 0) goto L22;
        if (r17 >= r2) goto L22;
    L23:
        w91.b<? extends Object, ? extends w91.f> r5 = getAdapter();
        if (r5 == null) goto L157;
        int r4 = r5.getItemSize();
        int r6 = this.a;
        if (r6 < 0) goto L138;
        if (r6 >= r4) goto L138;
        if (r4 <= 0) goto L138;
        u91.a r7 = r5.getData(r6);
        Intrinsics.checkNotNullParameter(r5, "adapter");
        WeakReference<View> r8 = this.d;
        w91.d r9 = null;
        if (r8 == null) goto L36;
        View r10 = r8.get();
        if (r10 == null) goto L36;
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
    L38:
        if ((r12 instanceof LayoutParams) == true) goto L40;
        r12 = null;
    L40:
        LayoutParams r13 = (LayoutParams) r12;
        if (r13 == null) goto L49;
        w91.f r14 = r13.a;
        if (r14 == null) goto L49;
        if (r14.b() != r5.getItemViewType(r6)) goto L49;
        if (Intrinsics.areEqual(r13.b, r7) == false) goto L49;
        boolean r15 = true;
    L50:
        if (r15 == false) goto L52;
        ALogger.d("BaseTabFlipper", "将要轮播的view已经在展示了");
        return;
    L52:
        ALogger.d("BaseTabFlipper", "show pos:" + this.a);
        Intrinsics.checkNotNullParameter(r5, "adapter");
        int r16 = r5.getItemViewType(r6);
        int r19 = r5.getItemSize();
        Intrinsics.checkNotNullParameter(r5, "adapter");
        h<w91.f> r20 = this.c;
        r20.getClass();
        int r110 = 7;
    L53:
        if (r110 < 0) goto L62;
        if (r20.b <= 0) goto L62;
        Pair r111 = r20.a[r110];
        if (r111 == null) goto L61;
        if (((Number) r111.getFirst()).intValue() != r16) goto L61;
        w91.f r112 = (w91.f) r111.getSecond();
        r20.a[r110] = 0;
        r20.b--;
        w91.f r113 = r112;
    L63:
        ALogger.d("BaseTabFlipper", "obtainTabHolder from pool.the holder is " + r113);
        w91.f r114 = r113;
        if (r113 != null) goto L73;
        CommonTabHolder r115 = r5.b(this, r16);
        r115.e(r16);
        if (r115.f.getParent() != null) goto L68;
    L72:
        r115.m();
        ALogger.d("BaseTabFlipper", "obtainTabHolder from onCreateHolder.the holder is " + r115);
        r114 = r115;
        goto L73
    L68:
        if (v.a() == false) goto L72;
        ALogger.e("BaseTabFlipper", "ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
        throw new IllegalArgumentException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
    L73:
        Intrinsics.checkNotNullParameter(r114, "enterHolder");
        View r22 = r114.a();
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if (r23 != null) goto L77;
        r23 = generateDefaultLayoutParams();
        r22.setLayoutParams(r23);
    L80:
        if ((r23 instanceof LayoutParams) == true) goto L82;
        r23 = null;
    L82:
        LayoutParams r24 = (LayoutParams) r23;
        if (r24 == null) goto L85;
        r24.b = r7;
        r24.a = r114;
        ALogger.d("BaseTabFlipper", "bind holder itemView's layout params data.the itemView:" + r114.a() + ".the itemData:" + r7 + '.');
    L85:
        WeakReference<View> r25 = this.d;
        if (r25 == null) goto L90;
        View r26 = r25.get();
        if (r26 == null) goto L90;
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
    L92:
        if ((r27 instanceof LayoutParams) == true) goto L94;
        r27 = null;
    L94:
        LayoutParams r28 = (LayoutParams) r27;
        if (r28 == null) goto L97;
        w91.f r29 = r28.a;
    L98:
        StringBuilder r30 = new StringBuilder("the exit holder:");
        if (r29 == null) goto L101;
        w91.e r32 = e.c(r29);
    L102:
        r30.append(r32);
        r30.append("\tthe enter holder:");
        r30.append(e.c(r114));
        ALogger.d("BaseTabFlipper", r30.toString());
        View r33 = r114.a();
        ViewParent r34 = r33.getParent();
        if ((r34 instanceof ViewGroup) == true) goto L105;
        r34 = null;
    L105:
        ViewGroup r35 = (ViewGroup) r34;
        if (r35 != null) goto L108;
    L113:
        addView(r33);
        ALogger.d("BaseTabFlipper", "cur childCount is " + getChildCount());
        Iterator r36 = UtilityKotlinExtentionsKt.g(this).iterator();
    L115:
        if (r36.hasNext() == false) goto L125;
        View r116 = (View) r36.next();
        if (r29 == null) goto L119;
        View r117 = r29.a();
    L121:
        if ((!Intrinsics.areEqual(r116, r117)) == false) goto L115;
        if ((!Intrinsics.areEqual(r116, r33)) == false) goto L115;
        ALogger.d("BaseTabFlipper", "remove extra view and its data is :" + e.b(r116));
        Intrinsics.checkNotNullParameter(r116, "view");
        k(r116);
        r116.clearAnimation();
        removeViewInLayout(r116);
        goto L115
    L119:
        r117 = null;
        goto L121
    L125:
        r5.a(r114, r6);
        a();
        w91.d r37 = getAnimController();
        if (r18 == true) goto L128;
    L130:
        if (r3 == false) goto L132;
        r9 = r37;
    L132:
        if (r9 == null) goto L134;
        ALogger.d("BaseTabFlipper", "doAnim");
        this.d = new WeakReference(r33);
        r9.b(r29, r114, new d(r33, r114, this, r29, r5));
        return;
    L134:
        ALogger.d("BaseTabFlipper", "undoAnim");
        if (r29 == null) goto L137;
        View r38 = r29.a();
        Intrinsics.checkNotNullParameter(r38, "view");
        k(r38);
        r38.clearAnimation();
        removeViewInLayout(r38);
    L137:
        this.d = new WeakReference(r33);
        e(r114, r33);
        return;
    L128:
        if (r37.a(new w91.d.b(r19, f(r33), r29, r114)) == false) goto L130;
        r3 = true;
        goto L130
    L108:
        if ((!Intrinsics.areEqual(r35, this)) == true) goto L111;
        r35 = null;
    L111:
        if (r35 == null) goto L113;
        r35.removeView(r33);
        goto L113
    L101:
        r32 = null;
        goto L102
    L97:
        r29 = null;
    L90:
        r27 = null;
        goto L92
    L77:
        if ((r23 instanceof LayoutParams) == true) goto L80;
        r23 = generateLayoutParams(r23);
        r22.setLayoutParams(r23);
    L61:
        r110 = r110 - 1;
    L62:
        r113 = null;
    L49:
        r15 = false;
    L36:
        r12 = null;
    L138:
        ALogger.e("BaseTabFlipper", "the position is invalidate:" + r6 + " and the item size is " + r4);
        return;
    L157:
        return;
    L22:
        ALogger.d("BaseTabFlipper", "wanna show but position is invalidate：" + r17);
        this.a = 0;
        goto L23
    }

    public BaseTabFlipper(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.a = -1;
        this.b = true;
        this.c = new h();
        this.h = LazyKt.lazy(BaseTabFlipper$animController$2.INSTANCE);
        this.i = LazyKt.lazy(new BaseTabFlipper$dataObserver$2(this));
        this.b = r4.obtainStyledAttributes(r5, new int[]{2130970078}).getBoolean(0, true);
    }

    public /* synthetic */ BaseTabFlipper(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
