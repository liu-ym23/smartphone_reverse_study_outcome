package wpb;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements e {
    public final String a;
    public final int b;
    public final int c;
    public final IconScene d;

    public static final class a {
    }

    static {
    }

    @Override // wpb.e
    public final Flowable<Bitmap> a(Drawable r14) {
        long r1 = System.nanoTime();
        List r4 = StringsKt.split$default(this.a, new String[]{"-"}, false, 0, 6, null);     // Catch: Exception -> L20
        if (r4.size() <= 1) goto L15;
        StringBuilder r5 = new StringBuilder();     // Catch: Exception -> L20
        Iterator r6 = r4.iterator();     // Catch: Exception -> L20
    L8:
        if (r6.hasNext() == false) goto L14;
        int r7 = CastIntegerProtector.parseInt((String) r6.next(), 16);     // Catch: Exception -> L20
        if (ypb.b.b(r7) == false) goto L13;
        r5.append(new String(Character.toChars(r7)));     // Catch: Exception -> L20
        goto L8
    L13:
        throw new Exception("codePoint " + r7 + " is not emoji");     // Catch: Exception -> L20
    L14:
        String r8 = r5.toString();     // Catch: Exception -> L20
    L23:
        if (r8 != null) goto L42;
        if (r14 == null) goto L27;
        Flowable<Bitmap> r15 = Flowable.just(ypb.b.a(r14));
        Intrinsics.checkNotNull(r15);
        return r15;
    L27:
        return Flowable.error(new Exception("unicode error"));
    L42:
        TextView r16 = new TextView(LarkContext.getApplication());     // Catch: Exception -> L38
        r16.setIncludeFontPadding(false);     // Catch: Exception -> L38
        r16.setGravity(17);     // Catch: Exception -> L38
        r16.setText(r8);     // Catch: Exception -> L38
        Resources r9 = LarkContext.getApplication().getResources();     // Catch: Exception -> L38
        r16.setTextSize((int) TypedValue.applyDimension(2, 18.0f, WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics())));     // Catch: Exception -> L38
        r16.measure(View.MeasureSpec.makeMeasureSpec(this.b, 0), View.MeasureSpec.makeMeasureSpec(this.c, 0));     // Catch: Exception -> L38
        r16.layout(0, 0, r16.getMeasuredWidth(), r16.getMeasuredHeight());     // Catch: Exception -> L38
        Bitmap r10 = Bitmap.createBitmap(r16.getMeasuredWidth(), r16.getMeasuredHeight(), Bitmap.Config.ARGB_8888);     // Catch: Exception -> L38
        Canvas r11 = new Canvas(r10);     // Catch: Exception -> L38
        r16.draw(r11);     // Catch: Exception -> L38
        r11.save();     // Catch: Exception -> L38
        Bitmap r17 = Bitmap.createBitmap(this.b, this.c, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L38
        Canvas r12 = new Canvas(r17);     // Catch: Exception -> L38
        if (r10.getWidth() <= r10.getHeight()) goto L31;
        float r13 = this.b;     // Catch: Exception -> L38
    L33:
        if (r10.getWidth() <= r10.getHeight()) goto L35;
        float r18 = (r10.getHeight() / r10.getWidth()) * r13;     // Catch: Exception -> L38
    L36:
        float r19 = 2;
        float r110 = (r13 - r13) / r19;     // Catch: Exception -> L38
        float r20 = (r13 - r18) / r19;     // Catch: Exception -> L38
        r12.drawBitmap(r10, null, new RectF(r110, r20, r13 - r110, r13 - r20), new Paint());     // Catch: Exception -> L38
        return Flowable.just(r17);
    L35:
        r18 = r13;
        goto L36
    L31:
        r13 = (r10.getWidth() / r10.getHeight()) * this.b;     // Catch: Exception -> L38
    L38:
        e = move-exception;
        DecimalFormat r3 = vpb.f.a;
        vpb.f.a("render_emoji", this.d, 1, false, System.nanoTime() - r1, e.getMessage());
        Log.e("EmojiIconProducer", "generateIcon error " + e.getMessage());
        return Flowable.error(new Exception("unicode error"));
    L15:
        int r21 = CastIntegerProtector.parseInt(this.a, 16);     // Catch: Exception -> L20
        if (ypb.b.b(r21) == false) goto L19;
        r8 = new String(Character.toChars(r21));     // Catch: Exception -> L20
        goto L23
    L19:
        throw new Exception("codePoint " + r21 + " is not emoji");     // Catch: Exception -> L20
    L20:
        e = move-exception;
        DecimalFormat r22 = vpb.f.a;
        vpb.f.a("render_emoji", this.d, 1, false, System.nanoTime() - r1, e.getMessage());
        Log.e("EmojiIconProducer", "getUnicodeBitmap unicode error " + e.getMessage());
        r8 = null;
        goto L23
    }

    public d(String r2, int r3, int r4, IconScene r5) {
        Intrinsics.checkNotNullParameter(r2, "unicode");
        Intrinsics.checkNotNullParameter(r5, "scene");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
