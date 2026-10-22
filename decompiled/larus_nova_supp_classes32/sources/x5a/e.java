package x5a;

import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.PictureDrawable;
import com.lynx.component.svg.parser.SVG;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e extends PictureDrawable {
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

    public e(SVG r2, com.lynx.component.svg.parser.c r3, com.lynx.component.svg.d r4) {
        super(null);
        Picture r5 = r2.e(r3, r4);
        if (r5 == null) goto L5;
        LLog.i("lynx_UISvg", "renderToPicture success.svgHashCode:" + r2.hashCode() + " picture hashCode:" + r5.hashCode());
    L5:
        setPicture(r5);
    }
}
