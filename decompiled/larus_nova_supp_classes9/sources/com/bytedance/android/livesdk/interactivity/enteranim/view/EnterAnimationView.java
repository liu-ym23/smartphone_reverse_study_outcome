package com.bytedance.android.livesdk.interactivity.enteranim.view;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.HighlevelNoMessageMonitorEnum;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.RevenueUtils;
import com.bytedance.android.livesdk.widget.opt.MeasureOptFrameLayout;
import com.bytedance.ies.sdk.widgets.DataCenter;
import ec2.j1;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import r72.l;
import v72.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class EnterAnimationView extends MeasureOptFrameLayout {
    public v72.c a;
    public boolean b;

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
        v72.c r0 = this.a;
        x72.c r1 = r0.r;
        if (r1 == null) goto L5;
        r1.c.clear();
        ((ArrayList) r1.a).clear();
        r1.b = 0;
    L5:
        f r2 = r0.e;
        if (r2 == null) goto L8;
        r2.c.a.clear();
        r2.a.clear();
        r2.b.clear();
        v72.e r3 = r2.d;
        ((HashMap) r3.a).clear();
        ((HashMap) r3.b).clear();
        ((HashMap) r3.d).clear();
        ((HashMap) r3.c).clear();
        ((HashMap) r3.e).clear();
    L8:
        h32.a r4 = r0.j;
        if (r4 == null) goto L12;
        r4.c().a(r0.v);
        r0.j.d().a(r0.w);
        r0.j = null;
    L12:
        if (r0.d.getChildCount() <= 0) goto L17;
        View r5 = r0.d.getChildAt(0);
        UserEnterLevelView r6 = (UserEnterLevelView) r5.findViewById(2131392613);
        if (r6 == null) goto L16;
        r6.t = true;
    L16:
        r0.d.removeView(r5);
        goto L12
    L17:
        Animator r7 = r0.i;
        if (r7 == null) goto L20;
        r7.cancel();
        r0.i = null;
    L20:
        r0.A.removeCallbacksAndMessages(null);
        r0.n = 0;
        r0.o = false;
        r0.a = null;
        r0.p = 0;
        RevenueUtils r8 = r0.t;
        r8.a.dispose();
        r8.c().l0(r8.h);
        ((LinkedHashMap) r8.g).clear();
    }

    public u72.a getEntryController() {
        return this.a;
    }

    public EnterAnimationView(Context r2) {
        this(r2, null);
    }

    public final void b(k32.a r3) {
        if (this.b == true) goto L5;
    L9:
        z32.b.a(HighlevelNoMessageMonitorEnum.MemberDropCount);
        return;
    L5:
        if (r3.k == null) goto L7;
    L8:
        this.a.b(r3);
        return;
    L7:
        if (r3.h == (-1)) goto L9;
        goto L8
    }

    public void setChildMarginBottom(int r2) {
        v72.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.h = r2;
        return;
    }

    public void setDataCenter(DataCenter r8) {
        v72.c r0 = this.a;
        if (r0 == null) goto L19;
        r0.a = r8;
        DataCenter r2 = r0.a;
        Boolean r3 = Boolean.FALSE;
        r0.e = new f(((Boolean) r2.get("data_is_anchor", r3)).booleanValue());
        x72.c r1 = r0.r;
        if (r1 == null) goto L8;
        r1.c.clear();
        ((ArrayList) r1.a).clear();
        r1.b = 1;
        RxUtilKt.c(RxUtilKt.h(Observable.timer(x72.c.e, TimeUnit.MILLISECONDS)).subscribe(new x72.d(r1)), r1.c);
    L8:
        if (r0.q == null) goto L13;
        if (r8 == null) goto L13;
        if (((Boolean) r8.get("data_is_anchor", r3)).booleanValue() == false) goto L13;
        x72.a r4 = r0.q;
        x72.e r5 = new x72.e(r8);
        r4.a.add(r5);
    L13:
        InteractivityPlatformContext r9 = r0.b;
        if (r9 == null) goto L20;
        DataCenter r6 = r0.a;
        if (r6 == null) goto L21;
        r0.s.b(r9, r6);
        return;
    L21:
        return;
    L20:
        return;
    }

    public void setInteractivityContext(InteractivityPlatformContext r3) {
        v72.c r0 = this.a;
        if (r0 == null) goto L15;
        r0.b = r3;
        if (r3 == null) goto L9;
        h32.a r4 = (h32.a) r3.getDegradeManager().getValue();
        r0.j = r4;
        if (r4 == null) goto L9;
        r4.c().b(r0.v);
        r0.j.d().b(r0.w);
    L9:
        InteractivityPlatformContext r5 = r0.b;
        if (r5 == null) goto L16;
        DataCenter r1 = r0.a;
        if (r1 == null) goto L17;
        r0.s.b(r5, r1);
        return;
    L17:
        return;
    L16:
        return;
    }

    public void setUserEventListener(l r2) {
        v72.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.f = r2;
        return;
    }

    public EnterAnimationView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onVisibilityChanged(View r2, int r3) {
        super/*android.widget.FrameLayout*/.onVisibilityChanged(r2, r3);
        if (r3 != 0) goto L5;
        boolean r4 = true;
    L6:
        this.b = r4;
        v72.c r0 = this.a;
        if (r0 == null) goto L12;
        boolean r5 = true ^ r4;
        f r6 = r0.e;
        if (r6 == null) goto L13;
        r6.e = r5;
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r4 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EnterAnimationView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.b = true;
        boolean r5 = ((Boolean) j1.a.getValue()).booleanValue();
        this.a = new v72.c(r2, this);
        if (r5 == false) goto L6;
        setClipChildren(true);
        return;
    }
}
