package iz;

import com.bytedance.android.live.base.model.user.IBaseUser;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final String a(IBaseUser r2) {
        if (r2 == null) goto L13;
        String r3 = r2.getIdString();
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.length() <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        return null;
    L11:
        if ((!Intrinsics.areEqual(r3, "0")) == false) goto L17;
        return r3;
    L17:
        return null;
    L8:
        r0 = false;
        goto L9
    L13:
        return null;
    }
}
