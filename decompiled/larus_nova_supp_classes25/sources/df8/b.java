package df8;

import android.os.Build;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public static final String a(ImageItem r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ImageEntity r0 = r2.getPreviewImage();
        if (r0 == null) goto L5;
        String r1 = r0.getUrl();
    L7:
        if (o0.d(r1) == false) goto L11;
        ImageEntity r3 = r2.getPreviewImage();
        if (r3 != null) goto L16;
        return null;
    L16:
        return r3.getUrl();
    L11:
        ImageEntity r4 = r2.getImageOrigin();
        if (r4 != null) goto L14;
        return null;
    L14:
        return r4.getUrl();
    L5:
        r1 = null;
        goto L7
    }

    public static final String b(ImageItem r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        boolean r1 = true;
        if (z2.a.imageGenerateHeicConfig().a == true) goto L7;
        r1 = false;
    L7:
        if (r1 == false) goto L24;
        ImageEntity r2 = r4.getImageThumb();
        if (r2 == null) goto L11;
        String r3 = r2.getUrlV2();
    L13:
        if (o0.d(r3) == false) goto L24;
        if (Build.VERSION.SDK_INT <= 26) goto L24;
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("use urlV2 is ");
        ImageEntity r7 = r4.getImageThumb();
        if (r7 == null) goto L19;
        String r8 = r7.getUrlV2();
    L20:
        r6.append(r8);
        r5.d("ImageItemExt", r6.toString());
        ImageEntity r9 = r4.getImageThumb();
        if (r9 != null) goto L23;
        return null;
    L23:
        return r9.getUrlV2();
    L19:
        r8 = null;
        goto L20
    L11:
        r3 = null;
    L24:
        ImageEntity r10 = r4.getImageThumb();
        if (r10 != null) goto L27;
        return null;
    L27:
        return r10.getUrl();
    }

    public static final boolean c(ImageItem r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (Intrinsics.areEqual(r2.isPlaceHolderImg(), Boolean.TRUE) == false) goto L5;
    L18:
        return false;
    L5:
        if (r2.getKey() != null) goto L17;
        ImageEntity r0 = r2.getImageOrigin();
        String r1 = null;
        if (r0 == null) goto L9;
        String r3 = r0.getUrl();
    L11:
        if (o0.d(r3) == true) goto L17;
        ImageEntity r4 = r2.getImageOrigin();
        if (r4 == null) goto L16;
        r1 = r4.getUrlV2();
    L16:
        if (o0.d(r1) == false) goto L18;
    L9:
        r3 = null;
    L17:
        return true;
    }
}
