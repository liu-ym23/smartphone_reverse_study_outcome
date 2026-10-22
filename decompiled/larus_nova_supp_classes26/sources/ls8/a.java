package ls8;

import com.larus.bmhome.upload.sdk.f;
import com.larus.bmhome.upload.sdk.impl.ApiCredentialProviderAdapter;
import hs8.b;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements b {
    public final com.larus.bmhome.upload.sdk.impl.a a;

    public a(com.larus.bmhome.upload.sdk.impl.a r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.a = r2;
    }

    @Override // hs8.b
    public final com.larus.bmhome.upload.sdk.impl.a a(f r3) {
        Intrinsics.checkNotNullParameter(r3, "module");
        com.larus.bmhome.upload.sdk.impl.a r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "module");
        r3.a(r1);
        return r1;
    }

    @Override // hs8.b
    public final com.larus.bmhome.upload.sdk.impl.a b(hs8.f r4) {
        Intrinsics.checkNotNullParameter(r4, "provider");
        com.larus.bmhome.upload.sdk.impl.a r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "provider");
        ApiCredentialProviderAdapter r2 = new ApiCredentialProviderAdapter(r4);
        Intrinsics.checkNotNullParameter(r2, "provider");
        ((ArrayList) r1.b).add(r2);
        return r1;
    }
}
