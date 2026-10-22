package p6a;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class c extends Drawable {
    public final Paint a;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public c() {
        Paint r0 = new Paint();
        this.a = r0;
        r0.setStyle(Paint.Style.FILL);
        r0.setAntiAlias(true);
        r0.setColor(-5592406);
    }

    public final void a(int r2) {
        this.a.setColor(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.a.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.a.setColorFilter(r2);
    }
}
