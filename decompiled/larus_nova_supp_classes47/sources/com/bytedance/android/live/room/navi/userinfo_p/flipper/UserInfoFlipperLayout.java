package com.bytedance.android.live.room.navi.userinfo_p.flipper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.core.BaseTabFlipper;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import r91.d;
import w91.e;
import w91.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/UserInfoFlipperLayout;", "Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/core/BaseTabFlipper;", "Lv91/a;", "m", "Lv91/a;", "getTabFlipSynchronizer", "()Lv91/a;", "setTabFlipSynchronizer", "(Lv91/a;)V", "tabFlipSynchronizer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoFlipperLayout extends BaseTabFlipper {
    public static final /* synthetic */ int n = 0;
    public v91.a m;

    public static final class a {
    }

    public static final class b implements w91.a.InterfaceC0339a {
        public final /* synthetic */ w91.a a;
        public final /* synthetic */ UserInfoFlipperLayout b;
        public final /* synthetic */ View c;
        public final /* synthetic */ f d;

        @Override // w91.a.InterfaceC0339a
        public final void a() {
            this.a.d();
            e r0 = com.bytedance.android.live.room.navi.userinfo_p.flipper.core.e.b(this.c);
            ALogger.i("UserInfoFlipperLayout", "on execute done.the fliperData is :" + r0);
            UserInfoFlipperLayout r1 = this.b;
            int r3 = UserInfoFlipperLayout.n;
            if (Intrinsics.areEqual(r1.getNextTabExecutor(), this.a) == false) goto L11;
            WeakReference<View> r2 = this.b.getDisplayView();
            if (r2 == null) goto L7;
            View r4 = r2.get();
        L9:
            if (Intrinsics.areEqual(r4, this.c) == false) goto L11;
            this.b.l(this.d);
            return;
        L7:
            r4 = null;
        L11:
            ALogger.i("UserInfoFlipperLayout", "don't execute next because the executor has changed." + r0);
            ALogger.i("UserInfoFlipperLayout", "curPos:" + this.b.getCurShowPos() + "\tthe fipperData" + r0 + "\tisAutoFlip:" + this.b.getFlipping() + "\tisExecutingNext:" + this.b.g());
        }

        public b(w91.a r1, UserInfoFlipperLayout r2, View r3, f r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public UserInfoFlipperLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public UserInfoFlipperLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.core.BaseTabFlipper
    public final void d() {
        WeakReference<View> r0 = getDisplayView();
        if (r0 == null) goto L5;
        View r1 = r0.get();
    L6:
        w91.b<? extends Object, ? extends f> r2 = getAdapter();
        if ((r2 instanceof w91.b) == true) goto L9;
        r2 = null;
    L9:
        if (r2 == null) goto L11;
        int r3 = r2.getItemSize();
    L12:
        setExpectAdapterCount(r3);
        if (r1 == null) goto L32;
        BaseTabFlipper.LayoutParams r4 = com.bytedance.android.live.room.navi.userinfo_p.flipper.core.e.a(r1);
        if (r4 == null) goto L33;
        Object r5 = r4.b;
        if (r5 != 0) goto L19;
        return;
    L19:
        f r6 = r4.a;
        if (r6 != null) goto L23;
        return;
    L23:
        if (r2 == null) goto L25;
        int r7 = r2.getDataPosition(r5);
    L26:
        if (r7 >= 0) goto L34;
        c();
        if (r3 > 0) goto L30;
        setDisplayView(null);
        setCurShowPos(-1);
        b();
        h();
        return;
    L30:
        l(r6);
        return;
    L34:
        return;
    L25:
        r7 = -1;
        goto L26
    L33:
        return;
    L32:
        return;
    L11:
        r3 = 0;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final v91.a getTabFlipSynchronizer() {
        return this.m;
    }

    public final void l(f r3) {
        if (r3.d(com.bytedance.android.live.room.navi.userinfo_p.flipper.core.e.c(r3)) == false) goto L11;
        v91.a r4 = this.m;
        if (r4 == null) goto L11;
        if (r4.a(this) != true) goto L11;
        ALogger.i("UserInfoFlipperLayout", "execute：do sync");
        v91.a r5 = this.m;
        if (r5 == null) goto L13;
        r5.b(this);
        return;
    L13:
        return;
    L11:
        ALogger.i("UserInfoFlipperLayout", "execute：to show next");
        i();
    }

    public final void setTabFlipSynchronizer(v91.a r1) {
        this.m = r1;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.core.BaseTabFlipper
    public final void e(f r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "enterHolder");
        Intrinsics.checkNotNullParameter(r4, "enterView");
        ALogger.i("UserInfoFlipperLayout", "start executeNextTabJob,the flipper data is:" + com.bytedance.android.live.room.navi.userinfo_p.flipper.core.e.b(r4));
        c();
        if (getFlipping() == false) goto L10;
        com.bytedance.android.live.room.navi.userinfo_p.flipper.core.e.c(r3);
        if (r3.f() == false) goto L7;
        w91.a r0 = d.c;
    L8:
        b r1 = new b(r0, this, r4, r3);
        r0.b(r1);
        Unit r5 = Unit.INSTANCE;
        setExecutorCallback(r1);
        setNextTabExecutor(r0);
        setNextTabDisposable(r0.execute());
        return;
    L7:
        r0 = r3.g();
        goto L8
    }

    public UserInfoFlipperLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ UserInfoFlipperLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
