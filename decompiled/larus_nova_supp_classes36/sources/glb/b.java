package glb;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import com.ss.android.lark.monitor.perf.BasePerfMonitor;
import com.ss.android.lark.utils.ImageUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends BasePerfMonitor {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public static void d(com.ss.android.lark.image.uploader.entity.b r5) {
        Intrinsics.checkNotNullParameter(r5, "uploadImage");
        a r0 = new a();
        if (r5.d == false) goto L5;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == false) goto L17;
        return;
    L17:
        Biz r2 = r5.e;
        Intrinsics.checkNotNull(r2);
        Scene r3 = r5.f;
        Intrinsics.checkNotNull(r3);
        int r4 = r5.g;
        String r6 = r5.h;
        Intrinsics.checkNotNull(r6);
        r0.a(r2, r3, r4, r6);
        r5.n = r0;
        return;
    L5:
        if (r5.e == null) goto L14;
        if (r5.f == null) goto L14;
        if (r5.g == 0) goto L14;
        if (r5.h == null) goto L14;
        r1 = false;
        goto L15
    }

    public static void e(com.ss.android.lark.image.uploader.entity.b r8) {
        Intrinsics.checkNotNullParameter(r8, "uploadImage");
        a r0 = r8.n;
        if (r0 == null) goto L20;
        ImageInfo r1 = r8.k;
        if (r1 == null) goto L8;
        ImageUtils.ImageType r2 = r1.h;
        if (r2 == null) goto L8;
    L9:
        int r3 = 0;
        if (r1 == null) goto L12;
        int r4 = r1.a;
    L13:
        if (r1 == null) goto L15;
        r3 = r1.b;
    L15:
        if (r1 == null) goto L17;
        long r5 = r1.c;
    L18:
        boolean r6 = r8.c;
        boolean r9 = r8.b;
        Intrinsics.checkNotNullParameter(r2, "imageType");
        r0.d = r6;
        r0.f = r9;
        r0.g = r2.getValue();
        r0.h = r5;
        r0.i = r4;
        r0.j = r3;
        return;
    L17:
        r5 = 0;
        goto L18
    L12:
        r4 = 0;
    L8:
        r2 = ImageUtils.ImageType.TYPE_UNKNOWN;
        goto L9
    }

    public static void f(com.ss.android.lark.image.uploader.entity.b r6) {
        Intrinsics.checkNotNullParameter(r6, "uploadImage");
        a r0 = r6.n;
        if (r0 == null) goto L21;
        ImageInfo r1 = r6.k;
        int r2 = 0;
        if (r1 == null) goto L7;
        int r3 = r1.a;
    L8:
        if (r1 == null) goto L10;
        r2 = r1.b;
    L10:
        if (r1 == null) goto L12;
        long r4 = r1.c;
    L13:
        com.ss.android.lark.image.uploader.entity.a r7 = r6.m;
        if (r7 == null) goto L16;
        Integer r8 = Integer.valueOf(r7.c);
    L17:
        if (r8 == null) goto L19;
        r0.n = r8.intValue();
    L19:
        r0.k = r4;
        r0.l = r3;
        r0.m = r2;
        return;
    L16:
        r8 = null;
        goto L17
    L12:
        r4 = 0;
        goto L13
    L7:
        r3 = 0;
        goto L8
    }

    public static void c(com.ss.android.lark.image.uploader.entity.b r19, ErrorResult r20) {
        Intrinsics.checkNotNullParameter(r19, "uploadImage");
        Intrinsics.checkNotNullParameter(r20, "error");
        a r0 = r19.n;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r20, "error");
        ErrorParams r1 = new ErrorParams(r0.b, r0.c, Event.image_upload, ErrorType.Unknown, ErrorLevel.Exception, r20.getCode(), null, null, r20.getDebugMsg(), Boolean.FALSE, null, null, null, 7360, null);
        r1.setErrorStatus(r20.getStatus());
        AppreciableKit.Companion.getInstance().error(r1);
        return;
    }
}
