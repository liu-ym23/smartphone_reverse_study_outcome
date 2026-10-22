package ff8;

import android.os.Build;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverImageEntity;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverItem;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public static final String a(CoverItem r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        CoverImageEntity r0 = r2.getPreviewImage();
        if (r0 == null) goto L5;
        String r1 = r0.getUrl();
    L7:
        if (o0.d(r1) == false) goto L12;
        CoverImageEntity r3 = r2.getPreviewImage();
        if (r3 != null) goto L11;
        return null;
    L11:
        return r3.getUrl();
    L12:
        return null;
    L5:
        r1 = null;
        goto L7
    }

    public static final String b(CoverItem r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        boolean r1 = true;
        if (z2.a.imageGenerateHeicConfig().a == true) goto L7;
        r1 = false;
    L7:
        if (r1 == false) goto L24;
        CoverImageEntity r2 = r4.getImageThumb();
        if (r2 == null) goto L11;
        String r3 = r2.getUrlV2();
    L13:
        if (o0.d(r3) == false) goto L24;
        if (Build.VERSION.SDK_INT <= 26) goto L24;
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("use urlV2 is ");
        CoverImageEntity r7 = r4.getImageThumb();
        if (r7 == null) goto L19;
        String r8 = r7.getUrlV2();
    L20:
        r6.append(r8);
        r5.d(" CoverItemExt", r6.toString());
        CoverImageEntity r9 = r4.getImageThumb();
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
        CoverImageEntity r10 = r4.getImageThumb();
        if (r10 != null) goto L27;
        return null;
    L27:
        return r10.getUrl();
    }
}
