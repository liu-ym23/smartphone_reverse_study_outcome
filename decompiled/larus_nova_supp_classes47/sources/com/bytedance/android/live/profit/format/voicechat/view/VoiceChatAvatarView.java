package com.bytedance.android.live.profit.format.voicechat.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/view/VoiceChatAvatarView;", "Landroid/widget/FrameLayout;", "", "scale", "", "setTagMargin", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VoiceChatAvatarView extends FrameLayout {
    public static final String h = null;
    public static final String i = null;
    public static final float j = 0.0f;
    public final ImageView a;
    public final ImageView b;
    public final CircleProgressView c;
    public final HSImageView d;
    public Disposable e;
    public final ImageView f;
    public final HSImageView g;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ VoiceChatAvatarView a;
        public final /* synthetic */ boolean b;

        public b(VoiceChatAvatarView r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r6) {
            Intrinsics.checkNotNullParameter(r6, "anim");
            Object r7 = r6.getAnimatedValue();
            if (r7 == null) goto L34;
            float r8 = ((Float) r7).floatValue();
            float r0 = 1;
            float r1 = (0.40310073f * r8) + r0;
            ImageView r2 = this.a.a;
            if (r2 == null) goto L7;
            r2.setAlpha(r0 - ((r0 - r8) * 0.2f));
        L7:
            ImageView r3 = this.a.f;
            if (r3 == null) goto L12;
            Drawable r4 = r3.getDrawable();
            if (r4 == null) goto L12;
            r4.setAlpha(MathKt.roundToInt((r0 - ((r0 - r8) * 0.5f)) * 255));
        L12:
            ImageView r5 = this.a.a;
            if (r5 == null) goto L15;
            r5.setScaleX(r1);
            r5.setScaleY(r1);
        L15:
            ImageView r9 = this.a.b;
            if (r9 == null) goto L18;
            r9.setScaleX(r1);
            r9.setScaleY(r1);
        L18:
            ImageView r10 = this.a.f;
            if (r10 == null) goto L21;
            r10.setScaleX(r1);
            r10.setScaleY(r1);
        L21:
            CircleProgressView r12 = this.a.c;
            if (r12 == null) goto L24;
            r12.setScaleX(r1);
            r12.setScaleY(r1);
        L24:
            VoiceChatAvatarView.a(this.a, r1);
            if (this.b == false) goto L29;
            CircleProgressView r13 = this.a.c;
            if (r13 == null) goto L35;
            r13.setProgress(r8);
            return;
        L35:
            return;
        L29:
            ImageView r14 = this.a.a;
            if (r14 == null) goto L37;
            r14.invalidate();
            return;
        L37:
            return;
        L34:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class c implements Animator.AnimatorListener {
        public final /* synthetic */ VoiceChatAvatarView a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        public c(VoiceChatAvatarView r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animator");
            ImageView r4 = this.a.b;
            if (r4 == null) goto L6;
            UtilityKotlinExtentionsKt.e(r4, 200);
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animator");
            ImageView r4 = this.a.b;
            if (r4 == null) goto L5;
            r4.setAlpha(0.0f);
        L5:
            ImageView r5 = this.a.b;
            if (r5 == null) goto L9;
            UtilityKotlinExtentionsKt.d(r5, 200);
            return;
        }
    }

    public VoiceChatAvatarView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VoiceChatAvatarView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    static {
        StringBuilder r0 = new StringBuilder("https://");
        LiveCommonConstants r2 = LiveCommonConstants.INSTANCE;
        r0.append(r2.getObjectTosPath());
        r0.append("/obj/live-android/voice_chat_voice_wave_v2.webp");
        h = r0.toString();
        i = "https://" + r2.getObjectTosPath() + "/obj/live-android/voice_chat_thinking.webp";
        j = UtilityKotlinExtentionsKt.h(45.5f);
    }

    private final void setTagMargin(float r5) {
        ImageView r0 = this.f;
        if (r0 == null) goto L11;
        if (r0 == null) goto L6;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
    L7:
        if (r1 == null) goto L10;
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;
        float r3 = j;
        r2.topMargin = MathKt.roundToInt(r3 * r5);
        r2.leftMargin = MathKt.roundToInt(r3 * r5);
        Unit r6 = Unit.INSTANCE;
        r0.setLayoutParams(r2);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L6:
        r1 = null;
        goto L7
    }

    public static final /* synthetic */ void a(VoiceChatAvatarView r0, float r1) {
        r0.setTagMargin(r1);
    }

    public VoiceChatAvatarView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131566022, this);
        this.a = (ImageView) findViewById(2131392679);
        this.b = (ImageView) findViewById(2131392680);
        this.c = (CircleProgressView) findViewById(2131392695);
        this.g = findViewById(2131392702);
        this.d = findViewById(2131392706);
        ImageView r5 = (ImageView) findViewById(2131392678);
        this.f = r5;
        if (r5 == null) goto L9;
        Drawable r6 = AppCompatResources.getDrawable(r2, 2131250640);
        if (r6 == null) goto L7;
        Drawable r7 = r6.mutate();
    L8:
        r5.setImageDrawable(r7);
        goto L9
    L7:
        r7 = null;
    L9:
        if (r5 == null) goto L14;
        Drawable r8 = r5.getDrawable();
        if (r8 == null) goto L15;
        r8.setAlpha(MathKt.roundToInt(0.5f * 255));
        return;
    L15:
        return;
    }

    public final Animator b(long r3, boolean r5, boolean r6) {
        if (r5 == false) goto L8;
        CircleProgressView r7 = this.c;
        if (r7 == null) goto L7;
        r7.setProgressDirection(Path.Direction.CW);
    L7:
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
    L12:
        r8.addUpdateListener(new b(this, r6));
        r8.addListener(new c(this));
        r8.setDuration(r3);
        r8.setInterpolator(new PathInterpolator(0.5f, 0.0f, 0.5f, 1.0f));
        return r8;
    L8:
        CircleProgressView r9 = this.c;
        if (r9 == null) goto L11;
        r9.setProgressDirection(Path.Direction.CCW);
    L11:
        r8 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        goto L12
    }

    public /* synthetic */ VoiceChatAvatarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
