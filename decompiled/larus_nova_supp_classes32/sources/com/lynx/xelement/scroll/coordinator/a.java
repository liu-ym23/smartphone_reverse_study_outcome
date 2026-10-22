package com.lynx.xelement.scroll.coordinator;

import com.google.android.material.appbar.AppBarLayout;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.b0;
import com.lynx.tasm.behavior.d0;
import com.lynx.tasm.utils.UIThreadUtils;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements AppBarLayout.OnOffsetChangedListener {
    public final /* synthetic */ BaseScrollCoordinator<BaseScrollCoordinatorAppBarLayout, ScrollCoordinatorToolbarLayout<Object>> a;

    public a(BaseScrollCoordinator<BaseScrollCoordinatorAppBarLayout, ScrollCoordinatorToolbarLayout<Object>> r1) {
        this.a = r1;
    }

    public final void onOffsetChanged(AppBarLayout r9, int r10) {
        this.a.P(r9, r10);
        if (Math.abs(this.a.e - r10) <= this.a.O()) goto L5;
        this.a.recognizeGesturere();
        this.a.e = r10;
    L5:
        d0 r11 = this.a.getLynxContext().getIntersectionObserverManager();
        if (r11 == null) goto L8;
        UIThreadUtils.runOnUiThreadImmediately(new b0(r11));
    L8:
        BaseScrollCoordinator<BaseScrollCoordinatorAppBarLayout, ScrollCoordinatorToolbarLayout<Object>> r12 = this.a;
        if (r12.b == true) goto L11;
        return;
    L11:
        int r13 = r12.N().getCollapsingToolbar().getHeight() - this.a.N().getPinnedToolbar().getHeight();
        if (r13 != 0) goto L14;
        return;
    L14:
        LLog.d("ScrollCoordinator", "onOffsetChanged: " + r10 + ", height = " + r13 + ' ');
        float r14 = (float) r13;
        float r0 = Math.abs((float) r10) / r14;
        float r1 = Math.abs(this.a.c - r0);
        BaseScrollCoordinator<BaseScrollCoordinatorAppBarLayout, ScrollCoordinatorToolbarLayout<Object>> r2 = this.a;
        if (r1 >= r2.d) goto L19;
        if (r0 >= 1.0f) goto L19;
        return;
    L19:
        if (r2.c != r0) goto L21;
        boolean r3 = true;
    L22:
        if (r3 == true) goto L30;
        EventEmitter r4 = r2.getLynxContext().getEventEmitter();
        m7a.a r5 = new m7a.a(this.a.getSign(), "offset");
        BaseScrollCoordinator<BaseScrollCoordinatorAppBarLayout, ScrollCoordinatorToolbarLayout<Object>> r6 = this.a;
        r6.getClass();
        if ((r6 instanceof LynxUIScrollCoordinator) == false) goto L27;
        r5.a("offset", Integer.valueOf(BaseScrollCoordinator.M(r6, Math.abs(r10))));
        r5.a("height", Integer.valueOf(BaseScrollCoordinator.M(r6, r14)));
    L28:
        r4.sendCustomEvent(r5);
        this.a.c = r0;
        return;
    L27:
        StringCompanionObject r15 = StringCompanionObject.INSTANCE;
        r5.a("offset", String.format(Locale.ENGLISH, "%.5f", Arrays.copyOf(new Object[]{Float.valueOf(r0)}, 1)));
        goto L28
    L30:
        return;
    L21:
        r3 = false;
        goto L22
    }
}
