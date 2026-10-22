package j6a;

import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.PictureDrawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends PictureDrawable {
    public a(Picture r1) {
        super(r1);
    }

    @Override // android.graphics.drawable.PictureDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r3) {
        Rect r0 = getBounds();
        r3.save();
        if (getPicture() == null) goto L5;
        r3.translate(r0.left, r0.top);
        r3.drawPicture(getPicture());
    L5:
        r3.restore();
    }
}
