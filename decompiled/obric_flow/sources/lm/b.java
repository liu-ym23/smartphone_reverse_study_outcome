package lm;

import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.PictureDrawable;
import com.lynx.base.log.LynxLog;
import com.lynx.component.svg.parser.n0;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends PictureDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19679a;

    public /* synthetic */ b(Picture r5) {
        this.f19679a = 1;
        super(r5);
    }

    @Override // android.graphics.drawable.PictureDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r5) {
        switch(this.f19679a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        Rect r10 = getBounds();
        r5.save();
        if (getPicture() == null) goto L7;
        r5.translate(r10.left, r10.top);
        r5.drawPicture(getPicture());
    L7:
        r5.restore();
        return;
    L9:
        Rect r11 = getBounds();
        r5.save();
        if (getPicture() == null) goto L12;
        r5.translate(r11.left, r11.top);
        r5.drawPicture(getPicture());
    L12:
        r5.restore();
    }

    public b(n0 r5, com.lynx.component.svg.parser.d r10, i4.a r11) {
        this.f19679a = 0;
        super(null);
        Picture r12 = r5.b(r10, r11);
        if (r12 == null) goto L5;
        LynxLog.b(2, "lynx_UISvg", "renderToPicture success.svgHashCode:" + r5.hashCode() + " picture hashCode:" + r12.hashCode());
    L5:
        setPicture(r12);
    }
}
