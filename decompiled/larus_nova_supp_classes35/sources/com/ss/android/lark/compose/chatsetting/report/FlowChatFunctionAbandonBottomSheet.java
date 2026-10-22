package com.ss.android.lark.compose.chatsetting.report;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ss.android.lark.chameleon.util.AppInfoUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FlowChatFunctionAbandonBottomSheet {
    public final Activity a;
    public e b;
    public b c;
    public final Lazy d;
    public c e;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Data(mainTitle=" + this.a + ", subTitle=" + this.b + ')';
        }

        public b() {
            this(BuildConfig.FLAVOR, BuildConfig.FLAVOR);
        }

        public b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "mainTitle");
            Intrinsics.checkNotNullParameter(r3, "subTitle");
            this.a = r2;
            this.b = r3;
        }
    }

    public interface c {
        void onDismiss();
    }

    public static final class d {
        public final View a;
        public final LinearLayout b;
        public final View c;

        public d(View r2) {
            Intrinsics.checkNotNullParameter(r2, "rootView");
            this.a = r2;
            this.b = (LinearLayout) r2.findViewById(2131364516);
            this.c = r2.findViewById(2131364522);
        }
    }

    public static final class e {
        public final View a;
        public final ImageView b;
        public final TextView c;
        public final TextView d;
        public final TextView e;

        public e(View r2) {
            Intrinsics.checkNotNullParameter(r2, "rootView");
            this.a = r2;
            this.b = (ImageView) r2.findViewById(2131373927);
            this.c = (TextView) r2.findViewById(2131379478);
            this.d = (TextView) r2.findViewById(2131387553);
            this.e = (TextView) r2.findViewById(2131364746);
        }
    }

    public static final class f implements Animator.AnimatorListener {
        public final /* synthetic */ FlowChatFunctionAbandonBottomSheet a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        public f(FlowChatFunctionAbandonBottomSheet r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.a.b().a.setVisibility(8);
            c r3 = this.a.e;
            if (r3 == null) goto L6;
            r3.onDismiss();
            return;
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ FlowChatFunctionAbandonBottomSheet a;

        public g(FlowChatFunctionAbandonBottomSheet r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.a();
        }
    }

    static {
    }

    public final void a() {
        AnimatorSet r0 = new AnimatorSet().setDuration(200);
        r0.addListener(new f(this));
        r0.playTogether(new Animator[]{ObjectAnimator.ofFloat(b().b, "translationY", new float[]{0.0f, b().b.getHeight()}).setDuration(200), ObjectAnimator.ofFloat(b().c, AppInfoUtils.VERSION_TYPE.VERSION_ALPHA, new float[]{1.0f, 0.0f}).setDuration(200)});
        r0.start();
    }

    public final d b() {
        return (d) this.d.getValue();
    }

    public final void c() {
        e r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        b r1 = this.c;
        if (r1 != null) goto L8;
        return;
    L8:
        Context r2 = r0.b.getContext();
        ImageView r3 = r0.b;
        Intrinsics.checkNotNull(r2);
        r3.setImageDrawable(new FlowChatFunctionAbandonWarningDrawable(r2));
        r0.c.setText(r1.a);
        r0.c.setVisibility(0);
        if (r1.b.length() <= 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L14;
        r0.d.setText(r1.b);
        r0.d.setVisibility(0);
    L15:
        r0.e.setOnClickListener(new g(this));
        return;
    L14:
        r0.d.setVisibility(8);
        goto L15
    L11:
        r4 = false;
        goto L12
    }

    public final Activity getActivity() {
        return this.a;
    }

    public FlowChatFunctionAbandonBottomSheet(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
        this.d = LazyKt.lazy(new FlowChatFunctionAbandonBottomSheet$rootViewHolder$2(this));
    }
}
