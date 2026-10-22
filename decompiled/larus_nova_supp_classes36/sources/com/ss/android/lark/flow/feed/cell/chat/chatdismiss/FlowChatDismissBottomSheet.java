package com.ss.android.lark.flow.feed.cell.chat.chatdismiss;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowChatDismissBottomSheet {
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
        public final String c;
        public final String d;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "Data(avatarKey=" + this.a + ", entityId=" + this.b + ", mainTitle=" + this.c + ", subTitle=" + this.d + ')';
        }

        public b() {
            this("", "", "", "");
        }

        public b(String r2, String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "avatarKey");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "mainTitle");
            Intrinsics.checkNotNullParameter(r5, "subTitle");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public interface c {
        void h4(String r1);
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
        public final ImageView f;

        public e(View r2) {
            Intrinsics.checkNotNullParameter(r2, "rootView");
            this.a = r2;
            this.b = (ImageView) r2.findViewById(2131373927);
            this.c = (TextView) r2.findViewById(2131379478);
            this.d = (TextView) r2.findViewById(2131387553);
            this.e = (TextView) r2.findViewById(2131364746);
            this.f = (ImageView) r2.findViewById(2131374734);
        }
    }

    public static final class f implements Animator.AnimatorListener {
        public final /* synthetic */ FlowChatDismissBottomSheet a;
        public final /* synthetic */ String b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.a.b().a.setVisibility(8);
            c r3 = this.a.e;
            if (r3 == null) goto L6;
            r3.h4(this.b);
            return;
        }

        public f(FlowChatDismissBottomSheet r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ FlowChatDismissBottomSheet a;

        public g(FlowChatDismissBottomSheet r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.a("click_btn_know");
        }
    }

    static {
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
        String r4 = r1.a;
        String r5 = r1.b;
        com.ss.android.lark.chat.utils.g.e(r0.a.getContext(), r0.b, r4, r5, UIHelper.dp2px(56.0f), UIHelper.dp2px(56.0f), Scene.Chat);
        r0.c.setText(r1.c);
        r0.c.setVisibility(0);
        if (r1.d.length() <= 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        r0.d.setText(r1.d);
        r0.d.setVisibility(0);
    L15:
        Context r3 = r0.a.getContext();
        if (r3 == null) goto L18;
        r0.f.setImageDrawable(new FlowChatDismissDialogWarningDrawable(r3));
    L18:
        r0.e.setOnClickListener(new g(this));
        return;
    L14:
        r0.d.setVisibility(8);
        goto L15
    L11:
        r2 = false;
        goto L12
    }

    public final Activity getActivity() {
        return this.a;
    }

    public FlowChatDismissBottomSheet(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
        this.d = LazyKt.lazy(new FlowChatDismissBottomSheet$rootViewHolder$2(this));
    }

    public final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        AnimatorSet r0 = new AnimatorSet().setDuration(300);
        r0.addListener(new f(this, r10));
        r0.playTogether(new Animator[]{ObjectAnimator.ofFloat(b().b, "translationY", new float[]{0.0f, b().b.getHeight()}).setDuration(300), ObjectAnimator.ofFloat(b().c, "alpha", new float[]{1.0f, 0.0f}).setDuration(300)});
        r0.start();
    }
}
