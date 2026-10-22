package o7b;

import com.ss.android.lark.widget.richtext.Image;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Image a(com.ss.android.lark.image.entity.Image r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Image r0 = new Image();
        r0.setKey(r2.getKey());
        r0.setWidth(r2.getWidth());
        r0.setHeight(r2.getHeight());
        r0.setUrls(r2.getUrls());
        if (r2.getType() != com.ss.android.lark.image.entity.Image.Type.ENCRYPTED) goto L8;
        r0.setType(Image.Type.ENCRYPTED);
    L9:
        return r0;
    L8:
        r0.setType(Image.Type.NORMAL);
        goto L9
    }
}
