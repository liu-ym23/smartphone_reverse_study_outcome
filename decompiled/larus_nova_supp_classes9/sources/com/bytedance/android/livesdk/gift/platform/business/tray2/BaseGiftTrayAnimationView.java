package com.bytedance.android.livesdk.gift.platform.business.tray2;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.tray.RelativeEnterAnimPos;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.common.ui.MeasureOptFrameLayout;
import com.bytedance.android.livesdk.gift.platform.business.tray.GiftTrayWidget;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010(\u001a\u00020\t¢\u0006\u0004\b)\u0010*J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0004J\b\u0010\u000b\u001a\u00020\tH\u0004R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001e\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/tray2/BaseGiftTrayAnimationView;", "Lcom/bytedance/android/live/revenue/common/ui/MeasureOptFrameLayout;", "Lh02/a;", "dialog", BuildConfig.FLAVOR, "setAboveDialog", BuildConfig.FLAVOR, "blockState", "setBlockingState", BuildConfig.FLAVOR, "getPublicScreenHeight", "getPublicScreenMarginBottom", "Ls02/d;", "a", "Ls02/d;", "getOnGiftTrayIdleStateListener", "()Ls02/d;", "setOnGiftTrayIdleStateListener", "(Ls02/d;)V", "onGiftTrayIdleStateListener", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "b", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "setDataCenter", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "dataCenter", "c", "Z", "isContainerVisible", "()Z", "setContainerVisible", "(Z)V", "isPortrait", "setPortrait", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseGiftTrayAnimationView extends MeasureOptFrameLayout {
    public static final /* synthetic */ int d = 0;
    public s02.d a;
    public DataCenter b;
    public boolean c;

    public static final class a implements Runnable {
        public final /* synthetic */ BaseGiftTrayAnimationView a;

        public a(BaseGiftTrayAnimationView r1) {
            this.a = r1;
        }

        public final void a() {
            MeasureOptFrameLayout r0 = this.a;
            int r1 = BaseGiftTrayAnimationView.d;
            r0.getClass();
            if (r0.getLocalVisibleRect(new Rect()) == false) goto L48;
            Iterator r2 = ViewUtilsKt.a(this.a).iterator();
            View r3 = null;
            int r4 = 0;
            View r5 = null;
            int r6 = 0;
            int r7 = 0;
        L6:
            if (r2.hasNext() == false) goto L16;
            View r8 = (View) r2.next();
            if (r8.getVisibility() != 0) goto L6;
            if (r6 != 0) goto L11;
        L12:
            r6 = r8.getTop();
            r3 = r8;
        L14:
            if (r8.getBottom() <= r7) goto L6;
            r7 = r8.getBottom();
            r5 = r8;
            goto L6
        L11:
            if (r6 <= r8.getTop()) goto L14;
        L16:
            int[] r9 = {0, 0};
            if (r3 == null) goto L19;
            r3.getLocationOnScreen(r9);
        L19:
            int r10 = r9[1];
            if ((!Intrinsics.areEqual(r5, r3)) == false) goto L23;
            if (r5 == null) goto L23;
            r5.getLocationOnScreen(r9);
        L23:
            int r11 = r9[1];
            if (r5 == null) goto L26;
            int r13 = r5.getMeasuredHeight();
        L27:
            int r14 = r11 + r13;
            int r15 = this.a.getPublicScreenHeight();
            int r16 = (s1.w() - r15) - this.a.getPublicScreenMarginBottom();
            if (r14 > r16) goto L31;
        L29:
            int r17 = 0;
        L34:
            if (r17 < 0) goto L49;
            if (r17 <= 0) goto L37;
            r4 = r17 + s1.f(18.0f);
        L37:
            com.bytedance.android.livesdk.revenue.service.interactivity.a r18 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.interactivity.a.class);
            if (r18 == null) goto L50;
            r18.oe(r4);
            return;
        L50:
            return;
        L49:
            return;
        L31:
            if (r10 >= (r15 + r16)) goto L29;
            r17 = r14 - Math.max(r16, r10);
            goto L34
        L26:
            r13 = 0;
            goto L27
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public BaseGiftTrayAnimationView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BaseGiftTrayAnimationView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public abstract void b();

    public abstract void c();

    public void d() {
    }

    public abstract boolean e();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract void j(int r1, boolean r2, boolean r3, User r4);

    public abstract void k(GiftTrayWidget.c r1, GiftTrayWidget.b r2);

    public abstract void l(boolean r1);

    public void setAboveDialog(h02.a r1) {
    }

    public void setBlockingState(boolean r1) {
    }

    public void setPortrait(boolean r1) {
    }

    public static boolean f() {
        ia0.b r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), ia0.b.class);
        if (r0 == null) goto L7;
        Pair r1 = r0.Y5();
        if (r1 == null) goto L7;
        RelativeEnterAnimPos r2 = (RelativeEnterAnimPos) r1.getSecond();
    L9:
        if (r2 != RelativeEnterAnimPos.DOWN) goto L11;
        return true;
    L11:
        return false;
    L7:
        r2 = null;
        goto L9
    }

    public final int getPublicScreenHeight() {
        Integer r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interactivity.b.class).B();
        if (r0 == null) goto L6;
        return r0.intValue();
    L6:
        return s1.f(197.0f);
    }

    public final int getPublicScreenMarginBottom() {
        Integer r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interactivity.b.class).mj();
        if (r0 == null) goto L6;
        return r0.intValue();
    L6:
        return s1.f(64.0f);
    }

    public DataCenter getDataCenter() {
        return this.b;
    }

    public s02.d getOnGiftTrayIdleStateListener() {
        return this.a;
    }

    public void setContainerVisible(boolean r1) {
        this.c = r1;
    }

    public void setDataCenter(DataCenter r1) {
        this.b = r1;
    }

    public void setOnGiftTrayIdleStateListener(s02.d r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(long r2, boolean r4) {
        if (r4 == false) goto L7;
        com.bytedance.android.livesdk.revenue.service.interactivity.a r3 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.interactivity.a.class);
        if (r3 == null) goto L14;
        r3.oe(0.0f);
        return;
    L14:
        return;
    L7:
        n01.a r5 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        if (r5 == null) goto L10;
        boolean r6 = r5.Q0(null);
    L11:
        if (r6 == false) goto L15;
        postDelayed(new a(this), r2);
        return;
    L15:
        return;
    L10:
        r6 = false;
        goto L11
    }

    public BaseGiftTrayAnimationView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = true;
    }

    public /* synthetic */ BaseGiftTrayAnimationView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static /* synthetic */ void n(BaseGiftTrayAnimationView r1, long r2, boolean r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = false;
    L8:
        r1.m(r2, r4);
    }
}
