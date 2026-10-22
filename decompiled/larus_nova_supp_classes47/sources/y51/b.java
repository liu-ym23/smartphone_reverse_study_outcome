package y51;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.adapter.AudienceViewHolder;
import com.bytedance.android.livesdk.widget.TransparentCircleIconView;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements Function3<TransparentCircleIconView, Canvas, Paint, Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ AudienceViewHolder b;

    public b(AudienceViewHolder r1, int r2) {
        this.b = r1;
        this.a = r2;
    }

    public final Object invoke(Object r5, Object r6, Object r7) {
        TransparentCircleIconView r8 = (TransparentCircleIconView) r5;
        Canvas r9 = (Canvas) r6;
        Paint r10 = (Paint) r7;
        if (r8 != null) goto L6;
        return Unit.INSTANCE;
    L6:
        if (r8.getWidth() <= 0) goto L8;
        int r12 = r8.getWidth();
    L9:
        int r0 = r12 / 2;
        AudienceViewHolder r1 = this.b;
        if (r1.g != null) goto L12;
        r1.g = new Paint(1);
        this.b.g.setStyle(Paint.Style.STROKE);
        this.b.g.setStrokeWidth(s1.f(0.5f));
        this.b.g.setColor(504764451);
    L12:
        float r2 = r0;
        r9.drawCircle(r2, r2, r2, this.b.g);
        if (this.a < 1) goto L16;
        int r3 = r0 + this.b.i;
        r9.drawCircle((-r3) + (r12 * 0.375f), r2, r3, r10);
    L16:
        return Unit.INSTANCE;
    L8:
        r12 = s1.f(24.0f);
        goto L9
    }
}
