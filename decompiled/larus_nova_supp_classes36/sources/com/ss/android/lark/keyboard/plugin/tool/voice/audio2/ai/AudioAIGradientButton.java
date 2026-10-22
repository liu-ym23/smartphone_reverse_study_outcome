package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.ai;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.gradient.UDGradientDrawableKt;
import com.larksuite.component.universe_design.gradient.UDLinearGradientDrawable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/ai/AudioAIGradientButton;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgPaint", "Landroid/graphics/Paint;", "gradient", "Lcom/larksuite/component/universe_design/gradient/UDGradientDrawable;", "boundsRect", "Landroid/graphics/Rect;", "boundsRectF", "Landroid/graphics/RectF;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AudioAIGradientButton extends AppCompatTextView {
    public final Paint a;
    public final UDLinearGradientDrawable b;
    public final Rect c;
    public final RectF d;

    public AudioAIGradientButton(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AudioAIGradientButton(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        float r0 = getWidth() / 2.0f;
        this.c.set(0, 0, getWidth(), getHeight());
        this.d.set(0.0f, 0.0f, getWidth(), getHeight());
        r10.drawRoundRect(this.d, r0, r0, this.a);
        UDLinearGradientDrawable r1 = this.b;
        Rect r2 = this.c;
        r1.setBounds(r2);
        int r3 = r10.saveLayer(r2.left, r2.top, r2.right, r2.bottom, null);
        super/*android.widget.TextView*/.onDraw(r10);
        r1.b((PorterDuffXfermode) UDGradientDrawableKt.a.getValue());
        r1.draw(r10);
        r10.restoreToCount(r3);
        r1.b(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AudioAIGradientButton(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Paint r5 = new Paint(1);
        int r6 = c.a;
        r5.setColor(c.c(this, 2131100548));
        this.a = r5;
        int r7 = com.larksuite.component.universe_design.gradient.b.a;
        Intrinsics.checkNotNullParameter(r2, "context");
        UDLinearGradientDrawable.Orientation r8 = UDLinearGradientDrawable.Orientation.TO_BOTTOM_RIGHT;
        UDLinearGradientDrawable r0 = new UDLinearGradientDrawable(UDColorUtils.getColor(r2, 2131100164), UDColorUtils.getColor(r2, 2131100165), r8);
        r0.mutate();
        this.b = r0;
        this.c = new Rect();
        this.d = new RectF();
    }

    public /* synthetic */ AudioAIGradientButton(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
