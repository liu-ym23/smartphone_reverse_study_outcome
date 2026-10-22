package v9;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.OvalShape;
import androidx.core.content.ContextCompat;
import com.obric.oui.common.util.f;
import kotlin.jvm.internal.Intrinsics;
import u8.c;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends OvalShape {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f13203c;

    public b(Context r10) {
        this.f13203c = r10;
    }

    @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
    public void draw(Canvas r10, Paint r11) {
        if (r11 == null) goto L4;
        Context r12 = this.f13203c;
        Intrinsics.checkNotNull(r12);
        r11.setColor(ContextCompat.getColor(r12, c.ConstTextInverse));
    L4:
        if (r11 == null) goto L6;
        r11.setShadowLayer(2.0f, 0.0f, 1.0f, f.c("#40000000"));
    L6:
        super.draw(r10, r11);
    }
}
