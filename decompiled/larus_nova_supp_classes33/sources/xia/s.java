package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.UserProfileEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class s implements c {
    public static final s a = null;

    static {
        a = new s();
    }

    public s() {
    }

    @Override // xia.c
    public final int a(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        if ((r3 instanceof UserProfileEntity) == false) goto L11;
        UserProfileEntity r4 = (UserProfileEntity) r3;
        int r0 = (((r4.getProfileKey().hashCode() + 0) * 31) + r4.getProfileValue().hashCode()) * 31;
        if (r4.isFromAutoLearn() == false) goto L7;
        int r5 = 1231;
    L9:
        return r0 + r5;
    L7:
        r5 = 1237;
        goto L9
    L11:
        throw new IllegalStateException("Check failed.".toString());
    }
}
