package h7b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.log.Log;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f extends SimpleTarget<File> {
    public final /* synthetic */ Context a;
    public final /* synthetic */ ImageView b;

    public final void onLoadFailed(Drawable r1) {
        super.onLoadFailed(r1);
    }

    public final void onResourceReady(Object r14) {
        File r15 = (File) r14;
        super.onResourceReady(r15);
        Log.i("ActionUtils", "resource size:" + (r15.length() / 1024) + "KB");
        Context r0 = this.a;
        Bitmap r5 = null;
        BitmapFactory.Options r6 = new BitmapFactory.Options();     // Catch: Exception -> L14
        r6.inJustDecodeBounds = true;     // Catch: Exception -> L14
        BitmapFactory.decodeFile(r15.getAbsolutePath(), r6);     // Catch: Exception -> L14
        int r8 = y9c.d.b(r0, 40.0f);     // Catch: Exception -> L14
        int r1 = y9c.d.b(r0, 40.0f);     // Catch: Exception -> L14
        int r7 = r6.outWidth;     // Catch: Exception -> L14
        int r9 = r6.outHeight;     // Catch: Exception -> L14
        int r10 = 1;
    L51:
    L10:
        e = move-exception;
        Log.e("ActionUtils", "calculateInSampleSize error", e);     // Catch: Exception -> L14
        r10 = 1;
    L12:
        Log.i("ActionUtils", "Options InSampleSize: " + r10);     // Catch: Exception -> L14
        r6.inSampleSize = r10;     // Catch: Exception -> L14
        r6.inJustDecodeBounds = false;     // Catch: Exception -> L14
        Bitmap r16 = BitmapFactory.decodeFile(r15.getAbsolutePath(), r6);     // Catch: Exception -> L14
    L16:
        if (r16 != null) goto L18;
        this.b.setImageDrawable(y9c.d.e(this.a, 2131233569));
        return;
    L18:
        Log.i("ActionUtils", "bitmap size: " + (r16.getByteCount() / ChameleonContainerUtils.MAX_URL_LENGTH) + "KB");
        if (((r16.getWidth() * 1.0f) / r16.getHeight()) <= 1.0f) goto L21;
        boolean r2 = true;
    L22:
        i.e = r2;
        int r3 = r16.getWidth();
        int r4 = r16.getHeight();
        if (i.e == false) goto L28;
        if ((((i.c * 1.0f) / r3) * r4) < i.b) goto L29;
    L30:
        boolean r11 = false;
    L31:
        if (r11 == true) goto L33;
        this.b.setImageBitmap(r16);
        return;
    L33:
        float r12 = (r16.getWidth() * 1.0f) / r16.getHeight();
        if (i.e == false) goto L36;
        int r13 = i.b;
        int r17 = (int) (r13 * r12);
    L37:
        if (r17 <= 0) goto L45;
        if (r13 <= 0) goto L45;
        Bitmap r18 = Bitmap.createScaledBitmap(r16, r17, r13, true);
        Rect r19 = new Rect(0, 0, i.c, i.d);
        if (i.e == false) goto L43;
        int r20 = i.c;
        int r21 = (r17 - r20) / 2;
        r19.left = r21;
        r19.right = r21 + r20;
        int r22 = i.d;
        int r23 = (-(r22 - r13)) / 2;
        r19.top = r23;
        r19.bottom = r23 + r22;
    L44:
        r5 = Bitmap.createBitmap(i.c, i.d, Bitmap.Config.ARGB_8888);
        new Canvas(r5).drawBitmap(r18, r19, new Rect(0, 0, i.c, i.d), new Paint());
        goto L45
    L43:
        int r24 = i.d;
        int r25 = (r13 - r24) / 2;
        r19.top = r25;
        r19.bottom = r25 + r24;
        int r26 = i.c;
        int r27 = (-(r26 - r17)) / 2;
        r19.left = r27;
        r19.right = r27 + r26;
    L45:
        if (r5 == null) goto L47;
        this.b.setImageBitmap(r5);
        return;
    L47:
        this.b.setImageBitmap(r16);
        return;
    L36:
        int r28 = i.a;
        r13 = (int) (r28 / r12);
        r17 = r28;
    L29:
        r11 = true;
        goto L31
    L28:
        if ((((i.d * 1.0f) / r4) * r3) >= i.a) goto L30;
    L21:
        r2 = false;
        goto L22
    L6:
        if ((r7 / r10) > r8) goto L9;
        if ((r9 / r10) <= r1) goto L12;
    L9:
        r10 = r10 * 2;
    L14:
        e = move-exception;
        Log.e("ActionUtils", "fileToBitMap: ", e);
        r16 = null;
        goto L16
    }

    public f(FragmentActivity r1, ImageView r2) {
        this.a = r1;
        this.b = r2;
    }
}
