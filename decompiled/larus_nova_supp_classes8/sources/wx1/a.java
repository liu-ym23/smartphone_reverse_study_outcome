package wx1;

import com.bytedance.android.gamecp.host_api.model.ImageModel;
import com.bytedance.android.gamecp.host_api.model.user.User;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static User a(com.bytedance.android.livesdk.user.f r2) {
        User r0 = new User();
        if (r2 != null) goto L5;
        return r0;
    L5:
        r0.setNickName(r2.b().getNickName());
        r0.setAvatarThumb(b(r2.b().getAvatarThumb()));
        r0.setAvatarMedium(b(r2.b().getAvatarMedium()));
        r0.setAvatarLarge(b(r2.b().getAvatarLarge()));
        r0.setIdStr(r2.n());
        r0.setId(r2.b().getUserId());
        return r0;
    }

    public static ImageModel b(com.bytedance.android.live.base.model.ImageModel r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        ImageModel r0 = new ImageModel();
        r0.setWidth(r2.getWidth());
        r0.setHeight(r2.getHeight());
        r0.setUri(r2.getUri());
        r0.setUrls(r2.getUrls());
        return r0;
    }
}
