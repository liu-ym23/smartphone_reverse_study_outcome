package com.larus.uaigc.helper;

import android.graphics.BitmapFactory;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ImageUploadDuplicateStatHelper {
    public static final Lazy a = null;
    public static final b b = null;
    public static final Lazy c = null;

    public static final class a {
        public final int a;
        public final int b;
        public final String c;

        public a(int r1, int r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public b(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r3, Throwable r4) {
            FLogger.a.e("ImageUploadDuplicateStatHelper", "err! msg=" + r4);
        }
    }

    public ImageUploadDuplicateStatHelper() {
    }

    static {
        a = LazyKt.lazy(new f0());
        b = new b(CoroutineExceptionHandler.Key);
        c = LazyKt.lazy(new g0());
    }

    public static final a a(PolarisFileWrapper r3) {
        if (r3.exists() == true) goto L5;
    L11:
        return null;
    L5:
        if (r3.isFile() == false) goto L11;
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        r0.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r3.getAbsolutePath(), r0);
        int r4 = r0.outWidth;
        int r1 = r0.outHeight;
        String r2 = r0.outMimeType;
        if (r4 <= 0) goto L11;
        if (r1 <= 0) goto L11;
        return new a(r4, r1, r2);
    }

    public static void b(String r12, Uri r13, ic8.n0 r14, long r15, boolean r17) {
        Intrinsics.checkNotNullParameter(r13, "uri");
        Intrinsics.checkNotNullParameter(r14, "processFileResult");
        if (Intrinsics.areEqual(((kq9.r) a.getValue()).a(), Boolean.TRUE) == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default((CoroutineScope) c.getValue(), null, null, new ImageUploadDuplicateStatHelper$mobDuplicateStatAsync$1(r14, r13, r12, r17, r15, null), 3, null);
    }
}
