package com.bytedance.android.livesdk.feedback.view.preview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u000eB\u001d\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/view/preview/FeedbackLikeView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/feedback/view/preview/i;", "listenerView", "", "setLikeClickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedbackLikeView extends FrameLayout {
    public final View a;
    public i b;
    public boolean c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ FeedbackLikeView a;

        public a(FeedbackLikeView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.a();
        }
    }

    public final void a() {
        if (this.c == true) goto L5;
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{0.9f, 1.1f, 1.0f});
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{0.9f, 1.1f, 1.0f});
        AnimatorSet r3 = new AnimatorSet();
        r3.setDuration(200);
        r3.addListener(new com.bytedance.android.livesdk.feedback.view.preview.a(this));
        r3.playTogether(new Animator[]{r0, r2});
        r3.start();
    L6:
        boolean r1 = !this.c;
        this.c = r1;
        i r4 = this.b;
        if (r4 == null) goto L10;
        r4.onClick(r1);
        return;
    L10:
        return;
    L5:
        this.a.setBackground(s1.m(2131251001));
        goto L6
    }

    public FeedbackLikeView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 0);
    }

    public final void setLikeClickListener(i r2) {
        Intrinsics.checkNotNullParameter(r2, "listenerView");
        this.b = r2;
    }

    public FeedbackLikeView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public FeedbackLikeView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        FrameLayout.inflate(r2, 2131566012, this);
        this.a = findViewById(2131374686);
        setOnClickListener(new a(this));
    }
}
