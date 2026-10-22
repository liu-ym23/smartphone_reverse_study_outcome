package com.bytedance.android.livesdk.chatroom.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.uikit.viewpager.AbsPagerAdapter;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.roommanage.admin.LiveRoomAdminManageListPresenter;
import com.bytedance.android.livesdk.chatroom.roommanage.admin.LiveRoomAdminManageListView;
import com.bytedance.android.livesdk.chatroom.roommanage.manage.LiveRoomManageListView2;
import com.bytedance.android.livesdk.chatroom.roommanage.permission.AnchorModifyAdminPermissionView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0007$B\u001d\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/LiveProfileManageViewPager;", "Lcom/bytedance/android/live/uikit/viewpager/SSViewPager;", "Landroidx/viewpager/widget/PagerAdapter;", "adapter", "", "setAdapter", "Lcom/bytedance/android/livesdk/chatroom/ui/LiveProfileManageViewPager$ProfileManageViewAdapter;", "a", "Lcom/bytedance/android/livesdk/chatroom/ui/LiveProfileManageViewPager$ProfileManageViewAdapter;", "getMAdapter", "()Lcom/bytedance/android/livesdk/chatroom/ui/LiveProfileManageViewPager$ProfileManageViewAdapter;", "setMAdapter", "(Lcom/bytedance/android/livesdk/chatroom/ui/LiveProfileManageViewPager$ProfileManageViewAdapter;)V", "mAdapter", "", "c", "Z", "getNeedUpdateHeightOnHorizontal", "()Z", "setNeedUpdateHeightOnHorizontal", "(Z)V", "needUpdateHeightOnHorizontal", "Landroid/animation/ValueAnimator;", "d", "Landroid/animation/ValueAnimator;", "getHeightAnimator", "()Landroid/animation/ValueAnimator;", "setHeightAnimator", "(Landroid/animation/ValueAnimator;)V", "heightAnimator", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ProfileManageViewAdapter", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveProfileManageViewPager extends SSViewPager {
    public ProfileManageViewAdapter a;
    public boolean b;
    public boolean c;
    public ValueAnimator d;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/LiveProfileManageViewPager$ProfileManageViewAdapter;", "Lcom/bytedance/android/live/uikit/viewpager/AbsPagerAdapter;", "Landroid/content/Context;", "h", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ProfileManageViewAdapter extends AbsPagerAdapter {
        public final t7 a;
        public final us2.a b;
        public final q7 c;
        public final Lazy d;
        public View e;
        public final AnchorModifyAdminPermissionView f;
        public final List<h80.d<? extends View>> g;
        public final Context h;
        public final LiveProfileManageDialogV2.b i;
        public final Room j;

        public final View f() {
            List<h80.d<? extends View>> r0 = this.g;
            return (View) ((h80.d) ListProtector.get(r0, CollectionsKt.getLastIndex(r0))).get();
        }

        public final int getCount() {
            return this.g.size();
        }

        public final Context getContext() {
            return this.h;
        }

        public final void g(Function0<Unit> r6) {
            LiveRoomAdminManageListView r0 = new LiveRoomAdminManageListView(this.h, this.j, this.c, "from_toolbar");
            this.e = r0;
            if (r6 == null) goto L6;
            LiveRoomAdminManageListPresenter r1 = r0.getPresenter();
            r1.h = r6;
            r1.d();
            return;
        }

        public final void unbindView(View r2) {
            super.unbindView(r2);
            if ((r2 instanceof com.bytedance.android.livesdk.chatroom.roommanage.c) == false) goto L6;
            ((com.bytedance.android.livesdk.chatroom.roommanage.c) r2).unbind();
            return;
        }

        public final View getView(int r1, View r2, ViewGroup r3) {
            com.bytedance.android.livesdk.chatroom.roommanage.c r4 = (View) ((h80.d) ListProtector.get(this.g, r1)).get();
            if ((r4 instanceof com.bytedance.android.livesdk.chatroom.roommanage.c) == false) goto L5;
            r4.a();
        L5:
            return r4;
        }

        public ProfileManageViewAdapter(boolean r14, Context r15, LayoutInflater r16, j7 r17, Room r18, User r19, boolean r20, boolean r21, UserProfileEvent r22, Bundle r23) {
            Intrinsics.checkNotNullParameter(r15, "context");
            Intrinsics.checkNotNullParameter(r16, "layoutInflater");
            Intrinsics.checkNotNullParameter(r17, "manageClickCallback");
            Intrinsics.checkNotNullParameter(r23, "bundle");
            super(r15, r16);
            this.h = r15;
            this.i = r17;
            this.j = r18;
            t7 r12 = new t7(r14, r15, r19, r20, r21, r22, r23);
            this.a = r12;
            String r2 = null;
            if (r18 == null) goto L5;
            Long r3 = Long.valueOf(r18.id);
        L6:
            if (r18 == null) goto L10;
            User r4 = r18.getOwner();
            if (r4 == null) goto L10;
            r2 = r4.getIdStr();
        L10:
            us2.a r1 = new us2.a(r15, r3, r2);
            this.b = r1;
            q7 r5 = new q7(this);
            this.c = r5;
            this.d = LazyKt.lazy(new LiveProfileManageViewPager$ProfileManageViewAdapter$emptyView$2(this));
            this.e = new FrameLayout(r15);
            this.f = new AnchorModifyAdminPermissionView(r15, r18, r5, "from_toolbar");
            this.g = CollectionsKt.listOf(new h80.d[]{new m7(this), new n7(this), new o7(this), new p7(this)});
            r12.setClickCallback(r17);
            r1.setClickCallback(r17);
            return;
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ LiveProfileManageViewPager a;
        public final /* synthetic */ ViewGroup.LayoutParams b;

        public b(LiveProfileManageViewPager r1, ViewGroup.LayoutParams r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            ViewGroup.LayoutParams r0 = this.b;
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L7;
            r0.height = ((Integer) r3).intValue();
            this.a.setLayoutParams(this.b);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    static {
    }

    public final boolean canScroll(View r1, boolean r2, int r3, int r4, int r5) {
        return false;
    }

    public final boolean canScrollHorizontally(int r1) {
        return false;
    }

    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return false;
    }

    public final boolean onTouchEvent(MotionEvent r1) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h() {
        ProfileManageViewAdapter r0 = this.a;
        if (r0 == null) goto L6;
        r0.a.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r1 = r0.a.getMeasuredHeight();
        ViewGroup.LayoutParams r2 = getLayoutParams();
        r2.height = r1;
        setLayoutParams(r2);
        return;
    }

    public final void j() {
        ProfileManageViewAdapter r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.e = new LiveRoomManageListView2(r0.h, r0.j, r0.c);
        setCurrentItem(2, false);
        k(r0.e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean i() {
        if (getContext().getResources() != null) goto L5;
        return false;
    L5:
        if (getContext().getResources().getConfiguration() != null) goto L7;
        return false;
    L7:
        if (getContext().getResources().getConfiguration().orientation != 1) goto L12;
        return true;
    L12:
        return false;
    }

    public final ValueAnimator getHeightAnimator() {
        return this.d;
    }

    public final ProfileManageViewAdapter getMAdapter() {
        return this.a;
    }

    public final boolean getNeedUpdateHeightOnHorizontal() {
        return this.c;
    }

    public LiveProfileManageViewPager(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k(View r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (i() == false) goto L6;
    L8:
        this.b = false;
        r5.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r6 = r5.getMeasuredHeight();
        ViewGroup.LayoutParams r1 = getLayoutParams();
        int r2 = getMeasuredHeight();
        ValueAnimator r3 = this.d;
        if (r3 == null) goto L11;
        r3.removeAllUpdateListeners();
        r3.removeAllListeners();
        r3.cancel();
    L11:
        ValueAnimator r7 = ValueAnimator.ofInt(new int[]{r2, r6});
        this.d = r7;
        if (r7 == null) goto L16;
        r7.addUpdateListener(new b(this, r1));
        r7.setDuration(300).start();
        return;
    L16:
        return;
    L6:
        if (this.c == true) goto L8;
    }

    public void setAdapter(PagerAdapter r2) {
        super/*androidx.viewpager.widget.ViewPager*/.setAdapter(r2);
        if (r2 != null) goto L5;
        return;
    L5:
        if ((r2 instanceof ProfileManageViewAdapter) == false) goto L9;
        this.a = (ProfileManageViewAdapter) r2;
        return;
    }

    public final void setHeightAnimator(ValueAnimator r1) {
        this.d = r1;
    }

    public final void setMAdapter(ProfileManageViewAdapter r1) {
        this.a = r1;
    }

    public final void setNeedUpdateHeightOnHorizontal(boolean r1) {
        this.c = r1;
    }

    public LiveProfileManageViewPager(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r6, int r7) {
        if (i() == true) goto L9;
        if (this.c == true) goto L9;
        super/*androidx.viewpager.widget.ViewPager*/.onMeasure(r6, r7);
        return;
    L9:
        if (this.b == false) goto L17;
        int r8 = getChildCount();
        int r1 = 9999;
        int r2 = 0;
    L11:
        if (r2 >= r8) goto L16;
        View r3 = getChildAt(r2);
        r3.measure(r6, View.MeasureSpec.makeMeasureSpec(0, 0));
        if ((r3 instanceof t7) == false) goto L15;
        r1 = ((t7) r3).getMeasuredHeight();
    L15:
        r2 = r2 + 1;
        goto L11
    L16:
        r7 = View.MeasureSpec.makeMeasureSpec(r1, 1073741824);
    L17:
        super/*androidx.viewpager.widget.ViewPager*/.onMeasure(r6, r7);
    }
}
