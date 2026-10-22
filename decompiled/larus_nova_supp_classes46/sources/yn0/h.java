package yn0;

import com.bytedance.android.live.link.ILinkServiceExternal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements l81.h {
    public static final h a = null;

    public h() {
    }

    static {
        a = new h();
    }

    public final String getLinkAnchorCount() {
        ILinkServiceExternal r0 = jc1.k.f(ILinkServiceExternal.class);
        if (r0 == null) goto L6;
        String r1 = r0.getLinkAnchorCount();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }
}
