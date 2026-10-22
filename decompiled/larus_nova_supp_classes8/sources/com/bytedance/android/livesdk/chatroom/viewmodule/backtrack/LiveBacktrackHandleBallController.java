package com.bytedance.android.livesdk.chatroom.viewmodule.backtrack;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.RecordDragContainer;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.RecordDragParentView;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.q;
import com.bytedance.android.livesdk.chatroom.widget.LiveCircleProgressView;
import com.bytedance.android.livesdk.config.cg;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.ReverseHorizontalLinearLayout;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveBacktrackHandleBallController {
    public boolean a;
    public int b;
    public final ReverseHorizontalLinearLayout c;
    public final View d;
    public final LiveCircleProgressView e;
    public final TextView f;
    public final TextView g;
    public final q h;
    public final b i;
    public Disposable j;
    public final q4.b k;
    public final com.bytedance.android.livesdk.chatroom.viewmodule.backtrack.a l;
    public final RecordDragParentView m;
    public final RecordDragContainer n;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LiveBacktrackHandleBallController a;

        public b(LiveBacktrackHandleBallController r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void b() {
        d(0);
        RecordDragParentView r1 = this.m;
        View r2 = r1.a;
        if (r2 == null) goto L5;
        r1.removeView(r2);
    L5:
        r1.a = null;
        UtilityKotlinExtentionsKt.t(this.m);
        this.c.setReverse(false);
        this.b = 0;
        Disposable r0 = this.j;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        this.j = null;
    }

    public final void a() {
        if (this.a == false) goto L5;
        return;
    L5:
        this.a = true;
        this.n.setEnableDrag(true);
        Disposable r0 = this.j;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        this.j = null;
        u4.c(new LiveBacktrackHandleBallController$createLeftBallCollapseAnimator$1(this)).c();
    }

    public final void c(boolean r5) {
        b();
        this.n.setDragParentView(this.m);
        if (this.l.isPortrait() == false) goto L5;
        this.m.b(this.n);
    L6:
        if (r5 == false) goto L9;
        a();
    L19:
        UtilityKotlinExtentionsKt.w(this.m);
        u4.a(this.k);
        return;
    L9:
        if (this.a == false) goto L19;
        this.a = false;
        this.n.setEnableDrag(false);
        q r6 = this.h;
        r6.setAlpha((int) 178.5f);
        r6.a(UtilityKotlinExtentionsKt.i(146));
        this.g.setAlpha(1.0f);
        UtilityKotlinExtentionsKt.w(this.g);
        UIUtils.setLayoutParams(this.c, UtilityKotlinExtentionsKt.i(146), UtilityKotlinExtentionsKt.i(40));
        if (this.b != 1) goto L15;
        this.n.setX((this.m.getWidth() - this.m.getAreaMarginRight()) - UtilityKotlinExtentionsKt.i(146));
    L15:
        Disposable r7 = this.j;
        if (r7 == null) goto L18;
        r7.dispose();
    L18:
        this.j = null;
        this.j = AndroidSchedulers.mainThread().scheduleDirect(this.i, 2000, TimeUnit.MILLISECONDS);
        goto L19
    L5:
        RecordDragParentView r0 = this.m;
        RecordDragContainer r1 = this.n;
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-2, -2);
        r2.gravity = 81;
        Unit r3 = Unit.INSTANCE;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "dragView");
        Intrinsics.checkNotNullParameter(r2, "layoutParams");
        r0.addView(r1, r2);
        r0.a = r1;
        goto L6
    }

    public final void d(int r3) {
        this.e.setProgress(r3);
        TextView r0 = this.f;
        StringBuilder r1 = new StringBuilder();
        r1.append(r3);
        r1.append('%');
        r0.setText(r1.toString());
    }

    public LiveBacktrackHandleBallController(com.bytedance.android.livesdk.chatroom.viewmodule.backtrack.a r8, RecordDragParentView r9, RecordDragContainer r10) {
        Intrinsics.checkNotNullParameter(r8, "bridge");
        Intrinsics.checkNotNullParameter(r9, "dragParentView");
        Intrinsics.checkNotNullParameter(r10, "handleBall");
        this.l = r8;
        this.m = r9;
        this.n = r10;
        this.a = true;
        ReverseHorizontalLinearLayout r1 = r10.findViewById(2131374187);
        this.c = r1;
        View r2 = r10.findViewById(2131383324);
        this.d = r2;
        LiveCircleProgressView r3 = (LiveCircleProgressView) r10.findViewById(2131383333);
        this.e = r3;
        this.f = (TextView) r10.findViewById(2131384023);
        TextView r4 = (TextView) r10.findViewById(2131391507);
        this.g = r4;
        q r5 = new q();
        r5.setAlpha((int) 178.5f);
        r5.a(UtilityKotlinExtentionsKt.i(146));
        Unit r6 = Unit.INSTANCE;
        this.h = r5;
        this.i = new b(this);
        this.k = u4.c(new LiveBacktrackHandleBallController$showAnimator$1(this));
        r1.setReverse(false);
        r1.setBackground(r5);
        r2.setOnClickListener(x0.a(new AnonymousClass1(this)));
        r10.setOnMoveToSideListener(new AnonymousClass2(this));
        r9.setOnOtherAreaTouchListener(new AnonymousClass3(this));
        if (r8.isPortrait() == true) goto L5;
        r10.setEnableDrag(false);
    L5:
        r3.setProgressColor(-1);
        r3.setBgCircleColor(s1.h(2131108573));
        r3.setCircleWidth(UtilityKotlinExtentionsKt.i(3));
        r3.setBgCircleWidth(UtilityKotlinExtentionsKt.i(3));
        if (r8.isAnchor() == false) goto L8;
        r4.setText(s1.B(2131915233));
        return;
    L8:
        r4.setText(s1.C(2131915234, new Object[]{cg.a.getValue()}));
    }
}
