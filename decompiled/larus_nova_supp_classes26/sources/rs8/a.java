package rs8;

import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.platform.service.i3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    static {
    }

    public static boolean a() {
        e0 r0 = (e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L5;
        LaunchInfo r1 = r0.a;
    L7:
        if (r1 != null) goto L10;
        return true;
    L10:
        if (FeatureKitDelegate.b.j0().b() == false) goto L12;
        return true;
    L12:
        if (i3.a.f() == true) goto L17;
        return false;
    L17:
        return true;
    L5:
        r1 = null;
        goto L7
    }
}
