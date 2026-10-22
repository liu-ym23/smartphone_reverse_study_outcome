package g2b;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.ttvideoengine.utils.ScreenUtils;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g extends Drawable {
    public final Drawable a;
    public final int b;
    public int c;

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (this.c != 255) goto L6;
        return -1;
    L6:
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        Drawable r0 = this.a;
        if (r0 == null) goto L5;
        r0.draw(r5);
    L5:
        int r1 = Color.argb(this.c, Color.red(this.b), Color.green(this.b), Color.blue(this.b));
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.message.message_background_and_padding") == false) goto L8;
        r5.drawColor(r1);
        return;
    L8:
        Rect r2 = getBounds();
        Paint r3 = new Paint();
        r3.setColor(r1);
        Unit r4 = Unit.INSTANCE;
        r5.drawRect(r2, r3);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
        this.c = r1;
        invalidateSelf();
    }

    public g(int r4, Drawable r5) {
        this.a = r5;
        int r6 = Color.alpha(r4);
        float r7 = r6 / 255.0f;
        this.b = Color.rgb((int) (Color.red(r4) * r7), (int) (Color.green(r4) * r7), (int) (Color.blue(r4) * r7));
        this.c = ScreenUtils.MAX_SYSTEM_BRIGHTNESS;
    }
}
