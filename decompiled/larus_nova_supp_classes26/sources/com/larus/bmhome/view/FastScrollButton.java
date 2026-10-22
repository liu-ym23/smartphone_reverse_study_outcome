package com.larus.bmhome.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.larus.utils.j0;
import com.obric.assistant.spi.chat.ObricChatUIDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001'B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0015\u001a\u00020\u000eJ)\u0010\u0016\u001a\u00020\u00172!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00170\u0018J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0017H\u0002J\b\u0010%\u001a\u00020\u0017H\u0002J\u000e\u0010&\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0010R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Lcom/larus/bmhome/view/FastScrollButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "showAnimator", "Landroid/animation/AnimatorSet;", "hideAnimator", "totalY", "", "icon", "Landroid/widget/ImageView;", "value", "", "isShow", "()Z", "setShow", "(Z)V", "iconLayoutTarget", "onClick", "", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "it", "logTouchEvent", "event", "Landroid/view/MotionEvent;", "motionActionToString", "", "action", "", "show", "hide", "resume", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FastScrollButton extends FrameLayout {
    public static final /* synthetic */ int f = 0;
    public AnimatorSet a;
    public AnimatorSet b;
    public final float c;
    public final ImageView d;
    public boolean e;

    public static final class a {
    }

    static {
    }

    public FastScrollButton(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setShow(boolean r9) {
        if (r9 != this.e) goto L5;
        return;
    L5:
        this.e = r9;
        if (r9 == false) goto L11;
        AnimatorSet r10 = this.b;
        if (r10 == null) goto L10;
        r10.cancel();
    L10:
        this.b = null;
        ObjectAnimator r11 = ObjectAnimator.ofFloat(this, "translationY", new float[]{getTranslationY(), this.c});
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this, "alpha", new float[]{getAlpha(), 1.0f});
        AnimatorSet r3 = new AnimatorSet();
        r3.play(r11).with(r2);
        r3.setDuration((long) ((1 - getAlpha()) * 300));
        r3.addListener(new d2(this));
        r3.start();
        this.a = r3;
        return;
    L11:
        AnimatorSet r12 = this.a;
        if (r12 == null) goto L14;
        r12.cancel();
    L14:
        this.a = null;
        ObjectAnimator r13 = ObjectAnimator.ofFloat(this, "translationY", new float[]{getTranslationY(), 0.0f});
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this, "alpha", new float[]{getAlpha(), 0.0f});
        AnimatorSet r5 = new AnimatorSet();
        r5.play(r13).with(r4);
        r5.setDuration((long) (getAlpha() * 300));
        r5.addListener(new c2(this));
        r5.start();
        this.b = r5;
    }

    public FastScrollButton(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        this.c = -i5.o0();
        ImageView r6 = new ImageView(r4);
        this.d = r6;
        if (r6.getId() != (-1)) goto L5;
        r6.setId(2131372138);
    L5:
        r6.setImageResource(v19.c.b(2130971711, r6.getContext(), 2131241314));
        addView(r6, new FrameLayout.LayoutParams(-1, -1));
        setBackgroundResource(2131240703);
        int r7 = j0.a;
        r6.setContentDescription(j0.d(2131898877));
        ObricChatUIDelegate.b.z(this);
    }
}
