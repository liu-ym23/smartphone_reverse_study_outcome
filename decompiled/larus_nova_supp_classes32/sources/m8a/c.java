package m8a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.lynx.tasm.base.LLog;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c extends BaseDataSubscriber<CloseableReference<PooledByteBuffer>> {
    public final /* synthetic */ d.a a;
    public final /* synthetic */ d b;

    public final void onFailureImpl(DataSource r3) {
        Throwable r4 = r3.getFailureCause();
        if (r4 == null) goto L5;
        LLog.e("LynxImageHelper", "loadBitmapFromRemote failed: " + r4.toString());
    L5:
        d r0 = this.b;
        if (r0.a == null) goto L19;
        d.c r1 = r0.b;
        if (r1 == null) goto L14;
        d.a r2 = r1.f;
        if (r2 == null) goto L14;
        if (r2.f == null) goto L14;
        String r5 = "Android BigImageDrawingHelper loading image from remote failed, and the url is " + this.b.b.f.f + ". The Fresco throw error msg is " + r4.toString();
    L17:
        this.b.a.onImageLoadFailed(r5);
        return;
    L14:
        if (r4 == null) goto L16;
        r5 = r4.toString();
        goto L17
    L16:
        r5 = NameKeys.UnloadStrategy_No_Strategy;
        goto L17
    }

    public final void onNewResultImpl(DataSource<CloseableReference<PooledByteBuffer>> r11) {
        if (r11.isFinished() == true) goto L5;
        return;
    L5:
        CloseableReference r12 = (CloseableReference) r11.getResult();
        if (r12 == null) goto L34;
        CloseableReference r1 = r12.clone();
        PooledByteBufferInputStream r3 = new PooledByteBufferInputStream((PooledByteBuffer) r1.get());     // Catch: Throwable -> L17
        BitmapRegionDecoder r4 = BitmapRegionDecoder.newInstance(r3, false);     // Catch: Throwable -> L13
        BitmapFactory.Options r5 = new BitmapFactory.Options();     // Catch: Throwable -> L13
        d.c r6 = this.b.m(this.a, r4.getWidth(), r4.getHeight());     // Catch: Throwable -> L13
        if (r6 == null) goto L15;
        r5.inSampleSize = r6.a;     // Catch: Throwable -> L13
        r5.inPreferredConfig = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L13
        r6.d = r4.decodeRegion(r6.b, r5);     // Catch: Throwable -> L13
        r6.e = false;     // Catch: Throwable -> L13
        d r2 = this.b;     // Catch: Throwable -> L13
        r2.c.post(new a(r2, r6));     // Catch: Throwable -> L13
    L15:
        r4.recycle();     // Catch: Throwable -> L13
    L30:
        d.d(r3);
        r12.close();
        r1.close();
        return;
    L13:
        th = th;
    L35:
        th.printStackTrace();     // Catch: Throwable -> L31
        d r7 = this.b;     // Catch: Throwable -> L31
        if (r7.a == null) goto L30;
        d.c r8 = r7.b;     // Catch: Throwable -> L31
        if (r8 == null) goto L28;
        d.a r9 = r8.f;     // Catch: Throwable -> L31
        if (r9 == null) goto L28;
        if (r9.f == null) goto L28;
        String r0 = "Android BigImageDrawingHelper loading image from remote onNewResultImpl failed, and the url is " + this.b.b.f.f + ". The Fresco throw error msg is " + th.toString();     // Catch: Throwable -> L31
    L29:
        this.b.a.onImageLoadFailed(r0);     // Catch: Throwable -> L31
    L28:
        r0 = th.toString();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        d.d(r3);
        r12.close();
        r1.close();
        throw th;
    L17:
        th = th;
        r3 = null;
        goto L35
    }

    public c(d r1, d.a r2) {
        this.b = r1;
        this.a = r2;
    }
}
