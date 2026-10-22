package com.bytedance.android.live.room.api.panel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.live.core.log.ALogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class PanelCoverListener implements com.bytedance.android.live.room.api.panel.a {
    public List<e> a;
    public final Lazy b;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ PanelCoverListener a;

        public b(PanelCoverListener r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2);
            ALogger.i("PanelCoverListener", "listener = " + this.a.getName() + ", onAnimationEnd GONE");
            View r3 = this.a.d();
            if (r3 == null) goto L6;
            r3.setVisibility(8);
            return;
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ PanelCoverListener a;

        public c(PanelCoverListener r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationStart(r2);
            ALogger.i("PanelCoverListener", "listener = " + this.a.getName() + ", onAnimationStart VISIBLE");
            View r3 = this.a.d();
            if (r3 == null) goto L6;
            r3.setVisibility(0);
            return;
        }
    }

    static {
    }

    public void f() {
        ALogger.i("PanelCoverListener", "hide, listener = " + getName());
        if (((Number) this.b.getValue()).intValue() != 1) goto L8;
        ALogger.i("PanelCoverListener", "hide, opt type = 1, GONE");
        View r0 = d();
        if (r0 == null) goto L23;
        r0.setVisibility(8);
        return;
    L23:
        return;
    L8:
        View r1 = d();
        if (r1 == null) goto L24;
        ViewPropertyAnimator r2 = r1.animate();
        if (r2 != null) goto L13;
        return;
    L13:
        if (((Number) this.b.getValue()).intValue() != 2) goto L15;
        ALogger.i("PanelCoverListener", "opt type = 2, call withLayer");
        r2.withLayer();
    L15:
        ViewPropertyAnimator r3 = r2.alpha(0.0f);
        if (r3 == null) goto L26;
        ViewPropertyAnimator r4 = r3.setDuration(200);
        if (r4 == null) goto L27;
        ViewPropertyAnimator r5 = r4.setListener(new b(this));
        if (r5 == null) goto L28;
        r5.start();
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    }

    public void g() {
        ALogger.i("PanelCoverListener", "show, listener = " + getName());
        if (((Number) this.b.getValue()).intValue() != 1) goto L8;
        ALogger.i("PanelCoverListener", "show, opt type = 1, VISIBLE");
        View r0 = d();
        if (r0 == null) goto L23;
        r0.setVisibility(0);
        return;
    L23:
        return;
    L8:
        View r1 = d();
        if (r1 == null) goto L24;
        ViewPropertyAnimator r2 = r1.animate();
        if (r2 != null) goto L13;
        return;
    L13:
        if (((Number) this.b.getValue()).intValue() != 2) goto L15;
        ALogger.i("PanelCoverListener", "opt type = 2, call withLayer");
        r2.withLayer();
    L15:
        ViewPropertyAnimator r3 = r2.alpha(1.0f);
        if (r3 == null) goto L26;
        ViewPropertyAnimator r4 = r3.setDuration(200);
        if (r4 == null) goto L27;
        ViewPropertyAnimator r5 = r4.setListener(new c(this));
        if (r5 == null) goto L28;
        r5.start();
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    }

    public PanelCoverListener() {
        this.b = LazyKt.lazy(PanelCoverListener$optType$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.room.api.panel.a
    public final void a(final e r4) {
        Intrinsics.checkNotNullParameter(r4, "panelInfo");
        List<e> r0 = this.a;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        ALogger.i("PanelCoverListener", "onPanelClose, hidePanelInfoList is null or empty");
        return;
    L12:
        Function1<e, Boolean> r2 = new PanelCoverListener$onPanelClose$1(r4);
        ArrayList r3 = (ArrayList) r0;
        Iterator r5 = r3.iterator();
    L14:
        if (r5.hasNext() == false) goto L19;
        if (((Boolean) r2.invoke(r5.next())).booleanValue() == false) goto L14;
        r5.remove();
        goto L14
    L19:
        if (r3.isEmpty() == false) goto L27;
        g();
        return;
    L27:
        return;
    L5:
        if (((ArrayList) r0).isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.room.api.panel.a
    public final void b(e r2) {
        Intrinsics.checkNotNullParameter(r2, "panelInfo");
        if (e(r2) == true) goto L5;
        return;
    L5:
        if (this.a != null) goto L7;
        this.a = new ArrayList();
    L7:
        List<e> r0 = this.a;
        if (r0 != null) goto L10;
    L12:
        List<e> r1 = this.a;
        if (r1 == null) goto L17;
        ((ArrayList) r1).add(r2);
        return;
    L17:
        return;
    L10:
        if (((ArrayList) r0).size() != 0) goto L12;
        f();
        goto L12
    }

    @Override // com.bytedance.android.live.room.api.panel.a
    public final void c(RemoveReason r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        ALogger.i("PanelCoverListener", getName() + " remove, reason = " + r3.getReason());
        List<e> r4 = this.a;
        if (r4 == null) goto L5;
        int r5 = ((ArrayList) r4).size();
    L6:
        if (r5 <= 0) goto L13;
        ALogger.i("PanelCoverListener", "hidePanelInfoList size > 0");
        View r6 = d();
        if (r6 == null) goto L10;
        r6.setVisibility(0);
    L10:
        View r7 = d();
        if (r7 == null) goto L13;
        r7.setAlpha(1.0f);
    L13:
        List<e> r8 = this.a;
        if (r8 == null) goto L17;
        ((ArrayList) r8).clear();
        return;
    L17:
        return;
    L5:
        r5 = 0;
        goto L6
    }
}
