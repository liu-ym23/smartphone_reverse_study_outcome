package android.support.v4.media;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import androidx.core.app.NotificationCompat;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader$EndOfFileException;
import com.bumptech.glide.load.resource.bitmap.h;
import com.google.common.reflect.w;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.behavior.j;
import com.lynx.tasm.behavior.k;
import com.lynx.tasm.o0;
import com.lynx.tasm.resourceprovider.LynxResourceResponse$ResponseState;
import com.obric.oui.banner.BannerStyle;
import com.obric.oui.banner.OBanner;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import javax.xml.transform.Transformer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class c implements h, k, com.bytedance.sdk.xbridge.cn.protocol.f, wq.b, go.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f367a;

    public /* synthetic */ c(Object r5) {
        this.f367a = r5;
    }

    public static ParcelFileDescriptor.AutoCloseInputStream c(String r5) {
        String r10 = com.lynx.tasm.behavior.utils.d.c("read file from fallback, url: ", r5, "AppletResourceLoader");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L5;
        r11.i("AppletResourceLoader", r10);
    L5:
        Intrinsics.checkNotNullParameter(r5, "url");
        if (com.bytedance.ai.multiprocess.d.f2406a == null) goto L21;
        Intrinsics.checkNotNullParameter(r5, "url");
        Object r12 = Result.m124constructorimpl(null);     // Catch: Throwable -> L10
    L12:
        Throwable r13 = Result.m127exceptionOrNullimpl(r12);
        if (r13 == null) goto L18;
        String r14 = com.lynx.tasm.behavior.utils.d.c("onResourceFallback failed, url=", r5, "AIManager");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L18;
        r15.e("AIManager", r14, r13);
    L18:
        if (Result.m130isFailureimpl(r12) == false) goto L20;
        r12 = null;
    L20:
        ParcelFileDescriptor r16 = (ParcelFileDescriptor) r12;
    L22:
        if (r16 != null) goto L25;
        return null;
    L25:
        return new ParcelFileDescriptor.AutoCloseInputStream(r16);
    L10:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r12 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L12
    L21:
        r16 = null;
        goto L22
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.f
    public void a(bj.a r5, cj.d r10) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        boolean r11 = ((com.bytedance.sdk.xbridge.cn.platform.lynx.a) this.f367a).f7363n;
        ki.a.d.getClass();
    }

    @Override // com.bumptech.glide.load.resource.bitmap.h
    public int b() {
        int r5 = d() << 8;
        return d() | r5;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.h
    public short d() {
        int r5 = ((InputStream) this.f367a).read();
        if (r5 == (-1)) goto L7;
        return (short) r5;
    L7:
        throw new DefaultImageHeaderParser$Reader$EndOfFileException();
    }

    public Object e(Class r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L13
        r6.a r11 = (r6.a) this.f367a;     // Catch: Throwable -> L13
        r11.getClass();     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r5, "clazz");     // Catch: Throwable -> L13
        com.bytedance.android.monitorV2.settings.b r12 = (com.bytedance.android.monitorV2.settings.b) ((ConcurrentHashMap) r11.f21695a).get(r5);     // Catch: Throwable -> L13
        if (r12 == null) goto L15;
        Object r13 = r12.f3719a;     // Catch: Throwable -> L13
        if (r13 == null) goto L15;
        if (r5.isAssignableFrom(r13.getClass()) == true) goto L11;
        r13 = null;
    L11:
        if (r13 == null) goto L15;
    L16:
        Object r14 = Result.m124constructorimpl(r13);     // Catch: Throwable -> L13
    L20:
        if (Result.m130isFailureimpl(r14) == false) goto L23;
        return null;
    L23:
        return r14;
    L15:
        r13 = null;
    L13:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    @Override // go.a
    public void f(w r5) {
        jo.a r10 = (jo.a) r5.f9376b;
        String r11 = null;
        if (r10 == null) goto L5;
        byte[] r12 = r10.f18400a;
        TemplateBundle r13 = r10.f18401b;
    L6:
        Throwable r14 = (Throwable) r5.d;
        if (r14 == null) goto L10;
        r11 = r14.getMessage();
    L10:
        if (((LynxResourceResponse$ResponseState) r5.f9377c) != LynxResourceResponse$ResponseState.f10948b) goto L12;
        boolean r15 = true;
    L13:
        ((nn.f) this.f367a).b(r15, r12, r13, r11);
        return;
    L12:
        r15 = false;
        goto L13
    L5:
        r13 = null;
        r12 = null;
        goto L6
    }

    public synchronized ArrayList g(Class r5, Class r10) {
        monitor-enter(this);
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L8
        if (r10.isAssignableFrom(r5) == false) goto L10;
        r11.add(r10);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r11;
    L10:
        Iterator r12 = ((ArrayList) this.f367a).iterator();     // Catch: Throwable -> L8
    L12:
        if (r12.hasNext() == false) goto L22;
        j0.b r13 = (j0.b) r12.next();     // Catch: Throwable -> L8
        if (r13.f18216a.isAssignableFrom(r5) == true) goto L16;
    L18:
        boolean r14 = false;
    L19:
        if (r14 == false) goto L12;
        r11.add(r10);     // Catch: Throwable -> L8
        goto L12
    L16:
        if (r10.isAssignableFrom(r13.f18217b) == false) goto L18;
        r14 = true;
        goto L19
    L22:
        monitor-exit(this);
        return r11;
    L8:
        th = move-exception;
        throw th;
    }

    public void h(com.obric.oui.banner.d r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "data");
        OBanner r11 = (OBanner) this.f367a;
        BannerStyle r12 = r11.f12017y;
        if (com.obric.oui.banner.c.f12022a[r12.ordinal()] != 1) goto L5;
        OBanner.d(r11, r5, r10);
        return;
    L5:
        wq.b r13 = r11.f12009p;
        if (r13 == null) goto L11;
        ((c) r13).h(r5, r10);
        return;
    }

    @Override // com.lynx.tasm.behavior.k
    public void loadImage(Context r10, String r11, String r12, float r13, float r14, Transformer r15, j r16) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r16, "handler");
        com.bytedance.ies.bullet.base.utils.logger.a.c("DefaultImageInterceptor", "loadImage");
        ((o0) this.f367a).loadImage(r10, null, r12, r13, r14, null, r16);
    }

    @Override // com.lynx.tasm.behavior.k
    public String shouldRedirectImageUrl(String r5) {
        int r10 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.c("DefaultImageInterceptor", "shouldRedirectImageUrl: " + r5);
        return ((o0) this.f367a).shouldRedirectImageUrl(r5);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.h
    public long skip(long r10) {
        if (r10 >= 0) goto L5;
        return 0;
    L5:
        long r5 = r10;
    L7:
        if (r5 <= 0) goto L16;
        InputStream r11 = (InputStream) this.f367a;
        long r12 = r11.skip(r5);
        if (r12 > 0) goto L10;
        if (r11.read() == (-1)) goto L16;
        r5 = r5 - 1;
        goto L7
    L10:
        r5 = r5 - r12;
    L16:
        return r10 - r5;
    }

    public c(int r5) {
        switch(r5) {
            case 7: goto L5;
            default: goto L3;
        };
    L3:
        this.f367a = new r6.a(3, false);
        pg.a r10 = pg.a.b("hybrid_monitor");
        r10.f21343a = com.bytedance.android.monitorV2.settings.e.f3726a;
        d5.b.f("MonitorSettingsCenter", "monitor app settings init");
        pg.a r11 = pg.a.b("hybrid_monitor");
        com.bytedance.android.monitorV2.settings.f r12 = new com.bytedance.android.monitorV2.settings.f(this, 0);
        r11.f21345c.put(r12, Boolean.FALSE);
        pg.a.b("hybrid_monitor").d();
        return;
    L5:
        this.f367a = new ArrayList();
    }

    public c(o0 r5) {
        Intrinsics.checkNotNullParameter(r5, "lynxViewClient");
        this.f367a = r5;
    }
}
