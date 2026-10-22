package bnb;

import android.content.Context;
import com.ss.android.lark.officesdk.api.IUserManager;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.officesdk.internal.OfficeSDKProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements tza.a {
    public a() {
    }

    public final void R0(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "chatID");
        IUserManager r0 = OfficeSDKProvider.INSTANCE.getInstance().getUserManager();
        if (r0 == null) goto L10;
        OfficeSDKUserApi r1 = r0.getUserApi();
        if (r1 == null) goto L11;
        p3c.b r2 = r1.getService(p3c.b.class);
        if (r2 == null) goto L12;
        r2.l3(r3, r4);
        return;
    L12:
        return;
    L11:
        return;
    }
}
