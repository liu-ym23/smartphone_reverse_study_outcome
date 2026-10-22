package g7a;

import android.graphics.Bitmap;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.utils.BitmapUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ Bitmap.CompressFormat b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Callback d;

    public final void a() {
        String r3 = BitmapUtils.bitmapToBase64(this.a, this.b, 100, 2);     // Catch: Throwable -> L5
        JavaOnlyMap r4 = new JavaOnlyMap();     // Catch: Throwable -> L5
        r4.putInt("width", this.a.getWidth());     // Catch: Throwable -> L5
        r4.putInt("height", this.a.getHeight());     // Catch: Throwable -> L5
        r4.putString(LynxResourceModule.DATA_KEY, this.c + r3);     // Catch: Throwable -> L5
        this.d.invoke(new Object[]{0, r4});     // Catch: Throwable -> L5
    L6:
        this.a.recycle();
        return;
    L5:
        this.d.invoke(new Object[]{1, new JavaOnlyMap()});     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.a.recycle();
        throw th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(Bitmap r1, Bitmap.CompressFormat r2, String r3, Callback r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
