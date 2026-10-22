package com.bytedance.android.live.profile.ui.component;

import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k implements Runnable {
    public final /* synthetic */ ProfileDynamicOperateComponent a;
    public final /* synthetic */ List b;

    public k(ProfileDynamicOperateComponent r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        ViewParent r1 = null;
        if (this.b.size() == 1) goto L31;
        ProfileDynamicOperateComponent r0 = this.a;
        List r3 = this.b;
        r0.getClass();
        if (r3.isEmpty() == false) goto L7;
        LinearLayout r4 = null;
    L8:
        if (r4 == null) goto L17;
        com.bytedance.android.live.profile.ui.util.v.a r2 = com.bytedance.android.live.profile.ui.util.v.b;
        LinearLayout r5 = this.a.n();
        if (r5 == null) goto L12;
        Object r6 = r5.getParent();
    L14:
        if ((r6 instanceof View) == true) goto L16;
        r6 = null;
    L16:
        int r7 = ProfileDynamicOperateComponent.D;
        int r8 = ProfileDynamicOperateComponent.E;
        int r9 = ProfileDynamicOperateComponent.G;
        r2.getClass();
        com.bytedance.android.live.profile.ui.util.v.a.a(r4, (View) r6, r7, r8, 0, r9);
        goto L17
    L12:
        r6 = null;
    L17:
        ProfileDynamicOperateComponent r10 = this.a;
        List r12 = this.b;
        r10.getClass();
        if (r12.size() > 1) goto L20;
        LinearLayout r13 = null;
    L21:
        if (r13 == null) goto L46;
        com.bytedance.android.live.profile.ui.util.v.a r14 = com.bytedance.android.live.profile.ui.util.v.b;
        LinearLayout r15 = this.a.n();
        if (r15 == null) goto L25;
        ViewParent r16 = r15.getParent();
    L27:
        if ((r16 instanceof View) == false) goto L30;
        r1 = r16;
    L30:
        int r17 = ProfileDynamicOperateComponent.E;
        int r18 = ProfileDynamicOperateComponent.F;
        int r19 = ProfileDynamicOperateComponent.G;
        r14.getClass();
        com.bytedance.android.live.profile.ui.util.v.a.a(r13, (View) r1, 0, r17, r18, r19);
        return;
    L25:
        r16 = null;
        goto L27
    L46:
        return;
    L20:
        r13 = (LinearLayout) r10.g.getValue();
        goto L21
    L7:
        r4 = r0.p();
        goto L8
    L31:
        ProfileDynamicOperateComponent r20 = this.a;
        List r22 = this.b;
        r20.getClass();
        if (r22.isEmpty() == false) goto L34;
        LinearLayout r23 = null;
    L35:
        if (r23 == null) goto L48;
        com.bytedance.android.live.profile.ui.util.v.a r24 = com.bytedance.android.live.profile.ui.util.v.b;
        LinearLayout r25 = this.a.n();
        if (r25 == null) goto L39;
        ViewParent r26 = r25.getParent();
    L41:
        if ((r26 instanceof View) == false) goto L44;
        r1 = r26;
    L44:
        int r27 = ProfileDynamicOperateComponent.D;
        int r28 = ProfileDynamicOperateComponent.E;
        int r29 = ProfileDynamicOperateComponent.F;
        int r30 = ProfileDynamicOperateComponent.G;
        r24.getClass();
        com.bytedance.android.live.profile.ui.util.v.a.a(r23, (View) r1, r27, r28, r29, r30);
        return;
    L39:
        r26 = null;
        goto L41
    L48:
        return;
    L34:
        r23 = r20.p();
        goto L35
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
