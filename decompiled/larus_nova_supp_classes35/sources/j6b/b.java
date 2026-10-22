package j6b;

import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.image.entity.Image;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final Image a(com.bytedance.lark.pb.basic.v1.Image r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Image r0 = new Image();
        r0.setType(Image.Type.valueOf(r2.type.getValue()));
        r0.setWidth(r2.width.intValue());
        r0.setHeight(r2.height.intValue());
        r0.setKey(r2.key);
        r0.setUrls(r2.urls);
        r0.setCrypto(r2.crypto);
        r0.setFsUnit(r2.fs_unit);
        return r0;
    }

    @JvmStatic
    public static final ImageSet b(com.bytedance.lark.pb.basic.v1.ImageSet r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new ImageSet(r10.key, a(r10.origin), a(r10.thumbnail), a(r10.middle), a(r10.thumbnail_webp), a(r10.middle_webp), a(r10.middle_mp4), a(r10.cover));
    }

    @JvmStatic
    public static final com.bytedance.lark.pb.basic.v1.Image c(Image r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new com.bytedance.lark.pb.basic.v1.Image.Builder().type(com.bytedance.lark.pb.basic.v1.Image.Type.fromValue(r2.getType().getNumber())).width(Integer.valueOf(r2.getWidth())).height(Integer.valueOf(r2.getHeight())).key(r2.getKey()).urls(r2.getUrls()).crypto(r2.getCrypto()).fs_unit(r2.getFsUnit()).build();
    }
}
