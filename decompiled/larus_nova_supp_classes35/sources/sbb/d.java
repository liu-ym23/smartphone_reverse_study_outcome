package sbb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final Integer[] a = null;

    static {
        a = new Integer[]{2131108753, 2131108780, 2131108637, 2131108833, 2131108766, 2131108617, 2131108666, 2131108850, 2131108811, 2131108653};
    }

    public static Bitmap a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "unicode");
        int r1 = rbb.a.a;
        Intrinsics.checkNotNullParameter(r10, "unicode");
        List r3 = StringsKt.split$default(r10, new String[]{"-"}, false, 0, 6, null);     // Catch: Exception -> L20
        if (r3.size() <= 1) goto L15;
        StringBuilder r11 = new StringBuilder();     // Catch: Exception -> L20
        Iterator r4 = r3.iterator();     // Catch: Exception -> L20
    L8:
        if (r4.hasNext() == false) goto L14;
        int r5 = CastIntegerProtector.parseInt((String) r4.next(), 16);     // Catch: Exception -> L20
        if (ypb.b.b(r5) == false) goto L13;
        r11.append(new String(Character.toChars(r5)));     // Catch: Exception -> L20
        goto L8
    L13:
        throw new Exception("codePoint " + r5 + " is not emoji");     // Catch: Exception -> L20
    L14:
        String r12 = r11.toString();     // Catch: Exception -> L20
    L22:
        if (r12 == null) goto L44;
        Context r6 = rbb.a.f();
        int r7 = UIUtils.dp2px(r6, 44.0f);     // Catch: Exception -> L35
        TextView r8 = new TextView(r6);     // Catch: Exception -> L35
        r8.setIncludeFontPadding(false);     // Catch: Exception -> L35
        r8.setGravity(17);     // Catch: Exception -> L35
        r8.setLayoutParams(new ViewGroup.LayoutParams(r7, r7));     // Catch: Exception -> L35
        r8.setText(r12);     // Catch: Exception -> L35
        r8.measure(View.MeasureSpec.makeMeasureSpec(r7, 0), View.MeasureSpec.makeMeasureSpec(r7, 0));     // Catch: Exception -> L35
        r8.layout(0, 0, r8.getMeasuredWidth(), r8.getMeasuredHeight());     // Catch: Exception -> L35
        Bitmap r13 = Bitmap.createBitmap(r8.getMeasuredWidth(), r8.getMeasuredHeight(), Bitmap.Config.ARGB_8888);     // Catch: Exception -> L35
        Canvas r9 = new Canvas(r13);     // Catch: Exception -> L35
        r8.draw(r9);     // Catch: Exception -> L35
        r9.save();     // Catch: Exception -> L35
        Bitmap r14 = Bitmap.createBitmap(r7, r7, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L35
        Canvas r15 = new Canvas(r14);     // Catch: Exception -> L35
        if (r13.getWidth() <= r13.getHeight()) goto L28;
        float r16 = r7;
    L30:
        if (r13.getWidth() <= r13.getHeight()) goto L32;
        float r17 = (r13.getHeight() / r13.getWidth()) * r7;     // Catch: Exception -> L35
    L33:
        float r18 = r7;
        float r19 = 2;
        float r20 = (r18 - r16) / r19;     // Catch: Exception -> L35
        float r21 = (r18 - r17) / r19;     // Catch: Exception -> L35
        r15.drawBitmap(r13, null, new RectF(r20, r21, r18 - r20, r18 - r21), new Paint());     // Catch: Exception -> L35
        return r14;
    L32:
        r17 = r7;
        goto L33
    L28:
        r16 = (r13.getWidth() / r13.getHeight()) * r7;     // Catch: Exception -> L35
    L35:
        e = move-exception;
        Log.e("DOCS_ICON_BitmapHelper", "getUnicodeBitmap unicode error " + e.getMessage());
        return null;
    L44:
        return null;
    L15:
        int r110 = CastIntegerProtector.parseInt(r10, 16);     // Catch: Exception -> L20
        if (ypb.b.b(r110) == false) goto L19;
        r12 = new String(Character.toChars(r110));     // Catch: Exception -> L20
        goto L22
    L19:
        throw new Exception("codePoint " + r110 + " is not emoji");     // Catch: Exception -> L20
    L20:
        e = move-exception;
        Log.e("DOCS_ICON_BitmapHelper", "getUnicodeBitmap unicode error " + e.getMessage());
        r12 = null;
        goto L22
    }
}
