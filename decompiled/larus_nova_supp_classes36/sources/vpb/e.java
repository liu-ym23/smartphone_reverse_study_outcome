package vpb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.larkicon.transform.ImgForegroundTransform;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.functions.Function;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e<T, R> implements Function {
    public final /* synthetic */ d a;

    public e(d r1) {
        this.a = r1;
    }

    public final Object apply(Object r13) {
        Bitmap r14 = (Bitmap) r13;
        Intrinsics.checkNotNullParameter(r14, "mainBody");
        int r0 = this.a.g;
        Bitmap r1 = Bitmap.createBitmap(r0, r0, Bitmap.Config.ARGB_8888);
        Canvas r2 = new Canvas(r1);
        Iterator<xpb.b> r3 = this.a.a.iterator();
    L3:
        int r6 = 0;
        if (r3.hasNext() == false) goto L11;
        xpb.a r4 = (xpb.a) r3.next();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r2, "canvas");
        Paint r7 = new Paint();
        Integer r8 = r4.a;
        if (r8 == null) goto L8;
        r6 = r8.intValue();
    L8:
        r7.setColor(r6);
        r7.setStyle(Paint.Style.FILL);
        r7.setAntiAlias(true);
        RectF r9 = new RectF(0.0f, 0.0f, r2.getWidth(), r2.getHeight());
        float r5 = r4.b;
        r2.drawRoundRect(r9, r5, r5, r7);
        if (r4.c == null) goto L3;
        Paint r10 = new Paint();
        r10.setColor(UDColorUtils.getColor(LarkContext.getApplication(), r4.c.intValue()));
        r10.setStyle(Paint.Style.STROKE);
        r10.setStrokeWidth(r4.d);
        r10.setAntiAlias(true);
        float r11 = r4.d;
        RectF r12 = new RectF(r11, r11, r2.getWidth() - r4.d, r2.getHeight() - r4.d);
        float r15 = r4.b;
        r2.drawRoundRect(r12, r15, r15, r10);
        goto L3
    L11:
        Matrix r16 = new Matrix();
        r16.postTranslate((r1.getWidth() / 2.0f) - (r14.getWidth() / 2.0f), (r1.getHeight() / 2.0f) - (r14.getHeight() / 2.0f));
        r2.drawBitmap(r14, r16, new Paint());
        Iterator<xpb.c> r17 = this.a.b.iterator();
    L13:
        if (r17.hasNext() == false) goto L44;
        ImgForegroundTransform r18 = (ImgForegroundTransform) r17.next();
        r18.getClass();
        Intrinsics.checkNotNullParameter(r2, "canvas");
        if (r18.a == null) goto L31;
        Integer r19 = r18.d;
        if (r19 == null) goto L19;
        int r20 = r19.intValue();
    L20:
        Integer r21 = r18.e;
        if (r21 == null) goto L23;
        int r22 = r21.intValue();
    L24:
        Bitmap r23 = Bitmap.createBitmap(r20, r22, Bitmap.Config.ARGB_8888);
        Canvas r24 = new Canvas(r23);
        Drawable r25 = r18.a;
        if (r25 == null) goto L27;
        r25.setBounds(0, 0, r23.getWidth(), r23.getHeight());
    L27:
        Drawable r26 = r18.a;
        if (r26 == null) goto L30;
        r26.draw(r24);
    L30:
        r18.b = r23;
        goto L31
    L23:
        r22 = r2.getHeight();
        goto L24
    L19:
        r20 = r2.getWidth();
    L31:
        Bitmap r27 = r18.b;
        if (r27 == null) goto L13;
        Matrix r28 = new Matrix();
        int r29 = ImgForegroundTransform.a.a[r18.c.ordinal()];
        if (r29 != 1) goto L36;
        r28.postTranslate(0.0f, r2.getHeight() - r27.getHeight());
    L43:
        r2.drawBitmap(r27, r28, new Paint());
        goto L13
    L36:
        if (r29 != 2) goto L38;
        r28.postTranslate(r2.getWidth() - r27.getWidth(), 0.0f);
        goto L43
    L38:
        if (r29 == 3) goto L40;
        r28.postTranslate(0.0f, 0.0f);
        goto L43
    L40:
        r28.postTranslate(r2.getWidth() - r27.getWidth(), r2.getHeight() - r27.getHeight());
        goto L43
    L44:
        return r1;
    }
}
