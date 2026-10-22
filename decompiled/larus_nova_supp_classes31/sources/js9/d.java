package js9;

import androidx.fragment.app.Fragment;
import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.impl.LoadingFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d implements b {
    public d() {
    }

    @Override // js9.b
    public final Fragment a(UserCreation r1, Fragment r2, boolean r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "creation");
        String r5 = r1.a;
        if (r5 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == true) goto L11;
        return null;
    L11:
        return new LoadingFragment();
    L5:
        if (r5.length() == 0) goto L8;
        r6 = false;
        goto L9
    }
}
