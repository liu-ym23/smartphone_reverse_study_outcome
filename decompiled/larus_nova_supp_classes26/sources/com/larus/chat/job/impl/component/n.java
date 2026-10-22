package com.larus.chat.job.impl.component;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.larus.platform.api.e4;
import com.larus.platform.api.f4;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n implements f4 {
    public final /* synthetic */ com.larus.chat.job.impl.page.i.a a;
    public final /* synthetic */ ChatJobLynxItemComponent b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
    public final /* synthetic */ String e;

    public final void a() {
    }

    public final void d(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    public final void f() {
    }

    public final void onLoadStart() {
    }

    public final void b(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("ivy onFallback cardType=");
        int r2 = ChatJobLynxItemComponent.r;
        r1.append(ChatJobLynxItemComponent.a.a(this.a));
        r1.append(" job=");
        r1.append(ChatJobLynxItemComponent.a.b(this.a.a));
        r0.e("ChatJobLynxItem", r1.toString(), r4);
        if (ChatJobLynxItemComponent.F2(this.b, this.c, this.d) == false) goto L6;
        this.b.N2();
        return;
    }

    public final void c(BulletContainerView r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if (ChatJobLynxItemComponent.F2(this.b, this.c, this.d) == false) goto L8;
        ChatJobLynxItemComponent r4 = this.b;
        String r0 = this.e;
        e4 r5 = r4.m;
        if (r5 == null) goto L9;
        r5.updateData(r0);
        return;
    L9:
        return;
    }

    public final void e(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("ivy onLoadFail cardType=");
        int r2 = ChatJobLynxItemComponent.r;
        r1.append(ChatJobLynxItemComponent.a.a(this.a));
        r1.append(" job=");
        r1.append(ChatJobLynxItemComponent.a.b(this.a.a));
        r0.e("ChatJobLynxItem", r1.toString(), r4);
        if (ChatJobLynxItemComponent.F2(this.b, this.c, this.d) == false) goto L6;
        this.b.N2();
        return;
    }

    public final void onLoadSuccess(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        if (ChatJobLynxItemComponent.F2(this.b, this.c, this.d) == false) goto L8;
        ChatJobLynxItemComponent r0 = this.b;
        r0.l.setMinimumHeight(0);
        r0.o = null;
        r0.l.removeAllViews();
        r0.l.addView(r5, new FrameLayout.LayoutParams(-1, -2));
        ChatJobLynxItemComponent r6 = this.b;
        String r1 = this.e;
        e4 r7 = r6.m;
        if (r7 == null) goto L9;
        r7.updateData(r1);
        return;
    L9:
        return;
    }

    public n(com.larus.chat.job.impl.page.i.a r1, ChatJobLynxItemComponent r2, String r3, int r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
