package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.bot.impl.databinding.LarusWidgetGenBgPromptInputButtonBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/widget/PromptInputButtonView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/bot/impl/databinding/LarusWidgetGenBgPromptInputButtonBinding;", "rotateAnimation", "Landroid/view/animation/RotateAnimation;", "showNormal", "", "showGenerating", "startGeneratingAnim", "cancelGeneratingAnim", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromptInputButtonView extends FrameLayout {
    public final LarusWidgetGenBgPromptInputButtonBinding a;
    public RotateAnimation b;

    public PromptInputButtonView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PromptInputButtonView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        this.a.b.setImageResource(2131243590);
        RotateAnimation r0 = this.b;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.b = null;
        RotateAnimation r1 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.b = r1;
        this.a.b.setAnimation(r1);
        RotateAnimation r2 = this.b;
        if (r2 == null) goto L8;
        r2.setDuration(2000);
    L8:
        RotateAnimation r3 = this.b;
        if (r3 == null) goto L11;
        r3.setRepeatCount(-1);
    L11:
        RotateAnimation r4 = this.b;
        if (r4 == null) goto L15;
        r4.start();
        return;
    }

    public PromptInputButtonView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131563248, this);
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(this, 2131368837);
        if (r5 == null) goto L7;
        this.a = new LarusWidgetGenBgPromptInputButtonBinding(this, r5);
        setBackground(ContextCompat.getDrawable(r2, 2131243581));
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(2131368837)));
    }

    public /* synthetic */ PromptInputButtonView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
