package c91;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.message.model.j4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final int l = 0;
    public final FrameLayout a;
    public final View b;
    public final ImageView c;
    public final HSImageView d;
    public final TextView e;
    public final TextView f;
    public final HSImageView g;
    public AnimatorSet h;
    public final ImageView i;
    public final List<j4> j;
    public int k;

    /* JADX INFO: renamed from: c91.a$a, reason: collision with other inner class name */
    public static final class C0010a {
    }

    static {
        l = s1.f(17.0f);
    }

    public final void a(j4 r18) {
        Intrinsics.checkNotNullParameter(r18, "message");
        AnimatorSet r2 = this.h;
        if (r2 != null) goto L5;
    L8:
        py.k r3 = null;
        o r5 = z51.a.h(null, 3);
        if (r5 == null) goto L17;
        com.bytedance.live.datacontext.m r6 = r5.getRoom();
        if (r6 == null) goto L17;
        IRoom r7 = (IRoom) r6.getValue();
        if (r7 == null) goto L17;
        IBaseUser r8 = r7.getOwner();
        if (r8 == null) goto L17;
        r3 = r8.getAvatarThumbKt();
    L17:
        this.e.setText(r18.P());
        this.a.setAlpha(0.9f);
        this.f.setText(sb2.a.h(r18.E(), "", false));
        if (this.b.getWidth() >= s1.f(140.0f)) goto L20;
        int r9 = s1.f(140.0f);
    L21:
        int r10 = l;
        this.k = r9 - r10;
        ImageUtil.loadImage(this.g, r18.H(), new m(this, r18));
        ImageUtil.loadRoundImage(this.d, r3);
        UIUtils.updateLayoutMargin(this.g, this.k - s1.f(20.0f), s1.f(2.0f), 0, 0);
        this.a.setOnClickListener(new n(r18));
        AnimatorSet r1 = this.h;
        if (r1 != null) goto L24;
    L26:
        AnimatorSet r4 = new AnimatorSet();
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r12.setDuration(100);
        r12.addUpdateListener(new d(this));
        Unit r13 = Unit.INSTANCE;
        ValueAnimator r14 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r14.setDuration(200);
        r14.addUpdateListener(new e(this));
        r14.addListener(new f(this));
        int r15 = this.k;
        ValueAnimator r16 = ValueAnimator.ofInt(new int[]{r15, r15 + r10});
        r16.setDuration(100);
        r16.setStartDelay(100);
        r16.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        r16.addUpdateListener(new g(this));
        ObjectAnimator r17 = ObjectAnimator.ofFloat(this.e, "translationX", new float[]{s1.f(-128.0f), 0.0f});
        r17.setDuration(200);
        r17.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        r17.addUpdateListener(new h(this));
        ObjectAnimator r19 = ObjectAnimator.ofFloat(this.f, "translationX", new float[]{s1.f(-128.0f), 0.0f});
        r19.setDuration(200);
        r19.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        r19.addUpdateListener(new i(this));
        ObjectAnimator r20 = ObjectAnimator.ofFloat(this.g, "translationX", new float[]{s1.f(-128.0f), 0.0f});
        r20.setDuration(200);
        r20.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        ObjectAnimator r22 = ObjectAnimator.ofFloat(this.i, "translationX", new float[]{s1.f(-128.0f), 0.0f});
        r22.setDuration(200);
        r22.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        r4.playTogether(new Animator[]{r12, r14, r16, r17, r19, r20, r22});
        AnimatorSet r23 = new AnimatorSet();
        ValueAnimator r110 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r110.setDuration(150);
        r110.addUpdateListener(new j(this));
        ValueAnimator r111 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r111.setDuration(150);
        r111.setStartDelay(50);
        r111.addUpdateListener(new k(this));
        r111.addListener(new l(this));
        int r112 = this.k;
        ValueAnimator r24 = ValueAnimator.ofInt(new int[]{r10 + r112, r112});
        r24.setDuration(150);
        r24.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        r24.addUpdateListener(new b(this));
        ObjectAnimator r25 = ObjectAnimator.ofFloat(this.e, "translationX", new float[]{0.0f, s1.f(-20.0f)});
        r25.setDuration(150);
        r25.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        ObjectAnimator r26 = ObjectAnimator.ofFloat(this.f, "translationX", new float[]{0.0f, s1.f(-20.0f)});
        r26.setDuration(150);
        r26.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        ObjectAnimator r27 = ObjectAnimator.ofFloat(this.i, "translationX", new float[]{0.0f, s1.f(-20.0f)});
        r27.setDuration(150);
        r27.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        ObjectAnimator r28 = ObjectAnimator.ofFloat(this.g, "translationX", new float[]{0.0f, s1.f(-20.0f)});
        r28.setDuration(150);
        r28.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        r23.playTogether(new Animator[]{r110, r111, r24, r25, r26, r27, r28});
        AnimatorSet r29 = new AnimatorSet();
        r23.setStartDelay(3000);
        r29.playSequentially(new Animator[]{r4, r23});
        r29.addListener(new c(this));
        r29.start();
        this.h = r29;
        return;
    L24:
        if (r1.isRunning() != true) goto L26;
        return;
    L20:
        r9 = this.b.getWidth();
        goto L21
    L5:
        if (r2.isRunning() != true) goto L8;
        ((ArrayList) this.j).add(r18);
    }

    public a(FrameLayout r10, View r12) {
        Intrinsics.checkNotNullParameter(r10, "containerView");
        Intrinsics.checkNotNullParameter(r12, "contentView");
        this.a = r10;
        this.b = r12;
        this.j = new ArrayList();
        ViewParent r0 = r10.getParent();
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L8;
        r1.bringToFront();
    L8:
        r10.getLayoutParams().width = r12.getLayoutParams().width;
        r10.setVisibility(8);
        ImageView r2 = new ImageView(r10.getContext());
        r2.setBackgroundResource(2131249161);
        Unit r3 = Unit.INSTANCE;
        r10.addView(r2, new FrameLayout.LayoutParams(-1, -1));
        this.c = r2;
        TextView r4 = new TextView(r10.getContext());
        r4.setTextSize(1, 12.0f);
        r4.setTextColor(-1);
        r4.setAlpha(0.9f);
        r4.setMaxLines(1);
        r4.setSingleLine(true);
        r4.setGravity(8388613);
        r4.setEllipsize(null);
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-2, -2);
        r5.topMargin = s1.f(3.0f);
        r5.leftMargin = s1.f(38.0f);
        r10.addView(r4, r5);
        this.e = r4;
        TextView r6 = new TextView(r10.getContext());
        r6.setTextSize(1, 10.0f);
        r6.setTextColor(-1);
        r6.setAlpha(0.7f);
        r6.setMaxLines(1);
        r6.setSingleLine(true);
        r6.setGravity(8388613);
        r6.setEllipsize(null);
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-2, -2);
        r7.topMargin = s1.f(18.0f);
        r7.leftMargin = s1.f(38.0f);
        r10.addView(r6, r7);
        this.f = r6;
        ImageView r8 = new ImageView(r10.getContext());
        r8.setBackgroundResource(2131249894);
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(-2, -2);
        r9.topMargin = s1.f(6.0f);
        r9.leftMargin = s1.f(38.0f);
        r10.addView(r8, r9);
        this.i = r8;
        View r13 = new HSImageView(r10.getContext());
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(s1.f(32.0f), s1.f(32.0f));
        r14.topMargin = s1.f(1.0f);
        r14.leftMargin = r12.getWidth() - s1.f(20.0f);
        r10.addView(r13, r14);
        this.g = r13;
        View r15 = new HSImageView(r10.getContext());
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(s1.f(32.0f), s1.f(32.0f));
        r16.topMargin = s1.f(1.0f);
        r16.leftMargin = s1.f(2.0f);
        r10.addView(r15, r16);
        this.d = r15;
    }
}
