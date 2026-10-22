package com.larus.slides.impl.select.utils;

import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.bigimg.i1;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ImageSaveUtils {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new f());
    }

    public static void a(String r7, String r8, Function1 r9) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ImageSaveUtils$doDownloadImg$1(r7, r8, r9, null), 3, null);
    }

    public static Boolean b(Bitmap r12, String r13, Function1 r14) {
        if (r12 != null) goto L5;
        return null;
    L5:
        StringBuilder r1 = new StringBuilder();
        AppHost.Companion r2 = AppHost.a;
        r1.append(r2.getAppName());
        r1.append(System.currentTimeMillis());
        r1.append(".jpeg");
        String r7 = r1.toString();
        if (r13 != null) goto L9;
        r13 = (String) a.getValue();
    L9:
        if (i1.e(r12, r13, r7) == false) goto L17;
        String r6 = r13 + File.separator + r7;
        Intrinsics.checkNotNull(r13);
        if (StringsKt.startsWith$default(r13, (String) a.getValue(), false, 2, null) == false) goto L13;
        i1.f(r2.getApplication(), r6, true);
        ImageSave.a.getClass();
        ImageSave.g(r6);
    L13:
        if (r14 == null) goto L16;
        r14.invoke(new a(true, r6, r7, new PolarisFileWrapper(r6).length(), r12.getWidth(), r12.getHeight()));
    L16:
        return Boolean.TRUE;
    L17:
        Intrinsics.checkNotNull(r13);
        if (StringsKt.startsWith$default(r13, (String) a.getValue(), false, 2, null) == false) goto L20;
        ImageSave r15 = ImageSave.a;
        String r16 = r13 + File.separator + r7;
        r15.getClass();
        ImageSave.g(r16);
    L20:
        FLogger.a.w("ImageSave", "save failed");
        if (r14 == null) goto L24;
        r14.invoke(new a("", "", 48));
    L24:
        return Boolean.FALSE;
    }
}
