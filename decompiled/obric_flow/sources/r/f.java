package r;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.w;
import com.airbnb.lottie.x;
import com.airbnb.lottie.z;
import java.io.IOException;
import java.util.HashSet;
import l.n;

/* JADX INFO: loaded from: classes.dex */
public final class f extends c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final j.a f21602v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Rect f21603w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Rect f21604x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public n f21605y;

    public f(w r5, g r10) {
        super(r5, r10);
        this.f21602v = new j.a(3, 0);
        this.f21603w = new Rect();
        this.f21604x = new Rect();
    }

    @Override // r.c, o.f
    public final void c(ColorFilter r5, v.c r10) {
        super.c(r5, r10);
        if (r5 != z.f1375y) goto L6;
        this.f21605y = new n(r10, null);
        return;
    }

    @Override // r.c, k.e
    public final void e(RectF r5, Matrix r10, boolean r11) {
        super.e(r5, r10, r11);
        Bitmap r12 = o();
        if (r12 == null) goto L6;
        r5.set(0.0f, 0.0f, u.f.c() * r12.getWidth(), u.f.c() * r12.getHeight());
        this.f21587l.mapRect(r5);
        return;
    }

    @Override // r.c
    public final void j(Canvas r10, Matrix r11, int r12) {
        Bitmap r5 = o();
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isRecycled() == true) goto L13;
        float r13 = u.f.c();
        j.a r14 = this.f21602v;
        r14.setAlpha(r12);
        n r15 = this.f21605y;
        if (r15 == null) goto L10;
        r14.setColorFilter((ColorFilter) r15.f());
    L10:
        r10.save();
        r10.concat(r11);
        int r16 = r5.getWidth();
        int r17 = r5.getHeight();
        Rect r18 = this.f21603w;
        r18.set(0, 0, r16, r17);
        int r19 = (int) (r5.getWidth() * r13);
        int r20 = (int) (r5.getHeight() * r13);
        Rect r21 = this.f21604x;
        r21.set(0, 0, r19, r20);
        r10.drawBitmap(r5, r18, r21, r14);
        r10.restore();
        return;
    }

    public final Bitmap o() {
        String r5 = this.f21589n.g;
        w r10 = this.f21588m;
        if (r10.getCallback() != null) goto L5;
        n.a r11 = null;
    L24:
        if (r11 == null) goto L83;
        String r12 = r11.f20186b;
        x r13 = (x) r11.f20187c.get(r5);
        if (r13 == null) goto L88;
        Bitmap r14 = r13.d;
        if (r14 != null) goto L84;
        BitmapFactory.Options r15 = new BitmapFactory.Options();
        r15.inScaled = true;
        r15.inDensity = 160;
        String r16 = r13.f1355c;
        if (r16.startsWith("data:") == true) goto L34;
    L80:
    L67:
        e = move-exception;
        u.b.f22181a.getClass();
        HashSet r17 = u.a.f22180a;
        if (r17.contains("Unable to open asset.") == true) goto L90;
        Log.w("LOTTIE", "Unable to open asset.", e);
        r17.add("Unable to open asset.");
        return null;
    L90:
        return null;
    L51:
        if (TextUtils.isEmpty(r12) == true) goto L70;
        Bitmap r18 = BitmapFactory.decodeStream(r11.f20185a.getAssets().open(r12 + r16), null, r15);
        int r19 = r13.f1353a;
        int r20 = r13.f1354b;
        PathMeasure r21 = u.f.f22191a;
        if (r18.getWidth() == r19) goto L56;
    L58:
        Bitmap r22 = Bitmap.createScaledBitmap(r18, r19, r20, true);
        r18.recycle();
    L59:
        Object r23 = n.a.d;
        monitor-enter(r23);
        ((x) r11.f20187c.get(r5)).d = r22;     // Catch: Throwable -> L64
        monitor-exit(r23);     // Catch: Throwable -> L64
        return r22;
    L64:
        th = move-exception;
        throw th;
    L56:
        if (r18.getHeight() != r20) goto L58;
        r22 = r18;
        goto L59
    L70:
        throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");     // Catch: IOException -> L67
    L34:
        if (r16.indexOf("base64,") <= 0) goto L80;
        byte[] r24 = Base64.decode(r16.substring(r16.indexOf(44) + 1), 0);     // Catch: IllegalArgumentException -> L45
        Bitmap r25 = BitmapFactory.decodeByteArray(r24, 0, r24.length, r15);
        Object r26 = n.a.d;
        monitor-enter(r26);
        ((x) r11.f20187c.get(r5)).d = r25;     // Catch: Throwable -> L42
        monitor-exit(r26);     // Catch: Throwable -> L42
        return r25;
    L42:
        th = move-exception;
        throw th;
    L45:
        e = move-exception;
        u.b.f22181a.getClass();
        HashSet r27 = u.a.f22180a;
        if (r27.contains("data URL did not have correct base64 format.") == true) goto L89;
        Log.w("LOTTIE", "data URL did not have correct base64 format.", e);
        r27.add("data URL did not have correct base64 format.");
        return null;
    L89:
        return null;
    L84:
        return r14;
    L88:
        return null;
    L83:
        return null;
    L5:
        n.a r28 = r10.f1343i;
        if (r28 == null) goto L21;
        Drawable.Callback r29 = r10.getCallback();
        if (r29 != null) goto L11;
    L9:
        Context r30 = null;
    L13:
        Context r31 = r28.f20185a;
        if (r30 != null) goto L17;
        if (r31 == null) goto L21;
    L17:
        if (r31.equals(r30) == true) goto L21;
        r10.f1343i = null;
        goto L21
    L11:
        if ((r29 instanceof View) == false) goto L9;
        r30 = ((View) r29).getContext();
    L21:
        if (r10.f1343i != null) goto L23;
        r10.f1343i = new n.a(r10.getCallback(), r10.f1344j, r10.f1340b.d);
    L23:
        r11 = r10.f1343i;
        goto L24
    }
}
