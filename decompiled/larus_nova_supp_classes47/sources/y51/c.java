package y51;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.bytedance.android.live.room.adapter.AudienceViewHolder;
import com.bytedance.android.livesdk.widget.TransparentCircleIconView;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements Function3<TransparentCircleIconView, Canvas, Paint, Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ AudienceViewHolder b;

    public c(AudienceViewHolder r1, int r2) {
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
        if (this.a < 1) goto L13;
        int r1 = this.b.i + r0;
        r9.drawCircle((-r1) + (r12 * 0.3846f), r0, r1, r10);
    L13:
        return Unit.INSTANCE;
    L8:
        r12 = this.b.h;
        goto L9
    }
}
