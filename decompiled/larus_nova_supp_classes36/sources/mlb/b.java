package mlb;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.z;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.imageqrcode.QRCodeResultInfo;
import com.ss.android.lark.imageqrcode.QRCodeShowParam;
import com.ss.android.lark.imageqrcode.ui.ImageQRCodeSelector;
import com.ss.android.lark.imageqrcode.utils.ImageQRCodeSettings;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final ExecutorService a = null;
    public static final ConcurrentHashMap<String, ArrayList<QRCodeResultInfo>> b = null;
    public static final ArrayList<String> c = null;

    public static final class a implements Runnable {
        public final /* synthetic */ d.a a;
        public final /* synthetic */ String b;

        public a(d.a r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.a r0 = this.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.onError(this.b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    /* JADX INFO: renamed from: mlb.b$b, reason: collision with other inner class name */
    public static final class RunnableC0296b implements Runnable {
        public final /* synthetic */ d.a a;
        public final /* synthetic */ ArrayList<QRCodeResultInfo> b;

        public RunnableC0296b(d.a r1, ArrayList<QRCodeResultInfo> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.a r0 = this.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.a(this.b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ Bitmap a;
        public final /* synthetic */ d.a b;

        public c(Bitmap r1, d.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            int r0 = com.ss.android.lark.imageqrcode.utils.a.a;
            Bitmap r1 = this.a;
            Intrinsics.checkNotNullParameter(r1, "bitmap");
            Lazy r2 = ImageQRCodeSettings.b;
            Bitmap r3 = p.b(r1, ((ImageQRCodeSettings.ImageQRCodeConfig) r2.getValue()).getSuperSizeSmallSide(), ((ImageQRCodeSettings.ImageQRCodeConfig) r2.getValue()).getSuperSizeBigSide());
            ArrayList<QRCodeResultInfo> r4 = ((mlb.a) ApiUtils.getApi(mlb.a.class)).decodeQRCode(r3);
            if (r4.isEmpty() == false) goto L5;
            ExecutorService r5 = b.a;
            b.a(this.b, "result is empty");
            return;
        L5:
            ExecutorService r6 = b.a;
            b.b(this.b, r4);
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
    }

    static {
        a = CoreThreadPool.getDefault().getSingleScheduledThreadPool("lk-ve-qrcode");
        b = new ConcurrentHashMap();
        ArrayList<String> r0 = new ArrayList();
        r0.add("Token");
        r0.add("token");
        r0.add("TOKEN");
        c = r0;
    }

    public static void c(String r1) {
        Log.i("ImageQRCodeKit", r1);
    }

    public static String d(String r9) {
        if (r9 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return "";
    L11:
        Iterator<String> r8 = c.iterator();
        String r2 = r9;
    L13:
        if (r8.hasNext() == false) goto L18;
        String r3 = r8.next();
        if (r2 != null) goto L16;
        r2 = null;
        goto L13
    L16:
        r2 = StringsKt.replace$default(r2, r3, "xxx", false, 4, null);
        goto L13
    L18:
        if (r2 != null) goto L21;
        return "";
    L21:
        return r2;
    L4:
        if (StringsKt.isBlank(r9) == true) goto L7;
        r0 = false;
        goto L9
    }

    @JvmStatic
    public static final void e(d r5) {
        Intrinsics.checkNotNullParameter(r5, "param");
        c("scan, param:" + r5);
        Bitmap r0 = r5.c;
        String r1 = r5.b;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        d.a r6 = r5.d;
        if (r0 == null) goto L11;
        if (com.ss.android.lark.imageqrcode.utils.a.c(r0) == true) goto L11;
        f(r0, r6);
        return;
    L11:
        if (FileUtils.r(r1) == false) goto L21;
        c("scan path");
        ArrayList<QRCodeResultInfo> r2 = b.get(r1);
        if (r2 == null) goto L18;
        boolean r3 = !r2.isEmpty();
        c("has cache, result is success:" + r3);
        if (r3 == false) goto L17;
        b(r6, r2);
        return;
    L17:
        a(r6, "path:" + r1 + " no has qr code");
        return;
    L18:
        c("no has cache");
        ExecutorService r4 = a;
        if (r4 == null) goto L26;
        r4.execute(new mlb.c(r1, r6));
        return;
    L26:
        return;
    L21:
        a(r6, "param is invalid");
    }

    public static void a(d.a r2, String r3) {
        c("scan error:" + r3);
        new Handler(Looper.getMainLooper()).post(new a(r2, r3));
    }

    public static void b(d.a r2, ArrayList r3) {
        c("scan success, result size:" + r3.size());
        new Handler(Looper.getMainLooper()).post(new RunnableC0296b(r2, r3));
    }

    public static void f(Bitmap r2, d.a r3) {
        c("scan bitmap, width:" + r2.getWidth() + ", height:" + r2.getHeight());
        ExecutorService r0 = a;
        if (r0 == null) goto L6;
        r0.execute(new c(r2, r3));
        return;
    }

    @JvmStatic
    public static final void g(Activity r4, QRCodeShowParam r5) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "param");
        c("show, param:" + r5);
        if (com.ss.android.lark.imageqrcode.utils.a.b(r4) == false) goto L5;
        return;
    L5:
        if (r5.isInValid() == true) goto L18;
        int r2 = ImageQRCodeSelector.a;
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "param");
        int r0 = ImageQRCodeSelector.a;
        ImageQRCodeSelector.b("launch, param:".concat(d(r5.toString())));
        if (z.e(r4) == false) goto L10;
        ImageQRCodeSelector.Launcher.MAIN_PROCESS.launch(r4, r5);
        return;
    L10:
        if (FileUtils.r(r5.getPath()) == false) goto L13;
        ImageQRCodeSelector.Launcher.NON_MAIN_PATH.launch(r4, r5);
        return;
    L13:
        if (r5.getBitmap() == null) goto L15;
        ImageQRCodeSelector.Launcher.NON_MAIN_BITMAP.launch(r4, r5);
        return;
    L15:
        ImageQRCodeSelector.b("non main process, param is invalid");
        return;
    }
}
