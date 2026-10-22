package ff8;

import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverImageEntity;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverItem;
import kotlin.jvm.internal.Intrinsics;
import nr9.f;
import nr9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final g a(AiGenVideoContentData r18) {
        Intrinsics.checkNotNullParameter(r18, "<this>");
        String r2 = r18.getVid();
        String r3 = r18.getVideoModel();
        String r4 = r18.getDownloadUrl();
        String r5 = r18.getDownloadFilehash();
        Double r6 = r18.getDuration();
        String r7 = r18.getVideoType();
        CoverItem r8 = r18.getVideoCover();
        if (r8 == null) goto L5;
        String r10 = b.b(r8);
    L6:
        CoverItem r9 = r18.getVideoCover();
        if (r9 == null) goto L9;
        String r11 = b.a(r9);
    L10:
        CoverItem r12 = r18.getVideoCover();
        if (r12 == null) goto L15;
        CoverImageEntity r13 = r12.getPreviewImage();
        if (r13 == null) goto L15;
        Integer r14 = Integer.valueOf(r13.getHeight());
    L16:
        CoverItem r15 = r18.getVideoCover();
        if (r15 == null) goto L21;
        CoverImageEntity r16 = r15.getPreviewImage();
        if (r16 == null) goto L21;
        Integer r17 = Integer.valueOf(r16.getWidth());
    L23:
        return new g(r2, r3, r4, r5, r6, r7, new f(r10, r11, null, r14, r17, null, 36), r18.getLocalUrl(), null, null, 768);
    L21:
        r17 = null;
    L15:
        r14 = null;
        goto L16
    L9:
        r11 = null;
        goto L10
    L5:
        r10 = null;
        goto L6
    }
}
