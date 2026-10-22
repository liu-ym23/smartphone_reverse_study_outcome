package q32;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.highlight.indicator.DuxBaseIndicator;
import com.bytedance.android.livesdk.interactivity.api.highlight.indicator.LiveDuxCarouselIndicator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends c {
    public final /* synthetic */ LiveDuxCarouselIndicator c;

    @Override // q32.c
    public final int a() {
        return this.c.a.size();
    }

    public b(LiveDuxCarouselIndicator r1) {
        this.c = r1;
    }

    @Override // q32.c
    public final void d(int r3) {
        a.a((View) ListProtector.get(this.c.a, r3), (int) this.c.getDotsSize());
        this.c.c(r3);
    }

    @Override // q32.c
    public final void c(int r9, int r10, float r11) {
        ArrayList<View> r0 = this.c.a;
        Intrinsics.checkNotNullParameter(r0, "$this$isInBounds");
        int r1 = r0.size();
        boolean r2 = false;
        if (r9 < 0) goto L7;
        if (r1 <= r9) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L10;
        return;
    L10:
        View r4 = (View) ListProtector.get(this.c.a, r9);
        float r7 = 1;
        a.a(r4, (int) (this.c.getDotsSize() + ((this.c.getDotsSize() * (this.c.getDotsWidthFactor() - r7)) * (r7 - r11))));
        ArrayList<View> r5 = this.c.a;
        Intrinsics.checkNotNullParameter(r5, "$this$isInBounds");
        int r6 = r5.size();
        if (r10 < 0) goto L15;
        if (r6 <= r10) goto L15;
        r2 = true;
    L15:
        if (r2 == false) goto L40;
        View r13 = (View) ListProtector.get(this.c.a, r10);
        a.a(r13, (int) (this.c.getDotsSize() + ((this.c.getDotsSize() * (this.c.getDotsWidthFactor() - r7)) * r11)));
        Drawable r8 = r4.getBackground();
        if (r8 == null) goto L39;
        GradientDrawable r14 = (GradientDrawable) r8;
        Drawable r15 = r13.getBackground();
        if (r15 == null) goto L37;
        GradientDrawable r16 = (GradientDrawable) r15;
        if (this.c.getSelectedDotColor() == this.c.getDotsColor()) goto L40;
        LiveDuxCarouselIndicator r17 = this.c;
        Object r18 = r17.m.evaluate(r11, Integer.valueOf(r17.getSelectedDotColor()), Integer.valueOf(this.c.getDotsColor()));
        if (r18 == null) goto L35;
        int r19 = ((Integer) r18).intValue();
        LiveDuxCarouselIndicator r20 = this.c;
        Object r110 = r20.m.evaluate(r11, Integer.valueOf(r20.getDotsColor()), Integer.valueOf(this.c.getSelectedDotColor()));
        if (r110 == null) goto L33;
        r16.setColor(((Integer) r110).intValue());
        DuxBaseIndicator.a r111 = this.c.getPager();
        if (r111 != null) goto L29;
    L31:
        r14.setColor(r19);
        goto L40
    L29:
        if (r9 != r111.getCurrentItem()) goto L31;
        r14.setColor(this.c.getSelectedDotColor());
        goto L40
    L33:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L35:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L39:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L40:
        this.c.invalidate();
        return;
    L7:
        r3 = false;
        goto L8
    }
}
