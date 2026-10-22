package f1b;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import io.reactivex.functions.Consumer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends y0b.c {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Ref.ObjectRef<Bitmap> a;
        public final /* synthetic */ CountDownLatch b;

        public a(Ref.ObjectRef<Bitmap> r1, CountDownLatch r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            this.a.element = (Bitmap) r2;
            this.b.countDown();
        }
    }

    /* JADX INFO: renamed from: f1b.b$b, reason: collision with other inner class name */
    public static final class C0219b<T> implements Consumer {
        public final /* synthetic */ CountDownLatch a;

        public C0219b(CountDownLatch r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            j.b("DocsIconHandler", "loadIcon error: " + ((Throwable) r3).getMessage());
            this.a.countDown();
        }
    }

    public b() {
    }

    @Override // y0b.c
    public final WebResourceResponse a(Uri r9) {
        if (r9 != null) goto L5;
        return null;
    L5:
        String r1 = UriProtector.getQueryParameter(r9, "key");
        String r2 = BuildConfig.FLAVOR;
        if (r1 != null) goto L8;
        r1 = BuildConfig.FLAVOR;
    L8:
        int r4 = 0;
        if (r1.length() != 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
        return null;
    L14:
        String r10 = UriProtector.getQueryParameter(r9, IPortraitService.TYPE);
        if (r10 == null) goto L18;
        r2 = r10;
    L18:
        j.e("DocsIconHandler", "loadIcon " + r1 + ", type: " + r2 + ' ');
        CountDownLatch r11 = new CountDownLatch(1);
        int r5 = obb.c.p;     // Catch: Throwable -> L33
        Integer r6 = StringsKt.toIntOrNull(r2);     // Catch: Throwable -> L33
        if (r6 == null) goto L22;
        r4 = r6.intValue();     // Catch: Throwable -> L33
    L22:
        obb.c r7 = new obb.c(obb.c.b.a(r4, r1));     // Catch: Throwable -> L33
        Ref.ObjectRef r8 = new Ref.ObjectRef();     // Catch: Throwable -> L33
        pbb.d.c(r7).subscribe(new a(r8, r11), new C0219b(r11));     // Catch: Throwable -> L33
        if (r11.getCount() == 0) goto L25;
        r11.await(5, TimeUnit.SECONDS);     // Catch: Throwable -> L33
    L25:
        Bitmap r12 = (Bitmap) r8.element;     // Catch: Throwable -> L33
        if (r12 == null) goto L35;
        ByteArrayOutputStream r13 = new ByteArrayOutputStream();     // Catch: Throwable -> L33
        if (r12.compress(Bitmap.CompressFormat.PNG, 100, r13) == false) goto L38;
        byte[] r14 = r13.toByteArray();     // Catch: Throwable -> L33
        r13.close();     // Catch: Throwable -> L33
        return new WebResourceResponse("image/png", Charset.defaultCharset().name(), new ByteArrayInputStream(r14));
    L38:
        return null;
    L35:
        return null;
    L33:
        th = move-exception;
        j.e("DocsIconHandler", "error: " + th.getMessage());
        goto L35
    L11:
        r3 = false;
        goto L12
    }
}
