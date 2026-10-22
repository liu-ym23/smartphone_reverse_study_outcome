package oo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.ui.image.v;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends BaseDataSubscriber {
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public a(e r5, b r10) {
        this.d = 0;
        this.f = r5;
        this.e = r10;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void d(DataSource r5) {
        switch(this.d) {
            case 0: goto L15;
            default: goto L4;
        };
    L4:
        AbstractDataSource r10 = (AbstractDataSource) r5;
        monitor-enter(r10);
        Throwable r11 = r10.e;     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        if (r11 == null) goto L10;
        ((xn.d) this.e).g(mh.e.b(r10.b()), r10.b());
        return;
    L10:
        ((xn.d) this.e).g(-1, new Throwable("imageLoadFailed."));
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        AbstractDataSource r12 = (AbstractDataSource) r5;
        monitor-enter(r12);
        Throwable r13 = r12.e;     // Catch: Throwable -> L30
        monitor-exit(r12);     // Catch: Throwable -> L30
        if (r13 == null) goto L21;
        LynxLog.b(4, "LynxImageHelper", "loadBitmapFromRemote failed: " + r13.toString());
    L21:
        e r14 = (e) this.f;
        c r15 = r14.f20799a;
        d r16 = r14.f20800b;
        if (r16 != null) goto L24;
    L26:
        if (r13 == null) goto L28;
        r13.toString();
    L28:
        c r17 = ((e) this.f).f20799a;
        return;
    L24:
        if (r16.f.f == null) goto L26;
        r13.toString();
    L30:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void e(DataSource r11) {
        switch(this.d) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        CloseableReference r12 = (CloseableReference) r11.getResult();
        i4.a r5 = new i4.a(r12);
        xn.d r10 = (xn.d) this.e;
        Bitmap r13 = (Bitmap) r5.f17503c;
        if (r13 == null) goto L7;
        r10.e(new wn.b(new i4.a(r12)), (xn.e) this.f, new xn.c(r13.getWidth(), r13.getHeight(), false));
        return;
    L7:
        r10.g(-1, new Throwable("empty bitmap!"));
        return;
    L9:
        AbstractDataSource r14 = (AbstractDataSource) r11;
        if (r14.f() == false) goto L76;
        CloseableReference r15 = (CloseableReference) r14.getResult();
        if (r15 == null) goto L59;
        CloseableReference r16 = r15.clone();
        PooledByteBufferInputStream r17 = null;
        monitor-enter(r16);     // Catch: Throwable -> L31
        Object r18 = r16.f7671b.d();     // Catch: Throwable -> L33
        monitor-exit(r16);     // Catch: Throwable -> L33
        PooledByteBufferInputStream r19 = new PooledByteBufferInputStream((PooledByteBuffer) r18);     // Catch: Throwable -> L31
        BitmapRegionDecoder r20 = BitmapRegionDecoder.newInstance(r19, false);     // Catch: Throwable -> L22
        BitmapFactory.Options r21 = new BitmapFactory.Options();     // Catch: Throwable -> L22
        e r22 = (e) this.f;     // Catch: Throwable -> L22
        b r23 = (b) this.e;     // Catch: Throwable -> L22
        float r24 = r20.getWidth();     // Catch: Throwable -> L22
        float r25 = r20.getHeight();     // Catch: Throwable -> L22
        int r26 = e.f;     // Catch: Throwable -> L22
        d r27 = r22.c(r23, r24, r25);     // Catch: Throwable -> L22
        if (r27 == null) goto L24;
        r21.inSampleSize = r27.f20796a;     // Catch: Throwable -> L22
        r21.inPreferredConfig = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L22
        r27.d = r20.decodeRegion(r27.f20797b, r21);     // Catch: Throwable -> L22
        r27.e = false;     // Catch: Throwable -> L22
        e r28 = (e) this.f;     // Catch: Throwable -> L22
        r28.f20801c.post(new v(23, r28, r27));     // Catch: Throwable -> L22
    L24:
        r20.recycle();     // Catch: Throwable -> L22
        r19.close();     // Catch: IOException -> L27
    L29:
        r15.close();
        r16.close();
        return;
    L27:
        e = move-exception;
        e.printStackTrace();
    L22:
        th = th;
        r17 = r19;
    L66:
        th.printStackTrace();     // Catch: Throwable -> L41
        e r29 = (e) this.f;     // Catch: Throwable -> L41
        c r30 = r29.f20799a;     // Catch: Throwable -> L41
        d r31 = r29.f20800b;     // Catch: Throwable -> L41
        if (r31 != null) goto L39;
    L43:
        th.toString();     // Catch: Throwable -> L41
    L44:
        c r110 = ((e) this.f).f20799a;     // Catch: Throwable -> L41
        if (r17 != null) goto L64;
    L50:
        r15.close();
        r16.close();
        return;
    L64:
        r17.close();     // Catch: IOException -> L48
    L48:
        e = move-exception;
        e.printStackTrace();
        goto L50
    L39:
        if (r31.f.f == null) goto L43;
        th.toString();     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        int r32 = e.f;
        if (r17 != null) goto L62;
    L57:
        r15.close();
        r16.close();
        throw th;
    L62:
        r17.close();     // Catch: IOException -> L55
    L55:
        e = move-exception;
        e.printStackTrace();
        goto L57
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = th;
        goto L66
    L59:
        return;
    }

    public a(xn.e r5, xn.d r10) {
        this.d = 1;
        this.e = r10;
        this.f = r5;
    }
}
