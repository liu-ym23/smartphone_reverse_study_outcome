package yn0;

import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v implements l81.v {
    public static final v a = null;

    public v() {
    }

    static {
        a = new v();
    }

    public final boolean a(d90.d r2) {
        if ((r2 instanceof d90.a) == true) goto L7;
        return false;
    L7:
        return VSMediaUIConfigHelper.c(r2);
    }
}
